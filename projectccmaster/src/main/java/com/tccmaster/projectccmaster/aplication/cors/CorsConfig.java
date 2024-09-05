package com.tccmaster.projectccmaster.aplication.cors;


import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;


@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class CorsConfig implements Filter {

    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletRequest requestHttpServlet = (HttpServletRequest) request;
        HttpServletResponse responseHttpServlet = (HttpServletResponse) response;

        String originPermitida = requestHttpServlet.getHeader("Origin");
        if (originPermitida != null && (originPermitida.equals("http://localhost:4200") || originPermitida.equals("http://localhost:8080"))) {
            responseHttpServlet.setHeader("Access-Control-Allow-Origin", originPermitida);
        }

        responseHttpServlet.setHeader("Access-Control-Allow-Credentials", "true");
        responseHttpServlet.setHeader("Access-Control-Allow-Headers", "Authorization, Content-Type, Accept");
        responseHttpServlet.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");

        if ("OPTIONS".equalsIgnoreCase(requestHttpServlet.getMethod())) {
            responseHttpServlet.setStatus(HttpServletResponse.SC_OK);
        } else {
            filterChain.doFilter(request, response);
        }
    }

    @Override
    public void init(FilterConfig arg0) {
    }
}



//@Component
//@Order(Ordered.HIGHEST_PRECEDENCE)
//public class CorsConfig implements Filter {
//
//
//    @Override
//    public void destroy() {
//    }
//
//    @Override
//    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
//            throws IOException, ServletException {
//        HttpServletRequest requestHttpServelt = (HttpServletRequest) request;
//        HttpServletResponse responseHttpServelt = (HttpServletResponse) response;
//        String originPermitida = "*";
//        responseHttpServelt.setHeader("Access-Control-Allow-Origin", originPermitida);
//        responseHttpServelt.setHeader("Access-Control-Allow-Credentials", "true");
//        responseHttpServelt.setHeader("Access-Control-Allow-Headers", "Authorization, Content-Type, Accept");
//
//
//        filterChain.doFilter(request, response);
//
//    }
//
//    @Override
//    public void init(FilterConfig arg0){
//
//    }
//}


