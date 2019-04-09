package com.haocai.web.controller;


import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


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
			   return 0;
		   }else {
			return 1;
		}
			
		}
}
