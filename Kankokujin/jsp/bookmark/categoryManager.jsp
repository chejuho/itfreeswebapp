
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
		allHide();
		$("categoryAdd").show();
		$("catename").focus();
		//$("mainForm").action="CategoryManager?action=insertCateOpen&clickedbtn=" + clickedSign;
		//$("mainForm").submit(); 
		return true;
		
}   

/* 카테고리AddAction  */
function insertCategory() {
	if (!clickedSign) {
		clickedSign = $F("clickedbtn");
	} 
	if (clickedSign == "category") {
		var param = "param=insertCategory&" + "catename=" + $F("catename");
		new Ajax.Request("CategoryControl", 
			{method:"get",
			onComplete:setTree,
			parameters:param });
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
			var param = "param=deleteCategory";
			new Ajax.Request("CategoryControl", 
				{method:"get",
				onComplete:setTree,
				parameters:param });
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
		var param = "param=updateCateOpen&" + "clickedbtn=" + clickedSign;;
		new Ajax.Request("CategoryControl", 
			{method:"get",
			onComplete:function set(resp) {
						var result = resp.responseText.split('<i>');
						allHide();
						$("updateCode").value = result[0];
						$("updateCodename").value = result[1];
						$("categoryUpdate").show();},
			parameters:param });
	} else {
		alert("카테고리를 선택하세요.");
	}
		
}   

/* 카테고리updateCategory  */
function updateCategory() {
		var param = "param=updateCategory&" + "updateCodename=" + $F("updateCodename") + "&updateCode=" + encodeURIComponent($F("updateCode"))
		new Ajax.Request("CategoryControl", 
			{method:"get",
			onComplete:setTree,
			parameters:param });
		return true;
		
}

/* 카테고리insertBookmarkOpen */
function insertBookmarkOpen() {
		allHide();
		$("bookMarkAdd").show();
		$("title").focus();
		
}

/* 카테고리insertBook */
function insertBookmark() {
	if (!clickedSign) {
		clickedSign = $F("clickedbtn");
	} 
	if (clickedSign == "category") {
		var param = "param=insertBook&" + "title=" + encodeURIComponent($F("title")) + "&url=" + encodeURIComponent($F("url")) + "&detail=" + encodeURIComponent($F("detail"));
		new Ajax.Request("CategoryControl", 
			{method:"get",
			onComplete:setTree,
			parameters:param });
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
			var param = "param=deleteBookmark";
			new Ajax.Request("CategoryControl", 
				{method:"get",
				onComplete:setTree,
				parameters:param });
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
		var param = "param=updateBookOpen&" + "clickedbtn=" + clickedSign;;
		new Ajax.Request("CategoryControl", 
			{method:"get",
			onComplete:function set(resp) {
						var result = resp.responseText.split('<i>');
						allHide();
						$("uptitle").value = result[0];
						$("upurl").value = result[1];
						$("updetail").value = result[2];
						$("bookMarkUpdate").show();},
			parameters:param });
	} else {
		alert("북마크를 선택하세요.");
	}
		
} 

/* 카테고리updateBookmark */
function updateBookmark() {
		var param = "param=updateBookmark&" + "uptitle=" + encodeURIComponent($F("uptitle")) + "&upurl=" + encodeURIComponent($F("upurl")) + "&updetail=" + encodeURIComponent($F("updetail"));
		new Ajax.Request("CategoryControl", 
			{method:"get",
			onComplete:setTree,
			parameters:param });
		return true;
		return true;
		
}
/* 카테고리updateBookmark */
function goBookmarkNavi() {
		$("mainForm").action="Category";
		$("mainForm").submit(); 
		return true;
}
/* bookmark */
function bookmark(url) {
		//alert(url);
		var frame = $('Page');
		frame.src = url;
	}   
	
/* goPage */
function goPage() {
		//alert(url);
		var url = $F('inputUrl');
		var frame = $('Page');
		frame.src = "http://"+ url;
	}  
/* goPage */
function updatePage() {
		//alert(url);
		var frame = $('Page');
		alert(frame.src);
	}  	
	
function Keycode(e){
		var result;
		if(window.event) {		
	    	result = window.event.keyCode;
	    } else if(e) {
			result = e.which;
		}
		return result;
	}	
//]]>
</script>
<link href="jsp/bookmark/tree.css" rel="stylesheet" type="text/css"> 
</head>
<body>
<form id ="mainForm" name="mainForm" method="post" style="margin:0" action="CategoryManagerAction">
	<input type="hidden" id="clickedbtn"  value="<c:out value="${clickedbtn}"/>">		
	<table border="1">
		<tr>
			<td valign="top">
				<table border="1">
				<tr>
					<td valign="top">
						<a href="http://localhost/Kankokujin/Index" target="_self">메인으로</a>
					</td>
				</tr>
				<tr>
					<td height="450" width="150" valign="top">
						<div class="elem" style="auto;" id = "tree" />
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
							http://<input type="text" size="120" id="inputUrl" onkeydown="if(Keycode(event) ==13) goPage();">
							<a href="javascript:goPage();" target="_self"><img src="jsp/bookmark/btn_cs_ok.gif"></a>
						</td>
					</tr>
					<tr>
						<td>
							<div id= "categoryAdd" style = "width:1000px; display:none">
								카테고리추가<br>
								이름:<input type="text" name="catename" id="catename" size="50" maxlength="42"><br>
								<img src="jsp/bookmark/regist.gif" onclick="return insertCategory()">
							</div>
							<div id= "categoryUpdate" style = "width:1000px; display:none">
								<input type="hidden" name = "updateCode" id = "updateCode" />	
								카테고리수정<br>
								이름:<input type="text" name="updateCodename" id = "updateCodename" " size="50" maxlength="42"><br>
								<img src="jsp/bookmark/regist.gif" onclick="return updateCategory()">
							</div>
							<div id= "bookMarkAdd" style = "width:1000px; display:none">
								북마크추가<br>
								싸이트명:<input type="text" name="title" size="50" maxlength="42"><br>
								장소(URL):<input type="text" name="url" size="50" maxlength="42"><br>
								상세정보:<input type="text" name="detail" size="50" maxlength="42"><br>
								<img src="jsp/bookmark/regist.gif" onclick="return insertBookmark()">
							</div>
							<div id= "bookMarkUpdate" style = "width:1000px; display:none">
								북마크추가<br>
								싸이트명:<input type="text" name="uptitle" id="title" size="50" maxlength="42"/><br>
								장소(URL):<input type="text" name="upurl" id="url" size="50" maxlength="100"/><br>
								상세정보:<input type="text" name="updetail" id="detail" size="50" maxlength="42"/><br>
								<img src="jsp/bookmark/regist.gif" onclick="return updateBookmark()">
							</div>
						</td>
					</tr>
					<tr>
						<td>
							<div id= "view">
								<iframe id ="Page" name = "Page" src="http://www.kankokujin.com" 
								 style="width:1000px; height:1450px; border: 0px" >
								</iframe>
						    <!--<a href="javascript:goBookmarkNavi();">북마크나비게이터로</a>-->
							</div>
							
						</td>
					</tr>
					
				
				</table>
				
			</td>
		</tr>
	</table>
</form>
</body>
</html>