package com.haocai.web.serviceimp;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.haocai.web.UUID.Uuid;
import com.haocai.web.dao.JiluHaocaiDAO;
import com.haocai.web.mod.JiluHaocai;
import com.haocai.web.mod.User;
import com.haocai.web.service.Jiluhaocaiservice;
@Service
public class Jiluhaocaiimp implements Jiluhaocaiservice {
@Resource
private JiluHaocaiDAO jiluhaocaidao;
	public List<JiluHaocai> getjiluhaocai(JiluHaocai jiluhaocai) {
		// TODO Auto-generated method stub
		return this.jiluhaocaidao.getjiluhaocai(jiluhaocai);
	}
	public int addjilu(JiluHaocai jiluHaocai,HttpServletRequest request) {
	
		HttpSession   session   =   request.getSession(); 
		System.out.println(session);
		Object a=session.getAttribute("user");
		HashMap<String, Object> map=new HashMap<String, Object>();
		map.put("tid", Uuid.getUUID());
	   	  map.put("name", jiluHaocai.getName());
	   	  map.put("cnumber", jiluHaocai.getCnumber());
	   	  map.put("tzhihang", jiluHaocai.getTzhihang());
	   	  map.put("tname", jiluHaocai.getTname());
	   	  map.put("canme", jiluHaocai.getCname());
	   	  map.put("cname",a);
	   	 map.put("tip", jiluHaocai.getTip());
		// TODO Auto-generated method stub
		return this.jiluhaocaidao.insertSelective(map);
	}
	public int upgcname(String name) {
		// TODO Auto-generated method stub
		return this.jiluhaocaidao.upgcname(name);
	}
	public int getcount(JiluHaocai jiluHaocai) {
		// TODO Auto-generated method stub
		return this.jiluhaocaidao.getcount(jiluHaocai);
	}

}
