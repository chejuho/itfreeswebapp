<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ page import="common.util.Util"%>
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
<%	}%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>캉코쿠진닷컴</title>
<meta http-equiv="Content-type" content="text/html; charset=UTF-8">
<script type="text/javascript">
<!--
	function start_index() {
		//window.location.href="http://www.yahoo.co.jp";
		window.location.href="StoreSearch";
	}
	function loginform_clearbg(type) {
		if (type == "id") {
			document.loginform.id.style.backgroundImage = '';
		} else if (type == "pw") {
			document.loginform.pw.style.backgroundImage = '';
		}
	}
	function loginform_bgChange(obj, act) {
		if ( act == 'F') {
			obj.className = 'login';
			obj.style.backgroundColor='#B6B6B6';
		} else {
			obj.className = 'login';
			obj.style.backgroundColor='#B6B6B6';	
		}			
	}
//-->
</script>
<link href="jsp/include/css/kankokujin.css" rel="stylesheet" type="text/css">
<style type="text/css">
<!--
.style3 {font-size: 12px}
.text {
	line-height: 8px;
}
-->
</style>
</head>

<body style="margin:0 0 0 0">
<table border="0" cellpadding="0" cellspacing="0" width="950" align="center">



<!----- top메뉴 ------>
<tr valign="top">
	<td colspan="5">
	<jsp:include page="jsp/include/top.jsp" flush="true"/>
			</td>
</tr>
<!----- top메뉴 ------>


<!----- 콘텐츠 영역 ----->
<tr>
<td><img src="images/common/space.gif" alt="" width="1" height="10"></td></tr>
<tr>
	
	<!-- 좌측메뉴 -->
	<td width="197" valign="top">
	<jsp:include page="jsp/include/left.jsp" flush="true"/>
        </td>
	<!-- 좌측메뉴 -->


	<!-- 콘텐츠간 간격 -->
	<td width="10">&nbsp;</td>
	<!-- 콘텐츠간 간격 -->


	<!-- 메인 콘텐츠 -->
	<td valign="top">
	메인 콘텐츠
	<table border="0" cellpadding="0" cellspacing="0" width="547">
      <tr valign="top">
        <!-- Main Flash 547x139-->
        <td><img src="jsp/images/main/img_center_banner.gif" alt="" width="547" height="139"></td>
        <!-- Main Flash -->
      </tr>
    </table>
	  <table border="0" cellpadding="0" cellspacing="0" width="547">
        <tr valign="top">
          <!-- Main Flash 420x370-->
          <td><img src="jsp/images/common/space.gif" alt="" width="1" height="12"></td>
          <!-- Main Flash -->
        </tr>
        <tr valign="top">
          <td><table width="547" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td><table width="547" border="0" cellspacing="0" cellpadding="0">
                    <tr>
                      <td width="85"><img src="jsp/images/main/img_center_new_title.gif" width="132" height="22"></td>
                      <td width="462"><div align="right"><a href="#"><img src="jsp/images/main/img_center_more.gif" width="42" height="22"></a></div></td>
                    </tr>
                </table></td>
              </tr>
              <tr>
                <td><img src="jsp/images/main/img_center_boxtop.gif" width="547" height="9"></td>
              </tr>
              <tr>
                <td background="jsp/images/main/img_center_boxtop_bg.gif"><img src="jsp/images/common/space.gif" alt="" width="1" height="5"></td>
              </tr>
              <tr>
                <td background="jsp/images/main/img_center_boxtop_bg.gif"><table width="480" border="0" align="center" cellpadding="0" cellspacing="0">
                    <tr>
                      <td width="100"><table width="104" border="0" cellspacing="0" cellpadding="0">
                          <tr>
                            <td><table width="104" height="89" border="0" cellpadding="0" cellspacing="0" bgcolor="#E3E3E3">
                                <tr>
                                  <td><table width="102" height="87" border="0" align="center" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF">
                                      <tr>
                                        <td><table width="94" height="79" border="0" align="center" cellpadding="0" cellspacing="0">
                                            <tr>
                                              <td><img src="jsp/images/main/img_center_img01.gif" width="94" height="79"></td>
                                            </tr>
                                        </table></td>
                                      </tr>
                                  </table></td>
                                </tr>
                            </table></td>
                          </tr>
                          <tr>
                            <td><img src="jsp/images/common/space.gif" alt="" width="1" height="5"></td>
                          </tr>
                          <tr>
                            <td><p align="center" class="style3"><span class="style1"><strong><a href="#">34千円</a></strong></span><a href="#"><br>
                              홈스테이<br>
                              임대</a></p></td>
                          </tr>
                      </table></td>
                      <td width="10"><img src="jsp/images/common/space.gif" alt="" width="25" height="10"></td>
                      <td width="100"><table width="104" border="0" cellspacing="0" cellpadding="0">
                          <tr>
                            <td><table width="104" height="89" border="0" cellpadding="0" cellspacing="0" bgcolor="#E3E3E3">
                                <tr>
                                  <td><table width="102" height="87" border="0" align="center" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF">
                                      <tr>
                                        <td><table width="94" height="79" border="0" align="center" cellpadding="0" cellspacing="0">
                                            <tr>
                                              <td><img src="jsp/images/main/img_center_img02.gif" width="94" height="79"></td>
                                            </tr>
                                        </table></td>
                                      </tr>
                                  </table></td>
                                </tr>
                            </table></td>
                          </tr>
                          <tr>
                            <td><img src="jsp/images/common/space.gif" alt="" width="1" height="5"></td>
                          </tr>
                          <tr>
                            <td><p align="center" class="style3"><span class="style1"><strong><a href="#">34千円</a></strong></span><a href="#"><br>
                              홈스테이<br>
                              임대</a></p></td>
                          </tr>
                      </table></td>
                      <td width="10"><img src="jsp/images/common/space.gif" alt="" width="25" height="10"></td>
                      <td width="100"><table width="104" border="0" cellspacing="0" cellpadding="0">
                          <tr>
                            <td><table width="104" height="89" border="0" cellpadding="0" cellspacing="0" bgcolor="#E3E3E3">
                                <tr>
                                  <td><table width="102" height="87" border="0" align="center" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF">
                                      <tr>
                                        <td><table width="94" height="79" border="0" align="center" cellpadding="0" cellspacing="0">
                                            <tr>
                                              <td><img src="jsp/images/main/img_center_img01.gif" width="94" height="79"></td>
                                            </tr>
                                        </table></td>
                                      </tr>
                                  </table></td>
                                </tr>
                            </table></td>
                          </tr>
                          <tr>
                            <td><img src="jsp/images/common/space.gif" alt="" width="1" height="5"></td>
                          </tr>
                          <tr>
                            <td><p align="center" class="style3"><span class="style1"><strong><a href="#">34千円</a></strong></span><a href="#"><br>
                              홈스테이<br>
                              임대</a></p></td>
                          </tr>
                      </table></td>
                      <td width="10"><img src="jsp/images/common/space.gif" alt="" width="25" height="10"></td>
                      <td width="170"><table width="104" border="0" cellspacing="0" cellpadding="0">
                          <tr>
                            <td><table width="104" height="89" border="0" cellpadding="0" cellspacing="0" bgcolor="#E3E3E3">
                                <tr>
                                  <td><table width="102" height="87" border="0" align="center" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF">
                                      <tr>
                                        <td><table width="94" height="79" border="0" align="center" cellpadding="0" cellspacing="0">
                                            <tr>
                                              <td><img src="jsp/images/main/img_center_img02.gif" width="94" height="79"></td>
                                            </tr>
                                        </table></td>
                                      </tr>
                                  </table></td>
                                </tr>
                            </table></td>
                          </tr>
                          <tr>
                            <td><img src="jsp/images/common/space.gif" alt="" width="1" height="5"></td>
                          </tr>
                          <tr>
                            <td><p align="center" class="style3"><span class="style1"><strong><a href="#">34千円</a></strong></span><a href="#"><br>
                              홈스테이<br>
                              임대</a></p></td>
                          </tr>
                      </table></td>
                    </tr>
                </table></td>
              </tr>
              <tr>
                <td><img src="jsp/images/main/img_center_boxbottom.gif" width="547" height="9"></td>
              </tr>
          </table></td>
        </tr>
      </table>
	  <table border="0" cellpadding="0" cellspacing="0" width="547">
        <tr valign="top">
          <!-- Main Flash 420x370-->
          <td><img src="jsp/images/common/space.gif" alt="" width="1" height="12"></td>
          <!-- Main Flash -->
        </tr>
        <tr valign="top">
          <td><table width="547" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td><table width="547" border="0" cellspacing="0" cellpadding="0">
                    <tr>
                      <td width="85"><img src="jsp/images/main/img_center_hot_title.gif" width="132" height="22"></td>
                      <td width="462"><div align="right"><a href="#"><img src="jsp/images/main/img_center_more.gif" width="42" height="22"></a></div></td>
                    </tr>
                </table></td>
              </tr>
              <tr>
                <td><img src="jsp/images/main/img_center_boxtop.gif" width="547" height="9"></td>
              </tr>
              <tr>
                <td background="jsp/images/main/img_center_boxtop_bg.gif"><img src="jsp/images/common/space.gif" alt="" width="1" height="5"></td>
              </tr>
              <tr>
                <td background="jsp/images/main/img_center_boxtop_bg.gif"><table width="480" border="0" align="center" cellpadding="0" cellspacing="0">
                    <tr>
                      <td width="100"><table width="104" border="0" cellspacing="0" cellpadding="0">
                          <tr>
                            <td><table width="104" height="89" border="0" cellpadding="0" cellspacing="0" bgcolor="#E3E3E3">
                                <tr>
                                  <td><table width="102" height="87" border="0" align="center" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF">
                                      <tr>
                                        <td><table width="94" height="79" border="0" align="center" cellpadding="0" cellspacing="0">
                                            <tr>
                                              <td><img src="jsp/images/main/img_center_img03.gif" width="94" height="79"></td>
                                            </tr>
                                        </table></td>
                                      </tr>
                                  </table></td>
                                </tr>
                            </table></td>
                          </tr>
                          <tr>
                            <td><img src="jsp/images/common/space.gif" alt="" width="1" height="5"></td>
                          </tr>
                          <tr>
                            <td><p align="center" class="style3"><span class="style1"><strong><a href="#">34千円</a></strong></span><a href="#"><br>
                              홈스테이<br>
                              임대</a></p></td>
                          </tr>
                      </table></td>
                      <td width="10"><img src="jsp/images/common/space.gif" alt="" width="25" height="10"></td>
                      <td width="100"><table width="104" border="0" cellspacing="0" cellpadding="0">
                          <tr>
                            <td><table width="104" height="89" border="0" cellpadding="0" cellspacing="0" bgcolor="#E3E3E3">
                                <tr>
                                  <td><table width="102" height="87" border="0" align="center" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF">
                                      <tr>
                                        <td><table width="94" height="79" border="0" align="center" cellpadding="0" cellspacing="0">
                                            <tr>
                                              <td><img src="jsp/images/main/img_center_img04.gif" width="94" height="79"></td>
                                            </tr>
                                        </table></td>
                                      </tr>
                                  </table></td>
                                </tr>
                            </table></td>
                          </tr>
                          <tr>
                            <td><img src="jsp/images/common/space.gif" alt="" width="1" height="5"></td>
                          </tr>
                          <tr>
                            <td><p align="center" class="style3"><span class="style1"><strong><a href="#">34千円</a></strong></span><a href="#"><br>
                              홈스테이<br>
                              임대</a></p></td>
                          </tr>
                      </table></td>
                      <td width="10"><img src="jsp/images/common/space.gif" alt="" width="25" height="10"></td>
                      <td width="100"><table width="104" border="0" cellspacing="0" cellpadding="0">
                          <tr>
                            <td><table width="104" height="89" border="0" cellpadding="0" cellspacing="0" bgcolor="#E3E3E3">
                                <tr>
                                  <td><table width="102" height="87" border="0" align="center" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF">
                                      <tr>
                                        <td><table width="94" height="79" border="0" align="center" cellpadding="0" cellspacing="0">
                                            <tr>
                                              <td><img src="jsp/images/main/img_center_img03.gif" width="94" height="79"></td>
                                            </tr>
                                        </table></td>
                                      </tr>
                                  </table></td>
                                </tr>
                            </table></td>
                          </tr>
                          <tr>
                            <td><img src="jsp/images/common/space.gif" alt="" width="1" height="5"></td>
                          </tr>
                          <tr>
                            <td><p align="center" class="style3"><span class="style1"><strong><a href="#">34千円</a></strong></span><a href="#"><br>
                              홈스테이<br>
                              임대</a></p></td>
                          </tr>
                      </table></td>
                      <td width="10"><img src="jsp/images/common/space.gif" alt="" width="25" height="10"></td>
                      <td width="170"><table width="104" border="0" cellspacing="0" cellpadding="0">
                          <tr>
                            <td><table width="104" height="89" border="0" cellpadding="0" cellspacing="0" bgcolor="#E3E3E3">
                                <tr>
                                  <td><table width="102" height="87" border="0" align="center" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF">
                                      <tr>
                                        <td><table width="94" height="79" border="0" align="center" cellpadding="0" cellspacing="0">
                                            <tr>
                                              <td><img src="jsp/images/main/img_center_img04.gif" width="94" height="79"></td>
                                            </tr>
                                        </table></td>
                                      </tr>
                                  </table></td>
                                </tr>
                            </table></td>
                          </tr>
                          <tr>
                            <td><img src="jsp/images/common/space.gif" alt="" width="1" height="5"></td>
                          </tr>
                          <tr>
                            <td><p align="center" class="style3"><span class="style1"><strong><a href="#">34千円</a></strong></span><a href="#"><br>
                              홈스테이<br>
                              임대</a></p></td>
                          </tr>
                      </table></td>
                    </tr>
                </table></td>
              </tr>
              <tr>
                <td background="jsp/images/main/img_center_boxtop_bg.gif"><table width="520" border="0" align="center" cellpadding="0" cellspacing="0">
                  <tr>
                    <td><img src="jsp/images/common/space.gif" alt="" width="1" height="5"></td>
                  </tr>
                  <tr>
                    <td height="55" background="jsp/images/main/img_center_hot_bg01.gif"><table width="520" border="0" cellspacing="0" cellpadding="0">
                      <tr>
                        <td width="21">&nbsp;</td>
                        <td width="499"><a href="#" class="style3">미나미센쥬 룸메이트 모집! 여학생 한정! 6만엔! (수도,전기,가스요금 포함) <br>
주식회사 액트넷株式社アクトネットTEL : 03-5759-5812</a></td>
                      </tr>
                    </table>                      <span class="style3"><a href="#"></a></span></td>
                  </tr>
                  <tr>
                    <td height="55" background="jsp/images/main/img_center_hot_bg02.gif"><table width="520" border="0" cellspacing="0" cellpadding="0">
                        <tr>
                          <td width="21">&nbsp;</td>
                          <td width="499"><a href="#" class="style3">미나미센쥬 룸메이트 모집! 여학생 한정! 6만엔! (수도,전기,가스요금 포함) <br>
                            주식회사 액트넷株式社アクトネットTEL : 03-5759-5812</a></td>
                        </tr>
                      </table>
                        <span class="style3"><a href="#"></a></span></td>
                  </tr>
                  <tr>
                    <td height="55" background="jsp/images/main/img_center_hot_bg01.gif"><table width="520" border="0" cellspacing="0" cellpadding="0">
                        <tr>
                          <td width="21">&nbsp;</td>
                          <td width="499"><a href="#" class="style3">미나미센쥬 룸메이트 모집! 여학생 한정! 6만엔! (수도,전기,가스요금 포함) <br>
                            주식회사 액트넷株式社アクトネットTEL : 03-5759-5812</a></td>
                        </tr>
                      </table>
                        <span class="style3"><a href="#"></a></span></td>
                  </tr>
                  <tr>
                    <td><img src="jsp/images/common/space.gif" alt="" width="1" height="5"></td>
                  </tr>
                </table></td>
              </tr>
              
              <tr>
                <td><img src="jsp/images/main/img_center_boxbottom.gif" width="547" height="9"></td>
              </tr>
          </table></td>
        </tr>
      </table>
    <!----- 전체 공지사항 ----->      <!----- 전체 공지사항 -----></td>
	<!-- 메인 콘텐츠 -->


	<!-- 콘텐츠간 간격 -->
	<td width="10">&nbsp;</td>
	<!-- 콘텐츠간 간격 -->


	<!-- 우측콘텐츠 -->
	
	<td width="186" valign="top">
	<jsp:include page="jsp/include/right.jsp" flush="true"/>
      <!-- 포토플레이어 -->      <!----- 스폐셜 ----->	</td>
	<!-- 우측콘텐츠 -->
</tr>

<!----- 콘텐츠 영역 ----->


<tr height="40">
	<td colspan="5"></td>
</tr>


<!----- Footer 영역 ----->

<tr valign="top">
	<td colspan="5">
		<jsp:include page="jsp/include/footer.jsp" flush="true"/>
</td>
</tr>
<!----- Footer 영역 ----->
</table>
</body>
</html>