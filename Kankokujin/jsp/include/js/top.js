	function searchAll() {
		if(document.allsearch.all_search.value== "") {
			alert("검색어를 입력해 주세요.");
			return;
		}		
		document.allsearch.action="AllSearch";
		document.allsearch.submit(); 	
		return true;
	}
	function actionforward(actionpath){
		//alert(actionpath);
		document.allsearch.action=actionpath;
		document.allsearch.submit(); 
		return true;
	}
	function goBookMark(userid){
		//alert(actionpath);
		document.allsearch.action="Category?user_id=" + userid;
		document.allsearch.submit(); 
		return true;
	}
	function goBookMarkManager(userid){
		//alert(actionpath);
		document.allsearch.action="CategoryManager?user_id=" + userid;
		document.allsearch.submit(); 
		return true;
	}
	
var BannerHandler = Class.create();	
BannerHandler.prototype = {
	
	initialize: function(id, url) {
			this.id  = id;
			this.url = url;
			now=new Date();
			this.num =(now.getSeconds())% this.url.length;
			$(this.id).update(this.url[this.num]);
			this.show();               
		},	
		update: function(){
		//alert("update");
			this.num++;
			if (this.num == this.url.length) {
				this.num = 0;
			}
			this.show();
		},
		show: function(){
			//alert($(this.id));
			$(this.id).update(this.url[this.num]);
		
 		}
	};
	
	/** 初期化*/
	if (window.addEventListener) {
		window.addEventListener("load",bannerInit,false);
	} else if (window.attachEvent) {
		window.attachEvent("onload", bannerInit);
	}
	
	var link1 = new Array();
	var link2 = new Array();
	var banner1;
	var banner2;
	function bannerInit(){
		var index1 = $F("bannerIndex");	
	//	alert(index1);
		var index2 = $F("adIndex");
		/** link生成*/
		for (var i = 0;i <= index1; i++) {
			var name = "banner" +i;
			link1[i] = $F(name);
		}
		for (var i = 0;i <= index2; i++) {
			var name = "ad" + i;
			link2[i] = $F(name);
		}
		banner1 = new BannerHandler("banner", link1);
		banner2 = new BannerHandler("ad", link2);
		setInterval("banner1.update()", 4000);
		setInterval("banner2.update()", 4000);
	}
	