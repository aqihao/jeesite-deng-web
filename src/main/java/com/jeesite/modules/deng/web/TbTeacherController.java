/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.deng.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jeesite.common.lang.DateUtils;
import com.jeesite.modules.deng.entity.TbStudent;
import com.jeesite.modules.deng.service.TbStudentService;
import com.jeesite.modules.utils.IDUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.jeesite.common.config.Global;
import com.jeesite.common.entity.Page;
import com.jeesite.common.web.BaseController;
import com.jeesite.modules.deng.entity.TbTeacher;
import com.jeesite.modules.deng.service.TbTeacherService;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;

/**
 * tb_teacherController
 * @author deng
 * @version 2019-05-23
 */
@Controller
@RequestMapping(value = "${adminPath}/deng/tbTeacher")
public class TbTeacherController extends BaseController {

	@Autowired
	private TbTeacherService tbTeacherService;
	@Autowired
	private TbStudentService tbStudentService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public TbTeacher get(String sno, boolean isNewRecord) {
		return tbTeacherService.get(sno, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("deng:tbTeacher:view")
	@RequestMapping(value = {"list", ""})
	public String list(TbTeacher tbTeacher, Model model) {
		model.addAttribute("tbTeacher", tbTeacher);
		return "modules/deng/tbTeacherList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("deng:tbTeacher:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<TbTeacher> listData(TbTeacher tbTeacher, HttpServletRequest request, HttpServletResponse response) {
		tbTeacher.setPage(new Page<>(request, response));
		Page<TbTeacher> page = tbTeacherService.findPage(tbTeacher);
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("deng:tbTeacher:view")
	@RequestMapping(value = "form")
	public String form(TbTeacher tbTeacher, Model model) {
		model.addAttribute("tbTeacher", tbTeacher);
		return "modules/deng/tbTeacherForm";
	}

	/**
	 * 保存tb_teacher
	 */
	@RequiresPermissions("deng:tbTeacher:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated TbTeacher tbTeacher) {
		tbTeacherService.save(tbTeacher);
		return renderResult(Global.TRUE, text("保存tb_teacher成功！"));
	}
	
	/**
	 * 删除tb_teacher
	 */
	@RequiresPermissions("deng:tbTeacher:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(TbTeacher tbTeacher) {
		tbTeacherService.delete(tbTeacher);
		return renderResult(Global.TRUE, text("删除tb_teacher成功！"));
	}

	/**
	 * 批量添加页面
	 */
	@RequiresPermissions("deng:tbTeacher:view")
	@RequestMapping(value = "batchAddPage")
	public String batchAddPage(Model model) {
		model.addAttribute("tbTeacher", "111");
		return "modules/deng/batchAddPage";
	}

	/**
	 * 批量添加学生
	 */
	@RequiresPermissions("deng:tbTeacher:view")
	@RequestMapping(value = "batchAdd")
	public String batchAdd(Model model,TbTeacher tbTeacher) {
		List<TbStudent> students = tbTeacher.getStudents();
		for(TbStudent stu : students){
			TbStudent student = new TbStudent();
			student.setIsNewRecord(true);
			student.setName(stu.getName());
			student.setSex(stu.getSex());
			student.setAge(stu.getAge());
			tbStudentService.save(student);
		}
		model.addAttribute("tbTeacher", "添加学生"+students.size()+"个成功");
		return "modules/deng/batchAddPage";
	}

	/**
	 * 添加图片页面
	 */
	@RequiresPermissions("deng:tbTeacher:view")
	@RequestMapping(value = "addImgPage")
	public String addImgPage(Model model) {
		model.addAttribute("tbTeacher", "111");
		return "modules/deng/addImgPage";
	}

	/**
	 * 添加图片
	 */
	@RequiresPermissions("deng:tbTeacher:view")
	@RequestMapping(value = "addImg")
	public String addImg(@RequestParam(value = "file", required = false) MultipartFile file,TbTeacher tbTeacher,Model model, HttpServletRequest request, HttpServletResponse response) {
		if(null != file && file.getSize() != 0){
			String path = request.getSession().getServletContext().getRealPath("upload")+"/imgs/test";
			String fileNames = file.getOriginalFilename();
			//fileNames.substring(fileNames.lastIndexOf("."), fileNames.length());//获取文件名中以.分割的最后字符串

			String fileName = DateUtils.getDate("yyyyMMddHHss")+ IDUtils.getUUID32()+fileNames.substring(fileNames.lastIndexOf("."), fileNames.length());
			File targetFile2 = new File(path, fileName);//这里必须要初始化一个目录带文件名的文件,file.transferTo(targetFile2);才能存储,否则会变成一个目录文件
			File targetFile = new File(path);//初始化一个文件并且放入路径,方便下面判断这个路径(目录)是否存在
			//判断目录是否存在,不存在,则新建一个
			if(!targetFile.exists()){
				targetFile.mkdirs();
			}
			//保存
			try {
				file.transferTo(targetFile2);
			} catch (Exception e) {
				e.printStackTrace();
			}
			tbTeacher.setPicture("/upload/imgs/test/"+fileName);
		}
		tbTeacherService.save(tbTeacher);
		model.addAttribute("tbTeacher", "成功");
		return "redirect:list";
//		return "modules/deng/addImgPage";
	}

	/**
	 * 查看详情
	 */
	@RequiresPermissions("deng:tbTeacher:view")
	@RequestMapping(value = "details")
	public String details(Model model,TbTeacher tbTeacher) {
		TbTeacher tbTeacher1 = tbTeacherService.get(tbTeacher.getSno());
		model.addAttribute("tbTeacher", tbTeacher);
		return "modules/deng/details";
	}
}