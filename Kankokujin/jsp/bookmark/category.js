/** init */
function init() {
//	alert("populateList Start");	
	var param = "param=init";
		new Ajax.Request("../../CategoryControl", 
			{method:"get",
			onComplete:setTree,
			parameters:param });
}
/** setTree */
function setTree(resp) {
	var recs = resp.responseText;
	$("tree").update = recs;
}

/** select */
function select(code) { 

 	var param = "param=select&" + "code=" + code;
		new Ajax.Request("../../CategoryControl", 
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