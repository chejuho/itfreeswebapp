<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@page import="common.bean.MemberBean"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<fmt:setLocale value="KO"/>
<fmt:setBundle basename="msg" var="message"/>
<%
	request.setCharacterEncoding("UTF-8");
	String message = (String)Util.changeNullStr(request.getAttribute("Message"));
	MemberBean member = new MemberBean();
	member = (MemberBean) session.getAttribute("memberInfo");
	if (member == null) {
		member = new MemberBean();
	}
	if ("WAR0005".equals(message)) {%>
	<script language="javascript">
		alert("<fmt:message key="WAR0005" bundle="${message}"/>");
	</script>
<%} else if ("MSG0013".equals(message)) {%>
	<script language="javascript">
		alert("<fmt:message key="MSG0013" bundle="${message}"/>");
	</script>
<%}%>
<script type="text/javascript">
<!--

	function submitUpdate() {
		   location.href="MemberUpdateOpen";
	   	}     
	   	
	function submitDelete() {
	
		   location.href="MemberDeleteOpen";
	   	}          


//-->
</script>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@page import="common.util.Util"%>
<html>
<head>
<title><c:out value="이용 약관"/>&nbsp;::&nbsp;<fmt:message key="TITLE.title" bundle="${message}"/></title>
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
    <td><table width="736"  border="0" align="center" cellpadding="0" cellspacing="0">
      <tr>
        <td valign="top"><img src="jsp/images/new/useagree_tit.gif" width="736" height="82" /></td>
        </tr>
      <tr>
        <td valign="top">&nbsp;</td>
      </tr>
      <tr>
        <td align="center" valign="top" ><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td bgcolor="#f3f6f9" style="padding:11px 11px 11px 11px;"><table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#d3e2f1">
              <tr>
                <td align="left" bgcolor="#FFFFFF" style="padding:15px 15px 15px 15px;"><strong>본 약관은 회원님들께 보다 전문화된 서비스를 제공하기 위한 것으로,
                  사이트 이용에 앞서 <span class="red-text-w">꼭   살펴보시기</span> 바랍니다.<br />
                    <br />
                    <span class="blue-text-w"><img src="jsp/images/new/foot_menu_icon1.gif"  align="absmiddle" width="16" height="16" />제 1 조 (목적) <br />
                    <img src="jsp/images/new/foot_menu_icon1.gif"  align="absmiddle" width="16" height="16" />제 2 조 (이용약관의 효력 및 변경) <br />
                    <img src="jsp/images/new/foot_menu_icon1.gif"  align="absmiddle" width="16" height="16" />제 3 조 (회원가입 절차와 회원   ID,비밀번호의 관리) <br />
                    <img src="jsp/images/new/foot_menu_icon1.gif"  align="absmiddle" width="16" height="16" />제 4 조. (서비스 이용의 개시 및 서비스 이용시간) <br />
                    <img src="jsp/images/new/foot_menu_icon1.gif"  align="absmiddle" width="16" height="16" />제 5 조 (회원의 개인정보 보호) <br />
                    <img src="jsp/images/new/foot_menu_icon1.gif"  align="absmiddle" width="16" height="16" />제 6   조 (서비스에 포함되어 있는 광고정보 및 전달방법)</span></strong>
                    <p><strong class="blue-text-w">제 1 조 (목적)</strong><br />
                        <br />
                      이 약관은 KANKOKUJIN.COM (이하 회사라 합니다)이 제공하는   서비스(한글명:캉코쿠진닷컴 , 이하 서비스라 합니다)의 조건 및 절차에 관한 기본적인 사항을 정함을 목적으로   합니다.<br />
                      <br />
                      <strong class="blue-text-w">제 2 조 (이용약관의 효력 및 변경)</strong><br />
                      <br />
                      1. 이 약관은 서비스 메뉴 및 회사에 게시하여   공시함으로써 효력이 발생합니다.<br />
                      2.회사는 합리적인 사유가 발생될 경우에는 이 약관을 변경할 수 있으며,약관이 변경된 경우에는 지체 없이   이를 공시합니다.<br />
                      <br />
                      <strong class="blue-text-w">제 3 조 (회원가입 절차와 회원 ID,비밀번호의 관리)</strong><br />
                      <br />
                      회원이란 캉코쿠진닷컴에 접속하여   회사가 정한 절차에 따라, 본 약관에 동의하고 서비스 이용에 필요한 회원 정보 입력 후 , 서비스 이용을 승낙함으로써, 서비스 이용계약이   체결되어 서비스를 받는 사람을 말합니다.<br />
                      <br />
                      이 약관은회사가 서비스하는 캉코쿠진닷컴의 공지사항을 통해 공시함으로써 효력을   발생합니다.<br />
                      회사는 사정 변경의 경우와 영업상 주요 사유가 있을 때, 약관 규제 등에 관한 법률 등에 관한 법률에 위배되지 않는 범위   내에서, 약관을 변경할 수 있으며, 변경된 약관은 공지사항을 통해 공시함으로써 효력을 발생합니다.<br />
                      또한 본 약관이 변경된 경우에는 적용일자   및 개정사유를 명시하여 현행약관과 함께 공지합니다.<br />
                      <br />
                      이 개정된 약관 내용이 관계 법령에 위배되지 않는 한 약관 변경 이전에 가입한   회원을 포함하여, 가입한 모든 회원은 최근 공지된 약관의 적용을 받게 되며,공지사항 및 본 약관을 정기적으로 확인할 책임이 있습니다.<br />
                      단,   회원 개인정보 및 권한 변경 등의 내용이 포함된 약관 변경의 경우,개별 연락방법인 캉코쿠진닷컴 개인메일을 통해 모든 회원에게   공지됩니다.<br />
                      회원의 ID와 비밀번호에 관한 모든 관리의 책임은 회원에게 있으며,자신의 ID 및 비밀번호를 제3자가 이용하게 해서는   안됩니다.<br />
                      회원은 자신의 ID 및 비밀번호가 부정하게 사용되고 있음을 인지한 경우,즉시 회사에 그 사실을 통보해야 하며, 회사의 안내에   따라야 합니다.<br />
                      회사는 다음에 해당하는 경우, 서비스 이용을 승낙하지 아니합니다. <br />
                      1. 회원정보 내용을 허위로 기재하였거나, 고의로   오기 및 누락시켰을 때<br />
                      2. 사회의 안녕과 질서 혹은 미풍양속을 저해할 목적으로 신청하였을 때<br />
                      3. 기타 회사가 정한, 회원의 서비스   이용 조건을 충족하지 못하였을 때<br />
                      또한, 회사는 다음 각 호의 내용과 같이 기술상 여건이 허락하지 않을<br />
                      경우, 서비스 이용 승낙 및   서비스 개시를 하지 않을 수 있습니다.<br />
                      4. 천재지변 등 불가항력적인 장애가 발생하였을 때<br />
                      5. 서비스 이용이 어려운 설비의 장애 및   기술적인 장애가 발생하였을 때<br />
                      6. 기타 회사가 필요하다고 여겨 서비스 이용을 제한하였을 때<br />
                      서비스 이용은 회사와 회원간에 서비스   이용계약이 성립된 때부터 개시됩니다.<br />
                      회사는 서비스 이용계약이 성립된 회원에게, 회사에서 개발한 서비스 및 타사와의 협력계약으로 얻어진   서비스를 제공하며, 필요한 경우 서비스의 내용을 추가 또는 변경할 수 있습니다.<br />
                      회사는 관계 법령과 본 약관에서 정한 바에 따라 회원이   쾌적한 환경에서 서비스를 즐길 수 있도록 지속적, 안정적으로 서비스를 제공할 의무를 가지며, 이를 위하여 최선을 다해 노력합니다.<br />
                      또한,   회원으로부터 소정의 절차에 의해 제기되는 의견에 대해서는 적절한 절차를 거처 처리하며,처리하는데 일정 기간이 소요될 경우 그 사유와 처리 일정을   알려줍니다. <br />
                      <br />
                      <strong class="blue-text-w">제 4 조. (서비스 이용의 개시 및 서비스 이용시간)</strong><br />
                      <br />
                      서비스 이용은 회사의 업무상 또는   기술상 특별한 지장이 없는 한 연중무휴,1일 24시간을 원칙으로 하나, 시스템 정기점검 및 회사가 필요한 경우는 제외로 합니다. 회사는 서비스   이용을 전체 또는 부분적으로 제한해야 할 경우, 공지사항을 통해 공시합니다. 단, 회사가 통제할 수 없는 사유로 인하여 서비스 이용이 중단되어   사전에 통지할 수 없는 경우는 예외로 합니다.<br />
                      <br />
                      <strong class="blue-text-w">제 5 조 (회원의 개인정보 보호)</strong> <br />
                      <br />
                      회사는   &quot;개인정보보호정책&quot;에 따라 회원의 개인정보를 보호할 책임을 지며,이외 회원 자신의 개인정보인 ID 및 비밀번호에 관한 관리책임은 각 회원에게   있습니다. <br />
                      회사는 회원이 회원정보에 기재하였거나 기타의 절차에 따라 제공한 회원정보를 철저히 보안 유지하며,양질의 서비스를 운영하거나   개선하는 데에만 사용하고 다른 목적으로 타 기관 및 개인에게 양도하지 않습니다. <br />
                      <br />
                      단, 회사는 다음의 경우에 한하여, 회원의   개인정보를 관련된 제3자에게 제공할 수 있습니다. <br />
                      1. 회원이 서비스를 이용함에 있어, 관련법률을 위반하여 정부기관으로부터 정보제공을   요청 받은 경우<br />
                      2. 회원이 관련법률 및 본 약관을 위반한 것을 확인 받아야 할 경우 이때 개인정보는 제3자에게 누설하거나 제공하지   않습니다.<br />
                      회원은 서비스 이용권한 및 이용환경을 타인에게 양도 및 증여할 수 없으며, 이를 어떠한 조건의 담보로 제공할 수   없습니다.<br />
                      회원은 본 약관에 위배되거나 관련 법규에 위배되는 불법적인 행위를 목적으로 캉코쿠진닷컴 서비스를 이용해서는 안됩니다. <br />
                      회원은 캉코쿠진닷컴 서비스를 의도적으로 훼손, 정지, 과부하, 손상시킬 목적으로 사용할 수 없으며, 다른 사용자의 서비스 이용을   방해해서도 안됩니다.<br />
                      <br />
                      회원은 해킹 또는 기타의 수단을 이용하여 캉코쿠진닷컴 서비스를 이용할 수 있는 권한 외의 다른 권한을 얻고자   일을 도모해서는 아니 되며, 회원에게 의도되지 않은 정보를 캉코쿠진닷컴 서비스를 통하여 취득하려고 해서는   안됩니다.<br />
                      <br />
                      스팸메일(Spam-mail)이란 PC통신이나 인터넷 ID를 가진 사람에게 사기성 광고 및 음란/불법 소프트웨어의 판매,   행운의 편지 등 기타의 내용을 수신인의 허락없이 일방적으로 보내는 대량의 메일을 말하며, 메일이 아닌 게시판 등을 이용하기도 합니다.. <br />
                      캉코쿠진닷컴 전자우편 서비스를 이용하여 불특정 다수에게 수신인의 허락없이 대량의 스팸메일을 발송할 수 없습니다.<br />
                      대량으로 보내지는   회사는 전자우편을 이용한 스팸메일 또는 스팸 게시물로 인해 회원 및 제3자에게 피해를 주는 행위를 방지하기 위하여 기타의 기술적, 제도적 정책을   시행할 수 있습니다. 이를 위반할 경우 캉코쿠진닷컴 서비스 이용을 제한할 수 있으며, 정보통신이용촉진 및 정보보호 등에 관한 법률 등 관계법령에   따라 민/형사상의 처벌을 받을 수 있습니다. <br />
                      <br />
                      <strong class="blue-text-w">제 6 조 (서비스에 포함되어 있는 광고정보 및   전달방법)</strong><br />
                      <br />
                      캉코쿠진닷컴 에는 제3자가 운영하는 타 웹사이트로 연결되는 링크정보가 포함될 수 있습니다. <br />
                      이는 회원의   편의를 위하여, 캉코쿠진닷컴에 다른 웹사이트 및 기타 자료에 대한 정보 연결만 되어 있는 것입니다. <br />
                      다른 웹사이트 및 정보는 회사가   관리하는 것이 아니며, 회사는 이에 대한 통제권이 없으므로, 회사의 고의나 중대한 과실에 의한 경우를 제외하고는, 다른 웹사이트 및 정보 등에   대한 책임을 지지 아니합니다. 더불어, 다른 웹사이트 및 기타 정보가 연결되어 있다고 해서, 회사가 이를 의도적으로 추천하거나 또는 그 운영자와   어떠한 관련이 있다는 것을 암시하지 아니합니다. <br />
                      회사는 무료로 제공되는 서비스와 관련하여 회사의 중대한 과실에 의한 경우를   제외하고,회원에게 어떠한 손해가 발생하더라도 이에 대한 책임을 부담하지 아니합니다. <br />
                      캉코쿠진닷컴을 통해 제공된 컨텐츠 및 서비스 정보는   불특정 다수를 대상으로 함으로 부정확함이나 인쇄상의 오류가 있을 수 있으며, 기타 유해한 구성요소의 부재 등을 보증하지 않으므로, 회사와 업체는   이러한 자료에 대한 수정을 정기적으로 진행합니다.<br />
                      이에, 회원은 법률, 의료, 금융 등의 관계로 어떤 중요한 의사결정을 함에 있어서 에서   제공하는 정보에만 의존하지 마시고, 회원의 상황에 맞는 특별한 조언을 받기를 권합니다.<br />
                      회사와 협력업체는 캉코쿠진닷컴을 통해 제공된 컨텐츠   및 서비스 정보를 회원이 이용함에 있어, 회사의 고의나 중대한 과실에 의한 경우를 제외하고, 이와 관련한 어떠한 책임도 부담하지   아니합니다.<br />
                      <br />
                      <strong class="blue-text-w">제 7 조 (서비스 이용 시 회원의 의무) </strong><br />
                      <br />
                      회원이 본 약관의 규정을 위반함으로써 회사의 회원   또는 제3자에게 책임을 부담하고,이로 인해 회사에 손해가 발생한 경우, 본 약관을 위반한 회원은 회사에 발생하는 모든 손해를 배상해야 하며 동   손해로부터 회사를 면책시켜야 합니다. <br />
                      <br />
                      또한, 회원은 서비스를 이용하면서 다음 각 호 행위의 것들을 절대 하지 아니하며,이로 인해   회사 및 다른 회원이 손해를 입은 경우, 손해를 배상할 책임이 있습니다.<br />
                      <br />
                      1. 공공질서 및 미풍양속에 반하는 행위<br />
                      2.   범죄행위 및 기타 이와 관련된 행위<br />
                      3. 국익 또는 사회적 공익을 저해할 목적으로 서비스 이용을 계획 또는 실행하는 행위<br />
                      4. 회원   가입신청시 또는 회원 정보수정시 허위내용을 등록하는 행위<br />
                      5. 타인의 ID 및 비밀번호를 도용하거나, 타인과의 관계를 허위로 게재하는   행위<br />
                      6. 타인의 명예를 손상시키거나 불이익을 주는 행위<br />
                      7. 다른 회원의 개인정보를 동의 없이 수집,저장,공개하는 행위<br />
                      8.   같은 사용자가 다른 ID로 이중 등록을 하는 행위<br />
                      9. 저속한 불건전 게시물 및 재단으로부터 승인되지 않은 광고성 정보 또는<br />
                      일정한   내용을 서비스에 게시하거나, 메일 또는 기타의 수단으로 지속적으로 유포하는 행위<br />
                      10. 타인에게 피해를 줄 수 있는 바이러스 및 오염된   기타의 소프트웨어를 메일 또는 기타의 수단으로 유포하는 행위<br />
                      11. 자신(또는 타인)에게 재산상의 이득을 취할 목적으로 또는 타인에게   손해를 가할 목적으로 허위 정보를 유포하는 행위<br />
                      12. 서비스에 위해를 가하거나 서비스 운영에 지장을 줄 우려가 있는 행위<br />
                      13.   기타 관련 법령이나 재단이 정한 규정에 위배되는 행위<br />
                      14. 정치 또는 종교적 분쟁을 야기시킬 수 있는 내용을 서비스에   게재함으로써,홈페이지 운영에 영향을 주거나 방해가 될 수 있다고 판단되는 경우.<br />
                      회사는 회원이 게시,업로드, 입력하였거나 제공한 자료에   대해서 소유권을 주장하지 아니합니다.<br />
                      회사는 회원이 본 약관에 위배되는 행위를 하였을 경우,캉코쿠진닷컴 서비스의 일부 또는 전부에 대한   이용권한을 사전 통지 없이 진행할 수 있습니다. </p>
                  <p><strong class="large-text-w">[부 칙] 제 1 조 [시행일] 본 약관은 2009년 월 일부터 적용됩니다. </strong></p></td>
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