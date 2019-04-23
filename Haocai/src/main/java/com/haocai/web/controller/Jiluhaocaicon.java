package com.haocai.web.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Iterator;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.codehaus.jackson.map.type.MapType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.haocai.web.mod.JiluHaocai;
import com.haocai.web.service.Jiluhaocaiservice;
@Controller
@RequestMapping("/jiluhaocai")
public class Jiluhaocaicon {
	@Resource
	Jiluhaocaiservice jiluhaocaiservice;
	@RequestMapping(value="/getjiluhaocai",produces = "application/json; charset=utf-8")
	@ResponseBody
	  public  Map<String, Object>  equdny(JiluHaocai jiluhaocai,HttpServletRequest request) {
		
		
		List list = new ArrayList();
		   
      String page =request.getParameter("page");
      String limit=request.getParameter("limit");
      
   System.out.println(page);
		    String msg="";
		    int code=0;
		    List data =this.jiluhaocaiservice.getjiluhaocai(jiluhaocai);
		    int count=data.size();
		    System.out.println(count);
		    Map<String, Object> map = new HashMap<String, Object>();
		    map.put("code", code);
		    map.put("msg", msg);
		    map.put("count", count);
		    map.put("data", data);
		    
		    
	   
		
		  
			return map;
		}
	@RequestMapping(value="/addjilu",produces = "application/json; charset=utf-8")
	@ResponseBody
	  public  int  addjilu(JiluHaocai jiluhaocai,HttpServletRequest request) {
		   
			return this.jiluhaocaiservice.addjilu(jiluhaocai, request);
		}
	
	@RequestMapping(value="/upgcname",produces = "application/json; charset=utf-8")
	@ResponseBody
	  public  int  upgcanme(String name) {
		   
			return this.jiluhaocaiservice.upgcname(name);
		}
}
