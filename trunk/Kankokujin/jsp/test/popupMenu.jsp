<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ page import="common.bean.MemberBean, common.util.EnDecoding"%>
<%@ page import="store.bean.StoreBean, store.bean.StoreSearchBean"%>
<%@ page import="category.bean.CategoryBean"%>
<%@ page import="common.util.Util"%>
<%@ page import="common.constant.Const"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="myTags" uri="pageHandle"%>
<%@ taglib prefix="util" uri="util" %>

<SCRIPT LANGUAGE="JavaScript">
var old_sa = '';
function menuclick( a )
{
if( old_sa != a ) {
if( old_sa!='' ) {
old_sa.style.display = 'none';
}
a.style.display = 'block';
old_sa = a;

} else {

a.style.display = 'none';
old_sa = '';
}

}
</SCRIPT>
우선 위 스크립트를 넣어주고요

메뉴가 들어갈 부분에
<a style="cursor:hand;" onclick="menuclick(submenu1);">큰메뉴1</a><br>
<span id="submenu1" style="margin-left:0;text-align:left; display:none;line-height:100%">
<a href="게시판 경로또는 파일 주소" onfocus='this.blur()'>작은 메뉴1</a><br>
<a href="게시판 경로또는 파일 주소" onfocus='this.blur()'>작은 메뉴2</a><br>
<a href="게시판 경로또는 파일 주소" onfocus='this.blur()'>작은 메뉴3</a><br>
</span>

<a style="cursor:hand;" onclick="menuclick(submenu2);">큰메뉴2</a><br>
<span id="submenu2" style="margin-left:0;text-align:left; display:none;line-height:100%">
<a href="게시판 경로또는 파일 주소" onfocus='this.blur()'>작은 메뉴1</a><br>
<a href="게시판 경로또는 파일 주소" onfocus='this.blur()'>작은 메뉴2</a><br>
<a href="게시판 경로또는 파일 주소" onfocus='this.blur()'>작은 메뉴3</a><br>
</span>

<a style="cursor:hand;" onclick="menuclick(submenu3);">큰메뉴3</a><br>
<span id="submenu3" style="margin-left:0;text-align:left; display:none;line-height:100%">
<a href="게시판 경로또는 파일 주소" onfocus='this.blur()'>작은 메뉴1</a><br>
<a href="게시판 경로또는 파일 주소" onfocus='this.blur()'>작은 메뉴2</a><br>
<a href="게시판 경로또는 파일 주소" onfocus='this.blur()'>작은 메뉴3</a><br>
</span>
