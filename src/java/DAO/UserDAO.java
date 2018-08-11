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
public class UserDAO {
  
//Tao tai khoan moi
   public static boolean createUser(User user) throws SQLException {
    Connection cons = DBConnect_MySQL.getConnection();
    try {
         String sql = "INSERT INTO db_mxh.user (Username, Name, Password, Phone, Email,  BDay, Address, Hometown, Hobby, Avatar) VALUE(?,?,?,?,?,?,?,?,?,?)";
    
         PreparedStatement ps = cons.prepareStatement(sql);
  
         ps.setString(1, user.getUserName());
         ps.setString(2,user.getName());
         ps.setString(3,user.getPassword());
         ps.setString(4, user.getPhone());
         ps.setString(5, user.getEmail());
         ps.setString(6,user.getBDay());
         ps.setString(7,user.getAddress());
         ps.setString(8,user.getHometown());
         ps.setString(9,user.getHobby());
         ps.setString(10,user.getAvatarLink());
         int temp = ps.executeUpdate();
       
         return temp == 1 ;
    } catch (Exception e) {
         return false;
    }
}
   
   //get Id from username
   public static int getId(String username){
       Connection cons = DBConnect_MySQL.getConnection();
       int id = 0;
         String sql = "SELECT UserId FROM db_mxh.user where Username='" + username+"'";
         try{
         PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
         ResultSet rs = ps.executeQuery();
         while(rs.next()){
              id = rs.getInt("UserId");
         }
        }catch(SQLException e){
    
            e.printStackTrace();
        }
       return id;
   }
   
   //Lấy Username,phone, email có ton tai chua?
   public static List<User> GetUsernameAndPhoneAndEmailToCheck() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
    Connection cons = DBConnect_MySQL.getConnection();
         String sql = "SELECT Username,Phone, Email FROM db_mxh.user ";
        List<User> user = new ArrayList<>();
  try {
      PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
         while(rs.next()){
                User u = new User();
                u.setUserName(rs.getString("Username"));
                u.setPhone(rs.getString("Phone"));
                u.setEmail(rs.getString("Email"));
                user.add(u);
            }
    } catch (SQLException e) {
         
        e.printStackTrace();
         
    }
  return user;
}
// Lay thong tin hien thi trang chu sau khi dang nhap
   public static String getNameToShowHomePage(int userid) throws SQLException{
       String name = null;;
        Connection cons = DBConnect_MySQL.getConnection();
        try{
         String sql = "SELECT Name FROM db_mxh.user WHERE UserId='" + userid +"'";
         PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
         ResultSet rs = ps.executeQuery();
         while(rs.next()){
              name = rs.getString("Name");
         }
        }catch(SQLException e){
    
            e.printStackTrace();
        }
       return name;
   }
   
   // Lay thong tin hien thi trang chu sau khi dang nhap
   public static String getAvatarToShowHomePage(int userid) throws SQLException{
       String link = null;;
        Connection cons = DBConnect_MySQL.getConnection();
        try{
         String sql = "SELECT Avatar FROM db_mxh.user WHERE UserId='" + userid +"'";
         PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
         ResultSet rs = ps.executeQuery();
         while(rs.next()){
              link = rs.getString("Avatar");
         }
        }catch(SQLException e){
   
            e.printStackTrace();
        }
       return link;
   }
   
   
   //Lay username vs pass 
    public static ArrayList<User> getAcc() throws SQLException {
        Connection cons = DBConnect_MySQL.getConnection();
        if (cons == null) {
            System.out.println("loi");
            return null;
        
        }else {
            System.out.println(cons.toString());
        }
        String sql = "SELECT Username,Password FROM db_mxh.user" ;
        ArrayList<User> user = new ArrayList<>();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                User u = new User();
                u.setUserName(rs.getString("Username"));
                u.setPassword(rs.getString("Password"));
                user.add(u);
            }
            
        }
        catch(SQLException e){
       
            e.printStackTrace();
        }
        return user;
    }
    
    //Kiem tra phone + email để được reset pass
    public static String getPhoneAndEmailByUseridToCheck(int userid){
        Connection cons = DBConnect_MySQL.getConnection();
        String sql= "SELECT Phone, Email FROM db_mxh.user WHERE UserId='"+ userid +"'";
        String phone = null, email=null;
        try{
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
            phone= rs.getString("Phone");
            email = rs.getString("Email");
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return (phone +"/" + email);
    }
    
    //Doi pass
    public static boolean ChangePass(User u) throws SQLException{
        Connection cons = DBConnect_MySQL.getConnection();
         try {
         String sql = "UPDATE db_mxh.user SET Password=? WHERE UserId = ?";
         PreparedStatement ps = cons.prepareCall(sql);
             
         ps.setString(1, u.getPassword());
         ps.setInt(2, u.getUserId());

         int temp = ps.executeUpdate();
         System.out.println(sql);
         return temp == 1 ;
    } catch (Exception e) {
         return false;
    }
         
    }
    //Lay tat ca thong tin cua 1 user
    public static User getInfoByUserId(int userid){
        Connection cons = DBConnect_MySQL.getConnection();
         User u = new User();
        try{
            String sql="SELECT * FROM db_mxh.user WHERE UserId = '" +userid + "'";
             PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                u.setUserName(rs.getString("Username"));
                u.setBDay(rs.getString("BDay"));
                u.setAddress(rs.getString("Address"));
                u.setHometown(rs.getString("Hometown"));
                u.setEmail(rs.getString("Email"));
                u.setPhone(rs.getString("Phone"));
                u.setHobby(rs.getString("Hobby")); 
                u.setName(rs.getString("Name"));
                u.setAvatarLink(rs.getString("Avatar"));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return u;
    }
    
    //Sua thong tin
    public static boolean editUser(User user) throws SQLException {
        Connection cons = DBConnect_MySQL.getConnection();
    try {
         String sql = "UPDATE db_mxh.user SET Name=?,Phone= ?, Email=?, Hometown=?, Address=?,Hobby=? WHERE UserId= ?";
         PreparedStatement ps = cons.prepareCall(sql);
                 
         ps.setString(1,user.getName());
         ps.setString(2,user.getPhone());
         ps.setString(3,user.getEmail());
         ps.setString(4, user.getHometown());
         ps.setString(5, user.getAddress());
       //  ps.setString(7, user.getBDay());
         ps.setString(6, user.getHobby());
         ps.setInt(7,user.getUserId());
         int temp = ps.executeUpdate();
         
         return temp == 1 ;
    } catch (Exception e) {
         return false;
    }
} 
    
     //Sua hinh dai dien
       public static boolean editAvatar(User user) throws SQLException {
            Connection cons = DBConnect_MySQL.getConnection();
    try {
         String sql = "UPDATE db_mxh.user SET Avatar= ? WHERE UserId= ?";
         PreparedStatement ps = cons.prepareCall(sql);
         ps.setString(1,user.getAvatarLink());
         ps.setInt(2,user.getUserId());
         int temp = ps.executeUpdate();
         return temp == 1 ;
    } catch (Exception e) {
         return false;
    }

}  

}
