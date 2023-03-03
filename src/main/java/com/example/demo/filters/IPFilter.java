package com.example.demo.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebFilter("/*")
public class IPFilter implements Filter {

    public final static String IP = "128.0.0.1";
//    public final static String IP = "127.0.0.1";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        String clientIPAddress = httpRequest.getRemoteAddr();

        servletResponse.setContentType("text/html");
        PrintWriter out = servletResponse.getWriter();
        out.println(clientIPAddress);


        if (IP.trim().equals(clientIPAddress.trim())) {
            throw new ServletException("Access denied from this IP address");
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
            out.println(">IP Filter passed successfully ");
        }
    }

    @Override
    public void destroy() {
    }
}
