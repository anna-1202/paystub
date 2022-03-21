package com.rubincomputers.paystub.servlet;

import com.rubincomputers.paystub.MainFunctions;
import com.rubincomputers.paystub.Period;
import com.rubincomputers.paystub.View;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(
        name = "ShowListServlet",
        urlPatterns = {"/showlist"}
)
public class ShowListServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        List<Period> list = MainFunctions.readData();

        String s = ""; //+
//                "<html>" +
//                "<body>" +
//                "list hours worked" + "<br>\n";
        for (int i = 0; i < list.size(); i++) {
            //s = s + list.get(i).toString()+ "<br>\n";
            s = s + list.get(i).getDate() + " " + View.durationToString(list.get(i).getHours()) + "<br>\n";
        }
//        s = s + "</body>" +
//                "</html>";
//
//        System.out.println(s);
//        ServletOutputStream out = resp.getOutputStream();
//        out.write(s.getBytes());
//        out.flush();
//        out.close();

        req.setAttribute("list", list);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("showlist.jsp");
        requestDispatcher.forward(req, resp);

    }
}
