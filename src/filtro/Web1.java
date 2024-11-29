package filtro;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



//@WebFilter("/Web1/*")
public class Web1 implements Filter 
{


    public Web1() 
    {
      
    }


	public void destroy() 
	{
		
	}


	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException 
	{
		
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		
		String url = httpServletRequest.getRequestURI();

		
		
		HttpSession sessao = httpServletRequest.getSession();
		
		System.out.println(sessao.getAttribute("usuAutenticado"));
		System.out.println(url.lastIndexOf("login"));
		System.out.println(url.lastIndexOf("UsuarioLogar"));
		
		System.out.println("-----");
		
		
		
		
		

		
		
			if (sessao.getAttribute("usuAutenticado") != null || url.lastIndexOf("login") > -1 || url.lastIndexOf("UsuarioLogar") > -1 )
			{
				
			chain.doFilter(request, response);

						
			}
			
				else
				{
					
					
					((HttpServletResponse)response).sendRedirect("usuario-login.jsp");
				
					
					
				}
				
			
		
		
		
 		
	}

	
	public void init(FilterConfig fConfig) throws ServletException 
	{
	
	}

}
