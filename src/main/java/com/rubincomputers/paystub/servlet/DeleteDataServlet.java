package com.rubincomputers.paystub.servlet;

import com.rubincomputers.paystub.MainFunctions;
import com.rubincomputers.paystub.Period;
import com.rubincomputers.paystub.View;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(
        name = "DeleteDataServlet",
        urlPatterns = {"/deletedata"}
)

public class DeleteDataServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Period> list = MainFunctions.readData();
        if(req.getParameter("id")!=null){
            int index = Integer.parseInt(req.getParameter("id"));
            list.remove(index);
            MainFunctions.saveData(list);

        }

        String s = "" +
                "<html>" +
                "<body>" +
                "Delete the following:" + "<br>\n";
         for (int i = 0; i < list.size(); i++) {
            //s = s + list.get(i).toString()+ "<br>\n";
            s = s + list.get(i).getDate() + " " + View.durationToString(list.get(i).getDuration()) + "<a href=\"/deletedata?id="+ i+"\">  DELETE</a>"+"<br>\n";
        }


                s = s + "</body>" +
                "</html>";

        //System.out.println(s);
        ServletOutputStream out = resp.getOutputStream();
        out.write(s.getBytes());
        out.flush();
        out.close();

    }
}
