<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<fmt:setLocale value="KO"/>
<fmt:setBundle basename="msg" var="message"/>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title><c:out value="사이트맵"/>&nbsp;::&nbsp;<fmt:message key="TITLE.title" bundle="${message}"/></title>
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
				<td colspan="3" valign="top"><img src="jsp/images/new/sitemap_tit.gif" width="736" height="82" /></td>
			</tr>
			<tr>
				<td colspan="3" valign="top">&nbsp;</td>
			</tr>
			<tr>
				<td valign="top">
					<table width="232" height="414" border="0" cellpadding="0" cellspacing="1" background="jsp/images/new/sitemap_category_bg.gif">
					<tr>
						<td valign="top" >
							<table width="170" border="0" align="center" cellpadding="0" cellspacing="0">
							<tr>
								<td height="60"><p>&nbsp;</p></td>
							</tr>
							<tr>
								<td height="40" align="left" ><a href="BuySellList?search_cate_code_1=C10100" class="sitemap-link">물건사기</a></td>
							</tr></a>
							<tr>
								<td height="39" align="left" > <a href="BuySellList?search_cate_code_1=C10200" class="sitemap-link">물건팔기</a></td>
							</tr>
							<tr>
								<td height="39" align="left" > <a href="StoreSearch" class="sitemap-link">업체찾기</a><br /></td>
							</tr>
							<tr>
								<td height="38" align="left" ><a href="GourmetSearch" class="sitemap-link">음식점</a></td>
							</tr>
							<tr>
								<td height="43" align="left" > <a href="RoomSellList?cate_code_1=C10001" class="sitemap-link">호텔/민박</a></td>
							</tr>
							<tr>
								<td height="34" align="left" ><a href="RoomSellList?cate_code_1=C10002" class="sitemap-link">기숙사/룸메이트</a></td>
							</tr>
							<tr>
								<td height="43" align="left" > <a href="HouseSellList" class="sitemap-link">부동산</a></td>
							</tr>
							<tr>
								<td height="37" align="left" > <a href="JobSearch" class="sitemap-link">구인</a></td>
							</tr>
							<tr>
								<td height="39" align="left" > <a href="FindjobSearch" class="sitemap-link">구직 </a></td>
							</tr>
							</table>
						</td>
					</tr>
					</table>
				</td>
				<td align="center" valign="top">
					<table width="232" height="298" border="0" cellpadding="0" cellspacing="1" background="jsp/images/new/sitemap_member_bg.gif">
					<tr>
						<td align="center" valign="top" >
							<table width="170" border="0" align="center" cellpadding="0" cellspacing="0">
							<tr>
								<td height="60"><p>&nbsp;</p></td>
							</tr>
							<tr>
								<td height="40" align="left" ><a href="MemberRegistOpen" class="sitemap-link">회원가입</a></td>
							</tr>
							<tr>
								<td height="40" align="left" > <a href="MemberFindInfoOpen" class="sitemap-link">아이디 찾기</a></td>
							</tr>
							<tr>
								<td height="38" align="left" > <a href="MemberFindInfoOpen" class="sitemap-link">비밀번호 찾기</a><br /></td>
							</tr>
							<tr>
								<td height="40" align="left" ><a href="MemberDetail" class="sitemap-link">회원정보</a></td>
							</tr>
							<tr>
								<td height="39" align="left" > <a href="MemberDeleteOpen" class="sitemap-link">회원탈퇴하기</a></td>
							</tr>
							<tr>
								<td height="37" align="left" ><a href="MyWrite" class="sitemap-link">메뉴별 내가쓴글</a> </td>
							</tr>
							</table>
						</td>
					</tr>
					</table>
				</td>
				<td align="right" valign="top">
					<table width="232" height="336" border="0" cellpadding="0" cellspacing="1" background="jsp/images/new/sitemap_cominfo_bg.gif">
					<tr>
						<td align="center" valign="top" >
							<table width="170" border="0" align="center" cellpadding="0" cellspacing="0">
							<tr>
								<td height="60"><p>&nbsp;</p></td>
							</tr>
							<tr>
								<td height="40" align="left" ><a href="SiteIntroduce" class="sitemap-link">사이트소개</a></td>
							</tr>
							<tr>
								<td height="39" align="left" > <a href="UseAgreement" class="sitemap-link">이용약관</a></td>
							</tr>
							<tr>
								<td height="39" align="left" > <a href="UseInfo" class="sitemap-link">이용안내</a> <br /></td>
							</tr>
							<tr>
								<td height="38" align="left" ><a href="Private" class="sitemap-link">개인정보취급방침</a></td>
							</tr>
							<tr>
								<td height="43" align="left" > <a href="TopRegist" class="sitemap-link">메뉴별 등록하기</a></td>
							</tr>
							<tr>
								<td height="34" align="left" ><a href="FAQ" class="sitemap-link">FAQ</a></td>
							</tr>
							<tr>
								<td height="43" align="left" > <a href="ContactusRegistOpen" class="sitemap-link">문의하기</a></td>
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