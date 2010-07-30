package common.handler;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

import main.bean.BannerBean;

import common.bean.CategoryBean;
import common.constant.Const;
import common.database.DBConnectionMgr;
import common.database.LogPreparedStatement;
import common.exception.SysException;
import common.logger.KankokujinLogger;

public class InitServletHandler {
	private static InitServletHandler instance = null;
	private InitServletHandler(){
		
	}
    public static InitServletHandler getInstance() {
        if (instance == null) {
            synchronized (InitServletHandler.class) {
                if (instance == null) {
                    instance = new InitServletHandler();
                }
            }
        }

        return instance;
    }	
//    public List getAreaBeanList() throws SysException{
//    	return changeMapToBeanList(getArea1Info(), getArea2Info(), 4);
//    }
//    public List getTrainBeanList() throws SysException{
//    	return changeMapToBeanList(getTrainLineInfo(), getStationInfoList(), 4);
//    }
//    public List getStoreCateBeanList() throws SysException{
//    	return changeMapToBeanList(getCate1Info(Const.TABLE_NAME_STORE_CATEGORY), getCate2Info(Const.TABLE_NAME_STORE_CATEGORY), 6);
//    }      
//    public List getJobCateBeanList() throws SysException{
//    	return changeMapToBeanList(getCate1Info(Const.TABLE_NAME_JOB_CATEGORY), getCate2Info(Const.TABLE_NAME_JOB_CATEGORY), 6);
//    }  
//    public List getGourmetCateBeanList() throws SysException{
//    	return changeMapToBeanList(getCate1Info(Const.TABLE_NAME_GOURMET_CATEGORY), getCate2Info(Const.TABLE_NAME_GOURMET_CATEGORY), 6);
//    }  
//    public List getBuySellCateBeanList() throws SysException{
//    	return changeMapToBeanList(getCate1Info(Const.TABLE_NAME_BUYSELL_CATEGORY), getCate2Info(Const.TABLE_NAME_BUYSELL_CATEGORY), 6);
//    }      
    
    public List changeMapToBeanList(SortedMap map1, SortedMap map2, int cate_code_length) throws SysException {
		List list = new ArrayList();

		SortedMap map3 = new TreeMap();
		Set set2= map2.keySet();
		Iterator it2 = set2.iterator();
		while(it2.hasNext()){
			String cate_code_2=(String)it2.next();
			String cate_code_1 = cate_code_2.substring(cate_code_length-4, cate_code_length-2);
			if(!map3.containsKey(cate_code_1)){
				CategoryBean oyaCategoryBean = new CategoryBean();
				oyaCategoryBean.setCate_code(cate_code_1);
				oyaCategoryBean.setCate_name((String)map1.get(cate_code_1));
				CategoryBean childCategoryBean = new CategoryBean();
				childCategoryBean.setCate_code(cate_code_2);
				childCategoryBean.setCate_name((String)map2.get(cate_code_2));
				List childList = new ArrayList();
				childList.add(childCategoryBean);
				oyaCategoryBean.setChildBeanList(childList);
				map3.put(cate_code_1, oyaCategoryBean);
			} else {
				CategoryBean oyaCategoryBean = (CategoryBean)map3.get(cate_code_1);
				List childBeanList = oyaCategoryBean.getChildBeanList();
				CategoryBean childCategoryBean = new CategoryBean();
				childCategoryBean.setCate_code(cate_code_2);
				childCategoryBean.setCate_name((String)map2.get(cate_code_2));
				childBeanList.add(childCategoryBean);
			}	
		}
		Set set3 = map3.keySet();
		Iterator it3 = set3.iterator();
		while (it3.hasNext()) {
			String key = (String)it3.next();
			list.add((CategoryBean)map3.get(key));
		}
		return list;
	}
    public SortedMap getArea1Info(Connection con) throws SysException {
		LogPreparedStatement pstmt = null;
		ResultSet rs = null;
		SortedMap map = new TreeMap();

		try {

			String strSql = "select area_code_1, area_name_1 from t_area group by area_code_1";
			pstmt = new LogPreparedStatement(con, strSql);
			rs = pstmt.executeQuery();
			KankokujinLogger.getInstance().debug("InitServletHandler.getArea1Info" + pstmt.getQueryString());
			while (rs.next()) {
				map.put(rs.getString("area_code_1"), rs
						.getString("area_name_1"));
			}

		} catch (SQLException e) {
			throw new SysException("SYE0031", e);

		} catch (Exception e) {
			throw new SysException("SYE0031", e);

		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					throw new SysException("SYE0031", e);
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					throw new SysException("SYE0031", e);
				}
			}
		}
		return map;
	}
    public SortedMap getArea2Info(Connection con) throws SysException {
		LogPreparedStatement pstmt = null;
		ResultSet rs = null;
		SortedMap map = new TreeMap();

		try {
			String strSql = "select area_code_2, area_name_2 from t_area";
			pstmt = new LogPreparedStatement(con, strSql);
			rs = pstmt.executeQuery();
			KankokujinLogger.getInstance().debug("InitServletHandler.getArea1Info" + pstmt.getQueryString());
			while (rs.next()) {
				map.put(rs.getString("area_code_2"), rs
						.getString("area_name_2"));
			}

		} catch (SQLException e) {
			throw new SysException("SYE0031", e);

		} catch (Exception e) {
			throw new SysException("SYE0031", e);

		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					throw new SysException("SYE0031", e);
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					throw new SysException("SYE0031", e);
				}
			}
		}
		return map;
	}
    public SortedMap getTrainLineInfo(Connection con) throws SysException {
		LogPreparedStatement pstmt = null;
		ResultSet rs = null;
		SortedMap map = new TreeMap();

		try {
			String strSql = "select line_code, line_kanji from t_train group by line_code";
			pstmt = new LogPreparedStatement(con, strSql);
			rs = pstmt.executeQuery();
			KankokujinLogger.getInstance().debug("InitServletHandler.getTrainLineInfo" + pstmt.getQueryString());
			while (rs.next()) {
				map.put(rs.getString("line_code"), rs
						.getString("line_kanji"));
			}

		} catch (SQLException e) {
			throw new SysException("SYE0031", e);

		} catch (Exception e) {
			throw new SysException("SYE0031", e);

		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					throw new SysException("SYE0031", e);
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					throw new SysException("SYE0031", e);
				}
			}
		}
		return map;
	}
    public SortedMap getStationInfoList(Connection con) throws SysException {
		LogPreparedStatement pstmt = null;
		ResultSet rs = null;
		SortedMap map = new TreeMap();

		try {
			String strSql = "select station_code, station_kanji from t_train";
			pstmt = new LogPreparedStatement(con, strSql);
			rs = pstmt.executeQuery();
			KankokujinLogger.getInstance().debug("InitServletHandler.getStationInfoList" + pstmt.getQueryString());
			while (rs.next()) {
				map.put(rs.getString("station_code"), rs
						.getString("station_kanji"));
			}

		} catch (SQLException e) {
			throw new SysException("SYE0031", e);

		} catch (Exception e) {
			throw new SysException("SYE0031", e);

		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					throw new SysException("SYE0031", e);
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					throw new SysException("SYE0031", e);
				}
			}
		}
		return map;
	}
    public SortedMap getCate1Info(Connection con, String table_name) throws SysException {
		LogPreparedStatement pstmt = null;
		ResultSet rs = null;
		SortedMap map = new TreeMap();

		try {
			String strSql = "select cate_code_1, category_name_1 from "+ table_name +" group by cate_code_1";
			pstmt = new LogPreparedStatement(con, strSql);
			rs = pstmt.executeQuery();
			KankokujinLogger.getInstance().debug("InitServletHandler.getCate1Info" + pstmt.getQueryString());
			while (rs.next()) {
				map.put(rs.getString("cate_code_1"), rs
						.getString("category_name_1"));
			}

		} catch (SQLException e) {
			throw new SysException("SYE0031", e);

		} catch (Exception e) {
			throw new SysException("SYE0031", e);

		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					throw new SysException("SYE0031", e);
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					throw new SysException("SYE0031", e);
				}
			}
		}
		return map;
	}
    public SortedMap getCate2Info(Connection con, String table_name) throws SysException {
		LogPreparedStatement pstmt = null;
		ResultSet rs = null;
		SortedMap map = new TreeMap();
		try {
			String strSql = "select cate_code_2, category_name_2 from " + table_name;
			pstmt = new LogPreparedStatement(con, strSql);
			rs = pstmt.executeQuery();
			KankokujinLogger.getInstance().debug("InitServletHandler.getCate2Info" + pstmt.getQueryString());
			while (rs.next()) {
				map.put(rs.getString("cate_code_2"), rs
						.getString("category_name_2"));
			}

		} catch (SQLException e) {
			throw new SysException("SYE0031", e);

		} catch (Exception e) {
			throw new SysException("SYE0031", e);

		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					throw new SysException("SYE0031", e);
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					throw new SysException("SYE0031", e);
				}
			}
		}
		return map;
	}
    
    /**
     * 
     * @return
     * @throws SysException
     */
    public Map readAreaCodeToMap(Connection con) throws SysException {
		LogPreparedStatement pstmt = null;
		ResultSet rs = null;
		Map map = new TreeMap();

		try {
			String strSql = "select * from t_area order by area_code_1 asc,area_code_2 asc";
			pstmt = new LogPreparedStatement(con, strSql);
			rs = pstmt.executeQuery();
			KankokujinLogger.getInstance().debug("InitServletHandler.readAreaCodeToMap" + pstmt.getQueryString());
			while (rs.next()) {
				
				String area_code_1 = rs.getString("area_code_1");
				String area_name_1 = rs.getString("area_name_1");
				
				if (!map.containsKey(area_code_1)) {
					CategoryBean oyaBean = new CategoryBean();
					CategoryBean childBean = new CategoryBean();
					oyaBean.setCate_code(area_code_1);
					oyaBean.setCate_name(area_name_1);
					childBean.setCate_code(rs.getString("area_code_2"));
					childBean.setCate_name(rs.getString("area_name_2"));
					oyaBean.addChild(childBean);
					map.put(area_code_1, oyaBean);
				} else {
					CategoryBean bean = (CategoryBean) map.get(area_code_1);
					CategoryBean childBean = new CategoryBean();
					childBean.setCate_code(rs.getString("area_code_2"));
					childBean.setCate_name(rs.getString("area_name_2"));
					bean.addChild(childBean);
				}
			}

		} catch (SQLException e) {
			throw new SysException("SYE0031", e);

		} catch (Exception e) {
			throw new SysException("SYE0031", e);

		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					throw new SysException("SYE0031", e);
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					throw new SysException("SYE0031", e);
				}
			}
		}
		return map;
	}
    
    /**
     * 
     * @return
     * @throws SysException
     */
    public Map readTrainCodeToMap(Connection con) throws SysException {
		LogPreparedStatement pstmt = null;
		ResultSet rs = null;
		Map map = new TreeMap();

		try {

			String strSql = "select * from t_train order by line_code asc,station_code asc ";
			pstmt = new LogPreparedStatement(con, strSql);
			rs = pstmt.executeQuery();
			KankokujinLogger.getInstance().debug("InitServletHandler.readTrainCodeToMap" + pstmt.getQueryString());
			while (rs.next()) {
				
				String line_code = rs.getString("line_code");
				String line_kanji = rs.getString("line_kanji");
				
				if (!map.containsKey(line_code)) {
					CategoryBean oyaBean = new CategoryBean();
					CategoryBean childBean = new CategoryBean();
					oyaBean.setCate_code(line_code);
					oyaBean.setCate_name(line_kanji);
					childBean.setCate_code(rs.getString("station_code"));
					childBean.setCate_name(rs.getString("station_kanji"));
					oyaBean.addChild(childBean);
					map.put(line_code, oyaBean);
				} else {
					CategoryBean bean = (CategoryBean) map.get(line_code);
					CategoryBean childBean = new CategoryBean();
					childBean.setCate_code(rs.getString("station_code"));
					childBean.setCate_name(rs.getString("station_kanji"));
					bean.addChild(childBean);
				}
			}

		} catch (SQLException e) {
			throw new SysException("SYE0031", e);

		} catch (Exception e) {
			throw new SysException("SYE0031", e);

		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					throw new SysException("SYE0031", e);
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					throw new SysException("SYE0031", e);
				}
			}
		}
		return map;
	}
    /**
     * 
     * @return
     * @throws SysException
     */
    public Map readCategoryCodeToMap(Connection con, String table_name) throws SysException {
		LogPreparedStatement pstmt = null;
		ResultSet rs = null;
		Map map = new TreeMap();

		try {

			String strSql = "select * from " + table_name;
			pstmt = new LogPreparedStatement(con, strSql);
			rs = pstmt.executeQuery();
			KankokujinLogger.getInstance().debug("InitServletHandler.readTrainCodeToMap" + pstmt.getQueryString());
			while (rs.next()) {
				
				String cate_code_1 = rs.getString("cate_code_1");
				String category_name_1 = rs.getString("category_name_1");
				
				if (!map.containsKey(cate_code_1)) {
					CategoryBean oyaBean = new CategoryBean();
					oyaBean.setCate_code(cate_code_1);
					oyaBean.setCate_name(category_name_1);
					map.put(cate_code_1, oyaBean);
				} else {
					CategoryBean bean = (CategoryBean) map.get(cate_code_1);
					CategoryBean childBean = new CategoryBean();
					childBean.setCate_code(rs.getString("cate_code_2"));
					childBean.setCate_name(rs.getString("category_name_2"));
					bean.addChild(childBean);
				}
			}

		} catch (SQLException e) {
			throw new SysException("SYE0031", e);

		} catch (Exception e) {
			throw new SysException("SYE0031", e);

		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					throw new SysException("SYE0031", e);
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					throw new SysException("SYE0031", e);
				}
			}
		}
		return map;
	}
    /**
     * 
     * @param con
     * @param sort
     * @return
     * @throws SysException
     */
    public List getBannerList(Connection con, String sort) throws SysException {
		LogPreparedStatement pstmt = null;
		ResultSet rs = null;
		List bannerList = new ArrayList();
		try {
			StringBuffer sb = new StringBuffer();
			sb.append("select * from bannertag where sort = ");
			sb.append(sort);
			pstmt = new LogPreparedStatement(con, sb.toString());
			KankokujinLogger.getInstance().debug("NewWriteHandler.getBannerList sql= " + pstmt.getQueryString());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				BannerBean bean = new BannerBean();
				bean.setTitle(rs.getString("title"));
				bean.setLink(rs.getString("tag"));
				bannerList.add(bean);
			}

		} catch (SQLException e) {
			throw new SysException("SYE0021", e);

		} catch (Exception e) {
			throw new SysException("SYE0021", e);

		} finally {
			if (rs != null) {

				try {
					rs.close();
				} catch (SQLException e) {
					throw new SysException("SYE0021", e);
				}
			}
			if (pstmt != null) {

				try {
					pstmt.close();
				} catch (SQLException e) {
					throw new SysException("SYE0021" + e);
				}
			}
		}
		return bannerList;

	}
}
