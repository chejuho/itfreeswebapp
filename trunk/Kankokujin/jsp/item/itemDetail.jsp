<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ page import="com.itfreesmall.dbhandler.EnDecoding"%>
<%@ page import="com.itfreesmall.dbhandler.ItemHandler"%>
<%@ page import="com.itfreesmall.actionform.ItemForm"%>
<%
request.setCharacterEncoding("utf-8");
%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="css/ITFreesMallStyle.css" tyep="text/css"
	rel="stylesheet" />
<title>アイテム 情 報</title>
</head>
<body>
<font size=2 color=blue> <%
 	String itemCode = request.getParameter("itemCode");
 	String nowPage = request.getParameter("nowPage");

 	ItemHandler viewHandler = new ItemHandler();

 	ItemForm ItemForm = viewHandler
  	.getItemInfo(itemCode);
  	String product_name = EnDecoding.decoding(ItemForm.getCol01());
  	String company = EnDecoding.decoding(ItemForm.getCol02());
  	String nation = EnDecoding.decoding(ItemForm.getCol03());
  	String price = EnDecoding.decoding(ItemForm.getCol04());
  	String file = EnDecoding.decoding(ItemForm.getCol05());
  	String contents = EnDecoding.decoding(ItemForm.getContents());
 %> <img src=/image/icon_book01.gif>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <b><font size=5>
アイテム 情 報 </font></b>

<form name="productForm" onSubmit="" action="" target="base"
	method="post">

<table width="610" border="0" cellpadding="0" cellspacing="0">
	<tr>
		<td width=2></td>
		<td width=2></td>
		<td width=130></td>
		<td width=2></td>
		<td width=470 align="right"><a
			href="ItemOpenUpdate.do?nowPage=<%=nowPage%>&itemCode=<%=itemCode%>" target="base">｜
		商品修正 </a> <a href="ItemDelete.do?nowPage=<%=nowPage%>&itemCode=<%=itemCode%>"
			target="base">｜ 商品削除 ｜</a></td>
		<td width=2></td>
		<td width=2></td>
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
		<td width=130 bgcolor=#E0E0E0>商品名</td>
		<td width=2></td>
		<td width=470 bgcolor=#E0E0E0>&nbsp;&nbsp;&nbsp;<%=product_name%></td>
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
		<td width=470 bgcolor=#E0E0E0>&nbsp;&nbsp;&nbsp;<%=price%></td>
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
		<td width=470 bgcolor=#E0E0E0><textarea name="contents" readonly><%=contents%></textarea></td>
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
		<td width=470 bgcolor=#E0E0E0>&nbsp;&nbsp;&nbsp;<%=company%></td>
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
		<td width=470 bgcolor=#E0E0E0>&nbsp;&nbsp;&nbsp;<%=nation%></td>
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
		<td width=470 bgcolor=#E0E0E0>&nbsp;&nbsp;&nbsp;<%=file%></td>
		<td width=2></td>
		<td width=2 bgcolor=#E0E0E0></td>
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
		<td align="right" colspan="7">| <a href="ProductList.do">最新リストへ</a>
		|</td>
	</tr>
</table>
</form>
<jsp:include page="/jsp/base/itfreesmallMark.jsp" flush="true"/>	
</font>
</body>
</html>
