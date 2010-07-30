package common.batch.url;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

import common.database.DBConnectionMgr;
import common.database.LogPreparedStatement;
import common.exception.AppException;

public class DataTransferHandler {
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		String s = getNumberOnly("http://rent.realestate.yahoo.co.jp/bin/rsearch?md=stn&lc=03&pf=13&ln=2172&stn=2001&stn=2172150&from=0&to=0&inc=1&tp=1&wlk=0&spfrom=0&spto=0&yr=0&nc=0&submit.x=50&submit.y=15&submit=%A4%B3%A4%CE%BE%F2%B7%EF%A4%C7%B8%A1%BA%F7&request=show%3D20%26md%3Dstn%26lc%3D03%26pfc%3D13%26ln%3D2172%26stn%3D2001%26stn%3D2172150%26from%3D0%26to%3D0%26inc%3D1%26nc%3D0%26tp%3D1%26spfrom%3D0%26spto%3D0%26yr%3D0%26wlk%3D0%26p%3D%26b%3D40&disp=");
		System.out.println(s);
	}
	/**
	 * 
	 * @param houseFee
	 * @return
	 */
	public static String getHouseFee(String houseFee) {
		
		BigDecimal dec = new BigDecimal(houseFee);
		
		return dec.multiply(BigDecimal.valueOf(10000)).toString();
	}
	/**
	 * 
	 * @param manageFee
	 * @return
	 */
	public static String getManage_fee(String manageFee) {
		
		BigDecimal dec = null;
		if (manageFee.indexOf("なし") == -1 && manageFee.indexOf("－") == -1 && manageFee.indexOf("－") == -1 && manageFee.indexOf("−") == -1) {
			dec = new BigDecimal(manageFee.substring(0, manageFee.length() - 1).replace(",", ""));
		} else {
			dec = BigDecimal.valueOf(0);
		}
		
		return dec.toString();
	}
	
	public static String getStairs(String stairs) {
		
		int index = 0;
		
		if ((index = stairs.indexOf("（")) >=0) {
			return getNumberOnly(stairs.substring(0, index));
		} else {
			return getNumberOnly(stairs);
		}
	}
	
	/**
	 * 
	 * @param str
	 * @return
	 */
	public static String getNumberOnly(String str) {
		
		return str.replaceAll("\\D", "");
		
	}
	/**
	 * 
	 * @param compass
	 * @return
	 */
	public static String getCompass(String compass) {

		if (compass.indexOf("東") == 0) {
			return "1";
		} else if (compass.indexOf("西") == 0) {
			return "2";
		} else if (compass.indexOf("南") == 0) {
			return "3";
		} else if (compass.indexOf("北") == 0) {
			return "4";
		} 
		return "";
		
	}
	/**
	 * @param comeDock
	 * @return
	 */
	public static String getComeDock(String comeDock) {
		if (comeDock.indexOf("即") >= 0) {
			return "0";
		} else {
			return "1";
		}
	}
	/**
	 * @param houseSort
	 * @return
	 */
	public static String getHouseSort(String houseSort) {
		
		if (houseSort.indexOf("アパート") >= 0 || houseSort.indexOf("賃貸アパート") >= 0) {
			return "0";
		} else if (houseSort.indexOf("マンション") >= 0) {
			return "1";
		} else if (houseSort.indexOf("一戸建て") >= 0) {
			return "2";
//		} else if (houseSort.indexOf("") >= 0) {
//			return "3";
//		} else if (houseSort.indexOf("2K") >= 0) {
//			return "4";
//		} else if (houseSort.indexOf("2DK") >= 0) {
//			return "5";
//		} else if (houseSort.indexOf("2LDK") >= 0) {
//			return "6";
		} else {
			return "7";
		} 
		
	}
	public static String getCompanyName(String companyInfo) {
		StringTokenizer st = new StringTokenizer(companyInfo, "\n");
		String company = "";
		int index = 0;
		while (st.hasMoreTokens()) {
			if (index == 2) {
				break;
			}
			company = st.nextToken();
			++index;
		}
		return company;
	}
	
	
	/**
	 * @param Madori
	 * @return
	 */
	public static String getMadori(String madori) {
		
		if (madori.indexOf("1R") >= 0 || madori.indexOf("ワンルーム") >= 0) {
			return "0";
		} else if (madori.indexOf("1K") >= 0) {
			return "1";
		} else if (madori.indexOf("1DK") >= 0) {
			return "2";
		} else if (madori.indexOf("1LDK") >= 0) {
			return "3";
		} else if (madori.indexOf("2K") >= 0) {
			return "4";
		} else if (madori.indexOf("2DK") >= 0) {
			return "5";
		} else if (madori.indexOf("2LDK") >= 0) {
			return "6";
		} else if (madori.indexOf("3DK") >= 0) {
			return "7";
		} else if (madori.indexOf("3LDK") >= 0) {
			return "8";
		} else if (madori.indexOf("4DK") >= 0) {
			return "9";
		} else if (madori.indexOf("4LDK") >= 0) {
			return "10";
		} else {
			return "11";
		}
		
	}
	
	
	public static Map<String,String> getTrainInfo(String trainInfo) {
		String line = trainInfo.substring(0, trainInfo.indexOf("/")); 
		String station =  trainInfo.substring(trainInfo.indexOf("/") + 1, trainInfo.length()); 
		
		if (line.equals("中央線")) {
			line = "中央本線";
		}
		return searchLineStaionCode(line, station);
	}
	
	private static Map<String,String> searchLineStaionCode(String line, String station) {
		
		Map<String,String> result = new HashMap<String, String>();
		Connection con = null;
		LogPreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = DBConnectionMgr.getInstance().getConnection();
			String sql = "select station_code,line_code from t_train where station_kanji like '%" + station + "%' and line_kanji like '%" + line + "%'";
			pstmt = new LogPreparedStatement(con, sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				result.put("station_code", rs.getString("station_code"));
				result.put("line_code", rs.getString("line_code"));
			} else {
				result.put("station_code", "0000");
				result.put("line_code", "00");
			}

		} catch (AppException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnectionMgr.getInstance().freeConnection(con, pstmt, rs);
		}
		
		return result;
	}
	
	public static Map<String,String> getAreaCode(String areaInfo) {
		
		Map<String,String> result = null;
		
		int index = 0;
		if (areaInfo.indexOf("東京都") >=0) {
			index = areaInfo.indexOf("区");
			result = searchAreaCode(areaInfo.substring(3, index));
			result.put("area_code_3", areaInfo.substring(index + 1, areaInfo.length()));
		} else if ((index = areaInfo.indexOf("区")) >=0) {
			result = searchAreaCode(areaInfo.substring(0, index));
			result.put("area_code_3", areaInfo.substring(index + 1, areaInfo.length()));
		} else if ((index = areaInfo.indexOf("市")) >=0) {
			result = searchAreaCode(areaInfo.substring(0, index));
			result.put("area_code_3", areaInfo.substring(index + 1, areaInfo.length()));
		} else {
			result = new HashMap<String, String>();
			result.put("area_code_1", "00");
			result.put("area_code_2", "0000");
			result.put("area_code_3", areaInfo);
		}
		
		return result;
	}
	private static Map<String,String> searchAreaCode(String area) {
	
		Map<String,String> result = new HashMap<String, String>();
		Connection con = null;
		LogPreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = DBConnectionMgr.getInstance().getConnection();
			String sql = "select area_code_1,area_code_2 from t_area where area_name_2 like '%" + area + "%'";
			pstmt = new LogPreparedStatement(con, sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				result.put("area_code_1", rs.getString("area_code_1"));
				result.put("area_code_2", rs.getString("area_code_2"));
			}

		} catch (AppException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnectionMgr.getInstance().freeConnection(con, pstmt, rs);
		}
		
		return result;
	}
	
	public static String removeLnKara(String str) {
		return str.replaceAll("\n", "").replaceAll(" ", "");
		
	}

}
