package com.codewiths;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/even-odd")
public class EvenOddServlet extends GenericServlet {

    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        String numberString = req.getParameter("number");
        int number = Integer.parseInt(numberString);

        out.println("<html><body>");
        if (number % 2 == 0) {
            out.println("<h1>Even</h1>");
        } else {

            out.println("<h1>Odd</h1>");
        }
        out.println("</body></html>");
    }
}
