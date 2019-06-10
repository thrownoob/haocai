package com.haocai.web.serviceimp;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;


import com.haocai.web.dao.EquipmentDAO;
import com.haocai.web.mod.Equipment;

import com.haocai.web.service.Equservice;
@Service
public class EquserviceImp implements Equservice{
@Resource
private EquipmentDAO euqdao;
//Catservice catservice;

	public int inse(Equipment equ) {
		 HashMap<String, Object> map=new HashMap<String, Object>();
//          if(catservice.sec(equ.getCategary())==1) {
//        	  return 2;
//          }else {
		  map.put("categary", equ.getCategary());
        	  map.put("eid", equ.getEid());
        	map.put("ard", equ.getArd());
        	  map.put("yr", "未启用");
        	  map.put("fixed", "否");
        	  return this.euqdao.insertSelective(map);
//        	  
//          }

	}

	public int equsec(String a) {
   if(this.euqdao.selectByPrimaryKey(a)==null) {
	   return 0;
   }
		return 1;
	}

	public int equupd(Equipment equ) {
		HashMap<String, Object> map=new HashMap<String, Object>();
		 Equipment mo=this.euqdao.selectByPrimaryKey(equ.getEid());
		 
		if(mo==null) {
			return 0;
		}else {
			String md=mo.getYr();
			if(md!=null&&md.equals("已启用")) {
				map.put("eid", equ.getEid());
				map.put("ard", equ.getArd());
				return this.euqdao.updateByPrimaryKeySelective(map);
			}else {
			map.put("usetime", equ.getUsetime());
			map.put("eid", equ.getEid());
			map.put("yr", equ.getYr());
			map.put("ard", equ.getArd());
			return this.euqdao.updateByPrimaryKeySelective(map);
			}
		}
		
	}

	public List<Equipment> getkey(String eid) {
		// TODO Auto-generated method stub
		return this.euqdao.getequ(eid);
	}

	public List<Equipment> selectByPrimaryKey(Equipment equ) {
		// TODO Auto-generated method stub
		return this.euqdao.selectByPrimaryKey(equ);
	}

	public int getequcount(Equipment equ) {
		// TODO Auto-generated method stub
		return this.euqdao.getequcount(equ);
	}

}
