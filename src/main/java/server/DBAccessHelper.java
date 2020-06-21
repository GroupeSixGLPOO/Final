package server;

import java.sql.*;

//代码复用;模块化

public class DBAccessHelper {
    private static DBAccessHelper dao;
    //
    private DBAccessHelper() { // private contructor
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    // get interface DAO
    public static DBAccessHelper getDAO() {
        if (dao == null)
            dao = new DBAccessHelper();
        return dao;
    }

    // get connection to database
    private Connection getConnection() {
        Connection conn=null;
        String url = "jdbc:mysql://localhost:3306/chatdb?serverTimezone=UTC&useSSL=false";
        String name = "root";
        String pass = "root";

        try {
            conn = DriverManager.getConnection(url, name, pass);
            System.out.println(conn);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return conn;
    }

    //Inquire execute()
    public void execute(String sqlString) {
        try {
            Connection conn = getConnection();
            PreparedStatement stmt = conn.prepareStatement(sqlString);
            stmt.execute();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


    // excuteQuary Inquire
    public ResultSet executeQuery(String sqlString) {
        ResultSet rs = null;
        try {
            Connection conn = getConnection();
            PreparedStatement stmt = conn.prepareStatement(sqlString);
            rs=stmt.executeQuery();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return rs;
    }
}
