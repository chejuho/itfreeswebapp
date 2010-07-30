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
<meta name="viewport" content="user-scalable=no, initial-scale=1, maximum-scale=1, minimum-scale=1, width=device-width" />

 <head>
<title>aFlashcard&nbsp;::&nbsp;<fmt:message key="aFlashcardList.title" bundle="${message}"/></title>
<script src = "jsp/aflashcard/tree.js" type="text/javascript"></script>
<script src = "jsp/Scripts/prototype.js" type="text/javascript" ></script>
<link href="jsp/include/css/mobile.css" rel="stylesheet" type="text/css">

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
		if (document.list.actionUrl.value == "MemorizerSearch") {
	 		document.list.action="search?pageNum="+pagenum;
	 	} else if (document.list.actionUrl.value == "MemorizerList") {
	 		document.list.action="list?pageNum="+pagenum;
	 	} 
		document.list.submit(); 
		return true;
	}
	function logout() {		
		document.list.action="logout";
		document.list.submit();		
	}
	//login
	function login(f) {
		if(f.id.value==""){
			alert("<fmt:message key="top.msg.input_err_id" bundle="${message}"/>");
			f.id.focus();
			return;
		}else if(f.pw.value==""){
			alert("<fmt:message key="top.msg.input_err_pwd" bundle="${message}"/>");
			f.pw.focus();
			return;
		}else{
			f.action="login";
			f.submit();
		}
				
	}
	function Keycode(e){
		var result;
		if(window.event) {		
	    	result = window.event.keyCode;
	    } else if(e) {
			result = e.which;
		}
		return result;
	}
	function loginform_clearbg(type) {
		if (type == "id") {
			document.list.id.style.backgroundImage = '';
		} else if (type == "pw") {
			document.list.pw.style.backgroundImage = '';
		}
	}
	function loginform_bgChange(obj, act) {
		if ( act == 'F') {
			obj.className = 'login';
			obj.style.backgroundColor='#FFFFFF';
		} else {
			obj.className = 'login';
			obj.style.backgroundColor='#FFFFFF';	
		}			
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
		document.list.action="AddQuestionGroup?id=" + group_id + "&fromUser_id=" + fromUser_id + "&toUser_id=" + toUser_id;
		document.list.submit(); 
		return true;
	}	
	function languageChange(id) {		
		document.list.action="list?userId=" + id;
		document.list.submit();		
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
<body style="margin:0 0 0 0;">
	<table width="100%" >
	<tr>
		<td>
			<form name="list" method="post" style="margin:0">
			<input type="hidden" name="mobileSign" value="ok">
			<input type="hidden" name="categoryCode" value="${code}">
			<input type="hidden" name="actionUrl" value="${actionUrl}">
			<input type="hidden" name="forward" value="list">
			<input type="hidden" name="userId" value="${userId}">
			<input type="hidden" name="msg" value="${Msg}">
			
			<table align="center" width="100%" cellpadding="0" cellspacing="0">
			<tr>
				<td>
					<table width="100%" cellspacing="1" cellpadding="0">
					<tr>
						<td width="100%" align="right">
							<table >
		        			<tr>
		        				<c:if test="${empty M_memberInfo}">
					        	<td>
					        		<span style="font-size:12px;">ID</span>
					        	</td>
					        	<td>
					        		<input type="text" name="id" id="textfield2" class="idForm" style="height:15px; width:50px;" onkeydown="if(Keycode(event) ==13) login(list);" onFocus="loginform_clearbg('id');loginform_bgChange(this,'F')" onBlur="loginform_bgChange(this,'B');"  tabindex="1" align="absmiddle"/>
								</td>
								<td>
									<span style="font-size:12px;">PWD</span>
									
								</td>
								<td>
									<input type="password" name="pw" id="textfield3"  style="height:15px; width:50px;" onkeydown="if(Keycode(event) ==13) login(list);" onFocus="loginform_clearbg('id');loginform_bgChange(this,'F')" onBlur="loginform_bgChange(this,'B');" onMouseDown="javascript:MouseUp1=true;" onKeyDown="javascript:KeyUp1=true;" tabindex="2" align="absmiddle"/>
								</td>	
								</c:if>
								<c:if test="${!empty M_memberInfo}">
								<td>
					        		<c:out value="${util:cutLongName(10,M_memberInfo.name)}" /></strong><fmt:message key="top.label.nameGuest" bundle="${message}"/>
					        	</td> 
								</c:if>
								<c:if test="${!empty M_memberInfo}">
									<td>
										 
										<a href="javascript:logout()" class="top-link">LOGOUT</a>&nbsp;
									</td>
								</c:if>
								<c:if test="${empty M_memberInfo}">
									<td>
										<a href="javascript:login(list)" class="top-link">LOGIN</a>&nbsp;
									</td>
								</c:if>
								<td>
									<a href="list" class="top-link"> 
										<img src="<fmt:message key="top.image.aFlashcardList" bundle="${message}"/>" align="absmiddle" />&nbsp;
									</a> 
								</td>
								<td>
									<a href="mylist" class="top-link">
										<img src="<fmt:message key="top.image.myaFlashcardList" bundle="${message}"/>" align="absmiddle" />&nbsp;
									</a>
								</td>
		        				<td>
					        		<a href="javascript:languageChange('k_admin')" target="_self" class="top-link" >
					        			<img src="jsp/images/aFlashcard/common/korea.png"  height="20" align="absmiddle"  />
					        		</a>
					        	</td>
					        	<td>
					        		<a href="javascript:languageChange('j_admin')" target="_self" class="top-link" >
					        			<img src="jsp/images/aFlashcard/common/japan.png" height="20" align="absmiddle"  />
					        		</a>
					        	</td>
					        	<td>
					        		<a href="javascript:languageChange('e_admin')" target="_self"  class="top-link" >
					        			<img src="jsp/images/aFlashcard/common/usa.png"  height="20" align="absmiddle"  />
					        		</a>
					        	</td>
					        	<!--    
					        	<td>
					        		<a href="javascript:languageChange('c_admin')" target="_self" tabindex="4" class="top-link" >
										<img src="jsp/images/aFlashcard/common/china.png"  align="absmiddle"  />
									</a>
					        	</td> 
								<td>
									<a href="javascript:registOpen('${userId}', '${code}');"><img src="<fmt:message key="aFlashcardList.image.registFlashcard" bundle="${message}"/>" height="60" align="absmiddle" /></a>							
								</td>-->
							</tr>
							</table>
						</td>
					</tr>
					</table>
				</td>
			</tr>
			<tr>
				<td>
					<table width="100%" cellspacing="0"  cellpadding="0">
					<tr>
						<td colspan="2" bgcolor="#E6E6FA" class="search-list-tit">
							<table width="100%" border="0" cellspacing="1" cellpadding="0">
							<tr>
								<td width="75%" align="center" class="board-title-text"><fmt:message key="aFlashcardList.label.title" bundle="${message}"/></td>
								<td width="25%" align="center" class="board-title-text"><fmt:message key="aFlashcardList.label.termsCnt" bundle="${message}"/></td>
							</tr>
							</table>
						</td>
					</tr>
					<!--리스트 표시 -->
					<c:choose>
					<c:when test="${!empty memorizerGroupList}">
						<c:forEach var="memorizerGroup" items="${memorizerGroupList}" varStatus="i">
						<tr>
							
				             <!--단어장 -->
							<td width="75%" align="center">
								<a href="javascript:openDetailPage('${memorizerGroup.groupid}');">
									<span class="mobile-text-content"><c:out value="${memorizerGroup.groupName}"/></span></a>&nbsp;
							</td>
							 <!--단어수 -->							
							<td width="25%" align="center">
									<span class="mobile-text-content"><c:out value="${memorizerGroup.questionCnt}"/></span>&nbsp;
							</td>
						</tr>
						<tr align="center" bgcolor="#CCCCCC">
							<td height="2" colspan="2" ></td>
						</tr>
						</c:forEach>
					</c:when>
					<c:otherwise>
						<tr>
							<td width="100%" align="center">
							<span class="mobile-text"><fmt:message key="aFlashcardList.label.searchresultEmpty" bundle="${message}"/></span>
							</td>
						</tr>
					</c:otherwise>
					</c:choose>
					</table>
				</td>
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
				<!--페이지표시 -->
				<td align="center">
	        		<myTags:pageHandle />
				</td>
			</tr>
			<tr>
				<td align="center" border="1">
					<table>
						<tr>
							<td>
								<select name="search_range" style="width:100px;font-size:15px" id="select7" >
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
							</td>
							<td>
								<input type="text" name="search" onkeydown="keyCodeSearch('${userId}', '${code}')"　id="textfield2" style="width:120px; height:25px ;font-size:20px" value="${search}" align="absmiddle"/>
							</td>
							<td>
								<a href="javascript:search('${userId}', '${code}');"><img src="<fmt:message key="aFlashcardList.image.search" bundle="${message}"/>"   height="25" align="absmiddle"/></a>
							</td>
						</tr>
					</table>						
				</td>
			</tr>
			<tr>
				<td width="100%" style="font-size: 20px;" valign="top">
					<div class="elem"  style="overflow:auto;" id = "tree" />
				</td>
			</tr>
			<tr>
				<td align="center"><a href="list?m=f">PC&nbsp;</a></td>
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