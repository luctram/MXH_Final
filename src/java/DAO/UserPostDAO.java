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
            String sql = "INSERT INTO db_mxh.userpost (UserId, DatePost, Contents, Link, CountLike) VALUE(?,?,?,?,?)";
            PreparedStatement ps = cons.prepareStatement(sql);

            ps.setInt(1, uPost.getUserId());
            ps.setString(2, uPost.getDate());
            ps.setString(3, uPost.getContent());
            ps.setString(4, uPost.getImgVideoLink());
            ps.setInt(5, uPost.getCountLike());
            int temp = ps.executeUpdate();
            return temp == 1;
        } catch (Exception e) {
            return false;

        }
    }
    
//Sua bai dang
    public static boolean editPost(UserPost uPost) throws SQLException {
    try {
         String sql = "UPDATE db_mxh.userpost SET Contents=?, Link= ? WHERE PostId= ?";
         PreparedStatement ps = cons.prepareCall(sql);
         
         ps.setString(1,uPost.getContent());
         ps.setString(2,uPost.getImgVideoLink());
         ps.setInt(3,uPost.getPostId());
         int temp = ps.executeUpdate();
         return temp == 1 ;
    } catch (Exception e) {
         return false;
    }

}
    
    //Sua like
    public static boolean editCountLike(UserPost uPost) throws SQLException {
    try {
         String sql = "UPDATE db_mxh.userpost SET CountLike=? WHERE PostId= ?";
         PreparedStatement ps = cons.prepareCall(sql);
         
         ps.setInt(1,uPost.getCountLike());
         ps.setInt(2,uPost.getPostId());
         int temp = ps.executeUpdate();
         return temp == 1 ;
    } catch (Exception e) {
         return false;
    }

}

    //Xoa bai dang
     public static boolean deletePost(int idpost) throws SQLException {
    
       try {
        String sql = "DELETE FROM db_mxh.userpost WHERE PostId = '" + idpost +"'";
        PreparedStatement ps = cons.prepareCall(sql);
           System.out.println("SQL: "+sql);
     
        int temp = ps.executeUpdate();
            return true;
    } catch (Exception e) {
           System.out.println(e);
        return false;
    }
    }
     
     //Lay tat ca bai viet
      public static ArrayList<UserPost> getAllPostByUserid(int Userid) {
        String sql = "SELECT * FROM db_mxh.userpost WHERE UserId LIKE '%"+Userid+"%'";
        ArrayList<UserPost> list = new ArrayList<UserPost>();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                UserPost uPost = new UserPost();
                uPost.setUserId(rs.getInt("UserId"));
                uPost.setPostId(rs.getInt("PostId"));
                uPost.setDate(rs.getString("DatePost"));
                uPost.setContent(rs.getString("Contents"));
                uPost.setImgVideoLink(rs.getString("Link"));
                uPost.setCountLike(rs.getInt("CountLike"));
                list.add(uPost);
            }
           
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
      
      //Lay 1 bai viet
      public static UserPost get1Post(int postid) {
        String sql = "SELECT * FROM db_mxh.userpost WHERE PostId LIKE '%"+postid+"%'";
                        UserPost uPost = new UserPost();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                uPost.setUserId(rs.getInt("UserId"));
                uPost.setPostId(rs.getInt("PostId"));
                uPost.setDate(rs.getString("DatePost"));
                uPost.setContent(rs.getString("Contents"));
                uPost.setImgVideoLink(rs.getString("Link"));
                uPost.setCountLike(rs.getInt("CountLike"));
           
            }
           
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return uPost;
    }
}