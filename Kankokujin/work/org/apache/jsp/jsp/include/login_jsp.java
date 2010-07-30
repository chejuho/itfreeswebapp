package org.apache.jsp.jsp.include;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import common.bean.MemberBean;
import common.util.Util;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

static private org.apache.jasper.runtime.ProtectedFunctionMapper _jspx_fnmap_0;

static {
  _jspx_fnmap_0= org.apache.jasper.runtime.ProtectedFunctionMapper.getMapForFunction("util:cutLongName", common.util.Util.class, "cutLongName", new Class[] {int.class, java.lang.String.class});
}

  private static java.util.List _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList(1);
    _jspx_dependants.add("/WEB-INF/tlds/utilFunction.tld");
  }

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_fmt_setLocale_value_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_fmt_setBundle_var_basename_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_fmt_message_key_bundle_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_if_test;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_out_value_nobody;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_fmt_setLocale_value_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_fmt_setBundle_var_basename_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_fmt_message_key_bundle_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_if_test = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_out_value_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_fmt_setLocale_value_nobody.release();
    _jspx_tagPool_fmt_setBundle_var_basename_nobody.release();
    _jspx_tagPool_fmt_message_key_bundle_nobody.release();
    _jspx_tagPool_c_if_test.release();
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
      if (_jspx_meth_fmt_setLocale_0(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
      if (_jspx_meth_fmt_setBundle_0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\r\n");

request.setCharacterEncoding("UTF-8");
String message = (String)Util.changeNullStr(request.getAttribute("Message"));

      out.write('\r');
      out.write('\n');
if(!Util.isEmpty(message)){ 
      out.write("\r\n");
      out.write("<script language=\"javascript\">\r\n");
      out.write("\t");
	if ("MSG0008".equals(message)) {
	
      out.write("\r\n");
      out.write("\t\talert(\"");
      if (_jspx_meth_fmt_message_0(_jspx_page_context))
        return;
      out.write("\");\r\n");
      out.write("\t");

		}else if ("WAR0003".equals(message)) {
	
      out.write("\r\n");
      out.write("\t\talert(\"");
      if (_jspx_meth_fmt_message_1(_jspx_page_context))
        return;
      out.write("\");\r\n");
      out.write("\t");

		}else if ("WAR0004".equals(message)) {
	
      out.write("\r\n");
      out.write("\t\talert(\"");
      if (_jspx_meth_fmt_message_2(_jspx_page_context))
        return;
      out.write("\");\r\n");
      out.write("\t");

		}
	
      out.write("\r\n");
      out.write("</script>\r\n");
} 
      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("<!--\r\n");
      out.write("\tfunction loginform_clearbg(type) {\r\n");
      out.write("\t\tif (type == \"id\") {\r\n");
      out.write("\t\t\tdocument.lf.id.style.backgroundImage = '';\r\n");
      out.write("\t\t} else if (type == \"pw\") {\r\n");
      out.write("\t\t\tdocument.lf.pw.style.backgroundImage = '';\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction loginform_bgChange(obj, act) {\r\n");
      out.write("\t\tif ( act == 'F') {\r\n");
      out.write("\t\t\tobj.className = 'login';\r\n");
      out.write("\t\t\tobj.style.backgroundColor='#FFFFFF';\r\n");
      out.write("\t\t} else {\r\n");
      out.write("\t\t\tobj.className = 'login';\r\n");
      out.write("\t\t\tobj.style.backgroundColor='#FFFFFF';\t\r\n");
      out.write("\t\t}\t\t\t\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction logout() {\t\t\r\n");
      out.write("\t\tdocument.lf.action=\"MemberLogout\";\r\n");
      out.write("\t\tdocument.lf.submit();\t\t\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction login(f) {\r\n");
      out.write("\t\tif(f.id.value==\"\"){\r\n");
      out.write("\t\t\talert(\"아이디를 입력하세요.\");\r\n");
      out.write("\t\t\tf.id.focus();\r\n");
      out.write("\t\t\treturn;\r\n");
      out.write("\t\t}else if(f.pw.value==\"\"){\r\n");
      out.write("\t\t\talert(\"비밀번호를 입력하세요.\");\r\n");
      out.write("\t\t\tf.pw.focus();\r\n");
      out.write("\t\t\treturn;\r\n");
      out.write("\t\t}else{\r\n");
      out.write("\t\t\tsaveid(f);\r\n");
      out.write("\t\t\tf.action=\"MemberLogin\";\r\n");
      out.write("\t\t\tf.submit();\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction Keycode(e){\r\n");
      out.write("\t\tvar result;\r\n");
      out.write("\t\tif(window.event) {\t\t\r\n");
      out.write("\t    \tresult = window.event.keyCode;\r\n");
      out.write("\t    } else if(e) {\r\n");
      out.write("\t\t\tresult = e.which;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\treturn result;\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("//-->\r\n");
      out.write("</script>\r\n");
      out.write("<form name=\"lf\" method=\"post\" style=\"margin:0\">\r\n");
      out.write("\t");
      if (_jspx_meth_c_if_0(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
      out.write('	');
      if (_jspx_meth_c_if_1(_jspx_page_context))
        return;
      out.write("\r\n");
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
    _jspx_th_fmt_message_0.setKey("MSG0008");
    _jspx_th_fmt_message_0.setBundle((javax.servlet.jsp.jstl.fmt.LocalizationContext) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${message}", javax.servlet.jsp.jstl.fmt.LocalizationContext.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_fmt_message_0 = _jspx_th_fmt_message_0.doStartTag();
    if (_jspx_th_fmt_message_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_fmt_message_key_bundle_nobody.reuse(_jspx_th_fmt_message_0);
      return true;
    }
    _jspx_tagPool_fmt_message_key_bundle_nobody.reuse(_jspx_th_fmt_message_0);
    return false;
  }

  private boolean _jspx_meth_fmt_message_1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  fmt:message
    org.apache.taglibs.standard.tag.rt.fmt.MessageTag _jspx_th_fmt_message_1 = (org.apache.taglibs.standard.tag.rt.fmt.MessageTag) _jspx_tagPool_fmt_message_key_bundle_nobody.get(org.apache.taglibs.standard.tag.rt.fmt.MessageTag.class);
    _jspx_th_fmt_message_1.setPageContext(_jspx_page_context);
    _jspx_th_fmt_message_1.setParent(null);
    _jspx_th_fmt_message_1.setKey("WAR0003");
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

  private boolean _jspx_meth_c_if_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_0.setPageContext(_jspx_page_context);
    _jspx_th_c_if_0.setParent(null);
    _jspx_th_c_if_0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${empty memberInfo}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_if_0 = _jspx_th_c_if_0.doStartTag();
    if (_jspx_eval_c_if_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t<!-- LOGIN START -->\r\n");
        out.write("\t\t<table id=\"Table_\" width=\"224\" height=\"134\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\r\n");
        out.write("\t    <tr>\r\n");
        out.write("\t\t\t<td colspan=\"3\"><img src=\"jsp/images/new/login_01.gif\" width=\"224\" height=\"9\" alt=\"\" /></td>\r\n");
        out.write("\t\t</tr>\r\n");
        out.write("\t\t<tr>\r\n");
        out.write("\t\t\t<td><img src=\"jsp/images/new/login_02.gif\" width=\"8\" height=\"118\" alt=\"\" /></td>\r\n");
        out.write("\t\t\t<td width=\"208\" valign=\"top\">\r\n");
        out.write("\t\t\t\t<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n");
        out.write("\t\t\t\t<tr>\r\n");
        out.write("\t\t\t\t\t<td><img src=\"jsp/images/new/main_login_tit.gif\" width=\"208\" height=\"30\" /></td>\r\n");
        out.write("\t \t\t\t\t</tr>\r\n");
        out.write("\t         \t<tr>\r\n");
        out.write("\t\t\t\t\t<td height=\"62\" align=\"center\">\r\n");
        out.write("   \t\t\t\t\t\t<table width=\"96%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n");
        out.write(" \t\t\t\t\t\t<tr>\r\n");
        out.write("   \t\t\t\t\t\t\t<td width=\"26%\" height=\"25\" align=\"left\">아이디</td>\r\n");
        out.write("   \t\t\t\t\t\t\t<td width=\"43%\">\r\n");
        out.write("   \t\t\t\t\t\t\t\t<input type=\"text\" name=\"id\" id=\"textfield2\" class=\"idForm\" style=\"width:80px;\" onkeydown=\"if(Keycode(event) ==13) login(lf);\"\r\n");
        out.write("   \t\t\t\t\t\t\t\t\tonFocus=\"loginform_clearbg('id');loginform_bgChange(this,'F')\" onBlur=\"loginform_bgChange(this,'B');\"  tabindex=\"1\" />\r\n");
        out.write("   \t\t\t\t\t\t\t</td>\r\n");
        out.write("   \t\t\t\t\t\t\t<td width=\"31%\">\r\n");
        out.write("   \t\t\t\t\t\t\t\t<a href=\"javascript:login(lf)\" ><img src=\"jsp/images/new/img_userbox_login.gif\" align=\"absmiddle\" height=\"25\" width=\"60\" border=\"0\" tabindex=\"3\"></a>\r\n");
        out.write("   \t\t\t\t\t\t\t<!--<a href=\"javascript:login(lf)\" target=\"_self\" tabindex=\"3\" >\r\n");
        out.write("   \t\t\t\t\t\t\t\t<img src=\"jsp/images/new/login_b.gif\" width=\"62\" height=\"42\" border=\"0\" /></a>-->\r\n");
        out.write("   \t\t\t\t\t\t\t</td>\r\n");
        out.write(" \t\t\t\t\t\t</tr>\r\n");
        out.write(" \t\t\t\t\t\t<tr>\r\n");
        out.write("  \t\t\t\t\t\t\t<td height=\"25\" align=\"left\">비밀번호</td>\r\n");
        out.write("   \t\t\t\t\t\t\t<td>\r\n");
        out.write("\t   \t\t\t\t\t\t\t<input type=\"password\" name=\"pw\" id=\"textfield3\"  style=\"width:80px;\" onkeydown=\"if(Keycode(event) ==13) login(lf);\"\r\n");
        out.write("\t   \t\t\t\t\t\t\t\t\tonFocus=\"loginform_clearbg('id');loginform_bgChange(this,'F')\" onBlur=\"loginform_bgChange(this,'B');\" \r\n");
        out.write("\t   \t\t\t\t\t\t\t\t\tonMouseDown=\"javascript:MouseUp1=true;\" onKeyDown=\"javascript:KeyUp1=true;\" tabindex=\"2\" />\r\n");
        out.write("   \t\t\t\t\t\t\t</td>\r\n");
        out.write("   \t\t\t\t\t\t\t<td align=\"left\"><input type=\"checkbox\" name=\"checksaveid\" onClick=\"saveid(this.form)\">ID저장</td>\r\n");
        out.write("   \t\t\t\t\t\t</tr>\r\n");
        out.write("   \t\t\t\t\t\t</table>\r\n");
        out.write("\t           \t\t</td>\r\n");
        out.write("\t           \t</tr>\r\n");
        out.write(" \t\t\t\t<tr>\r\n");
        out.write("   \t\t\t\t\t<td height=\"1\" bgcolor=\"#CCCCCC\"></td>\r\n");
        out.write(" \t\t\t\t</tr>\r\n");
        out.write("\t\t\t\t<tr>\r\n");
        out.write("\t                <td align=\"center\"  style=\"padding-top:5px;\">\r\n");
        out.write("\t                \t<span class=\"orange-text\"><strong>&raquo; \r\n");
        out.write("\t                \t\t<a href=\"MemberRegistOpen\" target=\"_self\" class=\"login-link1\" tabindex=\"4\" >회원가입</a></strong></span> &nbsp;&nbsp;\r\n");
        out.write("\t                \t\t<a href=\"MemberFindInfoOpen\" class=\"login-link2\" tabindex=\"5\" >아이디/비밀번호찾기</a>\r\n");
        out.write("\t                </td>\r\n");
        out.write("\t\t\t\t</tr>\r\n");
        out.write("\t   \t\t\t\t\t</table>\r\n");
        out.write("\t   \t\t\t\t</td>\r\n");
        out.write("\t   \t\t\t\t<td><img src=\"jsp/images/new/login_04.gif\" width=\"8\" height=\"118\" alt=\"\" /></td>\r\n");
        out.write("\t \t\t\t</tr>\r\n");
        out.write("\t\t<tr>\r\n");
        out.write("\t\t\t<td colspan=\"3\"><img src=\"jsp/images/new/login_05.gif\" width=\"224\" height=\"7\" alt=\"\" /></td>\r\n");
        out.write("\t\t</tr>\r\n");
        out.write("\t\t</table>\r\n");
        out.write("\t");
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
    _jspx_th_c_if_1.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${!empty memberInfo}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_if_1 = _jspx_th_c_if_1.doStartTag();
    if (_jspx_eval_c_if_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t<table id=\"Table_\" width=\"224\" height=\"134\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\r\n");
        out.write("\t\t<tr>\r\n");
        out.write("\t\t\t<td colspan=\"3\"><img src=\"jsp/images/new/login_01.gif\" width=\"224\" height=\"9\" alt=\"\" /></td>\r\n");
        out.write("\t\t</tr>\r\n");
        out.write("\t\t<tr>\r\n");
        out.write("\t\t\t<td><img src=\"jsp/images/new/login_02.gif\" width=\"8\" height=\"125\" alt=\"\" /></td>\r\n");
        out.write("\t\t    <td width=\"208\" valign=\"top\">\r\n");
        out.write("\t\t    \t<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n");
        out.write("\t\t      \t<tr>\r\n");
        out.write("\t\t        \t<td height=\"30\" align=\"center\" background=\"jsp/images/new/lougout_bg.gif\" class=\"top-text\">\r\n");
        out.write("\t\t        \t\t<strong><img src=\"jsp/images/new/logout_icon1.gif\" align=\"absmiddle\" width=\"16\" height=\"18\" /> Kankokujin.com입니다.</strong>\r\n");
        out.write("\t\t        \t</td>\r\n");
        out.write("\t\t      \t</tr>\r\n");
        out.write("\t\t      \t<tr>\r\n");
        out.write("\t\t        \t<td height=\"85\" align=\"center\"><strong>");
        if (_jspx_meth_c_out_0(_jspx_th_c_if_1, _jspx_page_context))
          return true;
        out.write("</strong>님 <br />\r\n");
        out.write("\t\t          \t\t기분좋은 하루 되세요.<br />\r\n");
        out.write("\t\t          \t\t<a href=\"javascript:logout()\"><img src=\"jsp/images/new/logout_b.gif\" width=\"82\" height=\"24\" /></a>\r\n");
        out.write("\t\t          \t</td>\r\n");
        out.write("\t\t        </tr>\r\n");
        out.write("\t\t    \t</table>\r\n");
        out.write("\t\t    </td>\r\n");
        out.write("\t\t    <td><img src=\"jsp/images/new/login_04.gif\" width=\"8\" height=\"125\" alt=\"\" /></td>\r\n");
        out.write("\t\t  </tr>\r\n");
        out.write("\t\t  <tr>\r\n");
        out.write("\t\t\t<td colspan=\"3\"><img src=\"jsp/images/new/login_05.gif\" width=\"224\" height=\"7\" alt=\"\" /></td>\r\n");
        out.write("\t\t  </tr>\r\n");
        out.write("\t\t</table>\r\n");
        out.write("\t\t<input type=\"hidden\" name=\"checksaveid\">\r\n");
        out.write("\t");
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

  private boolean _jspx_meth_c_out_0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_if_1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_out_0 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _jspx_tagPool_c_out_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_out_0.setPageContext(_jspx_page_context);
    _jspx_th_c_out_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_1);
    _jspx_th_c_out_0.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${util:cutLongName(10,memberInfo.name)}", java.lang.Object.class, (PageContext)_jspx_page_context, _jspx_fnmap_0, false));
    int _jspx_eval_c_out_0 = _jspx_th_c_out_0.doStartTag();
    if (_jspx_th_c_out_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_0);
      return true;
    }
    _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_0);
    return false;
  }
}
