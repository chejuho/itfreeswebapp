package engmgn.handler;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import common.database.DBConnectionMgr;
import common.exception.AppException;
import common.util.Util;

import engmgn.bean.EngMgnBean;

public class EngMgnDetailHandler {

	public EngMgnBean getEngineer(String eng_id) throws AppException {
		EngMgnBean bean = new EngMgnBean();
		Connection con= null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
		
		try{
		con = DBConnectionMgr.getInstance().getConnection();
			String strSql= "select * from engineer where eng_id=?";
			pstmt=con.prepareStatement(strSql);
			pstmt.setString(1, eng_id);
			rs=pstmt.executeQuery();
			
			while(rs.next()){
			
				bean.setEng_id(Util.changeNullStr(rs.getString("eng_id")));
				bean.setEng_type(Util.changeNullStr(rs.getString("eng_type")));
				bean.setEng_initial(Util.changeNullStr(rs.getString("eng_initial")));
				bean.setEng_sex(Util.changeNullStr(rs.getString("eng_sex")));
				bean.setEng_name1(Util.changeNullStr(rs.getString("eng_name1")));
				bean.setEng_name2(Util.changeNullStr(rs.getString("eng_name2")));
				bean.setEng_nation(Util.changeNullStr(rs.getString("eng_nation")));
				bean.setEng_nation_etc(Util.changeNullStr(rs.getString("eng_nation_etc")));
				bean.setEng_skilllicense(Util.changeNullStr(rs.getString("eng_skilllicense")));
				bean.setEng_japlicense(Util.changeNullStr(rs.getString("eng_japlicense")));
				bean.setEng_age(Util.changeNullStr(rs.getString("eng_age")));
				bean.setEng_career(Util.changeNullStr(rs.getString("eng_career")));				
				bean.setEng_os(Util.changeNullStr(rs.getString("eng_os")));		
				bean.setEng_os_etc(Util.changeNullStr(rs.getString("eng_os_etc")));
				bean.setEng_db(Util.changeNullStr(rs.getString("eng_db")));
				bean.setEng_db_etc(Util.changeNullStr(rs.getString("eng_db_etc")));
				bean.setEng_language(Util.changeNullStr(rs.getString("eng_language")));
				bean.setEng_language_etc(Util.changeNullStr(rs.getString("eng_language_etc")));
				bean.setEng_process(Util.changeNullStr(rs.getString("eng_process")));
				bean.setEng_possibledate(Util.changeNullStr(rs.getString("eng_possibledate")));
				bean.setEng_japanese(Util.changeNullStr(rs.getString("eng_japanese")));				
				bean.setEng_ment(Util.changeNullStr(rs.getString("eng_ment")));
				bean.setEng_salary(Util.changeNullStr(rs.getString("eng_salary")));
				bean.setEng_state(Util.changeNullStr(rs.getString("eng_state")));
				bean.setEng_filename(Util.changeNullStr(rs.getString("eng_filename")));
				bean.setEng_id_position(Util.changeNullStr(rs.getString("eng_id_position")));
				bean.setViewflg(Util.changeNullStr(rs.getString("view_flg")));
				
								
			}	

		}catch (SQLException e) {
			throw new AppException("EngMgnDetailHandler.getEngineer.SQLException" + e);

		} catch (Exception e) {
			throw new AppException("EngMgnDetailHandler.getEngineer.Exception" + e);

		} finally {
			if (rs != null) {

				try {
					rs.close();
				} catch (SQLException e) {
					throw new AppException("EngMgnDetailHandler.getEngineer.SQLException" + e);
				}
			}
			if (pstmt != null) {

				try {
					pstmt.close();
				} catch (SQLException e) {
					throw new AppException("EngMgnDetailHandler.getEngineer.SQLException" + e);
				}
			}
			if (con != null) {

				try {
					con.close();
				} catch (SQLException e) {
					throw new AppException("EngMgnDetailHandler.getEngineer.SQLException" + e);
				}
			}
		}
		return bean;
	
	}
	/**
	 * ENG_ID‚ðŽg‚Á‚ÄENGINEER‚ÌUPDATE‚·‚é–½—ß
	 * 
	 * @return EngMgnBean
	 */
/*
	public int update(EngMgnBean bean,int id){
		Connection conn= null;
		Statement stmt= null;
		
		int eng_type=bean.getEng_type();
		String eng_name=bean.getEng_name();
		int eng_age=bean.getEng_age();
		int eng_career=bean.getEng_career();
		int eng_os=bean.getEng_os();
		int eng_db=bean.getEng_db();
		int eng_language=bean.getEng_language();
		int eng_process=bean.getEng_process();
		String eng_possibledate=bean.getEng_possibledate();
		int eng_japanese=bean.getEng_japanese();
		
		String eng_ment=bean.getEng_ment();
		int eng_salary=bean.getEng_salary();
		String eng_state=bean.getEng_state();
		String eng_filename=bean.getEng_filename();
		//String eng_insertdate=bean.getEng_insertdate();
		
		String eng_id_position=bean.getEng_id_position();
	    	
		try{
					
			conn = DBConnectionMgr.getInstance().getConnection();
			stmt = (Statement) conn.createStatement();
			//System.out.println("2");
		
			String strSql= "update engineer set name='"+eng_id+"' eng_id='"+id+"''";
			int rs1 = stmt.executeUpdate(strSql);
			if(rs1==1){
				return 1;
			
		    }
			
			stmt.close();
			conn.close();
			
			//System.out.println("3");
		}catch(SQLException e){
			System.out.println("datebase error");
			System.out.println("error message:"+e.getMessage());
				
		}catch(Exception e){
		    e.printStackTrace();
		    
	    }
		  //System.out.println("4");
	           return 0;
	
	       

      }
*/
}
