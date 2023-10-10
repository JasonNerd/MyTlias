package com.example.mytliasvrd.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Result {
    Integer code;
    String msg;
    Object data;
    public static Result error(){
        return new Result(0, "error", null);
    }
    public static Result success(){
        return new Result(1, "success", null);
    }
    public static Result success(Object data){
        return new Result(1, "success", data);
    }
}
