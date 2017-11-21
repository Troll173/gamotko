package com.hermestechnologies.interceptor;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AuthInterceptor extends HandlerInterceptorAdapter {

    public boolean preHandle(
            HttpServletRequest request,
            HttpServletResponse response,
            Object handler) throws Exception {


        HttpSession session = request.getSession();

        if (session.getAttribute("loggedIn") != null) {
            return true;
        } else {
            response.sendRedirect("/login");
            return false;
        }
    }
}
