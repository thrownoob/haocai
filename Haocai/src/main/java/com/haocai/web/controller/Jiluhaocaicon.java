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
		   
		int page1 =Integer.parseInt(request.getParameter("page"));
		int limit1=Integer.parseInt(request.getParameter("limit"));
		int page=limit1*(page1-1);
		int limit=limit1;
      jiluhaocai.setPage(page);
      jiluhaocai.setLimit(limit);
      System.out.println(jiluhaocai);
            String msg="";
		    int code=0;
		    List data =this.jiluhaocaiservice.getjiluhaocai(jiluhaocai);
		    int count=this.jiluhaocaiservice.getcount(jiluhaocai);
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
