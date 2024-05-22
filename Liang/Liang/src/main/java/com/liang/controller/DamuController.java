package com.liang.controller;

import com.liang.pojo.Danmu;
import com.liang.pojo.Post;
import com.liang.pojo.Result;
import com.liang.service.AddPostService;
import com.liang.service.DanmuService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: Liang
 * @Date: 2024/05/12/16:09
 * @Description:
 */
@Slf4j
@RestController
@CrossOrigin(origins = "http://localhost:8080")
public class DamuController {
    @Resource
    private DanmuService danmuService;
    @PostMapping("/choice2")
    public String addDanmu(@RequestBody Danmu danmu) {
        // 在这里执行数据库插入操作
        // 假设UserService有一个addUser方法来插入用户数据
        danmuService.addDanmu(danmu);
        return "Data added successfully!";
    }
    //展示数据
    @RequestMapping(value = "/choice2",method = RequestMethod.GET)
    public Result showDanmu(){
        //调用业务层代码
        return danmuService.showDanmu();
    }
}
