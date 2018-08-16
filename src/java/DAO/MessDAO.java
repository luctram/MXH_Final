/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Connect.DBConnect_MySQL;
import Model.Mess;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author TramLuc
 */
public class MessDAO {
    final static Connection cons = DBConnect_MySQL.getConnection();
    
     public static ArrayList<Mess> getMessByUsername(int name1, int name2){
          String sql = "SELECT * FROM db_mxh.mess WHERE (UserId1 = '" +name1 + "'"
                  + "AND UserId2 = '" + name2 + "') OR (UserId1 = '" +name2 + "'"
                  + "AND UserId2 = '" + name1 + "') ORDER BY id DESC LIMIT 10;";
        ArrayList<Mess> list = new ArrayList<>();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Mess mess = new Mess();
                mess.setId(rs.getInt("id"));
                mess.setUserId1(rs.getInt("UserId1"));
                mess.setUserId2(rs.getInt("UserId2"));
                mess.setMess(rs.getString("mess"));
                mess.setDate(rs.getString("date"));
                mess.setStatus(rs.getString("status"));
                
                list.add(mess);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
     }
     
      public static boolean newMess(Mess mess) throws SQLException {
        try {
            String sql = "INSERT INTO db_mxh.mess (UserId1, UserId2, mess, date, status) VALUE(?,?,?,?,?)";
            PreparedStatement ps = cons.prepareStatement(sql);
            System.out.println("SQL " + sql);
            ps.setInt(1, mess.getUserId1());
            ps.setInt(2, mess.getUserId2());
            ps.setString(3, mess.getMess());
            ps.setString(4, mess.getDate());
            ps.setString(5, mess.getStatus());
            int temp = ps.executeUpdate();
            return temp == 1;
        } catch (Exception e) {
            return false;

        }
    }
}
