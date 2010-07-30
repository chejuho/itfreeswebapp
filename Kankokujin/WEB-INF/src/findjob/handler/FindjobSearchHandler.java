package findjob.handler;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

import common.bean.PageBean;
import common.database.DBConnectionMgr;
import common.database.LogPreparedStatement;
import common.exception.SysException;
import common.logger.KankokujinLogger;
import common.page.PageUtil;
import common.util.Util;

import findjob.bean.FindjobBean;
import findjob.bean.FindjobSearchBean;

public class FindjobSearchHandler {
	private static FindjobSearchHandler instance = null;
	private FindjobSearchHandler(){
		
	}
    public static FindjobSearchHandler getInstance() {
        if (instance == null) {
            synchronized (FindjobSearchHandler.class) {
                if (instance == null) {
                    instance = new FindjobSearchHandler();
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
	public int getInfoCount(FindjobSearchBean findjobSearchBean)
			throws SysException {
		Connection con = null;
		LogPreparedStatement pstmt = null;
		ResultSet rs = null;
		int count = 0;
		try {
			con = DBConnectionMgr.getInstance().getConnection();
			StringBuffer sb = new StringBuffer();
			sb.append("select count(*) from findjob_info, member where ");
			sb.append(" member.user_id =findjob_info.user_id and ");
			sb.append(" findjob_info.deleteflg = 0 ");
			sb.append(getWhereList(findjobSearchBean));
			pstmt = new LogPreparedStatement(con, sb.toString());
			rs = pstmt.executeQuery();
			KankokujinLogger.getInstance().debug("FindjobSearchHandler.getInfoCount" + pstmt.getQueryString());			
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
	public String getWhereList(FindjobSearchBean bean) {
		ArrayList<String> list = new ArrayList<String>();
		if (!"".equals(bean.getArea_code_1())
				&& !"00".equals(bean.getArea_code_1())) {
			list.add(getAreaCode1Tag(bean.getArea_code_1()));

			if (!"".equals(bean.getArea_code_2())
					&& !"00".equals(bean.getArea_code_2())) {
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

		if (!Util.isEmpty(bean.getCate_code_1())
				&& !"0000".equals(bean.getCate_code_1().substring(4, 6))) {
			list.add(getCate_code_1Tag(bean.getCate_code_1()));

			String cate_code_2 = bean.getCate_code_2();
			if (!Util.isEmpty(cate_code_2) && cate_code_2.length() == 6) {
				if (!"0000".equals(cate_code_2.substring(4, 6))) {
					list.add(getCate_code_2Tag(cate_code_2));
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
	private String getRegistDateTag(String regist_date) {
		StringBuffer sb = new StringBuffer();
		if ("0".equals(regist_date)) {
			sb.append("findjob_info.update_date > DATE_SUB(CURDATE(),INTERVAL 1 DAY)");
		} else if ("1".equals(regist_date)) {
			sb.append("findjob_info.update_date > DATE_SUB(CURDATE(),INTERVAL 14 DAY)");
		} else if ("2".equals(regist_date)) {
			sb.append("findjob_info.update_date > DATE_SUB(CURDATE(),INTERVAL 30 DAY)");
		}
		return sb.toString();

	}
	public void getSearchWhereAll(List list, FindjobSearchBean bean) {
		List whereList = changeSearch(bean.getSearch());
		Iterator it = whereList.iterator();
		List list2 = new ArrayList();
		while (it.hasNext()) {
			getSearchWhere(list2, (String)it.next(), bean);
		}
		list.add(getWhereOrSql(list2));

	}

	private void getSearchWhere(List list, String search, FindjobSearchBean bean) {

		if ("selected".equals(bean.getSearch_all())) {
			StringBuffer sb = new StringBuffer();
			sb.append("(");
			sb.append(getSearch_titleTag(search));
			sb.append(" or ");
			sb.append(getSearch_nameTag(search));
			sb.append(" or ");
			sb.append(getDetailTag(search));
			sb.append(")");
			list.add(sb.toString());
		} else if ("selected".equals(bean.getSearch_title())) {
			list.add(getSearch_titleTag(search));
		} else if ("selected".equals(bean.getSearch_com_name())) {
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
			String temp = (String) it.next();
			sb.append(temp);
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
		return "findjob_info.area_code_1 = " + area_code_1;
	}

	private String getCate_code_1Tag(String cate_code_1) {
		return "findjob_info.cate_code_1 = '" + cate_code_1 + "'";
	}

	private String getCate_code_2Tag(String cate_code_2) {
		return "findjob_info.cate_code_2 = '" + cate_code_2 + "'";
	}
	
	private String getUser_id_Tag(String user_id) {
		return "findjob_info.user_id = '" + user_id + "'";
	}

	/**
	 * 条件節のハッシュマップ情報からwhere節を作る
	 * 
	 * @param map
	 * @return
	 */
	private String getAreaCode2Tag(String area_code_2) {
		return "findjob_info.area_code_2 = " + area_code_2;
	}

	/**
	 * 条件節のハッシュマップ情報からwhere節を作る
	 * 
	 * @param map
	 * @return
	 */
	private String getLineCodeTag(String line_code) {
		return "findjob_info.line_code = " + line_code;
	}

	/**
	 * 条件節のハッシュマップ情報からwhere節を作る
	 * 
	 * @param map
	 * @return
	 */
	private String getStationCodeTag(String station_code) {
		return "findjob_info.station_code = " + station_code;
	}
	private String getSearch_titleTag(String search) {
		return "findjob_info.title like '%" + search + "%'";		
	}	
	private String getSearch_nameTag(String search) {
		return "member.name like '%" + search + "%' and member.user_id = findjob_info.user_id ";
	}
	private String getDetailTag(String search) {
		return "findjob_info.detail_info like '%" + search + "%'";
	}
	public String getDetailTag(List searchList) {
		StringBuffer sb = new StringBuffer();
		if (searchList != null && searchList.size() == 1) {
			sb.append("findjob_info.detail_info like '%" + searchList.get(0) + "%'");

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
				sb.append("findjob_info.detail_info like '%" + it.next() + "%'");

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
	public ArrayList getSearchFindjobList(int start,
			int num, FindjobSearchBean findjobSearchBean) throws SysException {
		Connection con = null;
		LogPreparedStatement pstmt = null;
		ResultSet rs = null;

		ArrayList list = new ArrayList();
		try {

			con = DBConnectionMgr.getInstance().getConnection();
			StringBuffer sb = new StringBuffer();
			sb.append("select * from findjob_info, member where ");
			sb.append(" member.user_id =findjob_info.user_id and ");
			sb.append(" findjob_info.deleteflg = 0 ");
			sb.append(getWhereList(findjobSearchBean));
			sb.append(" order by findjob_info.update_date desc limit ?,? ");
			pstmt = new LogPreparedStatement(con, sb.toString());
			pstmt.setInt(1, start - 1);
			pstmt.setInt(2, num);
			rs = pstmt.executeQuery();
			KankokujinLogger.getInstance().debug("FindjobSearchHandler.getSearchFindjobList" + pstmt.getQueryString());
			while (rs.next()) {

				FindjobBean bean = new FindjobBean();
				bean.setId(rs.getString("id"));
				bean.setUser_id(Util.changeNullStr(rs.getString("user_id")));
				bean.setUser_name(Util.cutLongName(5, rs.getString("name")));
				bean.setTitle(Util.changeNullStr(rs.getString("title")));
				bean.setTel_no1_1(Util.changeNullStr(rs.getString("tel_no1_1")));
				bean.setTel_no1_2(Util.changeNullStr(rs.getString("tel_no1_2")));
				bean.setTel_no1_3(Util.changeNullStr(rs.getString("tel_no1_3")));
				bean.setTel_no2_1(Util.changeNullStr(rs.getString("tel_no2_1")));
				bean.setTel_no2_2(Util.changeNullStr(rs.getString("tel_no2_2")));
				bean.setTel_no2_3(Util.changeNullStr(rs.getString("tel_no2_3")));
				bean.setEmail(Util.changeNullStr(rs.getString("email")));
				bean.setWork_sort(Util.changeNullStr(rs.getString("work_sort")));
				bean.setBirthday(Util.changeNullStr(rs.getString("birthday")));
				bean.setSex(Util.changeNullStr(rs.getString("sex")));
				bean.setAppeal_point(Util.changeNullStr(rs.getString("appeal_point")));
				bean.setDetail_info(Util.changeNullStr(rs.getString("detail_info")));
				bean.setUpdate_date(rs.getTimestamp("update_date"));
				bean.setRead_count(Util.changeNullStr(rs.getString("read_count")));
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
					throw new SysException("SYE0021", e);
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
	public ArrayList getSearchFindjobListTotal(PageBean pageBean, FindjobSearchBean findjobSearchBean) throws SysException {
		Connection con = null;
		LogPreparedStatement pstmt = null;
		ResultSet rs = null;
		
		//maxCount
		int maxCount = 0;

		ArrayList list = new ArrayList();
		try {

			con = DBConnectionMgr.getInstance().getConnection();
			String countGetQuery = getCountGetQuery(findjobSearchBean);
			String listGetQuery = getListGetQuery(findjobSearchBean);
			
			//画面に表示する総データ数を取得
			pstmt = new LogPreparedStatement(con, countGetQuery);
			rs = pstmt.executeQuery();
			KankokujinLogger.getInstance().debug("FindjobSearchHandler.getSearchFindjobListTotal.sql1= " + pstmt.getQueryString());
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
			KankokujinLogger.getInstance().debug("FindjobSearchHandler.getSearchFindjobListTotal.sql2= " + pstmt.getQueryString());
			while (rs.next()) {

				FindjobBean bean = new FindjobBean();
				bean.setId(rs.getString("id"));
				bean.setUser_id(Util.changeNullStr(rs.getString("user_id")));
				bean.setUser_name(Util.cutLongName(5, rs.getString("name")));
				bean.setTitle(Util.changeNullStr(rs.getString("title")));
				bean.setTel_no1_1(Util.changeNullStr(rs.getString("tel_no1_1")));
				bean.setTel_no1_2(Util.changeNullStr(rs.getString("tel_no1_2")));
				bean.setTel_no1_3(Util.changeNullStr(rs.getString("tel_no1_3")));
				bean.setTel_no2_1(Util.changeNullStr(rs.getString("tel_no2_1")));
				bean.setTel_no2_2(Util.changeNullStr(rs.getString("tel_no2_2")));
				bean.setTel_no2_3(Util.changeNullStr(rs.getString("tel_no2_3")));
				bean.setEmail(Util.changeNullStr(rs.getString("email")));
				bean.setWork_sort(Util.changeNullStr(rs.getString("work_sort")));
				bean.setBirthday(Util.changeNullStr(rs.getString("birthday")));
				bean.setSex(Util.changeNullStr(rs.getString("sex")));
				bean.setAppeal_point(Util.changeNullStr(rs.getString("appeal_point")));
				bean.setDetail_info(Util.changeNullStr(rs.getString("detail_info")));
				bean.setUpdate_date(rs.getTimestamp("update_date"));
				bean.setRead_count(Util.changeNullStr(rs.getString("read_count")));
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
					throw new SysException("SYE0021", e);
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
	 * @param gourmetSearchBean
	 * @return Countを取得するSQL
	 */
	private String getCountGetQuery(FindjobSearchBean findjobSearchBean) {
		
		StringBuffer sb = new StringBuffer();
		sb.append("select count(*) from findjob_info, member where ");
		sb.append(" member.user_id =findjob_info.user_id and ");
		sb.append(" findjob_info.deleteflg = 0 ");
		sb.append(getWhereList(findjobSearchBean));
		
		return sb.toString();
	}
	/**
	 * @param gourmetSearchBean
	 * @return リストを取得するSQL
	 */
	private String getListGetQuery(FindjobSearchBean findjobSearchBean) {
		
		StringBuffer sb = new StringBuffer();
		sb.append("select * from findjob_info, member where ");
		sb.append(" member.user_id =findjob_info.user_id and ");
		sb.append(" findjob_info.deleteflg = 0 ");
		sb.append(getWhereList(findjobSearchBean));
		sb.append(" order by findjob_info.update_date desc limit ?,? ");

		return sb.toString();
	}
	
}