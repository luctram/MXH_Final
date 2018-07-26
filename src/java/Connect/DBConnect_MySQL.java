/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connect;

import Model.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author TramLuc
 */
public class DBConnect_MySQL {
public static Connection getConnection() {
        Connection cons = null;
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            if (cons == null){
                cons = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_mxh?user=root&password=root");
                System.out.println("Ket noi thanh cong");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.toString());
        }
        return cons;
    }

 
}
