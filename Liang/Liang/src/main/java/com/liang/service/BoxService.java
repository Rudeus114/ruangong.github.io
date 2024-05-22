package com.liang.service;

import com.liang.pojo.Paper;

import java.util.List;

public interface BoxService {
    public void addBox(Paper paper);
    public Paper getBox(Paper paper);
    public List<Paper> findSend(String username);
    public List<Paper> findOwn(String username);
}
