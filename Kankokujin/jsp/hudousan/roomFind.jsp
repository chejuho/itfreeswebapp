<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="myTags" uri="pageHandle"%>

<fmt:setLocale value="KO"/>
<fmt:setBundle basename="hudousan" var="message"/>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title><fmt:message key="TITLE.main" bundle="${message}"/></title>
<link href="jsp/include/css/basic.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript">
<!--

	function sellcheck(form, leaseSign) {
		ID = /^[A-Za-z0-9]+$/;
		ED = /^[0-9]{1,4}/;
		if(form.title.value==""){
			alert("제목을 입력하세요.");
			f.title.focus();
			return;			
		}
		//賃貸の場合
		if (leaseSign == '1') {
			if(form.deposit.value == "" || form.reikin.value == ""){
				alert("희망 초기비용을 입력하세요.");
				form.deposit.focus();
				return;			
			}
			if(form.house_fee.value == ""){
				alert("희망 야칭을 입력하세요.");
				form.house_fee.focus();
				return;			
			}
		}
		
		//売買の場合
		if (leaseSign == '0') {
			if(form.house_fee.value == ""){
				alert("희망 매매가을 입력하세요.");
				form.house_fee.focus();
				return;			
			}
		}
		if(form.house_sort.value == ""){
				alert("희망타입을 입력하세요.");
				form.house_sort.focus();
				return;			
		}
		
		if(form.area_info.value == ""){
				alert("희망위치을 입력하세요.");
				form.area_info.focus();
				return;			
		}
		
		if(form.madori.value == ""){
				alert("희망마도리을 입력하세요.");
				form.madori.focus();
				return;			
		}
		
		
		
		if(form.email1.value==""){
			alert("이메일을 입력하세요.");
			form.email1.focus();
			return;
		} else if(form.email2.value==""){
			alert("이메일을 입력하세요.");
			form.email2.focus();
			return;		
		} 
		
		if(!isEmail(form.email1.value + "@"+ form.email2.value)) {
			alert("이메일이 형식에 맞지 않습니다.");
			return;
		} 
		//賃貸の場合
		if (leaseSign == '1') {
			form.action="HudousanFindAction?method=leaseFind";
		}	
		//売買の場合
		if (leaseSign == '0') {
			form.action="HudousanFindAction?method=buyFind";
		}
		
		form.submit(); 
	}
	function isNull(obj) {
		if(obj.value == "") {
			return true;
		}
	}	
	function isEmail(obj) {
	    var format = /^[_0-9a-zA-Z-]+(\.[_0-9a-zA-Z-]+)*@[0-9a-zA-Z-]+(\.[0-9a-zA-Z-]+)*$/;
		/^(file|gopher|news|nntp|telnet|https?|ftps?|sftp):\/\/([a-z0-9-]+\.)+[a-z0-9]{2,4}.*$/	    
		if (obj.search(format) != -1){
			return true;		
		}else {
			return false;		
		}	
	}
//-->
</script>


</head>

<body topmargin="0" leftmargin="0">
<form name="findroom" method="post" style="margin:0">
<table width="100%" border="0" cellpadding="0" cellspacing="0">
	<c:import url="top.jsp" />
	<tr>
		<td>&nbsp;</td>
	</tr>
	<tr>
    	<td>
			<table width="650"  border="1" align="center" cellpadding="0" cellspacing="0">
      		    <tr>
			        <td valign="top">
				        <table width="100%" border="1" cellspacing="0" cellpadding="0">
						<tr>
							<td bgcolor="#ebebeb" style="padding:11px 11px 11px 11px;">
								<table width="100%" border="1" cellpadding="0" cellspacing="1" bgcolor="#d6d5d5">
								<tr>
									<td width="34%" bgcolor="#f7f7f7" class="table-title-text"><span class="red-text-w">*</span><fmt:message key="findroom.label.item1" bundle="${message}"/> </td>
									<td width="66%" bgcolor="#FFFFFF" class="table-cont-text">
				                  	<input name="title" type="text" id="textfield9" style="width:150px;" />
				                </tr>
				                
				                <!--賃貸の場合-->
								<c:if test="${leaseSign == '1'}">
				                <tr>
				                  <td bgcolor="#f7f7f7" class="table-title-text">
				                  	<span class="red-text-w">*</span><fmt:message key="findroom.label.item2" bundle="${message}"/><br><fmt:message key="findroom.label.example1" bundle="${message}"/>
				                  </td>
				                  <td width="66%" bgcolor="#FFFFFF" class="table-cont-text">
				                  	<fmt:message key="findroom.label.item3" bundle="${message}"/> <input type="text" name="deposit" id="textfield2" maxlength="2" style="width:50px;" /> <fmt:message key="common.label.month" bundle="${message}"/> /
				                  	<fmt:message key="findroom.label.item4" bundle="${message}"/> <input type="text" name="reikin" id="textfield2" maxlength="2" style="width:50px;" /> <fmt:message key="common.label.month" bundle="${message}"/>
				                  </td>
				                </tr>
				                <tr>
				                  <td bgcolor="#f7f7f7" class="table-title-text"><span class="red-text-w">*</span><fmt:message key="findroom.label.item5" bundle="${message}"/></td>
				                  <td width="66%" bgcolor="#FFFFFF" class="table-cont-text">
				                  	<input type="text" name="house_fee" id="textfield5" style="width:150px;" /> <fmt:message key="common.label.en" bundle="${message}"/>
				                  </td>
				                </tr>
				                </c:if>
				                <!--売買の場合-->
								<c:if test="${leaseSign == '0'}">
								<tr>
									<td bgcolor="#f7f7f7" class="table-title-text"><span class="red-text-w">*</span><fmt:message key="findroom.label.item6" bundle="${message}"/></td>
					                <td width="66%" bgcolor="#FFFFFF" class="table-cont-text">
					                	<input type="text" name="house_fee" id="textfield5" style="width:150px;" /> <fmt:message key="common.label.en" bundle="${message}"/>
					                 </td>
				                </tr>
								</c:if>
				                <tr>
				                  <td bgcolor="#f7f7f7" class="table-title-text"><span class="red-text-w">*</span><fmt:message key="findroom.label.item7" bundle="${message}"/><br><fmt:message key="findroom.label.example2" bundle="${message}"/></td>
				                  <td width="66%" bgcolor="#FFFFFF" class="table-cont-text">
				                  	<input name="house_sort" type="text" id="textfield9" style="width:150px;" />
				                </tr>
				                <tr>
				                  <td bgcolor="#f7f7f7" class="table-title-text"><span class="red-text-w">*</span><fmt:message key="findroom.label.item8" bundle="${message}"/></td>
				                  <td width="66%" bgcolor="#FFFFFF" class="table-cont-text">
				                  	<input name="area_info" type="text" id="textfield3" style="width:150px;" />
				                  </td>
				                </tr>
				                <tr>
				                  <td bgcolor="#f7f7f7" class="table-title-text"><span class="red-text-w">*</span><fmt:message key="findroom.label.item9" bundle="${message}"/><br><fmt:message key="findroom.label.example3" bundle="${message}"/></td>
				                  <td width="66%" bgcolor="#FFFFFF" class="table-cont-text"><input type="text" name="madori" id="textfield8"  style="width:330px;" /></td>
				                </tr>
				                <tr>
									<td bgcolor="#f7f7f7" class="table-title-text"><fmt:message key="findroom.label.item10" bundle="${message}"/></td>
									<td width="79%" bgcolor="#FFFFFF" class="table-cont-text">
										<input name="phone1" type="text" style="width:50px;" maxlength="4" />
										-
										<input name="phone2" type="text" style="width:50px;" maxlength="4" />
										-
										<input name="phone3" type="text" style="width:50px;" maxlength="4" />
									</td>
								</tr>
								<tr>
									<td bgcolor="#f7f7f7" class="table-title-text"><span class="red-text-w">*</span><fmt:message key="findroom.label.item11" bundle="${message}"/></td>
									<td width="79%" bgcolor="#FFFFFF" class="table-cont-text">
										<input type="text" name="email1" style="width:150px;" maxlength="24"/>
										@
										<input type="text" name="email2" style="width:150px;" maxlength="24"/></td>
								</tr>
				                <tr>
				                  <td bgcolor="#f7f7f7" class="table-title-text"><fmt:message key="findroom.label.item12" bundle="${message}"/></td>
				                  <td width="66%" bgcolor="#FFFFFF" class="table-cont-text">
				                  	<textarea name="detail" id="textarea" cols="45" rows="5" style="width:330px;height:200px;"></textarea>
				                  </td>
				                </tr>
				            	</table>
				           </td>
			          	</tr>
			          	<tr>
							<td valign="top">&nbsp;</td>
						</tr>
						<tr>
							<td align="center" valign="top"><a href="javascript:sellcheck(findroom, '${leaseSign}')"><img src="jsp/images/new/contact_b.gif" width="119" height="37" /></a></td>
						</tr>
			        	</table>
					</td>
				</tr>
			</table>
		</td>
	</tr>
</table>
</form>
</body>
</html>
