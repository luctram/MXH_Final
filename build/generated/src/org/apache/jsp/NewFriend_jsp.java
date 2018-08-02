package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Model.User;

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
      out.write("    <c:set var=\"root\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"/>\n");
      out.write("  \n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("    <div class=\"container\">\n");
      out.write("        <h2>Danh sách bạn bè</h2>\n");
      out.write("        <br>\n");
      out.write("        <div class=\"AddFriendForm\">\n");
      out.write("\n");
      out.write("            <form action=\"./Servlet_SearchFriend\" method=\"POST\" id=\"formfriend\">\n");
      out.write("                <input type=\"text\" name=\"friendinfo\" placeholder=\" Nhập tên/số điện thoại/email bạn cần tìm\">\n");
      out.write("                <input type=\"submit\" value=\"Tìm\" name=\"search\">\n");
      out.write("\n");
      out.write("            </form>\n");
      out.write("            \n");
      out.write("        </div>\n");
      out.write("        <br>\n");
      out.write("\n");
      out.write("        <div class=\"row\">\n");
      out.write("            <div class=\"listfriend\">\n");
      out.write("                <div class=\"col-sm-12\">\n");
      out.write("                    <div class=\"col-sm-1 FriendAvatar\">\n");
      out.write("                        <img src=\"\" class=\"img-circle\" width=\"60px\" id=\"img\">\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-sm-9 FriendName\">\n");
      out.write("                        <h4><a href=\"#\"></a></h4>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-sm-2\">\n");
      out.write("                        <span class=\"glyphicon glyphicon-map-marker text-muted c-info\" data-toggle=\"tooltip\" title=\"\"></span>\n");
      out.write("\n");
      out.write("                        <span class=\"glyphicon glyphicon-earphone text-muted c-info\" data-toggle=\"tooltip\" title=\"\"></span>\n");
      out.write("\n");
      out.write("                        <span class=\"glyphicon glyphicon-envelope text-muted c-info\" data-toggle=\"tooltip\" title=\"\"></span>\n");
      out.write("\n");
      out.write("                        <span class=\"fa fa-user-plus text-muted c-info\" data-toggle=\"tooltip\" title=\"Gửi lời mời kết bạn\"></span>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"clearfix\"></div>\n");
      out.write("                <hr />\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("                        <script type=\"text/javascript\">\n");
      out.write("            var frm = $('#formfriend');\n");
      out.write("            frm.submit(function(){\n");
      out.write("                \n");
      out.write("                $.ajax({\n");
      out.write("                    type: frm.attr('method'), url: frm.attr('action'), data: frm.serialize(), success: function(data){\n");
      out.write("                        var result = data;\n");
      out.write("                        $('#result').attr(\"value\",result);\n");
      out.write("                        var b= result.split(\"-\")\n");
      out.write("                         document.getElementById(\"img\").innerHTML = b[5];\n");
      out.write("                    }\n");
      out.write("                });\n");
      out.write("                return false;\n");
      out.write("            });\n");
      out.write("        </script>\n");
      out.write("</body>\n");
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
