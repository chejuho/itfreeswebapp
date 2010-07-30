<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@page import="common.constant.Const"%>
<%@ page import="common.bean.PageBean" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="myTags" uri="pageHandle"%>
<%@ taglib prefix="util" uri="util" %>
<fmt:setLocale value="KO"/>
<fmt:setBundle basename="msg" var="message"/>

<%	
	PageBean pageBean = (PageBean)session.getAttribute("PageBean");
%>
<html>
<meta http-equiv="Content-type" content="text/html; charset=UTF-8">
<head>
<title><c:out value="공지사항"/>&nbsp;::&nbsp;<fmt:message key="TITLE.title" bundle="${message}"/></title>
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
//<!--
	function reloadPage(obj) {
		document.list.action="InformList?pageNum="+obj;
		document.list.submit(); 
		return true;
	}
	function searchStore() {
		document.list.action="FindjobSearch?re=9";
		document.list.submit(); 	
		return true;
	}	
	function my_write(user_id) {

		if(user_id == "-"){
			document.list.action="FindjobSearch?re=9&user_id=-";
		} else if(user_id == "_"){
			document.list.action="FindjobSearch?re=9&user_id=";
		} else {
			document.list.action="FindjobSearch?re=9&user_id=" + user_id;
		}			
		document.list.submit(); 
		return true;
	}
	function openDetailPage(id) {

		document.list.action="InformDetail?before=search&id=" + id;
		document.list.submit(); 
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
			<form name="list" method="post" style="margin:0">
			<input type="hidden" id="msg" name = "msg" value="<c:out value="${Message}"/>" />
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
					<!--리스트 표시 -->
					<c:choose>
					<c:when test="${!empty InformBeanList}">
						<c:forEach var="InformBean" items="${InformBeanList}" >
						<tr>
							<!--번호 -->
							<td width="11%" height="30" align="center">${InformBean.id}</td>
							<!--글제목 -->
							<td width="71%" align="center"><a href="javascript:openDetailPage('${InformBean.id}');">
										<c:out value="${InformBean.title}"/>${util:getNewImage(InformBean.regist_dateTime)}</a>&nbsp;</td>
							<!--등록일 -->
							<td width="18%" align="center"><c:out value="${InformBean.regist_date}"/>&nbsp;</td>
						</tr>
						<tr align="center" bgcolor="#CCCCCC">
							<td height="1" colspan="3" ></td>
						</tr>
						</c:forEach>
					</c:when>
					<c:otherwise>
						<tr>
							<td width="100%" align="center">
							<c:out value="해당 검색 리스트가 없습니다."/>
							</td>
						</tr>
					</c:otherwise>
					</c:choose>
					</table>
				</td>
			</tr>
			<tr>
				<td valign="top">&nbsp;</td>
			</tr>
			<tr>
				<!--건수표시 -->
				<c:if test="${0 != PageBean.maxCount}">
					<td align="center" style="color:#33333;font-size:12px;">검색결과 :
					<span class="orange-text"><strong>${PageBean.maxCount}</strong></span>건중 
		        	<span class="blue-text-w"><strong>${PageBean.startCount}~${PageBean.endCount}</strong></span>건을표시하고 있습니다.</td> 
				</c:if>
			</tr>		
			<tr>
				<td align="center">&nbsp;</td>
			</tr>
			<tr>
				<!--페이지표시 -->
				<td align="center">
	        		<myTags:pageHandle />
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