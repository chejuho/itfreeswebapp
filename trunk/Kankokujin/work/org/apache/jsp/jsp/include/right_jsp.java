package org.apache.jsp.jsp.include;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class right_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<table width=\"188\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n");
      out.write("\t<!-- 광고문의 START -->        \t\t\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td>\r\n");
      out.write("\t\t\t<table width=\"188\" border=\"0\" cellpadding=\"0\" cellspacing=\"1\" bgcolor=\"#dedede\">\r\n");
      out.write("\t      \t<tr>\r\n");
      out.write("\t        \t<td height=\"24\" background=\"jsp/images/new/main_rbox_bg.gif\" style=\"padding-left:10px;\"><strong class=\"orange-text\">광고문의</strong></td>\r\n");
      out.write("\t      \t</tr>\r\n");
      out.write("\t  \t\t<tr>\r\n");
      out.write("\t\t\t\t<td bgcolor=\"#FFFFFF\"style=\"padding:6px 6px 6px 6px;\">\r\n");
      out.write("\t\t\t\t\t<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n");
      out.write("\t              \t<tr>\r\n");
      out.write("\t                \t<td width=\"13%\" align=\"left\"><img src=\"jsp/images/new/tel_icon1.gif\" width=\"16\" height=\"15\" /></td>\r\n");
      out.write("\t                \t<td width=\"87%\" align=\"left\">Tel) 03-3333-4444</td>\r\n");
      out.write("\t              \t</tr>\r\n");
      out.write("\t              \t<tr>\r\n");
      out.write("\t                \t<td width=\"13%\" align=\"left\"><img src=\"jsp/images/new/email_icon1.gif\" width=\"16\" height=\"11\" /></td>\r\n");
      out.write("\t                \t<td align=\"left\"> info@kankokujin.com</td>\r\n");
      out.write("\t              \t</tr>\r\n");
      out.write("\t\t\t\t\t</table>\t\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t  \t\t</tr>\r\n");
      out.write("\t\t\t</table>\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td height=\"5\"></td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<!-- 환율정보 START -->           \t\t\t\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td>\r\n");
      out.write("\t\t\t<table width=\"188\" border=\"0\" cellpadding=\"0\" cellspacing=\"1\" bgcolor=\"#dedede\">\r\n");
      out.write("\t    \t<tr>\r\n");
      out.write("\t        \t<td height=\"24\" background=\"jsp/images/new/main_rbox_bg.gif\" style=\"padding-left:10px;\"><strong>환율정보</strong></td>\r\n");
      out.write("\t      \t</tr>\r\n");
      out.write("\t      \t<tr>\r\n");
      out.write("\t        \t<td align=\"center\" bgcolor=\"#FFFFFF\" style=\"padding:6px 6px 6px 6px;\">\r\n");
      out.write("\t        \t\t<iframe src=\"http://community.fxkeb.com/fxportal/jsp/RS/DEPLOY_EXRATE/4768_2.html\" width=\"158\" height=\"115\" border=\"0\" frameborder=\"no\" scrolling=\"no\" marginwidth=\"0\" hspace=\"0\" vspace=\"0\"> </iframe>\r\n");
      out.write("\t        \t</td>\r\n");
      out.write("\t      \t</tr>\r\n");
      out.write("\t\t\t</table>\r\n");
      out.write("\t\t</td>\r\n");
      out.write("  \t</tr>\r\n");
      out.write("  \t<tr>\r\n");
      out.write("\t\t<td height=\"5\"></td>\r\n");
      out.write("  \t</tr>\r\n");
      out.write("  \t<!-- 날씨정보 START -->   \t\t          \t\r\n");
      out.write("  \t<tr>\r\n");
      out.write("\t\t<td>\r\n");
      out.write("\t\t\t<table width=\"188\" border=\"0\" cellpadding=\"0\" cellspacing=\"1\" bgcolor=\"#dedede\">\r\n");
      out.write("\t  \t\t<tr>\r\n");
      out.write("\t\t\t\t<td height=\"24\" background=\"jsp/images/new/main_rbox_bg.gif\" style=\"padding-left:10px;\">\r\n");
      out.write("\t\t\t\t\t<strong>날씨정보</strong>\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t  \t\t</tr>\r\n");
      out.write("\t  \t\t<tr>\r\n");
      out.write("\t\t\t\t<td align=\"center\" bgcolor=\"#FFFFFF\" style=\"padding:6px 6px 6px 6px;\">\r\n");
      out.write("\t\t\t\t\t<iframe src=\"http://link.tenki-yoho.com/img.php?all,acrweb\" width=150 height=180 scrolling=NO frameborder=0 marginwidth=0 marginheight=0></iframe>\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t  \t\t</tr>\r\n");
      out.write("\t  \t\t</table>\r\n");
      out.write("\t  \t</td>\r\n");
      out.write("  \t</tr>\r\n");
      out.write("  \t<tr>\r\n");
      out.write("\t\t<td>&nbsp;</td>\r\n");
      out.write("  \t</tr>\r\n");
      out.write("  \t<tr>\r\n");
      out.write("\t\t<td>&nbsp;</td>\r\n");
      out.write("  \t</tr>\t\r\n");
      out.write("  </table>\r\n");
      out.write("       \r\n");
      out.write("                  ");
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
