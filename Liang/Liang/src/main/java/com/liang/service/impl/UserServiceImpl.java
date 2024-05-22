package com.liang.service.impl;

import com.liang.mapper.UserMapper;
import com.liang.pojo.Result;
import com.liang.pojo.User;
import com.liang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: Liang
 * @Date: 2024/03/24/14:48
 * @Description:
 */
//1.实现业务层接口,重写业务层接口方法
//2.注入mapper层接口,调用mapper层方法
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public Result login(String username, String password) {
        User user=userMapper.login(username);
        if(user==null){
            //用户名不存在
            return new Result(0,"用户名不存在",null);
        }else {
            //用户名存在
            if (user.getPassword().equals(password)){
                return new Result(1,"登录成功",user);
            }else {
                //密码错误
                return new Result(0,"密码错误",null);
            }
        }
    }

}
