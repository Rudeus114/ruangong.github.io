package com.liang.service;

import com.liang.pojo.Danmu;
import com.liang.pojo.Result;

import java.util.List;

/**
 * @Author: Liang
 * @Date: 2024/05/12/16:11
 * @Description:
 */
public interface DanmuService {
    public Result<List<Danmu>> showDanmu();
   void addDanmu(Danmu danmu);
}
