package top.lgh.boot.redis.config;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import top.lgh.boot.redis.entity.Address;
import top.lgh.boot.redis.entity.Student;

import java.util.concurrent.TimeUnit;

@SpringBootTest
public class TestRedis {
    @Resource
    private RedisTemplate<String, Student> redisTemplate;

//    @Test
//    public void test(){
//        redisTemplate.opsForValue().set("name", "张三");
//        redisTemplate.opsForValue().set("age", "28",10, TimeUnit.SECONDS);
//
//    }

    @Test
    void testStudent() {
        Address address = Address.builder().province("江苏").city("南京").build();
        Student student = Student.builder().name("李小子").age(20).address(address).build();
        redisTemplate.opsForValue().set("student",student, 120, TimeUnit.SECONDS);
    }
}