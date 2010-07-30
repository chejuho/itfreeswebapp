
var clickedSign;
/** init */
function init() {
	
	var param = "param=managerInit&";
		new Ajax.Request("CategoryControl", 
			{method:"get",
			onComplete:setTree,
			parameters:param });
}
/** setTree */
function setTree(resp) {
	var recs = resp.responseText;
	$("tree").innerHTML = recs;
	//alert(clickedSign);	
}

/** categoryClick */
function categoryClick(code) {
	clickedSign = "category";	
 	var param = "param=managerSelect&" + "code=" + code;
		new Ajax.Request("CategoryControl", 
			{method:"get",
			onComplete:setTree,
			parameters:param });
}
/** categoryClick */
function bookMarkClick(code, url) {
	allHide();
	$("view").show();
	var frame = $('Page');
	frame.src = url;
	clickedSign = "bookMark";
 	var param = "param=managerSelect&" + "code=" + code;
		new Ajax.Request("CategoryControl", 
			{method:"get",
			onComplete:setTree,
			parameters:param });
}
/** addGroup */
function addGroup() { 
	var groupCateName = $F("groupCateName");
 	var param = "param=addGroup&" + "codename=" + groupCateName;
		new Ajax.Request("CategoryControl", 
			{method:"get",
			onComplete:setTree,
			parameters:param });
}
/** addItem */
function addItem() { 
	var groupCateName = $F("cateName");
 	var param = "param=addItem&" + "codename=" + groupCateName;
		new Ajax.Request("CategoryControl", 
			{method:"get",
			onComplete:setTree,
			parameters:param });
}

function allHide() {
	//$("view").hide();
	//var frame = $('Page');
	//frame.src = "";
	$("categoryAdd").hide();
	$("categoryUpdate").hide();
	$("bookMarkAdd").hide();
	$("bookMarkUpdate").hide();
		
} 