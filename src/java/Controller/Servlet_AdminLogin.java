/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import DAO.AdminDAO;
import DAO.UserDAO;
import Model.User;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author TramLuc
 */
@WebServlet(name = "Servlet_AdminLogin", urlPatterns = {"/Servlet_AdminLogin"})
public class Servlet_AdminLogin extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String username = request.getParameter("name");
        String password = request.getParameter("pass");
        PrintWriter out = response.getWriter();
       username="TracyLuc";
       password = "123";
       
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

                ArrayList<User> acc = AdminDAO.getAcc();
                for (int i = 0; i < acc.size(); i++) {
                    System.out.println("Servlet_Login:   "+acc.get(i).getUserName());
                    if (username.equals(acc.get(i).getUserName()) && password.equals(acc.get(i).getPassword())) {
                        getServletContext().setAttribute("username",acc.get(i).getUserName()); // truyen username về jsp
                        System.out.println("Login: " + acc.get(i).getUserName());
                        request.getRequestDispatcher("AdminMenu.jsp").forward(request, response);
                        request.getRequestDispatcher("AdminFeedback.jsp").forward(request, response);
                        
                     
                        response.sendRedirect("http://localhost:8084/MXH_Final/admin/AdminMenu.jsp");
                        return;
                    }
                }
                out.print("<html><meta charset=\"utf-8\"/>");
                out.print("<script>alert('Nhập sai tên đăng nhập hoặc mật khẩu!');");
                out.print("window.location = 'http://localhost:8084/MXH_Final/admin/AdminLogin.jsp' ;</script></html>");
                return;
            } else {
                out.print("<html><meta charset=\"utf-8\"/>");
                out.print("<script>alert('Nhập thiếu tên đăng nhập hoặc mật khẩu!');");
                out.print("window.location = 'http://localhost:8084/MXH_Final/admin/AdminLogin.jsp' ;</script></html>");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
