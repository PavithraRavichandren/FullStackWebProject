package com.spring.user;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LifeGlueFilter implements Filter{

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		HttpSession session = req.getSession(false);
		Boolean byPassFilter = req.getServletPath().contains("login.do") || req.getServletPath().contains("index.do") || req.getServletPath().contains("checkLogin.do") || req.getServletPath().contains("signup.do") || req.getServletPath().contains("insertUser.do");
		if(session != null && session.getAttribute("loginStatus") != null || byPassFilter) {
			chain.doFilter(request, response);
		} else {
			HttpServletResponse res = (HttpServletResponse)response;
			res.sendRedirect("login.do");
		}
	}
	
}
