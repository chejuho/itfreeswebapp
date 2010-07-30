<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="bean.MemberBean, bean.HouseFindInfo"%>
<%
request.setCharacterEncoding("UTF-8");
%>
<%@ page import="dbhandler.UtilHandler"%>

<%
	MemberBean member = new MemberBean();
	member = (MemberBean) session.getAttribute("memberInfo");
	System.out.println("member=" + member);
	String checked = "";
	if (member != null) {
%>

<%
} else {
%>
<script language="javascript">
				alert("로그인을 해주세요.");
				location.href="";
			</script>
<%
}
	HouseFindInfo houseFindInfo = (HouseFindInfo)request.getAttribute("HouseFindInfo");
%>
<html>
<head>
<title>캉코쿠진닷컴</title>
<meta http-equiv="Content-type" content="text/html; charset=UTF-8">
<script language="javascript" src="jsp/Scripts/top.js"></script>
<script type="text/javascript">
<!--

	function houseFindRegistCheck(ff) {

		if(isNull(ff.title)) {
			alert("제목을 입력해 주세요.");
			return false;
		}

		if(isNull(ff.user_id)) {
			alert("이름을 입력해 주세요.");
			return false;
		}
		
		if(isNull(ff.detail_info)) {
			alert("상세내용을 입력해주세요.");
			return false;
		}
		
		if(!isEmail(ff.email)) {
			alert("예)xxxx@xxxx.co.jp형식으로 입력해주세요.");
			return false;
		}
		
		if(!isPhoneNumber(ff.telephone)) {
			alert("예)0000-0000-0000형식으로 입력해주세요.");
			return false;
		}

		ff.action="HouseFindRegist";
		ff.submit(); 
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
	function isPhoneNumber(obj) {

		if(obj.value == "") {
			return true;
		}
		var format = /^(\d+)-(\d+)-(\d+)$/;
		return isValidFormat(obj,format);
	}
function isValidFormat(obj,format) {
	if(obj.value.search(format) != -1) {
		return true;
	}
	return false;
}	
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
//-->
</script>
<script src="jsp/Scripts/AC_RunActiveContent.js" type="text/javascript"></script>
<link href="jsp/include/css/kankokujin.css" rel="stylesheet"
	type="text/css">
</head>

<body style="margin:0 0 0 0">
<table border="0" cellpadding="0" cellspacing="0" width="950"
	align="center">

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
		<td width="743" valign="top">
		<table border="0" cellpadding="0" cellspacing="0" width="930">
			<!-- 여기에 실제 메인 바디 소스코딩을 해주세요. -->
			<%


				//System.out.println("area_1 =" + area_1 + " , area_2 = " + area_2 + ", train_line =" + train_line + " , station = " + station);
				//System.out.println("title=" + title + ", detail_info="+detail_info + ", decoding=" + detail_info);
				UtilHandler util = new UtilHandler();
				String selected = " selected ";
			%>
			<form name="wf" method="post" enctype="multipart/form-data" action="HouseFindOpenWrite">
			<table border="0" cellpadding="0" cellspacing="0" width="930">
				<!---- Location ---->
				<tr height="30">
					<td align="right"><a href="jsp/index.html">Home</a> <b>집구하기</b></td>
				</tr>
				<!---- Location ---->
				<tr>
					<td><!-- QNA -->
					<table border="0" cellpadding="0" cellspacing="0" width="743"
						height="20">
						<tr>
							<td><img src="jsp/images/08housefind/img_title.gif"
								width="928" height="29"></td>
						</tr>
						<tr>
							<td><img src="jsp/images/common/space.gif" alt="" width="1"
								height="15"></td>
						</tr>
					</table>
					<table border="0" cellpadding="0" cellspacing="0" width="680"
						height="20" align="center">
						<tr style="padding-top:15">
							<td class="visit visit">※ 필수항목 (<font color=red>*</font>표시)
							만 입력해도 가능합니다. 선택항목을 입력하면 보다 편리한 정보로 검색되실 수 있습니다.</td>
						</tr>
					</table>
					<table width="680" border="1" align="center" cellpadding="0"
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
							<td style="padding-left:20"><font color=red>*</font> 글제목</td>
							<td><input type="text" name="title" value="<%=houseFindInfo.getTitle() %>"
								size="40" maxlength="100" class="text01"></td>
							<td style="padding-left:20">등록자</td>
							<td><input type="text" name="user_id" value="<%=houseFindInfo.getUser_id() %>"
								size="20" maxlength="20" readonly class="text01"></td>
						</tr>
						<tr height="28">
							<td height="27" style="padding-left:20"><font color=red>*</font>
							내용/기타</td>
							<td colspan="3"><textarea name="detail_info" rows="5"
								cols="70"><%=houseFindInfo.getDetail_info()%></textarea></td>
						</tr>
						<tr height="28">
							<td height="24" style="padding-left:20">이메일</td>
							<td><input type="text" name="email" value="<%=houseFindInfo.getEmail() %>"
								size="30" maxlength="50" readonly class="text01"></td>
							<td style="padding-left:20">전화번호</td>
							<td><input type="text" name="telephone"
								value="<%=houseFindInfo.getTelephone() %>" size="20" maxlength="20" class="text01"></td>
						</tr>
						<tr height="28">
							<td width="120" height="19" style="padding-left:20">입거가능일</td>
							<td colspan="3"><input type="radio" name="come_dock"
								value="1" <%=houseFindInfo.getCome_dock_ime_checked()%> 
								onClick="radioCheckDock(1)">즉시&nbsp;&nbsp;&nbsp; <input
								type="radio" name="come_dock" value="2"
								<%=houseFindInfo.getCome_dock_not_ime_checked()%> 
								onClick="radioCheckDock(2)">지정일&nbsp; <input type="text"
								name="come_dock_year" value="<%=houseFindInfo.getCome_dock_year()%>" size="4"
								maxlength="4" <%if("1".equals(houseFindInfo.getCome_dock())){%> disabled=true <%}%>
								class="text01">년(2008) <input type="text"
								name="come_dock_month" value="<%=houseFindInfo.getCome_dock_month()%>" size="2"
								maxlength="2" <%if("1".equals(houseFindInfo.getCome_dock())){%> disabled=true <%}%>
								class="text01">월(07) <FONT class="purple"></FONT></td>
						</tr>
						<tr height="28">
							<td height="19" style="padding-left:20">야칭</td>
							<td colspan="3"><input type="text" name="house_fee_from"
								value="<%=houseFindInfo.getHouse_fee_from()%>" size="7" maxlength="20" class="text01">
							&nbsp;엔 - <input type="text" name="house_fee_to"
								value="<%=houseFindInfo.getHouse_fee_to()%>" size="7" maxlength="20" class="text01">
							&nbsp;엔</td>
						</tr>
						<tr height="28">
							<td height="52" style="padding-left:20">지역</td>
							<td colspan="3"><input type="radio" name=main_area value="1"
								<%=houseFindInfo.getMain_area_checked()%>
								onClick="radioCheck(1)"> 빠른지역설정 <select name='area_fast'
								class="date" <%if("2".equals(houseFindInfo.getMain_area())){%> disabled=true <%}%>>
								<option <%if("".equals(houseFindInfo.getArea_fast())){%> <%=selected %> <%}%>
									value="">선택해주세요</option>
								<option <%if("okubo_area".equals(houseFindInfo.getArea_fast())){%> <%=selected %>
									<%}%> value="okubo_area">오오쿠보지역</option>
								<option <%if("nakano_area".equals(houseFindInfo.getArea_fast())){%> <%=selected %>
									<%}%> value="nakano_area">나카노지역</option>
								<option <%if("nippori_area".equals(houseFindInfo.getArea_fast())){%> <%=selected %>
									<%}%> value="nippori_area">닛뽀리지역</option>
							</select> <br>

							<input type="radio" name=main_area value="2"
								<%=houseFindInfo.getMain_area_not_checked()%>
								onClick="radioCheck(2)"> 상세지역설정 <select name='area_1'
								onChange='document.wf.submit()' <%if("1".equals(houseFindInfo.getMain_area())){%>
								disabled=true <%}%>>
								<%=util.getArea1Tag(houseFindInfo.getArea_code_1())%>
							</select> <select name='area_2' <%if("1".equals(houseFindInfo.getMain_area())){%>
								disabled=true <%}%>>
								<%=util.getArea2Tag(houseFindInfo.getArea_code_1(), houseFindInfo.getArea_code_2())%>
							</select></td>
						</tr>
						<tr height="28">
							<td height="24" style="padding-left:20">교통정보</td>
							<td colspan="3"><select name='line_code'
								onChange='document.wf.submit()'>
								<%=util.getTrainLineTag(houseFindInfo.getLine_code())%>
							</select> 센 <select name='station_code'>
								<%=util.getStationTag(houseFindInfo.getLine_code(), houseFindInfo.getStation_code())%>
							</select> 역에서 도보 <input type="text" name="walk_time" size="5"
								value="<%=houseFindInfo.getWalk_time()%>" maxlength="20" class="text01">분이내
							<br>
							</td>
						</tr>
						<tr height="28">
							<td height="47" style="padding-left:20">건물종류</td>
							<td colspan="3">
								<input type="checkbox" name="house_sort_0" value="checked" <%=houseFindInfo.getHouse_sort()[0]%>>
					                  아파트
					                  <input type="checkbox" name="house_sort_1" value="checked" <%=houseFindInfo.getHouse_sort()[1]%>>
					                  맨션
					                  <input type="checkbox" name="house_sort_2" value="checked" <%=houseFindInfo.getHouse_sort()[2]%>>
					                   개인주택 
					                  <input type="checkbox" name="house_sort_3" value="checked" <%=houseFindInfo.getHouse_sort()[3]%>>
					                  주차장
					                  
					                  <input type="checkbox" name="house_sort_4" value="checked" <%=houseFindInfo.getHouse_sort()[4]%>>
					                  점포<br>
					                  <input type="checkbox" name="house_sort_5" value="checked" <%=houseFindInfo.getHouse_sort()[5]%>>
					                    사무실
					                      <input type="checkbox" name="house_sort_6" value="checked" <%=houseFindInfo.getHouse_sort()[6]%>>
					                      토지                         <input type="checkbox" name="house_sort_7" value="checked" <%=houseFindInfo.getHouse_sort()[7]%>>
					                     기타
								</td>
						</tr>
						<tr height="28">
							<td height="26" style="padding-left:20">전용면적</td>
							<td colspan="3"><input type="text" name="dimension_from"
								value="<%=houseFindInfo.getDimension_from()%>" size="7" maxlength="20" class="text01">m2～
							<input type="text" name="dimension_to" value="<%=houseFindInfo.getDimension_to()%>"
								size="7" maxlength="20" class="text01">m2</td>
						</tr>
						<col width="121" bgcolor="#f9f9f9">
						<col width="559" style="padding-left:17">
						<tr height="28">
							<td height="48" style="padding-left:20">마도리</td>
							<td colspan="3">                  
								<input type="checkbox" name="madori_0" value="checked" <%=houseFindInfo.getMadori()[0]%>>
			                  1R
			                  <input type="checkbox" name="madori_1" value="checked" <%=houseFindInfo.getMadori()[1]%>>
			                  1K
			                  <input type="checkbox" name="madori_2" value="checked" <%=houseFindInfo.getMadori()[2]%>>
			                  1DK
			                  <input type="checkbox" name="madori_3" value="checked" <%=houseFindInfo.getMadori()[3]%>>
			                    1LDK 
			                      <input type="checkbox" name="madori_4" value="checked" <%=houseFindInfo.getMadori()[4]%>>
			                      2K
			                        <input type="checkbox" name="madori_5" value="checked" <%=houseFindInfo.getMadori()[5]%>>
			                        2DK <br>
			                          <input type="checkbox" name="madori_6" value="checked" <%=houseFindInfo.getMadori()[6]%>>
			                          2LDK 
			                  
			                  <input type="checkbox" name="madori_7" value="checked" <%=houseFindInfo.getMadori()[7]%>>
			                  3DK 
			                  <input type="checkbox" name="madori_8"　value="checked" <%=houseFindInfo.getMadori()[8]%>>
			                    3LDK
			                      <input type="checkbox" name="madori_9" value="checked" <%=houseFindInfo.getMadori()[9]%>>
			                      4DK
			                        <input type="checkbox"  name="madori_10" value="checked" <%=houseFindInfo.getMadori()[10]%>>
			                        4LDK
			                          <input type="checkbox" name="madori_11" value="checked" <%=houseFindInfo.getMadori()[11]%>>
                          		기타 </td>
						</tr>
					</table>
					<table border="0" cellpadding="0" cellspacing="0" width="680"
						height="20" align="center">
						<tr style="padding-top:15">
							<td align="right"><img src="jsp/images/common/btn_cs_ok.gif"
								onclick='return houseFindRegistCheck(wf)'>&nbsp; <a
								href="HouseFindOpenWrite"><img
								src="jsp/images/common/btn_cs_rewrite.gif"></a>&nbsp; <a
								href="HouseFindList"><img
								src="jsp/images/common/btn_csnotice_list.gif"></a></td>
						</tr>
					</table>
				</tr>
			</table>
			<!-- 메인 콘텐츠 --> <!-- 콘텐츠간 간격 --> <!----- 콘텐츠 영역 -----></form>
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
