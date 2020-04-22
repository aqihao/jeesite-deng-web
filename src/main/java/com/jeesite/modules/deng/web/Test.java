package com.jeesite.modules.deng.web;

import com.jeesite.modules.deng.entity.*;

/**
 * @author deng
 * @Description: ${todo}(这里用一句话描述这个类的作用)
 * @date 2019/8/22 9:43
 */
public class Test {
    public static void main(String[] args) {
        String str = "中华人民共和国abcdef12345";
        StringBuffer buffer = new StringBuffer("中华人民共和国abcdef12345");
        buffer.append("000");
        System.out.println(buffer);

    }
}
