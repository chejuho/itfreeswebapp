package gourmet.handler;

import gourmet.bean.GourmetBean;
import gourmet.bean.GourmetSearchBean;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import menu.bean.MenuBean;
import menu.handler.SQLUtil;
import store.bean.StoreSearchBean;

import common.bean.PageBean;
import common.database.DBConnectionMgr;
import common.database.LogPreparedStatement;
import common.exception.SysException;
import common.logger.KankokujinLogger;
import common.page.PageUtil;
import common.util.Util;

public class GourmetSearchHandler {
	private static GourmetSearchHandler instance = null;
	private GourmetSearchHandler(){
		
	}
    public static GourmetSearchHandler getInstance() {
        if (instance == null) {
            synchronized (GourmetSearchHandler.class) {
                if (instance == null) {
                    instance = new GourmetSearchHandler();
                }
            }
        }

        return instance;
    }	
		/**
	 * countの情報をお知らせする
	 * 
	 * @param bean
	 *            countを及ぶ
	 * @return count columnIndexの最初の列をintとして取得
	 */
	public int getInfoCount(GourmetSearchBean gourmetSearchBean)
			throws SysException {
		Connection con = null;
		LogPreparedStatement pstmt = null;
		ResultSet rs = null;
		int count = 0;

		try {
			con = DBConnectionMgr.getInstance().getConnection();
			StringBuffer sb = new StringBuffer();
			sb.append("select count(*) from gourmet_info, member, t_area , t_train where ");
			sb.append(" gourmet_info.user_id=member.user_id and ");
			sb.append(" gourmet_info.area_code_1=t_area.area_code_1 and ");
			sb.append(" gourmet_info.area_code_2=t_area.area_code_2 and ");
			sb.append(" gourmet_info.line_code=t_train.line_code and ");
			sb.append(" gourmet_info.station_code=t_train.station_code and ");
			sb.append(" gourmet_info.deleteflg = 0 ");								
			sb.append(getWhereList(gourmetSearchBean, false, false));
			pstmt = new LogPreparedStatement(con, sb.toString());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				count = rs.getInt(1);
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
			if (con != null) {
				DBConnectionMgr.getInstance().freeConnection(con);
			}
		}

		return count;

	}
	/**
	 * 条件節のハッシュマップ情報からwhere節を作る
	 * 
	 * @param map
	 * @return
	 */
	public String getWhereList(GourmetSearchBean bean, boolean category1Sign, boolean category2Sign) {

		ArrayList<String> list = new ArrayList<String>();
		if (!"".equals(bean.getArea_code_1())
				&& !"00".equals(bean.getArea_code_1())) {
			list.add(getAreaCode1Tag(bean.getArea_code_1()));

			if (!"".equals(bean.getArea_code_2())
					&& !"00".equals(bean.getArea_code_2().substring(2, 4))) {
				list.add(getAreaCode2Tag(bean.getArea_code_2()));
			}
		}

		if (!"".equals(bean.getLine_code())
				&& !"00".equals(bean.getLine_code())) {
			list.add(getLineCodeTag(bean.getLine_code()));

			String station_code = bean.getStation_code();
			if (!Util.isEmpty(station_code) && station_code.length() == 4) {
				if (!"00".equals(station_code.substring(2, 4))) {
					list.add(getStationCodeTag(bean.getStation_code()));
				}
			}
		}
		if (!category1Sign) {
			if (!Util.isEmpty(bean.getCate_code_1())
					&& !"0000".equals(bean.getCate_code_1().substring(4, 6))) {
				list.add(getCate_code_1Tag(bean.getCate_code_1()));
				if (!category2Sign) {
					String cate_code_2 = bean.getCate_code_2();
					if (!Util.isEmpty(cate_code_2) && cate_code_2.length() == 6) {
						if (!"0000".equals(cate_code_2.substring(4, 6))) {
							list.add(getCate_code_2Tag(cate_code_2));
						}
					}
				}
			}
		}
		if (!Util.isEmpty(bean.getSearch())){
			getSearchWhereAll(list, bean);
		}
		
		if (("0".equals(bean.getRegist_date())) || ("1".equals(bean.getRegist_date())) || ("2".equals(bean.getRegist_date()))) {
			list.add(getRegistDateTag(bean.getRegist_date()));
		}
		if(!Util.isEmpty(bean.getUser_id())){
			list.add(getUser_id_Tag(bean.getUser_id()));
		}
		return getWhereSQL(list);

	}
	private String getUser_id_Tag(String user_id) {
		return "gourmet_info.user_id = '" + user_id + "'";
	}
	private String getRegistDateTag(String regist_date) {
		StringBuffer sb = new StringBuffer();
		if ("0".equals(regist_date)) {
			sb.append("update_date > DATE_SUB(CURDATE(),INTERVAL 1 DAY)");
		} else if ("1".equals(regist_date)) {
			sb.append("update_date > DATE_SUB(CURDATE(),INTERVAL 14 DAY)");
		} else if ("2".equals(regist_date)) {
			sb.append("update_date > DATE_SUB(CURDATE(),INTERVAL 30 DAY)");
		}
		return sb.toString();

	}
	public void getSearchWhereAll(List list, GourmetSearchBean bean) {
		List whereList = changeSearch(bean.getSearch());
		Iterator it = whereList.iterator();
		List list2 = new ArrayList();
		while (it.hasNext()) {
			getSearchWhere(list2, (String)it.next(), bean);
		}
		list.add(getWhereOrSql(list2));

	}

	private void getSearchWhere(List list, String search, GourmetSearchBean bean) {
		String sql = "";

		if ("selected".equals(bean.getSearch_all())) {
			sql = "(" + getComNameTag(search) + " or " + getSearchWordTag(search) +  " or " + getAppealPointTag(search) + " or "
					+ getDetailTag(search) + ")";
			list.add(sql);
		} else if ("selected".equals(bean.getSearch_com_name())) {
			sql = getComNameTag(search);
			list.add(sql);
		} else if ("selected".equals(bean.getSearch_detail())) {
			sql = getDetailTag(search);
			list.add(sql);
		}

	}
	private String getSearchWordTag(String search_word) {

		return "search_word like '%" + search_word + "%'";
	}	
	private String getAppealPointTag(String appeal_point) {

		return "appeal_point like '%" + appeal_point + "%'";
	}
	public List changeSearch(String search) {
		List list = new ArrayList();

		StringTokenizer st1 = new StringTokenizer(search, " ");
		while (st1.hasMoreTokens()) {
			changeSearchZenkaku(list, st1.nextToken());
		}

		return list;
	}

	private void changeSearchZenkaku(List list, String input) {
		StringTokenizer st2 = new StringTokenizer(input, "　");
		while (st2.hasMoreTokens()) {
			list.add(st2.nextToken());
		}
	}

	/**
	 * 条件節のハッシュマップ情報からwhere節を作る
	 * 
	 * @param map
	 * @return
	 */
	private String getWhereSQL(ArrayList list) {
		Iterator it = list.iterator();
		StringBuffer sb = new StringBuffer();
		while (it.hasNext()) {
			sb.append(" and ");
			sb.append((String) it.next());
			sb.append(" ");
		}
		return sb.toString();

	}
	private String getWhereOrSql(List list) {
		Iterator it = list.iterator();
		StringBuffer sb = new StringBuffer();

		if (list.size() > 0) {
			sb.append(" (");
		}
		boolean isNotFirst = false;
		while (it.hasNext()) {
			if (isNotFirst) {
				sb.append(" or ");
			}			
			isNotFirst = true;
			sb.append((String) it.next());
			sb.append(" ");

		}
		if (list.size() > 0) {
			sb.append(") ");
		}
		return sb.toString();

	}
	/**
	 * 条件節のハッシュマップ情報からwhere節を作る
	 * 
	 * @param map
	 * @return
	 */
	private String getAreaCode1Tag(String area_code_1) {
		return " gourmet_info.area_code_1 = '" + area_code_1 + "'";
	}

	private String getCate_code_1Tag(String cate_code_1) {
		return " gourmet_info.cate_code_1 = '" + cate_code_1 + "'";
	}

	private String getCate_code_2Tag(String cate_code_2) {
		return " gourmet_info.cate_code_2 = '" + cate_code_2 + "'";
	}
	private String getAreaCode2Tag(String area_code_2) {
		return " gourmet_info.area_code_2 = '" + area_code_2 + "'";
	}
	private String getLineCodeTag(String line_code) {
		return " gourmet_info.line_code = '" + line_code+ "'";
	}
	private String getStationCodeTag(String station_code) {
		return " gourmet_info.station_code = '" + station_code+ "'";
	}

	private String getComNameTag(String search) {
		return " gourmet_info.store_name_k like '%" + search + "%' or gourmet_info.store_name_j like '%" + search + "%'";
	}

	private String getDetailTag(String search) {
		return " gourmet_info.detail_info like '%" + search + "%'";
	}
	public String getDetailTag(List searchList) {
		StringBuffer sb = new StringBuffer();
		if (searchList != null && searchList.size() == 1) {
			sb.append(" gourmet_info.detail_info like '%" + searchList.get(0) + "%'");

		} else if (searchList != null && searchList.size() != 1) {
			sb.append("(");
			Iterator it = searchList.iterator();
			boolean isFirst = true;
			while (it.hasNext()) {
				if (!isFirst) {
					sb.append(" or ");
				} else {
					isFirst = false;
				}
				sb.append(" gourmet_info.detail_info like '%" + it.next() + "%'");

			}
			sb.append(")");
		}
		return sb.toString();
	}
	/**
	 * descとascの整列
	 * 
	 * @param request,interpretBean,interpretSortBean,start,num
	 * @return list 整列の値
	 */
	public ArrayList<GourmetBean> getSearchGourmetList(int start,
			int num, GourmetSearchBean gourmetSearchBean) throws SysException {

		Connection con = null;
		LogPreparedStatement pstmt = null;
		ResultSet rs = null;

		ArrayList<GourmetBean> list = new ArrayList<GourmetBean>();
		try {

			con = DBConnectionMgr.getInstance().getConnection();
			StringBuffer sb = new StringBuffer();
			sb.append("select * from gourmet_info, member, t_area , t_train where ");
			sb.append(" gourmet_info.user_id=member.user_id and ");
			sb.append(" gourmet_info.area_code_1=t_area.area_code_1 and ");
			sb.append(" gourmet_info.area_code_2=t_area.area_code_2 and ");
			sb.append(" gourmet_info.line_code=t_train.line_code and ");
			sb.append(" gourmet_info.station_code=t_train.station_code and ");
			sb.append(" gourmet_info.deleteflg = 0 ");
			
			sb.append(getWhereList(gourmetSearchBean, false, false));
			sb.append("group by gourmet_info.id order by gourmet_info.update_date desc limit ?,? ");			
			pstmt = new LogPreparedStatement(con, sb.toString());
			pstmt.setInt(1, start - 1);
			pstmt.setInt(2, num);
			rs = pstmt.executeQuery();
			KankokujinLogger.getInstance().debug("GourmetSearchHandler.getSearchGourmetList" + pstmt.getQueryString());
			while (rs.next()) {

				GourmetBean bean = new GourmetBean();
				bean.setId(rs.getString("id"));
				bean.setUser_id(rs.getString("user_id"));
				bean.setUser_name(Util.changeNullStr(rs.getString("name")));
				bean.setStore_name_k(Util.changeNullStr(rs.getString("store_name_k")));
				bean.setStore_name_j(Util.changeNullStr(rs.getString("store_name_j")));				
				bean.setTel_no1_1(rs.getString("tel_no1_1"));
				bean.setTel_no1_2(rs.getString("tel_no1_2"));
				bean.setTel_no1_3(rs.getString("tel_no1_3"));
				bean.setTel_no2_1(rs.getString("tel_no2_1"));
				bean.setTel_no2_2(rs.getString("tel_no2_2"));
				bean.setTel_no2_3(rs.getString("tel_no2_3"));
				bean.setFax_no_1(rs.getString("fax_no_1"));
				bean.setFax_no_2(rs.getString("fax_no_2"));
				bean.setFax_no_3(rs.getString("fax_no_3"));
				bean.setEmail(rs.getString("email"));
				bean.setUrl(rs.getString("url"));

				bean.setPhoto_name1(rs.getString("photo_name1"));
				bean.setArea_code_1(Util.changeNullStr(rs.getString("area_code_1")));
				bean.setArea_code_2(Util.changeNullStr(rs.getString("area_code_2")));
				if(!"00".equals(bean.getArea_code_1())){
					bean.setArea_name_1(Util.changeNullStr(rs.getString("area_name_1")));
				}
				if(!"00".equals(bean.getArea_code_2().substring(2, 4))){
					bean.setArea_name_2(Util.changeNullStr(rs.getString("area_name_2")));
				}				
				bean.setArea_code_3(Util.changeNullStr(rs.getString("area_code_3")));
				bean.setLine_code(Util.changeNullStr(rs.getString("line_code")));
				bean.setStation_code(Util.changeNullStr(rs.getString("station_code")));
				if(!"00".equals(bean.getLine_code())){
					bean.setLine_name(Util.changeNullStr(rs.getString("line_kanji")));
				}
				if(!"00".equals(bean.getStation_code().substring(2, 4))){
					bean.setStation_name(Util.changeNullStr(rs.getString("station_kanji")));
				}	
				bean.setArea_fast(rs.getString("area_fast"));
				bean.setDetail_info(Util.changeNullStr(rs.getString("detail_info")));
				bean.setUpdate_date(rs.getTimestamp("update_date"));
				bean.setAppeal_point(Util.changeNullStr(rs.getString("appeal_point")));
				list.add(bean);

			}

		} catch (SQLException e) {
			throw new SysException("SYE0033", e);

		} catch (Exception e) {
			throw new SysException("SYE0033", e);

		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					throw new SysException("SYE0033", e);
				}
			}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException e) {
					throw new SysException("SYE0033", e);

				}
			if (con != null) {
				DBConnectionMgr.getInstance().freeConnection(con);
			}
		}

		return list;

	}
	
	/**
	 * descとascの整列
	 * 
	 * @param request,interpretBean,interpretSortBean,start,num
	 * @return list 整列の値
	 */
	public ArrayList<GourmetBean> getSearchGourmetListTotal(
			Connection con,
			PageBean pageBean,
			GourmetSearchBean gourmetSearchBean) throws SysException {

		LogPreparedStatement pstmt = null;
		ResultSet rs = null;

		//maxCount
		int maxCount = 0;
		ArrayList<GourmetBean> list = new ArrayList<GourmetBean>();
		try {
			String countGetQuery = getCountGetQuery(gourmetSearchBean);
			String listGetQuery = getListGetQuery(gourmetSearchBean);
			
			//画面に表示する総データ数を取得
			pstmt = new LogPreparedStatement(con, countGetQuery);
			rs = pstmt.executeQuery();
			KankokujinLogger.getInstance().debug("StoreSearchHandler.getSearchGourmetListTotal.sql1=" + pstmt.getQueryString());
			if (rs.next()) {
				maxCount = rs.getInt(1);
			}
			
			//ページ処理
			PageUtil.getInstance().nextPage(pageBean, maxCount);
			
			//画面に表示する総データリストを取得
			pstmt = new LogPreparedStatement(con, listGetQuery);
			pstmt.setInt(1, pageBean.getStartCount() - 1);
			pstmt.setInt(2, pageBean.getPageSize());
			rs = pstmt.executeQuery();
			KankokujinLogger.getInstance().debug("StoreSearchHandler.getSearchGourmetListTotal.sql2=" + pstmt.getQueryString());
			while (rs.next()) {

				GourmetBean bean = new GourmetBean();
				bean.setId(rs.getString("id"));
				bean.setUser_id(rs.getString("user_id"));
				bean.setUser_name(Util.changeNullStr(rs.getString("name")));
				bean.setStore_name_k(Util.changeNullStr(rs.getString("store_name_k")));
				bean.setStore_name_j(Util.changeNullStr(rs.getString("store_name_j")));				
				bean.setTel_no1_1(rs.getString("tel_no1_1"));
				bean.setTel_no1_2(rs.getString("tel_no1_2"));
				bean.setTel_no1_3(rs.getString("tel_no1_3"));
				bean.setTel_no2_1(rs.getString("tel_no2_1"));
				bean.setTel_no2_2(rs.getString("tel_no2_2"));
				bean.setTel_no2_3(rs.getString("tel_no2_3"));
				bean.setFax_no_1(rs.getString("fax_no_1"));
				bean.setFax_no_2(rs.getString("fax_no_2"));
				bean.setFax_no_3(rs.getString("fax_no_3"));
				bean.setEmail(rs.getString("email"));
				bean.setUrl(rs.getString("url"));

				bean.setPhoto_name1(rs.getString("photo_name1"));
				bean.setArea_code_1(Util.changeNullStr(rs.getString("area_code_1")));
				bean.setArea_code_2(Util.changeNullStr(rs.getString("area_code_2")));
				if(!"00".equals(bean.getArea_code_1())){
					bean.setArea_name_1(Util.changeNullStr(rs.getString("area_name_1")));
				}
				if(!"00".equals(bean.getArea_code_2().substring(2, 4))){
					bean.setArea_name_2(Util.changeNullStr(rs.getString("area_name_2")));
				}				
				bean.setArea_code_3(Util.changeNullStr(rs.getString("area_code_3")));
				bean.setLine_code(Util.changeNullStr(rs.getString("line_code")));
				bean.setStation_code(Util.changeNullStr(rs.getString("station_code")));
				if(!"00".equals(bean.getLine_code())){
					bean.setLine_name(Util.changeNullStr(rs.getString("line_kanji")));
				}
				if(!"00".equals(bean.getStation_code().substring(2, 4))){
					bean.setStation_name(Util.changeNullStr(rs.getString("station_kanji")));
				}	
				bean.setArea_fast(rs.getString("area_fast"));
				bean.setDetail_info(Util.changeNullStr(rs.getString("detail_info")));
				bean.setUpdate_date(rs.getTimestamp("update_date"));
				bean.setAppeal_point(Util.changeNullStr(rs.getString("appeal_point")));
				list.add(bean);

			}

		} catch (SQLException e) {
			throw new SysException("SYE0033", e);

		} catch (Exception e) {
			throw new SysException("SYE0033", e);

		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					throw new SysException("SYE0033", e);
				}
			} 
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					throw new SysException("SYE0033", e);

				}
			}
		}

		return list;

	}
	
	/**
	 * @param gourmetSearchBean
	 * @return Countを取得するSQL
	 */
	private String getCountGetQuery(GourmetSearchBean gourmetSearchBean) {
		
		StringBuffer sb = new StringBuffer();
		sb.append("select count(*) from gourmet_info, member, t_area , t_train where ");
		sb.append(" gourmet_info.user_id=member.user_id and ");
		sb.append(" gourmet_info.area_code_1=t_area.area_code_1 and ");
		sb.append(" gourmet_info.area_code_2=t_area.area_code_2 and ");
		sb.append(" gourmet_info.line_code=t_train.line_code and ");
		sb.append(" gourmet_info.station_code=t_train.station_code and ");
		sb.append(" gourmet_info.deleteflg = 0 ");								
		sb.append(getWhereList(gourmetSearchBean, false, false));
		
		return sb.toString();
	}
	/**
	 * @param gourmetSearchBean
	 * @return リストを取得するSQL
	 */
	private String getListGetQuery(GourmetSearchBean gourmetSearchBean) {
		
		StringBuffer sb = new StringBuffer();
		sb.append("select * from gourmet_info, member, t_area , t_train where ");
		sb.append(" gourmet_info.user_id=member.user_id and ");
		sb.append(" gourmet_info.area_code_1=t_area.area_code_1 and ");
		sb.append(" gourmet_info.area_code_2=t_area.area_code_2 and ");
		sb.append(" gourmet_info.line_code=t_train.line_code and ");
		sb.append(" gourmet_info.station_code=t_train.station_code and ");
		sb.append(" gourmet_info.deleteflg = 0 ");
		sb.append(getWhereList(gourmetSearchBean, false, false));
		sb.append("group by gourmet_info.id order by gourmet_info.update_date desc limit ?,? ");	
		
		return sb.toString();
	}
	
	/**
	 * 
	 * @param con
	 * @param tablename
	 * @throws SysException
	 */
	public Map getCategory1Count(Connection con, GourmetSearchBean gourmetSearchBean) throws SysException{

		List resultList = null;
		LogPreparedStatement pstmt = null;
		ResultSet rs = null;
		StringBuffer sql = new StringBuffer();  
		sql.append("select count(*) as count,cate_code_1 as cate_code from gourmet_info, member, t_area , t_train where ");
		sql.append(" gourmet_info.user_id=member.user_id and ");
		sql.append(" gourmet_info.area_code_1=t_area.area_code_1 and ");
		sql.append(" gourmet_info.area_code_2=t_area.area_code_2 and ");
		sql.append(" gourmet_info.line_code=t_train.line_code and ");
		sql.append(" gourmet_info.station_code=t_train.station_code and ");
		sql.append(" gourmet_info.deleteflg = 0 ");					
		sql.append(getWhereList(gourmetSearchBean, true, false));
		sql.append("  group by cate_code_1 ");
		try {
			pstmt = new LogPreparedStatement(con, sql.toString());
			rs = pstmt.executeQuery();
			KankokujinLogger.getInstance().debug("getCategory1Count" + pstmt.getQueryString());
			
			resultList = SQLUtil.resultSetToList(rs);
			
		} catch (SQLException e) {
			throw new SysException("SYE0014", e);
		} catch (Exception e) {
			throw new SysException("SYE0014", e);
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					throw new SysException("SYE0015", e);
				}
			}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException e) {
					throw new SysException("SYE0014", e);
				}
		}
		return categoryResultListToMap(resultList);
	}
	
	/**
	 * 
	 * @param con
	 * @param tablename
	 * @throws SysException
	 */
	public Map getCategory2Count(Connection con, GourmetSearchBean gourmetSearchBean) throws SysException{

		if (Util.isEmpty(gourmetSearchBean.getCate_code_1())) {
			return null;
		}
		
		List resultList = null;
		LogPreparedStatement pstmt = null;
		ResultSet rs = null;
		StringBuffer sql = new StringBuffer();  
		sql.append("select count(*) as count,cate_code_2 as cate_code from gourmet_info, member, t_area , t_train where ");
		sql.append(" gourmet_info.user_id=member.user_id and ");
		sql.append(" gourmet_info.area_code_1=t_area.area_code_1 and ");
		sql.append(" gourmet_info.area_code_2=t_area.area_code_2 and ");
		sql.append(" gourmet_info.line_code=t_train.line_code and ");
		sql.append(" gourmet_info.station_code=t_train.station_code and ");
		sql.append(" gourmet_info.deleteflg = 0 ");	
		sql.append(getWhereList(gourmetSearchBean, true, true));
		sql.append("  group by cate_code_2 ");
		try {
			pstmt = new LogPreparedStatement(con, sql.toString());
			rs = pstmt.executeQuery();
			KankokujinLogger.getInstance().debug("getCategory2Count" + pstmt.getQueryString());
			
			resultList = SQLUtil.resultSetToList(rs);
			
		} catch (SQLException e) {
			throw new SysException("SYE0014", e);
		} catch (Exception e) {
			throw new SysException("SYE0014", e);
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					throw new SysException("SYE0015", e);
				}
			}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException e) {
					throw new SysException("SYE0014", e);
				}
		}
		return categoryResultListToMap(resultList);
	}
	
	/**
	 * 
	 * @param resultList
	 * @throws SysException
	 */
	private static Map categoryResultListToMap(List resultList) throws SysException {
		int categoryTotalCount = 0;
		Map result = new HashMap();
		for (Iterator it = resultList.iterator(); it.hasNext();) {
			
			MenuBean bean = (MenuBean) it.next();
			String cate_code = (String) bean.get("cate_code");
			String count = (String) bean.get("count");
			categoryTotalCount += Integer.parseInt(count);
			result.put((String) bean.get("cate_code"), (String) bean.get("count")) ;
			
		}
		result.put("categoryTotalCount", String.valueOf(categoryTotalCount));
		return result;
		
	}
	
}