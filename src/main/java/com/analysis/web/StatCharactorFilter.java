package com.analysis.web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class StatCharactorFilter implements Filter {
	private String encoding;
	private static String DEFAULT_ENCODING = "utf-8";

	public void destroy() {

	}

	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		if (encoding == null) {
			encoding = DEFAULT_ENCODING;
		}
		arg0.setCharacterEncoding(encoding);
		//arg1.setContentType("text/html;charset=" + encoding);
		arg1.setContentType("application/json;charset=" + encoding);
		arg2.doFilter(arg0, arg1);
	}

	public void init(FilterConfig arg0) throws ServletException {
		encoding = arg0.getInitParameter("encoding ");
	}

}
