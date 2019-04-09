package com.haocai.web.serviceimp;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.haocai.web.dao.TnaDAO;
import com.haocai.web.mod.Cat;
import com.haocai.web.mod.Tna;
import com.haocai.web.service.Tnaservice;
@Service
public class TnaserviceImp implements Tnaservice {

	@Resource
	private TnaDAO tnaDao;

		


		public int inse(Tna ta) {
			 HashMap<String, Object> map=new HashMap<String, Object>();
			 map.put("ename", ta.getEname());
			 if(this.tnaDao.selectByPrimaryKey(ta.getEname())== null ) {
				 return this.tnaDao.insert(map);
			 }
			 return 2;
		}




		public List<Tna> gettna(Tna a) {
			// TODO Auto-generated method stub
			return this.tnaDao.gettna(a);
		}




		public List<Tna> getnames() {
			// TODO Auto-generated method stub
			return this.tnaDao.getnames();
		}




}
