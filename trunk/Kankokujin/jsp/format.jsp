<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%
request.setCharacterEncoding("UTF-8");
%>
<html>
<head>
<title>캉코쿠진닷컴</title>
<meta http-equiv="Content-type" content="text/html; charset=UTF-8">
<script language="javascript" src="../include/js/mypot.js"></script>
<script language="javascript" src="/Share/Function.js"></script>
<script language="javascript" src="../Scripts/top.js"></script>
<script type="text/javascript">
<!--
	function loginform_clearbg(type) {
		if (type == "id") {
			document.loginform.id.style.backgroundImage = '';
		} else if (type == "pw") {
			document.loginform.pw.style.backgroundImage = '';
		}
	}
	function loginform_bgChange(obj, act) {
		if ( act == 'F') {
			obj.className = 'login';
			obj.style.backgroundColor='#B6B6B6';
		} else {
			obj.className = 'login';
			obj.style.backgroundColor='#B6B6B6';	
		}			
	}
//-->
</script>
<script src="../Scripts/AC_RunActiveContent.js" type="text/javascript"></script>
<link href="../include/css/kankokujin.css" rel="stylesheet" type="text/css">
<style type="text/css">
<!--
.style3 {font-size: 12px}
.text {
	line-height: 8px;
}
-->
</style>
</head>

<body style="margin:0 0 0 0">
<table border="0" cellpadding="0" cellspacing="0" width="950" align="center">

<!----- top메뉴 ------>
<tr valign="top">
	<td colspan="3">
		<jsp:include page="../include/top.jsp" flush="true"/>
	</td>
</tr>
<!----- top메뉴 ------>


<!----- 콘텐츠 영역 ----->
<tr>
	
	<!-- 좌측메뉴 -->
	<td width="197" valign="top">
<jsp:include page="../include/left.jsp" flush="true"/>
		</td>
	<!-- 좌측메뉴 -->


	<!-- 콘텐츠간 간격 -->
	<td width="10"><img src="../images/common/space.gif" alt="" width="10" height="15"></td>
	<!-- 콘텐츠간 간격 -->


	<!-- 메인 콘텐츠 -->
	<td width="743" valign="top"><table border="0" cellpadding="0" cellspacing="0" width="740">
	<!-- 여기에 실제 메인 바디 소스코딩을 해주세요. -->
      </td>
	<!-- 메인 콘텐츠 -->


	<!-- 콘텐츠간 간격 -->
	<!-- 콘텐츠간 간격 -->


	<!-- 우측콘텐츠 -->
	<!-- 우측콘텐츠 -->
</tr>

<!----- 콘텐츠 영역 ----->


<tr height="40">
	<td colspan="3"></td>
</tr>


<!----- Footer 영역 ----->

<tr valign="top">
	<td colspan="3">
<jsp:include page="../include/footer.jsp" flush="true"/>
	</td>
</tr>
<!----- Footer 영역 ----->
</table>
</body>

</html>
