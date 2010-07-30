
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Category</title>
<script src = "jsp/Scripts/prototype.js" type="text/javascript" ></script>
<script  src = "jsp/bookmark/tree.js" type="text/javascript"></script>
<script type="text/javascript">
//<![CDATA[
	/** 今選択されているのがカテゴリかブックマックか判別する 0:カテゴリ, 1:ブックマック */
	//var clickedSign;
	Event.observe(window, 'load', init);
/* 카테고리OpenAction  */
function insertCategoryOpen() {
		$("mainForm").action="CategoryManager?action=insertCateOpen&clickedbtn=" + clickedSign;
		$("mainForm").submit(); 
		return true;
		
}   

/* 카테고리AddAction  */
function insertCategory() {
	if (!clickedSign) {
		clickedSign = $F("clickedbtn");
	} 
	if (clickedSign == "category") {
		$("mainForm").action="CategoryManager?action=insertCate&clickedbtn=" + clickedSign;
		$("mainForm").submit(); 
		return true;
	} else {
		alert("카테고리를 선택하세요.");
	}
}

/* 카테고리deleteAction  */
function deleteCategory() {
	if (!clickedSign) {
		clickedSign = $F("clickedbtn");
	} 
	if (clickedSign == "category") {
		if(window.confirm('정말 삭제하십니까?')){
			$("mainForm").action="CategoryManager?action=deleteCate&clickedbtn=" + clickedSign;
			$("mainForm").submit(); 
			return true;
		} else {
			window.alert('취소되었습니다'); 
		}
	} else {
		alert("카테고리를 선택하세요.");
	}
		
}    

/* 카테고리updateCategoryOpen  */
function updateCategoryOpen() {
	if (!clickedSign) {
		clickedSign = $F("clickedbtn");
	} 
	if (clickedSign == "category") {
		$("mainForm").action="CategoryManager?action=updateCateOpen&clickedbtn=" + clickedSign;
		$("mainForm").submit(); 
		return true;
	} else {
		alert("카테고리를 선택하세요.");
	}
		
}   

/* 카테고리updateCategory  */
function updateCategory() {
		$("mainForm").action="CategoryManager?action=updateCate&clickedbtn=" + clickedSign;
		$("mainForm").submit(); 
		return true;
		
}

/* 카테고리insertBookmarkOpen */
function insertBookmarkOpen() {
		$("mainForm").action="CategoryManager?action=insertBookOpen&clickedbtn=" + clickedSign;
		$("mainForm").submit(); 
		return true;
		
}

/* 카테고리insertBook */
function insertBookmark() {
	if (!clickedSign) {
		clickedSign = $F("clickedbtn");
	} 
	if (clickedSign == "category") {
		$("mainForm").action="CategoryManager?action=insertBook&clickedbtn=" + clickedSign;
		$("mainForm").submit(); 
		return true;
	} else {
		alert("카테고리를 선택하세요.");
	}
}

/* 카테고리deleteBookmark */
function deleteBookmark() {
	if (!clickedSign) {
		clickedSign = $F("clickedbtn");
	} 
	if (clickedSign == "bookMark") {
		if(window.confirm('정말 삭제하십니까?')){
			$("mainForm").action="CategoryManager?action=deleteBook&clickedbtn=" + clickedSign;
			$("mainForm").submit(); 
			return true;
		} else {
			window.alert('취소되었습니다'); 
		}
	} else {
		alert("북마크를 선택하세요.");
	}
}  

/* 카테고리updateBookmarkOpen */
function updateBookmarkOpen() {
	if (!clickedSign) {
		clickedSign = $F("clickedbtn");
	} 
	if (clickedSign == "bookMark") {
		$("mainForm").action="CategoryManager?action=updateBookOpen&clickedbtn=" + clickedSign;
		$("mainForm").submit(); 
		return true;
	} else {
		alert("북마크를 선택하세요.");
	}
		
} 

/* 카테고리updateBookmark */
function updateBookmark() {
		$("mainForm").action="CategoryManager?action=updateBook&clickedbtn=" + clickedSign;
		$("mainForm").submit(); 
		return true;
		
}
/* 카테고리updateBookmark */
function goBookmarkNavi() {
		$("mainForm").action="Category";
		$("mainForm").submit(); 
		return true;
}
function bookmark(url) {
		//alert(url);
		var frame = $('Page');
		frame.src = url;
	}   
//]]>
</script>
<link href="jsp/bookmark/tree.css" rel="stylesheet" type="text/css"> 
</head>
<body>
<form id ="mainForm" name="mainForm" method="post" style="margin:0" action="CategoryManagerAction">
	<input type="hidden" id="clickedbtn"  value="<c:out value="${clickedbtn}"/>">		
	<a href="Index">메인홈으로</a>
	<table border="1">
		<tr>
			<td valign="top">
				<table border="1">
				<tr>
					<td height="500" width="1550" valign="top">
						<div class="elem" style="overflow-y:scroll;" id = "tree" >
						</div>
					</td>
				</tr>
				<tr>
					<td>
					카테고리<br>
					<img src="jsp/bookmark/btn_regist.gif" onclick="return insertCategoryOpen()">
					<img src="jsp/bookmark/btn_delete.gif" onclick="return deleteCategory()">
					<img src="jsp/bookmark/btn_edit.gif" onclick="return updateCategoryOpen()"><br>
					북마크<br>
					<img src="jsp/bookmark/btn_regist.gif" onclick="return insertBookmarkOpen()">
					<img src="jsp/bookmark/btn_delete.gif" onclick="return deleteBookmark()">
					<img src="jsp/bookmark/btn_edit.gif" onclick="return updateBookmarkOpen()"><br>
					</td>
				</tr>
				</table>
			</td>
			<td valign="top">
				<table border="1">
					<tr>
						<td>
							<c:if test="${forwardSign == '0'}">
							    <c:out value="카테고리나북마크를 추가하세요!"></c:out>	
							    <!--<a href="javascript:goBookmarkNavi();">북마크나비게이터로</a>-->
							</c:if>
							<c:if test="${forwardSign == '2' }">
								카테고리추가<br>
								이름:<input type="text" name="catename" size="50" maxlength="42"><br>
								<img src="jsp/bookmark/regist.gif" onclick="return insertCategory()">
							</c:if>
							<c:if test="${forwardSign == '3' }">
								<input type="hidden" name = "updateCode" value="<c:out value="${updateCode}"/>">		
								카테고리수정<br>
								이름:<input type="text" name="updateCodename" value="<c:out value="${updateCodeName}"/>" size="50" maxlength="42"><br>
								<img src="jsp/bookmark/regist.gif" onclick="return updateCategory()">
							</c:if>
							<c:if test="${forwardSign == '4' }">	
								북마크추가<br>
								싸이트명:<input type="text" name="title" size="50" maxlength="42"><br>
								장소(URL):<input type="text" name="url" size="50" maxlength="42"><br>
								상세정보:<input type="text" name="detail" size="50" maxlength="42"><br>
								<img src="jsp/bookmark/regist.gif" onclick="return insertBookmark()">
							</c:if>
							<c:if test="${forwardSign == '5' }">	
								북마크추가<br>
								싸이트명:<input type="text" name="title" size="50" maxlength="42"  value="<c:out value="${bookMark.title}"/>"><br>
								장소(URL):<input type="text" name="url" size="50" maxlength="100"  value="<c:out value="${bookMark.url}"/>"><br>
								상세정보:<input type="text" name="detail" size="50" maxlength="42"  value="<c:out value="${bookMark.detail}"/>"><br>
								<img src="jsp/bookmark/regist.gif" onclick="return updateBookmark()">
							</c:if>
						</td>
					</tr>
					<tr>
						<td>
						<iframe id ="Page" name = "Page" src="http://www.kankokujin.com" 
							 style="width:1000px; height:1450px; border: 0px">
							</iframe>
						</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
</form>
</body>
</html>