package com.liang;

import com.liang.mapper.UserMapper;
import com.liang.pojo.User;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class LiangApplicationTests {

    @Resource
    private UserMapper userMapper;
    @Test
    public void testListUser(){
        /*List<User> userList=userMapper.list();
        userList.stream().forEach(user -> {
            System.out.println(user);
        });*/
        User user=userMapper.login("张");
        System.out.println(user);
    }

}
