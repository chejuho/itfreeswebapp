package hudousan.handler;

import housesell.bean.HouseBean;
import housesell.bean.HouseSearchBean;
import housesell.bean.HouseSellSortBean;
import hudousan.bean.HudousanBean;
import hudousan.common.HudousanSQLUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import common.bean.PageBean;
import common.database.DBConnectionMgr;
import common.database.LogPreparedStatement;
import common.exception.AppException;
import common.logger.KankokujinLogger;
import common.page.PageUtil;
import common.util.Util;

public class HudousanMainHandler {
	private static HudousanMainHandler instance = null;

	private HudousanMainHandler() {

	}

	public static HudousanMainHandler getInstance() {
		if (instance == null) {
			synchronized (HudousanMainHandler.class) {
				if (instance == null) {
					instance = new HudousanMainHandler();
				}
			}
		}

		return instance;
	}

	/**
	 * ƒƒCƒ“‰æ–Ê‚ÌV‹Kî•ñ‚ğæ“¾‚·‚é
	 * 
	 * @param bean
	 *            count‚ğ‹y‚Ô
	 * @return count columnIndex‚ÌÅ‰‚Ì—ñ‚ğint‚Æ‚µ‚Äæ“¾
	 */
	public List getMainInfo(Connection con, String sign) throws AppException {
		LogPreparedStatement pstmt = null;
		ResultSet rs = null;
		List<HudousanBean> resultList = new ArrayList<HudousanBean>();
		
		try {
			StringBuffer sb = new StringBuffer();
			sb.append("select * FROM  hudousan AS M ");
			sb.append("INNER JOIN member AS A ON M.user_id=A.user_id ");
			sb.append("INNER JOIN t_area AS B ON M.area_code_1=B.area_code_1 AND M.area_code_2=B.area_code_2 ");
			sb.append("INNER JOIN t_train AS C ON M.line_code=C.line_code AND M.station_code=C.station_code ");
			sb.append("where M.lease_sign = ? ");
			sb.append("order by M.update_date desc ");
			sb.append(" limit 0,4 ");
			pstmt = new LogPreparedStatement(con, sb.toString());
			pstmt.setString(1, sign);
			KankokujinLogger.getInstance().debug("HudousanMainHandler.getMainInfo" + pstmt.getQueryString());
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				HudousanBean bean = new HudousanBean();
				HudousanSQLUtil.resultSetToHudousanBean(bean, rs);
				resultList.add(bean);
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
					throw new AppException("SQLException" + e);
				}
			}
			if (pstmt != null) {

				try {
					pstmt.close();
				} catch (SQLException e) {
					throw new AppException("SQLException" + e);
				}
			}
			if (con != null) {
				DBConnectionMgr.getInstance().freeConnection(con);
			}
		}

		return resultList;

	}



}