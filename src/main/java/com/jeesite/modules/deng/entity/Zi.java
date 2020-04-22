package com.jeesite.modules.deng.entity;

/**
 * @author deng
 * @Description: ${todo}(这里用一句话描述这个类的作用)
 * @date 2019/8/22 9:45
 */
public class Zi extends Fu {
    private String name;
    private String age;

    public Zi(){
        this.name = "儿子zi";
        this.age = super.getAge();
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
