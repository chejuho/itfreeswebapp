<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="myTags" uri="pageHandle"%>

<fmt:setLocale value="KO"/>
<fmt:setBundle basename="hudousan" var="message"/>	
	<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
	<tr>
    	<td>
			<a href="HudousanMainAction" target="_self">메인으로</a>
		</td>
	</tr>
	<tr>
		<td>&nbsp;</td>
	</tr>
	<tr>
    	<td>
			<table background="jsp/images/new/top_bg.gif" width="950"  border="1" align="center" cellpadding="0" cellspacing="0" id="Table_01">
			<tr>
				<td align="center"><a href="HudousanSearchAction?method=leaseSearchInit" target="_self"><fmt:message key="top.label.top1" bundle="${message}"/></a></td>
				<td align="center"><a href="HudousanSearchAction?method=leaseSuggestInit" target="_self"><fmt:message key="top.label.top2" bundle="${message}"/></a></td>
				<td align="center"><a href="HudousanSearchAction?method=buySearchInit" target="_self"><fmt:message key="top.label.top3" bundle="${message}"/></a></td>
				<td align="center"><a href="HudousanSearchAction?method=buySuggestInit" target="_self"><fmt:message key="top.label.top4" bundle="${message}"/></a></td>
				<td align="center"><a href="HudousanFindAction?method=leaseFindInit" target="_self"><fmt:message key="top.label.top5" bundle="${message}"/></a></td>
				<td align="center"><a href="HudousanFindAction?method=buyFindInit" target="_self"><fmt:message key="top.label.top6" bundle="${message}"/></a></td>
				<td align="center"><a href="CompanyIntroAction" target="_self"><fmt:message key="top.label.top7" bundle="${message}"/></a></td>
			</tr>
			</table>
		</td>
	</tr>
	<tr>
		<td>&nbsp;</td>
	</tr>
	</table>
