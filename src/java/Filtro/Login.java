package model.bo.conta.filter;

import Model.Funcionario;
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

@WebFilter(filterName = "Login", urlPatterns = {"*.xhtml"})
public class Login implements Filter {

    public Login() {
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

   @Override
    public void doFilter(ServletRequest request, ServletResponse response,
        FilterChain chain) throws IOException, ServletException {
        try {
            HttpServletRequest httpRequest = (HttpServletRequest) request;
            HttpSession session = httpRequest.getSession(false);
            String uri = httpRequest.getRequestURI();
            String redirect = null;
            
            if (session == null || session.getAttribute("funcionarioLogado") == null) {
		if (!(uri.contains("/index.xhtml") || uri.contains("javax.faces.resource"))) {
                    redirect = "index.xhtml";
		}
            }else{
                Funcionario f = (Funcionario) session.getAttribute("funcionarioLogado");
                if (uri.contains("Principal.xhtml")) {
                    
                    if(f.getFuncao()== 1){
                        redirect = "PrincipalGarcom.xhtml";
                    }else if(f.getFuncao()== 2){
                        redirect = "PincipalCozinha.xhtml";
                    }else{
                        redirect = "PrincipalCentral.xhtml";
                    } 
		}
                
            }
 
            if (redirect != null) {
            	((HttpServletResponse) response).sendRedirect(redirect);
            } else {
		chain.doFilter(request, response);
            }
             
        } catch (IOException | ServletException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void destroy() {

    }
}