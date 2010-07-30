package main.handler;

import findjob.bean.FindjobBean;
import gourmet.bean.GourmetBean;
import housesell.bean.HouseBean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import job.bean.JobBean;
import main.bean.BannerBean;
import main.bean.MainInfoBean;
import main.bean.QuickSearchCountBean;
import roomsell.bean.RoomBean;
import store.bean.StoreBean;
import buysell.bean.BuySellBean;

import common.database.DBConnectionMgr;
import common.database.LogPreparedStatement;
import common.exception.AppException;
import common.exception.SysException;
import common.logger.KankokujinLogger;
import common.util.Util;

public class NewWriteHandler {
	private static NewWriteHandler instance = null;
	
	private static final int START_NO = 1;
	private static final int COUNT = 5;
	private final static String UNION = "union all \t";

	private NewWriteHandler() {

	}

	public static NewWriteHandler getInstance() {
		if (instance == null) {
			synchronized (NewWriteHandler.class) {
				if (instance == null) {
					instance = new NewWriteHandler();
				}
			}
		}

		return instance;
	}
	public QuickSearchCountBean getQuickSearchCount(Connection con) throws SysException {
		LogPreparedStatement pstmt = null;
		ResultSet rs = null;
		QuickSearchCountBean bean = new QuickSearchCountBean();
		try {
			StringBuffer sb = new StringBuffer();
			sb.append("select count(*) as a from room_info,member where room_info.user_id=member.user_id and room_sort IN(0,1,2,5) and room_info.deleteflg=0 union all\t");
			sb.append("select count(*) as b from room_info,member where room_info.user_id=member.user_id and room_sort=3 and room_info.deleteflg=0 union all\t");			
			sb.append("select count(*) as c from room_info,member where room_info.user_id=member.user_id and room_sort=8 and room_info.deleteflg=0 union all\t");
			sb.append("select count(*) as d from room_info,member where room_info.user_id=member.user_id and room_sort IN(9,10) and room_info.deleteflg=0 union all\t");
			sb.append("select count(*) from job_info,member where job_info.user_id=member.user_id and cate_code_1='C10100' and job_info.deleteflg=0 union all\t");
			sb.append("select count(*) from job_info,member where job_info.user_id=member.user_id and cate_code_1='C10200' and job_info.deleteflg=0 ");

			KankokujinLogger.getInstance().debug(
					"getRoomCount sql=" + sb.toString());
			pstmt = new LogPreparedStatement(con, sb.toString());
			rs = pstmt.executeQuery();
			if(rs.next()){
				bean.setDomi_count(rs.getInt(1));
			}
			if(rs.next()){
				bean.setRoomshare_count(rs.getInt(1));
			}	
			if(rs.next()){
				bean.setMinshuku_count(rs.getInt(1));
			}
			if(rs.next()){
				bean.setHotel_count(rs.getInt(1));
			}	
			if(rs.next()){
				bean.setStaff_count(rs.getInt(1));
			}	
			if(rs.next()){
				bean.setArbeit_count(rs.getInt(1));
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
		return bean;

	}
	/**
	 * @return MainInfoBean
	 * @throws SysException
	 * @throws AppException 
	 */
	public MainInfoBean getMainInfoBean(Connection con, int errorCount) throws SysException, AppException {
		
		LogPreparedStatement pstmt = null;
		ResultSet rs = null;
		MainInfoBean mainInfoBean = null;
		try {
			
			StringBuffer sb = new StringBuffer();
			sb.append("select id,title,user_id,email,update_date,'A' as sign from (select id,title,update_date,user_id,email from buysell_info where cate_code_1 = 'C10100' and  deleteflg = 0  order by update_date desc limit 0,4) P1 union all\t");
			sb.append("select id,title,user_id,email,update_date,'B' as sign from(select id,title,update_date,user_id,email from buysell_info where cate_code_1 = 'C10200'  and  deleteflg = 0  order by update_date desc limit 0,4) P2 union all\t");
			sb.append("select id,store_name_k,store_name_j,appeal_point,update_date,'C' as sign from (select id,store_name_k,store_name_j,appeal_point,update_date from store_info where deleteflg = 0 order by update_date desc limit 0,4) P3 union all\t");
			sb.append("select id,store_name_k,store_name_j,appeal_point,update_date,'D' as sign from (select id,store_name_k,store_name_j,appeal_point,update_date from gourmet_info where deleteflg = 0 order by update_date desc limit 0,4) P4 union all\t");
			sb.append("select id,title,cate_code_1,room_fee,update_date,'E' as sign from (select id,title,cate_code_1,room_fee,update_date from room_info where cate_code_1 = 'C10001' and deleteflg=0  order by update_date desc limit 0,4) P5 union all\t");
			sb.append("select id,title,cate_code_1,room_fee,update_date,'F' as sign from (select id,title,cate_code_1,room_fee,update_date from room_info where cate_code_1 = 'C10002' and deleteflg=0  order by update_date desc limit 0,4) P5 union all\t");
			sb.append("select id,title,madori,CAST(house_fee AS char),update_date,'G' as sign from (select id,title,madori,house_fee ,update_date from house_info where house_info.deleteflg = 0 order by update_date desc limit 0,4) P6 union all\t");
			sb.append("select id,title,user_id,email,update_date, 'H' as sign from (select id,title,update_date,user_id,email from job_info where job_info.deleteflg = 0 order by update_date desc limit 0,4) P7 union all\t");
			sb.append("select id,title,user_id,email,update_date,'I' as sign from (select id,title,update_date,user_id,email,'H' as sign from findjob_info where deleteflg = 0 order by update_date desc limit 0,4) P8");

			pstmt = new LogPreparedStatement(con, sb.toString());
			rs = pstmt.executeQuery();
			
			KankokujinLogger.getInstance().debug("getMainInfoBean sql=" + pstmt.getQueryString());
			
			mainInfoBean = new MainInfoBean();
			
			List<BuySellBean> buyBeanList = new ArrayList();
			List<BuySellBean> sellBeanList = new ArrayList();
			List<StoreBean> storeBeanList = new ArrayList();
			List<GourmetBean> gourmetBeanList = new ArrayList();
			List<RoomBean> roomBeanList1 = new ArrayList();
			List<RoomBean> roomBeanList2 = new ArrayList();
			List<HouseBean> houseBeanList = new ArrayList();
			List<JobBean> jobBeanList = new ArrayList();
			List<FindjobBean> findjobBeanList = new ArrayList();
			
			while (rs.next()) {
				String sign = rs.getString("sign");
				/** îÉÇ¢Ç‹Ç∑ */
				if ("A".equals(sign)) {
					BuySellBean bean = new BuySellBean();
					bean.setId(rs.getString(1));
					bean.setTitle(rs.getString(2));
					bean.setUpdate_date(rs.getTimestamp(5));
					buyBeanList.add(bean);
				/** îÑÇËÇ‹Ç∑ */
				} else if ("B".equals(sign)) {
					BuySellBean bean = new BuySellBean();
					bean.setId(rs.getString(1));
					bean.setTitle(rs.getString(2));
					bean.setUpdate_date(rs.getTimestamp(5));
					sellBeanList.add(bean);
				/** ìXèÓïÒ */
				} else if ("C".equals(sign)) {
					StoreBean bean = new StoreBean();
					bean.setId(rs.getString(1));
					bean.setStore_name_k(rs.getString(2));
					bean.setStore_name_j(rs.getString(3));
					bean.setAppeal_point(rs.getString(4));
					bean.setUpdate_date(rs.getTimestamp(5));
					storeBeanList.add(bean);
				/** à˘êHìX */
				} else if ("D".equals(sign)) {
					GourmetBean bean = new GourmetBean();
					bean.setId(rs.getString(1));
					bean.setStore_name_k(rs.getString(2));
					bean.setStore_name_j(rs.getString(3));
					bean.setAppeal_point(rs.getString(4));
					bean.setUpdate_date(rs.getTimestamp(5));
					gourmetBeanList.add(bean);
				/** ÉzÉeÉã */
				} else if ("E".equals(sign)) {
					RoomBean bean = new RoomBean();
					bean.setId(rs.getString(1));
					bean.setTitle(rs.getString(2));
					bean.setCate_code_1(Util.changeNullStr(rs.getString(3)));
					if("C10002".equals(bean.getCate_code_1())){
						bean.setRoom_fee(Util.changePriceToMan(rs.getString(4)));	
					} else {
						bean.setRoom_fee(rs.getString(4));
					}
					bean.setUpdate_date(rs.getTimestamp(5));
					roomBeanList1.add(bean);
				/** óæ */
				} else if ("F".equals(sign)) {
					RoomBean bean = new RoomBean();
					bean.setId(rs.getString(1));
					bean.setTitle(rs.getString(2));
					bean.setCate_code_1(Util.changeNullStr(rs.getString(3)));
					if("C10002".equals(bean.getCate_code_1())){
						bean.setRoom_fee(Util.changePriceToMan(rs.getString(4)));	
					} else {
						bean.setRoom_fee(rs.getString(4));
					}
					bean.setUpdate_date(rs.getTimestamp(5));
					roomBeanList2.add(bean);
				/** ïsìÆéY */	
				} else if ("G".equals(sign)) {
					HouseBean bean = new HouseBean();
					bean.setId(rs.getString(1));
					bean.setTitle(rs.getString(2));
					bean.setMadori(rs.getString(3));
					bean.setHouse_fee(new String[] {Util.changePriceToMan(rs.getString(4)), "" });
					bean.setUpdate_date(rs.getTimestamp(5));
					houseBeanList.add(bean);
				/** ãÅêl */	
				} else if ("H".equals(sign)) {
					JobBean bean = new JobBean();
					bean.setId(rs.getString(1));
					bean.setTitle(rs.getString(2));
					bean.setUpdate_date(rs.getTimestamp(5));
					jobBeanList.add(bean);
				/** ãÅêE */	
				} else if ("I".equals(sign)) {
					FindjobBean bean = new FindjobBean();
					bean.setId(rs.getString(1));
					bean.setTitle(rs.getString(2));
					bean.setUpdate_date(rs.getTimestamp(5));
					findjobBeanList.add(bean);
				} 
				
			}
			mainInfoBean.setBuyBeanList(buyBeanList);
			mainInfoBean.setSellBeanList(sellBeanList);
			mainInfoBean.setStoreBeanList(storeBeanList);
			mainInfoBean.setGourmetBeanList(gourmetBeanList);
			mainInfoBean.setRoomBeanList1(roomBeanList1);
			mainInfoBean.setRoomBeanList2(roomBeanList2);
			mainInfoBean.setHouseBeanList(houseBeanList);
			mainInfoBean.setJobBeanList(jobBeanList);
			mainInfoBean.setFindjobBeanList(findjobBeanList);

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
		
		return mainInfoBean;
		
		
	}
	
	

}