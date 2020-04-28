/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.deng.entity;

import org.hibernate.validator.constraints.Length;

import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.mybatis.annotation.Column;
import com.jeesite.common.mybatis.annotation.Table;
import com.jeesite.common.mybatis.mapper.query.QueryType;

import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.persistence.Transient;
import java.util.List;

/**
 * deng_course_entityEntity
 * @author deng
 * @version 2020-04-27
 */
@Table(name="deng_course_entity", alias="a", columns={
		@Column(name="id", attrName="id", label="id", isPK=true),
		@Column(name="name", attrName="name", label="name", queryType=QueryType.LIKE),
		@Column(name="math_teacher", attrName="mathTeacher", label="math_teacher"),
		@Column(includeEntity=DataEntity.class),
	}, orderBy="a.update_date DESC"
)
public class DengCourseEntity extends DataEntity<DengCourseEntity> {
	
	private static final long serialVersionUID = 1L;
	private String name;		// name
	private DengTeacherEntity mathTeacher;		// math_teacher

	private List<DengStudentEntity> students;
	
	public DengCourseEntity() {
		this(null);
	}

	public DengCourseEntity(String id){
		super(id);
	}
	
	@Length(min=0, max=255, message="name长度不能超过 255 个字符")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@OneToOne(fetch = FetchType.LAZY)
	public DengTeacherEntity getMathTeacher() {
		return mathTeacher;
	}

	public void setMathTeacher(DengTeacherEntity mathTeacher) {
		this.mathTeacher = mathTeacher;
	}

	@Transient
	public List<DengStudentEntity> getStudents() {
		return students;
	}

	public void setStudents(List<DengStudentEntity> students) {
		this.students = students;
	}
}