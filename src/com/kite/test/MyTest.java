package com.kite.test;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.Date;

import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.kite.dao.StudentDao;
import com.kite.entity.QueryPage;
import com.kite.entity.Student;
import com.kite.util.FileUtils;
import com.kite.util.MD5Utils;

public class MyTest {

	@Test
	public void testFileName() {
		String str = "a.jpg";
		System.out.println(FileUtils.getFileName(str));
	}

	@Test
	public void testFileType() {
		String str = "a.jpg";
		String str1 = "a";
		System.out.println(FileUtils.getFileType(str));
		// System.out.println(FileUtils.getFileType(filename));
		System.out.println(FileUtils.getFileType(str1));
	}

	@Test
	public void testPage() {
		StudentDao dao = new StudentDao();
		QueryPage page = new QueryPage();
		page.setCurrentPage(1);
		dao.findStudentsByPage(page);
		System.out.println();
	}

	@Test
	public void testMd5() throws UnsupportedEncodingException{
		System.out.println(MD5Utils.encrypt("root"));
		System.out.println(MD5Utils.encrypt("1717"));
	}
	
	@Test
	public void testAdd(){
		Student student = new Student();
		student.setName("nan");
		student.setSex("nan");
		student.setAge(11);
		student.setBrithday(new Date());
		ApplicationContext context =
				new ClassPathXmlApplicationContext("spring.xml");
		SqlSessionFactory sqlSession= (SqlSessionFactory) context.getBean("SqlSessionFactoryBean");
		StudentDao dao = (StudentDao) context.getBean("studentDao");
//		dao.insertStudent(student);
		dao.findStudentById(2);
//		List list =dao.findStudentByLikeName("测试");
		System.out.println();
	}
	
	@Test
	public void testMakeDir(){
		System.out.println(FileUtils.getPath("name"));
	}
}
