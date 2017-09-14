package com.kite.util;

import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import com.kite.entity.Admin;

public class WebUtils {
	
	/**
	 * 改方法只是作为用户未登录返回的页面用，并不能返回页面(弃用)
	 * @param model
	 * @param session
	 * @return
	 */
	@Deprecated
	public static String checkLogin(Model model, HttpSession session) {
		Admin admin = (Admin) session.getAttribute("admin");
		if (admin == null) {
			String message = "登录已经过期，<a href='index.jsp'>登录</a>";
			model.addAttribute("message", message);
			return "/WEB-INF/jsp/message.jsp";
		}
		return null;
	}

}
