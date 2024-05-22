package com.liang.controller;

import com.liang.pojo.Paper;
import com.liang.pojo.Result;
import com.liang.service.BoxService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@CrossOrigin(origins = "http://localhost:8080")
public class BoxController {
    @Resource
    private BoxService boxService;
    @PostMapping("/choice1")
    public Result addBox(@RequestBody Paper paper){
        boxService.addBox(paper);
        return Result.success();
    }
    @GetMapping("/choice1")
    public Result getBox(@RequestParam("sex") String sex,
                         @RequestParam("area") String area,
                         @RequestParam("sign") String sign) {
        Paper paper = new Paper();
        paper.setSex(sex);
        paper.setArea(area);
        paper.setSign(sign);

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
