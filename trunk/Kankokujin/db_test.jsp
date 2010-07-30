<%@ page language="java" import="java.sql.*"%>
<html>
<head><title>DB TEST</title>
</head>
<body>

<p align="center"><b>Following records are selected from DB</b><br>&nbsp;</p>

<div align="center" width="85%">
<center>
<table border="1" borderColor="#ffe9bf" cellPadding="0" cellSpacing="0" width="658" height="63">
<tbody>
<td bgColor="#008080" width="47" align="center" height="19"><font color="#ffffff"><b>COLUMN1</b></font></td>
<td bgColor="#008080" width="107" height="19"><font color="#ffffff"><b>COLUMN2</b></font></td>
<td bgColor="#008080" width="224" height="19"><font color="#ffffff"><b>COLUMN3</b></font></td>
<td bgColor="#008080" width="270" height="19"><font color="#ffffff"><b>COLUMN4</b></font></td>

<%
try{
String DRIVER = "org.gjt.mm.mysql.Driver";
Class.forName(DRIVER).newInstance();


Connection con=null;
ResultSet rst=null;
Statement stmt=null;


String url="jdbc:mysql://localhost:3306/kankokujincom?user=root&password=itfrees747";

int i=1;
con=DriverManager.getConnection(url);
stmt=con.createStatement();
rst=stmt.executeQuery("select * from member ");
while(rst.next()){

if (i==(i/2)*2){
%>
<tr>
<td bgColor="#ffff98" vAlign="top" width="47" align="center" height="19"><%=i%>.</td>
<td bgColor="#ffff98" vAlign="top" width="107" height="19"><%=rst.getString(2)%></td>
<td bgColor="#ffff98" vAlign="top" width="224" height="19"><a href="<%=rst.getString(3)%>"><%=rst.getString(3)%></a>&nbsp;</td>
<td bgColor="#ffff98" vAlign="top" width="270" height="19"><%=rst.getString(4)%></td>
</tr>
<%
}else{
%>
<tr>
<td bgColor="#ffcc68" vAlign="top" width="47" align="center" height="19"><%=i%>.</td>
<td bgColor="#ffcc68" vAlign="top" width="107" height="19"><%=rst.getString(2)%></td>
<td bgColor="#ffcc68" vAlign="top" width="224" height="19"><a href="<%=rst.getString(3)%>"><%=rst.getString(3)%></a>&nbsp;</td>
<td bgColor="#ffcc68" vAlign="top" width="270" height="19"><%=rst.getString(4)%></td>
</tr>
<% }

i++;
}
rst.close();
stmt.close();
con.close();
}catch(Exception e){
%><%=e.getMessage()%><%
}
%>

</tbody>
</table>
</center>
</div>


</body>
</html>