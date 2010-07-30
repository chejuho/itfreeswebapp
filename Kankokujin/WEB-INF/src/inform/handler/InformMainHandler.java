package inform.handler;

import inform.bean.InformBean;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.database.DBConnectionMgr;
import common.database.LogPreparedStatement;
import common.exception.AppException;
import common.logger.KankokujinLogger;

public class InformMainHandler {
	
	private static InformMainHandler instance = null;
	
	public static InformMainHandler getInstance() {
		if (instance == null) {
			synchronized (InformMainHandler.class) {
				if (instance == null) {
					instance = new InformMainHandler();
				}
			}
		}

		return instance;
	}
	/**
	 * desc
	 * @param request,interpretBean,interpretSortBean,start,num 
	 * @return list 
	 */
	public List<InformBean> getInformBeanList(Connection con) throws AppException {
		
		KankokujinLogger.getInstance().debug("InformListHandler.getInformBeanList.start");
		LogPreparedStatement pstmt = null;
		ResultSet rs = null;
		List<InformBean> list = new ArrayList<InformBean>();
		try {
		
			String listGetQuery = "select * from inform order by regist_date desc limit 0,2";
			
			
			//画面に表示する総データリストを取得
			pstmt = new LogPreparedStatement(con, listGetQuery);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				
				InformBean bean = new InformBean();
				
				bean.setId(rs.getString("id"));
				bean.setTitle(rs.getString("title"));
				bean.setRegist_date(rs.getTimestamp("regist_date"));
				list.add(bean);
			}

		} catch (SQLException e) {
			throw new AppException("InformListHandler.getInformBeanList.SQLException", e);

		} catch (Exception e) {
			throw new AppException("InformListHandler.getInformBeanList.Exception", e);

		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					throw new AppException("SYE0036", e);
				}
			}	
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException e) {
					throw new AppException("InformListHandler.getInformBeanList.SQLException", e);
				}
		}

		return list;

	}	

}
