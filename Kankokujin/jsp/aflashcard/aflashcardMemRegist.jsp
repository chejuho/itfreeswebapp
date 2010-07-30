<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@page import="common.bean.MemberBean"%>
<%@page import="common.util.Util"%>
<%@page import="common.constant.Const"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<fmt:setLocale value="${LocaleInfo}"/>
<fmt:setBundle basename="aFlashcard" var="message"/>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>aFlashcard&nbsp;::&nbsp;<fmt:message key="memberRegist.title" bundle="${message}"/></title>
<meta http-equiv="Content-type" content="text/html; charset=UTF-8">
<script src = "jsp/Scripts/prototype.js" type="text/javascript" ></script>
<script src="jsp/include/js/commonCheck.js" type="text/javascript"></script>
<script src="jsp/include/js/commonFunction.js" type="text/javascript"></script>
<link href="jsp/include/css/basic.css" rel="stylesheet" type="text/css">
<script language="javascript">
    
    Event.observe(window, 'load', errorInit);
	/** ERROR메세지 처리  */
	 function errorInit() {
	 	if (document.wf.msg.value == "DuplicateIDError") {
	 		alert("<fmt:message key="memberRegist.msg.duplication_err" bundle="${message}"/>");
	 	} 
	 	if (document.wf.msg.value == "DuplicateCheckOk") {
	 		alert("<fmt:message key="memberRegist.msg.available" bundle="${message}"/>");
	 	} 
	}
	
	function registCheck(f) {
		ID = /^[A-Za-z0-9]+$/;
		ED = /^[0-9]{1,4}/;
		if(f.userid.value==""){
			alert("<fmt:message key="memberRegist.msg.noInput_id_err" bundle="${message}"/>");
			f.userid.focus();
			return;
		} else if(!isIdShort(f.userid)){
	   		alert("<fmt:message key="memberRegist.msg.id_restrict1_err" bundle="${message}"/>");
	   		return;
	   	} else if (!ID.test(f.userid.value)) {
			alert('<fmt:message key="memberRegist.msg.id_restrict2_err" bundle="${message}"/>');
			f.userid.value="";
			f.userid.focus();
			return;			
		} else if(f.password.value==""){
			alert("<fmt:message key="memberRegist.msg.noPwd_err" bundle="${message}"/>");
			f.password.focus();
			return;
		} else if(f.password.value!=f.repassword.value){
			alert("<fmt:message key="memberRegist.msg.pwd_input1_err" bundle="${message}"/>");
			f.repassword.focus();
			return;
		} else if(!pwdcheck(f.password.value)) {
			alert("<fmt:message key="memberRegist.msg.pwd_input2_err" bundle="${message}"/>");
			return;	
	   	} else if(f.name.value=="") {
			alert("<fmt:message key="memberRegist.msg.nickname_input1_err" bundle="${message}"/>");
			return;
		} else if(!isNickNameCheck(f.name)) {
			alert("<fmt:message key="memberRegist.msg.nickname_input2_err" bundle="${message}"/>");
			return;
		}
	   f.action="memberregist";
	   f.submit(); 
	}
	function isNull(obj) {
		if(obj.value == "") {
			return true;
		}
	}
	function formCheck(f) {
		ID = /^[A-Za-z0-9]+$/;
		if (f.userid.value =="") { 
			alert("<fmt:message key="memberRegist.msg.noInput_id_err" bundle="${message}"/>");
			f.userid.focus();
			return;
			
		}else if(!isIdShort(f.userid)){
	   		alert("<fmt:message key="memberRegist.msg.id_restrict1_err" bundle="${message}"/>");
	   		return;
	   	}else if (!ID.test(f.userid.value)) {
			alert('<fmt:message key="memberRegist.msg.id_restrict2_err" bundle="${message}"/>');
			f.userid.value="";
			f.userid.focus();
		}else {
			f.action="memberidcheck";
			f.submit(); 
	   }     		
	}

	function isEmail(obj) {
	    var format = /^[_0-9a-zA-Z-]+(\.[_0-9a-zA-Z-]+)*@[0-9a-zA-Z-]+(\.[0-9a-zA-Z-]+)*$/;
		/^(file|gopher|news|nntp|telnet|https?|ftps?|sftp):\/\/([a-z0-9-]+\.)+[a-z0-9]{2,4}.*$/	    
		if (obj.search(format) != -1){
			return true;		
		}else {
			return false;		
		}	
	}

	function isIdShort(obj) {
		var str = obj.value;
		if(str.length < 4 || str.length > 12) {
			return false;
		}
		return true;		
	}
	
//-->
</script>
</head>

<body style="margin:0 0 0 0"> 
	<table border="0" >
	<jsp:include page="aflashcardHead.jsp" flush="true" />
	<tr>
    	<td height="20">&nbsp;</td>
	</tr>
	<tr>
		<td>
			<form name="wf" method="post">
			<input type="hidden" name="msg" value="${Msg}">
			<input type="hidden" name="categoryName" value="<fmt:message key="memberRegist.info.categoryName" bundle="${message}"/>">
			<table width="736"  border="0" align="center" cellpadding="0" cellspacing="0">
			<tr>
				<td valign="top"><img src="<fmt:message key="memberRegist.image.titleBg1" bundle="${message}"/>" width="736" height="82" /></td>
			</tr>
			<tr>
				<td valign="top"><img src="<fmt:message key="memberRegist.image.titleBg2" bundle="${message}"/>" width="736" height="38" /></td>
			</tr>
			<tr>
				<td height="8" valign="top"></td>
			</tr>
			<tr>
				<td valign="top">※ <fmt:message key="memberRegist.label.requiredItem" bundle="${message}"/> (<span class="red-text-w">*</span><fmt:message key="memberRegist.label.display" bundle="${message}"/>)
			</tr>
			<tr>
				<td height="8" valign="top"></td>
			</tr>
			<tr>
				<td valign="top" >
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td bgcolor="#ebebeb" style="padding:11px 11px 11px 11px;">
							<!-- 회원 정보 입력 -->
							<table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#d6d5d5">
							<tr>
								<td width="27%" bgcolor="#f7f7f7" class="table-title-text"><span class="red-text-w">*</span><fmt:message key="memberRegist.label.id" bundle="${message}"/></td>
								<td width="73%" bgcolor="#FFFFFF" class="table-cont-text">
									<input type="text" name="userid"  value="<c:out value="${tempMemberBean.userid}"/>" maxlength="12" id="textfield2" class="idForm" style="width:150px;" />
									&nbsp;<a href="javascript:formCheck(wf);"><img src="<fmt:message key="memberRegist.image.idcheck" bundle="${message}"/>" align="absmiddle"></a>
									<fmt:message key="memberRegist.label.restrict1" bundle="${message}"/></td>
							</tr>
							<tr>
								<td bgcolor="#f7f7f7" class="table-title-text"><span class="red-text-w">*</span><fmt:message key="memberRegist.label.pwd" bundle="${message}"/></td>
								<td width="73%" bgcolor="#FFFFFF" class="table-cont-text">
									<input type="password" name="password" id="textfield3" maxlength="12" style="width:150px;"/>&nbsp;&nbsp;<fmt:message key="memberRegist.label.restrict1" bundle="${message}"/></td>
							</tr>
							<tr>
								<td bgcolor="#f7f7f7" class="table-title-text"><span class="red-text-w">*</span><fmt:message key="memberRegist.label.rePwd" bundle="${message}"/></td>
								<td width="73%" bgcolor="#FFFFFF" class="table-cont-text">
									<input type="password" name="repassword" id="textfield4" maxlength="12" style="width:150px;"/>&nbsp;&nbsp;<fmt:message key="memberRegist.label.restrict1" bundle="${message}"/></td>
							</tr>
							<tr>
								<td bgcolor="#f7f7f7" class="table-title-text"><span class="red-text-w">*</span><fmt:message key="memberRegist.label.nickname" bundle="${message}"/></td>
								<td width="73%" bgcolor="#FFFFFF" class="table-cont-text">
									<input type="text" name="name" value="<c:out value="${tempMemberBean.name}"/>" maxlength="20" id="textfield8" style="width:280px;"/>&nbsp;&nbsp;<fmt:message key="memberRegist.label.restrict2" bundle="${message}"/></td>
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
					<a href="javascript:registCheck(wf)"><img src="<fmt:message key="memberRegist.image.regist" bundle="${message}"/>" width="139" height="37" /></a></td>
			</tr>
  			</table>
  			</form>
  		</td>
	</tr>
	<tr>
    	<td height="50">&nbsp;</td>
	</tr>
	</table>
</body>
</html>
