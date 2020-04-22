/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.deng.dao;

import com.jeesite.common.dao.CrudDao;
import com.jeesite.common.mybatis.annotation.MyBatisDao;
import com.jeesite.modules.deng.entity.TbStudent;

/**
 * tb_studentDAO接口
 * @author deng
 * @version 2019-05-22
 */
@MyBatisDao
public interface TbStudentDao extends CrudDao<TbStudent> {
	
}