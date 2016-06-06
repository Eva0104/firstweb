package com.zhuxiaoxue.myfilter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class EncodingFliter
 */
@WebFilter("/EncodingFliter")
public class EncodingFliter implements Filter {

    /**
     * Default constructor. 
     */
    public EncodingFliter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	String encode;
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		request.setCharacterEncoding(encode);
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
		encode=fConfig.getInitParameter("encode");
	}

}
