package com.liang.service.impl;

import com.liang.mapper.UserMapper;
import com.liang.pojo.Paper;
import com.liang.pojo.Result;
import com.liang.pojo.User;
import com.liang.service.BoxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoxServicelmpl implements BoxService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public void addBox(Paper paper){
        userMapper.addBox(paper);
    }
    @Override
    public Paper getBox(Paper paper) {
        return userMapper.getBox(paper.getSex(),paper.getArea(),paper.getSign());
    }
    @Override
    public List<Paper> findSend(String username){
        return userMapper.findSend(username);
    }
    @Override
    public List<Paper> findOwn(String username){
        return userMapper.findOwn(username);
    }
}
