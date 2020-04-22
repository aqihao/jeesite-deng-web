package com.jeesite.modules.deng.entity;

/**
 * @author deng
 * @Description: ${todo}(这里用一句话描述这个类的作用)
 * @date 2019/7/8 10:38
 */
public class T1 {
    private String name;
    public String sex;
    private String name1;
    public String sex1;

    public T1(){
        this.sex = "男";
        this.name = "张飞";
    }

    private String testP(){
        return "private";
    }

    public String testP1(){
        return "public";
    }

    public static String testP2(){
        return "p3-static";
    }

    static String testP3(){
        return "p4";
    }

    public String getName1() {
        return name1;
    }

    public void setName1(String name1) {
        this.name1 = name1;
    }

    private String getSex1() {
        return sex1;
    }

    private void setSex1(String sex1) {
        this.sex1 = sex1;
    }
}
