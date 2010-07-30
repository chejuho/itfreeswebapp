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


	<!-- 메인 바디 -->
	<td valign="top">
	
<table border="0" cellpadding="0" cellspacing="0" width="740">
      <!---- Location ---->
      <tr height="30">
        <td align="right" class="text_11">
          Home > <b>방구하기</b></td>
      </tr>
      <!---- Location ---->
      <tr valign="top">
        <td><table border="0" cellpadding="0" cellspacing="0" width="743" height="20">
          <tr>
            <td><img src="../images/02roomfind/img_title.gif" width="743" height="29"></td>
          </tr>
        </table></td>
      </tr>
      <tr>
        <td align="center">
          </td>
      </tr>
    </table>
	  <table border="0" cellpadding="0" cellspacing="0" width="743">
        <tr valign="top">
          <td style="padding:20 30"><!-- 읽기 폼 -->
              <table border="0" cellpadding="0" cellspacing="0" width="680">
                <col>
                <col width="473" style="padding:9 0 0 18">
                <col>
                <col align="center" width="92" style="padding-top:9">
                <col>
                <tr valign="top">
                  <td><img src="../images/gallery/img_write_sub.gif"></td>
                  <td background="../images/gallery/bg_borad_tit.gif" class="text_nw"><b>어느덧 겨울이 코앞으로 다가왔네요.</b></td>
                  <td><img src="../images/gallery/img_write_hit.gif"></td>
                  <td background="../images/gallery/bg_borad_tit.gif" class="text_nw">15</td>
                  <td><img src="../images/gallery/img_board_right.gif"></td>
                </tr>
                <tr valign="top">
                  <td colspan="8" style="padding:15 30"> 어느덧 겨울이 코앞으로 다가왔네요<br>
                    어느덧 겨울이 코앞으로 다가왔네요<br>
                    어느덧 겨울이 코앞으로 다가왔네요<br>
                    어느덧 겨울이 코앞으로 다가왔네요<br>                  </td>
                </tr>
                <tr height="1" bgcolor="#ECEAE3">
                  <td colspan="8"></td>
                </tr>
                <tr height="30">
                  <td align="right" class="text_11" colspan="8" style="padding:4 14 0 0">등록일 : 2004-12-16&nbsp;12:00</td>
                </tr>
                <tr height="2" bgcolor="#E2E0D6">
                  <td colspan="8"></td>
                </tr>
                <tr style="padding-top:10">
                  <td colspan="8" align="right"><a href="roomFindList.jsp"><img src="../images/common/btn_gp_list.gif"></a></td>
                </tr>
              </table>
            <!-- 읽기 폼 -->          </td>
        </tr>
      </table>
	
    </td>
	<!-- 메인 바디 -->


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