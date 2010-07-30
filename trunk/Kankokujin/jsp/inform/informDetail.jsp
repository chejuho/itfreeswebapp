<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ page import="common.bean.MemberBean, common.util.EnDecoding"%> 
<%@ page import="inform.bean.InformBean"%>
<%@ page import="common.util.Util"%>
<%@page import="common.constant.Const"%> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="myTags" uri="pageHandle"%>
<%@ taglib prefix="util" uri="util" %>
<fmt:setLocale value="KO"/>
<fmt:setBundle basename="msg" var="message"/>


<%
	InformBean bean = (InformBean) request.getAttribute("InformBean");
%>
<html>
<meta http-equiv="Content-type" content="text/html; charset=UTF-8">
 <head>
<title>${InformBean.title} ::&nbsp;<fmt:message key="TITLE.title" bundle="${message}"/></title>
<script src="jsp/include/js/prototype.js" type="text/javascript" ></script>
<script src="jsp/include/js/src/scriptaculous.js?effets" type="text/javascript" ></script>
<script src="jsp/include/js/popupMenu.js" type="text/javascript"></script>
<script src="jsp/include/js/top.js" type="text/javascript"></script>
<script src="jsp/include/js/commonCheck.js" type="text/javascript"></script>
<script src="jsp/include/js/commonFunction.js" type="text/javascript"></script>
<link href="jsp/include/css/basic.css" rel="stylesheet" type="text/css">
<style type="text/css">
<!--
.style6 {color: #d564b7}
-->
</style>
<script type="text/javascript">
<!--
	function goDirectTopMenu(topMenu) {
	 	//var topMenu =	document.getElementById("topMenu").value;
	 	if (topMenu == '1') {
	 		document.wf.action="BuySellList?re=9&search_cate_code_1=C10100";
	 	}
	 	if (topMenu == '2') {
	 		document.wf.action="BuySellList?re=9&search_cate_code_1=C10200";
	 	}
	 	if (topMenu == '3') {
	 		document.wf.action="StoreSearch?re=9";
	 	}
	 	if (topMenu == '4') {
	 		document.wf.action="GourmetSearch?re=9";
	 	}
	 	if (topMenu == '5') {
	 		document.wf.action="RoomSellList?re=9&cate_code_1=C10001";
	 	}
	 	if (topMenu == '6') {
	 		document.wf.action="RoomSellList?re=9&cate_code_1=C10002";
	 	}
	 	if (topMenu == '7') {
	 		document.wf.action="HouseSellList?re=9";
	 	}
	 	if (topMenu == '8') {
	 		document.getElementById("search_cate_code_1").value = "";
	 		document.wf.action="JobSearch?re=9";
	 	}
	 	if (topMenu == '9') {
	 		document.wf.action="FindjobSearch?re=9";
	 	}
		document.wf.submit(); 
		return true;
	}
	function backSearchPage() {
		document.wf.action="InformList?re=9&modoru=ok";
		document.wf.submit(); 
		return true;
	}
	function goSearchPage() {
		document.wf.action="InformList?re=9";
		document.wf.submit(); 
		return true;
	}	

//-->
</script>
</head>

<body style="margin:0 0 0 0"> 
	<table>
	<jsp:include page="../include/top.jsp" flush="true" />
	<tr>
    	<td height="20">&nbsp;</td>
  	</tr>
	<tr>
		<td>
			<form name="wf" method="post">   
			<table width="736"  border="0" align="center" cellpadding="0" cellspacing="0">
			<tr>
				<td valign="top"><img src="jsp/images/new/6_title.gif" width="736" height="82" /></td>
			</tr>
			<tr>
				<td valign="top">&nbsp;</td>
			</tr>
			<tr>
				<td valign="top">
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td height="38" colspan="3" background="jsp/images/new/6_list_bg.gif" class="search-list-tit">
							<table width="100%" border="0" cellspacing="1" cellpadding="0">
							<tr>
								<td width="11%" align="center" class="board-title-text"><span class="style8 style6">번호</span></td>
								<td width="71%" align="center" class="board-title-text style6">글제목</td>
								<td width="18%" align="center" class="board-title-text"><span class="style8 style6">등록일</span></td>
							</tr>
							</table>
						</td>
					</tr>
					<tr>
						<td width="11%" height="30" align="center">${InformBean.id}</td>
						<td width="71%" align="center" >${InformBean.title}</td>
						<td width="18%" align="center"><%=Util.getUpdateDateFull(bean.getRegist_dateTime())%></td>
					</tr>
					<tr align="center" bgcolor="#CCCCCC">
						<td height="3" colspan="3" bgcolor="#CCCCCC" ><img src="jsp/images/new/6_line.gif" width="736" height="3" /></td>
					</tr>
					<tr>
						<td colspan="3" align="center"><br />
						${InformBean.detail_info}&nbsp;<br />
						<br />
						<br /></td>
					</tr>
					
					<tr bgcolor="#CCCCCC">
						<td height="1" colspan="3"></td>
					</tr>
					</table>
				</td>
			</tr>
			<tr>
				<td height="5" align="right" valign="top"></td>
			</tr>
			<tr>
				<td align="right" valign="top">
					<c:if test="${before == 'search'}">
		              	<a href="javascript:backSearchPage();"><img src="jsp/images/new/6_list_b.gif" width="66" height="21" /></a>&nbsp;
					</c:if>
					<c:if test="${before == 'new_write'}">
		              	<a href="javascript:goSearchPage();"><img src="jsp/images/new/6_list_b.gif" width="66" height="21" /></a>&nbsp;
					</c:if>
				</td>
			</tr>
			</table>
			</form>
		</td>
	</tr>
  	<tr>
    	<td height="50">&nbsp;</td>
  	</tr>
	<jsp:include page="../include/footer.jsp" flush="true"/>
	</table>
</body>
</html>
