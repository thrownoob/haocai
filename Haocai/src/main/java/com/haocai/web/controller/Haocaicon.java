	package com.haocai.web.controller;


import java.util.List;

import javax.annotation.Resource;

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
	  public  String  getnumber(String name) {
		   
			return this.haocaiservice.getnumber(name);
		}
	
	}

