package com.haocai.web.serviceimp;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.haocai.web.dao.JiluDAO;
import com.haocai.web.mod.Jilu;
import com.haocai.web.service.Jiluservice;
@Service
public class JiluserviceImp implements Jiluservice{
@Resource
 private JiluDAO jiluDAO;
	public int jiluins(Jilu jilu) {
		HashMap<String, Object> map=new HashMap<String, Object>();
		map.put("eid", jilu.getEid());
         map.put("bname", jilu.getBname());
         map.put("cname", jilu.getCname());
         map.put("tname", jilu.getTname());
         
         
		
		return this.jiluDAO.insert(map);
		
	}
	public List<Jilu> sejilu(String a) {

		return  this.jiluDAO.getjilu(a);
	}

}
