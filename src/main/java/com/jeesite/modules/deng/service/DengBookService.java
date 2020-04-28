/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.deng.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.deng.entity.DengBook;
import com.jeesite.modules.deng.dao.DengBookDao;
import com.jeesite.modules.file.utils.FileUploadUtils;

/**
 * deng_bookService
 * @author deng
 * @version 2020-04-27
 */
@Service
@Transactional(readOnly=true)
public class DengBookService extends CrudService<DengBookDao, DengBook> {
	
	/**
	 * 获取单条数据
	 * @param dengBook
	 * @return
	 */
	@Override
	public DengBook get(DengBook dengBook) {
		return super.get(dengBook);
	}
	
	/**
	 * 查询分页数据
	 * @param dengBook 查询条件
	 * @param dengBook.page 分页对象
	 * @return
	 */
	@Override
	public Page<DengBook> findPage(DengBook dengBook) {
		return super.findPage(dengBook);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param dengBook
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(DengBook dengBook) {
		super.save(dengBook);
		// 保存上传图片
		FileUploadUtils.saveFileUpload(dengBook.getId(), "dengBook_image");
		// 保存上传附件
		FileUploadUtils.saveFileUpload(dengBook.getId(), "dengBook_file");
	}
	
	/**
	 * 更新状态
	 * @param dengBook
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(DengBook dengBook) {
		super.updateStatus(dengBook);
	}
	
	/**
	 * 删除数据
	 * @param dengBook
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(DengBook dengBook) {
		super.delete(dengBook);
	}
	
}