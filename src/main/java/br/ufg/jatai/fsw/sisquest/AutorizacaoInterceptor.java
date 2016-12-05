/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.jatai.fsw.sisquest;

import br.ufg.jatai.fsw.sisquest.annotations.Permissao;
import br.ufg.jatai.fsw.sisquest.model.Usuario;
import java.lang.reflect.Method;
import java.util.Arrays;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 *
 * @author dfranco
 */
public class AutorizacaoInterceptor extends HandlerInterceptorAdapter {

    private static final Logger log = LoggerFactory.getLogger(AutorizacaoInterceptor.class.getName());

    @Override
    public boolean preHandle(HttpServletRequest request,
            HttpServletResponse response,
            Object handler) throws Exception {
        HandlerMethod hm = (HandlerMethod) handler;
        Method method = hm.getMethod();
        if (method.getDeclaringClass().isAnnotationPresent(Controller.class)) {
//            log.error("Eu entrei aqui e tenho anotações: " + Arrays.toString(method.getAnnotations()));
            if (method.isAnnotationPresent(Permissao.class)) {
//                log.error("Ele entrou aqui como: " + Arrays.toString(method.getAnnotation(Permissao.class).value()));
                System.out.println(Arrays.toString(method.getAnnotation(Permissao.class).value()));
                Usuario u = (Usuario) request.getSession().getAttribute("usuarioLogado");
                if (Arrays.asList(method.getAnnotation(Permissao.class).value()).contains(u.getTipoUsuario())) {
                    return true;
                } else {
                    response.sendError(403, "Sem permissão para esse controller");
                    return false;
                }

            } 
        }

//        log.error("Ele passou aqui");
        return true;
    }
}
