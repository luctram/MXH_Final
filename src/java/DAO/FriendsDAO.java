/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Connect.DBConnect_MySQL;
import Model.Friends;
import Model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author TramLuc
 */
public class FriendsDAO {
    final static Connection cons = DBConnect_MySQL.getConnection();
    //Get All Friend By Username
    public static ArrayList<Friends> getAllFriendByUserId(int userid) {
        ArrayList<Friends> list = new ArrayList<Friends>();
        String sql1 = "SELECT * FROM db_mxh.friendlist WHERE UserId = '"+userid+"' AND Status='Friend'";
        
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql1);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Friends friend = new Friends();
                friend.setUserId(rs.getInt("UserId"));
                friend.setFriendId(rs.getInt("FriendId"));
                friend.setDate(rs.getString("Date"));
                list.add(friend);
            }
        } 
        catch (SQLException e) {
            e.printStackTrace();
        }
        
        String sql2 = "SELECT * FROM db_mxh.friendlist WHERE FriendId = '"+userid+"' AND Status='Friend'";
         try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql2);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Friends friend = new Friends();
                friend.setUserId(rs.getInt("FriendId"));
                friend.setFriendId(rs.getInt("UserId"));
                friend.setDate(rs.getString("Date"));
                list.add(friend);
            }
        } 
        catch (SQLException e) {
            e.printStackTrace();
        }
         
        return list;
    }
    
     //Get request make Friend By Username
    public static ArrayList<Friends> getRequestFriendByUserid(int userid) {
        String sql = "SELECT * FROM db_mxh.friendlist WHERE UserId = '"+userid+"' and Status='Unconfirmed'";
        ArrayList<Friends> list = new ArrayList<Friends>();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Friends friend = new Friends();
                friend.setUserId(rs.getInt("UserId"));
                friend.setFriendId(rs.getInt("FriendId"));
                friend.setDate(rs.getString("Date"));
                list.add(friend);
            }
        } 
        catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    
     //Get request be maked Friend By Username
    public static ArrayList<Friends> getRequestFromFriendByUserid(int userid) {
        String sql = "SELECT * FROM db_mxh.friendlist WHERE FriendId = '"+userid+"' and Status='Unconfirmed'";
        ArrayList<Friends> list = new ArrayList<Friends>();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Friends friend = new Friends();
                friend.setUserId(rs.getInt("UserId"));
                friend.setFriendId(rs.getInt("FriendId"));
                friend.setDate(rs.getString("Date"));
                list.add(friend);
            }
        } 
        catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    
    // Search User By Username or Name or Phone or Email
    public static User searchUser(String search){
        String sql = "SELECT Username,Name,Phone,Email,Address,Avatar FROM db_mxh.user WHERE Username='"  + search +"' OR Phone ='" + search +"' OR Email = '" + search + "'";
        User user = new User();
       try{ 
           PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                
                user.setUserName(rs.getString("Username"));
                user.setName(rs.getString("Name"));
                user.setPhone(rs.getString("Phone"));
                user.setEmail(rs.getString("Email"));
                user.setAddress(rs.getString("Address"));
                user.setAvatarLink(rs.getString("Avatar"));
            }
           
           rs.close();
       }
       catch (SQLException e) {
            e.printStackTrace();
        }
       return user;
    }
    
    //Add New Friend By Username
    public static boolean AddNewFriend(Friends friend) throws SQLException {
        try {
            String sql = "INSERT INTO db_mxh.friendlist (UserId, FriendId,Date,Status) VALUE(?,?,?,?)";
            PreparedStatement ps = cons.prepareStatement(sql);
            
            ps.setInt(1, friend.getUserId());
            ps.setInt(2, friend.getFriendId());
            ps.setString(3,friend.getDate());
            ps.setString(4,friend.getStatus());
            int temp = ps.executeUpdate();
            return temp == 1;
        } catch (Exception e) {
            return false;

        }
    }
    
    
    //get id from username and friendname 
    public static int getId(int userid, int friendid){
        int result = 0;
        try {
          
            String sql ="Select FriendListId FROM db_mxh.friendlist WHERE UserId = '"+userid +"' AND FriendId= '" +friendid+"'";
            System.out.println("SQL: " +sql);
            PreparedStatement ps = cons.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                
                result= rs.getInt("FriendListId");         
            }
        }catch (Exception e) {
    }
        return result;
         
    }
    //Delete Friend by username and friend name
    public static boolean deleteFriend(int id) throws SQLException {
    
       try {
          
        String sql = "DELETE FROM db_mxh.friendlist WHERE FriendListId = " + id;
        PreparedStatement ps = cons.prepareCall(sql);
        int temp = ps.executeUpdate();
            return true;
    } catch (Exception e) {
           System.out.println(e);
        return false;
    }
    }

 
    
}
