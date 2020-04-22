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
import com.jeesite.modules.deng.entity.DengUser;
import com.jeesite.modules.deng.service.DengUserService;

/**
 * deng学校Controller
 * @author deng
 * @version 2019-01-28
 */
@Controller
@RequestMapping(value = "deng/dengUser")
public class DengUserController extends BaseController {

	@Autowired
	private DengUserService dengUserService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public DengUser get(String userCode, boolean isNewRecord) {
		return dengUserService.get(userCode, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("deng:dengUser:view")
	@RequestMapping(value = {"list", ""})
	public String list(DengUser dengUser, Model model) {
		System.out.println("111");
		model.addAttribute("dengUser", dengUser);
		return "modules/deng/dengUserList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("deng:dengUser:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<DengUser> listData(DengUser dengUser, HttpServletRequest request, HttpServletResponse response) {
		dengUser.setPage(new Page<>(request, response));
		Page<DengUser> page = dengUserService.findPage(dengUser);
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("deng:dengUser:view")
	@RequestMapping(value = "form")
	public String form(DengUser dengUser, Model model) {
		model.addAttribute("dengUser", dengUser);
		return "modules/deng/dengUserForm";
	}

	/**
	 * 保存保存＂某某＂成功
	 */
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated DengUser dengUser) {
		dengUserService.save(dengUser);
		return renderResult(Global.TRUE, text("保存＂"+dengUser.getLoginCode()+"＂成功！"));
	}
	
	/**
	 * 删除保存＂某某＂成功
	 */
	@RequiresPermissions("deng:dengUser:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(DengUser dengUser) {
		dengUserService.delete(dengUser);
		return renderResult(Global.TRUE, text("删除保存＂某某＂成功成功！"));
	}
	
}