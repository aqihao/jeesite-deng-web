package com.jeesite.modules.deng.entity;

import com.fasterxml.jackson.databind.deser.DataFormatReaders;

import java.util.List;

/**
 * @author deng
 * @Description: ${todo}(这里用一句话描述这个类的作用)
 * @date 2019/5/25 17:12
 */
public class DanLi {
    //第一步,单例(饿汉模式)第一步,建立本类的私有(private)静态(static)对象
    private static DanLi danLi = new DanLi();
    //第二步,建立构造函数,和多线程的不一样,本类的构造方法必须是私有的,这样其它的类就不能new出本类(这样才叫单例,不能在其它类new出来),必须通过下面的方法获取
    private DanLi(){}
    //第三步,因为是单例模式,本类是不能在其它类中new出来的,所以其它的类要获取本类的话,必须在本类中写出一个获取本类的方法,而且必须是public static的,没有static则无法调用此方法,无法调用生成单例类的方法,则意味着不能调用所有该类的方法,包括下面的test
    public static DanLi getInstance() {
        //获取的时候就用第一步方法私有的静态类返回
        return danLi;
    }

    //本类的方法.输出一点内容用于测试
    public void test(){
        System.out.println("这是一个单例");
    }

    //一个用于随机获取StudenSort类值的方法,用于机试
    public StudentSort randomStu(List<StudentSort> stus){
        for (int i = 0;i<stus.size();i++) {
            return stus.get((int)(Math.random()*stus.size()));
        }
        return new StudentSort(1,"222","222");
    }
}
