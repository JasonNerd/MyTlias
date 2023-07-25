package com.example.mytlias.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Result {
    private Integer code;   // 0: failure, 1: success
    private String msg;
    private Object data;
    // factory
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
