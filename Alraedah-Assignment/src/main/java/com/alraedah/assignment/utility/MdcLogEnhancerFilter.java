package com.alraedah.assignment.utility;


import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.MDC;
import org.springframework.stereotype.Component;

import com.alraedah.assignment.constant.APIConstants;

import lombok.extern.log4j.Log4j2;

/**
 * @author FaisalMOI
 *
 */
@Component
@Log4j2
public class MdcLogEnhancerFilter implements Filter {

	@Override
	public void destroy() {
		log.info("Calling the destroy method of MdcLogEnhancerFilter");
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		log.info("Initialising " + filterConfig.getFilterName());
	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
	        throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
		MDC.put(APIConstants.UNIQUE_REFERENCE_CODE,
		        httpRequest.getHeader(APIConstants.UNIQUE_REFERENCE_CODE));
		MDC.put(APIConstants.FINANCIAL_ID,
		        httpRequest.getHeader(APIConstants.FINANCIAL_ID));
		MDC.put(APIConstants.CHANNEL_ID,
		        httpRequest.getHeader(APIConstants.CHANNEL_ID));
		filterChain.doFilter(servletRequest, servletResponse);
	}
}