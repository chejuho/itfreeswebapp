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

<!----- top�޴� ------>
<tr valign="top">
	<td colspan="5">
	<jsp:include page="../include/top.jsp" flush="true"/>
			</td>
</tr>
<!----- top�޴� ------>


<!----- ������ ���� ----->
<tr>
	
	<!-- �����޴� -->
	<td width="197" valign="top">
	<jsp:include page="../include/left.jsp" flush="true"/>
        </td>
	<!-- �����޴� -->


	<!-- �������� ���� -->
	<td width="10">&nbsp;</td>
	<!-- �������� ���� -->


	<!-- ���� ������ -->
	<td valign="top">
<table border="0" cellpadding="0" cellspacing="0" width="743">
      <!---- Location ---->
      <tr height="30">
        <td align="right">Home > <b>�汸�ϱ�</b></td>
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
                    <div align="left"><strong>�湰�Ǹ�</strong></div>
                </div></td>
                <td><span class="style3">
                  <input type="text" name="input16" size="20" maxlength="20" class="write">
                  Ĳ���������� �Խ�Ʈ�Ͽ콺 </span></td>
              </tr>
              <col width="121" bgcolor="#f9f9f9">
              <col width="559" style="padding-left:17">
              <tr height="28">
                <td height="59" style="padding-left:30"><div align="left" class="style7"><span class="style3">��Ī</span></div></td>
                <td width="554"><span class="style3">
                  <input type="text" name="input3" size="20" maxlength="20" class="write">
                  &nbsp;õ�� <span class="text_11 style3"><span class="text_11" style="padding:3 0">
                    <input type="checkbox" name="input152">
                    </span> 1����<span class="text_11" style="padding:3 0">
                      <input type="checkbox" name="input152">
                      </span>1��</span><br>
                  <span class="text_11 style3"> <span class="text_11" style="padding:3 0">
                    <input type="checkbox" name="input5">
                    </span> ������ ���� <span class="text_11" style="padding:3 0">
                      <input type="checkbox" name="input6">
                      </span> �ü���</span>0<span class="text_11 style3"><span class="text_11" style="padding:3 0">
                        <input type="checkbox" name="input7">
                        </span> ������</span>0<span class="text_11 style3"><span class="text_11" style="padding:3 0">
                          <input type="checkbox" name="input8">
                        </span>�ԽǷ�</span>0</span></td>
              </tr>
              <tr height="28">
                <td height="72" style="padding-left:30"><div align="center" class="style5">
                    <div align="left">����</div>
                </div></td>
                <td><span class="style3">
                  <select name="select2" class="date">
                    <option>���浵</option>
                    <option>ġ����</option>
                  </select>
                  <select name="select3" class="date">
                    <option>������</option>
                    <option>��ī�뱸</option>
                  </select>
                  <span class="text_11" style="padding:3 0">
                  <input type="checkbox" name="input9">
                  </span>������ ���� <span class="text_11" style="padding:3 0">
                  <input type="checkbox" name="input10">
                  </span>�ֻǸ� ����<br>
                  �����κ���
                  <input type="text" name="input11" size="5" maxlength="5" class="write">
                  �� �̳�<br>
                </span></td>
              </tr>
              <tr height="28">
                <td height="86" style="padding-left:30"><div align="left" class="style7"><span class="style3">����</span></div></td>
                <td><span class="style3"><span class="text_11 style3"><span class="text_11" style="padding:3 0">
                  <input type="checkbox" name="input12">
                  </span> ������� <span class="text_11" style="padding:3 0">
                  <input type="checkbox" name="input12">
                  </span> ������</span><span class="text_11 style3"><span class="text_11" style="padding:3 0">
                  <input type="checkbox" name="input12">
                  </span>�Ǽ���</span><span class="text_11 style3"><span class="text_11" style="padding:3 0">
                  <input type="checkbox" name="input12">
                  </span>�뽦��<br>
                  <span class="text_11" style="padding:3 0">
                  <input type="checkbox" name="input13">
                  </span> Ȩ������ <span class="text_11" style="padding:3 0">
                  <input type="checkbox" name="input13">
                  </span> ��ޱ����<span class="text_11" style="padding:3 0">
                  <input type="checkbox" name="input13">
                  </span>�ս����Ǽ�<span class="text_11" style="padding:3 0">
                  <input type="checkbox" name="input13">
                  </span>�Խ�Ʈ�Ͽ콺<br>
                  <span class="text_11" style="padding:3 0">
                  <input type="checkbox" name="input14">
                  </span> �ι� <span class="text_11" style="padding:3 0">
                  <input type="checkbox" name="input14">
                  </span> �����Ͻ�ȣ��<span class="text_11" style="padding:3 0">
                  <input type="checkbox" name="input14">
                </span>ȣ��</span></span></td>
              </tr>
              <tr height="28">
                <td style="padding-left:30"><div align="left" class="style7"><span class="style3">����</span></div></td>
                <td><span class="text_11 style3">
                  <input type="radio" name="" checked>
                  ��
                  <input type="radio" name="">
                  ��
                  <input type="radio" name="">
                  ���о��� </span></td>
              </tr>
              <tr height="28">
                <td style="padding-left:30"><div align="left" class="style7"><span class="style3">�ǹ�����</span></div></td>
                <td><span class="style3"><span class="text_11 style3">
                  <input type="radio" name="" checked>
                  ����Ʈ
                  <input type="radio" name="">
                  �Ǽ�</span></span></td>
              </tr>
              <tr height="28">
                <td style="padding-left:30"><div align="left" class="style7"><span class="style3">��Ÿ��</span></div></td>
                <td><span class="text_11 style3"><span class="text_11" style="padding:3 0">
                  <input type="checkbox" name="input15">
                  </span> 1�ν�<span class="text_11" style="padding:3 0">
                  <input type="checkbox" name="input15">
                  </span>2�ν�<span class="text_11" style="padding:3 0">
                  <input type="checkbox" name="input153">
                </span>���ν�</span></td>
              </tr>
              <tr height="28">
                <td height="45" style="padding-left:30"><div align="left" class="style7"><span class="style3">�󼼼���</span></div></td>
                <td><span class="style3">
                  <textarea name="input162" cols="60" class="write"></textarea>
                </span></td>
              </tr>
              <tr height="28">
                <td style="padding-left:30"><div align="left" class="style7"><span class="style3">����</span></div></td>
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
	  <!----- ��ü �������� ----->      
	  <!----- ��ü �������� ----->
	  <!-- �����÷��̾� -->
      <!-- �����÷��̾� -->      <!----- ����� ----->	
</td>
	<!-- ���� ������ -->


	<!-- �������� ���� -->
	<td width="10">&nbsp;</td>
	<!-- �������� ���� -->


	<!-- ���������� -->
	
	<td width="186" valign="top">
	<jsp:include page="../include/right.jsp" flush="true"/>
      <!-- �����÷��̾� -->      <!----- ����� ----->	</td>
	<!-- ���������� -->
</tr>

<!----- ������ ���� ----->


<tr height="40">
	<td colspan="5"></td>
</tr>


<!----- Footer ���� ----->

<tr valign="top">
	<td colspan="5">
		<jsp:include page="../include/footer.jsp" flush="true"/>
</td>
</tr>
<!----- Footer ���� ----->
</table>
</body>
</html>