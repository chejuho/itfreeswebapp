<%@ page contentType="text/html; charset=utf-8"%>
<%
request.setCharacterEncoding("utf-8");
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="../css/ITFreesMallStyle.css" tyep="text/css"
	rel="stylesheet" />
<title>カテゴリ修正,削除</title>
<%
	String cateCode = request.getParameter("cate_code");

	String cate_name = (String)request.getAttribute("cate_name");

	String categorySelect = (String) request.getAttribute("CategorySelect");


%>
<script language=javascript>
<!--
    function btn_click(str){ 
    	if(document.categoryForm.cate_name1.value == "") {
			alert("カテゴリ名を入力して下さい！");
			categoryForm.cate_name1.focus();
	   		return false;
		}
           
        if(str=="modify"){        
            categoryForm.action="CategoryUpdate"; 
            categoryForm.submit(); 
        } else if(str=="delete"){     
            categoryForm.action="CategoryDelete";   
            categoryForm.submit();  
        } else {
        
        }
    }
    
    function loadPage(obj){
		location.href = obj.options[obj.selectedIndex].value;
	}	
	
//-->
</script>




</head>
<body>
<form name="categoryForm" method="post" onSubmit="return submitForm()">

<table border="0">
	
	<tr>
		<td colspan="20" height="3" bgcolor=#E0E0E0></td>
	</tr>
	<tr>
		<td colspan=3>カテゴリ修正,削除</td>
		<input type="hidden" name=cate_code value="<%=cateCode %>">
		<input type="hidden" name=cate_code1 value="<%=cateCode %>">
	</tr>
	<tr>
		<td colspan="20" height="3" bgcolor=#E0E0E0></td>
	</tr>
	<tr>
		<td colspan=3>
		<table>
			<%=categorySelect%>
		</table>
		</td>
	</tr>
	<tr>
		<td colspan="20" height="3" bgcolor=#E0E0E0></td>
	</tr>
	<tr>
		<td>カテゴリ名</td>
		<td colspan=2><input type="hidden" name=cate_name value="<%=cate_name%>" maxlength="85">
		<input type="text" name=cate_name1 value="<%=cate_name %>" maxlength="85"></td>
	</tr>
	<tr>
		<td colspan="20" height="3" bgcolor=#E0E0E0></td>
	</tr>
	<tr>
		<td>&nbsp;</td>
		<td><input type="button" value="カテゴリ修正"
			onclick='btn_click("modify");'></td>
		<td><input type="button" value="カテゴリ削除"
			onclick='btn_click("delete");'></td>
	</tr>
	<tr>
		<td colspan="20" height="3" bgcolor=#E0E0E0></td>
	</tr>
	
</table>

<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
	<jsp:include page="/jsp/base/itfreesmallMark.jsp" flush="true"/>
</form>
</body>
</html>
