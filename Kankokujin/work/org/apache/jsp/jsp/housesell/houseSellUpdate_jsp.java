package org.apache.jsp.jsp.housesell;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import housesell.bean.HouseBean;
import housesell.bean.HouseSearchBean;
import common.util.Util;
import common.constant.Const;

public final class houseSellUpdate_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static java.util.List _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList(2);
    _jspx_dependants.add("/WEB-INF/tlds/pageHandleTag.tld");
    _jspx_dependants.add("/WEB-INF/tlds/utilFunction.tld");
  }

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_fmt_setLocale_value_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_fmt_setBundle_var_basename_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_out_value_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_fmt_message_key_bundle_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_if_test;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_fmt_setLocale_value_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_fmt_setBundle_var_basename_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_out_value_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_fmt_message_key_bundle_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_if_test = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_fmt_setLocale_value_nobody.release();
    _jspx_tagPool_fmt_setBundle_var_basename_nobody.release();
    _jspx_tagPool_c_out_value_nobody.release();
    _jspx_tagPool_fmt_message_key_bundle_nobody.release();
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
HouseBean houseBean = (HouseBean) request.getAttribute("HouseBean");
HouseSearchBean houseSearchBean = (HouseSearchBean) request.getAttribute("HouseSearchBean");

      out.write("\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<meta http-equiv=\"Content-type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write(" <head>\r\n");
      out.write("<title>");
      if (_jspx_meth_c_out_0(_jspx_page_context))
        return;
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
      out.write("\tfunction radioCheck(value){\r\n");
      out.write(" \t\tif(value == \"1\" ) {\r\n");
      out.write("\t\t \tdocument.wf.area_fast.disabled=false;\r\n");
      out.write("\t\t \tdocument.wf.area_code_1.disabled=true;\r\n");
      out.write("\t\t \tdocument.wf.area_code_2.disabled=true;\r\n");
      out.write("\t \t}else if(value == \"2\" ){\r\n");
      out.write(" \t\t\tdocument.wf.area_fast.disabled=true;\r\n");
      out.write("\t\t\tdocument.wf.area_code_1.disabled=false;\r\n");
      out.write("\t\t\tdocument.wf.area_code_2.disabled=false;\r\n");
      out.write(" \t\t}\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction radioCheckDock(value){\r\n");
      out.write(" \t\tif(value == \"1\" ) {\r\n");
      out.write("\t\t \tdocument.wf.come_dock_year.disabled=true;\r\n");
      out.write("\t\t \tdocument.wf.come_dock_month.disabled=true;\r\n");
      out.write("\t \t}else if(value == \"2\" ){\r\n");
      out.write(" \t\t\tdocument.wf.come_dock_year.disabled=false;\r\n");
      out.write("\t\t\tdocument.wf.come_dock_month.disabled=false;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\t\r\n");
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
      out.write("\t}\r\n");
      out.write("\tfunction modifycheck(ff) {\r\n");
      out.write("\t\tID = /^[0-9]{1,4}/;\r\n");
      out.write("\t\tif(isNull(ff.title)) {\r\n");
      out.write("\t\t\talert(\"제목을 입력해 주세요.\");\r\n");
      out.write("\t\t\treturn;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tif(!isNull(ff.build_year) && !isNumber(ff.build_year)) {\r\n");
      out.write("\t\t\talert(\"건축년도(년)은 숫자로 입력해주세요.\");\r\n");
      out.write("\t\t\treturn;\r\n");
      out.write("\t\t}\t\r\n");
      out.write("\t\r\n");
      out.write("\t\tif(!isNull(ff.build_month) && !isNumber(ff.build_month)) {\r\n");
      out.write("\t\t\talert(\"건축년도(월)은 숫자로 입력해주세요.\");\r\n");
      out.write("\t\t\treturn;\r\n");
      out.write("\t\t}\t\r\n");
      out.write("\t\tif(!isNull(ff.all_stairs) && !isNumber(ff.all_stairs)) {\r\n");
      out.write("\t\t\talert(\"전체층수는 숫자로 입력해주세요.\");\r\n");
      out.write("\t\t\treturn;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tif(!isNull(ff.stairs) && !isNumber(ff.stairs)) {\r\n");
      out.write("\t\t\talert(\"층은 숫자로 입력해주세요.\");\r\n");
      out.write("\t\t\treturn;\r\n");
      out.write("\t\t}\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\tif(ff.area_code_1.value !=\"00\" && ff.area_code_2.value.substring(2, 4)==\"00\") {\r\n");
      out.write("\t\t\talert(\"지역상세정보를 선택해 주세요.\");\r\n");
      out.write("\t\t\treturn;\r\n");
      out.write("\t\t} \t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tif(ff.line_code.value !=\"00\" && ff.station_code.value.substring(2, 4)==\"00\") {\r\n");
      out.write("\t\t\talert(\"역 정보를 선택해 주세요.\");\r\n");
      out.write("\t\t\treturn;\r\n");
      out.write("\t\t} \t\t\r\n");
      out.write("\t\tif(!isNull(ff.walk_time) && !isNumber(ff.walk_time)) {\r\n");
      out.write("\t\t\talert(\"도보시간은 숫자로 입력해주세요.\");\r\n");
      out.write("\t\t\treturn;\r\n");
      out.write("\t\t}\t\r\n");
      out.write("\t\tif(!isNull(ff.come_dock_year) && !isNumber(ff.come_dock_year)) {\r\n");
      out.write("\t\t\talert(\"입거가능일(년)은 숫자로 입력해주세요.\");\r\n");
      out.write("\t\t\treturn;\r\n");
      out.write("\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\tif(!isNull(ff.come_dock_month) && !isNumber(ff.come_dock_month)) {\r\n");
      out.write("\t\t\talert(\"입거가능일(월)은 숫자로 입력해주세요.\");\r\n");
      out.write("\t\t\treturn;\r\n");
      out.write("\t\t}\t\t\t\t\r\n");
      out.write("\t\tif(!isNull(ff.house_fee) && !isNumSosu(ff.house_fee)) {\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\talert(\"야칭은 숫자로 입력해주세요.\");\r\n");
      out.write("\t\t\treturn;\r\n");
      out.write("\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\tif(!isNull(ff.manage_fee) && !isNumSosu(ff.manage_fee)) {\r\n");
      out.write("\t\t\talert(\"관리비/기타은 숫자로 입력해주세요.\");\r\n");
      out.write("\t\t\treturn;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tif(!isNull(ff.deposit) && !isNumSosu(ff.deposit)) {\r\n");
      out.write("\t\t\talert(\"시끼낑은 숫자로 입력해주세요.\");\r\n");
      out.write("\t\t\treturn;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tif(!isNull(ff.reikin) && !isNumSosu(ff.reikin)) {\r\n");
      out.write("\t\t\talert(\"레이낑은 숫자로 입력해주세요.\");\r\n");
      out.write("\t\t\treturn;\r\n");
      out.write("\t\t}\t\r\n");
      out.write("\t\tif(!isNull(ff.guaranty_money) && !isNumSosu(ff.guaranty_money)) {\r\n");
      out.write("\t\t\talert(\"보증금은 숫자로 입력해주세요.\");\r\n");
      out.write("\t\t\treturn;\r\n");
      out.write("\t\t}\t\r\n");
      out.write("\r\n");
      out.write("\t\tif(!isNull(ff.dimension) && !isNumSosu(ff.dimension)) {\r\n");
      out.write("\t\t\talert(\"전용면적은 숫자로 입력해주세요.\");\r\n");
      out.write("\t\t\treturn;\r\n");
      out.write("\t\t}\t\t\t\r\n");
      out.write("\t\tif(!isNull(ff.email) && !isEmail(ff.email.value)) {\r\n");
      out.write("\t\t\talert(\"예)itfrees@itfrees.com형식으로 입력해주세요.\");\r\n");
      out.write("\t\t\treturn;\r\n");
      out.write("\t\t}\t\t\t\r\n");
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
      out.write("\t\t}\t\t\t\r\n");
      out.write("\t\tff.action=\"HouseSellUpdate?\";\r\n");
      out.write("\t\tff.submit(); \r\n");
      out.write("\t\treturn true;\r\n");
      out.write("\t\t\r\n");
      out.write("\t}\t\r\n");
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
      out.write("\tfunction isValidFormat(obj,format) {\r\n");
      out.write("\t\tif(obj.value.search(format) != -1) {\r\n");
      out.write("\t\t\treturn true;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\treturn false;\r\n");
      out.write("\t}\t\r\n");
      out.write("\tfunction isPhoneNumber(obj) {\r\n");
      out.write("\t\tif(obj.value == \"\") {\r\n");
      out.write("\t\t\treturn true;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tvar format = /^(\\d+)-(\\d+)-(\\d+)$/;\r\n");
      out.write("\t\treturn isValidFormat(obj,format);\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction reloadCheck(ff){\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\tff.action=\"HouseSellUpdateOpen\";\r\n");
      out.write("\t\tff.submit(); \r\n");
      out.write("\t\treturn true;\r\n");
      out.write("\t}\t\r\n");
      out.write("\tfunction containsCharsOnly(input,chars) {\r\n");
      out.write("\t    for (var inx = 0; inx < input.value.length; inx++) {\r\n");
      out.write("\r\n");
      out.write("\t       if (chars.indexOf(input.value.charAt(inx)) == -1){\r\n");
      out.write("\t           return false;\r\n");
      out.write("\t       } else {\r\n");
      out.write("\t           \r\n");
      out.write("\t       }\r\n");
      out.write("\t    }\r\n");
      out.write("\t    return true;\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction isNumComma(input) {\r\n");
      out.write("\t\t\r\n");
      out.write("\t    var chars = \",0123456789\";\r\n");
      out.write("\t    return containsCharsOnly(input,chars);\r\n");
      out.write("\t}\t\r\n");
      out.write("\tfunction isNumSosu(input) {\r\n");
      out.write("\t    var chars = \".0123456789\";\r\n");
      out.write("\t    return containsCharsOnly(input,chars);\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction backDetailPage() {\r\n");
      out.write("\t\tdocument.wf.action=\"HouseSellDetail\";\r\n");
      out.write("\t\tdocument.wf.submit(); \r\n");
      out.write("\t\treturn true;\r\n");
      out.write("\t}\t\r\n");
      out.write("\tfunction deletePhoto(index) {\r\n");
      out.write("\t\tdocument.wf.action=\"HouseSellUpdateOpen?del=\"+index;\r\n");
      out.write("\t\tdocument.wf.submit(); \r\n");
      out.write("\t\treturn true;\r\n");
      out.write("\t}\t\r\n");
      out.write("//-->\r\n");
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
      out.write("\t<tr>\r\n");
      out.write("\t\t<td height=\"35\">\r\n");
      out.write("\t\t\t<form name=\"wf\" method=\"post\" enctype=\"multipart/form-data\">\r\n");
      out.write("\t\t\t<input type=\"hidden\" name=\"id\" value=\"");
      out.print(houseBean.getId() );
      out.write("\">\r\n");
      out.write("\t\t\t<input type=\"hidden\" name=\"image1\" value=\"");
      out.print(houseBean.getPhoto_name1());
      out.write("\"> \r\n");
      out.write("   \t\t\t<input type=\"hidden\" name=\"image2\" value=\"");
      out.print(houseBean.getPhoto_name2());
      out.write("\"> \r\n");
      out.write("   \t\t\t<input type=\"hidden\" name=\"image3\" value=\"");
      out.print(houseBean.getPhoto_name3());
      out.write("\"> \r\n");
      out.write("   \t\t\t<input type=\"hidden\" name=\"image4\" value=\"");
      out.print(houseBean.getPhoto_name4());
      out.write("\"> \r\n");
      out.write("   \t\t\t<input type=\"hidden\" name=\"image5\" value=\"");
      out.print(houseBean.getPhoto_name5());
      out.write("\"> \r\n");
      out.write("   \t\t\t<input type=\"hidden\" name=\"before\" value=\"");
      out.print(houseSearchBean.getBefore());
      out.write("\">      \t\t\t\t\t\t\r\n");
      out.write("\t\t\t<input type=\"hidden\" name=\"user_id\" value=\"");
      out.print(houseSearchBean.getUser_id());
      out.write("\">      \t\t\t\t\t\t\r\n");
      out.write("  \t\t\t<input type=\"hidden\" name=\"pageSize\" value=\"");
      out.print(houseSearchBean.getPageSize());
      out.write("\">      \t\t\t\r\n");
      out.write("  \t\t\t<input type=\"hidden\" name=\"pageNum\" value=\"");
      out.print(houseSearchBean.getPageNum());
      out.write("\">      \t\t\t  \t\t\t      \t\t\t      \t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t<input type=\"hidden\" name=\"search_area_code_1\" value=\"");
      out.print(houseSearchBean.getArea_code_1());
      out.write("\">      \t\t\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t<input type=\"hidden\" name=\"search_area_code_2\" value=\"");
      out.print(houseSearchBean.getArea_code_2());
      out.write("\">      \t\t\t\t\t\t\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t<input type=\"hidden\" name=\"search_line_code\" value=\"");
      out.print(houseSearchBean.getLine_code());
      out.write("\">      \t\t\t\t\t\t\r\n");
      out.write("\t\t\t<input type=\"hidden\" name=\"search_station_code\" value=\"");
      out.print(houseSearchBean.getStation_code());
      out.write("\">      \t\t\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t<input type=\"hidden\" name=\"search_walk_time\" value=\"");
      out.print(houseSearchBean.getWalk_time());
      out.write("\">      \t\t\t\t\t\t\r\n");
      out.write("\t\t\t<input type=\"hidden\" name=\"search_regist_date\" value=\"");
      out.print(houseSearchBean.getRegist_date());
      out.write("\">      \t\t\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t<input type=\"hidden\" name=\"search_build_year\" value=\"");
      out.print(houseSearchBean.getBuild_year());
      out.write("\">      \t\t\t\t\t\t\r\n");
      out.write("\t\t\t<input type=\"hidden\" name=\"search_flg_tadami\" value=\"");
      out.print(houseSearchBean.getFlg_tadami());
      out.write("\">      \t\t\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t<input type=\"hidden\" name=\"search_toilet\" value=\"");
      out.print(houseSearchBean.getToilet());
      out.write("\">      \t\t\t\t\t\t\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t<input type=\"hidden\" name=\"house_fee_from\" value=\"");
      out.print(houseSearchBean.getHouse_fee(0));
      out.write("\">      \t\t\t\t\t\t\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t<input type=\"hidden\" name=\"house_fee_to\" value=\"");
      out.print(houseSearchBean.getHouse_fee(1));
      out.write("\">      \t\t\t\t\t\t\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t<input type=\"hidden\" name=\"dimension_1\" value=\"");
      out.print(houseSearchBean.getDimension(0));
      out.write("\">      \t\t\t\t\t\t\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t<input type=\"hidden\" name=\"dimension_2\" value=\"");
      out.print(houseSearchBean.getDimension(1));
      out.write("\">      \t\t\t\t\t\t\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t<input type=\"hidden\" name=\"madori_0\" value=\"");
      out.print(houseSearchBean.getMadori(0));
      out.write("\">      \t\t\t\t\t\t\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t<input type=\"hidden\" name=\"madori_1\" value=\"");
      out.print(houseSearchBean.getMadori(1));
      out.write("\">      \t\t\t\t\t\t\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t<input type=\"hidden\" name=\"madori_2\" value=\"");
      out.print(houseSearchBean.getMadori(2));
      out.write("\">      \t\t\t\t\t\t\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t<input type=\"hidden\" name=\"madori_3\" value=\"");
      out.print(houseSearchBean.getMadori(3));
      out.write("\">      \t\t\t\t\t\t\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t<input type=\"hidden\" name=\"madori_4\" value=\"");
      out.print(houseSearchBean.getMadori(4));
      out.write("\">      \t\t\t\t\t\t\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t<input type=\"hidden\" name=\"madori_5\" value=\"");
      out.print(houseSearchBean.getMadori(5));
      out.write("\">      \t\t\t\t\t\t\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t<input type=\"hidden\" name=\"madori_6\" value=\"");
      out.print(houseSearchBean.getMadori(6));
      out.write("\">      \t\t\t\t\t\t\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t<input type=\"hidden\" name=\"madori_7\" value=\"");
      out.print(houseSearchBean.getMadori(7));
      out.write("\">      \t\t\t\t\t\t\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t<input type=\"hidden\" name=\"madori_8\" value=\"");
      out.print(houseSearchBean.getMadori(8));
      out.write("\">      \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t<input type=\"hidden\" name=\"madori_9\" value=\"");
      out.print(houseSearchBean.getMadori(9));
      out.write("\">      \t\t\t\t\t\t\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t<input type=\"hidden\" name=\"madori_10\" value=\"");
      out.print(houseSearchBean.getMadori(10));
      out.write("\">      \t\t\t\t\t\t\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t<input type=\"hidden\" name=\"madori_11\" value=\"");
      out.print(houseSearchBean.getMadori(11));
      out.write("\">      \t\t\t\t\t\t\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t<input type=\"hidden\" name=\"house_sort_0\" value=\"");
      out.print(houseSearchBean.getHouse_sort(0));
      out.write("\">      \t\t\t\t\t\t\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t<input type=\"hidden\" name=\"house_sort_1\" value=\"");
      out.print(houseSearchBean.getHouse_sort(1));
      out.write("\">      \t\t\t\t\t\t\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t<input type=\"hidden\" name=\"house_sort_2\" value=\"");
      out.print(houseSearchBean.getHouse_sort(2));
      out.write("\">      \t\t\t\t\t\t\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t<input type=\"hidden\" name=\"house_sort_3\" value=\"");
      out.print(houseSearchBean.getHouse_sort(3));
      out.write("\">      \t\t\t\t\t\t\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t<input type=\"hidden\" name=\"house_sort_4\" value=\"");
      out.print(houseSearchBean.getHouse_sort(4));
      out.write("\">      \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t<input type=\"hidden\" name=\"house_sort_5\" value=\"");
      out.print(houseSearchBean.getHouse_sort(5));
      out.write("\">      \t\t\t\t\t\t\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t<input type=\"hidden\" name=\"house_sort_6\" value=\"");
      out.print(houseSearchBean.getHouse_sort(6));
      out.write("\">      \t\t\t\t\t\t\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t<input type=\"hidden\" name=\"house_sort_7\" value=\"");
      out.print(houseSearchBean.getHouse_sort(7));
      out.write("\">      \t\t\t\t\t\t\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t<input type=\"hidden\" name=\"house_option_0\" value=\"");
      out.print(houseSearchBean.getHouse_option(0));
      out.write("\">      \t\t\t\t\t\t\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t<input type=\"hidden\" name=\"house_option_1\" value=\"");
      out.print(houseSearchBean.getHouse_option(1));
      out.write("\">      \t\t\t\t\t\t\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t<input type=\"hidden\" name=\"house_option_2\" value=\"");
      out.print(houseSearchBean.getHouse_option(2));
      out.write("\">      \t\t\t\t\t\t\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t<input type=\"hidden\" name=\"house_option_3\" value=\"");
      out.print(houseSearchBean.getHouse_option(3));
      out.write("\">\r\n");
      out.write("\t\t\t<table width=\"736\"  border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\">\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td valign=\"top\" width=\"736\" height=\"82\"><img src=\"jsp/images/new/housesell_edit_title.gif\"/></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td valign=\"top\">&nbsp;</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td valign=\"top\">\r\n");
      out.write("\t\t\t\t\t※ 필수항목 (<span class=\"red-text-w\">*</span>표시) 만 입력해도 가능합니다. 선택항목을 입력하면 보다 편리한 정보로 검색되실 수   있습니다. <br />\r\n");
      out.write("\t\t\t\t\t※ 일본어명, 한글명 둘 중 하나만 입력 하셔도 등록이 가능합니다. \r\n");
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
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${HouseBean.title}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\" maxlength=\"42\"/></td>\r\n");
      out.write("\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td bgcolor=\"#f9faf0\" class=\"table-title-text\">집물건명</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td width=\"78%\" bgcolor=\"#FFFFFF\" class=\"table-cont-text\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<input type=\"text\" name=\"house_name\" id=\"textfield3\"  style=\"width:200px;\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${HouseBean.house_name}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\" maxlength=\"20\"/>\r\n");
      out.write("\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td bgcolor=\"#f9faf0\" class=\"table-title-text\">건축년도</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t <td width=\"78%\" bgcolor=\"#FFFFFF\" class=\"table-cont-text\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<input type=\"text\" name=\"build_year\" id=\"textfield3\"  style=\"width:55px;\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${HouseBean.build_year}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\" maxlength=\"4\"/>년\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<input type=\"text\" name=\"build_month\" id=\"textfield3\"  style=\"width:40px;\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${HouseBean.build_month}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\" maxlength=\"2\"/>월</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td bgcolor=\"#f9faf0\" class=\"table-title-text\">건물층수</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td width=\"78%\" bgcolor=\"#FFFFFF\" class=\"table-cont-text\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<input type=\"text\" name=\"all_stairs\" id=\"textfield3\"  style=\"width:45px;\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${HouseBean.all_stairs}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\" maxlength=\"3\"/>층 건물에\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<input type=\"text\" name=\"stairs\" id=\"textfield3\"  style=\"width:40px;\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${HouseBean.stairs}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\" maxlength=\"3\"/>층(예.5층건물에 3층)</td>\r\n");
      out.write("\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td bgcolor=\"#f9faf0\" class=\"table-title-text\">건물종류</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td width=\"78%\" bgcolor=\"#FFFFFF\" class=\"table-cont-text\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<input value=\"0\" type=\"radio\" name=\"house_sort\" ");
      out.print(houseBean.getHouse_sort_checked(0));
      out.write(" />아파트\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<input value=\"1\" type=\"radio\" name=\"house_sort\" ");
      out.print(houseBean.getHouse_sort_checked(1));
      out.write(" />맨션\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<input value=\"2\" type=\"radio\" name=\"house_sort\" ");
      out.print(houseBean.getHouse_sort_checked(2));
      out.write(" />개인주택\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<input value=\"3\" type=\"radio\" name=\"house_sort\" ");
      out.print(houseBean.getHouse_sort_checked(3));
      out.write(" />주차장<br />\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<input value=\"4\" type=\"radio\" name=\"house_sort\" ");
      out.print(houseBean.getHouse_sort_checked(4));
      out.write(" />점포\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<input value=\"5\" type=\"radio\" name=\"house_sort\" ");
      out.print(houseBean.getHouse_sort_checked(5));
      out.write(" />사무실\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<input value=\"6\" type=\"radio\" name=\"house_sort\" ");
      out.print(houseBean.getHouse_sort_checked(6));
      out.write(" />토지\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<input value=\"7\" type=\"radio\" name=\"house_sort\" ");
      out.print(houseBean.getHouse_sort_checked(7));
      out.write(" />기타\r\n");
      out.write("\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td bgcolor=\"#f9faf0\" class=\"table-title-text\">지역정보</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td width=\"78%\" bgcolor=\"#FFFFFF\" class=\"table-cont-text\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<select name=\"area_code_1\" id=\"select4\" onchange='return reloadCheck(wf)'>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${HouseBean.area_1Tag}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<select name=\"area_code_2\" id=\"select5\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${HouseBean.area_2Tag}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<td height=\"30\" align=\"left\" valign=\"bottom\">나머지주소 \r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<input type=\"text\" name=\"area_code_3\" id=\"textfield6\"   align=\"absbottom\" style=\"width:380px;\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${HouseBean.area_code_3}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\" /></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</table>\r\n");
      out.write("\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td bgcolor=\"#f9faf0\" class=\"table-title-text\">노선정보</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td width=\"78%\" bgcolor=\"#FFFFFF\" class=\"table-cont-text\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<select name=\"line_code\" id=\"select6\" onchange='return reloadCheck(wf)'>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${HouseBean.lineTag}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<select name=\"station_code\" id=\"select7\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${HouseBean.stationTag}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</select> 역에서 도보 <input type=\"text\" name=\"walk_time\" id=\"textfield3\"  style=\"width:45px;\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${HouseBean.walk_time}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\" maxlength=\"2\"/>분\r\n");
      out.write("\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td bgcolor=\"#f9faf0\" class=\"table-title-text\">입거가능일</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td width=\"78%\" bgcolor=\"#FFFFFF\" class=\"table-cont-text\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<input value=\"0\" type=\"radio\" name=\"come_dock\" ");
      out.print(houseBean.getCome_dockChecked(0));
      out.write(" onclick=\"radioCheckDock(1)\" />즉시&nbsp;&nbsp;&nbsp;\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<input value=\"1\" type=\"radio\" name=\"come_dock\" ");
      out.print(houseBean.getCome_dockChecked(1));
      out.write(" onclick=\"radioCheckDock(2)\" />지정일&nbsp;\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<input type=\"text\" name=\"come_dock_year\" id=\"textfield7\" align=\"absmiddle\" style=\"width:50px;\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${HouseBean.come_dock_year}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write('"');
      out.write(' ');
      out.print(houseBean.getCome_dock_disabled());
      out.write(" maxlength=\"4\"/>년(2008)\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<input type=\"text\" name=\"come_dock_month\" id=\"textfield7\" align=\"absmiddle\" style=\"width:50px;\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${HouseBean.come_dock_month}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write('"');
      out.write(' ');
      out.print(houseBean.getCome_dock_disabled());
      out.write(" maxlength=\"2\"/>월(07)\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td bgcolor=\"#f9faf0\" class=\"table-title-text\">야칭</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td width=\"78%\" bgcolor=\"#FFFFFF\" class=\"table-cont-text\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<input type=\"text\" name=\"house_fee\" id=\"textfield7\"   align=\"absmiddle\" style=\"width:55px;\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${HouseBean.house_fee[0]}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\" maxlength=\"5\"/>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t&nbsp;만엔&nbsp;&nbsp;(야칭은 3.0의 형식으로 소수점 단위로 입력해주세요.)\r\n");
      out.write("\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td bgcolor=\"#f9faf0\" class=\"table-title-text\">관리비/기타</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td width=\"78%\" bgcolor=\"#FFFFFF\" class=\"table-cont-text\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<input type=\"text\" name=\"manage_fee\" id=\"textfield7\"   align=\"absmiddle\" style=\"width:55px;\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${HouseBean.manage_fee}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\" maxlength=\"5\"/>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t&nbsp;만엔&nbsp; / 시끼낑\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<input type=\"text\" name=\"deposit\" id=\"textfield7\"   align=\"absmiddle\" style=\"width:50px;\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${HouseBean.deposit}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\" maxlength=\"4\"/>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t&nbsp;개월분 / 레이낑\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<input type=\"text\" name=\"reikin\" id=\"textfield7\"   align=\"absmiddle\" style=\"width:50px;\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${HouseBean.reikin}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\" maxlength=\"4\"/>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t&nbsp;개월분/ 보증금\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<input type=\"text\" name=\"guaranty_money\" id=\"textfield7\"   align=\"absmiddle\" style=\"width:50px;\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${HouseBean.guaranty_money}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\" maxlength=\"4\"/>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t&nbsp;개월분\r\n");
      out.write("\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td bgcolor=\"#f9faf0\" class=\"table-title-text\">전용면적</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td width=\"78%\" bgcolor=\"#FFFFFF\" class=\"table-cont-text\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<input type=\"text\" name=\"dimension\" id=\"textfield7\"   align=\"absmiddle\" style=\"width:50px;\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${HouseBean.dimension[0]}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\" maxlength=\"5\"/>&nbsp;&nbsp;m2\r\n");
      out.write("\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td bgcolor=\"#f9faf0\" class=\"table-title-text\">마도리</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td bgcolor=\"#FFFFFF\" class=\"table-cont-text\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<input value=\"0\" type=\"radio\" name=\"madori\" ");
      out.print(houseBean.getMadori_checked(0));
      out.write(" />1R\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<input value=\"1\" type=\"radio\" name=\"madori\" ");
      out.print(houseBean.getMadori_checked(1));
      out.write(" />1K\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<input value=\"2\" type=\"radio\" name=\"madori\" ");
      out.print(houseBean.getMadori_checked(2));
      out.write(" />1DK\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<input value=\"3\" type=\"radio\" name=\"madori\" ");
      out.print(houseBean.getMadori_checked(3));
      out.write(" />1LDK\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<input value=\"4\" type=\"radio\" name=\"madori\" ");
      out.print(houseBean.getMadori_checked(4));
      out.write(" />2K\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<input value=\"5\" type=\"radio\" name=\"madori\" ");
      out.print(houseBean.getMadori_checked(5));
      out.write(" />2DK \r\n");
      out.write("\t\t\t\t\t\t\t\t\t<input value=\"6\" type=\"radio\" name=\"madori\" ");
      out.print(houseBean.getMadori_checked(6));
      out.write(" />2LDK<br />\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<input value=\"7\" type=\"radio\" name=\"madori\" ");
      out.print(houseBean.getMadori_checked(7));
      out.write(" />3DK\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<input value=\"8\" type=\"radio\" name=\"madori\" ");
      out.print(houseBean.getMadori_checked(8));
      out.write(" />3LDK\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<input value=\"9\" type=\"radio\" name=\"madori\" ");
      out.print(houseBean.getMadori_checked(9));
      out.write(" />4DK\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<input value=\"10\" type=\"radio\" name=\"madori\" ");
      out.print(houseBean.getMadori_checked(10));
      out.write(" />4LDK\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<input value=\"11\" type=\"radio\" name=\"madori\" ");
      out.print(houseBean.getMadori_checked(11));
      out.write(" />기타<br />\r\n");
      out.write("\t\t\t\t\t\t\t\t\t마도리내역\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<input type=\"text\" name=\"madori_info\" id=\"textfield7\"   align=\"absmiddle\" style=\"width:350px;\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${HouseBean.madori_info}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\" maxlength=\"50\"/><br />\r\n");
      out.write("\t\t\t\t\t\t\t\t\t( ex : 일식6조 양식6조 화장실 샤워및욕조 주차장 베란다 )\r\n");
      out.write("\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td bgcolor=\"#f9faf0\" class=\"table-title-text\">방구조</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td bgcolor=\"#FFFFFF\" class=\"table-cont-text\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<input value=\"0\" type=\"radio\" name=\"flg_tadami\" ");
      out.print(houseBean.getFlgTadamiChecked()[0]);
      out.write(" />타다미\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<input value=\"1\" type=\"radio\" name=\"flg_tadami\" ");
      out.print(houseBean.getFlgTadamiChecked()[1]);
      out.write(" />플로링\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<input value=\"2\" type=\"radio\" name=\"flg_tadami\" ");
      out.print(houseBean.getFlgTadamiChecked()[2]);
      out.write(" />타다미 + 플로링\r\n");
      out.write("\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td bgcolor=\"#f9faf0\" class=\"table-title-text\">화장실/목욕탕</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td bgcolor=\"#FFFFFF\" class=\"table-cont-text\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<input value=\"0\" type=\"radio\" name=\"toilet\" ");
      out.print(houseBean.getToilet_checked(0));
      out.write(" />화장실 욕조별도\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<input value=\"1\" type=\"radio\" name=\"toilet\" ");
      out.print(houseBean.getToilet_checked(1));
      out.write(" />화장실 욕조동일\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<input value=\"2\" type=\"radio\" name=\"toilet\" ");
      out.print(houseBean.getToilet_checked(2));
      out.write(" />샤워만\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<input value=\"2\" type=\"radio\" name=\"toilet\" ");
      out.print(houseBean.getToilet_checked(3));
      out.write(" />화장실만\r\n");
      out.write("\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td bgcolor=\"#f9faf0\" class=\"table-title-text\">방위</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td bgcolor=\"#FFFFFF\" class=\"table-cont-text\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<select name=\"point_compass\" id=\"select4\" >\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<option ");
      out.print(houseBean.getPoint_compass_selected()[0]);
      out.write(" value=\"0\">선택해주세요</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<option ");
      out.print(houseBean.getPoint_compass_selected()[1]);
      out.write(" value=\"1\">동향</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<option ");
      out.print(houseBean.getPoint_compass_selected()[2]);
      out.write(" value=\"2\">서향</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<option ");
      out.print(houseBean.getPoint_compass_selected()[3]);
      out.write(" value=\"3\">남향</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<option ");
      out.print(houseBean.getPoint_compass_selected()[4]);
      out.write(" value=\"4\">북향</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td bgcolor=\"#f9faf0\" class=\"table-title-text\">조건</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td bgcolor=\"#FFFFFF\" class=\"table-cont-text\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<input type=\"checkbox\" name=\"option_0\" ");
      out.print(houseBean.getHouse_option_checked(0));
      out.write(" />2인입거가능 &nbsp;\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<input type=\"checkbox\" name=\"option_1\" ");
      out.print(houseBean.getHouse_option_checked(1));
      out.write(" />가족입거가능&nbsp;\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<input type=\"checkbox\" name=\"option_2\" ");
      out.print(houseBean.getHouse_option_checked(2));
      out.write(" />애완동물가능\r\n");
      out.write("\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td bgcolor=\"#f9faf0\" class=\"table-title-text\">이메일</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td width=\"78%\" bgcolor=\"#FFFFFF\" class=\"table-cont-text\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<input type=\"text\" name=\"email\" id=\"textfield8\" class=\"idForm\" align=\"absmiddle\" style=\"width:240px;\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${HouseBean.email}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\"/></td>\r\n");
      out.write("\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td bgcolor=\"#f9faf0\" class=\"table-title-text\"><span class=\"red-text-w\">*</span>전화번호1</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td width=\"78%\" bgcolor=\"#FFFFFF\" class=\"table-cont-text\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<input name=\"tel_no1_1\" type=\"text\" id=\"textfield9\"  class=\"idForm\" maxlength=\"4\" style=\"width:50px;\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${HouseBean.tel_no1_1}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\" />-\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<input name=\"tel_no1_2\" type=\"text\" id=\"textfield10\" class=\"idForm\" maxlength=\"4\" style=\"width:50px;\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${HouseBean.tel_no1_2}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\" />-\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<input name=\"tel_no1_3\" type=\"text\" id=\"textfield11\" class=\"idForm\" maxlength=\"4\" style=\"width:50px;\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${HouseBean.tel_no1_3}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\" /></td>\r\n");
      out.write("\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td bgcolor=\"#f9faf0\" class=\"table-title-text\">전화번호2</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td bgcolor=\"#FFFFFF\" class=\"table-cont-text\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<input name=\"tel_no2_1\" type=\"text\" id=\"textfield12\" class=\"idForm\" maxlength=\"4\" style=\"width:50px;\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${HouseBean.tel_no2_1}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\" />-\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<input name=\"tel_no2_2\" type=\"text\" id=\"textfield13\" class=\"idForm\" maxlength=\"4\" style=\"width:50px;\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${HouseBean.tel_no2_2}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\" />-\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<input name=\"tel_no2_3\" type=\"text\" id=\"textfield14\" class=\"idForm\" maxlength=\"4\" style=\"width:50px;\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${HouseBean.tel_no2_3}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\" /></td>\r\n");
      out.write("\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td bgcolor=\"#f9faf0\" class=\"table-title-text\">도면</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td bgcolor=\"#FFFFFF\" class=\"table-cont-text\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<td height=\"30\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t");
      if (_jspx_meth_c_if_0(_jspx_page_context))
        return;
      out.write("\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t  \t<input type=\"file\" name=\"photo_name1\" id=\"fileField\"  style=\"width:300px;\" onChange=\"uploadImageCheck(this, 1)\" />\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<a href=\"javascript:deletePhoto(1);\"><img src=\"jsp/images/new/file-delete_b.gif\"  align=\"absmiddle\" width=\"40\" height=\"22\" /></a>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</table>\r\n");
      out.write("\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td bgcolor=\"#f9faf0\" class=\"table-title-text\">이미지</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td bgcolor=\"#FFFFFF\" class=\"table-cont-text\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<td height=\"30\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t");
      if (_jspx_meth_c_if_1(_jspx_page_context))
        return;
      out.write("\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t  \t<input type=\"file\" name=\"photo_name2\" id=\"fileField\"  style=\"width:300px;\" onChange=\"uploadImageCheck(this, 2)\" />\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<a href=\"javascript:deletePhoto(2);\"><img src=\"jsp/images/new/file-delete_b.gif\"  align=\"absmiddle\" width=\"40\" height=\"22\" /></a>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<td height=\"30\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t");
      if (_jspx_meth_c_if_2(_jspx_page_context))
        return;
      out.write("\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t  \t<input type=\"file\" name=\"photo_name3\" id=\"fileField\"  style=\"width:300px;\" onChange=\"uploadImageCheck(this, 3)\" />\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<a href=\"javascript:deletePhoto(3);\"><img src=\"jsp/images/new/file-delete_b.gif\"  align=\"absmiddle\" width=\"40\" height=\"22\" /></a>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<td height=\"30\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t");
      if (_jspx_meth_c_if_3(_jspx_page_context))
        return;
      out.write("\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t  \t<input type=\"file\" name=\"photo_name4\" id=\"fileField\"  style=\"width:300px;\" onChange=\"uploadImageCheck(this, 4)\" />\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<a href=\"javascript:deletePhoto(4);\"><img src=\"jsp/images/new/file-delete_b.gif\"  align=\"absmiddle\" width=\"40\" height=\"22\" /></a>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<td height=\"30\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t");
      if (_jspx_meth_c_if_4(_jspx_page_context))
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
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${HouseBean.detail_info}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
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
      out.write("\t\t\t\t\t<a href=\"javascript:modifycheck(wf);\"><img src=\"jsp/images/new/btn_edit_ok.gif\" /></a>&nbsp;\r\n");
      out.write("\t\t\t\t\t<a href=\"javascript:backDetailPage();\"><img src=\"jsp/images/new/btn_back_page.gif\" /></a></td>\r\n");
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

  private boolean _jspx_meth_c_out_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_out_0 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _jspx_tagPool_c_out_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_out_0.setPageContext(_jspx_page_context);
    _jspx_th_c_out_0.setParent(null);
    _jspx_th_c_out_0.setValue(new String("부동산 수정화면"));
    int _jspx_eval_c_out_0 = _jspx_th_c_out_0.doStartTag();
    if (_jspx_th_c_out_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_0);
      return true;
    }
    _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_0);
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
    _jspx_th_c_if_0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${!empty HouseBean.photo_path1}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_if_0 = _jspx_th_c_if_0.doStartTag();
    if (_jspx_eval_c_if_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t\t\t<img src=\"");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${HouseBean.photo_path1}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
        out.write("\" alt=\"\" align=\"absmiddle\" width=\"30\" height=\"30\">\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t\t");
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
    _jspx_th_c_if_1.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${!empty HouseBean.photo_path2}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_if_1 = _jspx_th_c_if_1.doStartTag();
    if (_jspx_eval_c_if_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t\t\t<img src=\"");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${HouseBean.photo_path2}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
        out.write("\" alt=\"\" align=\"absmiddle\" width=\"30\" height=\"30\">\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t\t");
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
    _jspx_th_c_if_2.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${!empty HouseBean.photo_path3}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_if_2 = _jspx_th_c_if_2.doStartTag();
    if (_jspx_eval_c_if_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t\t\t<img src=\"");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${HouseBean.photo_path3}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
        out.write("\" alt=\"\" align=\"absmiddle\" width=\"30\" height=\"30\">\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t\t");
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
    _jspx_th_c_if_3.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${!empty HouseBean.photo_path4}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_if_3 = _jspx_th_c_if_3.doStartTag();
    if (_jspx_eval_c_if_3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t\t\t<img src=\"");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${HouseBean.photo_path4}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
        out.write("\" alt=\"\" align=\"absmiddle\" width=\"30\" height=\"30\">\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t\t");
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
    _jspx_th_c_if_4.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${!empty HouseBean.photo_path5}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_if_4 = _jspx_th_c_if_4.doStartTag();
    if (_jspx_eval_c_if_4 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t\t\t<img src=\"");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${HouseBean.photo_path5}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
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
}
