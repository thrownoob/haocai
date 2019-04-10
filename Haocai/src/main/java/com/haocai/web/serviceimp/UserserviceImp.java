package com.haocai.web.serviceimp;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.haocai.web.dao.UserDAO;
import com.haocai.web.mod.User;
import com.haocai.web.service.Userservice;
@Service
public class UserserviceImp implements Userservice{
	@Resource
	private UserDAO UserDAO;
	public Map<String, Object> logincheck(String username, String password,HttpServletRequest request) {
		Map<String, Object> map=new HashMap<String, Object>();
         User u = new User();
         u.setUsername(username);
         u.setPassword(password);
		User user=UserDAO.loginCheck(u);
		if(user==null) {
			map.put("status", "userNameOrPwdError");
		}else {
			 map.put("status", "ok");
	            map.put("user", user);
	            request.getSession().setAttribute("user", username);
		}
		return map;
	}

}
