package iboard.handler;

import iboard.bean.IBoardBean;
import iboard.bean.IBoardSearchBean;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import menu.handler.SQLUtil;

import job.bean.JobSearchBean;

import common.bean.PageBean;
import common.database.LogPreparedStatement;
import common.exception.SysException;
import common.logger.KankokujinLogger;
import common.page.PageUtil;
import common.util.Util;


public class IBoardListHandler {
	private static IBoardListHandler instance = null;
	private IBoardListHandler(){
		
	}
    public static IBoardListHandler getInstance() {
        if (instance == null) {
            synchronized (IBoardListHandler.class) {
                if (instance == null) {
                    instance = new IBoardListHandler();
                }
            }
        }

        return instance;
    }
    
    public List<IBoardBean> getIBoardBeanList(
			Connection con, 
			PageBean pageBean, 
			IBoardSearchBean searchBean)
		throws SysException {

		LogPreparedStatement pstmt = null;
		ResultSet rs = null;
		//maxCount
		int maxCount = 0;
		
		List<IBoardBean> list = new ArrayList<IBoardBean>();
		try {
			String countGetQuery = getCountGetQuery(searchBean);
			String listGetQuery = getListGetQuery(searchBean);
			
			//
			pstmt = new LogPreparedStatement(con, countGetQuery);
			rs = pstmt.executeQuery();
			KankokujinLogger.getInstance().debug("IBoardListHandler.getIBoardBeanList.sql1=" + pstmt.getQueryString());
			if (rs.next()) {
				maxCount = rs.getInt(1);
			}
			
			//�y�[�W����
			PageUtil.getInstance().nextPage(pageBean, maxCount);
			pstmt = new LogPreparedStatement(con, listGetQuery);
			pstmt.setInt(1, pageBean.getStartCount() - 1);
			pstmt.setInt(2, pageBean.getPageSize());
			KankokujinLogger.getInstance().debug("IBoardListHandler.getIBoardBeanList.sql2=" + pstmt.getQueryString());
			rs = pstmt.executeQuery();
		
			while (rs.next()) {
		
				IBoardBean bean = new IBoardBean();
				bean.setId(rs.getString("id"));
				bean.setTitle(rs.getString("title"));
				bean.setContent(rs.getString("content"));
				bean.setFilename1(rs.getString("file_name1"));
				bean.setFilename2(rs.getString("file_name2"));
				bean.setFilename3(rs.getString("file_name3"));
				bean.setRead_count(rs.getString("read_count"));
				bean.setUpdate_dateTime(rs.getTimestamp("update_date"));
				bean.setUser_name(Util.cutLongName(10, rs.getString("user_name")));
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
	 * @param iboard_info
	 * @return 
	 */
	private String getListGetQuery(IBoardSearchBean searchBean) {
		
		StringBuffer sb = new StringBuffer();
		sb.append("select * from iboard_info ");
		sb.append(getWhereList(searchBean));
		sb.append(" order by update_date desc limit ?,? ");
		return sb.toString();
	}
	
	/**
	 * @param iboard_info
	 * @return 
	 */
	private String getCountGetQuery(IBoardSearchBean searchBean) {
		
		StringBuffer sb = new StringBuffer();
		sb.append("select count(*) from iboard_info ");
		sb.append(getWhereList(searchBean));
		return sb.toString();
	}
	
	/**
	 * 
	 * @param bean
	 * @return
	 */
	public String getWhereList(IBoardSearchBean bean) {
		
		String whereSql = "";
		String search = bean.getSearch();
		String search_range = bean.getSearch_range();
		String board_id = bean.getIboard_id();
		List<String> andList = new ArrayList<String>();
		List<String> orList = new ArrayList<String>();
		
		if (!Util.isEmpty(search)) {
			List<String> searchList = SQLUtil.changeSearch(search);
			/** 全体検索 */
			if ("0".equals(search_range)) {
				orList.add(SQLUtil.makelikeSQL(searchList, "title"));
				orList.add(SQLUtil.makelikeSQL(searchList, "content"));
				orList.add(SQLUtil.makelikeSQL(searchList, "file_name1"));
				orList.add(SQLUtil.makelikeSQL(searchList, "file_name2"));
				orList.add(SQLUtil.makelikeSQL(searchList, "file_name3"));
			/** タイトル */
			} else if ("1".equals(search_range)) {
				orList.add(SQLUtil.makelikeSQL(searchList, "title"));
			/** 内容 */
			} else if ("2".equals(search_range)) {
				orList.add(SQLUtil.makelikeSQL(searchList, "content"));		
			/** ファイル名 */
			} else if ("3".equals(search_range)) {
				orList.add(SQLUtil.makelikeSQL(searchList, "file_name1"));
				orList.add(SQLUtil.makelikeSQL(searchList, "file_name2"));
				orList.add(SQLUtil.makelikeSQL(searchList, "file_name3"));
			}
			andList.add(SQLUtil.getWhereOrSql(orList));
			
		}
		andList.add(SQLUtil.makeEqualStateForChar("board_id", board_id));
		whereSql = SQLUtil.getWhereSQL(andList);
		return whereSql;
			
	}
	
}