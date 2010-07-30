package org.apache.jsp.jsp.hudousan;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class top_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static java.util.List _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList(1);
    _jspx_dependants.add("/WEB-INF/tlds/pageHandleTag.tld");
  }

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_fmt_setLocale_value_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_fmt_setBundle_var_basename_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_fmt_message_key_bundle_nobody;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_fmt_setLocale_value_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_fmt_setBundle_var_basename_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_fmt_message_key_bundle_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_fmt_setLocale_value_nobody.release();
    _jspx_tagPool_fmt_setBundle_var_basename_nobody.release();
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
      if (_jspx_meth_fmt_setLocale_0(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
      if (_jspx_meth_fmt_setBundle_0(_jspx_page_context))
        return;
      out.write("\t\r\n");
      out.write("\t<table width=\"100%\" border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\">\r\n");
      out.write("\t<tr>\r\n");
      out.write("    \t<td>\r\n");
      out.write("\t\t\t<a href=\"HudousanMainAction\" target=\"_self\">메인으로</a>\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td>&nbsp;</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr>\r\n");
      out.write("    \t<td>\r\n");
      out.write("\t\t\t<table background=\"jsp/images/new/top_bg.gif\" width=\"950\"  border=\"1\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" id=\"Table_01\">\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td align=\"center\"><a href=\"HudousanSearchAction?method=leaseSearchInit\" target=\"_self\">");
      if (_jspx_meth_fmt_message_0(_jspx_page_context))
        return;
      out.write("</a></td>\r\n");
      out.write("\t\t\t\t<td align=\"center\"><a href=\"HudousanSearchAction?method=leaseSuggestInit\" target=\"_self\">");
      if (_jspx_meth_fmt_message_1(_jspx_page_context))
        return;
      out.write("</a></td>\r\n");
      out.write("\t\t\t\t<td align=\"center\"><a href=\"HudousanSearchAction?method=buySearchInit\" target=\"_self\">");
      if (_jspx_meth_fmt_message_2(_jspx_page_context))
        return;
      out.write("</a></td>\r\n");
      out.write("\t\t\t\t<td align=\"center\"><a href=\"HudousanSearchAction?method=buySuggestInit\" target=\"_self\">");
      if (_jspx_meth_fmt_message_3(_jspx_page_context))
        return;
      out.write("</a></td>\r\n");
      out.write("\t\t\t\t<td align=\"center\"><a href=\"HudousanFindAction?method=leaseFindInit\" target=\"_self\">");
      if (_jspx_meth_fmt_message_4(_jspx_page_context))
        return;
      out.write("</a></td>\r\n");
      out.write("\t\t\t\t<td align=\"center\"><a href=\"HudousanFindAction?method=buyFindInit\" target=\"_self\">");
      if (_jspx_meth_fmt_message_5(_jspx_page_context))
        return;
      out.write("</a></td>\r\n");
      out.write("\t\t\t\t<td align=\"center\"><a href=\"CompanyIntroAction\" target=\"_self\">");
      if (_jspx_meth_fmt_message_6(_jspx_page_context))
        return;
      out.write("</a></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t</table>\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td>&nbsp;</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t</table>\r\n");
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
    _jspx_th_fmt_setBundle_0.setBasename("hudousan");
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
    _jspx_th_fmt_message_0.setKey("top.label.top1");
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
    _jspx_th_fmt_message_1.setKey("top.label.top2");
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
    _jspx_th_fmt_message_2.setKey("top.label.top3");
    _jspx_th_fmt_message_2.setBundle((javax.servlet.jsp.jstl.fmt.LocalizationContext) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${message}", javax.servlet.jsp.jstl.fmt.LocalizationContext.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_fmt_message_2 = _jspx_th_fmt_message_2.doStartTag();
    if (_jspx_th_fmt_message_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_fmt_message_key_bundle_nobody.reuse(_jspx_th_fmt_message_2);
      return true;
    }
    _jspx_tagPool_fmt_message_key_bundle_nobody.reuse(_jspx_th_fmt_message_2);
    return false;
  }

  private boolean _jspx_meth_fmt_message_3(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  fmt:message
    org.apache.taglibs.standard.tag.rt.fmt.MessageTag _jspx_th_fmt_message_3 = (org.apache.taglibs.standard.tag.rt.fmt.MessageTag) _jspx_tagPool_fmt_message_key_bundle_nobody.get(org.apache.taglibs.standard.tag.rt.fmt.MessageTag.class);
    _jspx_th_fmt_message_3.setPageContext(_jspx_page_context);
    _jspx_th_fmt_message_3.setParent(null);
    _jspx_th_fmt_message_3.setKey("top.label.top4");
    _jspx_th_fmt_message_3.setBundle((javax.servlet.jsp.jstl.fmt.LocalizationContext) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${message}", javax.servlet.jsp.jstl.fmt.LocalizationContext.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_fmt_message_3 = _jspx_th_fmt_message_3.doStartTag();
    if (_jspx_th_fmt_message_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_fmt_message_key_bundle_nobody.reuse(_jspx_th_fmt_message_3);
      return true;
    }
    _jspx_tagPool_fmt_message_key_bundle_nobody.reuse(_jspx_th_fmt_message_3);
    return false;
  }

  private boolean _jspx_meth_fmt_message_4(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  fmt:message
    org.apache.taglibs.standard.tag.rt.fmt.MessageTag _jspx_th_fmt_message_4 = (org.apache.taglibs.standard.tag.rt.fmt.MessageTag) _jspx_tagPool_fmt_message_key_bundle_nobody.get(org.apache.taglibs.standard.tag.rt.fmt.MessageTag.class);
    _jspx_th_fmt_message_4.setPageContext(_jspx_page_context);
    _jspx_th_fmt_message_4.setParent(null);
    _jspx_th_fmt_message_4.setKey("top.label.top5");
    _jspx_th_fmt_message_4.setBundle((javax.servlet.jsp.jstl.fmt.LocalizationContext) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${message}", javax.servlet.jsp.jstl.fmt.LocalizationContext.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_fmt_message_4 = _jspx_th_fmt_message_4.doStartTag();
    if (_jspx_th_fmt_message_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_fmt_message_key_bundle_nobody.reuse(_jspx_th_fmt_message_4);
      return true;
    }
    _jspx_tagPool_fmt_message_key_bundle_nobody.reuse(_jspx_th_fmt_message_4);
    return false;
  }

  private boolean _jspx_meth_fmt_message_5(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  fmt:message
    org.apache.taglibs.standard.tag.rt.fmt.MessageTag _jspx_th_fmt_message_5 = (org.apache.taglibs.standard.tag.rt.fmt.MessageTag) _jspx_tagPool_fmt_message_key_bundle_nobody.get(org.apache.taglibs.standard.tag.rt.fmt.MessageTag.class);
    _jspx_th_fmt_message_5.setPageContext(_jspx_page_context);
    _jspx_th_fmt_message_5.setParent(null);
    _jspx_th_fmt_message_5.setKey("top.label.top6");
    _jspx_th_fmt_message_5.setBundle((javax.servlet.jsp.jstl.fmt.LocalizationContext) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${message}", javax.servlet.jsp.jstl.fmt.LocalizationContext.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_fmt_message_5 = _jspx_th_fmt_message_5.doStartTag();
    if (_jspx_th_fmt_message_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_fmt_message_key_bundle_nobody.reuse(_jspx_th_fmt_message_5);
      return true;
    }
    _jspx_tagPool_fmt_message_key_bundle_nobody.reuse(_jspx_th_fmt_message_5);
    return false;
  }

  private boolean _jspx_meth_fmt_message_6(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  fmt:message
    org.apache.taglibs.standard.tag.rt.fmt.MessageTag _jspx_th_fmt_message_6 = (org.apache.taglibs.standard.tag.rt.fmt.MessageTag) _jspx_tagPool_fmt_message_key_bundle_nobody.get(org.apache.taglibs.standard.tag.rt.fmt.MessageTag.class);
    _jspx_th_fmt_message_6.setPageContext(_jspx_page_context);
    _jspx_th_fmt_message_6.setParent(null);
    _jspx_th_fmt_message_6.setKey("top.label.top7");
    _jspx_th_fmt_message_6.setBundle((javax.servlet.jsp.jstl.fmt.LocalizationContext) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${message}", javax.servlet.jsp.jstl.fmt.LocalizationContext.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_fmt_message_6 = _jspx_th_fmt_message_6.doStartTag();
    if (_jspx_th_fmt_message_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_fmt_message_key_bundle_nobody.reuse(_jspx_th_fmt_message_6);
      return true;
    }
    _jspx_tagPool_fmt_message_key_bundle_nobody.reuse(_jspx_th_fmt_message_6);
    return false;
  }
}
