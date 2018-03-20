package br.usjt.arqsw.mapeamento;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import br.usjt.arqsw.entity.Usuario;

/**
 * 
 * @author Gabrielle Nascimento da Anuncia��o ra: 81612332
 */
public class AutorizadorInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request,
        HttpServletResponse response,
        Object controller) throws Exception {
    	String uri = request.getRequestURI();
        if (uri.endsWith("telaLogin") || uri.endsWith("Login") ||
            uri.contains("css") || uri.contains("jsp") ||
            uri.contains("img") || uri.contains("index")) {
            return true;
        }
        if (request.getSession().getAttribute(Usuario.LOGADO) != null) {
            return true;
        }
        response.sendRedirect("index");
        return false;
    }
}

