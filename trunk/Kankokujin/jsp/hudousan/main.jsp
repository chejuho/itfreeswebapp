<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="myTags" uri="pageHandle"%>

<fmt:setLocale value="KO"/>
<fmt:setBundle basename="hudousan" var="message"/>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title><fmt:message key="TITLE.main" bundle="${message}"/></title>
<link href="jsp/include/css/basic.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript">
/* 詳細画面をオープン */
function openDetailPage(id, leaseSign) {

		document.main.action="HudousanDetailAction?id=" + id + "&leaseSign=" + leaseSign;
		document.main.submit(); 
		return true;
	}
</script>
</head>
<body topmargin="0" leftmargin="0">
<form name="main" method="post" style="margin:0">
<table width="100%" border="0" cellpadding="0" cellspacing="0">
	<c:import url="top.jsp" />
	<tr>
		<td>
			<table width="950"  border="0" align="center" cellpadding="0" cellspacing="0" id="Table_01">
			<tr>
				<td><fmt:message key="main.label.newinfoLease" bundle="${message}"/></td>
			</tr>
			</table>
		</td>
	</tr>
	<tr>
		<td>&nbsp;</td>
	</tr>
	<tr>
		<td>
			<table width="950"  border="0" align="center" cellpadding="0" cellspacing="0" id="Table_01">
			<tr>
				<c:forEach var="LeaseBean" items="${leaseList}" varStatus="status">
					<td align="center"><a href="javascript:openDetailPage('${LeaseBean.id}','1');"><img src="${LeaseBean.photo_path1}" alt="" width="240" height="150" border="1" /></a></td>
				</c:forEach>
			</tr>
			<tr>
				<c:forEach var="LeaseBean" items="${leaseList}" varStatus="status">
	            	<td align="center">
	            		<strong>
	            			<c:out value="${LeaseBean.lineInfo}"/>
							<c:if test="${!empty LeaseBean.walk_time}">/도보<c:out value="${LeaseBean.walk_time}"/>분
							</c:if>&nbsp;<br />
						</strong>
					</td>
				</c:forEach>
          	</tr>
          	<tr>
          		<c:forEach var="LeaseBean" items="${leaseList}" varStatus="status">
	            	<td align="center">
	            		<span class="red-text-w"><strong>
	            		<c:if test="${LeaseBean.madori == '0'}">
							1R
						</c:if>
						<c:if test="${LeaseBean.madori == '1'}">
							1K
						</c:if>
						<c:if test="${LeaseBean.madori == '2'}">
							1DK
		            	</c:if>
						<c:if test="${LeaseBean.madori == '3'}">
							1LDK
						</c:if>
		            	<c:if test="${LeaseBean.madori == '4'}">
							2K
		            	</c:if>
		            	<c:if test="${LeaseBean.madori == '5'}">
							2DK
		            	</c:if>
		            	<c:if test="${LeaseBean.madori == '6'}">
							2LDK
		            	</c:if>
		            	<c:if test="${LeaseBean.madori == '7'}">
							3DK
		            	</c:if>
		            	<c:if test="${LeaseBean.madori == '8'}">
							3LDK
		            	</c:if>
		            	<c:if test="${LeaseBean.madori == '9'}">
							4DK
		            	</c:if>
		            	<c:if test="${LeaseBean.madori == '10'}">
							4LDK
		            	</c:if>
		            	<c:if test="${LeaseBean.madori == '11'}">
							기타<br><c:out value="${LeaseBean.madori_info}"/>&nbsp;
		            	</c:if>
	            		
	            		</strong></span><br />
	            	</td>
            	</c:forEach>
          	</tr>
          	<tr>
          		<c:forEach var="LeaseBean" items="${leaseList}" varStatus="status">
	            	<td align="center">
	            		<c:if test="${!empty LeaseBean.house_fee[0] and LeaseBean.house_fee[0] != '0'}">
							<c:out value="${LeaseBean.house_fee[0]}만엔"/><br>
						</c:if>
	            	</td>
            	</c:forEach>
          	</tr>
			</table>
		</td>
	</tr>
	<tr>
		<td>&nbsp;</td>
	</tr>
	<tr>
		<td>
			<table width="950"  border="0" align="center" cellpadding="0" cellspacing="0" id="Table_01">
			<tr>
				<td><fmt:message key="main.label.newinfoBuy" bundle="${message}"/></td>
			</tr>
			</table>
		</td>
	</tr>
	<tr>
		<td>&nbsp;</td>
	</tr>
	<tr>
		<td>
			<table width="950"  border="0" align="center" cellpadding="0" cellspacing="0" id="Table_01">
			<tr>
				<c:forEach var="BuyBean" items="${buyList}" varStatus="status">
					<td align="center"><a href="javascript:openDetailPage('${BuyBean.id}','0');"><img src="${BuyBean.photo_path1}" alt="" width="240" height="150" border="1" /></a></td>
				</c:forEach>
			</tr>
			<tr>
				<c:forEach var="BuyBean" items="${buyList}" varStatus="status">
	            	<td align="center">
	            		<strong>
	            			<c:out value="${BuyBean.lineInfo}"/>
							<c:if test="${!empty BuyBean.walk_time}">/도보<c:out value="${BuyBean.walk_time}"/>분
							</c:if>&nbsp;<br />
						</strong>
					</td>
				</c:forEach>
          	</tr>
          	<tr>
          		<c:forEach var="BuyBean" items="${buyList}" varStatus="status">
	            	<td align="center">
	            		<span class="red-text-w"><strong>
	            		<c:if test="${BuyBean.madori == '0'}">
							1R
						</c:if>
						<c:if test="${BuyBean.madori == '1'}">
							1K
						</c:if>
						<c:if test="${BuyBean.madori == '2'}">
							1DK
		            	</c:if>
						<c:if test="${BuyBean.madori == '3'}">
							1LDK
						</c:if>
		            	<c:if test="${BuyBean.madori == '4'}">
							2K
		            	</c:if>
		            	<c:if test="${BuyBean.madori == '5'}">
							2DK
		            	</c:if>
		            	<c:if test="${BuyBean.madori == '6'}">
							2LDK
		            	</c:if>
		            	<c:if test="${BuyBean.madori == '7'}">
							3DK
		            	</c:if>
		            	<c:if test="${BuyBean.madori == '8'}">
							3LDK
		            	</c:if>
		            	<c:if test="${BuyBean.madori == '9'}">
							4DK
		            	</c:if>
		            	<c:if test="${BuyBean.madori == '10'}">
							4LDK
		            	</c:if>
		            	<c:if test="${BuyBean.madori == '11'}">
							기타<br><c:out value="${BuyBean.madori_info}"/>&nbsp;
		            	</c:if>
	            		
	            		</strong></span><br />
	            	</td>
            	</c:forEach>
          	</tr>
          	<tr>
          		<c:forEach var="BuyBean" items="${buyList}" varStatus="status">
	            	<td align="center">
	            		<c:if test="${!empty BuyBean.house_fee[0] and BuyBean.house_fee[0] != '0'}">
							<c:out value="${BuyBean.house_fee[0]}만엔"/><br>
						</c:if>
	            	</td>
            	</c:forEach>
          	</tr>
			</table>
		</td>
	</tr>	
</table>
</form>
</body>
</html>
