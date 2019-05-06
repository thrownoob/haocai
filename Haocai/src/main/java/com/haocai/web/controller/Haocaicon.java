	package com.haocai.web.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.haocai.web.mod.Haocai;
import com.haocai.web.service.Haocaiservice;


@Controller
@RequestMapping("/hao")
public class Haocaicon {
	@Resource
	Haocaiservice haocaiservice;
	@RequestMapping(value="/gethaocaibyname",produces = "application/json; charset=utf-8")
	@ResponseBody
	  public  int  getbyname(String name) {
		   if(this.haocaiservice.getbyname(name)==null) {
			   return 1;
		   }else {
			return 0;
		}
	}
		   @RequestMapping(value="/getallhaocaibyname",produces = "application/json; charset=utf-8")
			@ResponseBody
			  public  List<Haocai>  getallhaocai(String name) {
				 return this.haocaiservice.getallhaocai(name);
		}
	@RequestMapping(value="/addhaocai",produces = "application/json; charset=utf-8")
	@ResponseBody
	public  int  addhaocai(Haocai haocai) {
		
		
		return this.haocaiservice.addHaocai(haocai);
		
	}
	
	@RequestMapping(value="/uphaocai",produces = "application/json; charset=utf-8")
	@ResponseBody
	public  int  uphaocai(Haocai haocai) {
		
		
		return this.haocaiservice.uphaocainumberup(haocai);
		
	}
	@RequestMapping(value="/downhaocai",produces = "application/json; charset=utf-8")
	@ResponseBody
	public  int  downhaocai(Haocai haocai) {
		
		
		return this.haocaiservice.uphaocainumberdown(haocai);
		
	}
	@RequestMapping(value="/getname",produces = "application/json; charset=utf-8")
	@ResponseBody
	public  List<Haocai>  getname() {
		
		
		return this.haocaiservice.getname();
		
	}
	@RequestMapping(value="/getnumberforname",produces = "application/json; charset=utf-8")
	@ResponseBody
	  public  String  getnumber(String name,HttpServletRequest request) {
		   
			String number= this.haocaiservice.getnumber(name);
			String cnumber=request.getParameter("cnumber");
			if(number !=null) {
				if(Integer.parseInt(number)>=Integer.parseInt(cnumber)) {
					return "1";
				}
				return "2";
			}else {
				return "3";
			}
			
		}
	
	   @RequestMapping(value="/getnumberpage",produces = "application/json; charset=utf-8")
			@ResponseBody
			  public  Map<String, Object>  getnumberpage(Haocai haocai,HttpServletRequest request) {
		   
		   int page1 =Integer.parseInt(request.getParameter("page"));
			int limit1=Integer.parseInt(request.getParameter("limit"));
			int page=limit1*(page1-1);
			int limit=limit1;
	      haocai.setPage(page);
	      haocai.setLimit(limit);
	      System.out.println(haocai);
	            String msg="";
			    int code=0;
			    List data =this.haocaiservice.gethaocainumber(haocai);
			    int count=this.haocaiservice.getcountnumber(haocai);
			    System.out.println(count);
			    Map<String, Object> map = new HashMap<String, Object>();
			    map.put("code", code);
			    map.put("msg", msg);
			    map.put("count", count);
			    map.put("data", data);
			    
			    
		   
			
			  
				return map;
				 
		}
	
	}

