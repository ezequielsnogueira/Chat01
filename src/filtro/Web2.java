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



//@WebFilter("/Web2/*")
public class Web2 implements Filter 
{


    public Web2() 
    {
      
    }


	public void destroy() 
	{
		
	}


	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException 
	{
		
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		
		String url = httpServletRequest.getRequestURI();

		
		System.out.println("adicionaUsuario");
		System.out.println(url.lastIndexOf("adicionaUsuario"));
		System.out.println("UsuarioInserir");
		System.out.println(url.lastIndexOf("UsuarioInserir"));
		System.out.println("usuario-cadastro.jsp");
		System.out.println(url.lastIndexOf("usuario-cadastro.jsp"));
		System.out.println("usuario-cadastrado.jsp");
		System.out.println(url.lastIndexOf("usuario-cadastrado.jsp"));
		
		
		System.out.println("-----");
		
		
		
		
		

		
		
			if (url.lastIndexOf("usuario-cadastro.jsp") > -1 || url.lastIndexOf("adicionaUsuario") > -1)
			{
		
			chain.doFilter(request, response);

						
			}
			
				else
				{
					
					
					((HttpServletResponse)response).sendRedirect("usuario-cadastro.jsp");
				
					
					
				}
				
			
		
		
		
 		
	}

	
	public void init(FilterConfig fConfig) throws ServletException 
	{
	
	}

}
