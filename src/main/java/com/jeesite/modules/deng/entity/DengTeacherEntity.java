/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.deng.entity;

import org.hibernate.validator.constraints.Length;

import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.mybatis.annotation.Column;
import com.jeesite.common.mybatis.annotation.Table;
import com.jeesite.common.mybatis.mapper.query.QueryType;

/**
 * deng_teacher_entityEntity
 * @author deng
 * @version 2020-04-27
 */
@Table(name="deng_teacher_entity", alias="a", columns={
		@Column(name="id", attrName="id", label="id", isPK=true),
		@Column(name="name", attrName="name", label="姓名", queryType=QueryType.LIKE),
		@Column(includeEntity=DataEntity.class),
	}, orderBy="a.update_date DESC"
)
public class DengTeacherEntity extends DataEntity<DengTeacherEntity> {
	
	private static final long serialVersionUID = 1L;
	private String name;		// 姓名
	
	public DengTeacherEntity() {
		this(null);
	}

	public DengTeacherEntity(String id){
		super(id);
	}
	
	@Length(min=0, max=255, message="姓名长度不能超过 255 个字符")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}