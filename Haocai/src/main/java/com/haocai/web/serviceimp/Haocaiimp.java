package com.haocai.web.serviceimp;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.haocai.web.UUID.Uuid;
import com.haocai.web.dao.HaocaiDAO;
import com.haocai.web.mod.Haocai;
import com.haocai.web.service.Haocaiservice;
@Service
public class Haocaiimp implements Haocaiservice{
	@Resource
	private HaocaiDAO haocaidao;
	public Haocai getbyname(String name) {
		// TODO Auto-generated method stub
		return this.haocaidao.selectByPrimaryKey(name);
	}
	public int addHaocai(Haocai haocai) {
		 HashMap<String, Object> map=new HashMap<String, Object>();

     	  map.put("name", haocai.getName());
     	  map.put("cnumber", "0");
     	map.put("cid", Uuid.getUUID());

		return this.haocaidao.insertSelective(map);
	}
	public int uphaocainumberup(Haocai haocai) {//入库数量变更
		// TODO Auto-generated method stub
		HashMap<String, Object> map=new HashMap<String, Object>();

   	  map.put("name", haocai.getName());
   	  map.put("cnumber", haocai.getCnumber());
		return this.haocaidao.updatebynamefornumberup(map);
	}
	public int uphaocainumberdown(Haocai haocai) {//入库数量变更
		// TODO Auto-generated method stub
		HashMap<String, Object> map=new HashMap<String, Object>();

   	  map.put("name", haocai.getName());
   	  map.put("cnumber", haocai.getCnumber());
		return this.haocaidao.updatebynamefornumberdown(map);
	}
	public List<Haocai> getname() {
		// TODO Auto-generated method stub
		return this.haocaidao.getname();
	}
	public List<Haocai> getallhaocai(String name) {
		// TODO Auto-generated method stub
		return this.haocaidao.getallhaocai(name);
	}
	public String getnumber(String name) {
		// TODO Auto-generated method stub
		return this.haocaidao.selectbynamefornumber(name);
	}
	public List<Haocai> gethaocainumber(Haocai haocai) {
		// TODO Auto-generated method stub
		return this.haocaidao.gethaocainumber(haocai);
	}
	public int getcountnumber(Haocai haocai) {
		// TODO Auto-generated method stub
		return this.haocaidao.getcountnumber(haocai);
	}

}
