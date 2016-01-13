package org.tamin.web.Controller;


import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.tamin.model.entity.Device;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;

/**
 * Created by sector7 on 12/12/15.
 */


public class SecurityFilter
{}
//        implements Filter {
//
//
//    final Logger logger = Logger.getLogger("callLogger");
//
//
//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//
//        logger.log(Level.INFO, "Security Filter has been initialize");
//    }
//
//    @Override
//    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//
//
//        HttpServletRequest req = (HttpServletRequest) servletRequest;
//        HttpServletResponse res = (HttpServletResponse) servletResponse;
//        HttpSession session = req.getSession(false);
//
//        Device device = (Device) session.getAttribute("device");
//        String uri = req.getRequestURI();
//        if (device == null || !(uri.endsWith("html") || uri.endsWith("LoginServlet") || uri.endsWith("xhtml")) && cotnrolIpAddress()) {
//            logger.log(Level.WARN, "Unauthorized access request");
//            req.getRequestDispatcher("/login.xhtml").forward(req, res);
//
//        } else {
//            logger.log(Level.INFO, "Authorized Request Resource :" + uri);
//            filterChain.doFilter(req, res);
//
//        }
//    }
//
//    private boolean cotnrolIpAddress() {
//        //todo control vpn
//        return true;
//    }
//
//    @Override
//    public void destroy() {
//
//    }
//
//}
