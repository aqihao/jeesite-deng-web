/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.test.web;

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
import com.jeesite.modules.test.entity.Test001;
import com.jeesite.modules.test.service.Test001Service;

/**
 * test_001Controller
 * @author deng
 * @version 2020-04-27
 */
@Controller
@RequestMapping(value = "${adminPath}/test/test001")
public class Test001Controller extends BaseController {

	@Autowired
	private Test001Service test001Service;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public Test001 get(String id, boolean isNewRecord) {
		return test001Service.get(id, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("test:test001:view")
	@RequestMapping(value = {"list", ""})
	public String list(Test001 test001, Model model) {
		model.addAttribute("test001", test001);
		return "modules/test/test001List";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("test:test001:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<Test001> listData(Test001 test001, HttpServletRequest request, HttpServletResponse response) {
		test001.setPage(new Page<>(request, response));
		Page<Test001> page = test001Service.findPage(test001);
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("test:test001:view")
	@RequestMapping(value = "form")
	public String form(Test001 test001, Model model) {
		model.addAttribute("test001", test001);
		return "modules/test/test001Form";
	}

	/**
	 * 保存test_001
	 */
	@RequiresPermissions("test:test001:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated Test001 test001) {
		test001Service.save(test001);
		return renderResult(Global.TRUE, text("保存test_001成功！"));
	}
	
	/**
	 * 删除test_001
	 */
	@RequiresPermissions("test:test001:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(Test001 test001) {
		test001Service.delete(test001);
		return renderResult(Global.TRUE, text("删除test_001成功！"));
	}
	
}