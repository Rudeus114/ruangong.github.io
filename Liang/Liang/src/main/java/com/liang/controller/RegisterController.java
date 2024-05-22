package com.liang.controller;
import com.liang.pojo.Result;
import com.liang.pojo.User;
import com.liang.service.RegisterService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: Liang
 * @Date: 2024/03/25/20:18
 * @Description:
 */
@Slf4j
@RestController
@CrossOrigin(origins = "http://localhost:8080")
public class RegisterController {
    @Resource
    private RegisterService registerService;
    @PostMapping("/register")
    public String addData(@RequestBody User user) {
        // 在这里执行数据库插入操作
        // 假设UserService有一个addUser方法来插入用户数据
        registerService.addUser(user);
        return "Data added successfully!";
    }
    @RequestMapping(value = "/register",method = RequestMethod.GET)
    public Result isusername(String username){
        //调用业务层代码
        return registerService.isusername(username);
    }
}
