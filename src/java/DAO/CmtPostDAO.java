/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Connect.DBConnect_MySQL;
import Model.CommentPost;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author TramLuc
 */
public class CmtPostDAO {
    
    final static Connection cons = DBConnect_MySQL.getConnection();
    
    //tao cmt moi 
       public static boolean createUser(CommentPost cmt) throws SQLException {
        try {
            String sql = "INSERT INTO db_mxh.comment (SerialPost, UserCmtId, ContentsCmt, CmtDate) VALUE(?,?,?,?)";
            PreparedStatement ps = cons.prepareStatement(sql);

            ps.setInt(1, cmt.getSerialPost());
            ps.setInt(2, cmt.getUserCmtId());
            ps.setString(3, cmt.getContentsCmt());
            ps.setString(4, cmt.getCmtDate());

            int temp = ps.executeUpdate();
            return temp == 1;
        } catch (Exception e) {
            return false;

        }
    }
       
    //Sua cmt
       public static boolean editCmt(CommentPost cmt) throws SQLException {
    try {
         String sql = "UPDATE db_mxh.comment SET ContentsCmt=? WHERE CmtId= ?";
         PreparedStatement ps = cons.prepareCall(sql);
         
         ps.setString(1,cmt.getContentsCmt());
         ps.setInt(2,cmt.getCmtId());
         int temp = ps.executeUpdate();
         return temp == 1 ;
    } catch (Exception e) {
         return false;
    }

}  
     //Xoa cmt
        public static boolean deleteCmt(int cmtId) throws SQLException {
    
       try {
        String sql = "DELETE db_mxh.comment WHERE CmtId = ?";
        PreparedStatement ps = cons.prepareCall(sql);
        ps.setInt(1,cmtId);
        int temp = ps.executeUpdate();
            return true;
    } catch (Exception e) {
           System.out.println(e);
        return false;
    }
    }
        
        //Lay tat ca cmt trong 1 bai viet
        public static ArrayList<CommentPost> getAllPostBySerialPost(int serialPost) {
        String sql = "SELECT * FROM db_mxh.comment WHERE SerialPost LIKE '%"+serialPost+"%'";
        ArrayList<CommentPost> list = new ArrayList<>();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                CommentPost cmt = new CommentPost();
                cmt.setCmtId(rs.getInt("CmtId"));
                cmt.setSerialPost(rs.getInt("SerialPost"));
                cmt.setUserCmtId(rs.getInt("UserCmtId"));
                cmt.setContentsCmt(rs.getString("ContentsCmt"));
                cmt.setCmtDate(rs.getString("CmtDate"));
                
                list.add(cmt);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
