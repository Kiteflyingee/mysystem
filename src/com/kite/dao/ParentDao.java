package com.kite.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kite.entity.Parent;
import com.kite.util.SqlUtils;

/**
 * 操作父母信息的dao
 * 
 * @author KITE
 * 
 */
@Repository
public class ParentDao {

	@Autowired
	private SqlSessionFactory sqlSessionFactory;

	/**
	 * 添加家长信息
	 */
	public void insertParent(Parent parent) {
		SqlUtils.getSqlSession(sqlSessionFactory).insert(
				"ParentNS.insertParent", parent);
	}

	/**
	 * 不查询对应学生的信息（也没有必要查询）
	 * 
	 * @param student_id
	 * @return
	 */
	public List<Parent> findParents(Integer student_id) {
		return SqlUtils.getSqlSession(sqlSessionFactory).selectList(
				"ParentNS.findParents", student_id);
	}

	/**
	 * 更新家长信息
	 * 
	 * @param parent
	 */
	public void updateParent(Parent parent) {
		SqlUtils.getSqlSession(sqlSessionFactory).update(
				"ParentNS.updateParent", parent);
	}

	/**
	 * 删除家长信息
	 * @param id
	 */
	public void deleteParent(Integer id) {
		SqlUtils.getSqlSession(sqlSessionFactory).delete(
				"ParentNS.deleteParent", id);
	}

}
