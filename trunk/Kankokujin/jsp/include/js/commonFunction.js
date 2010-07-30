
/**
 大きく見る
**/
	function popup() {
	    var str = document.getElementById("disp").src;
		var title = document.wf.title.value;
		var photo1 = document.wf.photo1.value;
		var photo2 = document.wf.photo2.value;
		var photo3 = document.wf.photo3.value;
		var photo4 = document.wf.photo4.value;
		var photo5 = document.wf.photo5.value;
		var url = "ImagePopupOpen?photo1=" + photo1 + "&photo2=" + photo2+ "&photo3=" + photo3+ "&photo4=" + photo4+ "&photo5=" + photo5 + "&title=" + title;
		var windowWidth = screen.width;
		var windowHeight = screen.height - 100;		
		wo = window.open(url,'imageViewer','scrollbars=yes,resizable=yes,' + 'width=' + windowWidth + ',height=' + windowHeight + "'");		
		
		//alert(screen.width);
		//alert(screen.height);
		//wo.resizeTo(screen.width,screen.height);
		wo.moveTo(0,0);
		wo.focus();
	}

	/* 
	 * メールOPEN 
	 * sort:1(Buysell) sort:2(Store) sort:3(Gourmet) sort:4(RoomSell) sort:5(HouseSell) sort:6(JobSearch) sort:7(FindJob)
	 */
	function mailOpen(id, username , sort) {
		var url ="MailSendOpen?id=" + id + "&username=" + encodeURIComponent(username) + "&sort=" + sort;
		var newWindow =  window.open(url, "メール", "width = 550, height=550, location=no, toolbar=no");
		newWindow.moveTo(350,150);
		newWindow.focus();
	}
	
	
		/* 
	 * メールOPEN 
	 */
	function mailOpenDetailAction() {
		if ($("loginSign").value == "false") {
			alert("이기능은 로그인후에 사용가능합니다.");
			return false;
		}
		var url ="MailSendOpen?id=" + clickedId + "sort=detail";
		var newWindow =  window.open(url, "メール", "width = 550, height=450, location=no, toolbar=no");
		newWindow.moveTo(0,0);
		newWindow.focus();
	}
	/* 
	 * bookmarkに追加
	 */
	function bookmarksite(title,url) { 
  		// firefox
  		if (window.sidebar) {
			window.sidebar.addPanel(title, url, ""); 
		}
		// opera
		else if(window.opera && window.print) {  
		    var elem = document.createElement('a'); 
		    elem.setAttribute('href',url); 
		    elem.setAttribute('title',title); 
		    elem.setAttribute('rel','sidebar'); 
		    elem.click(); 
		// ie 
		} else if(document.all) {
			window.external.AddFavorite(url, title);
		}
	} 
	
	/* 
	 * bookmarkに追加
	 */
	function pwdcheck(pwd) {
	    chk1 = /^[a-z\d]{1,12}$/i;//a-zと 0-9以外の文字があるのを確認
	    //chk2 = /[a-z]/i;  //적어도 한개의 a-z 확인
	    //chk3 = /\d/;  //적어도 한개의 0-9 확인
	    return chk1.test(pwd);
	}
	
	function getFileExtension(filePath) {
	  var lastIndex = -1;
	  lastIndex = filePath.lastIndexOf('.');
	  var extension = "";
	  if ( lastIndex != -1 ) {
	    extension = filePath.substring( lastIndex+1, filePath.length);
	  }
	  else {
	    extension = "";
	  }
	
	  return extension;
	}
	
	/* Upload イメージチェック*/
	function uploadImageCheck(obj, index) {
		var maxSize = 2 * 1024 * 1024; 
		var value = obj.value;
		var src = getFileExtension(obj.value);
		if (src == "") {
			return true;
		}
		else if ( !((src.toLowerCase() == "gif") || (src.toLowerCase() == "jpg") || (src.toLowerCase() == "jpeg")) ) {
			alert('이미지파일' +index+ '은 gif, jpg 형식이 아닙니다.');
			//resetImage(obj);
			return false;
		}
		
		var img = new Image();
		img.dynsrc = value;
		var filesize = img.fileSize;
		
		if (filesize > maxSize) {
			alert('그림 파일' +index+ '은 허용 최대크기인 ' + maxSize/1024 + 'Kbyte 를 초과하였습니다.');
			//resetImage(obj);
			return false;
		}
		return true;
	}
	function resetImage(obj) {
	  	obj.select();
        document.selection.clear();	
	}
	function isNickNameCheck(obj) {
	  	var str = obj.value;
		if(str.length < 2 || str.length > 20) {
			return false;
		}
		return true;
	}
	
	
	function setCookie (name, value, expires) {
		document.cookie = name + "=" + escape (value) + "; path=/; expires=" + expires.toGMTString();
	}
	
	function getCookie(Name) {
	  var search = Name + "="
	  if (document.cookie.length > 0) {
	    offset = document.cookie.indexOf(search)
	    if (offset != -1) { 
	      offset += search.length
	      // set index of beginning of value
	      end = document.cookie.indexOf(";", offset)
	      if (end == -1)
	        end = document.cookie.length
	      return unescape(document.cookie.substring(offset, end))
	    }
	  }
	  return "";
	}

	