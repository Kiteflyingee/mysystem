package com.kite.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kite.dao.AdminDao;
import com.kite.entity.Admin;
import com.kite.util.MD5Utils;

@Service
public class AdminService {

	@Autowired
	private AdminDao adminDao;
	
	public boolean checkAdmin(Admin admin){
		if(admin==null||admin.getUsername()==null||admin.getUsername().equals("")){
			return false;
		}
		Admin findAdmin = adminDao.findAdmin(admin.getUsername());
		if(findAdmin==null){
			return false;
		}
		String password = MD5Utils.encrypt(admin.getPassword());
		if(findAdmin.getPassword().equals(password)){
			return true;
		}
		return false;
	}
}
