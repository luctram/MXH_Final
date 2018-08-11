/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.CmtPostDAO;
import Model.CommentPost;
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
@WebServlet(name = "Servlet_AddNewCommentHome", urlPatterns = {"/Servlet_AddNewCommentHome"})
public class Servlet_AddNewCommentHome extends HttpServlet {
 @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String comment = request.getParameter("comment");
        String postid = request.getParameter("postid");
        String usercmt = request.getParameter("usercmt"); 
        PrintWriter out = response.getWriter();
        String error = "";
        if (comment.equals("")) {
            error = "Chưa nhập tên đăng nhập";
            request.setAttribute("error", error);
        }
            try {
                if (error.length() == 0) {
                    CommentPost cmt = new CommentPost(Integer.parseInt(postid),Integer.parseInt(usercmt),comment,java.time.LocalDate.now().toString());            
                     CmtPostDAO.createCmt(cmt);
                    response.sendRedirect("http://localhost:8084/MXH_Final/Home.jsp");
                             return;
                          
                } else {
                     out.print("<html><meta charset=\"utf-8\"/>");
                             out.print("<script>alert('Chưa nhập bình luận');</script></html>");
                }   
            } catch (Exception e) {
            }
    }    
}
