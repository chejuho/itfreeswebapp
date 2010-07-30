<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="myTags" uri="pageHandle"%>
<%@ taglib prefix="util" uri="util" %>
<fmt:setLocale value="KO"/>
<fmt:setBundle basename="hudousan" var="message"/>
<html>
<meta http-equiv="Content-type" content="text/html; charset=UTF-8">
<head>
<title><fmt:message key="TITLE.main" bundle="${message}"/></title>
<link href="jsp/include/css/basic.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript">
<!--

	function backPage(form, leaseSign){
		alert(leaseSign);
		//賃貸の場合
		if (leaseSign == '1') {
			form.action="HudousanSearchAction?method=leaseSearchBack";
		}	
		//売買の場合
		if (leaseSign == '0') {
			form.action="HudousanSearchAction?method=buySearchBack";
		}
		form.submit();
	}
	
	function deleteCheck(id){
		if(confirm("삭제하시겠습니까?")){
			document.wf.action="HouseSellDelete?id="+id;
			document.wf.submit(); 
			return true;
		}
	}
	function setImage(position){
		document.getElementById("disp").src = position;
		return false;
	}
	function openUpdate(id){
		document.wf.action="HouseSellUpdateOpen?id=" + id;
		document.wf.submit(); 
		return true;
	}	
	function backSearchPage() {
		document.wf.action="HouseSellList?re=9&modoru=ok";
		document.wf.submit(); 
		return true;
	}
	function backMyWrite() {
		document.wf.action="MyWrite?sort=7&modoru=ok";
		document.wf.submit(); 
		return true;
	}	
	function goSearchPage() {
		document.wf.action="HouseSellList?re=9";
		document.wf.submit(); 
		return true;
	}
		
	function mailOpenDetail(id,name) {
		mailOpen(id, name, '5');
		return true;
	}
//-->
</script>
</head>
<body style="margin:0 0 0 0"> 
	<form name="detailForm" method="post" style="margin:0">
	<table>
	<c:import url="top.jsp" />
	<tr>
    	<td height="20">&nbsp;</td>
  	</tr>
	<tr>
		<td>
			<table width="950"  border="0" align="center" cellpadding="0" cellspacing="0">
			<tr>
				<td>
					<table width="100%" height="40" border="0" cellspacing="1" cellpadding="0">
					<tr>
						<td width="37%" align="right" style="padding-top:3px;">
							<!--목록버튼 -->
		              		<a href="javascript:backPage(detailForm, '${leaseSign}');"><img src="jsp/images/new/tolist.gif" width="91" /></a>&nbsp;
							
						</td>
					</tr>
					</table>	
				</td>
			</tr>
			<tr>
				<td height="1" bgcolor="#d9d9d9"></td>
			</tr>
			<tr>
				<td height="14"></td>
			</tr>
			<tr>
				<td>
					<table id="Table_" width="950" border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td height="67" colspan="3" align="center" background="jsp/images/new/search_content_boxbg.gif">
							<table width="96%" border="0" cellspacing="1" cellpadding="0">
					  		<tr>
								<td align="left">${util:getNewImage(HudousanBean.update_dateTime)}<span class="detail-page">${HudousanBean.title}</span></td>
								<td>&nbsp;</td>
								<td align="right">등록일: <c:out value="${HudousanBean.updateDateFull}"/></td>
							</tr>
							</table>
						</td>
					</tr>
					<tr>
						<td width="20" background="jsp/images/new/search_box_left.gif"><img src="jsp/images/new/search_box_left.gif" width="20" height="90" alt="" /></td>
						<td width="910" align="center" style="padding-top:10px;"><table width="895" border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td width="895" valign="top">
							<table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#d9d9d9">
							</table>
						</td>
  					</tr>
					<tr>
						<td valign="top">
							<table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#d9d9d9">
							<tr>
								<td width="142" align="left" bgcolor="#ececec" class="table-title-text">집물건명</td>
								<td width="341" align="left" bgcolor="#FFFFFF" class="table-cont-text"><c:out value="${HudousanBean.house_name}"/></td>
								<td align="left" bgcolor="#ececec" class="table-title-text">건축년도</td>
								<td width="276" align="left" bgcolor="#FFFFFF" class="table-cont-text">
									<c:if test="${!empty HudousanBean.build_year and RoomBean.build_year != '0'}">
										<c:out value="${HudousanBean.build_year}년"/>
									</c:if>
									<c:if test="${!empty HudousanBean.build_month and RoomBean.build_month != '0'}">
										<c:out value="${HudousanBean.build_month}월"/>
									</c:if>&nbsp;<br />
								</td>
							</tr>
							<tr>
								<td align="left" bgcolor="#ececec" class="table-title-text">건물층수</td>
								<td align="left" bgcolor="#FFFFFF" class="table-cont-text"> 
									<c:if test="${!empty HudousanBean.all_stairs and RoomBean.all_stairs != '0'}">
										<c:out value="${HudousanBean.all_stairs}"/>층건물에
									</c:if>
									<c:if test="${!empty HudousanBean.stairs and RoomBean.stairs != '0'}">
										<c:out value="${HudousanBean.stairs}"/>층
									</c:if>&nbsp;<br />
								</td>
								<td width="131" align="left" bgcolor="#ececec" class="table-title-text">건물종류</td>
								<td align="left" bgcolor="#FFFFFF" class="table-cont-text">
									<c:if test="${HudousanBean.house_sort == '0'}">
										아파트
									</c:if>
									<c:if test="${HudousanBean.house_sort == '1'}">
										맨션
									</c:if>
									<c:if test="${HudousanBean.house_sort == '2'}">
										개인주택
					            	</c:if>
									<c:if test="${HudousanBean.house_sort == '3'}">
										주차장
									</c:if>
					            	<c:if test="${HudousanBean.house_sort == '4'}">
										점포
					            	</c:if>
					            	<c:if test="${HudousanBean.house_sort == '5'}">
										사무실
					            	</c:if>
					            	<c:if test="${HudousanBean.house_sort == '6'}">
										토지
					            	</c:if>
					            	<c:if test="${HudousanBean.house_sort == '7'}">
										기타
					            	</c:if>&nbsp;
								</td>
							</tr>
							<tr>
								<td align="left" bgcolor="#ececec" class="table-title-text">지역정보</td>
								<td align="left" bgcolor="#FFFFFF" class="table-cont-text">
									<c:out value="${HudousanBean.area_fast}"/>
		                          	<c:out value="${HudousanBean.area_name_1}"/>
		                          	<c:out value="${HudousanBean.area_name_2}"/>
		                          	<c:out value="${HudousanBean.area_code_3}"/>&nbsp;<br /></td>
								<td width="131" align="left" bgcolor="#ececec" class="table-title-text">노선정보</td>
								<td align="left" bgcolor="#FFFFFF" class="table-cont-text">
									<c:out value="${HudousanBean.lineInfo}"/>
									<c:if test="${!empty HudousanBean.walk_time}">
										/도보<c:out value="${HudousanBean.walk_time}"/>분
									</c:if>&nbsp;<br /></td>
							</tr>
							<tr>
								<td colspan="2" rowspan="13" align="center" valign="middle" bgcolor="#FFFFFF"  >
									<table width="482" border="0" cellspacing="0" cellpadding="0">
									<tr>
										<td colspan="2" height="366" align="center"><img src="${HudousanBean.photo_path1}" id="disp" /></td>
									</tr>
									<tr>
										<td height="6" colspan="2"></td>
									</tr>
									<tr>
										<td width="392" align="right">
											<img src="${HudousanBean.photo_path1}" width="60" height="60" style="border:1px  solid #CCCCCC;" onmouseover="setImage('${HudousanBean.photo_path1}')"/>&nbsp;
											<img src="${HudousanBean.photo_path2}" width="60" height="60" style="border:1px  solid #CCCCCC;" onmouseover="setImage('${HudousanBean.photo_path2}')"/>&nbsp;
											<img src="${HudousanBean.photo_path3}" width="60" height="60" style="border:1px  solid #CCCCCC;" onmouseover="setImage('${HudousanBean.photo_path3}')"/>&nbsp;
											<img src="${HudousanBean.photo_path4}" width="60" height="60" style="border:1px  solid #CCCCCC;" onmouseover="setImage('${HudousanBean.photo_path4}')"/>&nbsp;
											<img src="${HudousanBean.photo_path5}" width="60" height="60" style="border:1px  solid #CCCCCC;" onmouseover="setImage('${HudousanBean.photo_path5}')"/>
										</td>
										<td width="89" align="right" valign="top"><a href="javascript:popup();"><img src="jsp/images/new/large_b.gif" width="61" height="16" /></a></td>
									</tr>
									</table>
								</td>
								<td align="left" bgcolor="#ececec" class="table-title-text"><strong>입거가능일<br /></strong></td>
								<td align="left" bgcolor="#FFFFFF" class="table-cont-text">
									<c:if test="${HudousanBean.come_dock == '0'}">
										즉시
									</c:if>
									<c:if test="${HudousanBean.come_dock == '1'}">
										<c:out value="${HudousanBean.come_dock_year}년${HudousanBean.come_dock_month}월"/>
									</c:if>&nbsp;<br /></td>
							</tr>
							<tr>
								<!--賃貸の場合-->
								<c:if test="${leaseSign == '1'}">
									<td align="left" bgcolor="#ececec" class="table-title-text">야칭</td>
									<td align="left" bgcolor="#FFFFFF" class="table-cont-text">
									<c:if test="${!empty HudousanBean.house_fee[0] and HudousanBean.house_fee[0] != '0'}">
										<c:out value="${HudousanBean.house_fee[0]}만엔"/><br>
									</c:if>
									<c:if test="${!empty HudousanBean.manage_fee and HudousanBean.manage_fee != '0'}">
										관리비/기타<c:out value="${HudousanBean.manage_fee}만엔"/>	
									</c:if>
									<c:if test="${!empty HudousanBean.deposit and HudousanBean.deposit != '0'}">
										시끼낑<c:out value="${HudousanBean.deposit}개월분"/><br>
									</c:if>
									<c:if test="${!empty HudousanBean.reikin and HudousanBean.reikin != '0'}">
										레이낑<c:out value="${HudousanBean.reikin}개월분"/>
									</c:if>
									<c:if test="${!empty HudousanBean.guaranty_money and HudousanBean.guaranty_money != '0'}">
										보증금<c:out value="${HudousanBean.guaranty_money}개월분"/>
									</c:if>&nbsp;<br />
								</td>	
								</c:if>
								<!--売買の場合-->
								<c:if test="${leaseSign == '0'}">
										<td align="left" bgcolor="#ececec" class="table-title-text">매매가</td>
										<td align="left" bgcolor="#FFFFFF" class="table-cont-text">
											<c:if test="${!empty HudousanBean.house_fee[0] and HudousanBean.house_fee[0] != '0'}">
												<c:out value="${HudousanBean.house_fee[0]}만엔"/><br>
											</c:if>
										</td>
								</c:if>					
							</tr>
							<tr>
								<td align="left" bgcolor="#ececec" class="table-title-text">전용면적</td>
								<td align="left" bgcolor="#FFFFFF" class="table-cont-text">
									<c:if test="${!empty HudousanBean.dimension[0] and HudousanBean.dimension[0] != '0'}">
										<c:out value="${HudousanBean.dimension[0]}m2"/>
									</c:if>&nbsp;								
								</td>
							</tr>
							<tr>
								<td align="left" bgcolor="#ececec" class="table-title-text">마도리</td>
								<td align="left" bgcolor="#FFFFFF" class="table-cont-text">
									<c:if test="${HudousanBean.madori == '0'}">
										1R
									</c:if>
									<c:if test="${HudousanBean.madori == '1'}">
										1K
									</c:if>
									<c:if test="${HudousanBean.madori == '2'}">
										1DK
					            	</c:if>
									<c:if test="${HudousanBean.madori == '3'}">
										1LDK
									</c:if>
					            	<c:if test="${HudousanBean.madori == '4'}">
										2K
					            	</c:if>
					            	<c:if test="${HudousanBean.madori == '5'}">
										2DK
					            	</c:if>
					            	<c:if test="${HudousanBean.madori == '6'}">
										2LDK
					            	</c:if>
					            	<c:if test="${HudousanBean.madori == '7'}">
										3DK
					            	</c:if>
					            	<c:if test="${HudousanBean.madori == '8'}">
										3LDK
					            	</c:if>
					            	<c:if test="${HudousanBean.madori == '9'}">
										4DK
					            	</c:if>
					            	<c:if test="${HudousanBean.madori == '10'}">
										4LDK
					            	</c:if>
					            	<c:if test="${HudousanBean.madori == '11'}">
										기타
					            	</c:if><br><c:out value="${HudousanBean.madori_info}"/>&nbsp;
								</td>
							</tr>
							<tr>
								<td align="left" bgcolor="#ececec" class="table-title-text">방구조</td>
								<td align="left" bgcolor="#FFFFFF" class="table-cont-text">
									<c:if test="${HudousanBean.flg_tadami == '0'}">
										타다미
									</c:if>
									<c:if test="${HudousanBean.flg_tadami == '1'}">
										플로링
									</c:if>
									<c:if test="${HudousanBean.flg_tadami == '2'}">
										타다미 + 플로링
					            	</c:if>&nbsp;								
								</td>
							</tr>
							<tr>
								<td align="left" bgcolor="#ececec" class="table-title-text">화장실/목욕탕</td>
								<td align="left" bgcolor="#FFFFFF" class="table-cont-text">
									<c:if test="${HudousanBean.toilet == '0'}">
										화장실 욕조별도
									</c:if>
									<c:if test="${HudousanBean.toilet == '1'}">
										화장실 욕조동일
									</c:if>
									<c:if test="${HudousanBean.toilet == '2'}">
										샤워만
					            	</c:if>
					            	<c:if test="${HudousanBean.toilet == '3'}">
										화장실만
					            	</c:if>&nbsp;								
								</td>
							</tr>
							<tr>
								<td align="left" bgcolor="#ececec" class="table-title-text">방위</td>
								<td align="left" bgcolor="#FFFFFF" class="table-cont-text">
									<c:if test="${HudousanBean.point_compass == '1'}">
										동향
									</c:if>
									<c:if test="${HudousanBean.point_compass == '2'}">
										서향
									</c:if>
									<c:if test="${HudousanBean.point_compass == '3'}">
										남향	
					            	</c:if>
					            	<c:if test="${HudousanBean.point_compass == '4'}">
										북향
					            	</c:if>&nbsp;								
								</td>
							</tr>
							<tr>
								<td align="left" bgcolor="#ececec" class="table-title-text">조건</td>
								<td align="left" bgcolor="#FFFFFF" class="table-cont-text">
									<c:if test="${HudousanBean.house_option[0] == '1'}">
										2인입거가능
									</c:if>
									<c:if test="${HudousanBean.house_option[1] == '1'}">
										 가족입거가능
									</c:if>
									<c:if test="${HudousanBean.house_option[2] == '1'}">
										 애완동물가능
					            	</c:if>&nbsp;								
								</td>
							</tr>
							<tr>
								<td align="left" bgcolor="#ececec" class="table-title-text">이메일</td>
								<td align="left" bgcolor="#FFFFFF" class="table-cont-text">
									<a href="" onclick="mailOpenDetail('${HudousanBean.id}','${HudousanBean.user_name}'); return false;">메일보내기</a>
								</td>
							</tr>
							<tr>
								<td align="left" bgcolor="#ececec" class="table-title-text">전화번호1</td>
								<td align="left" bgcolor="#FFFFFF" class="table-cont-text">
									<c:out value="${HudousanBean.tel_no1_fname}"/>&nbsp;	
								</td>
							</tr>
							<tr>
								<td align="left" bgcolor="#ececec" class="table-title-text">전화번호2</td>
								<td align="left" bgcolor="#FFFFFF" class="table-cont-text">
									<c:out value="${HudousanBean.tel_no2_fname}"/>&nbsp;
								</td>
							</tr>
							<tr>
								<td align="left" bgcolor="#ececec" class="table-title-text">등록자</td>
								<td align="left" bgcolor="#FFFFFF" class="table-cont-text">
									<c:out value="${HudousanBean.user_name}"/>&nbsp;
								</td>
							</tr>
							<tr>
								<td align="left" bgcolor="#ececec" class="table-title-text">조회수</td>
								<td align="left" bgcolor="#FFFFFF" class="table-cont-text">
									<c:out value="${HudousanBean.read_count}"/>&nbsp;
								</td>
							</tr>
							</table>
						</td>
					</tr>
					<tr>
						<td height="30" valign="top">&nbsp;</td>
					</tr>
					<tr>
						<td align="left" >
							<table width="40%" border="0" cellspacing="1" cellpadding="0">
							<tr>
								<td width="3%"><img src="jsp/images/new/search_conttit_icon.gif" width="7" height="14" /></td>
								<td width="97%" style="padding-top:2px;"><span class="style10">상세정보</span></td>
							</tr>
							</table>
						</td>
					</tr>	
					<tr>
						<td height="2" align="left" valign="top" bgcolor="#d9d9d9"></td>
					</tr>
					<tr>
						<td align="left" valign="top">&nbsp;</td>
					</tr>
					<tr>
						<td align="left" valign="top">&nbsp;</td>				  
					</tr>
					<tr>
						<td align="left" valign="top">${HudousanBean.detail_info}&nbsp;&nbsp;</td>
					</tr>
					<tr>
						<td align="left" valign="top">&nbsp;</td>
					</tr>
					<tr>
						<td align="left" valign="top">&nbsp;</td>
					</tr>
					<tr>
						<td align="left" valign="top">&nbsp;</td>
					</tr>
					<tr>
						<td align="left" valign="top">&nbsp;</td>
					</tr>
					</table>
		</td>
			<td width="20"   background="jsp/images/new/search_box_right.gif"><img src="jsp/images/new/search_box_right.gif" width="20" height="90" alt="" /></td>
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
					<c:if test="${HouseSearchBean.before == 'search'}">
              			<a href="javascript:backSearchPage();"><img src="jsp/images/new/tolist.gif" width="91" /></a>&nbsp;
					</c:if>	
					<c:if test="${HouseSearchBean.before == 'mysearch'}">
					 	<a href="javascript:backMySearchPage();"><img src="jsp/images/new/tolist.gif" width="91" /></a>							
					</c:if>
					<c:if test="${HouseSearchBean.before == 'my_write'}">
					 	<a href="javascript:backMyWrite();"><img src="jsp/images/new/tolist.gif" width="91" /></a>							
					</c:if>
					<c:if test="${HouseSearchBean.before == 'new_write'}">
  						<a href="javascript:goSearchPage();"><img src="jsp/images/new/tolist.gif" width="91" /></a>&nbsp;
					</c:if>						
					<!--수정 삭제버튼 로그인 ID와작성자ID가 일치할경우 -->
					<c:if test="${HudousanBean.user_id == memberInfo.userid}">
						<a href="javascript:openUpdate('${HudousanBean.id}');"><img src="jsp/images/new/btn_edit.gif"></a> &nbsp;
						<a href="javascript:deleteCheck('${HudousanBean.id},wf');"><img src="jsp/images/new/btn_delete.gif"></a>
					</c:if>
				</td>
			</tr>
			</table>
			</form>
		</td>
	</tr>
	</table>
</body>
</html>