/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.deng.dao;

import com.jeesite.common.dao.CrudDao;
import com.jeesite.common.mybatis.annotation.MyBatisDao;
import com.jeesite.modules.deng.entity.DengBook;

/**
 * deng_bookDAO接口
 * @author deng
 * @version 2020-04-27
 */
@MyBatisDao
public interface DengBookDao extends CrudDao<DengBook> {
	
}