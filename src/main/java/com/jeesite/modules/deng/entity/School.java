/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.deng.entity;


import cn.afterturn.easypoi.excel.annotation.Excel;
import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.mybatis.annotation.Column;
import com.jeesite.common.mybatis.annotation.Table;
import com.jeesite.modules.utils.IDUtils;

import java.util.Date;

/**
 * 学校管理表Entity
 * @author deng
 * @version 2019-01-28
 */
@Table(name="school", alias="a", columns={
		@Column(name="school_code", attrName="schoolCode", label="学校编码", isPK=true),
		@Column(name="sched_name", attrName="schedName", label="学校名称"),
		@Column(name="trigger_name", attrName="triggerName", label="校长名"),
		@Column(name="trigger_group", attrName="triggerGroup", label="地址"),
		@Column(name="s_type", attrName="sType", label="类型"),
	}, orderBy="a.sched_name DESC, a.trigger_name DESC, a.trigger_group DESC"
)
public class School extends DataEntity<School> {
	
	private static final long serialVersionUID = 1L;
	private String schoolCode;
	@Excel(name="学校名称",orderNum="2",width=30,isStatistics=true,suffix="%",replace = { "男_1", "女_2" })
	private String schedName;
	@Excel(name="校长名",orderNum="0")
	private String triggerName;
	@Excel(name="学校地址",orderNum="1",width=30)
	private String triggerGroup;
	private String sType;
	
	public School() {
		this.schoolCode = IDUtils.getUUID32();//todo 此处有问题,会导致查询分页时查不到数据,应放到插入数据时生成,延后处理
		this.createDate = new Date();
	}

	public School(String schedName, String triggerName, String triggerGroup){
		this.schedName = schedName;
		this.triggerName = triggerName;
		this.triggerGroup = triggerGroup;
	}
	
	public String getSchedName() {
		return schedName;
	}

	public void setSchedName(String schedName) {
		this.schedName = schedName;
	}
	
	public String getTriggerName() {
		return triggerName;
	}

	public void setTriggerName(String triggerName) {
		this.triggerName = triggerName;
	}
	
	public String getTriggerGroup() {
		return triggerGroup;
	}

	public void setTriggerGroup(String triggerGroup) {
		this.triggerGroup = triggerGroup;
	}
	
	public String getSchoolCode() {
		return schoolCode;
	}

	public void setSchoolCode(String schoolCode) {
		this.schoolCode = schoolCode;
	}

	public String getsType() {
		return sType;
	}

	public void setsType(String sType) {
		this.sType = sType;
	}
}