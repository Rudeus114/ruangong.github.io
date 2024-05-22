package com.liang.controller;

import com.liang.pojo.Result;
import com.liang.service.UserService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@CrossOrigin //解决异步请求的问题
public class LoginController {
    //注入业务层
    @Resource
    private UserService userService;
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public Result login(String username,String password){
        //调用业务层代码
        return userService.login(username,password);
    }
}
