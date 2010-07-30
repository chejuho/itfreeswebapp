<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@page import="common.bean.MemberBean"%>
<%@page import="common.util.Util"%>
<%@page import="common.constant.Const"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<fmt:setLocale value="KO"/>
<fmt:setBundle basename="msg" var="message"/>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title><c:out value="회원가입"/>&nbsp;::&nbsp;<fmt:message key="TITLE.title" bundle="${message}"/></title>
<meta http-equiv="Content-type" content="text/html; charset=UTF-8">
<script src="jsp/include/js/prototype.js" type="text/javascript" ></script>
<script src="jsp/include/js/src/scriptaculous.js?effets" type="text/javascript" ></script>
<script src="jsp/include/js/popupMenu.js" type="text/javascript"></script>
<script src="jsp/include/js/top.js" type="text/javascript"></script>
<script src="jsp/include/js/commonCheck.js" type="text/javascript"></script>
<script src="jsp/include/js/commonFunction.js" type="text/javascript"></script>
<link href="jsp/include/css/basic.css" rel="stylesheet" type="text/css">
<script language="javascript">
    /** ERROR메세지 처리  */
    function messageCheck() {
		var message = document.getElementById("msg").value;
		if (message) {
			if (message == 'MSG0007'){
				
				alert("<fmt:message key="MSG0007" bundle="${message}"/>");
		
			} else if (message == 'MSG0006'){
					
				alert("<fmt:message key="MSG0006" bundle="${message}"/>");
			
			} else if (message == 'WAR0002'){
					
				alert("<fmt:message key="WAR0002" bundle="${message}"/>");
			
			}
		}
	}
	
	function registCheck(f) {
		ID = /^[A-Za-z0-9]+$/;
		ED = /^[0-9]{1,4}/;
		if(document.wf.agree_check.checked==false){
			alert("약관에 동의를 해주세요.");
			return;	    
		} else if(f.userid.value==""){
			alert("아이디를 입력하세요.");
			f.userid.focus();
			return;
		} else if(!isIdShort(f.userid)){
	   		alert("아이디를 4자이상 12자이하로 해주세요.");
	   		return;
	   	} else if (!ID.test(f.userid.value)) {
			alert('ID는 영문,숫자만 가능합니다.');
			f.userid.value="";
			f.userid.focus();
			return;			
		} else if(f.password.value==""){
			alert("비밀번호를 입력하세요.");
			f.password.focus();
			return;
		} else if(f.password.value!=f.repassword.value){
			alert("입력하신 비밀번호가 서로 다릅니다.\n다시 입력을 해주십시요.");
			f.repassword.focus();
			return;
		} else if(!pwdcheck(f.password.value)) {
			alert("비밀번호에 영문,숫자 이외의 문자가 있으면 안됩니다!");
			return;
		} else if(f.email1.value==""){
			alert("이메일을 입력하세요.");
			f.email1.focus();
			return;
		} else if(f.email2.value=="") {
			alert("이메일을 입력하세요.");
			f.email2.focus();
			return;
		} else if(f.re_email.value=="") {
			alert("이메일확인란을 입력하세요.");
			f.re_email.focus();
			return;						
		} else if((f.email1.value+"@"+f.email2.value) != (f.re_email.value)) {		    
			alert("이메일과 이메일확인이 일치하지 않습니다.");
			return;		
		} else if(!isEmail(f.re_email.value)) {
			alert("이메일이 형식에 맞지 않습니다.");
			return;		
	   	} else if(f.name.value=="") {
			alert("닉네임을 입력하세요.");
			return;
		} else if(!isNickNameCheck(f.name)) {
			alert("닉네임이 형식에 맞지 않습니다.");
			return;
		} else if(!isNull(f.telephone1) || !isNull(f.telephone2) || !isNull(f.telephone3)) {
	
			if(!ED.test(f.telephone1.value) || !ED.test(f.telephone2.value) ||!ED.test(f.telephone3.value)){
				alert("전화번호1이 전화번호 형식에 맞지 않습니다.");
				return;
			}
		} 
		if(!isNull(f.mobile1) || !isNull(f.mobile2) || !isNull(f.mobile3)) {
	
			if(!ED.test(f.mobile1.value) || !ED.test(f.mobile2.value) ||!ED.test(f.mobile3.value)){
				alert("전화번호2가 전화번호 형식에 맞지 않습니다.");
				return;
			}
		}
	   f.action="MemberRegist";
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
			alert("아이디가 입력되어져 있지 않습니다.");
			f.userid.focus();
			return;
			
		}else if(!isIdShort(f.userid)){
	   		alert("아이디를 4자이상 12자이하로 해주세요.");
	   		return;
	   	}else if (!ID.test(f.userid.value)) {
			alert('ID는 영문,숫자만 가능합니다.');
			f.userid.value="";
			f.userid.focus();
		}else {
			f.action="MemberIDCheck";
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
window.onload=messageCheck;
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
			<input type="hidden" id="msg" name = "msg" value="<c:out value="${Message}"/>" /> 
			<table width="736"  border="0" align="center" cellpadding="0" cellspacing="0">
			<tr>
				<td valign="top"><img src="jsp/images/new/memregist_tit.gif" width="736" height="82" /></td>
			</tr>
			<tr>
				<td valign="top">&nbsp;</td>
			</tr>
			<tr>
				<td valign="top"><img src="jsp/images/new/memregist_s_tit1.gif" width="736" height="38" /></td>
			</tr>
			<tr>
				<td height="8" valign="top"></td>
			</tr>
			<tr>
				<td height="11" align="center" valign="top" bgcolor="#ebebeb"></td>
			</tr>
			<tr>
				<td align="center" valign="top" bgcolor="#ebebeb" style="padding:0px 11px 0px 11px;">
					<table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#d6d5d5">
					<tr>
						<td height="35" align="center" bgcolor="#FFFFFF">
							<table width="51%" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td height="25" align="left">
									<img src="jsp/images/new/memregist_icon1.gif" align="absmiddle" width="16" height="16" /> 가입하시기전에 아래의 <span class="blue-text-w"><strong>이용약관</strong></span>을 꼭 읽어주세요!</td>
							</tr>
							</table>
						</td>
					</tr>

					</table>
				</td>
			</tr>
			<tr>
				<td height="11" align="center" valign="top" bgcolor="#ebebeb"></td>
			</tr>
			<tr>
				<td align="center" valign="top" bgcolor="#ebebeb" style="padding:0px 11px 0px 11px;">
					<table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#d6d5d5">
					<tr>
						<td align="center" bgcolor="#FFFFFF" >
							<table width="680" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td>&nbsp;</td>
							</tr>
							<tr>
								<td align="left"><img src="jsp/images/new/memregist_icon2.gif"   align="absbottom"width="13" height="16" /><strong class="blue-text-w"> 이용약관</strong></td>
							</tr>
							<tr>
								<td height="8"></td>
							</tr>
							<tr>
								<td>
									<iframe src="jsp/member/memberdoc.html" frameborder="0" width="680" height="300" leftmargin="0" topmargin="0" scrolling="auto" class="if_border01"></iframe>
								</td>
							</tr>
							<tr>
								<td>&nbsp;</td>
							</tr>
							</table>
						</td>
					</tr>
					</table>
				</td>
			</tr>
			<tr>
				<td height="11" align="center" valign="top" bgcolor="#ebebeb"></td>
			</tr>
			<tr>
				<td align="center" valign="top" bgcolor="#ebebeb" style="padding:0px 11px 0px 11px;">
					<table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#d6d5d5">
					<tr>
						<td height="35" align="left" bgcolor="#FFFFFF">
							<table width="680" border="0" align="center" cellpadding="0" cellspacing="0">
							<tr>
								<td width="22" align="left" valign="top"><input type="checkbox" name="agree_check" id="checkbox" ${MemberBean.agree_check} /></td>
								<td width="658" align="left" valign="bottom">약관의 내용을 확인하였으며 위 내용에 동의 합니다. </td>
							</tr>
							</table>
						</td>
					</tr>
					</table>
				</td>
			</tr>
			<tr>
				<td height="11" align="center" valign="top" bgcolor="#ebebeb"></td>
			</tr>
			<tr>
				<td valign="top">&nbsp;</td>
			</tr>
			<tr>
				<td valign="top"><img src="jsp/images/new/memregist_s_tit2.gif" width="736" height="38" /></td>
			</tr>
			<tr>
				<td height="8" valign="top"></td>
			</tr>
			<tr>
				<td valign="top">※ 필수항목 (<span class="red-text-w">*</span>표시) 만 입력해도 회원가입이 가능합니다. <br />
				&nbsp;&nbsp;&nbsp; 선택항목을 입력하면 보다 편리하게 서비스를 이용하실 수 있습니다. </td>
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
								<td width="27%" bgcolor="#f7f7f7" class="table-title-text"><span class="red-text-w">*</span>아이디</td>
								<td width="73%" bgcolor="#FFFFFF" class="table-cont-text">
									<input type="text" name="userid"  value="<c:out value="${MemberBean.userid}"/>" maxlength="12" id="textfield2" class="idForm" style="width:150px;" />
									&nbsp;<a href="javascript:formCheck(wf);"><img src="jsp/images/new/btn_repeat_check.gif" align="absmiddle"></a>
									(4~12영문, 숫자 가능)</td>
							</tr>
							<tr>
								<td bgcolor="#f7f7f7" class="table-title-text"><span class="red-text-w">*</span>비밀번호</td>
								<td width="73%" bgcolor="#FFFFFF" class="table-cont-text">
									<input type="password" name="password" id="textfield3" maxlength="12" style="width:150px;"/>&nbsp;&nbsp;(4~12영문, 숫자 가능)</td>
							</tr>
							<tr>
								<td bgcolor="#f7f7f7" class="table-title-text"><span class="red-text-w">*</span>비밀번호확인</td>
								<td width="73%" bgcolor="#FFFFFF" class="table-cont-text">
									<input type="password" name="repassword" id="textfield4" maxlength="12" style="width:150px;"/>&nbsp;&nbsp;(4~12영문, 숫자 가능)</td>
							</tr>
							<tr>
								<td bgcolor="#f7f7f7" class="table-title-text"><span class="red-text-w">*</span>이메일</td>
								<td width="73%" bgcolor="#FFFFFF" class="table-cont-text">
									<table width="100%" border="0" cellspacing="0" cellpadding="0">
									<tr>
										<td height="30" valign="top">
											<input type="text" name="email1" value="<c:out value="${MemberBean.email1}"/>" maxlength="31" id="textfield5" class="idForm" style="width:150px;" />
											@
											<input type="text" name="email2" value="<c:out value="${MemberBean.email2}"/>" maxlength="31" id="textfield6" class="idForm" style="width:150px;"/></td>
									</tr>
									<tr>
										<td valign="bottom">이메일은 회원인증시, 아이디분실시, 임시비밀번호 발급시 이메일 보내기에 사용되오니 <br />
										사용가능한 이메일을 입력하시기 바랍니다.</td>
									</tr>
									</table>
								</td>
							</tr>
							<tr>
								<td bgcolor="#f7f7f7" class="table-title-text"><span class="red-text-w">*</span>이메일확인</td>
								<td width="73%" bgcolor="#FFFFFF" class="table-cont-text">
									<table width="100%" border="0" cellspacing="0" cellpadding="0">
									<tr>
										<td height="30" valign="top"><input name="re_email" type="text" id="textfield7" class="idForm" style="width:320px;" /></td>
									</tr>
									<tr>
										<td valign="bottom"> 위에 입력하신 이메일을 한번더 입력해 주세요. </td>
									</tr>
									</table>
								</td>
							</tr>
							<tr>
								<td bgcolor="#f7f7f7" class="table-title-text"><span class="red-text-w">*</span>닉네임</td>
								<td width="73%" bgcolor="#FFFFFF" class="table-cont-text">
									<input type="text" name="name" value="<c:out value="${MemberBean.name}"/>" maxlength="20" id="textfield8" style="width:280px;"/>&nbsp;&nbsp;(2~20자한글, 영문, 숫자 가능)</td>
							</tr>
							<tr>
								<td bgcolor="#f7f7f7" class="table-title-text">전화번호1</td>
								<td width="73%" bgcolor="#FFFFFF" class="table-cont-text">
									<input name="telephone1" type="text" value="<c:out value="${MemberBean.telephone1}"/>" maxlength="4" id="textfield9" class="idForm" style="width:50px;" />
									-
									<input name="telephone2" type="text" value="<c:out value="${MemberBean.telephone2}"/>" maxlength="4" id="textfield10" class="idForm" style="width:50px;" />
								  	-
									<input name="telephone3" type="text" value="<c:out value="${MemberBean.telephone3}"/>" maxlength="4" id="textfield11" class="idForm" style="width:50px;" /></td>
							</tr>
							<tr>
								<td bgcolor="#f7f7f7" class="table-title-text">전화번호2</td>
								<td width="73%" bgcolor="#FFFFFF" class="table-cont-text">
									<input name="mobile1" type="text" value="<c:out value="${MemberBean.mobile1}"/>" maxlength="4" id="textfield12" class="idForm" style="width:50px;" />
									-
									<input name="mobile2" type="text" value="<c:out value="${MemberBean.mobile2}"/>" maxlength="4" id="textfield13" class="idForm" style="width:50px;" />
									-
									<input name="mobile3" type="text" value="<c:out value="${MemberBean.mobile3}"/>" maxlength="4" id="textfield14" class="idForm" style="width:50px;" /></td>
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
					<a href="javascript:registCheck(wf)"><img src="jsp/images/new/memregist_b.gif" width="139" height="37" /></a></td>
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
