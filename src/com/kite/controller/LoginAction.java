package com.kite.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kite.entity.Admin;
import com.kite.service.AdminService;

@Controller
public class LoginAction {
	
	
	@Autowired
	private AdminService adminService;
	/**
	 * 登录页面
	 * 
	 * @param model
	 * @param admin
	 * @param session
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(Model model, Admin admin, HttpSession session,
			HttpServletResponse response) {
		boolean flag = adminService.checkAdmin(admin);
		if (flag == true) {
			session.setAttribute("admin", admin);
			Cookie cookie = new Cookie("JSESSIONID", session.getId());
			cookie.setMaxAge(30 * 60);
			response.addCookie(cookie);
			return "redirect:/base/goToJsp/newjsp/main.action";
//			return "redirect:/manager/main/index.action";
		} else {
			String message = "账号或密码错误,<a href='index.jsp'>重新登录</a>";
			model.addAttribute("message", message);
			return "/WEB-INF/jsp/message.jsp";
		}
	}
}
