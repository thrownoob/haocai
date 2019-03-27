package com.haocai.web.serviceimp;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.haocai.web.dao.CatDAO;
import com.haocai.web.mod.Cat;
import com.haocai.web.service.Catservice;
@Service
public class CatserviceImp implements Catservice{
@Resource
 private CatDAO catDao;
	public int inse(Cat cat) {
		 HashMap<String, Object> map=new HashMap<String, Object>();
		 if(this.catDao.selectByPrimaryKey(cat.getCategary())==null) {
			 map.put("categary", cat.getCategary());
			 map.put("ename", cat.getEname());
			 map.put("cnumber", cat.getCnumber());
			return this.catDao.insert(map);
		 }
	return 2;
	}
public List<Cat> getkey() {
		// TODO Auto-generated method stub
		return this.catDao.getalcr();
	}

}
