package com.liang.mapper;

import com.liang.pojo.Post;
import com.liang.pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author: Liang
 * @Date: 2024/05/09/13:53
 * @Description:
 */
@Mapper
public interface PostMapper {
    public void addPost (Post post);
    List<Post> showall();
}
