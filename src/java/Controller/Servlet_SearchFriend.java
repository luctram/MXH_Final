/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.FriendsDAO;
import DAO.UserDAO;
import Model.Friends;
import Model.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author TramLuc
 */
@WebServlet(name = "Servlet_SearchFriend", urlPatterns = {"/Servlet_SearchFriend"})
public class Servlet_SearchFriend extends HttpServlet {
 public void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String userid = request.getParameter("userid");
        String infoUser = request.getParameter("friendinfo");
       PrintWriter out =response.getWriter();
        String error = "";
        if (infoUser.equals("")) {
            error = "Chưa nhập tên đăng nhập";
            request.setAttribute("error", error);
        }

        try {
            if (error.length() == 0) {
               User user = new User();
               user =FriendsDAO.searchUser(infoUser);
                int id = UserDAO.getId(user.getUserName());
               if(user.equals(null)){
                    out.print("<html><meta charset=\"utf-8\"/>");
                out.print("<script>alert('Tài khoản này không tồn tại');</script></html>");
                   return;
               }
               else{
                   List<Friends> list= new ArrayList<Friends>();
                   list = FriendsDAO.getAllFriendByUserId(Integer.parseInt(userid));
                    
                   for(int i = 0; i< list.size(); i++){
                     if(list.get(i).getFriendId() == id){
                         User u = new User();
                    u = UserDAO.getInfoByUserId(id);
                         out.print(id+"-"+u.getName() +"-" + u.getEmail() + "-" + u.getPhone() + "-" + u.getAddress() + "-" + u.getAvatarLink() + "-Hủy kết bạn-./Servlet_DeleteFriend");
                    return;
                     }
                   } 
                         User u = new User();
                    u = UserDAO.getInfoByUserId(id);
                          out.print(id+"-"+u.getName() +"-" + u.getEmail() + "-" + u.getPhone() + "-" + u.getAddress() + "-" + u.getAvatarLink() + "-Gửi lời mời kết bạn-./Servlet_RequestNewFriend");
                    return;

                  
               }
               
                
            } else {
                 out.print("<html><meta charset=\"utf-8\"/>");
                out.print("<script>alert('Nhập thiếu thông tin');");
               out.print("window.location = 'http://localhost:8084/MXH_Final/NewFriend.jsp' ;</script></html>");
                return;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
