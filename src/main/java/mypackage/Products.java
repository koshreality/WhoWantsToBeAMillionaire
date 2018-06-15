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

@WebServlet(name = "Products", urlPatterns = "/Products")
public class Products extends CommonServlet {

    protected Integer executeSelectQuery() throws SQLException {
        PreparedStatement ps = conn.prepareStatement(
                "SELECT prod_amount from products WHERE prod_name = ?");

        // set the preparedstatement parameters
        ps.setString(1, prod_name);

        Integer a = null;
        ResultSet rs = ps.executeQuery();
        if (rs.isBeforeFirst()) {
            rs.next();
            a = rs.getInt("prod_amount");
        }
        ps.close();
        return a;
    }

    protected void executeUpdateQuery() throws SQLException {
        PreparedStatement ps = conn.prepareStatement(
                "UPDATE products SET prod_amount = prod_amount + ? WHERE prod_name = ?");

        // set the preparedstatement parameters
        ps.setInt(1, user_amount);
        ps.setString(2, prod_name);

        // call executeUpdate to execute our sql update statement
        ps.executeUpdate();
        ps.close();
    }

    protected void executeInsertQuery() throws SQLException {
        PreparedStatement ps = conn.prepareStatement(
                "INSERT INTO products VALUES (?, ?)");

        // set the preparedstatement parameters
        ps.setString(1, prod_name);
        ps.setInt(2, user_amount);

        // call executeUpdate to execute our sql update statement
        ps.executeUpdate();
        ps.close();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String button = request.getParameter("action");
        if ("save".equals(button)) {
            try {
                if (prod_exists) {
                    executeUpdateQuery();
                } else {
                    executeInsertQuery();
                }
            } catch (SQLException ex) {
                System.out.println("SQLException: " + ex.getMessage());
                System.out.println("SQLState: " + ex.getSQLState());
                System.out.println("VendorError: " + ex.getErrorCode());
                response.sendRedirect("products_enter_data.jsp");
                return;
            }
        } else {
            response.sendRedirect("products_enter_data.jsp");
            return;
        }
        request.setAttribute("prod_name", prod_name);
        request.setAttribute("prod_amount", user_amount);
        request.getRequestDispatcher("result_product.jsp").forward(request, response);
    }

    String prod_name;
    int prod_amount;
    int user_amount;
    boolean prod_exists;


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        prod_name = request.getParameter("prod_name");
        if (prod_name == null || prod_name.length() == 0) {
            response.sendRedirect("products_enter_data.jsp");
            return;
        }
        String user_amount_s = request.getParameter("user_amount");
        if (user_amount_s != null) {
            try {
                user_amount = Integer.parseInt(user_amount_s);
            } catch (NumberFormatException ex) {
                response.sendRedirect("products_enter_data.jsp");
                return;
            }
        } else {
            response.sendRedirect("products_enter_data.jsp");
            return;
        }

        try {
            String msg;
            Integer a = executeSelectQuery(); // a - количество существующего продукта в базе, либо null если его нет
            if (a == null) {
                prod_exists = false;

                msg = "There is no product with name " + prod_name + "!\n" +
                        "Would you like to add " + user_amount_s + " of " + prod_name + " to database?";

            } else {
                prod_exists = true;
                prod_amount = a;
                msg = "There are " + prod_amount + " of " + prod_name;
            }

            request.setAttribute("msg", msg);
            request.getRequestDispatcher("products_confirm.jsp").forward(request, response);

        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
            response.sendRedirect("products_enter_data.jsp");
        }
    }
}
