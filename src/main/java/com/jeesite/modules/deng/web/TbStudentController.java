/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.deng.web;

import com.jeesite.common.config.Global;
import com.jeesite.common.entity.Page;
import com.jeesite.common.lang.DateUtils;
import com.jeesite.common.lang.StringUtils;
import com.jeesite.common.web.BaseController;
import com.jeesite.modules.deng.entity.School;
import com.jeesite.modules.deng.entity.TbStudent;
import com.jeesite.modules.deng.entity.TbTeacher;
import com.jeesite.modules.deng.service.ImportService;
import com.jeesite.modules.deng.service.TbStudentService;
import com.jeesite.modules.deng.vo.TbStudentVO;
import com.jeesite.modules.sys.entity.User;
import com.jeesite.modules.sys.utils.UserUtils;
import com.jeesite.modules.utils.CookieUtils;
import com.jeesite.modules.utils.JsonUtils;
import com.jeesite.modules.utils.PoiUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.session.Session;
import org.jsoup.select.Evaluator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
//import redis.clients.jedis.Jedis;

import javax.mail.search.SearchException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.lang.reflect.Constructor;
import java.util.*;

import static java.lang.Thread.sleep;

/**
 * tb_studentController
 * @author deng
 * @version 2019-05-22
 */
@Controller
@RequestMapping(value = "${adminPath}/deng/tbStudent")
public class TbStudentController extends BaseController {

	@Autowired
	private TbStudentService tbStudentService;
	@Autowired(required=true)
	private ImportService importService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public TbStudent get(String sno, boolean isNewRecord) {
		return tbStudentService.get(sno, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("deng:tbStudent:view")
	@RequestMapping(value = {"list", ""})
	public String list(TbStudent tbStudent, Model model) {
		model.addAttribute("tbStudent", tbStudent);
		return "modules/deng/tbStudentList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("deng:tbStudent:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<TbStudent> listData(TbStudent tbStudent, HttpServletRequest request, HttpServletResponse response) {
		tbStudent.setPage(new Page<>(request, response));
		Page<TbStudent> page = tbStudentService.findPage(tbStudent);
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("deng:tbStudent:view")
	@RequestMapping(value = "form")
	public String form(TbStudent tbStudent, Model model) {
		model.addAttribute("tbStudent", tbStudent);
		return "modules/deng/tbStudentForm";
	}

	/**
	 * 保存tb_student
	 */
	@RequiresPermissions("deng:tbStudent:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated TbStudent tbStudent, @RequestParam(value = "file", required = false) MultipartFile file, HttpServletRequest request, HttpServletResponse response) {
		if(null != file && file.getSize() != 0){
			String path = request.getSession().getServletContext().getRealPath("upload")+"/imgs/test";
			String fileNames = file.getOriginalFilename();
			//fileNames.substring(fileNames.lastIndexOf("."), fileNames.length());//获取文件名中以.分割的最后字符串

			String fileName = DateUtils.getDate("yyyyMMddHH")+fileNames.substring(fileNames.lastIndexOf("."), fileNames.length());
			File targetFile = new File(path, fileName);
			if(!targetFile.exists()){
				targetFile.mkdirs();
			}

			//保存
			try {
				file.transferTo(targetFile);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		tbStudentService.save(tbStudent);
		return renderResult(Global.TRUE, text("保存tb_student成功！"));
	}
	
	/**
	 * 删除tb_student
	 */
	@RequiresPermissions("deng:tbStudent:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(TbStudent tbStudent) {
		tbStudentService.delete(tbStudent);
		return renderResult(Global.TRUE, text("删除tb_student成功！"));
	}

	/**
	 * 导出tb_student
	 */
	@RequiresPermissions("deng:tbStudent:edit")
	@RequestMapping(value = "export")
	@ResponseBody
	public String export(TbStudent tbStudent) {
		tbStudentService.delete(tbStudent);
		return renderResult(Global.TRUE, text("删除tb_student成功！"));
	}

	@ResponseBody
	@RequestMapping("poi")
	public void poi(HttpServletResponse response, HttpServletRequest request){
//		agent.setEnable(true);
		String[] rowName = {"序号","姓名","年龄","性别","学号"};
		List<Object[]> dataList = new ArrayList<Object[]>();

		TbStudent tbStudent = new TbStudent();
		Page<TbStudent> page = tbStudentService.findPage(new Page<>(request, response),tbStudent);
		List<TbStudent> list1 = page.getList();


		for (int i = 0; i < list1.size(); i++) {
			Object[] element = {null,list1.get(i).getName(),list1.get(i).getAge(),list1.get(i).getSex(),list1.get(i).getSno()};
			dataList.add(element);
		}
		PoiUtils utils = new PoiUtils("测试", rowName, dataList );
		try {
			utils.export(response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@RequiresPermissions("deng:tbStudent:view")
	@RequestMapping("bar")
	public String bar(Model model,String bar) {
		model.addAttribute("bar", bar);
		return "modules/deng/bar";
	}

	@ResponseBody
	@RequestMapping("bars")
	public String bars(){
		//设置初始百分比
		String bar = "0";
		try
		{
			//模拟这段代码完成后向前台返回进度条百分比为20%
			sleep(2000);//延时2秒
			bar = "20";
			//调用另外一个线程把bar数据返回到页面中-无法实现
			bar(null,bar);//一旦调用,后面的方法无法继续
			sleep(2000);
			bar = "30";
			bar(null,bar);
			sleep(4000);
			bar = "80";
			bar(null,bar);
			sleep(3000);
			bar = "100";
			bar(null,bar);
		}
		catch(Exception e){
			//todo
			e.getMessage();
		}
		return bar;
	}

	/**
	 * 通过json返回数据
	 * */
	@ResponseBody
	@RequestMapping(value = "details")
	public String jsonTest(TbStudent tbStudent){
		TbStudent student = tbStudentService.get(tbStudent);
		TbStudentVO vo = new TbStudentVO();
		vo.setAge(student.getAge());
		vo.setName(student.getName());
		vo.setSex(student.getSex());
		vo.setSno(student.getSno());
		test1(vo);
		String toJson = JsonUtils.objectToJson(vo);
		return toJson;
	}

	/**
	 * 通过json返回数据列表
	 * */
	@ResponseBody
	@RequestMapping(value = "jsonList")
	public String jsonList(TbStudent tbStudent, HttpServletRequest request, HttpServletResponse response){
		tbStudent.setPage(new Page<>(request, response));
		Page<TbStudent> page = tbStudentService.findPage(tbStudent);
		String toJson = JsonUtils.objectToJson(page);
		return toJson;
	}

	/**
	 * 得到cookie返回数据
	 * */
	@ResponseBody
	@RequestMapping(value = "cookie")
	public String cookie(String cookieName,HttpServletRequest request, HttpServletResponse response){
		CookieUtils.getCookieValue(request,cookieName);
		return "";
	}

	/**
	 * redis测试
	 * */
	/*@ResponseBody
	@RequestMapping(value = "redis")
	public String redis(HttpServletRequest request, HttpServletResponse response){
		Jedis jedis = new Jedis("localhost");
		System.out.println("连接成功");
		// 查看服务是否运行
		System.out.println("服务正在运行: " + jedis.ping());
		jedis.set("name","刘备");
		jedis.set("age","55");
		String name = jedis.get("name");
		StringUtils.isNoneEmpty();
		User user = UserUtils.getUser();
		Session session = UserUtils.getSession();
		jedis.set("users",user.getUserName());
		return jedis.get("users");
	}

	*//**
	 * redis测试
	 * *//*
	@ResponseBody
	@RequestMapping(value = "redisOne")
	public List<String> redisOne(HttpServletRequest request, HttpServletResponse response){
		Jedis jedis = new Jedis("localhost");
		jedis.set("age","667");
		jedis.append("age","+888");
		School school = new School();
		school.setSchedName("一中");
		School school1 = new School();
		school1.setSchedName("二中");
		School school2 = new School();
		school2.setSchedName("三中");
		String str1 = school.getSchedName();
		String str2 = school1.getSchedName();
		String str3 = school2.getSchedName();
		jedis.lpush("list",str1,str2,str3,"4","5");
		System.out.println(jedis.lrange("list",0,4));
		List<String> list = jedis.lrange("list", 0, 4);
		return list;
	}*/

	/**
	 * 通过json返回数据
	 * */
	@ResponseBody
	@RequestMapping(value = "test")
	public String test(){
		TbStudentVO vo = new TbStudentVO();
		vo.setAge(11);
		vo.setName("张三");
		vo.setSex("妖");
		vo.setSno("1");
		test1(vo);
		String toJson = JsonUtils.objectToJson(vo);
		return toJson;
	}

	@ResponseBody
	@RequestMapping(value = "test1")
	public void test1(TbStudentVO vo){
		vo.setAge(999);
	}

	@ResponseBody
	@RequestMapping(value = "sort")
	public String sort(TbStudentVO vo){
		TbStudent student1 = new TbStudent("2", "zhanFei", "男", 25);
		TbStudent student2 = new TbStudent("3", "liuBei", "妖", 30);
		TbStudent student3 = new TbStudent("1", "guanYu", "女", 28);
		List<TbStudent> list = new ArrayList<>();
		list.add(student1);
		list.add(student2);
		list.add(student3);
		//按学号升序,这种排序方法,重写Compartator中的compare方法
		/*Collections.sort(list, new Comparator<TbStudent>() {
			@Override
			public int compare(TbStudent o1, TbStudent o2) {
				Integer valueOf1 = Integer.valueOf(o1.getSno());
				Integer valueOf2 = Integer.valueOf(o2.getSno());
				return valueOf1-valueOf2;
			}
		});*/
		//第二种排序方法,让需要排序的类实现
		Collections.sort(list);
		return JsonUtils.objectToJson(list);
	}

	@ResponseBody
	@RequestMapping(value = "dates")
	public Integer dates(String date1,String date2,String dateType) throws SearchException {
		Integer integer = com.jeesite.modules.utils.DateUtils.compareDate(date1, date2, dateType);

		try {
			Class aClass = Class.forName("com.jeesite.modules.deng.entity.TbTeacher");
			System.out.println("**********************所有公有构造方法*********************************");
			Constructor[] constructors = aClass.getConstructors();
			for(Constructor c : constructors){
				System.out.println(c);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return integer;
	}

	@RequestMapping(value = "importData")
	public String importData(Model model) throws SearchException {
		model.addAttribute("tbStudent", "123");
		return "modules/deng/importForm";
	}

	//导入excel
	@RequestMapping(value = "import", method= RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> importExcel(@RequestParam(value="file",required = false) MultipartFile file, HttpServletRequest request, HttpServletResponse response){
		Map<String, Object> map = new HashMap<String, Object>();
		String result = importService.readExcelFile(file);
		map.put("message", result);
		return map;
	}
}