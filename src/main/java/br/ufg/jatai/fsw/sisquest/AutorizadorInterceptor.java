/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.jatai.fsw.sisquest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 *
 * @author dfranco
 */
public class AutorizadorInterceptor extends HandlerInterceptorAdapter {

//    private UserLogado userLogado;

    @Override
    public boolean preHandle(HttpServletRequest request,
            HttpServletResponse response,
            Object controller) throws Exception {
        
        if (request.getSession().getAttribute("usuarioLogado") != null) {
            return true;
        }

        response.sendRedirect("/login?u=" + request.getRequestURI());
        return false;
    }
}
