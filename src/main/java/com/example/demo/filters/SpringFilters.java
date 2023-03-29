package com.example.demo.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.stereotype.Component;

@Component
public class SpringFilters implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		System.out.println("inside filters");
		System.out.println("Remote host :: " + request.getRemoteHost());
		System.out.println("Remote Address :: " + request.getRemoteAddr());
		chain.doFilter(request, response);

	}

}
