/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.UserPostDAO;
import Model.UserPost;
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
@WebServlet(name = "Servlet_AddNewPost", urlPatterns = {"/Servlet_AddNewPost"})
public class Servlet_AddNewPost extends HttpServlet {
 @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String contentspost = request.getParameter("newpost");
        String username = request.getParameter("username");
        String error = "";
        
        if (contentspost.equals("")) {
            error = "Chưa nhập tên đăng nhập";
            request.setAttribute("error", error);
        }
            try {
                if (error.length() == 0) {
                       UserPost uPost  = new UserPost();
                           uPost.setUserName(username);
                           uPost.setContent(contentspost);
                           uPost.setImgLink("");
                           uPost.setVideoLink("");
                           uPost.setDate(java.time.LocalDate.now().toString());
                           UserPostDAO.createPost(uPost);
                              PrintWriter out = response.getWriter();
                             out.println("THANH CONG");
                             response.sendRedirect("http://localhost:8084/MXH_Final/UserPage.jsp");
                             return;
                        }
                        else{
                            System.out.println("<script>alert('Bài đăng trống!');</script>");
                            response.sendRedirect("http://localhost:8084/MXH_Final/NewPost.jsp");
                            return;
                        }
            }  
             catch (Exception e) {
            }
    }    
}
