package com.kite.controller;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.kite.entity.ClazzInfo;
import com.kite.entity.ClazzRecord;
import com.kite.entity.PageBean;
import com.kite.entity.Parent;
import com.kite.entity.QueryWorks;
import com.kite.entity.Student;
import com.kite.entity.Work;
import com.kite.service.ClazzInfoService;
import com.kite.service.ClazzRecordService;
import com.kite.service.ParentService;
import com.kite.service.StudentService;
import com.kite.service.WorkService;
import com.kite.util.FileUtils;

/**
 * 学生详情页的controller
 * 
 * @author KITE
 * 
 */
@Controller
@RequestMapping("/manager/student")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@Autowired
	private ParentService parentService;

	@Autowired
	private ClazzRecordService clazzRecordService;

	@Autowired
	private ClazzInfoService clazzInfoService;

	@Autowired
	private WorkService workService;

	/**
	 * 学生详情页主页面跳转用
	 * 
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping("index")
	public String showIndex(Model model, HttpSession session, Integer id) {
		model.addAttribute("id", id);
		return "/WEB-INF/jsp/index.jsp";
	}

	@RequestMapping("right")
	public String showRight(Model model) {
		return "/WEB-INF/jsp/main_content.jsp";
	}

	@RequestMapping("left")
	public String showLeft(Model model, Integer id) {
		model.addAttribute("id", id);
		return "/WEB-INF/jsp/detail_menu.jsp";
	}

	/**
	 * 显示学生个人信息页面
	 * 
	 * @param model
	 * @param id
	 * @return
	 */
	@RequestMapping("showDetail")
	public String getStudents(Model model, Integer id) {
		Student student = null;
		try {
			student = studentService.getStudentById(id);
		} catch (Exception e) {
			model.addAttribute("message", "显示失败");
			return "/WEB-INF/jsp/message.jsp";
		}
		model.addAttribute("student", student);
		return "/WEB-INF/jsp/studentdetail.jsp";
	}

	/**
	 * 提供展示修改的页面
	 * 
	 * @param model
	 * @param id
	 * @return
	 */
	@RequestMapping("showModifyStudent")
	public String showModifyStudent(Model model, Integer id) {
		Student student = null;
		try {
			student = studentService.getStudentById(id);
		} catch (Exception e) {
			model.addAttribute("message", "显示失败");
			return "/WEB-INF/jsp/message.jsp";
		}
		String url = "manager/student/modifyStudent.action";
		model.addAttribute("url", url);
		model.addAttribute("student", student);
		return "/WEB-INF/jsp/modifystudent.jsp";
	}

	/**
	 * 处理修改学生信息
	 * 
	 * @param model
	 * @param student
	 * @return
	 */
	@RequestMapping("modifyStudent")
	public String modifyStudent(Model model, Student student) {
		String message = "";
		try {
			studentService.updateStudent(student);
			message = "修改成功";
		} catch (Exception e) {
			message = e.getLocalizedMessage();
		}
		model.addAttribute("message", message);
		return "/WEB-INF/jsp/message.jsp";
	}

	/**
	 * 显示家长信息
	 * 
	 * @param model
	 * @param id
	 * @return
	 */
	@RequestMapping("listParents")
	public String listParents(Model model, Integer id) {
		try {
			List<Parent> parents = parentService.getParents(id);
			model.addAttribute("parents", parents);
		} catch (Exception e) {
			model.addAttribute("message", e.getMessage());
			return "/WEB-INF/jsp/message.jsp";
		}
		model.addAttribute("s_id", id);
		return "/WEB-INF/jsp/listparents.jsp";
	}

	/**
	 * 删除家长信息的控制器
	 * 
	 * @param model
	 * @param id
	 * @return
	 */
	@RequestMapping("removeParent")
	public String removeParent(Model model, Integer id) {
		String message = "";
		try {
			parentService.removeParent(id);
			message = "删除成功";
		} catch (Exception e) {
			message = "删除出错";
		}
		model.addAttribute("message", message);
		return "/WEB-INF/jsp/message.jsp";
	}

	/**
	 * 展示添加家长信息页面
	 * 
	 * @param model
	 * @param id
	 * @return
	 */
	@RequestMapping("showAddParent")
	public String showAddParent(Model model, Integer id) {
		/* 加入学生编号到页面，方便隐藏表单取 */
		model.addAttribute("s_id", id);
		return "/WEB-INF/jsp/addparent.jsp";
	}

	/**
	 * 处理添加家长信息
	 * 
	 * @param model
	 * @param parent
	 * @param s_id
	 * @return
	 */
	@RequestMapping("addParent")
	public String addParent(Model model, Parent parent, Integer s_id) {
		try {
			Student student = studentService.getStudentById(s_id);
			parent.setStudent(student);
			parentService.addParent(parent);
			model.addAttribute("message", "添加家长信息成功");
		} catch (Exception e) {
			model.addAttribute("message", "添加家长信息失败");
		}
		return "/WEB-INF/jsp/message.jsp";
	}

	/**
	 * 在jsp页面显示所有报名课次信息
	 * 
	 * @param model
	 * @param id
	 *            学生标号
	 * @return
	 */
	@RequestMapping("listClazzRecords")
	public String listClazzRecord(Model model, Integer id) {
		try {
			List<ClazzRecord> clazzRecords = clazzRecordService
					.getClazzRecord(id);
			model.addAttribute("clazzRecords", clazzRecords);
			// 把学生的编号传递给jsp页面
			model.addAttribute("s_id", id);
		} catch (Exception e) {
			model.addAttribute("message", "显示课次列表出错,请查看系统日志");
			return "/WEB-INF/jsp/message.jsp";
		}
		return "/WEB-INF/jsp/listclassrecord.jsp";
	}

	/**
	 * 课次打卡
	 * 
	 * @param model
	 * @param id
	 * @return
	 */
	@RequestMapping("recordClazz")
	public String recordClazz(Model model, Integer id) {
		String message = "";
		try {
			clazzRecordService.updateClazzRecord(id);
			message = "上课记录成功！";
		} catch (Exception e) {
			message = e.getLocalizedMessage();
		}
		model.addAttribute("message", message);
		return "/WEB-INF/jsp/message.jsp";
	}

	@RequestMapping("showAddClazzRecord")
	public String showAddClazzRecord(Model model, Integer s_id) {
		// 添加表单预准备内容
		model.addAttribute("s_id", s_id);
		List<ClazzInfo> clazzes = clazzInfoService.getClazzIng();
		model.addAttribute("clazzes", clazzes);
		return "/WEB-INF/jsp/addclazzrecord.jsp";
	}

	@RequestMapping("addClazzRecord")
	public String addClazzRecord(Model model, Integer s_id, Integer c_id,
			ClazzRecord clazzrecord) {
		String message = "";
		try {
			// 把相关信息整合封装
			ClazzInfo clazzinfo = clazzInfoService.getClazzInfoById(c_id);
			Student student = studentService.getStudentById(s_id);
			clazzrecord.setClazzinfo(clazzinfo);
			clazzrecord.setStudent(student);
			clazzRecordService.addClazzRecord(clazzrecord);
			message = "添加成功";
		} catch (Exception e) {
			message = "添加失败";
		}
		model.addAttribute("message", message);
		return "/WEB-INF/jsp/message.jsp";
	}
	
	@RequestMapping("showEditClazzRecord")
	public String showEditClazzRecord(Model model, Integer id) {
		// 添加表单预准备内容
		try {
			ClazzRecord clazzrecord = clazzRecordService.getClazzRecordById(id);
			List<ClazzInfo> clazzes = clazzInfoService.getClazzIng();
			model.addAttribute("clazzes", clazzes);
			model.addAttribute("clazzrecord", clazzrecord);
		} catch (Exception e) {
			model.addAttribute("message", "发生错误");
			return "/WEB-INF/jsp/message.jsp";
		}
		return "/WEB-INF/jsp/modifyclazzrecord.jsp";
	}
	
	@RequestMapping("editClazzRecord")
	public String editClazzRecord(Model model, Integer s_id, Integer c_id,
			ClazzRecord clazzrecord) {
		String message = "";
		try {
			// 把相关信息整合封装
			ClazzInfo clazzinfo = clazzInfoService.getClazzInfoById(c_id);
			Student student = studentService.getStudentById(s_id);
			clazzrecord.setClazzinfo(clazzinfo);
			clazzrecord.setStudent(student);
			clazzRecordService.updateClazzRecord(clazzrecord);
			message = "修改成功";
		} catch (Exception e) {
			message = "修改失败";
		}
		model.addAttribute("message", message);
		return "/WEB-INF/jsp/message.jsp";
	}

	@RequestMapping("removeClazzRecord")
	public String removeClazzRecord(Model model, Integer id) {
		String message = "";
		try {
			clazzRecordService.removeClazzRecordById(id);
			message = "删除成功";
		} catch (Exception e) {
			message = e.getLocalizedMessage();
		}
		model.addAttribute("message", message);
		return "/WEB-INF/jsp/message.jsp";
	}

	@RequestMapping("listWorks")
	public String listWorks(Model model, Integer s_id, QueryWorks queryworks) {
		queryworks.setS_id(s_id);
		PageBean pagebean = workService.getWorksByPage(queryworks);
		model.addAttribute("s_id", s_id);
		try {
			Student student = studentService.getStudentById(s_id);
			model.addAttribute("student", student);
		} catch (Exception e) {
			model.addAttribute("message", "在显示作品时查找学生的出错");
			return "/WEB-INF/jsp/message.jsp";
		}
		model.addAttribute("page", pagebean);
		return "/WEB-INF/jsp/listworks.jsp";
	}
	
	/**
	 * 处理添加作品
	 * @param model
	 * @param work
	 * @param s_id
	 * @return
	 */
	@RequestMapping("addWork")
	public String addWork(Model model,Work work,Integer s_id,@RequestParam("file") MultipartFile file){
		String message="";
		try {
			Student student=studentService.getStudentById(s_id);
			String filename_ori = file.getOriginalFilename();
			//生成存储到服务器的文件名
			String filename=FileUtils.generateFileName();
			//生成文件路径,并存储到数据中
			String type=FileUtils.getFileType(filename_ori);
			filename=filename+"."+type;
			work.setFilename(filename);
			String destFilePath =FileUtils.getPath(student.getId()+"")+"\\"+filename;
			//写入到目的文件
			file.transferTo(new File(destFilePath));
			//存储数据到数据库
			work.setStudent(student);
			workService.addWork(work);
			message="添加成功,<a href='manager/student/showAddWork.action?s_id="+s_id+"'>继续添加</a>";
		} catch (Exception e) {
			message="添加失败";
		}
		model.addAttribute("message", message);
		return "/WEB-INF/jsp/message.jsp";
	}
	
	@RequestMapping("showAddWork")
	public String showAddWork(Model model,Integer s_id){
		model.addAttribute("s_id", s_id);
		return "/WEB-INF/jsp/addwork.jsp";
	}
	
	@RequestMapping("removeWork")
	public String removeWork(Model model,Integer id){
		String message ="";
		try {
			workService.removeWork(id);
			message="删除成功";
		} catch (Exception e) {
			message="删除失败";
		}
		model.addAttribute("message", message);
		return "/WEB-INF/jsp/message.jsp";
	}
}
