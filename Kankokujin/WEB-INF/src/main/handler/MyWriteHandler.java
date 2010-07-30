package main.handler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import main.bean.AllSearchCountBean;
import main.bean.MainInfoBean;
import main.bean.QuickSearchCountBean;

import common.database.DBConnectionMgr;
import common.exception.SysException;
import common.logger.KankokujinLogger;

public class MyWriteHandler {
	private static MyWriteHandler instance = null;

	private final static String UNION = "union all";
	
	private static final String BUY_CODE = "C10001";
	
	private static final String SELL_CODE = "C10002";
	

	private MyWriteHandler() {

	}

	public static MyWriteHandler getInstance() {
		if (instance == null) {
			synchronized (MyWriteHandler.class) {
				if (instance == null) {
					instance = new MyWriteHandler();
				}
			}
		}

		return instance;
	}
	public AllSearchCountBean getAllSearchCount(String id) throws SysException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		AllSearchCountBean bean = new AllSearchCountBean();
		try {
			con = DBConnectionMgr.getInstance().getConnection();
			StringBuffer sb = new StringBuffer();
			sb.append("select count(*) from buysell_info where user_id = ? and deleteflg !=1 and cate_code_1='C10100' union all\t");
			sb.append("select count(*) from buysell_info where user_id = ? and deleteflg !=1 and cate_code_1='C10200' union all\t");
			sb.append("select count(*) from store_info where user_id = ? and deleteflg != 1 union all\t");
			sb.append("select count(*) from gourmet_info where user_id = ? and deleteflg != 1 union all\t");
			sb.append("select count(*) from room_info where user_id = ? and room_sort IN (7,8,9,10) and deleteflg != 1 union all\t");
			sb.append("select count(*) from room_info where user_id = ? and room_sort IN (0,1,2,3,4,5,6) and deleteflg != 1 union all\t");
			sb.append("select count(*) from house_info where user_id = ? and deleteflg != 1 union all\t");
			sb.append("select count(*) from job_info where user_id = ? and deleteflg != 1 union all\t");
			sb.append("select count(*) from findjob_info where user_id = ?");
			
			KankokujinLogger.getInstance().debug("getAllSearchCount sql=" + sb.toString());
			pstmt = con.prepareStatement(sb.toString());
			
			pstmt.setString(1, id);
			pstmt.setString(2, id);
			pstmt.setString(3, id);
			pstmt.setString(4, id);
			pstmt.setString(5, id);
			pstmt.setString(6, id);
			pstmt.setString(7, id);
			pstmt.setString(8, id);
			pstmt.setString(9, id);

			//îÉÇ¢Ç‹Ç∑
			rs = pstmt.executeQuery();
			rs.next();
			bean.setBuy_count(rs.getInt(1));
			//îÑÇËÇ‹Ç∑
			rs.next();
			bean.setSell_count(rs.getInt(1));
			//ìXíTÇµ
			rs.next();
			bean.setStore_count(rs.getInt(1));
			//à˘êHìX			
			rs.next();
			bean.setGourmet_count(rs.getInt(1));
			//ÉzÉeÉã		
			rs.next();
			bean.setHotel_count(rs.getInt(1));
			//óæ			
			rs.next();
			bean.setBoardingHouse_count(rs.getInt(1));
			//ïsìÆéY		
			rs.next();
			bean.setHouseSell_count(rs.getInt(1));
			//ãÅêl
			rs.next();
			bean.setJobSearch_count(rs.getInt(1));
			//ãÅêE		
			rs.next();
			bean.setFindjobSearch_count(rs.getInt(1));
						

		} catch (SQLException e) {
			e.printStackTrace();
			throw new SysException("MyWriteHandler", e);

		} catch (Exception e) {
			throw new SysException("MyWriteHandler", e);

		} finally {
			if (rs != null) {

				try {
					rs.close();
				} catch (SQLException e) {
					throw new SysException("MyWriteHandler", e);
				}
			}
			if (pstmt != null) {

				try {
					pstmt.close();
				} catch (SQLException e) {
					throw new SysException("MyWriteHandler" + e);
				}
			}
			if (con != null) {

				DBConnectionMgr.getInstance().freeConnection(con);
			}
		}
		return bean;

	}
	/**
	 * @return MainInfoBean
	 * @throws SysException
	 */
	public MainInfoBean getMainInfoBean() throws SysException {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MainInfoBean mainInfoBean = new MainInfoBean();
		
		try {
			con = DBConnectionMgr.getInstance().getConnection();
			StringBuffer sb = new StringBuffer();
			sb.append("select count(*) as a from room_info where room_sort=0 or room_sort=1 or room_sort=2 or room_sort=3 or room_sort='5' and deleteflg=0 union ");
			sb.append("select count(*) as b from room_info where room_sort=3 and deleteflg=0 union ");			
			sb.append("select count(*) as c from room_info where room_sort=8 and deleteflg=0 union ");
			sb.append("select count(*) as d from room_info where room_sort=9 or room_sort=10 and deleteflg=0 union ");
			sb.append("select count(*) from job_info where cate_code_1='C10001' and deleteflg=0 union ");
			sb.append("select count(*) from job_info where cate_code_1='C10002' and deleteflg=0 ");

			KankokujinLogger.getInstance().debug(
					"getRoomCount sql=" + sb.toString());
			pstmt = con.prepareStatement(sb.toString());
			rs = pstmt.executeQuery();
//			if(rs.next()){
//				bean.setDomi_count(rs.getInt(1));
//			}
//			if(rs.next()){
//				bean.setRoomshare_count(rs.getInt(1));
//			}	
//			if(rs.next()){
//				bean.setMinshuku_count(rs.getInt(1));
//			}
//			if(rs.next()){
//				bean.setHotel_count(rs.getInt(1));
//			}	
//			if(rs.next()){
//				bean.setStaff_count(rs.getInt(1));
//			}	
//			if(rs.next()){
//				bean.setArbeit_count(rs.getInt(1));
//			}				

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
		//return bean;
		
		
		return null;
		
		
	}
}