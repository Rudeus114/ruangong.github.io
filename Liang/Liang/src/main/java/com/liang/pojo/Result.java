package com.liang.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result<T> {
    private Integer code;  // 响应码，1代表成功，0代表失败
    private String msg;    // 响应信息描述字符串
    private T data;        // 返回的数据

    // 增删改成功响应
    public static <T> Result<T> success() {
        return new Result<>(1, "success", null);
    }

    // 查询成功响应
    public static <T> Result<T> success(T data) {
        return new Result<>(1, "success", data);
    }

    // 失败响应
    public static <T> Result<T> error(String msg) {
        return new Result<>(0, msg, null);
    }
}
