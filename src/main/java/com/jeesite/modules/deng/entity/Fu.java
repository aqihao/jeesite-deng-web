package com.jeesite.modules.deng.entity;

/**
 * @author deng
 * @Description: ${todo}(这里用一句话描述这个类的作用)
 * @date 2019/8/22 9:39
 */
public class Fu {
    private String name;
    private String age;

    public Fu(){
        this.name = "父";
        this.age = "88";
    }

    public String str(){
        return "我是父";
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
}
