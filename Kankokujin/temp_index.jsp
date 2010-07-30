<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@page import="common.util.Util"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<fmt:setLocale value="KO"/>
<fmt:setBundle basename="msg" var="message"/>
<%
request.setCharacterEncoding("UTF-8");
String message = (String)Util.changeNullStr(request.getAttribute("Message"));
	
	if ("MSG0014".equals(message)) {%>
	<script language="javascript">
		alert("<fmt:message key="MSG0014" bundle="${message}"/>");
	</script>
<%	}else if ("MSG0009".equals(message)) {%>
	<script language="javascript">
		alert("<fmt:message key="MSG0009" bundle="${message}"/>");
	</script>
<%	}else if ("MSG0019".equals(message)) {%>
	<script language="javascript">
		alert("<fmt:message key="MSG0019" bundle="${message}"/>");
	</script>	
<%	}else if ("MSG0020".equals(message)) {%>
	<script language="javascript">
		alert("<fmt:message key="MSG0020" bundle="${message}"/>");
	</script>		
<%	}else if ("WAR0006".equals(message)) {%>
	<script language="javascript">
		alert("<fmt:message key="WAR0006" bundle="${message}"/>");
	</script>		
	
<%	}%>
<html>
<script language="javascript">
	function start_index() {
		window.location.href="NewWrite";
	}
</script>
<body  onload="start_index()">
</body>
</html>
