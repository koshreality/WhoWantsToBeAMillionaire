package mypackage;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

@WebServlet(name = "UserHistory", urlPatterns = "/user/History")
public class UserHistory extends CommonServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try (PreparedStatement stmt = conn.prepareStatement("SELECT * FROM finished_games WHERE username = ?")) {
            Subject currentUser = SecurityUtils.getSubject();
            String username = (String) currentUser.getPrincipal();
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();
            if (rs.isBeforeFirst()) {
                List<FinishedGame> fg = new LinkedList<>();
                while (rs.next()) {
                    fg.add(new FinishedGame(rs.getInt("prize"), rs.getTimestamp("ts")));
                }
                request.setAttribute("fgs", fg);
                request.getRequestDispatcher("result_history.jsp").forward(request, response);
            }
            else {
                response.getWriter().write("You have not played yet");
            }
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
    }
}
