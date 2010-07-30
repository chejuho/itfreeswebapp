<%@ page language="java" contentType="text/html; charset=euc-kr"
    pageEncoding="euc-kr"%>
<%@ page import="common.util.EnDecoding"%>
<%@ page import="bean.MemberBean"%>
<%
  request.setCharacterEncoding("euc-kr");
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>캉코쿠진닷컴</title>
<meta http-equiv="Content-type" content="text/html; charset=euc-kr">
<script language="javascript" src="./include/js/mypot.js"></script>
<script language="javascript" src="/Share/Function.js"></script>
<script type="text/javascript">
<!--
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
	function logout() {
		
		alert("이용해주셔서 감사합니다");
    	location.href="/index.jsp"			
	}
	
//-->
</script>
<script src="Scripts/AC_RunActiveContent.js" type="text/javascript"></script>
<link href="include/css/kankokujin.css" rel="stylesheet" type="text/css">
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
	
		<table border="0" cellpadding="0" cellspacing="0" width="950" height="90">
	  <tr>
			<td><table width="950" border="0" cellspacing="0" cellpadding="0" bgcolor="e3dacb">
              <tr>
                <td width="423"><img src="images/main/img_topline_left.gif" width="4" height="4"></td>
                <td width="104"><img src="images/common/space.gif" width="1" height="1"></td>
                <td width="423"><div align="right"><img src="images/main/img_topline_right.gif" width="4" height="4"></div></td>
              </tr>
            </table></td>
	  </tr>
	  <tr>
	    <td><img src="images/common/space.gif" alt="" width="1" height="5"></td>
	    </tr>
		<tr valign="top">
			<td height="15" align="right">
			
			  <table border="0" cellpadding="0" cellspacing="0">
				<tr valign="top">
					<td><!--img src="./images/main/img_flash.gif"-->
				      <a href="#"><img src="images/common/util_menu01.gif" width="34" height="10"></a><img src="images/common/util_slide.gif" width="15" height="10"><a href="#"><img src="images/common/util_menu02.gif" width="20" height="10"></a><img src="images/common/util_slide.gif" alt="" width="15" height="10"><a href="#"><img src="images/common/util_menu03.gif" width="19" height="10"></a><img src="images/common/util_slide.gif" alt="" width="15" height="10"><a href="#"><img src="images/common/util_menu04.gif" width="41" height="10"></a><img src="images/common/util_slide.gif" alt="" width="15" height="10"><a href="#"><img src="images/common/util_menu05.gif" width="62" height="10"></a></td>
			  </tr>
			</table>			</td>
		</tr>
		<tr valign="top">
		  <td><a href="#"><img src="images/common/logo.gif" width="207" height="30"></a></td>
		  </tr>
		<tr valign="top">
		  <td><table width="950" border="0" cellpadding="0" cellspacing="0" background="images/common/top_bg.gif">
            <tr>
              <td width="207"><img src="images/common/top_banner.gif" width="207" height="54"></td>
              <td width="547"><table width="439" border="0" align="center" cellpadding="0" cellspacing="0">
                  <tr>
                    <td width="71"><a href="#"><img src="images/common/top_menu01.gif" alt="" width="71" height="23"></a></td>
                    <td width="21"><img src="images/common/top_menu_slide.gif" width="21" height="23"></td>
                    <td width="71"><a href="#"><img src="images/common/top_menu02.gif" alt="" width="71" height="23"></a></td>
                    <td width="21"><img src="images/common/top_menu_slide.gif" alt="" width="21" height="23"></td>
                    <td width="71"><a href="#"><img src="images/common/top_menu03.gif" alt="" width="71" height="23"></a></td>
                    <td width="21"><img src="images/common/top_menu_slide.gif" alt="" width="21" height="23"></td>
                    <td width="71"><a href="#"><img src="images/common/top_menu04.gif" alt="" width="71" height="23"></a></td>
                    <td width="21"><img src="images/common/top_menu_slide.gif" alt="" width="21" height="23"></td>
                    <td width="71"><a href="#"><img src="images/common/top_menu05.gif" alt="" width="71" height="23"></a></td>
                  </tr>
              </table></td>
              <td width="196"><img src="images/common/top_search.gif" width="196" height="54"></td>
            </tr>
          </table></td>
		  </tr>
		<tr valign="top">
		  <td><img src="images/common/space.gif" alt="" width="1" height="15"></td>
		  </tr>
		</table>	</td>
</tr>
<!----- top메뉴 ------>


<!----- 콘텐츠 영역 ----->
<tr>
	
	<!-- 좌측메뉴 -->
	<td width="197" valign="top">
	
		<table width="197" height="145" border="0" cellpadding="0" cellspacing="0">
		</table>
        <table width="197" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td><img src="images/common/img_userbox_top.gif"></td>
          </tr>
          <tr>
            <td background="images/common/img_userbox_bg.gif"><table width="173" border="0" align="center" cellpadding="0" cellspacing="0">
                <tr style="padding-top:9">
                  <td>&nbsp;</td>
                  <td width="167" class="text_11 style="padding-left:5"">
                  <%
                  	  MemberBean member = (MemberBean) session.getAttribute("member"); 
	                  String userid = EnDecoding.kordecoding(member.getUserid());
	              %><font class="text_c4"><b><%= userid %></b>님
                  
                  기분좋은 하루 되세요.</font></td>
              </tr>
              <tr>
                <td height="23">&nbsp;</td>
                <td align="center" valign="top"><img src="images/common/btn_logout.gif" width="52" height="17" onclick="logout()"></td>
              </tr>
                
                <tr>
                  <td colspan="3"><table width="173" border="0" cellspacing="0" cellpadding="0">
                      <tr>
                        <td width="26"><a href="/jsp"><img src="images/common/img_userbox_join.gif" alt="" width="60" height="20"></a></td>
                        <td width="147"><a href="#"><img src="images/common/img_userbox_search.gif" width="110" height="21"></a></td>
                      </tr>
                  </table></td>
                </tr>
            </table></td>
          </tr>
          <tr>
            <td><img src="images/common/img_userbox_bottom.gif" alt="" width="197" height="16"></td>
          </tr>
        </table>
        <table border="0" cellpadding="0" cellspacing="0" width="197" height="20">
          <tr valign="top">
            <td><img src="images/common/space.gif" alt="" width="1" height="12"></td>
          </tr>
          <tr valign="top">
            <td><table border="0" cellpadding="0" cellspacing="0" width="188">
                <tr valign="top">
                  <td><img src="images/main/img_left_quick.gif" width="197" height="28"></td>
                </tr>
                <tr>
                  <td background="images/main/img_left_quick_bg.gif"><table border="0" cellpadding="0" cellspacing="0" width="197" height="20">
                    <tr>
                      <td width="10" class="text_11" style="padding-top:3"><p>&nbsp;</p></td>
                      <td width="187" class="text_11" style="padding-top:3"><strong>· <a href="#">기숙사구하기 </a></strong><a href="#"><span class="style1">(57910)</span></a><span class="style1"></span><strong> <br>
  · <a href="#">원룸내놓기</a></strong><a href="#"><span class="style1"> (40013)</span></a><span class="style1"></span><strong> <br>
                        · <a href="#">쉐어룸구하기 </a></strong><a href="#"><span class="style1">(19516)</span></a><span class="style1"></span><strong> <br>
                        · <a href="#">홈스테이 </a></strong><a href="#"><span class="style1">(11815)</span></a><span class="style1"></span><strong> <br>
                        · <a href="#">게스트하우스 </a></strong><a href="#"><span class="style1">(25274)</span></a></td>
                    </tr>
                  </table></td>
                </tr>
                <tr>
                  <td><img src="images/main/img_left_quick_bottom.gif" width="197" height="8"></td>
                </tr>
            </table></td>
          </tr>
        </table>
    <table border="0" cellpadding="0" cellspacing="0" width="197" height="20">
          <tr valign="top">
            <td></td>
          </tr>
          <tr valign="top">
            <td></td>
          </tr>
          <tr valign="top">
            <td></td>
          </tr>
          <tr valign="top">
            <td></td>
          </tr>
          <tr valign="top">
            <td></td>
          </tr>
          <tr valign="top">
            <td></td>
          </tr>
          <tr valign="top">
            <td></td>
          </tr>
          <tr valign="top">
            <td><img src="images/common/space.gif" alt="" width="1" height="10"></td>
        </tr>
          <tr valign="top">
            <td><table border="0" cellpadding="0" cellspacing="0" width="188">
              <tr valign="top">
                <td><img src="images/main/img_notice_title.gif" alt="" width="197" height="18"></td>
              </tr>
              <tr>
                <td><table border="0" cellpadding="0" cellspacing="0" width="197" height="20">
                    <tr>
                      <td width="10" class="text_11" style="padding-top:3"><p>&nbsp;</p></td>
                      <td width="187" class="text_11" style="padding-top:3">· <span class="text01"><a href="#">캉코쿠진 닷컴 공지사항입니다.</a><br>
                        · <a href="#">캉코쿠진 닷컴 공지사항입니다.</a><br>
                        · <a href="#">캉코쿠진 닷컴 공지사항입니다.</a></span><br>
                        · <span class="text01"><a href="#">캉코쿠진 닷컴 공지사항입니다.</a></span></td>
                    </tr>
                </table></td>
              </tr>
            </table></td>
          </tr>
        </table>
        <table border="0" cellpadding="0" cellspacing="0" width="197" height="20">
          <tr valign="top">
            <td></td>
          </tr>
          <tr valign="top">
            <td></td>
          </tr>
          <tr valign="top">
            <td></td>
          </tr>
          <tr valign="top">
            <td></td>
          </tr>
          <tr valign="top">
            <td></td>
          </tr>
          <tr valign="top">
            <td></td>
          </tr>
          <tr valign="top">
            <td></td>
          </tr>
          <tr valign="top">
            <td><img src="images/common/space.gif" alt="" width="1" height="10"></td>
          </tr>
          <tr valign="top">
            <td><table border="0" cellpadding="0" cellspacing="0" width="188">
              <tr valign="top">
                <td><img src="images/main/img_left_room.gif" width="197" height="31"></td>
              </tr>
              <tr>
                <td background="images/main/img_left_room_bg.gif"><table border="0" cellpadding="0" cellspacing="0" width="197" height="20">
                
                  <tr>
                    <td style="padding-top:3"><p><img src="images/common/space.gif" alt="" width="1" height="1"></p></td>
                    <td style="padding-top:3"><img src="images/common/space.gif" alt="" width="1" height="1"></td>
                    <td class="text_profile" style="padding-top:3"><p><img src="images/common/space.gif" alt="" width="1" height="1"></p></td>
                  </tr>
                  <tr>
                    <td style="padding-top:3"><p>&nbsp;</p></td>
                    <td style="padding-top:3"><img src="images/main/img_left_room_photo.gif" alt="" width="44" height="44"></td>
                    <td class="text_profile" style="padding-top:3"><p><a href="#" align="left">룸메이트 구합니다! <br>
                      여학생 한정! 3만엔!<br>
                      (수도,전기,가스요금 포함)</a></p></td>
                  </tr>
                  <tr>
                    <td style="padding-top:3"><p><img src="images/common/space.gif" alt="" width="1" height="1"></p></td>
                    <td style="padding-top:3"><img src="images/common/space.gif" alt="" width="1" height="1"></td>
                    <td class="text_profile" style="padding-top:3"><p><img src="images/common/space.gif" alt="" width="1" height="1"></p></td>
                  </tr>
                    <tr>
                      <td width="14" style="padding-top:3"><p>&nbsp;</p></td>
                      <td width="49" style="padding-top:3"><img src="images/main/img_left_room_photo.gif" width="44" height="44"></td>
                      <td width="134" class="text_profile" style="padding-top:3"><p><a href="#" align="left">룸메이트 구합니다! <br>
                        여학생 한정! 3만엔!<br>
                      (수도,전기,가스요금 포함)</a></p></td>
                    </tr>                    
                  <tr>
                    <td style="padding-top:3"><p><img src="images/common/space.gif" alt="" width="1" height="1"></p></td>
                    <td style="padding-top:3"><img src="images/common/space.gif" alt="" width="1" height="1"></td>
                    <td class="text_profile" style="padding-top:3"><p><img src="images/common/space.gif" alt="" width="1" height="1"></p></td>
                  </tr>
                </table></td>
              </tr>
              <tr>
                <td><img src="images/main/img_left_room01.gif" width="197" height="6"></td>
              </tr>
            </table></td>
          </tr>
        </table>
        <table border="0" cellpadding="0" cellspacing="0" width="197" height="20">
          <tr valign="top">
            <td><table border="0" cellpadding="0" cellspacing="0" width="197" height="20">
                <tr valign="top">
                  <td></td>
                </tr>
                <tr valign="top">
                  <td></td>
                </tr>
                <tr valign="top">
                  <td></td>
                </tr>
                <tr valign="top">
                  <td></td>
                </tr>
                <tr valign="top">
                  <td></td>
                </tr>
                <tr valign="top">
                  <td></td>
                </tr>
                <tr valign="top">
                  <td></td>
                </tr>
                <tr valign="top">
                  <td><img src="images/common/space.gif" alt="" width="1" height="5"></td>
              </tr>
                <tr valign="top">
                  <td><img src="images/common/Untitled-21.gif" width="197" height="125"></td>
                </tr>
            </table></td>
          </tr>
        </table>
        </td>
	<!-- 좌측메뉴 -->


	<!-- 콘텐츠간 간격 -->
	<td width="10">&nbsp;</td>
	<!-- 콘텐츠간 간격 -->


	<!-- 메인 콘텐츠 -->
	<td valign="top"><table border="0" cellpadding="0" cellspacing="0" width="547">
      <tr valign="top">
        <!-- Main Flash 547x139-->
        <td><img src="images/main/img_center_banner.gif" alt="" width="547" height="139"></td>
        <!-- Main Flash -->
      </tr>
    </table>
	  <table border="0" cellpadding="0" cellspacing="0" width="547">
        <tr valign="top">
          <!-- Main Flash 420x370-->
          <td><img src="images/common/space.gif" alt="" width="1" height="12"></td>
          <!-- Main Flash -->
        </tr>
        <tr valign="top">
          <td><table width="547" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td><table width="547" border="0" cellspacing="0" cellpadding="0">
                    <tr>
                      <td width="85"><img src="images/main/img_center_new_title.gif" width="132" height="22"></td>
                      <td width="462"><div align="right"><a href="#"><img src="images/main/img_center_more.gif" width="42" height="22"></a></div></td>
                    </tr>
                </table></td>
              </tr>
              <tr>
                <td><img src="images/main/img_center_boxtop.gif" width="547" height="9"></td>
              </tr>
              <tr>
                <td background="images/main/img_center_boxtop_bg.gif"><img src="images/common/space.gif" alt="" width="1" height="5"></td>
              </tr>
              <tr>
                <td background="images/main/img_center_boxtop_bg.gif"><table width="480" border="0" align="center" cellpadding="0" cellspacing="0">
                    <tr>
                      <td width="100"><table width="104" border="0" cellspacing="0" cellpadding="0">
                          <tr>
                            <td><table width="104" height="89" border="0" cellpadding="0" cellspacing="0" bgcolor="#E3E3E3">
                                <tr>
                                  <td><table width="102" height="87" border="0" align="center" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF">
                                      <tr>
                                        <td><table width="94" height="79" border="0" align="center" cellpadding="0" cellspacing="0">
                                            <tr>
                                              <td><img src="images/main/img_center_img01.gif" width="94" height="79"></td>
                                            </tr>
                                        </table></td>
                                      </tr>
                                  </table></td>
                                </tr>
                            </table></td>
                          </tr>
                          <tr>
                            <td><img src="images/common/space.gif" alt="" width="1" height="5"></td>
                          </tr>
                          <tr>
                            <td><p align="center" class="style3"><span class="style1"><strong><a href="#">34千円</a></strong></span><a href="#"><br>
                              홈스테이<br>
                              임대</a></p></td>
                          </tr>
                      </table></td>
                      <td width="10"><img src="images/common/space.gif" alt="" width="25" height="10"></td>
                      <td width="100"><table width="104" border="0" cellspacing="0" cellpadding="0">
                          <tr>
                            <td><table width="104" height="89" border="0" cellpadding="0" cellspacing="0" bgcolor="#E3E3E3">
                                <tr>
                                  <td><table width="102" height="87" border="0" align="center" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF">
                                      <tr>
                                        <td><table width="94" height="79" border="0" align="center" cellpadding="0" cellspacing="0">
                                            <tr>
                                              <td><img src="images/main/img_center_img02.gif" width="94" height="79"></td>
                                            </tr>
                                        </table></td>
                                      </tr>
                                  </table></td>
                                </tr>
                            </table></td>
                          </tr>
                          <tr>
                            <td><img src="images/common/space.gif" alt="" width="1" height="5"></td>
                          </tr>
                          <tr>
                            <td><p align="center" class="style3"><span class="style1"><strong><a href="#">34千円</a></strong></span><a href="#"><br>
                              홈스테이<br>
                              임대</a></p></td>
                          </tr>
                      </table></td>
                      <td width="10"><img src="images/common/space.gif" alt="" width="25" height="10"></td>
                      <td width="100"><table width="104" border="0" cellspacing="0" cellpadding="0">
                          <tr>
                            <td><table width="104" height="89" border="0" cellpadding="0" cellspacing="0" bgcolor="#E3E3E3">
                                <tr>
                                  <td><table width="102" height="87" border="0" align="center" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF">
                                      <tr>
                                        <td><table width="94" height="79" border="0" align="center" cellpadding="0" cellspacing="0">
                                            <tr>
                                              <td><img src="images/main/img_center_img01.gif" width="94" height="79"></td>
                                            </tr>
                                        </table></td>
                                      </tr>
                                  </table></td>
                                </tr>
                            </table></td>
                          </tr>
                          <tr>
                            <td><img src="images/common/space.gif" alt="" width="1" height="5"></td>
                          </tr>
                          <tr>
                            <td><p align="center" class="style3"><span class="style1"><strong><a href="#">34千円</a></strong></span><a href="#"><br>
                              홈스테이<br>
                              임대</a></p></td>
                          </tr>
                      </table></td>
                      <td width="10"><img src="images/common/space.gif" alt="" width="25" height="10"></td>
                      <td width="170"><table width="104" border="0" cellspacing="0" cellpadding="0">
                          <tr>
                            <td><table width="104" height="89" border="0" cellpadding="0" cellspacing="0" bgcolor="#E3E3E3">
                                <tr>
                                  <td><table width="102" height="87" border="0" align="center" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF">
                                      <tr>
                                        <td><table width="94" height="79" border="0" align="center" cellpadding="0" cellspacing="0">
                                            <tr>
                                              <td><img src="images/main/img_center_img02.gif" width="94" height="79"></td>
                                            </tr>
                                        </table></td>
                                      </tr>
                                  </table></td>
                                </tr>
                            </table></td>
                          </tr>
                          <tr>
                            <td><img src="images/common/space.gif" alt="" width="1" height="5"></td>
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
                <td><img src="images/main/img_center_boxbottom.gif" width="547" height="9"></td>
              </tr>
          </table></td>
        </tr>
      </table>
	  <table border="0" cellpadding="0" cellspacing="0" width="547">
        <tr valign="top">
          <!-- Main Flash 420x370-->
          <td><img src="images/common/space.gif" alt="" width="1" height="12"></td>
          <!-- Main Flash -->
        </tr>
        <tr valign="top">
          <td><table width="547" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td><table width="547" border="0" cellspacing="0" cellpadding="0">
                    <tr>
                      <td width="85"><img src="images/main/img_center_hot_title.gif" width="132" height="22"></td>
                      <td width="462"><div align="right"><a href="#"><img src="images/main/img_center_more.gif" width="42" height="22"></a></div></td>
                    </tr>
                </table></td>
              </tr>
              <tr>
                <td><img src="images/main/img_center_boxtop.gif" width="547" height="9"></td>
              </tr>
              <tr>
                <td background="images/main/img_center_boxtop_bg.gif"><img src="images/common/space.gif" alt="" width="1" height="5"></td>
              </tr>
              <tr>
                <td background="images/main/img_center_boxtop_bg.gif"><table width="480" border="0" align="center" cellpadding="0" cellspacing="0">
                    <tr>
                      <td width="100"><table width="104" border="0" cellspacing="0" cellpadding="0">
                          <tr>
                            <td><table width="104" height="89" border="0" cellpadding="0" cellspacing="0" bgcolor="#E3E3E3">
                                <tr>
                                  <td><table width="102" height="87" border="0" align="center" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF">
                                      <tr>
                                        <td><table width="94" height="79" border="0" align="center" cellpadding="0" cellspacing="0">
                                            <tr>
                                              <td><img src="images/main/img_center_img03.gif" width="94" height="79"></td>
                                            </tr>
                                        </table></td>
                                      </tr>
                                  </table></td>
                                </tr>
                            </table></td>
                          </tr>
                          <tr>
                            <td><img src="images/common/space.gif" alt="" width="1" height="5"></td>
                          </tr>
                          <tr>
                            <td><p align="center" class="style3"><span class="style1"><strong><a href="#">34千円</a></strong></span><a href="#"><br>
                              홈스테이<br>
                              임대</a></p></td>
                          </tr>
                      </table></td>
                      <td width="10"><img src="images/common/space.gif" alt="" width="25" height="10"></td>
                      <td width="100"><table width="104" border="0" cellspacing="0" cellpadding="0">
                          <tr>
                            <td><table width="104" height="89" border="0" cellpadding="0" cellspacing="0" bgcolor="#E3E3E3">
                                <tr>
                                  <td><table width="102" height="87" border="0" align="center" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF">
                                      <tr>
                                        <td><table width="94" height="79" border="0" align="center" cellpadding="0" cellspacing="0">
                                            <tr>
                                              <td><img src="images/main/img_center_img04.gif" width="94" height="79"></td>
                                            </tr>
                                        </table></td>
                                      </tr>
                                  </table></td>
                                </tr>
                            </table></td>
                          </tr>
                          <tr>
                            <td><img src="images/common/space.gif" alt="" width="1" height="5"></td>
                          </tr>
                          <tr>
                            <td><p align="center" class="style3"><span class="style1"><strong><a href="#">34千円</a></strong></span><a href="#"><br>
                              홈스테이<br>
                              임대</a></p></td>
                          </tr>
                      </table></td>
                      <td width="10"><img src="images/common/space.gif" alt="" width="25" height="10"></td>
                      <td width="100"><table width="104" border="0" cellspacing="0" cellpadding="0">
                          <tr>
                            <td><table width="104" height="89" border="0" cellpadding="0" cellspacing="0" bgcolor="#E3E3E3">
                                <tr>
                                  <td><table width="102" height="87" border="0" align="center" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF">
                                      <tr>
                                        <td><table width="94" height="79" border="0" align="center" cellpadding="0" cellspacing="0">
                                            <tr>
                                              <td><img src="images/main/img_center_img03.gif" width="94" height="79"></td>
                                            </tr>
                                        </table></td>
                                      </tr>
                                  </table></td>
                                </tr>
                            </table></td>
                          </tr>
                          <tr>
                            <td><img src="images/common/space.gif" alt="" width="1" height="5"></td>
                          </tr>
                          <tr>
                            <td><p align="center" class="style3"><span class="style1"><strong><a href="#">34千円</a></strong></span><a href="#"><br>
                              홈스테이<br>
                              임대</a></p></td>
                          </tr>
                      </table></td>
                      <td width="10"><img src="images/common/space.gif" alt="" width="25" height="10"></td>
                      <td width="170"><table width="104" border="0" cellspacing="0" cellpadding="0">
                          <tr>
                            <td><table width="104" height="89" border="0" cellpadding="0" cellspacing="0" bgcolor="#E3E3E3">
                                <tr>
                                  <td><table width="102" height="87" border="0" align="center" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF">
                                      <tr>
                                        <td><table width="94" height="79" border="0" align="center" cellpadding="0" cellspacing="0">
                                            <tr>
                                              <td><img src="images/main/img_center_img04.gif" width="94" height="79"></td>
                                            </tr>
                                        </table></td>
                                      </tr>
                                  </table></td>
                                </tr>
                            </table></td>
                          </tr>
                          <tr>
                            <td><img src="images/common/space.gif" alt="" width="1" height="5"></td>
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
                <td background="images/main/img_center_boxtop_bg.gif"><table width="520" border="0" align="center" cellpadding="0" cellspacing="0">
                  <tr>
                    <td><img src="images/common/space.gif" alt="" width="1" height="5"></td>
                  </tr>
                  <tr>
                    <td height="55" background="images/main/img_center_hot_bg01.gif"><table width="520" border="0" cellspacing="0" cellpadding="0">
                      <tr>
                        <td width="21">&nbsp;</td>
                        <td width="499"><a href="#" class="style3">미나미센쥬 룸메이트 모집! 여학생 한정! 6만엔! (수도,전기,가스요금 포함) <br>
주식회사 액트넷株式社アクトネットTEL : 03-5759-5812</a></td>
                      </tr>
                    </table>                      <span class="style3"><a href="#"></a></span></td>
                  </tr>
                  <tr>
                    <td height="55" background="images/main/img_center_hot_bg02.gif"><table width="520" border="0" cellspacing="0" cellpadding="0">
                        <tr>
                          <td width="21">&nbsp;</td>
                          <td width="499"><a href="#" class="style3">미나미센쥬 룸메이트 모집! 여학생 한정! 6만엔! (수도,전기,가스요금 포함) <br>
                            주식회사 액트넷株式社アクトネットTEL : 03-5759-5812</a></td>
                        </tr>
                      </table>
                        <span class="style3"><a href="#"></a></span></td>
                  </tr>
                  <tr>
                    <td height="55" background="images/main/img_center_hot_bg01.gif"><table width="520" border="0" cellspacing="0" cellpadding="0">
                        <tr>
                          <td width="21">&nbsp;</td>
                          <td width="499"><a href="#" class="style3">미나미센쥬 룸메이트 모집! 여학생 한정! 6만엔! (수도,전기,가스요금 포함) <br>
                            주식회사 액트넷株式社アクトネットTEL : 03-5759-5812</a></td>
                        </tr>
                      </table>
                        <span class="style3"><a href="#"></a></span></td>
                  </tr>
                  <tr>
                    <td><img src="images/common/space.gif" alt="" width="1" height="5"></td>
                  </tr>
                </table></td>
              </tr>
              
              <tr>
                <td><img src="images/main/img_center_boxbottom.gif" width="547" height="9"></td>
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

		<!-- 포토플레이어 -->
		<table width="186" height="30" border="0" cellpadding="0" cellspacing="0">
		  <tr valign="top">
            <td><img src="images/main/img_right_topbanner.gif" width="186" height="139"></td>
	      </tr>
		</table>
        <table width="186" height="30" border="0" cellpadding="0" cellspacing="0">
          <tr valign="top">
            <td><img src="images/common/space.gif" alt="" width="1" height="12"></td>
          </tr>
          <tr valign="top">
            <td><img src="images/main/img_right_banner.gif" width="186" height="97"></td>
          </tr>
        </table>
        <table width="186" height="30" border="0" cellpadding="0" cellspacing="0">
          <tr valign="top">
            <td><img src="images/common/space.gif" alt="" width="1" height="12"></td>
          </tr>
          <tr valign="top">
            <td><img src="images/main/img_right_smallbanner.gif" width="186" height="158"></td>
          </tr>
        </table>
        <table width="186" height="30" border="0" cellpadding="0" cellspacing="0">
          <tr valign="top">
            <td><img src="images/common/space.gif" alt="" width="1" height="12"></td>
          </tr>
          <tr valign="top">
            <td><table border="0" cellpadding="0" cellspacing="0" width="186">
              <tr valign="top">
                <td><img src="images/main/img_right_moneytitle.gif" width="186" height="30"></td>
              </tr>
              <tr>
                <td background="images/main/img_right_moneybg.gif"><table border="0" cellpadding="0" cellspacing="0" width="186" height="20">
                  <tr>
                    <td class="text_11" style="padding-top:3"><p><img src="images/common/space.gif" alt="" width="1" height="5"></p></td>
                    <td class="text_11" style="padding-top:3"><img src="images/common/space.gif" alt="" width="1" height="5"></td>
                  </tr>
                  <tr>
                    <td width="10" class="text_11" style="padding-top:3"><p>&nbsp;</p></td>
                    <td class="text_11" style="padding-top:3">100엔 ⇒ 891.8 원<br>
                      1원 ⇒ 0.11213 엔 <br>
                      ※2008년02월25일15시01분 환율 <br>
                      이 환율은 '우리은행'의 한국에서 <br>
                      일본으로 송금하는 경우를 참고. </td>
                  </tr>
                </table>
                  <table border="0" cellpadding="0" cellspacing="0" width="186" height="20">
                    <tr valign="top">
                      <td></td>
                    </tr>
                    <tr valign="top">
                      <td></td>
                    </tr>
                    <tr valign="top">
                      <td></td>
                    </tr>
                    <tr valign="top">
                      <td></td>
                    </tr>
                    <tr valign="top">
                      <td></td>
                    </tr>
                    <tr valign="top">
                      <td></td>
                    </tr>
                    <tr valign="top">
                      <td></td>
                    </tr>
                    <tr valign="top">
                      <td><img src="images/common/space.gif" alt="" width="1" height="13"></td>
                    </tr>
                    <tr valign="top">
                      <td><table border="0" cellpadding="0" cellspacing="0" width="186">
                          <tr valign="top">
                            <td><img src="images/main/img_right_communitytitle.gif" alt="" width="186" height="19"></td>
                          </tr>
                          <tr>
                            <td><table border="0" cellpadding="0" cellspacing="0" width="186" height="78">
                              <tr>
                                <td height="73" class="text_11" style="padding-top:3"><p>&nbsp;</p></td>
                                <td class="text_11" style="padding-top:3">· <span class="text01"><a href="#">캉코쿠진 닷컴 공지사항입니다.</a><br>
                                  · <a href="#">캉코쿠진 닷컴 공지사항입니다.</a><br>
                                  · <a href="#">캉코쿠진 닷컴 공지사항입니다.</a></span><br>
                                  · <span class="text01"><a href="#">캉코쿠진 닷컴 공지사항입니다.</a></span></td>
                              </tr>
                                <tr>
                                  <td width="10" height="5"><img src="images/common/space.gif" alt="" width="1" height="5"></td>
                                  <td><img src="images/common/space.gif" alt="" width="1" height="5"></td>
                                </tr>
                            </table></td>
                          </tr>
                      </table></td>
                    </tr>
                  </table></td>
              </tr>
              <tr>
                <td><img src="images/main/img_right_moneybottom.gif" width="186" height="6"></td>
              </tr>
            </table></td>
          </tr>
        </table>
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
	
		<table border="0" cellpadding="0" cellspacing="0" width="950">
	  <tr valign="top">
			<td><img src="images/common/img_footer.gif" width="950" height="33"></td>
		  </tr>
		</table>	</td>
</tr>
<!----- Footer 영역 ----->
</table>
</body>

</html>
