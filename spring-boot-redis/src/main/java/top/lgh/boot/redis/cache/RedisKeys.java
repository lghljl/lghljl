package top.lgh.boot.redis.cache;

public class RedisKeys {

    /**
     * 验证码 Key
     *
     * @param phone 手机号
     * @return Redis Key
     */
    public static String getSmsKey(String phone) {
        return "sms:captcha:" + phone;
    }
}