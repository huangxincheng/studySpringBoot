package com.iba.utils.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebFilter(filterName = "ifilter", urlPatterns = "/*")
public class IFilter implements Filter {

	private static final Logger logger = LoggerFactory.getLogger(IFilter.class);
	
	@Override
	public void init(FilterConfig paramFilterConfig) throws ServletException {
		logger.info("iFilter init ...");
	}

	@Override
	public void doFilter(ServletRequest paramServletRequest, ServletResponse paramServletResponse,
			FilterChain paramFilterChain) throws IOException, ServletException {
		logger.info("enter iFilter ...");
		paramFilterChain.doFilter(paramServletRequest, paramServletResponse);
	}

	@Override
	public void destroy() {
		logger.info("iFilter destroy ...");
	}

}
