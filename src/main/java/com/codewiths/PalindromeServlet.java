package com.codewiths;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/palindrome-servlet")
public class PalindromeServlet extends GenericServlet {

    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        PrintWriter out = res.getWriter();
        res.setContentType("text/html");
        String name = req.getParameter("name");

        StringBuffer sb = new StringBuffer(name);
        sb.reverse();
        String reverse = sb.toString();

        if(name.equalsIgnoreCase(reverse)) {
            out.println("<h1>Palindrome</h1>");
        } else {
            out.println("<h1>Not a palindrome</h1>");
        }
        out.close();
    }
}
