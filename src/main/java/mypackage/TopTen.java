package mypackage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

@WebServlet(name = "TopTen", urlPatterns = "/user/Top")
public class TopTen extends CommonServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<TopUser> topUsers = new LinkedList<>();
        try (Statement stmt2 = conn.createStatement()) {
            ResultSet rs = stmt2.executeQuery(
                    "SELECT DISTINCT f1.username, min(ts) as ts, f1.prize FROM finished_games f1\n" +
                        "INNER JOIN (\n" +
                        "  SELECT username, max(prize) as prize FROM finished_games\n" +
                        "  GROUP BY username\n" +
                        "           ) f2\n" +
                        "  ON f1.username = f2.username AND f1.prize = f2.prize\n" +
                        "GROUP BY f1.username, f1.prize ORDER BY f1.prize DESC, ts ASC");
            while (rs.next()) {
                TopUser user = new TopUser(
                        rs.getString("username"),
                        rs.getInt("prize"),
                        rs.getTimestamp("ts"));
                topUsers.add(user);
            }
            request.setAttribute("topusers", topUsers);
            request.getRequestDispatcher("top.jsp").forward(request, response);
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
    }
}
