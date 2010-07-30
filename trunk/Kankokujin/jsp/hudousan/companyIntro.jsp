<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<fmt:setLocale value="KO"/>
<fmt:setBundle basename="hudousan" var="message"/>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title><fmt:message key="TITLE.main" bundle="${message}"/></title>
<link href="jsp/include/css/basic.css" rel="stylesheet" type="text/css"/>
</head>

<body topmargin="0" leftmargin="0">
<table width="100%" border="0" cellpadding="0" cellspacing="0">
	<c:import url="top.jsp" />
	<tr>
		<td>&nbsp;</td>
	</tr>
	<tr>
    	<td>
			<table width="650"  border="1" align="center" cellpadding="0" cellspacing="0">
      		    <tr>
			        <td valign="top">
				        <table width="100%" border="1" cellspacing="0" cellpadding="0">
						<tr>
							<td bgcolor="#ebebeb" style="padding:11px 11px 11px 11px;">
								<table width="100%" border="1" cellpadding="0" cellspacing="1" bgcolor="#d6d5d5">
								<tr>
									<td width="34%" bgcolor="#f7f7f7" class="table-title-text"><fmt:message key="companyIntro.label.item1" bundle="${message}"/></td>
									<td width="66%" bgcolor="#FFFFFF" class="table-cont-text"><fmt:message key="companyIntro.label.value1" bundle="${message}"/></td>
				                </tr>
				                <tr>
				                  <td bgcolor="#f7f7f7" class="table-title-text">
				                  	<fmt:message key="companyIntro.label.item2" bundle="${message}"/>
				                  </td>
				                  <td width="66%" bgcolor="#FFFFFF" class="table-cont-text">
				                  	<fmt:message key="companyIntro.label.value2" bundle="${message}"/>
				                  </td>
				                </tr>
				                <tr>
				                  <td bgcolor="#f7f7f7" class="table-title-text"><fmt:message key="companyIntro.label.item3" bundle="${message}"/></td>
				                  <td width="66%" bgcolor="#FFFFFF" class="table-cont-text">
				                  	<fmt:message key="companyIntro.label.value3" bundle="${message}"/>
				                  </td>
				                </tr>
				                <tr>
				                  <td bgcolor="#f7f7f7" class="table-title-text"><fmt:message key="companyIntro.label.item4" bundle="${message}"/></td>
				                  <td width="66%" bgcolor="#FFFFFF" class="table-cont-text">
				                   <fmt:message key="companyIntro.label.value4" bundle="${message}"/>
				                  </td>
				                </tr>
				                <tr>
				                  <td bgcolor="#f7f7f7" class="table-title-text"><fmt:message key="companyIntro.label.item5" bundle="${message}"/></td>
				                  <td width="66%" bgcolor="#FFFFFF" class="table-cont-text">
				                  	<fmt:message key="companyIntro.label.value5" bundle="${message}"/>
				                  </td>
				                </tr>
				                <tr>
				                  <td bgcolor="#f7f7f7" class="table-title-text"><fmt:message key="companyIntro.label.item6" bundle="${message}"/></td>
				                  <td width="66%" bgcolor="#FFFFFF" class="table-cont-text">
				                   <fmt:message key="companyIntro.label.value6" bundle="${message}"/>
				                  </td>
				                </tr>
				                <tr>
				                  <td bgcolor="#f7f7f7" class="table-title-text"><fmt:message key="companyIntro.label.item7" bundle="${message}"/></td>
				                  <td width="66%" bgcolor="#FFFFFF" class="table-cont-text">
				                  	<fmt:message key="companyIntro.label.value7" bundle="${message}"/>
				                  </td>
				                </tr>
				                 <tr>
				                  <td bgcolor="#f7f7f7" class="table-title-text"><fmt:message key="companyIntro.label.item8" bundle="${message}"/></td>
				                  <td width="66%" bgcolor="#FFFFFF" class="table-cont-text">
				                  	<fmt:message key="companyIntro.label.value8" bundle="${message}"/>
				                  </td>
				                </tr>
				                 <tr>
				                  <td bgcolor="#f7f7f7" class="table-title-text"><fmt:message key="companyIntro.label.item9" bundle="${message}"/></td>
				                  <td width="66%" bgcolor="#FFFFFF" class="table-cont-text">
				                  	<fmt:message key="companyIntro.label.value9" bundle="${message}"/>
				                  </td>
				                </tr>
				            	</table>
				           </td>
			          	</tr>
			        	</table>
					</td>
				</tr>
			</table>
		</td>
	</tr>
	<tr>
		<td>&nbsp;</td>
	</tr>
	<tr>
		<td>
			<table width="650" align="center" border="1" cellpadding="0" cellspacing="1" bgcolor="#d6d5d5">
				<tr>
					<td width="34%" bgcolor="#f7f7f7" class="table-title-text"><fmt:message key="companyIntro.label.item10" bundle="${message}"/> </td>
                </tr>
                <tr>
                  <td width="66%" bgcolor="#FFFFFF" class="table-cont-text">
                  	<img src="jsp/images/access.JPG"  align="absmiddle" width="600" height="400" />
                  </td>
                </tr>
            </table>
		</td>
	</tr>
</body>
</html>
