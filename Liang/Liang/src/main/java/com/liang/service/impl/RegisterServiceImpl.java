package com.liang.service.impl;

import com.liang.mapper.UserMapper;
import com.liang.pojo.Result;
import com.liang.pojo.User;
import com.liang.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: Liang
 * @Date: 2024/03/25/20:53
 * @Description:
 */
@Service
public class RegisterServiceImpl implements RegisterService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public Result isusername(String username) {
        User user=userMapper.isusername(username);
        if(user==null){
            //用户名不存在
            return new Result(1,"用户可以创建",null);
        }else {
            //用户名存在
            return new Result(0,"用户已经存在",null);
        }
    }

    @Override
    public void addUser(User user) {
        userMapper.insert(user);
    }
}
