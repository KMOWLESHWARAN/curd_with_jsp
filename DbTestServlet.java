package com.example;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/dbtest")
public class DbTestServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/plain;charset=UTF-8");
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        String url = "jdbc:mysql://localhost:3306/jsp";
        String user = "root";      // change for your lab
        String pass = "MOULY@2005";  // change for your lab

        try (Connection conn = DriverManager.getConnection(url, user, pass);
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT NOW() as now")) {
            if (rs.next()) {
                resp.getWriter().println("DB OK. Server time: " + rs.getString("now"));
            }
        } catch (SQLException e) {
            e.printStackTrace(resp.getWriter());
        }
    }
}
