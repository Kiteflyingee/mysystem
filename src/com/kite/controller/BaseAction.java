package com.kite.controller;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 这个是一个公共控制器，负责web的一些通用或者常用的功能。
 * 
 * @author KITE
 *
 */
@Controller
@RequestMapping("/base")
public class BaseAction {

	/**
	 * 这个属性用于程序初始加载的一些必要数据的存储
	 */
	@Autowired
	private ServletContext servletContext;

	/**
	 * 一个基本的web-inf目录下jsp跳转的控制器
	 * @param folder
	 * @param file
	 * @return 跳转的jsp页面
	 */
	@RequestMapping("/goToJsp/{folder}/{file}")
	public String goToJSP(@PathVariable String folder, @PathVariable String file) {
		return "/WEB-INF/" + folder + "/" + file + ".jsp";
	}


}
