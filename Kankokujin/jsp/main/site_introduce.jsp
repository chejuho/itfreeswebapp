<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ page import="common.bean.MemberBean"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="common.util.Util"%>
<fmt:setLocale value="KO"/>
<fmt:setBundle basename="msg" var="message"/>
<html>
<head>
<title><c:out value="사이트 소개"/>&nbsp;::&nbsp;<fmt:message key="TITLE.title" bundle="${message}"/></title>
<meta http-equiv="Content-type" content="text/html; charset=UTF-8">
<script src="jsp/include/js/prototype.js" type="text/javascript" ></script>
<script src="jsp/include/js/src/scriptaculous.js?effets" type="text/javascript" ></script>
<script src="jsp/include/js/popupMenu.js" type="text/javascript"></script>
<script src="jsp/include/js/top.js" type="text/javascript"></script>
<script src="jsp/include/js/commonCheck.js" type="text/javascript"></script>
<script src="jsp/include/js/commonFunction.js" type="text/javascript"></script>
<link href="jsp/include/css/basic.css" rel="stylesheet" type="text/css">
</head>

<body style="margin:0 0 0 0">
	<table>
	<jsp:include page="../include/top.jsp" flush="true" />
	<tr>
		<td height="20">&nbsp;</td>
	</tr>
	<tr>
		<td>
			<table width="736"  border="0" align="center" cellpadding="0" cellspacing="0">
			<tr>
				<td valign="top"><img src="jsp/images/new/site_introduce_tit.gif" width="736" height="82" /></td>
			</tr>
			<tr>
				<td valign="top">&nbsp;</td>
			</tr>
			<tr>
				<td valign="top" bgcolor="#f3f6f9" style="padding:11px 11px 11px 11px;">
					<table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#d3e2f1">
					<tr>
						<td align="left" bgcolor="#FFFFFF" style="padding:15px 15px 15px 15px;">
							<table width="100%" border="0" cellspacing="1" cellpadding="0">
							<tr>
								<td width="26%" align="right"><img src="jsp/images/new/siteintroduce_bg.gif" width="150" height="401" /></td>
								<td width="74%" align="left" valign="top" style="padding:20px 20px 20px 20px;">
									<table width="100%" border="0" cellspacing="0" cellpadding="0">
									<tr>
										<td><p class="large-text-w">안녕하십니까? <span class="blue-text-w"><strong>KANKOKUJIN.COM</strong></span>입니다. </p>
											<p><strong>KANKOKUJIN.COM</strong>은 <span class="green-text-w"><strong>일본내의 업체정보 및 부동산 숙박 및 종합적인 정보 <br />
                        						제공사이트</strong></span>로서 다양한 정보로 넘쳐나는 인터넷에서 정확하고 믿을 수 있는 정보<br />
                        						를 제공하여 일본생활 조금이나마 도움을 드리고 싶은 것이 KANKOKUJIN.COM<br />의 
												목표입니다.믿을 수 있는 <span class="orange-text"><strong>정보와 신뢰성</strong></span>
												<strong>있는 <span class="red-text-w">한인 커뮤니티</span></strong>를 만들기 위하여<br /> 
												일본에 거주하시는 한인교포들과 다양한 커뮤니티를 형성하여 한국인 커뮤니티를<br />이용한정보 공유와 
												거래 형성에 편리한 환경을조성하기 위하여 꾸준히 노력할 것입<br />니다.
												<br />KANKOKUJIN.COM을 이용하시는 모든 방문자와 회원들에게 만족할 수 있는 서비<br />스를
												제공해 드리기 위하여 언제나 노력하고 발로 뛰는 KANKOKUJIN.COM이 되겠<br />습니다. </p>
										</td>
 									</tr>
									<tr>
										<td align="right"><span class="large-text-w"><img src="jsp/images/new/siteintroduce_sign.gif" width="232" height="60" /></span></td>
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
			</table>
		</td>
	</tr>
	<tr>
		<td height="50">&nbsp;</td>
	</tr>
	<jsp:include page="../include/footer.jsp" flush="true"/>
	</table>
</body>
</html>