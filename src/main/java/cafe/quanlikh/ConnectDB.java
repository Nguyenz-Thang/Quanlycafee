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
            String url = ("jdbc:mysql://localhost:3306/capnhatsach?zeroDateTimeBehavior=CONVERT_TO_NULL");
            String user = "root";
            String pass  =  "";
            con = DriverManager.getConnection(url, user , pass);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }
}
