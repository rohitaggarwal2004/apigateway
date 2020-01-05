package com.example.hello.logging;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class Logging extends ZuulFilter {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public Object run() throws ZuulException {
		HttpServletRequest httpServletRequest = RequestContext.getCurrentContext().getRequest();

		logger.info("Request ->{} request uri->{}", httpServletRequest, httpServletRequest.getRequestURI());
		return null;
	}

	@Override
	public boolean shouldFilter() {
		// Implement Business Logic
		return true;
	}

	@Override
	public int filterOrder() {
		// TODO Auto-generated method stub
		HttpServletRequest httpServletRequest = RequestContext.getCurrentContext().getRequest();

		logger.info("Request ->{} request uri->{}", httpServletRequest, httpServletRequest.getRequestURI());
		System.out.println("############# " + httpServletRequest.getRequestURI());
		return 1;
	}

	@Override
	public String filterType() {
		// TODO Auto-generated method stub
		// Prem,Post,error request, free
		return "pre";
	}

}
