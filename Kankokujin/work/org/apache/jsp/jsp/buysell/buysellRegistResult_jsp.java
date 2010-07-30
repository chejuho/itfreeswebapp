package org.apache.jsp.jsp.buysell;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import buysell.bean.BuySellSearchBean;
import common.constant.Const;

public final class buysellRegistResult_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\r\n");

	request.setCharacterEncoding("UTF-8");
	BuySellSearchBean buySellSearchBean = (BuySellSearchBean) request.getAttribute("BuySellSearchBean");

      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<script language=\"javascript\">\r\n");
      out.write("\tfunction start_index() {\r\n");
      out.write("\t\tdocument.list.action=\"BuySellList?re=9\";\r\n");
      out.write("\t\tdocument.list.submit(); \r\n");
      out.write("\t\treturn true;\r\n");
      out.write("\t}\r\n");
      out.write("</script>\r\n");
      out.write("<body  onload=\"start_index()\">\r\n");
      out.write("\t<form name=\"list\" method=\"post\" style=\"margin:0\">\r\n");
      out.write("\t\t<input type=\"hidden\" name=\"user_id\" value=\"");
      out.print(buySellSearchBean.getUser_id());
      out.write("\">      \t\r\n");
      out.write("      \t<input type=\"hidden\" name=\"search_cate_code_1\" value=\"");
      out.print(buySellSearchBean.getCate_code_1());
      out.write("\">\t\t\r\n");
      out.write("      \t<input type=\"hidden\" name=\"search_cate_code_2\" value=\"");
      out.print(buySellSearchBean.getCate_code_2());
      out.write("\">\t\t      \t\r\n");
      out.write("\t\t<input type=\"hidden\" name=\"search_pro_status\" value=\"");
      out.print(buySellSearchBean.getPro_status());
      out.write("\">      \t\t\t\r\n");
      out.write("\t\t<input type=\"hidden\" name=\"search_free_price\" value=\"");
      out.print(buySellSearchBean.getFree_price());
      out.write("\">      \t\t\t      \t\t\t      \t\t\t\r\n");
      out.write("\t\t<input type=\"hidden\" name=\"search_member_sort\" value=\"");
      out.print(buySellSearchBean.getMember_sort());
      out.write("\">      \t\t\t      \t\t\t      \t\t\t\r\n");
      out.write("\t\t<input type=\"hidden\" name=\"search_free_price\" value=\"");
      out.print(buySellSearchBean.getFree_price());
      out.write("\">      \t\t\t      \t\t\t      \t\t\t\r\n");
      out.write("\t\t<input type=\"hidden\" name=\"search_sold_out\" value=\"");
      out.print(buySellSearchBean.getSold_out());
      out.write("\">      \t\t\t      \t\t\t\r\n");
      out.write("\t\t<input type=\"hidden\" name=\"search_send_method\" value=\"");
      out.print(buySellSearchBean.getSend_method());
      out.write("\">      \t\t\t      \t\t\t      \t\t\t\r\n");
      out.write("\t\t<input type=\"hidden\" name=\"search_range\" value=\"");
      out.print(buySellSearchBean.getSearch_range());
      out.write("\">      \t\t\t      \t\t\t      \t\t\t\r\n");
      out.write("\t\t<input type=\"hidden\" name=\"search\" value=\"");
      out.print(buySellSearchBean.getSearch());
      out.write("\">      \t\t\t      \t\t\t\r\n");
      out.write("\t\t<input type=\"hidden\" name=\"decodedSearch\" value=\"");
      out.print(buySellSearchBean.getDecodedSearch());
      out.write("\">      \t\t\t      \t\t\t\r\n");
      out.write("\t\t<input type=\"hidden\" name=\"pageNum\" value=\"");
      out.print(buySellSearchBean.getPageNum());
      out.write("\">      \t\t\t  \t\t\t      \t\t\t\r\n");
      out.write("\t\t<input type=\"hidden\" name=\"pageSize\" value=\"");
      out.print(buySellSearchBean.getPageSize());
      out.write("\">      \t\t\t  \t\t\t      \t\t\t      \t\t\t\r\n");
      out.write("\t\t<input type=\"hidden\" name=\"before\" value=\"");
      out.print(buySellSearchBean.getBefore());
      out.write("\">      \t\t\t  \t\t\t      \t\t\t      \t\t\t\t\t\t      \t\r\n");
      out.write(" \t\t<input type=\"hidden\" name=\"list_view\" value=\"");
      out.print(buySellSearchBean.getList_view());
      out.write("\">       \t\t\t        \t\t\t      \t\t\t \t\t\t\t\t\t\r\n");
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
