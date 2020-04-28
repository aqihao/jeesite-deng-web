/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.deng.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.deng.entity.DengStudentEntity;
import com.jeesite.modules.deng.dao.DengStudentEntityDao;

/**
 * deng_student_entityService
 * @author deng
 * @version 2020-04-27
 */
@Service
@Transactional(readOnly=true)
public class DengStudentEntityService extends CrudService<DengStudentEntityDao, DengStudentEntity> {
	
	/**
	 * 获取单条数据
	 * @param dengStudentEntity
	 * @return
	 */
	@Override
	public DengStudentEntity get(DengStudentEntity dengStudentEntity) {
		return super.get(dengStudentEntity);
	}
	
	/**
	 * 查询分页数据
	 * @param dengStudentEntity 查询条件
	 * @param dengStudentEntity.page 分页对象
	 * @return
	 */
	@Override
	public Page<DengStudentEntity> findPage(DengStudentEntity dengStudentEntity) {
		return super.findPage(dengStudentEntity);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param dengStudentEntity
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(DengStudentEntity dengStudentEntity) {
		super.save(dengStudentEntity);
	}
	
	/**
	 * 更新状态
	 * @param dengStudentEntity
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(DengStudentEntity dengStudentEntity) {
		super.updateStatus(dengStudentEntity);
	}
	
	/**
	 * 删除数据
	 * @param dengStudentEntity
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(DengStudentEntity dengStudentEntity) {
		super.delete(dengStudentEntity);
	}
	
}