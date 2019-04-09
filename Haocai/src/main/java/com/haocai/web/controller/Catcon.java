package com.haocai.web.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import com.haocai.web.mod.Cat;

import com.haocai.web.service.Catservice;

@Controller
@RequestMapping("/cat")
public class Catcon {
	@Resource
	Catservice catservice;
	@RequestMapping(value="/catins",produces = "application/json; charset=utf-8")
	@ResponseBody
	public  int getEmpsWithJson(Cat cat) {
		
		int a=catservice.inse(cat);
		System.out.println(a);
	return a;
}
	
	@RequestMapping(value="/catsec",produces = "application/json; charset=utf-8")
	@ResponseBody
	public List<Cat> getcats(){
		return catservice.getkey();
		
		
		
	}
	@RequestMapping(value="/getallCats",produces = "application/json; charset=utf-8")
	@ResponseBody
	public List<Cat> getallCats(Cat cat){
		return catservice.getcatdn(cat);
		
		
		
	}

}
