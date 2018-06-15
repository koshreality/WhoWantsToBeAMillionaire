package mypackage;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import static java.lang.Class.forName;

@WebServlet(name = "Registration", urlPatterns = "/Registration")
public class Registration extends CommonServlet {

    private boolean registerUser(String username, String password) throws SQLException {
        try (PreparedStatement stmt = conn.prepareStatement(
                "INSERT INTO users (username, password) VALUES (?, ?)")){
            stmt.setString(1, username);
            stmt.setString(2, password);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("/registration.jsp");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String password2 = request.getParameter("confirm-password");
        if (username == null || password == null
                || password2 == null || !password2.equals(password)) {
            response.sendRedirect("/registration.jsp");
            return;
        }
        boolean registered = false;
        try {
            registered = registerUser(username, password);
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        String url = "registration_complete.jsp";
        if (!registered) {
            url = "registration.jsp";
        }
        RequestDispatcher rd = request.getRequestDispatcher(url);
        rd.forward(request, response);
    }
}