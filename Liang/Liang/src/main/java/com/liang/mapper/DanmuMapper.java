package com.liang.mapper;

import com.liang.pojo.Danmu;
import com.liang.pojo.Post;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author: Liang
 * @Date: 2024/05/12/16:13
 * @Description:
 */
@Mapper
public interface DanmuMapper {
    public void addDanmu (Danmu danmu);
    List<Danmu> showDanmu();
}
