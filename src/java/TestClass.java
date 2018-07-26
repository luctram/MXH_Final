

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author TramLuc
 */
public class TestClass {
     public static void main(String []args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
        Connection cons = null;
        Class.forName("com.mysql.jdbc.Driver").newInstance();
            if (cons == null){
                cons = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_mxh?user=root&password=root");
            }
         String sql = "SELECT Username FROM db_mxh.user";
           PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            rs.next();
            System.out.println(rs.getString("Username"));
     System.out.println("OK");
}

}
