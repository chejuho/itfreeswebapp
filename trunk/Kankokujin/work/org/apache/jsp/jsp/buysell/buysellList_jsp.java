package org.apache.jsp.jsp.buysell;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import common.bean.PageBean;
import category.bean.CategoryBean;
import java.util.List;
import java.util.Iterator;
import buysell.bean.BuySellBean;
import buysell.bean.BuySellSearchBean;
import common.bean.MemberBean;
import common.util.Util;
import common.constant.Const;

public final class buysellList_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

static private org.apache.jasper.runtime.ProtectedFunctionMapper _jspx_fnmap_0;
static private org.apache.jasper.runtime.ProtectedFunctionMapper _jspx_fnmap_1;

static {
  _jspx_fnmap_0= org.apache.jasper.runtime.ProtectedFunctionMapper.getMapForFunction("util:getNewImage", common.util.Util.class, "getNewImage", new Class[] {java.util.Date.class});
  _jspx_fnmap_1= org.apache.jasper.runtime.ProtectedFunctionMapper.getMapForFunction("util:cutLongName", common.util.Util.class, "cutLongName", new Class[] {int.class, java.lang.String.class});
}

  private static java.util.List _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList(2);
    _jspx_dependants.add("/WEB-INF/tlds/pageHandleTag.tld");
    _jspx_dependants.add("/WEB-INF/tlds/utilFunction.tld");
  }

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_fmt_setLocale_value_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_fmt_setBundle_var_basename_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_if_test;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_out_value_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_fmt_message_key_bundle_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_forEach_varStatus_var_items;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_choose;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_when_test;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_otherwise;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_forEach_var_step_end_begin;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_fmt_setLocale_value_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_fmt_setBundle_var_basename_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_if_test = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_out_value_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_fmt_message_key_bundle_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_forEach_varStatus_var_items = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_choose = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_when_test = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_otherwise = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_forEach_var_step_end_begin = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_fmt_setLocale_value_nobody.release();
    _jspx_tagPool_fmt_setBundle_var_basename_nobody.release();
    _jspx_tagPool_c_if_test.release();
    _jspx_tagPool_c_out_value_nobody.release();
    _jspx_tagPool_fmt_message_key_bundle_nobody.release();
    _jspx_tagPool_c_forEach_varStatus_var_items.release();
    _jspx_tagPool_c_choose.release();
    _jspx_tagPool_c_when_test.release();
    _jspx_tagPool_c_otherwise.release();
    _jspx_tagPool_c_forEach_var_step_end_begin.release();
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
      out.write("\r\n");
      if (_jspx_meth_fmt_setLocale_0(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
      if (_jspx_meth_fmt_setBundle_0(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');

	PageBean pageBean = (PageBean) session.getAttribute("PageBean");
	List buySellBeanList = (List) request.getAttribute("BuySellBeanList");
	BuySellSearchBean buySellSearchBean = (BuySellSearchBean) request.getAttribute("BuySellSearchBean");
	List category2List = (List) request.getAttribute("Category2List");
	
	String message = (String)Util.changeNullStr(request.getAttribute("Message"));
	MemberBean member = new MemberBean();
	member.setUserid("-");
	if (session.getAttribute("memberInfo")!=null){
		member = (MemberBean) session.getAttribute("memberInfo");	
	}

      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<meta http-equiv=\"Content-type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write(" <head>\r\n");
      if (_jspx_meth_c_if_0(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
      if (_jspx_meth_c_if_1(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\r\n");
      out.write("<script src=\"jsp/include/js/prototype.js\" type=\"text/javascript\" ></script>\r\n");
      out.write("<script src=\"jsp/include/js/src/scriptaculous.js?effets\" type=\"text/javascript\" ></script>\r\n");
      out.write("<script src=\"jsp/include/js/popupMenu.js\" type=\"text/javascript\"></script>\r\n");
      out.write("<script src=\"jsp/include/js/top.js\" type=\"text/javascript\"></script>\r\n");
      out.write("<script src=\"jsp/include/js/commonCheck.js\" type=\"text/javascript\"></script>\r\n");
      out.write("<script src=\"jsp/include/js/commonFunction.js\" type=\"text/javascript\" charset=\"utf-8\"></script>\r\n");
      out.write("\r\n");
      out.write("<link href=\"jsp/include/css/basic.css\" rel=\"stylesheet\" type=\"text/css\">\t\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\tvar clickedUserid;\r\n");
      out.write("\tvar clickedId;\r\n");
      out.write("\tvar clickedName;\r\n");
      out.write("\tvar popupMenuList = new Array();\r\n");
      out.write("\twindow.onload = function()\r\n");
      out.write("\t{\r\n");
      out.write("\t\tfor (var i = 1; i < 11; i++) {\r\n");
      out.write("\t\t\tvar name = \"link\" + i;\r\n");
      out.write("\t\t\tif ($(name)) {\r\n");
      out.write("\t\t\t\tpopupMenuList.push(new PopupMenu($(name), $(\"popup\")));\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("\t/** ERROR메세지 처리  */\r\n");
      out.write("\t function messageCheck() {\r\n");
      out.write("\t\tvar message = document.getElementById(\"msg\").value;\r\n");
      out.write("\t\tif (message) {\r\n");
      out.write("\t\t\tif (message == 'WAR0004'){\r\n");
      out.write("\t\t\t\talert(\"");
      if (_jspx_meth_fmt_message_2(_jspx_page_context))
        return;
      out.write("\");\r\n");
      out.write("\t\t\t\twindow.open('PopLogin', 'notice', 'width=230, height=160');\t\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction registOpen(ff) {\r\n");
      out.write("\t\tff.action=\"BuySellRegistOpen?before=search&f=search\";\r\n");
      out.write("\t\tff.submit(); \r\n");
      out.write("\t\treturn true;\r\n");
      out.write("\t}\t\r\n");
      out.write("\tfunction storePageSize(ff) {\r\n");
      out.write("\t\tff.action=\"BuySellList?re=9\";\r\n");
      out.write("\t\tff.submit(); \r\n");
      out.write("\t\treturn true;\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction changeView(obj) {\r\n");
      out.write("\t\tdocument.list.action=\"BuySellList?re=9&list_view=\"+obj;\r\n");
      out.write("\t\tdocument.list.submit(); \r\n");
      out.write("\t\treturn true;\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\tfunction reloadPage(obj) {\r\n");
      out.write("\t\tdocument.list.action=\"BuySellList?pageNum=\"+obj;\r\n");
      out.write("\t\tdocument.list.submit(); \r\n");
      out.write("\t\treturn true;\r\n");
      out.write("\t}\t\r\n");
      out.write("\tfunction reloadCate_code_2(cate_code_1, cate_code_2) {\r\n");
      out.write("\t\tdocument.list.action=\"BuySellList?re=9&search_cate_code_1=\" + cate_code_1 + \"&search_cate_code_2=\" + cate_code_2;\r\n");
      out.write("\t\tdocument.list.submit(); \t\r\n");
      out.write("\t\treturn true;\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction searchStore(cate_code_1, cate_code_2) {\r\n");
      out.write("\t\tdocument.list.action=\"BuySellList?re=9&search_cate_code_1=\" + cate_code_1 + \"&search_cate_code_2=\" + cate_code_2;\r\n");
      out.write("\t\tdocument.list.submit(); \t\r\n");
      out.write("\t\treturn true;\r\n");
      out.write("\t}\t\r\n");
      out.write("\tfunction my_write(user_id) {\r\n");
      out.write("\t\tif(user_id == \"-\"){\r\n");
      out.write("\t\t\tdocument.list.action=\"BuySellList?re=9&user_id=-\";\r\n");
      out.write("\t\t} else if(user_id == \"_\"){\r\n");
      out.write("\t\t\tdocument.list.action=\"BuySellList?re=9&user_id=\";\r\n");
      out.write("\t\t} else {\r\n");
      out.write("\t\t\tdocument.list.action=\"BuySellList?re=9&user_id=\" + user_id;\r\n");
      out.write("\t\t}\t\r\n");
      out.write("\t\tdocument.list.submit(); \r\n");
      out.write("\t\treturn true;\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction openDetailPage(id) {\r\n");
      out.write("\r\n");
      out.write("\t\tdocument.list.action=\"BuySellDetail?before=search&id=\" + id;\r\n");
      out.write("\t\tdocument.list.submit(); \r\n");
      out.write("\t\treturn true;\r\n");
      out.write("\t}\r\n");
      out.write("\t/* POPUPメニューオープン時必要な値を設定*/\r\n");
      out.write("\tfunction popupMenuOpen(userid, id, name) {\t\t\t\r\n");
      out.write("\t\tclickedUserid = userid;\r\n");
      out.write("\t\tclickedId = id;\r\n");
      out.write("\t\tclickedName = name;\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction makewriteLook() {\r\n");
      out.write("\t\tdocument.list.action=\"BuySellList?re=9&user_id=\" + clickedUserid;\r\n");
      out.write("\t\tdocument.list.submit(); \r\n");
      out.write("\t\treturn true;\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\tfunction mailOpenAction() {\r\n");
      out.write("\t\tmailOpen(clickedId, clickedName, '1');\r\n");
      out.write("\t\treturn true;\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body style=\"margin:0 0 0 0\"> \r\n");
      out.write("\t<table>\r\n");
      out.write("\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "../include/top.jsp", out, true);
      out.write("\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td height=\"20\">&nbsp;</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("  \t<tr>\r\n");
      out.write("\t\t<td>\r\n");
      out.write("\t\t\t<form name=\"list\" method=\"post\" style=\"margin:0\">\r\n");
      out.write("\t\t\t<input type=\"hidden\" id=\"msg\" name = \"msg\" value=\"");
      if (_jspx_meth_c_out_2(_jspx_page_context))
        return;
      out.write("\" /> \r\n");
      out.write("\t\t\t<input type=\"hidden\" name=\"user_id\" value=\"");
      out.print(buySellSearchBean.getUser_id());
      out.write("\">      \t\r\n");
      out.write("\t\t\t<input type=\"hidden\" name=\"before_cate_code_1\" value=\"");
      out.print(buySellSearchBean.getCate_code_1());
      out.write("\">\r\n");
      out.write("\t\t\t<input type=\"hidden\" name=\"before_cate_code_2\" value=\"");
      out.print(buySellSearchBean.getCate_code_2());
      out.write("\">       \t\t\t        \t\t\t      \t\t\t\r\n");
      out.write("\t\t\t<input type=\"hidden\" name=\"before_list_view\" value=\"");
      out.print(buySellSearchBean.getList_view());
      out.write("\">       \t\t\t        \t\t\t      \t\t\t \t\t\t\t\r\n");
      out.write("\t\t\t<input type=\"hidden\" name=\"before_pageSize\" value=\"");
      out.print(pageBean.getPageSize());
      out.write("\">       \t\t\t        \t\t\t      \t\t\t \t\t\t\t \t\t\t\t\r\n");
      out.write("\t\t\t<input type=\"hidden\" name=\"before_pageNum\" value=\"");
      out.print(buySellSearchBean.getPageNum());
      out.write("\">\r\n");
      out.write("\t\t\t<!--로그인 체크때문-->\r\n");
      out.write("\t\t\t");
      if (_jspx_meth_c_if_2(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t");
      if (_jspx_meth_c_if_3(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t<table width=\"950\"  border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\">\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td><img src=\"jsp/images/new/search_tit1.gif\" width=\"118\" height=\"24\" /></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td height=\"6\"></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t<table id=\"Table_\" width=\"950\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<!--물건사기-->\r\n");
      out.write("\t\t\t\t\t\t");
      if (_jspx_meth_c_if_4(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<!--물건팔기-->\r\n");
      out.write("\t\t\t\t\t\t");
      if (_jspx_meth_c_if_5(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t<table width=\"90%\"    border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"1\">\r\n");
      out.write("\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td width=\"17%\" height=\"35\" >&nbsp;</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<!--제1카테고리-->\r\n");
      out.write("\t\t\t\t\t\t\t\t<td width=\"83%\" rowspan=\"2\" >\r\n");
      out.write("\t\t\t\t\t\t\t\t\t");
      if (_jspx_meth_c_forEach_0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t<!--카테고리검색수-->\r\n");
      out.write("\t\t\t\t\t\t\t\t<td height=\"25\" class=\"search-num1\" >\r\n");
      out.write("\t\t\t\t\t\t\t\t\t");
      if (_jspx_meth_c_out_15(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t");
      if (_jspx_meth_c_out_16(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t");
      if (_jspx_meth_c_out_17(_jspx_page_context))
        return;
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t</table>\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td background=\"jsp/images/new/search_box_left.gif\" ><img src=\"jsp/images/new/search_box_left.gif\" width=\"20\" height=\"30\" alt=\"\" /></td>\r\n");
      out.write("\t\t\t\t\t\t<td width=\"910\" align=\"center\" valign=\"middle\" style=\"padding:10px 8px 8px 8px;\">\r\n");
      out.write("\t\t\t\t\t\t\t<!--검색-->\r\n");
      out.write("\t\t\t\t\t\t\t<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n");
      out.write("\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td width=\"89%\" align=\"left\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<select name=\"search_pro_status\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<option selected=\"selected\" value=\"0\" ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${BuySellSearchBean.pro_status_no_matter}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write(" >제품상태</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<option value=\"1\" ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${BuySellSearchBean.pro_status_used}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write(">중고</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<option value=\"2\" ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${BuySellSearchBean.pro_status_new}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write(">신제품</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<!--물건사기-->\r\n");
      out.write("\t\t\t\t\t\t\t\t\t");
      if (_jspx_meth_c_if_15(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<!--물건팔기-->\r\n");
      out.write("\t\t\t\t\t\t\t\t\t");
      if (_jspx_meth_c_if_16(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<select name=\"search_range\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<option selected=\"selected\" value=\"0\" ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${BuySellSearchBean.search_all}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write(">전체검색</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<option value=\"1\" ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${BuySellSearchBean.search_title}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write(">글제목</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<option value=\"2\" ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${BuySellSearchBean.search_name}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write(">등록자</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<option value=\"3\" ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${BuySellSearchBean.search_detail}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write(">상세정보</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<input maxlength=\"100\" name=\"search\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${BuySellSearchBean.search}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\" />\r\n");
      out.write("\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td width=\"11%\" align=\"right\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<a href=\"BuySellList?re=9&search_cate_code_1=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${BuySellSearchBean.cate_code_1}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\"><img src=\"jsp/images/new/search_return_b.gif\" width=\"94\" height=\"22\" /></a>\r\n");
      out.write("\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td height=\"10\" colspan=\"2\" align=\"center\"></td>\r\n");
      out.write("\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td height=\"1\" colspan=\"2\" align=\"center\" bgcolor=\"#CCCCCC\"></td>\r\n");
      out.write("\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td height=\"10\" colspan=\"2\" align=\"center\"></td>\r\n");
      out.write("\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td colspan=\"2\" align=\"center\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<a href=\"javascript:searchStore('");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${BuySellSearchBean.cate_code_1}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("', '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${BuySellSearchBean.cate_code_2}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("')\"><img src=\"jsp/images/new/search_b.gif\" width=\"107\" height=\"35\" /></a>\r\n");
      out.write("\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t</table>\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t<td background=\"jsp/images/new/search_box_right.gif\"><img src=\"jsp/images/new/search_box_right.gif\" width=\"20\" height=\"30\" alt=\"\" /></td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td colspan=\"3\"><img src=\"jsp/images/new/search_box_under.gif\" width=\"950\" height=\"14\" alt=\"\" /></td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t</table>\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td height=\"40\">&nbsp;</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t<table width=\"100%\" border=\"0\" cellspacing=\"1\" cellpadding=\"0\">\r\n");
      out.write("\t\t\t\t\t<!--물건사기-->\r\n");
      out.write("\t\t\t\t\t");
      //  c:if
      org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_17 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
      _jspx_th_c_if_17.setPageContext(_jspx_page_context);
      _jspx_th_c_if_17.setParent(null);
      _jspx_th_c_if_17.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${BuySellSearchBean.cate_code_1 == 'C10100'}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
      int _jspx_eval_c_if_17 = _jspx_th_c_if_17.doStartTag();
      if (_jspx_eval_c_if_17 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("\t\t\t\t\t\t<tr>\r\n");
          out.write("\t\t\t\t\t\t\t<td width=\"13%\">\r\n");
          out.write("\t\t\t\t\t\t\t\t");
          if (_jspx_meth_c_if_18(_jspx_th_c_if_17, _jspx_page_context))
            return;
          out.write("\t\r\n");
          out.write("\t\t\t\t\t\t\t\t");
          if (_jspx_meth_c_if_19(_jspx_th_c_if_17, _jspx_page_context))
            return;
          out.write("\t\r\n");
          out.write("\t\t\t\t\t\t\t</td>\r\n");
          out.write("\t\t\t\t\t\t\t<td width=\"59%\" align=\"right\" valign=\"bottom\">\r\n");
          out.write("\t\t\t\t\t\t\t\t<img src=\"jsp/images/new/board_icon1.gif\" align=\"absmiddle\" width=\"16\" height=\"17\" />중고 \r\n");
          out.write("\t\t\t\t\t\t\t\t<img src=\"jsp/images/new/board_icon2.gif\" align=\"absmiddle\" width=\"16\" height=\"17\" />신제품 \r\n");
          out.write("\t\t\t\t\t\t\t\t<img src=\"jsp/images/new/board_icon3.gif\" align=\"absmiddle\" width=\"29\" height=\"17\" />무료 \r\n");
          out.write("\t\t\t\t\t\t\t\t<img src=\"jsp/images/new/board_icon4.gif\"  align=\"absmiddle\" width=\"16\" height=\"17\" />직거래 \r\n");
          out.write("\t\t\t\t\t\t\t\t<img src=\"jsp/images/new/board_icon5.gif\"  align=\"absmiddle\" width=\"16\" height=\"17\" />택배</td>\r\n");
          out.write("\t\t\t\t\t\t\t<td width=\"28%\" align=\"right\">\r\n");
          out.write("\t\t\t\t\t\t\t\t<select name=\"pageSize\" id=\"pageSize\" onchange='return storePageSize(list)'>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t<option ");
if(pageBean.getPageSize() == 10){
          out.write(" selected ");
}
          out.write(" value=\"10\">10개씩보기</option>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t<option ");
if(pageBean.getPageSize() == 20){
          out.write(" selected ");
}
          out.write(" value=\"20\">20개씩보기</option>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t<option ");
if(pageBean.getPageSize() == 50){
          out.write(" selected ");
}
          out.write(" value=\"50\">50개씩보기</option>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t<option ");
if(pageBean.getPageSize() == 100){
          out.write(" selected ");
}
          out.write(" value=\"100\">100개씩보기</option>\r\n");
          out.write("\t\t\t\t\t\t\t\t</select>\r\n");
          out.write("\t\t\t\t\t\t\t\t<!--내글보기버튼 -->\r\n");
          out.write("\t\t\t\t\t\t\t\t");
          if (_jspx_meth_c_if_20(_jspx_th_c_if_17, _jspx_page_context))
            return;
          out.write("\t\r\n");
          out.write("\t\t\t\t\t\t\t\t");
          if (_jspx_meth_c_if_23(_jspx_th_c_if_17, _jspx_page_context))
            return;
          out.write("\t\r\n");
          out.write("\t\t\t\t\t\t\t\t<!--등록버튼 -->\r\n");
          out.write("\t\t\t\t\t\t\t\t<a href=\"javascript:registOpen(list);\"><img src=\"jsp/images/new/resigter_b.gif\" align=\"absmiddle\" width=\"58\" height=\"22\" /></a>\r\n");
          out.write("\t\t\t\t\t\t\t</td>\r\n");
          out.write("\t\t\t\t\t\t</tr>\r\n");
          out.write("\t\t\t\t\t\t<tr>\r\n");
          out.write("\t\t\t\t\t\t\t<td height=\"6\" colspan=\"3\"></td>\r\n");
          out.write("\t\t\t\t\t\t</tr>\r\n");
          out.write("\t\t\t\t\t");
          int evalDoAfterBody = _jspx_th_c_if_17.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_if_17.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_17);
        return;
      }
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_17);
      out.write("\r\n");
      out.write("\t\t\t\t\t<!--물건팔기-->\r\n");
      out.write("\t\t\t\t\t");
      //  c:if
      org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_24 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
      _jspx_th_c_if_24.setPageContext(_jspx_page_context);
      _jspx_th_c_if_24.setParent(null);
      _jspx_th_c_if_24.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${BuySellSearchBean.cate_code_1 == 'C10200'}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
      int _jspx_eval_c_if_24 = _jspx_th_c_if_24.doStartTag();
      if (_jspx_eval_c_if_24 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("\t\t\t\t\t\t<tr>\r\n");
          out.write("\t\t\t\t\t\t\t<td width=\"13%\">&nbsp;</td>\r\n");
          out.write("\t\t\t\t\t\t\t<td width=\"21%\">&nbsp;</td>\r\n");
          out.write("\t\t\t\t\t\t\t<td width=\"39%\" align=\"right\">\r\n");
          out.write("\t\t\t\t\t\t\t\t<select name=\"pageSize\" id=\"select2\" onchange='return storePageSize(list)'>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t<option ");
if(pageBean.getPageSize() == 10){
          out.write(" selected ");
}
          out.write(" value=\"10\">10개씩보기</option>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t<option ");
if(pageBean.getPageSize() == 20){
          out.write(" selected ");
}
          out.write(" value=\"20\">20개씩보기</option>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t<option ");
if(pageBean.getPageSize() == 50){
          out.write(" selected ");
}
          out.write(" value=\"50\">50개씩보기</option>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t<option ");
if(pageBean.getPageSize() == 100){
          out.write(" selected ");
}
          out.write(" value=\"100\">100개씩보기</option>\r\n");
          out.write("\t\t\t\t\t\t\t\t</select>\r\n");
          out.write("\t\t\t\t\t\t\t</td>\r\n");
          out.write("\t\t\t\t\t\t\t<td width=\"27%\" align=\"right\">\r\n");
          out.write("\t\t\t\t\t\t\t\t<!--이미지보기버튼 -->\r\n");
          out.write("\t\t\t\t\t\t\t\t");
          if (_jspx_meth_c_if_25(_jspx_th_c_if_24, _jspx_page_context))
            return;
          out.write("\r\n");
          out.write("\t\t\t\t\t\t\t\t<!--텍스트보기버튼 -->\r\n");
          out.write("\t\t\t\t\t\t\t\t");
          if (_jspx_meth_c_if_26(_jspx_th_c_if_24, _jspx_page_context))
            return;
          out.write("\t\r\n");
          out.write("\t\t\t\t\t\t\t\t<!--내글보기버튼 -->\r\n");
          out.write("\t\t\t\t\t\t\t\t");
          if (_jspx_meth_c_if_27(_jspx_th_c_if_24, _jspx_page_context))
            return;
          out.write("\t\r\n");
          out.write("\t\t\t\t\t\t\t\t");
          if (_jspx_meth_c_if_30(_jspx_th_c_if_24, _jspx_page_context))
            return;
          out.write("\t\r\n");
          out.write("\t\t\t\t\t\t\t\t<!--등록버튼 -->\r\n");
          out.write("\t\t\t\t\t\t\t\t<a href=\"javascript:registOpen(list);\"><img src=\"jsp/images/new/resigter_b.gif\" width=\"58\" height=\"22\" border=\"0\" align=\"absmiddle\" /></a>\r\n");
          out.write("\t\t\t\t\t\t\t</td>\r\n");
          out.write("\t\t\t\t\t\t</tr>\r\n");
          out.write("\t\t\t\t\t\t<tr>\r\n");
          out.write("\t\t\t\t\t\t\t<td>\r\n");
          out.write("\t\t\t\t\t\t\t\t");
          if (_jspx_meth_c_if_31(_jspx_th_c_if_24, _jspx_page_context))
            return;
          out.write("\t\r\n");
          out.write("\t\t\t\t\t\t\t\t");
          if (_jspx_meth_c_if_32(_jspx_th_c_if_24, _jspx_page_context))
            return;
          out.write("\t\r\n");
          out.write("\t\t\t\t\t\t\t</td>\r\n");
          out.write("\t\t\t\t\t\t\t<td width=\"21%\">&nbsp;</td>\r\n");
          out.write("\t\t\t\t\t\t\t<td colspan=\"2\" align=\"right\" valign=\"bottom\">\r\n");
          out.write("\t\t\t\t\t\t\t\t<img src=\"jsp/images/new/board_icon1.gif\" align=\"absmiddle\" width=\"16\" height=\"17\" />중고 \r\n");
          out.write("\t\t\t\t\t\t\t\t<img src=\"jsp/images/new/board_icon2.gif\" align=\"absmiddle\" width=\"16\" height=\"17\" />신제품 \r\n");
          out.write("\t\t\t\t\t\t\t\t<img src=\"jsp/images/new/board_icon3.gif\" align=\"absmiddle\" width=\"29\" height=\"17\" />무료 \r\n");
          out.write("\t\t\t\t\t\t\t\t<img src=\"jsp/images/new/board_icon4.gif\"  align=\"absmiddle\" width=\"16\" height=\"17\" />직거래 \r\n");
          out.write("\t\t\t\t\t\t\t\t<img src=\"jsp/images/new/board_icon5.gif\"  align=\"absmiddle\" width=\"16\" height=\"17\" />택배 \r\n");
          out.write("\t\t\t\t\t\t\t\t<img src=\"jsp/images/new/board_icon6.gif\" align=\"absmiddle\" width=\"16\" height=\"17\" />판매완료 \r\n");
          out.write("\t\t\t\t\t\t\t\t<img src=\"jsp/images/new/board_icon7.gif\" align=\"absmiddle\" width=\"16\" height=\"17\" />개인회원 \r\n");
          out.write("\t\t\t\t\t\t\t\t<img src=\"jsp/images/new/board_icon8.gif\" align=\"absmiddle\" width=\"16\" height=\"17\" />업자회원\r\n");
          out.write("\t\t\t\t\t\t\t</td>\r\n");
          out.write("          \t\t\t\t</tr>\r\n");
          out.write("\t\t\t\t\t\t<tr>\r\n");
          out.write("\t\t\t\t\t\t\t<td height=\"6\" colspan=\"4\"></td>\r\n");
          out.write("\t\t\t\t\t\t</tr>\r\n");
          out.write("\t\t\t\t\t");
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
      out.write("\r\n");
      out.write("\t\t\t\t\t</table>\t\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<!--물건사기-->\r\n");
      out.write("\t\t\t");
      if (_jspx_meth_c_if_33(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t<!--물건사기 END-->\r\n");
      out.write("\t\t\t<!--물건팔기 -->\r\n");
      out.write("\t\t\t");
      if (_jspx_meth_c_if_41(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t <tr>\r\n");
      out.write("        \t\t<td height=\"2\" align=\"center\" bgcolor=\"#CCCCCC\"></td>\r\n");
      out.write("      \t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td align=\"center\">&nbsp;</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<!--건수표시 -->\r\n");
      out.write("\t\t\t\t");
      if (_jspx_meth_c_if_68(_jspx_page_context))
        return;
      out.write("\t\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td align=\"center\">&nbsp;</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<!--페이지표시 -->\r\n");
      out.write("\t\t\t\t<td align=\"center\">\r\n");
      out.write("\t\t\t\t\t");
      if (_jspx_meth_myTags_pageHandle_0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t</table>\r\n");
      out.write("\t\t\t</form>\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td height=\"50\">&nbsp;</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "../include/footer.jsp", out, true);
      out.write("\r\n");
      out.write("\t</table>\r\n");
      out.write(" \t<div id = \"popup\" style = \"display:none\" class=\"popupMenu\">\r\n");
      out.write("\t\t<table>\r\n");
      out.write("\t\t\t<tr><td class=\"board-title-text\"><a href=\"javascript:makewriteLook();\">작성글보기</a></td></tr>\r\n");
      out.write("\t\t\t<tr><td class=\"board-title-text\"><a href=\"\" onclick=\"mailOpenAction(); return false;\">메일보내기</a></td></tr>\r\n");
      out.write("\t\t</table>\r\n");
      out.write("\t</div>\r\n");
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

  private boolean _jspx_meth_c_if_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_0.setPageContext(_jspx_page_context);
    _jspx_th_c_if_0.setParent(null);
    _jspx_th_c_if_0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${BuySellSearchBean.cate_code_1 == 'C10100'}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_if_0 = _jspx_th_c_if_0.doStartTag();
    if (_jspx_eval_c_if_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t<title>");
        if (_jspx_meth_c_out_0(_jspx_th_c_if_0, _jspx_page_context))
          return true;
        out.write("&nbsp;::&nbsp;");
        if (_jspx_meth_fmt_message_0(_jspx_th_c_if_0, _jspx_page_context))
          return true;
        out.write("</title>\r\n");
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

  private boolean _jspx_meth_c_out_0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_if_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_out_0 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _jspx_tagPool_c_out_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_out_0.setPageContext(_jspx_page_context);
    _jspx_th_c_out_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_0);
    _jspx_th_c_out_0.setValue(new String("물건사기"));
    int _jspx_eval_c_out_0 = _jspx_th_c_out_0.doStartTag();
    if (_jspx_th_c_out_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_0);
      return true;
    }
    _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_0);
    return false;
  }

  private boolean _jspx_meth_fmt_message_0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_if_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  fmt:message
    org.apache.taglibs.standard.tag.rt.fmt.MessageTag _jspx_th_fmt_message_0 = (org.apache.taglibs.standard.tag.rt.fmt.MessageTag) _jspx_tagPool_fmt_message_key_bundle_nobody.get(org.apache.taglibs.standard.tag.rt.fmt.MessageTag.class);
    _jspx_th_fmt_message_0.setPageContext(_jspx_page_context);
    _jspx_th_fmt_message_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_0);
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

  private boolean _jspx_meth_c_if_1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_1 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_1.setPageContext(_jspx_page_context);
    _jspx_th_c_if_1.setParent(null);
    _jspx_th_c_if_1.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${BuySellSearchBean.cate_code_1 == 'C10200'}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_if_1 = _jspx_th_c_if_1.doStartTag();
    if (_jspx_eval_c_if_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t<title>");
        if (_jspx_meth_c_out_1(_jspx_th_c_if_1, _jspx_page_context))
          return true;
        out.write("&nbsp;::&nbsp;");
        if (_jspx_meth_fmt_message_1(_jspx_th_c_if_1, _jspx_page_context))
          return true;
        out.write("</title>\r\n");
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

  private boolean _jspx_meth_c_out_1(javax.servlet.jsp.tagext.JspTag _jspx_th_c_if_1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_out_1 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _jspx_tagPool_c_out_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_out_1.setPageContext(_jspx_page_context);
    _jspx_th_c_out_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_1);
    _jspx_th_c_out_1.setValue(new String("물건팔기"));
    int _jspx_eval_c_out_1 = _jspx_th_c_out_1.doStartTag();
    if (_jspx_th_c_out_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_1);
      return true;
    }
    _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_1);
    return false;
  }

  private boolean _jspx_meth_fmt_message_1(javax.servlet.jsp.tagext.JspTag _jspx_th_c_if_1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  fmt:message
    org.apache.taglibs.standard.tag.rt.fmt.MessageTag _jspx_th_fmt_message_1 = (org.apache.taglibs.standard.tag.rt.fmt.MessageTag) _jspx_tagPool_fmt_message_key_bundle_nobody.get(org.apache.taglibs.standard.tag.rt.fmt.MessageTag.class);
    _jspx_th_fmt_message_1.setPageContext(_jspx_page_context);
    _jspx_th_fmt_message_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_1);
    _jspx_th_fmt_message_1.setKey("TITLE.title");
    _jspx_th_fmt_message_1.setBundle((javax.servlet.jsp.jstl.fmt.LocalizationContext) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${message}", javax.servlet.jsp.jstl.fmt.LocalizationContext.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_fmt_message_1 = _jspx_th_fmt_message_1.doStartTag();
    if (_jspx_th_fmt_message_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_fmt_message_key_bundle_nobody.reuse(_jspx_th_fmt_message_1);
      return true;
    }
    _jspx_tagPool_fmt_message_key_bundle_nobody.reuse(_jspx_th_fmt_message_1);
    return false;
  }

  private boolean _jspx_meth_fmt_message_2(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  fmt:message
    org.apache.taglibs.standard.tag.rt.fmt.MessageTag _jspx_th_fmt_message_2 = (org.apache.taglibs.standard.tag.rt.fmt.MessageTag) _jspx_tagPool_fmt_message_key_bundle_nobody.get(org.apache.taglibs.standard.tag.rt.fmt.MessageTag.class);
    _jspx_th_fmt_message_2.setPageContext(_jspx_page_context);
    _jspx_th_fmt_message_2.setParent(null);
    _jspx_th_fmt_message_2.setKey("WAR0004");
    _jspx_th_fmt_message_2.setBundle((javax.servlet.jsp.jstl.fmt.LocalizationContext) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${message}", javax.servlet.jsp.jstl.fmt.LocalizationContext.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_fmt_message_2 = _jspx_th_fmt_message_2.doStartTag();
    if (_jspx_th_fmt_message_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_fmt_message_key_bundle_nobody.reuse(_jspx_th_fmt_message_2);
      return true;
    }
    _jspx_tagPool_fmt_message_key_bundle_nobody.reuse(_jspx_th_fmt_message_2);
    return false;
  }

  private boolean _jspx_meth_c_out_2(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_out_2 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _jspx_tagPool_c_out_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_out_2.setPageContext(_jspx_page_context);
    _jspx_th_c_out_2.setParent(null);
    _jspx_th_c_out_2.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${Message}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_out_2 = _jspx_th_c_out_2.doStartTag();
    if (_jspx_th_c_out_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_2);
      return true;
    }
    _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_2);
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
    _jspx_th_c_if_2.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${!empty memberInfo}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_if_2 = _jspx_th_c_if_2.doStartTag();
    if (_jspx_eval_c_if_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t<input type=\"hidden\" id=\"loginSign\" value=\"true\">\r\n");
        out.write("\t\t\t");
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
    _jspx_th_c_if_3.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${empty memberInfo}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_if_3 = _jspx_th_c_if_3.doStartTag();
    if (_jspx_eval_c_if_3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t<input type=\"hidden\" id=\"loginSign\" value=\"false\">\r\n");
        out.write("\t\t\t");
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
        out.write("\t\t\t\t\t\t<td height=\"71\" colspan=\"3\" background=\"jsp/images/new/buy_box_tit.gif\">\r\n");
        out.write("\t\t\t\t\t\t");
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
        out.write("\t\t\t\t\t\t<td height=\"71\" colspan=\"3\" background=\"jsp/images/new/sell_box_tit.gif\">\r\n");
        out.write("\t\t\t\t\t\t");
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

  private boolean _jspx_meth_c_forEach_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_varStatus_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_0.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_0.setParent(null);
    _jspx_th_c_forEach_0.setVar("Category2");
    _jspx_th_c_forEach_0.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${Category2List}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    _jspx_th_c_forEach_0.setVarStatus("i");
    int[] _jspx_push_body_count_c_forEach_0 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_0 = _jspx_th_c_forEach_0.doStartTag();
      if (_jspx_eval_c_forEach_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t<!--선택된 카테고리의 경우 -->\r\n");
          out.write("          \t\t\t\t\t\t\t\t");
          if (_jspx_meth_c_if_6(_jspx_th_c_forEach_0, _jspx_page_context, _jspx_push_body_count_c_forEach_0))
            return true;
          out.write("\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t<!---선택되지않은 카테고리의 경우 -->\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t");
          if (_jspx_meth_c_if_10(_jspx_th_c_forEach_0, _jspx_page_context, _jspx_push_body_count_c_forEach_0))
            return true;
          out.write("\t\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t<!--화면에7건-->\t\t\t\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t");
          if (_jspx_meth_c_if_14(_jspx_th_c_forEach_0, _jspx_page_context, _jspx_push_body_count_c_forEach_0))
            return true;
          out.write("\r\n");
          out.write("        \t\t\t\t\t\t\t ");
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

  private boolean _jspx_meth_c_if_6(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_6 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_6.setPageContext(_jspx_page_context);
    _jspx_th_c_if_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_0);
    _jspx_th_c_if_6.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${BuySellSearchBean.cate_code_2 == Category2.cate_code_2}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_if_6 = _jspx_th_c_if_6.doStartTag();
    if (_jspx_eval_c_if_6 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t\t<span class=\"search-text2\" onclick=\"return reloadCate_code_2('");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${BuySellSearchBean.cate_code_1}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
        out.write("', '");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${Category2.cate_code_2}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
        out.write("')\"> \r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t\t\t<!--카테고리명  검색건수 표시-->\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t\t\t");
        if (_jspx_meth_c_out_3(_jspx_th_c_if_6, _jspx_page_context, _jspx_push_body_count_c_forEach_0))
          return true;
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t\t\t");
        if (_jspx_meth_c_out_4(_jspx_th_c_if_6, _jspx_page_context, _jspx_push_body_count_c_forEach_0))
          return true;
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t\t\t");
        if (_jspx_meth_c_if_7(_jspx_th_c_if_6, _jspx_page_context, _jspx_push_body_count_c_forEach_0))
          return true;
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t\t\t");
        if (_jspx_meth_c_if_8(_jspx_th_c_if_6, _jspx_page_context, _jspx_push_body_count_c_forEach_0))
          return true;
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t\t\t");
        if (_jspx_meth_c_out_7(_jspx_th_c_if_6, _jspx_page_context, _jspx_push_body_count_c_forEach_0))
          return true;
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t\t</span>\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t\t<!--카테고리1이 마지막이 아닐경우 | 표시를 붙힌다-->\t\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t\t");
        if (_jspx_meth_c_if_9(_jspx_th_c_if_6, _jspx_page_context, _jspx_push_body_count_c_forEach_0))
          return true;
        out.write("\t\t\t\t\t\t\t\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t");
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

  private boolean _jspx_meth_c_out_3(javax.servlet.jsp.tagext.JspTag _jspx_th_c_if_6, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_out_3 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _jspx_tagPool_c_out_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_out_3.setPageContext(_jspx_page_context);
    _jspx_th_c_out_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_6);
    _jspx_th_c_out_3.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${Category2.cate_name_2}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_out_3 = _jspx_th_c_out_3.doStartTag();
    if (_jspx_th_c_out_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_3);
      return true;
    }
    _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_3);
    return false;
  }

  private boolean _jspx_meth_c_out_4(javax.servlet.jsp.tagext.JspTag _jspx_th_c_if_6, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_out_4 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _jspx_tagPool_c_out_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_out_4.setPageContext(_jspx_page_context);
    _jspx_th_c_out_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_6);
    _jspx_th_c_out_4.setValue(new String("("));
    int _jspx_eval_c_out_4 = _jspx_th_c_out_4.doStartTag();
    if (_jspx_th_c_out_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_4);
      return true;
    }
    _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_4);
    return false;
  }

  private boolean _jspx_meth_c_if_7(javax.servlet.jsp.tagext.JspTag _jspx_th_c_if_6, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_7 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_7.setPageContext(_jspx_page_context);
    _jspx_th_c_if_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_6);
    _jspx_th_c_if_7.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${empty Category2Count[Category2['cate_code_2']]}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_if_7 = _jspx_th_c_if_7.doStartTag();
    if (_jspx_eval_c_if_7 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t");
        if (_jspx_meth_c_out_5(_jspx_th_c_if_7, _jspx_page_context, _jspx_push_body_count_c_forEach_0))
          return true;
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t\t\t");
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

  private boolean _jspx_meth_c_out_5(javax.servlet.jsp.tagext.JspTag _jspx_th_c_if_7, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_out_5 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _jspx_tagPool_c_out_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_out_5.setPageContext(_jspx_page_context);
    _jspx_th_c_out_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_7);
    _jspx_th_c_out_5.setValue(new String("0"));
    int _jspx_eval_c_out_5 = _jspx_th_c_out_5.doStartTag();
    if (_jspx_th_c_out_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_5);
      return true;
    }
    _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_5);
    return false;
  }

  private boolean _jspx_meth_c_if_8(javax.servlet.jsp.tagext.JspTag _jspx_th_c_if_6, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_8 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_8.setPageContext(_jspx_page_context);
    _jspx_th_c_if_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_6);
    _jspx_th_c_if_8.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${!empty Category2Count[Category2['cate_code_2']]}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_if_8 = _jspx_th_c_if_8.doStartTag();
    if (_jspx_eval_c_if_8 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t");
        if (_jspx_meth_c_out_6(_jspx_th_c_if_8, _jspx_page_context, _jspx_push_body_count_c_forEach_0))
          return true;
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t\t\t");
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

  private boolean _jspx_meth_c_out_6(javax.servlet.jsp.tagext.JspTag _jspx_th_c_if_8, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_out_6 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _jspx_tagPool_c_out_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_out_6.setPageContext(_jspx_page_context);
    _jspx_th_c_out_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_8);
    _jspx_th_c_out_6.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${Category2Count[Category2['cate_code_2']]}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_out_6 = _jspx_th_c_out_6.doStartTag();
    if (_jspx_th_c_out_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_6);
      return true;
    }
    _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_6);
    return false;
  }

  private boolean _jspx_meth_c_out_7(javax.servlet.jsp.tagext.JspTag _jspx_th_c_if_6, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_out_7 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _jspx_tagPool_c_out_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_out_7.setPageContext(_jspx_page_context);
    _jspx_th_c_out_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_6);
    _jspx_th_c_out_7.setValue(new String(")"));
    int _jspx_eval_c_out_7 = _jspx_th_c_out_7.doStartTag();
    if (_jspx_th_c_out_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_7);
      return true;
    }
    _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_7);
    return false;
  }

  private boolean _jspx_meth_c_if_9(javax.servlet.jsp.tagext.JspTag _jspx_th_c_if_6, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_9 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_9.setPageContext(_jspx_page_context);
    _jspx_th_c_if_9.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_6);
    _jspx_th_c_if_9.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${!i.last}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_if_9 = _jspx_th_c_if_9.doStartTag();
    if (_jspx_eval_c_if_9 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t\t\t");
        if (_jspx_meth_c_out_8(_jspx_th_c_if_9, _jspx_page_context, _jspx_push_body_count_c_forEach_0))
          return true;
        out.write("  \r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t\t");
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

  private boolean _jspx_meth_c_out_8(javax.servlet.jsp.tagext.JspTag _jspx_th_c_if_9, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_out_8 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _jspx_tagPool_c_out_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_out_8.setPageContext(_jspx_page_context);
    _jspx_th_c_out_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_9);
    _jspx_th_c_out_8.setValue(new String("|"));
    int _jspx_eval_c_out_8 = _jspx_th_c_out_8.doStartTag();
    if (_jspx_th_c_out_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_8);
      return true;
    }
    _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_8);
    return false;
  }

  private boolean _jspx_meth_c_if_10(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_10 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_10.setPageContext(_jspx_page_context);
    _jspx_th_c_if_10.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_0);
    _jspx_th_c_if_10.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${BuySellSearchBean.cate_code_2 != Category2.cate_code_2}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_if_10 = _jspx_th_c_if_10.doStartTag();
    if (_jspx_eval_c_if_10 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t\t<a href=\"javascript:reloadCate_code_2('");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${BuySellSearchBean.cate_code_1}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
        out.write("', '");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${Category2.cate_code_2}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
        out.write("')\" class=\"search-link1\">\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t\t\t<!--카테고리명  검색건수 표시-->\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t\t\t");
        if (_jspx_meth_c_out_9(_jspx_th_c_if_10, _jspx_page_context, _jspx_push_body_count_c_forEach_0))
          return true;
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t\t\t");
        if (_jspx_meth_c_out_10(_jspx_th_c_if_10, _jspx_page_context, _jspx_push_body_count_c_forEach_0))
          return true;
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t");
        if (_jspx_meth_c_if_11(_jspx_th_c_if_10, _jspx_page_context, _jspx_push_body_count_c_forEach_0))
          return true;
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t");
        if (_jspx_meth_c_if_12(_jspx_th_c_if_10, _jspx_page_context, _jspx_push_body_count_c_forEach_0))
          return true;
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t\t\t");
        if (_jspx_meth_c_out_13(_jspx_th_c_if_10, _jspx_page_context, _jspx_push_body_count_c_forEach_0))
          return true;
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t\t</a>\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t<!--카테고리1이 마지막이 아닐경우 | 표시를 붙힌다-->\t\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t");
        if (_jspx_meth_c_if_13(_jspx_th_c_if_10, _jspx_page_context, _jspx_push_body_count_c_forEach_0))
          return true;
        out.write("\t\t\t\t\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t");
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

  private boolean _jspx_meth_c_out_9(javax.servlet.jsp.tagext.JspTag _jspx_th_c_if_10, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_out_9 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _jspx_tagPool_c_out_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_out_9.setPageContext(_jspx_page_context);
    _jspx_th_c_out_9.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_10);
    _jspx_th_c_out_9.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${Category2.cate_name_2}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_out_9 = _jspx_th_c_out_9.doStartTag();
    if (_jspx_th_c_out_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_9);
      return true;
    }
    _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_9);
    return false;
  }

  private boolean _jspx_meth_c_out_10(javax.servlet.jsp.tagext.JspTag _jspx_th_c_if_10, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_out_10 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _jspx_tagPool_c_out_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_out_10.setPageContext(_jspx_page_context);
    _jspx_th_c_out_10.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_10);
    _jspx_th_c_out_10.setValue(new String("("));
    int _jspx_eval_c_out_10 = _jspx_th_c_out_10.doStartTag();
    if (_jspx_th_c_out_10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_10);
      return true;
    }
    _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_10);
    return false;
  }

  private boolean _jspx_meth_c_if_11(javax.servlet.jsp.tagext.JspTag _jspx_th_c_if_10, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_11 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_11.setPageContext(_jspx_page_context);
    _jspx_th_c_if_11.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_10);
    _jspx_th_c_if_11.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${empty Category2Count[Category2['cate_code_2']]}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_if_11 = _jspx_th_c_if_11.doStartTag();
    if (_jspx_eval_c_if_11 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t");
        if (_jspx_meth_c_out_11(_jspx_th_c_if_11, _jspx_page_context, _jspx_push_body_count_c_forEach_0))
          return true;
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t");
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

  private boolean _jspx_meth_c_out_11(javax.servlet.jsp.tagext.JspTag _jspx_th_c_if_11, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_out_11 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _jspx_tagPool_c_out_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_out_11.setPageContext(_jspx_page_context);
    _jspx_th_c_out_11.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_11);
    _jspx_th_c_out_11.setValue(new String("0"));
    int _jspx_eval_c_out_11 = _jspx_th_c_out_11.doStartTag();
    if (_jspx_th_c_out_11.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_11);
      return true;
    }
    _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_11);
    return false;
  }

  private boolean _jspx_meth_c_if_12(javax.servlet.jsp.tagext.JspTag _jspx_th_c_if_10, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_12 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_12.setPageContext(_jspx_page_context);
    _jspx_th_c_if_12.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_10);
    _jspx_th_c_if_12.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${!empty Category2Count[Category2['cate_code_2']]}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_if_12 = _jspx_th_c_if_12.doStartTag();
    if (_jspx_eval_c_if_12 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t");
        if (_jspx_meth_c_out_12(_jspx_th_c_if_12, _jspx_page_context, _jspx_push_body_count_c_forEach_0))
          return true;
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t");
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

  private boolean _jspx_meth_c_out_12(javax.servlet.jsp.tagext.JspTag _jspx_th_c_if_12, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_out_12 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _jspx_tagPool_c_out_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_out_12.setPageContext(_jspx_page_context);
    _jspx_th_c_out_12.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_12);
    _jspx_th_c_out_12.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${Category2Count[Category2['cate_code_2']]}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_out_12 = _jspx_th_c_out_12.doStartTag();
    if (_jspx_th_c_out_12.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_12);
      return true;
    }
    _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_12);
    return false;
  }

  private boolean _jspx_meth_c_out_13(javax.servlet.jsp.tagext.JspTag _jspx_th_c_if_10, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_out_13 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _jspx_tagPool_c_out_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_out_13.setPageContext(_jspx_page_context);
    _jspx_th_c_out_13.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_10);
    _jspx_th_c_out_13.setValue(new String(")"));
    int _jspx_eval_c_out_13 = _jspx_th_c_out_13.doStartTag();
    if (_jspx_th_c_out_13.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_13);
      return true;
    }
    _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_13);
    return false;
  }

  private boolean _jspx_meth_c_if_13(javax.servlet.jsp.tagext.JspTag _jspx_th_c_if_10, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_13 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_13.setPageContext(_jspx_page_context);
    _jspx_th_c_if_13.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_10);
    _jspx_th_c_if_13.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${!i.last}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_if_13 = _jspx_th_c_if_13.doStartTag();
    if (_jspx_eval_c_if_13 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t\t");
        if (_jspx_meth_c_out_14(_jspx_th_c_if_13, _jspx_page_context, _jspx_push_body_count_c_forEach_0))
          return true;
        out.write("  \r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t");
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

  private boolean _jspx_meth_c_out_14(javax.servlet.jsp.tagext.JspTag _jspx_th_c_if_13, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_out_14 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _jspx_tagPool_c_out_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_out_14.setPageContext(_jspx_page_context);
    _jspx_th_c_out_14.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_13);
    _jspx_th_c_out_14.setValue(new String("|"));
    int _jspx_eval_c_out_14 = _jspx_th_c_out_14.doStartTag();
    if (_jspx_th_c_out_14.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_14);
      return true;
    }
    _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_14);
    return false;
  }

  private boolean _jspx_meth_c_if_14(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_14 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_14.setPageContext(_jspx_page_context);
    _jspx_th_c_if_14.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_0);
    _jspx_th_c_if_14.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${(i.index + 1) % 6 == 0}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_if_14 = _jspx_th_c_if_14.doStartTag();
    if (_jspx_eval_c_if_14 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t\t<br>\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t");
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

  private boolean _jspx_meth_c_out_15(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_out_15 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _jspx_tagPool_c_out_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_out_15.setPageContext(_jspx_page_context);
    _jspx_th_c_out_15.setParent(null);
    _jspx_th_c_out_15.setValue(new String("("));
    int _jspx_eval_c_out_15 = _jspx_th_c_out_15.doStartTag();
    if (_jspx_th_c_out_15.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_15);
      return true;
    }
    _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_15);
    return false;
  }

  private boolean _jspx_meth_c_out_16(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_out_16 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _jspx_tagPool_c_out_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_out_16.setPageContext(_jspx_page_context);
    _jspx_th_c_out_16.setParent(null);
    _jspx_th_c_out_16.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${Category2Count['categoryTotalCount']}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_out_16 = _jspx_th_c_out_16.doStartTag();
    if (_jspx_th_c_out_16.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_16);
      return true;
    }
    _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_16);
    return false;
  }

  private boolean _jspx_meth_c_out_17(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_out_17 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _jspx_tagPool_c_out_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_out_17.setPageContext(_jspx_page_context);
    _jspx_th_c_out_17.setParent(null);
    _jspx_th_c_out_17.setValue(new String(")"));
    int _jspx_eval_c_out_17 = _jspx_th_c_out_17.doStartTag();
    if (_jspx_th_c_out_17.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_17);
      return true;
    }
    _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_17);
    return false;
  }

  private boolean _jspx_meth_c_if_15(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_15 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_15.setPageContext(_jspx_page_context);
    _jspx_th_c_if_15.setParent(null);
    _jspx_th_c_if_15.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${BuySellSearchBean.cate_code_1 == 'C10100'}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_if_15 = _jspx_th_c_if_15.doStartTag();
    if (_jspx_eval_c_if_15 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t<select name=\"search_send_method\">\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t\t<option selected=\"selected\" value=\"0\" ");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${BuySellSearchBean.send_no_matter}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
        out.write(">배송방식</option>\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t\t<option value=\"1\" ");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${BuySellSearchBean.send_direct}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
        out.write(">직거래</option>\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t\t<option value=\"2\" ");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${BuySellSearchBean.send_post}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
        out.write(">택배</option>\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t</select>\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t\r\n");
        out.write("\t\t\t\t\t\t\t\t\t");
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

  private boolean _jspx_meth_c_if_16(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_16 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_16.setPageContext(_jspx_page_context);
    _jspx_th_c_if_16.setParent(null);
    _jspx_th_c_if_16.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${BuySellSearchBean.cate_code_1 == 'C10200'}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_if_16 = _jspx_th_c_if_16.doStartTag();
    if (_jspx_eval_c_if_16 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\t\t\t\t\t\t\t\t\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t<select name=\"search_member_sort\">\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t\t<option selected=\"selected\" value=\"0\" ");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${BuySellSearchBean.member_no_matter}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
        out.write(">판매자구분</option>\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t\t<option value=\"1\" ");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${BuySellSearchBean.member_ama}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
        out.write(">개인회원</option>\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t\t<option value=\"2\" ");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${BuySellSearchBean.member_pro}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
        out.write(">업자회원</option>\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t</select>\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t<select name=\"search_free_price\">\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t\t<option selected=\"selected\" value=\"0\" ");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${BuySellSearchBean.price_no_matter}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
        out.write(">무료여부</option>\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t\t<option value=\"1\" ");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${BuySellSearchBean.price_free_price}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
        out.write(">무료</option>\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t</select>\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t<select name=\"search_send_method\">\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t\t<option selected=\"selected\" value=\"0\" ");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${BuySellSearchBean.send_no_matter}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
        out.write(">배송방식</option>\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t\t<option value=\"1\" ");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${BuySellSearchBean.send_direct}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
        out.write(">직거래</option>\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t\t<option value=\"2\" ");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${BuySellSearchBean.send_post}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
        out.write(">택배</option>\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t</select>&nbsp;&nbsp;&nbsp;\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t<input type=\"checkbox\" name=\"search_sold_out\" ");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${BuySellSearchBean.sold_out_checked}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
        out.write(" />판매완료&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\r\n");
        out.write("\t\t\t\t\t\t\t\t\t");
        int evalDoAfterBody = _jspx_th_c_if_16.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_16.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_16);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_16);
    return false;
  }

  private boolean _jspx_meth_c_if_18(javax.servlet.jsp.tagext.JspTag _jspx_th_c_if_17, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_18 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_18.setPageContext(_jspx_page_context);
    _jspx_th_c_if_18.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_17);
    _jspx_th_c_if_18.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${empty BuySellSearchBean.user_id}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_if_18 = _jspx_th_c_if_18.doStartTag();
    if (_jspx_eval_c_if_18 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t\t\t<img src=\"jsp/images/new/search_tit2.gif\" width=\"118\" height=\"23\" />\r\n");
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

  private boolean _jspx_meth_c_if_19(javax.servlet.jsp.tagext.JspTag _jspx_th_c_if_17, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_19 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_19.setPageContext(_jspx_page_context);
    _jspx_th_c_if_19.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_17);
    _jspx_th_c_if_19.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${!empty BuySellSearchBean.user_id}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_if_19 = _jspx_th_c_if_19.doStartTag();
    if (_jspx_eval_c_if_19 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t\t\t<img src=\"jsp/images/new/mywrite_title.gif\" width=\"118\" height=\"23\" />\r\n");
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

  private boolean _jspx_meth_c_if_20(javax.servlet.jsp.tagext.JspTag _jspx_th_c_if_17, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_20 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_20.setPageContext(_jspx_page_context);
    _jspx_th_c_if_20.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_17);
    _jspx_th_c_if_20.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${empty BuySellSearchBean.user_id}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_if_20 = _jspx_th_c_if_20.doStartTag();
    if (_jspx_eval_c_if_20 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t\t\t<!--ID가 없으면 내글보기표시 -->\r\n");
        out.write("\t\t\t\t\t\t\t\t\t");
        if (_jspx_meth_c_if_21(_jspx_th_c_if_20, _jspx_page_context))
          return true;
        out.write("\t\r\n");
        out.write("\t\t\t              \t\t\t");
        if (_jspx_meth_c_if_22(_jspx_th_c_if_20, _jspx_page_context))
          return true;
        out.write("\t\r\n");
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

  private boolean _jspx_meth_c_if_21(javax.servlet.jsp.tagext.JspTag _jspx_th_c_if_20, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_21 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_21.setPageContext(_jspx_page_context);
    _jspx_th_c_if_21.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_20);
    _jspx_th_c_if_21.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${empty memberInfo.userid}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_if_21 = _jspx_th_c_if_21.doStartTag();
    if (_jspx_eval_c_if_21 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t              \t\t\t<a href=\"javascript:my_write('-');\"><img src=\"jsp/images/new/mywriting_b.gif\" align=\"absmiddle\" /></a>&nbsp;\r\n");
        out.write("\t\t\t              \t\t\t");
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

  private boolean _jspx_meth_c_if_22(javax.servlet.jsp.tagext.JspTag _jspx_th_c_if_20, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_22 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_22.setPageContext(_jspx_page_context);
    _jspx_th_c_if_22.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_20);
    _jspx_th_c_if_22.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${!empty memberInfo.userid}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_if_22 = _jspx_th_c_if_22.doStartTag();
    if (_jspx_eval_c_if_22 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t              \t\t\t<a href=\"javascript:my_write('");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${memberInfo.userid}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
        out.write("');\"><img src=\"jsp/images/new/mywriting_b.gif\" align=\"absmiddle\" /></a>&nbsp;\r\n");
        out.write("\t\t\t              \t\t\t");
        int evalDoAfterBody = _jspx_th_c_if_22.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_22.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_22);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_22);
    return false;
  }

  private boolean _jspx_meth_c_if_23(javax.servlet.jsp.tagext.JspTag _jspx_th_c_if_17, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_23 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_23.setPageContext(_jspx_page_context);
    _jspx_th_c_if_23.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_17);
    _jspx_th_c_if_23.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${!empty BuySellSearchBean.user_id}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_if_23 = _jspx_th_c_if_23.doStartTag();
    if (_jspx_eval_c_if_23 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t\t\t<!--ID가 있으면 목록표시 -->\r\n");
        out.write("\t\t\t\t\t\t\t\t \t<a href=\"javascript:my_write('_');\"><img src=\"jsp/images/new/btn_list.gif\" align=\"absmiddle\" /></a>\t\t\t\t\t\t\t\r\n");
        out.write("\t\t\t\t\t\t\t\t");
        int evalDoAfterBody = _jspx_th_c_if_23.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_23.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_23);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_23);
    return false;
  }

  private boolean _jspx_meth_c_if_25(javax.servlet.jsp.tagext.JspTag _jspx_th_c_if_24, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_25 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_25.setPageContext(_jspx_page_context);
    _jspx_th_c_if_25.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_24);
    _jspx_th_c_if_25.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${empty BuySellSearchBean.list_view or BuySellSearchBean.list_view == '0'}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_if_25 = _jspx_th_c_if_25.doStartTag();
    if (_jspx_eval_c_if_25 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t\t\t<a href=\"javascript:changeView(1);\"><img src=\"jsp/images/new/board_img_see.gif\" border=\"0\"  align=\"absmiddle\" /></a>&nbsp;\r\n");
        out.write("\t\t\t\t\t\t\t\t");
        int evalDoAfterBody = _jspx_th_c_if_25.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_25.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_25);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_25);
    return false;
  }

  private boolean _jspx_meth_c_if_26(javax.servlet.jsp.tagext.JspTag _jspx_th_c_if_24, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_26 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_26.setPageContext(_jspx_page_context);
    _jspx_th_c_if_26.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_24);
    _jspx_th_c_if_26.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${BuySellSearchBean.list_view == '1'}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_if_26 = _jspx_th_c_if_26.doStartTag();
    if (_jspx_eval_c_if_26 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t\t\t<a href=\"javascript:changeView(0);\"><img src=\"jsp/images/new/board_text_see.gif\" border=\"0\"  align=\"absmiddle\" /></a>&nbsp;\r\n");
        out.write("\t\t\t\t\t\t\t\t");
        int evalDoAfterBody = _jspx_th_c_if_26.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_26.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_26);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_26);
    return false;
  }

  private boolean _jspx_meth_c_if_27(javax.servlet.jsp.tagext.JspTag _jspx_th_c_if_24, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_27 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_27.setPageContext(_jspx_page_context);
    _jspx_th_c_if_27.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_24);
    _jspx_th_c_if_27.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${empty BuySellSearchBean.user_id}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_if_27 = _jspx_th_c_if_27.doStartTag();
    if (_jspx_eval_c_if_27 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t              \t\t\t<!--ID가 없으면 내글보기표시 -->\r\n");
        out.write("\t\t\t\t\t\t\t\t\t");
        if (_jspx_meth_c_if_28(_jspx_th_c_if_27, _jspx_page_context))
          return true;
        out.write("\t\r\n");
        out.write("\t\t\t              \t\t\t");
        if (_jspx_meth_c_if_29(_jspx_th_c_if_27, _jspx_page_context))
          return true;
        out.write("\t\r\n");
        out.write("\t\t\t\t\t\t\t\t");
        int evalDoAfterBody = _jspx_th_c_if_27.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_27.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_27);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_27);
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
    _jspx_th_c_if_28.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${empty memberInfo.userid}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_if_28 = _jspx_th_c_if_28.doStartTag();
    if (_jspx_eval_c_if_28 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t              \t\t\t<a href=\"javascript:my_write('-');\"><img src=\"jsp/images/new/mywriting_b.gif\" align=\"absmiddle\" /></a>&nbsp;\r\n");
        out.write("\t\t\t              \t\t\t");
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
    _jspx_th_c_if_29.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${!empty memberInfo.userid}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_if_29 = _jspx_th_c_if_29.doStartTag();
    if (_jspx_eval_c_if_29 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t              \t\t\t<a href=\"javascript:my_write('");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${memberInfo.userid}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
        out.write("');\"><img src=\"jsp/images/new/mywriting_b.gif\" align=\"absmiddle\" width=\"77\" height=\"22\" /></a>&nbsp;\r\n");
        out.write("\t\t\t              \t\t\t");
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

  private boolean _jspx_meth_c_if_30(javax.servlet.jsp.tagext.JspTag _jspx_th_c_if_24, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_30 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_30.setPageContext(_jspx_page_context);
    _jspx_th_c_if_30.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_24);
    _jspx_th_c_if_30.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${!empty BuySellSearchBean.user_id}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_if_30 = _jspx_th_c_if_30.doStartTag();
    if (_jspx_eval_c_if_30 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t\t\t<!--ID가 있으면 목록표시 -->\r\n");
        out.write("\t\t\t\t\t\t\t\t \t<a href=\"javascript:my_write('_');\"><img src=\"jsp/images/new/btn_list.gif\" align=\"absmiddle\" /></a>&nbsp;\t\t\t\t\t\t\r\n");
        out.write("\t\t\t\t\t\t\t\t");
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

  private boolean _jspx_meth_c_if_31(javax.servlet.jsp.tagext.JspTag _jspx_th_c_if_24, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_31 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_31.setPageContext(_jspx_page_context);
    _jspx_th_c_if_31.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_24);
    _jspx_th_c_if_31.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${empty BuySellSearchBean.user_id}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_if_31 = _jspx_th_c_if_31.doStartTag();
    if (_jspx_eval_c_if_31 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t\t\t<img src=\"jsp/images/new/search_tit2.gif\" width=\"118\" height=\"23\" />\r\n");
        out.write("\t\t\t\t\t\t\t\t");
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

  private boolean _jspx_meth_c_if_32(javax.servlet.jsp.tagext.JspTag _jspx_th_c_if_24, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_32 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_32.setPageContext(_jspx_page_context);
    _jspx_th_c_if_32.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_24);
    _jspx_th_c_if_32.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${!empty BuySellSearchBean.user_id}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_if_32 = _jspx_th_c_if_32.doStartTag();
    if (_jspx_eval_c_if_32 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t\t\t<img src=\"jsp/images/new/mywrite_title.gif\" width=\"118\" height=\"23\" />\r\n");
        out.write("\t\t\t\t\t\t\t\t");
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

  private boolean _jspx_meth_c_if_33(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_33 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_33.setPageContext(_jspx_page_context);
    _jspx_th_c_if_33.setParent(null);
    _jspx_th_c_if_33.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${BuySellSearchBean.cate_code_1 == 'C10100'}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_if_33 = _jspx_th_c_if_33.doStartTag();
    if (_jspx_eval_c_if_33 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t<tr>\r\n");
        out.write("\t\t\t\t<td>\r\n");
        out.write("\t\t\t\t\t<!--머릿글 -->\r\n");
        out.write("\t\t\t\t\t<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n");
        out.write("\t\t\t\t\t<tr>\r\n");
        out.write("\t\t\t\t\t\t<td height=\"41\" colspan=\"8\" background=\"jsp/images/new/board_list_top_bg.gif\" class=\"search-list-tit\">\r\n");
        out.write("\t\t\t\t\t\t\t<table width=\"100%\" border=\"0\" cellspacing=\"1\" cellpadding=\"0\">\r\n");
        out.write("\t\t\t\t\t\t\t<tr>\r\n");
        out.write("\t\t\t\t\t\t\t\t<td width=\"5%\" align=\"center\" class=\"board-title-text\">번호</td>\r\n");
        out.write("\t\t\t\t                <td width=\"34%\" align=\"center\" class=\"board-title-text\">글제목</td>\r\n");
        out.write("\t\t\t\t                <td width=\"8%\" align=\"center\" class=\"board-title-text\">가격</td>\r\n");
        out.write("\t\t\t\t                <td width=\"12%\" align=\"center\" class=\"board-title-text\">희망거래장소</td>\r\n");
        out.write("\t\t\t\t                <td width=\"11%\" align=\"center\" class=\"board-title-text\">제품상태<br />배송방식</td>\r\n");
        out.write("\t\t\t\t                <td width=\"10%\" align=\"center\" class=\"board-title-text\">등록일</td>\r\n");
        out.write("\t\t\t\t                <td width=\"12%\" align=\"center\" class=\"board-title-text\">등록자</td>\r\n");
        out.write("\t\t\t\t                <td width=\"8%\" align=\"center\" class=\"board-title-text\">조회수</td>\r\n");
        out.write("\t\t\t\t\t\t\t</tr>\r\n");
        out.write("\t\t\t\t\t\t\t</table>\t\r\n");
        out.write("\t\t\t\t\t\t</td>\r\n");
        out.write("\t\t\t\t\t</tr>\r\n");
        out.write("\t\t\t\t\t<!--내용표시 -->\r\n");
        out.write("\t\t\t\t\t");
        if (_jspx_meth_c_choose_0(_jspx_th_c_if_33, _jspx_page_context))
          return true;
        out.write("\t\r\n");
        out.write("\t\t\t\t\t</table>\r\n");
        out.write("\t\t\t\t</td>\r\n");
        out.write("\t\t\t</tr>\r\n");
        out.write("\t\t\t");
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

  private boolean _jspx_meth_c_choose_0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_if_33, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:choose
    org.apache.taglibs.standard.tag.common.core.ChooseTag _jspx_th_c_choose_0 = (org.apache.taglibs.standard.tag.common.core.ChooseTag) _jspx_tagPool_c_choose.get(org.apache.taglibs.standard.tag.common.core.ChooseTag.class);
    _jspx_th_c_choose_0.setPageContext(_jspx_page_context);
    _jspx_th_c_choose_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_33);
    int _jspx_eval_c_choose_0 = _jspx_th_c_choose_0.doStartTag();
    if (_jspx_eval_c_choose_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t\t\t");
        if (_jspx_meth_c_when_0(_jspx_th_c_choose_0, _jspx_page_context))
          return true;
        out.write("\r\n");
        out.write("\t\t\t\t\t\t");
        if (_jspx_meth_c_otherwise_0(_jspx_th_c_choose_0, _jspx_page_context))
          return true;
        out.write("\r\n");
        out.write("\t\t\t\t\t");
        int evalDoAfterBody = _jspx_th_c_choose_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_choose_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_choose.reuse(_jspx_th_c_choose_0);
      return true;
    }
    _jspx_tagPool_c_choose.reuse(_jspx_th_c_choose_0);
    return false;
  }

  private boolean _jspx_meth_c_when_0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_choose_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:when
    org.apache.taglibs.standard.tag.rt.core.WhenTag _jspx_th_c_when_0 = (org.apache.taglibs.standard.tag.rt.core.WhenTag) _jspx_tagPool_c_when_test.get(org.apache.taglibs.standard.tag.rt.core.WhenTag.class);
    _jspx_th_c_when_0.setPageContext(_jspx_page_context);
    _jspx_th_c_when_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_choose_0);
    _jspx_th_c_when_0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${!empty BuySellBeanList}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_when_0 = _jspx_th_c_when_0.doStartTag();
    if (_jspx_eval_c_when_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t");
        if (_jspx_meth_c_forEach_1(_jspx_th_c_when_0, _jspx_page_context))
          return true;
        out.write("\r\n");
        out.write("\t\t\t\t\t\t");
        int evalDoAfterBody = _jspx_th_c_when_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_when_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_when_test.reuse(_jspx_th_c_when_0);
      return true;
    }
    _jspx_tagPool_c_when_test.reuse(_jspx_th_c_when_0);
    return false;
  }

  private boolean _jspx_meth_c_forEach_1(javax.servlet.jsp.tagext.JspTag _jspx_th_c_when_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_1 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_varStatus_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_1.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_when_0);
    _jspx_th_c_forEach_1.setVar("BuySellBean");
    _jspx_th_c_forEach_1.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${BuySellBeanList}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    _jspx_th_c_forEach_1.setVarStatus("i");
    int[] _jspx_push_body_count_c_forEach_1 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_1 = _jspx_th_c_forEach_1.doStartTag();
      if (_jspx_eval_c_forEach_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("\t\t\t\t\t\t\t\t<tr>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t<!--번호-->\r\n");
          out.write("\t\t\t\t\t\t\t\t\t<td width=\"5%\" height=\"52\" align=\"center\">");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${BuySellBean.id}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("</td>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t<!--글제목-->\r\n");
          out.write("\t\t\t\t\t\t            <td width=\"34%\">\r\n");
          out.write("\t\t\t\t\t\t            \t<a href=\"javascript:openDetailPage('");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${BuySellBean.id}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("');\">");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${BuySellBean.title}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${util:getNewImage(BuySellBean.update_dateTime)}", java.lang.String.class, (PageContext)_jspx_page_context, _jspx_fnmap_0, false));
          out.write("</a>\r\n");
          out.write("\t\t\t\t\t\t            \t&nbsp;\r\n");
          out.write("\t\t\t\t\t\t            </td>\r\n");
          out.write("\t\t\t\t\t\t            <!--가격-->\r\n");
          out.write("\t\t\t\t\t\t            <td width=\"8%\" align=\"center\">\r\n");
          out.write("\t\t\t\t\t\t            \t");
          if (_jspx_meth_c_if_34(_jspx_th_c_forEach_1, _jspx_page_context, _jspx_push_body_count_c_forEach_1))
            return true;
          out.write("\r\n");
          out.write("\t\t\t\t\t\t            \t");
          if (_jspx_meth_c_if_35(_jspx_th_c_forEach_1, _jspx_page_context, _jspx_push_body_count_c_forEach_1))
            return true;
          out.write("\r\n");
          out.write("\t\t\t\t\t\t            \t&nbsp;\r\n");
          out.write("\t\t\t\t\t\t            </td>\r\n");
          out.write("\t\t\t\t\t\t            <!--희망거래장소-->\r\n");
          out.write("\t\t\t\t\t\t            <td width=\"12%\" align=\"center\">");
          if (_jspx_meth_c_out_19(_jspx_th_c_forEach_1, _jspx_page_context, _jspx_push_body_count_c_forEach_1))
            return true;
          out.write("&nbsp;</td>\r\n");
          out.write("\t\t\t\t\t\t            <!--제품상태/배송방식-->\r\n");
          out.write("\t\t\t\t\t\t            <td width=\"11%\" align=\"center\">\r\n");
          out.write("\t\t\t\t\t\t            \t<!--중고품-->\r\n");
          out.write("\t\t\t\t\t\t            \t");
          if (_jspx_meth_c_if_36(_jspx_th_c_forEach_1, _jspx_page_context, _jspx_push_body_count_c_forEach_1))
            return true;
          out.write("\r\n");
          out.write("\t\t\t\t\t\t            \t<!--신제품-->\r\n");
          out.write("\t\t\t\t\t\t            \t");
          if (_jspx_meth_c_if_37(_jspx_th_c_forEach_1, _jspx_page_context, _jspx_push_body_count_c_forEach_1))
            return true;
          out.write("\r\n");
          out.write("\t\t\t\t\t\t            \t<!--직거래/택배-->\r\n");
          out.write("\t\t\t\t\t\t            \t");
          if (_jspx_meth_c_if_38(_jspx_th_c_forEach_1, _jspx_page_context, _jspx_push_body_count_c_forEach_1))
            return true;
          out.write("\r\n");
          out.write("\t\t\t\t\t\t            \t<!--직거래-->\r\n");
          out.write("\t\t\t\t\t\t            \t");
          if (_jspx_meth_c_if_39(_jspx_th_c_forEach_1, _jspx_page_context, _jspx_push_body_count_c_forEach_1))
            return true;
          out.write("\r\n");
          out.write("\t\t\t\t\t\t            \t<!--택배-->\r\n");
          out.write("\t\t\t\t\t\t            \t");
          if (_jspx_meth_c_if_40(_jspx_th_c_forEach_1, _jspx_page_context, _jspx_push_body_count_c_forEach_1))
            return true;
          out.write("\r\n");
          out.write("\t\t\t\t\t\t            \t&nbsp;\r\n");
          out.write("\t\t\t\t\t\t            </td>\r\n");
          out.write("\t\t\t\t\t\t            <!--등록일-->\r\n");
          out.write("\t\t\t\t\t\t            <td width=\"10%\" align=\"center\">\r\n");
          out.write("\t\t\t\t\t\t            \t");
          if (_jspx_meth_c_out_20(_jspx_th_c_forEach_1, _jspx_page_context, _jspx_push_body_count_c_forEach_1))
            return true;
          out.write("\r\n");
          out.write("\t\t\t\t\t\t            \t&nbsp;\r\n");
          out.write("\t\t\t\t\t\t            </td>\r\n");
          out.write("\t\t\t\t\t\t            <!--등록자-->\r\n");
          out.write("\t\t\t\t\t\t            <td width=\"12%\" align=\"left\">\r\n");
          out.write("\t\t\t\t\t\t            \t<!--<a href=\"javascript:my_write('");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${BuySellBean.user_id}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("');\"><span style=\"text-decoration: underline\">");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${BuySellBean.user_name}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("</span>-->\r\n");
          out.write("\t\t\t\t\t\t            \t<span class=\"registUser\" id=\"link");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${i.index + 1}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("\" onclick=\"popupMenuOpen('");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${BuySellBean.user_id}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write('\'');
          out.write(',');
          out.write('\'');
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${BuySellBean.id}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write('\'');
          out.write(',');
          out.write('\'');
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${BuySellBean.user_name}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("')\">");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${BuySellBean.user_name}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("&nbsp;</span>\r\n");
          out.write("\t\t\t\t\t\t            \t&nbsp;\r\n");
          out.write("\t\t\t\t\t\t            </td>\r\n");
          out.write("\t\t\t\t\t\t             <!--조회수-->\r\n");
          out.write("\t\t\t\t\t\t            <td width=\"8%\" align=\"center\">\r\n");
          out.write("\t\t\t\t\t\t            \t");
          if (_jspx_meth_c_out_21(_jspx_th_c_forEach_1, _jspx_page_context, _jspx_push_body_count_c_forEach_1))
            return true;
          out.write("\r\n");
          out.write("\t\t\t\t\t\t            \t&nbsp;\r\n");
          out.write("\t\t\t\t\t\t            </td>\r\n");
          out.write("\t\t\t\t\t\t\t\t</tr>\r\n");
          out.write("\t\t\t\t\t\t\t\t<tr align=\"center\" bgcolor=\"#CCCCCC\">\r\n");
          out.write("\t\t\t\t\t\t\t\t\t<td height=\"1\" colspan=\"8\" ></td>\r\n");
          out.write("\t\t\t\t\t\t\t\t</tr>\r\n");
          out.write("\t\t\t\t\t\t\t");
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

  private boolean _jspx_meth_c_if_34(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_1, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_1)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_34 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_34.setPageContext(_jspx_page_context);
    _jspx_th_c_if_34.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_1);
    _jspx_th_c_if_34.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${BuySellBean.free_price == '1'}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_if_34 = _jspx_th_c_if_34.doStartTag();
    if (_jspx_eval_c_if_34 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t\t\t            \t\t<img src=\"jsp/images/new/board_icon3.gif\" align=\"middle\">\r\n");
        out.write("\t\t\t\t\t\t            \t");
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

  private boolean _jspx_meth_c_if_35(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_1, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_1)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_35 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_35.setPageContext(_jspx_page_context);
    _jspx_th_c_if_35.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_1);
    _jspx_th_c_if_35.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${BuySellBean.free_price != '1' and !empty BuySellBean.price}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_if_35 = _jspx_th_c_if_35.doStartTag();
    if (_jspx_eval_c_if_35 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t\t\t            \t\t");
        if (_jspx_meth_c_out_18(_jspx_th_c_if_35, _jspx_page_context, _jspx_push_body_count_c_forEach_1))
          return true;
        out.write("\r\n");
        out.write("\t\t\t\t\t\t            \t");
        int evalDoAfterBody = _jspx_th_c_if_35.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_35.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_35);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_35);
    return false;
  }

  private boolean _jspx_meth_c_out_18(javax.servlet.jsp.tagext.JspTag _jspx_th_c_if_35, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_1)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_out_18 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _jspx_tagPool_c_out_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_out_18.setPageContext(_jspx_page_context);
    _jspx_th_c_out_18.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_35);
    _jspx_th_c_out_18.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${BuySellBean.price}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_out_18 = _jspx_th_c_out_18.doStartTag();
    if (_jspx_th_c_out_18.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_18);
      return true;
    }
    _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_18);
    return false;
  }

  private boolean _jspx_meth_c_out_19(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_1, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_1)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_out_19 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _jspx_tagPool_c_out_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_out_19.setPageContext(_jspx_page_context);
    _jspx_th_c_out_19.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_1);
    _jspx_th_c_out_19.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${BuySellBean.sell_place}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_out_19 = _jspx_th_c_out_19.doStartTag();
    if (_jspx_th_c_out_19.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_19);
      return true;
    }
    _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_19);
    return false;
  }

  private boolean _jspx_meth_c_if_36(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_1, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_1)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_36 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_36.setPageContext(_jspx_page_context);
    _jspx_th_c_if_36.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_1);
    _jspx_th_c_if_36.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${BuySellBean.pro_status == '1'}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_if_36 = _jspx_th_c_if_36.doStartTag();
    if (_jspx_eval_c_if_36 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t\t\t            \t\t<img src=\"jsp/images/new/board_icon1.gif\" align=\"middle\">\r\n");
        out.write("\t\t\t\t\t\t            \t");
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

  private boolean _jspx_meth_c_if_37(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_1, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_1)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_37 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_37.setPageContext(_jspx_page_context);
    _jspx_th_c_if_37.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_1);
    _jspx_th_c_if_37.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${BuySellBean.pro_status == '2'}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_if_37 = _jspx_th_c_if_37.doStartTag();
    if (_jspx_eval_c_if_37 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t\t\t            \t\t<img src=\"jsp/images/new/board_icon2.gif\" align=\"middle\">\r\n");
        out.write("\t\t\t\t\t\t            \t");
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

  private boolean _jspx_meth_c_if_38(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_1, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_1)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_38 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_38.setPageContext(_jspx_page_context);
    _jspx_th_c_if_38.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_1);
    _jspx_th_c_if_38.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${BuySellBean.send_method == '0'}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_if_38 = _jspx_th_c_if_38.doStartTag();
    if (_jspx_eval_c_if_38 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t\t\t            \t\t<img src=\"jsp/images/new/board_icon4.gif\" align=\"middle\">\r\n");
        out.write("\t\t\t\t\t\t            \t\t<img src=\"jsp/images/new/board_icon5.gif\" align=\"middle\">\r\n");
        out.write("\t\t\t\t\t\t            \t");
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

  private boolean _jspx_meth_c_if_39(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_1, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_1)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_39 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_39.setPageContext(_jspx_page_context);
    _jspx_th_c_if_39.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_1);
    _jspx_th_c_if_39.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${BuySellBean.send_method == '1'}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_if_39 = _jspx_th_c_if_39.doStartTag();
    if (_jspx_eval_c_if_39 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t\t\t            \t\t<img src=\"jsp/images/new/board_icon4.gif\" align=\"middle\">\r\n");
        out.write("\t\t\t\t\t\t            \t");
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

  private boolean _jspx_meth_c_if_40(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_1, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_1)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_40 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_40.setPageContext(_jspx_page_context);
    _jspx_th_c_if_40.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_1);
    _jspx_th_c_if_40.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${BuySellBean.send_method == '2'}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_if_40 = _jspx_th_c_if_40.doStartTag();
    if (_jspx_eval_c_if_40 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t\t\t            \t\t<img src=\"jsp/images/new/board_icon5.gif\" align=\"middle\">\r\n");
        out.write("\t\t\t\t\t\t            \t");
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

  private boolean _jspx_meth_c_out_20(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_1, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_1)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_out_20 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _jspx_tagPool_c_out_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_out_20.setPageContext(_jspx_page_context);
    _jspx_th_c_out_20.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_1);
    _jspx_th_c_out_20.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${BuySellBean.update_date}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_out_20 = _jspx_th_c_out_20.doStartTag();
    if (_jspx_th_c_out_20.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_20);
      return true;
    }
    _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_20);
    return false;
  }

  private boolean _jspx_meth_c_out_21(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_1, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_1)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_out_21 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _jspx_tagPool_c_out_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_out_21.setPageContext(_jspx_page_context);
    _jspx_th_c_out_21.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_1);
    _jspx_th_c_out_21.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${BuySellBean.read_count}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_out_21 = _jspx_th_c_out_21.doStartTag();
    if (_jspx_th_c_out_21.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_21);
      return true;
    }
    _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_21);
    return false;
  }

  private boolean _jspx_meth_c_otherwise_0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_choose_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:otherwise
    org.apache.taglibs.standard.tag.common.core.OtherwiseTag _jspx_th_c_otherwise_0 = (org.apache.taglibs.standard.tag.common.core.OtherwiseTag) _jspx_tagPool_c_otherwise.get(org.apache.taglibs.standard.tag.common.core.OtherwiseTag.class);
    _jspx_th_c_otherwise_0.setPageContext(_jspx_page_context);
    _jspx_th_c_otherwise_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_choose_0);
    int _jspx_eval_c_otherwise_0 = _jspx_th_c_otherwise_0.doStartTag();
    if (_jspx_eval_c_otherwise_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t<tr>\r\n");
        out.write("\t\t\t\t\t\t\t\t<td width=\"100%\" align=\"center\">\r\n");
        out.write("\t\t\t\t\t\t\t\t");
        if (_jspx_meth_c_out_22(_jspx_th_c_otherwise_0, _jspx_page_context))
          return true;
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t\t</td>\r\n");
        out.write("\t\t\t\t\t\t\t</tr>\r\n");
        out.write("\t\t\t\t\t\t");
        int evalDoAfterBody = _jspx_th_c_otherwise_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_otherwise_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_otherwise.reuse(_jspx_th_c_otherwise_0);
      return true;
    }
    _jspx_tagPool_c_otherwise.reuse(_jspx_th_c_otherwise_0);
    return false;
  }

  private boolean _jspx_meth_c_out_22(javax.servlet.jsp.tagext.JspTag _jspx_th_c_otherwise_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_out_22 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _jspx_tagPool_c_out_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_out_22.setPageContext(_jspx_page_context);
    _jspx_th_c_out_22.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_otherwise_0);
    _jspx_th_c_out_22.setValue(new String("해당 검색 리스트가 없습니다."));
    int _jspx_eval_c_out_22 = _jspx_th_c_out_22.doStartTag();
    if (_jspx_th_c_out_22.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_22);
      return true;
    }
    _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_22);
    return false;
  }

  private boolean _jspx_meth_c_if_41(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_41 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_41.setPageContext(_jspx_page_context);
    _jspx_th_c_if_41.setParent(null);
    _jspx_th_c_if_41.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${BuySellSearchBean.cate_code_1 == 'C10200'}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_if_41 = _jspx_th_c_if_41.doStartTag();
    if (_jspx_eval_c_if_41 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t<!--텍스트보기-->\r\n");
        out.write("\t\t\t\t");
        if (_jspx_meth_c_if_42(_jspx_th_c_if_41, _jspx_page_context))
          return true;
        out.write("\r\n");
        out.write("\t\t\t\t<!--텍스트보기 END -->\r\n");
        out.write("\t\t\t\t<!--이미지 보기 -->\r\n");
        out.write("\t\t\t\t");
        if (_jspx_meth_c_if_54(_jspx_th_c_if_41, _jspx_page_context))
          return true;
        out.write("\r\n");
        out.write("\t\t\t");
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

  private boolean _jspx_meth_c_if_42(javax.servlet.jsp.tagext.JspTag _jspx_th_c_if_41, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_42 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_42.setPageContext(_jspx_page_context);
    _jspx_th_c_if_42.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_41);
    _jspx_th_c_if_42.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${empty BuySellSearchBean.list_view or BuySellSearchBean.list_view == '0'}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_if_42 = _jspx_th_c_if_42.doStartTag();
    if (_jspx_eval_c_if_42 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t<tr>\r\n");
        out.write("\t\t\t\t\t<td>\r\n");
        out.write("\t\t\t\t\t\t<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n");
        out.write("\t\t\t\t\t\t\t<tr>\r\n");
        out.write("\t\t\t\t\t\t\t\t<td height=\"41\" colspan=\"9\" background=\"jsp/images/new/board_list_top_bg.gif\" class=\"search-list-tit\">\r\n");
        out.write("\t\t\t\t\t\t\t\t\t<table width=\"100%\" border=\"0\" cellspacing=\"1\" cellpadding=\"0\">\r\n");
        out.write("\t\t\t\t\t\t\t\t\t<tr>\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t<td width=\"5%\" align=\"center\" class=\"board-title-text\">번호</td>\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t<td width=\"6%\" align=\"center\" class=\"board-title-text\">이미지</td>\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t<td width=\"28%\" align=\"center\" class=\"board-title-text\">글제목</td>\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t<td width=\"8%\" align=\"center\" class=\"board-title-text\">가격</td>\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t<td width=\"12%\" align=\"center\" class=\"board-title-text\"> 희망거래장소</td>\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t<td width=\"11%\" align=\"center\" class=\"board-title-text\">제품상태<br />배송방식</td>\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t<td width=\"10%\" align=\"center\" class=\"board-title-text\">등록일</td>\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t<td width=\"12%\" align=\"center\" class=\"board-title-text\">등록자</td>\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t<td width=\"8%\" align=\"center\" class=\"board-title-text\">조회수</td>\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t\r\n");
        out.write("\t\t\t\t\t\t\t\t\t</tr>\r\n");
        out.write("\t\t\t\t\t\t\t\t\t</table>\t\r\n");
        out.write("\t\t\t\t\t\t\t\t</td>\r\n");
        out.write("\t\t\t\t\t\t\t</tr>\r\n");
        out.write("\t\t\t\t\t\t\t<!--내용표시 -->\r\n");
        out.write("\t\t\t\t\t\t\t");
        if (_jspx_meth_c_choose_1(_jspx_th_c_if_42, _jspx_page_context))
          return true;
        out.write("\r\n");
        out.write("\t\t\t\t\t\t</table>\r\n");
        out.write("\t\t\t\t\t</td>\r\n");
        out.write("\t\t\t\t</tr>\r\n");
        out.write("\t\t\t\t");
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

  private boolean _jspx_meth_c_choose_1(javax.servlet.jsp.tagext.JspTag _jspx_th_c_if_42, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:choose
    org.apache.taglibs.standard.tag.common.core.ChooseTag _jspx_th_c_choose_1 = (org.apache.taglibs.standard.tag.common.core.ChooseTag) _jspx_tagPool_c_choose.get(org.apache.taglibs.standard.tag.common.core.ChooseTag.class);
    _jspx_th_c_choose_1.setPageContext(_jspx_page_context);
    _jspx_th_c_choose_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_42);
    int _jspx_eval_c_choose_1 = _jspx_th_c_choose_1.doStartTag();
    if (_jspx_eval_c_choose_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t\t");
        if (_jspx_meth_c_when_1(_jspx_th_c_choose_1, _jspx_page_context))
          return true;
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t\t");
        if (_jspx_meth_c_otherwise_1(_jspx_th_c_choose_1, _jspx_page_context))
          return true;
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t");
        int evalDoAfterBody = _jspx_th_c_choose_1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_choose_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_choose.reuse(_jspx_th_c_choose_1);
      return true;
    }
    _jspx_tagPool_c_choose.reuse(_jspx_th_c_choose_1);
    return false;
  }

  private boolean _jspx_meth_c_when_1(javax.servlet.jsp.tagext.JspTag _jspx_th_c_choose_1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:when
    org.apache.taglibs.standard.tag.rt.core.WhenTag _jspx_th_c_when_1 = (org.apache.taglibs.standard.tag.rt.core.WhenTag) _jspx_tagPool_c_when_test.get(org.apache.taglibs.standard.tag.rt.core.WhenTag.class);
    _jspx_th_c_when_1.setPageContext(_jspx_page_context);
    _jspx_th_c_when_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_choose_1);
    _jspx_th_c_when_1.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${!empty BuySellBeanList}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_when_1 = _jspx_th_c_when_1.doStartTag();
    if (_jspx_eval_c_when_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t\t");
        if (_jspx_meth_c_forEach_2(_jspx_th_c_when_1, _jspx_page_context))
          return true;
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t\t");
        int evalDoAfterBody = _jspx_th_c_when_1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_when_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_when_test.reuse(_jspx_th_c_when_1);
      return true;
    }
    _jspx_tagPool_c_when_test.reuse(_jspx_th_c_when_1);
    return false;
  }

  private boolean _jspx_meth_c_forEach_2(javax.servlet.jsp.tagext.JspTag _jspx_th_c_when_1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_2 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_varStatus_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_2.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_when_1);
    _jspx_th_c_forEach_2.setVar("BuySellBean");
    _jspx_th_c_forEach_2.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${BuySellBeanList}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    _jspx_th_c_forEach_2.setVarStatus("i");
    int[] _jspx_push_body_count_c_forEach_2 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_2 = _jspx_th_c_forEach_2.doStartTag();
      if (_jspx_eval_c_forEach_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("\t\t\t\t\t\t\t\t\t<tr>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t<!--번호-->\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t<td width=\"5%\" height=\"52\" align=\"center\">");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${BuySellBean.id}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("</td>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t<!--이미지-->\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t<td width=\"6%\" align=\"center\">\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t<a href=\"javascript:openDetailPage('");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${BuySellBean.id}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("');\"><img src=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${BuySellBean.thumbNail_path}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("\" /></a></td>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t<!--글제목-->\r\n");
          out.write("\t\t\t\t\t\t\t            <td width=\"28%\">\r\n");
          out.write("\t\t\t\t\t\t\t            \t<a href=\"javascript:openDetailPage('");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${BuySellBean.id}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("');\">");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${BuySellBean.title}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${util:getNewImage(BuySellBean.update_dateTime)}", java.lang.String.class, (PageContext)_jspx_page_context, _jspx_fnmap_0, false));
          out.write("</a>\r\n");
          out.write("\t\t\t\t\t\t\t            \t&nbsp;\r\n");
          out.write("\t\t\t\t\t\t\t            </td>\r\n");
          out.write("\t\t\t\t\t\t\t            <!--가격-->\r\n");
          out.write("\t\t\t\t\t\t\t            <td width=\"8%\" align=\"center\">\r\n");
          out.write("\t\t\t\t\t\t\t            \t<!--무료-->\r\n");
          out.write("\t\t\t\t\t\t\t            \t");
          if (_jspx_meth_c_if_43(_jspx_th_c_forEach_2, _jspx_page_context, _jspx_push_body_count_c_forEach_2))
            return true;
          out.write("\r\n");
          out.write("\t\t\t\t\t\t\t            \t");
          if (_jspx_meth_c_if_44(_jspx_th_c_forEach_2, _jspx_page_context, _jspx_push_body_count_c_forEach_2))
            return true;
          out.write("\r\n");
          out.write("\t\t\t\t\t\t\t            \t&nbsp;\r\n");
          out.write("\t\t\t\t\t\t\t            </td>\r\n");
          out.write("\t\t\t\t\t\t\t            <!--희망거래장소-->\r\n");
          out.write("\t\t\t\t\t\t\t            <td width=\"12%\" align=\"center\">");
          if (_jspx_meth_c_out_26(_jspx_th_c_forEach_2, _jspx_page_context, _jspx_push_body_count_c_forEach_2))
            return true;
          out.write("&nbsp;</td>\r\n");
          out.write("\t\t\t\t\t\t\t            <!--제품상태/배송방식-->\r\n");
          out.write("\t\t\t\t\t\t\t            <td width=\"11%\" align=\"center\">\r\n");
          out.write("\t\t\t\t\t\t\t            \t<!--중고품-->\r\n");
          out.write("\t\t\t\t\t\t\t            \t");
          if (_jspx_meth_c_if_47(_jspx_th_c_forEach_2, _jspx_page_context, _jspx_push_body_count_c_forEach_2))
            return true;
          out.write("\r\n");
          out.write("\t\t\t\t\t\t\t            \t<!--신제품-->\r\n");
          out.write("\t\t\t\t\t\t\t            \t");
          if (_jspx_meth_c_if_48(_jspx_th_c_forEach_2, _jspx_page_context, _jspx_push_body_count_c_forEach_2))
            return true;
          out.write("\r\n");
          out.write("\t\t\t\t\t\t\t            \t<!--직거래/택배-->\r\n");
          out.write("\t\t\t\t\t\t\t            \t");
          if (_jspx_meth_c_if_49(_jspx_th_c_forEach_2, _jspx_page_context, _jspx_push_body_count_c_forEach_2))
            return true;
          out.write("\r\n");
          out.write("\t\t\t\t\t\t\t            \t<!--직거래-->\r\n");
          out.write("\t\t\t\t\t\t\t            \t");
          if (_jspx_meth_c_if_50(_jspx_th_c_forEach_2, _jspx_page_context, _jspx_push_body_count_c_forEach_2))
            return true;
          out.write("\r\n");
          out.write("\t\t\t\t\t\t\t            \t<!--택배-->\r\n");
          out.write("\t\t\t\t\t\t\t            \t");
          if (_jspx_meth_c_if_51(_jspx_th_c_forEach_2, _jspx_page_context, _jspx_push_body_count_c_forEach_2))
            return true;
          out.write("\r\n");
          out.write("\t\t\t\t\t\t\t            \t&nbsp;\r\n");
          out.write("\t\t\t\t\t\t\t            </td>\r\n");
          out.write("\t\t\t\t\t\t\t            <!--등록일-->\r\n");
          out.write("\t\t\t\t\t\t\t            <td width=\"10%\" align=\"center\">\r\n");
          out.write("\t\t\t\t\t\t\t            \t");
          if (_jspx_meth_c_out_27(_jspx_th_c_forEach_2, _jspx_page_context, _jspx_push_body_count_c_forEach_2))
            return true;
          out.write("\r\n");
          out.write("\t\t\t\t\t\t\t            \t&nbsp;\r\n");
          out.write("\t\t\t\t\t\t\t            </td>\r\n");
          out.write("\t\t\t\t\t\t\t            <!--등록자-->\r\n");
          out.write("\t\t\t\t\t\t\t            <td width=\"12%\" align=\"left\">\r\n");
          out.write("\t\t\t\t\t\t\t            \t<!--<a href=\"javascript:my_write('");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${BuySellBean.user_id}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("');\"><span style=\"text-decoration: underline\">");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${BuySellBean.user_name}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("</span>-->\r\n");
          out.write("\t\t\t\t\t\t\t            \t<span class=\"registUser\" id=\"link");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${i.index + 1}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("\" onclick=\"popupMenuOpen('");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${BuySellBean.user_id}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write('\'');
          out.write(',');
          out.write('\'');
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${BuySellBean.id}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write('\'');
          out.write(',');
          out.write('\'');
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${BuySellBean.user_name}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("')\">");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${BuySellBean.user_name}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("&nbsp;</span>\r\n");
          out.write("\t\t\t\t\t\t\t            \t&nbsp;\r\n");
          out.write("\t\t\t\t\t\t\t            \t<!--개인-->\r\n");
          out.write("\t\t\t\t\t\t\t            \t");
          if (_jspx_meth_c_if_52(_jspx_th_c_forEach_2, _jspx_page_context, _jspx_push_body_count_c_forEach_2))
            return true;
          out.write("\r\n");
          out.write("\t\t\t\t\t\t\t            \t<!--업자-->\r\n");
          out.write("\t\t\t\t\t\t\t            \t");
          if (_jspx_meth_c_if_53(_jspx_th_c_forEach_2, _jspx_page_context, _jspx_push_body_count_c_forEach_2))
            return true;
          out.write("\r\n");
          out.write("\t\t\t\t\t\t\t            </td>\r\n");
          out.write("\t\t\t\t\t\t\t             <!--조회수-->\r\n");
          out.write("\t\t\t\t\t\t\t            <td width=\"8%\" align=\"center\">\r\n");
          out.write("\t\t\t\t\t\t\t            \t");
          if (_jspx_meth_c_out_28(_jspx_th_c_forEach_2, _jspx_page_context, _jspx_push_body_count_c_forEach_2))
            return true;
          out.write("\r\n");
          out.write("\t\t\t\t\t\t\t            \t&nbsp;\r\n");
          out.write("\t\t\t\t\t\t\t            </td>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t</tr>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t<tr align=\"center\" bgcolor=\"#CCCCCC\">\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t<td height=\"1\" colspan=\"9\" ></td>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t</tr>\r\n");
          out.write("\t\t\t\t\t\t\t\t");
          int evalDoAfterBody = _jspx_th_c_forEach_2.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_2[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_2.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_2.doFinally();
      _jspx_tagPool_c_forEach_varStatus_var_items.reuse(_jspx_th_c_forEach_2);
    }
    return false;
  }

  private boolean _jspx_meth_c_if_43(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_2, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_2)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_43 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_43.setPageContext(_jspx_page_context);
    _jspx_th_c_if_43.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_2);
    _jspx_th_c_if_43.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${BuySellBean.free_price == '1'}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_if_43 = _jspx_th_c_if_43.doStartTag();
    if (_jspx_eval_c_if_43 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t            \t\t<img src=\"jsp/images/new/board_icon3.gif\" align=\"middle\">\r\n");
        out.write("\t\t\t\t\t\t\t            \t");
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

  private boolean _jspx_meth_c_if_44(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_2, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_2)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_44 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_44.setPageContext(_jspx_page_context);
    _jspx_th_c_if_44.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_2);
    _jspx_th_c_if_44.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${BuySellBean.free_price != '1' and !empty BuySellBean.price}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_if_44 = _jspx_th_c_if_44.doStartTag();
    if (_jspx_eval_c_if_44 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t            \t\t");
        if (_jspx_meth_c_out_23(_jspx_th_c_if_44, _jspx_page_context, _jspx_push_body_count_c_forEach_2))
          return true;
        out.write("\r\n");
        out.write("\t\t\t\t\t\t            \t\t\t");
        if (_jspx_meth_c_if_45(_jspx_th_c_if_44, _jspx_page_context, _jspx_push_body_count_c_forEach_2))
          return true;
        out.write("\r\n");
        out.write("\t\t\t\t\t\t            \t\t\t");
        if (_jspx_meth_c_if_46(_jspx_th_c_if_44, _jspx_page_context, _jspx_push_body_count_c_forEach_2))
          return true;
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t            \t");
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

  private boolean _jspx_meth_c_out_23(javax.servlet.jsp.tagext.JspTag _jspx_th_c_if_44, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_2)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_out_23 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _jspx_tagPool_c_out_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_out_23.setPageContext(_jspx_page_context);
    _jspx_th_c_out_23.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_44);
    _jspx_th_c_out_23.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${BuySellBean.price}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_out_23 = _jspx_th_c_out_23.doStartTag();
    if (_jspx_th_c_out_23.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_23);
      return true;
    }
    _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_23);
    return false;
  }

  private boolean _jspx_meth_c_if_45(javax.servlet.jsp.tagext.JspTag _jspx_th_c_if_44, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_2)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_45 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_45.setPageContext(_jspx_page_context);
    _jspx_th_c_if_45.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_44);
    _jspx_th_c_if_45.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${empty BuySellBean.price_unit or BuySellBean.price_unit == '0'}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_if_45 = _jspx_th_c_if_45.doStartTag();
    if (_jspx_eval_c_if_45 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t\t\t            \t\t\t\t");
        if (_jspx_meth_c_out_24(_jspx_th_c_if_45, _jspx_page_context, _jspx_push_body_count_c_forEach_2))
          return true;
        out.write("\r\n");
        out.write("\t\t\t\t\t\t            \t\t\t");
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

  private boolean _jspx_meth_c_out_24(javax.servlet.jsp.tagext.JspTag _jspx_th_c_if_45, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_2)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_out_24 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _jspx_tagPool_c_out_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_out_24.setPageContext(_jspx_page_context);
    _jspx_th_c_out_24.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_45);
    _jspx_th_c_out_24.setValue(new String("엔"));
    int _jspx_eval_c_out_24 = _jspx_th_c_out_24.doStartTag();
    if (_jspx_th_c_out_24.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_24);
      return true;
    }
    _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_24);
    return false;
  }

  private boolean _jspx_meth_c_if_46(javax.servlet.jsp.tagext.JspTag _jspx_th_c_if_44, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_2)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_46 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_46.setPageContext(_jspx_page_context);
    _jspx_th_c_if_46.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_44);
    _jspx_th_c_if_46.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${!empty BuySellBean.price_unit and BuySellBean.price_unit == '1'}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_if_46 = _jspx_th_c_if_46.doStartTag();
    if (_jspx_eval_c_if_46 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t\t\t            \t\t\t\t");
        if (_jspx_meth_c_out_25(_jspx_th_c_if_46, _jspx_page_context, _jspx_push_body_count_c_forEach_2))
          return true;
        out.write("\r\n");
        out.write("\t\t\t\t\t\t            \t\t\t");
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

  private boolean _jspx_meth_c_out_25(javax.servlet.jsp.tagext.JspTag _jspx_th_c_if_46, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_2)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_out_25 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _jspx_tagPool_c_out_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_out_25.setPageContext(_jspx_page_context);
    _jspx_th_c_out_25.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_46);
    _jspx_th_c_out_25.setValue(new String("원"));
    int _jspx_eval_c_out_25 = _jspx_th_c_out_25.doStartTag();
    if (_jspx_th_c_out_25.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_25);
      return true;
    }
    _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_25);
    return false;
  }

  private boolean _jspx_meth_c_out_26(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_2, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_2)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_out_26 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _jspx_tagPool_c_out_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_out_26.setPageContext(_jspx_page_context);
    _jspx_th_c_out_26.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_2);
    _jspx_th_c_out_26.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${BuySellBean.sell_place}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_out_26 = _jspx_th_c_out_26.doStartTag();
    if (_jspx_th_c_out_26.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_26);
      return true;
    }
    _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_26);
    return false;
  }

  private boolean _jspx_meth_c_if_47(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_2, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_2)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_47 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_47.setPageContext(_jspx_page_context);
    _jspx_th_c_if_47.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_2);
    _jspx_th_c_if_47.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${BuySellBean.pro_status == '1'}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_if_47 = _jspx_th_c_if_47.doStartTag();
    if (_jspx_eval_c_if_47 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t            \t\t<img src=\"jsp/images/new/board_icon1.gif\" align=\"middle\">\r\n");
        out.write("\t\t\t\t\t\t\t            \t");
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

  private boolean _jspx_meth_c_if_48(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_2, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_2)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_48 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_48.setPageContext(_jspx_page_context);
    _jspx_th_c_if_48.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_2);
    _jspx_th_c_if_48.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${BuySellBean.pro_status == '2'}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_if_48 = _jspx_th_c_if_48.doStartTag();
    if (_jspx_eval_c_if_48 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t            \t\t<img src=\"jsp/images/new/board_icon2.gif\" align=\"middle\">\r\n");
        out.write("\t\t\t\t\t\t\t            \t");
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

  private boolean _jspx_meth_c_if_49(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_2, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_2)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_49 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_49.setPageContext(_jspx_page_context);
    _jspx_th_c_if_49.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_2);
    _jspx_th_c_if_49.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${BuySellBean.send_method == '0'}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_if_49 = _jspx_th_c_if_49.doStartTag();
    if (_jspx_eval_c_if_49 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t            \t\t<img src=\"jsp/images/new/board_icon4.gif\" align=\"middle\">\r\n");
        out.write("\t\t\t\t\t\t\t            \t\t<img src=\"jsp/images/new/board_icon5.gif\" align=\"middle\">\r\n");
        out.write("\t\t\t\t\t\t\t            \t");
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

  private boolean _jspx_meth_c_if_50(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_2, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_2)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_50 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_50.setPageContext(_jspx_page_context);
    _jspx_th_c_if_50.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_2);
    _jspx_th_c_if_50.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${BuySellBean.send_method == '1'}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_if_50 = _jspx_th_c_if_50.doStartTag();
    if (_jspx_eval_c_if_50 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t            \t\t<img src=\"jsp/images/new/board_icon4.gif\" align=\"middle\">\r\n");
        out.write("\t\t\t\t\t\t\t            \t");
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

  private boolean _jspx_meth_c_if_51(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_2, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_2)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_51 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_51.setPageContext(_jspx_page_context);
    _jspx_th_c_if_51.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_2);
    _jspx_th_c_if_51.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${BuySellBean.send_method == '2'}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_if_51 = _jspx_th_c_if_51.doStartTag();
    if (_jspx_eval_c_if_51 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t            \t\t<img src=\"jsp/images/new/board_icon5.gif\" align=\"middle\">\r\n");
        out.write("\t\t\t\t\t\t\t            \t");
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

  private boolean _jspx_meth_c_out_27(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_2, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_2)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_out_27 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _jspx_tagPool_c_out_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_out_27.setPageContext(_jspx_page_context);
    _jspx_th_c_out_27.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_2);
    _jspx_th_c_out_27.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${BuySellBean.update_date}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_out_27 = _jspx_th_c_out_27.doStartTag();
    if (_jspx_th_c_out_27.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_27);
      return true;
    }
    _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_27);
    return false;
  }

  private boolean _jspx_meth_c_if_52(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_2, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_2)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_52 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_52.setPageContext(_jspx_page_context);
    _jspx_th_c_if_52.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_2);
    _jspx_th_c_if_52.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${BuySellBean.member_sort == '1'}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_if_52 = _jspx_th_c_if_52.doStartTag();
    if (_jspx_eval_c_if_52 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t            \t\t<img src=\"jsp/images/new/board_icon7.gif\" align=\"middle\">\r\n");
        out.write("\t\t\t\t\t\t\t            \t");
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

  private boolean _jspx_meth_c_if_53(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_2, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_2)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_53 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_53.setPageContext(_jspx_page_context);
    _jspx_th_c_if_53.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_2);
    _jspx_th_c_if_53.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${BuySellBean.member_sort == '2'}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_if_53 = _jspx_th_c_if_53.doStartTag();
    if (_jspx_eval_c_if_53 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t            \t\t<img src=\"jsp/images/new/board_icon8.gif\" align=\"middle\">\r\n");
        out.write("\t\t\t\t\t\t\t            \t");
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

  private boolean _jspx_meth_c_out_28(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_2, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_2)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_out_28 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _jspx_tagPool_c_out_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_out_28.setPageContext(_jspx_page_context);
    _jspx_th_c_out_28.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_2);
    _jspx_th_c_out_28.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${BuySellBean.read_count}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_out_28 = _jspx_th_c_out_28.doStartTag();
    if (_jspx_th_c_out_28.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_28);
      return true;
    }
    _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_28);
    return false;
  }

  private boolean _jspx_meth_c_otherwise_1(javax.servlet.jsp.tagext.JspTag _jspx_th_c_choose_1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:otherwise
    org.apache.taglibs.standard.tag.common.core.OtherwiseTag _jspx_th_c_otherwise_1 = (org.apache.taglibs.standard.tag.common.core.OtherwiseTag) _jspx_tagPool_c_otherwise.get(org.apache.taglibs.standard.tag.common.core.OtherwiseTag.class);
    _jspx_th_c_otherwise_1.setPageContext(_jspx_page_context);
    _jspx_th_c_otherwise_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_choose_1);
    int _jspx_eval_c_otherwise_1 = _jspx_th_c_otherwise_1.doStartTag();
    if (_jspx_eval_c_otherwise_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t\t\t<tr>\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t<td width=\"100%\" align=\"center\">\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t");
        if (_jspx_meth_c_out_29(_jspx_th_c_otherwise_1, _jspx_page_context))
          return true;
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t</td>\r\n");
        out.write("\t\t\t\t\t\t\t\t\t</tr>\r\n");
        out.write("\t\t\t\t\t\t\t\t");
        int evalDoAfterBody = _jspx_th_c_otherwise_1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_otherwise_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_otherwise.reuse(_jspx_th_c_otherwise_1);
      return true;
    }
    _jspx_tagPool_c_otherwise.reuse(_jspx_th_c_otherwise_1);
    return false;
  }

  private boolean _jspx_meth_c_out_29(javax.servlet.jsp.tagext.JspTag _jspx_th_c_otherwise_1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_out_29 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _jspx_tagPool_c_out_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_out_29.setPageContext(_jspx_page_context);
    _jspx_th_c_out_29.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_otherwise_1);
    _jspx_th_c_out_29.setValue(new String("해당 검색 리스트가 없습니다."));
    int _jspx_eval_c_out_29 = _jspx_th_c_out_29.doStartTag();
    if (_jspx_th_c_out_29.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_29);
      return true;
    }
    _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_29);
    return false;
  }

  private boolean _jspx_meth_c_if_54(javax.servlet.jsp.tagext.JspTag _jspx_th_c_if_41, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_54 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_54.setPageContext(_jspx_page_context);
    _jspx_th_c_if_54.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_41);
    _jspx_th_c_if_54.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${BuySellSearchBean.list_view == '1'}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_if_54 = _jspx_th_c_if_54.doStartTag();
    if (_jspx_eval_c_if_54 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t<tr>\r\n");
        out.write("\t\t\t\t\t<td valign=\"top\">\r\n");
        out.write("\t\t\t\t\t\t<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n");
        out.write("\t\t\t\t\t\t<tr>\r\n");
        out.write("\t\t\t\t\t\t\t<td width=\"100%\" height=\"20\" background=\"jsp/images/new/board_list_top_bg.gif\" class=\"search-list-tit\">&nbsp;</td>\r\n");
        out.write("\t\t\t\t\t\t</tr>\r\n");
        out.write("\t\t\t\t\t\t</table>\r\n");
        out.write("\t\t\t\t\t</td>\r\n");
        out.write("\t\t\t\t</tr>\r\n");
        out.write("\t\t\t\t<tr>\r\n");
        out.write("\t\t\t\t\t<td height=\"5\" align=\"center\"></td>\r\n");
        out.write("\t\t\t\t</tr>\r\n");
        out.write("\t\t\t\t");
        if (_jspx_meth_c_choose_2(_jspx_th_c_if_54, _jspx_page_context))
          return true;
        out.write("\r\n");
        out.write("\t\t\t\t");
        int evalDoAfterBody = _jspx_th_c_if_54.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_54.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_54);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_54);
    return false;
  }

  private boolean _jspx_meth_c_choose_2(javax.servlet.jsp.tagext.JspTag _jspx_th_c_if_54, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:choose
    org.apache.taglibs.standard.tag.common.core.ChooseTag _jspx_th_c_choose_2 = (org.apache.taglibs.standard.tag.common.core.ChooseTag) _jspx_tagPool_c_choose.get(org.apache.taglibs.standard.tag.common.core.ChooseTag.class);
    _jspx_th_c_choose_2.setPageContext(_jspx_page_context);
    _jspx_th_c_choose_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_54);
    int _jspx_eval_c_choose_2 = _jspx_th_c_choose_2.doStartTag();
    if (_jspx_eval_c_choose_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t\t");
        if (_jspx_meth_c_when_2(_jspx_th_c_choose_2, _jspx_page_context))
          return true;
        out.write("\r\n");
        out.write("\t\t\t\t\t");
        if (_jspx_meth_c_otherwise_2(_jspx_th_c_choose_2, _jspx_page_context))
          return true;
        out.write("\r\n");
        out.write("\t\t\t\t");
        int evalDoAfterBody = _jspx_th_c_choose_2.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_choose_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_choose.reuse(_jspx_th_c_choose_2);
      return true;
    }
    _jspx_tagPool_c_choose.reuse(_jspx_th_c_choose_2);
    return false;
  }

  private boolean _jspx_meth_c_when_2(javax.servlet.jsp.tagext.JspTag _jspx_th_c_choose_2, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:when
    org.apache.taglibs.standard.tag.rt.core.WhenTag _jspx_th_c_when_2 = (org.apache.taglibs.standard.tag.rt.core.WhenTag) _jspx_tagPool_c_when_test.get(org.apache.taglibs.standard.tag.rt.core.WhenTag.class);
    _jspx_th_c_when_2.setPageContext(_jspx_page_context);
    _jspx_th_c_when_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_choose_2);
    _jspx_th_c_when_2.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${!empty BuySellBeanList}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_when_2 = _jspx_th_c_when_2.doStartTag();
    if (_jspx_eval_c_when_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t\t\t");
        if (_jspx_meth_c_forEach_3(_jspx_th_c_when_2, _jspx_page_context))
          return true;
        out.write("\r\n");
        out.write("\t\t\t\t\t");
        int evalDoAfterBody = _jspx_th_c_when_2.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_when_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_when_test.reuse(_jspx_th_c_when_2);
      return true;
    }
    _jspx_tagPool_c_when_test.reuse(_jspx_th_c_when_2);
    return false;
  }

  private boolean _jspx_meth_c_forEach_3(javax.servlet.jsp.tagext.JspTag _jspx_th_c_when_2, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_3 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_varStatus_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_3.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_when_2);
    _jspx_th_c_forEach_3.setVar("BuySellBean");
    _jspx_th_c_forEach_3.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${BuySellBeanList}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    _jspx_th_c_forEach_3.setVarStatus("status");
    int[] _jspx_push_body_count_c_forEach_3 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_3 = _jspx_th_c_forEach_3.doStartTag();
      if (_jspx_eval_c_forEach_3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("\t\t\t\t\t\t");
          if (_jspx_meth_c_if_55(_jspx_th_c_forEach_3, _jspx_page_context, _jspx_push_body_count_c_forEach_3))
            return true;
          out.write("\r\n");
          out.write("\t\t\t\t\t  \t\t\t<!--표시부분 START -->\r\n");
          out.write("\t\t\t\t\t\t\t\t<td align=\"left\" width=\"25%\">\r\n");
          out.write("\t\t\t\t\t\t\t\t\t<table align=\"left\" height=\"190\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\r\n");
          out.write("\t\t\t\t\t\t\t\t\t<tr height=\"190\" cellspacing=\"0\">\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t<td align=\"center\">\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t<a href=\"javascript:openDetailPage('");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${BuySellBean.id}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("');\"><img src=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${BuySellBean.photo_path1}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("\" alt=\"\" width=\"230\"  height=\"190\"></a>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t</td>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t</tr>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t<tr>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t<td height=\"5\" align=\"center\" bgcolor=\"#FFFFFF\"></td>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t</tr>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t<tr>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t<td align=\"center\"\">\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t<strong>");
          if (_jspx_meth_c_out_30(_jspx_th_c_forEach_3, _jspx_page_context, _jspx_push_body_count_c_forEach_3))
            return true;
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${util:getNewImage(BuySellBean.update_dateTime)}", java.lang.String.class, (PageContext)_jspx_page_context, _jspx_fnmap_0, false));
          out.write("</strong>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t</td>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t</tr>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t<tr>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t<td align=\"center\"\">\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t<span class=\"red-text-w\"><strong>가격:\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t");
          if (_jspx_meth_c_if_56(_jspx_th_c_forEach_3, _jspx_page_context, _jspx_push_body_count_c_forEach_3))
            return true;
          out.write("\r\n");
          out.write("\t\t\t\t\t\t\t            \t");
          if (_jspx_meth_c_if_57(_jspx_th_c_forEach_3, _jspx_page_context, _jspx_push_body_count_c_forEach_3))
            return true;
          out.write("\r\n");
          out.write("\t\t\t\t\t\t\t            \t</strong></span><br />\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t</td>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t</tr>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t<tr>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t<td align=\"center\">\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t");
          if (_jspx_meth_c_out_34(_jspx_th_c_forEach_3, _jspx_page_context, _jspx_push_body_count_c_forEach_3))
            return true;
          out.write("\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t<!--중고품-->\r\n");
          out.write("\t\t\t\t\t\t\t            \t");
          if (_jspx_meth_c_if_60(_jspx_th_c_forEach_3, _jspx_page_context, _jspx_push_body_count_c_forEach_3))
            return true;
          out.write("\r\n");
          out.write("\t\t\t\t\t\t\t            \t<!--신제품-->\r\n");
          out.write("\t\t\t\t\t\t\t            \t");
          if (_jspx_meth_c_if_61(_jspx_th_c_forEach_3, _jspx_page_context, _jspx_push_body_count_c_forEach_3))
            return true;
          out.write("\r\n");
          out.write("\t\t\t\t\t\t\t            \t<!--직거래/택배-->\r\n");
          out.write("\t\t\t\t\t\t\t            \t");
          if (_jspx_meth_c_if_62(_jspx_th_c_forEach_3, _jspx_page_context, _jspx_push_body_count_c_forEach_3))
            return true;
          out.write("\r\n");
          out.write("\t\t\t\t\t\t\t            \t<!--직거래-->\r\n");
          out.write("\t\t\t\t\t\t\t            \t");
          if (_jspx_meth_c_if_63(_jspx_th_c_forEach_3, _jspx_page_context, _jspx_push_body_count_c_forEach_3))
            return true;
          out.write("\r\n");
          out.write("\t\t\t\t\t\t\t            \t<!--택배-->\r\n");
          out.write("\t\t\t\t\t\t\t            \t");
          if (_jspx_meth_c_if_64(_jspx_th_c_forEach_3, _jspx_page_context, _jspx_push_body_count_c_forEach_3))
            return true;
          out.write("\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t</td>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t</tr>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t</table>\r\n");
          out.write("\t\t\t\t\t\t\t\t</td>\r\n");
          out.write("\t\t\t\t\t\t  \t\t<!--표시부분 END -->\r\n");
          out.write("\t\t\t\t\t\t<!--4의배수 and 마지막이 아닐때 개행처리   -->\t\t\t\t\t\t  \t\t\t\t\t\t\t\t\t\r\n");
          out.write("\t\t\t\t\t\t");
          if (_jspx_meth_c_if_65(_jspx_th_c_forEach_3, _jspx_page_context, _jspx_push_body_count_c_forEach_3))
            return true;
          out.write("\r\n");
          out.write("\t\t\t\t\t\t<!--마지막일때 개행처리   -->\r\n");
          out.write("\t\t\t\t\t\t");
          if (_jspx_meth_c_if_66(_jspx_th_c_forEach_3, _jspx_page_context, _jspx_push_body_count_c_forEach_3))
            return true;
          out.write("\t\t\r\n");
          out.write("\t\t\t\t\t\t");
          int evalDoAfterBody = _jspx_th_c_forEach_3.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_3[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_3.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_3.doFinally();
      _jspx_tagPool_c_forEach_varStatus_var_items.reuse(_jspx_th_c_forEach_3);
    }
    return false;
  }

  private boolean _jspx_meth_c_if_55(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_3, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_3)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_55 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_55.setPageContext(_jspx_page_context);
    _jspx_th_c_if_55.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_3);
    _jspx_th_c_if_55.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${status.first}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_if_55 = _jspx_th_c_if_55.doStartTag();
    if (_jspx_eval_c_if_55 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t\t\t<!--처음이면 테이블 테그 생성  -->\r\n");
        out.write("\t\t\t\t\t\t<tr>\r\n");
        out.write("\t\t\t\t\t\t\t<td align=\"left\">\r\n");
        out.write("\t\t\t\t\t\t\t\t<table width=\"100%\" align=\"left\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n");
        out.write("\t\t\t\t\t\t  \t\t<tr>\r\n");
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

  private boolean _jspx_meth_c_out_30(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_3, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_3)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_out_30 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _jspx_tagPool_c_out_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_out_30.setPageContext(_jspx_page_context);
    _jspx_th_c_out_30.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_3);
    _jspx_th_c_out_30.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${util:cutLongName(12,BuySellBean.title)}", java.lang.Object.class, (PageContext)_jspx_page_context, _jspx_fnmap_1, false));
    int _jspx_eval_c_out_30 = _jspx_th_c_out_30.doStartTag();
    if (_jspx_th_c_out_30.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_30);
      return true;
    }
    _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_30);
    return false;
  }

  private boolean _jspx_meth_c_if_56(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_3, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_3)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_56 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_56.setPageContext(_jspx_page_context);
    _jspx_th_c_if_56.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_3);
    _jspx_th_c_if_56.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${BuySellBean.free_price == '1'}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_if_56 = _jspx_th_c_if_56.doStartTag();
    if (_jspx_eval_c_if_56 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t            \t\t<img src=\"jsp/images/new/board_icon3.gif\" align=\"middle\">\r\n");
        out.write("\t\t\t\t\t\t\t            \t");
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

  private boolean _jspx_meth_c_if_57(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_3, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_3)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_57 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_57.setPageContext(_jspx_page_context);
    _jspx_th_c_if_57.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_3);
    _jspx_th_c_if_57.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${BuySellBean.free_price != '1' and !empty BuySellBean.price}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_if_57 = _jspx_th_c_if_57.doStartTag();
    if (_jspx_eval_c_if_57 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t            \t\t\r\n");
        out.write("\t\t\t\t\t\t\t            \t\t");
        if (_jspx_meth_c_out_31(_jspx_th_c_if_57, _jspx_page_context, _jspx_push_body_count_c_forEach_3))
          return true;
        out.write("\r\n");
        out.write("\t\t\t\t\t\t            \t\t\t");
        if (_jspx_meth_c_if_58(_jspx_th_c_if_57, _jspx_page_context, _jspx_push_body_count_c_forEach_3))
          return true;
        out.write("\r\n");
        out.write("\t\t\t\t\t\t            \t\t\t");
        if (_jspx_meth_c_if_59(_jspx_th_c_if_57, _jspx_page_context, _jspx_push_body_count_c_forEach_3))
          return true;
        out.write("\r\n");
        out.write("\t\t\t\t\t\t            \t\t\t\r\n");
        out.write("\t\t\t\t\t\t\t            \t");
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

  private boolean _jspx_meth_c_out_31(javax.servlet.jsp.tagext.JspTag _jspx_th_c_if_57, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_3)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_out_31 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _jspx_tagPool_c_out_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_out_31.setPageContext(_jspx_page_context);
    _jspx_th_c_out_31.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_57);
    _jspx_th_c_out_31.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${BuySellBean.price}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_out_31 = _jspx_th_c_out_31.doStartTag();
    if (_jspx_th_c_out_31.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_31);
      return true;
    }
    _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_31);
    return false;
  }

  private boolean _jspx_meth_c_if_58(javax.servlet.jsp.tagext.JspTag _jspx_th_c_if_57, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_3)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_58 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_58.setPageContext(_jspx_page_context);
    _jspx_th_c_if_58.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_57);
    _jspx_th_c_if_58.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${empty BuySellBean.price_unit or BuySellBean.price_unit == '0'}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_if_58 = _jspx_th_c_if_58.doStartTag();
    if (_jspx_eval_c_if_58 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t\t\t            \t\t\t\t");
        if (_jspx_meth_c_out_32(_jspx_th_c_if_58, _jspx_page_context, _jspx_push_body_count_c_forEach_3))
          return true;
        out.write("\r\n");
        out.write("\t\t\t\t\t\t            \t\t\t");
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

  private boolean _jspx_meth_c_out_32(javax.servlet.jsp.tagext.JspTag _jspx_th_c_if_58, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_3)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_out_32 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _jspx_tagPool_c_out_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_out_32.setPageContext(_jspx_page_context);
    _jspx_th_c_out_32.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_58);
    _jspx_th_c_out_32.setValue(new String("엔"));
    int _jspx_eval_c_out_32 = _jspx_th_c_out_32.doStartTag();
    if (_jspx_th_c_out_32.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_32);
      return true;
    }
    _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_32);
    return false;
  }

  private boolean _jspx_meth_c_if_59(javax.servlet.jsp.tagext.JspTag _jspx_th_c_if_57, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_3)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_59 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_59.setPageContext(_jspx_page_context);
    _jspx_th_c_if_59.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_57);
    _jspx_th_c_if_59.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${!empty BuySellBean.price_unit and BuySellBean.price_unit == '1'}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_if_59 = _jspx_th_c_if_59.doStartTag();
    if (_jspx_eval_c_if_59 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t\t\t            \t\t\t\t");
        if (_jspx_meth_c_out_33(_jspx_th_c_if_59, _jspx_page_context, _jspx_push_body_count_c_forEach_3))
          return true;
        out.write("\r\n");
        out.write("\t\t\t\t\t\t            \t\t\t");
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

  private boolean _jspx_meth_c_out_33(javax.servlet.jsp.tagext.JspTag _jspx_th_c_if_59, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_3)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_out_33 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _jspx_tagPool_c_out_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_out_33.setPageContext(_jspx_page_context);
    _jspx_th_c_out_33.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_59);
    _jspx_th_c_out_33.setValue(new String("원"));
    int _jspx_eval_c_out_33 = _jspx_th_c_out_33.doStartTag();
    if (_jspx_th_c_out_33.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_33);
      return true;
    }
    _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_33);
    return false;
  }

  private boolean _jspx_meth_c_out_34(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_3, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_3)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_out_34 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _jspx_tagPool_c_out_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_out_34.setPageContext(_jspx_page_context);
    _jspx_th_c_out_34.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_3);
    _jspx_th_c_out_34.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${BuySellBean.sell_place}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_out_34 = _jspx_th_c_out_34.doStartTag();
    if (_jspx_th_c_out_34.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_34);
      return true;
    }
    _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_34);
    return false;
  }

  private boolean _jspx_meth_c_if_60(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_3, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_3)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_60 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_60.setPageContext(_jspx_page_context);
    _jspx_th_c_if_60.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_3);
    _jspx_th_c_if_60.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${BuySellBean.pro_status == '1'}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_if_60 = _jspx_th_c_if_60.doStartTag();
    if (_jspx_eval_c_if_60 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t            \t\t<img src=\"jsp/images/new/board_icon1.gif\" align=\"absmiddle\" width=\"16\" height=\"17\" />\r\n");
        out.write("\t\t\t\t\t\t\t            \t");
        int evalDoAfterBody = _jspx_th_c_if_60.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_60.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_60);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_60);
    return false;
  }

  private boolean _jspx_meth_c_if_61(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_3, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_3)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_61 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_61.setPageContext(_jspx_page_context);
    _jspx_th_c_if_61.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_3);
    _jspx_th_c_if_61.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${BuySellBean.pro_status == '2'}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_if_61 = _jspx_th_c_if_61.doStartTag();
    if (_jspx_eval_c_if_61 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t            \t\t<img src=\"jsp/images/new/board_icon2.gif\" align=\"absmiddle\" width=\"16\" height=\"17\" />\r\n");
        out.write("\t\t\t\t\t\t\t            \t");
        int evalDoAfterBody = _jspx_th_c_if_61.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_61.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_61);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_61);
    return false;
  }

  private boolean _jspx_meth_c_if_62(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_3, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_3)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_62 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_62.setPageContext(_jspx_page_context);
    _jspx_th_c_if_62.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_3);
    _jspx_th_c_if_62.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${BuySellBean.send_method == '0'}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_if_62 = _jspx_th_c_if_62.doStartTag();
    if (_jspx_eval_c_if_62 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t            \t\t<img src=\"jsp/images/new/board_icon4.gif\" align=\"absmiddle\" width=\"16\" height=\"17\" />\r\n");
        out.write("\t\t\t\t\t\t\t            \t\t<img src=\"jsp/images/new/board_icon5.gif\" align=\"absmiddle\" width=\"16\" height=\"17\" />\r\n");
        out.write("\t\t\t\t\t\t\t            \t");
        int evalDoAfterBody = _jspx_th_c_if_62.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_62.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_62);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_62);
    return false;
  }

  private boolean _jspx_meth_c_if_63(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_3, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_3)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_63 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_63.setPageContext(_jspx_page_context);
    _jspx_th_c_if_63.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_3);
    _jspx_th_c_if_63.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${BuySellBean.send_method == '1'}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_if_63 = _jspx_th_c_if_63.doStartTag();
    if (_jspx_eval_c_if_63 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t            \t\t<img src=\"jsp/images/new/board_icon4.gif\" align=\"absmiddle\" width=\"16\" height=\"17\" />\r\n");
        out.write("\t\t\t\t\t\t\t            \t");
        int evalDoAfterBody = _jspx_th_c_if_63.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_63.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_63);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_63);
    return false;
  }

  private boolean _jspx_meth_c_if_64(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_3, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_3)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_64 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_64.setPageContext(_jspx_page_context);
    _jspx_th_c_if_64.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_3);
    _jspx_th_c_if_64.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${BuySellBean.send_method == '2'}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_if_64 = _jspx_th_c_if_64.doStartTag();
    if (_jspx_eval_c_if_64 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t            \t\t<img src=\"jsp/images/new/board_icon5.gif\" align=\"absmiddle\" width=\"16\" height=\"17\" />\r\n");
        out.write("\t\t\t\t\t\t\t            \t");
        int evalDoAfterBody = _jspx_th_c_if_64.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_64.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_64);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_64);
    return false;
  }

  private boolean _jspx_meth_c_if_65(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_3, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_3)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_65 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_65.setPageContext(_jspx_page_context);
    _jspx_th_c_if_65.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_3);
    _jspx_th_c_if_65.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${(status.index + 1) % 4 == 0 and !status.last}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_if_65 = _jspx_th_c_if_65.doStartTag();
    if (_jspx_eval_c_if_65 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t\t</tr>\r\n");
        out.write("\t\t\t\t\t\t\t\t</table>\r\n");
        out.write("\t\t\t\t\t\t\t</td>\r\n");
        out.write("\t\t\t\t\t\t</tr>\r\n");
        out.write("\t\t\t\t\t\t<tr>\r\n");
        out.write("\t\t\t\t\t\t\t<td height=\"1\" align=\"center\" bgcolor=\"#CCCCCC\"></td>\r\n");
        out.write("\t\t\t\t\t\t</tr>\r\n");
        out.write("\t\t\t\t\t\t<tr>\r\n");
        out.write("\t\t\t\t\t\t\t<td height=\"5\" align=\"center\"></td>\r\n");
        out.write("\t\t\t\t\t\t</tr>\r\n");
        out.write("\t\t\t\t\t\t<tr>\r\n");
        out.write("\t\t\t\t\t\t\t<td align=\"center\">\r\n");
        out.write("\t\t\t\t\t\t\t\t<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n");
        out.write("\t\t\t\t\t\t  \t\t<tr>\r\n");
        out.write("\t\t\t\t\t\t");
        int evalDoAfterBody = _jspx_th_c_if_65.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_65.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_65);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_65);
    return false;
  }

  private boolean _jspx_meth_c_if_66(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_3, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_3)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_66 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_66.setPageContext(_jspx_page_context);
    _jspx_th_c_if_66.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_3);
    _jspx_th_c_if_66.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${status.last}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_if_66 = _jspx_th_c_if_66.doStartTag();
    if (_jspx_eval_c_if_66 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t\t");
        if (_jspx_meth_c_if_67(_jspx_th_c_if_66, _jspx_page_context, _jspx_push_body_count_c_forEach_3))
          return true;
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t\t</tr>\r\n");
        out.write("\t\t\t\t\t\t\t\t</table>\r\n");
        out.write("\t\t\t\t\t\t\t</td>\r\n");
        out.write("\t\t\t\t\t\t</tr>\r\n");
        out.write("\t\t\t\t\t\t<tr>\r\n");
        out.write("\t\t\t\t\t\t\t<td height=\"5\" colspan=\"4\" align=\"center\"></td>\r\n");
        out.write("\t\t\t\t\t\t</tr>\r\n");
        out.write("\t\t\t\t\t\t");
        int evalDoAfterBody = _jspx_th_c_if_66.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_66.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_66);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_66);
    return false;
  }

  private boolean _jspx_meth_c_if_67(javax.servlet.jsp.tagext.JspTag _jspx_th_c_if_66, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_3)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_67 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_67.setPageContext(_jspx_page_context);
    _jspx_th_c_if_67.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_66);
    _jspx_th_c_if_67.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${(status.index + 1) % 4 != 0}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_if_67 = _jspx_th_c_if_67.doStartTag();
    if (_jspx_eval_c_if_67 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t\t\t");
        if (_jspx_meth_c_forEach_4(_jspx_th_c_if_67, _jspx_page_context, _jspx_push_body_count_c_forEach_3))
          return true;
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t\t");
        int evalDoAfterBody = _jspx_th_c_if_67.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_67.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_67);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_67);
    return false;
  }

  private boolean _jspx_meth_c_forEach_4(javax.servlet.jsp.tagext.JspTag _jspx_th_c_if_67, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_3)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_4 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_step_end_begin.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_4.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_67);
    _jspx_th_c_forEach_4.setVar("i");
    _jspx_th_c_forEach_4.setBegin(0);
    _jspx_th_c_forEach_4.setEnd(((java.lang.Integer) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${(status.index + 1) % 4}", java.lang.Integer.class, (PageContext)_jspx_page_context, null, false)).intValue());
    _jspx_th_c_forEach_4.setStep(1);
    int[] _jspx_push_body_count_c_forEach_4 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_4 = _jspx_th_c_forEach_4.doStartTag();
      if (_jspx_eval_c_forEach_4 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t<td align=\"left\" width=\"25%\">&nbsp;</td>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t");
          int evalDoAfterBody = _jspx_th_c_forEach_4.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_4[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_4.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_4.doFinally();
      _jspx_tagPool_c_forEach_var_step_end_begin.reuse(_jspx_th_c_forEach_4);
    }
    return false;
  }

  private boolean _jspx_meth_c_otherwise_2(javax.servlet.jsp.tagext.JspTag _jspx_th_c_choose_2, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:otherwise
    org.apache.taglibs.standard.tag.common.core.OtherwiseTag _jspx_th_c_otherwise_2 = (org.apache.taglibs.standard.tag.common.core.OtherwiseTag) _jspx_tagPool_c_otherwise.get(org.apache.taglibs.standard.tag.common.core.OtherwiseTag.class);
    _jspx_th_c_otherwise_2.setPageContext(_jspx_page_context);
    _jspx_th_c_otherwise_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_choose_2);
    int _jspx_eval_c_otherwise_2 = _jspx_th_c_otherwise_2.doStartTag();
    if (_jspx_eval_c_otherwise_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t\t\t<tr>\r\n");
        out.write("\t\t\t\t\t\t\t<td width=\"100%\" align=\"center\">\r\n");
        out.write("\t\t\t\t\t\t\t");
        if (_jspx_meth_c_out_35(_jspx_th_c_otherwise_2, _jspx_page_context))
          return true;
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t</td>\r\n");
        out.write("\t\t\t\t\t\t</tr>\r\n");
        out.write("\t\t\t\t\t");
        int evalDoAfterBody = _jspx_th_c_otherwise_2.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_otherwise_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_otherwise.reuse(_jspx_th_c_otherwise_2);
      return true;
    }
    _jspx_tagPool_c_otherwise.reuse(_jspx_th_c_otherwise_2);
    return false;
  }

  private boolean _jspx_meth_c_out_35(javax.servlet.jsp.tagext.JspTag _jspx_th_c_otherwise_2, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_out_35 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _jspx_tagPool_c_out_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_out_35.setPageContext(_jspx_page_context);
    _jspx_th_c_out_35.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_otherwise_2);
    _jspx_th_c_out_35.setValue(new String("해당 검색 리스트가 없습니다."));
    int _jspx_eval_c_out_35 = _jspx_th_c_out_35.doStartTag();
    if (_jspx_th_c_out_35.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_35);
      return true;
    }
    _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_35);
    return false;
  }

  private boolean _jspx_meth_c_if_68(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_68 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_68.setPageContext(_jspx_page_context);
    _jspx_th_c_if_68.setParent(null);
    _jspx_th_c_if_68.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${0 != PageBean.maxCount}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_if_68 = _jspx_th_c_if_68.doStartTag();
    if (_jspx_eval_c_if_68 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t\t<td align=\"center\" style=\"color:#33333;font-size:12px;\">검색결과 :\r\n");
        out.write("\t\t\t\t\t<span class=\"orange-text\"><strong>");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${PageBean.maxCount}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
        out.write("</strong></span>건중 \r\n");
        out.write("\t\t        \t<span class=\"blue-text-w\"><strong>");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${PageBean.startCount}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
        out.write('~');
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${PageBean.endCount}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
        out.write("</strong></span>건을표시하고 있습니다.</td> \r\n");
        out.write("\t\t\t\t");
        int evalDoAfterBody = _jspx_th_c_if_68.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_68.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_68);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_68);
    return false;
  }

  private boolean _jspx_meth_myTags_pageHandle_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  myTags:pageHandle
    common.page.PageHandleTag _jspx_th_myTags_pageHandle_0 = new common.page.PageHandleTag();
    _jspx_th_myTags_pageHandle_0.setJspContext(_jspx_page_context);
    _jspx_th_myTags_pageHandle_0.doTag();
    return false;
  }
}
