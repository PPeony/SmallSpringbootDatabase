package com.springbootbank.bank;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author: Peony
 * @Date: 2020/7/9 14:08
 */
@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println(request.getContextPath()+"========");
        System.out.println(request.getPathInfo()+"  ");
        System.out.println(request.getServletPath());
        if (request.getSession().getAttribute("user_id") == null) {

            response.sendRedirect(request.getContextPath()+"/user/login");
            return false;
        }
        return true;
    }
}
