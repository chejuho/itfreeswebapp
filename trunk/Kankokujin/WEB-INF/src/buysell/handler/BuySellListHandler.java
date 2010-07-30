package buysell.handler;

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

import buysell.bean.BuySellBean;
import buysell.bean.BuySellSearchBean;

import common.bean.PageBean;
import common.database.DBConnectionMgr;
import common.database.LogPreparedStatement;
import common.exception.SysException;
import common.logger.KankokujinLogger;
import common.page.PageUtil;
import common.util.Util;

public class BuySellListHandler {
	private static BuySellListHandler instance = null;
	private BuySellListHandler(){
		
	}
    public static BuySellListHandler getInstance() {
        if (instance == null) {
            synchronized (BuySellListHandler.class) {
                if (instance == null) {
                    instance = new BuySellListHandler();
                }
            }
        }

        return instance;
    }
	public int getInfoCount(BuySellSearchBean buySellSearchBean) throws SysException {

		Connection con = null;
		LogPreparedStatement pstmt = null;
		ResultSet rs = null;
		int count = 0;

		try {
			con = DBConnectionMgr.getInstance().getConnection();
			StringBuffer sb = new StringBuffer();
			sb.append("select count(*) from buysell_info, member ");
			sb.append(getWhereList(buySellSearchBean, false));
			pstmt = new LogPreparedStatement(con, sb.toString());
			rs = pstmt.executeQuery();
			KankokujinLogger.getInstance().debug("BuySellListHandler.getInfoCount" + pstmt.getQueryString());
			if (rs.next()) {
				count = rs.getInt(1);
			}
		} catch (SQLException e) {
			throw new SysException("SYE0037", e);
		} catch (Exception e) {
			throw new SysException("SYE0037", e);
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					throw new SysException("SYE0037", e);
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					throw new SysException("SYE0037" + e);
				}
			}
			if (con != null) {
				DBConnectionMgr.getInstance().freeConnection(con);
			}
		}
		return count;
	}
	private String getWhereList(BuySellSearchBean bean, boolean categorySign) {
		ArrayList<String> list = new ArrayList<String>();

		list.add(" member.user_id =buysell_info.user_id");

		if (!Util.isEmpty(bean.getCate_code_1()) && !"0000".equals(bean.getCate_code_1().substring(4, 6))) {
			list.add(getCate_code_1Tag(bean.getCate_code_1()));
			
			if (!categorySign) {
				String cate_code_2 = bean.getCate_code_2();
				if (!Util.isEmpty(cate_code_2) && cate_code_2.length() == 6) {
					if (!"0000".equals(cate_code_2.substring(4, 6))) {
						list.add(getCate_code_2Tag(cate_code_2));
					}
				} 
			}
		}
		/**　配送方式が条件にある場合 **/
		if ("1".equals(bean.getSend_method()) || "2".equals(bean.getSend_method())) {
			
			list.add(getSendMethodTag(bean.getSend_method()));
		}
		
		if ("1".equals(bean.getMember_sort()) || "2".equals(bean.getMember_sort())) {
			
			list.add(getMemberSortTag(bean.getMember_sort()));
		}		
		/**　製品状態が条件にある場合 **/
		if ("1".equals(bean.getPro_status()) || "2".equals(bean.getPro_status())|| "3".equals(bean.getPro_status())) {
			
			list.add(getProStatusTag(bean.getPro_status()));
		}
		/**　無料有無が条件にある場合 **/
		if ("1".equals(bean.getFree_price())) {
			
			list.add(getFreePriceTag(bean.getFree_price()));
		}	
		/**　検索語が条件にある場合 **/
		if (!Util.isEmpty(bean.getSearch())){
			getSearchWhereAll(list, bean);
		}
		if (("0".equals(bean.getRegist_date())) || ("1".equals(bean.getRegist_date())) || ("2".equals(bean.getRegist_date()))) {
			list.add(getRegistDateTag(bean.getRegist_date()));
		}		
		/**　自分が書いた情報のみ見る場合 
		 * 　修正箇所（自分が書いた情報を見る場合）
		 **/
		if(!Util.isEmpty(bean.getUser_id())){
			
			if ("1".equals(bean.getUserFlag())) {
				list.add(" buysell_info.deleteflg IN (0, 2, 3)");
			} else {
				list.add(" buysell_info.deleteflg = 0");
			}
			list.add(getUser_id_Tag(bean.getUser_id()));
		} else {
			if ("on".equals(bean.getSold_out())) {
				list.add(" buysell_info.deleteflg = 2");
			} else {
				list.add(" buysell_info.deleteflg = 0");
			}
		}
				
		return getWhereSQL(list);

	}
	private String getUser_id_Tag(String user_id) {
		return "buysell_info.user_id = '" + user_id + "'";
	}
	public void getSearchWhereAll(List list, BuySellSearchBean bean) {
		List whereList = changeSearch(bean.getSearch());
		Iterator it = whereList.iterator();
		List list2 = new ArrayList();
		while (it.hasNext()) {
			getSearchWhere(list2, (String)it.next(), bean);
		}
		list.add(getWhereOrSql(list2));

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
			String temp = (String) it.next();
			sb.append(temp);
			sb.append(" ");

		}
		if (list.size() > 0) {
			sb.append(") ");
		}
		return sb.toString();

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
	private void getSearchWhere(List list, String search, BuySellSearchBean bean) {
		

		if ("selected".equals(bean.getSearch_all())) {
			StringBuffer sb = new StringBuffer();
			sb.append("(");
			sb.append(getTitleTag(search));
			sb.append(" or ");
			sb.append(getSearch_nameTag(search));
			sb.append(" or ");
			sb.append(getDetailTag(search));
			sb.append(" or ");
			sb.append(getSellPlaceTag(search));		
			sb.append(")");
			list.add(sb.toString());
		} else if ("selected".equals(bean.getSearch_title())) {
			list.add(getTitleTag(search));
		} else if ("selected".equals(bean.getSearch_name())) {
			list.add(getSearch_nameTag(search));			
		} else if ("selected".equals(bean.getSearch_detail())) {
			list.add(getDetailTag(search));
		}

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
	private String getSearch_nameTag(String search) {
		return "member.name like '%" + search + "%' and member.user_id = buysell_info.user_id ";
	}

	private String getDetailTag(String search) {
		return "buysell_info.detail_info like '%" + search + "%'";
	}
	
	private String getSellPlaceTag(String search) {
		return "buysell_info.sell_place like '%" + search + "%'";
	}

	private String getTitleTag(String title) {
		return "buysell_info.title like '%" + title + "%'";
	}
	private String getCate_code_1Tag(String cate_code_1) {
		return "buysell_info.cate_code_1 = '" + cate_code_1 + "'";
	}

	private String getCate_code_2Tag(String cate_code_2) {
		return "buysell_info.cate_code_2 = '" + cate_code_2 + "'";
	}
	private String getSendMethodTag(String send_method) {
		return " ( buysell_info.send_method = '" + send_method + "' or buysell_info.send_method = 0 ) ";
	}	
	private String getMemberSortTag(String member_sort) {
		return "buysell_info.member_sort = '" + member_sort + "'";
	}		
	private String getProStatusTag(String pro_status) {
		return "buysell_info.pro_status = '" + pro_status + "'";
	}	
	private String getFreePriceTag(String free_price) {
		return "buysell_info.free_price = '" + free_price + "'";
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

		if (list.size() > 0) {
			sb.append(" where ");
		}
		boolean isNotFirst = false;
		while (it.hasNext()) {
			if (isNotFirst) {
				sb.append(" and ");
			}
			isNotFirst = true;
			sb.append((String) it.next());
			sb.append(" ");

		}
		return sb.toString();

	}

	public ArrayList<BuySellBean> getBuySellList(int start, int num, BuySellSearchBean buySellSearchBean)
			throws SysException {
		
		Connection con = null;
		LogPreparedStatement pstmt = null;
		ResultSet rs = null;

		ArrayList<BuySellBean> list = new ArrayList<BuySellBean>();
		try {

			con = DBConnectionMgr.getInstance().getConnection();
			StringBuffer sb = new StringBuffer();
			sb.append("select * from buysell_info, member ");
			sb.append(getWhereList(buySellSearchBean, false));
			sb.append(" order by buysell_info.update_date desc limit ?,? ");

			pstmt = new LogPreparedStatement(con, sb.toString());
			pstmt.setInt(1, start - 1);
			pstmt.setInt(2, num);
			KankokujinLogger.getInstance().debug("MemberFindInfoHandler.getBuySellList" + pstmt.getQueryString());
			rs = pstmt.executeQuery();

			while (rs.next()) {

				BuySellBean bean = new BuySellBean();

				bean.setId(rs.getString("id"));
				bean.setUser_id(Util.changeNullStr(rs.getString("user_id")));
				bean.setUser_name(Util.cutLongName(5, rs.getString("member.name")));
				if("2".equals(rs.getString("deleteflg"))){
					bean.setTitle("<img src='jsp/images/common/img_soldout.gif'> " + rs.getString("title"));
				} else {
					bean.setTitle(rs.getString("title"));
				}
				if(!"1".equals(Util.changeNullStr(rs.getString("free_price"))) && !"0".equals(rs.getString("price"))){
					bean.setPrice(rs.getString("price"));
					bean.setPrice_unit(Util.changeNullStr(rs.getString("price_unit")));
				}
				bean.setFree_price(Util.changeNullStr(rs.getString("free_price")));
				bean.setSell_place(rs.getString("sell_place"));
				bean.setSend_method(Util.changeNullStr(rs.getString("send_method")));
				bean.setPro_status(Util.changeNullStr(rs.getString("pro_status")));
				bean.setMember_sort(Util.changeNullStr(rs.getString("member_sort")));
				bean.setTel_no1_1(Util.changeNullStr(rs.getString("tel_no1_1")));
				bean.setTel_no1_2(Util.changeNullStr(rs.getString("tel_no1_2")));
				bean.setTel_no1_3(Util.changeNullStr(rs.getString("tel_no1_3")));
				bean.setTel_no2_1(Util.changeNullStr(rs.getString("tel_no2_1")));
				bean.setTel_no2_2(Util.changeNullStr(rs.getString("tel_no2_2")));
				bean.setTel_no2_3(Util.changeNullStr(rs.getString("tel_no2_3")));
				bean.setPhoto_name1(Util.changeNullStr(rs.getString("photo_name1")));
				bean.setPhoto_name2(Util.changeNullStr(rs.getString("photo_name2")));
				bean.setPhoto_name3(Util.changeNullStr(rs.getString("photo_name3")));
				bean.setPhoto_name4(Util.changeNullStr(rs.getString("photo_name4")));
				bean.setPhoto_name5(Util.changeNullStr(rs.getString("photo_name5")));

				bean.setCate_code_1(Util.changeNullStr(rs.getString("cate_code_1")));
				bean.setCate_code_2(Util.changeNullStr(rs.getString("cate_code_2")));
				bean.setRead_count(Util.changeNullStr(rs.getString("read_count")));
				bean.setDetail_info(rs.getString("detail_info"));
				bean.setUpdate_date(rs.getTimestamp("update_date"));
				list.add(bean);

			}

		} catch (SQLException e) {
			throw new SysException("SYE0038", e);

		} catch (Exception e) {
			throw new SysException("SYE0038", e);

		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					throw new SysException("SYE0037", e);
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					throw new SysException("SYE0037" + e);
				}
			}
			if (con != null) {
				DBConnectionMgr.getInstance().freeConnection(con);
			}
		}

		return list;

	}
	
	public ArrayList<BuySellBean> getBuySellListTotal(
			Connection con, 
			PageBean pageBean,
			BuySellSearchBean buySellSearchBean)
		throws SysException {

		LogPreparedStatement pstmt = null;
		ResultSet rs = null;
		//maxCount
		int maxCount = 0;
		
		ArrayList<BuySellBean> list = new ArrayList<BuySellBean>();
		try {
			String countGetQuery = getCountGetQuery(buySellSearchBean);
			String listGetQuery = getListGetQuery(buySellSearchBean);
			
			//画面に表示する総データ数を取得
			pstmt = new LogPreparedStatement(con, countGetQuery);
			rs = pstmt.executeQuery();
			KankokujinLogger.getInstance().debug("MemberFindInfoHandler.getBuySellListTotal.sql1=" + pstmt.getQueryString());
			if (rs.next()) {
				maxCount = rs.getInt(1);
			}
			
			//ページ処理
			PageUtil.getInstance().nextPage(pageBean, maxCount);
			pstmt = new LogPreparedStatement(con, listGetQuery);
			pstmt.setInt(1, pageBean.getStartCount() - 1);
			pstmt.setInt(2, pageBean.getPageSize());
			KankokujinLogger.getInstance().debug("MemberFindInfoHandler.getBuySellListTotal.sql2=" + pstmt.getQueryString());
			rs = pstmt.executeQuery();
		
			while (rs.next()) {
		
				BuySellBean bean = new BuySellBean();
		
				bean.setId(rs.getString("id"));
				bean.setUser_id(Util.changeNullStr(rs.getString("user_id")));
				bean.setUser_name(Util.cutLongName(7, rs.getString("member.name")));
				if("2".equals(rs.getString("deleteflg"))){
					bean.setTitle("<img src='jsp/images/common/img_soldout.gif'> " + rs.getString("title"));
				} else {
					bean.setTitle(rs.getString("title"));
				}
				if(!"1".equals(Util.changeNullStr(rs.getString("free_price"))) && !"0".equals(rs.getString("price"))){
					bean.setPrice(rs.getString("price"));
					bean.setPrice_unit(Util.changeNullStr(rs.getString("price_unit")));
				}
				bean.setFree_price(Util.changeNullStr(rs.getString("free_price")));
				bean.setSell_place(rs.getString("sell_place"));
				bean.setSend_method(Util.changeNullStr(rs.getString("send_method")));
				bean.setPro_status(Util.changeNullStr(rs.getString("pro_status")));
				bean.setMember_sort(Util.changeNullStr(rs.getString("member_sort")));
				bean.setTel_no1_1(Util.changeNullStr(rs.getString("tel_no1_1")));
				bean.setTel_no1_2(Util.changeNullStr(rs.getString("tel_no1_2")));
				bean.setTel_no1_3(Util.changeNullStr(rs.getString("tel_no1_3")));
				bean.setTel_no2_1(Util.changeNullStr(rs.getString("tel_no2_1")));
				bean.setTel_no2_2(Util.changeNullStr(rs.getString("tel_no2_2")));
				bean.setTel_no2_3(Util.changeNullStr(rs.getString("tel_no2_3")));
				bean.setPhoto_name1(Util.changeNullStr(rs.getString("photo_name1")));
				bean.setPhoto_name2(Util.changeNullStr(rs.getString("photo_name2")));
				bean.setPhoto_name3(Util.changeNullStr(rs.getString("photo_name3")));
				bean.setPhoto_name4(Util.changeNullStr(rs.getString("photo_name4")));
				bean.setPhoto_name5(Util.changeNullStr(rs.getString("photo_name5")));
		
				bean.setEmail(rs.getString("email"));
				
				bean.setCate_code_1(Util.changeNullStr(rs.getString("cate_code_1")));
				bean.setCate_code_2(Util.changeNullStr(rs.getString("cate_code_2")));
				bean.setRead_count(Util.changeNullStr(rs.getString("read_count")));
				bean.setDetail_info(rs.getString("detail_info"));
				bean.setUpdate_date(rs.getTimestamp("update_date"));
				list.add(bean);
			}
		
		} catch (SQLException e) {
			throw new SysException("SYE0038", e);
		
		} catch (Exception e) {
			throw new SysException("SYE0038", e);
		
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					throw new SysException("SYE0037", e);
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					throw new SysException("SYE0037" + e);
				}
			}
		}
		return list;
	}
	
	/**
	 * 
	 * @param con
	 * @param tablename
	 * @throws SysException
	 */
	public Map getCategory2Count(Connection con, BuySellSearchBean buySellSearchBean) throws SysException{

		if (Util.isEmpty(buySellSearchBean.getCate_code_1())) {
			return null;
		}
		
		List resultList = null;
		LogPreparedStatement pstmt = null;
		ResultSet rs = null;
		StringBuffer sql = new StringBuffer();  
		sql.append("select count(*) as count,cate_code_2 as cate_code from buysell_info, member ");
		sql.append(getWhereList(buySellSearchBean, true));
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
	
	/**
	 * @param buySellSearchBean
	 * @return Countを取得するSQL
	 */
	private String getListGetQuery(BuySellSearchBean buySellSearchBean) {
		
		StringBuffer sb = new StringBuffer();
		sb.append("select * from buysell_info, member ");
		sb.append(getWhereList(buySellSearchBean, false));
		sb.append(" order by buysell_info.update_date desc limit ?,? ");
		return sb.toString();
	}
	
	/**
	 * @param buySellSearchBean
	 * @return リストを取得するSQL
	 */
	private String getCountGetQuery(BuySellSearchBean buySellSearchBean) {
		
		StringBuffer sb = new StringBuffer();
		sb.append("select count(*) from buysell_info, member ");
		sb.append(getWhereList(buySellSearchBean, false));
		
		return sb.toString();
	}
}