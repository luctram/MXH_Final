/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Connect.DBConnect_MySQL;
import Model.UserPost;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author TramLuc
 */
public class UserPostDAO {

    final static Connection cons = DBConnect_MySQL.getConnection();
    
//Bai dang moi
    public static boolean createPost(UserPost uPost) throws SQLException {
        try {
            String sql = "INSERT INTO db_mxh.userpost (Username, DatePost, Contents, ImgLink,VideoLink) VALUE(?,?,?,?,?)";
            PreparedStatement ps = cons.prepareStatement(sql);

            ps.setString(1, uPost.getUserName());
            ps.setString(2, uPost.getDate());
            ps.setString(3, uPost.getContent());
            ps.setString(4, uPost.getImgLink());
            ps.setString(5, uPost.getVideoLink());
            int temp = ps.executeUpdate();
            return temp == 1;
        } catch (Exception e) {
            return false;

        }
    }
    
//Sua bai dang
    public static boolean editPost(UserPost uPost) throws SQLException {
    try {
         String sql = "UPDATE db_mxh.userpost SET Contents=?, ImgLink= ? , VideoLink= ? WHERE Username= ?";
         PreparedStatement ps = cons.prepareCall(sql);
         
         ps.setString(1,uPost.getContent());
         ps.setString(2,uPost.getImgLink());
         ps.setString(3,uPost.getVideoLink());
         ps.setString(4,uPost.getUserName());
         int temp = ps.executeUpdate();
         return temp == 1 ;
    } catch (Exception e) {
         return false;
    }

}

    //Xoa bai dang
     public static boolean deletePost(String Username) throws SQLException {
    
       try {
        String sql = "DELETE db_mxh.userpost WHERE Username = ?";
        PreparedStatement ps = cons.prepareCall(sql);
        ps.setString(1,Username);
        int temp = ps.executeUpdate();
            return true;
    } catch (Exception e) {
           System.out.println(e);
        return false;
    }
    }
     
     //Lay tat ca bai viet
      public static ArrayList<UserPost> getAllPostByUsername(String Username) {
        String sql = "SELECT * FROM db_mxh.userpost WHERE Username LIKE '%"+Username+"%'";
        ArrayList<UserPost> list = new ArrayList<UserPost>();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                UserPost uPost = new UserPost();
                uPost.setUserName(rs.getString("Username"));
                uPost.setSerial(rs.getInt("Serial"));
                uPost.setDate(rs.getString("DatePost"));
                uPost.setContent(rs.getString("Contents"));
                uPost.setImgLink(rs.getString("ImgLink"));
                uPost.setUserName(rs.getString("VideoLink"));
                list.add(uPost);
            }
            cons.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}