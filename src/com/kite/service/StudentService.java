package com.kite.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kite.dao.StudentDao;
import com.kite.domain.QueryInfo;
import com.kite.entity.QueryPage;
import com.kite.entity.QueryResult;
import com.kite.entity.Student;

@Service
public class StudentService {

	@Autowired
	private StudentDao studentDao;

	/**
	 * 按编号查找学生
	 * 
	 * @param id
	 * @return
	 * @throws Exception 
	 */
	public Student getStudentById(Integer id) throws Exception {
		if (id == null)
			throw new Exception("id为空");
		Student student = studentDao.findStudentById(id);
		return student;
	}

	/**
	 * 分页查找学生信息
	 * 
	 * @param queryPage
	 * @return QueryResult
	 */
	@Deprecated
	public QueryResult<Student> getStudentByPage(QueryPage queryPage) {
		List<Student> students = studentDao.findStudentsByPage(queryPage);
		int totalNum = studentDao.countStudents();
		QueryResult<Student> queryResult = new QueryResult<Student>(students,
				totalNum);
		return queryResult;
	}
	
	/**
	 * 新的分页查找学生信息的方法
	 * @param queryPage
	 * @return QueryResult
	 */
	public QueryResult<Student> getStudentsByPage(QueryInfo queryInfo) {
		List<Student> students = studentDao.findStudentsByPage(queryInfo);
		int totalNum = studentDao.countStudents();
		QueryResult<Student> queryResult = new QueryResult<Student>(students,
				totalNum);
		return queryResult;
	}

	/**
	 * 搜索功能，按名称搜索，未实现分页
	 * 
	 * @param likeName
	 * @return QueryResult
	 */
	public QueryResult<Student> searchStudent(String likeName) {
		if (likeName == null || "".equals(likeName))
			return getStudentByPage(new QueryPage());
		int totalNum = studentDao.countStudents();
		List<Student> results = studentDao.findStudentByLikeName(likeName);
		QueryResult<Student> queryResult = new QueryResult<Student>(results,
				totalNum);
		return queryResult;
	}

	/**
	 * 添加学生
	 * 
	 * @param student
	 * @throws Exception
	 */
	public void addStudent(Student student) throws Exception {
		if (student == null) {
			throw new Exception("插入学生为空");
		}
		if (student.getName() == null || "".equals(student.getName())) {
			throw new Exception("姓名不能为空");
		}
		if (student.getSex() == null || "".equals(student.getSex())) {
			throw new Exception("性别不能为空");
		}
		if (student.getBrithday() == null) {
			throw new Exception("生日不能为空");
		}
		studentDao.insertStudent(student);
	}

	/**
	 * 移除学生
	 * 
	 * @param id
	 * @throws Exception
	 */
	public void removeStudent(Integer id) throws Exception {
		if (id == null) {
			throw new Exception("删除学生失败");
		}
		studentDao.deleteStudent(id);
	}

	/**
	 * 更新学生
	 * 
	 * @param student
	 * @throws Exception 
	 */
	public void updateStudent(Student student) throws Exception {
		if (student == null) {
			throw new Exception("没有更新信息，更新学生失败");
		}
		studentDao.updateStudent(student);
	}

}
