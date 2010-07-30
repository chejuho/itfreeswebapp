<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<script language="JavaScript">
	function openClose(X) {
		var ray = new Array(1, 3, 5, 7, 9, 11, 13, 15, 17, 19);
		if (ttable.rows[ray[X-1]].style.display =="") {
			ttable.rows[ray[X-1]].style.display = "none";
			document.images[X-1].src="jsp/images/menu/menu_plus.gif";
		} else {
			ttable.rows[ray[X-1]].style.display = "";
			document.images[X-1].src="jsp/images/menu/menu_minus.gif";
		}
	}
	
	function menuClicked(cateCode){
		alert('test');
		

	}
</script>
<a href="ItemList">全てを見る</a><br>

<%=request.getAttribute("MenuTag")%>
