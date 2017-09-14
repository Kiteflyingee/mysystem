package com.kite.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kite.domain.QueryInfo;
import com.kite.entity.QueryPage;
import com.kite.entity.Student;
import com.kite.util.SqlUtils;

/**
 * 学生Dao类
 * 
 * @author KITE
 *
 */
@Repository
public class StudentDao {

	@Autowired
	private SqlSessionFactory sqlSessionFactory;

	/**
	 * 增加学生
	 * 
	 * @param student
	 */
	public void insertStudent(Student student) {
		SqlUtils.getSqlSession(sqlSessionFactory).insert("StudentNS.insertStudent", student);
	}

	/**
	 * 删除学生ByID
	 * 
	 * @param id
	 */
	public void deleteStudent(Integer id) {
		SqlUtils.getSqlSession(sqlSessionFactory).delete("StudentNS.deleteStudent", id);
	}

	/**
	 * 更新学生
	 * 
	 * @param id
	 */
	public void updateStudent(Student student) {
		SqlUtils.getSqlSession(sqlSessionFactory).delete("StudentNS.updateStudent", student);
	}

	/**
	 * 查询学生按编号
	 * 
	 * @param id
	 * @return
	 */
	public Student findStudentById(Integer id) {
		return SqlUtils.getSqlSession(sqlSessionFactory).selectOne("StudentNS.selectStudentById", id);
	}

	/**
	 * 查询学生按姓名（搜索）
	 * 
	 * @param id
	 * @return
	 */
	public List<Student> findStudentByLikeName(String name) {
		return SqlUtils.getSqlSession(sqlSessionFactory).selectList("StudentNS.selectStudentByLikeName", name);
	}

	/**
	 * 分页查询学生信息
	 * 
	 * @return
	 */
	@Deprecated
	public List<Student> findStudentsByPage(QueryPage queryPage) {
		return SqlUtils.getSqlSession(sqlSessionFactory).selectList("StudentNS.findStudentByPage", queryPage);
	}

	/**
	 * 新的分页查询学生信息(可以附带其它信息分页查询)
	 * 
	 * @return
	 */
	public List<Student> findStudentsByPage(QueryInfo queryInfo) {
		return SqlUtils.getSqlSession(sqlSessionFactory).selectList("StudentNS.findStudentsByPage", queryInfo);
	}

	/**
	 * 查询总记录数
	 * 
	 * @return 总记录数
	 */
	public int countStudents() {
		return SqlUtils.getSqlSession(sqlSessionFactory).selectOne("StudentNS.countStudents");
	}

}
