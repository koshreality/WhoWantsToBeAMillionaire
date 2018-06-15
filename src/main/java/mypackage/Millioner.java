package mypackage;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static java.lang.Class.forName;

@WebServlet(name = "Millioner", urlPatterns = "/millioner/game")
public class Millioner extends CommonServlet {

    Question getRandomQuestion(int difficulty) {
        try (PreparedStatement ps = conn.prepareStatement(
                "SELECT TOP 1 * from questions " +
                        "WHERE Difficulty = ? " +
                        "AND id NOT IN (" +
                            "SELECT question_id FROM current_games " +
                            "WHERE username = ?" +
                        ") " +
                        "ORDER BY NEWID()")) {

            Subject currentUser = SecurityUtils.getSubject();
            String username = (String) currentUser.getPrincipal();

            ps.setInt(1, difficulty);
            ps.setString(2, username);

            ResultSet rs = ps.executeQuery();
            rs.next();
            Question q = new Question(
                    rs.getInt("id")
                    , rs.getInt("Difficulty")
                    , rs.getString("Question")
                    , rs.getString("Correct Answer")
                    , rs.getString("Answer_2")
                    , rs.getString("Answer_3")
                    , rs.getString("Answer_1")
                    , rs.getString("Background information")
            );
            return q;
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        return null;
    }

    Question getQuestion(int id) {
        try (PreparedStatement ps = conn.prepareStatement(
                "SELECT * FROM questions WHERE id = ?")) {

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            rs.next();
            Question q = new Question(
                    rs.getInt("id")
                    , rs.getInt("Difficulty")
                    , rs.getString("Question")
                    , rs.getString("Correct Answer")
                    , rs.getString("Answer_2")
                    , rs.getString("Answer_3")
                    , rs.getString("Answer_1")
                    , rs.getString("Background information")
            );
            return q;
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        return null;
    }

    int question_number;
    int max_question_number;
    int current_money;
    int fail_money;
    boolean fireproof;
    Question current_question;
    List<Answer> answers = new ArrayList<>();
    boolean have_fifty;
    boolean have_help;
    boolean have_friend;

    int getFailMoney(int question_index) {
        if (question_index == 0) return 0;
        try (PreparedStatement stmt = conn.prepareStatement(
                "SELECT TOP 1 money FROM money " +
                        "WHERE level <= ? AND fireproof = 1 " +
                        "ORDER BY money DESC")) {
            stmt.setInt(1, question_index-1);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            return rs.getInt("money");
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        return 0;
    }

    void updateMoney(int question_index) {
        if (question_index == 0) {
            current_money = 0;
            fail_money = 0;
            fireproof = false;
        }
        try (PreparedStatement stmt = conn.prepareStatement(
            "SELECT money FROM money WHERE level = ?")) {
            stmt.setInt(1, question_index-1);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            current_money = rs.getInt("money");
            fail_money = getFailMoney(question_index);
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
    }

    void retrieveState() {
        try (PreparedStatement stmt = conn.prepareStatement(
        "SELECT question_id, ts, count(*) OVER (PARTITION BY 1) AS c " +
            "FROM current_games " +
            "WHERE username = ? ORDER BY ts DESC"))
        {
            Subject currentUser = SecurityUtils.getSubject();
            String username = (String) currentUser.getPrincipal();
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();
            if (rs.isBeforeFirst()) {
                rs.next();
                question_number = rs.getInt("c") - 1;
                current_question = getQuestion(rs.getInt("question_id"));
                updateMoney(question_number);
            } else {
                have_fifty = true;
                have_help = true;
                have_friend = true;
                fireproof = false;
                question_number = 0;
                current_money = 0;
                fail_money = 0;
                current_question = getRandomQuestion(0);
                saveState();
            }
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        try (PreparedStatement stmt = conn.prepareStatement(
                "SELECT fifty, friend, help  FROM users " +
                        "WHERE username = ?"))
        {
            Subject currentUser = SecurityUtils.getSubject();
            String username = (String) currentUser.getPrincipal();
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();
            if (rs.isBeforeFirst()) {
                rs.next();
                have_fifty = rs.getBoolean("fifty");
                have_friend = rs.getBoolean("friend");
                have_help = rs.getBoolean("help");
            }
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
    }

    void end_game() {
        Subject currentUser = SecurityUtils.getSubject();
        String username = (String) currentUser.getPrincipal();
        try (PreparedStatement stmt = conn.prepareStatement(
        "INSERT INTO finished_games (username, prize) VALUES (?, ?)"))
        {
            stmt.setString(1, username);
            stmt.setInt(2, fail_money);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        try (PreparedStatement stmt = conn.prepareStatement(
                "DELETE FROM current_games WHERE username = ?"))
        {
            stmt.setString(1, username);
            stmt.executeUpdate();
            setHaveFifty(true);
            setHaveFriend(true);
            setHaveHelp(true);
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
    }

    void setHaveFifty(boolean have) {
        have_fifty = have;
        try (PreparedStatement stmt = conn.prepareStatement(
                "UPDATE users SET fifty = ? " +
                    "WHERE username = ?"
        )) {
            Subject currentUser = SecurityUtils.getSubject();
            String username = (String) currentUser.getPrincipal();
            stmt.setBoolean(1, have);
            stmt.setString(2, username);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
    }

    void setHaveFriend(boolean have) {
        have_friend = have;
        try (PreparedStatement stmt = conn.prepareStatement(
                "UPDATE users SET friend = ? " +
                        "WHERE username = ?"
        )) {
            Subject currentUser = SecurityUtils.getSubject();
            String username = (String) currentUser.getPrincipal();
            stmt.setBoolean(1, have);
            stmt.setString(2, username);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
    }

    void setHaveHelp(boolean have) {
        have_help = have;
        try (PreparedStatement stmt = conn.prepareStatement(
                "UPDATE users SET help = ? " +
                        "WHERE username = ?"
        )) {
            Subject currentUser = SecurityUtils.getSubject();
            String username = (String) currentUser.getPrincipal();
            stmt.setBoolean(1, have);
            stmt.setString(2, username);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
    }

    void saveState() {
        try (PreparedStatement stmt = conn.prepareStatement(
                "INSERT INTO current_games (username, question_id) " +
                        "VALUES (?, ?)")) {
            Subject currentUser = SecurityUtils.getSubject();
            String username = (String) currentUser.getPrincipal();
            stmt.setString(1, username);
            stmt.setInt(2, current_question.getId());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
    }

    void next(HttpServletRequest request, HttpServletResponse response, boolean half) throws ServletException, IOException {
        answers.clear();
        answers.add(new Answer(current_question.getCorrect(), true));
        answers.add(new Answer(current_question.getInc1(), false));
        if (half == false) {
            answers.add(new Answer(current_question.getInc2(), false));
            answers.add(new Answer(current_question.getInc3(), false));
        } else {
            setHaveFifty(false);
        }
        Collections.shuffle(answers);
        repeat(request, response);
    }

    void repeat(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("fifty", have_fifty);
        request.setAttribute("help", have_help);
        request.setAttribute("friend", have_friend);
        request.setAttribute("question", current_question.getQ());
        request.setAttribute("background", current_question.getBackground());
        request.setAttribute("answers", answers);
        request.setAttribute("q_num", question_number);
        request.setAttribute("cur_money", current_money);
        request.setAttribute("fail_money", fail_money);
        request.getRequestDispatcher("game.jsp").forward(request, response);
    }

    void help(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int count = answers.size();
        int randomNum = ThreadLocalRandom.current().nextInt(
                Math.max(100 - 50 * (question_number / 5 + 1), 0),
                100 - 12 * (question_number / 5 + 1)
        );
        int sum = randomNum;
        int i = 0;
        for (Answer a : answers) {
            ++i;
            if (a.correct) {
                a.add = " (" + randomNum + "%)";
            } else if (i < count) {
                int randomNum2 = ThreadLocalRandom.current().nextInt(
                        0,
                        100 - sum + 1);
                sum += randomNum2;
                a.add = " (" + randomNum2 + "%)";
            } else {
                a.add = " (" + (100 - sum) + "%)";
            }
        }
        setHaveHelp(false);
        repeat(request, response);
    }

    void friend(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (ThreadLocalRandom.current().nextInt(0, 100) > question_number * 5) {
            for (Answer a : answers) {
                if (a.correct) {
                    a.add = " (friend's advice)";
                }
            }
        } else {
            answers.get(ThreadLocalRandom.current().nextInt(0, answers.size())).text += " (friend's advice)";
        }
        setHaveFriend(false);
        repeat(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String answer = request.getParameter("answer");
        String fifty = request.getParameter("fifty");
        String help = request.getParameter("help");
        String friend = request.getParameter("friend");
        String money = request.getParameter("money");
        String start = request.getParameter("start");
        if (start != null) {
            retrieveState();
            next(request, response, false);
        }
        if (answer != null) {
            if (answer.equals(current_question.getCorrect())) {
                question_number++;
                updateMoney(question_number);
                if (question_number == max_question_number) {
                    end_game();
                    request.setAttribute("money", current_money);
                    request.getRequestDispatcher("win.jsp").forward(request, response);
                }
                current_question = getRandomQuestion(question_number / 3);
                saveState();
                retrieveState();
                next(request, response, false);
            } else if (answer.equals(current_question.getInc1())
                    || answer.equals(current_question.getInc2())
                    || answer.equals(current_question.getInc3())){
                end_game();
                request.setAttribute("money", fail_money);
                request.getRequestDispatcher("game_over.jsp").forward(request, response);
            } else {
                retrieveState();
                repeat(request, response);
            }
        } else if (fifty != null) {
            if (have_fifty) {
                next(request, response, true);
            } else {
                retrieveState();
                repeat(request, response);
            }
        } else if (help != null) {
            if (have_help) {
                help(request, response);
            } else {
                retrieveState();
                repeat(request, response);
            }
        } else if (friend != null) {
            if (have_friend) {
                friend(request, response);
            } else {
                retrieveState();
                repeat(request, response);
            }
        } else if (money != null) {
            fail_money = current_money;
            end_game();
            request.setAttribute("money", fail_money);
            retrieveState();
            request.getRequestDispatcher("game_over.jsp").forward(request, response);
        } else {
            response.sendRedirect("/millioner");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("/millioner");
    }
}