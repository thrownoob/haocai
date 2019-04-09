package com.haocai.web.controller;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.haocai.web.service.Userservice;

@Controller
public class Usercon {
 
	@Resource
	Userservice userservice;
	@RequestMapping(value="/login",produces = "application/json; charset=utf-8")
	@ResponseBody
	public Map<String,Object> login(String username,String password,HttpServletRequest request){
	
		  return userservice.logincheck(username, password, request);
    
	}
	}

