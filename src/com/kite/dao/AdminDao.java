package com.kite.dao;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kite.entity.Admin;
import com.kite.util.SqlUtils;

@Repository
public class AdminDao {

	@Autowired
	private SqlSessionFactory sqlSessionFactory;

	public Admin findAdmin(String username) {
		return SqlUtils.getSqlSession(sqlSessionFactory).selectOne(
				"AdminNS.findAdmin", username);
	}
	
	

}
