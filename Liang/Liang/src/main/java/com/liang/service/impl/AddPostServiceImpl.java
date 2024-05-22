package com.liang.service.impl;

import com.liang.pojo.Post;
import com.liang.pojo.Result;
import com.liang.service.AddPostService;
import com.liang.mapper.PostMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddPostServiceImpl implements AddPostService {

    @Autowired
    private PostMapper postMapper;

    @Override
    public Result<List<Post>> showPost() {
        List<Post> posts = postMapper.showall(); // 调用 Mapper 方法获取帖子数据

        // 构建返回结果对象，假设 Result 是一个自定义的响应对象
        Result<List<Post>> result = new Result<>();
        result.setData(posts);
        return result;
    }

    @Override
    public void addPost(Post post) {
        postMapper.addPost(post); // 调用 Mapper 方法添加帖子
    }
}
