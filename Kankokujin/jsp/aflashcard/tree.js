
var clickedSign;
/** init */
function init() {
	var forward = document.list.forward.value;
	var userId = document.list.userId.value;
	var param = "param=managerInit&userId=" + userId + "&forward=" + forward;
		new Ajax.Request("categoryctrl", 
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
function categoryClick(forward, code, userId) {
 	document.list.action = forward + "?categoryCode=" + code + "&userId=" + userId + "&categoryClick=ok";
	document.list.submit(); 
}

/** addGroup */
function addGroup() { 
	var groupCateName = $F("groupCateName");
 	var param = "param=addGroup&" + "codename=" + groupCateName;
		new Ajax.Request("categoryctrl", 
			{method:"get",
			onComplete:setTree,
			parameters:param });
}
/** addItem */
function addItem() { 
	var groupCateName = $F("cateName");
 	var param = "param=addItem&" + "codename=" + groupCateName;
		new Ajax.Request("categoryctrl", 
			{method:"get",
			onComplete:setTree,
			parameters:param });
}

		