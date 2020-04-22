package com.jeesite.modules.deng.web;

/**
 * @author deng
 * @Description: ${todo}(这里用一句话描述这个类的作用)
 * @date 2019/3/4 20:35
 */
public class DengTest1 implements Runnable{
    @Override
    public void run(){
        for(int i = 0;i < 100;i++){
            System.out.println("子函数");
        }
    }
}

class test1 {
    public static void main(String[] args) {
        DengTest1 dengTest1 = new DengTest1();
        Thread thread = new Thread(dengTest1);
        thread.start();
        for(int i = 0;i < 100;i++){
            System.out.println("主函数");
        }
    }
}
