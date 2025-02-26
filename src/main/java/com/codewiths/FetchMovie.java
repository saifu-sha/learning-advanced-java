package com.codewiths;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@WebServlet("/fetch-movie")
public class FetchMovie extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        int id = Integer.parseInt(request.getParameter("id"));

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/student_db";
            String user = "root";
            String password = "root";
            Connection conn = DriverManager.getConnection(url, user, password);
            String query = "select * from movies where id = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                rs.getInt(1);
                String name = rs.getString(2);
                String actor = rs.getString(3);
                String actress = rs.getString(4);
                String director = rs.getString(5);
                String releaseDate = rs.getString(6);
                Float rating = rs.getFloat(7);

                out.println("<html><body>");
                out.println("<h1> Movie Details:</h1>");
                out.println("<table border=1>");
                out.println("<tr>");
                out.println("<th>ID</th>");
                out.println("<th>Name</th>");
                out.println("<th>Actor</th>");
                out.println("<th>Actress</th>");
                out.println("<th>Director</th>");
                out.println("<th>Release Date</th>");
                out.println("<th>Rating</th>");
                out.println("</tr>");
                out.println("<tr>");
                out.println("<td>" + id + "</td>");
                out.println("<td>" + name + "</td>");
                out.println("<td>" + actor + "</td>");
                out.println("<td>" + actress + "</td>");
                out.println("<td>" + director + "</td>");
                out.println("<td>" + releaseDate + "</td>");
                out.println("<td>" + rating + "</td>");
                out.println("</tr>");
                out.println("</table>");
                out.println("</body></html>");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
