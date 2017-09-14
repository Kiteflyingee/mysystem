package com.kite.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.kite.entity.Admin;
/**
 * 自定义的判断登录拦截器
 * @author KITE
 *
 */
public class UserInterceptor implements HandlerInterceptor{

	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object arg2) throws Exception {
		Admin admin = (Admin) request.getSession().getAttribute("admin");
		if (admin == null) {
			response.setHeader("Content-type", "text/html;charset=UTF-8");
			response.setCharacterEncoding("UTF-8");
			String message = "登录已经过期，<a href='"+request.getContextPath()+"/index.jsp'>登录</a>";
			response.getWriter().print(message);
			return false;
		}
		return true;
	}

}
