package school.xauat.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import school.xauat.interceptor.LoginInterceptor;

/**
 * @author ：zsy
 * @date ：Created 2021/4/6 17:46
 * @description：配置拦截器
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/admin/**")
                .excludePathPatterns("/admin", "/admin/login","/css/**", "/images/**", "/js/**", "/lib/**");
    }
}
