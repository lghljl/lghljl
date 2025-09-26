package top.lgh.boot.redis.service;

import top.lgh.boot.redis.dto.LoginRequest;
import top.lgh.boot.redis.vo.LoginResponse;

public interface LoginService {
    LoginResponse login(LoginRequest loginRequest);
}
