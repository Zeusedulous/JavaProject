package com.zsl.cn.test;


import com.fasterxml.jackson.core.type.TypeReference;
import com.zsl.cn.util.JacksonUtil;

import java.util.List;
import java.util.Map;

/**
 * @Author : Zeusedulous
 * @Date : 2021/11/22 16:01
 * @Desc :
 */
public class Test3 {
    public static void main(String[] args) throws Exception {
        String str = "{\"eventValue\":1, \"event\":\"aaa\"}";

        Map<String, Object> map = JacksonUtil.strToMap(str, String.class, Object.class);
        System.out.println(map);
        System.out.println(map.containsKey("test"));

    }
}