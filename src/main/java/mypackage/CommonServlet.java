package mypackage;

import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServlet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import static java.lang.Class.forName;

public abstract class CommonServlet extends HttpServlet {
    protected Connection conn;

    public void init(ServletConfig config) {
        try {
            forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String dbUrl = "localhost:1433";
        String databaseName = "millioner";
        String username = "millioner";
        String password = "millioner";

        Properties info = new Properties();
        info.put("user", username);
        info.put("password", password);
        info.put("databaseName", databaseName);

        try {
            conn = DriverManager.getConnection("jdbc:sqlserver://" + dbUrl, info);
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
    }

    public void destroy() {
        //Close Connection
        try {
            if (conn != null && !conn.isClosed())
                conn.close();
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
    }
}
