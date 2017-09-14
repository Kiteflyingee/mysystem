package com.kite.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kite.entity.ClazzRecord;
import com.kite.util.SqlUtils;

@Repository
public class ClazzRecordDao {

	@Autowired
	private SqlSessionFactory sqlSessionFactory;

	/**
	 * 添加学生课程信息（学生报名课程）
	 * 
	 * @param clazzrecord
	 */
	public void insertClazzRecord(ClazzRecord clazzrecord) {
		SqlUtils.getSqlSession(sqlSessionFactory).insert(
				"ClazzRecordNS.insertClazzRecord", clazzrecord);
	}

	/**
	 * 删除学生课程课次信息
	 * 
	 * @param id
	 */
	public void deleteClazzRecord(Integer id) {
		SqlUtils.getSqlSession(sqlSessionFactory).delete(
				"ClazzRecordNS.deleteClazzRecordById", id);
	}

	/**
	 * 修改学生课程信息（提供接口，供扩展用）
	 * @param clazzrecord
	 */
	public void updateClazzRecord(ClazzRecord clazzrecord) {
		SqlUtils.getSqlSession(sqlSessionFactory).update(
				"ClazzRecordNS.updateClazzRecord", clazzrecord);
	}
	
	/**
	 * 
	 * 更新剩余课时数(Service层做判断剩余课时数为多少，不能小于1)
	 * @param id
	 */
	public void updateLastHours(Integer id){
		SqlUtils.getSqlSession(sqlSessionFactory).update(
				"ClazzRecordNS.updateLastHours", id);
	}

	/**
	 * 找出学生的课程信息
	 * @param s_id
	 *            学生编号
	 * @return 学生所有报名课程的信息
	 */
	public List<ClazzRecord> getClazzRecords(Integer s_id) {
		return SqlUtils.getSqlSession(sqlSessionFactory).selectList(
				"ClazzRecordNS.findClazzRecords", s_id);
	}
	
	
	/**
	 * 获得某一课程记录信息，用于在service层做判断使用
	 * @param id
	 * @return
	 */
	public ClazzRecord getClazzRecordById(Integer id){
		return SqlUtils.getSqlSession(sqlSessionFactory).selectOne(
				"ClazzRecordNS.findClazzRecordById", id);
	}

}
