/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cafe.quanlikh;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author gunna666
 */
public class ConnectDB {
    public static Connection KetnoiDB(){
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = ("jdbc:mysql://localhost:3306/quanlybancafe?zeroDateTimeBehavior=CONVERT_TO_NULL");
            String user = "root";
            String pass  =  "";
            con = DriverManager.getConnection(url, user , pass);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }
//    public static Connection KetnoiDB(){
//        Connection con = null;
//        try {
//            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//            String url = ("jdbc:sqlserver://localhost:1433;databaseName=quanlybancafe;encrypt=true;trustServerCertificate=true");
//            String user = "sa";
//            String pass  =  "12345";
//            con = DriverManager.getConnection(url, user , pass);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return con;
//    }
}
