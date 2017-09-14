package com.kite.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kite.dao.ClazzDao;
import com.kite.entity.ClazzInfo;

@Service
public class ClazzInfoService {

	@Autowired
	private ClazzDao clazzDao;

	public void addClazz(ClazzInfo clazz) throws Exception {
		if (clazz == null || "".equals(clazz.getName())) {
			throw new Exception("课程为空无法添加");
		}
		clazzDao.insertClazz(clazz);
	}

	/**
	 * 修改课程状态
	 * @param clazzInfo
	 * @throws Exception 
	 */
	public void modifyClazzStatus(ClazzInfo clazzInfo) throws Exception {
		if(clazzInfo==null||clazzInfo.getStatus()==null||clazzInfo.getId()==null){
			throw new Exception("修改课程状态异常，请重试");
		}
		clazzDao.updateClazzStatus(clazzInfo);
	}
	/**
	 * 获取所有课程信息
	 * @return list
	 */
	public List<ClazzInfo> getAllClazz(){
		return clazzDao.findAllClazz();
	}
	
	public ClazzInfo getClazzInfoById(Integer c_id) throws Exception{
		if(c_id==null||c_id<1){
			throw new Exception("查找课程信息发生错误");
		}
		return clazzDao.findClazzById(c_id);
	}
	
	/**
	 * 获取启用的课程信息
	 * @return list
	 */
	public List<ClazzInfo> getClazzIng(){
		return clazzDao.findClazzIng();
	}
	
}
