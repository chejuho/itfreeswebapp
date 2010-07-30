package org.apache.jsp.jsp.job;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import job.bean.JobSearchBean;

public final class jobRegistResult_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\r\n");

	request.setCharacterEncoding("UTF-8");
JobSearchBean jobSearchBean = (JobSearchBean) request.getAttribute("JobSearchBean");

      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<script language=\"javascript\">\r\n");
      out.write("\tfunction start_index() {\r\n");
      out.write("\t\tdocument.list.action=\"JobSearch?re=9\";\r\n");
      out.write("\t\tdocument.list.submit(); \r\n");
      out.write("\t\treturn true;\r\n");
      out.write("\t}\r\n");
      out.write("</script>\r\n");
      out.write("<body  onload=\"start_index()\">\r\n");
      out.write("\t<form name=\"list\" method=\"post\" style=\"margin:0\">\r\n");
      out.write("\t\t\t<input type=\"hidden\" name=\"user_id\" value=\"");
      out.print(jobSearchBean.getUser_id());
      out.write("\">      \t\t\t\t\t\t  \r\n");
      out.write("\t      \t<input type=\"hidden\" name=\"search_cate_code_1\" value=\"");
      out.print(jobSearchBean.getCate_code_1());
      out.write("\">\r\n");
      out.write("\t\t\t<input type=\"hidden\" name=\"search_cate_code_2\" value=\"");
      out.print(jobSearchBean.getCate_code_2());
      out.write("\">       \t\t\r\n");
      out.write("\t\t\t<input type=\"hidden\" name=\"search_sex\" value=\"");
      out.print(jobSearchBean.getSex());
      out.write("\">          \t\t\t      \t\t\t\t\t \t\t\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t<input type=\"hidden\" name=\"pageNum\" value=\"");
      out.print(jobSearchBean.getPageNum());
      out.write("\"> \r\n");
      out.write("\t\t\t<input type=\"hidden\" name=\"pageSize\" value=\"");
      out.print(jobSearchBean.getPageSize());
      out.write("\">          \t\t\t      \t\t\t\t\t \t\t\t\t\r\n");
      out.write("   \t\t\t<input type=\"hidden\" name=\"search\" value=\"");
      out.print(jobSearchBean.getSearch());
      out.write("\">      \t\t\t      \t\t\t\r\n");
      out.write("   \t\t\t<input type=\"hidden\" name=\"search_range\" value=\"");
      out.print(jobSearchBean.getSearch_range());
      out.write("\">      \t\t\t      \t\t\t\r\n");
      out.write("   \t\t\t<input type=\"hidden\" name=\"before\" value=\"");
      out.print(jobSearchBean.getBefore());
      out.write("\">  \r\n");
      out.write("\t</form>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
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
