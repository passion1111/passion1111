package aa;



import java.io.IOException;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class AA extends HttpServletRequestWrapper  {

	private HttpServletRequest request;
	
    public AA(HttpServletRequest request) {
        super(request);
        this.request=request;
    }
    
  

	@Override
	public String getParameter(String name) {
		String name2=request.getParameter(name);
    	System.out.println(name);
    	name2=name2.replace("<", "&lt");
    		System.out.println(name2);
    	name2=	name2.replaceAll(">", "&gt");
    		
    	name2=	name2.replaceAll("DDD", "WWWW");
    		
    		System.out.println(name2);
    		return name2; 
	}
	

    	
    		}
    
	