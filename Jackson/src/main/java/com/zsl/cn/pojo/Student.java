package com.zsl.cn.pojo;


/**
 * @Author : Zeusedulous
 * @Date : 2021/7/8 17:20
 * @Desc :
 */

public class Student {
    private String name;
    private int age;
    private long OrgID;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public long getOrgID() {
        return OrgID;
    }

    public void setOrgID(long orgID) {
        OrgID = orgID;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", OrgID=" + OrgID +
                '}';
    }
}
