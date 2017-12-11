package com.xiaoqiang.sqlitelearn.sqlite.bean;

/**
 * Description: 用户信息
 * Created by crx on 2017/12/7.
 */

public class UserBean {
    private String id;
    private String name;
    private int gender;
    private int age;
    private String avatar;  //新加字段

    public UserBean(String id, String name, int gender, int age, String avatar) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.avatar = avatar;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    @Override
    public String toString() {
        return "UserBean{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                ", age=" + age +
                ", avatar='" + avatar + '\'' +
                '}';
    }
}
