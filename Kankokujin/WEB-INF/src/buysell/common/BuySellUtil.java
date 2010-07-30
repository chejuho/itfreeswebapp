package buysell.common;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import common.exception.AppException;
import common.util.Util;

public class BuySellUtil extends HttpServlet {
	private static final long serialVersionUID = 1L;

	


	public String changeData(HttpServletRequest request, String language,String sign) throws AppException{
		int size = language.length();
		String newLanguage = "";
		for(int i=0;i<size;i++){
			String str = changeLanguage(request,language.substring(i, i+1));
			newLanguage += str;
			if(i<size-1){
				newLanguage += sign;
			}
		}
	
		return newLanguage;
	}

	public String changeLanguage(HttpServletRequest request, String number) throws AppException{
		String language = "";
		if(!Util.isEmpty(number)){
			int no = Integer.valueOf(number);
			switch (no) {
			case 0:
				language = Util.getConstantValue(request, "korean");
				break;
			case 1:
				language = Util.getConstantValue(request, "japanese");
				break;
			case 2:
				language = Util.getConstantValue(request, "english");
				break;
			case 3:
				language = Util.getConstantValue(request, "chinese");
				break;		
			default:
				language = "";
				break;	
			}
		}
		return language;
	}
	
	public String changeNation(HttpServletRequest request, String number) throws AppException{
		String nation = "";
		if(!Util.isEmpty(number)){
			int no = Integer.valueOf(number);
			switch (no) {
			case 0:
				nation = Util.getConstantValue(request, "korea");
				break;
			case 1:
				nation = Util.getConstantValue(request, "japan");
				break;
			case 2:
				nation = Util.getConstantValue(request, "america");
				break;
			case 3:
				nation = Util.getConstantValue(request, "china");
				break;
			default:
				nation = "";
				break;
			}
		}
		return nation;
	}


	public String changeSex(HttpServletRequest request, String number) throws AppException{
		String sex = "";
		if(!Util.isEmpty(number)){
			int no = Integer.valueOf(number);
			switch (no) {
			case 0:
				sex = Util.getConstantValue(request, "male");
				break;
			case 1:
				sex = Util.getConstantValue(request, "female");
				break;	
			default:
				sex = "";
				break;
			}
		}
		return sex;
	}
	
	public String changePayUnit(HttpServletRequest request, String number) throws AppException{
		String payUnit = "";
		if(!Util.isEmpty(number)){
			int no = Integer.valueOf(number);
			switch (no) {
			case 0:
				payUnit = Util.getConstantValue(request, "won");
				break;
			case 1:
				payUnit = Util.getConstantValue(request, "yen");
				break;
			case 2:
				payUnit = Util.getConstantValue(request, "dollar");
				break;	
			default:
				payUnit = "";
				break;
			}
		}
		return payUnit;
	}

}
