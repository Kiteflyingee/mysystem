package com.kite.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kite.entity.LearnGoal;

@Deprecated
@Repository
public class LearnGoalDao {

	@Autowired
	private SqlSessionFactory sqlSessionFactory;
	/**
	 * 不知道是一个还是多个。先暂时不写 
	 * @return 查询的学习目标
	 */
	public List<LearnGoal> findLearnGoals(){

		return null;
	}
	
	/**
	 * 增加学习进度
	 * @param learngoal
	 */
	public void addLearnGoal(LearnGoal learngoal){
		
	}
	
	/**
	 * 删除学习进度
	 * @param id
	 */
	public void deleteLearnGoal(Integer id){
		
	}
	
	/**
	 * 修改学习进度
	 * @param learngoal
	 */
	public void updateLearnGoal(LearnGoal learngoal){
		
	}
}
