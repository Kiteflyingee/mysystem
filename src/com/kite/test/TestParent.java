package com.kite.test;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.kite.dao.ParentDao;
import com.kite.entity.Parent;

public class TestParent {

	@Test
	public void testfind1() {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"spring.xml");
		SqlSessionFactory sqlSession = (SqlSessionFactory) context
				.getBean("SqlSessionFactoryBean");
		ParentDao dao = (ParentDao) context.getBean("parentDao");
		List<Parent> parents =  dao.findParents(1);
		System.out.println();
	}
}
