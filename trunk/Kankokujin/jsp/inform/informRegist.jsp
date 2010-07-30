<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="common.bean.MemberBean"%>
<%
	request.setCharacterEncoding("UTF-8");
	MemberBean member = new MemberBean();
	member = (MemberBean) session.getAttribute("memberInfo");
	String message = (String)Util.changeNullStr(request.getAttribute("Message"));
	if (member == null) {
%>
<script language="javascript">
				alert("로그인을 해주세요.");
				location.href="";
			</script>
<%
}
%>

<%@page import="common.util.Util"%>
<html>
<head>
<title>캉코쿠진닷컴</title>
<meta http-equiv="Content-type" content="text/html; charset=UTF-8">
<script language="javascript" src="jsp/Scripts/top.js"></script>

<script type="text/javascript">
<!--
	function isNull(obj) {
		if(obj.value == "") {
			return true;
		}
	}

	function sellcheck(ff) {

		if(isNull(ff.title)) {
			alert("제목을 입력해 주세요.");
			return false;
		}	
		if(isNull(ff.detail_info)) {
			alert("상세정보를 입력해 주세요.");
			return false;
		}	
		
		ff.action="InformRegist";
		ff.submit(); 
		return true;
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
	<tr>
		<td colspan="3">
			<font color="red"><%=message%></font>
		</td>
	</tr>

	<!----- top메뉴 ------>
	<tr valign="top">
		<td colspan="3"><jsp:include page="../include/top.jsp"
			flush="true" /></td>
	</tr>
	<!----- 콘텐츠 영역 ----->
	<tr>
		<!-- 콘텐츠간 간격 -->
		<!-- 메인 콘텐츠 -->
		<td width="10"><img src="jsp/images/common/space.gif" alt=""
			width="10" height="15"></td>
		<!-- 콘텐츠간 간격 -->


		<!-- 메인 콘텐츠 -->
		<td width="950" valign="top">
		<table border="0" cellpadding="0" cellspacing="0" width="930">
			<!-- 여기에 실제 메인 바디 소스코딩을 해주세요. -->
			<form name="wf" method="post" enctype="multipart/form-data"><input
				type="hidden" name="user_id" value="<%=member.getUserid() %>">
			<table border="0" cellpadding="0" cellspacing="0" width="930">
				<!---- Location ---->
				<tr height="30">
					<td align="right"><a href="">Home</a><b>사고팔고등록</b></td>
				</tr>
				<!---- Location ---->
				<tr>
					<td><!-- QNA -->
					<table border="0" cellpadding="0" cellspacing="0" width="743"
						height="20">
						<tr>
							<td><img src="jsp/images/09housesell/img_title.gif" height="29"></td>
						</tr>
						<tr>
							<td><img src="jsp/images/common/space.gif" alt="" width="1"
								height="15"></td>
						</tr>
					</table>
					<table border="0" cellpadding="0" cellspacing="0" width="800"
						height="20" align="center">
						<tr style="padding-top:15">
							<td>※필수항목 (<font color=red>*</font>표시) 만 입력해도 가능합니다. 선택항목을
							입력하면 보다 편리한 정보로 검색되실 수 있습니다.</td>
						</tr>
					</table>
					<table width="800" border="0" align="center" cellpadding="0"
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
							<td height="24" style="padding-left:20"><font color=red>*</font>글제목</td>
							<td><input type="text" name="title" size="40" value=""
								maxlength="20"></td>
							<td style="padding-left:20">글쓴이</td>
							<td>
								<%=member.getName() %>
								<input type="hidden" name="user_id" size="40" value="<%=member.getName() %>">
							</td>
						</tr>
						<tr height="28">
							<td height="45" style="padding-left:20"><font color=red>*</font>상세정보</td>
							<td colspan="3"><textarea name="detail_info" rows="6"
								cols="80"></textarea></td>
						</tr>
						<col width="121" bgcolor="#f9f9f9">
						<col width="559" style="padding-left:20">
						
						<tr>
							<td bgcolor="#ffffff" colspan="4"></td>
						</tr>
					</table>
					<table border="0" cellpadding="0" cellspacing="0" width="680"
						height="20" align="center">
						<tr style="padding-top:15">
							<td align="right">
							    <img src="jsp/images/common/btn_cs_ok.gif" onclick='return sellcheck(wf)'>&nbsp; 
							    <a href="InformRegistOpen">
							    <img src="jsp/images/common/btn_cs_rewrite.gif"></a>&nbsp; 
								<a href="InformList">
								<img src="jsp/images/common/btn_csnotice_list.gif">
								</a>
							</td>
						</tr>
					</table>
				</tr>
			</table>
			</form>

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
