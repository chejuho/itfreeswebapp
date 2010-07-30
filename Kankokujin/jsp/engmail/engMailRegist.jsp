<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@page import="common.bean.MemberBean"%>
<%@page import="common.util.Util, java.util.List, java.util.Iterator"%>
<%@page import="engmail.bean.EngmailListBean"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<fmt:setLocale value="KO"/>
<fmt:setBundle basename="msg" var="message"/>
<%
	request.setCharacterEncoding("UTF-8");
		
	List selectedMailList = (List) request.getAttribute("selectedMailList");
	MemberBean member = new MemberBean();
	member = (MemberBean) session.getAttribute("memberInfo");
	String message = (String)Util.changeNullStr(request.getAttribute("Message"));
%>

<html>
<head>
<title>캉코쿠진닷컴</title>
<meta http-equiv="Content-type" content="text/html; charset=UTF-8">
<script language="javascript" src="jsp/Scripts/top.js"></script>
<script language="javascript">
	<%if ("ERR0003".equals(message)) {%>
			alert("<fmt:message key="ERR0003" bundle="${message}"/>");
	<%
		} else if ("WAR0001".equals(message)){
	%>
			alert("<fmt:message key="WAR0001" bundle="${message}"/>");
	<%
		} else if ("MSG0003".equals(message)){
	%>			
			alert("<fmt:message key="MSG0003" bundle="${message}"/>");
	<%
		} else if ("WAR0002".equals(message)){
	%>			
			alert("<fmt:message key="WAR0002" bundle="${message}"/>");
	<%	} else if ("MSG0013".equals(message)){
	%>			
			alert("<fmt:message key="MSG0013" bundle="${message}"/>");
			location.href="InterpretRegistOpen";
			window.open('PopLogin', 'notice', 'width=230, height=160');	
	<%	} else if ("MSG0006".equals(message)){
	%>			
			alert("<fmt:message key="MSG0006" bundle="${message}"/>");
	<%	} else if ("MSG0007".equals(message)){
	%>			
			alert("<fmt:message key="MSG0007" bundle="${message}"/>");
	<%	}
	%>
</script>				
<script type="text/javascript">
<!--
	
	function isValidFormat(obj,format) {
		if(obj.value.search(format) != -1) {
			return true;
		}
		return false;
	}
	function isNumber(obj) {
		var str = obj.value;
		if(str.length == 0){
		alert(str.length);
			return false;
		}
		for(var i=0; i < str.length; i++) {
			if(!('0' <= str.charAt(i) && str.charAt(i) <= '9'))
				return false;
		}
		return true;
	}
	function isPhoneNumber(obj) {
		if(obj.value == "") {
			return true;
		}
		var format = /^(\d+)-(\d+)-(\d+)$/;
		return isValidFormat(obj,format);
	}	
	function isNull(obj) {
		if(obj.value == "") {
			return true;
		}
	}
	function isEmail(obj) {
		var str = obj.value;
		if(str == "")
			return false;
	
		i = str.indexOf(".");
		if(i < 0)
			return false;
		
		return true;
	}
	function registCheck(ff) {
			if(isNull(ff.title)) {
				alert("제목을 넣어 주세요");
				return false;
			}
			if(isNull(ff.content)) {
				alert("내용을 넣어 주세요");
				return false;
			}			
			ff.action="EngMailRegist";
			ff.submit(); 		
			return true;
	}			
	function mailSendCheck(ff) {
			if(isNull(ff.title)) {
				alert("제목을 넣어 주세요");
				return false;
			}
			if(isNull(ff.content)) {
				alert("내용을 넣어 주세요");
				return false;
			}	
			ff.action="EngMailSend";
			ff.submit(); 
			return true;
	}
	function engListCheck(ff) {

			ff.action="EngList";
			ff.submit(); 
			return true;
	}	
	function enableLanguage(flg){
		var lan1 = document.wf.language1.value;
		var lan2 = document.wf.language2.value;
		if(flg==1){
			if(lan1==""){			
				document.wf.language2.disabled=true;
				document.wf.language3.disabled=true;			
				document.wf.language2.value="";		
				document.wf.language3.value="";
			}else{			
				document.wf.language2.disabled=false;
			}
		}else if(flg==2){
			if(lan2==""){
				document.wf.language3.disabled=true;
				document.wf.language3.value="";
			}else{			
				document.wf.language3.disabled=false;
			}
		}
	}
	function enableService_area(){
		var service_area_1 = document.wf.service_area_1.value;
			if(service_area_1==""){
				document.wf.service_area_2.disabled=true;
				document.wf.service_area_2.value="";
			}else{			
				document.wf.service_area_2.disabled=false;
		}
	}
	function enableNation(nation){
			if(nation==""){
				document.wf.nation_etc.disabled=false;
			}else{			
				document.wf.nation_etc.value="";
				document.wf.nation_etc.disabled=true;
		}
	}
	function payUnitChk(Unit){
			if(Unit==""){
				document.wf.pay_unit_etc.disabled=false;
			}else{			
				document.wf.pay_unit_etc.value="";
				document.wf.pay_unit_etc.disabled=true;
		}
	}
	function logIn(){
		window.open('PopLogin', 'notice', 'width=230, height=160');		
	}
	
	function formCheck(f) {
		ID = /^[A-Za-z0-9]+$/;
		if (f.userid.value =="") { 
			alert("아이디가 입력되어져 있지 않습니다.");
			f.userid.focus();
			return false;
			}else if(!isIdShort(f.userid)){
	   		alert("아이디를 4자이상 12자이하로 해주세요.");
	   		return false;
	   		}else if (!ID.test(f.userid.value)) {
			alert('ID는 영문,숫자만 가능합니다.');
			f.userid.value="";
			f.userid.focus();
			}else {
			f.action="MemberIDCheck?pageName=InterpretRegistOpen";
			f.submit(); 
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

<script src="jsp/Scripts/AC_RunActiveContent.js" type="text/javascript"></script>
<link href="jsp/include/css/kankokujin.css" rel="stylesheet" type="text/css">
</head>

<body style="margin:0 0 0 0">
<table border="0" cellpadding="0" cellspacing="0" width="950" align="center">
	<!----- top메뉴 ------>
	<tr valign="top">
		<td colspan="3"><jsp:include page="../include/top.jsp"
			flush="true" /></td>
	</tr>
	<!----- 콘텐츠 영역 ----->
	<tr>
		<!-- 콘텐츠간 간격 -->
		<td width="10"><img src="jsp/images/common/space.gif" alt=""
			width="10" height="15"></td>
		<!-- 콘텐츠간 간격 -->


		<!-- 메인 콘텐츠 -->
		<td width="950" valign="top">
		<table border="0" cellpadding="0" cellspacing="0" width="930">
			<form name="wf" method="post">
			<!-- 여기에 실제 메인 바디 소스코딩을 해주세요. -->
			<table border="0" cellpadding="0" cellspacing="0" width="930">

				<tr height="30">
					<td align="right"><a href="">Home</a> <b>技術者メール登録</b></td>
				</tr>

				<tr>
					<td>
					<table border="0" cellpadding="0" cellspacing="0" width="743"
						height="20">
						<tr>
							<td align="center"><img src="jsp/images/common/title_eng_mail_regist.gif"></td>
						</tr>
						<tr>
							<td><img src="jsp/images/common/space.gif" alt="" width="1"
								height="15"></td>
						</tr>
					</table>
					<table width="800" border="1" align="center" cellpadding="0"
						cellspacing="0" bordercolor="#E2E0D6" frame="void" rules="rows"
						style="border-collapse:collapse;">
						<col width="400" bgcolor="#F0F0E2" style="padding-left:10">
						<col width="332" style="padding-left:10">
						<col width="102" bgcolor="#F0F0E2" style="padding-left:10">
						<col width="120" style="padding-left:10">
						
						<tr>
							<td bgcolor="#ffffff" colspan="4"></td>
						</tr>
						<tr>
					    	<td>selected email address
					    	</td>
					    	<td>
					    		<table border=1>
					    		
								<%
									
									Iterator it = selectedMailList.iterator();
									int count = 0;	
									while (it.hasNext()) {
										%><tr><td width="300" align="center"><%
										count ++;
										EngmailListBean bean = (EngmailListBean)it.next();
										%><%=bean.getTo_name()%><%
										%></td>              		

		            <input type="hidden" name="web_mail_<%=count%>" value="<%=bean.getTo_mail()%>">
		            <input type="hidden" name="mobile_mail_<%=count%>" value="<%=bean.getTo_mobile_mail()%>">
		            <%
										if (!Util.isEmpty(bean.getTo_mail())) {
											%><td width="300"><%
											//sb.append(";");
											//sb.append(bean.getTo_mail());
											%><%=bean.getTo_mail()%><%
											%></td><%
										}
										if (!Util.isEmpty(bean.getTo_mobile_mail())) {
											%><td width="300"><%
											//sb.append(";");
											//sb.append(bean.getTo_mobile_mail());	
											%><%=bean.getTo_mobile_mail()%><%
											%></td><%											
										}
										%><td></tr><%
										
									}
				
		
								%>
					            <input type="hidden" name="count" value="<%=count%>">										
								</table>
					    	</td>					    	
					    </tr>						
						<tr>
					    	<td>email address
					    	</td>
					    	<td><input type="text" name="email" value=""
								size="100" maxlength="100">
					    	</td>					    	
					    </tr>
					    <tr>
					    	<td>タイトル
					    	</td>
					    	<td><input type="text" name="title" value=""
								size="100" maxlength="100">
					    	</td>					    	
					    </tr>

						<tr>
							<td style="padding-left:20">内容</td>
							<td><textarea name="content" rows="35" cols="90"></textarea>

							</td>
						</tr>
						<tr>
							<td bgcolor="#ffffff" colspan="2"></td>
						</tr>
					</table>
					<table border="0" cellpadding="0" cellspacing="0" width="680"
						height="20" align="center">
						<tr style="padding-top:15">
							<td align="right"><img src="jsp/images/common/btn_regist.gif" onclick='return registCheck(wf)'>&nbsp;
							<a href="EngMailRegistOpen"><img src="jsp/images/common/btn_rewrite.gif"></a>&nbsp;
							<a href="EngMailList"><img src="jsp/images/common/btn_list.gif"></a>
							<img src="jsp/images/common/btn_send_mail.gif" onclick='return mailSendCheck(wf)'>
							<img src="jsp/images/common/btn_eng_list.gif" onclick='return engListCheck(wf)'></td>														
						</tr>
					</table>
				</tr>
			</table>
			</form>
			<!-- 메인 콘텐츠 -->
			<!-- 콘텐츠간 간격 -->

			<!----- 콘텐츠 영역 ----->

			<tr height="40">
				<td colspan="3"></td>
			</tr>


			<!----- Footer 영역 ----->

			<tr valign="top">
				<td colspan="3"><jsp:include page="../include/footer.jsp"
					flush="true" /></td>
			</tr>
			<!----- Footer 영역 ----->
		</table>
		</td>
		</tr>
		</table>
</body>
</html>