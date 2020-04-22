package com.jeesite.modules.deng.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jeesite.modules.deng.entity.TbTeacher;
import com.jeesite.modules.deng.service.TbTeacherService;
import com.jeesite.modules.utils.RedisUtil;
//import net.oschina.j2cache.redis.RedisUtils;
import com.jeesite.modules.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;

/**
 * @author deng
 * @date 2020/3/26 16:37
 */
@Controller
@RequestMapping(value = "redis")
public class RedisDemo {

    public static final Logger log = LoggerFactory.getLogger(RedisDemo.class);

    @Autowired
    private RedisUtil redisUtil;
    @Autowired
    private RedisUtils redisUtils;
    @Autowired
    private TbTeacherService tbTeacherService;

    @ResponseBody
    @RequestMapping(value = "test")
    public String hello(String id) {
        //查询缓存中是否存在
        boolean hasKey = redisUtils.exists(id);
        String str = "";
        if(hasKey){
            //获取缓存
            Object object =  redisUtils.get(id);
            log.info("从缓存获取的数据"+ object);
            TbTeacher tbTeacher = new TbTeacher();
            TbTeacher tbTeacher1 = (TbTeacher)object;
                    str = object.toString();
        }else{
            //从数据库中获取信息
            log.info("从数据库中获取数据");
            TbTeacher tbTeacher = tbTeacherService.get(id);
            //数据插入缓存（set中的参数含义：key值，user对象，缓存存在时间10（long类型），时间单位）
            redisUtils.set(id,tbTeacher,10L,TimeUnit.MINUTES);
            log.info("数据插入缓存" + tbTeacher);
        }
        return str;
    }

    @ResponseBody
    @RequestMapping(value = "fing")
    public TbTeacher fing(String id) {
        //查询缓存中是否存在
        boolean hasKey = redisUtils.exists(id);
        String str = "";
        TbTeacher tbTeachers = new TbTeacher();
        if(hasKey){
            //获取缓存
            Object object =  redisUtils.get(id);
            log.info("从缓存获取的数据"+ object);
            str = object.toString();
            tbTeachers = (TbTeacher)object;
            return tbTeachers;

        }else{
            //从数据库中获取信息
            log.info("从数据库中获取数据");
            TbTeacher tbTeacher = tbTeacherService.get(id);
            //数据插入缓存（set中的参数含义：key值，user对象，缓存存在时间10（long类型），时间单位）
            redisUtils.set(id,tbTeacher,10L,TimeUnit.MINUTES);
            log.info("数据插入缓存" + tbTeacher);
            return tbTeacher;
        }
    }
}
