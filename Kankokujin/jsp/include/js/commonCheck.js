
/**
 電話番号チェック
**/
function telephoneNoCheck(tel_no1, tel_no2, tel_no3) {
	ID = /^[0-9]{1,4}/;		
	if(!isNull(tel_no1) || !isNull(tel_no2) || !isNull(tel_no3)) {
		if(!isNumber(tel_no1) || !isNumber(tel_no2) || !isNumber(tel_no3)) {
			return false;
		}  
		if(!ID.test(tel_no1.value) || !ID.test(tel_no2.value) ||!ID.test(tel_no3.value)){
			return false;
		}
	}
	return true;
}

function isNull(obj) {
	if(obj.value == "") {
		return true;
	}
}
function isNumber(obj) {
	var str = obj.value;
	if(str.length == 0){
	
		return false;
	}
	for(var i=0; i < str.length; i++) {
		if(!('0' <= str.charAt(i) && str.charAt(i) <= '9'))
			return false;
	}
	return true;
}