package com.liang.mapper;

import com.liang.pojo.Paper;
import com.liang.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    //登录功能

    public User login(String username);
    public User isusername(String username);
    public void insert(User user);
    public void addBox(Paper paper);
    public Paper getBox(String sex,String area,String sign);
    public List<Paper> findSend(String username);
    public List<Paper> findOwn(String username);
}
