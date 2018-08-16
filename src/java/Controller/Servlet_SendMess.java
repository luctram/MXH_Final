/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.MessDAO;
import Model.Mess;
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
@WebServlet(name = "Servlet_SendMess", urlPatterns = {"/Servlet_SendMess"})
public class Servlet_SendMess extends HttpServlet {
@Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
         PrintWriter out =response.getWriter();
         request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String me = request.getParameter("me");
        String myfend = request.getParameter("myfriend");
       String content = request.getParameter("content");
       try{
           Mess mess= new Mess();
           mess.setUserId1(Integer.parseInt(me));
           mess.setUserId2(Integer.parseInt(myfend));
           mess.setDate(java.time.LocalDate.now().toString());
           mess.setMess(content);
           mess.setStatus("Sent");
           MessDAO.newMess(mess);
                    return;
       }
       catch(Exception e){
           
       }
    }
}
