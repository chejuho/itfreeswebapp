<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ page import="item.bean.ItemBean, common.util.Util"%>
<%@ page session="true"%>
<%@ page import="java.util.*"%>
<%
request.setCharacterEncoding("utf-8");
%>
<html>
<SCRIPT LANGUAGE="Javascript">
<!--
	function loadPage(obj){
		location.href = obj.options[obj.selectedIndex].value;
	}
	function cateCode(){
		if(document.listForm.cate_code1.value == "") {
   			alert("カテゴリを選択してください。")
   			return (false);
   		}    		
	}
//-->
</SCRIPT>
<head>
<link href="jsp/include/css/kankokujin.css" rel="stylesheet" type="text/css">
<title>アイテム リスト</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
</head>
<%

	String categorySelect = (String) request.getAttribute("CategorySelect");
	String viewTag = (String) request.getAttribute("viewListTag");	
	String cateCode = (String) request.getAttribute("cate_code");	
	List viewList = (List) request.getAttribute("viewList");	
	String cate_code = (String) request.getAttribute("cate_code");
	int total = 0;
	if (viewList != null) {
		total = viewList.size();	
	}
	
%>
<body>
<form name="listForm" method="post">


	<input type=hidden name="cate_code" value="<%=cate_code%>">


<table border="1">
	<tr>
		<td>
			<jsp:include page="../include/cate_menu.jsp" flush="true"/>
		</td>
		<td>
			<table border="1">	
				<tr>		
				<%=categorySelect %>
				</tr>
			</table>		
		<%
			if (total == 0) {
		%> 登録されたアイテムがありません。<br>
		<a href="ItemRegistOpen?cate_code=<%=cate_code %>">新規追加</a>
		<%
		} else {
		%>
		
		<table border='1'>
	
			<tr align='center'>
				<td>col1</td>	
				<td>col2</td>	
				<td>col3</td>	
				<td>col4</td>	
				<td>col5</td>									
			</tr>
			<%
						Iterator it = viewList.iterator();
						while (it.hasNext()) {
							ItemBean itemForm = (ItemBean) it.next();
							String tmpCateCode = itemForm.getCate_code();				
							String itemCode = itemForm.getItem_code();

			%>
							<tr align="center">
								<td><%=itemCode%></td>
								<td><a href="DetailInfo.do?itemCode=<%=itemCode%>"><%=itemForm.getCol01()%></a></td>
								<td><%=itemForm.getCol02()%></td>
								<td><%=itemForm.getCol03()%></td>
								<td><%=itemForm.getCol04()%></td>
								<td><%=itemForm.getCol05()%></td>
		
							</tr>
			<%
			}
			
			%>
			<tr>
				<td colspan="7"><input type="submit" value="商品登録"></td>
			</tr></table>
				
			<%
			}
			%>
		</td>
	</tr>
	
</table>



</form>
</body>
</html>
