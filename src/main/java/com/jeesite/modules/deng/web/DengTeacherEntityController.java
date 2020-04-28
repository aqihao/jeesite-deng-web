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
import com.jeesite.modules.deng.entity.DengTeacherEntity;
import com.jeesite.modules.deng.service.DengTeacherEntityService;

/**
 * deng_teacher_entityController
 * @author deng
 * @version 2020-04-27
 */
@Controller
@RequestMapping(value = "${adminPath}/deng/dengTeacherEntity")
public class DengTeacherEntityController extends BaseController {

	@Autowired
	private DengTeacherEntityService dengTeacherEntityService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public DengTeacherEntity get(String id, boolean isNewRecord) {
		return dengTeacherEntityService.get(id, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("deng:dengTeacherEntity:view")
	@RequestMapping(value = {"list", ""})
	public String list(DengTeacherEntity dengTeacherEntity, Model model) {
		model.addAttribute("dengTeacherEntity", dengTeacherEntity);
		return "modules/deng/dengTeacherEntityList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("deng:dengTeacherEntity:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<DengTeacherEntity> listData(DengTeacherEntity dengTeacherEntity, HttpServletRequest request, HttpServletResponse response) {
		dengTeacherEntity.setPage(new Page<>(request, response));
		Page<DengTeacherEntity> page = dengTeacherEntityService.findPage(dengTeacherEntity);
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("deng:dengTeacherEntity:view")
	@RequestMapping(value = "form")
	public String form(DengTeacherEntity dengTeacherEntity, Model model) {
		model.addAttribute("dengTeacherEntity", dengTeacherEntity);
		return "modules/deng/dengTeacherEntityForm";
	}

	/**
	 * 保存deng_teacher_entity
	 */
	@RequiresPermissions("deng:dengTeacherEntity:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated DengTeacherEntity dengTeacherEntity) {
		dengTeacherEntityService.save(dengTeacherEntity);
		return renderResult(Global.TRUE, text("保存deng_teacher_entity成功！"));
	}
	
	/**
	 * 删除deng_teacher_entity
	 */
	@RequiresPermissions("deng:dengTeacherEntity:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(DengTeacherEntity dengTeacherEntity) {
		dengTeacherEntityService.delete(dengTeacherEntity);
		return renderResult(Global.TRUE, text("删除deng_teacher_entity成功！"));
	}
	
}