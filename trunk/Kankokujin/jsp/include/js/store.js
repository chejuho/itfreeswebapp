
	function actionforward(actionpath){
		//alert(actionpath);
		document.list.action=actionpath;
		document.list.submit(); 
		return true;
	}
	function reloadAreaLineSearch(obj) {
		if(obj == "0"){
			document.list.action="StoreSearch?re=0";
		} else if (obj == "1"){
			document.list.action="StoreSearch?re=1";
		}
		
		document.list.submit(); 
		return true;
	}
	function registOpen(ff) {
		ff.action="StoreRegistOpen?before=search&f=search";
		ff.submit(); 
		return true;
	}	

	function storePageSize(ff) {
		ff.action="StoreSearch?re=9";
		ff.submit(); 
		return true;
	}
	function reloadPage(obj) {
		document.list.action="StoreSearch?pageNum="+obj;
		document.list.submit(); 
		return true;
	}
	function reloadCate_code_1(obj) {
		document.list.action="StoreSearch?re=9&search_cate_code_1=" + obj + "&search_cate_code_2=&before_cate_code_2=";
		document.list.submit(); 	
		return true;
	}
	function reloadCate_code_2(cate_code_1, cate_code_2) {
		document.list.action="StoreSearch?re=9&search_cate_code_1=" + cate_code_1 + "&search_cate_code_2=" + cate_code_2;
		document.list.submit(); 	
		return true;
	}
	function searchStore(cate_code_1, cate_code_2) {
		document.list.action="StoreSearch?re=9&search_cate_code_1=" + cate_code_1 + "&search_cate_code_2=" + cate_code_2;
		document.list.submit(); 	
		return true;
	}	

	function my_write(user_id) {
		if (user_id == '') {
			user_id = "-";
		}
		if(user_id == "-"){
			document.list.action="StoreSearch?re=9&user_id=-";
		} else if(user_id == "_"){
			document.list.action="StoreSearch?re=9&user_id=";
		} else {
			document.list.action="StoreSearch?re=9&user_id=" + user_id;
		}			
		document.list.submit(); 
		return true;
	}
	function openDetailPage(id) {

		document.list.action="StoreDetail?before=search&id=" + id;
		document.list.submit(); 
		return true;
	}
		/* 
	 * ログイン
	 */
	function logIn(){
		//window.open('PopLogin', 'notice', 'width=230, height=160');		
		document.allsearch.action="MemberLoginOpen";
		document.allsearch.submit(); 
	}
	/* 
	 * 画面遷移
	 */
	function actionforward(actionpath){
		//alert(actionpath);
		document.allsearch.action=actionpath;
		document.allsearch.submit(); 
		return true;
	}
	
	function adminLogIn(){
		window.open('AdminLoginOpen', 'notice', 'width=230, height=160');		
	}
	
	function popup() {
	    var str = document.getElementById("disp").src;
		wo = window.open(str.replace("/M_", "/L_"), "popup", "toolbar=no, location=no, directories=no, status=no, menubar=no, scrollbars=yes, resizable=no, left=0,top=0 border=0");
		wo.resizeTo(screen.width,screen.height);
		return;
	}
	function deleteCheck(id, wf){
	
			if(confirm("삭제하시겠습니까?")){
				wf.action="StoreDelete?id="+id;
				wf.submit(); 
				return true;
			}
	}
	function openUpdate(id){
		document.wf.action="StoreUpdateOpen?id=" + id;
		document.wf.submit(); 
		return true;
	}	
	function setImage(position){
		document.getElementById("disp").src = position;
		return false;
	}	
	function backSearchPage() {
		document.wf.action="StoreSearch?re=9&modoru=ok";
		document.wf.submit(); 
		return true;
	}
	function backMySearchPage(ff, obj) {
		ff.submit(); 
		return true;
	}	
	function backSearchAllPage() {
		document.wf.action="AllSearch";
		document.wf.submit(); 
		return true;
	}	
	function backMyWrite() {
		document.wf.action="MyWrite?sort=3";
		document.wf.submit(); 
		return true;
	}