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
import java.time.LocalDate;


@WebServlet("/save-movie")
public class SaveMovieServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String name = request.getParameter("name");
        String actor = request.getParameter("actor");
        String actress = request.getParameter("actress");
        String director = request.getParameter("director");
        String releaseDateString = request.getParameter("release_date");
        LocalDate releaseDate = LocalDate.parse(releaseDateString);
        float rating = Float.parseFloat(request.getParameter("rate_point"));

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/student_db";
            String user = "root";
            String password = "root";
            Connection con = DriverManager.getConnection(url, user, password);
            String query = "insert into movies(name, actor, actress, director, release_date, rate_point) values(?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, actor);
            ps.setString(3, actress);
            ps.setString(4, director);
            ps.setObject(5, releaseDate);
            ps.setFloat(6, rating);
            int noOfRowInserted = ps.executeUpdate();

            if(noOfRowInserted>0) {
                out.println("<h1>Movie Saved Successfully</h1>");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
