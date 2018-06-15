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

@WebServlet(name = "SetScore", urlPatterns = "/Grades")
public class SetScore extends CommonServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String comment = request.getParameter("comment");
        Integer grade = Integer.parseInt(request.getParameter("grade"));
        String student = request.getParameter("student");
        if (student != null && grade != null) {
            Subject currentUser = SecurityUtils.getSubject();
            String username = (String) currentUser.getPrincipal();
            try (PreparedStatement s = conn.prepareStatement("INSERT INTO response VALUES (" +
                    "(SELECT lecturer_id FROM users2 WHERE username = ?), " +
                    "(SELECT id FROM students WHERE name = ?)," +
                    "?, ?)")) {
                s.setString(1, username);
                s.setString(2, student);
                s.setInt(3, grade);
                if (comment != null && comment.length() > 0) {
                    s.setString(4, comment);
                } else {
                    s.setString(4,"-");
                }
                s.executeUpdate();
            } catch (SQLException ex) {
                System.out.println("SQLException: " + ex.getMessage());
                System.out.println("SQLState: " + ex.getSQLState());
                System.out.println("VendorError: " + ex.getErrorCode());
            }
            response.getWriter().write("You gave response to student " + student);
        } else {
            response.sendRedirect("index.jsp");
        }
    }

    protected ResultSet executeSelectQuery() throws SQLException {
        PreparedStatement stmt = conn.prepareStatement(
                "SELECT DISTINCT students.name FROM users2, courses, course_student, students" +
                "  WHERE users2.lecturer_id = courses.lecturer_id" +
                "  AND courses.id = course_student.course_id" +
                "  AND course_student.student_id = students.id" +
                "  AND users2.username = ?");
        Subject currentUser = SecurityUtils.getSubject();
        String username = (String) currentUser.getPrincipal();
        stmt.setString(1, username);
        ResultSet rs = stmt.executeQuery();
        return rs;
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            ResultSet rs = executeSelectQuery();
            List<String> students = new LinkedList<String>();
            while (rs.next()) {
                String student = new String(rs.getString("name"));
                students.add(student);
            }
            request.setAttribute("students", students);
            request.getRequestDispatcher("grades/set_score.jsp").forward(request, response);
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
    }
}
