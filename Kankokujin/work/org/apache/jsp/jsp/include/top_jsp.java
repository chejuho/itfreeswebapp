package org.apache.jsp.jsp.include;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import common.bean.MemberBean;
import common.bean.SearchBean;
import common.util.EnDecoding;
import common.util.Util;

public final class top_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static java.util.List _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_forEach_varStatus_var_items;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_if_test;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_forEach_varStatus_var_items = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_if_test = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_forEach_varStatus_var_items.release();
    _jspx_tagPool_c_if_test.release();
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
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!--Banner Process START -->\r\n");
      out.write("\t");
      if (_jspx_meth_c_forEach_0(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
      out.write('	');
      if (_jspx_meth_c_forEach_1(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("<!--Banner Process END -->\r\n");
      out.write("<form name=\"allsearch\" method=\"post\" action=\"AllSearch\"> \r\n");
      out.write("<table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\r\n");
      out.write("\t<tr>\t\r\n");
      out.write("\t\t<td height=\"25\" background=\"jsp/images/new/top_bg.gif\">\r\n");
      out.write("\t\t\t<table width=\"950\"  height=\"25\" border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\">\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t        <td width=\"687\" class=\"top-font\"><img src=\"jsp/images/new/top_icon.png\"   align=\"absmiddle\" width=\"11\" height=\"16\" /> \r\n");
      out.write("\t\t        \t\t<span class=\"top-text\">Kankokujin.com에오신것을 환영합니다.</span>\r\n");
      out.write("\t\t        \t</td>\r\n");
      out.write("\t\t\t        <td width=\"263\" align=\"right\" class=\"top-text\">\r\n");
      out.write("\t\t\t\t\t\t<!--<a href=\"javascript:goBookMark('");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${memberInfo.userid}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("')\" class=\"umenu-link\"> 북마크</a>-->\r\n");
      out.write("\t\t\t\t\t\t<a href=\"javascript:goBookMarkManager('");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${memberInfo.userid}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("')\" class=\"umenu-link\"> 북마크</a>\r\n");
      out.write("\t\t\t\t\t\t<a href=\"javascript:bookmarksite('KANKOKUJIN.COM', 'http://www.kankokujin.com/')\" target=\"_self\">즐겨찾기설정하기</a>\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t    \t</table>\r\n");
      out.write("    </td>\r\n");
      out.write("  </tr>\r\n");
      out.write("  <tr>\r\n");
      out.write("    <td>&nbsp;</td>\r\n");
      out.write("  </tr>\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td>\r\n");
      out.write("\t    \t<table width=\"950\"  border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\">\r\n");
      out.write("\t      \t<tr><!--로고 -->\r\n");
      out.write("\t\t        <td width=\"331\"><a href=\"Index\"><img src=\"jsp/images/new/logo.gif\" width=\"331\" height=\"41\" border=\"0\"></a></td>\r\n");
      out.write("\t\t        <td width=\"98\" align=\"right\">&nbsp;</td>\r\n");
      out.write("\t\t        <!--로그인,내가쓴글,회원정보등 -->\r\n");
      out.write("\t\t        <td width=\"521\" align=\"left\" valign=\"bottom\">\r\n");
      out.write("\t\t\t\t\t<img src=\"jsp/images/new/top_m_icon1.gif\"  align=\"absmiddle\" width=\"16\" height=\"19\" />\r\n");
      out.write("\t\t\t\t\t");
      if (_jspx_meth_c_if_2(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t\t\t");
      if (_jspx_meth_c_if_3(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t\t\t<img src=\"jsp/images/new/top_m_icon2.gif\" align=\"absmiddle\" width=\"16\" height=\"17\" /><a href=\"MyWrite\" class=\"top-link\"> 내가쓴글</a>&nbsp; \r\n");
      out.write("\t\t\t\t\t<img src=\"jsp/images/new/top_m_icon3.gif\" align=\"absmiddle\" width=\"16\" height=\"16\" /><a href=\"MemberDetail\" class=\"top-link\">회원정보</a>&nbsp; \r\n");
      out.write("\t\t\t\t\t<img src=\"jsp/images/new/top_m_icon4.gif\" align=\"absmiddle\" width=\"16\" height=\"16\" /><a href=\"TopRegist\" class=\"top-link\">등록하기</a>&nbsp; \r\n");
      out.write("\t\t\t\t\t<img src=\"jsp/images/new/top_m_icon5.gif\" align=\"absmiddle\" width=\"16\" height=\"16\" /><a href=\"FAQ\" class=\"top-link\">FAQ</a>&nbsp; \r\n");
      out.write("\t\t\t\t\t<img src=\"jsp/images/new/top_m_icon6.gif\" align=\"absmiddle\" width=\"16\" height=\"16\" /><a href=\"SiteMap\" class=\"top-link\">사이트맵</a>&nbsp; \r\n");
      out.write("\t\t\t\t\t<img src=\"jsp/images/new/top_m_icon7.gif\" align=\"absmiddle\" width=\"16\" height=\"16\" /><a href=\"ContactusRegistOpen\" class=\"top-link\">문의하기</a></strong>\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t</table>\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t<td height=\"6\"></td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t<td>\r\n");
      out.write("\t\t<table width=\"950\" border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\">\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<td valign=\"bottom\"> <img src=\"jsp/images/new/menu_left.gif\" width=\"23\"  alt=\"\" /></td>\r\n");
      out.write("\t\t\t<td valign=\"bottom\"><!--물건사기 --><a href=\"BuySellList?re=9&search_cate_code_1=C10100\" ><img src=\"jsp/images/new/menu_01.gif\" width=\"95\" height=\"63\" border=\"0\" ></a></td>\r\n");
      out.write("\t\t\t<td valign=\"bottom\"><!--물건팔기 --><a href=\"BuySellList?re=9&search_cate_code_1=C10200\" ><img src=\"jsp/images/new/menu_02.gif\" width=\"104\" height=\"63\" border=\"0\" ></a></td>\r\n");
      out.write("\t\t\t<td valign=\"bottom\"><!--업체찾기 --><a href=\"StoreSearch?re=9\" ><img src=\"jsp/images/new/menu_03.gif\" width=\"109\" height=\"63\" border=\"0\" ></a></td>\r\n");
      out.write("\t\t\t<td valign=\"bottom\"><!--음식점 --><a href=\"GourmetSearch?re=9\" ><img src=\"jsp/images/new/menu_04.gif\" width=\"91\" height=\"63\" border=\"0\" ></a></td>\r\n");
      out.write("\t\t\t<td valign=\"bottom\"><!--호텔/민박 --><a href=\"RoomSellList?re=9&cate_code_1=C10001\" ><img src=\"jsp/images/new/menu_05.gif\" width=\"114\" height=\"63\" border=\"0\" ></a></td>\r\n");
      out.write("\t\t\t<td valign=\"bottom\"><!--기숙사 /룸메이트--><a href=\"RoomSellList?re=9&cate_code_1=C10002\" ><img src=\"jsp/images/new/menu_06.gif\" width=\"151\" height=\"63\" border=\"0\" ></a></td>\r\n");
      out.write("\t\t\t<td valign=\"bottom\"><!--부동산 --><a href=\"HouseSellList?re=9\" ><img src=\"jsp/images/new/menu_07.gif\" width=\"98\" height=\"63\" border=\"0\" ></a></td>\r\n");
      out.write("\t\t\t<td valign=\"bottom\"><!--구인 --><a href=\"JobSearch?re=9\" ><img src=\"jsp/images/new/menu_08.gif\" width=\"75\" height=\"63\" border=\"0\" ></a></td>\r\n");
      out.write("\t\t\t<td valign=\"bottom\"><!--구직--><a href=\"FindjobSearch?re=9\" ><img src=\"jsp/images/new/menu_09.gif\" width=\"65\" height=\"63\" border=\"0\" ></a></td>\r\n");
      out.write("\t\t\t<td><img src=\"jsp/images/new/menu_right.gif\" width=\"25\" height=\"63\" alt=\"\"  /></td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<td height=\"52\" colspan=\"11\" background=\"jsp/images/new/all_search_bg.gif\"><table width=\"900\" border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\">\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("            <td width=\"40\" align=\"left\"><img src=\"jsp/images/new/hot_search_icon.png\" align=\"absmiddle\" width=\"29\" height=\"17\" /></td>\r\n");
      out.write("            <td width=\"240\" align=\"left\">\r\n");
      out.write("            \t<div id=\"banner\"></div>\r\n");
      out.write("            </td>\r\n");
      out.write("            <!--검색-->\r\n");
      out.write("            <td width=\"360\" align=\"left\">\r\n");
      out.write("            \t<select name=\"all_search_range\" id=\"select\">\r\n");
      out.write("\t            \t<option value='0'>통합검색</option>\r\n");
      out.write("\t\t\t\t\t<option value='1' ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${SearchBean.all_search_range1_selected}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write(">물건사기</option>\r\n");
      out.write("\t\t\t\t\t<option value='2' ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${SearchBean.all_search_range2_selected}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write(">물건팔기</option>\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t<option value='3' ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${SearchBean.all_search_range3_selected}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write(">업체찾기</option>\t\t\r\n");
      out.write("\t\t\t\t\t<option value='4' ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${SearchBean.all_search_range4_selected}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write(">음식점</option>\r\n");
      out.write("\t\t\t\t\t<option value='7' ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${SearchBean.all_search_range7_selected}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write(">구인</option>\r\n");
      out.write("\t\t\t\t\t<option value='8' ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${SearchBean.all_search_range8_selected}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write(">구직</option>\t\t\t\r\n");
      out.write("             \t</select>\r\n");
      out.write("             \t<input type=\"text\" name=\"all_search\" id=\"all_search\" style=\"width:190px; \" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${SearchBean.all_search}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\" />\r\n");
      out.write("                <a href=\"javascript:searchAll();\"><img src=\"jsp/images/new/all_search_b.gif\"  width=\"45\" height=\"21\" align=\"absmiddle\"/></a>\r\n");
      out.write("           </td>\r\n");
      out.write("            <td width=\"40\" class=\"top-ad\"><img src=\"jsp/images/new/ad_icon.png\" align=\"absmiddle\" width=\"29\" height=\"17\" /></td>\r\n");
      out.write("            <td width=\"220\"> <span class=\"style2\" id=\"ad\"></span></td>\r\n");
      out.write("          </tr>\r\n");
      out.write("        </table></td>\r\n");
      out.write("      \t</tr>\r\n");
      out.write("    \t</table>\r\n");
      out.write("    </td>\r\n");
      out.write("  </tr>\r\n");
      out.write("</form>");
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
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_varStatus_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_0.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_0.setParent(null);
    _jspx_th_c_forEach_0.setVar("Banner");
    _jspx_th_c_forEach_0.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${BannerList1}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    _jspx_th_c_forEach_0.setVarStatus("status");
    int[] _jspx_push_body_count_c_forEach_0 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_0 = _jspx_th_c_forEach_0.doStartTag();
      if (_jspx_eval_c_forEach_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("\t\t<input type=\"hidden\" name=\"banner");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${status.index}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("\" id=\"banner");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${status.index}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("\" value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${Banner.bannerTag}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("\"/>\r\n");
          out.write("\t\t");
          if (_jspx_meth_c_if_0(_jspx_th_c_forEach_0, _jspx_page_context, _jspx_push_body_count_c_forEach_0))
            return true;
          out.write("\t\t\t\t\r\n");
          out.write("\t");
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
      _jspx_tagPool_c_forEach_varStatus_var_items.reuse(_jspx_th_c_forEach_0);
    }
    return false;
  }

  private boolean _jspx_meth_c_if_0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_0.setPageContext(_jspx_page_context);
    _jspx_th_c_if_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_0);
    _jspx_th_c_if_0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${status.last}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_if_0 = _jspx_th_c_if_0.doStartTag();
    if (_jspx_eval_c_if_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t<input type=\"hidden\" name=\"bannerIndex\" id = \"bannerIndex\" value=\"");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${status.index}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
        out.write("\"/>\r\n");
        out.write("\t\t");
        int evalDoAfterBody = _jspx_th_c_if_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_0);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_0);
    return false;
  }

  private boolean _jspx_meth_c_forEach_1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_1 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_varStatus_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_1.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_1.setParent(null);
    _jspx_th_c_forEach_1.setVar("Banner");
    _jspx_th_c_forEach_1.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${BannerList2}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    _jspx_th_c_forEach_1.setVarStatus("status");
    int[] _jspx_push_body_count_c_forEach_1 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_1 = _jspx_th_c_forEach_1.doStartTag();
      if (_jspx_eval_c_forEach_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("\t\t<input type=\"hidden\" name=\"ad");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${status.index}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("\" id=\"ad");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${status.index}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("\" value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${Banner.bannerTag}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("\"/>\r\n");
          out.write("\t\t");
          if (_jspx_meth_c_if_1(_jspx_th_c_forEach_1, _jspx_page_context, _jspx_push_body_count_c_forEach_1))
            return true;
          out.write("\t\t\t\t\r\n");
          out.write("\t");
          int evalDoAfterBody = _jspx_th_c_forEach_1.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_1[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_1.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_1.doFinally();
      _jspx_tagPool_c_forEach_varStatus_var_items.reuse(_jspx_th_c_forEach_1);
    }
    return false;
  }

  private boolean _jspx_meth_c_if_1(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_1, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_1)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_1 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_1.setPageContext(_jspx_page_context);
    _jspx_th_c_if_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_1);
    _jspx_th_c_if_1.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${status.last}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_if_1 = _jspx_th_c_if_1.doStartTag();
    if (_jspx_eval_c_if_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t<input type=\"hidden\" name=\"adIndex\" id = \"adIndex\" value=\"");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${status.index}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
        out.write("\"/>\r\n");
        out.write("\t\t");
        int evalDoAfterBody = _jspx_th_c_if_1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_1);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_1);
    return false;
  }

  private boolean _jspx_meth_c_if_2(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_2 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_2.setPageContext(_jspx_page_context);
    _jspx_th_c_if_2.setParent(null);
    _jspx_th_c_if_2.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${!empty memberInfo.userid}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_if_2 = _jspx_th_c_if_2.doStartTag();
    if (_jspx_eval_c_if_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t\t\t<a href=\"javascript:actionforward('MemberLogout')\" class=\"top-link\">로그아웃</a>&nbsp;\r\n");
        out.write("\t\t\t\t\t");
        int evalDoAfterBody = _jspx_th_c_if_2.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_2);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_2);
    return false;
  }

  private boolean _jspx_meth_c_if_3(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_3 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_3.setPageContext(_jspx_page_context);
    _jspx_th_c_if_3.setParent(null);
    _jspx_th_c_if_3.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${empty memberInfo.userid}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_if_3 = _jspx_th_c_if_3.doStartTag();
    if (_jspx_eval_c_if_3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t\t\t<a href=\"javascript:actionforward('MemberLoginOpen')\" class=\"top-link\">로그인</a>&nbsp;\r\n");
        out.write("\t\t\t\t\t");
        int evalDoAfterBody = _jspx_th_c_if_3.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_3);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_3);
    return false;
  }
}
