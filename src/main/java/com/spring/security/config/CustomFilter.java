package com.spring.security.config;

import java.io.IOException;
import java.security.Principal;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

@Component
public class CustomFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("init:::::::::Filter");

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("doFilter:::::::::Filter");

		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		Principal userPrincipal = httpServletRequest.getUserPrincipal();
		System.out.println("User Name " + userPrincipal.getName());

	}

	@Override
	public void destroy() {
		System.out.println("destroy:::::::::Filter");

	}

}
