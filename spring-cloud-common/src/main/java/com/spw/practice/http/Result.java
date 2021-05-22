package com.spw.practice.http;

import lombok.Data;

import java.io.Serializable;

/**
 * 统一响应结果集
 * @author spw
 * @date 2021/02/15
 */
@Data
public class Result implements Serializable {
    /**
     * 响应码
     */
    private int code;

    /**
     * 响应信息
     */
    private String msg;

    /**
     * 响应报文
     */
    private Object data;

    public Result setCode(int code) {
        this.code = code;
        return this;
    }

    public Result setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public Result setData(Object data) {
        this.data = data;
        return this;
    }

    public static Result sucessResult(Object data) {
        return new Result()
                .setCode(ResultCode.SUCCESS.code)
                .setMsg(ResultCode.SUCCESS.msg)
                .setData(data);
    }

    public static Result sucessResult() {
        return new Result()
                .setCode(ResultCode.SUCCESS.code)
                .setMsg(ResultCode.SUCCESS.msg);
    }

    public static Result failResult(String msg) {
        return new Result()
                .setCode(ResultCode.SERVER_ERROR.code)
                .setMsg(ResultCode.SERVER_ERROR.msg + ":" + msg);
    }

}
