<%@ page language="java" contentType="text/html; charset=euc-kr"
    pageEncoding="euc-kr" %>
<%
request.setCharacterEncoding("euc-kr");

%>

<%
//boolean  ttt = false;
    User user = (User)session.getAttribute("user");	  
	String wordtable = request.getParameter("wordtable");
	
%>