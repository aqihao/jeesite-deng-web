package com.jeesite.modules.deng.entity;

/**
 * @author deng
 * @Description: ${todo}(这里用一句话描述这个类的作用)
 * @date 2019/8/22 9:51
 */
public class Son extends Fu {
    private String name;
    private String age;

    public Son(){
        this.name = "女儿son";
        this.age = "18";
    }

    public String str1(){
        return super.str();
    }

    @Override
    public String str(){
        return "我是女";
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getAge() {
        return age;
    }

    @Override
    public void setAge(String age) {
        this.age = age;
    }
}
