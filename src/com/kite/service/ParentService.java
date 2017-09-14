package com.kite.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kite.dao.ParentDao;
import com.kite.entity.Parent;
import com.kite.entity.Student;

@Service
public class ParentService {

	@Autowired
	private ParentDao parentDao;
	
	/**
	 * 添加家长信息
	 * @param parent
	 * @throws Exception
	 */
	public void addParent(Parent parent) throws Exception{
		Student student = parent.getStudent();
		if(parent==null||student==null){
			throw new Exception("添加家长信息失败，service");
		}
		if(student.getId()==null||student.getId()<1){
			throw new Exception("添加家长信息失败，service");
		}
		try{
			parentDao.insertParent(parent);
		}catch (Exception e) {
			throw new RuntimeException("添加家长信息失败，service调用dao时发生");
		}
		
	}
	
	/**
	 * 删除家长信息
	 */
	public void removeParent(Integer id) throws Exception{
		if(id==null||id<1){
			throw new Exception("删除家长信息失败，service");
		}
		try{
			parentDao.deleteParent(id);
		}catch (Exception e) {
			throw new Exception("删除家长信息失败，service调用dao时发生");
		}
	}
	
	/**
	 * 修改家长信息
	 * @param parent
	 * @throws Exception
	 */
	public void modifyParent(Parent parent) throws Exception{
		if(parent==null||parent.getId()==null||parent.getId()<1){
			throw new Exception("更新家长信息失败，service");
		}
		try{
			parentDao.updateParent(parent);
		}catch (Exception e) {
			throw new RuntimeException("删除家长信息失败，service调用dao时发生");
		}
	}
	
	public List<Parent> getParents(Integer s_id) throws Exception{
		if(s_id==null||s_id<1){
			throw new Exception("获取家长信息失败，service");
		}
		try{
			return parentDao.findParents(s_id);
		}catch (Exception e) {
			throw new RuntimeException("删除家长信息失败，service调用dao时发生");
		}
	}
}
