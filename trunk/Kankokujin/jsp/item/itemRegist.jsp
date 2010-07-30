<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="common.util.EnDecoding"%>
<%@ page import="common.bean.MemberBean"%>
<%
request.setCharacterEncoding("utf-8");
%>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="css/ITFreesMallStyle.css" tyep="text/css" rel="stylesheet" />
<html>
<head><title>Product Input</title>
</head>
<script type="text/javascript" src="../FCKeditor/fckeditor.js"></script>
    <script type="text/javascript">
    window.onload = function() {
        var oFCKeditor = new FCKeditor( 'contents' ) ;
	    oFCKeditor.BasePath = "../FCKeditor/";
	    oFCKeditor.Width = 650;
	    oFCKeditor.Height = 500;
	    oFCKeditor.ToolbarSet = "Custom";
        oFCKeditor.ReplaceTextarea() ;        
    }
	   	 
	function submitForm(){	
		if(document.searchForm.product_name.value == "") {
   			alert("商品名を入力して下さい！");
   			return false;
   		}
	}
	
	function loadPage(obj){
		location.href = obj.options[obj.selectedIndex].value;
	}
//
--></SCRIPT>


<body>
<%
	MemberBean userInfo = (MemberBean) session.getAttribute("userInfo");
	String user_id = "";
	String pass = "";
	String user_level = "";
	
	if (userInfo != null) {
	user_id = userInfo.getUserid();

	pass = userInfo.getPassword();
	user_level = userInfo.getUser_level();
	}

	SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd_HHmmss");
	String date = formatter.format(new java.util.Date());

	String cate_code = request.getParameter("cate_code");
	
	if (cate_code == null || cate_code == "") {
		cate_code = "0000";
	}
	String categoryCode = (String) request.getAttribute("CategorySelect");

	if (request.getAttribute("ProductList") == null) {
%>

<form name="searchForm" onSubmit="return submitForm()" method="post"
	action="ItemInput.do?user_id=<%=user_id %>" target="base" enctype="multipart/form-data">
	<table>
		<tr>
			<td colspan="30" height="3" bgcolor=#E0E0E0></td>
		</tr>
		<tr>
			<%=categoryCode %>
		</tr>
		<tr>
			<td colspan="30" height="3" bgcolor=#E0E0E0></td>
		</tr>
	</table>
	
<table width="740" border="0" cellpadding="0" cellspacing="0">

	<input type=hidden name="user_id" value="<%=user_id %>">
	<input type=hidden name="file_name" value="<%=date %>">
	<input type=hidden name="cate_code" value="<%=cate_code %>">
	<tr>
		<td width=740 colspan=7 align=left>(<font color=red>*</font>)は必須入力項目です。</td>
	</tr>
	<tr>
		<td colspan=7 height=2 width=610 bgcolor=#E0E0E0></td>
	</tr>
	<tr>
		<td width=2 bgcolor=#E0E0E0></td>
		<td colspan=5 height=2 width=606></td>
		<td width=2 bgcolor=#E0E0E0></td>
	</tr>
	<tr>
		<td width=2 bgcolor=#E0E0E0></td>
		<td width=2></td>
		<td width=130 bgcolor=#E0E0E0>商品名<font color=red>*</font></td>
		<td width=2></td>
		<td width=470 bgcolor=#E0E0E0>&nbsp;&nbsp;&nbsp;<input type=text name="product_name" value="" size="80" maxlength="85">
		<br>&nbsp;&nbsp;&nbsp;<font color=red>*</font>商品名には85文字まで書くことができます。
		</td>
		<td width=2></td>
		<td width=2 bgcolor=#E0E0E0></td>
	</tr>
	<tr>
		<td width=2 bgcolor=#E0E0E0></td>
		<td colspan=5 height=2 width=606></td>
		<td width=2 bgcolor=#E0E0E0></td>
	</tr>
	<tr>
		<td width=2 bgcolor=#E0E0E0></td>
		<td width=2></td>
		<td width=130 bgcolor=#E0E0E0>価格</td>
		<td width=2></td>
		<td width=470 bgcolor=#E0E0E0>&nbsp;&nbsp;&nbsp;<input type=text name="price" value=""></td>
		<td width=2></td>
		<td width=2 bgcolor=#E0E0E0></td>
	</tr>
	<tr>
		<td width=2 bgcolor=#E0E0E0></td>
		<td colspan=5 height=2 width=606></td>
		<td width=2 bgcolor=#E0E0E0></td>
	</tr>
	<tr>
		<td width=2 bgcolor=#E0E0E0></td>
		<td width=2></td>
		<td width=130 bgcolor=#E0E0E0>内容<font color=red>*</font></td>
		<td width=2></td>
		<td width=470 bgcolor=#E0E0E0><textarea name="contents"></textarea></td>
		<td width=2></td>
		<td width=2 bgcolor=#E0E0E0></td>
	</tr>
	<tr>
		<td width=2 bgcolor=#E0E0E0></td>
		<td colspan=5 height=2 width=606></td>
		<td width=2 bgcolor=#E0E0E0></td>
	</tr>
	<tr>
		<td width=2 bgcolor=#E0E0E0></td>
		<td width=2></td>
		<td width=130 bgcolor=#E0E0E0>製造社</td>
		<td width=2></td>
		<td width=470 bgcolor=#E0E0E0>&nbsp;&nbsp;&nbsp;<input type=text
			name="company" value=""></td>
		<td width=2></td>
		<td width=2 bgcolor=#E0E0E0></td>
	</tr>
	<tr>
		<td width=2 bgcolor=#E0E0E0></td>
		<td colspan=5 height=2 width=606></td>
		<td width=2 bgcolor=#E0E0E0></td>
	</tr>
	<tr>
		<td width=2 bgcolor=#E0E0E0></td>
		<td width=2></td>
		<td width=130 bgcolor=#E0E0E0>原産地</td>
		<td width=2></td>
		<td width=470 bgcolor=#E0E0E0>&nbsp;&nbsp;&nbsp;<input type=text
			name="nation" value=""></td>
		<td width=2></td>
		<td width=2 bgcolor=#E0E0E0></td>
	</tr>
	<tr>
		<td width=2 bgcolor=#E0E0E0></td>
		<td colspan=5 height=2 width=606></td>
		<td width=2 bgcolor=#E0E0E0></td>
	</tr>
	<tr>
		<td width=2 bgcolor=#E0E0E0></td>
		<td width=2></td>
		<td width=130 bgcolor=#E0E0E0>イメージ</td>
		<td width=2></td>
		<td bgcolor=#E0E0E0>&nbsp;&nbsp;&nbsp;<input type="file" name="file1"></td>
		<td width=2 bgcolor=#E0E0E0></td>
		<input type="hidden" name="permission" value="0">
	</tr>

	<tr>
		<td width=2 bgcolor=#E0E0E0></td>
		<td colspan=5 height=2 width=606></td>
		<td width=2 bgcolor=#E0E0E0></td>
	</tr>
	<tr>
		<td colspan=7 height=2 width=610 bgcolor=#E0E0E0></td>
	</tr>
	<tr>
		<td width=2></td>
		<td width=2></td>
		<td width=130></td>
		<td width=2></td>
		<td width=470 align="right"></td>
		<td width=2></td>
		<td width=2></td>
	</tr>
	<tr>
		<td align="center" colspan="7">
			<input name="submit" type="submit" value="登&nbsp;&nbsp;&nbsp;&nbsp;録"
				onClick="submitForm">
		</td>
	</tr>

</table>
</form>
<table width="740" border="0" cellpadding="0" cellspacing="0">
	<tr>
		<td align="right" colspan="7">
				| <a href="ProductList.do">最新リストへ</a>
		</td>
	</tr>
</table>
<jsp:include page="jsp/base/itfreesmallMark.jsp" flush="true"/>
</body>
</html>

<%
} else {
%>

<body>
<form name="input" onSubmit="return submitForm()" method="post"
	action="ProductInput.do" target="_base" enctype="multipart/form-data">
<table width="610" border="0" cellpadding="0" cellspacing="0">
	<input type=hidden name="file_name" value="<%=date %>">
	<input type=hidden name="cate_code" value="<%=cate_code %>">
	<tr>
		<td colspan=7 height=2 width=610 bgcolor=#E0E0E0></td>
	</tr>
	<tr>
		<td width=2 bgcolor=#E0E0E0></td>
		<td colspan=5 height=2 width=606></td>
		<td width=2 bgcolor=#E0E0E0></td>
	</tr>
	<tr>
		<td width=2 bgcolor=#E0E0E0></td>
		<td width=2></td>
		<td width=130 bgcolor=#E0E0E0>商品名</td>
		<td width=2></td>
		<td width=470 bgcolor=#E0E0E0>&nbsp;&nbsp;&nbsp;<input type=text name="product_name" value=""></td>
		<td width=2></td>
		<td width=2 bgcolor=#E0E0E0></td>
	</tr>
	<tr>
		<td width=2 bgcolor=#E0E0E0></td>
		<td colspan=5 height=2 width=606></td>
		<td width=2 bgcolor=#E0E0E0></td>
	</tr>
	<tr>
		<td width=2 bgcolor=#E0E0E0></td>
		<td width=2></td>
		<td width=130 bgcolor=#E0E0E0>価格</td>
		<td width=2></td>
		<td width=470 bgcolor=#E0E0E0>&nbsp;&nbsp;&nbsp;<input type=text
			name="price" value=""></td>
		<td width=2></td>
		<td width=2 bgcolor=#E0E0E0></td>
	</tr>
	<tr>
		<td width=2 bgcolor=#E0E0E0></td>
		<td colspan=5 height=2 width=606></td>
		<td width=2 bgcolor=#E0E0E0></td>
	</tr>
	<tr>
		<td width=2 bgcolor=#E0E0E0></td>
		<td width=2></td>
		<td width=130 bgcolor=#E0E0E0>内容</td>
		<td width=2></td>
		<td width=470 bgcolor=#E0E0E0><textarea name="contents"></textarea></td>
		<td width=2></td>
		<td width=2 bgcolor=#E0E0E0></td>
	</tr>
	<tr>
		<td width=2 bgcolor=#E0E0E0></td>
		<td colspan=5 height=2 width=606></td>
		<td width=2 bgcolor=#E0E0E0></td>
	</tr>
	<tr>
		<td width=2 bgcolor=#E0E0E0></td>
		<td width=2></td>
		<td width=130 bgcolor=#E0E0E0>製造社</td>
		<td width=2></td>
		<td width=470 bgcolor=#E0E0E0>&nbsp;&nbsp;&nbsp;<input type=text
			name="company" value=""></td>
		<td width=2></td>
		<td width=2 bgcolor=#E0E0E0></td>
	</tr>
	<tr>
		<td width=2 bgcolor=#E0E0E0></td>
		<td colspan=5 height=2 width=606></td>
		<td width=2 bgcolor=#E0E0E0></td>
	</tr>
	<tr>
		<td width=2 bgcolor=#E0E0E0></td>
		<td width=2></td>
		<td width=130 bgcolor=#E0E0E0>原産地</td>
		<td width=2></td>
		<td width=470 bgcolor=#E0E0E0>&nbsp;&nbsp;&nbsp;<input type=text
			name="nation" value=""></td>
		<td width=2></td>
		<td width=2 bgcolor=#E0E0E0></td>
	</tr>
	<tr>
		<td width=2 bgcolor=#E0E0E0></td>
		<td colspan=5 height=2 width=606></td>
		<td width=2 bgcolor=#E0E0E0></td>
	</tr>
	<tr>
		<td width=2 bgcolor=#E0E0E0></td>
		<td width=2></td>
		<td width=130 bgcolor=#E0E0E0>&nbsp;</td>
		<td width=2></td>
		<td bgcolor=#E0E0E0><input type="file" name="file1"></td>
		<td width=2 bgcolor=#E0E0E0></td>
		<input type="hidden" name="permission" value="0">
	</tr>

	<tr>
		<td width=2 bgcolor=#E0E0E0></td>
		<td colspan=5 height=2 width=606></td>
		<td width=2 bgcolor=#E0E0E0></td>
	</tr>
	<tr>
		<td colspan=7 height=2 width=610 bgcolor=#E0E0E0></td>
	</tr>
	<tr>
		<td width=2></td>
		<td width=2></td>
		<td width=130></td>
		<td width=2></td>
		<td width=470 align="right"></td>
		<td width=2></td>
		<td width=2></td>
	</tr>
	<tr>
		<td align="center" colspan="7">
			<input name="submit" type="submit" value="登&nbsp;&nbsp;&nbsp;&nbsp;録"
				onClick="submitForm">
		</td>
	</tr>
</table>
</form>
<table width="740" border="0" cellpadding="0" cellspacing="0">
	<tr>
		<td align="right" colspan="7">
				| <a href="ProductList.do">最新リストへ</a>
		</td>
	</tr>
</table>
<jsp:include page="/jsp/base/itfreesmallMark.jsp" flush="true"/>
</body>
</html>
<%
}
%>