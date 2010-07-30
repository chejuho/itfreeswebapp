<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ page import="common.constant.Const"%>

<html>
<meta http-equiv="Content-type" content="text/html; charset=UTF-8">
<head>
<title><%=Const.PAGE_MAIN_TITLE%></title>
<style type="text/css">
TD
{
    FONT-SIZE: 12px;
    COLOR: #545454;
    LINE-HEIGHT: 18px;
}
.yellow14_b
{
    FONT-WEIGHT: bold;
    FONT-SIZE: 14px;
    COLOR: #ffff00;
}
</style>
<script type="text/javascript">
function setImage(position){
		document.getElementById("MainImg").src = position;
		return false;
	}
	
function setImageSize(t) {
	var objDiv = document.getElementById("MainImg");
	objDiv.height = screen.height - 210;
	//objDiv.width = screen.width * 0.9;
	
}

function winclose() {
	window.opener.focus();
	window.close();
}

window.onload=setImageSize;
</script>
<link href="jsp/include/css/kankokujin.css" rel="stylesheet" type="text/css">
<body topmargin="0" leftmargin="0">
	<table width="100%" height="100%"  border="0" cellpadding="0" cellspacing="0" bgcolor="1698E3">
  	<tr>
	    <td valign="top"  >
	        <table width="100%" height="100%"  border="0" cellpadding="0" cellspacing="0">
	          <tr align="center" valign="top">
	           	<td width="35" background="jsp/images/popup/pop_left.gif">&nbsp;</td>
	    		<td align="center" valign="top" bgcolor="ffffff"  style="padding:7 0 0 0">
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
      				<tr>
				        <td width="8" height="24"><img src="jsp/images/popup/pop_stitle_bg1.gif" width="8" height="24"></td>
				        <td valign="top" background="jsp/images/popup/pop_stitle_bg2.gif" style="padding:5 0 0 0"><span id="title"><strong>사진크게보기</strong></span></td>
        				<td width="8"><img src="jsp/images/popup/pop_stitle_bg3.gif" width="8" height="24"></td>
      				</tr>
   					</table>
					<table height="80%" width="100%" border="0" cellspacing="0" cellpadding="0" align="top">
					<tr>
						<td align="center"><img src="${photo1}" id="MainImg"></td>
					</tr>	
					</table>

					<table width="58"  border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td align="left" style="padding:0 0 0 7">
							<div id ="show_Image" >
								<table  border="0" cellspacing="0" cellpadding="0">
								<tr valign="top">
									<td width="58"><img src="${photo1}" width="54" height="41" onmouseover="setImage('${photo1}')" ></td>
									<td width="58"><img src="${photo2}" width="54" height="41" onmouseover="setImage('${photo2}')" ></td>
									<td width="58"><img src="${photo3}" width="54" height="41" onmouseover="setImage('${photo3}')" ></td> 
									<td width="58"><img src="${photo4}" width="54" height="41" onmouseover="setImage('${photo4}')" ></td> 
									<td width="58"><img src="${photo5}" width="54" height="41" onmouseover="setImage('${photo5}')" ></td>
								</tr>
								</table>
							</div>
						</td>
					</tr>
					</table>
				</td>
		 		<td width="35" align="right" valign="bottom" background="jsp/images/popup/pop_right.gif"><img src="jsp/images/popup/pop_right2.gif" width="35" height="18"></td>
	  		</tr>
			</table>
		</td>
	</tr>
	<tr>
		<td height="28" align="right" valign="top" style="padding:4 10 0 0"><a href="javascript:winclose();"><img src="jsp/images/popup/icon_close.gif"></a></td>
	</tr>
	</table>
</body>
</html>