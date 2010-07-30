<%@ page contentType="text/html;charset=UTF-8"%>
<jsp:useBean id="main" scope="page" class="stock.Kawase" />
<%@page import="bean.KawaseBean, java.util.List, java.util.Iterator"%>
<html>
<head>
<title>KAWASE INFO</title>
<style type='text/css'>
  A:link    { color:#183CA5; text-decoration:none;     }
  A:visited { color:#183CA5; text-decoration:none;     }
  A:active  { text-decoration:none;     }
  A:hover    { color:#387FE7; text-decoration:none;}
  .editbox  { border:1 solid black; background-color:white; }
  .input    { height:19px; border:1 solid; border-color:gray; background-color:white; }
  .button   { height:19px; border:1 solid; border-color:gray; background-color:#B5CEFF; border-width:1; color:#183CA5; }
  p,br,table,body,td,select,input,form,textarea,option {font-size:10pt; }
</style>

</head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<body>
<table><tr><td>
<table border=1 align=center>
<tr><td width=100 align=center>buy</td><td width=100 align=center>sell</td><td width=100 align=center>date</td></tr>

<%
List kawaselist = main.getKawaseInfoList();

Iterator kawaselistIt = kawaselist.iterator();
while (kawaselistIt.hasNext()) {
	KawaseBean bean = (KawaseBean)kawaselistIt.next();
	%><tr><td align=center><%=bean.getBuy_price()%></td><td align=center><%=bean.getSell_price()%></td><td align=center><%=bean.getDate()%></td></tr><%
}

%>
</table></td>
<td>

<table border=1 align=center>
<tr><td width=100 align=center>stock_price</td><td width=100 align=center>date</td></tr>

<%
List list = main.getUsaStockInfoList();

Iterator it = list.iterator();
while (it.hasNext()) {
	KawaseBean bean = (KawaseBean)it.next();
	%><tr><td align=center><%=bean.getSell_price()%></td><td align=center><%=bean.getDate()%></td></tr><%
}

%>
</table>
</td>
</body>
</html>