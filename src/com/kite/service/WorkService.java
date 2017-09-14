package com.kite.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kite.dao.WorksDao;
import com.kite.entity.PageBean;
import com.kite.entity.QueryWorks;
import com.kite.entity.Work;

@Service
public class WorkService {

	@Autowired
	private WorksDao worksDao;
	
	
	/**
	 * 分页查询作品信息
	 * @param queryworks
	 * @return
	 * @throws Exception
	 */
	public PageBean getWorksByPage(QueryWorks queryworks){
		if(queryworks==null){
			throw new RuntimeException("service层分页查询works出错");
		}
		List<Work> works=worksDao.findWorks(queryworks);
		int totalNum =worksDao.getTotalNum(queryworks.getS_id());
		PageBean pagebean = new PageBean();
		pagebean.setCurrentPage(queryworks.getCurrentPage());
		pagebean.setPageSize(queryworks.getSize());
		pagebean.setResults(works);
		pagebean.setTotalNum(totalNum);
		return pagebean;
	}
	
	/**
	 * 添加作品
	 * @param work
	 * @throws Exception
	 */
	public void addWork(Work work) throws Exception{
		if(work==null){
			throw new Exception("service层在处理添加作品信息出错");
		}
		worksDao.insertWork(work);
	}
	
	/**
	 * 删除作品
	 * @param id
	 * @throws Exception
	 */
	public void removeWork(Integer id) throws Exception{
		if(id==null||id<1){
			throw new Exception("service层在处理删除作品信息出错");
		}
		worksDao.deleteWorkById(id);
	}
}
