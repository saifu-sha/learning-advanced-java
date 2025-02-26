package com.codewiths;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/even-range-servlet")
public class EvenRangeServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        int start = Integer.parseInt(request.getParameter("start"));
        int end = Integer.parseInt(request.getParameter("end"));
        out.println("<html><body>");
        for(int number = start; number <= end; number++) {
            if(number % 2 == 0) {
                out.println("<p>" + number + "</p>");
            }
        }

        out.println("</body></html>");
        out.close();

    }
}
