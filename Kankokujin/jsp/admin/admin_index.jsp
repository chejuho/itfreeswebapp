<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%request.setCharacterEncoding("UTF-8");%>
<html>
<head>
<title>캉코쿠진닷컴</title>
<meta http-equiv="Content-type" content="text/html; charset=UTF-8">
<script language="javascript" src="jsp/Scripts/top.js"></script>


<script src="jsp/Scripts/AC_RunActiveContent.js" type="text/javascript"></script>
<link href="jsp/include/css/kankokujin.css" rel="stylesheet" type="text/css">
</head>

<body style="margin:0 0 0 0">
<table border="0" cellpadding="0" cellspacing="0" width="950" align="center">

<!----- top메뉴 ------>
<tr valign="top">
	<td colspan="3">
		<jsp:include page="../include/top.jsp" flush="true"/>
	</td>
</tr>
<tr><td align="center"><img src="jsp/images/common/title_admin_main.gif"></td>
</tr>
<!----- top메뉴 ------>


<!----- 콘텐츠 영역 ----->
<tr>
	
	<!-- 메인 콘텐츠 -->
	<td  align="center" valign="top">
		<table>

			<tr><td>
				1. <a href="EigyouMailList">一括営業メール発送</a>
			</td></tr>			
			<tr><td>		
				2. <a href="EngMailList" >技術者メール発送</a>
			</td></tr>			
			<tr><td>				
				3．<a href="" >会員管理</a>	
			</td></tr>	
			<tr><td>				
				4．<a href="ContactusList" >問い合わせ一覧</a>	
			</td></tr>						
		</table>		

	</td>
    </tr>
    <tr>
    	<td>
			<!----- Footer 영역 ----->
			
			<jsp:include page="../include/footer.jsp" flush="true"/>
			
			<!----- Footer 영역 ----->    	
    	</td>
    </tr>
</table>
	<!-- 메인 콘텐츠 -->



</body>

</html>