package org.tamin.web.Controller;

import org.hibernate.result.Output;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Properties;

/**
 * Created by sector7 on 1/15/16.
 */
public class ConfigController extends HttpServlet {



    protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {



    }

    protected void doget(HttpServletRequest request , HttpServletResponse response)
    {

        try {
            PrintWriter out = response.getWriter();
            InputStream stream = getServletContext().getResourceAsStream("/WEB-INF/config.properties");
            out.print(stream);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }







}
