/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.deng.web;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import com.jeesite.modules.deng.vo.SchoolVO;
import org.apache.poi.ss.usermodel.Workbook;
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

import java.io.File;
import java.io.FileOutputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
		List<School> list = page.getList();
		for (School school1 : list) {
			Date date = school1.getCreateDate();
		}
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


	/**
	 * 导出列表数据
	 */
	@RequiresPermissions("deng:school:view")
	@RequestMapping(value = "export")
	@ResponseBody
	public void export(School school, HttpServletRequest request, HttpServletResponse response) {
		school.setPage(new Page<>(request, response));
		school.setSchoolCode("");
		Page<School> page = schoolService.findPage(school);

		ArrayList<SchoolVO> list = new ArrayList<>();
		SchoolVO vo = new SchoolVO();
		SchoolVO vo1 = new SchoolVO();
		vo.setSchedName("祁阳一中");
		vo.setsType("1");
		vo.setTriggerGroup("祁阳湘江河");
		vo.setTriggerName("黄天荡");
		vo.setDate("2020-05-01 10:52:56");
		vo1.setSchedName("祁阳二中");
		vo1.setsType("2");
		vo1.setTriggerGroup("祁阳莲子塘");
		vo1.setTriggerName("刘小中");
		vo1.setDate("2020-05-02 12:50:56");
		list.add(vo);
		list.add(vo1);

		/*try {
			//导出
//			Workbook workbook = ExcelExportUtil.exportBigExcel(new ExportParams("计算机一班学生", "学生"), School.class, page.getList());
			Workbook workbook = ExcelExportUtil.exportBigExcel(new ExportParams("计算机一班学生", "学生"), SchoolVO.class, list);
			response.reset();
			response.setContentType("application/octet-stream");
			ServletOutputStream outputStream = response.getOutputStream();
			workbook.write(outputStream);
			outputStream.flush();
			outputStream.close();
		}catch (Exception e){
			e.printStackTrace();
		}*/

		try{

			// 生成workbook 并导出
//			Workbook workbook = ExcelExportUtil.exportExcel(exportParams, School.class, page.getList());
			Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams("学生名字",  "测试"), SchoolVO.class, list);
            /*File savefile = new File("C:/Users/JustryDeng/Desktop/");
            if (!savefile.exists()) {
                boolean result = savefile.mkdirs();
                System.out.println("目录不存在，创建" + result);
            }
            FileOutputStream fos = new FileOutputStream("C:/Users/JustryDeng/Desktop/student.xls");
            workbook.write(fos);
            fos.close();*/
			String fileName = "日数据表" + ".xls";
			response.reset();
			response.addHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
			response.setContentType("application/octet-stream");
			ServletOutputStream outputStream = response.getOutputStream();
			workbook.write(outputStream);
			outputStream.flush();
			outputStream.close();
		}catch (Exception e){
			e.printStackTrace();
		}
	}
	
}