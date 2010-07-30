package engmgn.handler;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import common.database.DBConnectionMgr;
import common.exception.AppException;
import common.logger.KankokujinLogger;

import engmgn.bean.EngMgnBean;

public class EngMgnRegistHandler {
	
/**
 * EngineerのINSERTする命令
 * 
 * @return void
 */
	public boolean insert(EngMgnBean bean) throws AppException{
		Connection con= null;
		PreparedStatement pstmt = null;
		
		try{
			con = DBConnectionMgr.getInstance().getConnection();
			String strsqr = "insert into engineer(eng_type, eng_initial, eng_name1 ,eng_name2 ,eng_nation, eng_skilllicense, " +
					"eng_japlicense, eng_age, eng_career ,eng_os ,eng_db ,eng_language, eng_process ,eng_possibledate ," +
					"eng_japanese , eng_ment ,eng_salary, eng_state ,eng_filename, eng_id_position, " +
					"eng_nation_etc, eng_os_etc, eng_db_etc, eng_language_etc, eng_sex, eng_insertdate, eng_updatedate, view_flg)" +
					"values" +
					"(?, ?, ?, ?, ?, ?, ?, ?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, now(), now(), ?)";
			
			pstmt = con.prepareStatement(strsqr);
			pstmt.setString(1, bean.getEng_type());
			pstmt.setString(2, bean.getEng_initial());
			pstmt.setString(3, bean.getEng_name1());
			pstmt.setString(4, bean.getEng_name2());
			pstmt.setString(5, bean.getEng_nation());
			pstmt.setString(6, bean.getEng_skilllicense());
			pstmt.setString(7, bean.getEng_japlicense());
			pstmt.setString(8, bean.getEng_age());
			pstmt.setString(9, bean.getEng_career());
			pstmt.setString(10, bean.getEng_os());
			pstmt.setString(11, bean.getEng_db());
			pstmt.setString(12, bean.getEng_language());
			pstmt.setString(13, bean.getEng_process());
			pstmt.setString(14, bean.getEng_possibledate());
			pstmt.setString(15, bean.getEng_japanese());
			pstmt.setString(16, bean.getEng_ment());
			pstmt.setString(17, bean.getEng_salary());
			pstmt.setString(18, bean.getEng_state());
			pstmt.setString(19, bean.getEng_filename());
			pstmt.setString(20, bean.getEng_id_position());
			pstmt.setString(21, bean.getEng_nation_etc());
			pstmt.setString(22, bean.getEng_os_etc());
			pstmt.setString(23, bean.getEng_db_etc());
			pstmt.setString(24, bean.getEng_language_etc());
			pstmt.setString(25, bean.getEng_sex());
			pstmt.setString(26, bean.getViewflg());
		
			
			
			pstmt.executeUpdate();
			
			return true;
			
			
	    }catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			KankokujinLogger.getInstance().debug("error message:"+e.getMessage());
			DBConnectionMgr.getInstance().freeConnection(con);

		} finally {
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException e) {
				}
			if (con != null) {
				DBConnectionMgr.getInstance().freeConnection(con);
			}
		}
		return false;
	}

	
	/**
	 * ENG_IDを使ってENGINEERのSELECTする命令
	 * 
	 * @return EngMgnBean
	 */
	public EngMgnBean getEngineer(int eng_id) throws AppException{
		EngMgnBean bean = new EngMgnBean();
		 Connection con= null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
		System.out.println("1");
		
		try{
		con = DBConnectionMgr.getInstance().getConnection();
			System.out.println("2");
			String strSql= "select * from engineer where eng_id=?";
			pstmt=con.prepareStatement(strSql);
			pstmt.setInt(1, eng_id);
			rs=pstmt.executeQuery();
			
			while(rs.next()){
			
				bean.setEng_id(rs.getString("eng_id"));
				bean.setEng_type(rs.getString("eng_type"));
				bean.setEng_initial(rs.getString("eng_initial"));
				bean.setEng_name1(rs.getString("eng_name1"));
				bean.setEng_name2(rs.getString("eng_name2"));
				bean.setEng_nation(rs.getString("eng_nation"));
				bean.setEng_skilllicense(rs.getString("eng_skilllicense"));
				bean.setEng_japlicense(rs.getString("eng_japlicense"));
				bean.setEng_age(rs.getString("eng_age"));
				bean.setEng_career(rs.getString("eng_career"));				
				bean.setEng_os(rs.getString("eng_os"));
				bean.setEng_db(rs.getString("eng_db"));
				bean.setEng_language(rs.getString("eng_language"));
				bean.setEng_process(rs.getString("eng_process"));
				bean.setEng_possibledate(rs.getString("eng_possibledate"));
				bean.setEng_japanese(rs.getString("eng_japanese"));
				
				bean.setEng_ment(rs.getString("eng_ment"));
				bean.setEng_salary(rs.getString("eng_salary"));
				bean.setEng_state(rs.getString("eng_state"));
				bean.setEng_filename(rs.getString("eng_filename"));
				//bean.setEng_insertdate(rs.getString("eng_insertdate"));
				//bean.setEng_updatedate(rs.getString("eng_updatedate"));
				bean.setEng_id_position(rs.getString("eng_id_position"));
								
			}

		}catch (SQLException e) {
			throw new AppException("EngMgnRegistHandler.getEngineer.SQLException" + e);

		} catch (Exception e) {
			throw new AppException("EngMgnRegistHandler.getEngineer.Exception" + e);

		} finally {
			if (rs != null) {

				try {
					rs.close();
				} catch (SQLException e) {
					throw new AppException("EngMgnRegistHandler.getEngineer.SQLException" + e);
				}
			}
			if (pstmt != null) {

				try {
					pstmt.close();
				} catch (SQLException e) {
					throw new AppException("EngMgnRegistHandler.getEngineer.SQLException" + e);
				}
			}
			if (con != null) {

				try {
					con.close();
				} catch (SQLException e) {
					throw new AppException("EngMgnRegistHandler.getEngineer.SQLException" + e);
				}
			}
		}
		return bean;
	
	}
	/**
	 * ENG_IDを使ってENGINEERのUPDATEする命令
	 * 
	 * @return EngMgnBean
	 *//*
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
