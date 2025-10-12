package top.lgh.boot.redis.service;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class RedisStringService {

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 基本字符串操作
     */
    public void stringOperations() {
        // 设置值
        stringRedisTemplate.opsForValue().set("user:name", "张三");
        // 获取值
        String name = stringRedisTemplate.opsForValue().get("user:name");
        log.info("用户名: {}", name);

        // 设置值并指定过期时间
        stringRedisTemplate.opsForValue().set("temp:data", "临时数据", Duration.ofMinutes(10));

        // 只有当 key 不存在时才设置值
        Boolean success = stringRedisTemplate.opsForValue().setIfAbsent("config:init", "已初始化");
        log.info("初始化状态设置: {}", success);

        // 递增操作
        Long visitCount = stringRedisTemplate.opsForValue().increment("visit:count");
        log.info("访问次数: {}", visitCount);
        // 递增指定数值
        Long visitCountBy10 = stringRedisTemplate.opsForValue().increment("visit:count", 10);
        log.info("访问次数增加10后: {}", visitCountBy10);

        // 递减操作
        Long inventory = stringRedisTemplate.opsForValue().decrement("product:inventory");
        log.info("商品库存: {}", inventory);
    }

    /**
     * 批量字符串操作
     */
    public void batchStringOperations() {
        // 批量设置
        Map<String, String> batchData = new HashMap<>();
        batchData.put("user:1:name", "用户1");
        batchData.put("user:2:name", "用户2");
        batchData.put("user:3:name", "用户3");
        stringRedisTemplate.opsForValue().multiSet(batchData);

        // 批量获取
        List<String> keys = Arrays.asList("user:1:name", "user:2:name", "user:3:name");
        List<String> values = stringRedisTemplate.opsForValue().multiGet(keys);
        log.info("批量获取结果: {}", values);
    }
}