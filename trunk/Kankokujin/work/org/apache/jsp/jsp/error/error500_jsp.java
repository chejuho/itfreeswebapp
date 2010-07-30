package org.apache.jsp.jsp.error;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class error500_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static java.util.List _jspx_dependants;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    JspFactory _jspxFactory = null;
    PageContext pageContext = null;
    HttpSession session = null;
    Throwable exception = org.apache.jasper.runtime.JspRuntimeLibrary.getThrowable(request);
    if (exception != null) {
      response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
    }
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      _jspxFactory = JspFactory.getDefaultFactory();
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write('\r');
      out.write('\n');

 response.setStatus(HttpServletResponse.SC_OK);
 request.setCharacterEncoding("UTF-8");
 
      out.write("\r\n");
      out.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<title>Error500</title>\r\n");
      out.write("<meta http-equiv=\"Content-type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("<!-- スタイルシート追加 START▼ -->\r\n");
      out.write("<link href=\"jsp/include/css/kankokujin.css\" rel=\"stylesheet\" type=\"text/css\">\r\n");
      out.write("<!-- ▲END スタイルシート追加 -->\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"960\" align=\"center\">\r\n");
      out.write("\r\n");
      out.write("<!----- top메뉴 ------>\r\n");
      out.write("\t\t<tr valign=\"top\">\r\n");
      out.write("\t\t\t<td colspan=\"3\">\r\n");
      out.write("\t\t\t\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "../include/top.jsp", out, true);
      out.write("\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("<!----- top메뉴 ------>\r\n");
      out.write(" \t\t<tr>\r\n");
      out.write(" \t\t\t<td align=\"center\">管理者にお問い合わせください。</td>\r\n");
      out.write(" \t\t</tr>\r\n");
      out.write(" \t\t<tr>\r\n");
      out.write(" \t\t\t<td align=\"center\">(");
      out.print(exception.getMessage() );
      out.write(")</td>\r\n");
      out.write(" \t\t</tr>\r\n");
      out.write(" </table>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      if (_jspxFactory != null) _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
