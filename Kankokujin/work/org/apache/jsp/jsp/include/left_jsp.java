package org.apache.jsp.jsp.include;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class left_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static java.util.List _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_forEach_var_items;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_forEach_var_items = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_forEach_var_items.release();
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
      out.write("\r\n");
      out.write("<table width=\"224\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<!-- LOGIN START -->\r\n");
      out.write("\t\t<td>\r\n");
      out.write("\t\t\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "../include/login.jsp", out, true);
      out.write("\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td height=\"5\"></td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("  \t<tr>\r\n");
      out.write("        <td>\r\n");
      out.write("    \t\t<!-- Quick 검색 START -->            \t\t\t\r\n");
      out.write("\t\t\t<table id=\"Table_2\" width=\"224\"  border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td height=\"34\" colspan=\"3\" background=\"jsp/images/new/quick_01.gif\"  style=\"padding-left:10px;\">\r\n");
      out.write("\t\t\t\t\t<table width=\"80%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t            \t\t<td width=\"11%\"><img src=\"jsp/images/new/quick_icon.gif\"   width=\"16\" height=\"17\" /></td>\r\n");
      out.write("\t            \t\t<td width=\"89%\" align=\"left\"><strong>Quick 검색</strong></td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t</table>\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t            <td background=\"jsp/images/new/quick_02.gif\"><img src=\"jsp/images/new/quick_02.gif\" width=\"13\" height=\"69\" alt=\"\" /></td>\r\n");
      out.write("\t            <td width=\"198\"  style=\"padding:5px 5px 5px 5px;\">\r\n");
      out.write("\t            \t<a href=\"RoomSellList?re=9&cate_code_1=C10002&room_sort_0=0&room_sort_1=1&room_sort_2=2&room_sort_5=5\" class=\"quick-link\">\r\n");
      out.write("\t            \t\t기숙사(");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${QuickSearchCountBean.domi_count}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write(")\r\n");
      out.write("\t            \t</a>  \r\n");
      out.write("\t            \t<a href=\"RoomSellList?re=9&cate_code_1=C10002&room_sort_3=3\" class=\"quick-link\">\r\n");
      out.write("\t            \t\t룸메이트(");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${QuickSearchCountBean.roomshare_count}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write(")\r\n");
      out.write("\t            \t</a> <br />\r\n");
      out.write("\t              \t<a href=\"RoomSellList?re=9&cate_code_1=C10001&room_sort_8=8\" class=\"quick-link\">\r\n");
      out.write("\t              \t\t민박(");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${QuickSearchCountBean.minshuku_count}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write(")\r\n");
      out.write("\t              \t</a> \r\n");
      out.write("\t              \t<!--<span class=\"red-text-w\"><strong>호텔</strong></span>(102)-->\r\n");
      out.write("\t              \t<a href=\"RoomSellList?re=9&cate_code_1=C10001&room_sort_9=9&room_sort_10=10\" class=\"quick-link\">\r\n");
      out.write("\t              \t\t호텔(");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${QuickSearchCountBean.hotel_count}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write(")\r\n");
      out.write("\t              \t</a> \r\n");
      out.write("\t              \t<a href=\"JobSearch?re=9&search_cate_code_1=C10100\" class=\"quick-link\">\r\n");
      out.write("\t              \t\t사원모집(");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${QuickSearchCountBean.staff_count}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write(")\r\n");
      out.write("\t              \t</a> <br />\r\n");
      out.write("\t              \t<a href=\"JobSearch?re=9&search_cate_code_1=C10200\" class=\"quick-link\">\r\n");
      out.write("\t              \t\t알바모집(");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${QuickSearchCountBean.arbeit_count}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write(")\r\n");
      out.write("\t              \t</a> </td>\r\n");
      out.write("\t            <td background=\"jsp/images/new/quick_04.gif\">\r\n");
      out.write("\t            \t<img src=\"jsp/images/new/quick_04.gif\" width=\"13\" height=\"69\" alt=\"\" />\r\n");
      out.write("\t            </td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td colspan=\"3\"><img src=\"jsp/images/new/quick_05.gif\" width=\"224\" height=\"13\" alt=\"\" /></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t</table>\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td height=\"5\"></td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td>\r\n");
      out.write("\t\t\t<!-- Quick 등록 START --> \r\n");
      out.write("\t\t\t<table id=\"Table_3\" width=\"224\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\r\n");
      out.write("\t  \t\t<tr>\r\n");
      out.write("\t\t\t\t<td height=\"34\" colspan=\"3\" background=\"jsp/images/new/quick_01.gif\"  style=\"padding-left:10px;\">\r\n");
      out.write("\t\t\t\t\t<table width=\"80%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n");
      out.write("\t  \t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td width=\"11%\"><img src=\"jsp/images/new/quick_icon.gif\"   width=\"16\" height=\"17\" /></td>\r\n");
      out.write("\t\t\t\t\t\t<td width=\"89%\" align=\"left\"><strong>Quick 등록</strong></td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t</table>\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td background=\"jsp/images/new/quick_02.gif\"><img src=\"jsp/images/new/quick_02.gif\" width=\"13\" height=\"69\" alt=\"\" /></td>\r\n");
      out.write("\t\t\t\t<td width=\"198\" style=\"padding:5px 5px 5px 5px;\">\r\n");
      out.write("\t\t\t\t\t<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td width=\"48%\">\r\n");
      out.write("\t\t\t\t\t\t\t· <a href=\"BuySellRegistOpen?before=search&f=search&before_cate_code_1=C10100\" class=\"quick-link\">물건사기등록</a> <br />\r\n");
      out.write("\t\t\t\t\t\t  \t· <a href=\"StoreRegistOpen?before=search&f=search\" class=\"quick-link\">업체찾기등록</a> <br />\r\n");
      out.write("\t\t\t\t\t\t  \t· <a href=\"RoomSellRegistOpen?cate_code_1=C10001&before=search&f=search\" class=\"quick-link\">호텔/민박등록</a><br />\r\n");
      out.write("\t\t\t\t\t\t  \t· <a href=\"HouseSellRegistOpen??before=search&f=search\" class=\"quick-link\">부동산등록 </a><br />\r\n");
      out.write("\t\t\t\t\t\t  \t· <a href=\"JobRegistOpen?before=search&f=search&cate_code_1=C10200\" class=\"quick-link\">알바구인등록</a> \r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t<td width=\"52%\">\r\n");
      out.write("\t\t\t\t\t\t\t· <a href=\"BuySellRegistOpen?before=search&f=search&&before_cate_code_1=C10200\" class=\"quick-link\">물건팔기등록</a><br />\r\n");
      out.write("\t\t\t\t\t\t  \t· <a href=\"GourmetRegistOpen?before=search&f=search\" class=\"quick-link\">음식점등록</a> <br />\r\n");
      out.write("\t\t\t\t\t\t  \t· <a href=\"RoomSellRegistOpen?cate_code_1=C10002&before=search&f=search\" class=\"quick-link\">기숙사/룸메등록 </a><br />\r\n");
      out.write("\t\t\t\t\t\t  \t· <a href=\"JobRegistOpen?before=search&f=search&cate_code_1=C10100\" class=\"quick-link\">사원구인등록 </a><br />\r\n");
      out.write("\t\t\t\t\t\t  \t· <a href=\"FindjobRegistOpen?before=search&f=search\" class=\"quick-link\">구직등록</a>\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t</table>\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t<td background=\"jsp/images/new/quick_04.gif\"><img src=\"jsp/images/new/quick_04.gif\" width=\"13\" height=\"69\" alt=\"\" /></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td colspan=\"3\"><img src=\"jsp/images/new/quick_05.gif\" width=\"224\" height=\"13\" alt=\"\" /></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t</table>\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td height=\"5\"></td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td>\r\n");
      out.write("\t\t\t<!-- Quick 업체찾기 START --> \t\t\t\t\t\t\r\n");
      out.write("\t\t\t<table id=\"Table_4\" width=\"224\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("    \t\t\t<td height=\"34\" colspan=\"3\" background=\"jsp/images/new/quick_01.gif\"  style=\"padding-left:10px;\">\r\n");
      out.write("    \t\t\t\t<table width=\"80%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n");
      out.write("      \t\t\t\t<tr>\r\n");
      out.write("       \t\t \t\t\t<td width=\"11%\"><img src=\"jsp/images/new/quick_icon.gif\"   width=\"16\" height=\"17\" /></td>\r\n");
      out.write("        \t\t\t\t<td width=\"89%\" align=\"left\"><strong>Quick 업체찾기</strong></td>\r\n");
      out.write("      \t\t\t\t</tr>\r\n");
      out.write("    \t\t\t\t</table>\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("    \t\t\t<td background=\"jsp/images/new/quick_02.gif\">\r\n");
      out.write("    \t\t\t\t<img src=\"jsp/images/new/quick_02.gif\" width=\"13\" height=\"69\" alt=\"\" />\r\n");
      out.write("    \t\t\t</td>\r\n");
      out.write("    \t\t\t<td width=\"198\" style=\"padding:5px 5px 5px 5px;\">\r\n");
      out.write("    \t\t\t\t· <a href=\"StoreSearch?re=9&search_cate_code_1=C10100&search_cate_code_2=C20102\" class=\"quick-link\">나라시</a>   \r\n");
      out.write("    \t\t\t\t· <a href=\"StoreSearch?re=9&search_cate_code_1=C10100&search_cate_code_2=C20104\" class=\"quick-link\">이사</a>   \r\n");
      out.write("    \t\t\t\t· <a href=\"StoreSearch?re=9&search_cate_code_1=C10200&search_cate_code_2=C20202\" class=\"quick-link\">부동산</a> <br />\r\n");
      out.write("      \t\t\t\t· <a href=\"StoreSearch?re=9&search_cate_code_1=C10500&search_cate_code_2=C20501\" class=\"quick-link\">리사이클</a>   \r\n");
      out.write("      \t\t\t\t· <a href=\"StoreSearch?re=9&search_cate_code_1=C11100&search_cate_code_2=C21101\" class=\"quick-link\">미용실</a>  \r\n");
      out.write("      \t\t\t \t· <a href=\"StoreSearch?re=9&search_cate_code_1=C10500&search_cate_code_2=C20513\" class=\"quick-link\">세탁소</a><br />\r\n");
      out.write("      \t\t\t\t· <a href=\"StoreSearch?re=9&search_cate_code_1=C10700&search_cate_code_2=C20703\" class=\"quick-link\">한국식품</a> \r\n");
      out.write("      \t\t\t</td>\r\n");
      out.write("\t\t\t\t<td background=\"jsp/images/new/quick_04.gif\"><img src=\"jsp/images/new/quick_04.gif\" width=\"13\" height=\"69\" alt=\"\" /></td>\r\n");
      out.write("  \t\t\t\t</tr>\r\n");
      out.write("  \t\t\t<tr>\r\n");
      out.write("    \t\t\t<td colspan=\"3\"><img src=\"jsp/images/new/quick_05.gif\" width=\"224\" height=\"13\" alt=\"\" /></td>\r\n");
      out.write("  \t\t\t</tr>\r\n");
      out.write("\t\t\t</table>\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td height=\"5\"></td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td>\r\n");
      out.write("\t\t\t<table id=\"Table_5\" width=\"224\" height=\"131\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\r\n");
      out.write("  \t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td colspan=\"3\"><img src=\"jsp/images/new/notice_01.gif\" width=\"224\" height=\"8\" alt=\"\" /></td>\r\n");
      out.write("  \t\t\t\t</tr>\r\n");
      out.write("  \t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td><img src=\"jsp/images/new/notice_02.gif\" width=\"8\" height=\"115\" alt=\"\" /></td>\r\n");
      out.write("\t\t\t\t<td width=\"208\" valign=\"top\" style=\"padding:5px 5px 5px 5px;\">\r\n");
      out.write("\t\t\t\t\t<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n");
      out.write("  \t\t\t\t\t<tr>\r\n");
      out.write("    \t\t\t\t\t<td><a href=\"InformList\" class=\"quick-link\"><strong>공지사항</strong></a></td>\r\n");
      out.write("    \t\t\t\t\t<td align=\"right\"><a href=\"InformList\" class=\"quick-link\"><img src=\"jsp/images/new/notice_more_b.gif\" width=\"16\" height=\"16\" /></a></td>\r\n");
      out.write("  \t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td height=\"2\" colspan=\"2\" bgcolor=\"#CCCCCC\"></td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td height=\"8\" colspan=\"2\" valign=\"top\"></td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("  \t\t\t\t\t<tr>\r\n");
      out.write("    \t\t\t\t\t<td colspan=\"2\" valign=\"top\">\r\n");
      out.write("\t\t\t\t\t\t\t");
      if (_jspx_meth_c_forEach_0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("  \t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t</table>\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t<td><img src=\"jsp/images/new/notice_04.gif\" width=\"8\" height=\"115\" alt=\"\" /></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td colspan=\"3\"><img src=\"jsp/images/new/notice_05.gif\" width=\"224\" height=\"8\" alt=\"\" /></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t</table>\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("</table>");
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

  private boolean _jspx_meth_c_forEach_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_0.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_0.setParent(null);
    _jspx_th_c_forEach_0.setVar("InformBean");
    _jspx_th_c_forEach_0.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${InformBeanList}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int[] _jspx_push_body_count_c_forEach_0 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_0 = _jspx_th_c_forEach_0.doStartTag();
      if (_jspx_eval_c_forEach_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("\t\t\t\t\t\t\t\t<a href=\"javascript:openDetailPage(9, '");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${InformBean.id}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("');\">·");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${InformBean.title}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("<br /></a>\r\n");
          out.write("\t\t\t\t\t\t\t");
          int evalDoAfterBody = _jspx_th_c_forEach_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_0.doFinally();
      _jspx_tagPool_c_forEach_var_items.reuse(_jspx_th_c_forEach_0);
    }
    return false;
  }
}
