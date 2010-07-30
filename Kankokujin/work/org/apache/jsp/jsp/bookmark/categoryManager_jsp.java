package org.apache.jsp.jsp.bookmark;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class categoryManager_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static java.util.List _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_out_value_nobody;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_out_value_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
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
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\">\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />\r\n");
      out.write("<title>Category</title>\r\n");
      out.write("<script src = \"jsp/Scripts/prototype.js\" type=\"text/javascript\" ></script>\r\n");
      out.write("<script  src = \"jsp/bookmark/tree.js\" type=\"text/javascript\"></script>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("//<![CDATA[\r\n");
      out.write("\t/** 今選択されているのがカテゴリかブックマックか判別する 0:カテゴリ, 1:ブックマック */\r\n");
      out.write("\t//var clickedSign;\r\n");
      out.write("\tEvent.observe(window, 'load', init);\r\n");
      out.write("\t\r\n");
      out.write(" \r\n");
      out.write("/* 카테고리OpenAction  */\r\n");
      out.write("function insertCategoryOpen() {\r\n");
      out.write("\t\tallHide();\r\n");
      out.write("\t\t$(\"categoryAdd\").show();\r\n");
      out.write("\t\t$(\"catename\").focus();\r\n");
      out.write("\t\t//$(\"mainForm\").action=\"CategoryManager?action=insertCateOpen&clickedbtn=\" + clickedSign;\r\n");
      out.write("\t\t//$(\"mainForm\").submit(); \r\n");
      out.write("\t\treturn true;\r\n");
      out.write("\t\t\r\n");
      out.write("}   \r\n");
      out.write("\r\n");
      out.write("/* 카테고리AddAction  */\r\n");
      out.write("function insertCategory() {\r\n");
      out.write("\tif (!clickedSign) {\r\n");
      out.write("\t\tclickedSign = $F(\"clickedbtn\");\r\n");
      out.write("\t} \r\n");
      out.write("\tif (clickedSign == \"category\") {\r\n");
      out.write("\t\tvar param = \"param=insertCategory&\" + \"catename=\" + $F(\"catename\");\r\n");
      out.write("\t\tnew Ajax.Request(\"CategoryControl\", \r\n");
      out.write("\t\t\t{method:\"get\",\r\n");
      out.write("\t\t\tonComplete:setTree,\r\n");
      out.write("\t\t\tparameters:param });\r\n");
      out.write("\t\treturn true;\r\n");
      out.write("\t} else {\r\n");
      out.write("\t\talert(\"카테고리를 선택하세요.\");\r\n");
      out.write("\t}\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("/* 카테고리deleteAction  */\r\n");
      out.write("function deleteCategory() {\r\n");
      out.write("\tif (!clickedSign) {\r\n");
      out.write("\t\tclickedSign = $F(\"clickedbtn\");\r\n");
      out.write("\t} \r\n");
      out.write("\tif (clickedSign == \"category\") {\r\n");
      out.write("\t\tif(window.confirm('정말 삭제하십니까?')){\r\n");
      out.write("\t\t\tvar param = \"param=deleteCategory\";\r\n");
      out.write("\t\t\tnew Ajax.Request(\"CategoryControl\", \r\n");
      out.write("\t\t\t\t{method:\"get\",\r\n");
      out.write("\t\t\t\tonComplete:setTree,\r\n");
      out.write("\t\t\t\tparameters:param });\r\n");
      out.write("\t\t\treturn true;\r\n");
      out.write("\t\t} else {\r\n");
      out.write("\t\t\twindow.alert('취소되었습니다'); \r\n");
      out.write("\t\t}\r\n");
      out.write("\t} else {\r\n");
      out.write("\t\talert(\"카테고리를 선택하세요.\");\r\n");
      out.write("\t}\r\n");
      out.write("\t\t\r\n");
      out.write("}    \r\n");
      out.write("\r\n");
      out.write("/* 카테고리updateCategoryOpen  */\r\n");
      out.write("function updateCategoryOpen() {\r\n");
      out.write("\tif (!clickedSign) {\r\n");
      out.write("\t\tclickedSign = $F(\"clickedbtn\");\r\n");
      out.write("\t} \r\n");
      out.write("\tif (clickedSign == \"category\") {\r\n");
      out.write("\t\tvar param = \"param=updateCateOpen&\" + \"clickedbtn=\" + clickedSign;;\r\n");
      out.write("\t\tnew Ajax.Request(\"CategoryControl\", \r\n");
      out.write("\t\t\t{method:\"get\",\r\n");
      out.write("\t\t\tonComplete:function set(resp) {\r\n");
      out.write("\t\t\t\t\t\tvar result = resp.responseText.split('<i>');\r\n");
      out.write("\t\t\t\t\t\tallHide();\r\n");
      out.write("\t\t\t\t\t\t$(\"updateCode\").value = result[0];\r\n");
      out.write("\t\t\t\t\t\t$(\"updateCodename\").value = result[1];\r\n");
      out.write("\t\t\t\t\t\t$(\"categoryUpdate\").show();},\r\n");
      out.write("\t\t\tparameters:param });\r\n");
      out.write("\t} else {\r\n");
      out.write("\t\talert(\"카테고리를 선택하세요.\");\r\n");
      out.write("\t}\r\n");
      out.write("\t\t\r\n");
      out.write("}   \r\n");
      out.write("\r\n");
      out.write("/* 카테고리updateCategory  */\r\n");
      out.write("function updateCategory() {\r\n");
      out.write("\t\tvar param = \"param=updateCategory&\" + \"updateCodename=\" + $F(\"updateCodename\") + \"&updateCode=\" + encodeURIComponent($F(\"updateCode\"))\r\n");
      out.write("\t\tnew Ajax.Request(\"CategoryControl\", \r\n");
      out.write("\t\t\t{method:\"get\",\r\n");
      out.write("\t\t\tonComplete:setTree,\r\n");
      out.write("\t\t\tparameters:param });\r\n");
      out.write("\t\treturn true;\r\n");
      out.write("\t\t\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("/* 카테고리insertBookmarkOpen */\r\n");
      out.write("function insertBookmarkOpen() {\r\n");
      out.write("\t\tallHide();\r\n");
      out.write("\t\t$(\"bookMarkAdd\").show();\r\n");
      out.write("\t\t$(\"title\").focus();\r\n");
      out.write("\t\t\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("/* 카테고리insertBook */\r\n");
      out.write("function insertBookmark() {\r\n");
      out.write("\tif (!clickedSign) {\r\n");
      out.write("\t\tclickedSign = $F(\"clickedbtn\");\r\n");
      out.write("\t} \r\n");
      out.write("\tif (clickedSign == \"category\") {\r\n");
      out.write("\t\tvar param = \"param=insertBook&\" + \"title=\" + encodeURIComponent($F(\"title\")) + \"&url=\" + encodeURIComponent($F(\"url\")) + \"&detail=\" + encodeURIComponent($F(\"detail\"));\r\n");
      out.write("\t\tnew Ajax.Request(\"CategoryControl\", \r\n");
      out.write("\t\t\t{method:\"get\",\r\n");
      out.write("\t\t\tonComplete:setTree,\r\n");
      out.write("\t\t\tparameters:param });\r\n");
      out.write("\t\treturn true;\r\n");
      out.write("\t} else {\r\n");
      out.write("\t\talert(\"카테고리를 선택하세요.\");\r\n");
      out.write("\t}\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("/* 카테고리deleteBookmark */\r\n");
      out.write("function deleteBookmark() {\r\n");
      out.write("\tif (!clickedSign) {\r\n");
      out.write("\t\tclickedSign = $F(\"clickedbtn\");\r\n");
      out.write("\t} \r\n");
      out.write("\tif (clickedSign == \"bookMark\") {\r\n");
      out.write("\t\tif(window.confirm('정말 삭제하십니까?')){\r\n");
      out.write("\t\t\tvar param = \"param=deleteBookmark\";\r\n");
      out.write("\t\t\tnew Ajax.Request(\"CategoryControl\", \r\n");
      out.write("\t\t\t\t{method:\"get\",\r\n");
      out.write("\t\t\t\tonComplete:setTree,\r\n");
      out.write("\t\t\t\tparameters:param });\r\n");
      out.write("\t\t\treturn true;\r\n");
      out.write("\t\t} else {\r\n");
      out.write("\t\t\twindow.alert('취소되었습니다'); \r\n");
      out.write("\t\t}\r\n");
      out.write("\t} else {\r\n");
      out.write("\t\talert(\"북마크를 선택하세요.\");\r\n");
      out.write("\t}\r\n");
      out.write("}  \r\n");
      out.write("\r\n");
      out.write("/* 카테고리updateBookmarkOpen */\r\n");
      out.write("function updateBookmarkOpen() {\r\n");
      out.write("\tif (!clickedSign) {\r\n");
      out.write("\t\tclickedSign = $F(\"clickedbtn\");\r\n");
      out.write("\t} \r\n");
      out.write("\tif (clickedSign == \"bookMark\") {\r\n");
      out.write("\t\tvar param = \"param=updateBookOpen&\" + \"clickedbtn=\" + clickedSign;;\r\n");
      out.write("\t\tnew Ajax.Request(\"CategoryControl\", \r\n");
      out.write("\t\t\t{method:\"get\",\r\n");
      out.write("\t\t\tonComplete:function set(resp) {\r\n");
      out.write("\t\t\t\t\t\tvar result = resp.responseText.split('<i>');\r\n");
      out.write("\t\t\t\t\t\tallHide();\r\n");
      out.write("\t\t\t\t\t\t$(\"uptitle\").value = result[0];\r\n");
      out.write("\t\t\t\t\t\t$(\"upurl\").value = result[1];\r\n");
      out.write("\t\t\t\t\t\t$(\"updetail\").value = result[2];\r\n");
      out.write("\t\t\t\t\t\t$(\"bookMarkUpdate\").show();},\r\n");
      out.write("\t\t\tparameters:param });\r\n");
      out.write("\t} else {\r\n");
      out.write("\t\talert(\"북마크를 선택하세요.\");\r\n");
      out.write("\t}\r\n");
      out.write("\t\t\r\n");
      out.write("} \r\n");
      out.write("\r\n");
      out.write("/* 카테고리updateBookmark */\r\n");
      out.write("function updateBookmark() {\r\n");
      out.write("\t\tvar param = \"param=updateBookmark&\" + \"uptitle=\" + encodeURIComponent($F(\"uptitle\")) + \"&upurl=\" + encodeURIComponent($F(\"upurl\")) + \"&updetail=\" + encodeURIComponent($F(\"updetail\"));\r\n");
      out.write("\t\tnew Ajax.Request(\"CategoryControl\", \r\n");
      out.write("\t\t\t{method:\"get\",\r\n");
      out.write("\t\t\tonComplete:setTree,\r\n");
      out.write("\t\t\tparameters:param });\r\n");
      out.write("\t\treturn true;\r\n");
      out.write("\t\treturn true;\r\n");
      out.write("\t\t\r\n");
      out.write("}\r\n");
      out.write("/* 카테고리updateBookmark */\r\n");
      out.write("function goBookmarkNavi() {\r\n");
      out.write("\t\t$(\"mainForm\").action=\"Category\";\r\n");
      out.write("\t\t$(\"mainForm\").submit(); \r\n");
      out.write("\t\treturn true;\r\n");
      out.write("}\r\n");
      out.write("/* bookmark */\r\n");
      out.write("function bookmark(url) {\r\n");
      out.write("\t\t//alert(url);\r\n");
      out.write("\t\tvar frame = $('Page');\r\n");
      out.write("\t\tframe.src = url;\r\n");
      out.write("\t}   \r\n");
      out.write("\t\r\n");
      out.write("/* goPage */\r\n");
      out.write("function goPage() {\r\n");
      out.write("\t\t//alert(url);\r\n");
      out.write("\t\tvar url = $F('inputUrl');\r\n");
      out.write("\t\tvar frame = $('Page');\r\n");
      out.write("\t\tframe.src = \"http://\"+ url;\r\n");
      out.write("\t}  \r\n");
      out.write("/* goPage */\r\n");
      out.write("function updatePage() {\r\n");
      out.write("\t\t//alert(url);\r\n");
      out.write("\t\tvar frame = $('Page');\r\n");
      out.write("\t\talert(frame.src);\r\n");
      out.write("\t}  \t\r\n");
      out.write("\t\r\n");
      out.write("function Keycode(e){\r\n");
      out.write("\t\tvar result;\r\n");
      out.write("\t\tif(window.event) {\t\t\r\n");
      out.write("\t    \tresult = window.event.keyCode;\r\n");
      out.write("\t    } else if(e) {\r\n");
      out.write("\t\t\tresult = e.which;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\treturn result;\r\n");
      out.write("\t}\t\r\n");
      out.write("//]]>\r\n");
      out.write("</script>\r\n");
      out.write("<link href=\"jsp/bookmark/tree.css\" rel=\"stylesheet\" type=\"text/css\"> \r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<form id =\"mainForm\" name=\"mainForm\" method=\"post\" style=\"margin:0\" action=\"CategoryManagerAction\">\r\n");
      out.write("\t<input type=\"hidden\" id=\"clickedbtn\"  value=\"");
      if (_jspx_meth_c_out_0(_jspx_page_context))
        return;
      out.write("\">\t\t\r\n");
      out.write("\t<table border=\"1\">\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<td valign=\"top\">\r\n");
      out.write("\t\t\t\t<table border=\"1\">\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td valign=\"top\">\r\n");
      out.write("\t\t\t\t\t\t<a href=\"http://localhost/Kankokujin/Index\" target=\"_self\">메인으로</a>\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td height=\"450\" width=\"150\" valign=\"top\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"elem\" style=\"auto;\" id = \"tree\" />\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t카테고리<br>\r\n");
      out.write("\t\t\t\t\t<img src=\"jsp/bookmark/btn_regist.gif\" onclick=\"return insertCategoryOpen()\">\r\n");
      out.write("\t\t\t\t\t<img src=\"jsp/bookmark/btn_delete.gif\" onclick=\"return deleteCategory()\">\r\n");
      out.write("\t\t\t\t\t<img src=\"jsp/bookmark/btn_edit.gif\" onclick=\"return updateCategoryOpen()\"><br>\r\n");
      out.write("\t\t\t\t\t북마크<br>\r\n");
      out.write("\t\t\t\t\t<img src=\"jsp/bookmark/btn_regist.gif\" onclick=\"return insertBookmarkOpen()\">\r\n");
      out.write("\t\t\t\t\t<img src=\"jsp/bookmark/btn_delete.gif\" onclick=\"return deleteBookmark()\">\r\n");
      out.write("\t\t\t\t\t<img src=\"jsp/bookmark/btn_edit.gif\" onclick=\"return updateBookmarkOpen()\"><br>\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t</table>\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t\t<td valign=\"top\">\r\n");
      out.write("\t\t\t\t<table border=\"1\">\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\thttp://<input type=\"text\" size=\"120\" id=\"inputUrl\" onkeydown=\"if(Keycode(event) ==13) goPage();\">\r\n");
      out.write("\t\t\t\t\t\t\t<a href=\"javascript:goPage();\" target=\"_self\"><img src=\"jsp/bookmark/btn_cs_ok.gif\"></a>\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t<div id= \"categoryAdd\" style = \"width:1000px; display:none\">\r\n");
      out.write("\t\t\t\t\t\t\t\t카테고리추가<br>\r\n");
      out.write("\t\t\t\t\t\t\t\t이름:<input type=\"text\" name=\"catename\" id=\"catename\" size=\"50\" maxlength=\"42\"><br>\r\n");
      out.write("\t\t\t\t\t\t\t\t<img src=\"jsp/bookmark/regist.gif\" onclick=\"return insertCategory()\">\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t<div id= \"categoryUpdate\" style = \"width:1000px; display:none\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<input type=\"hidden\" name = \"updateCode\" id = \"updateCode\" />\t\r\n");
      out.write("\t\t\t\t\t\t\t\t카테고리수정<br>\r\n");
      out.write("\t\t\t\t\t\t\t\t이름:<input type=\"text\" name=\"updateCodename\" id = \"updateCodename\" \" size=\"50\" maxlength=\"42\"><br>\r\n");
      out.write("\t\t\t\t\t\t\t\t<img src=\"jsp/bookmark/regist.gif\" onclick=\"return updateCategory()\">\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t<div id= \"bookMarkAdd\" style = \"width:1000px; display:none\">\r\n");
      out.write("\t\t\t\t\t\t\t\t북마크추가<br>\r\n");
      out.write("\t\t\t\t\t\t\t\t싸이트명:<input type=\"text\" name=\"title\" size=\"50\" maxlength=\"42\"><br>\r\n");
      out.write("\t\t\t\t\t\t\t\t장소(URL):<input type=\"text\" name=\"url\" size=\"50\" maxlength=\"42\"><br>\r\n");
      out.write("\t\t\t\t\t\t\t\t상세정보:<input type=\"text\" name=\"detail\" size=\"50\" maxlength=\"42\"><br>\r\n");
      out.write("\t\t\t\t\t\t\t\t<img src=\"jsp/bookmark/regist.gif\" onclick=\"return insertBookmark()\">\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t<div id= \"bookMarkUpdate\" style = \"width:1000px; display:none\">\r\n");
      out.write("\t\t\t\t\t\t\t\t북마크추가<br>\r\n");
      out.write("\t\t\t\t\t\t\t\t싸이트명:<input type=\"text\" name=\"uptitle\" id=\"title\" size=\"50\" maxlength=\"42\"/><br>\r\n");
      out.write("\t\t\t\t\t\t\t\t장소(URL):<input type=\"text\" name=\"upurl\" id=\"url\" size=\"50\" maxlength=\"100\"/><br>\r\n");
      out.write("\t\t\t\t\t\t\t\t상세정보:<input type=\"text\" name=\"updetail\" id=\"detail\" size=\"50\" maxlength=\"42\"/><br>\r\n");
      out.write("\t\t\t\t\t\t\t\t<img src=\"jsp/bookmark/regist.gif\" onclick=\"return updateBookmark()\">\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t<div id= \"view\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<iframe id =\"Page\" name = \"Page\" src=\"http://www.kankokujin.com\" \r\n");
      out.write("\t\t\t\t\t\t\t\t style=\"width:1000px; height:1450px; border: 0px\" >\r\n");
      out.write("\t\t\t\t\t\t\t\t</iframe>\r\n");
      out.write("\t\t\t\t\t\t    <!--<a href=\"javascript:goBookmarkNavi();\">북마크나비게이터로</a>-->\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t</table>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t</table>\r\n");
      out.write("</form>\r\n");
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

  private boolean _jspx_meth_c_out_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_out_0 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _jspx_tagPool_c_out_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_out_0.setPageContext(_jspx_page_context);
    _jspx_th_c_out_0.setParent(null);
    _jspx_th_c_out_0.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${clickedbtn}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_out_0 = _jspx_th_c_out_0.doStartTag();
    if (_jspx_th_c_out_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_0);
      return true;
    }
    _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_0);
    return false;
  }
}
