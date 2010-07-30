<SCRIPT LANGUAGE="Javascript">
<!--
	function loadPage(obj){
		location.href = obj.options[obj.selectedIndex].value;
	}
//-->
</SCRIPT>

<form name="categoryForm" action="" method="post" target="base">
	<table width="" height="" border="0" width="100%">
		<tr>
			<td colspan="20" height="3" bgcolor=#E0E0E0></td>
		</tr>

	<% 	
		String cate_code1 = "";
		String CategorySelect = (String) request.getAttribute("CategorySelect");
		cate_code1 = (String) request.getAttribute("cateCode");
	%>
	<%=CategorySelect %>
		<tr>
			<td colspan="20" height="3" bgcolor=#E0E0E0></td>
		</tr>
	</table>
</form>