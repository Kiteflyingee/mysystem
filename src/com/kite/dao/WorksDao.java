package com.kite.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kite.entity.QueryWorks;
import com.kite.entity.Work;
import com.kite.util.SqlUtils;

/**
 * worksdao
 * 
 * @author KITE
 * 
 */
@Repository
public class WorksDao {

	@Autowired
	private SqlSessionFactory sqlSessionFactory;

	/**
	 * 往数据库中插入作品信息
	 * 
	 * @param work
	 */
	public void insertWork(Work work) {
		SqlUtils.getSqlSession(sqlSessionFactory).insert("WorkNS.insertWork",
				work);
	}

	/**
	 * 查询作品详情（隐藏方法方便以后添加该功能）
	 * 
	 * @param id
	 * @return
	 */
	public Work findWorkById(Integer id) {
		return SqlUtils.getSqlSession(sqlSessionFactory).selectOne(
				"WorkNS.findWorkById", id);
	}

	/**
	 * 分页查询作品信息
	 * 
	 * @param queryWorks
	 * @return
	 */
	public List<Work> findWorks(QueryWorks queryWorks) {
		return SqlUtils.getSqlSession(sqlSessionFactory).selectList(
				"WorkNS.findWorks", queryWorks);
	}

	public int getTotalNum(Integer s_id) {
		return SqlUtils.getSqlSession(sqlSessionFactory).selectOne(
				"WorkNS.getTotalNum",s_id);
	}

	/**
	 * 删除作品信息
	 * 
	 * @param id
	 */
	public void deleteWorkById(Integer id) {
		SqlUtils.getSqlSession(sqlSessionFactory).delete(
				"WorkNS.deleteWorkById", id);
	}

}
