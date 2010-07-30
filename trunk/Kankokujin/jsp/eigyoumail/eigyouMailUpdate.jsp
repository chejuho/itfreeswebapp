<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<fmt:setLocale value="KO"/>
<fmt:setBundle basename="msg" var="message"/>
<%@page import="common.bean.MemberBean"%>
<%@page import="interpret.bean.InterpretBean"%>
<%@ page import="common.util.Util"%>
<%
	request.setCharacterEncoding("UTF-8");
	InterpretBean interpretBean = (InterpretBean) request.getAttribute("InterpretBean");
	MemberBean member = new MemberBean();
	member = (MemberBean) session.getAttribute("memberInfo");
	String message = (String)Util.changeNullStr(session.getAttribute("Message"));
	if ("ERR0002".equals(message)) {
	%>
		<script language="javascript">
			alert("<fmt:message key="ERR0002" bundle="${message}"/>");
			location.href="InterpretList";
		</script>
	<%}%>
<html>
<head>
<title>캉코쿠진닷컴</title>
<meta http-equiv="Content-type" content="text/html; charset=UTF-8">
<script language="javascript" src="jsp/Scripts/top.js"></script>

<script type="text/javascript">
<!--
	function radioCheck(value){
 		if(value == "1" ) {
		 	document.wf.area_fast.disabled=false;
		 	document.wf.area_1.disabled=true;
		 	document.wf.area_2.disabled=true;
	 	}else if(value == "2" ){
 			document.wf.area_fast.disabled=true;
			document.wf.area_1.disabled=false;
			document.wf.area_2.disabled=false;
 		}
	}
	function radioCheckDock(value){
 		if(value == "1" ) {
		 	document.wf.come_dock_year.disabled=true;
		 	document.wf.come_dock_month.disabled=true;
	 	}else if(value == "2" ){
 			document.wf.come_dock_year.disabled=false;
			document.wf.come_dock_month.disabled=false;
		}
	}	
	function isNumber(obj) {
		var str = obj.value;
		if(str.length == 0)
			return false;
	
		for(var i=0; i < str.length; i++) {
			if(!('0' <= str.charAt(i) && str.charAt(i) <= '9'))
				return false;
		}
		return true;
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
	
		var i = str.indexOf("@");
		if(i < 0)
			return false;
	
		i = str.indexOf(".");
		if(i < 0)
			return false;
		
		return true;
	}
	function isValidFormat(obj,format) {
		if(obj.value.search(format) != -1) {
			return true;
		}
		return false;
	}	
	function isPhoneNumber(obj) {
		if(obj.value == "") {
			return true;
		}
		var format = /^(\d+)-(\d+)-(\d+)$/;
		return isValidFormat(obj,format);
	}
	function modifycheck(ff) {
		
		<%if(member==null){ %>
	
			if(isNull(ff.user_id)) {
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
			
			if(!isEmail(ff.email)) {
				alert("예)itfrees@itfrees.com형식으로 입력해주세요.");
				return false;
			}
		<%}%>
		if(isNull(ff.language1)) {
			alert("'통번역언어/제1언어'을 입력해 주세요.");
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
		
		
		if(confirm("<fmt:message key="MSG0012" bundle="${message}"/>")){
		ff.action="InterpretUpdate?id="+ff.id;
		ff.submit(); 
		return true;
		}
		return false;
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
	
	function enableNation(nation){
			if(nation==""){
				document.wf.nation_etc.disabled=false;
			}else{			
				document.wf.nation_etc.value="";
				document.wf.nation_etc.disabled=true;
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
	function payUnitChk(Unit){
			if(Unit==""){
				document.wf.pay_unit_etc.disabled=false;
			}else{			
				document.wf.pay_unit_etc.value="";
				document.wf.pay_unit_etc.disabled=true;
		}
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
<link href="jsp/include/css/kankokujin.css" rel="stylesheet"
	type="text/css">
</head>

<body style="margin:0 0 0 0">
<table border="0" cellpadding="0" cellspacing="0" width="950"
	align="center">
	<tr>
		<td colspan="3">
		</td>
	</tr>
	<!----- top메뉴 ------>
	<tr valign="top">
		<td colspan="3"><jsp:include page="../include/top.jsp"
			flush="true" /></td>
	</tr>
	<!----- top메뉴 ------>


	<!----- 콘텐츠 영역 ----->
	<tr>
		<!-- 콘텐츠간 간격 -->
		<td width="10"><img src="jsp/images/common/space.gif" alt="" width="10" height="15"></td>
		<!-- 콘텐츠간 간격 -->
		<!-- 메인 콘텐츠 -->
		<td width="743" valign="top">
		<table border="0" cellpadding="0" cellspacing="0" width="740">
			<!-- 여기에 실제 메인 바디 소스코딩을 해주세요. -->
			<form name="wf" method="post" enctype="multipart/form-data">
			<table border="0" cellpadding="0" cellspacing="0" width="930">

				<tr height="30">
					<td align="right"><a href="">Home</a> <b>통번역 회원정보 수정</b></td>
				</tr>
				<tr>
					<td>
					<table border="0" cellpadding="0" cellspacing="0" width="743"
						height="20">
						<tr>
							<td><img src="jsp/images/09housesell/img_title.gif"
								width="928" height="29"></td>
						</tr>
						<tr>
							<td><img src="jsp/images/common/space.gif" alt="" width="1"
								height="15"></td>
						</tr>
					</table>
					<table border="0" cellpadding="0" cellspacing="0" width="800"
						height="20" align="center">
						<tr style="padding-top:15">
							<td>※ 필수항목 (<font color=red>*</font>)은 반드시 입력해주세요!
							</td>
						</tr>
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
						<tr>							
							<td style="padding-left:20">이름</td>
							<td>
								<%=member.getName() %>
								<input type="hidden" name="user_id" value="<%=member.getUserid() %>">
								<input type="hidden" name="user_name" value="<%=member.getName() %>" >
								<input type="hidden" name="id" value="<%=interpretBean.getId()%>" >
							</td>
						</tr>
						<tr>
							<td style="padding-left:20"> 이메일</td>
							<td>
								<%=member.getEmail1() %>@<%=member.getEmail2() %>
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
								    		<input type="text" name="tel1" value="<%=interpretBean.getTel()[0] %>" size="6" maxlenth=4 class="write"> - 
								    		<input type="text" name="tel2" value="<%=interpretBean.getTel()[1] %>" size="11" maxlenth=4 class="write"> - 
								    		<input type="text" name="tel3" value="<%=interpretBean.getTel()[2] %>" size="11" maxlenth=4 class="write">
								    		</span>
								    		<input type="checkbox" name="tel_no_1_open" value="1"<%if("1".equals(interpretBean.getTel_no_1_open())){%> checked<%} %>>공개
								    	</td>
							    	</tr>
							    	<tr>
								    	<td>휴대전화</td>
								    	<td>					    	
								    		<span class="style3"> 
								    		<input type="text" name="mobile1" value="<%=interpretBean.getMobile()[0] %>" size="6" maxlenth=4 class="write"> - 
								    		<input type="text" name="mobile2" value="<%=interpretBean.getMobile()[1] %>" size="11" maxlenth=4 class="write"> - 
								    		<input type="text" name="mobile3" value="<%=interpretBean.getMobile()[2] %>" size="11" maxlenth=4 class="write">
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
								
						<!--		<select name="service_area_2">
									<option value="0">한국</option>
									<option value="1">일본</option>
									<option value="2">미국</option>
									<option value="3">중국</option>
								</select>
						  -->									
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
								<img src="<%=interpretBean.getPhoto_path()%>" width="344" height="274"><br/>
								<input type="file" name="photo_path">
								<input type="checkbox" name="photo_path_open" size="80" value="1"<%if("1".equals(interpretBean.getPhoto_path_open())){%> checked<%} %>>공개
							</td>
						</tr>
						<tr>
							<td style="padding-left:20"> 이력서첨부</td>
							<td>
								<%if(!Util.isEmpty(interpretBean.getResume())){%>
									<%=interpretBean.getResume() %><br/>
								<%} %>
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
					<table border="0" cellpadding="0" cellspacing="0" width="800" align="center">
						<tr height="2">
							<td></td>
						</tr>
						<tr height="2">
							<td align="right"><img src="jsp/images/common/btn_cs_ok.gif" onclick='return modifycheck(wf)'>&nbsp;
							<a href="InterpretUpdateOpen?id=<%=interpretBean.getId()%>"><img src="jsp/images/common/btn_cs_rewrite.gif"></a>&nbsp;
							<a href="InterpretDetail?id=<%=interpretBean.getId()%>"><img src="jsp/images/common/btn_csnotice_list.gif"></a></td>
						</tr>
					</table>
				</tr>
			</table>
			</form>
			<!-- 메인 콘텐츠 -->


			<!-- 콘텐츠간 간격 -->
			<!-- 콘텐츠간 간격 -->


			<!-- 우측콘텐츠 -->
			<!-- 우측콘텐츠 -->
			

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