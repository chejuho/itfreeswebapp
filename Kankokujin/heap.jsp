<meta http-equiv="Refresh" content="10;url=heap.jsp">
<%
Runtime rt = Runtime.getRuntime();
%>
Total size: <%=rt.totalMemory()%>
<br>free size: <%=rt.freeMemory()%>
<br>Heap size: <%=rt.totalMemory()-rt.freeMemory()%>

