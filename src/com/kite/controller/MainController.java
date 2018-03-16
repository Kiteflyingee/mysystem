package com.kite.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kite.entity.ClazzInfo;
import com.kite.entity.PageBean;
import com.kite.entity.QueryPage;
import com.kite.entity.QueryResult;
import com.kite.entity.Student;
import com.kite.service.ClazzInfoService;
import com.kite.service.StudentService;

@Controller
@RequestMapping("manager/main")
public class MainController {

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
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		dateFormat.setLenient(true);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}

	/**
	 * 显示主页面
	 * 
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping("/index")
	public String showWelcome(Model model, HttpSession session) {
		return "/WEB-INF/jsp/welcome.jsp";
	}

	@RequestMapping("/left")
	public String showLeft(Model model) {
		return "/WEB-INF/jsp/main_menu.jsp";
	}

	@RequestMapping("/right")
	public String showRight(Model model) {
		return "/WEB-INF/jsp/main_content.jsp";
	}

	/**
	 * 显示学生列表分页显示
	 * 
	 * @return 转发JSP页面
	 */
	@RequestMapping("listStudents")
	public String listStudentByPage(Model model, int currentPage, HttpSession session) {
		model.addAttribute("url", "manager/main/listStudents.action");
		if (currentPage < 1) {
			currentPage = 1;
		}
		QueryPage queryPage = new QueryPage();
		queryPage.setCurrentPage(currentPage);
		// 获取页面数据并封装成pagebean对象
		QueryResult<Student> queryResult = studentService.getStudentByPage(queryPage);
		PageBean pageBean = new PageBean();
		pageBean.setResults(queryResult.getResults());
		pageBean.setCurrentPage(currentPage);
		pageBean.setPageSize(queryPage.getSize());
		pageBean.setTotalNum(queryResult.getTotalNum());
		// 存入要显示个人页面的路径
		String url = "manager/student/index.action";
		model.addAttribute("myurl", url);
		model.addAttribute("pageBean", pageBean);
		return "/WEB-INF/jsp/liststudent.jsp";
	}

	/**
	 * 进入学生个人管理页面
	 * 
	 * @param model
	 * @param id
	 * @param session
	 * @return
	 */
	@RequestMapping("showDetail")
	public String showStudentDetail(Model model, Integer id, HttpSession session) {
		// 首先从学生表查询出学生的信息，再获取学生的家长和作品与 课程等信息
		Student student = null;
		try {
			student = studentService.getStudentById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("student", student);
		/* 未完待写 */
		return "/WEB-INF/jsp/showdetail.jsp";
	}

	/**
	 * 显示添加学生页面
	 * 
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping("showAddStudent")
	public String showAddStudent(Model model, HttpSession session) {
		String url = "manager/main/addStudent.action";
		model.addAttribute("url", url);
		return "/WEB-INF/jsp/addstudent.jsp";
	}

	/**
	 * 处理添加学生
	 * 
	 * @param model
	 * @param student
	 * @param session
	 * @return
	 */
	@Deprecated
	@RequestMapping(value = "/addStudent", method = RequestMethod.POST)
	public String AddStudent(Model model, Student student, HttpSession session) {
		String message = "";
		try {
			studentService.addStudent(student);
			message = "添加成功";
		} catch (Exception e) {
			message = e.getMessage();
		}
		model.addAttribute("message", message);
		return "/WEB-INF/jsp/message.jsp";
	}

	/**
	 * 显示所有课程的页面
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("showClazz")
	public String showClazz(Model model) {
		List<ClazzInfo> list = clazzService.getAllClazz();
		model.addAttribute("clazzs", list);
		return "/WEB-INF/jsp/listclazz.jsp";
	}

	/**
	 * 显示添加课程页面
	 * 
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping("showAddClazz")
	public String showAddClazz(Model model, HttpSession session) {
		model.addAttribute("url", "manager/main/addClazz.action");
		return "/WEB-INF/jsp/addclazz.jsp";
	}

	/**
	 * 处理添加课程
	 * 
	 * @param model
	 * @param clazz
	 * @return
	 */
	@RequestMapping(value = "addClazz", method = RequestMethod.POST)
	public String addClazz(Model model, ClazzInfo clazz) {
		String message = "";
		// 设置为上线状态
		clazz.setStatus(1);
		try {
			clazzService.addClazz(clazz);
			message = "添加成功";
		} catch (Exception e) {
			message = e.getMessage();
		}
		model.addAttribute("message", message);
		return "/WEB-INF/jsp/message.jsp";
	}

	@Deprecated
	@RequestMapping("deleteStudent")
	public String deleteStudent(Model model, Integer id) {
		String message = "";
		try {
			studentService.removeStudent(id);
			message = "删除成功";
		} catch (Exception e) {
			message = e.getLocalizedMessage();
		}
		model.addAttribute("message", message);
		return "/WEB-INF/jsp/message.jsp";
	}

	@RequestMapping("changeStatus")
	public String changeStatus(Model model, Integer id, Integer status) {
		ClazzInfo clazzInfo;
		try {
			clazzInfo = clazzService.getClazzInfoById(id);
			clazzInfo.setStatus(status);
			clazzService.modifyClazzStatus(clazzInfo);
		} catch (Exception e) {
			model.addAttribute("message", "修改课程状态发生错误");
			return "/WEB-INF/jsp/message.jsp";
		}
		return "/manager/main/showClazz.action";
	}
}
