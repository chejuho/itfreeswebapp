<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ page import="common.bean.MemberBean"%>
<%@ page import="job.bean.JobBean, job.bean.JobSearchBean"%>
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
<title>${iboardBean.title}&nbsp;::&nbsp;<fmt:message key="aFlashcardRegist.title" bundle="${message}"/></title>
<script src="jsp/include/js/commonCheck.js" type="text/javascript"></script>
<script src="jsp/include/js/commonFunction.js" type="text/javascript"></script>
<link href="jsp/include/css/basic.css" rel="stylesheet" type="text/css">
<script type="text/javascript">
    
	/* Upload イメージチェック*/
	function uploadFileCheck(obj) {
		var maxSize = 2 * 1024 * 1024; 
		var value = obj.value;
		var src = getFileExtension(obj.value);
		if (src == "") {
			return true;
		}
		else if (!((src.toLowerCase() == "txt") ||
		 			(src.toLowerCase() == "csv") || 
		 			(src.toLowerCase() == "xls") || 
		 			(src.toLowerCase() == "zip"))) {
			alert('<fmt:message key="aFlashcardRegist.msg.uploadFormat_err" bundle="${message}"/>');
			document.wf.action="deckregistopen";
			document.wf.submit(); 
			return true;
		}
		return true;
	}
	
	function resetFile(obj) {
	  	obj.select();
        document.selection.clear();	
	}
	
	
	function registNoLogin(ff) {
		if(isNull(ff.title)) {
			alert("<fmt:message key="aFlashcardRegist.msg.no_input1_err" bundle="${message}"/>");
			return;
		}
		
		if(isNull(ff.user_name)) {
			alert("<fmt:message key="aFlashcardRegist.msg.no_input2_err" bundle="${message}"/>");
			return;
		}
		if(isNull(ff.pass_word)) {
			alert("<fmt:message key="aFlashcardRegist.msg.no_input3_err" bundle="${message}"/>");
			return;
		}
		ff.action="deckregist";
		ff.submit(); 
		return true;
	}
	
	function registLogin(ff) {
		if(isNull(ff.title)) {
			alert("<fmt:message key="aFlashcardRegist.msg.no_input1_err" bundle="${message}"/>");
			return;
		}
		ff.action="deckregist";
		ff.submit(); 
		return true;
	}
	
	function cancel(ff) {
		var userId = document.wf.user_id.value;
		var categoryCode = document.wf.categoryCode.value;
		document.wf.action="list?modoru=ok&userId=" + userId + "&categoryCode=" + categoryCode;
		document.wf.submit(); 
	}
	
	
//-->
</script>
</head>

<body style="margin:0 0 0 0"> 
	<table >
	<jsp:include page="aflashcardHead.jsp" flush="true" />
	<tr>
		<td height="35">
			<form name="wf" method="post" enctype="multipart/form-data">
			<input type="hidden" name="user_id" value="${user_id}">  
			<input type="hidden" name="categoryCode" value="${categoryCode}">  
			<table width="900"  border="0" align="center" cellpadding="0" cellspacing="0">
			<tr><!--게시판이름 -->
				
				<td bgcolor="#EBF2E6" align="center" valign="bottom" style="padding:21px 11px 11px 11px;"><h2><fmt:message key="aFlashcardRegist.label.titleMain" bundle="${message}"/></h2></td>
			</tr>
			<tr>
				<td valign="top">
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td bgcolor="#EBF2E6" style="padding:11px 11px 11px 11px;">
							<table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#d6d5d5">
							<tr>
								<td bgcolor="#FFFFFF" class="table-cont-text">
									<h4><fmt:message key="aFlashcardRegist.label.title" bundle="${message}"/></h4>
								</td>
								<td width="85%" bgcolor="#FFFFFF" class="table-cont-text">
									<input type="text" name= "title" id="idTitle" value="${title}" style="width:680px;"  maxlength="42"/>
								</td>
							</tr>
							<tr>
								<td bgcolor="#FFFFFF" class="table-cont-text">
									<h4><fmt:message key="aFlashcardRegist.label.register" bundle="${message}"/></h4>
								</td>
								<td width="85%" bgcolor="#FFFFFF" class="table-cont-text">
									<c:if test="${!empty M_memberInfo}">
									<input type="text" name="user_name" id="idTitle" style="width:300px;" value="${M_memberInfo.name}" maxlength="42" disabled="true"/>
									</c:if>
									<c:if test="${empty M_memberInfo}">
									<input type="text" name="user_name" id="idTitle" value="${user_name}" style="width:300px;" maxlength="42"/>
									</c:if>
								</td>
							</tr>
							<tr>
								<td bgcolor="#FFFFFF" class="table-cont-text">
									<h4><fmt:message key="aFlashcardRegist.label.fileupload" bundle="${message}"/></h4>
								</td>
								<td bgcolor="#FFFFFF" class="table-cont-text">
									<table width="100%" border="0" cellspacing="0" cellpadding="0">
									<tr>
										<td height="30">	
										  	<input type="file" name="file_name" id="idFile_name1" value="${iboardBean.filename1}" onChange="uploadFileCheck(this)" style="width:300px;"  />
										</td>
									</tr>
									</table>
								</td>
							</tr>
							<tr>
								<td bgcolor="#FFFFFF" class="table-cont-text">
									<h4><fmt:message key="aFlashcardRegist.label.pwd" bundle="${message}"/></h4>
								</td>
								<td width="85%" bgcolor="#FFFFFF" class="table-cont-text">
									<c:if test="${!empty M_memberInfo}">
									<input type="password" name= "pass_word" id="idTitle" style="width:180px;" disabled="true" maxlength="42"/>
									</c:if>
									<c:if test="${empty M_memberInfo}">
									<input type="password" name= "pass_word" id="idTitle" style="width:180px;"  maxlength="42"/>
									</c:if>
									
								</td>
							</tr>
							</table>
						</td>
					</tr>
					</table>
				</td>
			</tr>
			<tr>
				<td valign="top">&nbsp;</td>
			</tr>
			<tr>
				<td align="center" valign="top">
					<c:if test="${!empty M_memberInfo}">
						<a href="javascript:registLogin(wf);"><img src="<fmt:message key="aFlashcardRegist.image.regist_ok" bundle="${message}"/>"/></a>&nbsp;
					</c:if>
					<c:if test="${empty M_memberInfo}">
						<a href="javascript:registNoLogin(wf);"><img src="<fmt:message key="aFlashcardRegist.image.regist_ok" bundle="${message}"/>"/></a>&nbsp;
					</c:if>
					<a href="javascript:cancel();"><img src="<fmt:message key="aFlashcardRegist.image.cancel" bundle="${message}"/>"/></a></td>
			</tr>
			</table>
			</form>
		</td>		
	</tr>
	<tr>
		<td width="150">&nbsp;</td>
		<td height="50">&nbsp;</td>
	</tr>
	</table>
</body>
</html>