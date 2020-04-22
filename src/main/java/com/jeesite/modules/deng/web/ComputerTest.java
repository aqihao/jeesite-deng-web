package com.jeesite.modules.deng.web;

import com.jeesite.modules.deng.entity.DanLi;
import com.jeesite.modules.deng.entity.DanLi1;
import com.jeesite.modules.deng.entity.StudentSort;
import org.apache.commons.collections.ArrayStack;
//import redis.clients.jedis.Jedis;

import java.util.*;

/**
 * @author deng
 * @Description: ${todo}(这里用一句话描述这个类的作用)
 * @date 2019/5/25 11:38
 */
public class ComputerTest {
    /**
     * 将字符串「a-b-c-d-e-f」按 「-」 切割，找到 「c」字符，
     * 替换为大写，然后倒序输出 「f-e-d-C-b-a」
     * @author 26966
     */
    /*public static void main(String[] args) {
        String str = "a-b-c-d-e-f";
        String[] split = str.split("-");
        //找到"c"转换为大写
        for(int i = 0;i<split.length;i++){
            if("c".equals(split[i])){
                String s = split[i].toUpperCase();
                split[i] = s;
            }
        }
        System.out.println(split.length);
        String temp = "";
        for(int i = split.length -1;i >= 0;i--){
            temp += split[i]+"-";
        }
        System.out.println(temp);
        System.out.println(temp.substring(0, temp.length()-1));
        String substring = temp.substring(0, temp.length() - 1);
        System.out.println(substring);
        System.out.println(str.substring(2,4));
    }*/


    /**
     * 建立测试类，将小组组员添加到一个集合
     * 中，并按学号排序后输出
     */
    /*public static void main(String[] args) {
        List<StudentSort> stu = new ArrayList<>();
        StudentSort stu1 = new StudentSort(1, "张三", "25");
        StudentSort stu2 = new StudentSort(3, "李四", "21");
        StudentSort stu3 = new StudentSort(4, "王五", "21");
        StudentSort stu4 = new StudentSort(2, "陈六", "23");
        StudentSort stu5 = new StudentSort(6, "张三1", "25");
        StudentSort stu6 = new StudentSort(5, "李四2", "31");
        StudentSort stu7 = new StudentSort(8, "王五3", "91");
        StudentSort stu8 = new StudentSort(7, "陈六4", "23");
        stu.add(stu1);
        stu.add(stu2);
        stu.add(stu3);
        stu.add(stu4);
        stu.add(stu5);
        stu.add(stu6);
        stu.add(stu7);
        stu.add(stu8);
        //按学号排序后输出
        Collections.sort(stu, new Comparator<StudentSort>() {
            @Override
            public int compare(StudentSort o1, StudentSort o2) {
                //按学号排序
                int i = o2.getSno() - o1.getSno();
                //按年龄排序
//                int i = Integer.valueOf(o2.getAge()) - Integer.valueOf(o1.getAge());
                if(i == 0){
                    return o1.getSno() - o2.getSno();
                }
                return i;
            }
        });
        for(StudentSort stus : stu){
            System.out.println(stus.toString());
        }

//        System.out.println("随机:"+stu.get((int)(Math.random() * stu.size())));
//        System.out.println((Math.random()));
        DanLi danLi = DanLi.getInstance();
        danLi.test();
        StudentSort studentSort = danLi.randomStu(stu);
        System.out.println(studentSort);
    }*/


    /**
     * 建立测试类，将小组组员添加到一个集合
     * 中，并按学号排序后输出
     */
    /*public static void main(String[] args) {
        List<StudentSort> list = new ArrayList();
        list.add(new StudentSort(1,"张三","20"));
        list.add(new StudentSort(3,"李四","20"));
        list.add(new StudentSort(2,"王五","20"));
        list.add(new StudentSort(5,"孙六在","20"));
        list.add(new StudentSort(4,"陈七雄","20"));
        Collections.sort(list,new Comparator<StudentSort>(){
            @Override
            public int compare(StudentSort o1,StudentSort o2){
                //按学号来排序
                int i = o1.getSno() - o2.getSno();
                if(i == 0){
                    return o1.getSno() - o2.getSno();
                }
                return i;
            }
        });
//        for(StudentSort sort:list){
//            System.out.println(sort.toString());
//        }
        //用单例模式随机抽取一个学生输出
        //1,建立一个单例类-去项目里建一个单例类
        //2,调用这个单例类,由于是单例,只能通过单例的获取方法得到,而不能new出
        DanLi1 danLi1 = DanLi1.getDanLi1();
        danLi1.shuiji(list);

    }*/

    /*public static void main(String[] args) {
        Random random = new Random();
        int arr[] = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        String str = "";
        int temp = 0;
        while (str.length() != 4) {
            temp = random.nextInt(10);//随机获取0~9的数字
            if (arr[temp] == 0) {
                str += temp;
                arr[temp] = 1;
            }
        }
        System.out.println(str);
    }*/
    //生成一个随机四位数，每位数字不能重复
  /*  public static void main(String[] args) {
        //建立一个随机数类
        Random random = new Random();
        String str = "";
        //建立一个数组,长度是10个,内容全部设置为0,每当生成一个随机数后,将对应位置的0改成1,以用作判断
        int[] arr = {0,0,0,0,0,0,0,0,0,0};
        while (str.length() < 4){
            //生成一个0-9的随机数,并被用作arr数组里的下标,用以下面的判断是否有效
            int i = random.nextInt(10);
            //只要arr数据这个位置没有被改,还是0的话,这个随机数就是有效的非重复的,就取,而且取了之后把数组对应位置的0改成1,以便下次不取这个数,去重
            if(arr[i] == 0){
                str += i;
                //取过的位置把0改成1,下次就不会取这个数了
                arr[i] = 1;
            }
        }
        System.out.println(str);
    }*/
    //1万个数字中求第二大的数
    /*public static void main(String[] args) {
        List<String> list = new ArrayList<>(10);
        Random random = new Random();
            list.add("中");
            list.add("国");
            list.add("人");
            list.add("中");
            list.add("工");
        System.out.println(list.get(2));
        System.out.println(list.indexOf("中"));
    }*/

    //不使用中间变量，逆置字符串。
    /*public static void main(String[] args) {
        String str = "这里还可以直接使用StringBuilder或StringBuffer的reverse()方法来直接对字符串逆置排序";
        String str1 = "";
        for(int i = str.length() - 1;i>=0;i--){
            str1 += str.charAt(i);
        }
        System.out.println(str1);

        StringBuffer str2 = new StringBuffer("ADBCDEF");
        str2.reverse();
        System.out.println(str2);
    }*/

   /* public static void main(String[] args) {
        // 连接本地的 Redis 服务
        Jedis jedis = new Jedis("localhost");
        System.out.println("连接成功");
        // 查看服务是否运行
        System.out.println("服务正在运行: " + jedis.ping());
        jedis.set("name","刘备");
        String name = jedis.get("name");
        System.out.println(name);
    }*/


}
