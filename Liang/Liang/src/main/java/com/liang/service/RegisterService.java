package com.liang.service;

import com.liang.pojo.Result;
import com.liang.pojo.User;

/**
 * @Author: Liang
 * @Date: 2024/03/25/20:54
 * @Description:
 */
public interface RegisterService {

    public Result isusername(String username);

    public void addUser(User user);
}
