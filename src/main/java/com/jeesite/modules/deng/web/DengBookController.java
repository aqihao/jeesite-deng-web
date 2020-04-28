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
import com.jeesite.modules.deng.entity.DengBook;
import com.jeesite.modules.deng.service.DengBookService;

/**
 * deng_bookController
 * @author deng
 * @version 2020-04-27
 */
@Controller
@RequestMapping(value = "${adminPath}/deng/dengBook")
public class DengBookController extends BaseController {

	@Autowired
	private DengBookService dengBookService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public DengBook get(String id, boolean isNewRecord) {
		return dengBookService.get(id, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("deng:dengBook:view")
	@RequestMapping(value = {"list", ""})
	public String list(DengBook dengBook, Model model) {
		model.addAttribute("dengBook", dengBook);
		return "modules/deng/dengBookList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("deng:dengBook:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<DengBook> listData(DengBook dengBook, HttpServletRequest request, HttpServletResponse response) {
		dengBook.setPage(new Page<>(request, response));
		Page<DengBook> page = dengBookService.findPage(dengBook);
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("deng:dengBook:view")
	@RequestMapping(value = "form")
	public String form(DengBook dengBook, Model model) {
		model.addAttribute("dengBook", dengBook);
		return "modules/deng/dengBookForm";
	}

	/**
	 * 保存deng_book
	 */
	@RequiresPermissions("deng:dengBook:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated DengBook dengBook) {
		dengBookService.save(dengBook);
		return renderResult(Global.TRUE, text("保存deng_book成功！"));
	}
	
	/**
	 * 删除deng_book
	 */
	@RequiresPermissions("deng:dengBook:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(DengBook dengBook) {
		dengBookService.delete(dengBook);
		return renderResult(Global.TRUE, text("删除deng_book成功！"));
	}
	
}