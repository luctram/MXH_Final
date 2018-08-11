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
        String userid = request.getParameter("userid");
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String hometown = request.getParameter("hometown");
        String hobby = request.getParameter("hobby");
        String phone = request.getParameter("phone");
        
        try {
      User u = new User(Integer.parseInt(userid), email, phone, name, hobby, address, hometown, hobby);
            UserDAO.editUser(u);
            
                PrintWriter out = response.getWriter();
                out.println("THANH CONG");
                response.sendRedirect("http://localhost:8084/MXH_Final/UserInfo.jsp");
                return;
            
        } catch (Exception e) {
        }
    }
    
}
