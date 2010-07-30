package member.handler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import common.constant.Const;
import common.database.DBConnectionMgr;
import common.database.LogPreparedStatement;
import common.exception.SysException;
import common.logger.KankokujinLogger;

public class MemberDeleteHandler {
	public boolean deleteMemberBean(String userid) throws SysException {
		Connection con = null;
		LogPreparedStatement pstmt = null;
		try {
			con = DBConnectionMgr.getInstance().getConnection();
			
			ArrayList<String>list = setUpdateSql(userid);
			Iterator it = list.iterator();
          	if (it.hasNext()) {
          		while (it.hasNext()) {
          			String  strSql = (String) it.next();
          			pstmt = new LogPreparedStatement(con, strSql);
          			KankokujinLogger.getInstance().debug("MemberDeleteHandler.deleteMemberBean" + pstmt.getQueryString());
					pstmt.executeUpdate();
          		}
          	}
		} catch (SQLException e) {
			throw new SysException("SYE0002" , e);
		} catch (Exception e) {
			throw new SysException("SYE0002" , e);
		} finally {
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException e) {
					throw new SysException("SYE0002" , e);
				}
			if (con != null) {
				DBConnectionMgr.getInstance().freeConnection(con);
			}
		}
		return true;

	}
	private ArrayList<String> setUpdateSql(String userid){
		ArrayList<String> list = new ArrayList<String>();

		String[] table = Const.TABLE;
		for(int i=0;i<table.length;i++){
			String sql = "update "+table[i]+" set deleteflg=1 where user_id= '" +userid+"' ";
			list.add(sql);
		}
		return list;
	}
	
}