package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class FormRegistration_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html onload =\"tenham()\">\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>MAKEFRIEND SOCIAL NETWORK</title>\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css\" />\n");
      out.write("        <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js\"></script>\n");
      out.write("        <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\"></script>\n");
      out.write("        <link rel=\"stylesheet\" href=\"AccountCss.css\">\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "footer.jsp", out, false);
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("          ");

            String error="";
            if(request.getParameter("error") != null){
                error = (String) request.getParameter("error");
            }
            
      out.write("\n");
      out.write("        <main role=\"main\" class=\"container\">\n");
      out.write("            <div class=\"col-md-6\">\n");
      out.write("                <div id=\"welcome\">\n");
      out.write("                   <p>CHÀO MỪNG BẠN ĐẾN VỚI </p>\n");
      out.write("                    <p>MAKE FRIEND SOCIAL NETWORK</p>\n");
      out.write("                    <img src=\"img/fulllogo.png\" align=\"center\">\n");
      out.write("                    \n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            \n");
      out.write("            <div class=\"col-md-6\">\n");
      out.write("            <div id=\"taotk\">\n");
      out.write("                <h3>TẠO TÀI KHOẢN MỚI</h3>\n");
      out.write("                <form action=\"./Servlet_AddNewUser\" method=\"POST\">\n");
      out.write("                    <br>Tên đăng nhập *&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n");
      out.write("                    <input class=\"tendn\" type=\"text\" name=\"username\" id=\"username\">\n");
      out.write("                   \n");
      out.write("                    <br><br>Mật khẩu *&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n");
      out.write("                    <input class=\"matkhau1\" type=\"password\" name=\"password\"> \n");
      out.write("                    \n");
      out.write("                    <br><br>Nhập lại mật khẩu *&nbsp;\n");
      out.write("                    <input class=\"matkhau1\" type=\"password\" name=\"password1\">\n");
      out.write("                    \n");
      out.write("                    <br><br>Số điện thoại *&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n");
      out.write("                    <input class=\"sdt\" type=\"text\" name=\"phone\">\n");
      out.write("                    \n");
      out.write("                    <br><br>Tên tài khoản *&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n");
      out.write("                    <input class=\"name1\" type=\"text\" name=\"name\"> \n");
      out.write("                    \n");
      out.write("                    <br><br>Email *&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n");
      out.write("                    <input class=\"email\" type=\"text\" name=\"email\"> \n");
      out.write("                    <br>\n");
      out.write("                    <p><em>* là những thông tin bắt buộc</em></p>\n");
      out.write("                    <br>\n");
      out.write("                    <input class=\"button taotaikhoan\" type=\"submit\" value=\"TẠO TÀI KHOẢN\">\n");
      out.write("                    \n");
      out.write("                </form>\n");
      out.write("            </div>\n");
      out.write("            </div>\n");
      out.write("              \n");
      out.write("        </main><!-- /.container -->\n");
      out.write("        <script>\n");
      out.write("              $(\"#username\").click(function(){\n");
      out.write("    var n = countItem();\n");
      out.write("    if (n == 5) {\n");
      out.write("      alert(\"Tên đăng nhập không quá 20 ký tự\");\n");
      out.write("    } else {\n");
      out.write("      n++;\n");
      out.write("      $(\"#answer\").append(\"<div class='item'><label><span>Ans \"+n+\"</span> <input type='text'> <input type='checkbox' disabled='disabled'></label> <a href='javascript:void(0)' class='del'>del</a></div>\");\n");
      out.write("    }\n");
      out.write("  });\n");
      out.write("        </script>\n");
      out.write("        </body>\n");
      out.write("    </html>\n");
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
