package com.haocai.web.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;



public interface Userservice {

	public  Map<String, Object>  logincheck(String username,String password,HttpServletRequest request);
	
}
