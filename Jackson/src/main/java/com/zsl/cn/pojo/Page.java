package com.zsl.cn.pojo;

import lombok.Data;

import java.util.List;

/**
 * @Author : Zeusedulous
 * @Date : 2021/12/17 15:54
 * @Desc :
 */
@Data
public class Page<T> {

    private List<T> list;
}
