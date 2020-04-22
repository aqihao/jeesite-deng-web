package com.jeesite.modules.deng.entity;

/**
 * @author deng
 * @Description:
 *  定义学生类（包含学号、姓名、年龄），将你所在小组组员添加到一个集合
 *  中，并按学号排序后输出
 *  要对list进行排序必须实现排序类
 * @date 2019/5/25 15:34
 */
public class StudentSort {
    private int sno;
    private String name;
    private String age;

    public StudentSort(int sno,String name,String age){
        this.sno = sno;
        this.name = name;
        this.age = age;
    }

    public int getSno() {
        return sno;
    }

    public void setSno(int sno) {
        this.sno = sno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public String toString(){
        return "学号="+sno+";姓名="+name+";年龄="+age+"";
    }
}
