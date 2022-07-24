package school.xauat.aspect;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @author ：zsy
 * @date ：Created 2021/1/11 10:53
 * @description：日志处理(Aop)
 */

@Aspect//开启切面操作
@Component
public class LogAspect {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    //拦截school.xauat.controller包下所有类，所有方法，所有参数
    @Pointcut("execution(* school.xauat.controller.*.*(..))")
    public void log() {

    }

    //在log切面之前执行
    @Before("log()")
    public void doBefore(JoinPoint joinPoint) {
        //logger.info("----------doBefore--------");
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        String url = request.getRequestURL().toString();
        String ip = request.getRemoteAddr();
        String classMethod = joinPoint.getSignature().getDeclaringTypeName() + "."
                + joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        RequestLog requestLog = new RequestLog(url, ip, classMethod, args);
        logger.info("Request : {}", requestLog);
    }

    //在log切面之后执行
    @After("log()")
    public void doAfter() {
        logger.info("---------doAfter---------");
    }


    @AfterReturning(returning = "result", pointcut = "log()")
    public void doAfterReturn(Object result) {
        logger.info("Result : {}" , result);
    }

    //定义请求信息内部类
    @Data
    @AllArgsConstructor
    @ToString
    private class RequestLog {
        private String url;
        private String ip;
        private String classMethod;
        private Object[] args;
    }

}
