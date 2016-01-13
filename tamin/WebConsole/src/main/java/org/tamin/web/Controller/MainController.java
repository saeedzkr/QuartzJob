package org.tamin.web.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by sector7 on 1/10/16.
 */
public class MainController extends HttpServlet {




    protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        resp.sendRedirect("/pages/QueueMonitor.xhtml");

    }
}
