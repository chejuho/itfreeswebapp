<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ page import="common.bean.PageBean, category.bean.CategoryBean"%>
<%@ page import="java.util.List,java.util.Iterator"%>
<%@ page import="job.bean.JobBean, job.bean.JobSearchBean"%>
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
<title>aFlashcard&nbsp;::&nbsp;<fmt:message key="aFlashcardDetail.main" bundle="${message}"/></title>
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
	 		alert("<fmt:message key="aFlashcardDetail.msg.login_err" bundle="${message}"/>");
	 	} else if (document.list.msg.value == "NO_LOGIN") {
	 		alert("<fmt:message key="aFlashcardDetail.msg.no_login_err" bundle="${message}"/>");
	 	} else if (document.list.msg.value == "DeleteFailForPassError") {
	 		alert("<fmt:message key="aFlashcardDetail.msg.login_err" bundle="${message}"/>");
	 	}
	 
	}
	//ページ処理
	function reloadPage(pagenum) {
		document.list.action="detail?pageNum="+pagenum;
		document.list.submit(); 
		return true;
	}
	
	//ファイルDownLoad
	function fileDownLoad(groupId, userId) {
		document.list.action="download?id=" +groupId + "&userId=" + userId;
		document.list.submit(); 
		return true;
	}
	//リストに戻る
	function backPageList(url) {
		document.list.action= url + "?modoru=ok";
		document.list.submit(); 
		return true;
	}
	/* 
	 * パースOPEN 
	 */
	function passwordInputOpen(user_id, group_id) {
		var url ="passwordinputopen?user_id=" + user_id + "&group_id=" + group_id;
		var newWindow =  window.open(url, "PASSWORD", "width = 350, height=150, location=no, toolbar=no");
		newWindow.moveTo(350,150);
		newWindow.focus();
	}
	function deleteGroup(user_id, group_id) {
		if(window.confirm('<fmt:message key="aFlashcardDetail.msg.confirmDelete" bundle="${message}"/>')){
			document.list.action="usergroupdelete?delUserId=" + user_id + "&delGroupId=" + group_id;
			document.list.submit(); 
			return true;
		} else {
				window.alert('<fmt:message key="aFlashcardDetail.msg.confirmCancel" bundle="${message}"/>'); 
		}
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
<body style="margin:0 0 0 0">
	<table border="0">
	<jsp:include page="aflashcardHead.jsp" flush="true" />
	<tr>
		<td width="150" colspan="2">&nbsp;</td>
	</tr>
	<tr>
		<td>
			<form name="list" method="post" style="margin:0">
			
			<input type="hidden" name="forward" value="${fromPage}">
			<input type="hidden" name="fromPage" value="${fromPage}">
			<input type="hidden" name="userId" value="${userId}">
			<input type="hidden" name="id" value="${groupId}">
			<input type="hidden" name="msg" value="${Msg}">
			<input type="hidden" name="search" value="${search}">
			<input type="hidden" name="search_range" value="${search_range}">
			<input type="hidden" name="categoryCode" value="${categoryCode}">
			<input type="hidden" name="delUserId">
			<input type="hidden" name="delGroupId">
			<input type="hidden" name="pass_word">
			<table width="950"  border="0" align="center" cellpadding="0" cellspacing="0">
			<tr>
				<td height="450" width="150" rowspan="11" valign="top">
						<div class="elem"  style="overflow:auto;" id = "tree" />
				</td>
			</tr>
			<tr>
				<td>
					<table width="100%" border="0" cellspacing="1" cellpadding="0">
					<tr>
						<td width="41%">&nbsp;</td>
						<td width="46%" align="right">
							<c:if test="${'guest' == groupInfo.register_user_id}">
								<a href="javascript:passwordInputOpen('${groupInfo.user_id}', '${groupInfo.group_id}');"><img src="<fmt:message key="aFlashcardDetail.image.delete" bundle="${message}"/>" align="absmiddle" /></a>
							</c:if>
							<c:if test="${'guest' != groupInfo.register_user_id && M_memberInfo.userid == groupInfo.register_user_id}">
								<a href="javascript:deleteGroup('${groupInfo.user_id}', '${groupInfo.group_id}');"><img src="<fmt:message key="aFlashcardDetail.image.delete" bundle="${message}"/>" align="absmiddle" /></a>
							</c:if>
							<a href="javascript:backPageList('${fromPage}');"><img src="<fmt:message key="aFlashcardDetail.image.list" bundle="${message}"/>" align="absmiddle" /></a>
							<a href="javascript:fileDownLoad('${groupId}', '${userId}');"><img src="<fmt:message key="aFlashcardDetail.image.download" bundle="${message}"/>" align="absmiddle" /></a>
						</td>
					</tr>
					<tr>
						<td colspan="3" align="center"><h4><c:out value="${groupInfo.groupName}"/></h4></td>
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
								<td width="50%" align="center" class="board-title-text"><span class="style8"><fmt:message key="aFlashcardDetail.label.question" bundle="${message}"/></span></td>
								<td width="45%" align="center" class="board-title-text"><span class="style8"><fmt:message key="aFlashcardDetail.label.answer" bundle="${message}"/></span></td>
							</tr>
							</table>
						</td>
					</tr>
					<!--리스트 표시 -->
					<c:choose>
					<c:when test="${!empty memorizerQuestionList}">
						<c:forEach var="memorizerQuestion" items="${memorizerQuestionList}" varStatus="i">
						<tr>
							<!--단어 -->
							<td width="50%" height="52" align="center">
							<c:if test="${util:isImage(memorizerQuestion.question)}">
								<img src="${util:getImagePath(memorizerQuestion.question)}" width="60" height="60" style="border:1px  solid #CCCCCC;" />&nbsp;
							</c:if>
							<c:if test="${!util:isImage(memorizerQuestion.question)}">
								<c:out value="${memorizerQuestion.question}"/>&nbsp;
							</c:if>
								
							</td>
				             <!--뜻 -->
							<td width="45%" align="center">
								
								<c:out value="${memorizerQuestion.answer}"/>&nbsp;
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
							<fmt:message key="aFlashcardDetail.label.searchresultEmpty" bundle="${message}"/>
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
				<c:if test="${0 != QuestionPageBean.maxCount}">
					<td align="center" style="color:#33333;font-size:12px;"><fmt:message key="aFlashcardDetail.label.searchresult" bundle="${message}"/>
					<span class="orange-text"><strong>${QuestionPageBean.maxCount}</strong></span><fmt:message key="aFlashcardDetail.label.searchresultdis1" bundle="${message}"/>
		        	<span class="blue-text-w"><strong>${QuestionPageBean.startCount}~${QuestionPageBean.endCount}</strong></span><fmt:message key="aFlashcardDetail.label.searchresultdis2" bundle="${message}"/></td> 
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