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
import com.jeesite.modules.deng.entity.DengCourseEntity;
import com.jeesite.modules.deng.service.DengCourseEntityService;

/**
 * deng_course_entityController
 * @author deng
 * @version 2020-04-27
 */
@Controller
@RequestMapping(value = "${adminPath}/deng/dengCourseEntity")
public class DengCourseEntityController extends BaseController {

	@Autowired
	private DengCourseEntityService dengCourseEntityService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public DengCourseEntity get(String id, boolean isNewRecord) {
		return dengCourseEntityService.get(id, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("deng:dengCourseEntity:view")
	@RequestMapping(value = {"list", ""})
	public String list(DengCourseEntity dengCourseEntity, Model model) {
		model.addAttribute("dengCourseEntity", dengCourseEntity);
		return "modules/deng/dengCourseEntityList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("deng:dengCourseEntity:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<DengCourseEntity> listData(DengCourseEntity dengCourseEntity, HttpServletRequest request, HttpServletResponse response) {
		dengCourseEntity.setPage(new Page<>(request, response));
		Page<DengCourseEntity> page = dengCourseEntityService.findPage(dengCourseEntity);
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("deng:dengCourseEntity:view")
	@RequestMapping(value = "form")
	public String form(DengCourseEntity dengCourseEntity, Model model) {
		model.addAttribute("dengCourseEntity", dengCourseEntity);
		return "modules/deng/dengCourseEntityForm";
	}

	/**
	 * 保存deng_course_entity
	 */
	@RequiresPermissions("deng:dengCourseEntity:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated DengCourseEntity dengCourseEntity) {
		dengCourseEntityService.save(dengCourseEntity);
		return renderResult(Global.TRUE, text("保存deng_course_entity成功！"));
	}
	
	/**
	 * 删除deng_course_entity
	 */
	@RequiresPermissions("deng:dengCourseEntity:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(DengCourseEntity dengCourseEntity) {
		dengCourseEntityService.delete(dengCourseEntity);
		return renderResult(Global.TRUE, text("删除deng_course_entity成功！"));
	}
	
}