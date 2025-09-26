package top.lgh.boot.exception.controller;

import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import top.lgh.boot.exception.common.Result;
import top.lgh.boot.exception.service.TestService;
import top.lgh.boot.exception.entity.User;

@RestController
@RequestMapping("/test")
public class TestController {

    @Resource
    private TestService testService;

    @GetMapping("/{id}")
    public Result<String> getInfo(@PathVariable int id) {
        if (id == 1) {
            testService.method1();
        } else if (id == 2) {
            testService.method2();
        } else {
           int i = 1 / 0;
            return Result.ok("请求成功");
        }
        return Result.ok("请求成功");
    }
    @PostMapping("/user")
    public Result<User> createUser(@Valid @RequestBody User user, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            // 修正：通过bindingResult对象调用getAllErrors()方法
            return Result.error(bindingResult.getAllErrors().get(0).getDefaultMessage());
        }
        return Result.ok(user);
    }
}