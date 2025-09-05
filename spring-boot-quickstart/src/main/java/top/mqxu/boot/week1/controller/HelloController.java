package top.mqxu.boot.week1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

public class HelloController {
    @GetMapping("/hello")
    public String hello() {
        return "hello world";}

        @GetMapping("/list")
                public List<String> getList() {
                    return List.of("111", "222");
                }

    }

