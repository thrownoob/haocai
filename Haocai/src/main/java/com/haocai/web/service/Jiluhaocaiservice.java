package com.haocai.web.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.haocai.web.mod.JiluHaocai;

public interface Jiluhaocaiservice {
	 public List<JiluHaocai> getjiluhaocai(JiluHaocai jiluhaocai);
	 
	 public  int addjilu(JiluHaocai jiluHaocai ,HttpServletRequest request);
	 
	 public int upgcname(String name);
}
