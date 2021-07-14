package com.zsl.cn.test;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeCreator;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.zsl.cn.pojo.*;
import com.zsl.cn.util.JacksonUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author : Zeusedulous
 * @Date : 2021/7/8 17:23
 * @Desc :
 */
public class Test {

    public static void main(String[] args) throws Exception {

//        ObjectNode();

//        Map();

//        pojo2ObjectNode();

//        str2ObjectNode();

//        objctNodePutPojo();

//        testAsText();
        testArrayNode();
    }

    public static void testArrayNode() throws Exception {
//        List<User> list = new ArrayList<>();
//
//        User user = new User();
//        user.setAge(11);
//        user.setName("张三");
//        user.setSex("男");
//
//        list.add(user);
//
//        user = new User();
//        user.setSex("女");
//        user.setName("李四");
//        user.setAge(22);
//
//        list.add(user);

        String str = "{\"msg\":\"\",\"code\":1,\"result2\":[{\"name\":\"张三\",\"age\":11,\"sex\":\"男\"},{\"name\":\"李四\",\"age\":22,\"sex\":\"女\"}]}";

//        Result result = JacksonUtil.str2pojo(str,Result.class);
//        System.out.println(result);
//        ArrayNode arrayNode = JacksonUtil.obj2pojo(result.getResult2(),ArrayNode.class);
//        System.out.println("================");
//        System.out.println(arrayNode);
//        for (JsonNode arr : arrayNode) {
//            System.out.println(arr);
//            System.out.println(JacksonUtil.obj2Obj(arr, new TypeReference<ObjectNode>() {}));
//        }

        ObjectNode objectNode = JacksonUtil.str2pojo(str,ObjectNode.class);
        ArrayNode arrayNode = objectNode.withArray("result2");
        System.out.println(arrayNode);
        for (JsonNode arr : arrayNode) {
            System.out.println(arr);
            System.out.println(arr.path("name").asText());
            System.out.println(arr.path("name").textValue());
            System.out.println(JacksonUtil.obj2Obj(arr, new TypeReference<ObjectNode>() {}));
        }

    }

    public static void testAsText(){
        ObjectNode objectNode = new ObjectMapper().createObjectNode();
        objectNode.put("a",1);
        objectNode.put("b","b");

        System.out.println(objectNode.get("a").asInt());
        System.out.println(objectNode.get("a").intValue());
        System.out.println(objectNode.get("b").textValue());
        System.out.println(objectNode.get("b").asText());
        System.out.println(objectNode.path("c").asText());
        System.out.println(objectNode.path("c").textValue());
        System.out.println("---------------");
        System.out.println(objectNode.get("b").toPrettyString());
        System.out.println(objectNode.path("c").toString());



    }

    public static void objctNodePutPojo() throws Exception {

        List<String> accountList = new ArrayList<>();
        accountList.add("1");
        accountList.add("2");
        accountList.add("3");
        String str = JacksonUtil.obj2JsonStr(accountList);
        //参数设置
        ObjectNode jsonData = new ObjectMapper().createObjectNode();
        jsonData.put("accountList", str);
        jsonData.putPOJO("accountList2", accountList);

        jsonData.put("appID", "111111");
        jsonData.put("sdkID", "222222");
        System.out.println(JacksonUtil.obj2JsonStr(jsonData));
    }


    public static void str2ObjectNode() throws Exception {
        String str = "{\"msg\":\"\",\"result\":{\"appFunctintroduce\":\"dsfsfdd\",\"appID\":21256822673,\"appIcon\":\"/group1/M00/00/00/rBAImGDnrwSAOZ0gAAAYADC_45807.jpeg\",\"appName\":\"test1\",\"appName_PinYin\":\"test1 test1\",\"appSecret\":\"jponI1CMmUTdIjqnGgP-YVtXdN9xwq0ONdZvYr3_ZNXqOoRxwvU0wZsHUpaKyCvm\",\"appSetting\":{},\"appSign\":\"dsdfdff\",\"appSubType\":0,\"appType\":0,\"configs\":{},\"defaultInstall\":0,\"enableRemoveServer\":0,\"entID\":0,\"lineStatus\":0,\"messageHistoryUrl\":\"//vrvxin/messageGroup/toHistoryMessage.do?appId=21256822673\",\"openIDEncoded\":0,\"orgIdList\":[],\"ownerId\":21256832675,\"recommend\":0,\"replyMenuOpen\":\"0\",\"sdkType\":0,\"showInMy\":0,\"status\":2,\"subOrAppType\":3,\"useLocal\":0},\"code\":0}";
//        ObjectNode obj = JacksonUtil.str2Obj(str,new TypeReference<ObjectNode>() {});
        ObjectNode obj = JacksonUtil.str2pojo(str,ObjectNode.class);
        System.out.println(obj);
        System.out.println("-------------------------");
        System.out.println(obj.path("result"));
//        EntAppInfo appInfo =  JacksonUtil.str2Obj(obj.path("result").toString(), new TypeReference<EntAppInfo>() {});

        EntAppInfo appInfo = JacksonUtil.obj2Obj(obj.path("result"),new TypeReference<EntAppInfo>() {});

        System.out.println(appInfo);
//        Result result = JacksonUtil.obj2Obj(obj, new TypeReference<Result>() {});
//        System.out.println(result);
    }


    public static void ObjectNode() throws Exception {
        Student student = new Student();
        student.setAge(21);
        student.setName("张三");

        List<Student> list = new ArrayList<>();
        list.add(student);
        Students students = new Students();
        students.setStudents(list);

        ObjectNode jsonData = new ObjectMapper().createObjectNode();
        jsonData.put("sdkID", 1L);
        jsonData.put("appID", "111111");
        jsonData.put("entID", 2222L);
        jsonData.putPOJO("students",students);

        System.out.println(JacksonUtil.obj2JsonStr(jsonData));
    }
    public static void Map() throws Exception {
        Student student = new Student();
        student.setAge(21);
        student.setName("张三");

        List<Student> list = new ArrayList<>();
        list.add(student);
        Students students = new Students();
        students.setStudents(list);

        Map map = new HashMap<>();
        map.put("sdkID", 1L);
        map.put("appID", "111111");
        map.put("entID", 2222L);
        map.put("students",students);

        System.out.println(JacksonUtil.obj2JsonStr(map));
    }

    public static void pojo2ObjectNode() throws Exception {
        Student student = new Student();
        student.setAge(21);
        student.setName("张三");

        ObjectNode jsonData = JacksonUtil.obj2Obj(student, new TypeReference<ObjectNode>() {});
        jsonData.put("appID", "111111");

        System.out.println(JacksonUtil.obj2JsonStr(jsonData));
    }
}
