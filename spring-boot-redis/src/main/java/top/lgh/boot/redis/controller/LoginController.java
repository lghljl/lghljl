package top.lgh.boot.redis.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.lgh.boot.redis.dto.LoginRequest;
import top.lgh.boot.redis.result.Result;
import top.lgh.boot.redis.service.LoginService;
import top.lgh.boot.redis.vo.LoginResponse;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class LoginController {

    private final LoginService loginService;

    @PostMapping("/login")
    public Result<LoginResponse> login(@RequestBody LoginRequest loginRequest) {
        LoginResponse loginResponse = loginService.login(loginRequest);
        return Result.ok(loginResponse);
    }
}