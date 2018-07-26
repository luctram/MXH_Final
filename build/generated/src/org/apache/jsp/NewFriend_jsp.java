package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class NewFriend_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "menu.jsp", out, false);
      out.write("\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "footer.jsp", out, false);
      out.write("\n");
      out.write("       \n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"container\">\n");
      out.write("                <h2>Danh sách bạn bè</h2>\n");
      out.write("                <div class=\"AddFriend\">\n");
      out.write("                    <a href=\"#\" title=\"Thêm bạn\"><i class=\"fa fa-plus fa-2x\"></i></a>\n");
      out.write("                    <form action=\"\" method=\"\">\n");
      out.write("                        <input type=\"text\" name=\"friendusername\" placeholder=\"Nhập tên bạn cần tìm\">\n");
      out.write("                        <input type=\"submit\" value=\"Tìm\">\n");
      out.write("                    </form>\n");
      out.write("                </div>\n");
      out.write("                <br>\n");
      out.write("            \n");
      out.write("            <div class=\"row\">\n");
      out.write("\n");
      out.write("                <div class=\"listfriend\">\n");
      out.write("                    <div class=\"col-sm-12\">\n");
      out.write("                        <div class=\"col-sm-1 FriendAvatar\">\n");
      out.write("                            <img src=\"https://www.infrascan.net/demo/assets/img/avatar5.png\" class=\"img-circle\" width=\"60px\">\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"col-sm-9 FriendName\">\n");
      out.write("                            <h4><a href=\"#\">Rahul Jain</a></h4>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"col-sm-2\">\n");
      out.write("                            <span class=\"glyphicon glyphicon-map-marker text-muted c-info\" data-toggle=\"tooltip\" title=\"5842 Hillcrest Rd\"></span>\n");
      out.write("                            <span class=\"visible-xs\"> <span class=\"text-muted\">5842 Hillcrest Rd</span><br/></span>\n");
      out.write("                            <span class=\"glyphicon glyphicon-earphone text-muted c-info\" data-toggle=\"tooltip\" title=\"(870) 288-4149\"></span>\n");
      out.write("                            <span class=\"visible-xs\"> <span class=\"text-muted\">(870) 288-4149</span><br/></span>\n");
      out.write("                            <span class=\"glyphicon glyphicon-envelope text-muted c-info\" data-toggle=\"tooltip\" title=\"scott.stevens@example.com\"></span>\n");
      out.write("                            <span class=\"visible-xs\"> <span class=\"text-muted\">scott.stevens@example.com</span><br/></span>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"clearfix\"></div>\n");
      out.write("                    <hr />\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
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
