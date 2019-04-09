package com.haocai.web.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.haocai.web.mod.Cat;
import com.haocai.web.mod.Tna;
import com.haocai.web.service.Tnaservice;
@Controller
@RequestMapping("/tna")
public class Tnacon {
	@Resource
	Tnaservice tnaservice;
	
	@RequestMapping(value="/tnains",produces = "application/json; charset=utf-8")
	@ResponseBody
	public  int getEmpsWithJson(Tna ta) {
	
		int a=tnaservice.inse(ta);
	return a;
}
	
	@RequestMapping(value="/gettna",produces = "application/json; charset=utf-8")
	@ResponseBody
	public List<Tna> getcats(Tna a){
		return tnaservice.gettna(a);
		
		
		
	}
	@RequestMapping(value="/getname",produces = "application/json; charset=utf-8")
	@ResponseBody
	public List<Tna> getnames(){
		return tnaservice.getnames();
		
		
		
	}
}
