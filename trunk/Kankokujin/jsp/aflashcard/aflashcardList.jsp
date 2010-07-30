<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ page import="common.bean.PageBean, category.bean.CategoryBean"%>
<%@ page import="java.util.List,java.util.Iterator"%>
<%@ page import="common.bean.MemberBean"%>
<%@ page import="common.util.Util"%>
<%@ page import="common.constant.Const"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="myTags" uri="flashPageHandle"%>
<%@ taglib prefix="util" uri="util" %>
<fmt:setLocale value="${LocaleInfo}"/>
<fmt:setBundle basename="aFlashcard" var="message"/>

<html>
<meta http-equiv="Content-type" content="text/html; charset=UTF-8">
 <head>
<title>aFlashcard&nbsp;::&nbsp;<fmt:message key="aFlashcardList.title" bundle="${message}"/></title>
<script src = "jsp/aflashcard/tree.js" type="text/javascript"></script>
<script src = "jsp/Scripts/prototype.js" type="text/javascript" ></script>
<link href="jsp/include/css/basic.css" rel="stylesheet" type="text/css">
<link href="jsp/bookmark/tree.css" rel="stylesheet" type="text/css"> 

<script type="text/javascript">
	//var popupMenuList = new Array();
	Event.observe(window, 'load', init);
	Event.observe(window, 'load', errorInit);
	/** ERROR메세지 처리  */
	 function errorInit() {
	 	if (document.list.msg.value == "LOGIN_ERROR") {
	 		alert("<fmt:message key="aFlashcardList.msg.login_err" bundle="${message}"/>");
	 	} else if (document.list.msg.value == "NO_LOGIN") {
	 		alert("<fmt:message key="aFlashcardList.msg.no_login_err" bundle="${message}"/>");
	 	} else if (document.list.msg.value == "GroupAddSuccess") {
	 		alert("<fmt:message key="aFlashcardList.msg.groupAddSuccess" bundle="${message}"/>");
	 	} else if (document.list.msg.value == "DuplicateError") {
	 		alert("<fmt:message key="aFlashcardList.msg.duplicateError" bundle="${message}"/>");
	 	} else if (document.list.msg.value == "DeleteSuccess") {
	 		alert("<fmt:message key="aFlashcardList.msg.deleteSuccess" bundle="${message}"/>");
	 	} else if (document.list.msg.value == "DeleteFailForPassError") {
	 		alert("<fmt:message key="aFlashcardList.msg.deleteFailForPassError" bundle="${message}"/>");
	 	}
	 
	}
	//ページ処理
	function reloadPage(pagenum) {
		if (document.list.actionUrl.value == "search") {
	 		document.list.action="search?pageNum="+pagenum;
	 	} else if (document.list.actionUrl.value == "list") {
	 		document.list.action="list?pageNum="+pagenum;
	 	} 
		document.list.submit(); 
		return true;
	}
	
	//登録
	function registOpen(userId,category) {
		//var board_id = document.list.board_id.value;
		document.list.action="deckregistopen?userId=" + userId + "&categoryCode=" + category;
		document.list.submit(); 
		return true;
	}
	//詳細画面
	function openDetailPage(id) {
		var url = "";
		if (document.list.actionUrl.value == "search") {
	 		url="search";
	 	} else if (document.list.actionUrl.value == "list") {
	 		url="list";
	 	} 
		document.list.action="detail?id=" + id + "&fromPage=" + url;
		document.list.submit(); 
		return true;
	}	
	//暗記帳追加
	function addGroup(group_id, fromUser_id, toUser_id) {
		document.list.action="adddeck?id=" + group_id + "&fromUser_id=" + fromUser_id + "&toUser_id=" + toUser_id;
		document.list.submit(); 
		return true;
	}	
	
	//Search
	function search(userId,category) {
		document.list.action="search?userId=" + userId + "&categoryCode=" + category;
		document.list.submit(); 
		return true;
	}
	//Enter Key Search
	function keyCodeSearch(userId,category) {
		if(Keycode(event) ==13) search(userId,category);
	}
	
	
	//KeyCode
	function Keycode(e){
		
		var result;
		if(window.event) {		
	    	result = window.event.keyCode;
	    } else if(e) {
			result = e.which;
		}		
		return result;
	}
	
			
</script>	
</head>
<body style="margin:0 0 0 0;" >
	<table>
	<jsp:include page="aflashcardHead.jsp" flush="true" />
	<tr>
		<td width="150" colspan="2">&nbsp;</td>
	</tr>
	<tr>
		<td>
			<form name="list" method="post" style="margin:0">
			<input type="hidden" name="categoryCode" value="${code}">
			<input type="hidden" name="actionUrl" value="${actionUrl}">
			<input type="hidden" name="forward" value="list">
			<input type="hidden" name="userId" value="${userId}">
			<input type="hidden" name="msg" value="${Msg}">
			<table width="950"  align="center" cellpadding="0" cellspacing="0">
			<tr>
				<td width="150" rowspan="11" valign="top">
					<div class="elem"  style="overflow:auto;" id = "tree" />
				</td>
			</tr>
			<tr>
				<td>
					
					<table width="100%" border="0" cellspacing="1" cellpadding="0">
					<tr>
						
						<td width="46%" align="right">
							<a href="javascript:registOpen('${userId}', '${code}');"><img src="<fmt:message key="aFlashcardList.image.registFlashcard" bundle="${message}"/>" align="absmiddle" /></a>
						</td>
					</tr>
					<tr>
						<td height="6" colspan="3"></td>
					</tr>
					</table>
				</td>
			</tr>
			<tr>
				<td>
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td height="41" colspan="10" background="jsp/images/new/board_list_top_bg.gif" class="search-list-tit">
							<table width="100%" border="0" cellspacing="1" cellpadding="0">
							<tr>
								<td width="20%" align="center" class="board-title-text"><span class="style8"><fmt:message key="aFlashcardList.label.category" bundle="${message}"/></span></td>
								<td width="40%" align="center" class="board-title-text"><span class="style8"><fmt:message key="aFlashcardList.label.title" bundle="${message}"/></span></td>
								<td width="10%" align="center" class="board-title-text"><span class="style8"><fmt:message key="aFlashcardList.label.termsCnt" bundle="${message}"/></span></td>
								<td width="15%" align="center" class="board-title-text"><span class="style8"><fmt:message key="aFlashcardList.label.register" bundle="${message}"/></span></td>
								<td width="15%" align="center" class="board-title-text"><span class="style8"><fmt:message key="aFlashcardList.label.flashcardAdd" bundle="${message}"/></span></td>
							</tr>
							</table>
						</td>
					</tr>
					<!--리스트 표시 -->
					<c:choose>
					<c:when test="${!empty memorizerGroupList}">
						<c:forEach var="memorizerGroup" items="${memorizerGroupList}" varStatus="i">
						<tr>
							<!--카테고리 -->
							<td width="20%" height="52" align="center">
								<c:out value="${memorizerGroup.categoryName}"/>&nbsp;
							</td>
				             <!--단어장 -->
							<td width="40%" align="center">
								<a href="javascript:openDetailPage('${memorizerGroup.groupid}');">
									<c:out value="${memorizerGroup.groupName}"/></a>&nbsp;
							</td>
							 <!--단어수 -->							
							<td width="10%" align="center">
									<c:out value="${memorizerGroup.questionCnt}"/>&nbsp;
							</td>
							 <!--등록자-->							
							<td width="15%" align="center">
								<c:out value="${memorizerGroup.registerName}"/>&nbsp;
							</td>
							 <!--가져오기 -->							
							<td width="15%" align="center">
								<a href="javascript:addGroup('${memorizerGroup.groupid}','${memorizerGroup.userid}', '${M_memberInfo.userid}');">
									<img src="<fmt:message key="aFlashcardList.image.flashcardAdd" bundle="${message}"/>" align="absmiddle" />
								</a>
								&nbsp;
							</td>
						</tr>
						<tr align="center" bgcolor="#CCCCCC">
							<td height="1" colspan="10" ></td>
						</tr>
						</c:forEach>
					</c:when>
					<c:otherwise>
						<tr>
							<td width="100%" align="center">
							<fmt:message key="aFlashcardList.label.searchresultEmpty" bundle="${message}"/>
							</td>
						</tr>
					</c:otherwise>
					</c:choose>
					</table>
				</td>
			</tr>
			<tr>
	        	<td height="2" align="center" bgcolor="#CCCCCC"></td>
	      	</tr>			
			<tr>
				<td align="center">&nbsp;</td>
			</tr>
			<tr>
				<!--건수표시 -->
				<c:if test="${0 != GroupPageBean.maxCount}">
					<td align="center" style="color:#33333;font-size:12px;"><fmt:message key="aFlashcardList.label.searchresult" bundle="${message}"/>
					<span class="orange-text"><strong>${GroupPageBean.maxCount}</strong></span><fmt:message key="aFlashcardList.label.searchresultdis1" bundle="${message}"/>
		        	<span class="blue-text-w"><strong>${GroupPageBean.startCount}~${GroupPageBean.endCount}</strong></span><fmt:message key="aFlashcardList.label.searchresultdis2" bundle="${message}"/></td> 
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
			<tr>
				<td align="center">&nbsp;</td>
			</tr>
			<tr>
				<td align="center" border="1">
					<select name="search_range" id="select7">
						<c:if test="${empty search_range || '0' == search_range}">
							<option value='0' selected><fmt:message key="aFlashcardList.search.option1" bundle="${message}"/></option>
							<option value='1'><fmt:message key="aFlashcardList.search.option2" bundle="${message}"/></option>						
							<option value='2'><fmt:message key="aFlashcardList.search.option3" bundle="${message}"/></option>
						</c:if>
						<c:if test="${'1' == search_range}">
							<option value='0' ><fmt:message key="aFlashcardList.search.option1" bundle="${message}"/></option>
							<option value='1' selected><fmt:message key="aFlashcardList.search.option2" bundle="${message}"/></option>						
							<option value='2' ><fmt:message key="aFlashcardList.search.option3" bundle="${message}"/></option>
						</c:if>
						<c:if test="${'2' == search_range}">
							<option value='0' ><fmt:message key="aFlashcardList.search.option1" bundle="${message}"/></option>
							<option value='1' ><fmt:message key="aFlashcardList.search.option2" bundle="${message}"/></option>						
							<option value='2' selected><fmt:message key="aFlashcardList.search.option3" bundle="${message}"/></option>
						</c:if>
					</select>
					<input type="text" name="search" onkeydown="keyCodeSearch('${userId}', '${code}')"　id="textfield2" style="width:300px;" value="${search}" align="absmiddle"/>
					<a href="javascript:search('${userId}', '${code}');"><img src="<fmt:message key="aFlashcardList.image.search" bundle="${message}"/>"  width="45" height="21" align="absmiddle"/></a>	
				</td>
			</tr>
			</table>
			</form>
		</td>
	</tr>
	<tr>
		<td width="150">&nbsp;</td>

	</tr>
	</table>
</body>
</html>