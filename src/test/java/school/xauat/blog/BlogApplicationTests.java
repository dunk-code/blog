package school.xauat.blog;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import school.xauat.util.RedisUtil;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

@SpringBootTest
class BlogApplicationTests {

    @Autowired
    RedisUtil redisUtil;

    @Test
    void contextLoads() {
        String s = "saA";
        s.toLowerCase();
    }

    @Test
    void test() {
        Long policyId = redisUtil.incrBy("policyId", 1);
        System.out.println((long)policyId);
    }

}
