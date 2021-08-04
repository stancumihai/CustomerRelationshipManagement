package com.stancu.testdb;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.io.Serial;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Servlet implementation class TestDbServlet
 */
@WebServlet("/TestDbServlet")
public class TestDbServlet extends HttpServlet {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException {

        // setup connection variables
        String user = "springstudent";
        String pass = "springstudent";

        String jdbcUrl = "jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false&serverTimezone=UTC";
        String driver = "com.mysql.cj.jdbc.Driver";

        // get connection to database
        try {
            PrintWriter out = response.getWriter();

            out.println("Connecting to database: " + jdbcUrl);

            Class.forName(driver);

            Connection myConn = DriverManager.getConnection(jdbcUrl, user, pass);

            out.println("SUCCESS!!!");

            myConn.close();

        } catch (Exception exc) {
            exc.printStackTrace();
            throw new ServletException(exc);
        }
    }

    private void close() {
    }

    public void setDriverClass(String driverClass) {
    }

    public void setJdbcUrl(String jdbcUrl) {
    }

    public void setUser(String user) {
    }

    public void setPassword(String password) {
    }

    public void setMinPoolSize(String minPoolSize) {
    }

    public void setMaxPoolSize(String maxPoolSize) {
    }

    public void setMaxIdleTime(String maxIdleTime) {
    }
}







