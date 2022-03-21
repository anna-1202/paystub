package com.rubincomputers.paystub.servlet;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
        name = "MyServlet",
        urlPatterns = {""}
)
public class HelloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String s = "" +
                "<html>" +
                "<body>" +
                "<a href=\"/showlist\">Show List</a>" +"<br>"+
                "<a href=\"/adddata\">Add new data</a>" +"<br>"+
                "<a href=\"/deletedata\">Delete from list</a>" +"<br>"+
                "</body>" +
                "</html>";
     ServletOutputStream out = resp.getOutputStream();
        out.write(s.getBytes());
        out.flush();
        out.close();
    }

}
