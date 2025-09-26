package top.lgh.boot.redis.service.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import top.lgh.boot.redis.cache.RedisCache;
import top.lgh.boot.redis.cache.RedisKeys;
import top.lgh.boot.redis.dto.LoginRequest;
import top.lgh.boot.redis.enums.ErrorCode;
import top.lgh.boot.redis.exception.ServerException;
import top.lgh.boot.redis.service.LoginService;
import top.lgh.boot.redis.utils.CommonUtils;
import top.lgh.boot.redis.vo.LoginResponse;

import java.util.UUID;

@Slf4j
@Service
@AllArgsConstructor
public class LoginServiceImpl implements LoginService {

    private final RedisCache redisCache;

    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        String phone = loginRequest.getPhone();
        String inputCode = loginRequest.getCode();

        if (!CommonUtils.checkPhone(phone)) {
            throw new ServerException(ErrorCode.PHONE_ERROR);
        }

        if (inputCode == null || inputCode.trim().isEmpty()) {
            throw new ServerException(ErrorCode.PHONE_CODE_EMPTY);
        }

        String redisKey = RedisKeys.getSmsKey(phone);
        Object cachedCode = redisCache.get(redisKey);

        if (cachedCode == null) {
            throw new ServerException(ErrorCode.PHONE_CODE_EXPIRED);
        }

        String redisCode = cachedCode.toString();

        if (!inputCode.equals(redisCode)) {
            throw new ServerException(ErrorCode.PHONE_CODE_ERROR);
        }

        redisCache.delete(redisKey);

        String token = generateToken(phone);
        log.info("用户 {} 登录成功", phone);
        return new LoginResponse(token, phone);
    }

    private String generateToken(String phone) {
        return UUID.randomUUID().toString().replace("-", "") + phone.hashCode();
    }
}