
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>CategoryTest</title>
<script src = "../Scripts/prototype.js" type="text/javascript" ></script>
<script  src = "category.js" type="text/javascript"></script>
<script type="text/javascript">
//<![CDATA[
	Event.observe(window, 'load', init);
	/* 카테고리bookmark  */
	function bookmark(url) {
		//alert(url);
		var frame = window.parent.$('Page');
		frame.src = url;
	}   
	
//]]>
</script>
<link href="tree.css" rel="stylesheet" type="text/css"> 
</head>
<body>

<form name="mainForm" method="post" style="margin:0" action="CategoryManagerAction">
	<table border="0" width="200%">
		<tr>
			<td>
				<div class="elem" id = "tree">
				</div>
			</td>
		</tr>
	</table>
</form>
</body>
</html>