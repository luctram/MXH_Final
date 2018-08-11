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
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author TramLuc
 */
@WebServlet(name = "Servlet_Mess", urlPatterns = {"/Servlet_Mess"})
public class Servlet_Mess extends HttpServlet {
@Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
         request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String me = request.getParameter("user1");
        String myfend = request.getParameter("user2");
         PrintWriter out = response.getWriter();
    List<Mess> list = new ArrayList<Mess>();
         list= MessDAO.getMessByUsername(Integer.parseInt(me), Integer.parseInt(myfend));
         for(int i = 0; i< list.size() ; i++ ){
             if(list.get(i).getUserId1() == Integer.parseInt(me)){
                 mymess(out,list.get(i).getMess());
             }
             else{
                 friendmess(out,list.get(i).getMess());
             }
         }
    }
    
    public void mymess( PrintWriter out, String mess){
        out.println("<li class=\"left clearfix admin_chat\">");
        out.println("<span class=\"chat-img1 pull-right\">");
        out.println("<img src=\"<%=avatarlink%>\" alt=\"User Avatar\" class=\"img-circle\">");
        out.println("</span>");
        out.println("<div class=\"chat-body1 clearfix\">");
        out.println("<p>" + mess + "</p>");
        out.println("<div class=\"chat_time pull-left\">Ngay gio</div>");
        out.println("</div>");
        out.println("</li>");                                        
    }
    
    public void friendmess(PrintWriter out, String mess){
        out.println("<li class=\"left clearfix\">");
        out.println("<span class=\"chat-img1 pull-left\">");
        out.println("<img src=\"<%=avatar%>\" alt=\"User Avatar\" class=\"img-circle\">");
        out.println("</span>");
        out.println("<div class=\"chat-body1 clearfix\">");
        out.println("<p>" + mess + "</p>");
        out.println("<div class=\"chat_time pull-right\">Ngay gio</div>");
        out.println("</div>");
        out.println("</li>");                                
    }
}
