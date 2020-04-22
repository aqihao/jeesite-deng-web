/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.deng.service;

import java.util.List;

import com.jeesite.common.service.ServiceException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.deng.entity.School;
import com.jeesite.modules.deng.dao.SchoolDao;

/**
 * 学校管理表Service
 * @author deng
 * @version 2019-01-28
 */
@Service
@Transactional(readOnly=true)
public class SchoolService extends CrudService<SchoolDao, School> {
	
	/**
	 * 获取单条数据
	 * @param school
	 * @return
	 */
	@Override
	public School get(School school) {
		return super.get(school);
	}
	
	/**
	 * 查询分页数据
	 * @param school 查询条件
	 * @return
	 */
	@Override
	public Page<School> findPage(School school) {
		return super.findPage(school);
	}


	/**
	 * 保存数据（插入或更新）
	 * @param school
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(School school) {
		super.save(school);
	}
	
	/**
	 * 更新状态
	 * @param school
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(School school) {
		super.updateStatus(school);
	}
	
	/**
	 * 删除数据
	 * @param school
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(School school) {
		super.delete(school);
	}
	
}