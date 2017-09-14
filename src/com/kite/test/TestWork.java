package com.kite.test;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.kite.dao.WorksDao;
import com.kite.entity.QueryWorks;
import com.kite.entity.Work;

public class TestWork {

	@Test
	public void testGetDao() {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"spring.xml");
		SqlSessionFactory sqlSession = (SqlSessionFactory) context
				.getBean("SqlSessionFactoryBean");
		WorksDao dao = (WorksDao) context.getBean("worksDao");
		Work work = dao.findWorkById(1);
		QueryWorks qw = new QueryWorks();
		qw.setS_id(1);
		List works = dao.findWorks(qw);
		System.out.println();
	}

}
