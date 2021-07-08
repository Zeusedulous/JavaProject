package com.zsl.cn.test;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.zsl.cn.pojo.Student;
import com.zsl.cn.pojo.Students;
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

        ObjectNode();

        Map();

        pojo2ObjectNode();
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
