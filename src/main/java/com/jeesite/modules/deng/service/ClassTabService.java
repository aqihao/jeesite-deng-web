/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.deng.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.deng.entity.ClassTab;
import com.jeesite.modules.deng.dao.ClassTabDao;

/**
 * class_tabService
 * @author deng
 * @version 2019-01-29
 */
@Service
@Transactional(readOnly=true)
public class ClassTabService extends CrudService<ClassTabDao, ClassTab> {
	
	/**
	 * 获取单条数据
	 * @param classTab
	 * @return
	 */
	@Override
	public ClassTab get(ClassTab classTab) {
		return super.get(classTab);
	}
	
	/**
	 * 查询分页数据
	 * @param classTab 查询条件
	 * @param classTab.page 分页对象
	 * @return
	 */
	@Override
	public Page<ClassTab> findPage(ClassTab classTab) {
		return super.findPage(classTab);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param classTab
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(ClassTab classTab) {
		super.save(classTab);
	}
	
	/**
	 * 更新状态
	 * @param classTab
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(ClassTab classTab) {
		super.updateStatus(classTab);
	}
	
	/**
	 * 删除数据
	 * @param classTab
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(ClassTab classTab) {
		super.delete(classTab);
	}
	
}