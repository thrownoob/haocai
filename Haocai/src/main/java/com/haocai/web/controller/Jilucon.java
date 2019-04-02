package com.haocai.web.controller;

import java.util.List;

import javax.annotation.Resource;

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
public int jiluins(Jilu jilu) {
	int a=jiluservice.jiluins(jilu);
	return a;
}
@RequestMapping(value="/sejilu",produces = "application/json; charset=utf-8")
@ResponseBody
public List<Jilu> sejilu(String a){
	
	return jiluservice.sejilu(a);
	
}
}
