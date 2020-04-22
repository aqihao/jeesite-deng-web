package com.jeesite.modules.deng.service;

import com.jeesite.common.service.CrudService;
import com.jeesite.modules.deng.dao.TbTeacherDao;
import com.jeesite.modules.deng.entity.ReadExcel;
import com.jeesite.modules.deng.entity.TbTeacher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @author deng
 * @Description: ${todo}(这里用一句话描述这个类的作用)
 * @date 2019/7/3 10:10
 */
@Service
public class ImportService extends CrudService<TbTeacherDao, TbTeacher> {
    /**
      * 读取excel中的数据,生成list
      */
    @Transactional
    public String readExcelFile(MultipartFile file){
        String result = "";
         //创建处理EXCEL的类
         ReadExcel readExcel = new ReadExcel();
         //解析excel，获取上传的事件单
         List<Map<String, Object>> userList = readExcel.getExcelInfo(file);
         //至此已经将excel中的数据转换到list里面了,接下来就可以操作list,可以进行保存到数据库,或者其他操作,
         for(Map<String, Object> user:userList){
             //插入数据库操作
             String name = user.get("name").toString();
             String sex = user.get("sex").toString();
             String age = user.get("age").toString();
             String img = user.get("img").toString();
             String resume = user.get("resume").toString();
             TbTeacher teacher = new TbTeacher();
             teacher.setName(name);
             teacher.setSex(sex);
             teacher.setAge(Integer.valueOf(age));
             teacher.setPicture(img);
             teacher.setResume(resume);
             teacher.setSno(UUID.randomUUID().toString());
             super.insert(teacher);
         }
         if(userList != null && !userList.isEmpty()){
             result = "上传成功";
         }else{
             result = "上传失败";
         }
         return result;
    }
}
