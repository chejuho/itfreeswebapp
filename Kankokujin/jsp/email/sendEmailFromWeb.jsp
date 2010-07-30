<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@page import="common.bean.MemberBean"%>
<%@ page import="common.constant.Const"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%

MemberBean member = (MemberBean) session.getAttribute("memberInfo");
String toId = (String)request.getAttribute("toId");
String toName = (String)request.getAttribute("toName");
%>
<fmt:setLocale value="KO"/>
<fmt:setBundle basename="msg" var="message"/>
<html>
<title><c:out value="메일 보내기"/>&nbsp;::&nbsp;<fmt:message key="TITLE.title" bundle="${message}"/></title>
<head>
<meta http-equiv="Content-type" content="text/html; charset=UTF-8">
<link href="jsp/include/css/basic.css" rel="stylesheet" type="text/css">
<script type="text/javascript">
<!--


	function isNull(obj) {
		if(obj.value == "") {
			return true;
		}
	}
	function sendMail(ff){

		if(isNull(ff.fromName)) {
			alert("보내는이(이름)을 입력해 주세요.");
			return;
		}
		
		if(isNull(ff.fromEmail) || !isEmail(ff.fromEmail.value)) {
			alert("보내는이(Email)을 이메일형식으로 입력해 주세요.\n\n예)itfrees@itfrees.com");
			return;
		}

		if(isNull(ff.subject)) {
			alert("제목을 입력해 주세요.");
			return;
		}	
		if(isNull(ff.contents)) {
			alert("내용을 입력해 주세요.");
			return;
		}			
		
		if(confirm("메일을 전송하시겠습니까?")){							
			ff.action="CustomMailSend";
			ff.submit(); 
			//window.close();
			return true;
		}
	}
	
	function chk_empty(str) {
 		if ( str.match(/\S/) == null || str.match(/\S/) == "" ) { return(true); }
 		else { return(false);}
	}
	function isEmail(obj) {
	    var format = /^[_0-9a-zA-Z-]+(\.[_0-9a-zA-Z-]+)*@[0-9a-zA-Z-]+(\.[0-9a-zA-Z-]+)*$/;
		if (obj.search(format) != -1){
			return true;		
		}else {
			return false;		
		}	
	}
//-->
</script>
<script src = "jsp/Scripts/prototype.js" type="text/javascript" ></script>
</head>
<body topmargin="0" leftmargin="0">
<form name="ff"method="post">
	<input type="hidden" name="toId" value="<c:out value="${map['to_id']}"/>">
	<input type="hidden" name="sort" value="<c:out value="${map['sort']}"/>">
	<table width="500"  border="0" align="center" cellpadding="0" cellspacing="0">
	  <tr>
	    <td valign="top"><img src="jsp/images/new/7_title.gif" width="565" height="56" /></td>
	  </tr>
	  <tr>
	    <td valign="top">&nbsp;</td>
	  </tr>
	  <tr>
	    <td valign="top"><table width="500" border="0" align="center" cellpadding="0" cellspacing="0">
	      <tr>
	        <td bgcolor="#ebebeb" style="padding:4px 4px 4px 4px;"><table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#d6d5d5">
	          <tr>
	            <td width="16%" bgcolor="#f7f7f7" class="table-title-text">보내는이<br>(이름)</td>
	            <td width="84%" bgcolor="#FFFFFF" class="table-cont-text"><input type="text" name="fromName" value="<c:out value="${memberInfo['name']}"/>" id="fromName" style="width:350px;" /></td>
	          </tr>
	          <tr>
	          	<c:if test="${!empty memberInfo}">
					<td width="16%" bgcolor="#f7f7f7" class="table-title-text">보내는이<br>(Email)</td>
	            	<td width="84%" bgcolor="#FFFFFF" class="table-cont-text"><input type="text" name="fromEmail" class="idForm" id="fromEmail" value="<c:out value="${memberInfo['email1']}@${memberInfo['email2']}"/>" style="width:350px;" /></td>
				</c:if>
				<c:if test="${empty memberInfo}">
					<td width="16%" bgcolor="#f7f7f7" class="table-title-text">보내는이<br>(Email)</td>
	            	<td width="84%" bgcolor="#FFFFFF" class="table-cont-text"><input type="text" name="fromEmail" class="idForm" id="fromEmail"  style="width:350px;" /></td>
				</c:if>
	          </tr>
	          <tr>
	            <td width="16%" bgcolor="#f7f7f7" class="table-title-text">받는이</td>
	            <td width="84%" bgcolor="#FFFFFF" class="table-cont-text"><c:out value="${map['to_userName']}"/></td>
	          </tr>
	          <tr>
	            <td bgcolor="#f7f7f7" class="table-title-text">제 목</td>
	            <td width="84%" bgcolor="#FFFFFF" class="table-cont-text">
	            	<input type="text" name="subject" id="subject"  style="width:350px;" />
					<input name="fromId" type="hidden" size="70" value=""style="width: 350px" />
	            </td>
	          </tr>
	          <tr>
	            <td bgcolor="#f7f7f7" class="table-title-text">내 용</td>
	            <td width="84%" bgcolor="#FFFFFF" class="table-cont-text"><textarea name="contents" id="textarea" cols="45" rows="5" style="width:350px;height:200px;"></textarea></td>
	          </tr>
	        </table></td>
	      </tr>
	    </table></td>
	  </tr>
	  <tr>
	    <td valign="top">&nbsp;</td>
	  </tr>
	  <tr>
	    <td align="center" valign="top">
			<a href="javascript:sendMail(ff);"><img src="jsp/images/new/7_send.gif" width="73" height="22" /></a>&nbsp;
	    	<a href="" onclick="window.close();"><img src="jsp/images/new/7_cancel.gif" width="73" height="22" /></a></td>
	  </tr>
	</table>
</form>
</body>
</html>