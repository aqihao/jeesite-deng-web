package com.jeesite.modules.deng.entity;

/**
 * @author deng
 * @Description: ${todo}(这里用一句话描述这个类的作用)
 * @date 2019/7/8 15:31
 */
public class MyThread implements Runnable {
    @Override
    public void run(){
        System.out.println("myRunnable");
    }
}
