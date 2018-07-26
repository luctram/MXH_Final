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
    public static ArrayList<Friends> getAllFriendByUsername(String Username) {
        String sql = "SELECT * FROM db_mxh.friendid WHERE Username LIKE '%"+Username+"%'";
        ArrayList<Friends> list = new ArrayList<Friends>();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Friends friend = new Friends();
                friend.setUsername(rs.getString("Username"));
                friend.setFriendName(rs.getString("FriendName"));
                list.add(friend);
            }
            cons.close();
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
           
           cons.close();
       }
       catch (SQLException e) {
            e.printStackTrace();
        }
       return user;
    }
    
    //Add New Friend By Username
    public static boolean AddNewFriend(Friends friend) throws SQLException {
        try {
            String sql = "INSERT INTO db_mxh.friendid (Username, FriendName) VALUE(?,?)";
            PreparedStatement ps = cons.prepareStatement(sql);

            ps.setString(1, friend.getUserName());
            ps.setString(2, friend.getFriendName());
            int temp = ps.executeUpdate();
            return temp == 1;
        } catch (Exception e) {
            return false;

        }
    }
    //Delete Friend by username and friend name
    public static boolean deleteFriend(String Username, String Friendname) throws SQLException {
    
       try {
        String sql = "DELETE db_mxh.friendid WHERE Username = ? AND FriendName= ?";
        PreparedStatement ps = cons.prepareCall(sql);
        ps.setString(1,Username);
        ps.setString(2,Friendname);
        int temp = ps.executeUpdate();
            return true;
    } catch (Exception e) {
           System.out.println(e);
        return false;
    }
    }
}
