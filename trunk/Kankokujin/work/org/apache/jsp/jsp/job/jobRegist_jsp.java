package org.apache.jsp.jsp.job;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import common.bean.MemberBean;
import job.bean.JobBean;
import job.bean.JobSearchBean;
import common.util.Util;
import common.constant.Const;

public final class jobRegist_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

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

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_fmt_setLocale_value_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_fmt_setBundle_var_basename_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_if_test = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_out_value_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_fmt_message_key_bundle_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_fmt_setLocale_value_nobody.release();
    _jspx_tagPool_fmt_setBundle_var_basename_nobody.release();
    _jspx_tagPool_c_if_test.release();
    _jspx_tagPool_c_out_value_nobody.release();
    _jspx_tagPool_fmt_message_key_bundle_nobody.release();
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
      if (_jspx_meth_fmt_setLocale_0(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
      if (_jspx_meth_fmt_setBundle_0(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');

	request.setCharacterEncoding("UTF-8");
	JobBean jobBean = (JobBean) request.getAttribute("JobBean");
	JobSearchBean jobSearchBean = (JobSearchBean) request.getAttribute("JobSearchBean");
	MemberBean member = new MemberBean();
	member = (MemberBean) session.getAttribute("memberInfo");
	if (member == null) {

      out.write("\r\n");
      out.write("<script language=\"javascript\">\r\n");
      out.write("\t\t\t\talert(\"로그인을 해주세요.\");\r\n");
      out.write("\t\t\t\tlocation.href=\"\";\r\n");
      out.write("\t\t\t</script>\r\n");

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
      out.write("<script src=\"jsp/include/js/prototype.js\" type=\"text/javascript\" ></script>\r\n");
      out.write("<script src=\"jsp/include/js/src/scriptaculous.js?effets\" type=\"text/javascript\" ></script>\r\n");
      out.write("<script src=\"jsp/include/js/popupMenu.js\" type=\"text/javascript\"></script>\r\n");
      out.write("<script src=\"jsp/include/js/top.js\" type=\"text/javascript\"></script>\r\n");
      out.write("<script src=\"jsp/include/js/commonCheck.js\" type=\"text/javascript\"></script>\r\n");
      out.write("<script src=\"jsp/include/js/commonFunction.js\" type=\"text/javascript\"></script>\r\n");
      out.write("<link href=\"jsp/include/css/basic.css\" rel=\"stylesheet\" type=\"text/css\">\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("<!--   \r\n");
      out.write("    \r\n");
      out.write("\tfunction isValidFormat(obj,format) {\r\n");
      out.write("\t\tif(obj.value.search(format) != -1) {\r\n");
      out.write("\t\t\treturn true;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\treturn false;\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction radioCheck(value){\r\n");
      out.write(" \t\tif(value == \"1\" ) {\r\n");
      out.write("\t\t \tdocument.wf.area_fast.disabled=false;\r\n");
      out.write("\t\t \tdocument.wf.area_code_1.disabled=true;\r\n");
      out.write("\t\t \tdocument.wf.area_code_2.disabled=true;\r\n");
      out.write("\t \t}else if(value == \"2\" ){\r\n");
      out.write(" \t\t\tdocument.wf.area_fast.disabled=true;\r\n");
      out.write("\t\t\tdocument.wf.area_code_1.disabled=false;\r\n");
      out.write("\t\t\tdocument.wf.area_code_2.disabled=false;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction isNumber(obj) {\r\n");
      out.write("\t\tvar str = obj.value;\r\n");
      out.write("\t\tif(str.length == 0)\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\r\n");
      out.write("\t\tfor(var i=0; i < str.length; i++) {\r\n");
      out.write("\t\t\tif(!('0' <= str.charAt(i) && str.charAt(i) <= '9'))\r\n");
      out.write("\t\t\t\treturn false;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\treturn true;\r\n");
      out.write("\t}\t\r\n");
      out.write("\tfunction isPhoneNumber(obj) {\r\n");
      out.write("\t\tif(obj.value == \"\") {\r\n");
      out.write("\t\t\treturn true;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tvar format = /^(\\d+)-(\\d+)-(\\d+)$/;\r\n");
      out.write("\t\treturn isValidFormat(obj,format);\r\n");
      out.write("\t}\t\r\n");
      out.write("\tfunction isNull(obj) {\r\n");
      out.write("\t\tif(obj.value == \"\") {\r\n");
      out.write("\t\t\treturn true;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction isEmail(obj) {\r\n");
      out.write("\t    var format = /^[_0-9a-zA-Z-]+(\\.[_0-9a-zA-Z-]+)*@[0-9a-zA-Z-]+(\\.[0-9a-zA-Z-]+)*$/;\r\n");
      out.write("\t\tif (obj.search(format) != -1){\r\n");
      out.write("\t\t\treturn true;\t\t\r\n");
      out.write("\t\t}else {\r\n");
      out.write("\t\t\treturn false;\t\t\r\n");
      out.write("\t\t}\t\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction isURL(obj) {\r\n");
      out.write("\t\tvar format = /^([a-z0-9-]+\\.)+[a-z0-9]{2,4}.*$/\t    \r\n");
      out.write("\t\tif (obj.match(format)){\r\n");
      out.write("\t\t\treturn true;\t\t\r\n");
      out.write("\t\t}else {\r\n");
      out.write("\t\t\treturn false;\t\t\r\n");
      out.write("\t\t}\t\r\n");
      out.write("\t}\t\r\n");
      out.write("\tfunction registCheck(ff) {\r\n");
      out.write("\t\tID = /^[0-9]{1,4}/;\r\n");
      out.write("\t\tif(isNull(ff.title)) {\r\n");
      out.write("\t\t\talert(\"글제목을 입력해 주세요.\");\r\n");
      out.write("\t\t\treturn;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tif(isNull(ff.company_name_k)) {\r\n");
      out.write("\t\t\talert(\"회사명을 입력해 주세요.\");\r\n");
      out.write("\t\t\treturn;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tif(ff.cate_code_2.value.substring(4, 6)==\"00\") {\r\n");
      out.write("\t\t\talert(\"업종을 선택해 주세요.\");\r\n");
      out.write("\t\t\treturn;\r\n");
      out.write("\t\t} \t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tif(ff.area_code_1.value !=\"00\" && ff.area_code_2.value.substring(2, 4)==\"00\") {\r\n");
      out.write("\t\t\talert(\"지역상세정보를 선택해 주세요.\");\r\n");
      out.write("\t\t\treturn;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tif(ff.line_code.value !=\"00\" && ff.station_code.value.substring(2, 4)==\"00\") {\r\n");
      out.write("\t\t\talert(\"역 정보를 선택해 주세요.\");\r\n");
      out.write("\t\t\treturn;\r\n");
      out.write("\t\t}\t\r\n");
      out.write("\t\tif(!isNull(ff.url) && !isURL(ff.url.value)) {\r\n");
      out.write("\t\t\talert(\"홈페이지 형식으로 입력해주세요.\");\r\n");
      out.write("\t\t\treturn;\r\n");
      out.write("\t\t}\t\t\t\t\r\n");
      out.write("\t\tif(!isNull(ff.email) && !isEmail(ff.email.value)) {\r\n");
      out.write("\t\t\talert(\"예)itfrees@itfrees.com형식으로 입력해주세요.\");\r\n");
      out.write("\t\t\treturn;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\r\n");
      out.write("\t\tif(isNull(ff.tel_no1_1) || isNull(ff.tel_no1_2) || isNull(ff.tel_no1_3)) {\r\n");
      out.write("\t\t\talert(\"전화번호1을 입력해 주세요.\");\r\n");
      out.write("\t\t\treturn;\r\n");
      out.write("\t\t} \r\n");
      out.write("\t\tif(!telephoneNoCheck(ff.tel_no1_1, ff.tel_no1_2, ff.tel_no1_3)) {\r\n");
      out.write("\t\t\talert(\"전화번호1이 전화번호 형식에 맞지 않습니다. \");\r\n");
      out.write("\t\t\treturn;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tif(!telephoneNoCheck(ff.tel_no2_1, ff.tel_no2_2, ff.tel_no2_3)) {\r\n");
      out.write("\t\t\talert(\"전화번호2가 전화번호 형식에 맞지 않습니다. \");\r\n");
      out.write("\t\t\treturn;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tif(!uploadImageCheck(ff.photo_name1, 1)) {\r\n");
      out.write("\t\t\treturn;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tif(!uploadImageCheck(ff.photo_name2, 2)) {\r\n");
      out.write("\t\t\treturn;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tif(!uploadImageCheck(ff.photo_name3, 3)) {\r\n");
      out.write("\t\t\treturn;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tif(!uploadImageCheck(ff.photo_name4, 4)) {\r\n");
      out.write("\t\t\treturn;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tif(!uploadImageCheck(ff.photo_name5, 5)) {\r\n");
      out.write("\t\t\treturn;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\tff.action=\"JobRegist\";\r\n");
      out.write("\t\tff.submit(); \r\n");
      out.write("\t\treturn true;\r\n");
      out.write("\t}\t\t\t\r\n");
      out.write("\tfunction reloadSearch(ff) {\r\n");
      out.write("\t\tff.action=\"JobRegistOpen?cate_code_2=-\";\r\n");
      out.write("\t\tff.submit(); \r\n");
      out.write("\t\treturn true;\r\n");
      out.write("\t}\t\r\n");
      out.write("\tfunction reloadRegist() {\r\n");
      out.write("\t\tdocument.wf.action=\"JobRegistOpen\";\r\n");
      out.write("\t\tdocument.wf.submit(); \r\n");
      out.write("\t\treturn true;\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction deletePhoto(index) {\r\n");
      out.write("\t\tdocument.wf.action=\"JobRegistOpen?del=\"+index;\r\n");
      out.write("\t\tdocument.wf.submit(); \r\n");
      out.write("\t\treturn true;\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction backSearch() {\r\n");
      out.write("\r\n");
      out.write("\t\tdocument.wf.action=\"JobSearch?f=b\";\r\n");
      out.write("\t\tdocument.wf.submit(); \r\n");
      out.write("\t\treturn true;\r\n");
      out.write("\t}\t\t\r\n");
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
      out.write("\t\t<td height=\"20\">&nbsp;</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td height=\"35\">\r\n");
      out.write("\t\t\t<form name=\"wf\" method=\"post\" enctype=\"multipart/form-data\">\r\n");
      out.write("\t\t\t<input type=\"hidden\" name=\"id\"\tvalue=\"");
      out.print(jobBean.getId());
      out.write("\">\t\t\t\r\n");
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
      out.write("\t\t\t<input type=\"hidden\" name=\"cate_code_1\" value=\"");
      out.print(jobBean.getCate_code_1());
      out.write("\">      \t\t\t    \t\t\t  \t\t\t      \t\t\t      \t\t\t\t\t\t\t\t\t\t\r\n");
      out.write("   \t\t\t<input type=\"hidden\" name=\"image1\" value=\"");
      out.print(jobBean.getPhoto_name1());
      out.write("\"> \r\n");
      out.write("   \t\t\t<input type=\"hidden\" name=\"image2\" value=\"");
      out.print(jobBean.getPhoto_name2());
      out.write("\"> \r\n");
      out.write("   \t\t\t<input type=\"hidden\" name=\"image3\" value=\"");
      out.print(jobBean.getPhoto_name3());
      out.write("\"> \r\n");
      out.write("   \t\t\t<input type=\"hidden\" name=\"image4\" value=\"");
      out.print(jobBean.getPhoto_name4());
      out.write("\"> \r\n");
      out.write("   \t\t\t<input type=\"hidden\" name=\"image5\" value=\"");
      out.print(jobBean.getPhoto_name5());
      out.write("\">\r\n");
      out.write("\t\t\t<table width=\"736\"  border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\">\r\n");
      out.write("\t\t\t<tr><!--이미지수정예정 -->\r\n");
      out.write("\t\t\t\t<!--사원-->\r\n");
      out.write("\t\t\t\t");
      if (_jspx_meth_c_if_2(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t\t<!--알바-->\r\n");
      out.write("\t\t\t\t");
      if (_jspx_meth_c_if_3(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td valign=\"top\">&nbsp;</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td valign=\"top\">\r\n");
      out.write("\t\t\t\t\t※ 필수항목 (<span class=\"red-text-w\">*</span>표시) 만 입력해도 가능합니다. 선택항목을 입력하면 보다 편리한 정보로 검색되실 수 있습니다. <br />\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td height=\"8\" valign=\"top\"></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td valign=\"top\">\r\n");
      out.write("\t\t\t\t\t<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td bgcolor=\"#EBF2E6\" style=\"padding:11px 11px 11px 11px;\">\r\n");
      out.write("\t\t\t\t\t\t\t<table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"1\" bgcolor=\"#d6d5d5\">\r\n");
      out.write("\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td width=\"22%\" bgcolor=\"#f9faf0\" class=\"table-title-text\"><span class=\"red-text-w\">*</span>글제목</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td width=\"78%\" bgcolor=\"#FFFFFF\" class=\"table-cont-text\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<input type=\"text\" name=\"title\" id=\"textfield2\"  style=\"width:400px;\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${JobBean.title}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\" maxlength=\"42\"/></td>\r\n");
      out.write("\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td bgcolor=\"#f9faf0\" class=\"table-title-text\"><span class=\"red-text-w\">*</span>회사명</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td width=\"78%\" bgcolor=\"#FFFFFF\" class=\"table-cont-text\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<input type=\"text\" name=\"company_name_k\" id=\"textfield3\"  style=\"width:240px;\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${JobBean.company_name_k}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\" /></td>\r\n");
      out.write("\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td bgcolor=\"#f9faf0\" class=\"table-title-text\"><span class=\"red-text-w\">*</span>업종</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td width=\"78%\" bgcolor=\"#FFFFFF\" class=\"table-cont-text\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<select name=\"cate_code_2\" id=\"select3\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${JobBean.cate_2Tag}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</select></td>\r\n");
      out.write("\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td bgcolor=\"#f9faf0\" class=\"table-title-text\">지역정보</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td width=\"78%\" bgcolor=\"#FFFFFF\" class=\"table-cont-text\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<select name=\"area_code_1\" id=\"select4\" onchange='return reloadRegist()'>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${JobBean.area_1Tag}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<select name=\"area_code_2\" id=\"select5\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${JobBean.area_2Tag}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<td height=\"30\" align=\"left\" valign=\"bottom\">나머지주소 \r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<input type=\"text\" name=\"area_code_3\" id=\"textfield6\"   align=\"absbottom\" style=\"width:380px;\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${JobBean.area_code_3}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\" /></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</table>\r\n");
      out.write("\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td bgcolor=\"#f9faf0\" class=\"table-title-text\">노선정보</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td width=\"78%\" bgcolor=\"#FFFFFF\" class=\"table-cont-text\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<select name=\"line_code\" id=\"select6\" onchange='return reloadRegist()'>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${JobBean.lineTag}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<select name=\"station_code\" id=\"select7\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${JobBean.stationTag}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t  </select>\r\n");
      out.write("\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td bgcolor=\"#f9faf0\" class=\"table-title-text\">홈페이지</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td width=\"78%\" bgcolor=\"#FFFFFF\" class=\"table-cont-text\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\thttp://<input type=\"text\" name=\"url\" id=\"textfield7\" class=\"idForm\" align=\"absmiddle\" style=\"width:240px;\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${JobBean.url}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\"/></td>\r\n");
      out.write("\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td bgcolor=\"#f9faf0\" class=\"table-title-text\">이메일</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td width=\"78%\" bgcolor=\"#FFFFFF\" class=\"table-cont-text\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<input type=\"text\" name=\"email\" id=\"textfield8\" class=\"idForm\" align=\"absmiddle\" style=\"width:240px;\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${JobBean.email}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\"/></td>\r\n");
      out.write("\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td bgcolor=\"#f9faf0\" class=\"table-title-text\"><span class=\"red-text-w\">*</span>전화번호1</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td width=\"78%\" bgcolor=\"#FFFFFF\" class=\"table-cont-text\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<input name=\"tel_no1_1\" type=\"text\" id=\"textfield9\"  class=\"idForm\" maxlength=\"4\" style=\"width:50px;\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${JobBean.tel_no1_1}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\" />-\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<input name=\"tel_no1_2\" type=\"text\" id=\"textfield10\" class=\"idForm\" maxlength=\"4\" style=\"width:50px;\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${JobBean.tel_no1_2}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\" />-\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<input name=\"tel_no1_3\" type=\"text\" id=\"textfield11\" class=\"idForm\" maxlength=\"4\" style=\"width:50px;\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${JobBean.tel_no1_3}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\" /></td>\r\n");
      out.write("\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td bgcolor=\"#f9faf0\" class=\"table-title-text\">전화번호2</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td bgcolor=\"#FFFFFF\" class=\"table-cont-text\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<input name=\"tel_no2_1\" type=\"text\" id=\"textfield12\" class=\"idForm\" maxlength=\"4\" style=\"width:50px;\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${JobBean.tel_no2_1}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\" />-\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<input name=\"tel_no2_2\" type=\"text\" id=\"textfield13\" class=\"idForm\" maxlength=\"4\" style=\"width:50px;\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${JobBean.tel_no2_2}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\" />-\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<input name=\"tel_no2_3\" type=\"text\" id=\"textfield14\" class=\"idForm\" maxlength=\"4\" style=\"width:50px;\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${JobBean.tel_no2_3}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\" /></td>\r\n");
      out.write("\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td width=\"22%\" bgcolor=\"#f9faf0\" class=\"table-title-text\">담당자명</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td width=\"78%\" bgcolor=\"#FFFFFF\" class=\"table-cont-text\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<input type=\"text\" name=\"charge\" id=\"textfield2\"  style=\"width:400px;\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${JobBean.charge}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\" maxlength=\"20\"/></td>\r\n");
      out.write("\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td bgcolor=\"#f9faf0\" class=\"table-title-text\">성별</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td bgcolor=\"#FFFFFF\" class=\"table-cont-text\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<select name='sex'>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<option value='0' ");
      out.print(jobBean.getSex_selected(0));
      out.write(">남녀무관</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<option value='1' ");
      out.print(jobBean.getSex_selected(1));
      out.write(">남</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<option value='2' ");
      out.print(jobBean.getSex_selected(2));
      out.write(">여</option>\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td width=\"22%\" bgcolor=\"#f9faf0\" class=\"table-title-text\">급여조건</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td width=\"78%\" bgcolor=\"#FFFFFF\" class=\"table-cont-text\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<input type=\"text\" name=\"pay\" id=\"textfield2\"  style=\"width:250px;\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${JobBean.pay}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\" maxlength=\"30\"/></td>\r\n");
      out.write("\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td width=\"22%\" bgcolor=\"#f9faf0\" class=\"table-title-text\">근무시간</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td width=\"78%\" bgcolor=\"#FFFFFF\" class=\"table-cont-text\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<input type=\"text\" name=\"work_time\" id=\"textfield2\"  style=\"width:250px;\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${JobBean.work_time}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\" maxlength=\"30\"/>ex)9:00~18:00</td>\r\n");
      out.write("\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td bgcolor=\"#f9faf0\" class=\"table-title-text\">이미지</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td bgcolor=\"#FFFFFF\" class=\"table-cont-text\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<td height=\"30\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t");
      if (_jspx_meth_c_if_4(_jspx_page_context))
        return;
      out.write("\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t  \t<input type=\"file\" name=\"photo_name1\" id=\"fileField\"  style=\"width:300px;\" onChange=\"uploadImageCheck(this, 1)\" />\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<a href=\"javascript:deletePhoto(1);\"><img src=\"jsp/images/new/file-delete_b.gif\"  align=\"absmiddle\" width=\"40\" height=\"22\" /></a>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<td height=\"30\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t");
      if (_jspx_meth_c_if_5(_jspx_page_context))
        return;
      out.write("\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t  \t<input type=\"file\" name=\"photo_name2\" id=\"fileField\"  style=\"width:300px;\" onChange=\"uploadImageCheck(this, 2)\" />\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<a href=\"javascript:deletePhoto(2);\"><img src=\"jsp/images/new/file-delete_b.gif\"  align=\"absmiddle\" width=\"40\" height=\"22\" /></a>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<td height=\"30\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t");
      if (_jspx_meth_c_if_6(_jspx_page_context))
        return;
      out.write("\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t  \t<input type=\"file\" name=\"photo_name3\" id=\"fileField\"  style=\"width:300px;\" onChange=\"uploadImageCheck(this, 3)\" />\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<a href=\"javascript:deletePhoto(3);\"><img src=\"jsp/images/new/file-delete_b.gif\"  align=\"absmiddle\" width=\"40\" height=\"22\" /></a>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<td height=\"30\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t");
      if (_jspx_meth_c_if_7(_jspx_page_context))
        return;
      out.write("\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t  \t<input type=\"file\" name=\"photo_name4\" id=\"fileField\"  style=\"width:300px;\" onChange=\"uploadImageCheck(this, 4)\" />\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<a href=\"javascript:deletePhoto(4);\"><img src=\"jsp/images/new/file-delete_b.gif\"  align=\"absmiddle\" width=\"40\" height=\"22\" /></a>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<td height=\"30\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t");
      if (_jspx_meth_c_if_8(_jspx_page_context))
        return;
      out.write("\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t  \t<input type=\"file\" name=\"photo_name5\" id=\"fileField\"  style=\"width:300px;\" onChange=\"uploadImageCheck(this, 5)\" />\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<a href=\"javascript:deletePhoto(5);\"><img src=\"jsp/images/new/file-delete_b.gif\"  align=\"absmiddle\" width=\"40\" height=\"22\" /></a>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<td height=\"30\"><strong class=\"red-text-w\">※</strong>JPEG GIF이외의 확장자,2M이상의 이미지파일은 등록이 되지 않습니다. </td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</tr>\t\t\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</table>\r\n");
      out.write("\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td bgcolor=\"#f9faf0\" class=\"table-title-text\">상세정보</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td bgcolor=\"#FFFFFF\" class=\"table-cont-text\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<textarea name=\"detail_info\" id=\"textarea\" cols=\"45\" rows=\"5\" style=\"width:530px;height:300px;\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${StoreBean.detail_info}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("</textarea></td>\r\n");
      out.write("\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t</table>\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t</table>\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td valign=\"top\">&nbsp;</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td align=\"center\" valign=\"top\">\r\n");
      out.write("\t\t\t\t\t<a href=\"javascript:registCheck(wf);\"><img src=\"jsp/images/new/storeregist_up_b.gif\" width=\"117\" height=\"35\" /></a>&nbsp;\r\n");
      out.write("\t\t\t\t\t<a href=\"javascript:backSearch();\"><img src=\"jsp/images/new/storeregist_list_b.gif\" width=\"136\" height=\"35\" /></a></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t</table>\r\n");
      out.write("\t\t\t</form>\r\n");
      out.write("\t\t</td>\t\t\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td height=\"50\">&nbsp;</td>\r\n");
      out.write("\t</tr>\r\n");
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

  private boolean _jspx_meth_c_if_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_0.setPageContext(_jspx_page_context);
    _jspx_th_c_if_0.setParent(null);
    _jspx_th_c_if_0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${JobBean.cate_code_1 == 'C10100'}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
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
    _jspx_th_c_out_0.setValue(new String("사원구인 등록화면"));
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
    _jspx_th_c_if_1.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${JobBean.cate_code_1 == 'C10200'}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
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
    _jspx_th_c_out_1.setValue(new String("알바구인 등록화면"));
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

  private boolean _jspx_meth_c_if_2(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_2 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_2.setPageContext(_jspx_page_context);
    _jspx_th_c_if_2.setParent(null);
    _jspx_th_c_if_2.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${JobBean.cate_code_1 == 'C10100'}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_if_2 = _jspx_th_c_if_2.doStartTag();
    if (_jspx_eval_c_if_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t\t<td valign=\"top\" width=\"736\" height=\"82\"><img src=\"jsp/images/new/reg_title_staff_job.gif\" /></td>\r\n");
        out.write("\t\t\t\t");
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
    _jspx_th_c_if_3.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${JobBean.cate_code_1 == 'C10200'}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_if_3 = _jspx_th_c_if_3.doStartTag();
    if (_jspx_eval_c_if_3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t\t<td valign=\"top\" width=\"736\" height=\"82\"><img src=\"jsp/images/new/reg_title_arbeit_job.gif\" /></td>\r\n");
        out.write("\t\t\t\t");
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
    _jspx_th_c_if_4.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${!empty JobBean.photo_path1}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_if_4 = _jspx_th_c_if_4.doStartTag();
    if (_jspx_eval_c_if_4 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t\t\t<img src=\"");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${JobBean.photo_path1}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
        out.write("\" alt=\"\" align=\"absmiddle\" width=\"30\" height=\"30\">\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t\t");
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
    _jspx_th_c_if_5.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${!empty JobBean.photo_path2}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_if_5 = _jspx_th_c_if_5.doStartTag();
    if (_jspx_eval_c_if_5 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t\t\t<img src=\"");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${JobBean.photo_path2}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
        out.write("\" alt=\"\" align=\"absmiddle\" width=\"30\" height=\"30\">\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t\t");
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
    _jspx_th_c_if_6.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${!empty JobBean.photo_path3}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_if_6 = _jspx_th_c_if_6.doStartTag();
    if (_jspx_eval_c_if_6 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t\t\t<img src=\"");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${JobBean.photo_path3}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
        out.write("\" alt=\"\" align=\"absmiddle\" width=\"30\" height=\"30\">\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t\t");
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

  private boolean _jspx_meth_c_if_7(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_7 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_7.setPageContext(_jspx_page_context);
    _jspx_th_c_if_7.setParent(null);
    _jspx_th_c_if_7.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${!empty JobBean.photo_path4}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_if_7 = _jspx_th_c_if_7.doStartTag();
    if (_jspx_eval_c_if_7 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t\t\t<img src=\"");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${JobBean.photo_path4}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
        out.write("\" alt=\"\" align=\"absmiddle\" width=\"30\" height=\"30\">\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t\t");
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

  private boolean _jspx_meth_c_if_8(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_8 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_8.setPageContext(_jspx_page_context);
    _jspx_th_c_if_8.setParent(null);
    _jspx_th_c_if_8.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${!empty JobBean.photo_path5}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_if_8 = _jspx_th_c_if_8.doStartTag();
    if (_jspx_eval_c_if_8 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t\t\t<img src=\"");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${JobBean.photo_path5}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
        out.write("\" alt=\"\" align=\"absmiddle\" width=\"30\" height=\"30\">\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t\t");
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
}