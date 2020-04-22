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

import java.util.ArrayList;
import java.util.List;

/**
 * tb_teacherEntity
 * @author deng
 * @version 2019-05-23
 */
@Table(name="tb_teacher", alias="a", columns={
		@Column(name="sno", attrName="sno", label="编号", isPK=true),
		@Column(name="name", attrName="name", label="姓名", queryType=QueryType.LIKE),
		@Column(name="sex", attrName="sex", label="性别"),
		@Column(name="age", attrName="age", label="年龄"),
		@Column(name="picture", attrName="picture", label="照片"),
		@Column(name="resume", attrName="resume", label="个人简历"),
	}, orderBy="a.sno DESC"
)
public class TbTeacher extends DataEntity<TbTeacher> {
	
	private static final long serialVersionUID = 1L;
	private String sno;		// 编号
	private String name;		// 姓名
	private String sex;		// 性别
	private Integer age;		// 年龄
	private String picture;		// 照片
	private String resume;		// 个人简历

	private List<TbStudent> students = new ArrayList<>();
	
	public TbTeacher() {
		this(null);
	}

	public TbTeacher(String id){
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
	
	@Length(min=0, max=500, message="照片长度不能超过 500 个字符")
	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}
	
	@Length(min=0, max=500, message="个人简历长度不能超过 500 个字符")
	public String getResume() {
		return resume;
	}

	public void setResume(String resume) {
		this.resume = resume;
	}

	public List<TbStudent> getStudents() {
		return students;
	}

	public void setStudents(List<TbStudent> students) {
		this.students = students;
	}
}