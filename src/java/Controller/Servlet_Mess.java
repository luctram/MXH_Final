/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.MessDAO;
import DAO.UserDAO;
import Model.Mess;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
        System.out.println("OK");
         request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String me = request.getParameter("user1");
        String myfend = request.getParameter("user2");
        String index = request.getParameter("idMessageLastest");
        PrintWriter out = response.getWriter();
        List<Mess> list = new ArrayList<Mess>();
        list= MessDAO.getMessByUsername(Integer.parseInt(me), Integer.parseInt(myfend));
        int id = Integer.parseInt(index);
        if (list.size() > 0) {
            out.print(configti(String.valueOf(list.get(0).getId())));
            if (list.get(0).getId() <= (id)) { return;}
        }else{            
            out.print(configti(String.valueOf(list.get(0).getId())));
            return;
        }
        String date="", avatar="", avatarfriend="";
        
    try {
        avatar = UserDAO.getAvatarToShowHomePage(Integer.parseInt(me));
          avatarfriend = UserDAO.getAvatarToShowHomePage(Integer.parseInt(myfend));
    } catch (SQLException ex) {
        Logger.getLogger(Servlet_Mess.class.getName()).log(Level.SEVERE, null, ex);
    }
      
        for(int i = list.size()-1; i >= 0  ; i-- ){
            if (list.get(i).getId() > id){
                if(list.get(i).getUserId1() == Integer.parseInt(me)){
                    date = list.get(i).getDate();
                    mymess(out,list.get(i).getMess(),date,avatar);
                }
                else{
                     date = list.get(i).getDate();
                    friendmess(out,list.get(i).getMess(),date,avatarfriend);
                }
            }
         }
    }
    
    public void mymess( PrintWriter out, String mess,String date,String avatar){
        out.println("<li class=\"left clearfix admin_chat\">");
        out.println("<span class=\"chat-img1 pull-right\">");
        out.println("<img src=\""+avatar+"\" alt=\"User Avatar\" class=\"img-circle\">");
        out.println("</span>");
        out.println("<div class=\"chat-body1 clearfix\">");
        out.println("<p>" + mess + "</p>");
        out.println("<div class=\"chat_time pull-left\">"+date+"</div>");
        out.println("</div>");
        out.println("</li>");                                        
    }
    
    public void friendmess(PrintWriter out, String mess,String date, String avatarfriend){
        out.println("<li class=\"left clearfix\">");
        out.println("<span class=\"chat-img1 pull-left\">");
        out.println("<img src=\""+avatarfriend+"\" alt=\"User Avatar\" class=\"img-circle\">");
        out.println("</span>");
        out.println("<div class=\"chat-body1 clearfix\">");
        out.println("<p>" + mess + "</p>");
        out.println("<div class=\"chat_time pull-right\">"+date+"</div>");
        out.println("</div>");
        out.println("</li>");                                
    }
    public String configti(String data){
        if (data.length() == 8){
            return data;
        }else{
            String s = "";
            for(int i = 0 ; i<8 ;i++){
                if (i < data.length()){
                    s += data.charAt(i);
                }else{
                    s = "0" + s;
                }
            }
            return s;
        }
    }
}
