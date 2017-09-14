package com.kite.util;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class SqlUtils {
	
	/**
	 * 返回sqlSession对象
	 * @param sqlSessionFactory
	 * @return sqlSession
	 */
	public static SqlSession getSqlSession(SqlSessionFactory sqlSessionFactory){
		return sqlSessionFactory.openSession();
	}
}
