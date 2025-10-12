package top.lgh.boot.redis.service;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Set;

@Service
@Slf4j
public class RedisHashService {

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    /**
     * 哈希基本操作
     */
    public void hashOperations() {
        String key = "user:1001";
        // 设置哈希字段
        redisTemplate.opsForHash().put(key, "name", "李四");
        redisTemplate.opsForHash().put(key, "age", 25);
        redisTemplate.opsForHash().put(key, "email", "lisi@example.com");
        redisTemplate.opsForHash().put(key, "department", "技术部");

        // 获取单个字段
        Object name = redisTemplate.opsForHash().get(key, "name");
        log.info("用户名: {}", name);

        // 获取所有字段和值
        Map<Object, Object> userInfo = redisTemplate.opsForHash().entries(key);
        log.info("用户完整信息: {}", userInfo);

        // 获取所有字段名
        Set<Object> fields = redisTemplate.opsForHash().keys(key);
        log.info("所有字段名: {}", fields);
    }
}
