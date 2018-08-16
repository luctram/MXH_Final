package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class AdminLogin_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <title>MAKEFRIEND SOCIAL NETWORK ADMINISTRATOR</title>\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"AdminCss.css\">\n");
      out.write("        <style>\n");
      out.write("           #login {\n");
      out.write("  margin-left: -230px;\n");
      out.write("  background: black;\n");
      out.write("  color: white;\n");
      out.write("  text-align: right;\n");
      out.write("  cursor: pointer;\n");
      out.write("  transition: all 1s ease-out;\n");
      out.write("}\n");
      out.write("#login:hover {\n");
      out.write("  background: #81827c;\n");
      out.write("  transition: all 0.3s ease-in;\n");
      out.write("}\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div id=\"warp\">\n");
      out.write("            MakeFriend Social Network Administrator\n");
      out.write("            <form action=\"../Servlet_AdminLogin\" method=\"POST\" id=\"formu\">\n");
      out.write("                <div class=\"admin\">\n");
      out.write("                    <div class=\"rota\">\n");
      out.write("                        <h1>ADMIN</h1>\n");
      out.write("                        <input id=\"username\" type=\"text\" name=\"name\" value=\"\" placeholder=\"Tên đăng nhập\" /><br />\n");
      out.write("                        <input id=\"password\" type=\"password\" name=\"pass\" value=\"\" placeholder=\"             Mật khẩu\" />\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"title\">\n");
      out.write("                    <div class=\"roti\">\n");
      out.write("                        <h1>M.F</h1>\n");
      out.write("                        <input id=\"login\" type=\"submit\" name=\"valid\" value=\"Đăng nhập\"><br />\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </form>\n");
      out.write("        </div>\n");
      out.write("       \n");
      out.write("    </body>\n");
      out.write("    \n");
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
