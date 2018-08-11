/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.UserDAO;
import Model.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;
import sun.rmi.runtime.Log;

/**
 *
 * @author TramLuc
 */

public class Servlet_Login extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String username = request.getParameter("username");
        String password = request.getParameter("pass");
    PrintWriter out = response.getWriter();
        String error = "";
        if (username.equals("")) {
            error = "Chưa nhập tên đăng nhập";
            request.setAttribute("error", error);
        }

        if (password.equals("")) {
            error = "Chưa nhập mật khẩu";
            request.setAttribute("error", error);
        }

        try {
            if (error.length() == 0) {

                ArrayList<User> acc = UserDAO.getAcc();
                for (int i = 0; i < acc.size(); i++) {
                    System.out.println("Servlet_Login:   "+acc.get(i).getUserName());
                    if (username.equals(acc.get(i).getUserName()) && password.equals(acc.get(i).getPassword())) {
                        
                        int id= UserDAO.getId(acc.get(i).getUserName());
                        
                        System.out.println("Login: " + id);
                        
                        getServletContext().setAttribute("userid",id); // truyen userid về jsp
                        request.getRequestDispatcher("Home.jsp").forward(request, response);
                        request.getRequestDispatcher("mess.jsp").forward(request, response);
                        request.getRequestDispatcher("menu.jsp").forward(request, response);
                        request.getRequestDispatcher("UserPage.jsp").forward(request, response);
                        request.getRequestDispatcher("UserInfo.jsp").forward(request, response);
                        request.getRequestDispatcher("Feedback.jsp").forward(request, response);
                        request.getRequestDispatcher("Friends.jsp").forward(request, response);
                         request.getRequestDispatcher("NewPost.jsp").forward(request, response);
                         request.getRequestDispatcher("game.jsp").forward(request, response);
                          request.getRequestDispatcher("ChangePassword.jsp").forward(request, response);
                           request.getRequestDispatcher("ChangeAvatar.jsp").forward(request, response);
                           request.getRequestDispatcher("EditPost.jsp").forward(request, response);
                        request.getRequestDispatcher("RequestFriends.jsp").forward(request, response);
                        response.sendRedirect("http://localhost:8084/MXH_Final/Home.jsp");
                     
                        return;
                    }
                }
                out.print("<html><meta charset=\"utf-8\"/>");
                out.print("<script>alert('Nhập sai tên hoặc mật khẩu!');");
               out.print("window.location = 'http://localhost:8084/MXH_Final/FormLogin.jsp' ;</script></html>");
                return;
            } else {
                out.print("<html><meta charset=\"utf-8\"/>");
                out.print("<script>alert('Nhập thiếu tên đăng nhập hoặc mật khẩu!');");
                out.print("window.location = 'http://localhost:8084/MXH_Final/FormLogin.jsp' ;</script></html>");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
