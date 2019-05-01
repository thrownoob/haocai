package com.haocai.web.lesson;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class Loginlesson implements HandlerInterceptor {

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		Object user=request.getSession().getAttribute("user");
		if(user=="userNameOrPwdError"||user==null) {
			 System.out.println("尚未登录，调到登录页面");
	       //       response.sendRedirect("/login.jsp");
	            
			        
			          response.getWriter().print("368");
			           return false;
		}
		return true;
	}

	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		  System.out.println("postHandle");
		
	}

	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("afterCompletion");
		
	}

}
