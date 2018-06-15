package mypackage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;

@WebServlet(name = "AddQuestion", urlPatterns = "/admin/AddQuestion")
public class AddQuestion extends CommonServlet {

    protected void addQuestion(Question q) throws SQLException {
        PreparedStatement ps = conn.prepareStatement(
                "INSERT INTO questions VALUES (?, ?, ?, ?, ?, ?, ?)");

        ps.setInt(1, q.getDifficulty());
        ps.setString(2, q.getQ());
        ps.setString(3, q.getCorrect());
        ps.setString(4, q.getInc1());
        ps.setString(5, q.getInc2());
        ps.setString(6, q.getInc3());
        if (q.getBackground() == null || q.getBackground().length() < 2) {
            ps.setNull(7, Types.VARCHAR);
        } else {
            ps.setString(7, q.getBackground());
        }

        ps.executeUpdate();
        ps.close();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Question q = new Question(
                0   //doesn't matter
                ,Integer.parseInt(request.getParameter("difficulty"))
                ,request.getParameter("question")
                ,request.getParameter("correct")
                ,request.getParameter("inc1")
                ,request.getParameter("inc2")
                ,request.getParameter("inc3")
                ,request.getParameter("background")
        );
        try {
            addQuestion(q);
            request.getRequestDispatcher("result_add_question").forward(request, response);
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        response.sendRedirect("/");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("add_question.jsp").forward(request, response);
    }
}
