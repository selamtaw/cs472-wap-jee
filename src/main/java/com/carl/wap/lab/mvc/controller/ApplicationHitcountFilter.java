package com.carl.wap.lab.mvc.controller;


import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;

/**
 * Servlet Filter implementation class ApplicationHitcountFilter
 */
@WebFilter(dispatcherTypes = {
        DispatcherType.REQUEST,
        DispatcherType.FORWARD
}, description = "ApplicationHitcountFilter", urlPatterns = {"/", "/*"})
public class ApplicationHitcountFilter implements Filter {

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        String url = ((HttpServletRequest) request).getRequestURI();
        System.out.println("AppInfo-Log: Called doFilter via " + url);
        Integer totalHitCount = (Integer) request.getServletContext().getAttribute("totalHitCount");

        if(!url.endsWith(".jsp")){
            request.getServletContext().setAttribute("totalHitCount", ++totalHitCount);
        }
        chain.doFilter(request, response);
    }

    public void init(FilterConfig fConfig) {
        System.out.println("AppInfo-Log: Initializing " + fConfig.getFilterName());
        int totalHitCount = 0;
        fConfig.getServletContext().setAttribute("totalHitCount", totalHitCount);
    }

}
