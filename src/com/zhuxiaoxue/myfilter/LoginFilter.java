package com.zhuxiaoxue.myfilter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter("/LoginFilter")
public class LoginFilter implements Filter {

	public LoginFilter() {
		// TODO Auto-generated constructor stub
	}

	public void destroy() {
		// TODO Auto-generated method stub
	}

	private String uris;

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;

		String uri = req.getRequestURI();

		String[] str = uris.split(",");
		boolean flag = false;
		for (String strs : str) {
			if (strs.startsWith(uri)) {
				flag = true;
				break;
			}
		}
		if (flag) {
			chain.doFilter(request, response);
		} else {
			Object name = req.getSession().getAttribute("userName");
			if (name != null) {
				chain.doFilter(request, response);
			} else {
				res.sendRedirect("/index");
			}
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
		uris = fConfig.getInitParameter("uris");
	}

}
