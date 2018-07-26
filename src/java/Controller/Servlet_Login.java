/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.UserDAO;
import Model.User;
import java.io.IOException;
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
       
        String getnamefromid;
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
                        getServletContext().setAttribute("username",acc.get(i).getUserName()); // truyen username về jsp
                        System.out.println("Login: " + acc.get(i).getUserName());
                        request.getRequestDispatcher("Home.jsp").forward(request, response);
                        request.getRequestDispatcher("menu.jsp").forward(request, response);
                        request.getRequestDispatcher("UserPage.jsp").forward(request, response);
                        request.getRequestDispatcher("UserInfo.jsp").forward(request, response);
                        request.getRequestDispatcher("Feedback.jsp").forward(request, response);
                        request.getRequestDispatcher("Friends.jsp").forward(request, response);
                         request.getRequestDispatcher("NewPost.jsp").forward(request, response);
                        
                        response.sendRedirect("http://localhost:8084/MXH_Final/Home.jsp");
                        return;
                    }
                }
                System.out.println("<script>alert('Nhập sai tên đăng nhập hoặc mật khẩu!');</script>");
                response.sendRedirect("http://localhost:8084/MXH_Final/FormLogin.jsp");
                return;
            } else {
                System.out.println("<script>alert('Nhập thiếu tên đăng nhập hoặc mật khẩu!');</script>");
                response.sendRedirect("http://localhost:8084/MXH_Final/FormLogin.jsp");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
