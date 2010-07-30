package menu.handler;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import menu.bean.MenuBean;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import common.bean.MemberBean;
import common.bean.PageBean;
import common.constant.Const;
import common.database.DBConnectionMgr;
import common.exception.SysException;
import common.logger.KankokujinLogger;
import common.util.Util;
import common.handler.UtilHandler;


public class MenuHandler {
	
	private final String SAVEFOLDER = Const.UPLOAD_FOLDER_PATH;
	private final int MAXSIZE = 10 * 1024 * 1024;
	private final static String USERBEAN = "memberInfo";
	private static MenuHandler instance = null;
	
	public static MenuHandler getInstance() {
	    if (instance == null) {
	        synchronized (MenuHandler.class) {
	            if (instance == null) {
	                instance = new MenuHandler();
	            }
	        }
	    }
	    return instance;
    }	
	
	/**
	 * @param path
	 * @param request
	 * @return
	 * @throws IOException
	 */
	public MenuBean changeRequestToMenuBean(HttpServletRequest request) throws IOException {
		
		MenuBean menuBean = new MenuBean();
		MultipartRequest multi = null;
		Enumeration enumeration = null;
		//System.out.println("request.getContentType()"+ request.getRequestURL());
		
		
		if (isRegistUpdate(request.getRequestURL().toString())) {
			multi = new MultipartRequest(request, SAVEFOLDER,
					MAXSIZE, "UTF-8", new DefaultFileRenamePolicy());
			enumeration = multi.getParameterNames();
			
			menuBean.put("photo_name1", Util.changePhotoPath(multi.getFilesystemName("photo_name1")));			
			menuBean.put("photo_name2", Util.changePhotoPath(multi.getFilesystemName("photo_name2")));		
			menuBean.put("photo_name3", Util.changePhotoPath(multi.getFilesystemName("photo_name3")));		
			menuBean.put("photo_name4", Util.changePhotoPath(multi.getFilesystemName("photo_name4")));		
			menuBean.put("photo_name5", Util.changePhotoPath(multi.getFilesystemName("photo_name5")));	
		}  else {
			enumeration = request.getParameterNames();
			
		}

		//enumeration = request.getParameterNames();
	   while(enumeration.hasMoreElements()) {
	        String name = (String)enumeration.nextElement();
	        String param = null;
	        if (multi != null) {
	        	param = multi.getParameter(name);
	        } else {
	        	param = request.getParameter(name);
	        }
	        
	        menuBean.put(name, param);
	     }
	   HttpSession session = request.getSession();
	   MemberBean memberBean= (MemberBean) session.getAttribute(USERBEAN);
	   if (memberBean != null) {
		   menuBean.put("user_id", memberBean.getUserid());
		   
		   if (!menuBean.containsKey("email")) {
			   menuBean.put("email", memberBean.getEmail1() + "@" + memberBean.getEmail2());
		   }
		  
		   menuBean.put("tel_no1_1", memberBean.getTelephone1());
		   menuBean.put("tel_no1_2", memberBean.getTelephone2());
		   menuBean.put("tel_no1_3", memberBean.getTelephone3());
		   menuBean.put("tel_no2_1", memberBean.getMobile1());
		   menuBean.put("tel_no2_2", memberBean.getMobile2());
		   menuBean.put("tel_no2_3", memberBean.getMobile3());
	   }
	  
		
		return menuBean;
	}

	private boolean isRegistUpdate(String requestURL) {
		
		if (0 < requestURL.indexOf("MenuRegist") 
				&& 0 > requestURL.indexOf("MenuRegistOpen")) {
			return true;
		}
		if (0 < requestURL.indexOf("MenuUpdate") 
				&& 0 > requestURL.indexOf("MenuUpdateOpen")) {
			return true;
		}
		return false;
		
	}

	/**
	 * @param bean
	 */
	public boolean insert01(MenuBean bean) {
		
		boolean result = false;
		StringBuffer sql = new StringBuffer();
		MenuBean value = new MenuBean();
		
		/** SQL作成 48個 */
		sql.append("insert into nihongo_info (user_id, school_name_k, school_name_j, area_code1, area_code2, ");
		sql.append("area_info, zip_code1, zip_code2, line_code, station_code, tel_no_1, tel_no_2, tel_no_3, fax_no_1, fax_no_2, fax_no_3, url, email, ");
		sql.append("registrationfee_1, entrancefee_1, lessonsfee_1, totalfee_1,");
		sql.append("registrationfee_3, entrancefee_3, lessonsfee_3, totalfee_3,");
		sql.append("registrationfee_6, entrancefee_6, lessonsfee_6, totalfee_6,");
		sql.append("registrationfee_12, entrancefee_12, lessonsfee_12, totalfee_12,");
		sql.append("studentsu_korean, studentsu_chinese, studentsu_others, studentsu_total, dormitoryflg, ");
		sql.append("feature, photo_name1, photo_name2, photo_name3, photo_name4, photo_name5, read_count, regist_date, update_date, deleteflg)");
		sql.append(" values(");
		for (int i = 0; i < 45; i++) {
			sql.append("?,");
		}
		sql.append("0, now(),  now(), 0)");
		System.out.println((String) bean.get("area_info"));
		/** 値設定 */
		value.put("01", Util.changeNullStr((String) bean.get("user_id")));			
		value.put("02", Util.changeNullStr((String) bean.get("school_name_k")));			
		value.put("03", Util.changeNullStr((String) bean.get("school_name_j")));			
		value.put("04", Util.changeNullStr((String) bean.get("searchArea1")));			
		value.put("05", Util.changeNullStr((String) bean.get("searchArea2")));			
		value.put("06", Util.changeNullStr((String) bean.get("area_info")));			
		value.put("07", Util.changeNullStr((String) bean.get("zip_code1")));	
		value.put("08", Util.changeNullStr((String) bean.get("zip_code2")));	
		value.put("09", Util.changeNullStr((String) bean.get("line_code")));			
		value.put("10", Util.changeNullStr((String) bean.get("station_code")));			
		value.put("11", Util.changeNullStr((String) bean.get("tel_no_1")));			
		value.put("12", Util.changeNullStr((String) bean.get("tel_no_2")));			
		value.put("13", Util.changeNullStr((String) bean.get("tel_no_3")));			
		value.put("14", Util.changeNullStr((String) bean.get("fax_no_1")));			
		value.put("15", Util.changeNullStr((String) bean.get("fax_no_2")));			
		value.put("16", Util.changeNullStr((String) bean.get("fax_no_3")));			
		value.put("17", Util.changeNullStr((String) bean.get("url")));			
		value.put("18", Util.changeNullStr((String) bean.get("email")));
		
		String  registrationfee_1 = Util.changeNullInt((String) bean.get("registrationfee_1"));
		String  entrancefee_1 = Util.changeNullInt((String) bean.get("entrancefee_1"));
		String  lessonsfee_1 = Util.changeNullInt((String) bean.get("lessonsfee_1"));
		
		Integer totalfee_1 = new Integer(Integer.parseInt(registrationfee_1) +Integer.parseInt(registrationfee_1) + Integer.parseInt(lessonsfee_1));
		
		value.put("19", registrationfee_1);			
		value.put("20", entrancefee_1);			
		value.put("21", lessonsfee_1);		
		value.put("22", totalfee_1.toString());
		
		String  registrationfee_3 = Util.changeNullInt((String) bean.get("registrationfee_3"));
		String  entrancefee_3 = Util.changeNullInt((String) bean.get("entrancefee_3"));
		String  lessonsfee_3 = Util.changeNullInt((String) bean.get("lessonsfee_3"));
		
		Integer totalfee_3 = new Integer(Integer.parseInt(registrationfee_3) +Integer.parseInt(registrationfee_3) + Integer.parseInt(lessonsfee_3));
		
		value.put("23", registrationfee_3);			
		value.put("24", entrancefee_3);			
		value.put("25", lessonsfee_3);	
		value.put("26", totalfee_3.toString());
		
		String  registrationfee_6 = Util.changeNullInt((String) bean.get("registrationfee_6"));
		String  entrancefee_6 = Util.changeNullInt((String) bean.get("entrancefee_6"));
		String  lessonsfee_6 = Util.changeNullInt((String) bean.get("lessonsfee_6"));
		
		Integer totalfee_6 = new Integer(Integer.parseInt(registrationfee_6) +Integer.parseInt(registrationfee_6) + Integer.parseInt(lessonsfee_6));
				
		value.put("27", registrationfee_6);			
		value.put("28", entrancefee_6);			
		value.put("29", lessonsfee_6);
		value.put("30",  totalfee_6.toString());
		
		String  registrationfee_12 = Util.changeNullInt((String) bean.get("registrationfee_12"));
		String  entrancefee_12 = Util.changeNullInt((String) bean.get("entrancefee_12"));
		String  lessonsfee_12 = Util.changeNullInt((String) bean.get("lessonsfee_12"));
		
		Integer totalfee_12 = new Integer(Integer.parseInt(registrationfee_12) +Integer.parseInt(registrationfee_12) + Integer.parseInt(lessonsfee_12));
		
		value.put("31", registrationfee_12);	
		value.put("32", entrancefee_12);			
		value.put("33", lessonsfee_12);
		value.put("34", totalfee_12.toString());
			
		value.put("35", Util.changeNullInt((String) bean.get("studentsu_korean")));			
		value.put("36", Util.changeNullInt((String) bean.get("studentsu_chinese")));			
		value.put("37", Util.changeNullInt((String) bean.get("studentsu_others")));			
		value.put("38", Util.changeNullInt((String) bean.get("studentsu_total")));			
		value.put("39", Util.changeNullInt((String) bean.get("dormitoryflg")));			
		value.put("40", Util.changeNullStr((String) bean.get("feature")));			
		value.put("41", Util.changeNullStr((String) bean.get("photo_name1")));			
		value.put("42", Util.changeNullStr((String) bean.get("photo_name2")));			
		value.put("43", Util.changeNullStr((String) bean.get("photo_name3")));			
		value.put("44", Util.changeNullStr((String) bean.get("photo_name4")));			
		value.put("45", Util.changeNullStr((String) bean.get("photo_name5")));			
//		value.put("45", "0");			
//		value.put("46", "now()");			
//		value.put("47", "now()");			
//		value.put("48", "0");			

		
		try {
			SQLUtil.insert(sql.toString(), value);
		} catch (SysException e) {
			e.printStackTrace();
			KankokujinLogger.getInstance().debug("e.getMessage()");
		} finally {
			KankokujinLogger.getInstance().debug("insertMenu完了");
		}
		
		return true;
	}
	/**
	 * @param bean
	 */
	public boolean insert02(MenuBean bean) {
		return true;
	}
	/**
	 * @param bean
	 */
	public boolean insert03(MenuBean bean) {
		return true;
	}
	/**
	 * @param bean
	 */
	public boolean insert04(MenuBean bean) {
		return true;
	}
	
	/**
	 * @param bean
	 * @param searchBean 
	 */
		
	public List select01(PageBean pageBean, MenuBean searchBean) {
		
		final String[] SORTCOLUMN = {"totalfee_1","totalfee_3","totalfee_6","totalfee_12"};
		
		
		List searchList = null;
		List resultList = new ArrayList();

		/** SQL作成 */
		StringBuffer sql1 = new StringBuffer();
		StringBuffer sql2 = new StringBuffer();
		
		String whereSql = getWhereList01(searchBean);

		sql1.append("select count(*) from nihongo_info");
		sql1.append(whereSql);
		
		sql2.append("select * from nihongo_info ");
		sql2.append(whereSql);
		sql2.append(" order by ");
		
		/** 整列ルール*/
		String sortPattern = (String) searchBean.get("sortPattern");
		if (!Util.isEmpty(sortPattern)) {
			sql2.append(SQLUtil.makeOrderBy(SORTCOLUMN[Integer.parseInt(sortPattern) / 2],
						Integer.parseInt(sortPattern) % 2));
			sql2.append(",");
		}
		
		sql2.append(SQLUtil.makeOrderBy("update_date" ,0));
		sql2.append("limit ?,? ");
		
		/** 値設定 */
		try {
			searchList = SQLUtil.select(sql1.toString(),sql2.toString(), pageBean);
		} catch (SysException e) {
			KankokujinLogger.getInstance().debug("e.getMessage()");
		}
		
		for (Iterator it = searchList.iterator(); it.hasNext();) {
			
			MenuBean menuBean = (MenuBean) it.next();
			MenuBean value = new MenuBean();
			
			String id = (String) menuBean.get("id");
			String school_name_k = (String) menuBean.get("school_name_k");
			String school_name_j = (String) menuBean.get("school_name_j");
			
			String area_code1 = (String) menuBean.get("area_code1");			
			String area_code2 = (String) menuBean.get("area_code2");	
			String line_code = (String) menuBean.get("line_code");			
			String station_code = (String) menuBean.get("station_code");	
			
			String photo_name1 = (String) menuBean.get("photo_name1");
			String tel_no_1 = (String) menuBean.get("tel_no_1");
			String tel_no_2 = (String) menuBean.get("tel_no_2");
			String tel_no_3 = (String) menuBean.get("tel_no_3");
			String url = (String) menuBean.get("url");
			String dormitoryflg = (String) menuBean.get("dormitoryflg");
			String totalfee_1 = (String) menuBean.get("totalfee_1");
			String totalfee_3 = (String) menuBean.get("totalfee_3");
			String totalfee_6 = (String) menuBean.get("totalfee_6");
			String totalfee_12 = (String) menuBean.get("totalfee_12");
			String studentsu_korean = (String) menuBean.get("studentsu_korean");
			String studentsu_chinese = (String) menuBean.get("studentsu_chinese");
			String studentsu_others = (String) menuBean.get("studentsu_others");
			String studentsu_total = (String) menuBean.get("studentsu_total");
			Timestamp update_date = (Timestamp) menuBean.get("update_date");
			
			value.put("id", id);
			if (Util.isEmpty(school_name_k)) {
				school_name_k = "";
			}
			if (Util.isEmpty(school_name_j)) {
				school_name_j = "";
			}
			value.put("school_name", school_name_k + "\n" + school_name_j);
			
			if ("00".equals(area_code1)) {
				area_code1 = "";
				area_code2 = "";
			}
			
			value.put("area_code1", area_code1);
			value.put("area_code2", area_code2);
			
			if ("00".equals(line_code)) {
				line_code = "";
				station_code = "";
			}
			
			value.put("line_code", line_code);
			value.put("station_code", station_code);
			
			
			/** photo_name1 */
			if(!Util.isEmpty(photo_name1) && !"XXXXX".equals(photo_name1)){
				value.put("photo_name1", Const.IMAGE_FOLDER_PATH + "S_" + photo_name1);
			}else{
				value.put("photo_name1", "jsp/images/common/S_no_image.gif");
			}
			
			
			value.put("tel_no", tel_no_1 + "-" + tel_no_2 + "-" + tel_no_3);
			value.put("dormitoryflg", dormitoryflg);
			value.put("url", url);
			value.put("totalfee", totalfee_1 + "/" + totalfee_3+ "/" + totalfee_6 + "/"+ totalfee_12);
			
			
			
			 
			if (isCaluableNum(studentsu_total)) {
				Float korean = 0.f;
				Float chinese = 0.f;
				Float others = 0.f;
				if (isCaluableNum(studentsu_korean)) {
					korean = Float.parseFloat(studentsu_korean) / Float.parseFloat(studentsu_total);
				}
				if (isCaluableNum(studentsu_chinese)) {
					chinese = Float.parseFloat(studentsu_chinese) / Float.parseFloat(studentsu_total);
				}
				if (isCaluableNum(studentsu_others)) {
					others = Float.parseFloat(studentsu_others) / Float.parseFloat(studentsu_total);
				}
				BigDecimal koreanD = new BigDecimal(korean * 100);
				BigDecimal chineseD = new BigDecimal(chinese * 100);
				BigDecimal othersD = new BigDecimal(others * 100);
				
		       
				value.put("studentsu", koreanD.toBigInteger() + "%" + "/" + chineseD.toBigInteger()  + "%"+ "/" + othersD.toBigInteger() + "%");
			} else {
				value.put("studentsu", "0" + "%"+ "/" + "0"+ "%"+ "/" + "0"+ "%");
			}
			value.put("update_date", Util.getUpdateDate(update_date));
			
			resultList.add(value);
		}
		
		
		return resultList;
	}
	
	/**
	 * 条件節のハッシュマップ情報からwhere節を作る
	 * 
	 * @param map
	 * @return
	 */
	public String getWhereList01(MenuBean bean) {

		/** 検索条件 */
		String userId              = (String) bean.get("search_user_id");
		String searchAreaCode1     = (String) bean.get("searchArea1");
		String searchAreaCode2     = (String) bean.get("searchArea2");
		String searchLineCode      = (String) bean.get("searchLine");
		String searchStationCode   = (String) bean.get("searchStation");
		String search_dormitoryflg = (String) bean.get("search_dormitoryflg");
		String search_range 	   = (String) bean.get("search_range");
		String search 			   = (String) bean.get("search");
		String sortPattern 		   = (String) bean.get("sortPattern");

		ArrayList<String> andList = new ArrayList<String>();
		ArrayList<String> orList = new ArrayList<String>();

		andList.add(SQLUtil.makeEqualState("deleteflg", "0"));
		
		//地域コード１
		if (!Util.isEmpty(searchAreaCode1)) {
			if (!"".equals(searchAreaCode1) && !"00".equals(searchAreaCode1)) {
				andList.add(SQLUtil.makeEqualState("area_code1", searchAreaCode1));
				//地域コード２
				if (!"".equals(searchAreaCode2) && !"00".equals(searchAreaCode2.substring(2, 4))) {
					andList.add(SQLUtil.makeEqualState("area_code2", searchAreaCode2));
				}
			}
			//ラインコード、駅コード
			if (!"".equals(searchLineCode) && !"00".equals(searchLineCode)) {
				andList.add(SQLUtil.makeEqualState("line_code", searchLineCode));

				if (!Util.isEmpty(searchStationCode) && searchStationCode.length() == 4) {
					if (!"00".equals(searchStationCode.substring(2, 4))) {
						andList.add(SQLUtil.makeEqualState("station_code", searchStationCode));
					}
				}
			}
			//寮有無
			if ("on".equals(search_dormitoryflg)) {
				andList.add(SQLUtil.makeEqualState("dormitoryflg", "1"));
			}
			/** ユーザID*/
			if(!Util.isEmpty(userId)){
				andList.add("user_id" + userId);
			}
			
			
			List searchList = SQLUtil.changeSearch(search);
			//検索語がある場合
			if (searchList.size() > 0) {
				/** 全体検索 */
				if ("0".equals(search_range)) {
					orList.add(SQLUtil.makelikeSQL(searchList, "school_name_k"));
					orList.add(SQLUtil.makelikeSQL(searchList, "school_name_j"));
					orList.add(SQLUtil.makelikeSQL(searchList, "feature"));
				/** 学校名 */
				} else if ("1".equals(search_range)) {
					orList.add(SQLUtil.makelikeSQL(searchList, "school_name_k"));
					orList.add(SQLUtil.makelikeSQL(searchList, "school_name_j"));
				/** 特徴 */
				} else if ("2".equals(search_range)) {
					orList.add(SQLUtil.makelikeSQL(searchList, "feature"));		
				}
				if (orList.size() > 1) {
					andList.add(SQLUtil.getWhereOrSql(orList));
				}
			}
			
		}
	
		return SQLUtil.getWhereSQL(andList);

	}
	
	
	/**
	 * @param bean
	 */
	public List select02(PageBean pageBean, MenuBean searchBean) {
		
		List searchList = new ArrayList();
		List resultList = new ArrayList();
		Connection con = null;
		
		String sign  = (String) searchBean.get("sign");
		String address_name  = (String) searchBean.get("address_name");
		String zip_code1     = (String) searchBean.get("zip_code1");
		String zip_code2     = (String) searchBean.get("zip_code2");
		String station_name  = (String) searchBean.get("station_name");	
		/** SQL作成 */
		StringBuffer sql1 = new StringBuffer();
		StringBuffer sql2 = new StringBuffer();

		String whereSql = getWhereList02(searchBean);
		
		if (Util.isEmpty(sign)) {
			return resultList;
		} else if ("0".equals(sign)) {
			try {
				con = DBConnectionMgr.getInstance().getConnection();
				
				Map condition = new HashMap();
				List getcolumnList = new ArrayList();				
				getcolumnList.add("*");
				condition.put("kana_name" , address_name);
				condition.put("kanji_name" , address_name);
				
				List categoryList1 = UtilHandler.searchCategoryList(con, address_name, "00");
				List categoryList2 = UtilHandler.sigleTableGetWhereLike(con, "t_areainfo", condition, getcolumnList);
				UtilHandler.joinOyaInfo(con, categoryList2, "00");
				searchList.addAll(categoryList1);
				searchList.addAll(categoryList2);
			} catch (SysException e) {
				KankokujinLogger.getInstance().debug("e.getMessage()");
			} catch (Exception e) {
				
			} finally {
				DBConnectionMgr.getInstance().freeConnection(con);
			}
			
		} else if ("1".equals(sign)) {
			Map condition = new HashMap();
			List getcolumnList = new ArrayList();				
			getcolumnList.add("*");
			
			if (!Util.isEmpty(zip_code2)) {
				condition.put("zipcode" , zip_code1 + zip_code2);
			} else {
				condition.put("zipcode" , zip_code1);
			}
			try {
				con = DBConnectionMgr.getInstance().getConnection();
				List categoryList = UtilHandler.sigleTableGetWhereLike(con, "t_areainfo", condition, getcolumnList);				
				UtilHandler.joinOyaInfo(con, categoryList, "00");
				searchList.addAll(categoryList);
			} catch (SysException e) {
				KankokujinLogger.getInstance().debug("e.getMessage()");
			} catch (Exception e) {
				
			} finally {
				DBConnectionMgr.getInstance().freeConnection(con);
			}
			
		} else if ("2".equals(sign)) {
			try {
				con = DBConnectionMgr.getInstance().getConnection();
				
				Map condition = new HashMap();
				List getcolumnList = new ArrayList();				
				getcolumnList.add("*");
				condition.put("kana_name" , station_name);
				condition.put("kanji_name" , station_name);
				
				List categoryList1 = UtilHandler.searchCategoryList(con, station_name, "01");
				List categoryList2 = UtilHandler.sigleTableGetWhereLike(con, "t_stationinfo", condition, getcolumnList);
				UtilHandler.joinOyaInfo(con, categoryList2, "01");
				searchList.addAll(categoryList1);
				searchList.addAll(categoryList2);
			} catch (SysException e) {
				KankokujinLogger.getInstance().debug("e.getMessage()");
			} catch (Exception e) {
				
			} finally {
				DBConnectionMgr.getInstance().freeConnection(con);
			}
			
		}
		/** 値設定 */
		for (Iterator it = searchList.iterator(); it.hasNext();) {
			MenuBean menuBean = (MenuBean) it.next();
			MenuBean value = new MenuBean();

			if ("0".equals(sign) || "1".equals(sign)) {
				String zipcode = (String) menuBean.get("zipcode");
				List kanjiNameList = (List) menuBean.get("kanjiName");
				List kanaNameList = (List) menuBean.get("kanaName");
				
				StringBuffer editZipcode = new StringBuffer();
				StringBuffer todoAddress = new StringBuffer();
				StringBuffer sikuAddress = new StringBuffer();
				StringBuffer address = new StringBuffer();
				
				if (!Util.isEmpty(zipcode)) {
					editZipcode.append(zipcode.substring(0, 3));
					editZipcode.append("－");
					editZipcode.append(zipcode.substring(3, 7));
				}
				//都道府県
				if (kanjiNameList.size() == 1) {
					todoAddress.append((String) kanjiNameList.get(0));
					todoAddress.append("(");
					todoAddress.append((String) kanaNameList.get(0));
					todoAddress.append(")");
				}
				//市区
				if (kanjiNameList.size() == 2) {
					todoAddress.append((String) kanjiNameList.get(1));
					todoAddress.append("(");
					todoAddress.append((String) kanaNameList.get(1));
					todoAddress.append(")");
					sikuAddress.append((String) kanjiNameList.get(0));
					sikuAddress.append("(");
					sikuAddress.append((String) kanaNameList.get(0));
					sikuAddress.append(")");
				}
				//その他
				if (kanjiNameList.size() == 3) {
					todoAddress.append((String) kanjiNameList.get(2));
					todoAddress.append("(");
					todoAddress.append((String) kanaNameList.get(2));
					todoAddress.append(")");
					sikuAddress.append((String) kanjiNameList.get(1));
					sikuAddress.append("(");
					sikuAddress.append((String) kanaNameList.get(1));
					sikuAddress.append(")");
					address.append((String) kanjiNameList.get(0));
					address.append("(");
					address.append((String) kanaNameList.get(0));
					address.append(")");
				}
	
				value.put("zipcode", editZipcode.toString());
				value.put("todoAddress", todoAddress.toString());
				value.put("sikuAddress", sikuAddress.toString());
				value.put("address", address.toString());
				
			} if ("2".equals(sign)) {
				List kanjiNameList = (List) menuBean.get("kanjiName");
				List kanaNameList = (List) menuBean.get("kanaName");
				StringBuffer linename = new StringBuffer();
				StringBuffer stationname = new StringBuffer();
				
				//路線
				if (kanjiNameList.size() == 1) {
					linename.append((String) kanjiNameList.get(0));
					linename.append("(");
					linename.append((String) kanaNameList.get(0));
					linename.append(")");
				}
				//駅
				if (kanjiNameList.size() == 2) {
					linename.append((String) kanjiNameList.get(1));
					linename.append("(");
					linename.append((String) kanaNameList.get(1));
					linename.append(")");
					stationname.append((String) kanjiNameList.get(0));
					stationname.append("(");
					stationname.append((String) kanaNameList.get(0));
					stationname.append(")");
					
				}
				value.put("line_name", linename.toString());
				value.put("station_name", stationname.toString());
			}
				
			
			resultList.add(value);
		}
		return resultList;
	}
	
	/**
	 * 条件節のハッシュマップ情報からwhere節を作る
	 * 
	 * @param map
	 * @return
	 */
	public String getWhereList02(MenuBean bean) {

		/** 検索条件 */
		String sign  = (String) bean.get("sign");
		String address_name  = (String) bean.get("address_name");
		String zip_code1     = (String) bean.get("zip_code1");
		String zip_code2     = (String) bean.get("zip_code2");
		String station_name  = (String) bean.get("station_name");	
		
		ArrayList<String> orList = new ArrayList<String>();
		ArrayList<String> andList = new ArrayList<String>();
		if ("0".equals(sign)) {
			if (!"".equals(address_name)) {
				List searchList = SQLUtil.changeSearch(address_name);
				orList.add(SQLUtil.makelikeSQL(searchList, "ADDRESS.area_kana_name"));
				orList.add(SQLUtil.makelikeSQL(searchList, "ADDRESS.area_kanji_name"));
				andList.add(SQLUtil.getWhereOrSql(orList));
			}
		
		} else if ("1".equals(sign)) {
			if (Util.isEmpty(zip_code2)) {
				List searchList = SQLUtil.changeSearch(zip_code1);
				andList.add(SQLUtil.makelikeStartMatchSQL(searchList, "ADDRESS.zipcode"));
			} else {
				andList.add(SQLUtil.makeEqualState("ADDRESS.zipcode", zip_code1 + zip_code2));
			}
			
		} else if ("2".equals(sign)) {
			if (!Util.isEmpty(station_name)) {
				List searchList = SQLUtil.changeSearch(station_name);
				orList.add(SQLUtil.makelikeSQL(searchList, "STATION.station_kana_name"));
				orList.add(SQLUtil.makelikeSQL(searchList, "STATION.station_kanji_name"));
				andList.add(SQLUtil.getWhereOrSql(orList));
			} 
			
		}
		
		return SQLUtil.getWhereSQL(andList);
		
	}
	/**
	 * @param bean
	 */
	public List select03(PageBean pageBean, MenuBean bean) {
		return null;
	}
	/**
	 * @param bean
	 */
	public List select04(PageBean pageBean, MenuBean bean) {
		return null;
	}
	
	/**
	 * @param bean
	 * @throws SysException 
	 */
	public MenuBean selectDetail01(MenuBean bean, boolean updataSign) throws SysException {	
		
		MenuBean detailBean = null;
		MenuBean resultBean = new MenuBean();
		
		/** ID キー　*/
		String id = (String) bean.get("id");
		
		/** SQL作成 */
		StringBuffer sql1 = new StringBuffer();
		StringBuffer sql2 = new StringBuffer();
		sql1.append("update nihongo_info set read_count = read_count + 1 where id = ?");
		sql2.append("select * from nihongo_info where id = ?");
		detailBean = SQLUtil.selectDetail(sql1.toString(), sql2.toString(), id, updataSign);
		
		/** 結果セット */
		//01
		String user_id = (String) detailBean.get("user_id");			
		//02
		String school_name_k = (String) detailBean.get("school_name_k");			
		//03
		String school_name_j = (String) detailBean.get("school_name_j");			
		//04
		String area_code1 = (String) detailBean.get("area_code1");			
		//05
		String area_code2 = (String) detailBean.get("area_code2");			
		//06
		String area_info = (String) detailBean.get("area_info");			
		//07
		String zip_code1 = (String) detailBean.get("zip_code1");	
		String zip_code2 = (String) detailBean.get("zip_code2");
		//08
		String line_code = (String) detailBean.get("line_code");			
		//09
		String station_code = (String) detailBean.get("station_code");			
		//10
		String tel_no_1 = (String) detailBean.get("tel_no_1");			
		//11
		String tel_no_2 = (String) detailBean.get("tel_no_2");			
		//12
		String tel_no_3 = (String) detailBean.get("tel_no_3");			
		//13
		String fax_no_1 = (String) detailBean.get("fax_no_1");			
		//14
		String fax_no_2 = (String) detailBean.get("fax_no_2");			
		//15
		String fax_no_3 = (String) detailBean.get("fax_no_3");			
		//16
		String url = (String) detailBean.get("url");			
		//17
		String email = (String) detailBean.get("email");			
		//18
		String registrationfee_1 = (String) detailBean.get("registrationfee_1");			
		//19
		String entrancefee_1 = (String) detailBean.get("entrancefee_1");			
		//20
		String lessonsfee_1 = (String) detailBean.get("lessonsfee_1");			
		//21
		String totalfee_1 = (String) detailBean.get("totalfee_1");			
		//22
		String registrationfee_3 = (String) detailBean.get("registrationfee_3");			
		//23
		String entrancefee_3 = (String) detailBean.get("entrancefee_3");			
		//24
		String lessonsfee_3 = (String) detailBean.get("lessonsfee_3");			
		//25
		String totalfee_3 = (String) detailBean.get("totalfee_3");			
		//26
		String registrationfee_6 = (String) detailBean.get("registrationfee_6");			
		//27
		String entrancefee_6 = (String) detailBean.get("entrancefee_6");			
		//28
		String lessonsfee_6 = (String) detailBean.get("lessonsfee_6");			
		//29
		String totalfee_6 = (String) detailBean.get("totalfee_6");			
		//30
		String registrationfee_12 = (String) detailBean.get("registrationfee_12");			
		//31
		String entrancefee_12 = (String) detailBean.get("entrancefee_12");			
		//32
		String lessonsfee_12 = (String) detailBean.get("lessonsfee_12");			
		//33
		String totalfee_12 = (String) detailBean.get("totalfee_12");			
		//34
		String studentsu_korean = (String) detailBean.get("studentsu_korean");			
		//35
		String studentsu_chinese = (String) detailBean.get("studentsu_chinese");			
		//36
		String studentsu_others = (String) detailBean.get("studentsu_others");			
		//37
		String studentsu_total = (String) detailBean.get("studentsu_total");			
		//38
		String dormitoryflg = (String) detailBean.get("dormitoryflg");			
		//39
		String feature = (String) detailBean.get("feature");			
		//40
		String photo_name1 = (String) detailBean.get("photo_name1");			
		//41
		String photo_name2 = (String) detailBean.get("photo_name2");			
		//42
		String photo_name3 = (String) detailBean.get("photo_name3");			
		//43
		String photo_name4 = (String) detailBean.get("photo_name4");			
		//44
		String photo_name5 = (String) detailBean.get("photo_name5");	
		//45
		Timestamp regist_date = (Timestamp) detailBean.get("regist_date");			
		//46
		String read_count = (String) detailBean.get("read_count");
		
		resultBean.put("school_name_k", school_name_k);
		resultBean.put("school_name_j", school_name_j);
		
		
		
		
		/*********************** photo_name ***************/
		if(!Util.isEmpty(photo_name1) && !"XXXXX".equals(photo_name1)){
			resultBean.put("photo_name1", Const.IMAGE_FOLDER_PATH + "M_" + photo_name1) ;
		}else{
			resultBean.put("photo_name1", "jsp/images/common/no_image.gif");
		}
		if(!Util.isEmpty(photo_name2) && !"XXXXX".equals(photo_name2)){
			resultBean.put("photo_name2", Const.IMAGE_FOLDER_PATH+ "M_" + photo_name2);
		}else{
			resultBean.put("photo_name2", "jsp/images/common/no_image.gif");
		}
		if(!Util.isEmpty(photo_name3) && !"XXXXX".equals(photo_name3)){
			resultBean.put("photo_name3", Const.IMAGE_FOLDER_PATH+ "M_" + photo_name3);
		}else{
			resultBean.put("photo_name3", "jsp/images/common/no_image.gif");
		}
		if(!Util.isEmpty(photo_name4) && !"XXXXX".equals(photo_name4)){
			resultBean.put("photo_name4", Const.IMAGE_FOLDER_PATH+ "M_" + photo_name4);
		}else{
			resultBean.put("photo_name4", "jsp/images/common/no_image.gif");
		}
		if(!Util.isEmpty(photo_name5) && !"XXXXX".equals(photo_name5)){
			resultBean.put("photo_name5", Const.IMAGE_FOLDER_PATH+ "M_" + photo_name5);
		}else{
			resultBean.put("photo_name5", "jsp/images/common/no_image.gif");
		}
		
		
		if ("00".equals(area_code1)) {
			area_code1 = "";
			area_code2 = "";
		}
		
		resultBean.put("area_code1", area_code1);
		resultBean.put("area_code2", area_code2);
		resultBean.put("area_info", area_info);
		if ("00".equals(line_code)) {
			line_code = "";
			station_code = "";
		}
		
		resultBean.put("line_code", line_code);
		resultBean.put("station_code", station_code);

		
		//郵便番号
		resultBean.put("zip_code1", zip_code1);
		resultBean.put("zip_code2", zip_code2);
		//電話番号
		resultBean.put("tel_no_1", tel_no_1);
		resultBean.put("tel_no_2", tel_no_2);
		resultBean.put("tel_no_3", tel_no_3);
		//FAX番号
		resultBean.put("fax_no_1", fax_no_1);
		resultBean.put("fax_no_2", fax_no_2);
		resultBean.put("fax_no_3", fax_no_3);
		
		resultBean.put("tel_no", tel_no_1+"-"+tel_no_2+"-"+tel_no_3);
		resultBean.put("fax_no", fax_no_1+"-"+fax_no_2+"-"+fax_no_3);
		resultBean.put("url", url);
		resultBean.put("email", email);
		
		/*********** 登録金 ********/
		resultBean.put("registrationfee_1", registrationfee_1);
		resultBean.put("registrationfee_3", registrationfee_3);
		resultBean.put("registrationfee_6", registrationfee_6);
		resultBean.put("registrationfee_12", registrationfee_12);
		if ("0".equals(registrationfee_1) || Util.isEmpty(registrationfee_1)) {
			registrationfee_1 = "情報無し";
		} else {
			registrationfee_1 = registrationfee_1 + "万円";
		}
		
		if ("0".equals(registrationfee_3)|| Util.isEmpty(registrationfee_3)) {
			registrationfee_3 = "情報無し";
		} else {
			registrationfee_3 = registrationfee_3 + "万円";
		}
		if ("0".equals(registrationfee_6) || Util.isEmpty(registrationfee_6)) {
			registrationfee_6 = "情報無し";
		} else {
			registrationfee_6 = registrationfee_6 + "万円";
		}
		if ("0".equals(registrationfee_12)|| Util.isEmpty(registrationfee_12)) {
			registrationfee_12 = "情報無し";
		} else {
			registrationfee_12 = registrationfee_12 + "万円";
		}
		/*********** 入学金 ********/
		resultBean.put("entrancefee_1", entrancefee_1);
		resultBean.put("entrancefee_3", entrancefee_3);
		resultBean.put("entrancefee_6", entrancefee_6);
		resultBean.put("entrancefee_12", entrancefee_12);
		if ("0".equals(entrancefee_1)|| Util.isEmpty(entrancefee_1)) {
			entrancefee_1 = "情報無し";
		} else {
			entrancefee_1 = entrancefee_1 + "万円";
		}
		
		if ("0".equals(entrancefee_3)|| Util.isEmpty(entrancefee_3)) {
			entrancefee_3 = "情報無し";
		} else {
			entrancefee_3 = entrancefee_3 + "万円";
		}
		if ("0".equals(entrancefee_6)|| Util.isEmpty(entrancefee_6)) {
			entrancefee_6 = "情報無し";
		} else {
			entrancefee_6 = entrancefee_6 + "万円";
		}
		if ("0".equals(entrancefee_12)|| Util.isEmpty(entrancefee_12)) {
			entrancefee_12 = "情報無し";
		} else {
			entrancefee_12 = entrancefee_12 + "万円";
		}
		
		/*********** 授業料 ********/
		resultBean.put("lessonsfee_1", lessonsfee_1);
		resultBean.put("lessonsfee_3", lessonsfee_3);
		resultBean.put("lessonsfee_6", lessonsfee_6);
		resultBean.put("lessonsfee_12", lessonsfee_12);
		if ("0".equals(lessonsfee_1)|| Util.isEmpty(lessonsfee_1)) {
			lessonsfee_1 = "情報無し";
		} else {
			lessonsfee_1 = lessonsfee_1 + "万円";
		}
		
		if ("0".equals(lessonsfee_3)|| Util.isEmpty(lessonsfee_3)) {
			lessonsfee_3 = "情報無し";
		} else {
			lessonsfee_3 = lessonsfee_3 + "万円";
		}
		if ("0".equals(lessonsfee_6)|| Util.isEmpty(lessonsfee_6)) {
			lessonsfee_6 = "情報無し";
		} else {
			lessonsfee_6 = lessonsfee_6 + "万円";
		}
		if ("0".equals(lessonsfee_12)|| Util.isEmpty(lessonsfee_12)) {
			lessonsfee_12 = "情報無し";
		} else {
			lessonsfee_12 = lessonsfee_12 + "万円";
		}
		
		resultBean.put("registrationfee",
				registrationfee_1+"/"+registrationfee_3+"/"+registrationfee_6+"/"+registrationfee_12);
		resultBean.put("entrancefee", entrancefee_1+"/"+entrancefee_3+"/"+entrancefee_6+"/"+entrancefee_12);
		resultBean.put("lessonsfee", lessonsfee_1+"/"+lessonsfee_3+"/"+lessonsfee_6+"/"+lessonsfee_12);
		
		//国籍比率
		resultBean.put("studentsu_korean", studentsu_korean);
		resultBean.put("studentsu_chinese", studentsu_chinese);
		resultBean.put("studentsu_others", studentsu_others);
		resultBean.put("totalsu", studentsu_total);
		resultBean.put("studentsu", studentsu_korean+"/"+studentsu_chinese+"/"+studentsu_others);
		
		resultBean.put("dormitoryflg", dormitoryflg);
		resultBean.put("user_id", user_id);
		resultBean.put("regist_date", Util.getUpdateDate(regist_date));
		resultBean.put("read_count", read_count);
		resultBean.put("feature", feature);
		resultBean.put("id", id);
		return resultBean;
	}
	/**
	 * @param bean
	 */
	public MenuBean selectDetail02(MenuBean bean) {	
		return null;
	}
	/**
	 * @param bean
	 */
	public MenuBean selectDetail03(MenuBean bean) {	
		return null;
	}
	/**
	 * @param bean
	 */
	public MenuBean selectDetail04(MenuBean bean) {	
		return null;
	}
	/**
	 * @param bean
	 * @throws SysException 
	 */
	public int update01(MenuBean bean) {	
		
		int result = 0;
		MenuBean value = new MenuBean();
		
		/** ID キー　*/
		String id = (String) bean.get("id");
		
		/** SQL作成 */
		StringBuffer sql1 = new StringBuffer();
		StringBuffer sql2 = new StringBuffer();
		
		sql1.append("UPDATE nihongo_info ");
		sql1.append(" SET user_id=?, school_name_k=?, school_name_j=?, area_code1=?, area_code2=?, area_info=?, zip_code1=?," );
		sql1.append(" zip_code2=?, line_code=?, station_code=?, tel_no_1=?, tel_no_2=?, tel_no_3=?, fax_no_1=?, fax_no_2=?,fax_no_3=?," );
		sql1.append(" url=?, email=?, registrationfee_1=?, entrancefee_1=?, lessonsfee_1=?, totalfee_1=?, registrationfee_3=?, entrancefee_3=?,lessonsfee_3=?," );
		sql1.append(" totalfee_3=?,registrationfee_6=?, entrancefee_6=?, lessonsfee_6=?, totalfee_6=?, registrationfee_12=?, entrancefee_12=?, lessonsfee_12=?, totalfee_12=?,");
		sql1.append(" studentsu_korean=?, studentsu_chinese=?, studentsu_others=?, studentsu_total=?, dormitoryflg=?, feature=?, photo_name1=?, photo_name2=?,");	
		sql1.append(" photo_name3=?, photo_name4=?, photo_name5=?, update_date=(now())");	
		sql1.append(" where id=");
		sql1.append(id); 	
		/** 値設定 */
		value.put("01", Util.changeNullStr((String) bean.get("user_id")));			
		value.put("02", Util.changeNullStr((String) bean.get("school_name_k")));			
		value.put("03", Util.changeNullStr((String) bean.get("school_name_j")));			
		value.put("04", Util.changeNullStr((String) bean.get("searchArea1")));			
		value.put("05", Util.changeNullStr((String) bean.get("searchArea2")));			
		value.put("06", Util.changeNullStr((String) bean.get("searchArea3")));			
		value.put("07", Util.changeNullStr((String) bean.get("zip_code1")));	
		value.put("08", Util.changeNullStr((String) bean.get("zip_code2")));	
		value.put("09", Util.changeNullStr((String) bean.get("line_code")));			
		value.put("10", Util.changeNullStr((String) bean.get("station_code")));			
		value.put("11", Util.changeNullStr((String) bean.get("tel_no_1")));			
		value.put("12", Util.changeNullStr((String) bean.get("tel_no_2")));			
		value.put("13", Util.changeNullStr((String) bean.get("tel_no_3")));			
		value.put("14", Util.changeNullStr((String) bean.get("fax_no_1")));			
		value.put("15", Util.changeNullStr((String) bean.get("fax_no_2")));			
		value.put("16", Util.changeNullStr((String) bean.get("fax_no_3")));			
		value.put("17", Util.changeNullStr((String) bean.get("url")));			
		value.put("18", Util.changeNullStr((String) bean.get("email")));
		
		String  registrationfee_1 = Util.changeNullInt((String) bean.get("registrationfee_1"));
		String  entrancefee_1 = Util.changeNullInt((String) bean.get("entrancefee_1"));
		String  lessonsfee_1 = Util.changeNullInt((String) bean.get("lessonsfee_1"));
		
		Integer totalfee_1 = new Integer(Integer.parseInt(registrationfee_1) +Integer.parseInt(registrationfee_1) + Integer.parseInt(lessonsfee_1));
		
		value.put("19", registrationfee_1);			
		value.put("20", entrancefee_1);			
		value.put("21", lessonsfee_1);		
		value.put("22", totalfee_1.toString());
		
		String  registrationfee_3 = Util.changeNullInt((String) bean.get("registrationfee_3"));
		String  entrancefee_3 = Util.changeNullInt((String) bean.get("entrancefee_3"));
		String  lessonsfee_3 = Util.changeNullInt((String) bean.get("lessonsfee_3"));
		
		Integer totalfee_3 = new Integer(Integer.parseInt(registrationfee_3) +Integer.parseInt(registrationfee_3) + Integer.parseInt(lessonsfee_3));
		
		value.put("23", registrationfee_3);			
		value.put("24", entrancefee_3);			
		value.put("25", lessonsfee_3);	
		value.put("26", totalfee_3.toString());
		
		String  registrationfee_6 = Util.changeNullInt((String) bean.get("registrationfee_6"));
		String  entrancefee_6 = Util.changeNullInt((String) bean.get("entrancefee_6"));
		String  lessonsfee_6 = Util.changeNullInt((String) bean.get("lessonsfee_6"));
		
		Integer totalfee_6 = new Integer(Integer.parseInt(registrationfee_6) +Integer.parseInt(registrationfee_6) + Integer.parseInt(lessonsfee_6));
				
		value.put("27", registrationfee_6);			
		value.put("28", entrancefee_6);			
		value.put("29", lessonsfee_6);
		value.put("30",  totalfee_6.toString());
		
		String  registrationfee_12 = Util.changeNullInt((String) bean.get("registrationfee_12"));
		String  entrancefee_12 = Util.changeNullInt((String) bean.get("entrancefee_12"));
		String  lessonsfee_12 = Util.changeNullInt((String) bean.get("lessonsfee_12"));
		
		Integer totalfee_12 = new Integer(Integer.parseInt(registrationfee_12) +Integer.parseInt(registrationfee_12) + Integer.parseInt(lessonsfee_12));
		
		value.put("31", registrationfee_12);	
		value.put("32", entrancefee_12);			
		value.put("33", lessonsfee_12);
		value.put("34", totalfee_12.toString());
			
		value.put("35", Util.changeNullInt((String) bean.get("studentsu_korean")));			
		value.put("36", Util.changeNullInt((String) bean.get("studentsu_chinese")));			
		value.put("37", Util.changeNullInt((String) bean.get("studentsu_others")));			
		value.put("38", Util.changeNullInt((String) bean.get("studentsu_total")));			
		value.put("39", Util.changeNullInt((String) bean.get("dormitoryflg")));			
		value.put("40", Util.changeNullStr((String) bean.get("feature")));			
		value.put("41", Util.changeNullStr((String) bean.get("photo_name1")));			
		value.put("42", Util.changeNullStr((String) bean.get("photo_name2")));			
		value.put("43", Util.changeNullStr((String) bean.get("photo_name3")));			
		value.put("44", Util.changeNullStr((String) bean.get("photo_name4")));			
		value.put("45", Util.changeNullStr((String) bean.get("photo_name5")));		
		
		try {
			result = SQLUtil.update(sql1.toString(), value);
		} catch (SysException e) {
			e.printStackTrace();
			KankokujinLogger.getInstance().debug("e.getMessage()");
		} finally {
			KankokujinLogger.getInstance().debug("update完了");
		}
		
		return result;
	}
	/**
	 * @param bean
	 */
//	public MenuBean update02(MenuBean bean) {	
//		return null;
//	}
//	/**
//	 * @param bean
//	 */
//	public MenuBean update03(MenuBean bean) {	
//		return null;
//	}
//	/**
//	 * @param bean
//	 */
//	public MenuBean update04(MenuBean bean) {	
//		return null;
//	}
	
	/**
	 * @param bean
	 * @throws SysException 
	 */
	public boolean delete01(MenuBean bean) {	
		
		boolean result = false;
		MenuBean value = new MenuBean();
		
		/** ID キー　*/
		String id = (String) bean.get("id");
		
		/** SQL作成 */
		StringBuffer sql = new StringBuffer();
		
		sql.append("delete from findjob_info where id=");
		sql.append(id); 
		
		try {
			result = SQLUtil.delete(sql.toString(), value);
		} catch (SysException e) {
			e.printStackTrace();
			KankokujinLogger.getInstance().debug("e.getMessage()");
		} finally {
			KankokujinLogger.getInstance().debug("update完了");
		}
		
		return result;
	}
	/**
	 * @param bean
	 */
	public boolean delete02(MenuBean bean) {	
		return false;
	}
	/**
	 * @param bean
	 */
	public boolean delete03(MenuBean bean) {	
		return false;
	}
	/**
	 * @param bean
	 */
	public boolean delete04(MenuBean bean) {	
		return false;
	}
	
	
	/**
	 * 
	 * @param str
	 * @return 入力  数字, not 0:true 、非数字,0：flase
	 */
	private boolean isCaluableNum(String str) {
		boolean check = true;
		try {
			int k = Integer.parseInt(str);
			if (k == 0) return false;
		} catch (NumberFormatException ne) {
			check = false;
		}
		return check;
		
	}
	
	

	
}