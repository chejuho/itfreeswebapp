<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ page import="common.bean.MemberBean"%>
<%@ page import="job.bean.JobBean, job.bean.JobSearchBean"%>
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
	<title>게시판</title>
<script src="jsp/include/js/commonCheck.js" type="text/javascript"></script>
<script src="jsp/include/js/commonFunction.js" type="text/javascript"></script>
<link href="jsp/include/css/basic.css" rel="stylesheet" type="text/css">
<script type="text/javascript">
<!--   
    
	//リストに戻る
	function backDetailPage(id) {
		document.wf.action="IBoardDetail?id=" + id + "&noReadSign=ok";
		document.wf.submit(); 
		return true;
	}
	//更新
	function updateCheck(id) {
		if(isNull(wf.title)) {
			alert("글제목을 입력해 주세요.");
			return;
		}
		
		if(isNull(wf.user_name)) {
			alert("글쓴이를 입력해 주세요.");
			return;
		}
		if(isNull(wf.content)) {
			alert("글내용을 입력해 주세요.");
			return;
		}
		document.wf.action="IBoardUpdate";
		document.wf.submit(); 
		return true;
	}
	
//-->
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
		<td height="35">
			<form name="wf" method="post">
			<input type="hidden" name="id" value="${iboardBean.id}">
			<input type="hidden" name="board_id" value="${board_id}"> 
			<table width="736"  border="0" align="center" cellpadding="0" cellspacing="0">
			<tr><!--게시판이름 -->
				<td bgcolor="#EBF2E6" valign="bottom"  align="middle" width="736" height="52"><h3>${boardName} 수정</h3></td>
			</tr>
			<tr>
				<td valign="top">
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td bgcolor="#EBF2E6" style="padding:11px 11px 11px 11px;">
							<table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#d6d5d5">
							<tr>
								<td width="22%" bgcolor="#FFFFFF" class="table-cont-text">
									<h4>글제목</h4>
								</td>
								<td width="78%" bgcolor="#FFFFFF" class="table-cont-text">
									<input type="text" name= "title" id="idTitle" value="${iboardBean.title}" style="width:680px;"  maxlength="42"/>
								</td>
							</tr>
							<tr>
								<td bgcolor="#FFFFFF" class="table-cont-text">
									<h4>글쓴이</h4>
								</td>
								<td width="90%" bgcolor="#FFFFFF" class="table-cont-text">
									<input type="text" name= "user_name" id="idTitle"  value="${iboardBean.user_name}" style="width:300px;"  maxlength="42"/>
								</td>
							</tr>
							<tr>
								<td bgcolor="#FFFFFF" class="table-cont-text">
									<h4>내용</h4>
								</td>
								<td bgcolor="#FFFFFF" class="table-cont-text">
									<textarea name="content" id="idContent" cols="45" rows="15"  style="width:680px;height:300px;">${iboardBean.content}</textarea>
								</td>
							</tr>
							<tr>
								<td bgcolor="#FFFFFF" class="table-cont-text">
									<h4>파일첨부</h4>
								</td>
								<td bgcolor="#FFFFFF" class="table-cont-text">
									<table width="100%" border="0" cellspacing="0" cellpadding="0">
									<tr>
										<td height="30">	
										  	<h4>파일수정을 하시려면 글을 삭제하고 다시등록하세요..</h4>
										</td>
									</tr>
									<!-- <tr>
										<td height="30">	
										  	<input type="file" name="file_name1" id="idFile_name1" value="${iboardBean.filename1}" style="width:300px;"  />
										</td>
									</tr>
									<tr>
										<td height="30">	
										  	<input type="file" name="file_name2" id="idFile_name2" value="${iboardBean.filename2}" style="width:300px;"  />
										</td>
									</tr>
									<tr>
										<td height="30">	
										  	<input type="file" name="file_name3" id="idFile_name3" value="${iboardBean.filename3}" style="width:300px;"  />
										</td>
									</tr> -->
									</table>
								</td>
							</tr>
							</table>
						</td>
					</tr>
					</table>
				</td>
			</tr>
			<tr>
				<td valign="top">&nbsp;</td>
			</tr>
			<tr>
				<td align="center" valign="top">
					<a href="javascript:updateCheck(wf);"><img src="jsp/images/new/btn_edit_ok.gif" width="117" height="35" /></a>&nbsp;
					<a href="javascript:backDetailPage('${iboardBean.id}');"><img src="jsp/images/new/btn_back_page.gif" width="136" height="35" /></a></td>
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