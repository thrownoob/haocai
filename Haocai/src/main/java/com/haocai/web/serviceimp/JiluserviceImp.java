package com.haocai.web.serviceimp;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.haocai.web.dao.JiluDAO;
import com.haocai.web.mod.Jilu;
import com.haocai.web.service.Jiluservice;
@Service
public class JiluserviceImp implements Jiluservice{
@Resource
 private JiluDAO jiluDAO;
	public int jiluins(Jilu jilu,HttpServletRequest request) {
		HttpSession   session   =   request.getSession(); 
		Object a=session.getAttribute("user");
		HashMap<String, Object> map=new HashMap<String, Object>();
		map.put("eid", jilu.getEid());
         map.put("user", a);
         map.put("sex", jilu.getSex());
         map.put("time", jilu.getTime());
         return this.jiluDAO.insert(map);
		
	}
	public List<Jilu> sejilu(Jilu jilu) {
       
		return  this.jiluDAO.getjilu(jilu);
	}
	public int getcount(Jilu jilu) {
		// TODO Auto-generated method stub
		
		return this.jiluDAO.getcountjilu(jilu);
	}

}
