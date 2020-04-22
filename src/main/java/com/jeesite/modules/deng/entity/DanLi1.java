package com.jeesite.modules.deng.entity;

import java.util.List;

/**
 * @author deng
 * @Description: 单例
 * @date 2019/5/27 10:47
 */
public class DanLi1 {
    //1,建立一个私有,静态的本类
    private static DanLi1 danLi1 = new DanLi1();
    //2,建立一个私有的构造方法,以避免其它类new出该类
    private DanLi1(){}
    //3,建立一个获取该类的公用,静态方法,用于获取该类的唯一方法,用此方法获取该类而不是new出来
    public static DanLi1 getDanLi1(){
        return danLi1;
    }

    //4,单例类可被调用的方法,如一个随机获取list中某条数据并打印出来
    public void shuiji(List<StudentSort> stu){
        StudentSort sort = stu.get((int) (Math.random() * stu.size()));
        System.out.println(sort);
    }
}
