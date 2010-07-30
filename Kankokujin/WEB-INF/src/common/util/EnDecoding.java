package common.util;

import java.io.UnsupportedEncodingException;

public class EnDecoding {
	public EnDecoding() {
	}

	public static String decoding(String s) {
		try {
			if (!Util.isEmpty(s)){
				return new String(s.getBytes("8859_1"), "UTF-8");
			} else {
				return "";
			}
		} catch (UnsupportedEncodingException ex) {
			String k = ex.getMessage();
			return k;
		}
	}

	public static String encoding(String s) {
		try {
			if (!Util.isEmpty(s)){
				return new String(s.getBytes("UTF-8"), "8859_1");
			} else {
				return "";
			}
		} catch (UnsupportedEncodingException ex) {
			String k = ex.getMessage();
			return k;
		}
	}
	
	public static String kordecoding(String s) {
		try {
			if (!Util.isEmpty(s)){
				return new String(s.getBytes("8859_1"), "EUC-KR");
			} else {
				return "";
			}
		} catch (UnsupportedEncodingException ex) {
			String k = ex.getMessage();
			return k;
		}
	}

}