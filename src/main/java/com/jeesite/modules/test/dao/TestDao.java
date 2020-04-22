/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.test.dao;

import com.jeesite.common.dao.CrudDao;
import com.jeesite.common.mybatis.annotation.MyBatisDao;
import com.jeesite.modules.test.entity.Test;

/**
 * testDAO接口
 * @author deng
 * @version 2019-02-27
 */
@MyBatisDao
public interface TestDao extends CrudDao<Test> {
	
}