package com.kite.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kite.domain.QueryInfo;
import com.kite.entity.ClazzInfo;
import com.kite.entity.QueryResult;
import com.kite.entity.Student;
import com.kite.service.ClazzInfoService;
import com.kite.service.StudentService;

/**
 * 新的主页面控制器，负责主页面MVC
 * 
 * @author KITE
 *
 */
@Controller
@RequestMapping("/main")
public class MainAction {

	@Autowired
	private StudentService studentService;

	@Autowired
	private ClazzInfoService clazzService;

	/**
	 * 注册日期转换器
	 * 
	 * @param binder
	 */
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(true);
		// 注册日期转换器，传过来的日期允许为空
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}

	/**
	 * new新版显示学生列表
	 * 
	 * @param model
	 * @param queryPage
	 * @param session
	 * @return
	 */
	@RequestMapping("liststudents")
	@ResponseBody
	public Object listStudentByPageJson(Model model, QueryInfo queryInfo) {
		// 获取页面数据并封装成pagebean对象
		QueryResult<Student> queryResult = studentService.getStudentsByPage(queryInfo);
		Map<String,Object> pageMap = new HashMap<String,Object>();
		pageMap.put("total", queryResult.getTotalNum());
		pageMap.put("rows", queryResult.getResults());
		// 存入要显示个人页面的路径
		String url = "manager/student/index.action";
		model.addAttribute("myurl", url);
//		model.addAttribute("pageBean", pageBean);
		return pageMap;
	}
	
	/**
	 * 处理添加学生
	 * 
	 * @param model
	 * @param student
	 * @return
	 */
	@RequestMapping(value = "/addstudent", method = RequestMethod.POST)
	@ResponseBody
	public String AddStudent(Model model, Student student) {
		String message = "";
		try {
			studentService.addStudent(student);
			message = "添加成功";
		} catch (Exception e) {
			message = e.getMessage();
		}
		return message;
	}
	
	/**
	 * 处理删除
	 * @param model
	 * @param id 学生编号
	 * @return 状态
	 */
	@RequestMapping("/deletestudent")
	@ResponseBody
	public String deleteStudent(Model model,Integer id){
		String message = "";
		try{
			studentService.removeStudent(id);
			message="删除成功";
		}catch (Exception e) {
			message  = e.getLocalizedMessage();
		}
		return message;
	}
	
	/**
	 * 处理修改学生
	 * 
	 * @param model
	 * @param student
	 * @return
	 */
	@RequestMapping(value = "/midifystudent", method = RequestMethod.POST)
	@ResponseBody
	public String modifyStudent(Student student) {
		String message = "";
		try {
			studentService.updateStudent(student);
			message = "修改成功";
		} catch (Exception e) {
			message = e.getMessage();
		}
		return message;
	}
	
	/**
	 * 查询学生详细信息 
	 * @param id
	 * @return
	 */
	@RequestMapping("/findstudent")
	@ResponseBody
	public Object showStudentDetail( Integer id) {
		// 首先从学生表查询出学生的信息，再获取学生的家长和作品与 课程等信息
		Student student=null;
		try {
			student = studentService.getStudentById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return student;
	}
	
	/**
	 * 查询学生详情，用于修改学生信息
	 * 
	 * @param model
	 * @param id
	 * @param session
	 * @return
	 */
	@RequestMapping("showdetail")
	public String showStudentDetail(Model model, Integer id) {
		// 首先从学生表查询出学生的信息，再获取学生的家长和作品与 课程等信息
		Student student=null;
		try {
			student = studentService.getStudentById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("student", student);
		/* 未完待写 */
		return "/WEB-INF/newjsp/modifystudent.jsp";
	}
	
	/**
	 * 处理添加课程
	 * 
	 * @param model
	 * @param clazz
	 * @return
	 */
	@RequestMapping(value = "addClazz", method = RequestMethod.POST)
	@ResponseBody
	public String addClazz(ClazzInfo clazz) {
		String message = "";
		// 设置为上线状态
		clazz.setStatus(1);
		try {
			clazzService.addClazz(clazz);
			message = "添加成功";
		} catch (Exception e) {
			message = e.getMessage();
		}
		return message;
	}
	
	/**
	 * 处理刪除课程
	 * 
	 * @param model
	 * @param clazz
	 * @return
	 */
	@RequestMapping(value = "deleteclazz", method = RequestMethod.POST)
	@ResponseBody
	public String addClazz(Integer id) {
		String message = "";
		try {
			
			message = "添加成功";
		} catch (Exception e) {
			message = e.getMessage();
		}
		return message;
	}
	
	/**
	 * 显示所有课程信息
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("/showclazz")
	public @ResponseBody Object showClazz(Model model) {
		List<ClazzInfo> list = clazzService.getAllClazz();
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("total", list.size());
		map.put("rows", list);
		return map;
	}

}
