package mypackage;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

import static java.lang.Class.forName;

@WebServlet(name = "CourseEnter", urlPatterns = "/Courses")
public class CourseEnter extends CommonServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String course = request.getParameter("selected_course");
        if (course != null) {
            Subject currentUser = SecurityUtils.getSubject();
            String username = (String) currentUser.getPrincipal();
            try (Statement s = conn.createStatement()) {
                s.executeQuery("INSERT INTO course_student VALUES (" +
                        "(SELECT id FROM courses WHERE name = '" + course + "'), " +
                        "(SELECT student_id FROM users2 WHERE username = '" + username + "')" +
                        ")");
            } catch (SQLException ex) {
                System.out.println("SQLException: " + ex.getMessage());
                System.out.println("SQLState: " + ex.getSQLState());
                System.out.println("VendorError: " + ex.getErrorCode());
            }
            response.getWriter().write("You entered course " + course);
        } else {
            response.sendRedirect("index.jsp");
        }
    }

    protected ResultSet executeSelectQuery(String q) throws SQLException {
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(q);
        return rs;
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            try {
                ResultSet rs = executeSelectQuery("SELECT name FROM courses");
                List<String> courses = new LinkedList<String>();
                while (rs.next()) {
                    String course = new String(rs.getString("name"));
                    courses.add(course);
                }
                request.setAttribute("courses", courses);
                request.getRequestDispatcher("courses/enter_course.jsp").forward(request, response);
            } catch (SQLException ex) {
                System.out.println("SQLException: " + ex.getMessage());
                System.out.println("SQLState: " + ex.getSQLState());
                System.out.println("VendorError: " + ex.getErrorCode());
            }
    }
}
