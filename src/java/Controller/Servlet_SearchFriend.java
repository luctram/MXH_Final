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
import java.util.ArrayList;
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
        String infoUser = request.getParameter("friendinfo");
       
        String error = "";
        if (infoUser.equals("")) {
            error = "Chưa nhập tên đăng nhập";
            request.setAttribute("error", error);
        }

        try {
            if (error.length() == 0) {
               User user = new User();
               user =FriendsDAO.searchUser(infoUser);
                
               if(user.equals(null)){
                   System.out.println("Tai khoan ko ton tai");
                   return;
               }
               else{
                   getServletContext().setAttribute("searchFriend",user); 
                    request.getRequestDispatcher("NewFriend.jsp").forward(request, response);
                response.sendRedirect("http://localhost:8084/MXH_Final/FormLogin.jsp");}
                return;
            } else {
                System.out.println("<script>alert('Nhập thiếu tên đăng nhập hoặc mật khẩu!');</script>");
                response.sendRedirect("http://localhost:8084/MXH_Final/NewFriend.jsp");
                return;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
