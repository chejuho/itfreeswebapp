package item.handler;

import item.bean.ItemBean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

import common.database.DBConnectionMgr;
import common.exception.AppException;
import common.util.EnDecoding;


/**
 * MemberのDBHANDLER
 * 
 * @author KSH
 * @since 2007.07
 * @ver 1.0.0
 */
public class ItemHandler {

	/**
	 * USER_IDを使ってMemberのDELETEする命令
	 * 
	 * @return boolean
	 */
	public boolean deleteItem(String itemCode) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = DBConnectionMgr.getInstance().getConnection();
			pstmt = con.prepareStatement("delete from t_item where item_code=?");
			pstmt.setString(1, itemCode);

			int result = pstmt.executeUpdate();
			if (result == 1) {
				return true;
			}

		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();

			DBConnectionMgr.getInstance().freeConnection(con);
		} finally {
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException ex) {
				}
			if (con != null) {
				DBConnectionMgr.getInstance().freeConnection(con);
			}
		}
		return false;
	}

	// update level3 set

	/*
	 *//**
		 * MemberのINSERTする命令
		 * 
		 * @return void
		 */
	/*
	 * public boolean changeProduct(ProductForm productForm) throws SQLException {
	 * Connection conn = null; PreparedStatement pstmt = null;
	 * 
	 * pool = new DBConnectionMgr(); try { conn = pool.getConnection();
	 * 
	 * pstmt = conn .prepareStatement("update t_product set ?,?,?,?,?,? where
	 * ?"); pstmt.setString(1, productForm.getCate_code()); pstmt.setString(2,
	 * productForm.getProduct_code()); pstmt.setString(3,
	 * productForm.getProduct_name()); pstmt.setString(4,
	 * productForm.getCompany()); pstmt.setString(5, productForm.getNation());
	 * pstmt.setString(6, productForm.getContents()); pstmt.setString(7,
	 * productForm.getPrice());
	 * 
	 * pstmt.executeUpdate(); System.out.println("db?:"
	 * +productForm.getCate_code()); return true; } catch (Exception e) { //
	 * TODO 自動生成された catch ブロック e.printStackTrace(); } finally { if (pstmt !=
	 * null) try { pstmt.close(); } catch (SQLException e) { } if (conn != null)
	 * try { conn.close(); } catch (SQLException e) { } } return false; }
	 * 
	 */

	/**
	 * USER_IDを使ってMemberのUPDATEする命令
	 * 
	 * @return boolean
	 */
	public boolean changeItem(ItemBean ItemForm) {
		Connection con = null;
		Statement st = null;
		int result = 0;

		String cate_code = ItemForm.getCate_code();
		
		String itemCode = ItemForm.getItem_code();
		
		//String product_name = ItemForm.getProduct_name();
		//System.out.println("[ DB ] product_name :" + product_name);
		//String company = ItemForm.getCompany();
		//System.out.println("[ DB ] company :" + company);
		//String nation = ItemForm.getNation();
		//System.out.println("[ DB ] nation :" + nation);
		String contents = ItemForm.getContents();
		System.out.println("[ DB ] contents :" + contents);
		//String price = ItemForm.getPrice();
		//System.out.println("[ DB ] price :" + price);
		String file = ItemForm.getFile();
		System.out.println("[ DB ] file :" + file);
//		String permission = ItemForm.getPermission();
//		System.out.println("[ DB ] permission :" + permission);
		String query = "";

		try {
			con = DBConnectionMgr.getInstance().getConnection();
			st = con.createStatement();

			query = "update t_item set cate_code='" + cate_code	+ 
					"' , col01='" + ItemForm.getCol01() + 
					"' , col02='" + ItemForm.getCol02() +
					"' , col03='" + ItemForm.getCol03() +
					"' , col04='" + ItemForm.getCol04() +
					"' , col05='" + ItemForm.getCol05() +
					"' , col06='" + ItemForm.getCol06() +
					"' , col07='" + ItemForm.getCol07() +
					"' , col08='" + ItemForm.getCol08() +
					"' , col09='" + ItemForm.getCol09() +
					"' , col10='" + ItemForm.getCol10() +
					"' , col11='" + ItemForm.getCol11() + 
					"' , col12='" + ItemForm.getCol12() +
					"' , col13='" + ItemForm.getCol13() +
					"' , col14='" + ItemForm.getCol14() +
					"' , col15='" + ItemForm.getCol15() +
					"' , col16='" + ItemForm.getCol16() +
					"' , col17='" + ItemForm.getCol17() +
					"' , col18='" + ItemForm.getCol18() +
					"' , col19='" + ItemForm.getCol19() +
					"' , col20='" + ItemForm.getCol20() +					
					
					
					"' , code='"	+ ItemForm.getCode() + 
					"' , item_code='" + ItemForm.getItem_code() + 
					"' , contents='"+ contents + 
					"' , update_date=sysdate() " + 
					", file='" + file	+					
					//"', permission='" + permission + 
					"' where item_code='"
					+ itemCode + "'";

			result = st.executeUpdate(query);

			if (result == 1) {
				System.out.println("update success");
				return true;
			}

		} catch (Exception e) {
			System.out.println(e);
			DBConnectionMgr.getInstance().freeConnection(con);
		} finally {
			if (st != null) {
				try {
					st.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (con != null) {
				DBConnectionMgr.getInstance().freeConnection(con);
			}
		}
		System.out.println("update fail");
		return false;
	}

	/*    
	 *//**
		 * beanｰｪﾀｻ ﾅ?ﾇﾘ ﾄｮｹｮﾀﾇ ｹ?ｷｪｿ｡ ｳﾖｾ? ｾ･ﾀﾌﾆｮﾇﾏｴﾂ ｸﾞｼﾒｵ?
		 * 
		 * @Param UserInfoﾀﾇ
		 *            beanｰｪ
		 * @return true
		 */
	/*
	 * public boolean changeProduct (ProductForm productForm) throws
	 * SQLException { ProductHandler handler = new ProductHandler(); pool = new
	 * DBConnectionMgr(); conn = pool.getConnection(); Statement st = null; int
	 * rs2 = 0;
	 * 
	 * String num = bean.getNum(); String name = bean.getName(); String pos =
	 * bean.getPos(); String rec = bean.getRec(); String tech = bean.getTech();
	 * String webs = bean.getWebs(); String db = bean.getDb(); String time =
	 * bean.getTime(); String tool = bean.getTool(); String date =
	 * bean.getDate();
	 * 
	 * 
	 * String query = ""; try { st = con.createStatement(); //query = "update
	 * test set pwd='" + pwd + "' where id='" + id + "'"; query = "update level3
	 * set cate_code='" + cate_code + "' , product_name='" + product_name + "' ,
	 * company='" + company + "' , nation='" + nation + "' , contents='" +
	 * contents + "' , price='" + price + "' where cate_code='" + cate_code +
	 * "'"; rs2 = st.executeUpdate(query);
	 * 
	 * if(rs2==1){ return true; } } catch(Exception e) { System.out.println(e); }
	 * finally { try { con.close(); System.out.println("ｿｬｰ盖｡"); } catch
	 * (SQLException e) { // TODO ﾀﾚｵｿ ｻ?ｼｺｵﾈ catch ｺ昞ﾏ e.printStackTrace(); } }
	 * return false; }
	 */
	public String makeProductCode(String cate_code) {

		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		String query = "";
		System.out.println("cate_code=" + cate_code);
		try {
			query = "select max(product_code) as p_code from t_product where cate_code = ?";
			con = DBConnectionMgr.getInstance().getConnection();
			rs = stmt.executeQuery(query);
			String c_code = rs.getString("p_code");
			System.out.println(c_code);
			if (rs.next()) {
				String temp = rs.getString("cate_code");
				System.out.println("cate_1 = " + temp);
				if (temp == null) {
					temp = "0";
				}
				int cate1max = Integer.parseInt(temp);
				int cate1maxup = cate1max + 1;

				if (cate1maxup < 10) {
					String p_code = "000" + cate1maxup;
					return p_code;
				} else if (cate1maxup < 100) {
					String p_code = "00" + cate1maxup;
					return p_code;
				} else if (cate1maxup < 1000) {
					String p_code = "0" + cate1maxup;
					return p_code;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (stmt != null)
				try {
					stmt.close();
				} catch (SQLException e) {
				}
			if (con != null) {
				DBConnectionMgr.getInstance().freeConnection(con);
			}
		}
		return null;
	}

	/**
	 * ProductのINSERTする命令
	 * 
	 * @return void
	 */
	public boolean insertItem(ItemBean itemForm) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = DBConnectionMgr.getInstance().getConnection();
			pstmt = con
					.prepareStatement("insert into t_item (col01, col02, col03, col04, col05, col06, col07, col08, col09, col10," +
							" col11, col12, col13, col14, col15, col16, col17, col18, col19, col20," +
							" code, cate_code, contents, file, insert_date, update_date, user_id" +							
							") values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, " +
							"?, ?, ?, ?, ?, ?, ?, ?, ?, ?, " +
							"?, ?, ?, ?," +
							"sysdate(), sysdate(),?)");
			
			pstmt.setString(1, nullToStr(itemForm.getCol01()));
			pstmt.setString(2, nullToStr(itemForm.getCol02()));
			pstmt.setString(3, nullToStr(itemForm.getCol03()));
			pstmt.setString(4, nullToStr(itemForm.getCol04()));
			pstmt.setString(5, nullToStr(itemForm.getCol05()));
			pstmt.setString(6, nullToStr(itemForm.getCol06()));
			pstmt.setString(7, nullToStr(itemForm.getCol07()));
			pstmt.setString(8, nullToStr(itemForm.getCol08()));
			pstmt.setString(9, nullToStr(itemForm.getCol09()));
			pstmt.setString(10, nullToStr(itemForm.getCol10()));
			pstmt.setString(11, nullToStr(itemForm.getCol11()));
			pstmt.setString(12, nullToStr(itemForm.getCol12()));
			pstmt.setString(13, nullToStr(itemForm.getCol13()));
			pstmt.setString(14, nullToStr(itemForm.getCol14()));
			pstmt.setString(15, nullToStr(itemForm.getCol15()));
			pstmt.setString(16, nullToStr(itemForm.getCol16()));
			pstmt.setString(17, nullToStr(itemForm.getCol17()));
			pstmt.setString(18, nullToStr(itemForm.getCol18()));
			pstmt.setString(19, nullToStr(itemForm.getCol19()));
			pstmt.setString(20, nullToStr(itemForm.getCol20()));
			
			pstmt.setString(21, nullToStr(itemForm.getCode()));			
			pstmt.setString(22, nullToStr(itemForm.getCate_code()));			
			pstmt.setString(23, nullToStr(itemForm.getContents()));
			pstmt.setString(24, nullToStr(itemForm.getFile()));			
			pstmt.setString(25, nullToStr(itemForm.getUser_id()));

			pstmt.executeUpdate();
			System.out.println("db?:" + itemForm.getCate_code());
			return true;

		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
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

	/*	
	 *//**
		 * ProductのINSERTする命令
		 * 
		 * @return void
		 */
	/*
	 * public void insertProduct(ProductForm productForm) throws
	 * MemberManagerException { Connection conn = null; PreparedStatement pstmt =
	 * null;
	 * 
	 * pool = new DBConnectionMgr(); try { conn = pool.getConnection();
	 * System.out.println("insertProduct conn:" + conn); pstmt =
	 * conn.prepareStatement("insert into t_product values ('" +
	 * productForm.getCate_code() + "','" + productForm.getProduct_code() +
	 * "','" + productForm.getProduct_name() + "','" + productForm.getCompany() +
	 * "','" + productForm.getNation() + "','" + productForm.getContents() +
	 * "','" + productForm.getPrice() + "')");
	 * 
	 * pstmt.executeUpdate(); System.out.println("insertProduct pstmt:" +
	 * pstmt); } catch (Exception e) { // TODO 自動生成された catch ブロック
	 * e.printStackTrace(); } finally { if (pstmt != null) try { pstmt.close(); }
	 * catch (SQLException e) { } if (conn != null) try { conn.close(); } catch
	 * (SQLException e) { } } }
	 */

	/**
	 * DBの命令 ++++++++++++++
	 * 
	 * @return list
	 */
	public ArrayList<ItemBean> getItemList(String code, String cate_code, String userId)
			throws SQLException {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<ItemBean> list = new ArrayList<ItemBean>();

		StringBuffer query = new StringBuffer();
		try {
			con = DBConnectionMgr.getInstance().getConnection();
			stmt = con.createStatement();
			query.append("select * from t_item where code ='");
			query.append(code);
			query.append("'");			
			if (!"".equals(cate_code)) {
				query.append(" and cate_code ='");
				query.append(cate_code);
				query.append("'");			
			} 
			if (userId != null && !"".equals(userId)) {
				query.append(" and user_id ='");
				query.append(userId);
				query.append("'");
				
			} 
			query.append(" order by update_date desc");		

			rs = stmt.executeQuery(query.toString());

			while (rs.next()) {
				ItemBean ItemForm = new ItemBean();
				ItemForm.setCol01(rs.getString("col01"));
				ItemForm.setCol02(rs.getString("col02"));
				ItemForm.setCol03(rs.getString("col03"));
				ItemForm.setCol04(rs.getString("col04"));
				ItemForm.setCol05(rs.getString("col05"));
				ItemForm.setCol06(rs.getString("col06"));
				ItemForm.setCol07(rs.getString("col07"));
				ItemForm.setCol08(rs.getString("col08"));
				ItemForm.setCol09(rs.getString("col09"));
				ItemForm.setCol10(rs.getString("col10"));
				ItemForm.setCol11(rs.getString("col11"));
				ItemForm.setCol12(rs.getString("col12"));
				ItemForm.setCol13(rs.getString("col13"));
				ItemForm.setCol14(rs.getString("col14"));
				ItemForm.setCol15(rs.getString("col15"));
				ItemForm.setCol16(rs.getString("col16"));
				ItemForm.setCol17(rs.getString("col17"));
				ItemForm.setCol18(rs.getString("col18"));
				ItemForm.setCol19(rs.getString("col19"));
				ItemForm.setCol20(rs.getString("col20"));
				ItemForm.setItem_code(rs.getString("item_code"));
				ItemForm.setCate_code(rs.getString("cate_code"));
				ItemForm.setCode(rs.getString("code"));
				ItemForm.setFile(rs.getString("file"));
				ItemForm.setUpdate_date(rs.getString("update_date"));			
				ItemForm.setUser_id(rs.getString("user_id"));
				ItemForm.setContents(rs.getString("contents"));
				
//				String userid = rs.getString("user_id");
//				
//				ConfidenceHandler ch = new ConfidenceHandler();
//				productForm.setFree(ch.getConfSum(userid,3));
//				productForm.setFree2(ch.getConfSum(product_code,2));
				list.add(ItemForm);
			}
		} catch (Exception e) {
			e.printStackTrace();
			DBConnectionMgr.getInstance().freeConnection(con, stmt, rs);
		} finally {
			DBConnectionMgr.getInstance().freeConnection(con, stmt, rs);
		}
		return list;
	}
	
	/**
	 * DBの命令
	 * 
	 * @return list
	 */
	public String getViewListTag(String cateCode, List list) {
		StringBuffer sb = new StringBuffer();
		sb.append("<table border='0'>");
		sb.append("	<tr align='center'>");
		sb.append("		<td>商品コード</td>");
		sb.append("		<td>商品名</td>");
		sb.append("		<td>製造社</td>");
		sb.append("		<td>原産地</td>");
		sb.append("		<td>価格</td>");
		//sb.append("		<td>イメージ</td>");
		//sb.append("		<td></td>");
		sb.append("	</tr>");
		
		Iterator it = list.iterator();
		while (it.hasNext()) {
			ItemBean ItemForm = (ItemBean)it.next();
			sb.append("	<tr align='center'>");
			sb.append("<td>" + EnDecoding.decoding(ItemForm.getCol01()) + "</td>");
			sb.append("<td>" + EnDecoding.decoding(ItemForm.getCol02()) + "</td>");
			sb.append("<td>" + EnDecoding.decoding(ItemForm.getCol03()) + "</td>");
			sb.append("<td>" + EnDecoding.decoding(ItemForm.getCol04()) + "</td>");
			sb.append("<td>" + EnDecoding.decoding(ItemForm.getCol05()) + "</td>");
			sb.append("	</tr>");
		}

		sb.append("</table>");
		return sb.toString();
	}


	/**
	 * searchの値を入れて商品を検索するメソッド
	 * 
	 * @param search
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<ItemBean> getSearchItemList(String searchProduct1,
			String searchProduct2, String searchSelect) throws SQLException {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<ItemBean> list = new ArrayList<ItemBean>();
		String query = "";
		try {
			if (searchProduct1 == null && searchProduct2 == null
					&& searchSelect == null) {
				searchProduct1 = "";
				searchProduct2 = "";
				searchSelect = "";
				query = "select * from t_product";
				con = DBConnectionMgr.getInstance().getConnection();
				stmt = con.createStatement();

				rs = stmt.executeQuery(query);

				System.out.println(query);
			}
			if (searchSelect.equals("content")) {
				if (searchProduct2 == null) {
					query = "select * from t_product where contents like '%"
							+ searchProduct1 + "%'";
				} else {
					query = "select * from t_product where contents like '%"
							+ searchProduct1 + "%' and contents like '%"
							+ searchProduct2 + "%'";
				}
				con = DBConnectionMgr.getInstance().getConnection();
				stmt = con.createStatement();

				rs = stmt.executeQuery(query);

				System.out.println(query);
			} else if (searchSelect.equals("title")) {
				if (searchProduct2 == null) {
					query = "select * from t_product where product_name like '%"
							+ searchProduct1 + "%'";
				} else {
					query = "select * from t_product where product_name like '%"
							+ searchProduct1
							+ "%' and product_name like '%"
							+ searchProduct2 + "%'";
				}

				con = DBConnectionMgr.getInstance().getConnection();
				stmt = con.createStatement();

				rs = stmt.executeQuery(query);

				System.out.println(query);
			} else {
				if (searchProduct2 == null) {
					query = "select * from t_product where product_name like '%"
							+ searchProduct1
							+ "%' or contents like '%"
							+ searchProduct1 + "%'";
				} else {
					query = "select * from t_product where product_name like '%"
							+ searchProduct2
							+ "%' or contents like '%"
							+ searchProduct2
							+ "%' and product_name like '%"
							+ searchProduct1
							+ "%' or contents like '%"
							+ searchProduct1 + "%'";
				}

				con = DBConnectionMgr.getInstance().getConnection();
				stmt = con.createStatement();

				rs = stmt.executeQuery(query);

				System.out.println(query);
			}
			while (rs.next()) {
				ItemBean itemForm = new ItemBean();
//				productForm.setCate_code(rs.getString("cate_code"));
//				productForm.setProduct_code(rs.getString("product_code"));
//				productForm.setProduct_name(rs.getString("product_name"));
//				productForm.setCompany(rs.getString("company"));
//				productForm.setNation(rs.getString("nation"));
//				productForm.setContents(rs.getString("contents"));
//				productForm.setPrice(rs.getString("price"));
//				productForm.setFile(rs.getString("file"));
//				productForm.setCreateDate(rs.getString("create_date"));
//				productForm.setUserId(rs.getString("user_id"));
//				productForm.setPermission(rs.getString("permission"));
//				String userid = rs.getString("user_id");
//				String product_code = rs.getString("product_code");
//				ConfidenceHandler ch = new ConfidenceHandler();
//				productForm.setFree(ch.getConfSum(userid,3));
//				productForm.setFree2(ch.getConfSum(product_code,2));
				
				list.add(itemForm);
			}
		} catch (Exception e) {
			e.printStackTrace();
			DBConnectionMgr.getInstance().freeConnection(con, stmt, rs);
		} finally {
			DBConnectionMgr.getInstance().freeConnection(con, stmt, rs);
		}
		return list;
	}

	public ItemBean getItemInfo(String item_code) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = DBConnectionMgr.getInstance().getConnection();
			pstmt = con
					.prepareStatement("select * from t_item where item_code ='"
							+ item_code + "'");
			rs = pstmt.executeQuery();
			if (rs.next()) {
				ItemBean itemForm = new ItemBean();
				itemForm.setCate_code(rs.getString("cate_code"));
				itemForm.setItem_code(rs.getString("item_code"));
				itemForm.setCol01(rs.getString("col01"));
				itemForm.setCol02(rs.getString("col02"));
				itemForm.setCol03(rs.getString("col03"));
				itemForm.setCol04(rs.getString("col04"));
				itemForm.setCol05(rs.getString("col05"));
				itemForm.setCol06(rs.getString("col06"));
				itemForm.setCol07(rs.getString("col07"));
				itemForm.setCol08(rs.getString("col08"));
				itemForm.setCol09(rs.getString("col09"));
				itemForm.setCol10(rs.getString("col10"));
				itemForm.setCol11(rs.getString("col11"));
				itemForm.setCol12(rs.getString("col12"));
				itemForm.setCol13(rs.getString("col13"));
				itemForm.setCol14(rs.getString("col14"));
				itemForm.setCol15(rs.getString("col15"));
				itemForm.setCol16(rs.getString("col16"));
				itemForm.setCol17(rs.getString("col17"));
				itemForm.setCol18(rs.getString("col18"));
				itemForm.setCol19(rs.getString("col19"));
				itemForm.setCol20(rs.getString("col20"));
				itemForm.setUpdate_date(rs.getString("update_date"));
				
				itemForm.setUser_id(rs.getString("user_id"));
				itemForm.setContents(rs.getString("contents"));
				itemForm.setFile(rs.getString("file"));
//				String userid = rs.getString("user_id");
//				ConfidenceHandler ch = new ConfidenceHandler();
//				ItemForm.setFree(ch.getConfSum(userid,3));
//				ItemForm.setFree2(ch.getConfSum(product_code,2));
//				ItemForm.setPermission(rs.getString("permission"));
				
				return itemForm;
			} else {
				// .......
				return null;
			}

		} catch (Exception e) {
			e.printStackTrace();
			DBConnectionMgr.getInstance().freeConnection(con, pstmt, rs);
		} finally {
			DBConnectionMgr.getInstance().freeConnection(con, pstmt, rs);
		}
		return null;
	}

	public int idCheck(String user_id) throws AppException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = DBConnectionMgr.getInstance().getConnection();
			pstmt = con
					.prepareStatement("select * from t_user where user_id = ?");
			pstmt.setString(1, user_id);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				// .. new id create xx
				return 1;

			} else {
				// new id create ok
				return -1;
			}

		} catch (Exception e) {
			e.printStackTrace();
			DBConnectionMgr.getInstance().freeConnection(con, pstmt, rs);
		} finally {
			DBConnectionMgr.getInstance().freeConnection(con, pstmt, rs);
		}
		return 0;
	}

	/*
	 * 自分の商品リスト
	 * @param user_id
	 * @return　list
	 */
	public ArrayList<ItemBean> getMyItem(String user_id, String cate_code) throws SQLException {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<ItemBean> list = new ArrayList<ItemBean>();
		
		String query = "";
		try {
			con = DBConnectionMgr.getInstance().getConnection();
			stmt = con.createStatement();
			
			String query1 = "select * from t_item where user_id='" + user_id +"'";
			String query2 = "";
			if (!(cate_code.equals(""))) {
				query2 = " and cate_code='" + cate_code +"'";
			}
			String query3 = " order by update_date desc";
			query = query1+query2+query3;
			System.out.println("query:"+query);
			rs = stmt.executeQuery(query);
		
			while (rs.next()) {
				ItemBean ItemForm = new ItemBean();
				ItemForm.setCol01(rs.getString("col01"));
				ItemForm.setCol02(rs.getString("col02"));
				ItemForm.setCol03(rs.getString("col03"));
				ItemForm.setCol04(rs.getString("col04"));
				ItemForm.setCol05(rs.getString("col05"));
				ItemForm.setCol06(rs.getString("col06"));
				ItemForm.setCol07(rs.getString("col07"));
				ItemForm.setCol08(rs.getString("col08"));
				ItemForm.setCol09(rs.getString("col09"));
				ItemForm.setCol10(rs.getString("col10"));
				ItemForm.setCol11(rs.getString("col11"));
				ItemForm.setCol12(rs.getString("col12"));
				ItemForm.setCol13(rs.getString("col13"));
				ItemForm.setCol14(rs.getString("col14"));
				ItemForm.setCol15(rs.getString("col15"));
				ItemForm.setCol16(rs.getString("col16"));
				ItemForm.setCol17(rs.getString("col17"));
				ItemForm.setCol18(rs.getString("col18"));
				ItemForm.setCol19(rs.getString("col19"));
				ItemForm.setCol20(rs.getString("col20"));
				ItemForm.setItem_code(rs.getString("item_code"));
				ItemForm.setCate_code(rs.getString("cate_code"));
				ItemForm.setCode(rs.getString("code"));
				ItemForm.setUpdate_date(rs.getString("update_date"));			
				ItemForm.setUser_id(rs.getString("user_id"));
				ItemForm.setContents(rs.getString("contents"));
				list.add(ItemForm);
			}
		} catch (Exception e) {
			e.printStackTrace();
			DBConnectionMgr.getInstance().freeConnection(con, stmt, rs);
		} finally {
			DBConnectionMgr.getInstance().freeConnection(con, stmt, rs);
		}
		return list;
		}
	
	public boolean productConfirm(String product_code, String permission) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		boolean result = false;

		try {
			con = DBConnectionMgr.getInstance().getConnection();
			pstmt = con
					.prepareStatement("update t_product set permission=? where product_code=?");
			
			pstmt.setString(1, permission);
			pstmt.setString(2, product_code);

			int cnt = pstmt.executeUpdate();
			if (cnt == 1)
			{
				result = true;
			}

		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
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
		return result;
	}
	
	private String nullToStr(String inputStr) {
		if (inputStr == null) {
			inputStr = "";
		}
		return inputStr;
	}
	
	
}