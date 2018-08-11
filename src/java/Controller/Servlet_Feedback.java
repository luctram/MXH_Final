/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.FeedbackDAO;
import Model.Feedback;
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
@WebServlet(name = "Servlet_Feedback", urlPatterns = {"/Servlet_Feedback"})
public class Servlet_Feedback extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        String userid = request.getParameter("userid");
        String contents = request.getParameter("contents");

        String error = "";
        if (contents.equals("")) {
            error = "Chưa nhập nội dung";
            request.setAttribute("error", error);
        }

        try {
            if (error.length() == 0) {
                Feedback fb = new Feedback();
                fb.setUserId(Integer.parseInt(userid));
                fb.setContents(contents);
                fb.setDate(java.time.LocalDate.now().toString());
                System.out.println(fb.getDate());
                FeedbackDAO.newFeedBack(fb);
                
                  out.print("<html><meta charset=\"utf-8\"/>");
                out.print("<script>alert('M.F xin cảm ơn phản hồi của bạn <3');");
               out.print("window.location = 'http://localhost:8084/MXH_Final/Feedback.jsp' ;</script></html>");
                return;
            } else {
                 out.print("<html><meta charset=\"utf-8\"/>");
                out.print("<script>alert('Bạn chưa viết phản ảnh!!');");
               out.print("window.location = 'http://localhost:8084/MXH_Final/Feedback.jsp' ;</script></html>");

            }
        } catch (Exception e) {
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String userid = request.getParameter("userid");
        String contents = request.getParameter("contents");

        String error = "";
        if (contents.equals("")) {
            error = "Chưa nhập nội dung";
            request.setAttribute("error", error);
        }

        try {
            if (error.length() == 0) {
                Feedback fb = new Feedback();
                fb.setUserId(Integer.parseInt(userid));
                fb.setContents(contents);
                fb.setDate(java.time.LocalDate.now().toString());
                System.out.println(fb.getDate());
                FeedbackDAO.newFeedBack(fb);
                
                PrintWriter out = response.getWriter();
                out.println("M.F xin cảm ơn phản hồi của bạn <3");
                response.sendRedirect("http://localhost:8084/MXH_Final/Feedback.jsp");
                return;
            } else {
                System.out.println("<script>alert('Nhập thiếu thông tin');</script>");
                response.sendRedirect("http://localhost:8084/MXH_Final/Feedback.jsp");

            }
        } catch (Exception e) {
        }
    }

}
