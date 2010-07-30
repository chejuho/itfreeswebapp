<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="common.bean.MemberBean, common.util.EnDecoding"%>
<%@ page import="common.util.Util"%>
<%@ page import="common.constant.Const"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="myTags" uri="pageHandle"%>
<%@ taglib prefix="util" uri="util" %>
<fmt:setLocale value="KO"/>
<fmt:setBundle basename="msg" var="message"/>

<html>
<meta http-equiv="Content-type" content="text/html; charset=UTF-8">
<head>
<title>${iboardBean.title}&nbsp;::&nbsp;<fmt:message key="TITLE.title" bundle="${message}"/></title>
<link href="jsp/include/css/basic.css" rel="stylesheet" type="text/css">.

<script type="text/javascript">

	window.onload=init;
	/** ERROR메세지 처리  */
	 function init() {
	 	if (document.wf.msg.value == "psdError") {
	 		alert("비밀번호가 일치하지 않습니다.");
	 	}
	 
	}
	function deleteCheck(id){
	
		if(confirm("삭제하시겠습니까?")){
			document.wf.action="IBoardDelete?id="+id;
			document.wf.submit(); 
			return;
		}
	}
	
	function openUpdate(id){
		document.wf.action="IBoardUpdateOpen?id=" + id + "&noReadSign=ok";
		document.wf.submit(); 
		return true;
	}
	//ファイルDownLoad
	function fileDownLoad(filename) {
		document.wf.action="FileDownload?fileName=" + encodeURIComponent(filename);
		document.wf.submit(); 
		return true;
	}
	//リストに戻る
	function backListPage() {
		document.wf.action="IBoardList?modoru=ok";
		document.wf.submit(); 
		return true;
	}
	/* 
	 * パースOPEN 
	 */
	function passwordInputOpen(id,sign) {
		var url ="PasswordInputOpen?id=" + id + "&sign=" + sign;
		var newWindow =  window.open(url, "PASSWORD", "width = 350, height=150, location=no, toolbar=no");
		newWindow.moveTo(350,150);
		newWindow.focus();
	}
	

</script>
</head>

<body style="margin:0 0 0 0"> 
	<table>
	<tr>
		<td width="150">&nbsp;</td>
    	<td height="20">&nbsp;</td>
  	</tr>
	<tr>
		<td width="150">&nbsp;</td>
		<td>
			<form name="wf" method="post">
			<input type="hidden" name="id" >
			<input type="hidden" name="pass_word" >
			<input type="hidden" name="msg" value="${msg}">
			<input type="hidden" name="board_id" value="${board_id}"> 
			<table width="950"  border="0" align="center" cellpadding="0" cellspacing="0">
			<tr>
				<td height="85" background="jsp/images/new/foot_bg.gif" valign="bottom" align="center"><h2>${boardName}</h2>&nbsp;</td>
			</tr>
			<tr>
				<td height="40" align="right">
				<!--목록버튼 -->
          			<a href="javascript:backListPage();"><img src="jsp/images/new/tolist.gif" width="91" /></a>&nbsp;					
				<!--수정 삭제버튼 로그인 ID와작성자ID가 일치할경우 -->
					<a href="javascript:passwordInputOpen('${iboardBean.id}', 'edit');"><img src="jsp/images/new/btn_edit.gif"></a> &nbsp;
					<a href="javascript:passwordInputOpen('${iboardBean.id}', 'del');"><img src="jsp/images/new/btn_delete.gif"></a>				
				</td>
			</tr>
			<tr>
				<td>
					<table id="Table_" width="950" border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td height="67" colspan="3" align="center" background="jsp/images/new/search_content_boxbg.gif">
							<table width="96%" border="0" cellspacing="1" cellpadding="0">
							<tr>
								<td align="left">${util:getNewImage(iboardBean.update_dateTime)}
									<span class="detail-page"> ${iboardBean.title}</span>
								</td>
								<td>&nbsp;</td>
								<td align="right"><strong> ${iboardBean.user_name}  | 조회 ${iboardBean.read_count}  | ${iboardBean.update_dateTime}</strong></td>
							</tr>
							</table>
						</td>
					</tr>
					<tr>
						<td width="20" background="jsp/images/new/search_box_left.gif"><img src="jsp/images/new/search_box_left.gif" width="20" height="90" alt="" /></td>
						<td width="910" align="center" style="padding-top:10px;">
							<table border="0" cellspacing="1" cellpadding="0" width="97%">
							
							<tr>
								<td height="2" colspan="3" align="left" valign="top" bgcolor="#d9d9d9"></td>
							</tr>
							<tr>
								<td colspan="3" align="left" valign="top">&nbsp;</td>
							</tr>
							<tr>
								<td colspan="3" align="left" valign="top">${iboardBean.content}&nbsp;</td>
							</tr>
							<tr>
								<td colspan="3" align="left" valign="top">&nbsp;</td>
							</tr>
							<tr>
								<td colspan="3" align="left" valign="top">&nbsp;</td>
							</tr>
							
							<c:if test="${!empty iboardBean.filename1 || !empty iboardBean.filename2 || !empty iboardBean.filename3}">
								<tr>
								<td colspan="3" align="left" >
									<table width="100%" border="0" cellspacing="1" cellpadding="0">
									<tr>
										<td width="1%"><img src="jsp/images/new/search_conttit_icon.gif" width="7" height="14" /></td>
										<td width="99%" class="large-text-w" style="padding-top:2px;"><strong>첨부파일</strong></td>
									</tr>
									</table>
								</td>
								</tr>
								<tr>
									<td height="2" colspan="3" align="left" valign="top" bgcolor="#d9d9d9"></td>
								</tr>
								<tr>
									<td colspan="3" align="left" valign="top">&nbsp;</td>
								</tr>
								<c:if test="${!empty iboardBean.filename1}">
								<tr>	
									<td colspan="3" align="left" valign="top">
										&nbsp;&nbsp;●&nbsp;&nbsp;<a href="javascript:fileDownLoad('${iboardBean.downFile1Url}');"><strong>${iboardBean.filename1}</strong></a>
									</td>
								</tr>
			              		</c:if>
			              		<c:if test="${!empty iboardBean.filename2}">
								<tr>
									<td colspan="3" align="left" valign="top">
										&nbsp;&nbsp;●&nbsp;&nbsp;<a href="javascript:fileDownLoad('${iboardBean.downFile2Url}');"><strong>${iboardBean.filename2}</strong></a>
									</td>
								</tr>
			              		</c:if>
			              		<c:if test="${!empty iboardBean.filename3}">
								<tr>
									<td colspan="3" align="left" valign="top">
										&nbsp;&nbsp;●&nbsp;&nbsp;<a href="javascript:fileDownLoad('${iboardBean.downFile3Url}');"><strong>${iboardBean.filename3}</strong></a>
									</td>
								</tr>
			              		</c:if>
							</c:if>							
							</table>
						</td>
						<td width="20" background="jsp/images/new/search_box_right.gif"><img src="jsp/images/new/search_box_right.gif" width="20" height="90" alt="" /></td>
					</tr>
					<tr>
						<td colspan="3"><img src="jsp/images/new/search_box_under.gif" width="950" height="17" alt="" /></td>
					</tr>
					</table>
				</td>
			</tr>
			<tr>
				<td height="40" align="right">
				<!--목록버튼 -->
          			<a href="javascript:backListPage();"><img src="jsp/images/new/tolist.gif" width="91" /></a>&nbsp;					
				<!--수정 삭제버튼 로그인 ID와작성자ID가 일치할경우 -->
					<a href="javascript:passwordInputOpen('${iboardBean.id}','edit');"><img src="jsp/images/new/btn_edit.gif"></a> &nbsp;
					<a href="javascript:passwordInputOpen('${iboardBean.id}', 'del');"><img src="jsp/images/new/btn_delete.gif"></a>
				
				</td>
			</tr>
			</table>
			</form>
		</td>
	</tr>
  	<tr>
  		<td width="150">&nbsp;</td>
    	<td height="50">&nbsp;</td>
  	</tr>
	</table>
</body>
</html>