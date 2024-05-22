package com.liang.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.w3c.dom.Text;

import java.time.LocalDateTime;

/**
 * @Author: Liang
 * @Date: 2024/05/09/13:04
 * @Description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Post {
    private int id;//帖子的编号
    private String title;//帖子的标题
    private String content;//帖子的正文内容
    private String time;
}
