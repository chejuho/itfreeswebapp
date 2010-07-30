package org.apache.jsp.jsp.buysell;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import common.bean.MemberBean;
import common.util.EnDecoding;
import buysell.bean.BuySellBean;
import buysell.bean.BuySellSearchBean;
import common.util.Util;
import common.constant.Const;

public final class buysellDetail_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

static private org.apache.jasper.runtime.ProtectedFunctionMapper _jspx_fnmap_0;

static {
  _jspx_fnmap_0= org.apache.jasper.runtime.ProtectedFunctionMapper.getMapForFunction("util:getNewImage", common.util.Util.class, "getNewImage", new Class[] {java.util.Date.class});
}

  private static java.util.List _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList(2);
    _jspx_dependants.add("/WEB-INF/tlds/pageHandleTag.tld");
    _jspx_dependants.add("/WEB-INF/tlds/utilFunction.tld");
  }

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_fmt_setLocale_value_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_fmt_setBundle_var_basename_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_fmt_message_key_bundle_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_if_test;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_forEach_varStatus_var_items;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_out_value_nobody;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_fmt_setLocale_value_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_fmt_setBundle_var_basename_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_fmt_message_key_bundle_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_if_test = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_forEach_varStatus_var_items = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_out_value_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_fmt_setLocale_value_nobody.release();
    _jspx_tagPool_fmt_setBundle_var_basename_nobody.release();
    _jspx_tagPool_fmt_message_key_bundle_nobody.release();
    _jspx_tagPool_c_if_test.release();
    _jspx_tagPool_c_forEach_varStatus_var_items.release();
    _jspx_tagPool_c_out_value_nobody.release();
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
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      if (_jspx_meth_fmt_setLocale_0(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
      if (_jspx_meth_fmt_setBundle_0(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');

	BuySellBean buySellBean = (BuySellBean) request.getAttribute("BuySellBean");
	BuySellSearchBean buySellSearchBean = (BuySellSearchBean) request.getAttribute("BuySellSearchBean");
	

      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<meta http-equiv=\"Content-type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("<head>\r\n");
      out.write("<title>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${BuySellBean.title}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("&nbsp;::&nbsp;");
      if (_jspx_meth_fmt_message_0(_jspx_page_context))
        return;
      out.write("</title>\r\n");
      out.write("<script src=\"jsp/include/js/prototype.js\" type=\"text/javascript\" ></script>\r\n");
      out.write("<script src=\"jsp/include/js/src/scriptaculous.js?effets\" type=\"text/javascript\" ></script>\r\n");
      out.write("<script src=\"jsp/include/js/popupMenu.js\" type=\"text/javascript\"></script>\r\n");
      out.write("<script src=\"jsp/include/js/top.js\" type=\"text/javascript\"></script>\r\n");
      out.write("<script src=\"jsp/include/js/commonCheck.js\" type=\"text/javascript\"></script>\r\n");
      out.write("<script src=\"jsp/include/js/commonFunction.js\" type=\"text/javascript\"></script>\r\n");
      out.write("<link href=\"jsp/include/css/basic.css\" rel=\"stylesheet\" type=\"text/css\">\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("<!--\r\n");
      out.write("\tvar clickedId;\r\n");
      out.write("\tfunction goDirectTopMenu(topMenu) {\r\n");
      out.write("\t \t//var topMenu =\tdocument.getElementById(\"topMenu\").value;\r\n");
      out.write("\t \tif (topMenu == '1') {\r\n");
      out.write("\t \t\tdocument.wf.action=\"BuySellList?re=9&search_cate_code_1=C10100&search_cate_code_2=\";\r\n");
      out.write("\t \t}\r\n");
      out.write("\t \tif (topMenu == '2') {\r\n");
      out.write("\t \t\tdocument.wf.action=\"BuySellList?re=9&search_cate_code_1=C10200&search_cate_code_2=\";\r\n");
      out.write("\t \t}\r\n");
      out.write("\t \tif (topMenu == '3') {\r\n");
      out.write("\t \t\tdocument.wf.action=\"StoreSearch?re=9\";\r\n");
      out.write("\t \t}\r\n");
      out.write("\t \tif (topMenu == '4') {\r\n");
      out.write("\t \t\tdocument.wf.action=\"GourmetSearch?re=9\";\r\n");
      out.write("\t \t}\r\n");
      out.write("\t \tif (topMenu == '5') {\r\n");
      out.write("\t \t\tdocument.wf.action=\"RoomSellList?re=9&cate_code_1=C10001\";\r\n");
      out.write("\t \t}\r\n");
      out.write("\t \tif (topMenu == '6') {\r\n");
      out.write("\t \t\tdocument.wf.action=\"RoomSellList?re=9&cate_code_1=C10002\";\r\n");
      out.write("\t \t}\r\n");
      out.write("\t \tif (topMenu == '7') {\r\n");
      out.write("\t \t\tdocument.wf.action=\"HouseSellList?re=9\";\r\n");
      out.write("\t \t}\r\n");
      out.write("\t \tif (topMenu == '8') {\r\n");
      out.write("\t \t\tdocument.getElementById(\"search_cate_code_1\").value = \"\";\r\n");
      out.write("\t \t\tdocument.wf.action=\"JobSearch?re=9\";\r\n");
      out.write("\t \t}\r\n");
      out.write("\t \tif (topMenu == '9') {\r\n");
      out.write("\t \t\tdocument.wf.action=\"FindjobSearch?re=9\";\r\n");
      out.write("\t \t}\r\n");
      out.write("\t\tdocument.wf.submit(); \r\n");
      out.write("\t\treturn true;\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\tfunction goDirectCategory(category1, category2) {\r\n");
      out.write("\t\t//var category1 =\tdocument.getElementById(\"category1\").value;\r\n");
      out.write("     \t//var category2 =\tdocument.getElementById(\"category2\").value;\r\n");
      out.write("\t\tdocument.wf.action=\"BuySellList?re=9&search_cate_code_1=\" + category1 + \"&search_cate_code_2=\" + category2;\r\n");
      out.write("\t\tdocument.wf.submit(); \r\n");
      out.write("\t\treturn true;\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction deleteCheck(id){\r\n");
      out.write("\t\r\n");
      out.write("\t\t\tif(confirm(\"삭제하시겠습니까?\")){\r\n");
      out.write("\t\t\t\tdocument.wf.action=\"BuySellDelete?id=\"+id;\r\n");
      out.write("\t\t\t\tdocument.wf.submit(); \r\n");
      out.write("\t\t\t\treturn;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction finishCheck(id, flg){\r\n");
      out.write("\t\r\n");
      out.write("\t\t\tif(confirm(\"판매완료 처리 하시겠습니까?\")){\r\n");
      out.write("\t\t\t\tdocument.wf.action=\"BuySellDelete?id=\"+id+\"&flg=\"+flg;\r\n");
      out.write("\t\t\t\tdocument.wf.submit(); \r\n");
      out.write("\t\t\t\treturn true;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("\t//공개 비공개 판매완료　처리\r\n");
      out.write("\tfunction deleteSignAction(id, flg){\r\n");
      out.write("\t\tif (flg == \"0\") {\r\n");
      out.write("\t\t\tif(confirm(\"공개로  처리 하시겠습니까?\")){\r\n");
      out.write("\t\t\t\tdocument.wf.action=\"BuySellDelete?id=\"+id+\"&flg=\"+flg;\r\n");
      out.write("\t\t\t\tdocument.wf.submit(); \r\n");
      out.write("\t\t\t\treturn true;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tif (flg == \"1\") {\r\n");
      out.write("\t\t\tif(confirm(\"삭제하시겠습니까?\")){\r\n");
      out.write("\t\t\t\tdocument.wf.action=\"BuySellDelete?id=\"+id+\"&flg=\"+flg;\r\n");
      out.write("\t\t\t\tdocument.wf.submit(); \r\n");
      out.write("\t\t\t\treturn true;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tif (flg == \"2\") {\r\n");
      out.write("\t\t\tif(confirm(\"판매완료 처리 하시겠습니까?\")){\r\n");
      out.write("\t\t\t\tdocument.wf.action=\"BuySellDelete?id=\"+id+\"&flg=\"+flg;\r\n");
      out.write("\t\t\t\tdocument.wf.submit(); \r\n");
      out.write("\t\t\t\treturn true;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tif (flg == \"3\") {\r\n");
      out.write("\t\t\tif(confirm(\"비공개로  처리 하시겠습니까?\")){\r\n");
      out.write("\t\t\t\tdocument.wf.action=\"BuySellDelete?id=\"+id+\"&flg=\"+flg;\r\n");
      out.write("\t\t\t\tdocument.wf.submit(); \r\n");
      out.write("\t\t\t\treturn true;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\t\r\n");
      out.write("\t\t\r\n");
      out.write("\tfunction openUpdate(id){\r\n");
      out.write("\t\tdocument.wf.action=\"BuySellUpdateOpen?id=\" + id;\r\n");
      out.write("\t\tdocument.wf.submit(); \r\n");
      out.write("\t\treturn true;\r\n");
      out.write("\t}\t\r\n");
      out.write("\tfunction setImage(position){\r\n");
      out.write("\t\tdocument.getElementById(\"disp\").src = position;\r\n");
      out.write("\t\treturn false;\r\n");
      out.write("\t}\t\r\n");
      out.write("\tfunction backSearchPage() {\r\n");
      out.write("\t\tdocument.wf.action=\"BuySellList?re=9&modoru=ok\";\r\n");
      out.write("\t\tdocument.wf.submit(); \r\n");
      out.write("\t\treturn true;\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction backMySearchPage(ff, obj) {\r\n");
      out.write("\t\tff.submit(); \r\n");
      out.write("\t\treturn true;\r\n");
      out.write("\t}\t\r\n");
      out.write("\tfunction backSearchAllPage() {\r\n");
      out.write("\t\tdocument.wf.action=\"AllSearch\";\r\n");
      out.write("\t\tdocument.wf.submit(); \r\n");
      out.write("\t\treturn true;\r\n");
      out.write("\t}\t\r\n");
      out.write("\tfunction backMyWrite(obj) {\r\n");
      out.write("\t\tdocument.wf.action=\"MyWrite?sort=\" + obj + \"&modoru=ok\";\r\n");
      out.write("\t\tdocument.wf.submit(); \r\n");
      out.write("\t\treturn true;\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction goSearchPage() {\r\n");
      out.write("\t\tdocument.wf.action=\"BuySellList?re=9\";\r\n");
      out.write("\t\tdocument.wf.submit(); \r\n");
      out.write("\t\treturn true;\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\tfunction mailOpenDetail(id,name) {\r\n");
      out.write("\t\tmailOpen(id, name, '1');\r\n");
      out.write("\t\treturn true;\r\n");
      out.write("\t}\r\n");
      out.write("//-->\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body style=\"margin:0 0 0 0\"> \r\n");
      out.write("\t<table>\r\n");
      out.write("\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "../include/top.jsp", out, true);
      out.write("\r\n");
      out.write("\t<tr>\r\n");
      out.write("    \t<td height=\"20\">&nbsp;</td>\r\n");
      out.write("  \t</tr>\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td>\r\n");
      out.write("\t\t\t<form name=\"wf\" method=\"post\">\r\n");
      out.write("\t\t\t<input type=\"hidden\" name=\"id\"\tvalue=\"");
      out.print(buySellBean.getId());
      out.write("\">\r\n");
      out.write("\t\t\t<input type=\"hidden\" name=\"user_id\" value=\"");
      out.print(buySellSearchBean.getUser_id());
      out.write("\">      \t\t    \r\n");
      out.write("\t\t    <input type=\"hidden\" name=\"search_cate_code_1\" value=\"");
      out.print(buySellSearchBean.getCate_code_1());
      out.write("\">\r\n");
      out.write("  \t\t\t<input type=\"hidden\" name=\"search_cate_code_2\" value=\"");
      out.print(buySellSearchBean.getCate_code_2());
      out.write("\">\r\n");
      out.write("  \t\t\t<input type=\"hidden\" name=\"search\" value=\"");
      out.print(buySellSearchBean.getSearch());
      out.write("\">      \t\t\t      \t\t\t\r\n");
      out.write("  \t\t\t<input type=\"hidden\" name=\"decodedSearch\" value=\"");
      out.print(buySellSearchBean.getDecodedSearch());
      out.write("\">      \t\t\t      \t\t\t\r\n");
      out.write("  \t\t\t<input type=\"hidden\" name=\"search_range\" value=\"");
      out.print(buySellSearchBean.getSearch_range());
      out.write("\">      \t\t\t      \t\t\r\n");
      out.write("\t\t\t<input type=\"hidden\" name=\"pageSize\" value=\"");
      out.print(buySellSearchBean.getPageSize());
      out.write("\">      \t\t\t      \t\t\t\t      \t\t\t      \t\t\t      \t\t\t      \t\t\t\r\n");
      out.write("  \t\t\t<input type=\"hidden\" name=\"pageNum\" value=\"");
      out.print(buySellSearchBean.getPageNum());
      out.write("\">      \t\t\t\r\n");
      out.write("  \t\t\t<input type=\"hidden\" name=\"before\" value=\"");
      out.print(buySellSearchBean.getBefore());
      out.write("\">      \t\t\t      \t\t\t\r\n");
      out.write("  \t\t\t<input type=\"hidden\" name=\"list_view\" value=\"");
      out.print(buySellSearchBean.getList_view());
      out.write("\"> \r\n");
      out.write("\t\t\t<input type=\"hidden\" name=\"search_pro_status\" value=\"");
      out.print(buySellSearchBean.getPro_status());
      out.write("\">       \t\t\t\r\n");
      out.write("\t\t\t<input type=\"hidden\" name=\"search_member_sort\" value=\"");
      out.print(buySellSearchBean.getMember_sort());
      out.write("\">       \t\t\t\r\n");
      out.write("\t\t\t<input type=\"hidden\" name=\"search_free_price\" value=\"");
      out.print(buySellSearchBean.getFree_price());
      out.write("\">       \t\t\t\r\n");
      out.write("\t\t\t<input type=\"hidden\" name=\"search_send_method\" value=\"");
      out.print(buySellSearchBean.getSend_method());
      out.write("\">       \t\t\t\r\n");
      out.write("\t\t\t<input type=\"hidden\" name=\"search_sold_out\" value=\"");
      out.print(buySellSearchBean.getSold_out());
      out.write("\">  \r\n");
      out.write("  \t\t\t<input type=\"hidden\" name=\"all_search\" value=\"");
      out.print(EnDecoding.decoding(buySellSearchBean.getAll_search()));
      out.write("\"> \r\n");
      out.write("  \t\t\t<input type=\"hidden\" name=\"all_search_range\" value=\"");
      out.print(buySellSearchBean.getAll_search_range());
      out.write("\"> \t\t\t\t     \r\n");
      out.write("  \t\t\t\r\n");
      out.write("  \t\t\t<input type=\"hidden\" name=\"photo1\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${BuySellBean.photo_path1}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\">  \r\n");
      out.write("  \t\t\t<input type=\"hidden\" name=\"photo2\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${BuySellBean.photo_path2}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\">  \r\n");
      out.write("  \t\t\t<input type=\"hidden\" name=\"photo3\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${BuySellBean.photo_path3}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\">  \r\n");
      out.write("  \t\t\t<input type=\"hidden\" name=\"photo4\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${BuySellBean.photo_path4}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\">  \r\n");
      out.write("  \t\t\t<input type=\"hidden\" name=\"photo5\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${BuySellBean.photo_path5}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\">\r\n");
      out.write("  \t\t\t<!--로그인 체크때문-->\r\n");
      out.write("\t\t\t");
      if (_jspx_meth_c_if_0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t");
      if (_jspx_meth_c_if_1(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t<table width=\"950\"  border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\">\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t<table width=\"100%\" height=\"40\" border=\"0\" cellspacing=\"1\" cellpadding=\"0\">\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td width=\"5%\"><a href=\"Index\"><img src=\"jsp/images/new/home_icon.gif\" width=\"16\" height=\"16\" align=\"absmiddle\"/>Home</a></td>\r\n");
      out.write("\t\t\t\t\t\t<td width=\"41%\" style=\"padding-top:3px;\"> \r\n");
      out.write("\t\t\t\t\t\t\t<!-- 현재위치표시-->\r\n");
      out.write("\t\t\t\t\t\t\t");
      if (_jspx_meth_c_if_2(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t                    ");
      if (_jspx_meth_c_if_3(_jspx_page_context))
        return;
      out.write("\t\r\n");
      out.write("\t\t\t\t\t\t\t&nbsp;&gt;&nbsp;<a href=\"javascript:goDirectCategory('");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${BuySellBean.cate_code_1}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("', '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${BuySellBean.cate_code_2}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("');\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${BuySellBean.cate_name_2}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("</a>\r\n");
      out.write("\t\t\t\t\t\t\t<!--&gt;\r\n");
      out.write("\t\t\t\t\t\t\t<select name=\"topMenu\" id=\"topMenu\" onchange=\"return goDirectTopMenu();\">\r\n");
      out.write("\t\t\t\t\t\t\t\t");
      if (_jspx_meth_c_if_4(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t                    ");
      if (_jspx_meth_c_if_5(_jspx_page_context))
        return;
      out.write("\t\r\n");
      out.write("\t\t\t                    <option value=\"3\">업체찾기</option>\r\n");
      out.write("\t\t\t                    <option value=\"4\">음식점</option>\r\n");
      out.write("\t\t\t                    <option value=\"5\">호텔/민박</option>\r\n");
      out.write("\t\t\t                    <option value=\"6\">기숙사/룸메이트</option>\r\n");
      out.write("\t\t\t                    <option value=\"7\">부동산</option>\r\n");
      out.write("\t\t\t                    <option value=\"8\">구인</option>\r\n");
      out.write("\t\t\t                    <option value=\"9\">구직</option>\r\n");
      out.write("\t\t\t\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t\t\t\t");
      if (_jspx_meth_c_if_6(_jspx_page_context))
        return;
      out.write("-->\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t<td width=\"47%\" align=\"right\" style=\"padding-top:3px;\">\r\n");
      out.write("\t\t\t\t\t\t\t<!--물건사기-->\r\n");
      out.write("\t\t\t\t\t\t\t");
      if (_jspx_meth_c_if_9(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t<!--물건팔기-->\r\n");
      out.write("\t\t\t\t\t\t\t");
      //  c:if
      org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_16 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
      _jspx_th_c_if_16.setPageContext(_jspx_page_context);
      _jspx_th_c_if_16.setParent(null);
      _jspx_th_c_if_16.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${BuySellSearchBean.cate_code_1 == 'C10200'}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
      int _jspx_eval_c_if_16 = _jspx_th_c_if_16.doStartTag();
      if (_jspx_eval_c_if_16 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("\t\t\t\t\t\t\t\t<!--목록버튼 -->\r\n");
          out.write("\t\t\t\t\t\t\t\t");
          if (_jspx_meth_c_if_17(_jspx_th_c_if_16, _jspx_page_context))
            return;
          out.write("\t\r\n");
          out.write("\t\t\t\t\t\t\t\t<!--전의페이지가 통합검색의경우 -->\t\t\r\n");
          out.write("\t\t\t\t\t\t\t\t");
          if (_jspx_meth_c_if_18(_jspx_th_c_if_16, _jspx_page_context))
            return;
          out.write("\r\n");
          out.write("\t\t\t\t\t\t\t\t");
          if (_jspx_meth_c_if_19(_jspx_th_c_if_16, _jspx_page_context))
            return;
          out.write("\r\n");
          out.write("\t\t\t\t\t\t\t\t");
          if (_jspx_meth_c_if_20(_jspx_th_c_if_16, _jspx_page_context))
            return;
          out.write("\r\n");
          out.write("\t\t\t\t\t\t\t\t");
          if (_jspx_meth_c_if_21(_jspx_th_c_if_16, _jspx_page_context))
            return;
          out.write("\t\r\n");
          out.write("\t\t\t\t\t\t\t\t<!--수정 삭제버튼 로그인 ID와작성자ID가 일치할경우 -->\r\n");
          out.write("\t\t\t\t\t\t\t\t");
          //  c:if
          org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_22 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
          _jspx_th_c_if_22.setPageContext(_jspx_page_context);
          _jspx_th_c_if_22.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_16);
          _jspx_th_c_if_22.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${BuySellBean.user_id == memberInfo.userid}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
          int _jspx_eval_c_if_22 = _jspx_th_c_if_22.doStartTag();
          if (_jspx_eval_c_if_22 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n");
              out.write("\t\t\t\t\t\t\t\t\t<a href=\"javascript:openUpdate('");
              out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${BuySellBean.id}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
              out.write("');\"><img src=\"jsp/images/new/btn_edit.gif\"></a> &nbsp;\r\n");
              out.write("\t\t\t\t\t\t\t\t\t<a href=\"javascript:deleteCheck('");
              out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${BuySellBean.id}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
              out.write("');\"><img src=\"jsp/images/new/btn_delete.gif\"></a>\r\n");
              out.write("\t\t\t\t\t\t\t\t\t ");
              out.write("\r\n");
              out.write("\t\t\t\t\t\t\t\t\t");
              //  c:if
              org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_23 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
              _jspx_th_c_if_23.setPageContext(_jspx_page_context);
              _jspx_th_c_if_23.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_22);
              _jspx_th_c_if_23.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${BuySellBean.deleteflg == '0'}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
              int _jspx_eval_c_if_23 = _jspx_th_c_if_23.doStartTag();
              if (_jspx_eval_c_if_23 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                do {
                  out.write("\r\n");
                  out.write("\t\t\t\t\t\t\t\t\t\t <a href=\"javascript:deleteSignAction(");
                  out.print(buySellBean.getId());
                  out.write(", '3');\"><img src=\"jsp/images/new/close_open.gif\"></a> &nbsp;\r\n");
                  out.write("\t\t\t\t\t\t\t\t\t");
                  int evalDoAfterBody = _jspx_th_c_if_23.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
              }
              if (_jspx_th_c_if_23.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_23);
                return;
              }
              _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_23);
              out.write("\t\r\n");
              out.write("\t\t\t\t\t\t\t\t\t");
              //  c:if
              org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_24 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
              _jspx_th_c_if_24.setPageContext(_jspx_page_context);
              _jspx_th_c_if_24.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_22);
              _jspx_th_c_if_24.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${BuySellBean.deleteflg == '3'}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
              int _jspx_eval_c_if_24 = _jspx_th_c_if_24.doStartTag();
              if (_jspx_eval_c_if_24 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                do {
                  out.write("\r\n");
                  out.write("\t\t\t\t\t\t\t\t\t\t <a href=\"javascript:deleteSignAction(");
                  out.print(buySellBean.getId());
                  out.write(", '0');\"><img src=\"jsp/images/new/open.gif\"></a> &nbsp;\r\n");
                  out.write("\t\t\t\t\t\t\t\t\t");
                  int evalDoAfterBody = _jspx_th_c_if_24.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
              }
              if (_jspx_th_c_if_24.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_24);
                return;
              }
              _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_24);
              out.write("\t\r\n");
              out.write("\t\t\t\t\t\t\t\t\t");
              //  c:if
              org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_25 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
              _jspx_th_c_if_25.setPageContext(_jspx_page_context);
              _jspx_th_c_if_25.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_22);
              _jspx_th_c_if_25.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${BuySellBean.deleteflg == '2'}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
              int _jspx_eval_c_if_25 = _jspx_th_c_if_25.doStartTag();
              if (_jspx_eval_c_if_25 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                do {
                  out.write("\r\n");
                  out.write("\t\t\t\t\t\t\t\t\t\t <a href=\"javascript:deleteSignAction(");
                  out.print(buySellBean.getId());
                  out.write(", '3');\"><img src=\"jsp/images/new/close_open.gif\"></a> &nbsp;\r\n");
                  out.write("\t\t\t\t\t\t\t\t\t");
                  int evalDoAfterBody = _jspx_th_c_if_25.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
              }
              if (_jspx_th_c_if_25.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_25);
                return;
              }
              _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_25);
              out.write("\t\r\n");
              out.write("\t\t\t\t\t\t\t\t\t");
              //  c:if
              org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_26 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
              _jspx_th_c_if_26.setPageContext(_jspx_page_context);
              _jspx_th_c_if_26.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_22);
              _jspx_th_c_if_26.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${BuySellBean.deleteflg == '0'}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
              int _jspx_eval_c_if_26 = _jspx_th_c_if_26.doStartTag();
              if (_jspx_eval_c_if_26 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                do {
                  out.write("\r\n");
                  out.write("\t\t\t\t\t\t\t\t\t\t <a href=\"javascript:deleteSignAction(");
                  out.print(buySellBean.getId());
                  out.write(", '2');\"><img src=\"jsp/images/new/btn_end.gif\"></a> &nbsp;\r\n");
                  out.write("\t\t\t\t\t\t\t\t\t");
                  int evalDoAfterBody = _jspx_th_c_if_26.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
              }
              if (_jspx_th_c_if_26.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_26);
                return;
              }
              _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_26);
              out.write("\t\r\n");
              out.write("\t\t\t\t\t\t\t\t\t\t\t\r\n");
              out.write("\t\t\t\t\t\t\t\t");
              int evalDoAfterBody = _jspx_th_c_if_22.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_c_if_22.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
            _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_22);
            return;
          }
          _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_22);
          out.write("\t\r\n");
          out.write("\t\t\t\t\t\t\t");
          int evalDoAfterBody = _jspx_th_c_if_16.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_if_16.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_16);
        return;
      }
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_16);
      out.write("\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t</table>\t\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t<td height=\"1\" bgcolor=\"#d9d9d9\"></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td height=\"14\"></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t<!--물건사기-->\r\n");
      out.write("\t\t\t\t\t");
      //  c:if
      org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_27 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
      _jspx_th_c_if_27.setPageContext(_jspx_page_context);
      _jspx_th_c_if_27.setParent(null);
      _jspx_th_c_if_27.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${BuySellSearchBean.cate_code_1 == 'C10100'}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
      int _jspx_eval_c_if_27 = _jspx_th_c_if_27.doStartTag();
      if (_jspx_eval_c_if_27 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("\t\t\t\t\t<table id=\"Table_\" width=\"950\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\r\n");
          out.write("\t\t\t\t\t<tr>\r\n");
          out.write("\t\t\t\t\t\t<td height=\"67\" colspan=\"3\" align=\"center\" background=\"jsp/images/new/search_content_boxbg.gif\">\r\n");
          out.write("\t\t\t\t\t\t\t<table width=\"96%\" border=\"0\" cellspacing=\"1\" cellpadding=\"0\">\r\n");
          out.write("\t\t\t\t\t\t\t<tr>\r\n");
          out.write("\t\t\t\t\t\t\t\t<td align=\"left\">");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${util:getNewImage(BuySellBean.update_dateTime)}", java.lang.String.class, (PageContext)_jspx_page_context, _jspx_fnmap_0, false));
          out.write("\r\n");
          out.write("\t\t\t\t\t\t\t\t\t<span class=\"detail-page\">");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${BuySellBean.title}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("</span></td>\r\n");
          out.write("\t\t\t\t\t\t\t\t<td>&nbsp;</td>\r\n");
          out.write("\t\t\t\t\t\t\t\t<td align=\"right\">등록일: ");
          out.print(Util.getUpdateDateFull(buySellBean.getUpdate_dateTime()));
          out.write("</td>\r\n");
          out.write("\t\t\t\t\t\t\t</tr>\r\n");
          out.write("\t\t\t\t\t\t\t</table>\r\n");
          out.write("\t\t\t\t\t\t</td>\r\n");
          out.write("\t\t\t\t\t</tr>\r\n");
          out.write("\t\t\t\t\t<tr>\r\n");
          out.write("\t\t\t\t\t\t<td width=\"20\" background=\"jsp/images/new/search_box_left.gif\"><img src=\"jsp/images/new/search_box_left.gif\" width=\"20\" height=\"90\" alt=\"\" /></td>\r\n");
          out.write("\t\t\t\t\t\t<td width=\"910\" align=\"center\" style=\"padding-top:10px;\">\r\n");
          out.write("\t\t\t\t\t\t\t<table border=\"0\" cellspacing=\"1\" cellpadding=\"0\">\r\n");
          out.write("\t\t\t\t\t\t\t<tr>\r\n");
          out.write("\t\t\t\t\t\t\t\t<td>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t<table width=\"860\" border=\"0\" cellpadding=\"0\" cellspacing=\"1\" bgcolor=\"#d9d9d9\">\r\n");
          out.write("\t\t\t\t\t\t\t\t\t<tr>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t<td style=\"padding:8px 8px 8px 8px;\">\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t<table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"1\" bgcolor=\"#d9d9d9\">\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t<tr>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t\t<td width=\"15%\" align=\"left\" bgcolor=\"#ececec\" class=\"table-title-text\"><strong>분류<br /></strong></td>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t\t<td align=\"left\" bgcolor=\"#FFFFFF\" class=\"table-cont-text\">");
          if (_jspx_meth_c_out_4(_jspx_th_c_if_27, _jspx_page_context))
            return;
          out.write("&nbsp; </td>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t</tr>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t<tr>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t\t<td align=\"left\" bgcolor=\"#ececec\" class=\"table-title-text\"><strong>제품상태<br /></strong></td>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t\t<td align=\"left\" bgcolor=\"#FFFFFF\" class=\"table-cont-text\">\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<!--중고품-->\r\n");
          out.write("\t\t\t\t\t\t\t\t\t            \t");
          if (_jspx_meth_c_if_28(_jspx_th_c_if_27, _jspx_page_context))
            return;
          out.write("\r\n");
          out.write("\t\t\t\t\t\t\t\t\t            \t<!--신제품-->\r\n");
          out.write("\t\t\t\t\t\t\t\t\t            \t");
          if (_jspx_meth_c_if_29(_jspx_th_c_if_27, _jspx_page_context))
            return;
          out.write("&nbsp;\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t\t</td>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t</tr>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t<tr>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t\t<td align=\"left\" bgcolor=\"#ececec\" class=\"table-title-text\"><strong>희망거래가격<br /></strong></td>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t\t<td align=\"left\" bgcolor=\"#FFFFFF\" class=\"table-cont-text\">\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<!--무료-->\r\n");
          out.write("\t\t\t\t\t\t\t\t\t            \t");
          if (_jspx_meth_c_if_30(_jspx_th_c_if_27, _jspx_page_context))
            return;
          out.write("\r\n");
          out.write("\t\t\t\t\t\t\t\t\t            \t");
          if (_jspx_meth_c_if_31(_jspx_th_c_if_27, _jspx_page_context))
            return;
          out.write("&nbsp;\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t\t</td>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t</tr>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t<tr>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t\t<td align=\"left\" bgcolor=\"#ececec\" class=\"table-title-text\"><strong>배송방식<br /></strong></td>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t\t<td align=\"left\" bgcolor=\"#FFFFFF\" class=\"table-cont-text\">\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<!--직거래/택배-->\r\n");
          out.write("\t\t\t\t\t\t\t\t\t            \t");
          if (_jspx_meth_c_if_32(_jspx_th_c_if_27, _jspx_page_context))
            return;
          out.write("\r\n");
          out.write("\t\t\t\t\t\t\t\t\t            \t<!--직거래-->\r\n");
          out.write("\t\t\t\t\t\t\t\t\t            \t");
          if (_jspx_meth_c_if_33(_jspx_th_c_if_27, _jspx_page_context))
            return;
          out.write("\r\n");
          out.write("\t\t\t\t\t\t\t\t\t            \t<!--택배-->\r\n");
          out.write("\t\t\t\t\t\t\t\t\t            \t");
          if (_jspx_meth_c_if_34(_jspx_th_c_if_27, _jspx_page_context))
            return;
          out.write("&nbsp;\r\n");
          out.write("\t\t\t\t\t\t\t\t\t            </td>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t</tr>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t<tr>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t\t<td align=\"left\" bgcolor=\"#ececec\" class=\"table-title-text\"><strong>희망거래장소 <br /></strong></td>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t\t<td align=\"left\" bgcolor=\"#FFFFFF\" class=\"table-cont-text\">\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t");
          if (_jspx_meth_c_out_6(_jspx_th_c_if_27, _jspx_page_context))
            return;
          out.write("&nbsp;<br />\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t\t</td>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t</tr>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t<tr>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t\t<td align=\"left\" bgcolor=\"#ececec\" class=\"table-title-text\"><strong>이메일 <br /></strong></td>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t\t<td align=\"left\" bgcolor=\"#FFFFFF\" class=\"table-cont-text\">\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<a href=\"\" onclick=\"mailOpenDetail('");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${BuySellBean.id}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write('\'');
          out.write(',');
          out.write('\'');
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${BuySellBean.user_name}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("'); return false;\">메일보내기</a>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t\t</td>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t</tr>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t<tr>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t\t<td align=\"left\" bgcolor=\"#ececec\" class=\"table-title-text\"><strong>전화번호1</strong></td>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t\t<td align=\"left\" bgcolor=\"#FFFFFF\" class=\"table-cont-text\">\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t");
          if (_jspx_meth_c_out_7(_jspx_th_c_if_27, _jspx_page_context))
            return;
          out.write("&nbsp;<br />\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t\t</td>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t</tr>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t<tr>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t\t<td align=\"left\" bgcolor=\"#ececec\" class=\"table-title-text\"><strong> 전화번호2 <br /></strong></td>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t\t<td align=\"left\" bgcolor=\"#FFFFFF\" class=\"table-cont-text\">\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t");
          if (_jspx_meth_c_out_8(_jspx_th_c_if_27, _jspx_page_context))
            return;
          out.write("&nbsp;\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t\t</td>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t</tr>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t<tr>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t\t<td align=\"left\" bgcolor=\"#ececec\" class=\"table-title-text\"><strong>등록자 <br /></strong></td>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t\t<td align=\"left\" bgcolor=\"#FFFFFF\" class=\"table-cont-text\">\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t ");
          if (_jspx_meth_c_out_9(_jspx_th_c_if_27, _jspx_page_context))
            return;
          out.write("&nbsp;\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t\t</td>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t</tr>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t<tr>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t\t<td align=\"left\" bgcolor=\"#ececec\" class=\"table-title-text\"><strong>등록일 <br /></strong></td>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t\t<td align=\"left\" bgcolor=\"#FFFFFF\" class=\"table-cont-text\">\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t");
          out.print(Util.getUpdateDateFull(buySellBean.getUpdate_dateTime()));
          out.write("&nbsp;\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t\t</td>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t</tr>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t<tr>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t\t<td align=\"left\" bgcolor=\"#ececec\" class=\"table-title-text\"><strong>조회수<br /></strong></td>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t\t<td align=\"left\" bgcolor=\"#FFFFFF\" class=\"table-cont-text\">\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t");
          if (_jspx_meth_c_out_10(_jspx_th_c_if_27, _jspx_page_context))
            return;
          out.write("&nbsp;\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t\t</td>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t</tr>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t</table>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t</td>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t</tr>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t</table>\r\n");
          out.write("\t\t\t\t\t\t\t\t</td>\r\n");
          out.write("\t\t\t\t\t\t\t</tr>\r\n");
          out.write("\t\t\t\t\t\t\t<tr>\r\n");
          out.write("\t\t\t\t\t\t\t\t<td height=\"30\" colspan=\"3\" valign=\"top\">&nbsp;</td>\r\n");
          out.write("\t\t\t\t\t\t\t</tr>\r\n");
          out.write("\t\t\t\t\t\t\t<tr>\r\n");
          out.write("\t\t\t\t\t\t\t\t<td colspan=\"3\" align=\"left\" >\r\n");
          out.write("\t\t\t\t\t\t\t\t\t<table width=\"40%\" border=\"0\" cellspacing=\"1\" cellpadding=\"0\">\r\n");
          out.write("\t\t\t\t\t\t\t\t\t<tr>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t<td width=\"3%\"><img src=\"jsp/images/new/search_conttit_icon.gif\" width=\"7\" height=\"14\" /></td>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t<td width=\"97%\" class=\"large-text-w\" style=\"padding-top:2px;\"><strong>상세정보</strong></td>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t</tr>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t</table>\r\n");
          out.write("\t\t\t\t\t\t\t\t</td>\r\n");
          out.write("\t\t\t\t\t\t\t</tr>\r\n");
          out.write("\t\t\t\t\t\t\t<tr>\r\n");
          out.write("\t\t\t\t\t\t\t\t<td height=\"2\" colspan=\"3\" align=\"left\" valign=\"top\" bgcolor=\"#d9d9d9\"></td>\r\n");
          out.write("\t\t\t\t\t\t\t</tr>\r\n");
          out.write("\t\t\t\t\t\t\t<tr>\r\n");
          out.write("\t\t\t\t\t\t\t\t<td colspan=\"3\" align=\"left\" valign=\"top\">");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${BuySellBean.detail_info}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("&nbsp;</td>\r\n");
          out.write("\t\t\t\t\t\t\t</tr>\r\n");
          out.write("\t\t\t\t\t\t\t<tr>\r\n");
          out.write("\t\t\t\t\t\t\t\t<td colspan=\"3\" align=\"left\" valign=\"top\">&nbsp;</td>\r\n");
          out.write("\t\t\t\t\t\t\t</tr>\r\n");
          out.write("\t\t\t\t\t\t\t</table>\r\n");
          out.write("\t\t\t\t\t\t</td>\r\n");
          out.write("\t\t\t\t\t\t<td width=\"20\" background=\"jsp/images/new/search_box_right.gif\"><img src=\"jsp/images/new/search_box_right.gif\" width=\"20\" height=\"90\" alt=\"\" /></td>\r\n");
          out.write("\t\t\t\t\t</tr>\r\n");
          out.write("\t\t\t\t\t<tr>\r\n");
          out.write("\t\t\t\t\t\t<td colspan=\"3\"><img src=\"jsp/images/new/search_box_under.gif\" width=\"950\" height=\"17\" alt=\"\" /></td>\r\n");
          out.write("\t\t\t\t\t</tr>\r\n");
          out.write("\t\t\t\t\t</table>\r\n");
          out.write("\t\t\t\t\t");
          int evalDoAfterBody = _jspx_th_c_if_27.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_if_27.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_27);
        return;
      }
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_27);
      out.write("\r\n");
      out.write("\t\t\t\t\t<!--물건팔기-->\r\n");
      out.write("\t\t\t\t\t");
      //  c:if
      org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_35 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
      _jspx_th_c_if_35.setPageContext(_jspx_page_context);
      _jspx_th_c_if_35.setParent(null);
      _jspx_th_c_if_35.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${BuySellSearchBean.cate_code_1 == 'C10200'}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
      int _jspx_eval_c_if_35 = _jspx_th_c_if_35.doStartTag();
      if (_jspx_eval_c_if_35 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("\t\t\t\t\t<table id=\"Table_\" width=\"950\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\r\n");
          out.write("\t\t\t\t\t<tr>\r\n");
          out.write("\t\t\t\t\t\t<td height=\"67\" colspan=\"3\" align=\"center\" background=\"jsp/images/new/search_content_boxbg.gif\">\r\n");
          out.write("\t\t\t\t\t\t\t<table width=\"96%\" border=\"0\" cellspacing=\"1\" cellpadding=\"0\">\r\n");
          out.write("\t\t\t\t\t\t\t<tr>\r\n");
          out.write("\t\t\t\t\t\t\t\t<td align=\"left\">");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${util:getNewImage(BuySellBean.update_dateTime)}", java.lang.String.class, (PageContext)_jspx_page_context, _jspx_fnmap_0, false));
          out.write("\r\n");
          out.write("\t\t\t\t\t\t\t\t\t<span class=\"detail-page\">");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${BuySellBean.title}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("</span></td>\r\n");
          out.write("\t\t\t\t\t\t\t\t<td>&nbsp;</td>\r\n");
          out.write("\t\t\t\t\t\t\t\t<td align=\"right\">등록일: ");
          out.print(Util.getUpdateDateFull(buySellBean.getUpdate_dateTime()));
          out.write("</td>\r\n");
          out.write("\t\t\t\t\t\t\t</tr>\r\n");
          out.write("\t\t\t\t\t\t\t</table>\r\n");
          out.write("\t\t\t\t\t\t</td>\r\n");
          out.write("\t\t\t\t\t</tr>\r\n");
          out.write("\t\t\t\t\t<tr>\r\n");
          out.write("\t\t\t\t\t\t<td width=\"20\" background=\"jsp/images/new/search_box_left.gif\"><img src=\"jsp/images/new/search_box_left.gif\" width=\"20\" height=\"90\" /></td>\r\n");
          out.write("\t\t\t\t\t\t<td width=\"910\" align=\"center\" style=\"padding-top:10px;\">\r\n");
          out.write("\t\t\t\t\t\t\t<table border=\"0\" cellspacing=\"1\" cellpadding=\"0\">\r\n");
          out.write("\t\t\t\t\t\t\t<tr>\r\n");
          out.write("\t\t\t\t\t\t\t\t<td valign=\"top\">\r\n");
          out.write("\t\t\t\t\t\t\t\t\t<table width=\"482\" border=\"0\" cellspacing=\"1\" cellpadding=\"0\">\r\n");
          out.write("\t\t\t\t\t\t\t\t\t<tr>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t<td colspan=\"2\" height=\"366\" align=\"center\">\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t<img src=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${BuySellBean.photo_path1}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("\" id=\"disp\"/>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t</td>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t</tr>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t<tr>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t<td height=\"6\" colspan=\"2\"></td>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t</tr>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t<tr>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t<td width=\"392\" align=\"right\">\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t<img src=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${BuySellBean.photo_path1}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("\" width=\"60\" height=\"60\" style=\"border:1px  solid #CCCCCC;\" onMouseover=\"setImage('");
          out.print(buySellBean.getPhoto_path1());
          out.write("')\"/>&nbsp;\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t<img src=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${BuySellBean.photo_path2}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("\" width=\"60\" height=\"60\" style=\"border:1px  solid #CCCCCC;\" onMouseover=\"setImage('");
          out.print(buySellBean.getPhoto_path2());
          out.write("')\"/>&nbsp;\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t<img src=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${BuySellBean.photo_path3}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("\" width=\"60\" height=\"60\" style=\"border:1px  solid #CCCCCC;\" onMouseover=\"setImage('");
          out.print(buySellBean.getPhoto_path3());
          out.write("')\"/>&nbsp;\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t<img src=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${BuySellBean.photo_path4}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("\" width=\"60\" height=\"60\" style=\"border:1px  solid #CCCCCC;\" onMouseover=\"setImage('");
          out.print(buySellBean.getPhoto_path4());
          out.write("')\"/>&nbsp;\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t<img src=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${BuySellBean.photo_path5}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("\" width=\"60\" height=\"60\" style=\"border:1px  solid #CCCCCC;\" onMouseover=\"setImage('");
          out.print(buySellBean.getPhoto_path5());
          out.write("')\"/>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t</td>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t<td width=\"89\" align=\"right\" valign=\"top\">\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t<!--크게보기-->\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t<a href=\"javascript:popup();\"><img src=\"jsp/images/new/large_b.gif\" width=\"61\" height=\"16\" /></a></td>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t</tr>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t</table>\r\n");
          out.write("\t\t\t\t\t\t\t\t</td>\r\n");
          out.write("\t\t\t\t\t\t\t\t<td width=\"10\">&nbsp;</td>\r\n");
          out.write("\t\t\t\t\t\t\t\t<td>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t<table width=\"400\" border=\"0\" cellpadding=\"0\" cellspacing=\"1\" bgcolor=\"#d9d9d9\">\r\n");
          out.write("\t\t\t\t\t\t\t\t\t<tr>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t<td style=\"padding:8px 8px 8px 8px;\">\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t<table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"1\" bgcolor=\"#d9d9d9\">\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t<tr>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t\t<td width=\"30%\" align=\"left\" bgcolor=\"#ececec\" class=\"table-title-text\"><strong>분류</strong></td>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t\t<td align=\"left\" bgcolor=\"#FFFFFF\" class=\"table-cont-text\">");
          if (_jspx_meth_c_out_11(_jspx_th_c_if_35, _jspx_page_context))
            return;
          out.write(" </td>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t</tr>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t<tr>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t\t<td align=\"left\" bgcolor=\"#ececec\" class=\"table-title-text\"><strong> 제품상태 </strong></td>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t\t<td align=\"left\" bgcolor=\"#FFFFFF\" class=\"table-cont-text\">\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<!--중고품-->\r\n");
          out.write("\t\t\t\t\t\t\t\t\t            \t");
          if (_jspx_meth_c_if_36(_jspx_th_c_if_35, _jspx_page_context))
            return;
          out.write("\r\n");
          out.write("\t\t\t\t\t\t\t\t\t            \t<!--신제품-->\r\n");
          out.write("\t\t\t\t\t\t\t\t\t            \t");
          if (_jspx_meth_c_if_37(_jspx_th_c_if_35, _jspx_page_context))
            return;
          out.write("&nbsp;\r\n");
          out.write("\t\t\t\t\t\t\t\t\t            </td>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t</tr>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t<tr>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t\t<td align=\"left\" bgcolor=\"#ececec\" class=\"table-title-text\"><strong> 판매자구분<br /></strong></td>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t\t<td align=\"left\" bgcolor=\"#FFFFFF\" class=\"table-cont-text\">\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<!--개인회원-->\r\n");
          out.write("\t\t\t\t\t\t\t\t\t            \t");
          if (_jspx_meth_c_if_38(_jspx_th_c_if_35, _jspx_page_context))
            return;
          out.write("\r\n");
          out.write("\t\t\t\t\t\t\t\t\t            \t<!--업자회원-->\r\n");
          out.write("\t\t\t\t\t\t\t\t\t            \t");
          if (_jspx_meth_c_if_39(_jspx_th_c_if_35, _jspx_page_context))
            return;
          out.write("\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t\t</td>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t</tr>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t<tr>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t\t<td align=\"left\" bgcolor=\"#ececec\" class=\"table-title-text\"><strong>가격 <br /></strong></td>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t\t<td align=\"left\" bgcolor=\"#FFFFFF\" class=\"table-cont-text\">\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<!--무료-->\r\n");
          out.write("\t\t\t\t\t\t\t\t\t            \t");
          if (_jspx_meth_c_if_40(_jspx_th_c_if_35, _jspx_page_context))
            return;
          out.write("\r\n");
          out.write("\t\t\t\t\t\t\t\t\t            \t");
          if (_jspx_meth_c_if_41(_jspx_th_c_if_35, _jspx_page_context))
            return;
          out.write("&nbsp;\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t\t</td>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t</tr>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t<tr>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t\t<td align=\"left\" bgcolor=\"#ececec\" class=\"table-title-text\"><strong>배송방식 <br /></strong></td>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t\t<td align=\"left\" bgcolor=\"#FFFFFF\" class=\"table-cont-text\">\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<!--직거래/택배-->\r\n");
          out.write("\t\t\t\t\t\t\t\t\t            \t");
          if (_jspx_meth_c_if_44(_jspx_th_c_if_35, _jspx_page_context))
            return;
          out.write("\r\n");
          out.write("\t\t\t\t\t\t\t\t\t            \t<!--직거래-->\r\n");
          out.write("\t\t\t\t\t\t\t\t\t            \t");
          if (_jspx_meth_c_if_45(_jspx_th_c_if_35, _jspx_page_context))
            return;
          out.write("\r\n");
          out.write("\t\t\t\t\t\t\t\t\t            \t<!--택배-->\r\n");
          out.write("\t\t\t\t\t\t\t\t\t            \t");
          if (_jspx_meth_c_if_46(_jspx_th_c_if_35, _jspx_page_context))
            return;
          out.write("<br />\r\n");
          out.write("\t\t\t\t\t\t\t\t\t            </td>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t</tr>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t<tr>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t\t<td align=\"left\" bgcolor=\"#ececec\" class=\"table-title-text\"><strong>희망거래장소 <br /></strong></td>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t\t<td align=\"left\" bgcolor=\"#FFFFFF\" class=\"table-cont-text\">\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t");
          if (_jspx_meth_c_out_15(_jspx_th_c_if_35, _jspx_page_context))
            return;
          out.write("<br />\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t\t</td>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t</tr>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t<tr>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t\t<td align=\"left\" bgcolor=\"#ececec\" class=\"table-title-text\"><strong>이메일</strong></td>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t\t<td align=\"left\" bgcolor=\"#FFFFFF\" class=\"table-cont-text\">\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<a href=\"\" onclick=\"mailOpenDetail('");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${BuySellBean.id}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write('\'');
          out.write(',');
          out.write('\'');
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${BuySellBean.user_name}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("'); return false;\">메일보내기</a>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t\t</td>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t</tr>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t<tr>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t\t<td align=\"left\" bgcolor=\"#ececec\" class=\"table-title-text\"><strong> 전화번호1 <br /></strong></td>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t\t<td align=\"left\" bgcolor=\"#FFFFFF\" class=\"table-cont-text\">\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t");
          if (_jspx_meth_c_out_16(_jspx_th_c_if_35, _jspx_page_context))
            return;
          out.write("&nbsp;\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t\t</td>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t</tr>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t<tr>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t\t<td align=\"left\" bgcolor=\"#ececec\" class=\"table-title-text\"><strong>전화번호2 <br /></strong></td>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t\t<td align=\"left\" bgcolor=\"#FFFFFF\" class=\"table-cont-text\">\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t");
          if (_jspx_meth_c_out_17(_jspx_th_c_if_35, _jspx_page_context))
            return;
          out.write("\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t\t</td>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t</tr>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t<tr>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t\t<td align=\"left\" bgcolor=\"#ececec\" class=\"table-title-text\"><strong>등록자 <br /></strong></td>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t\t<td align=\"left\" bgcolor=\"#FFFFFF\" class=\"table-cont-text\">\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t");
          if (_jspx_meth_c_out_18(_jspx_th_c_if_35, _jspx_page_context))
            return;
          out.write("&nbsp;\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t\t</td>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t</tr>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t<tr>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t\t<td align=\"left\" bgcolor=\"#ececec\" class=\"table-title-text\"><strong>등록일<br /></strong></td>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t\t<td align=\"left\" bgcolor=\"#FFFFFF\" class=\"table-cont-text\">\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t");
          out.print(Util.getUpdateDateFull(buySellBean.getUpdate_dateTime()));
          out.write("&nbsp;\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t\t</td>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t</tr>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t<tr>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t\t<td align=\"left\" bgcolor=\"#ececec\" class=\"table-title-text\"><strong>조회수<br /></strong></td>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t\t<td align=\"left\" bgcolor=\"#FFFFFF\" class=\"table-cont-text\">\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t");
          if (_jspx_meth_c_out_19(_jspx_th_c_if_35, _jspx_page_context))
            return;
          out.write("&nbsp;\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t\t</td>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t</tr>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t</table>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t</td>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t</tr>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t</table>\r\n");
          out.write("\t\t\t\t\t\t\t\t</td>\r\n");
          out.write("\t\t\t\t\t\t\t</tr>\r\n");
          out.write("\t\t\t\t\t\t\t<tr>\r\n");
          out.write("\t\t\t\t\t\t\t\t<td height=\"30\" colspan=\"3\" valign=\"top\">&nbsp;</td>\r\n");
          out.write("\t\t\t\t\t\t\t</tr>\r\n");
          out.write("\t\t\t\t\t\t\t<tr>\r\n");
          out.write("\t\t\t\t\t\t\t\t<td colspan=\"3\" align=\"left\" >\r\n");
          out.write("\t\t\t\t\t\t\t\t\t<table width=\"40%\" border=\"0\" cellspacing=\"1\" cellpadding=\"0\">\r\n");
          out.write("\t\t\t\t\t\t\t\t\t<tr>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t<td width=\"3%\"><img src=\"jsp/images/new/search_conttit_icon.gif\" width=\"7\" height=\"14\" /></td>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t<td width=\"97%\" class=\"large-text-w\" style=\"padding-top:2px;\"><strong>상세정보</strong></td>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t</tr>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t</table>\r\n");
          out.write("\t\t\t\t\t\t\t\t</td>\r\n");
          out.write("\t\t\t\t\t\t\t</tr>\r\n");
          out.write("\t\t\t\t\t\t\t<tr>\r\n");
          out.write("\t\t\t\t\t\t\t\t<td height=\"2\" colspan=\"3\" align=\"left\" valign=\"top\" bgcolor=\"#d9d9d9\"></td>\r\n");
          out.write("\t\t\t\t\t\t\t</tr>\r\n");
          out.write("\t\t\t\t\t\t\t<tr>\r\n");
          out.write("\t\t\t\t\t\t\t\t<td colspan=\"3\" align=\"left\" valign=\"top\">&nbsp;</td>\r\n");
          out.write("\t\t\t\t\t\t\t</tr>\r\n");
          out.write("\t\t\t\t\t\t\t<tr>\r\n");
          out.write("\t\t\t\t\t\t\t\t<td colspan=\"3\" align=\"left\" valign=\"top\">");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${BuySellBean.detail_info}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("&nbsp;</td>\r\n");
          out.write("\t\t\t\t\t\t\t</tr>\r\n");
          out.write("\t\t\t\t\t\t\t<tr>\r\n");
          out.write("\t\t\t\t\t\t\t\t<td colspan=\"3\" align=\"left\" valign=\"top\">&nbsp;</td>\r\n");
          out.write("\t\t\t\t\t\t\t</tr>\r\n");
          out.write("\t\t\t\t\t\t\t</table>\r\n");
          out.write("\t\t\t\t\t\t</td>\r\n");
          out.write("\t\t\t\t\t\t<td width=\"20\" background=\"jsp/images/new/search_box_right.gif\"><img src=\"jsp/images/new/search_box_right.gif\" width=\"20\" height=\"90\" alt=\"\" /></td>\r\n");
          out.write("\t\t\t\t\t</tr>\r\n");
          out.write("\t\t\t\t\t<tr>\r\n");
          out.write("\t\t\t\t\t\t<td colspan=\"3\"><img src=\"jsp/images/new/search_box_under.gif\" width=\"950\" height=\"17\" alt=\"\" /></td>\r\n");
          out.write("\t\t\t\t\t</tr>\r\n");
          out.write("\t\t\t\t\t</table>\r\n");
          out.write("\t\t\t\t\t");
          int evalDoAfterBody = _jspx_th_c_if_35.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_if_35.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_35);
        return;
      }
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_35);
      out.write("\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td height=\"40\" align=\"right\">\r\n");
      out.write("\t\t\t\t\t<!--물건사기-->\r\n");
      out.write("\t\t\t\t\t");
      if (_jspx_meth_c_if_47(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t\t\t<!--물건팔기-->\r\n");
      out.write("\t\t\t\t\t");
      //  c:if
      org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_54 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
      _jspx_th_c_if_54.setPageContext(_jspx_page_context);
      _jspx_th_c_if_54.setParent(null);
      _jspx_th_c_if_54.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${BuySellSearchBean.cate_code_1 == 'C10200'}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
      int _jspx_eval_c_if_54 = _jspx_th_c_if_54.doStartTag();
      if (_jspx_eval_c_if_54 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("\t\t\t\t\t\t<!--목록버튼 -->\r\n");
          out.write("\t\t\t\t\t\t");
          if (_jspx_meth_c_if_55(_jspx_th_c_if_54, _jspx_page_context))
            return;
          out.write("\t\r\n");
          out.write("\t\t\t\t\t\t");
          if (_jspx_meth_c_if_56(_jspx_th_c_if_54, _jspx_page_context))
            return;
          out.write("\r\n");
          out.write("\t\t\t\t\t\t");
          if (_jspx_meth_c_if_57(_jspx_th_c_if_54, _jspx_page_context))
            return;
          out.write("\r\n");
          out.write("\t\t\t\t\t\t");
          if (_jspx_meth_c_if_58(_jspx_th_c_if_54, _jspx_page_context))
            return;
          out.write("\r\n");
          out.write("\t\t\t\t\t\t");
          if (_jspx_meth_c_if_59(_jspx_th_c_if_54, _jspx_page_context))
            return;
          out.write("\t\t\t\t\t\t\t\r\n");
          out.write("\t\t\t\t\t\t<!--수정 삭제버튼 로그인 ID와작성자ID가 일치할경우 -->\r\n");
          out.write("\t\t\t\t\t\t");
          //  c:if
          org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_60 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
          _jspx_th_c_if_60.setPageContext(_jspx_page_context);
          _jspx_th_c_if_60.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_54);
          _jspx_th_c_if_60.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${BuySellBean.user_id == memberInfo.userid}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
          int _jspx_eval_c_if_60 = _jspx_th_c_if_60.doStartTag();
          if (_jspx_eval_c_if_60 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n");
              out.write("\t\t\t\t\t\t\t<a href=\"javascript:openUpdate('");
              out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${BuySellBean.id}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
              out.write("');\"><img src=\"jsp/images/new/btn_edit.gif\"></a> &nbsp;\r\n");
              out.write("\t\t\t\t\t\t\t<a href=\"javascript:deleteCheck('");
              out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${BuySellBean.id}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
              out.write(",wf');\"><img src=\"jsp/images/new/btn_delete.gif\"></a>\r\n");
              out.write("\t\t\t\t\t\t\t ");
              out.write("\r\n");
              out.write("\t\t\t\t\t\t\t");
              //  c:if
              org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_61 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
              _jspx_th_c_if_61.setPageContext(_jspx_page_context);
              _jspx_th_c_if_61.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_60);
              _jspx_th_c_if_61.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${BuySellBean.deleteflg == '0'}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
              int _jspx_eval_c_if_61 = _jspx_th_c_if_61.doStartTag();
              if (_jspx_eval_c_if_61 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                do {
                  out.write("\r\n");
                  out.write("\t\t\t\t\t\t\t\t <a href=\"javascript:deleteSignAction(");
                  out.print(buySellBean.getId());
                  out.write(", '3');\"><img src=\"jsp/images/new/close_open.gif\"></a> &nbsp;\r\n");
                  out.write("\t\t\t\t\t\t\t");
                  int evalDoAfterBody = _jspx_th_c_if_61.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
              }
              if (_jspx_th_c_if_61.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_61);
                return;
              }
              _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_61);
              out.write("\t\r\n");
              out.write("\t\t\t\t\t\t\t");
              //  c:if
              org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_62 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
              _jspx_th_c_if_62.setPageContext(_jspx_page_context);
              _jspx_th_c_if_62.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_60);
              _jspx_th_c_if_62.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${BuySellBean.deleteflg == '3'}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
              int _jspx_eval_c_if_62 = _jspx_th_c_if_62.doStartTag();
              if (_jspx_eval_c_if_62 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                do {
                  out.write("\r\n");
                  out.write("\t\t\t\t\t\t\t\t <a href=\"javascript:deleteSignAction(");
                  out.print(buySellBean.getId());
                  out.write(", '0');\"><img src=\"jsp/images/new/open.gif\"></a> &nbsp;\r\n");
                  out.write("\t\t\t\t\t\t\t");
                  int evalDoAfterBody = _jspx_th_c_if_62.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
              }
              if (_jspx_th_c_if_62.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_62);
                return;
              }
              _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_62);
              out.write("\t\r\n");
              out.write("\t\t\t\t\t\t\t");
              //  c:if
              org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_63 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
              _jspx_th_c_if_63.setPageContext(_jspx_page_context);
              _jspx_th_c_if_63.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_60);
              _jspx_th_c_if_63.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${BuySellBean.deleteflg == '2'}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
              int _jspx_eval_c_if_63 = _jspx_th_c_if_63.doStartTag();
              if (_jspx_eval_c_if_63 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                do {
                  out.write("\r\n");
                  out.write("\t\t\t\t\t\t\t\t <a href=\"javascript:deleteSignAction(");
                  out.print(buySellBean.getId());
                  out.write(", '3');\"><img src=\"jsp/images/new/close_open.gif\"></a> &nbsp;\r\n");
                  out.write("\t\t\t\t\t\t\t");
                  int evalDoAfterBody = _jspx_th_c_if_63.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
              }
              if (_jspx_th_c_if_63.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_63);
                return;
              }
              _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_63);
              out.write("\t\r\n");
              out.write("\t\t\t\t\t\t\t");
              //  c:if
              org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_64 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
              _jspx_th_c_if_64.setPageContext(_jspx_page_context);
              _jspx_th_c_if_64.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_60);
              _jspx_th_c_if_64.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${BuySellBean.deleteflg == '0'}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
              int _jspx_eval_c_if_64 = _jspx_th_c_if_64.doStartTag();
              if (_jspx_eval_c_if_64 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                do {
                  out.write("\r\n");
                  out.write("\t\t\t\t\t\t\t\t <a href=\"javascript:deleteSignAction(");
                  out.print(buySellBean.getId());
                  out.write(", '2');\"><img src=\"jsp/images/new/btn_end.gif\"></a> &nbsp;\r\n");
                  out.write("\t\t\t\t\t\t\t");
                  int evalDoAfterBody = _jspx_th_c_if_64.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
              }
              if (_jspx_th_c_if_64.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_64);
                return;
              }
              _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_64);
              out.write("\t\r\n");
              out.write("\t\t\t\t\t\t");
              int evalDoAfterBody = _jspx_th_c_if_60.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_c_if_60.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
            _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_60);
            return;
          }
          _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_60);
          out.write("\t\r\n");
          out.write("\t\t\t\t\t");
          int evalDoAfterBody = _jspx_th_c_if_54.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_if_54.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_54);
        return;
      }
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_54);
      out.write("\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t</table>\r\n");
      out.write("\t\t\t</form>\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("  \t<tr>\r\n");
      out.write("    \t<td height=\"50\">&nbsp;</td>\r\n");
      out.write("  \t</tr>\r\n");
      out.write("\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "../include/footer.jsp", out, true);
      out.write("\r\n");
      out.write("\t</table>\r\n");
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

  private boolean _jspx_meth_fmt_setLocale_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  fmt:setLocale
    org.apache.taglibs.standard.tag.rt.fmt.SetLocaleTag _jspx_th_fmt_setLocale_0 = (org.apache.taglibs.standard.tag.rt.fmt.SetLocaleTag) _jspx_tagPool_fmt_setLocale_value_nobody.get(org.apache.taglibs.standard.tag.rt.fmt.SetLocaleTag.class);
    _jspx_th_fmt_setLocale_0.setPageContext(_jspx_page_context);
    _jspx_th_fmt_setLocale_0.setParent(null);
    _jspx_th_fmt_setLocale_0.setValue(new String("KO"));
    int _jspx_eval_fmt_setLocale_0 = _jspx_th_fmt_setLocale_0.doStartTag();
    if (_jspx_th_fmt_setLocale_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_fmt_setLocale_value_nobody.reuse(_jspx_th_fmt_setLocale_0);
      return true;
    }
    _jspx_tagPool_fmt_setLocale_value_nobody.reuse(_jspx_th_fmt_setLocale_0);
    return false;
  }

  private boolean _jspx_meth_fmt_setBundle_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  fmt:setBundle
    org.apache.taglibs.standard.tag.rt.fmt.SetBundleTag _jspx_th_fmt_setBundle_0 = (org.apache.taglibs.standard.tag.rt.fmt.SetBundleTag) _jspx_tagPool_fmt_setBundle_var_basename_nobody.get(org.apache.taglibs.standard.tag.rt.fmt.SetBundleTag.class);
    _jspx_th_fmt_setBundle_0.setPageContext(_jspx_page_context);
    _jspx_th_fmt_setBundle_0.setParent(null);
    _jspx_th_fmt_setBundle_0.setBasename("msg");
    _jspx_th_fmt_setBundle_0.setVar("message");
    int _jspx_eval_fmt_setBundle_0 = _jspx_th_fmt_setBundle_0.doStartTag();
    if (_jspx_th_fmt_setBundle_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_fmt_setBundle_var_basename_nobody.reuse(_jspx_th_fmt_setBundle_0);
      return true;
    }
    _jspx_tagPool_fmt_setBundle_var_basename_nobody.reuse(_jspx_th_fmt_setBundle_0);
    return false;
  }

  private boolean _jspx_meth_fmt_message_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  fmt:message
    org.apache.taglibs.standard.tag.rt.fmt.MessageTag _jspx_th_fmt_message_0 = (org.apache.taglibs.standard.tag.rt.fmt.MessageTag) _jspx_tagPool_fmt_message_key_bundle_nobody.get(org.apache.taglibs.standard.tag.rt.fmt.MessageTag.class);
    _jspx_th_fmt_message_0.setPageContext(_jspx_page_context);
    _jspx_th_fmt_message_0.setParent(null);
    _jspx_th_fmt_message_0.setKey("TITLE.title");
    _jspx_th_fmt_message_0.setBundle((javax.servlet.jsp.jstl.fmt.LocalizationContext) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${message}", javax.servlet.jsp.jstl.fmt.LocalizationContext.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_fmt_message_0 = _jspx_th_fmt_message_0.doStartTag();
    if (_jspx_th_fmt_message_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_fmt_message_key_bundle_nobody.reuse(_jspx_th_fmt_message_0);
      return true;
    }
    _jspx_tagPool_fmt_message_key_bundle_nobody.reuse(_jspx_th_fmt_message_0);
    return false;
  }

  private boolean _jspx_meth_c_if_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_0.setPageContext(_jspx_page_context);
    _jspx_th_c_if_0.setParent(null);
    _jspx_th_c_if_0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${!empty memberInfo}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_if_0 = _jspx_th_c_if_0.doStartTag();
    if (_jspx_eval_c_if_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t<input type=\"hidden\" id=\"loginSign\" value=\"true\">\r\n");
        out.write("\t\t\t");
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

  private boolean _jspx_meth_c_if_1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_1 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_1.setPageContext(_jspx_page_context);
    _jspx_th_c_if_1.setParent(null);
    _jspx_th_c_if_1.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${empty memberInfo}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_if_1 = _jspx_th_c_if_1.doStartTag();
    if (_jspx_eval_c_if_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t<input type=\"hidden\" id=\"loginSign\" value=\"false\">\r\n");
        out.write("\t\t\t");
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
    _jspx_th_c_if_2.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${BuySellSearchBean.cate_code_1 == 'C10100'}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_if_2 = _jspx_th_c_if_2.doStartTag();
    if (_jspx_eval_c_if_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t                    &nbsp;&gt;&nbsp;<a href=\"javascript:goDirectTopMenu('1');\">물건사기</a>\r\n");
        out.write("\t\t                    ");
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
    _jspx_th_c_if_3.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${BuySellSearchBean.cate_code_1 == 'C10200'}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_if_3 = _jspx_th_c_if_3.doStartTag();
    if (_jspx_eval_c_if_3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t                    \t&nbsp;&gt;&nbsp;<a href=\"javascript:goDirectTopMenu('2');\">물건팔기</a>\r\n");
        out.write("\t\t                    ");
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

  private boolean _jspx_meth_c_if_4(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_4 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_4.setPageContext(_jspx_page_context);
    _jspx_th_c_if_4.setParent(null);
    _jspx_th_c_if_4.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${BuySellSearchBean.cate_code_1 == 'C10100'}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_if_4 = _jspx_th_c_if_4.doStartTag();
    if (_jspx_eval_c_if_4 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t                    \t<option value=\"1\" selected=\"selected\">물건사기</option>\r\n");
        out.write("\t\t\t                    \t<option value=\"2\" >물건팔기</option>\r\n");
        out.write("\t\t\t                    ");
        int evalDoAfterBody = _jspx_th_c_if_4.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_4);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_4);
    return false;
  }

  private boolean _jspx_meth_c_if_5(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_5 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_5.setPageContext(_jspx_page_context);
    _jspx_th_c_if_5.setParent(null);
    _jspx_th_c_if_5.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${BuySellSearchBean.cate_code_1 == 'C10200'}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_if_5 = _jspx_th_c_if_5.doStartTag();
    if (_jspx_eval_c_if_5 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t                    \t <option value=\"1\" >물건사기</option>\r\n");
        out.write("\t\t\t                    \t <option value=\"2\" selected=\"selected\">물건팔기</option>\r\n");
        out.write("\t\t\t                    ");
        int evalDoAfterBody = _jspx_th_c_if_5.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_5);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_5);
    return false;
  }

  private boolean _jspx_meth_c_if_6(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_6 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_6.setPageContext(_jspx_page_context);
    _jspx_th_c_if_6.setParent(null);
    _jspx_th_c_if_6.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${!empty Category2List}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_if_6 = _jspx_th_c_if_6.doStartTag();
    if (_jspx_eval_c_if_6 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("&gt;\r\n");
        out.write("\t\t\t\t\t\t\t<select name=\"category2\" id=\"category2\" onchange=\"return goDirectCategory();\">\r\n");
        out.write("\t\t\t\t\t\t\t\t");
        if (_jspx_meth_c_forEach_0(_jspx_th_c_if_6, _jspx_page_context))
          return true;
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t</select>&nbsp;\r\n");
        out.write("\t\t\t\t\t\t\t");
        int evalDoAfterBody = _jspx_th_c_if_6.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_6);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_6);
    return false;
  }

  private boolean _jspx_meth_c_forEach_0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_if_6, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_varStatus_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_0.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_6);
    _jspx_th_c_forEach_0.setVar("Category2");
    _jspx_th_c_forEach_0.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${Category2List}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    _jspx_th_c_forEach_0.setVarStatus("i");
    int[] _jspx_push_body_count_c_forEach_0 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_0 = _jspx_th_c_forEach_0.doStartTag();
      if (_jspx_eval_c_forEach_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("\t\t\t\t\t\t\t\t\t");
          if (_jspx_meth_c_if_7(_jspx_th_c_forEach_0, _jspx_page_context, _jspx_push_body_count_c_forEach_0))
            return true;
          out.write("\r\n");
          out.write("\t\t\t\t\t\t\t\t\t");
          if (_jspx_meth_c_if_8(_jspx_th_c_forEach_0, _jspx_page_context, _jspx_push_body_count_c_forEach_0))
            return true;
          out.write("\t\r\n");
          out.write("\t\t\t\t\t\t\t\t");
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

  private boolean _jspx_meth_c_if_7(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_7 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_7.setPageContext(_jspx_page_context);
    _jspx_th_c_if_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_0);
    _jspx_th_c_if_7.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${BuySellBean.cate_code_2 == Category2.cate_code_2}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_if_7 = _jspx_th_c_if_7.doStartTag();
    if (_jspx_eval_c_if_7 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t<option selected value=\"");
        if (_jspx_meth_c_out_0(_jspx_th_c_if_7, _jspx_page_context, _jspx_push_body_count_c_forEach_0))
          return true;
        out.write('"');
        out.write('>');
        if (_jspx_meth_c_out_1(_jspx_th_c_if_7, _jspx_page_context, _jspx_push_body_count_c_forEach_0))
          return true;
        out.write("</option>\r\n");
        out.write("\t\t\t\t\t\t\t\t\t");
        int evalDoAfterBody = _jspx_th_c_if_7.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_7);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_7);
    return false;
  }

  private boolean _jspx_meth_c_out_0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_if_7, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_out_0 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _jspx_tagPool_c_out_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_out_0.setPageContext(_jspx_page_context);
    _jspx_th_c_out_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_7);
    _jspx_th_c_out_0.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${Category2.cate_code_2}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_out_0 = _jspx_th_c_out_0.doStartTag();
    if (_jspx_th_c_out_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_0);
      return true;
    }
    _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_0);
    return false;
  }

  private boolean _jspx_meth_c_out_1(javax.servlet.jsp.tagext.JspTag _jspx_th_c_if_7, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_out_1 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _jspx_tagPool_c_out_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_out_1.setPageContext(_jspx_page_context);
    _jspx_th_c_out_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_7);
    _jspx_th_c_out_1.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${Category2.cate_name_2}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_out_1 = _jspx_th_c_out_1.doStartTag();
    if (_jspx_th_c_out_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_1);
      return true;
    }
    _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_1);
    return false;
  }

  private boolean _jspx_meth_c_if_8(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_8 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_8.setPageContext(_jspx_page_context);
    _jspx_th_c_if_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_0);
    _jspx_th_c_if_8.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${BuySellBean.cate_code_2 != Category2.cate_code_2}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_if_8 = _jspx_th_c_if_8.doStartTag();
    if (_jspx_eval_c_if_8 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t<option value=\"");
        if (_jspx_meth_c_out_2(_jspx_th_c_if_8, _jspx_page_context, _jspx_push_body_count_c_forEach_0))
          return true;
        out.write('"');
        out.write('>');
        if (_jspx_meth_c_out_3(_jspx_th_c_if_8, _jspx_page_context, _jspx_push_body_count_c_forEach_0))
          return true;
        out.write("</option>\r\n");
        out.write("\t\t\t\t\t\t\t\t\t");
        int evalDoAfterBody = _jspx_th_c_if_8.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_8);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_8);
    return false;
  }

  private boolean _jspx_meth_c_out_2(javax.servlet.jsp.tagext.JspTag _jspx_th_c_if_8, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_out_2 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _jspx_tagPool_c_out_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_out_2.setPageContext(_jspx_page_context);
    _jspx_th_c_out_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_8);
    _jspx_th_c_out_2.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${Category2.cate_code_2}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_out_2 = _jspx_th_c_out_2.doStartTag();
    if (_jspx_th_c_out_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_2);
      return true;
    }
    _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_2);
    return false;
  }

  private boolean _jspx_meth_c_out_3(javax.servlet.jsp.tagext.JspTag _jspx_th_c_if_8, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_out_3 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _jspx_tagPool_c_out_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_out_3.setPageContext(_jspx_page_context);
    _jspx_th_c_out_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_8);
    _jspx_th_c_out_3.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${Category2.cate_name_2}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_out_3 = _jspx_th_c_out_3.doStartTag();
    if (_jspx_th_c_out_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_3);
      return true;
    }
    _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_3);
    return false;
  }

  private boolean _jspx_meth_c_if_9(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_9 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_9.setPageContext(_jspx_page_context);
    _jspx_th_c_if_9.setParent(null);
    _jspx_th_c_if_9.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${BuySellSearchBean.cate_code_1 == 'C10100'}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_if_9 = _jspx_th_c_if_9.doStartTag();
    if (_jspx_eval_c_if_9 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t\t<!--목록버튼 -->\r\n");
        out.write("\t\t\t\t\t\t\t\t");
        if (_jspx_meth_c_if_10(_jspx_th_c_if_9, _jspx_page_context))
          return true;
        out.write("\t\r\n");
        out.write("\t\t\t\t\t\t\t\t<!--전의페이지가 통합검색의경우 -->\r\n");
        out.write("\t\t\t\t\t\t\t\t");
        if (_jspx_meth_c_if_11(_jspx_th_c_if_9, _jspx_page_context))
          return true;
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t\t");
        if (_jspx_meth_c_if_12(_jspx_th_c_if_9, _jspx_page_context))
          return true;
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t\t<!--전의페이지가 내글보기의경우 -->\r\n");
        out.write("\t\t\t\t\t\t\t\t");
        if (_jspx_meth_c_if_13(_jspx_th_c_if_9, _jspx_page_context))
          return true;
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t\t<!--전의페이지가 메인화면일경우 -->\r\n");
        out.write("\t\t\t\t\t\t\t\t");
        if (_jspx_meth_c_if_14(_jspx_th_c_if_9, _jspx_page_context))
          return true;
        out.write("\t\t\t\t\t\t\t\t\t\r\n");
        out.write("\t\t\t\t\t\t\t\t<!--수정 삭제버튼 로그인 ID와작성자ID가 일치할경우 -->\r\n");
        out.write("\t\t\t\t\t\t\t\t");
        if (_jspx_meth_c_if_15(_jspx_th_c_if_9, _jspx_page_context))
          return true;
        out.write("\t\r\n");
        out.write("\t\t\t\t\t\t\t");
        int evalDoAfterBody = _jspx_th_c_if_9.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_9);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_9);
    return false;
  }

  private boolean _jspx_meth_c_if_10(javax.servlet.jsp.tagext.JspTag _jspx_th_c_if_9, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_10 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_10.setPageContext(_jspx_page_context);
    _jspx_th_c_if_10.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_9);
    _jspx_th_c_if_10.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${BuySellSearchBean.before == 'search'}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_if_10 = _jspx_th_c_if_10.doStartTag();
    if (_jspx_eval_c_if_10 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t              \t\t\t<!--ID가 없으면 내글보기표시 -->\r\n");
        out.write("\t\t\t              \t\t\t<a href=\"javascript:backSearchPage();\"><img src=\"jsp/images/new/tolist.gif\" width=\"91\" /></a>&nbsp;\r\n");
        out.write("\t\t\t\t\t\t\t\t");
        int evalDoAfterBody = _jspx_th_c_if_10.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_10);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_10);
    return false;
  }

  private boolean _jspx_meth_c_if_11(javax.servlet.jsp.tagext.JspTag _jspx_th_c_if_9, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_11 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_11.setPageContext(_jspx_page_context);
    _jspx_th_c_if_11.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_9);
    _jspx_th_c_if_11.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${BuySellSearchBean.before == 'search_all'}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_if_11 = _jspx_th_c_if_11.doStartTag();
    if (_jspx_eval_c_if_11 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t\t \t<a href=\"javascript:backSearchAllPage();\"><img src=\"jsp/images/new/tolist.gif\" width=\"91\" /></a>\t\t\t\t\t\t\t\r\n");
        out.write("\t\t\t\t\t\t\t\t");
        int evalDoAfterBody = _jspx_th_c_if_11.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_11.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_11);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_11);
    return false;
  }

  private boolean _jspx_meth_c_if_12(javax.servlet.jsp.tagext.JspTag _jspx_th_c_if_9, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_12 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_12.setPageContext(_jspx_page_context);
    _jspx_th_c_if_12.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_9);
    _jspx_th_c_if_12.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${BuySellSearchBean.before == 'mysearch'}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_if_12 = _jspx_th_c_if_12.doStartTag();
    if (_jspx_eval_c_if_12 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t\t\t<!--ID가 있으면 목록표시 -->\r\n");
        out.write("\t\t\t\t\t\t\t\t \t<a href=\"javascript:backMySearchPage();\"><img src=\"jsp/images/new/tolist.gif\" width=\"91\" /></a>\t\t\t\t\t\t\t\r\n");
        out.write("\t\t\t\t\t\t\t\t");
        int evalDoAfterBody = _jspx_th_c_if_12.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_12.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_12);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_12);
    return false;
  }

  private boolean _jspx_meth_c_if_13(javax.servlet.jsp.tagext.JspTag _jspx_th_c_if_9, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_13 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_13.setPageContext(_jspx_page_context);
    _jspx_th_c_if_13.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_9);
    _jspx_th_c_if_13.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${BuySellSearchBean.before == 'my_write'}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_if_13 = _jspx_th_c_if_13.doStartTag();
    if (_jspx_eval_c_if_13 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t\t \t<a href=\"javascript:backMyWrite(1);\"><img src=\"jsp/images/new/tolist.gif\" width=\"91\" /></a>\t\t\t\t\t\t\t\r\n");
        out.write("\t\t\t\t\t\t\t\t");
        int evalDoAfterBody = _jspx_th_c_if_13.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_13.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_13);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_13);
    return false;
  }

  private boolean _jspx_meth_c_if_14(javax.servlet.jsp.tagext.JspTag _jspx_th_c_if_9, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_14 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_14.setPageContext(_jspx_page_context);
    _jspx_th_c_if_14.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_9);
    _jspx_th_c_if_14.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${BuySellSearchBean.before == 'new_write'}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_if_14 = _jspx_th_c_if_14.doStartTag();
    if (_jspx_eval_c_if_14 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("              \t\t\t\t\t\t<a href=\"javascript:goSearchPage();\"><img src=\"jsp/images/new/tolist.gif\" width=\"91\" /></a>&nbsp;\r\n");
        out.write("\t\t\t\t\t\t\t\t");
        int evalDoAfterBody = _jspx_th_c_if_14.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_14.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_14);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_14);
    return false;
  }

  private boolean _jspx_meth_c_if_15(javax.servlet.jsp.tagext.JspTag _jspx_th_c_if_9, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_15 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_15.setPageContext(_jspx_page_context);
    _jspx_th_c_if_15.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_9);
    _jspx_th_c_if_15.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${BuySellBean.user_id == memberInfo.userid}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_if_15 = _jspx_th_c_if_15.doStartTag();
    if (_jspx_eval_c_if_15 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t\t\t<a href=\"javascript:openUpdate('");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${BuySellBean.id}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
        out.write("');\"><img src=\"jsp/images/new/btn_edit.gif\"></a> &nbsp;\r\n");
        out.write("\t\t\t\t\t\t\t\t\t<a href=\"javascript:deleteCheck('");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${BuySellBean.id}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
        out.write("');\"><img src=\"jsp/images/new/btn_delete.gif\"></a>\r\n");
        out.write("\t\t\t\t\t\t\t\t");
        int evalDoAfterBody = _jspx_th_c_if_15.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_15.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_15);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_15);
    return false;
  }

  private boolean _jspx_meth_c_if_17(javax.servlet.jsp.tagext.JspTag _jspx_th_c_if_16, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_17 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_17.setPageContext(_jspx_page_context);
    _jspx_th_c_if_17.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_16);
    _jspx_th_c_if_17.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${BuySellSearchBean.before == 'search'}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_if_17 = _jspx_th_c_if_17.doStartTag();
    if (_jspx_eval_c_if_17 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t              \t\t\t<!--ID가 없으면 내글보기표시 -->\r\n");
        out.write("\t\t\t              \t\t\t<a href=\"javascript:backSearchPage();\"><img src=\"jsp/images/new/tolist.gif\" width=\"91\" /></a>&nbsp;\r\n");
        out.write("\t\t\t\t\t\t\t\t");
        int evalDoAfterBody = _jspx_th_c_if_17.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_17.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_17);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_17);
    return false;
  }

  private boolean _jspx_meth_c_if_18(javax.servlet.jsp.tagext.JspTag _jspx_th_c_if_16, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_18 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_18.setPageContext(_jspx_page_context);
    _jspx_th_c_if_18.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_16);
    _jspx_th_c_if_18.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${BuySellSearchBean.before == 'search_all'}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_if_18 = _jspx_th_c_if_18.doStartTag();
    if (_jspx_eval_c_if_18 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t\t\t<!--ID가 있으면 목록표시 -->\r\n");
        out.write("\t\t\t\t\t\t\t\t \t<a href=\"javascript:backSearchAllPage();\"><img src=\"jsp/images/new/tolist.gif\" width=\"91\" /></a>\t\t\t\t\t\t\t\r\n");
        out.write("\t\t\t\t\t\t\t\t");
        int evalDoAfterBody = _jspx_th_c_if_18.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_18.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_18);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_18);
    return false;
  }

  private boolean _jspx_meth_c_if_19(javax.servlet.jsp.tagext.JspTag _jspx_th_c_if_16, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_19 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_19.setPageContext(_jspx_page_context);
    _jspx_th_c_if_19.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_16);
    _jspx_th_c_if_19.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${BuySellSearchBean.before == 'mysearch'}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_if_19 = _jspx_th_c_if_19.doStartTag();
    if (_jspx_eval_c_if_19 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t\t\t<!--ID가 있으면 목록표시 -->\r\n");
        out.write("\t\t\t\t\t\t\t\t \t<a href=\"javascript:backMySearchPage();\"><img src=\"jsp/images/new/tolist.gif\" width=\"91\" /></a>\t\t\t\t\t\t\t\r\n");
        out.write("\t\t\t\t\t\t\t\t");
        int evalDoAfterBody = _jspx_th_c_if_19.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_19.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_19);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_19);
    return false;
  }

  private boolean _jspx_meth_c_if_20(javax.servlet.jsp.tagext.JspTag _jspx_th_c_if_16, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_20 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_20.setPageContext(_jspx_page_context);
    _jspx_th_c_if_20.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_16);
    _jspx_th_c_if_20.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${BuySellSearchBean.before == 'my_write'}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_if_20 = _jspx_th_c_if_20.doStartTag();
    if (_jspx_eval_c_if_20 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t\t\t<!--ID가 있으면 목록표시 -->\r\n");
        out.write("\t\t\t\t\t\t\t\t \t<a href=\"javascript:backMyWrite(2);\"><img src=\"jsp/images/new/tolist.gif\" width=\"91\" /></a>\t\t\t\t\t\t\t\r\n");
        out.write("\t\t\t\t\t\t\t\t");
        int evalDoAfterBody = _jspx_th_c_if_20.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_20.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_20);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_20);
    return false;
  }

  private boolean _jspx_meth_c_if_21(javax.servlet.jsp.tagext.JspTag _jspx_th_c_if_16, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_21 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_21.setPageContext(_jspx_page_context);
    _jspx_th_c_if_21.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_16);
    _jspx_th_c_if_21.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${BuySellSearchBean.before == 'new_write'}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_if_21 = _jspx_th_c_if_21.doStartTag();
    if (_jspx_eval_c_if_21 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("              \t\t\t\t\t\t<a href=\"javascript:goSearchPage();\"><img src=\"jsp/images/new/tolist.gif\" width=\"91\" /></a>&nbsp;\r\n");
        out.write("\t\t\t\t\t\t\t\t");
        int evalDoAfterBody = _jspx_th_c_if_21.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_21.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_21);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_21);
    return false;
  }

  private boolean _jspx_meth_c_out_4(javax.servlet.jsp.tagext.JspTag _jspx_th_c_if_27, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_out_4 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _jspx_tagPool_c_out_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_out_4.setPageContext(_jspx_page_context);
    _jspx_th_c_out_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_27);
    _jspx_th_c_out_4.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${BuySellBean.cate_name_2}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_out_4 = _jspx_th_c_out_4.doStartTag();
    if (_jspx_th_c_out_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_4);
      return true;
    }
    _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_4);
    return false;
  }

  private boolean _jspx_meth_c_if_28(javax.servlet.jsp.tagext.JspTag _jspx_th_c_if_27, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_28 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_28.setPageContext(_jspx_page_context);
    _jspx_th_c_if_28.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_27);
    _jspx_th_c_if_28.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${BuySellBean.pro_status == '1'}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_if_28 = _jspx_th_c_if_28.doStartTag();
    if (_jspx_eval_c_if_28 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t\t\t            \t\t중고\r\n");
        out.write("\t\t\t\t\t\t\t\t\t            \t");
        int evalDoAfterBody = _jspx_th_c_if_28.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_28.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_28);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_28);
    return false;
  }

  private boolean _jspx_meth_c_if_29(javax.servlet.jsp.tagext.JspTag _jspx_th_c_if_27, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_29 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_29.setPageContext(_jspx_page_context);
    _jspx_th_c_if_29.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_27);
    _jspx_th_c_if_29.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${BuySellBean.pro_status == '2'}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_if_29 = _jspx_th_c_if_29.doStartTag();
    if (_jspx_eval_c_if_29 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t\t\t            \t\t신제품\r\n");
        out.write("\t\t\t\t\t\t\t\t\t            \t");
        int evalDoAfterBody = _jspx_th_c_if_29.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_29.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_29);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_29);
    return false;
  }

  private boolean _jspx_meth_c_if_30(javax.servlet.jsp.tagext.JspTag _jspx_th_c_if_27, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_30 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_30.setPageContext(_jspx_page_context);
    _jspx_th_c_if_30.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_27);
    _jspx_th_c_if_30.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${BuySellBean.free_price == '1'}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_if_30 = _jspx_th_c_if_30.doStartTag();
    if (_jspx_eval_c_if_30 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t\t\t            \t\t무료\r\n");
        out.write("\t\t\t\t\t\t\t\t\t            \t");
        int evalDoAfterBody = _jspx_th_c_if_30.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_30.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_30);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_30);
    return false;
  }

  private boolean _jspx_meth_c_if_31(javax.servlet.jsp.tagext.JspTag _jspx_th_c_if_27, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_31 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_31.setPageContext(_jspx_page_context);
    _jspx_th_c_if_31.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_27);
    _jspx_th_c_if_31.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${BuySellBean.free_price != '1' and !empty BuySellBean.price}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_if_31 = _jspx_th_c_if_31.doStartTag();
    if (_jspx_eval_c_if_31 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t\t\t            \t\t");
        if (_jspx_meth_c_out_5(_jspx_th_c_if_31, _jspx_page_context))
          return true;
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t\t\t            \t");
        int evalDoAfterBody = _jspx_th_c_if_31.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_31.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_31);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_31);
    return false;
  }

  private boolean _jspx_meth_c_out_5(javax.servlet.jsp.tagext.JspTag _jspx_th_c_if_31, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_out_5 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _jspx_tagPool_c_out_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_out_5.setPageContext(_jspx_page_context);
    _jspx_th_c_out_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_31);
    _jspx_th_c_out_5.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${BuySellBean.price}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_out_5 = _jspx_th_c_out_5.doStartTag();
    if (_jspx_th_c_out_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_5);
      return true;
    }
    _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_5);
    return false;
  }

  private boolean _jspx_meth_c_if_32(javax.servlet.jsp.tagext.JspTag _jspx_th_c_if_27, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_32 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_32.setPageContext(_jspx_page_context);
    _jspx_th_c_if_32.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_27);
    _jspx_th_c_if_32.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${BuySellBean.send_method == '0'}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_if_32 = _jspx_th_c_if_32.doStartTag();
    if (_jspx_eval_c_if_32 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t\t\t            \t\t직거래 or 택배\r\n");
        out.write("\t\t\t\t\t\t\t\t\t            \t");
        int evalDoAfterBody = _jspx_th_c_if_32.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_32.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_32);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_32);
    return false;
  }

  private boolean _jspx_meth_c_if_33(javax.servlet.jsp.tagext.JspTag _jspx_th_c_if_27, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_33 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_33.setPageContext(_jspx_page_context);
    _jspx_th_c_if_33.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_27);
    _jspx_th_c_if_33.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${BuySellBean.send_method == '1'}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_if_33 = _jspx_th_c_if_33.doStartTag();
    if (_jspx_eval_c_if_33 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t\t\t            \t\t직거래\r\n");
        out.write("\t\t\t\t\t\t\t\t\t            \t");
        int evalDoAfterBody = _jspx_th_c_if_33.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_33.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_33);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_33);
    return false;
  }

  private boolean _jspx_meth_c_if_34(javax.servlet.jsp.tagext.JspTag _jspx_th_c_if_27, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_34 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_34.setPageContext(_jspx_page_context);
    _jspx_th_c_if_34.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_27);
    _jspx_th_c_if_34.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${BuySellBean.send_method == '2'}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_if_34 = _jspx_th_c_if_34.doStartTag();
    if (_jspx_eval_c_if_34 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t\t\t            \t\t택배\r\n");
        out.write("\t\t\t\t\t\t\t\t\t            \t");
        int evalDoAfterBody = _jspx_th_c_if_34.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_34.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_34);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_34);
    return false;
  }

  private boolean _jspx_meth_c_out_6(javax.servlet.jsp.tagext.JspTag _jspx_th_c_if_27, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_out_6 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _jspx_tagPool_c_out_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_out_6.setPageContext(_jspx_page_context);
    _jspx_th_c_out_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_27);
    _jspx_th_c_out_6.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${BuySellBean.sell_place}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_out_6 = _jspx_th_c_out_6.doStartTag();
    if (_jspx_th_c_out_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_6);
      return true;
    }
    _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_6);
    return false;
  }

  private boolean _jspx_meth_c_out_7(javax.servlet.jsp.tagext.JspTag _jspx_th_c_if_27, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_out_7 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _jspx_tagPool_c_out_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_out_7.setPageContext(_jspx_page_context);
    _jspx_th_c_out_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_27);
    _jspx_th_c_out_7.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${BuySellBean.tel_no1_fname}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_out_7 = _jspx_th_c_out_7.doStartTag();
    if (_jspx_th_c_out_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_7);
      return true;
    }
    _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_7);
    return false;
  }

  private boolean _jspx_meth_c_out_8(javax.servlet.jsp.tagext.JspTag _jspx_th_c_if_27, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_out_8 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _jspx_tagPool_c_out_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_out_8.setPageContext(_jspx_page_context);
    _jspx_th_c_out_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_27);
    _jspx_th_c_out_8.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${BuySellBean.tel_no2_fname}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_out_8 = _jspx_th_c_out_8.doStartTag();
    if (_jspx_th_c_out_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_8);
      return true;
    }
    _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_8);
    return false;
  }

  private boolean _jspx_meth_c_out_9(javax.servlet.jsp.tagext.JspTag _jspx_th_c_if_27, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_out_9 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _jspx_tagPool_c_out_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_out_9.setPageContext(_jspx_page_context);
    _jspx_th_c_out_9.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_27);
    _jspx_th_c_out_9.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${BuySellBean.user_name}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_out_9 = _jspx_th_c_out_9.doStartTag();
    if (_jspx_th_c_out_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_9);
      return true;
    }
    _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_9);
    return false;
  }

  private boolean _jspx_meth_c_out_10(javax.servlet.jsp.tagext.JspTag _jspx_th_c_if_27, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_out_10 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _jspx_tagPool_c_out_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_out_10.setPageContext(_jspx_page_context);
    _jspx_th_c_out_10.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_27);
    _jspx_th_c_out_10.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${BuySellBean.read_count}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_out_10 = _jspx_th_c_out_10.doStartTag();
    if (_jspx_th_c_out_10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_10);
      return true;
    }
    _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_10);
    return false;
  }

  private boolean _jspx_meth_c_out_11(javax.servlet.jsp.tagext.JspTag _jspx_th_c_if_35, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_out_11 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _jspx_tagPool_c_out_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_out_11.setPageContext(_jspx_page_context);
    _jspx_th_c_out_11.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_35);
    _jspx_th_c_out_11.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${BuySellBean.cate_name_2}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_out_11 = _jspx_th_c_out_11.doStartTag();
    if (_jspx_th_c_out_11.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_11);
      return true;
    }
    _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_11);
    return false;
  }

  private boolean _jspx_meth_c_if_36(javax.servlet.jsp.tagext.JspTag _jspx_th_c_if_35, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_36 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_36.setPageContext(_jspx_page_context);
    _jspx_th_c_if_36.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_35);
    _jspx_th_c_if_36.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${BuySellBean.pro_status == '1'}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_if_36 = _jspx_th_c_if_36.doStartTag();
    if (_jspx_eval_c_if_36 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t\t\t            \t\t중고\r\n");
        out.write("\t\t\t\t\t\t\t\t\t            \t");
        int evalDoAfterBody = _jspx_th_c_if_36.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_36.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_36);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_36);
    return false;
  }

  private boolean _jspx_meth_c_if_37(javax.servlet.jsp.tagext.JspTag _jspx_th_c_if_35, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_37 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_37.setPageContext(_jspx_page_context);
    _jspx_th_c_if_37.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_35);
    _jspx_th_c_if_37.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${BuySellBean.pro_status == '2'}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_if_37 = _jspx_th_c_if_37.doStartTag();
    if (_jspx_eval_c_if_37 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t\t\t            \t\t신제품\r\n");
        out.write("\t\t\t\t\t\t\t\t\t            \t");
        int evalDoAfterBody = _jspx_th_c_if_37.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_37.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_37);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_37);
    return false;
  }

  private boolean _jspx_meth_c_if_38(javax.servlet.jsp.tagext.JspTag _jspx_th_c_if_35, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_38 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_38.setPageContext(_jspx_page_context);
    _jspx_th_c_if_38.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_35);
    _jspx_th_c_if_38.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${BuySellBean.pro_status == '1'}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_if_38 = _jspx_th_c_if_38.doStartTag();
    if (_jspx_eval_c_if_38 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t\t\t            \t\t개인회원\r\n");
        out.write("\t\t\t\t\t\t\t\t\t            \t");
        int evalDoAfterBody = _jspx_th_c_if_38.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_38.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_38);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_38);
    return false;
  }

  private boolean _jspx_meth_c_if_39(javax.servlet.jsp.tagext.JspTag _jspx_th_c_if_35, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_39 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_39.setPageContext(_jspx_page_context);
    _jspx_th_c_if_39.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_35);
    _jspx_th_c_if_39.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${BuySellBean.pro_status == '2'}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_if_39 = _jspx_th_c_if_39.doStartTag();
    if (_jspx_eval_c_if_39 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t\t\t            \t\t업자회원\r\n");
        out.write("\t\t\t\t\t\t\t\t\t            \t");
        int evalDoAfterBody = _jspx_th_c_if_39.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_39.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_39);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_39);
    return false;
  }

  private boolean _jspx_meth_c_if_40(javax.servlet.jsp.tagext.JspTag _jspx_th_c_if_35, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_40 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_40.setPageContext(_jspx_page_context);
    _jspx_th_c_if_40.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_35);
    _jspx_th_c_if_40.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${BuySellBean.free_price == '1'}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_if_40 = _jspx_th_c_if_40.doStartTag();
    if (_jspx_eval_c_if_40 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t\t\t            \t\t무료\r\n");
        out.write("\t\t\t\t\t\t\t\t\t            \t");
        int evalDoAfterBody = _jspx_th_c_if_40.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_40.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_40);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_40);
    return false;
  }

  private boolean _jspx_meth_c_if_41(javax.servlet.jsp.tagext.JspTag _jspx_th_c_if_35, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_41 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_41.setPageContext(_jspx_page_context);
    _jspx_th_c_if_41.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_35);
    _jspx_th_c_if_41.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${BuySellBean.free_price != '1' and !empty BuySellBean.price}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_if_41 = _jspx_th_c_if_41.doStartTag();
    if (_jspx_eval_c_if_41 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t\t\t            \t\t");
        if (_jspx_meth_c_out_12(_jspx_th_c_if_41, _jspx_page_context))
          return true;
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t\t            \t\t\t");
        if (_jspx_meth_c_if_42(_jspx_th_c_if_41, _jspx_page_context))
          return true;
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t\t            \t\t\t");
        if (_jspx_meth_c_if_43(_jspx_th_c_if_41, _jspx_page_context))
          return true;
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t\t\t            \t");
        int evalDoAfterBody = _jspx_th_c_if_41.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_41.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_41);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_41);
    return false;
  }

  private boolean _jspx_meth_c_out_12(javax.servlet.jsp.tagext.JspTag _jspx_th_c_if_41, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_out_12 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _jspx_tagPool_c_out_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_out_12.setPageContext(_jspx_page_context);
    _jspx_th_c_out_12.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_41);
    _jspx_th_c_out_12.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${BuySellBean.price}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_out_12 = _jspx_th_c_out_12.doStartTag();
    if (_jspx_th_c_out_12.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_12);
      return true;
    }
    _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_12);
    return false;
  }

  private boolean _jspx_meth_c_if_42(javax.servlet.jsp.tagext.JspTag _jspx_th_c_if_41, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_42 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_42.setPageContext(_jspx_page_context);
    _jspx_th_c_if_42.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_41);
    _jspx_th_c_if_42.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${empty BuySellBean.price_unit or BuySellBean.price_unit == '0'}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_if_42 = _jspx_th_c_if_42.doStartTag();
    if (_jspx_eval_c_if_42 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t\t            \t\t\t\t");
        if (_jspx_meth_c_out_13(_jspx_th_c_if_42, _jspx_page_context))
          return true;
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t\t            \t\t\t");
        int evalDoAfterBody = _jspx_th_c_if_42.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_42.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_42);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_42);
    return false;
  }

  private boolean _jspx_meth_c_out_13(javax.servlet.jsp.tagext.JspTag _jspx_th_c_if_42, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_out_13 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _jspx_tagPool_c_out_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_out_13.setPageContext(_jspx_page_context);
    _jspx_th_c_out_13.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_42);
    _jspx_th_c_out_13.setValue(new String("엔"));
    int _jspx_eval_c_out_13 = _jspx_th_c_out_13.doStartTag();
    if (_jspx_th_c_out_13.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_13);
      return true;
    }
    _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_13);
    return false;
  }

  private boolean _jspx_meth_c_if_43(javax.servlet.jsp.tagext.JspTag _jspx_th_c_if_41, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_43 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_43.setPageContext(_jspx_page_context);
    _jspx_th_c_if_43.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_41);
    _jspx_th_c_if_43.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${!empty BuySellBean.price_unit and BuySellBean.price_unit == '1'}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_if_43 = _jspx_th_c_if_43.doStartTag();
    if (_jspx_eval_c_if_43 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t\t            \t\t\t\t");
        if (_jspx_meth_c_out_14(_jspx_th_c_if_43, _jspx_page_context))
          return true;
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t\t            \t\t\t");
        int evalDoAfterBody = _jspx_th_c_if_43.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_43.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_43);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_43);
    return false;
  }

  private boolean _jspx_meth_c_out_14(javax.servlet.jsp.tagext.JspTag _jspx_th_c_if_43, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_out_14 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _jspx_tagPool_c_out_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_out_14.setPageContext(_jspx_page_context);
    _jspx_th_c_out_14.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_43);
    _jspx_th_c_out_14.setValue(new String("원"));
    int _jspx_eval_c_out_14 = _jspx_th_c_out_14.doStartTag();
    if (_jspx_th_c_out_14.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_14);
      return true;
    }
    _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_14);
    return false;
  }

  private boolean _jspx_meth_c_if_44(javax.servlet.jsp.tagext.JspTag _jspx_th_c_if_35, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_44 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_44.setPageContext(_jspx_page_context);
    _jspx_th_c_if_44.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_35);
    _jspx_th_c_if_44.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${BuySellBean.send_method == '0'}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_if_44 = _jspx_th_c_if_44.doStartTag();
    if (_jspx_eval_c_if_44 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t\t\t            \t\t직거래 or 택배\r\n");
        out.write("\t\t\t\t\t\t\t\t\t            \t");
        int evalDoAfterBody = _jspx_th_c_if_44.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_44.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_44);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_44);
    return false;
  }

  private boolean _jspx_meth_c_if_45(javax.servlet.jsp.tagext.JspTag _jspx_th_c_if_35, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_45 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_45.setPageContext(_jspx_page_context);
    _jspx_th_c_if_45.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_35);
    _jspx_th_c_if_45.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${BuySellBean.send_method == '1'}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_if_45 = _jspx_th_c_if_45.doStartTag();
    if (_jspx_eval_c_if_45 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t\t\t            \t\t직거래\r\n");
        out.write("\t\t\t\t\t\t\t\t\t            \t");
        int evalDoAfterBody = _jspx_th_c_if_45.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_45.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_45);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_45);
    return false;
  }

  private boolean _jspx_meth_c_if_46(javax.servlet.jsp.tagext.JspTag _jspx_th_c_if_35, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_46 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_46.setPageContext(_jspx_page_context);
    _jspx_th_c_if_46.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_35);
    _jspx_th_c_if_46.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${BuySellBean.send_method == '2'}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_if_46 = _jspx_th_c_if_46.doStartTag();
    if (_jspx_eval_c_if_46 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t\t\t            \t\t택배\r\n");
        out.write("\t\t\t\t\t\t\t\t\t            \t");
        int evalDoAfterBody = _jspx_th_c_if_46.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_46.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_46);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_46);
    return false;
  }

  private boolean _jspx_meth_c_out_15(javax.servlet.jsp.tagext.JspTag _jspx_th_c_if_35, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_out_15 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _jspx_tagPool_c_out_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_out_15.setPageContext(_jspx_page_context);
    _jspx_th_c_out_15.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_35);
    _jspx_th_c_out_15.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${BuySellBean.sell_place}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_out_15 = _jspx_th_c_out_15.doStartTag();
    if (_jspx_th_c_out_15.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_15);
      return true;
    }
    _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_15);
    return false;
  }

  private boolean _jspx_meth_c_out_16(javax.servlet.jsp.tagext.JspTag _jspx_th_c_if_35, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_out_16 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _jspx_tagPool_c_out_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_out_16.setPageContext(_jspx_page_context);
    _jspx_th_c_out_16.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_35);
    _jspx_th_c_out_16.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${BuySellBean.tel_no1_fname}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_out_16 = _jspx_th_c_out_16.doStartTag();
    if (_jspx_th_c_out_16.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_16);
      return true;
    }
    _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_16);
    return false;
  }

  private boolean _jspx_meth_c_out_17(javax.servlet.jsp.tagext.JspTag _jspx_th_c_if_35, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_out_17 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _jspx_tagPool_c_out_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_out_17.setPageContext(_jspx_page_context);
    _jspx_th_c_out_17.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_35);
    _jspx_th_c_out_17.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${BuySellBean.tel_no2_fname}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_out_17 = _jspx_th_c_out_17.doStartTag();
    if (_jspx_th_c_out_17.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_17);
      return true;
    }
    _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_17);
    return false;
  }

  private boolean _jspx_meth_c_out_18(javax.servlet.jsp.tagext.JspTag _jspx_th_c_if_35, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_out_18 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _jspx_tagPool_c_out_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_out_18.setPageContext(_jspx_page_context);
    _jspx_th_c_out_18.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_35);
    _jspx_th_c_out_18.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${BuySellBean.user_name}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_out_18 = _jspx_th_c_out_18.doStartTag();
    if (_jspx_th_c_out_18.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_18);
      return true;
    }
    _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_18);
    return false;
  }

  private boolean _jspx_meth_c_out_19(javax.servlet.jsp.tagext.JspTag _jspx_th_c_if_35, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_out_19 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _jspx_tagPool_c_out_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_out_19.setPageContext(_jspx_page_context);
    _jspx_th_c_out_19.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_35);
    _jspx_th_c_out_19.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${BuySellBean.read_count}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_out_19 = _jspx_th_c_out_19.doStartTag();
    if (_jspx_th_c_out_19.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_19);
      return true;
    }
    _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_19);
    return false;
  }

  private boolean _jspx_meth_c_if_47(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_47 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_47.setPageContext(_jspx_page_context);
    _jspx_th_c_if_47.setParent(null);
    _jspx_th_c_if_47.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${BuySellSearchBean.cate_code_1 == 'C10100'}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_if_47 = _jspx_th_c_if_47.doStartTag();
    if (_jspx_eval_c_if_47 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t\t\t<!--목록버튼 -->\r\n");
        out.write("\t\t\t\t\t\t");
        if (_jspx_meth_c_if_48(_jspx_th_c_if_47, _jspx_page_context))
          return true;
        out.write("\t\r\n");
        out.write("\t\t\t\t\t\t");
        if (_jspx_meth_c_if_49(_jspx_th_c_if_47, _jspx_page_context))
          return true;
        out.write("\r\n");
        out.write("\t\t\t\t\t\t");
        if (_jspx_meth_c_if_50(_jspx_th_c_if_47, _jspx_page_context))
          return true;
        out.write("\r\n");
        out.write("\t\t\t\t\t\t");
        if (_jspx_meth_c_if_51(_jspx_th_c_if_47, _jspx_page_context))
          return true;
        out.write("\r\n");
        out.write("\t\t\t\t\t\t");
        if (_jspx_meth_c_if_52(_jspx_th_c_if_47, _jspx_page_context))
          return true;
        out.write("\t\t\t\t\t\t\t\r\n");
        out.write("\t\t\t\t\t\t<!--수정 삭제버튼 로그인 ID와작성자ID가 일치할경우 -->\r\n");
        out.write("\t\t\t\t\t\t");
        if (_jspx_meth_c_if_53(_jspx_th_c_if_47, _jspx_page_context))
          return true;
        out.write("\t\r\n");
        out.write("\t\t\t\t\t");
        int evalDoAfterBody = _jspx_th_c_if_47.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_47.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_47);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_47);
    return false;
  }

  private boolean _jspx_meth_c_if_48(javax.servlet.jsp.tagext.JspTag _jspx_th_c_if_47, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_48 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_48.setPageContext(_jspx_page_context);
    _jspx_th_c_if_48.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_47);
    _jspx_th_c_if_48.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${BuySellSearchBean.before == 'search'}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_if_48 = _jspx_th_c_if_48.doStartTag();
    if (_jspx_eval_c_if_48 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t              \t\t\t<!--ID가 없으면 내글보기표시 -->\r\n");
        out.write("\t              \t\t\t<a href=\"javascript:backSearchPage();\"><img src=\"jsp/images/new/tolist.gif\" width=\"91\" /></a>&nbsp;\r\n");
        out.write("\t\t\t\t\t\t");
        int evalDoAfterBody = _jspx_th_c_if_48.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_48.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_48);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_48);
    return false;
  }

  private boolean _jspx_meth_c_if_49(javax.servlet.jsp.tagext.JspTag _jspx_th_c_if_47, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_49 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_49.setPageContext(_jspx_page_context);
    _jspx_th_c_if_49.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_47);
    _jspx_th_c_if_49.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${BuySellSearchBean.before == 'search_all'}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_if_49 = _jspx_th_c_if_49.doStartTag();
    if (_jspx_eval_c_if_49 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t<!--ID가 있으면 목록표시 -->\r\n");
        out.write("\t\t\t\t\t\t \t<a href=\"javascript:backSearchAllPage();\"><img src=\"jsp/images/new/tolist.gif\" width=\"91\" /></a>\t\t\t\t\t\t\t\r\n");
        out.write("\t\t\t\t\t\t");
        int evalDoAfterBody = _jspx_th_c_if_49.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_49.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_49);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_49);
    return false;
  }

  private boolean _jspx_meth_c_if_50(javax.servlet.jsp.tagext.JspTag _jspx_th_c_if_47, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_50 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_50.setPageContext(_jspx_page_context);
    _jspx_th_c_if_50.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_47);
    _jspx_th_c_if_50.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${BuySellSearchBean.before == 'mysearch'}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_if_50 = _jspx_th_c_if_50.doStartTag();
    if (_jspx_eval_c_if_50 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t<!--ID가 있으면 목록표시 -->\r\n");
        out.write("\t\t\t\t\t\t \t<a href=\"javascript:backMySearchPage();\"><img src=\"jsp/images/new/tolist.gif\" width=\"91\"/></a>\t\t\t\t\t\t\t\r\n");
        out.write("\t\t\t\t\t\t");
        int evalDoAfterBody = _jspx_th_c_if_50.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_50.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_50);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_50);
    return false;
  }

  private boolean _jspx_meth_c_if_51(javax.servlet.jsp.tagext.JspTag _jspx_th_c_if_47, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_51 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_51.setPageContext(_jspx_page_context);
    _jspx_th_c_if_51.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_47);
    _jspx_th_c_if_51.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${BuySellSearchBean.before == 'my_write'}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_if_51 = _jspx_th_c_if_51.doStartTag();
    if (_jspx_eval_c_if_51 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t<!--ID가 있으면 목록표시 -->\r\n");
        out.write("\t\t\t\t\t\t \t<a href=\"javascript:backMyWrite(1);\"><img src=\"jsp/images/new/tolist.gif\" width=\"91\" /></a>\t\t\t\t\t\t\t\r\n");
        out.write("\t\t\t\t\t\t");
        int evalDoAfterBody = _jspx_th_c_if_51.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_51.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_51);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_51);
    return false;
  }

  private boolean _jspx_meth_c_if_52(javax.servlet.jsp.tagext.JspTag _jspx_th_c_if_47, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_52 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_52.setPageContext(_jspx_page_context);
    _jspx_th_c_if_52.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_47);
    _jspx_th_c_if_52.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${BuySellSearchBean.before == 'new_write'}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_if_52 = _jspx_th_c_if_52.doStartTag();
    if (_jspx_eval_c_if_52 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("      \t\t\t\t\t\t<a href=\"javascript:goSearchPage();\"><img src=\"jsp/images/new/tolist.gif\" width=\"91\" /></a>&nbsp;\r\n");
        out.write("\t\t\t\t\t\t");
        int evalDoAfterBody = _jspx_th_c_if_52.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_52.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_52);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_52);
    return false;
  }

  private boolean _jspx_meth_c_if_53(javax.servlet.jsp.tagext.JspTag _jspx_th_c_if_47, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_53 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_53.setPageContext(_jspx_page_context);
    _jspx_th_c_if_53.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_47);
    _jspx_th_c_if_53.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${BuySellBean.user_id == memberInfo.userid}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_if_53 = _jspx_th_c_if_53.doStartTag();
    if (_jspx_eval_c_if_53 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t<a href=\"javascript:openUpdate('");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${BuySellBean.id}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
        out.write("');\"><img src=\"jsp/images/new/btn_edit.gif\"></a> &nbsp;\r\n");
        out.write("\t\t\t\t\t\t\t<a href=\"javascript:deleteCheck('");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${BuySellBean.id}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
        out.write(",wf');\"><img src=\"jsp/images/new/btn_delete.gif\"></a>\r\n");
        out.write("\t\t\t\t\t\t");
        int evalDoAfterBody = _jspx_th_c_if_53.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_53.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_53);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_53);
    return false;
  }

  private boolean _jspx_meth_c_if_55(javax.servlet.jsp.tagext.JspTag _jspx_th_c_if_54, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_55 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_55.setPageContext(_jspx_page_context);
    _jspx_th_c_if_55.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_54);
    _jspx_th_c_if_55.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${BuySellSearchBean.before == 'search'}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_if_55 = _jspx_th_c_if_55.doStartTag();
    if (_jspx_eval_c_if_55 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t              \t\t\t<!--ID가 없으면 내글보기표시 -->\r\n");
        out.write("\t              \t\t\t<a href=\"javascript:backSearchPage();\"><img src=\"jsp/images/new/tolist.gif\" width=\"91\" /></a>&nbsp;\r\n");
        out.write("\t\t\t\t\t\t");
        int evalDoAfterBody = _jspx_th_c_if_55.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_55.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_55);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_55);
    return false;
  }

  private boolean _jspx_meth_c_if_56(javax.servlet.jsp.tagext.JspTag _jspx_th_c_if_54, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_56 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_56.setPageContext(_jspx_page_context);
    _jspx_th_c_if_56.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_54);
    _jspx_th_c_if_56.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${BuySellSearchBean.before == 'search_all'}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_if_56 = _jspx_th_c_if_56.doStartTag();
    if (_jspx_eval_c_if_56 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t<!--ID가 있으면 목록표시 -->\r\n");
        out.write("\t\t\t\t\t\t \t<a href=\"javascript:backSearchAllPage();\"><img src=\"jsp/images/new/tolist.gif\" width=\"91\" /></a>\t\t\t\t\t\t\t\r\n");
        out.write("\t\t\t\t\t\t");
        int evalDoAfterBody = _jspx_th_c_if_56.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_56.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_56);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_56);
    return false;
  }

  private boolean _jspx_meth_c_if_57(javax.servlet.jsp.tagext.JspTag _jspx_th_c_if_54, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_57 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_57.setPageContext(_jspx_page_context);
    _jspx_th_c_if_57.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_54);
    _jspx_th_c_if_57.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${BuySellSearchBean.before == 'mysearch'}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_if_57 = _jspx_th_c_if_57.doStartTag();
    if (_jspx_eval_c_if_57 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t<!--ID가 있으면 목록표시 -->\r\n");
        out.write("\t\t\t\t\t\t \t<a href=\"javascript:backMySearchPage();\"><img src=\"jsp/images/new/tolist.gif\" width=\"91\" /></a>\t\t\t\t\t\t\t\r\n");
        out.write("\t\t\t\t\t\t");
        int evalDoAfterBody = _jspx_th_c_if_57.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_57.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_57);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_57);
    return false;
  }

  private boolean _jspx_meth_c_if_58(javax.servlet.jsp.tagext.JspTag _jspx_th_c_if_54, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_58 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_58.setPageContext(_jspx_page_context);
    _jspx_th_c_if_58.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_54);
    _jspx_th_c_if_58.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${BuySellSearchBean.before == 'my_write'}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_if_58 = _jspx_th_c_if_58.doStartTag();
    if (_jspx_eval_c_if_58 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t<!--ID가 있으면 목록표시 -->\r\n");
        out.write("\t\t\t\t\t\t \t<a href=\"javascript:backMyWrite(1);\"><img src=\"jsp/images/new/tolist.gif\" width=\"91\" /></a>\t\t\t\t\t\t\t\r\n");
        out.write("\t\t\t\t\t\t");
        int evalDoAfterBody = _jspx_th_c_if_58.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_58.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_58);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_58);
    return false;
  }

  private boolean _jspx_meth_c_if_59(javax.servlet.jsp.tagext.JspTag _jspx_th_c_if_54, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_59 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_59.setPageContext(_jspx_page_context);
    _jspx_th_c_if_59.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_54);
    _jspx_th_c_if_59.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${BuySellSearchBean.before == 'new_write'}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_if_59 = _jspx_th_c_if_59.doStartTag();
    if (_jspx_eval_c_if_59 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("      \t\t\t\t\t\t<a href=\"javascript:goSearchPage();\"><img src=\"jsp/images/new/tolist.gif\" width=\"91\" /></a>&nbsp;\r\n");
        out.write("\t\t\t\t\t\t");
        int evalDoAfterBody = _jspx_th_c_if_59.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_59.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_59);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_59);
    return false;
  }
}
