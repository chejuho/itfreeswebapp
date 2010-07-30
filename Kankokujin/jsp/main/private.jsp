<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<fmt:setLocale value="KO"/>
<fmt:setBundle basename="msg" var="message"/>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title><c:out value="개인정보 취급방침"/>&nbsp;::&nbsp;<fmt:message key="TITLE.title" bundle="${message}"/></title>
<meta http-equiv="Content-type" content="text/html; charset=UTF-8">
<script src="jsp/include/js/prototype.js" type="text/javascript" ></script>
<script src="jsp/include/js/src/scriptaculous.js?effets" type="text/javascript" ></script>
<script src="jsp/include/js/popupMenu.js" type="text/javascript"></script>
<script src="jsp/include/js/top.js" type="text/javascript"></script>
<script src="jsp/include/js/commonCheck.js" type="text/javascript"></script>
<script src="jsp/include/js/commonFunction.js" type="text/javascript"></script>
<script src="jsp/Scripts/AC_RunActiveContent.js" type="text/javascript"></script>
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
        <td valign="top"><img src="jsp/images/new/private_tit.gif" width="736" height="82" /></td>
        </tr>
      <tr>
        <td valign="top">&nbsp;</td>
      </tr>
      <tr>
        <td valign="top"><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td bgcolor="#f3f6f9" style="padding:11px 11px 11px 11px;"><table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#d3e2f1">
                <tr>
                  <td align="left" bgcolor="#FFFFFF" style="padding:15px 15px 15px 15px;"><p align="left"><strong class="red-text-w">개인정보 취급방침</strong>은 고객의 개인정보 보호를 위하여   실시하는
                    개인정보수집의 목적과 그 정보의 보안에 관한 규정입니다.<br />
                    <br />
                    이는 <strong>고객의 기본적인 사생활 비밀과 자유 </strong>및<strong> 통신 비밀을   보장</strong>하고 
                    <strong>정보 유출로 인한 인권피해가 발생하지 않도록 </strong>하고자 마련한 것입니다. <br />
                    <br />
                    <br />
                    <strong><span class="blue-text-w"><img src="jsp/images/new/foot_menu_icon2.gif"   align="absbottom"width="16" height="16" /></span></strong><span class="blue-text-w"><strong>개인 정보 수집 목적 및 이용</strong></span><br />
                    <br />
                    회원님께서 서비스를 이용하는데 있어,필요한 최소한의 정보를 필수 사항으로 수집합니다.<br />
                          회원님께서 제공하신 모든 정보는 상기 목적에   필요한 용도 이외로는 사용되지 않으며, 
                          수집 정보의 범위나 사용 목적, 용도가 변경될 시에는 반드시 회원님께 사전 동의를 구할   것입니다.<br />
                          <br />
                          <br />
                          <strong><span class="blue-text-w"><img src="jsp/images/new/foot_menu_icon2.gif"   align="absbottom"width="16" height="16" /></span></strong><span class="blue-text-w"><strong>개인 정보 수집 항목 및 보유 기간</strong></span><br />
                          <br />
                          서비스 제공을 위해 제공 받는 회원정보는 희망ID / 비밀번호 / E-mail / 전화번호 / 이름 입니다.<br />
                        회원님께서 서비스를 받는   동안 개인 정보는 계속 보유하며 서비스 제공을 위해 이용하게 됩니다.<br />
                        단, 탈퇴를 요청하거나 표명된 회원 자격 상실 사유에의해 회원 자격을   제한 및 정지시키는 경우에는 
                        해당 개인의 정보는 기술적 방법에 의해 삭제되며 어떠한 용도로도 열람 또는 이용될수 없도록   처리됩니다.<br />
                        <br />
                        <br />
                          <strong><span class="blue-text-w"><img src="jsp/images/new/foot_menu_icon2.gif"   align="absbottom"width="16" height="16" /></span></strong><span class="blue-text-w"><strong>개인 정보 열람과 정정 및 탈퇴</strong></span><br />
                          <br />
                          회원님은 언제든지 제공된 개인 정보를 열람, 정정, 삭제를 하실 수 있습니다.<br />
                        회원님의 정보는 탈퇴시 즉시 삭제됨과 동시에 기술적   방법에 의해 어떠한 용도로도열람 또는 이용 될 수
                        없도록 처리됩니다.<br />
                        <br />
                        <br />
                          <strong><span class="blue-text-w"><img src="jsp/images/new/foot_menu_icon2.gif"   align="absbottom"width="16" height="16" /></span></strong><span class="blue-text-w"><strong>개인 아이디와 비빌번호 관리</strong></span><br />
                          <br />
                          회원님이 사용하고 계시는 ID와 비밀번호는 원칙적으로 회원님만이 사용하도록 되어 있습니다.<br />
                        고의 또는 과실이 없는 경우에, 회원님의   ID와 비밀번호 도용 또는 기타 타인의 사용으로 의해 발생된 문제에<br />
                        대하여 책임지지 않습니다.<br />
                        어떠한 경우에도 비밀번호는 타인에게   알려 주지 마시고 로그온 상태에서는 주위의 다른 사람에게 개인정보가 유출되지 않도록 특별한 주의를 기울여 주시기   바랍니다.</p>                    
                    
                     
                    </td>
                </tr>
            </table></td>
          </tr>
        </table></td>
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