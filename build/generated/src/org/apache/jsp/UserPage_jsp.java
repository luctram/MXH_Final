package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import DAO.FileDAO;
import DAO.UserPostDAO;
import java.util.ArrayList;
import java.util.List;
import Model.UserPost;
import DAO.UserDAO;
import Model.User;

public final class UserPage_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>MAKEFRIEND SOCIAL NETWORK</title>\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\">\n");
      out.write("        <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js\"></script>\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css\" />\n");
      out.write("        <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\"></script>\n");
      out.write("        <link rel=\"stylesheet\" href=\"css.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"postcss.css\">\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "menu.jsp", out, false);
      out.write("\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "footer.jsp", out, false);
      out.write("\n");
      out.write("        </head>\n");
      out.write("        <body>\n");
      out.write("        ");

            User user = new User();
            user.setUserName(getServletContext().getAttribute("username").toString());
            user = UserDAO.getInfoByUsername(user.getUserName());
            List<UserPost> Listpost = new ArrayList<UserPost>();
            Listpost = UserPostDAO.getAllPostByUsername(user.getUserName());
        
      out.write("\n");
      out.write("        <div class=\"container-fluid\">\n");
      out.write("            <div class=\"row\">\n");
      out.write("                <div class=\"fb-profile\">\n");
      out.write("                    <img align=\"left\" class=\"profile-img thumbnail\" src=\"");
      out.print(user.getAvatarLink());
      out.write("\" alt=\"Profile image example\" height=\"250px\" width=\"10px\"/>\n");
      out.write("                    <div class=\"profile-name\">\n");
      out.write("                        <h1>");
      out.print(user.getName());
      out.write("\n");
      out.write("                            ");
 if (!user.getOtherName().equals(" ")) {// Kiem tra user có dùng othername ko

      out.write("&nbsp;(");
      out.print(user.getOtherName());
      out.write(')');
}
      out.write("\n");
      out.write("\n");
      out.write("                        </h1>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div> <!-- /container fluid-->  \n");
      out.write("        <div class=\"container\">\n");
      out.write("            <div class=\"col-sm-8\">\n");
      out.write("                ");
for (int i = 0; i < Listpost.size(); i++) {
                        String avatar = UserDAO.getAvatarToShowHomePage(user.getUserName());
                        String name = UserDAO.getNameToShowHomePage(user.getUserName());
                
      out.write("\n");
      out.write("\n");
      out.write("                <div>\n");
      out.write("                    <div class=\"panel-heading\">\n");
      out.write("                        <a href=\"#\"><img src=\"");
      out.print(avatar);
      out.write("\" class=\"img-circle\" width=\"45px\" height=\"43px\">&nbsp;&nbsp;&nbsp;    \n");
      out.write("                            ");
      out.print(name);
      out.write("</a>\n");
      out.write("                        <div id=\"datepost\">");
      out.print(Listpost.get(i).getDate());
      out.write("\n");
      out.write("                            <br><br>\n");
      out.write("                            <p>2&nbsp;bình luận&nbsp;&nbsp;&nbsp;");
      out.print(Listpost.get(i).getCountLike());
      out.write("&nbsp;&nbsp;&nbsp;<i class=\"fa fa-heart\"></i></p>\n");
      out.write("                        </div>\n");
      out.write("                    </div>   \n");
      out.write("\n");
      out.write("                    <div class=\"panel-body\">\n");
      out.write("                        <div class=\"PostContents\">\n");
      out.write("                            <p>");
      out.print(Listpost.get(i).getContent());
      out.write("</p>\n");
      out.write("                            ");

                                if (!Listpost.get(i).getImgVideoLink().equals(" ")) {
                                    int check = FileDAO.checkfile(Listpost.get(i).getImgVideoLink());
                                    if (check == 0) {
                            
      out.write("\n");
      out.write("                            <img src=\"");
      out.print(Listpost.get(i).getImgVideoLink());
      out.write("\" width=\"300px\" height=\"150px\" >\n");
      out.write("                            ");
} else if (check == 1) {
      out.write("\n");
      out.write("                            <video width=\"320\" height=\"240\" controls>\n");
      out.write("                                <source src=\"");
      out.print(Listpost.get(i).getImgVideoLink());
      out.write("\" type=\"video/mp4\">\n");
      out.write("                            </video>\n");
      out.write("                            ");
}
                                    }
      out.write("\n");
      out.write("\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"LikeButton\">\n");
      out.write("                            <input type=\"button\" value=\"Thích\">\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                    <div class=\"panel-footer\">\n");
      out.write("                        <div data-spy=\"scroll\">\n");
      out.write("                            <div class=\"tabbable-line\">\n");
      out.write("                                <ul class=\"nav nav-tabs \">\n");
      out.write("\n");
      out.write("                                    <li class=\"active\">\n");
      out.write("                                        <a href=\"#tab_default_1_");
      out.print(Listpost.get(i).getPostId());
      out.write("\" data-toggle=\"tab\">\n");
      out.write("                                            Viết bình luận</a>\n");
      out.write("                                    </li>\n");
      out.write("                                    <li>\n");
      out.write("                                        <a href=\"#tab_default_2_");
      out.print(Listpost.get(i).getPostId());
      out.write("\" data-toggle=\"tab\">\n");
      out.write("                                            Xem bình luận</a>\n");
      out.write("                                    </li>\n");
      out.write("                                </ul> <div class=\"tab-content\">\n");
      out.write("                                    <div class=\"tab-pane active\" id=\"tab_default_1_");
      out.print(Listpost.get(i).getPostId());
      out.write("\">\n");
      out.write("                                        <div class=\"CmtAvatar\">\n");
      out.write("                                            <img src=\"https://www.infrascan.net/demo/assets/img/avatar5.png\" class=\"img-circle\" width=\"30px\" height=\"30px\">\n");
      out.write("\n");
      out.write("                                        </div>\n");
      out.write("                                        <div class=\"Comment\">\n");
      out.write("                                            <div id=\"Usenamepost\">\n");
      out.write("                                                <a href=\"\">Trâm Lục</a>\n");
      out.write("                                            </div>\n");
      out.write("                                            <div id=\"WriteContents\">\n");
      out.write("                                                <form>\n");
      out.write("                                                    <input type=\"text\" placeholder=\"Viết bình luận\">\n");
      out.write("                                                </form>\n");
      out.write("\n");
      out.write("                                            </div>\n");
      out.write("                                        </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"tab-pane\" id=\"tab_default_2_");
      out.print(Listpost.get(i).getPostId());
      out.write("\">\n");
      out.write("                                        <div> <div class=\"CmtAvatar\">\n");
      out.write("                                                <img src=\"Avatar/logo.png\" class=\"img-circle\" width=\"30px\">\n");
      out.write("\n");
      out.write("                                            </div>\n");
      out.write("                                            <div class=\"Comment\">\n");
      out.write("                                                <div id=\"Usenamepost\">\n");
      out.write("                                                    <a href=\"\">Hana</a>\n");
      out.write("                                                </div>\n");
      out.write("                                                <div id=\"CmtContents\">\n");
      out.write("                                                    Hahaaaaaa :))\n");
      out.write("                                                </div>\n");
      out.write("                                            </div>\n");
      out.write("                                        </div>\n");
      out.write("                                        <br><br>\n");
      out.write("                                        <div><div class=\"CmtAvatar\">\n");
      out.write("                                                <img src=\"Avatar/baocuong0501.png\" class=\"img-circle\" width=\"30px\">\n");
      out.write("\n");
      out.write("                                            </div>\n");
      out.write("                                            <div class=\"Comment\">\n");
      out.write("                                                <div id=\"Usenamepost\">\n");
      out.write("                                                    <a href=\"\"> Bảo Cường</a>\n");
      out.write("                                                </div>\n");
      out.write("                                                <div id=\"CmtContents\">\n");
      out.write("                                                    Sao dui dọ kể nghe =))\n");
      out.write("                                                </div>\n");
      out.write("                                            </div>\n");
      out.write("                                        </div>\n");
      out.write("                                        <br>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <br> \n");
      out.write("                ");
}
                
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <div class=\"col-sm-4\">\n");
      out.write("                <div class=\"panel panel-default\">\n");
      out.write("                    <div class=\"menu_title\">\n");
      out.write("                        THÔNG TIN CÁ NHÂN\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"panel-body\">\n");
      out.write("                        <div class=\"row\">\n");
      out.write("                            <div class=\"col-lg-12\">\n");
      out.write("                                <div class=\"form-group\">\n");
      out.write("                                    <i class=\"fa fa-birthday-cake\"></i>&nbsp;<label for=\"email\">Sinh nhật&nbsp;</label>");
      out.print(user.getBDay());
      out.write("\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"form-group\">\n");
      out.write("                                    <i class=\"fa fa-map-marker\"></i>&nbsp; <label for=\"email\">Đến từ&nbsp;</label>");
      out.print(user.getHometown());
      out.write("\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"form-group\">\n");
      out.write("                                    <i class=\"fa fa-home\"></i>&nbsp;<label for=\"email\">Sống tại&nbsp;</label>");
      out.print(user.getAddress());
      out.write("\n");
      out.write("\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"form-group\">\n");
      out.write("                                    <i class=\"fa fa-phone\"></i> &nbsp; <label for=\"email\">Số điện thoại&nbsp;</label>");
      out.print(user.getPhone());
      out.write("\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"form-group\">\n");
      out.write("                                    <i class=\"fa fa-envelope\"></i> &nbsp;   <label for=\"email\">Email&nbsp;</label>");
      out.print(user.getEmail());
      out.write("\n");
      out.write("\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"form-group\">\n");
      out.write("                                    <i class=\"glyphicon glyphicon-heart\"></i> &nbsp;   <label for=\"email\">Sở thích&nbsp;</label>");
      out.print(user.getHobby());
      out.write("\n");
      out.write("\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div></div>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
