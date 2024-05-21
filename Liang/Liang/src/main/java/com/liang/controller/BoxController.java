package com.liang.controller;

import com.liang.pojo.Paper;
import com.liang.pojo.Result;
import com.liang.pojo.User;
import com.liang.service.BoxService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@CrossOrigin //解决异步请求的问题
public class BoxController {
    @Resource
    private BoxService boxService;
    @PostMapping("/choice2")
    public Result addBox(@RequestBody Paper paper){
        boxService.addBox(paper);
        return Result.success();
    }
    @GetMapping("/choice2")
    public Result getBox(@RequestBody Paper paper){
        Paper getpaper = boxService.getBox(paper);
        return Result.success(getpaper);
    }
    @GetMapping("/searchSend")
    public Result findSend(@RequestParam String username){
        List<Paper> getMyPaper =boxService.findSend(username);
        return Result.success(getMyPaper);
    }
    @GetMapping("/searchOwn")
    public Result findOwn(@RequestParam String username){
        List<Paper> getPaper =boxService.findOwn(username);
        return Result.success(getPaper);
    }
}
