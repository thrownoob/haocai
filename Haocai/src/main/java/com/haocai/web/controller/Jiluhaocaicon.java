package com.haocai.web.controller;

import java.util.List;

import javax.annotation.Resource;

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
	  public  List<JiluHaocai>  equdny(JiluHaocai jiluhaocai) {
		   
			return this.jiluhaocaiservice.getjiluhaocai(jiluhaocai);
		}
}
