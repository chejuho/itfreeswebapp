<%@ page language="java" contentType="text/html; charset=euc-kr"
    pageEncoding="euc-kr" %>
<%
request.setCharacterEncoding("euc-kr");
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>write.jsp</title>
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
//-->
</script>
<script src="Scripts/AC_RunActiveContent.js" type="text/javascript"></script>
<link href="../include/css/kankokujin.css" rel="stylesheet" type="text/css">
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
	<jsp:include page="../include/top.jsp" flush="true"/>
			</td>
</tr>
<!----- top메뉴 ------>


<!----- 콘텐츠 영역 ----->
<tr>
	
	<!-- 좌측메뉴 -->
	<td width="197" valign="top">
	<jsp:include page="../include/left.jsp" flush="true"/>
        </td>
	<!-- 좌측메뉴 -->


	<!-- 콘텐츠간 간격 -->
	<td width="10">&nbsp;</td>
	<!-- 콘텐츠간 간격 -->


	<!-- 메인 콘텐츠 -->
	<td valign="top">
<table border="0" cellpadding="0" cellspacing="0" width="743">
      <!---- Location ---->
      <tr height="30">
        <td align="right">Home > <b>방구하기</b></td>
      </tr>
      <!---- Location ---->
      <tr>
        <td><!-- QNA -->
            <table border="0" cellpadding="0" cellspacing="0" width="743" height="20">
              <tr>
                <td><img src="../images/02roomfind/img_title.gif" width="743" height="29"></td>
              </tr>
              <tr>
                <td><img src="../images/common/space.gif" alt="" width="1" height="15"></td>
              </tr>
            </table>
            <table width="680" border="1" align="center" cellpadding="0" cellspacing="0" bordercolor="#E2E0D6" frame="void" rules="rows" style="border-collapse:collapse;">
              <col width="121" bgcolor="#F0F0E2">
              <col width="559" style="padding-left:20">
              <tr>
                <td bgcolor="#ffffff" colspan="2"></td>
              </tr>
              <tr height="28">
                <td width="120" height="59" style="padding-left:30"><div align="center" class="style3 style4 style6">
                    <div align="left"><strong>방물건명</strong></div>
                </div></td>
                <td><span class="style3">
                  <input type="text" name="input16" size="20" maxlength="20" class="write">
                  캉코쿠진닷컴 게스트하우스 </span></td>
              </tr>
              <col width="121" bgcolor="#f9f9f9">
              <col width="559" style="padding-left:17">
              <tr height="28">
                <td height="59" style="padding-left:30"><div align="left" class="style7"><span class="style3">야칭</span></div></td>
                <td width="554"><span class="style3">
                  <input type="text" name="input3" size="20" maxlength="20" class="write">
                  &nbsp;천엔 <span class="text_11 style3"><span class="text_11" style="padding:3 0">
                    <input type="checkbox" name="input152">
                    </span> 1개월<span class="text_11" style="padding:3 0">
                      <input type="checkbox" name="input152">
                      </span>1일</span><br>
                  <span class="text_11 style3"> <span class="text_11" style="padding:3 0">
                    <input type="checkbox" name="input5">
                    </span> 공과금 포함 <span class="text_11" style="padding:3 0">
                      <input type="checkbox" name="input6">
                      </span> 시설비</span>0<span class="text_11 style3"><span class="text_11" style="padding:3 0">
                        <input type="checkbox" name="input7">
                        </span> 보증금</span>0<span class="text_11 style3"><span class="text_11" style="padding:3 0">
                          <input type="checkbox" name="input8">
                        </span>입실료</span>0</span></td>
              </tr>
              <tr height="28">
                <td height="72" style="padding-left:30"><div align="center" class="style5">
                    <div align="left">지역</div>
                </div></td>
                <td><span class="style3">
                  <select name="select2" class="date">
                    <option>동경도</option>
                    <option>치바현</option>
                  </select>
                  <select name="select3" class="date">
                    <option>신주쿠구</option>
                    <option>나카노구</option>
                  </select>
                  <span class="text_11" style="padding:3 0">
                  <input type="checkbox" name="input9">
                  </span>오오쿠보 지역 <span class="text_11" style="padding:3 0">
                  <input type="checkbox" name="input10">
                  </span>닛뽀리 지역<br>
                  역으로부터
                  <input type="text" name="input11" size="5" maxlength="5" class="write">
                  분 이내<br>
                </span></td>
              </tr>
              <tr height="28">
                <td height="86" style="padding-left:30"><div align="left" class="style7"><span class="style3">종별</span></div></td>
                <td><span class="style3"><span class="text_11 style3"><span class="text_11" style="padding:3 0">
                  <input type="checkbox" name="input12">
                  </span> 기숙사형 <span class="text_11" style="padding:3 0">
                  <input type="checkbox" name="input12">
                  </span> 원룸형</span><span class="text_11 style3"><span class="text_11" style="padding:3 0">
                  <input type="checkbox" name="input12">
                  </span>맨션형</span><span class="text_11 style3"><span class="text_11" style="padding:3 0">
                  <input type="checkbox" name="input12">
                  </span>룸쉐어<br>
                  <span class="text_11" style="padding:3 0">
                  <input type="checkbox" name="input13">
                  </span> 홈스테이 <span class="text_11" style="padding:3 0">
                  <input type="checkbox" name="input13">
                  </span> 고급기숙사<span class="text_11" style="padding:3 0">
                  <input type="checkbox" name="input13">
                  </span>먼슬리맨션<span class="text_11" style="padding:3 0">
                  <input type="checkbox" name="input13">
                  </span>게스트하우스<br>
                  <span class="text_11" style="padding:3 0">
                  <input type="checkbox" name="input14">
                  </span> 민박 <span class="text_11" style="padding:3 0">
                  <input type="checkbox" name="input14">
                  </span> 비지니스호텔<span class="text_11" style="padding:3 0">
                  <input type="checkbox" name="input14">
                </span>호텔</span></span></td>
              </tr>
              <tr height="28">
                <td style="padding-left:30"><div align="left" class="style7"><span class="style3">성별</span></div></td>
                <td><span class="text_11 style3">
                  <input type="radio" name="" checked>
                  남
                  <input type="radio" name="">
                  여
                  <input type="radio" name="">
                  구분없음 </span></td>
              </tr>
              <tr height="28">
                <td style="padding-left:30"><div align="left" class="style7"><span class="style3">건물종류</span></div></td>
                <td><span class="style3"><span class="text_11 style3">
                  <input type="radio" name="" checked>
                  아파트
                  <input type="radio" name="">
                  맨션</span></span></td>
              </tr>
              <tr height="28">
                <td style="padding-left:30"><div align="left" class="style7"><span class="style3">방타입</span></div></td>
                <td><span class="text_11 style3"><span class="text_11" style="padding:3 0">
                  <input type="checkbox" name="input15">
                  </span> 1인실<span class="text_11" style="padding:3 0">
                  <input type="checkbox" name="input15">
                  </span>2인실<span class="text_11" style="padding:3 0">
                  <input type="checkbox" name="input153">
                </span>다인실</span></td>
              </tr>
              <tr height="28">
                <td height="45" style="padding-left:30"><div align="left" class="style7"><span class="style3">상세설명</span></div></td>
                <td><span class="style3">
                  <textarea name="input162" cols="60" class="write"></textarea>
                </span></td>
              </tr>
              <tr height="28">
                <td style="padding-left:30"><div align="left" class="style7"><span class="style3">사진</span></div></td>
                <td><input type="text" name="input2" size="20" maxlength="20" class="write">
                    </span>&nbsp;<a href="#"><img src="../images/common/btn_searching.gif" alt="" align="absmiddle"></a></span></td>
              </tr>
              <tr>
                <td bgcolor="#ffffff" colspan="2"></td>
              </tr>
            </table>
            <table border="0" cellpadding="0" cellspacing="0" width="680" height="20" align="center">
              <tr style="padding-top:15">
                <td align="right"><a href="roomFindList.jsp"><img src="../images/common/btn_cs_ok.gif"></a>&nbsp;<a href="#"><img src="../images/common/btn_cs_rewrite.gif"></a>&nbsp;<a href="roomFindList.jsp"><img src="../images/common/btn_csnotice_list.gif"></a></td>
              </tr>
            </table>
        </tr>
    </table>
	  <!----- 전체 공지사항 ----->      
	  <!----- 전체 공지사항 ----->
	  <!-- 포토플레이어 -->
      <!-- 포토플레이어 -->      <!----- 스폐셜 ----->	
</td>
	<!-- 메인 콘텐츠 -->


	<!-- 콘텐츠간 간격 -->
	<td width="10">&nbsp;</td>
	<!-- 콘텐츠간 간격 -->


	<!-- 우측콘텐츠 -->
	
	<td width="186" valign="top">
	<jsp:include page="../include/right.jsp" flush="true"/>
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
		<jsp:include page="../include/footer.jsp" flush="true"/>
</td>
</tr>
<!----- Footer 영역 ----->
</table>
</body>
</html>