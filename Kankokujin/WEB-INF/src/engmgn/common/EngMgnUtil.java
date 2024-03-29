package engmgn.common;

import javax.servlet.http.HttpServlet;

import common.util.Util;

public class EngMgnUtil extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	

	public static String getChangeNullStr(String str) {
		if(Util.isEmpty(str)){
			str="*";
		}
		return str;
	}
	public static String getChangeNullInt(int num) {
		String number=String.valueOf(num);
		if(Util.isEmpty(number)){
			number="*";
		}
		return number;
	}

	public static String getBaseName(String path) {
		int index1 = path.lastIndexOf('\\');
		int index2 = path.lastIndexOf('/');
		int index;
		if (index1 == -1) {
			if (index2 == -1) {
				// 区切り文字が現れなかったので、そのまま返す
				return path;
			} else {
				index = index2;
			}
		} else {
			if (index2 == -1) {
				index = index1;
			} else {
				// 区切り文字が両方あったので、より後ろの方を採用
				index = (index1 > index2) ? index1 : index2;
			}
		}
		return path.substring(index + 1);
	}


}
