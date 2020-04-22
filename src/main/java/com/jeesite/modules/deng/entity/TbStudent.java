/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.deng.entity;

import javax.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.mybatis.annotation.Column;
import com.jeesite.common.mybatis.annotation.Table;
import com.jeesite.common.mybatis.mapper.query.QueryType;

/**
 * tb_studentEntity
 * @author deng
 * @version 2019-05-22
 */
@Table(name="tb_student", alias="a", columns={
		@Column(name="sno", attrName="sno", label="学号", isPK=true),
		@Column(name="name", attrName="name", label="姓名", queryType=QueryType.LIKE),
		@Column(name="sex", attrName="sex", label="性别"),
		@Column(name="age", attrName="age", label="年龄"),
	}, orderBy="a.sno DESC"
)
public class TbStudent extends DataEntity<TbStudent> implements Comparable<TbStudent>{
	
	private static final long serialVersionUID = 1L;
	private String sno;		// 学号
	private String name;		// 姓名
	private String sex;		// 性别
	private Integer age;		// 年龄
	
	public TbStudent() {
		this(null);
	}

	public TbStudent(String sno,String name,String sex,int age) {
		this.sno = sno;
		this.name = name;
		this.sex = sex;
		this.age = age;
	}

	public TbStudent(String id){
		super(id);
	}
	
	public String getSno() {
		return sno;
	}

	public void setSno(String sno) {
		this.sno = sno;
	}
	
	@NotBlank(message="姓名不能为空")
	@Length(min=0, max=64, message="姓名长度不能超过 64 个字符")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Length(min=0, max=1, message="性别长度不能超过 1 个字符")
	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}
	
	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public int compareTo(TbStudent emp) {
		/*按员工编号正序排序*/
//		return Integer.valueOf(this.getSno())-Integer.valueOf(emp.getSno());
		/*按员工编号逆序排序*/
		//return emp.getEmpno()-this.getEmpno();
		/*按员工姓名正序排序*/
		//return this.getEname().compareTo(emp.getEname());
		/*按员工姓名逆序排序*/
		return emp.getName().compareTo(this.getName());
	}
	
}