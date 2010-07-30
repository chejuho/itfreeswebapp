package iboard.handler;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import common.database.LogPreparedStatement;
import common.exception.SysException;
import common.util.Util;


public class IBoardCommonHandler {
	private static IBoardCommonHandler instance = null;
	private IBoardCommonHandler(){
		
	}
    public static IBoardCommonHandler getInstance() {
        if (instance == null) {
            synchronized (IBoardCommonHandler.class) {
                if (instance == null) {
                    instance = new IBoardCommonHandler();
                }
            }
        }

        return instance;
    }
    //public String
    public boolean isEditAuthority(
			Connection con, 
			int id, 
			String password)
		throws SysException {

		LogPreparedStatement pstmt = null;
		ResultSet rs = null;
		
		boolean sign = false;
		try {
			StringBuffer sb = new StringBuffer("select count(*) from iboard_info where id = ? and pass_word = ?");
			pstmt = new LogPreparedStatement(con, sb.toString());
			pstmt.setInt(1, id);
			pstmt.setString(2, Util.password(password));
			rs = pstmt.executeQuery();
			if (rs.next()) {
				sign = (rs.getInt(1) == 1);
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
		return sign;
	}
    
    public String getBoardName(Connection con, String boardId) throws SysException {
    	
    	String boardName = null;
    	LogPreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			StringBuffer sb = new StringBuffer("select board_name from board where board_id = ?");
			pstmt = new LogPreparedStatement(con, sb.toString());
			pstmt.setString(1, boardId);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				boardName = rs.getString(1);
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
		return boardName;
    }
    
    public String getFromRequestBoardId(HttpServletRequest request) {
    	
    	String board_id = null;
    	
    	if (Util.isEmpty(request.getParameter("board_id"))) {
			board_id = "memorizer";
		} else {
			board_id = request.getParameter("board_id");
		}
    	return board_id;
    }
	
}