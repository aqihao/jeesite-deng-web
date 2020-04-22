package com.jeesite.modules.deng.web;

/**
 * @author deng
 * @Description: ${todo}(这里用一句话描述这个类的作用)
 * @date 2019/3/4 20:22
 */
class DengTest extends Thread{
    @Override
    public void run(){
        for(int i = 0;i< 1000;i++){
            System.out.println("子函数");
        }
    }


}
class test{
    public static void main(String[] args) {
        DengTest dengTest = new DengTest();
        dengTest.start();
        for(int i = 0;i< 1000;i++){
            System.out.println("主函数");
        }
    }
}
