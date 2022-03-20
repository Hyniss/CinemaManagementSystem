/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bảo Châu Bống
 */
public class DBContext {

    public static Connection getConnection() {
        try {
            String server = "localhost";
            String databasename = "Cinema";
            String username = "sa";
            String password = "123456";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            return DriverManager.getConnection("jdbc:sqlserver://" + server + ":1433;databaseName=" + databasename, username, password);

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

//    public static void close(Connection con, Statement stmt, ResultSet rs) {
//        if (stmt != null) {
//            try {
//                stmt.close();
//            } catch (SQLException ex) {
//                Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
//        if (con != null) {
//            try {
//                con.close();
//            } catch (SQLException ex) {
//                Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
//        if (rs != null) {
//            try {
//                rs.close();
//            } catch (SQLException ex) {
//                Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
//    }
//
//}
    public void closeConnection(java.sql.Connection con) { // đóng kết nối
        if (con != null) {
            try {
                con.close();
            } catch (SQLException ex) {
                System.err.println(ex);
            }
        }
    }

    /**
     * Close PrepareStatement to MSSQL Sever
     *
     * @param ps
     */
    public void closePreparedStatement(PreparedStatement ps) { // đóng biên dịch sql
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException ex) {
                System.err.println("Close PreparedStatement Fail!");
            }
        }
    }

    /**
     * Close ResultSet to MSSQL Sever
     *
     * @param rs
     */
    public void closeResultSet(ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException ex) {
                System.err.println("Close PreparedStatement Fail!");
            }
        }
    }
}
