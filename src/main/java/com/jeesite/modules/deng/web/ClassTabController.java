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
import com.jeesite.modules.deng.entity.ClassTab;
import com.jeesite.modules.deng.service.ClassTabService;

/**
 * class_tabController
 * @author deng
 * @version 2019-01-29
 */
@Controller
@RequestMapping(value = "${adminPath}/deng/classTab")
public class ClassTabController extends BaseController {

	@Autowired
	private ClassTabService classTabService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public ClassTab get(String id, boolean isNewRecord) {
		return classTabService.get(id, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("deng:classTab:view")
	@RequestMapping(value = {"list", ""})
	public String list(ClassTab classTab, Model model) {
		model.addAttribute("classTab", classTab);
		return "modules/deng/classTabList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("deng:classTab:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<ClassTab> listData(ClassTab classTab, HttpServletRequest request, HttpServletResponse response) {
		classTab.setPage(new Page<>(request, response));
		Page<ClassTab> page = classTabService.findPage(classTab);
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("deng:classTab:view")
	@RequestMapping(value = "form")
	public String form(ClassTab classTab, Model model) {
		model.addAttribute("classTab", classTab);
		return "modules/deng/classTabForm";
	}

	/**
	 * 保存class_tab
	 */
	@RequiresPermissions("deng:classTab:edit")
	@RequestMapping(value = "save")
	@ResponseBody
	public String save(@Validated ClassTab classTab) {
		classTabService.save(classTab);
		return renderResult(Global.TRUE, text("保存class_tab成功！"));
	}
	
	/**
	 * 删除class_tab
	 */
	@RequiresPermissions("deng:classTab:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(ClassTab classTab) {
		classTabService.delete(classTab);
		return renderResult(Global.TRUE, text("删除class_tab成功！"));
	}
	
}