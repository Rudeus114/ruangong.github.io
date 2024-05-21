package com.liang.service;

import com.liang.pojo.Paper;
import com.liang.pojo.Result;
import com.liang.pojo.User;

import java.util.List;

public interface BoxService {
    public void addBox(Paper paper);
    public Paper getBox(Paper paper);
    public List<Paper> findSend(String username);
    public List<Paper> findOwn(String username);
}
