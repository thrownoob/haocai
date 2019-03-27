package com.haocai.web.controller;

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
		
		int a=equservice.inse(equ);
		System.out.println(a);
	return a;
}
}
