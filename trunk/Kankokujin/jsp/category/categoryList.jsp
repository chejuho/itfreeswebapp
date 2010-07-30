<%@ page contentType="text/html; charset=utf-8" %>
<% request.setCharacterEncoding("utf-8"); %>
<%@ page session="true"%>
<%@ page contentType="text/html; charset=utf-8" %>

<html>
<head><title>カテゴリ管理</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<SCRIPT LANGUAGE="Javascript">
<!--
	function loadPage(obj){
		location.href = obj.options[obj.selectedIndex].value;
	}
//-->
</SCRIPT>
</head>
<body>

<font style="font-size=30;">---------- カテゴリ管理 ----------</font>
<form name="categoryForm" action="" method="post">
	<table width="" height="" border="0" width="100%">
		<tr>
			<td colspan="20" height="3" bgcolor=#E0E0E0></td>
		</tr>
			<%=request.getAttribute("CategorySelect") %>
		<tr>
			<td colspan="20" height="3" bgcolor=#E0E0E0></td>
		</tr>
	</table>
</form>
</body>
</html>