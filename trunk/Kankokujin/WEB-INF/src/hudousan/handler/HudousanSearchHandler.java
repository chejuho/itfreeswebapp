package hudousan.handler;

import hudousan.bean.HudousanBean;
import hudousan.bean.HudousanSearchBean;
import hudousan.bean.HudousanSortBean;
import hudousan.common.HudousanSQLUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import common.bean.PageBean;
import common.database.DBConnectionMgr;
import common.database.LogPreparedStatement;
import common.exception.AppException;
import common.logger.KankokujinLogger;
import common.page.PageUtil;

public class HudousanSearchHandler {
	private static HudousanSearchHandler instance = null;

	private HudousanSearchHandler() {

	}

	public static HudousanSearchHandler getInstance() {
		if (instance == null) {
			synchronized (HudousanSearchHandler.class) {
				if (instance == null) {
					instance = new HudousanSearchHandler();
				}
			}
		}

		return instance;
	}
	
	
	/**
	 * descとascの整列
	 * 
	 * @param request,houseBean,houseSellSortBean,start,num
	 * @return list 整列の値
	 */
	public ArrayList<HudousanBean> getHudousanBeanListTotal(
			PageBean pageBean, 
			HudousanSearchBean searchBean,
			HudousanSortBean sortBean, 
			String sign)
			throws AppException {
		
		Connection con = null;
		LogPreparedStatement pstmt = null;
		ResultSet rs = null;
		
		//maxCount
		int maxCount = 0;

		ArrayList<HudousanBean> list = new ArrayList<HudousanBean>();
		try {

			con = DBConnectionMgr.getInstance().getConnection();
			
			String countGetQuery = HudousanSQLUtil.getCountGetSearchQuery(searchBean, sign);
			String listGetQuery = HudousanSQLUtil.getListGetSearchQuery(searchBean, sortBean, sign);
			
			//画面に表示する総データ数を取得
			pstmt = new LogPreparedStatement(con, countGetQuery);
			rs = pstmt.executeQuery();
			KankokujinLogger.getInstance().debug("HouseSellListHandler.getHouseBeanListTotal1 sql= " + pstmt.getQueryString());
			System.out.println(pstmt.getQueryString());
			if (rs.next()) {
				maxCount = rs.getInt(1);
			}
			//ページ処理
			PageUtil.getInstance().nextPage(pageBean, maxCount);
			
			//画面に表示する総データリストを取得
			pstmt = new LogPreparedStatement(con, listGetQuery);
			KankokujinLogger.getInstance().debug("HouseSellListHandler.getHouseBeanListTotal2 sql=" + pstmt.getQueryString());
			pstmt.setInt(1, pageBean.getStartCount() - 1);
			pstmt.setInt(2, pageBean.getPageSize());
			
			System.out.println(pstmt.getQueryString());
			rs = pstmt.executeQuery();

			while (rs.next()) {
				HudousanBean bean = new HudousanBean();
				HudousanSQLUtil.resultSetToHudousanBean(bean, rs);
				list.add(bean);
			}

		} catch (SQLException e) {
			throw new AppException("SQLException" + e);

		} catch (Exception e) {
			throw new AppException("Exception" + e);

		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					throw new AppException("SQLException", e);
				}
			}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException e) {
					throw new AppException("SQLException" + e);
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
	 * @param request,houseBean,houseSellSortBean,start,num
	 * @return list 整列の値
	 */
	public ArrayList<HudousanBean> getHudousanBeanListSuggert(
			PageBean pageBean, 
			HudousanSortBean sortBean, 
			String sign)
			throws AppException {
		
		
		Connection con = null;
		LogPreparedStatement pstmt = null;
		ResultSet rs = null;
		
		//maxCount
		int maxCount = 0;

		ArrayList<HudousanBean> list = new ArrayList<HudousanBean>();
		try {

			con = DBConnectionMgr.getInstance().getConnection();
			
			String countGetQuery = HudousanSQLUtil.getCountGetSuggestQuery(sign);
			String listGetQuery = HudousanSQLUtil.getListGetSuggestQuery(sign, sortBean);
			
			//画面に表示する総データ数を取得
			pstmt = new LogPreparedStatement(con, countGetQuery);
			rs = pstmt.executeQuery();
			KankokujinLogger.getInstance().debug("HouseSellListHandler.getHouseBeanListTotal1 sql= " + pstmt.getQueryString());
			
			if (rs.next()) {
				maxCount = rs.getInt(1);
			}
			//ページ処理
			PageUtil.getInstance().nextPage(pageBean, maxCount);
			
			//画面に表示する総データリストを取得
			pstmt = new LogPreparedStatement(con, listGetQuery);
			KankokujinLogger.getInstance().debug("HouseSellListHandler.getHouseBeanListTotal2 sql=" + pstmt.getQueryString());
			pstmt.setInt(1, pageBean.getStartCount() - 1);
			pstmt.setInt(2, pageBean.getPageSize());
			rs = pstmt.executeQuery();

			while (rs.next()) {
				HudousanBean bean = new HudousanBean();
				HudousanSQLUtil.resultSetToHudousanBean(bean, rs);
				list.add(bean);
			}

		} catch (SQLException e) {
			throw new AppException("SQLException" + e);

		} catch (Exception e) {
			throw new AppException("Exception" + e);

		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					throw new AppException("SQLException", e);
				}
			}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException e) {
					throw new AppException("SQLException" + e);
				}
			if (con != null) {
				DBConnectionMgr.getInstance().freeConnection(con);
			}
		}

		return list;
	}
}