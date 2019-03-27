package com.haocai.web.serviceimp;

import java.util.HashMap;

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
        	  map.put("eid", equ.getEid());
        	  map.put("categary", equ.getCategary());
        	  map.put("ard", equ.getArd());
        	  map.put("usetime", equ.getUsetime());
        	  map.put("yr", equ.getYr());
        	  map.put("fixed", equ.getFixed());
        	  return this.euqdao.insert(map);
//        	  
//          }

	}

}
