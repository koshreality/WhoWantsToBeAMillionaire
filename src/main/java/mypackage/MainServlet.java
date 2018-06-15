package mypackage;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

import static java.lang.Class.forName;

@javax.servlet.annotation.WebServlet(urlPatterns = "/admin/GetUsers", name = "MainServlet")
public class MainServlet extends CommonServlet {

    protected ResultSet executeSelectQuery(String sql) throws SQLException {
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        return rs;
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            ResultSet rs = executeSelectQuery("SELECT * FROM users");
            List<UserInfo> users = new LinkedList<UserInfo>();
            while (rs.next()) {
                UserInfo ui = new UserInfo(
                         rs.getString("username")
                        ,rs.getString("password")
                        ,rs.getBoolean("active")
                );
                users.add(ui);
            }
            request.setAttribute("users", users);
            request.getRequestDispatcher("result_users.jsp").forward(request, response);
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
    }
}
