package com.codewiths;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/name-length-servlet")
public class NameLengthServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String name = request.getParameter("name");
        int length = name.length();
        out.println("<html><head>");
        out.println("<title>Servlet NameLengthServlet</title>");
        out.println("</head><body>");
        out.println("<h1>Length of " + name + " is " + length + "</h1>");
        out.println("</body></html>");
        out.close();
    }
}
