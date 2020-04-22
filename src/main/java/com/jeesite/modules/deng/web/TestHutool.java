package com.jeesite.modules.deng.web;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import com.jeesite.common.lang.StringUtils;
import com.jeesite.modules.deng.entity.MyThread;
import com.jeesite.modules.deng.entity.StudentSort;
import com.jeesite.modules.deng.entity.T1;

import java.lang.reflect.Field;
import java.util.*;

/**
 * @author deng
 * @Description: ${todo}(这里用一句话描述这个类的作用)
 * @date 2019/7/5 11:33
 */
public class TestHutool {
    public static void main(String[] args) throws NoSuchFieldException,IllegalAccessException{
        /*String dateStr = "2012-12-12 12:12:12";
        Date date = DateUtil.parse(dateStr);
        System.out.println(date);

        int a = 1;
        String aStr = Convert.toStr(a);

        int[] b = {1,2,3,4,5};
        String bStr = Convert.toStr(b);

        Object c = null;
        String cStr = Convert.toStr(c,"空字符串(默认值)");

        System.out.println(("整数"+a+"字符串"+aStr));
        System.out.println(("long数组"+b+"字符串"+bStr));
        System.out.println(("空对象"+c+"字符串"+cStr));

        String[] a1 = { "1", "2", "3", "4" };
        Integer[] b1 = Convert.toIntArray(a1);
        Integer integer = b1[0]+b1[1];
        System.out.println("字符串数组:"+Convert.toStr(a1)+",Integer数组:"+Convert.toStr(b1)+"---"+integer);

        String[] a2 = { "5", "2", "7", "4" };

        List<?> l = Convert.toList(a2);

        String[] b2= Convert.toStrArray(l);
        for(int i = 0;i<l.size();i++){
            Object o = l.get(i);
        }
        System.out.println("字符串数组"+a2+"集合"+l);
        System.out.println("集合"+l+"字符串数组"+b2);

        double  a3= 1234567123456.12;
        String b3 = Convert.digitToChinese(a3);
        System.out.println("数字:"+a3+",钞票金额:"+b3);

        String str = " 1 2";
        boolean blank = StrUtil.isBlank(str);
        boolean empty = StrUtil.isEmpty(str);
        String trim = StrUtil.trim(str);
        boolean empty1 = StrUtil.isEmpty(trim);
        boolean b4 = StrUtil.containsAny(str, "16");
        boolean b5 = StringUtils.contains(str, "16");
        System.out.println(b4);
        System.out.println(b5);*/

       /* T1 t1 = new T1();
        String sex = t1.sex;
        t1.setName1("刘备");
        System.out.println(t1.sex+"--"+t1.getName1());

        Class<? extends T1> clazz = t1.getClass();
        clazz.getDeclaredField("name");*/

//        Runnable threads = new MyThread();
//        Thread thread=new Thread(threads);
//        thread.start();
//        System.out.println("运行结束！");
        /*for(int i = 0;i< 100;i++){
            System.out.println("-------------------第"+i+"次运行开始！----------------");
            Runnable thread1 = new MyThread();
            Thread thread=new Thread(thread1);
            thread.start();
            System.out.println("第"+i+"次运行结束！");
        }
        int i = 0;
        if(i==0) i = 1;
        System.out.println(i);*/
        /*List<StudentSort> list = new ArrayList<>();
        StudentSort sort = new StudentSort(20, "刘四", "男");
        StudentSort sort2 = new StudentSort(30, "陈二", "男");
        StudentSort sort3 = new StudentSort(25, "赵三", "女");
        StudentSort sort4 = new StudentSort(35, "李大", "妖");
        list.add(sort);
        list.add(sort2);
        list.add(sort3);
        list.add(sort4);
        Collections.sort(list, new Comparator<StudentSort>() {
            @Override
            public int compare(StudentSort sort1,StudentSort sort2){
                int i = sort2.getSno() - sort1.getSno();
                if(i>0){
                    return 1;
                }else if(i<0){
                    return -1;
                }
                return 0;
            }
        });
        for (StudentSort stu : list) {
            System.out.println(stu.getName());
        }*/
        /*int v = (int)Math.random()*5;
        System.out.println(v);

        double v1 = Math.random() * 5;
        System.out.println(v1);

        double d = 0.0884634532260994;
        int d1 = (int) d;
        System.out.println(d1);

        int i = (int) (Math.random() * 5);
        System.out.println(i);*/
        //跳出外循环
       /* bgm:for(int i=0;i<3;i++){
            for(int j=0;j<4;j++){
                System.out.println("当前i的值"+j);
                if(j==2){
                    System.out.println("当前j的值="+j);
                    break;//跳出外循环，给外循环起一个名字，然后使用break 名字  跳出外循环
                }
            }
        }*/
        int a = 15,b = 10;
        double c = a/b;//如果想要结果是小数的话,只能是强转c=(double)a/(double)b
        System.out.println(c);//c的结果为1；原因是a,b是int类型，int类型相除会舍弃掉所有小数；虽然小范围的类型转大范围的类型能够隐式转换，但当有表达式操作时需要强制转换，否者可能失去精度 。左到右范围从小到大：byte->short->int->long->float->double
    }


    public void test1() {
        /*int a = 1;
        String aStr = Convert.toStr(a);

        int[] b = {1,2,3,4,5};
        String bStr = Convert.toStr(b);

        Object c = null;
        String cStr = Convert.toStr(c,"空字符串(默认值)");

        System.out.println(("整数"+a+"字符串"+aStr));
        System.out.println(("long数组"+b+"字符串"+bStr));
        System.out.println(("空对象"+c+"字符串"+cStr));*/

    }
}
