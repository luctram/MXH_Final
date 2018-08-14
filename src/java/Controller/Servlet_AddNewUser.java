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
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author TramLuc
 */

public class Servlet_AddNewUser extends HttpServlet{
    
    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String password1 = request.getParameter("password1"); 
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String name = request.getParameter("name");
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
        if (password1.equals("") && password1.equals(password)) {
            error = "Chưa xác nhận mật khẩu";
            request.setAttribute("error", error);
        }
        if (phone.equals("")) {
            error = "Chưa nhập số điện thoại";
            request.setAttribute("error", error);
        }
        if (email.equals("")) {
            error = "Chưa nhập email";
            request.setAttribute("error", error);
        }
        
        if (name.equals("")) {
            error = "Chưa nhập ten";
            request.setAttribute("error", error);
        }
            try {
                if (error.length() == 0) {
                    List<User> acc = UserDAO.GetUsernameAndPhoneAndEmailToCheck();
                    for (int i = 0; i < acc.size(); i++) {
                        if (!(username.equals(acc.get(i).getUserName()) || email.equals(acc.get(i).getEmail()) || phone.equals(acc.get(i).getPhone()))){
                           if(password.equals(password1)){
                            User user  = new User();
                            user.setUserName(username);
                            user.setName(name);
                            user.setEmail(email);
                            user.setPassword(password);
                            user.setPhone(phone);
                            user.setAddress(" ");
                            user.setAvatarLink("Avatar/logo.png");
                            user.setBDay(" ");
                            user.setHobby(" ");
                            user.setHometown(" ");
                                               
                             UserDAO.createUser(user);
                            out.print("<html><meta charset=\"utf-8\"/>");
                             out.print("<script>alert('Tạo tài khoản thành công!');");
                              out.print("window.location = 'http://localhost:8084/MXH_Final/FormLogin.jsp' ;</script></html>");
                             return;
                        }else{
                                out.print("<html><meta charset=\"utf-8\"/>");
                             out.print("<script>alert('Mật khẩu xác nhận không khớp');");
                              out.print("window.location = 'http://localhost:8084/MXH_Final/FormRegistration.jsp' ;</script></html>");
                             return;
                           }}
                        else{
                             out.print("<html><meta charset=\"utf-8\"/>");
                             out.print("<script>alert('Tên tài khoản/Số điện thoại/Email đã có! Vui lòng nhập thông tin khác');");
                              out.print("window.location = 'http://localhost:8084/MXH_Final/FormRegistration.jsp' ;</script></html>");
                            return;
                        }
                    }
                    
                          
                } else {
                     out.print("<html><meta charset=\"utf-8\"/>");
                             out.print("<script>alert('Vui lòng nhập đủ thông tin');");
                              out.print("window.location = 'http://localhost:8084/MXH_Final/FormRegistration.jsp' ;</script></html>");
                }   
            } catch (Exception e) {
            }
    }    
}
