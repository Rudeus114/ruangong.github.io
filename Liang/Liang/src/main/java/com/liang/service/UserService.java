package com.liang.service;

import com.liang.pojo.Result;
import com.liang.pojo.User;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author: Liang
 * @Date: 2024/03/24/14:47
 * @Description:
 */
public interface UserService {
    public Result login(String username, String password);
}
