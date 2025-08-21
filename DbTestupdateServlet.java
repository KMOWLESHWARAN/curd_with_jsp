package com.example;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/updateData")
public class DbTestupdateServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        resp.setContentType("text/plain;charset=UTF-8");

        // Database connection details
        String url = "jdbc:mysql://localhost:3306/jsp";
        String user = "root";
        String pass = "MOULY@2005";

        try {
            // Load JDBC driver (optional in newer versions)
            Class.forName("com.mysql.cj.jdbc.Driver");

            try (Connection conn = DriverManager.getConnection(url, user, pass);
                PreparedStatement st = conn.prepareStatement(
                "update products set name=? where id=?")) {

                // Get the ID 
                int id = Integer.parseInt(req.getParameter("id"));
                String name = req.getParameter("name");

                st.setString(1, name); 
                st.setInt(2, id);   


                int rows = st.executeUpdate();

                if (rows > 0) {
                    resp.getWriter().println("Product successfully updated...");
                } else {
                    resp.getWriter().println("No product found with ID: " + id);
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            resp.getWriter().println("Driver not found!");
        } catch (SQLException e) {
            e.printStackTrace();
            resp.getWriter().println("Database error: " + e.getMessage());
        }
    }
}
