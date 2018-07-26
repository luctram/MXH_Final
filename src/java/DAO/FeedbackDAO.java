/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Connect.DBConnect_MySQL;
import Model.Feedback;
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
public class FeedbackDAO {

    //Them phan hoi tu User
    public static boolean newFeedBack(Feedback fb) throws SQLException {
        Connection cons = DBConnect_MySQL.getConnection();
        try {
            System.out.println("DAO");
            String sql = "INSERT INTO db_mxh.feedback (Username, Contents, Date) VALUE(?,?,?)";
            PreparedStatement ps = cons.prepareStatement(sql);

            ps.setString(1, fb.getUserName());
            ps.setString(2, fb.getContents());
            ps.setString(3, fb.getDate());
            int temp = ps.executeUpdate();
            cons.close();
            return temp == 1;
        } catch (Exception e) {
            cons.close();
            return false;
        }
    }

    //Lay tat ca phan hoi
    public static List<Feedback> GetFeedBack() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        Connection cons = DBConnect_MySQL.getConnection();
        String sql = "SELECT * FROM db_mxh.feedback ";
        List<Feedback> feedback = new ArrayList<>();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Feedback fb = new Feedback();
                fb.setUserName(rs.getString("Username"));
                fb.setDate(rs.getString("Date"));
                fb.setContents(rs.getString("Contents"));
                feedback.add(fb);
            }
        } catch (SQLException e) {
            cons.close();
            e.printStackTrace();
        }
        cons.close();
        return feedback;
    }
}
