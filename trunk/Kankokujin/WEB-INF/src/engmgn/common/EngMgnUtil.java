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
				// ‹æØ‚è•¶š‚ªŒ»‚ê‚È‚©‚Á‚½‚Ì‚ÅA‚»‚Ì‚Ü‚Ü•Ô‚·
				return path;
			} else {
				index = index2;
			}
		} else {
			if (index2 == -1) {
				index = index1;
			} else {
				// ‹æØ‚è•¶š‚ª—¼•û‚ ‚Á‚½‚Ì‚ÅA‚æ‚èŒã‚ë‚Ì•û‚ğÌ—p
				index = (index1 > index2) ? index1 : index2;
			}
		}
		return path.substring(index + 1);
	}


}
