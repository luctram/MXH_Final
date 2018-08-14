/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.FriendsDAO;
import Model.Friends;
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
@WebServlet(name = "Servlet_AcceptFriend", urlPatterns = {"/Servlet_AcceptFriend"})
public class Servlet_AcceptFriend extends HttpServlet {
 @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
         request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
         PrintWriter out = response.getWriter();
         String userid = request.getParameter("userid");
        String friendid = request.getParameter("friendid");
        try{
            int id= FriendsDAO.getId(Integer.parseInt(userid), Integer.parseInt(friendid));
            FriendsDAO.deleteFriend(id);
            Friends friend = new Friends(Integer.parseInt(userid), Integer.parseInt(friendid), java.time.LocalDate.now().toString(), "Friend");
             friend.setUserId(Integer.parseInt(userid));
            friend.setFriendId(Integer.parseInt(friendid));
            friend.setDate(java.time.LocalDate.now().toString());
            friend.setStatus("Friend");
            FriendsDAO.AddFriend(friend);
            
            response.sendRedirect("http://localhost:8084/MXH_Final/Friends.jsp");
            return;
              } catch (Exception e) {
        
        }
        
    }
}
