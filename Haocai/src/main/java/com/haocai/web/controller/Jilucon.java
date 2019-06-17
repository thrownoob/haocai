package com.haocai.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.haocai.web.mod.Jilu;
import com.haocai.web.service.Jiluservice;

@Controller
@RequestMapping("/jilu")
public class Jilucon {
@Resource
Jiluservice jiluservice;
@RequestMapping(value="/jiluins",produces = "application/json; charset=utf-8")
@ResponseBody
public int jiluins(Jilu jilu,HttpServletRequest request) {
	int a=jiluservice.jiluins(jilu,request);
	return a;
}
@RequestMapping(value="/sejilu",produces = "application/json; charset=utf-8")
@ResponseBody
public  Map<String, Object> sejilu(Jilu jilu,HttpServletRequest request){
	 int page1 =Integer.parseInt(request.getParameter("page"));
		int limit1=Integer.parseInt(request.getParameter("limit"));
		int page=limit1*(page1-1);
		int limit=limit1;
   jilu.setPage(page);
   jilu.setLimit(limit);
   System.out.println(jilu);
         String msg="";
		    int code=0;
		    List data =this.jiluservice.sejilu(jilu);
		    int count=this.jiluservice.getcount(jilu);
		    System.out.println(count);
		    Map<String, Object> map = new HashMap<String, Object>();
		    map.put("code", code);
		    map.put("msg", msg);
		    map.put("count", count);
		    map.put("data", data);
		    
		    
	   
		
		  
			return map;

	
}
}
