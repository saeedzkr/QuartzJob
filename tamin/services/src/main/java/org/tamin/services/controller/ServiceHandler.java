package org.tamin.services.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by sector7 on 10/23/15.
 */
public class ServiceHandler extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String user = req.getParameter("user");
        String pass = req.getParameter("pass");
        String serviceURL = "http://localhost:8083/url/UserService/remain?username=" + user + "&password=" + pass;
        resp.sendRedirect(serviceURL);

    }

}
