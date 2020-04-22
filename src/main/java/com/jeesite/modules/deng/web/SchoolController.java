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
import com.jeesite.modules.deng.entity.School;
import com.jeesite.modules.deng.service.SchoolService;

/**
 * 学校管理表Controller
 * @author deng
 * @version 2019-01-28
 */
@Controller
@RequestMapping(value = "${adminPath}/deng/school")
public class SchoolController extends BaseController {

	@Autowired
	private SchoolService schoolService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public School get(String schedName, String triggerName, String triggerGroup, boolean isNewRecord) {
		return schoolService.get(new Class<?>[]{String.class, String.class, String.class},
				new Object[]{schedName, triggerName, triggerGroup}, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("deng:school:view")
	@RequestMapping(value = {"list", ""})
	public String list(School school, Model model) {
		model.addAttribute("school", school);
		model.addAttribute("yes", "yes001");
		return "modules/deng/schoolList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("deng:school:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<School> listData(School school, HttpServletRequest request, HttpServletResponse response) {
		school.setPage(new Page<>(request, response));
		school.setSchoolCode("");
		Page<School> page = schoolService.findPage(school);
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("deng:school:view")
	@RequestMapping(value = "form")
	public String form(School school, Model model) {
		model.addAttribute("school", school);
		return "modules/deng/schoolForm";
	}

	/**
	 * 保存学校管理,新增＂XX＂成功!
	 */
	@RequiresPermissions("deng:school:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated School school) {
		schoolService.save(school);
		return renderResult(Global.TRUE, text("保存学校管理,新增"+school.getSchedName()+"成功!成功！"));
	}
	
	/**
	 * 删除学校管理,新增＂XX＂成功!
	 */
	@RequiresPermissions("deng:school:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(School school) {
		schoolService.delete(school);
		return renderResult(Global.TRUE, text("删除学校管理,新增＂XX＂成功!成功！"));
	}
	
}