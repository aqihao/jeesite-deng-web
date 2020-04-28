/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.deng.entity;

import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.jeesite.common.mybatis.annotation.JoinTable;
import com.jeesite.common.mybatis.annotation.JoinTable.Type;
import com.fasterxml.jackson.annotation.JsonFormat;

import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.mybatis.annotation.Column;
import com.jeesite.common.mybatis.annotation.Table;
import com.jeesite.common.mybatis.mapper.query.QueryType;

/**
 * deng_student_entityEntity
 * @author deng
 * @version 2020-04-27
 */
@Table(name="deng_student_entity", alias="a", columns={
		@Column(name="id", attrName="id", label="id", isPK=true),
		@Column(includeEntity=DataEntity.class),
		@Column(name="name", attrName="name", label="name", queryType=QueryType.LIKE),
		@Column(name="sex", attrName="sex", label="sex"),
		@Column(name="birthday", attrName="birthday", label="birthday"),
		@Column(name="registrationdate", attrName="registrationdate", label="registrationdate"),
	}, orderBy="a.update_date DESC"
)
public class DengStudentEntity extends DataEntity<DengStudentEntity> {
	
	private static final long serialVersionUID = 1L;
	private String name;		// name
	private Integer sex;		// sex
	private Date birthday;		// birthday
	private Date registrationdate;		// registrationdate
	
	public DengStudentEntity() {
		this(null);
	}

	public DengStudentEntity(String id){
		super(id);
	}
	
	@Length(min=0, max=255, message="name长度不能超过 255 个字符")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getRegistrationdate() {
		return registrationdate;
	}

	public void setRegistrationdate(Date registrationdate) {
		this.registrationdate = registrationdate;
	}
	
}