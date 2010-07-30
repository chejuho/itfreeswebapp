<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ page import="com.itfreesmall.dbhandler.EnDecoding"%>
<%@ page import="com.itfreesmall.actionform.ItemForm"%>
<%@ page import="com.itfreesmall.actionform.Member"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%
request.setCharacterEncoding("utf-8");
%>
<html>
<head>
<link href="css/ITFreesMallStyle.css" tyep="text/css"
	rel="stylesheet" />
<title>update product</title>
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
    function loadPage(obj){
		location.href = obj.options[obj.selectedIndex].value;
	}
	</script>
<body>

<%
	Member userInfo = (Member) session.getAttribute("userInfo");
	String userId = "";
	String user_level = "";
	if (userInfo != null) {
			userId = userInfo.getUser_id();
			user_level = userInfo.getUser_level();
	}
	
	String nowPage1 ="";
	nowPage1 = request.getParameter("nowPage");
	if (request.getParameter("nowPage") == null ) {
		nowPage1 =(String)request.getAttribute("nowPage");
	}
	int nowPage = Integer.parseInt(nowPage1);
	System.out.println("nowPage:" + nowPage);

	String cate_code1 = "";
	String categorySelect = (String) request.getAttribute("CategorySelect");
	cate_code1 = (String) request.getAttribute("cate_code");

	ItemForm ItemForm = (ItemForm) request
			.getAttribute("itemInfo");

	String cate_code = ItemForm.getCate_code();
	System.out.println("cate_code..check check" + cate_code);
	String item_code = ItemForm.getItem_code();
	String product_name = EnDecoding.decoding(ItemForm.getCol01());
	String company = EnDecoding.decoding(ItemForm.getCol01());
	String nation = EnDecoding.decoding(ItemForm.getCol01());
	String contents = EnDecoding.decoding(ItemForm.getContents());
	String price = EnDecoding.decoding(ItemForm.getCol01());
	//String file = EnDecoding.decoding(ItemForm.getCol01());
	String file = "test.jpg";
	String date = ItemForm.getInsert_date();
	String permission = "9"; //ItemForm.getPermission();
	
	System.out.println("date:"+date);
	int fileCut = file.indexOf(".jpg");
	String fileName = file.substring(0,fileCut);
	
	SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd_HHmmss");
	String date1 = formatter.format(new java.util.Date());

%>

<%if (user_level.equals("9")) { %>
    <script type="text/javascript">

		function submitForm(){	
			
			if(document.itemUpdateForm.product_name.value == "") {
	   			alert("商品名を入力して下さい！");
	   			return false;
	   		}
		}

//--></SCRIPT>
<form name="itemUpdateForm" onSubmit="return submitForm()" action="ItemChange.do" method="post"
	target="base" enctype="multipart/form-data">

	<%} else if (user_level.equals("1") || user_level.equals("2")) { %>
    <script type="text/javascript">

		function submitForm(){	
			
			if(document.myProduct.product_name.value == "") {
	   			alert("商品名を入力して下さい！")
	   			return false;
	   		}
	
		}

//--></SCRIPT>
<form name="myProduct" action="MyProductChange.do" onSubmit="return submitForm()" method="post"
	target="base" enctype="multipart/form-data">


	<%} %>
<table>
	<tr>
		<td colspan="30" height="3" bgcolor=#E0E0E0></td>
	</tr>
	<tr>
		<%=categorySelect%>
	</tr>
	<tr>
		<td colspan="30" height="3" bgcolor=#E0E0E0></td>
	</tr>
</table>

<table width="740" border="0" cellpadding="0" cellspacing="0">
	<tr>
		<td width=740 colspan=7 align=left>(<font color=red>*</font>)は必須入力項目です。</td>
	</tr>
	<tr>
		<td width=2></td>
		<td width=2></td>
		<td width=130></td>
		<td width=2></td>
		<td width=2></td>
		<td width=2></td>
		<td width=2></td>
	</tr>
	<input type=hidden name="cate_code" value="<%=cate_code %>">
	<input type=hidden name="item_code" value="<%=item_code %>">
	<input type=hidden name="user_id" value="<%=userId %>">
	<input type=hidden name="nowPage" value="<%=nowPage %>">
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
		<td width=470 bgcolor=#E0E0E0 >&nbsp;&nbsp;&nbsp;<input type=text name="product_name" value="<%=product_name %>" size="80" maxlength="85">
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
		<td width=470 bgcolor=#E0E0E0>&nbsp;&nbsp;&nbsp;<input type=text
			name="price" value="<%=price %>"></td>
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
		<td width=470 height="300" bgcolor=#E0E0E0><textarea name="contents" cols="60" rows="10"><%=contents%></textarea></td>
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
			name="company" value="<%=company %>"></td>
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
			name="nation" value="<%=nation %>"></td>
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
		<td width=470 bgcolor=#E0E0E0>		
		<% if (!(file.equals("0.jpg"))) {  %>
			<img src="C:\\eclipse\\image\\<%=file%>" border="0">
			<input type="hidden" name="file_name" value="<%=file%>">
		<% } else {%>
			<center>イメージがありません。</center>
			<input type="hidden" name="file_name" value="<%=file%>">
		<% } %>
		</td>
		<td width=2><br></td>
	</tr>
	<tr>
		<td width=2 bgcolor=#E0E0E0></td>
		<td width=2></td>
		<td width=130 bgcolor=#E0E0E0>&nbsp;</td>
		<td width=2></td>
		<td bgcolor=#E0E0E0><input type="file" name="file1"></td>
		<input type="hidden" name="fileName" value="<%=date1%>">
		<td width=2 bgcolor=#E0E0E0></td>
		<input type="hidden" name="permission" value="<%=permission %>">
	</tr>
	<tr>
		<td align="right" colspan="7">
				| <a href="MyProductList.do?user_id=<%=userId %>">最新リストへ</a> 
				| <a href="MyProductList.do?nowPage=<%=nowPage%>&cate_code=<%=cate_code1%>&user_id=<%=userId %>">戻る</a>
				|
		</td>
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
	<td colspan=7 align=center>
		<input type="submit" value=" 商品情報修正 " onClick="submitForm"> 	
	</td>
		
	</tr>
</table>
</form>

<jsp:include page="/jsp/base/itfreesmallMark.jsp" flush="true"/>	
</body>
</html>