package common.util;

import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.math.BigDecimal;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import menu.bean.MenuBean;

import common.bean.MemberBean;
import common.constant.Const;
import common.exception.AppException;
import common.handler.UtilHandler;

public class Util {

	private final static String SMALL = "S_";
	private final static String MIDDLE = "M_";
	private final static String LARGE = "L_";
	
	private final static String ERROR_COUNT = "errorCount";
	
	/**
	 * 
	 * @param session
	 * @return
	 */
	public static boolean retry(HttpSession session) {
		
		Integer errorCnt = (Integer) session.getAttribute(ERROR_COUNT);
		
		if (errorCnt == null) {
			errorCnt = 0;
		}
		
		if (errorCnt == 3) {
			
			return false;
		}
		session.setAttribute(ERROR_COUNT, new Integer(errorCnt.intValue() + 1));
		
		return true;
		
	}
	
	/**
	 * 
	 * @param session
	 * @return
	 */
	public static void errorCntInit(HttpSession session) {
		
		session.setAttribute(ERROR_COUNT, new Integer(0));
		
	}
	
	/*
	 * 1000*780�A530*350�A50*50�C���[�W�t�@�C�����ꂼ��쐬
	 */
	public static void makeResizeFile(MenuBean requestBean) {
		
		String photo_name1 = (String) requestBean.get("photo_name1");
		
		String photo_name2 = (String) requestBean.get("photo_name2");
	
		String photo_name3 = (String) requestBean.get("photo_name3");
		
		String photo_name4 = (String) requestBean.get("photo_name4");
		
		String photo_name5 = (String) requestBean.get("photo_name5");
		
		processMakeResize(photo_name1, photo_name2, photo_name3, photo_name4, photo_name5);
	}

	/**
	 * 
	 * @param photo_name1
	 * @param photo_name2
	 * @param photo_name3
	 * @param photo_name4
	 * @param photo_name5
	 */
	public static void processMakeResize(String photo_name1, String photo_name2, String photo_name3, String photo_name4, String photo_name5) {
		
		if (!isEmpty(photo_name1)) {
			String photo_file_input1 = Const.UPLOAD_FOLDER_PATH + photo_name1;
			resize(1000, 780, photo_file_input1, Const.UPLOAD_FOLDER_PATH + LARGE + photo_name1);
			resize( 482, 366, photo_file_input1, Const.UPLOAD_FOLDER_PATH + MIDDLE + photo_name1);
			resize(  60,  60, photo_file_input1, Const.UPLOAD_FOLDER_PATH + SMALL + photo_name1);
			fileDelete(photo_file_input1);
		}
		if (!isEmpty(photo_name2)) {
			String photo_file_input2 = Const.UPLOAD_FOLDER_PATH +photo_name2;
			
			resize(1000, 780, photo_file_input2, Const.UPLOAD_FOLDER_PATH + LARGE + photo_name2);
			resize( 482, 366, photo_file_input2, Const.UPLOAD_FOLDER_PATH + MIDDLE + photo_name2);
			resize(  50,  50, photo_file_input2, Const.UPLOAD_FOLDER_PATH + SMALL + photo_name2);
			fileDelete(photo_file_input2);
		}
		if (!isEmpty(photo_name3)) {
			String photo_file_input3 = Const.UPLOAD_FOLDER_PATH + photo_name3;
			
			resize(1000, 780, photo_file_input3, Const.UPLOAD_FOLDER_PATH + LARGE + photo_name3);
			resize( 482, 366, photo_file_input3, Const.UPLOAD_FOLDER_PATH + MIDDLE + photo_name3);
			resize(  50,  50, photo_file_input3, Const.UPLOAD_FOLDER_PATH + SMALL + photo_name3);
			fileDelete(photo_file_input3);
		}
		if (!isEmpty(photo_name4)) {
			String photo_file_input4 = Const.UPLOAD_FOLDER_PATH + photo_name4;
			
			resize(1000, 780, photo_file_input4, Const.UPLOAD_FOLDER_PATH + LARGE + photo_name4);
			resize( 482, 366, photo_file_input4, Const.UPLOAD_FOLDER_PATH + MIDDLE + photo_name4);
			resize(  50,  50, photo_file_input4, Const.UPLOAD_FOLDER_PATH + SMALL + photo_name4);
			fileDelete(photo_file_input4);
		}
		if (!isEmpty(photo_name5)) {
			String photo_file_input5 = Const.UPLOAD_FOLDER_PATH + photo_name5;
			
			resize(1000, 780, photo_file_input5, Const.UPLOAD_FOLDER_PATH + LARGE + photo_name5);
			resize( 482, 366, photo_file_input5, Const.UPLOAD_FOLDER_PATH + MIDDLE + photo_name5);
			resize(  50,  50, photo_file_input5, Const.UPLOAD_FOLDER_PATH + SMALL + photo_name5);
			fileDelete(photo_file_input5);
		}
	}

	private static void fileDelete(String file_str) {
		File file = new File(file_str);
		file.delete();
		
	}

	/**
	 * 
	 * @param width   ��
	 * @param height�@����
	 * @param old_file_name�@
	 * @param new_file_name
	 */
	public static void resize(
			int width,
			int height,
			String input_file_name,
			String out_file_name) {
			File file = null;
		try {
			file = new File(input_file_name);
			ImageIO.setUseCache(true);

			BufferedImage src = ImageIO.read(file);

			int new_image_width = 0;
			int new_image_height = 0;

			double image_width = src.getWidth();
			double image_height = src.getHeight();

			// �C���[�W�{���T�C�Y�̕����w�肷�镝���傫���ꍇ
			if (image_width > width) {

				new_image_width = width;
				new_image_height = (int) (width * image_height / image_width);
			} else {
				new_image_width = (int) image_width;
				new_image_height = (int) image_height;
			}
			// �V�����v�Z�����������w�肷�鍂�����傫���ꍇ
			if (new_image_height > height) {

				new_image_width = (int) (height * new_image_width / new_image_height);
				new_image_height = height;
				
			}

			double resize_rate_width = new_image_width / image_width;
			double resize_rate_height = new_image_height / image_height;

			AffineTransform tx = new AffineTransform();
			tx.scale(resize_rate_width, resize_rate_height);

			RenderingHints rh = new RenderingHints(
					RenderingHints.KEY_ANTIALIASING,
					RenderingHints.VALUE_ANTIALIAS_ON);
			rh.put(RenderingHints.KEY_ALPHA_INTERPOLATION,
					RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
			rh.put(RenderingHints.KEY_COLOR_RENDERING,
					RenderingHints.VALUE_COLOR_RENDER_QUALITY);
			rh.put(RenderingHints.KEY_INTERPOLATION,
					RenderingHints.VALUE_INTERPOLATION_BICUBIC);
			rh.put(RenderingHints.KEY_RENDERING,
					RenderingHints.VALUE_RENDER_QUALITY);
			rh.put(RenderingHints.KEY_STROKE_CONTROL,
					RenderingHints.VALUE_STROKE_PURE);
			rh.put(RenderingHints.KEY_TEXT_ANTIALIASING,
					RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

			AffineTransformOp op = new AffineTransformOp(tx, rh);
			BufferedImage biNew = new BufferedImage(new_image_width,
					new_image_height, src.getType());

			op.filter(src, biNew);

			ImageIO.write(biNew, "jpg", new File(out_file_name));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void resize(int width, String old_file_name,
			String new_file_name) {
		File file = null;
		try {
			file = new File(old_file_name);

			ImageIO.setUseCache(true);

			BufferedImage src = ImageIO.read(file);

			double image_width = src.getWidth();
			double image_height = src.getHeight();

			double resize_width = 0;

			// �C���[�W�{���T�C�Y�̕����w�肷�镝���傫���ꍇ
			if (image_width < width) {
				resize_width = image_width;
			} else {
				resize_width = width;
			}

			double resize_rate = resize_width / image_width;

			if (image_height * resize_rate > resize_width) {
				resize_rate = resize_width / image_height;
			}

			if (resize_rate > 0.8D) {
				resize_rate = 1.0D;
			}

			int new_image_width = (int) (image_width * resize_rate);
			int new_image_height = (int) (image_height * resize_rate);

			AffineTransform tx = new AffineTransform();
			tx.scale(resize_rate, resize_rate);

			RenderingHints rh = new RenderingHints(
					RenderingHints.KEY_ANTIALIASING,
					RenderingHints.VALUE_ANTIALIAS_ON);
			rh.put(RenderingHints.KEY_ALPHA_INTERPOLATION,
					RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
			rh.put(RenderingHints.KEY_COLOR_RENDERING,
					RenderingHints.VALUE_COLOR_RENDER_QUALITY);
			rh.put(RenderingHints.KEY_INTERPOLATION,
					RenderingHints.VALUE_INTERPOLATION_BICUBIC);
			rh.put(RenderingHints.KEY_RENDERING,
					RenderingHints.VALUE_RENDER_QUALITY);
			rh.put(RenderingHints.KEY_STROKE_CONTROL,
					RenderingHints.VALUE_STROKE_PURE);
			rh.put(RenderingHints.KEY_TEXT_ANTIALIASING,
					RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

			AffineTransformOp op = new AffineTransformOp(tx, rh);
			BufferedImage biNew = new BufferedImage(new_image_width,
					new_image_height, src.getType());

			op.filter(src, biNew);

			ImageIO.write(biNew, "jpg", new File(new_file_name));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public static String changePhotoPath(String photoPath) {
		if (Util.isEmpty(photoPath)) {
			return "";
		}
		String[] photo_path = { ".JPG", ".jpg", ".JPEG", ".jpeg", ".GIF",
				".gif" };
		boolean isExist = false;
		for (int i = 0; i < photo_path.length; i++) {
			if ((photoPath.indexOf(photo_path[i]) != -1)) {
				isExist = true;
			}
		}
		if (!isExist) {
			photoPath = "";
		}
		return photoPath;
	}

	public static String changeNullCode(int sort, String inputstr) {
		if (Util.isEmpty(inputstr)) {
			if (sort == 0) {
				return "00";
			} else if (sort == 1) {
				return "0000";
			} else {
				return inputstr;
			}
		} else {
			return inputstr;
		}

	}

	public static String changeManToPrice(String man) {
		String price = "";
		try {
			BigDecimal bigDecimal = new BigDecimal(man);
			bigDecimal = bigDecimal.multiply(new BigDecimal("10000"));
			// System.out.println(bigDecimal.intValue());
			price = String.valueOf(bigDecimal.intValue());
		} catch (Exception e) {

		}

		return price;
	}

	public static String changePriceToMan(String price) {
		String man = "";
		try {
			BigDecimal bigDecimal = new BigDecimal(price);
			bigDecimal = bigDecimal.divide(new BigDecimal("10000"));
			// System.out.println(bigDecimal.intValue());
			man = String.valueOf(bigDecimal.toString());
		} catch (Exception e) {

		}

		return man;
	}

	public static String getRND(String sStartChar) {
		Random random = new Random();
		String NANValue = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		int nMAX_LNG = 12;
		StringBuffer sTemp = new StringBuffer(sStartChar);

		for (int i = 1; i < nMAX_LNG; i++) {
			int nRnd = random.nextInt(36);
			sTemp.append(NANValue.substring(nRnd, nRnd + 1));
		}

		return sTemp.toString();
	}

	/**
	 * ���BĂ��邩��`�F�b�N����i���O�C������Ă��邩�j
	 */
	public static boolean hasPrivilege(HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		MemberBean memberBean = (MemberBean) session.getAttribute("memberInfo");
		boolean result = true;
		if (memberBean == null || isEmpty(memberBean.getUserid())) {
			result = false;
		} else if (!"9".equals(memberBean.getUser_level())) {
			result = false;
		}
		return result;
	}

	public static boolean isLogin(HttpServletRequest request) {

		return isLogin(request, "memberInfo");
	}

	public static boolean isLogin(HttpServletRequest request, String attrName) {

		HttpSession session = request.getSession();
		MemberBean memberBean = (MemberBean) session.getAttribute(attrName);
		boolean result = true;
		if (memberBean == null || isEmpty(memberBean.getUserid())) {
			result = false;
		}
		return result;
	}

	public static String changeNullStr(Object input) {
		String result = (String) input;

		if (result == null || "null".equals(result)) {
			result = "";
		}
		return result;
	}

	public static String changeNullInt(String input) {

		if (input == null || Util.isEmpty(input)) {
			input = "0";
		}
		return input;
	}

	public static String changeNullStrToNull(String input) {

		if (Util.isEmpty(input)) {
			return null;
		}
		return input;
	}

	public static String changeRnToBrTag(Object input) {
		String result = (String) input;

		if (result != null) {
			result = result.replaceAll("\r\n", "<br>");
		}

		return result;
	}

	public static boolean isEmpty(String input) {
		boolean result = false;

		if (input == null || "".equals(input) || "null".equals(input)) {
			result = true;
		}
		return result;
	}

	public static String changeBrToRnTag(Object input) {
		String result = (String) input;
		if (result != null) {
			result = result.replaceAll("<br>", "\r\n");
		}

		return result;
	}

	public static String getMapInfo(Object input) {
		// input = "�����s�V�h��̕��꒬2-42-13";
		StringBuffer sb = new StringBuffer();
		if (input != null) {
			// sb.append("<script type='text/javascript'>");
			// sb.append("<!--");

			sb.append("function load() {");
			sb.append("if (GBrowserIsCompatible()) {");
			sb.append("map = new GMap2(document.getElementById('map'));");
			sb.append("map.addControl(new GMapTypeControl());");
			sb.append("map.addControl(new GLargeMapControl());");
			sb.append("geocoder = new GClientGeocoder();");
			sb.append("moveAddress('");
			sb.append(input);
			sb.append("');");
			sb.append("}");
			sb.append("}");
			// sb.append("//-->");
			// sb.append("</script>");

		}

		return sb.toString();
	}

	public static String[] changeStrToCheckedArray(String inputStr) {
		int arrayLength = inputStr.length();
		String[] result = new String[arrayLength];

		for (int i = 0; i < arrayLength; i++) {
			if (inputStr.charAt(i) == '1') {
				result[i] = "checked";
			} else {
				result[i] = "";
			}

		}
		return result;
	}

	public static String[] changeStrToArray(String inputStr) {

		inputStr = changeNullStr(inputStr);
		int size = inputStr.length();
		String[] result = null;
		if (size == 0) {
			result = new String[] { "" };
		} else {
			result = new String[size];
			for (int i = 0; i < inputStr.length(); i++) {
				result[i] = inputStr.substring(i, i + 1);
			}
		}

		return result;
	}

	public static String changeArrayToStr(String[] arrayStr) {
		int arraylength = arrayStr.length;
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < arraylength; i++) {
			String temp = arrayStr[i];
			if ("1".equals(temp)) {
				sb.append("1");
			} else {
				sb.append("0");
			}
		}
		return sb.toString();
	}

	public static String getConstantValue(HttpServletRequest request, String key)
			throws AppException {
		HttpSession session = request.getSession();
		Map hashmap = (HashMap) session.getAttribute("constant_map");
		if (hashmap == null) {
			hashmap = UtilHandler.getConstantMap();
			session.setAttribute("constant_map", hashmap);
		}
		return (String) EnDecoding.decoding(Util
				.changeNullStr(hashmap.get(key)));
	}

	public static String getKoreanAge(String yyyymm) {
		String age = "";
		if (!isEmpty(yyyymm) && yyyymm.length() > 4) {
			Calendar calendar = Calendar.getInstance();
			age = String.valueOf(calendar.get(Calendar.YEAR)
					- Integer.parseInt(yyyymm.substring(0, 4)) + 1);
		} else {
			age = "";
		}

		return age;
	}

	public static String getKoreanAgeYear(String age) {
		String yyyy = "";
		String mm = "";
		Calendar calendar = Calendar.getInstance();
		// int month = Integer.valueOf(calendar.get(Calendar.MONTH))+1;
		// if(month<10){
		// mm = "0"+ month;
		// }

		mm = "01";

		if (!isEmpty(age)) {
			yyyy = String.valueOf(calendar.get(Calendar.YEAR)
					- Integer.parseInt(age) + 1);
		} else {
			yyyy = "";
		}

		return yyyy + mm;
	}

	public static String getSecurityInfo(String info, String flg) {
		if (!Util.isEmpty(info)) {
			if (!"1".equals(flg)) {
				info = "XXXXX";
			}
		}
		return info;
	}

	public static String getRegistDate(Date date) {

		// SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd");
		return sdf.format(date);

		//		
		// String _date = day.substring(0, 10);
		// Date _today = new Date();
		// SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		// String today = sdf.format(_today);
		//
		// if (today.equals(_date)) {
		// _date = day.substring(11, 16);
		// } else {
		// SimpleDateFormat sdfDate = new SimpleDateFormat("yy/MM/dd");
		// _date = sdfDate.format(date);
		// }

		// return _date;
	}

	public static String getUpdateDate(Date date) {
		if (date != null) {
			SimpleDateFormat sdf1 = new SimpleDateFormat("MM/dd");
			SimpleDateFormat sdf2 = new SimpleDateFormat("kk:mm");
			if (isNew(date)) {
				return sdf2.format(date);
			} else {
				return sdf1.format(date);
			}
		} else {
			return "";
		}

	}

	public static String getUpdateDateFull(Date date) {
		if (date != null) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd kk:mm");
			return sdf.format(date);
		} else {
			return "";
		}
	}

	public static boolean isNew(Date inputDate) {
		if (inputDate == null) {
			return false;
		}
		Date nowDate = new Date();
		long nowTime = nowDate.getTime();
		long oneDayBefore = nowTime - (1000 * 60 * 60 * 24);
		long inputDateTime = inputDate.getTime();
		if (inputDateTime > oneDayBefore) {
			return true;
		} else {
			return false;
		}
	}

	public static String getNewImage(Date inputDate) {
		if (isNew(inputDate)) {
			return " <img src='jsp/images/new/new_icon1.gif'>";
		} else {
			return "";
		}
	}

	public static String changePayUnit(HttpServletRequest request, String number)
			throws AppException {
		String payUnit = "";
		if (!Util.isEmpty(number)) {
			int no = Integer.valueOf(number);
			switch (no) {
			case 0:
				payUnit = Util.getConstantValue(request, "yen");
				break;
			case 1:
				payUnit = Util.getConstantValue(request, "won");
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

	static public String changeData(HttpServletRequest request,
			String language, String sign) throws AppException {
		int size = language.length();
		String newLanguage = "";
		for (int i = 0; i < size; i++) {
			String str = changeLanguage(request, language.substring(i, i + 1));
			newLanguage += str;
			if (i < size - 1) {
				newLanguage += sign;
			}
		}

		return newLanguage;
	}

	static public String changeLanguage(HttpServletRequest request,
			String number) throws AppException {
		String language = "";
		if (!Util.isEmpty(number)) {
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

	static public String changeNation(HttpServletRequest request, String number)
			throws AppException {
		String nation = "";
		if (!Util.isEmpty(number)) {
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

	static public String changeSex(HttpServletRequest request, String number)
			throws AppException {
		String sex = "";
		if (!Util.isEmpty(number)) {
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

	static public String getShortName(String name) {

		if (name != null && name.length() > 7) {
			return name.substring(0, 7);
		} else {
			return name;
		}
	}

	static public String cutLongName(int length, String name) {
		if (name != null && name.length() > length) {
			StringBuffer sb = new StringBuffer();
			sb.append(name.substring(0, length));
			sb.append("…");
			return sb.toString();
		} else {
			return name;
		}
	}
	
	static public boolean isNumber(String checkNum) {
		boolean check = true;
		try{
			Integer.parseInt(checkNum);
		} catch (NumberFormatException e){
			check = false;
		}
		return check;
	}
	
	
	
	public static String password(String input)  {
		byte[] bpara = new byte[input.length()];
		byte[] rethash;
		
		for (int i = 0; i < input.length(); i++) {
			bpara[i] = (byte)(input.charAt(i) & 0xff);
		}
		 try {
				MessageDigest md = MessageDigest.getInstance("SHA1");
				rethash = md.digest(bpara);
				rethash = md.digest(rethash);
			} catch (NoSuchAlgorithmException e) {
				// �͏�N �䐌�� ��׈� ������ ���ސ� ���w Exception �~��
				throw new RuntimeException("SHA1" + " Algorithm Not Found", e);
			}
		
		StringBuilder sb = new StringBuilder(41);
		sb.append("*");
		for (int i = 0; i < rethash.length; i++) {
			String x = Integer.toHexString(rethash[i] & 0xff).toUpperCase();
			if (x.length() < 2) {
				sb.append("0");
			}
			sb.append(x);
		}
		return sb.toString();
	
	}
}
