package com.kg.handler;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyInterceptor implements HandlerInterceptor {

    /**
     *
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {
        System.out.println("1拦截器preHandle");
        String username="";
//       获取登录账号的信息
        Object attr=request.getSession().getAttribute("username");
        if(attr!=null){
            username = (String) attr;
        }
//判断账号是否正确
        if("huabao".equals(username)){
            return true;
        }else{
            request.getRequestDispatcher("/tips.jsp").forward(request,response);
            return false;
        }
    }

    /**
     *
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response,
                           Object handler,
                           ModelAndView modelAndView) throws Exception {
        System.out.println("1拦截器的hosthandle");

    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("1拦截器的afterhandle");
    }
}
