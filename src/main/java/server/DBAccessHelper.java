package server;

import java.sql.*;

//代码复用;模块化

public class DBAccessHelper {
    private static DBAccessHelper dao;
    // 加载驱动
    private DBAccessHelper() { // private构造函数
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    // 希望只执行一次
    public static DBAccessHelper getDAO() {
        if (dao == null)
            dao = new DBAccessHelper();
        return dao;
    }
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
    //无结果返回的查询execute()
    public void execute(String sqlString) {
        try {
            Connection conn = getConnection();
            PreparedStatement stmt = conn.prepareStatement(sqlString);// 变量在try外初始化
            stmt.execute();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    // 查询语句
    // excuteQuary有返回值，execute返回值！
    public ResultSet executeQuery(String sqlString) {
        ResultSet rs = null;
        try {
            Connection conn = getConnection();
            PreparedStatement stmt = conn.prepareStatement(sqlString);// 变量在tyr外初始化
            rs=stmt.executeQuery();        //出错了，打印成了.execute

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return rs;
    }
}
