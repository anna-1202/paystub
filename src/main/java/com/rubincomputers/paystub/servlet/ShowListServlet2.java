package com.rubincomputers.paystub.servlet;

import com.rubincomputers.paystub.MainFunctions;
import com.rubincomputers.paystub.Period;
import com.rubincomputers.paystub.View;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.ServletException;
import java.io.IOException;
import java.util.List;

@Controller
public class ShowListServlet2 {

    @GetMapping("/showlist")
    public String doGet(Model model) throws ServletException, IOException {

        List<Period> list = MainFunctions.readData();

        String s = ""; //+
//                "<html>" +
//                "<body>" +
//                "list hours worked" + "<br>\n";
        for (int i = 0; i < list.size(); i++) {
            //s = s + list.get(i).toString()+ "<br>\n";
            s = s + list.get(i).getDate() + " " + View.durationToString(list.get(i).getDuration()) + "<br>\n";
        }
//        s = s + "</body>" +
//                "</html>";
//
//        System.out.println(s);
//        ServletOutputStream out = resp.getOutputStream();
//        out.write(s.getBytes());
//        out.flush();
//        out.close();

//        req.setAttribute("list", list);
//        RequestDispatcher requestDispatcher = req.getRequestDispatcher("showlist");
//        requestDispatcher.forward(req, resp);

        model.addAttribute("list", list);
        return "showlist";

    }
}
