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
<title>aFlashcard&nbsp;::&nbsp;<fmt:message key="myaFlashcardList.main" bundle="${message}"/></title>
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
	 	if (document.list.msg.value == "DELETE_ERROR") {
	 		alert("<fmt:message key="myaFlashcardList.msg.delete_err" bundle="${message}"/>");
	 	} else if (document.list.msg.value == "GroupAddSuccess") {
	 		alert("<fmt:message key="myaFlashcardList.msg.froupAddSuccess" bundle="${message}"/>");
	 	} else if (document.list.msg.value == "DuplicateError") {
	 		alert("<fmt:message key="myaFlashcardList.msg.duplicateError" bundle="${message}"/>");
	 	} else if (document.list.msg.value == "GroupDeleteSuccess") {
	 		alert("<fmt:message key="myaFlashcardList.msg.groupDeleteSuccess" bundle="${message}"/>");
	 	}
	 
	}
	//ページ処理
	function reloadPage(pagenum) {
		document.list.action="mylist?pageNum="+pagenum;
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
		document.list.action="detail?id=" + id + "&fromPage=mylist";
		document.list.submit(); 
		return true;
	}
	/* 
	 * sign 1:登録、2:修正
	 */
	function categoryEditOpenWindow(sign) {
	
		var url ="categoryeditopen?sign=" + sign;
		var newWindow =  window.open(url, "<fmt:message key="myaFlashcardList.msg.category" bundle="${message}"/>", "width = 350, height=150, location=no, toolbar=no");
		newWindow.moveTo(350,150);
		newWindow.focus();
	}
	/* 카테고리deleteAction  */
	function deleteCategory() {
		if(window.confirm('<fmt:message key="myaFlashcardList.msg.confirmDelete" bundle="${message}"/>')){
			document.list.action="categorydel";
			document.list.submit(); 
			return true;
		} else {
			window.alert('<fmt:message key="myaFlashcardList.msg.confirmCancel" bundle="${message}"/>'); 
		}
		
	}
	//暗記帳追加
	function addGroup(group_id, fromUser_id, toUser_id) {
		document.list.action="adddeck?id=" + group_id + "&fromUser_id=" + fromUser_id + "&toUser_id=" + toUser_id;
		document.list.submit(); 
		return true;
	}
	//暗記帳削除
	function deleteGroup(group_id) {
		if(window.confirm('<fmt:message key="myaFlashcardList.msg.confirmDelete" bundle="${message}"/>')){
			document.list.action="deletedeck?id=" + group_id;
			document.list.submit(); 
			return true;
		} else {
				window.alert('<fmt:message key="myaFlashcardList.msg.confirmCancel" bundle="${message}"/>'); 
		}
		
	}
	
	//Enter Key Search
	function keyCodeSearch() {
		if(Keycode(event) ==13) search();
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
			<input type="hidden" name="categoryCode" value="${code}">
			<input type="hidden" name="forward" value="mylist">
			<input type="hidden" name="userId" value="${M_memberInfo.userid}">
			<input type="hidden" name="msg" value="${Msg}">
			<input type="hidden" name="editCategoryName">
			<table width="950" align="center" cellpadding="0" cellspacing="0">
			<tr>
				<td height="150"  rowspan="10" valign="top">
						<div class="elem"  style="overflow:auto;" id = "tree" />
				</td>
			</tr>
			<tr>
				<td>
					
					<table width="100%" border="0" cellspacing="1" cellpadding="0">
					<tr>
						<td width="41%" align="left">
							&nbsp;&nbsp;<fmt:message key="myaFlashcardList.label.categoryManage" bundle="${message}"/>&nbsp;&nbsp;
							<a href="javascript:categoryEditOpenWindow('reg');">
								<img src="<fmt:message key="myaFlashcardList.image.registCategory" bundle="${message}"/>" align="absmiddle">
							</a>
							<a href="javascript:deleteCategory();">
								<img src="<fmt:message key="myaFlashcardList.image.deleteCategory" bundle="${message}"/>" align="absmiddle">
							</a>
							<a href="javascript:categoryEditOpenWindow('edit');">
								<img src="<fmt:message key="myaFlashcardList.image.editCategory" bundle="${message}"/>" align="absmiddle">
							</a>
							&nbsp;
						</td>
						<td width="46%" align="right">
							
							<a href="javascript:registOpen('${M_memberInfo.userid}', '${code}');"><img src="<fmt:message key="myaFlashcardList.image.registCategory" bundle="${message}"/>" align="absmiddle" /></a>
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
								<td width="20%" align="center" class="board-title-text"><span class="style8"><fmt:message key="myaFlashcardList.label.category" bundle="${message}"/></span></td>
								<td width="40%" align="center" class="board-title-text"><span class="style8"><fmt:message key="myaFlashcardList.label.title" bundle="${message}"/></span></td>
								<td width="10%" align="center" class="board-title-text"><span class="style8"><fmt:message key="myaFlashcardList.label.termsCnt" bundle="${message}"/></span></td>
								<td width="10%" align="center" class="board-title-text"><span class="style8"><fmt:message key="myaFlashcardList.label.share" bundle="${message}"/></span></td>
								<td width="10%" align="center" class="board-title-text"><span class="style8"><fmt:message key="myaFlashcardList.label.delete" bundle="${message}"/></span></td>
								<td width="10%" align="center" class="board-title-text"><span class="style8"><fmt:message key="myaFlashcardList.label.start" bundle="${message}"/></span></td>
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
				             <!--단어장제목 -->
							<td width="40%" align="center">
								<a href="javascript:openDetailPage('${memorizerGroup.groupid}');">
									<c:out value="${memorizerGroup.groupName}"/></a>&nbsp;
							</td>
							 <!--단어수 -->							
							<td width="10%" align="center">
									<c:out value="${memorizerGroup.questionCnt}"/>&nbsp;
							</td>
							 <!--공유-->							
							<td width="10%" align="center">
								<a href="javascript:addGroup('${memorizerGroup.groupid}','${M_memberInfo.userid}', '${UserLocale}');">
									<img src="<fmt:message key="myaFlashcardList.image.shareFlashcard" bundle="${message}"/>" align="absmiddle" />&nbsp;
								</a>
							</td>
							 <!--삭제-->							
							<td width="10%" align="center">
								<a href="javascript:deleteGroup('${memorizerGroup.groupid}');">
									<img src="<fmt:message key="myaFlashcardList.image.deleteFlashcard" bundle="${message}"/>" align="absmiddle" />&nbsp;
								</a>
							</td>
							 <!--학습시작 -->							
							<td width="10%" align="center">
								<img src="<fmt:message key="myaFlashcardList.image.startFlashcard" bundle="${message}"/>" align="absmiddle" />
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
							<fmt:message key="myaFlashcardList.label.searchresultEmpty" bundle="${message}"/>
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
					<td align="center" style="color:#33333;font-size:12px;"><fmt:message key="myaFlashcardList.label.searchresult" bundle="${message}"/>
					<span class="orange-text"><strong>${GroupPageBean.maxCount}</strong></span><fmt:message key="myaFlashcardList.label.searchresultdis1" bundle="${message}"/>
		        	<span class="blue-text-w"><strong>${GroupPageBean.startCount}~${GroupPageBean.endCount}</strong></span><fmt:message key="myaFlashcardList.label.searchresultdis2" bundle="${message}"/></td> 
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