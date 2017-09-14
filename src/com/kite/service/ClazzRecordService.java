package com.kite.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kite.dao.ClazzRecordDao;
import com.kite.entity.ClazzRecord;

@Service
public class ClazzRecordService {

	@Autowired
	private ClazzRecordDao clazzRecordDao;
	
	/**
	 * 获取课次记录（service层）
	 * @return
	 * @throws Exception 
	 */
	public List<ClazzRecord> getClazzRecord(Integer s_id) throws Exception{
		if(s_id==null||s_id<1){
			throw new Exception("获取课次失败，service");
		}
		return clazzRecordDao.getClazzRecords(s_id);
	}
	
	/**
	 * 获取摸个具体的课次信息
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public ClazzRecord getClazzRecordById(Integer id) throws Exception{
		if(id<1){
			throw new Exception("获取课次失败，service");
		}
		return clazzRecordDao.getClazzRecordById(id);
	}
	
	/**
	 * 更新课次记录
	 * @param id 课次编号
	 * @throws Exception 
	 */
	public void updateClazzRecord(Integer id) throws Exception{
		//首先检查剩余课时数
		ClazzRecord record = clazzRecordDao.getClazzRecordById(id);
		if(record.getLasthours()<1){
			throw new Exception("没有课时，打卡失败");
		}
		//没有异常则执行更新课次操作
		clazzRecordDao.updateLastHours(id);
	}
	
	/**
	 * 更新课次记录
	 * @param id 课次编号
	 * @throws Exception 
	 */
	public void updateClazzRecord(ClazzRecord clazzrecord) throws Exception{
		if(clazzrecord==null||clazzrecord.getId()==null||clazzrecord.getId()<0){
			throw new Exception("修改失败");
		}
		//没有异常则执行更新课次操作
		clazzRecordDao.updateClazzRecord(clazzrecord);
	}
	
	public void addClazzRecord(ClazzRecord clazzrecord) throws Exception{
		if(clazzrecord==null||clazzrecord.getClasshours()<1){
			throw new Exception("添加课次信息失败");
		}
		clazzRecordDao.insertClazzRecord(clazzrecord);
	}
	
	public void removeClazzRecordById(Integer id) throws Exception{
		if(id==null||id<1){
			throw new Exception("删除出错");
		}
		clazzRecordDao.deleteClazzRecord(id);
	}
}
