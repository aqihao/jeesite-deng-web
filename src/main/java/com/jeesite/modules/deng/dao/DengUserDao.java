/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.deng.dao;

import com.jeesite.common.dao.CrudDao;
import com.jeesite.common.mybatis.annotation.MyBatisDao;
import com.jeesite.modules.deng.entity.DengUser;

/**
 * deng学校DAO接口
 * @author deng
 * @version 2019-01-28
 */
@MyBatisDao
public interface DengUserDao extends CrudDao<DengUser> {
	
}