package com.haocai.web.controller;

import java.util.List;

import javax.annotation.Resource;

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
    public  int getEquWithJson(Equipment equ) {
		
	if	(equservice.equsec(equ.getEid())==0)
	{
	
		return equservice.inse(equ);
	}
	return 0;
		
	
	
}
	
	@RequestMapping(value="/equget",produces = "application/json; charset=utf-8")
	@ResponseBody
    public  List<Equipment> getEqueid() {
		
		return this.equservice.getkey();
	}
	
	@RequestMapping(value="/equupt",produces = "application/json; charset=utf-8")
	@ResponseBody
	  public  int  equupt(Equipment equ) {
		   
			return this.equservice.equupd(equ);
		}
	
@RequestMapping(value="/equdny",produces = "application/json; charset=utf-8")
@ResponseBody
  public  List<Equipment>  equdny(Equipment equ) {
	   
		return this.equservice.getdyn(equ);
	}
}
