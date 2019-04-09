package com.haocai.web.serviceimp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.haocai.web.dao.JiluHaocaiDAO;
import com.haocai.web.mod.JiluHaocai;
import com.haocai.web.service.Jiluhaocaiservice;
@Service
public class Jiluhaocaiimp implements Jiluhaocaiservice {
@Resource
private JiluHaocaiDAO jiluhaocaidao;
	public List<JiluHaocai> getjiluhaocai(JiluHaocai jiluhaocai) {
		// TODO Auto-generated method stub
		return this.jiluhaocaidao.getjiluhaocai(jiluhaocai);
	}

}
