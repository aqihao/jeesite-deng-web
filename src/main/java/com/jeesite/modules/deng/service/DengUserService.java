/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.deng.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.deng.entity.DengUser;
import com.jeesite.modules.deng.dao.DengUserDao;

/**
 * deng学校Service
 * @author deng
 * @version 2019-01-28
 */
@Service
@Transactional(readOnly=true)
public class DengUserService extends CrudService<DengUserDao, DengUser> {
	
	/**
	 * 获取单条数据
	 * @param dengUser
	 * @return
	 */
	@Override
	public DengUser get(DengUser dengUser) {
		return super.get(dengUser);
	}
	
	/**
	 * 查询分页数据
	 * @param dengUser 查询条件
	 * @param dengUser.page 分页对象
	 * @return
	 */
	@Override
	public Page<DengUser> findPage(DengUser dengUser) {
		return super.findPage(dengUser);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param dengUser
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(DengUser dengUser) {
		super.save(dengUser);
	}
	
	/**
	 * 更新状态
	 * @param dengUser
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(DengUser dengUser) {
		super.updateStatus(dengUser);
	}
	
	/**
	 * 删除数据
	 * @param dengUser
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(DengUser dengUser) {
		super.delete(dengUser);
	}
	
}