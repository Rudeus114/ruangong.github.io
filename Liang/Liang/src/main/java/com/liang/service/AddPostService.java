package com.liang.service;

import com.liang.pojo.Post;
import com.liang.pojo.Result;

import java.util.List;

/**
 * @Author: Liang
 * @Date: 2024/05/10/13:26
 * @Description:
 */
public interface AddPostService {
    public Result<List<Post>> showPost();

    void addPost(Post post);
}
