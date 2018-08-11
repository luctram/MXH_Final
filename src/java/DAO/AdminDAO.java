/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import Connect.DBConnect_MySQL;
import Model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author TramLuc
 */
public class AdminDAO {
    //Lay username vs pass 
    public static ArrayList<User> getAcc() throws SQLException {
        Connection cons = DBConnect_MySQL.getConnection();
        if (cons == null) {
            System.out.println("loi");
            return null;
        
        }else {
            System.out.println(cons.toString());
        }
        String sql = "SELECT AdminName,Password FROM db_mxh.adminuser" ;
        ArrayList<User> user = new ArrayList<>();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                User u = new User();
                u.setUserName(rs.getString("AdminName"));
                u.setPassword(rs.getString("Password"));
                user.add(u);
            }
            
        }
        catch(SQLException e){
       
            e.printStackTrace();
        }
        return user;
    }
}
