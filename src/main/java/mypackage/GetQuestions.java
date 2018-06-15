package mypackage;

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

@WebServlet(name = "GetQuestions", urlPatterns = "/admin/GetQuestions")
public class GetQuestions extends CommonServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Question> questions = new LinkedList<>();
        try (Statement stmt2 = conn.createStatement()) {
            ResultSet rs = stmt2.executeQuery("SELECT * FROM questions");
            while (rs.next()) {
                Question question = new Question(
                        rs.getInt("id")
                        ,rs.getInt("Difficulty")
                        ,rs.getString("Question")
                        ,rs.getString("Correct Answer")
                        ,rs.getString("Answer_2")
                        ,rs.getString("Answer_3")
                        ,rs.getString("Answer_1")
                        ,rs.getString("Background information")
                );
                questions.add(question);
            }
            request.setAttribute("questions", questions);
            request.getRequestDispatcher("result_questions.jsp").forward(request, response);
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
    }
}
