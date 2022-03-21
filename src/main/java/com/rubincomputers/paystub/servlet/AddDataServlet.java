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
import java.time.Duration;
import java.time.LocalDate;
import java.util.List;

@WebServlet(
        name = "AddDataServlet",
        urlPatterns = {"/adddata"}
)
public class AddDataServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {


//        String s = "" +
//                "<html>" +
//                "<body>" +
//                "Enter day and hours: " + "<br>\n";
//        s = s +
//                "<form action=\"/adddata\" method=\"post\" >" +
//                "  <label for=\"date\">Enter Date:</label><br>\n" +
//                "  <input type=\"text\" id=\"date\" name=\"date\" value=\"date\"><br><br>\n" +
//                "  <label for=\"hours\">Enter hours:</label><br>\n" +
//                "  <input type=\"text\" id=\"hours\" name=\"hours\" value=\"hours\"><br>\n" +
//                "  <label for=\"minutes\">Enter hours:</label><br>\n" +
//                "  <input type=\"text\" id=\"minutes\" name=\"minutes\" value=\"minutes\"><br><br>\n" +
//                "  <input type=\"submit\" value=\"Submit\">\n" +
//                "</form> ";
//
//        s = s + "</body>" +
//                "</html>";

//        System.out.println(s);
//        ServletOutputStream out = resp.getOutputStream();
//        out.write(s.getBytes());
//        out.flush();
//        out.close();
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("adddata.jsp");
        requestDispatcher.forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Period> list = MainFunctions.readData();
        System.out.println(req.getParameterMap());
        System.out.println(req.getParameter("date"));
        System.out.println(req.getParameter("hours"));
        System.out.println(req.getParameter("minutes"));

        LocalDate date = View.stringToLocalDate(req.getParameter("date"));

        int hours = Integer.parseInt(req.getParameter("hours"));
        int minutes = Integer.parseInt(req.getParameter("minutes"));

        Duration time = Duration.ofHours(hours).plusMinutes(minutes);
        list.add(new Period(date, time));
        MainFunctions.saveData(list);

        //doGet(req, resp);
        resp.sendRedirect("/adddata");


    }
}
