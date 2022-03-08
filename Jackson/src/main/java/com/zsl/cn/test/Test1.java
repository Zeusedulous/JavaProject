package com.zsl.cn.test;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.zsl.cn.util.JacksonUtil;

import java.util.*;

/**
 * @Author : Zeusedulous
 * @Date : 2021/8/16 17:30
 * @Desc :
 */
public class Test1 {

    public static void main(String[] args) throws Exception {
        String str = "[{\"bb04a68f81f84dcf98fd840e1936fb3d\":\"\",\"accountRoles\":\"[]\",\"6ad6f26ea2584a3daa0241075793f2af\":\"周世龙\",\"isFirstLogin\":\"0\",\"orgCode\":\"1001\",\"5ce1151741534b17b2a4acd77e8909dc\":\"\",\"bizStatus\":\"1\",\"orgID\":\"1\",\"orderNum\":99999}]";
        List<Map> ent = JacksonUtil.str2List(str, Map.class);
        System.out.println(ent);
        System.out.println(ent.get(0));
        Map<String,Object> entExtendArr = ent.get(0);

        for (Map.Entry<String, Object> m : entExtendArr.entrySet()) {
            System.out.println("key:" + m.getKey() + " value:" + m.getValue());
            String field = "6ad6f26ea2584a3daa0241075793f2af";
            if(m.getKey().equals(field)){
                String extendValue = m.getValue().toString();
                System.out.println(extendValue);
            }
        }
//        for (Object obj : entExtendArr) {
//            JsonNode entUser = JacksonUtil.obj2Obj(obj, new TypeReference<JsonNode>() {
//            });
//            logger.info("extend field:" + field);
//            String extendValue = entUser.get(field).asText();
//            logger.info("extend extendValue:" + extendValue + "," + verifySuccess);
//            if (extendValue != null && extendValue.equals(ufJson.get(key).asText())) {
//                isExtendEqual = true;
//                logger.info("extend extendValue:" + extendValue + "," + isExtendEqual);
//                break;
//            }
//        }

//        Map<String,String> map = JacksonUtil.strToMap(listStr, String.class, String.class);
//        System.out.println(map);
//        Map<String,Object> entExtendArr = (Map<String, Object>) JacksonUtil.listJson2MapList(ent, String.class, Object.class);
//        System.out.println("========================");
//        System.out.println(entExtendArr);
//
//        for (Map.Entry<String, Object> m : entExtendArr.entrySet()) {
//            System.out.println("key:" + m.getKey() + " value:" + m.getValue());
//            String field = "6ad6f26ea2584a3daa0241075793f2af";
//            if(m.getKey().equals(field)){
//                String extendValue = m.getValue().toString();
//                System.out.println(extendValue);
//            }
//
//        }
    }
}
