package org.apache.jsp.jsp.include;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class footer_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\r\n");
      out.write("  <tr>\r\n");
      out.write("    <td height=\"83\" background=\"jsp/images/new/foot_bg.gif\">\r\n");
      out.write("    \t<table width=\"950\" border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\">\r\n");
      out.write("\t      <tr>\r\n");
      out.write("\t        <td width=\"611\" align=\"left\" valign=\"top\"><img src=\"jsp/images/new/foot_img1.gif\" width=\"331\" height=\"83\" /></td>\r\n");
      out.write("\t        <td width=\"339\" valign=\"top\" style=\"padding-top:20px;\">\r\n");
      out.write("\t        \t<a href=\"SiteIntroduce\" class=\"foot-link\">사이트소개</a> &nbsp;|&nbsp;\r\n");
      out.write("\t        \t<a href=\"UseAgreement\" class=\"foot-link\">이용약관</a> &nbsp;|&nbsp; \r\n");
      out.write("\t        \t<a href=\"UseInfo\" class=\"foot-link\">이용안내</a>&nbsp;|&nbsp;\r\n");
      out.write("\t        \t<a href=\"Private\" class=\"foot-link\">개인정보취급방침</a></td>\r\n");
      out.write("\t      </tr>\r\n");
      out.write("    \t</table>\r\n");
      out.write("    </td>\r\n");
      out.write("  </tr>\r\n");
      out.write("</table>\r\n");
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
