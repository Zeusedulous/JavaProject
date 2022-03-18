package com.zsl.cn.test;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.zsl.cn.util.JacksonUtil;
import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @Author : Zeusedulous
 * @Date : 2021/11/22 16:01
 * @Desc :
 */
public class Test3 {
    public static void main(String[] args) throws Exception {
        String entExtend = "[{\"accountRoles\":\"[]\",\"phone\":\"22\",\"orderNum\":1,\"orgCode\":\"1001\",\"orgID\":\"1\"}]";

        ArrayNode entExtendArr = null;
        if (StringUtils.isNotBlank(entExtend)) {
//            entExtendArr = Arrays.asList(entExtend);
            entExtendArr = JacksonUtil.str2Obj(entExtend, new TypeReference<ArrayNode>() {
            });
        }
        System.out.println(entExtend);


        for (int i=0;i<entExtendArr.size();i++){
            Object obj = entExtendArr.get(i);
            System.out.println(obj);
        }
        for (Object obj : entExtendArr) {
            System.out.println("ojb= " + obj);
            Map entUser = JacksonUtil.obj2Obj(obj, new TypeReference<Map<String,Object>>() {
            });
            System.out.println("entUser="+entUser);
            System.out.println(entUser.get("phone"));
            String extendValue = entUser.get("phone").toString();
            System.out.println("extendValue="+extendValue);
        }

    }
}