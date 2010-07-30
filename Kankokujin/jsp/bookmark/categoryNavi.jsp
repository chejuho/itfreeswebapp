<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>CategoryTest</title>
<script src = "jsp/Scripts/prototype.js" type="text/javascript" ></script>
<script  src = "jsp/bookmark/tree.js" type="text/javascript"></script>
<script type="text/javascript">
//<![CDATA[
/* 카테고리updateBookmark */
function goCategoryManager() {
		$("mainForm").action="CategoryManager";
		$("mainForm").submit(); 
		return true;
}

//]]>
</script>
<link href="jsp/bookmark/tree.css" rel="stylesheet" type="text/css"> 
</head>
<body>

<form name="mainForm" method="post" style="margin:0" action="CategoryManagerAction">
	<table border="1">
		<tr>
			<td align="left" border="1">
				<iframe id ="Category" name="Category" scrolling="auto" src="jsp/bookmark/category.jsp" 
				 style="width:200px; height:550px; border: 10px" align="left">
				</iframe>
			</td>
			<td align="left" border="1">
				<table border="1" height="500" width="500" valign="top" >
					<tr>
						<td height="550" valign="top">
							<iframe id ="Page" name = "Page" src="http://www.kankokujin.com" style="width:1000px; height:550px; border: 0px"></iframe>
						</td>
					</tr>	
				</table>
			</td>
		</tr>
		<tr>
			<td>
				<a href="javascript:goCategoryManager();">관리메뉴로</a>
				<a href="Index">메인홈으로</a>
			</td>
		</tr>
	</table>
</form>
</body>
</html>