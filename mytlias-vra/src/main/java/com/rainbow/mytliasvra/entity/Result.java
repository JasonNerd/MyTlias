package com.rainbow.mytliasvra.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Result {
    private Integer code;   // 0: 失败, 1: 成功
    private String msg;     // 信息
    private Object data;    // 携带的数据
    public static Result success(){
        return new Result(1, "success", null);
    }
    public static Result success(Object data){
        return new Result(1, "success", data);
    }
    public static Result error(){
        return new Result(0, "error", null);
    }
}
