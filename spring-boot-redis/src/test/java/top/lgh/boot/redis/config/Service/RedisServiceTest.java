package top.lgh.boot.redis.config.Service;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

@SpringBootTest
@Slf4j
public class RedisServiceTest {

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 测试 Redis 基本连接
     */
    @Test
    public void testConnection() {
        try {
            // 测试字符串操作
            stringRedisTemplate.opsForValue().set("test:connection", "Redis 连接成功!");
            String value = stringRedisTemplate.opsForValue().get("test:connection");
            log.info("Redis 连接测试结果：{}", value);

            // 测试对象操作
            redisTemplate.opsForValue().set("test:object", "对象序列化测试");
            Object objValue = redisTemplate.opsForValue().get("test:object");
            log.info("Redis 对象测试结果：{}", objValue);

        } catch (Exception e) {
            log.info("Redis 连接失败：{}", e.getMessage());
            throw new RuntimeException("Redis 连接异常", e);
        }
    }
}