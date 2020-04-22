/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.test.entity;

import org.hibernate.validator.constraints.Length;

import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.mybatis.annotation.Column;
import com.jeesite.common.mybatis.annotation.Table;
import com.jeesite.common.mybatis.mapper.query.QueryType;

/**
 * testEntity
 * @author deng
 * @version 2019-02-27
 */
@Table(name="test", alias="a", columns={
		@Column(name="id", attrName="id", label="标识", isPK=true),
		@Column(name="name", attrName="name", label="名称", queryType=QueryType.LIKE),
	}, orderBy="a.id DESC"
)
public class Test extends DataEntity<Test> {
	
	private static final long serialVersionUID = 1L;
	private String name;		// 名称
	
	public Test() {
		this(null);
	}

	public Test(String id){
		super(id);
	}
	
	@Length(min=0, max=255, message="名称长度不能超过 255 个字符")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}