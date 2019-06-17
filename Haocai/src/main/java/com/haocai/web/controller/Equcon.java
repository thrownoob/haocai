package com.haocai.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import com.haocai.web.mod.Equipment;

import com.haocai.web.service.Equservice;

@Controller
@RequestMapping("/equ")
public class Equcon {
	@Resource
	Equservice equservice;
	@RequestMapping(value="/equins",produces = "application/json; charset=utf-8")
	@ResponseBody
    public  int getEquWithJson(Equipment equ) {//添加设备
		


	
		return equservice.inse(equ);


		
	
	
}
	
	@RequestMapping(value="/equget",produces = "application/json; charset=utf-8")
	@ResponseBody
    public  List<Equipment> getEqueid(String eid) {//查询编号
		
		return this.equservice.getkey(eid);
	}
	
	@RequestMapping(value="/equupt",produces = "application/json; charset=utf-8")
	@ResponseBody
	  public  int  equupt(Equipment equ) {
		   
			return this.equservice.equupd(equ);
		}
	
@RequestMapping(value="/equdny",produces = "application/json; charset=utf-8")
@ResponseBody
  public  Map<String, Object>  equdny(Equipment equ,HttpServletRequest request) {//查询设备
	int page1 =Integer.parseInt(request.getParameter("page"));
	int limit1=Integer.parseInt(request.getParameter("limit"));
	    int page=limit1*(page1-1);
	     int limit=limit1;
           equ.setPage(page);
             equ.setLimit(limit);
             String msg="";
 		    int code=0;
 		    List data =this.equservice.selectByPrimaryKey(equ);
 		    int count=this.equservice.getequcount(equ);
 		   Map<String, Object> map = new HashMap<String, Object>();
		    map.put("code", code);
		    map.put("msg", msg);
		    map.put("count", count);
		    map.put("data", data);
		return map;
	}
}
