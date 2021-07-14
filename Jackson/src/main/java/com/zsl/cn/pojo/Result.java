package com.zsl.cn.pojo;

import lombok.Data;

/**
 * @Author : Zeusedulous
 * @Date : 2021/7/9 15:34
 * @Desc :
 */
@Data
public class Result {
    private String msg;
    private int code;
    private EntAppInfo result;
    private Object result2;
}
