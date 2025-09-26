package top.lgh.boot.redis.config.Service;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import top.lgh.boot.redis.service.RedisStringService;

@SpringBootTest
class RedisStringServiceTest {

    @Resource
    private RedisStringService redisStringService;

    @Test
    void stringOperations() {
        redisStringService.stringOperations();
    }

    @Test
    void batchStringOperations() {
        redisStringService.batchStringOperations();
    }
}