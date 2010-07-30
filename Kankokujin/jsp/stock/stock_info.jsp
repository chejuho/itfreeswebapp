<%@ page contentType="text/html;charset=UTF-8"%>

<jsp:useBean id="main" scope="page" class="stock.AnalizeStock" />
<%@ page import="common.batch.InsertMainStockInfo" %>
<%@page import="bean.MainStockBean"%>
<html>
<head>
<title>STOCK INFO</title>
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
<% String analizedaycount = request.getParameter("analizedaycount");
String benefits = request.getParameter("benefits");
String userfulMoney = request.getParameter("userfulMoney");
String continueDays = request.getParameter("continueDays");
	if ("".equals(analizedaycount) || "null".equals(analizedaycount) || analizedaycount == null) {
		analizedaycount = "4";
	}

	if ("".equals(continueDays) || "null".equals(continueDays) || continueDays == null) {
		continueDays = "2";
	}

	if ("".equals(benefits) || "null".equals(benefits) || benefits == null) {
		benefits = "10000";
	}

	if ("".equals(userfulMoney) || "null".equals(userfulMoney) || userfulMoney == null) {
		userfulMoney = "500000";
	}

	System.out.println("analizedaycount=" + analizedaycount + "userfulMoney=" + userfulMoney);
 
	InsertMainStockInfo mainStockInfo = new InsertMainStockInfo();
	MainStockBean mainStockBean = mainStockInfo.getMainStockBean();

%>
<form method=post name=condition action="stock_info.jsp">

표시할 주식별 일자건수<select name="analizedaycount" onChange="document.condition.submit()">
	<%for (int i = 3; i < 10; i ++) {
		if (Integer.parseInt(analizedaycount) == i) {
			%><option selected><%=i%></option><%
		} else {
			%><option><%=i%></option><%
		} 
	  }
	%>
</select>
<%System.out.println("analizedaycount2=" + Integer.parseInt(analizedaycount));%>
연속되는 날 수
<select name="continueDays" onChange="document.condition.submit()">
	<%for (int j = 2; j < 10; j ++) {
		if (Integer.parseInt(continueDays) == j) {
			%><option selected><%=j%></option><%
		} else {
			%><option><%=j%></option><%
		} 
	  }
	%>
</select>
<%System.out.println("analizedaycount3=" + Integer.parseInt(analizedaycount));%>
이익율<input type=text size=7 name=benefits value=<%=benefits%>>	
투자금액<input type=text size=7 name=userfulMoney value=<%=userfulMoney%>>				
</form>
<table border='1' width='950'>
	<tr>
		<td>
			日経平均:<%= mainStockBean.getNikkei_aver()%>(<%= mainStockBean.getNikkei_plus()%> ) 
		</td>
		<td>
			JASDAQ:<%= mainStockBean.getJasdaq_aver()%>(<%= mainStockBean.getJasdaq_plus()%> ) 
		</td>	
		<td>
			NYダウ:<%= mainStockBean.getDau_aver()%>(<%= mainStockBean.getDau_plus()%> )
		</td>

		<td>
			韓国総合:<%= mainStockBean.getKosdaq_aver()%>(<%= mainStockBean.getKosdaq_plus()%> ) 
		</td>
	</tr>
	
</table>
<table border='1' width='950'>
		<tr>
			<td height=50 align=center colspan=8>
				<font face="Comic Sans MS" size=3 color=#004080><strong>계속 오르고 있는 주식들</strong></font>
			</td>
		</tr>
<tr><td>
<%System.out.println("continueDays4=" + continueDays);%>

<%=main.getUsefulStockMap(1, Integer.parseInt(continueDays), Integer.parseInt(analizedaycount), benefits, userfulMoney)%>
</td></tr>

		<tr>
			<td height=50 align=center colspan=8>
				<font face="Comic Sans MS" size=3 color=#004080><strong>계속 떨어지고 있는 주식들</strong></font>
			</td>
		</tr>
<tr><td>
<%System.out.println("analizedaycount5=" + Integer.parseInt(analizedaycount));%>
<%//=main.getUsefulStockMap(3, Integer.parseInt(continueDays), (Integer.parseInt(analizedaycount)), benefits, userfulMoney)%>
</td></tr>

		<tr>
			<td height=50  align=center colspan=8>
				<font face="Comic Sans MS" size=3 color=#004080><strong>STOCK INFO</strong></font>
			</td>
		</tr>
<tr><td>
<%System.out.println("analizedaycount6=" + Integer.parseInt(analizedaycount));%>
<%//=main.getUsefulStockMap(2, Integer.parseInt(continueDays), Integer.parseInt(analizedaycount), benefits, userfulMoney)%>
</td></tr>
</table>
</html>