package br.com.rlb.config;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;

@WebFilter(asyncSupported = true, urlPatterns = { "/*" })
public class CorsFilter implements Filter {
	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse resp, FilterChain chain) throws IOException, ServletException {

		HttpServletResponse response = (HttpServletResponse) resp;
		
		response.addHeader("Access-Control-Allow-Origin", "*");
		
		response.addHeader("Access-Control-Allow-Methods","POST,GET,PUT,DELETE,OPTIONS");

		response.addHeader("Access-Control-Allow-Headers",	"Content-type");

		response.addHeader("Allow",	"POST,GET,PUT,DELETE,OPTIONS");

		chain.doFilter(request, response);
	}
	
	public void init(FilterConfig fConfig) throws
	ServletException {
		
	}
	
	

}
