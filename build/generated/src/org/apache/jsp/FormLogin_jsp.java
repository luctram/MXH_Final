package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class FormLogin_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css\" />\n");
      out.write("        <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js\"></script>\n");
      out.write("        <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\"></script>\n");
      out.write("        <link rel=\"stylesheet\" href=\"LoginCss.css\">\n");
      out.write("        \n");
      out.write("        <c:set var=\"root\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"/>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        \n");
      out.write("        <div id=\"welcome\">\n");
      out.write("        <p>CHÀO MỪNG BẠN ĐẾN VỚI MAKE FRIEND SOCIAL NETWORK!!!</p>\n");
      out.write("        </div>\n");
      out.write("        \n");
      out.write("        <div id=\"warp\">\n");
      out.write("             \n");
      out.write("            <form action=\"./Servlet_Login\" method=\"POST\">\n");
      out.write("                <div class=\"Make\">\n");
      out.write("                    <div class=\"rota\">\n");
      out.write("                        <h1>&nbsp;&nbsp;Make</h1>\n");
      out.write("                        <input id=\"username\" type=\"text\" name=\"username\" value=\"\" placeholder=\"Tên đăng nhập\" /><br />\n");
      out.write("                        <input id=\"password\" type=\"password\" name=\"pass\" value=\"\" placeholder=\"Mật khẩu\" />\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"Friend\">\n");
      out.write("                    <div class=\"roti\">\n");
      out.write("                        <h1>Friend</h1>\n");
      out.write("                        <input type=\"submit\" class=\"nutdangnhap\" value=\"Đăng nhập\"><br />\n");
      out.write("                        <a href=\"CheckAcc.jsp\">Quên mật khẩu?</a>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                \n");
      out.write("            </form>\n");
      out.write("            \n");
      out.write("                <div id=\"dangky\">\n");
      out.write("                            <br><br>Bạn chưa có tài khoản?\n");
      out.write("                            <a href=\"FormRegistration.jsp\">Đăng ký ngay!</a>\n");
      out.write("                        </div>\n");
      out.write("            <br>\n");
      out.write("            <img src=\"img/logo.png\" width=\"150px\" height=\"150px\">\n");
      out.write("        </div>\n");
      out.write("         <footer id=\"footer\">\n");
      out.write("                <div class=\"container\">\n");
      out.write("                    MakeFriend Social Network  &copy; 2018\n");
      out.write("                </div>    \n");
      out.write("            </footer>\n");
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
