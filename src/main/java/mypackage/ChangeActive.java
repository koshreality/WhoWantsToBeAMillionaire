package mypackage;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

import static java.lang.Class.forName;

@WebServlet(name = "ChangeActive", urlPatterns = "/admin/ChangeActive")
public class ChangeActive extends CommonServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try (PreparedStatement stmt = conn.prepareStatement(
                "UPDATE users SET active = ~active WHERE username = ?")){
            String username = request.getParameter("username");
            stmt.setString(1, username);
            stmt.executeUpdate();
            request.setAttribute("user", username);
            request.getRequestDispatcher("result_change_active.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
