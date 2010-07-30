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
	
	<!-- 여기에 실제 메인 바디 소스코딩을 해주세요. -->
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
          <td style="padding:20 30"><!-- 리스트 -->
              <table border="0" cellpadding="0" cellspacing="0" width="680">
                <col width="97" align="center">
                <col width="336">
                <col width="110" align="center">
                <col width="117" align="center">
                <tr valign="top">
                  <td colspan="7"><img src="../images/gallery/img_notice_title.gif"></td>
                </tr>
                <tr height="28">
                  <td>1</td>
                  <td style="padding-left:20"><a href="roomFindDetail.jsp">뿌늉뿌늉이 왔다</a></td>
                  <td>2004-12-13</td>
                  <td>15</td>
                </tr>
                <tr height="1" bgcolor="#ECEAE3">
                  <td colspan="7"></td>
                </tr>
                <tr height="28">
                  <td>1</td>
                  <td style="padding-left:20"><a href="roomFindDetail.jsp">뿌늉뿌늉이 왔다</a></td>
                  <td>2004-12-13</td>
                  <td>15</td>
                </tr>
                <tr height="1" bgcolor="#ECEAE3">
                  <td colspan="7"></td>
                </tr>
                <tr height="28">
                  <td>1</td>
                  <td style="padding-left:20"><a href="roomFindDetail.jsp">뿌늉뿌늉이 왔다</a></td>
                  <td>2004-12-13</td>
                  <td>15</td>
                </tr>
                <tr height="1" bgcolor="#ECEAE3">
                  <td colspan="7"></td>
                </tr>
                <tr height="28">
                  <td>1</td>
                  <td style="padding-left:20"><a href="roomFindDetail.jsp">뿌늉뿌늉이 왔다</a></td>
                  <td>2004-12-13</td>
                  <td>15</td>
                </tr>
                <tr height="1" bgcolor="#ECEAE3">
                  <td colspan="7"></td>
                </tr>
                <tr height="1" bgcolor="#ECEAE3">
                  <td colspan="7"></td>
                </tr>
              </table>
              <table border="0" cellpadding="0" cellspacing="0" width="680" height="10">
                <tr style="padding-top:10">
                  <td align="right"><a href="roomFindWrite.jsp"><img src="../images/common/btn_cs_write.gif"></a></td>
                </tr>
              </table>
            <!-- 리스트 -->
              <!-- Page No-->
              <table border="0" cellpadding="0" cellspacing="0" align="center">
                <tr height="15">
                  <td></td>
                </tr>
                <tr valign="top">
                  <td style="padding-top:1"><img src="../images/common/btn_page_bprev.gif" align="absmiddle"> <img src="../images/common/btn_page_sprev.gif" align="absmiddle"></td>
                  <td class="text_11" style="padding:0 7">1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 | 10</td>
                  <td style="padding-top:1"><img src="../images/common/btn_page_snext.gif" align="absmiddle"> <img src="../images/common/btn_page_bnext.gif" align="absmiddle"></td>
                </tr>
                <tr height="10">
                  <td></td>
                </tr>
              </table>
            <!-- Page No-->
              <!-- 검색창-->
              <table border="0" cellpadding="0" cellspacing="0" width="260" align="center">
                <form name="form01">
                  <tr height="1" bgcolor="#D9D9D9">
                    <td colspan="3"></td>
                  </tr>
                  <tr height="1" bgcolor="#FFFFFF">
                    <td colspan="3"></td>
                  </tr>
                  <tr height="33" bgcolor="#FAF9F5">
                    <td style="padding-left:10"><SELECT NAME="select" class="search">
                        <option>제목</option>
                        <option>내용</option>
                    </SELECT></td>
                    <td align="center"><INPUT TYPE="text" NAME="input2" class="search" style="width:125"></td>
                    <td align="right" style="padding-right:10"><img src="../images/common/btn_gp_search.gif" align="absmiddle"></td>
                  </tr>
                  <tr height="1" bgcolor="#FFFFFF">
                    <td colspan="3"></td>
                  </tr>
                  <tr height="1" bgcolor="#D9D9D9">
                    <td colspan="3"></td>
                  </tr>
                </form>
              </table>
            <!-- 검색창-->          </td>
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