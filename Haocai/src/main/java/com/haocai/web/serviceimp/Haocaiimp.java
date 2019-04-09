package com.haocai.web.serviceimp;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;


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

}
