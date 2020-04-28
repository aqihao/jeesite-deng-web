/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.deng.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jeesite.common.config.Global;
import com.jeesite.common.entity.Page;
import com.jeesite.common.web.BaseController;
import com.jeesite.modules.deng.entity.DengStudentEntity;
import com.jeesite.modules.deng.service.DengStudentEntityService;

/**
 * deng_student_entityController
 * @author deng
 * @version 2020-04-27
 */
@Controller
@RequestMapping(value = "${adminPath}/deng/dengStudentEntity")
public class DengStudentEntityController extends BaseController {

	@Autowired
	private DengStudentEntityService dengStudentEntityService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public DengStudentEntity get(String id, boolean isNewRecord) {
		return dengStudentEntityService.get(id, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("deng:dengStudentEntity:view")
	@RequestMapping(value = {"list", ""})
	public String list(DengStudentEntity dengStudentEntity, Model model) {
		model.addAttribute("dengStudentEntity", dengStudentEntity);
		return "modules/deng/dengStudentEntityList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("deng:dengStudentEntity:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<DengStudentEntity> listData(DengStudentEntity dengStudentEntity, HttpServletRequest request, HttpServletResponse response) {
		dengStudentEntity.setPage(new Page<>(request, response));
		Page<DengStudentEntity> page = dengStudentEntityService.findPage(dengStudentEntity);
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("deng:dengStudentEntity:view")
	@RequestMapping(value = "form")
	public String form(DengStudentEntity dengStudentEntity, Model model) {
		model.addAttribute("dengStudentEntity", dengStudentEntity);
		return "modules/deng/dengStudentEntityForm";
	}

	/**
	 * 保存deng_student_entity
	 */
	@RequiresPermissions("deng:dengStudentEntity:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated DengStudentEntity dengStudentEntity) {
		dengStudentEntityService.save(dengStudentEntity);
		return renderResult(Global.TRUE, text("保存deng_student_entity成功！"));
	}
	
	/**
	 * 删除deng_student_entity
	 */
	@RequiresPermissions("deng:dengStudentEntity:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(DengStudentEntity dengStudentEntity) {
		dengStudentEntityService.delete(dengStudentEntity);
		return renderResult(Global.TRUE, text("删除deng_student_entity成功！"));
	}
	
}