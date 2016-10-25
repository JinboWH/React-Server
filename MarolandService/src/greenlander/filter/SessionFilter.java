package greenlander.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SessionFilter implements Filter
{
	 public FilterConfig config;
	    
	    public void destroy() 
	    {
	        this.config = null;
	    }
	    
	    public static boolean isContains(String container, String[] regx) 
	    {
	        return true;
	    }

	    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException 
	    {    	
	    	//Logger.getLogger("RestExceptionHandler").log(Level.INFO, request.getLocalAddr());
	    	final HttpServletResponse httpResponse = (HttpServletResponse) response;
	    	request.setCharacterEncoding("utf-8");
	    	httpResponse.setHeader("Access-Control-Allow-Origin", "*");
	    	httpResponse.setHeader("Access-Control-Allow-Methods","GET,POST,PUT, DELETE,OPTIONS");
	    	httpResponse.setHeader("Access-Control-Allow-Headers","Content-Type");
	    	//httpResponse.setHeader("Content-Type", "application/json");
	    		    	
	    	chain.doFilter(request,httpResponse);
	    }

	    public void init(FilterConfig filterConfig) throws ServletException 
	    {
	        config = filterConfig;
	    }
}
