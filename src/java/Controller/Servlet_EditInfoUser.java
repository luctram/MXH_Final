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
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author TramLuc
 */
@WebServlet(name = "Servlet_EditInfoUser", urlPatterns = {"/Servlet_EditInfoUser"})
public class Servlet_EditInfoUser extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String username = request.getParameter("username");
        String name = request.getParameter("name");
        String othername = request.getParameter("othername");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String hometown = request.getParameter("hometown");
        String hobby = request.getParameter("name");
        String phone = request.getParameter("phone");
        
        try {
            User user = new User(username, email, phone, name, othername, address, hometown, hobby);
            System.out.println(username);
            user.setUserName(username);
            user.setName(name);
            user.setOtherName(othername);
            user.setAddress(address);
            user.setEmail(email);
            user.setHobby(hobby);
            user.setHometown(hometown);
            
            UserDAO.editUser(user);
            
                PrintWriter out = response.getWriter();
                out.println("THANH CONG");
                response.sendRedirect("http://localhost:8084/MXH_Final/UserInfo.jsp");
                return;
            
        } catch (Exception e) {
        }
    }
    
}
