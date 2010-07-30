package engmgn.handler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.database.DBConnectionMgr;
import common.exception.AppException;
import common.util.Util;

import engmgn.bean.EngMgnBean;

public class EngMgnListHandler {

	public ArrayList<EngMgnBean> getList(String position, String initial,
			String language, String userLevel) throws AppException {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<EngMgnBean> list = new ArrayList<EngMgnBean>();

		try {

			con = DBConnectionMgr.getInstance().getConnection();

			StringBuffer sb = new StringBuffer();
			sb.append("select * from engineer ");
			if (!"1".equals(userLevel)) {
				sb.append(" Where view_flg != 1 ");
			}
			sb.append(" order by eng_id desc");
//			if (Util.isEmpty(position)) {
//				if (Util.isEmpty(initial)) {
//					if (language == null || language.equals("0")) {// null null
//																	// null
//						sb.append("order by eng_id desc");
//					} else {// null null not null
//						sb.append("where eng_language like '%");
//						sb.append(language);
//						sb.append("%' order by eng_id desc");
//					}
//				} else {
//					if (language == null || language.equals("0")) {// null
//																	// notnull
//																	// null
//						sb.append("where eng_initial like '%");
//						sb.append(initial);
//						sb.append("%' order by eng_id desc");
//					} else {// null notnull notnull
//						sb.append("where eng_initial like '%");
//						sb.append(initial);
//						sb.append("%' and eng_language like '%" + language
//								+ "%'order by eng_id desc");
//					}
//				}
//
//			} else {// position not null or not empty
//				if (Util.isEmpty(initial)) {
//					if (language == null || language.equals("0")) {// notnull
//																	// null null
//						sb.append("where eng_id_position like '%");
//						sb.append(position);
//						sb.append("%' order by eng_id desc");
//					} else {// notnull null notnull
//						sb.append("where eng_id_position like '%");
//						sb.append(position);
//						sb.append("%' and eng_language like '%");
//						sb.append(language);
//						sb.append("%'order by eng_id desc");
//					}
//				} else {
//					if (language == null || language.equals("0")) {// notnull
//																	// notnull
//																	// null
//						sb.append("where eng_id_position like '%");
//						sb.append(position);
//						sb.append("%' and eng_initial like '%" + initial
//								+ "%' order by eng_id desc");
//					} else {// notnull notnull notnull
//						sb.append("where eng_id_position like '%");
//						sb.append(position);
//						sb.append("%' and eng_initial like '%");
//						sb.append(initial);
//						sb.append("%' and eng_language like '%");
//						sb.append(language);
//						sb.append("%'order by eng_id desc");
//					}
//				}
//
//			}
			pstmt = con.prepareStatement(sb.toString());

			rs = pstmt.executeQuery();

			while (rs.next()) {
				EngMgnBean bean = new EngMgnBean();
				bean.setEng_id(rs.getString("eng_id"));
				bean.setEng_type(rs.getString("eng_type"));
				bean.setEng_initial(rs.getString("eng_initial"));
				bean.setEng_name1(rs.getString("eng_name1"));
				bean.setEng_sex(rs.getString("eng_sex"));
				bean.setEng_name2(rs.getString("eng_name2"));
				bean.setEng_nation(rs.getString("eng_nation"));
				bean.setEng_nation_etc(rs.getString("eng_nation_etc"));
				bean.setEng_skilllicense(rs.getString("eng_skilllicense"));
				bean.setEng_japlicense(rs.getString("eng_japlicense"));
				bean.setEng_age(rs.getString("eng_age"));
				bean.setEng_career(rs.getString("eng_career"));
				bean.setEng_os(rs.getString("eng_os"));
				bean.setEng_os_etc(rs.getString("eng_os_etc"));
				bean.setEng_db(rs.getString("eng_db"));
				bean.setEng_db_etc(rs.getString("eng_db_etc"));
				bean.setEng_language(rs.getString("eng_language"));
				bean.setEng_language_etc(rs.getString("eng_language_etc"));
				bean.setEng_process(rs.getString("eng_process"));
				bean.setEng_possibledate(rs.getString("eng_possibledate"));
				bean.setEng_japanese(rs.getString("eng_japanese"));
				bean.setEng_ment(rs.getString("eng_ment"));
				bean.setEng_salary(rs.getString("eng_salary"));
				bean.setEng_state(rs.getString("eng_state"));
				bean.setEng_updatedate(rs.getString("eng_updatedate"));
				bean.setEng_filename(Util.changeNullStr(rs
						.getString("eng_filename")));
				bean.setEng_id_position(rs.getString("eng_id_position"));
				bean.setViewflg(rs.getString("view_flg"));

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

				try {
					con.close();
				} catch (SQLException e) {
					throw new AppException("SQLException" + e);
				}
			}
		}
		return list;

	}

	/**
	 * ENG_ID‚ðŽg‚Á‚ÄENGINEER‚ÌUPDATE‚·‚é–½—ß
	 * 
	 * @return EngMgnBean
	 */
	/*
	 * public int update(EngMgnBean bean,int id){ Connection conn= null;
	 * Statement stmt= null;
	 * 
	 * int eng_type=bean.getEng_type(); String eng_name=bean.getEng_name(); int
	 * eng_age=bean.getEng_age(); int eng_career=bean.getEng_career(); int
	 * eng_os=bean.getEng_os(); int eng_db=bean.getEng_db(); int
	 * eng_language=bean.getEng_language(); int
	 * eng_process=bean.getEng_process(); String
	 * eng_possibledate=bean.getEng_possibledate(); int
	 * eng_japanese=bean.getEng_japanese();
	 * 
	 * String eng_ment=bean.getEng_ment(); int eng_salary=bean.getEng_salary();
	 * String eng_state=bean.getEng_state(); String
	 * eng_filename=bean.getEng_filename(); //String
	 * eng_insertdate=bean.getEng_insertdate();
	 * 
	 * String eng_id_position=bean.getEng_id_position();
	 * 
	 * try{
	 * 
	 * conn = DBConnectionMgr.getInstance().getConnection(); stmt = (Statement)
	 * conn.createStatement(); //System.out.println("2");
	 * 
	 * String strSql= "update engineer set name='"+eng_id+"' eng_id='"+id+"''";
	 * int rs1 = stmt.executeUpdate(strSql); if(rs1==1){ return 1;
	 *  }
	 * 
	 * stmt.close(); conn.close();
	 * 
	 * //System.out.println("3"); }catch(SQLException e){
	 * System.out.println("datebase error"); System.out.println("error
	 * message:"+e.getMessage());
	 * 
	 * }catch(Exception e){ e.printStackTrace();
	 *  } //System.out.println("4"); return 0;
	 * 
	 * 
	 *  }
	 */
}
