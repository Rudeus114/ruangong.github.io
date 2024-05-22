package com.liang.service.impl;

import com.liang.mapper.DanmuMapper;
import com.liang.mapper.PostMapper;
import com.liang.pojo.Danmu;
import com.liang.pojo.Post;
import com.liang.pojo.Result;
import com.liang.service.DanmuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: Liang
 * @Date: 2024/05/12/16:12
 * @Description:
 */
@Service
public class DanmuServiceImpl implements DanmuService {

    @Autowired
    private DanmuMapper danmuMapper;


    @Override
    public Result<List<Danmu>> showDanmu() {
        List<Danmu> danmus = danmuMapper.showDanmu(); // 调用 Mapper 方法获取帖子数据

        // 构建返回结果对象，假设 Result 是一个自定义的响应对象
        Result<List<Danmu>> result = new Result<>();
        result.setData(danmus);
        return result;
    }

    @Override
    public void addDanmu(Danmu danmu) {
            danmuMapper.addDanmu(danmu); // 调用 Mapper 方法添加弹幕
    }
}
