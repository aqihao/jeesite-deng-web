package com.jeesite.modules.utils;

import com.jeesite.common.lang.StringUtils;

import javax.mail.search.SearchException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author deng
 * @Description: 比较日期大小
 * @date 2019/7/2 10:39
 */
public class DateUtils {
    /**
     * 比较日期大小
     * <p>
     * 2017年9月7日 16:15:53
     * xj
     *
     * @param DATE1      第一个时间
     * @param DATE2      第二个时间
     * @param dateFormat 日期格式
     * @return Integer null日期格式有误，1：第一个日期大，0：两个日期一样，-1：第二个日期大
     */
    public static Integer compareDate(String DATE1, String DATE2, String dateFormat) throws SearchException {
        if(StringUtils.isEmpty(DATE1)){
           throw  new SearchException("日期1不能为空!");
        }
        DateFormat df = new SimpleDateFormat(dateFormat);
        try {
            Date dt1 = df.parse(DATE1);
            Date dt2 = df.parse(DATE2);
            if (dt1.getTime() > dt2.getTime()) {
                return 1;
            } else if (dt1.getTime() < dt2.getTime()) {
                return -1;
            } else {
                return 0;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage()+":"+e.toString());
//            logger.error(e.toString(), e);
        }

        return null;
    }
}
