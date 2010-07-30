package job.handler;

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

import job.bean.JobBean;
import job.bean.JobSearchBean;

import common.bean.PageBean;
import common.database.DBConnectionMgr;
import common.database.LogPreparedStatement;
import common.exception.SysException;
import common.logger.KankokujinLogger;
import common.page.PageUtil;
import common.util.Util;

public class JobSearchHandler {
	private static JobSearchHandler instance = null;
	private JobSearchHandler(){
		
	}
    public static JobSearchHandler getInstance() {
        if (instance == null) {
            synchronized (JobSearchHandler.class) {
                if (instance == null) {
                    instance = new JobSearchHandler();
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
	public int getInfoCount(JobSearchBean jobSearchBean)
			throws SysException {
		Connection con = null;
		LogPreparedStatement pstmt = null;
		ResultSet rs = null;
		int count = 0;

		try {
			con = DBConnectionMgr.getInstance().getConnection();
			StringBuffer sb = new StringBuffer();
			sb.append("select count(*) from job_info, t_job_category, member ");
			sb.append(getWhereList(jobSearchBean, false, false));
			pstmt = new LogPreparedStatement(con, sb.toString());
			rs = pstmt.executeQuery();
			KankokujinLogger.getInstance().debug("JobSearchHandler.getInfoCount" + pstmt.getQueryString());
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
	public String getWhereList(JobSearchBean bean, boolean category1Sign, boolean category2Sign) {
		ArrayList<String> list = new ArrayList<String>();
		list.add(" job_info.user_id=member.user_id and job_info.cate_code_1=t_job_category.cate_code_1 and job_info.cate_code_2=t_job_category.cate_code_2 ");
		list.add(" job_info.deleteflg = 0");
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
		if (!Util.isEmpty(bean.getSex())
				&& !"0".equals(bean.getSex())) {
			list.add(getSexTag(bean.getSex()));
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
		return "job_info.user_id = '" + user_id + "'";
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
	public void getSearchWhereAll(List list, JobSearchBean bean) {
		List whereList = changeSearch(bean.getSearch());
		Iterator it = whereList.iterator();
		List list2 = new ArrayList();
		while (it.hasNext()) {
			getSearchWhere(list2, (String)it.next(), bean);
		}
		list.add(getWhereOrSql(list2));

	}

	private void getSearchWhere(List list, String search, JobSearchBean bean) {
		String sql = "";

		if ("selected".equals(bean.getSearch_all())) {
			sql = "(" + getComNameTag(search) + " or " + getTitleTag(search) + " or "
					+ getDetailTag(search) + ")";
			list.add(sql);
		} else if ("selected".equals(bean.getSearch_com_name())) {
			sql = getComNameTag(search);
			list.add(sql);
		} else if ("selected".equals(bean.getSearch_title())) {
			sql = getTitleTag(search);
			list.add(sql);			
		} else if ("selected".equals(bean.getSearch_detail())) {
			sql = getDetailTag(search);
			list.add(sql);
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
		return "job_info.area_code_1 = " + area_code_1;
	}

	private String getCate_code_1Tag(String cate_code_1) {
		return "job_info.cate_code_1 = '" + cate_code_1 + "'";
	}
	private String getSexTag(String sex) {
		return "( job_info.sex = '" + sex + "' or  job_info.sex = 0 ) ";
	}	

	private String getCate_code_2Tag(String cate_code_2) {
		return "job_info.cate_code_2 = '" + cate_code_2 + "'";
	}

	/**
	 * 条件節のハッシュマップ情報からwhere節を作る
	 * 
	 * @param map
	 * @return
	 */
	private String getAreaCode2Tag(String area_code_2) {
		return "area_code_2 = " + area_code_2;
	}

	/**
	 * 条件節のハッシュマップ情報からwhere節を作る
	 * 
	 * @param map
	 * @return
	 */
	private String getLineCodeTag(String line_code) {
		return "job_info.line_code = " + line_code;
	}

	/**
	 * 条件節のハッシュマップ情報からwhere節を作る
	 * 
	 * @param map
	 * @return
	 */
	private String getStationCodeTag(String station_code) {

		return "job_info.station_code = " + station_code;
	}

	/**
	 * 条件節のハッシュマップ情報からwhere節を作る
	 * 
	 * @param map
	 * @return
	 */
	private String getComNameTag(String search) {

		return "job_info.company_name_k like '%" + search + "%'";
	}
	private String getTitleTag(String search) {

		return "job_info.title like '%" + search + "%'";
	}	

	private String getDetailTag(String search) {

		return "job_info.detail_info like '%" + search + "%'";
	}

	public String getDetailTag(List searchList) {
		StringBuffer sb = new StringBuffer();
		if (searchList != null && searchList.size() == 1) {
			sb.append("job_info.detail_info like '%" + searchList.get(0) + "%'");

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
				sb.append("job_info.detail_info like '%" + it.next() + "%'");

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
	public ArrayList<JobBean> getSearchJobList(int start,
			int num, JobSearchBean jobSearchBean) throws SysException {

		Connection con = null;
		LogPreparedStatement pstmt = null;
		ResultSet rs = null;

		ArrayList<JobBean> list = new ArrayList<JobBean>();
		try {

			con = DBConnectionMgr.getInstance().getConnection();
			StringBuffer sb = new StringBuffer();
			sb.append("select * from job_info, t_job_category, member ");
			sb.append(getWhereList(jobSearchBean, false, false));
			sb.append("order by update_date desc limit ?,? ");

			pstmt = new LogPreparedStatement(con, sb.toString());
			pstmt.setInt(1, start - 1);
			pstmt.setInt(2, num);
			rs = pstmt.executeQuery();
			KankokujinLogger.getInstance().debug("JobSearchHandler.getSearchJobList" + pstmt.getQueryString());
			while (rs.next()) {

				JobBean bean = new JobBean();
				bean.setId(rs.getString("id"));
				bean.setUser_id(rs.getString("user_id"));
				bean.setUser_name(Util.cutLongName(5, rs.getString("name")));
				bean.setCompany_name_k(Util.changeNullStr(rs.getString("company_name_k")));
				bean.setTel_no1_1(Util.changeNullStr(rs.getString("tel_no1_1")));
				bean.setTel_no1_2(Util.changeNullStr(rs.getString("tel_no1_2")));
				bean.setTel_no1_3(Util.changeNullStr(rs.getString("tel_no1_3")));
				bean.setTel_no2_1(Util.changeNullStr(rs.getString("tel_no2_1")));
				bean.setTel_no2_2(Util.changeNullStr(rs.getString("tel_no2_2")));
				bean.setTel_no2_3(Util.changeNullStr(rs.getString("tel_no2_3")));
				bean.setFax_no_1(Util.changeNullStr(rs.getString("fax_no_1")));
				bean.setFax_no_2(Util.changeNullStr(rs.getString("fax_no_2")));
				bean.setFax_no_3(Util.changeNullStr(rs.getString("fax_no_3")));
				bean.setEmail(Util.changeNullStr(rs.getString("email")));
				bean.setUrl(Util.changeNullStr(rs.getString("url")));
				bean.setPhoto_name1(Util.changeNullStr(rs.getString("photo_name1")));
				bean.setArea_code_1(Util.changeNullStr(rs.getString("area_code_1")));
				bean.setArea_code_2(Util.changeNullStr(rs.getString("area_code_2")));
				bean.setCate_code_1(Util.changeNullStr(rs.getString("cate_code_1")));
				bean.setCate_name_2(Util.changeNullStr(rs.getString("category_name_2")));
				bean.setCate_code_2(Util.changeNullStr(rs.getString("cate_code_2")));
				bean.setLine_code(Util.changeNullStr(rs.getString("line_code")));
				bean.setStation_code(Util.changeNullStr(rs.getString("station_code")));
				bean.setArea_fast(Util.changeNullStr(rs.getString("area_fast")));
				bean.setTitle(Util.changeNullStr(rs.getString("title")));
				bean.setPay(Util.changeNullStr(rs.getString("pay")));
				bean.setWork_time(Util.changeNullStr(rs.getString("work_time")));	
				bean.setSex(Util.changeNullStr(rs.getString("sex")));	
				bean.setDetail_info(Util.changeNullStr(rs.getString("detail_info")));
				bean.setUpdate_date(rs.getTimestamp("update_date"));
				bean.setAppeal_point(Util.changeNullStr(rs.getString("appeal_point")));
				bean.setRead_count(Util.changeNullStr(rs.getString("read_count")));
				list.add(bean);
			}

		} catch (SQLException e) {
			throw new SysException("SYE0033", e);

		} catch (Exception e) {
			throw new SysException("SYE0033", e);

		} finally {
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
	public ArrayList<JobBean> getSearchJobListTotal(
			Connection con,
			PageBean pageBean,
			JobSearchBean jobSearchBean) throws SysException {

		LogPreparedStatement pstmt = null;
		ResultSet rs = null;
		
		//maxCount
		int maxCount = 0;

		ArrayList<JobBean> list = new ArrayList<JobBean>();
		try {

			con = DBConnectionMgr.getInstance().getConnection();
			
			String countGetQuery = getCountGetQuery(jobSearchBean);
			String listGetQuery = getListGetQuery(jobSearchBean);
			
			//画面に表示する総データ数を取得
			pstmt = new LogPreparedStatement(con, countGetQuery);
			rs = pstmt.executeQuery();
			KankokujinLogger.getInstance().debug("JobSearchHandler.getSearchJobListTotal1" + pstmt.getQueryString());
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
			KankokujinLogger.getInstance().debug("JobSearchHandler.getSearchJobListTotal1" + pstmt.getQueryString());
			while (rs.next()) {

				JobBean bean = new JobBean();
				bean.setId(rs.getString("id"));
				bean.setUser_id(rs.getString("user_id"));
				bean.setUser_name(Util.cutLongName(5, rs.getString("name")));
				bean.setCompany_name_k(Util.changeNullStr(rs.getString("company_name_k")));
				bean.setTel_no1_1(Util.changeNullStr(rs.getString("tel_no1_1")));
				bean.setTel_no1_2(Util.changeNullStr(rs.getString("tel_no1_2")));
				bean.setTel_no1_3(Util.changeNullStr(rs.getString("tel_no1_3")));
				bean.setTel_no2_1(Util.changeNullStr(rs.getString("tel_no2_1")));
				bean.setTel_no2_2(Util.changeNullStr(rs.getString("tel_no2_2")));
				bean.setTel_no2_3(Util.changeNullStr(rs.getString("tel_no2_3")));
				bean.setFax_no_1(Util.changeNullStr(rs.getString("fax_no_1")));
				bean.setFax_no_2(Util.changeNullStr(rs.getString("fax_no_2")));
				bean.setFax_no_3(Util.changeNullStr(rs.getString("fax_no_3")));
				bean.setEmail(Util.changeNullStr(rs.getString("email")));
				bean.setUrl(Util.changeNullStr(rs.getString("url")));
				bean.setPhoto_name1(Util.changeNullStr(rs.getString("photo_name1")));
				bean.setArea_code_1(Util.changeNullStr(rs.getString("area_code_1")));
				bean.setArea_code_2(Util.changeNullStr(rs.getString("area_code_2")));
				bean.setCate_code_1(Util.changeNullStr(rs.getString("cate_code_1")));
				bean.setCate_name_2(Util.changeNullStr(rs.getString("category_name_2")));
				bean.setCate_code_2(Util.changeNullStr(rs.getString("cate_code_2")));
				bean.setLine_code(Util.changeNullStr(rs.getString("line_code")));
				bean.setStation_code(Util.changeNullStr(rs.getString("station_code")));
				bean.setArea_fast(Util.changeNullStr(rs.getString("area_fast")));
				bean.setTitle(Util.changeNullStr(rs.getString("title")));
				bean.setPay(Util.changeNullStr(rs.getString("pay")));
				bean.setWork_time(Util.changeNullStr(rs.getString("work_time")));	
				bean.setSex(Util.changeNullStr(rs.getString("sex")));	
				bean.setDetail_info(Util.changeNullStr(rs.getString("detail_info")));
				bean.setUpdate_date(rs.getTimestamp("update_date"));
				bean.setAppeal_point(Util.changeNullStr(rs.getString("appeal_point")));
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
	private String getCountGetQuery(JobSearchBean jobSearchBean) {
		
		StringBuffer sb = new StringBuffer();
		sb.append("select count(*) from job_info, t_job_category, member ");
		sb.append(getWhereList(jobSearchBean, false, false));
		
		return sb.toString();
	}
	/**
	 * @param gourmetSearchBean
	 * @return リストを取得するSQL
	 */
	private String getListGetQuery(JobSearchBean jobSearchBean) {
		
		StringBuffer sb = new StringBuffer();
		sb.append("select * from job_info, t_job_category, member ");
		sb.append(getWhereList(jobSearchBean, false, false));
		sb.append("order by update_date desc limit ?,? ");

		return sb.toString();
	}
	
	/**
	 * 
	 * @param con
	 * @param tablename
	 * @throws SysException
	 */
	public Map getCategory1Count(Connection con, JobSearchBean jobSearchBean) throws SysException{

		List resultList = null;
		LogPreparedStatement pstmt = null;
		ResultSet rs = null;
		StringBuffer sql = new StringBuffer();  
		sql.append("select count(*) as count,job_info.cate_code_1 as cate_code from job_info, t_job_category, member ");			
		sql.append(getWhereList(jobSearchBean, true, false));
		sql.append("  group by job_info.cate_code_1 ");
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
	public Map getCategory2Count(Connection con, JobSearchBean jobSearchBean) throws SysException{

		if (Util.isEmpty(jobSearchBean.getCate_code_1())) {
			return null;
		}
		
		List resultList = null;
		LogPreparedStatement pstmt = null;
		ResultSet rs = null;
		StringBuffer sql = new StringBuffer();  
		sql.append("select count(*) as count,job_info.cate_code_2 as cate_code from job_info, t_job_category, member ");
		sql.append(getWhereList(jobSearchBean, true, true));
		sql.append("  group by job_info.cate_code_2 ");
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