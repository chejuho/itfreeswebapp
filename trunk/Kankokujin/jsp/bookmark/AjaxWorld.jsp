
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Ajax</title>
<style type="text/css">
div.elem { magin: 20px; } 
</style>
<script type="text/javascript" src = "../Scripts/prototype.js"></script>
<script type="text/javascript">
//<![CDATA[
           
/* サーバから情報取得する */
function populateList() {
//	alert("populateList Start");
	var param = "param="+$F("test");
	//alert(param);
		new Ajax.Request("../../AjaxServlet", 
			{method:"get",
			onComplete:getCities,
			parameters:param });
}
function getCities(resp) {
	var recs = resp.responseText;
	//alert(recs);
	$("cities").innerHTML = "<select>" + recs + "</select>";
	//document.getElementById('cities').innerHTML ="<select>" + recs + "</select>";
}
//]]>
</script>

</head>
<body>

<h3>都道府県</h3>
<form action="../../AjaxServlet" method="get">
<div class =elem">
<select id = "test" onchange="populateList()">
<option value = "HO">北海道</option>
<option value = "FU">福井県</option>
<option value = "NA">長野県</option>
<option value = "OK">沖縄県</option>
</select>
</div>
<h3>都市</h3>
<div class="elem" id = "cities">
<select>
</select>
</div>

<input type = "submit" />
</form>
</body>
</html>
</body>
</html>