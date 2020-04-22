/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.deng.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.deng.entity.TbTeacher;
import com.jeesite.modules.deng.dao.TbTeacherDao;
import com.jeesite.modules.file.utils.FileUploadUtils;

/**
 * tb_teacherService
 * @author deng
 * @version 2019-05-23
 */
@Service
@Transactional(readOnly=true)
public class TbTeacherService extends CrudService<TbTeacherDao, TbTeacher> {
	
	/**
	 * 获取单条数据
	 * @param tbTeacher
	 * @return
	 */
	@Override
	public TbTeacher get(TbTeacher tbTeacher) {
		return super.get(tbTeacher);
	}
	
	/**
	 * 查询分页数据
	 * @param tbTeacher 查询条件
	 * @param tbTeacher.page 分页对象
	 * @return
	 */
	@Override
	public Page<TbTeacher> findPage(TbTeacher tbTeacher) {
		return super.findPage(tbTeacher);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param tbTeacher
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(TbTeacher tbTeacher) {
		super.save(tbTeacher);
		// 保存上传图片
		FileUploadUtils.saveFileUpload(tbTeacher.getId(), "tbTeacher_image");
		// 保存上传附件
		FileUploadUtils.saveFileUpload(tbTeacher.getId(), "tbTeacher_file");
	}
	
	/**
	 * 更新状态
	 * @param tbTeacher
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(TbTeacher tbTeacher) {
		super.updateStatus(tbTeacher);
	}
	
	/**
	 * 删除数据
	 * @param tbTeacher
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(TbTeacher tbTeacher) {
		super.delete(tbTeacher);
	}
	
}