/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.deng.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.deng.entity.TbStudent;
import com.jeesite.modules.deng.dao.TbStudentDao;

/**
 * tb_studentService
 * @author deng
 * @version 2019-05-22
 */
@Service
@Transactional(readOnly=true)
public class TbStudentService extends CrudService<TbStudentDao, TbStudent> {
	
	/**
	 * 获取单条数据
	 * @param tbStudent
	 * @return
	 */
	@Override
	public TbStudent get(TbStudent tbStudent) {
		return super.get(tbStudent);
	}
	
	/**
	 * 查询分页数据
	 * @param tbStudent 查询条件
	 * @param tbStudent.page 分页对象
	 * @return
	 */
	@Override
	public Page<TbStudent> findPage(TbStudent tbStudent) {
		return super.findPage(tbStudent);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param tbStudent
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(TbStudent tbStudent) {
		super.save(tbStudent);
	}
	
	/**
	 * 更新状态
	 * @param tbStudent
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(TbStudent tbStudent) {
		super.updateStatus(tbStudent);
	}
	
	/**
	 * 删除数据
	 * @param tbStudent
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(TbStudent tbStudent) {
		super.delete(tbStudent);
	}
	
}