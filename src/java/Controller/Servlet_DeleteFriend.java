/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.FriendsDAO;
import Model.User;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author TramLuc
 */
@WebServlet(name = "Servlet_DeleteFriend", urlPatterns = {"/Servlet_DeleteFriend"})
public class Servlet_DeleteFriend extends HttpServlet {
public void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        String userid = request.getParameter("userid");
         String friendid = request.getParameter("friendid");
        try {
            int id= FriendsDAO.getId(Integer.parseInt(userid), Integer.parseInt(friendid));
            FriendsDAO.deleteFriend(id);
out.print("<html><meta charset=\"utf-8\"/>");
                out.print("<script>alert('Đã xóa bạn bè');");
               out.print("window.location = 'http://localhost:8084/MXH_Final/Friends.jsp' ;</script></html>");
        } catch (Exception e) {
            e.printStackTrace();
        }
}}
