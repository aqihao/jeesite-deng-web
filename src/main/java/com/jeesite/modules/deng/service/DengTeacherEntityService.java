/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.deng.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.deng.entity.DengTeacherEntity;
import com.jeesite.modules.deng.dao.DengTeacherEntityDao;

/**
 * deng_teacher_entityService
 * @author deng
 * @version 2020-04-27
 */
@Service
@Transactional(readOnly=true)
public class DengTeacherEntityService extends CrudService<DengTeacherEntityDao, DengTeacherEntity> {
	
	/**
	 * 获取单条数据
	 * @param dengTeacherEntity
	 * @return
	 */
	@Override
	public DengTeacherEntity get(DengTeacherEntity dengTeacherEntity) {
		return super.get(dengTeacherEntity);
	}
	
	/**
	 * 查询分页数据
	 * @param dengTeacherEntity 查询条件
	 * @param dengTeacherEntity.page 分页对象
	 * @return
	 */
	@Override
	public Page<DengTeacherEntity> findPage(DengTeacherEntity dengTeacherEntity) {
		return super.findPage(dengTeacherEntity);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param dengTeacherEntity
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(DengTeacherEntity dengTeacherEntity) {
		super.save(dengTeacherEntity);
	}
	
	/**
	 * 更新状态
	 * @param dengTeacherEntity
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(DengTeacherEntity dengTeacherEntity) {
		super.updateStatus(dengTeacherEntity);
	}
	
	/**
	 * 删除数据
	 * @param dengTeacherEntity
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(DengTeacherEntity dengTeacherEntity) {
		super.delete(dengTeacherEntity);
	}
	
}