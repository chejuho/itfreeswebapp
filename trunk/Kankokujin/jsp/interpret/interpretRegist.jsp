<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@page import="common.bean.MemberBean"%>
<%@page import="common.util.Util"%>
<%@page import="interpret.bean.InterpretBean"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<fmt:setLocale value="KO"/>
<fmt:setBundle basename="msg" var="message"/>
<%
	request.setCharacterEncoding("UTF-8");
	InterpretBean interpretBean = new InterpretBean();
	if(session.getAttribute("InterpretBean")!=null){
		interpretBean = (InterpretBean) session.getAttribute("InterpretBean");
	}
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
	function sellcheck(ff) {
		<%if(member==null){ %>
	
			if(isNull(ff.userid)) {
				alert("아이디를 입력해 주세요.");
				return false;
			}
	
			if(isNull(ff.user_name)) {
				alert("이름을 입력해 주세요.");
				return false;
			}
			if(isNull(ff.password)) {
				alert("비밀번호를 입력해 주세요.");
				return false;
			}			
			if(ff.password.value!=ff.repassword.value){
				alert("입력하신 비밀번호가 서로 다릅니다.\n다시 입력을 해주십시요.");
				return false;
			}
			
			if(isNull(ff.email1)&&isNull(ff.email2)) {
				alert("메일주소를 입력해 주세요.");
				return false;
			}
			if(!isEmail(ff.email2)) {
				alert("메일형식으로 입력해주세요.");
				return false;
			}
		<%}%>

		if(isNull(ff.language1)) {
			alert("'통역대상언어/언어1'을 입력해 주세요.");
			return false;
		}	
		if(isNull(ff.service_area_1)) {
			alert("'통번역가능지역/서비스가능국가'을 선택해 주세요.");
			return false;
		}	
		if(!isNull(ff.tel1)||!isNull(ff.tel2)||!isNull(ff.tel3)) {
			if(isNull(ff.tel1)||isNull(ff.tel2)||isNull(ff.tel3)) {
				alert("전화번호를 전부 입력해주세요.");
				return false;
			}
		}
		if(!isNull(ff.mobile1)||!isNull(ff.mobile2)||!isNull(ff.mobile3)) {
			if(isNull(ff.mobile1)||isNull(ff.mobile2)||isNull(ff.mobile3)) {
				alert("전화번호를 전부 입력해주세요.");
				return false;
			}
		}
		if(isNull(ff.birth_year) && !isNull(ff.birth_month)) {
			alert("생년월(년)을 입력해주세요.");
			return false;
		}		
		if(!isNull(ff.birth_year) && isNull(ff.birth_month)) {
			alert("생년월(월)을 입력해주세요.");
			return false;
		}				
		if(!isNull(ff.birth_year) && !isNumber(ff.birth_year)) {
			alert("지정일(년)은 숫자로 입력해주세요.");
			return false;
		}			
		if(!isNull(ff.birth_month) && !isNumber(ff.birth_month)) {
			alert("지정일(월)은 숫자로 입력해주세요.");
			return false;
		}	
		if(!isNull(ff.pay) && !isNumber(ff.pay)) {
			alert("기준요금은 숫자로 입력해주세요.");
			return false;
		}
		if(!isNull(ff.pay)){
			if(isNull(ff.pay_unit) && isNull(ff.pay_unit_etc)) {
			alert("화폐단위를 선택해주세요.");
			return false;
			}
		}
			ff.action="InterpretRegistConfirm";
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
<script language="JavaScript" Event="onLoad" For="window"> 
	if(document.wf.service_area_1.value==""){
		document.wf.service_area_2.disabled=true;
	}
	if(document.wf.language1.value==""){
		document.wf.language2.disabled=true;
	}	
	if(document.wf.language2.value==""){
		document.wf.language3.disabled=true;
	}
	if(document.wf.nation.value!=""){
		document.wf.nation_etc.disabled=true;
	}
	
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
			<form name="wf" method="post" enctype="multipart/form-data">
			<!-- 여기에 실제 메인 바디 소스코딩을 해주세요. -->
			<table border="0" cellpadding="0" cellspacing="0" width="930">

				<tr height="30">
					<td align="right"><a href="">Home</a> <b>통번역 회원등록</b></td>
				</tr>

				<tr>
					<td>
					<table border="0" cellpadding="0" cellspacing="0" width="743"
						height="20">
						<tr>
							<td><img src="jsp/images/10interpret/img_title_interpret_regist.gif"
								width="928" height="29"></td>
						</tr>
						<tr>
							<td><img src="jsp/images/common/space.gif" alt="" width="1"
								height="15"></td>
						</tr>
					</table>
					<table border="0" cellpadding="0" cellspacing="0" width="800"
						height="20" align="center">
						<tr style="padding-top:0">
							<td>※ 필수항목 (<font color=red>*</font>)은 반드시 입력해주세요!
							</td>
						</tr>
						<%if(member==null){ %>
						<tr style="padding-top:0">
							<td><font color=red>※ 회원이신분은 <a href="javascript:logIn()">로그인</a>하신후 등록해 주세요.</font>
							</td>
						</tr>
						<%} %>
					</table>					
					<table width="800" border="1" align="center" cellpadding="0"
						cellspacing="0" bordercolor="#E2E0D6" frame="void" rules="rows"
						style="border-collapse:collapse;">
						<col width="116" bgcolor="#F0F0E2" style="padding-left:10">
						<col width="332" style="padding-left:10">
						<col width="102" bgcolor="#F0F0E2" style="padding-left:10">
						<col width="120" style="padding-left:10">
						<tr>
							<td bgcolor="#ffffff" colspan="4"></td>
						</tr>
						<tr height="28">
						<%if(member!=null){ %>
								<input type="hidden" name="userid" value="<%=member.getUserid() %>">
						<%}else{ %>
							<td style="padding-left:20"><font color=red>*</font> 아이디</td>
							<td>
								<input type="text" name="userid" value="<%=interpretBean.getUser_id() %>" size="40" maxlength="80">
								<img src="jsp/images/common/btn_repeat_check.gif" align="absmiddle" onclick='return formCheck(wf)'>
							</td>
						<%} %>
						</tr>					
						<%if(member==null){ %>
						<tr height="28">
							<td style="padding-left:20"><font color=red>*</font> 비밀번호</td>
							<td><input type="password" name="password" value=""
								size="40" maxlength="80"></td>
						</tr>
						<tr height="28">
							<td style="padding-left:20"><font color=red>*</font> 비밀번호재입력</td>
							<td><input type="password" name="repassword" value=""
								size="40" maxlength="80"></td>
						</tr>
						<%} %>
						<tr>
							<%if(member!=null){ %>
							<td style="padding-left:20">이름</td>
							<td>
								<%=member.getName() %>
								<input type="hidden" name="user_name" value="<%=member.getName() %>" >
							
							<%}else{ %>
							<td style="padding-left:20"><font color=red>*</font> 이름</td>
							<td>
								<input type="text" name="user_name" value="<%=interpretBean.getUser_name() %>" size="20" maxlength="20" >
							<%} %>
							</td>
						</tr>
						<tr>
							<%if(member!=null){ %>
							<td style="padding-left:20"> 이메일</td>
							<td>
								<%=member.getEmail1() %>@<%=member.getEmail2() %>
							</td>
							<%}else{ %>
							<td style="padding-left:20"><font color=red>*</font> 이메일</td>
							<td>
								<input type="text" name="email1" value="<%=interpretBean.getEmail1() %>" size="12" maxlength="12" class="write">@
								<input type="text" name="email2" value="<%=interpretBean.getEmail2() %>" size="12" maxlength="12" class="write"> <br>
								<span class="visit visit">- 비밀번호 분실 시, 기입해주신 <font class="text_c4">이메일</font>
								 주소로 비밀번호를 전송해 드립니다.</span>
							</td>
							<%} %>
						</tr>
						<tr>
							<td style="padding-left:20"> 전화번호</td>
							<td>
							    <table width="95%">
							    	<tr>
								    	<td rowspan="2">
								    	국가번호<br><input type="text" name="nation_no" value="<%=interpretBean.getNation_no()%>" size="4" maxlength="4">								    		
								    	</td>
								    	<td>전화</td>
								    	<td>							    	
								    		<span class="style3"> 
								    		<input type="text" name="tel1" value="<%=interpretBean.getTel()[0] %>" size="6" maxlength="4" class="write"> - 
								    		<input type="text" name="tel2" value="<%=interpretBean.getTel()[1] %>" size="11" maxlength="4" class="write"> - 
								    		<input type="text" name="tel3" value="<%=interpretBean.getTel()[2] %>" size="11" maxlength="4" class="write">
								    		</span>
								    		<input type="checkbox" name="tel_no_1_open" value="1"<%if("1".equals(interpretBean.getTel_no_1_open())){%> checked<%} %>>공개
								    	</td>
							    	</tr>
							    	<tr>
								    	<td>휴대전화</td>
								    	<td>					    	
								    		<span class="style3"> 
								    		<input type="text" name="mobile1" value="<%=interpretBean.getMobile()[0] %>" size="6" maxlength="4" class="write"> - 
								    		<input type="text" name="mobile2" value="<%=interpretBean.getMobile()[1] %>" size="11" maxlength="4" class="write"> - 
								    		<input type="text" name="mobile3" value="<%=interpretBean.getMobile()[2] %>" size="11" maxlength="4" class="write">
								    		</span>
								    		<input type="checkbox" name="tel_no_2_open" value="1"<%if("1".equals(interpretBean.getTel_no_2_open())){%> checked<%} %>>공개
								    	</td>
							    	</tr>
							    	
							    </table>
							</td>
						</tr>						
						<tr>
							<td style="padding-left:20"><font color=red>*</font> 통번역언어</td>
							<td>
								제1언어
								<%								
			                	String[] language = interpretBean.getLanguage_Select();  								
								%>
								<select name="language1" onchange="enableLanguage(1)">
									<option value= ""<%if( "".equals(language[0])){%> selected<%} %>>선택해주십시요</option>
									<option value="0"<%if("0".equals(language[0])){%> selected<%} %>>한국어</option>
									<option value="1"<%if("1".equals(language[0])){%> selected<%} %>>일본어</option>
									<option value="2"<%if("2".equals(language[0])){%> selected<%} %>>영어</option>
									<option value="3"<%if("3".equals(language[0])){%> selected<%} %>>중국어</option>
								</select>
								제2언어
								<select name="language2" onchange="enableLanguage(2)">
									<option value= ""<%if( "".equals(language[1])){%> selected<%} %>>선택해주십시요</option>
									<option value="0"<%if("0".equals(language[1])){%> selected<%} %>>한국어</option>
									<option value="1"<%if("1".equals(language[1])){%> selected<%} %>>일본어</option>
									<option value="2"<%if("2".equals(language[1])){%> selected<%} %>>영어</option>
									<option value="3"<%if("3".equals(language[1])){%> selected<%} %>>중국어</option>
								</select>								
								제3언어
								<select name="language3">
									<option value= ""<%if( "".equals(language[2])){%> selected<%} %>>선택해주십시요</option>
									<option value="0"<%if("0".equals(language[2])){%> selected<%} %>>한국어</option>
									<option value="1"<%if("1".equals(language[2])){%> selected<%} %>>일본어</option>
									<option value="2"<%if("2".equals(language[2])){%> selected<%} %>>영어</option>
									<option value="3"<%if("3".equals(language[2])){%> selected<%} %>>중국어</option>
								</select>					
								<br>
								그외의 언어
								<input type="text" name="language_etc" value="<%=interpretBean.getLanguage_etc() %>" size="20" maxlength="20" >
								
							</td>
						</tr>
						<tr>
							<td style="padding-left:20"><font color=red>*</font> 통번역가능지역</td>
							<td>
								서비스가능국가
								<% String service_area_1 = interpretBean.getService_area_1();%>
								<select name="service_area_1" onchange="enableService_area()">
									<option value= ""<%if( "".equals(service_area_1)){%> selected<%} %>>선택해주십시요</option>
									<option value="0"<%if("0".equals(service_area_1)){%> selected<%} %>>한국</option>
									<option value="1"<%if("1".equals(service_area_1)){%> selected<%} %>>일본</option>
									<option value="2"<%if("2".equals(service_area_1)){%> selected<%} %>>미국</option>
									<option value="3"<%if("3".equals(service_area_1)){%> selected<%} %>>중국</option>
								</select>
								상세지역
								<input type="text" name="service_area_2" value="<%=interpretBean.getService_area_2() %>" size="20" maxlength="20" >
								예)동경, 오사까 등
								<br>
								기타서비스가능국가
								<input type="text" name="service_area_1_etc" value="<%=interpretBean.getService_area_1_etc() %>" size="20" maxlength="20" >
								(한국,일본,미국,중국 이외의 경우에 입력해주세요)
							</td>
						</tr>
						<tr>
							<td style="padding-left:20"> 성별</td>
							<td>
								<% String sex = interpretBean.getSex();%>
								<input type="radio" name="sex" value="0"<%if("0".equals(sex)){%> checked<%} %>> 남
								<input type="radio" name="sex" value="1"<%if("1".equals(sex)){%> checked<%} %>> 여
							</td>
						</tr>
						<tr>
							<td style="padding-left:20"> 생년월</td>
							<td>
								<input type="text" name="birth_year" value="<%=interpretBean.getBirth()[0] %>" size="4" maxlength="4">년
								<input type="text" name="birth_month" value="<%=interpretBean.getBirth()[1] %>" size="2" maxlength="2">월
							</td>
						</tr>
						<tr>
							<td style="padding-left:20"> 국적</td>
							<td>
								<% String nation = interpretBean.getNation();%>
								<select name="nation" onchange="enableNation(this.value)">
									<option value=""<%if( "".equals(nation)){%> selected<%} %>>선택해주십시요</option>
									<option value="0"<%if( "0".equals(nation)){%> selected<%} %>>한국</option>
									<option value="1"<%if( "1".equals(nation)){%> selected<%} %>>일본</option>
									<option value="2"<%if( "2".equals(nation)){%> selected<%} %>>미국</option>
									<option value="3"<%if( "3".equals(nation)){%> selected<%} %>>중국</option>
								</select>
								 <br> 기타국적 : 
								<input type="text" name="nation_etc" value="<%=interpretBean.getNation_etc()%>" size="20" maxlength="20" >
								(한국,일본,미국,중국 이외의 경우에 입력해주세요)
							</td>
						</tr>
						<tr>
							<td style="padding-left:20"> 사진첨부</td>
							<td>
								<input type="file" name="photo_path">
								<input type="checkbox" name="photo_path_open" size="80" value="1"<%if("1".equals(interpretBean.getPhoto_path_open())){%> checked<%} %>>공개
							</td>
						</tr>
						<tr>
							<td style="padding-left:20"> 이력서첨부</td>
							<td>
								<input type="file" name="resume_path">
								<input type="checkbox" name="resume_path_open" size="80" value="1"<%if("1".equals(interpretBean.getResume_path_open())){%> checked<%} %>>공개
							</td>
						</tr>						
						<tr>
							<td style="padding-left:20"> 1일기준요금</td>
							<td><input type="text" name="pay" value="<%=interpretBean.getPay() %>" size="10" maxlength="10">
								<% String pay_unit = interpretBean.getPay_unit();%>
								<select name="pay_unit" onchange="payUnitChk(this.value)">
									<option value="" <%if(  "".equals(pay_unit)){%> selected<%} %>>-통화단위-</option>
									<option value="0"<%if( "0".equals(pay_unit)){%> selected<%} %>>원</option>
									<option value="1"<%if( "1".equals(pay_unit)){%> selected<%} %>>엔</option>
									<option value="2"<%if( "2".equals(pay_unit)){%> selected<%} %>>달러</option>
								</select>
								통화단위(기타)
								<input type="text" name="pay_unit_etc" value="<%=interpretBean.getPay_unit_etc() %>" size="6" maxlength="6">
							</td>							
						</tr>
						<tr>
							<td style="padding-left:20"> 경력</td>
							<td><textarea name="skill" rows="6" cols="80"><%=interpretBean.getSkill() %></textarea>
								<input type="checkbox" name="skill_open" value="1" <%if("1".equals(interpretBean.getSkill_open())){%> checked<%} %>>공개
							</td>
						</tr>
						<tr>
							<td style="padding-left:20"> 자격증</td>
							<td><textarea name="certification" rows="6" cols="80"><%=interpretBean.getCertification() %></textarea>
								<input type="checkbox" name="certification_open" value="1"<%if("1".equals(interpretBean.getCertification_open())){%> checked<%} %>>공개
							</td>
						</tr>
						<tr>
							<td style="padding-left:20"> 자기소개</td>
							<td><textarea name="introduction" rows="6" cols="80"><%=interpretBean.getIntroduction() %></textarea>
								<input type="checkbox" name="introduction_open" value="1"<%if("1".equals(interpretBean.getIntroduction_open())){%> checked<%} %>>공개
							</td>
						</tr>
						<tr>
							<td style="padding-left:20"> 통번역가능일</td>
							<td><textarea name="service_day" rows="6" cols="80"><%=interpretBean.getService_day() %></textarea>
								<input type="checkbox" name="service_day_open" value="1"<%if("1".equals(interpretBean.getService_day_open())){%> checked<%} %>>공개
							</td>
						</tr>
						<tr>
							<td style="padding-left:20"> 기타</td>
							<td><textarea name="etc" rows="6" cols="80"><%=interpretBean.getEtc() %></textarea>
								<input type="checkbox" name="etc_open" value="1"<%if("1".equals(interpretBean.getEtc_open())){%> checked<%} %>>공개
							</td>
						</tr>
						<tr>
							<td bgcolor="#ffffff" colspan="2"></td>
						</tr>
					</table>
					<table border="0" cellpadding="0" cellspacing="0" width="680"
						height="20" align="center">
						<tr style="padding-top:15">
							<td align="right"><img src="jsp/images/common/btn_cs_ok.gif" onclick='return sellcheck(wf)'>&nbsp;
							<a href="InterpretRegistOpen"><img src="jsp/images/common/btn_cs_rewrite.gif"></a>&nbsp;
							<a href="InterpretList"><img src="jsp/images/common/btn_csnotice_list.gif"></a></td>
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