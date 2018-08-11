/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.UserPostDAO;
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
@WebServlet(name = "Servlet_DeletePost", urlPatterns = {"/Servlet_DeletePost"})
public class Servlet_DeletePost extends HttpServlet {
       public void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        String idpost = request.getParameter("idpost");
        try {
            int id = Integer.parseInt(idpost);
            UserPostDAO.deletePost(id);
                out.print("<html><meta charset=\"utf-8\"/>");
                out.print("<script>alert('Đã xóa bài viết');");
               out.print("window.location = 'http://localhost:8084/MXH_Final/UserPage.jsp' ;</script></html>");
        } catch (Exception e) {
            e.printStackTrace();
        }
}

}
