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
    
	
	function registCheck(ff) {
		if(isNull(ff.title)) {
			alert("글제목을 입력해 주세요.");
			return;
		}
		
		if(isNull(ff.user_name)) {
			alert("글쓴이를 입력해 주세요.");
			return;
		}
		if(isNull(ff.content)) {
			alert("글내용을 입력해 주세요.");
			return;
		}
		if(isNull(ff.pass_word)) {
			alert("패스워드를 입력해 주세요.");
			return;
		}
		ff.action="IBoardRegist";
		ff.submit(); 
		return true;
	}
	//リストに戻る
	function backListPage() {
		var board_id = document.wf.board_id.value;
		document.wf.action="IBoardList?modoru=ok&board_id=" + board_id;
		document.wf.submit(); 
		return true;
	}		
	function deletePhoto(index) {
		document.wf.action="JobRegistOpen?del="+index;
		document.wf.submit(); 
		return true;
	}
	function backSearch() {

		document.wf.action="JobSearch?f=b";
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
			<form name="wf" method="post" enctype="multipart/form-data">
			<input type="hidden" name="board_id" value="${board_id}">
			<input type="hidden" name="user_id" value="${memberInfo.userid}">
			<table width="900"  border="0" align="center" cellpadding="0" cellspacing="0">
			<tr><!--게시판이름 -->
				
				<td bgcolor="#EBF2E6" align="center" valign="bottom" style="padding:21px 11px 11px 11px;"><h2>${boardName}&nbsp;글쓰기</h2></td>
			</tr>
			<tr>
				<td valign="top">
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td bgcolor="#EBF2E6" style="padding:11px 11px 11px 11px;">
							<table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#d6d5d5">
							<tr>
								<td bgcolor="#FFFFFF" class="table-cont-text">
									<h4>글제목</h4>
								</td>
								<td width="90%" bgcolor="#FFFFFF" class="table-cont-text">
									<input type="text" name= "title" id="idTitle" style="width:680px;"  maxlength="42"/>
								</td>
							</tr>
							<tr>
								<td bgcolor="#FFFFFF" class="table-cont-text">
									<h4>글쓴이</h4>
								</td>
								<td width="90%" bgcolor="#FFFFFF" class="table-cont-text">
									<input type="text" name= "user_name" id="idTitle" style="width:300px;"  maxlength="42"/>
								</td>
							</tr>
							<tr>
								<td bgcolor="#FFFFFF" class="table-cont-text">
									<h4>내용</h4>
								</td>
								<td bgcolor="#FFFFFF" class="table-cont-text">
									<textarea name="content" id="idContent" cols="45" rows="15"  style="width:680px;height:300px;"></textarea>
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
										  	<input type="file" name="file_name1" id="idFile_name1" value="${iboardBean.filename1}" style="width:300px;"  />
										</td>
									</tr>
									<tr>
										<td height="30">	
										  	<input type="file"  name="file_name2" id="idFile_name2" value="${iboardBean.filename2}" style="width:300px;"  />
										</td>
									</tr>
									<tr>
										<td height="30">	
										  	<input type="file"  name="file_name3" id="idFile_name3" value="${iboardBean.filename3}" style="width:300px;"  />
										</td>
									</tr>
									</table>
								</td>
							</tr>
							<tr>
								<td bgcolor="#FFFFFF" class="table-cont-text">
									<h4>패스워드</h4>
								</td>
								<td width="90%" bgcolor="#FFFFFF" class="table-cont-text">
									<input type="password" name= "pass_word" id="idTitle" style="width:180px;"  maxlength="42"/>
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
					<a href="javascript:registCheck(wf);"><img src="jsp/images/new/ok_b.gif" width="117" height="35" /></a>&nbsp;
					<a href="javascript:backListPage();"><img src="jsp/images/new/storeregist_list_b.gif" width="136" height="35" /></a></td>
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