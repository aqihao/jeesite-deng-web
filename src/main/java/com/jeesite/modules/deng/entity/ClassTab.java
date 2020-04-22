/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.deng.entity;

import com.jeesite.common.entity.BaseEntity;
import org.hibernate.validator.constraints.Length;

import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.mybatis.annotation.Column;
import com.jeesite.common.mybatis.annotation.Table;
import com.jeesite.common.mybatis.mapper.query.QueryType;

/**
 * class_tabEntity
 * @author deng
 * @version 2019-01-29
 */
@Table(name="class_tab", alias="a", columns={
		@Column(name="id", attrName="id", label="id", isPK=true),
		@Column(name="name", attrName="name", label="name", queryType=QueryType.LIKE),
		@Column(name="num", attrName="num", label="num"),
		@Column(name="teacher_name", attrName="teacherName", label="teacher_name", queryType=QueryType.LIKE),
		@Column(includeEntity=DataEntity.class),
		@Column(name="del_flag", attrName="delFlag", label="del_flag"),
	}, orderBy="a.update_date DESC"
)
public class ClassTab extends DataEntity<ClassTab> {
	
	private static final long serialVersionUID = 1L;
	private String name;		// name
	private Long num;		// num
	private String teacherName;		// teacher_name
	private String delFlag;		// del_flag
	
	public ClassTab() {
		this(null);
	}

	public ClassTab(String id){
		super(id);
	}
	
	@Length(min=0, max=10, message="name长度不能超过 10 个字符")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Long getNum() {
		return num;
	}

	public void setNum(Long num) {
		this.num = num;
	}
	
	@Length(min=0, max=5, message="teacher_name长度不能超过 5 个字符")
	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	
	@Length(min=0, max=255, message="del_flag长度不能超过 255 个字符")
	public String getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}
	
}