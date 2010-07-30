package inform.handler;
                       
import inform.bean.InformBean;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.bean.PageBean;
import common.database.DBConnectionMgr;
import common.database.LogPreparedStatement;
import common.exception.AppException;
import common.exception.SysException;
import common.logger.KankokujinLogger;
import common.page.PageUtil;

public class InformListHandler {
	
	/**
	 * desc
	 * @param request,interpretBean,interpretSortBean,start,num 
	 * @return list 
	 */
	public List<InformBean> getInformBeanList(PageBean pageBean) throws AppException {
		
		KankokujinLogger.getInstance().debug("InformListHandler.getInformBeanList.start");
		Connection con = null;
		LogPreparedStatement pstmt = null;
		ResultSet rs = null;

		//maxCount
		int maxCount = 0;
		List<InformBean> list = new ArrayList<InformBean>();
		try {

			con = DBConnectionMgr.getInstance().getConnection();			
			
			String countGetQuery ="select count(*) from inform";
			String listGetQuery = "select * from inform order by regist_date desc limit ?,?";
			
			//画面に表示する総データ数を取得
			pstmt = new LogPreparedStatement(con, countGetQuery);
			rs = pstmt.executeQuery();
			KankokujinLogger.getInstance().debug("MemberFindInfoHandler.getSearchStoreListTotal" + pstmt.getQueryString());
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
			if (con != null) {
				DBConnectionMgr.getInstance().freeConnection(con);
			}
		}

		return list;

	}	
	
}