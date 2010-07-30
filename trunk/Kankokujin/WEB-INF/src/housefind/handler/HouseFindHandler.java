package housefind.handler;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.handler.UtilHandler;
import common.logger.KankokujinLogger;
import common.util.EnDecoding;
import common.util.Util;
import bean.AreaBean;
import bean.HouseFindInfo;
import housesell.bean.HouseBean;
import housesell.bean.HouseSellSortBean;
import bean.TrainBean;
import common.database.DBConnectionMgr;



public class HouseFindHandler {	
	/**
	 * RoomInfoのINSERTするメソッドド
	 * 
	 * @return boolean
	 */
	 public boolean insertHouseFindInfo(HouseFindInfo bean){
			Connection con= null;
			PreparedStatement pstmt = null;
			try{
				con = DBConnectionMgr.getInstance().getConnection();
				String strsqr = "insert into housefind_info(" +
						"title, user_id, email, telephone, detail_info, "+
								"come_dock, come_dock_year, come_dock_month, house_fee_from, house_fee_to,"+
								"area_code_1, area_code_2, area_fast, main_area, line_code, "+
								"station_code, walk_time, house_sort, dimension_from, dimension_to,"+
								"madori, regist_date, update_date)"+
						        "values(" +
						        "?,?,?,?,?," +
						        "?,?,?,?,?," +
						        "?,?,?,?,?," +
						        "?,?,?,?,?," +
						        "?,now(),now())";
						        
				
				pstmt = con.prepareStatement(strsqr);
				pstmt.setString(1, bean.getTitle());
				pstmt.setString(2, bean.getUser_id());
				pstmt.setString(3, bean.getEmail());
				pstmt.setString(4, bean.getTelephone());
				pstmt.setString(5, bean.getDetail_info());
				pstmt.setString(6, bean.getCome_dock());
				pstmt.setString(7, bean.getCome_dock_year());
				pstmt.setString(8, bean.getCome_dock_month());
				pstmt.setString(9, bean.getHouse_fee_from());
				pstmt.setString(10, bean.getHouse_fee_to());
				pstmt.setString(11, bean.getArea_code_1());
				pstmt.setString(12, bean.getArea_code_2());
				pstmt.setString(13, bean.getArea_fast());
				pstmt.setString(14, bean.getMain_area());
				pstmt.setString(15, bean.getLine_code());
				pstmt.setString(16, bean.getStation_code());
				pstmt.setString(17, bean.getWalk_time());
				pstmt.setString(18, Util.changeArrayToStr(bean.getHouse_sort()));
				pstmt.setString(19, bean.getDimension_from());
				pstmt.setString(20, bean.getDimension_to());
				pstmt.setString(21, Util.changeArrayToStr(bean.getMadori()));
				int result = pstmt.executeUpdate();
				if(result==1){
				
					return true;
				}
				
		    }catch (Exception e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
				System.out.println("error message:"+e.getMessage());
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
	  * db:room_infoからセレクトするメソッドド
	  * @return ArraList
	  */
	 public ArrayList <HouseFindInfo>getList(int start, int num) {
			
		    Connection con= null;
		    PreparedStatement pstmt = null;
		    ResultSet rs = null;
		    
			ArrayList<HouseFindInfo> list = new ArrayList<HouseFindInfo>();
			
			try{
				
				con = DBConnectionMgr.getInstance().getConnection();
					
				String strSql= "select * from housefind_info order by id limit ?,?";
				
				pstmt=con.prepareStatement(strSql);
				
				pstmt.setInt(1, start-1);
				
				pstmt.setInt(2, num);
				
				rs=pstmt.executeQuery();
				
				while(rs.next()){

					HouseFindInfo bean = new HouseFindInfo();
					bean.setId((String.valueOf(rs.getInt("id"))));
					bean.setTitle(rs.getString("title"));
					bean.setUser_id(rs.getString("user_id"));
					bean.setEmail(rs.getString("email"));
					bean.setTelephone(rs.getString("telephone"));
					bean.setDetail_info(rs.getString("detail_info"));
					bean.setCome_dock(rs.getString("come_dock"));
					bean.setCome_dock_year(rs.getString("come_dock_year"));
					bean.setCome_dock_month(rs.getString("come_dock_month"));
					bean.setHouse_fee_from(rs.getString("house_fee_from"));
					bean.setHouse_fee_to(rs.getString("house_fee_to"));
					bean.setArea_code_1(rs.getString("area_code_1"));
					bean.setArea_code_2(rs.getString("area_code_2"));
					bean.setArea_fast(rs.getString("area_fast"));
					bean.setMain_area(rs.getString("main_area"));
					bean.setLine_code(rs.getString("line_code"));
					bean.setStation_code(rs.getString("station_code"));
					bean.setWalk_time(rs.getString("walk_time"));
					bean.setHouse_sort(Util.changeStrToArray(rs.getString("house_sort")));
					bean.setDimension_from(rs.getString("dimension_from"));
					bean.setDimension_to(rs.getString("dimension_to"));
					bean.setMadori(Util.changeStrToArray(rs.getString("madori")));
					bean.setRegist_date(rs.getString("regist_date"));
					bean.setUpdate_date(rs.getString("update_date"));
					bean.setRead_count(rs.getString("read_count"));					
					list.add(bean);									
				}
				

			}catch(SQLException e){
				System.out.println("datebase error");
				System.out.println("error message:"+e.getMessage());
					
			}catch(Exception e){
			    e.printStackTrace();
			    
		    } finally {
		    	if (rs != null) {

	    			try {
						rs.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
		    	} if (pstmt != null) {
		    		
		    		try {
						pstmt.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
		    	} if (con != null) {
		    		
		    		DBConnectionMgr.getInstance().freeConnection(con);
		    	}
		    }

			return list;
		
		}
	 /**
	  * db:room_infoからセレクトするメソッドド
	  * @return ArraList
	  */
	 public ArrayList <HouseBean>getList(HouseBean houseBean, int start, int num) {
			
		    Connection con= null;
		    PreparedStatement pstmt = null;
		    ResultSet rs = null;
		    System.out.println("------database +houselist start-------");
		    
			ArrayList<HouseBean> list = new ArrayList<HouseBean>();
			StringBuffer sb = new StringBuffer();
			try{
				
				con = DBConnectionMgr.getInstance().getConnection();
				sb.append("select * from house_info ");
				UtilHandler util = new UtilHandler();
				sb.append(util.getWhereList(houseBean));
				//util.getOrderbyList(houseBean, sb);
				util.getOrderbyList(new HouseSellSortBean(), sb);
				sb.append(" limit ?,? ");
				System.out.println("getList map sql =" + sb.toString());								
				pstmt=con.prepareStatement(sb.toString());
				//TODO後で修正すること
				//pstmt.setInt(1, start);
				pstmt.setInt(1, start-1);
				
				pstmt.setInt(2, num);
				
				rs=pstmt.executeQuery();
				
				while(rs.next()){

					HouseBean bean = new HouseBean();
					
//					bean.setId(rs.getInt("id"));
//					bean.setTitle(rs.getString("title"));
//					bean.setHouseName(rs.getString("house_name"));
//					bean.setDetailInfo(rs.getString("detail_info"));
//					bean.setManageFee(rs.getString("manage_fee"));
//					bean.setHouseSort(rs.getString("house_sort"));
//					bean.setDimension(rs.getString("dimension"));
//					bean.setHouseFee(rs.getString("house_fee"));
//					bean.setDeposit(rs.getString("deposit"));
//					bean.setReikin(rs.getString("reikin"));
//					bean.setWalkTime(rs.getString("walk_time"));
//					bean.setBuildYear(rs.getString("build_year"));
//					bean.setBuild_month(rs.getString("build_month"));
//					bean.setMadori(rs.getString("madori"));
//					bean.setAllStairs(rs.getString("all_stairs"));
//					bean.setStairs(rs.getString("stairs"));
//					bean.setFlgTadami(rs.getString("flg_tadami"));
//					bean.setToilet(rs.getString("toilet"));
//					bean.setLineCode(rs.getString("line_code"));
//					bean.setStationCode(rs.getString("station_code"));
//					bean.setPhotoName1(rs.getString("photo_name1"));
//					bean.setPhotoName2(rs.getString("photo_name2"));
//					bean.setPhotoName3(rs.getString("photo_name3"));
//					bean.setPhotoName4(rs.getString("photo_name4"));
//					bean.setAreaCode1(rs.getString("area_code_1"));
//					bean.setAreaCode2(rs.getString("area_code_2"));
//					bean.setMainArea(rs.getString("main_area"));
//					bean.setAreaFast(rs.getString("area_fast"));
//					bean.setUserId(rs.getString("user_id"));
//					bean.setRegistDate(rs.getDate("regist_date"));
//					bean.setUpdateDate(rs.getDate("update_date"));
//					bean.setReadCount(rs.getInt("read_count"));
//					bean.setAreaCode3(rs.getString("area_code_3"));
//					bean.setGuaranty_money(rs.getString("guaranty_money"));
					
					list.add(bean);

									
				}
				rs.close();
				pstmt.close();
				con.close();
				

			}catch(SQLException e){
				System.out.println("datebase error");
					
			}catch(Exception e){
			    e.printStackTrace();
			    
		    } finally {
		    	if (rs != null) {

	    			try {
						rs.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
	    	} if (pstmt != null) {
	    		
	    		try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
	    	} if (con != null) {
	    		
	    		DBConnectionMgr.getInstance().freeConnection(con);
	    	}
	    }

			return list;
		
		}
//	 /**
//	  * db:room_infoからセレクトするメソッドド
//	  * @return ArraList
//	  */
//	 public ArrayList <HouseInfo>getList(int start, int num, String area,String houseSort, String houseFee, String searchDate) {
//			
//		    Connection con= null;
//		    PreparedStatement pstmt = null;
//		    ResultSet rs = null;
//		    System.out.println("------database +houselist start-------");
//		    //StringBuffer mainArea = new StringBuffer();
//	 
//		    String where = "";
//		    
//		    UtilHandler whereList =new UtilHandler();
//		    
//			ArrayList<HouseInfo> list = new ArrayList<HouseInfo>();
//			
//			ArrayList sqlWhere = new ArrayList();
//			
//			if(area != null || houseSort != null || houseFee != null || searchDate != null){
//				
//				houseFee=whereList.getHouseFee(houseFee);
//			
//				sqlWhere = whereList.getWhereList(area, houseSort, houseFee, searchDate);
//			
//				where = whereList.getArea1Info1(sqlWhere);
//				
////				System.out.println("Quick houseFee="+where);
//			}
//			
//			try{
//				
//				con = DBConnectionMgr.getInstance().getConnection();
//				
//				StringBuffer sb = new StringBuffer();
//				
//				String strSql = "";
//					
//				sb.append("select * from house_info ");
//					
//				sb.append(where);
//					
//				sb.append(" order by id desc limit ?,?");
//					
//				strSql = sb.toString();
//				
//				pstmt=con.prepareStatement(strSql);
//				
//				pstmt.setInt(1, start-1);
//				
//				pstmt.setInt(2, num);
//				
//				
//				rs=pstmt.executeQuery();
//				
//				while(rs.next()){
//
//					HouseInfo bean = new HouseInfo();
//					
//					bean.setId(rs.getInt("id"));
//					bean.setTitle(rs.getString("title"));
//					bean.setHouseName(rs.getString("house_name"));
//					bean.setDetailInfo(rs.getString("detail_info"));
//					bean.setManageFee(rs.getString("manage_fee"));
//					bean.setHouseSort(rs.getString("house_sort"));
//					bean.setDimension(rs.getString("dimension"));
//					bean.setHouseFee(rs.getString("house_fee"));
//					bean.setDeposit(rs.getString("deposit"));
//					bean.setReikin(rs.getString("reikin"));
//					bean.setWalkTime(rs.getString("walk_time"));
//					bean.setBuildYear(rs.getString("build_year"));
//					bean.setBuild_month(rs.getString("build_month"));
//					bean.setMadori(rs.getString("madori"));				
//					bean.setAllStairs(rs.getString("all_stairs"));
//					bean.setStairs(rs.getString("stairs"));
//					bean.setFlgTadami(rs.getString("flg_tadami"));
//					bean.setToilet(rs.getString("toilet"));
//					bean.setLineCode(rs.getString("line_code"));
//					bean.setStationCode(rs.getString("station_code"));
//					bean.setPhotoName1(rs.getString("photo_name1"));
//					bean.setPhotoName2(rs.getString("photo_name2"));
//					bean.setPhotoName3(rs.getString("photo_name3"));
//					bean.setPhotoName4(rs.getString("photo_name4"));
//					bean.setPhotoName5(rs.getString("photo_name5"));
//					bean.setAreaCode1(rs.getString("area_code_1"));
//					bean.setAreaCode2(rs.getString("area_code_2"));
//					bean.setAreaFast(rs.getString("area_fast"));
//					bean.setMainArea(rs.getString("main_area"));
//					bean.setUserId(rs.getString("user_id"));
//					bean.setEmail(rs.getString("email"));
//					bean.setTelephone(rs.getString("telephone"));
//					bean.setRegistDate(rs.getDate("regist_date"));
//					bean.setUpdateDate(rs.getDate("update_date"));
//					bean.setReadCount(rs.getInt("read_count"));
//					bean.setAreaCode3(rs.getString("area_code_3"));
//			
//					list.add(bean);
//
//									
//				}
//				rs.close();
//				pstmt.close();
//				con.close();
//				
//
//			}catch(SQLException e){
//				System.out.println("datebase error");
//				System.out.println("error message:"+e.getMessage());
//					
//			}catch(Exception e){
//			    e.printStackTrace();
//			    
//		    }
//
//			return list;
//		
//		}
//	 
//	 public HouseInfo getHouseInfo(int id){
//		    Connection con= null;
//		    PreparedStatement pstmt = null;
//		    ResultSet rs = null;
//		    System.out.println("------database +houseinfo start-------");
//		    HouseInfo bean = new HouseInfo();
//			try{
//				
//				con = DBConnectionMgr.getInstance().getConnection();
//					
//				String strSql= "select * from house_info where id = ?";
//				
//				pstmt=con.prepareStatement(strSql);
//				
//				pstmt.setInt(1, id);
//				
//				rs=pstmt.executeQuery();
//				while(rs.next()){
//				
//				bean.setId(rs.getInt("id"));
//				bean.setTitle(rs.getString("title"));
//				bean.setHouseName(rs.getString("house_name"));
//				bean.setDetailInfo(rs.getString("detail_info"));
//				bean.setManageFee(rs.getString("manage_fee"));
//				bean.setHouseSort(rs.getString("house_sort"));
//				bean.setDimension(rs.getString("dimension"));
//				bean.setHouseFee(rs.getString("house_fee"));
//				bean.setDeposit(rs.getString("deposit"));
//				bean.setReikin(rs.getString("reikin"));
//				bean.setWalkTime(rs.getString("walk_time"));
//				bean.setBuildYear(rs.getString("build_year"));
//				bean.setBuild_month(rs.getString("build_month"));
//				bean.setMadori(rs.getString("madori"));				
//				bean.setAllStairs(rs.getString("all_stairs"));
//				bean.setStairs(rs.getString("stairs"));
//				bean.setFlgTadami(rs.getString("flg_tadami"));
//				bean.setToilet(rs.getString("toilet"));
//				bean.setLineCode(rs.getString("line_code"));
//				bean.setStationCode(rs.getString("station_code"));
//				bean.setPhotoName1(rs.getString("photo_name1"));
//				bean.setPhotoName2(rs.getString("photo_name2"));
//				bean.setPhotoName3(rs.getString("photo_name3"));
//				bean.setPhotoName4(rs.getString("photo_name4"));
//				bean.setPhotoName5(rs.getString("photo_name5"));
//				bean.setAreaCode1(rs.getString("area_code_1"));
//				bean.setAreaCode2(rs.getString("area_code_2"));
//				bean.setAreaFast(rs.getString("area_fast"));
//				bean.setMainArea(rs.getString("main_area"));
//				bean.setUserId(rs.getString("user_id"));
//				bean.setEmail(rs.getString("email"));
//				bean.setTelephone(rs.getString("telephone"));
//				bean.setRegistDate(rs.getDate("regist_date"));
//				bean.setUpdateDate(rs.getDate("update_date"));
//				bean.setReadCount(rs.getInt("read_count"));
//				bean.setAreaCode3(rs.getString("area_code_3"));
//				bean.setPoint_compass(rs.getString("point_compass"));
//				bean.setCome_dock(rs.getString("come_dock"));
//				bean.setCome_dock_year(rs.getString("come_dock_year"));
//				bean.setCome_dock_month(rs.getString("come_dock_month"));
//				bean.setGuaranty_money(rs.getString("guaranty_money"));
//				bean.setMadori_info(rs.getString("madori_info"));
//				}
//				
//				rs.close();
//				pstmt.close();
//				con.close();
//
//
//		}catch(SQLException e){
//			System.out.println("datebase error");
//			System.out.println("error message:"+e.getMessage());
//				
//		}catch(Exception e){
//		    e.printStackTrace();
//		    
//	    }
//
//		return bean;
//	 }
//	 
	 
	 /**
	  * db:house_infoのidからハウス情報を削除するメソッド
	  * @return boolean
	  */ 	 
	 public boolean delete(int id){
			Connection con= null;
			PreparedStatement pstmt = null;
			System.out.println("------database house Delete start-------");
			try{
				
				con = DBConnectionMgr.getInstance().getConnection();
					
				String strSql= "DELETE FROM house_info WHERE ID= ?";
				
				pstmt=con.prepareStatement(strSql);
				
				pstmt.setInt(1, id);
				
				int result = pstmt.executeUpdate();
				if(result==1){
				
				return true;
				}
				
		    }catch (Exception e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
				System.out.println("error message:"+e.getMessage());
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
	  * db:room_infoからセレクトする命令
	  * @return ArraList
	  */
	 public int getInfoCount(){
			
		    Connection con= null;
		    PreparedStatement pstmt = null;
		    ResultSet rs = null;
		    int count = 0;
			
			
			try{
				con = DBConnectionMgr.getInstance().getConnection();
					
				String strSql= "select count(*) from housefind_info";
				
				pstmt=con.prepareStatement(strSql);
				
				rs=pstmt.executeQuery();
				
				if(rs.next()){
					
					count = rs.getInt(1);				
				}
				
			}catch(SQLException e){
				System.out.println("datebase error");
				System.out.println("error message:"+e.getMessage());
					
			}catch(Exception e){
			    e.printStackTrace();
			    
		    } finally {
		    	if (rs != null) {

		    			try {
							rs.close();
						} catch (SQLException e) {
							e.printStackTrace();
						}
		    	}
		    	if (pstmt != null) {
		    		
		    		try {
						pstmt.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
		    	}
		    	if (con != null) {
		    		
		    		DBConnectionMgr.getInstance().freeConnection(con);
		    	}
		    }

			return count;
		
		}
//		/**
//		 * db:room_infoからセレクトする命令
//		 * 
//		 * @return ArraList
//		 */
//		public int getInfoCount(SearchHouseBean bean) {
//
//			Connection con = null;
//			PreparedStatement pstmt = null;
//			ResultSet rs = null;
//			System.out.println("------database +count start-------");
//			int count = 0;
//
//			try {
//				con = DBConnectionMgr.getInstance().getConnection();
//				StringBuffer sb = new StringBuffer();
//				sb.append("select count(*) from house_info");			
//				UtilHandler util = new UtilHandler();
//				//TODO　getWhereListを後で修正する
//				sb.append(util.getWhereList(bean));
//				KankokujinLogger.getInstance().debug("getInfoCount" + sb.toString());
//				pstmt = con.prepareStatement(sb.toString());
//
//				rs = pstmt.executeQuery();
//
//				if (rs.next()) {
//
//					count = rs.getInt(1);
//				}
//
//			} catch (SQLException e) {
//				System.out.println("datebase error");
//				System.out.println("error message:" + e.getMessage());
//
//			} catch (Exception e) {
//				e.printStackTrace();
//
//			} finally {
//				if (rs != null) {
//
//					try {
//						rs.close();
//					} catch (SQLException e) {
//						e.printStackTrace();
//					}
//				}
//				if (pstmt != null) {
//
//					try {
//						pstmt.close();
//					} catch (SQLException e) {
//						e.printStackTrace();
//					}
//				}
//				if (con != null) {
//
//					try {
//						con.close();
//					} catch (SQLException e) {
//						e.printStackTrace();
//					}
//				}
//			}
//
//			return count;
//
//		}
//	 public boolean readCount(HouseInfo bean){
//		    Connection con= null;
//		    PreparedStatement pstmt = null;
//		    System.out.println("------database +readCount start-------");
//		    try{
//				
//				con = DBConnectionMgr.getInstance().getConnection();
//				
//				String strSql =  "UPDATE house_info SET read_count = ? +'"+1+"' where id='"+ bean.getId()+"'";
//					
//				pstmt=con.prepareStatement(strSql);
//				
//				pstmt.setInt(1, bean.getReadCount());
//				
//				int result = pstmt.executeUpdate();
//				if(result==1){
//				
//					return true;
//				}
//				
//		    }catch (Exception e) {
//				// TODO 自動生成された catch ブロック
//				e.printStackTrace();
//				System.out.println("error message:"+e.getMessage());
//				DBConnectionMgr.getInstance().freeConnection(con);
//			} finally {
//				if (pstmt != null)
//					try {
//						pstmt.close();
//					} catch (SQLException e) {
//					}
//				if (con != null) {
//					DBConnectionMgr.getInstance().freeConnection(con);
//				}
//			}
//			return false;	
//		 
//	 }
//	 
//	 public ArrayList <HouseInfo>getQuickList(String area, String houseSort, String houseFee, Date searchDate){
//		    Connection con= null;
//		    PreparedStatement pstmt = null;
//		    ResultSet rs = null;
//		    System.out.println("------database +houselist start-------");
//		    
//			ArrayList<HouseInfo> list = new ArrayList<HouseInfo>();
//			
//			try{
//				
//				con = DBConnectionMgr.getInstance().getConnection();
//					
//				if(area != null && houseSort == null && houseFee == null && searchDate == null){
//				
//					String strSql= "select * from house_info where area_fast = ?";
//				
//					pstmt=con.prepareStatement(strSql);
//				
//					pstmt.setString(1, area);
//				
//				}else{
//					if(area != null && houseSort != null && houseFee == null && searchDate == null){
//						
//						String strSql= "select * from house_info where area_fast = ? AND house_sort = ?";
//						
//						pstmt=con.prepareStatement(strSql);
//					
//						pstmt.setString(1, area);
//						pstmt.setString(2, houseSort);
//					}else{
//						if(area != null && houseSort != null && houseFee != null && searchDate == null){
//							String strSql= "select * from house_info where area_fast = ? AND house_sort = ? AND house_fee = ?";
//							
//							pstmt=con.prepareStatement(strSql);
//						
//							pstmt.setString(1, area);
//							pstmt.setString(2, houseSort);
//							pstmt.setString(3, houseFee);
//						}else{
//							if(area != null && houseSort != null && houseFee != null && searchDate != null){
//								String strSql= "select * from house_info where area_fast = ? AND house_sort = ? AND house_fee = ? AND regist_date = ?";
//								
//								pstmt=con.prepareStatement(strSql);
//							
//								pstmt.setString(1, area);
//								pstmt.setString(2, houseSort);
//								pstmt.setString(3, houseFee);
//								pstmt.setDate(4, searchDate);
//							}
//						}
//					}
//				}
//				
//				rs=pstmt.executeQuery();
//				
//				while(rs.next()){
//
//					HouseInfo bean = new HouseInfo();
//					
//					bean.setId(rs.getInt("id"));
//					bean.setTitle(rs.getString("title"));
//					bean.setHouseName(rs.getString("house_name"));
//					bean.setDetailInfo(rs.getString("detail_info"));
//					bean.setManageFee(rs.getString("manage_fee"));
//					bean.setHouseSort(rs.getString("house_sort"));
//					bean.setDimension(rs.getString("dimension"));
//					bean.setHouseFee(rs.getString("house_fee"));
//					bean.setDeposit(rs.getString("deposit"));
//					bean.setReikin(rs.getString("reikin"));
//					bean.setWalkTime(rs.getString("walk_time"));
//					bean.setBuildYear(rs.getString("build_year"));
//					bean.setMadori(rs.getString("madori"));				
//					bean.setAllStairs(rs.getString("all_stairs"));
//					bean.setStairs(rs.getString("stairs"));
//					bean.setFlgTadami(rs.getString("flg_tadami"));
//					bean.setToilet(rs.getString("toilet"));
//					bean.setLineCode(rs.getString("line_code"));
//					bean.setStationCode(rs.getString("station_code"));
//					bean.setPhotoName1(rs.getString("photo_name1"));
//					bean.setPhotoName2(rs.getString("photo_name2"));
//					bean.setPhotoName3(rs.getString("photo_name3"));
//					bean.setPhotoName4(rs.getString("photo_name4"));
//					bean.setPhotoName5(rs.getString("photo_name5"));
//					bean.setAreaCode1(rs.getString("area_code_1"));
//					bean.setAreaCode2(rs.getString("area_code_2"));
//					bean.setMainArea(rs.getString("main_area"));
//					bean.setUserId(rs.getString("user_id"));
//					bean.setEmail(rs.getString("email"));
//					bean.setTelephone(rs.getString("telephone"));
//					bean.setRegistDate(rs.getDate("regist_date"));
//					bean.setUpdateDate(rs.getDate("update_date"));
//					bean.setReadCount(rs.getInt("read_count"));
//					bean.setAreaCode3(rs.getString("area_code_3"));
//					
//					list.add(bean);
//
//									
//				}
//				rs.close();
//				pstmt.close();
//				con.close();
//				
//
//			}catch(SQLException e){
//				System.out.println("datebase error");
//				System.out.println("error message:"+e.getMessage());
//					
//			}catch(Exception e){
//			    e.printStackTrace();
//			    
//		    }
//
//			return list;
//		
//		}
//	 
//	 public String areaName_1(String area_code1){
//			Connection con = null;
//			PreparedStatement pstmt = null;
//			ResultSet rs = null;
//			String area_name = "";
//
//			try {
//
//				con = DBConnectionMgr.getInstance().getConnection();
//
//				String strSql = "select area_name_1 from t_area where area_code_1 ='" + area_code1 + "'";
//
//				pstmt = con.prepareStatement(strSql);
//
//				rs = pstmt.executeQuery();
//
//				while (rs.next()) {
//					AreaBean bean = new AreaBean();
//					bean.setArea_name_1(rs.getString("area_name_1"));
//					area_name = EnDecoding.decoding(bean.getArea_name_1());
//
//				}
//
//			} catch (SQLException e) {
//				e.printStackTrace();
//
//			} catch (Exception e) {
//				e.printStackTrace();
//
//			} finally {
//				if (rs != null) {
//					try {
//						rs.close();
//					} catch (SQLException e) {
//						// TODO 自動生成された catch ブロック
//						e.printStackTrace();
//					}
//				}
//				if (pstmt != null) {
//					try {
//						pstmt.close();
//					} catch (SQLException e) {
//						// TODO 自動生成された catch ブロック
//						e.printStackTrace();
//					}
//				}
//				if (con != null) {
//					try {
//						con.close();
//					} catch (SQLException e) {
//						// TODO 自動生成された catch ブロック
//						e.printStackTrace();
//					}
//				}
//			}
//			return area_name;
//	 }
//	 
	 
	 public String areaName_2(String area_code_1, String area_code_2){
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String area_name_2 = "";

			try {

				con = DBConnectionMgr.getInstance().getConnection();

				String strSql = "select area_name_2 from t_area where area_code_1 ='" + area_code_1 + "' and area_code_2 ='" + area_code_2 + "'";

				pstmt = con.prepareStatement(strSql);

				rs = pstmt.executeQuery();

				while (rs.next()) {
					AreaBean bean = new AreaBean();
					bean.setArea_name_2(rs.getString("area_name_2"));
					area_name_2 = EnDecoding.decoding(bean.getArea_name_2());

				}

			} catch (SQLException e) {
				e.printStackTrace();

			} catch (Exception e) {
				e.printStackTrace();

			} finally {
				if (rs != null) {
					try {
						rs.close();
					} catch (SQLException e) {
						// TODO 自動生成された catch ブロック
						e.printStackTrace();
					}
				}
				if (pstmt != null) {
					try {
						pstmt.close();
					} catch (SQLException e) {
						// TODO 自動生成された catch ブロック
						e.printStackTrace();
					}
				}
				if (con != null) {
					DBConnectionMgr.getInstance().freeConnection(con);
				}
			}
			return area_name_2;
	 }
	 
	 public String getLineName(String line_code){
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String line_name = "";

			try {

				con = DBConnectionMgr.getInstance().getConnection();

				String strSql = "select line_kanji from t_train where line_code ='" + line_code + "'";

				pstmt = con.prepareStatement(strSql);

				rs = pstmt.executeQuery();

				while (rs.next()) {
					TrainBean bean = new TrainBean();
					bean.setLine_kanji(rs.getString("line_kanji"));
					line_name = EnDecoding.decoding(bean.getLine_kanji());

				}

			} catch (SQLException e) {
				e.printStackTrace();

			} catch (Exception e) {
				e.printStackTrace();

			} finally {
				if (rs != null) {
					try {
						rs.close();
					} catch (SQLException e) {
						// TODO 自動生成された catch ブロック
						e.printStackTrace();
					}
				}
				if (pstmt != null) {
					try {
						pstmt.close();
					} catch (SQLException e) {
						// TODO 自動生成された catch ブロック
						e.printStackTrace();
					}
				}
				if (con != null) {
					DBConnectionMgr.getInstance().freeConnection(con);
				}
			}
			return line_name;
	 }
	 
	 
	 public String getStationName(String line_code, String station_code){
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String station_name = "";

			try {

				con = DBConnectionMgr.getInstance().getConnection();

				String strSql = "select station_kanji from t_train where line_code ='" + line_code + "' and station_code ='" + station_code + "'";

				pstmt = con.prepareStatement(strSql);

				rs = pstmt.executeQuery();

				while (rs.next()) {
					TrainBean bean = new TrainBean();
					bean.setStation_kanji(rs.getString("station_kanji"));
					station_name = EnDecoding.decoding(bean.getStation_kanji());

				}

			} catch (SQLException e) {
				e.printStackTrace();

			} catch (Exception e) {
				e.printStackTrace();

			} finally {
				if (rs != null) {
					try {
						rs.close();
					} catch (SQLException e) {
						// TODO 自動生成された catch ブロック
						e.printStackTrace();
					}
				}
				if (pstmt != null) {
					try {
						pstmt.close();
					} catch (SQLException e) {
						// TODO 自動生成された catch ブロック
						e.printStackTrace();
					}
				}
				if (con != null) {
					DBConnectionMgr.getInstance().freeConnection(con);
				}
			}
			return station_name;
	 }
	 
	 public String stationName(String line_code, String station_code){
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String station_name = "";

			try {

				con = DBConnectionMgr.getInstance().getConnection();

				String strSql = "select station_kanji from t_train where station_code ='" + station_code + "' and line_code ='" + line_code + "'";

				pstmt = con.prepareStatement(strSql);

				rs = pstmt.executeQuery();

				while (rs.next()) {
					station_name = EnDecoding.decoding(rs.getString("station_kanji"));
				}

			} catch (SQLException e) {
				e.printStackTrace();

			} catch (Exception e) {
				e.printStackTrace();

			} finally {
				if (rs != null) {
					try {
						rs.close();
					} catch (SQLException e) {
						// TODO 自動生成された catch ブロック
						e.printStackTrace();
					}
				}
				if (pstmt != null) {
					try {
						pstmt.close();
					} catch (SQLException e) {
						// TODO 自動生成された catch ブロック
						e.printStackTrace();
					}
				}
				if (con != null) {
					DBConnectionMgr.getInstance().freeConnection(con);
				}
			}
			return station_name;
		}


		public String trainName(String line_code){
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String train_line = "";

			try {

				con = DBConnectionMgr.getInstance().getConnection();

				String strSql = "select line_kanji from t_train where line_code ='" + line_code + "'";

				pstmt = con.prepareStatement(strSql);

				rs = pstmt.executeQuery();

				while (rs.next()) {
					train_line = EnDecoding.decoding(rs.getString("line_kanji"));
				}

			} catch (SQLException e) {
				e.printStackTrace();

			} catch (Exception e) {
				e.printStackTrace();

			} finally {
				if (rs != null) {
					try {
						rs.close();
					} catch (SQLException e) {
						// TODO 自動生成された catch ブロック
						e.printStackTrace();
					}
				}
				if (pstmt != null) {
					try {
						pstmt.close();
					} catch (SQLException e) {
						// TODO 自動生成された catch ブロック
						e.printStackTrace();
					}
				}
				if (con != null) {
					DBConnectionMgr.getInstance().freeConnection(con);
				}
				
			}
			return train_line;
		}
		
	 
}

