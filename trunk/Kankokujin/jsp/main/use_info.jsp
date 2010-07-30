<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@page import="common.bean.MemberBean"%>
<%@page import="common.util.Util"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<fmt:setLocale value="KO"/>
<fmt:setBundle basename="msg" var="message"/>
<html>
<head>
<title><c:out value="이용 안내"/>&nbsp;::&nbsp;<fmt:message key="TITLE.title" bundle="${message}"/></title>
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
    <td><table width="736"  border="0" align="center" cellpadding="0" cellspacing="0">
      <tr>
        <td valign="top"><img src="jsp/images/new/useinfo_tit.gif" width="736" height="82" /></td>
        </tr>
      <tr>
        <td valign="top">&nbsp;</td>
      </tr>
      <tr>
        <td width="614" valign="top"><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td bgcolor="#f3f6f9" style="padding:11px 11px 11px 11px;"><table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#d3e2f1">
              <tr>
                <td align="left" bgcolor="#FFFFFF" style="padding:15px 15px 15px 15px;"><p><span class="blue-text-w"><strong>KANKOKUJIN.COM</strong></span>에 오신 것을 환영합니다.<br />
                  본 사이트는 현재 일본에 거주하는 한국인을 대상으로 정보를 제공하는 사이트 입니다.</p>
                  <p>KANKOKUJIN.COM 을 이용할 수 있는 방법은 두 가지가 있습니다. <br />
                    <span class="red-text-w"><strong>회원</strong></span><strong>으로 가입하시는 방법</strong>과 <span class="green-text-w">비회원</span><strong>으로 이용하시는 방법</strong>이 있습니다.<br />
                    회원에 가입하지 않더라도 KANKOKUJIN.COM 등록된 모든 글은 열람이 가능합니다.<br />
                    각 메뉴별 등록글 들은 누구나 열람이 가능하고 상세페이지도 열람 하실수 있습니다.<br />
                  </p>
                  <br />
                  <table width="614" border="0" align="center" cellpadding="0" cellspacing="0">
                    <tr>
                      <td height="96" background="jsp/images/new/useinfo_box_bg.gif"><table width="97%" border="0" align="center" cellpadding="0" cellspacing="0">
                        <tr>
                          <td width="20%" align="center" class="white-text-w"><strong>글등록하기</strong></td>
                          <td width="8%">&nbsp;</td>
                          <td width="72%"><span class="red-text-w"><strong>회원</strong></span>으로 가입하셔야 <strong>글을 등록</strong> 하실수 있습니다.<br />
                            등록하신 글은 홈페이지 상단의 내가쓴글에서 열람이 가능하며, 지금까지 <br />
                            등록하신 모든 글들을 (수정/삭제)하실수 있습니다.</td>
                        </tr>
                      </table></td>
                    </tr>
                    <tr>
                      <td><img src="jsp/images/new/useinfo_line.gif" width="654" height="30" /></td>
                    </tr>
                    <tr>
                      <td height="96" align="center" background="jsp/images/new/useinfo_box_bg.gif"><table width="97%" border="0" align="center" cellpadding="0" cellspacing="0">
                        <tr>
                          <td width="20%" align="center" class="white-text-w"><strong>회원정보수정</strong></td>
                          <td width="8%">&nbsp;</td>
                          <td width="72%" align="left">홈페이지 상단의 회원정보에서 <span class="blue-text-w"><strong>회원님의 정보 (열람/수정)이가능</strong></span>하며 <br />
                            회원님의 
                            <span class="blue-text-w"><strong>비밀번호를 변경</strong></span>하실수 있습니다.</td>
                        </tr>
                      </table></td>
                    </tr>
                    <tr>
                      <td><img src="jsp/images/new/useinfo_line.gif" width="654" height="30" /></td>
                    </tr>
                    <tr>
                      <td height="96" background="jsp/images/new/useinfo_box_bg.gif"><table width="97%" border="0" align="center" cellpadding="0" cellspacing="0">
                        <tr>
                          <td width="20%" align="center" class="white-text-w"><strong>등록하기</strong></td>
                          <td width="8%">&nbsp;</td>
                          <td width="72%">메인화면의 상단의 페이지의 등록하기 메뉴에서 <strong>한번에 등록화면으로 이동</strong>이 <br />
                            가능합니다.</td>
                        </tr>
                      </table></td>
                    </tr>
                    <tr>
                      <td><img src="jsp/images/new/useinfo_line.gif" width="654" height="30" /></td>
                    </tr>
                    <tr>
                      <td height="96" background="jsp/images/new/useinfo_box_bg.gif"><table width="97%" border="0" align="center" cellpadding="0" cellspacing="0">
                        <tr>
                          <td width="20%" align="center" class="white-text-w"><strong>FAQ</strong></td>
                          <td width="8%">&nbsp;</td>
                          <td width="72%"><strong>자주 올라 오는 문의사항</strong>을 모아둔 곳입니다.</td>
                        </tr>
                      </table></td>
                    </tr>
                    <tr>
                      <td><img src="jsp/images/new/useinfo_line.gif" width="654" height="30" /></td>
                    </tr>
                    <tr>
                      <td height="96" background="jsp/images/new/useinfo_box_bg.gif"><table width="97%" border="0" align="center" cellpadding="0" cellspacing="0">
                        <tr>
                          <td width="20%" align="center" class="white-text-w"><strong>사이트맵</strong></td>
                          <td width="8%">&nbsp;</td>
                          <td width="72%">당 사이트의 모든 메뉴들을 보실수 있습니다.</td>
                        </tr>
                      </table></td>
                    </tr>
                    <tr>
                      <td><img src="jsp/images/new/useinfo_line.gif" width="654" height="30" /></td>
                    </tr>
                    <tr>
                      <td height="96" background="jsp/images/new/useinfo_box_bg.gif"><table width="97%" border="0" align="center" cellpadding="0" cellspacing="0">
                        <tr>
                          <td width="20%" align="center" class="white-text-w"><strong>문의하기</strong></td>
                          <td width="8%">&nbsp;</td>
                          <td width="72%">이용시 문제점이나 그밖의 불편하신 사항은 관리자에게 문의 가능합니다.</td>
                        </tr>
                      </table></td>
                    </tr>
                  </table></td>
              </tr>
            </table></td>
          </tr>
        </table></td>
      </tr>
      <tr>
        <td valign="top">&nbsp;</td>
      </tr>
      
    </table></td>
  </tr>
  <tr>
    <td height="50">&nbsp;</td>
  </tr>
	<jsp:include page="../include/footer.jsp" flush="true"/>
	</table>
</body>
</html>