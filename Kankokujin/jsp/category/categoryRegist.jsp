<%@ page contentType="text/html; charset=utf-8"%>
<%
request.setCharacterEncoding("utf-8");
%>
<%@ page session="true"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="css/ITFreesMallStyle.css" tyep="text/css"
	rel="stylesheet" />
<title>カテゴリ入力</title>
<%
	String fathercateCode = request.getParameter("cate_code");

	String CategorySelect = "";
	CategorySelect = (String) request.getAttribute("CategorySelect");
%>
<SCRIPT LANGUAGE="Javascript">
<!--
	function loadPage(obj){
		location.href = obj.options[obj.selectedIndex].value;
	}
	
	function submitForm(){
		  
			if(document.categoryForm.cateName.value == "") {
	   			alert("カテゴリ名を入力して下さい！");
	   			categoryForm.cateName.focus();
	   			return false;
	   		}
   		}
//
--></SCRIPT>
</head>
<body>
	<form name="categoryForm" action="CategoryRegist" method="post" onSubmit="return submitForm()">
			<table border="0">
				<tr>
					<td colspan="20" height="3" bgcolor=#E0E0E0></td>
				</tr>
			
				<tr>
					<td colspan=2>カテゴリ入力</td>
				</tr>
				<tr>
					<td colspan="20" height="3" bgcolor=#E0E0E0></td>
				</tr>
				<tr>
					<td colspan=2>
					<table>
						<%=CategorySelect%>
					</table>
					</td>
				</tr>
				<tr>
					<td colspan="20" height="3" bgcolor=#E0E0E0></td>
				</tr>
				<tr>
					<td>カテゴリ名 <input type="hidden" name=fatherCateCode
						value=<%=fathercateCode %>></td>
					<td><input type="text" name=cateName value="" maxlength="85"></td>
				</tr>
				<tr>
					<td colspan="20" height="3" bgcolor=#E0E0E0></td>
				</tr>
				<tr>
					<td colspan=2><input type="submit" value="カテゴリ入力"></td>
				</tr>
				<tr>
					<td colspan="20" height="3" bgcolor=#E0E0E0></td>
				</tr>
			</table>
	</form>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<jsp:include page="/jsp/base/itfreesmallMark.jsp" flush="true" />
</body>
</html>
