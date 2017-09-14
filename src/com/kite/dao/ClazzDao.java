package com.kite.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kite.entity.ClazzInfo;
import com.kite.util.SqlUtils;

/**
 * 课程Dao
 * 
 * @author KITE
 * 
 */
@Repository
public class ClazzDao {
	@Autowired
	private SqlSessionFactory sqlSessionFactory;

	public void insertClazz(ClazzInfo clazz) {
		SqlUtils.getSqlSession(sqlSessionFactory).insert("ClazzNS.insertClazz",
				clazz);
	}

	public ClazzInfo findClazzById(Integer id) {
		return SqlUtils.getSqlSession(sqlSessionFactory).selectOne(
				"ClazzNS.findClazzById", id);
	}

	public List<ClazzInfo> findAllClazz() {
		return SqlUtils.getSqlSession(sqlSessionFactory).selectList(
				"ClazzNS.findAllClazz");
	}
	
	public List<ClazzInfo> findClazzIng() {
		return SqlUtils.getSqlSession(sqlSessionFactory).selectList(
				"ClazzNS.findClazzIng");
	}
	
	@Deprecated   
	public void deleteClazz(Integer id) {
		SqlUtils.getSqlSession(sqlSessionFactory).delete(
				"ClazzNS.deleteClazz", id);
	}
	
	public void updateClazzStatus(ClazzInfo clazzInfo){
		SqlUtils.getSqlSession(sqlSessionFactory).update(
				"ClazzNS.updateClazzStatus", clazzInfo);
	}
}
