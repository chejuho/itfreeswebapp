/*
 * Created on 2006. 7. 5.
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package stock;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import bean.KawaseBean;
import bean.StockBean;
import common.exception.AppException;
import common.database.DBConnectionMgr;

/**
 * @author Administrator
 * 
 * TODO To change the template for this generated type comment go to Window -
 * Preferences - Java - Code Style - Code Templates
 */
public class Kawase {
	/*
	 */
	public List getKawaseInfoList() {

		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		List list = new ArrayList();
		try {
			con = DBConnectionMgr.getInstance().getConnection();

			stmt = con.createStatement();
			StringBuffer sql = new StringBuffer();
			//sql.append(" select fx_id, buy_price, sell_price, stock_date from kawase order by fx_id desc limit 120");
			sql.append(" select fx_id, buy_price, sell_price, stock_date from kawase order by fx_id desc ");
			rs = stmt.executeQuery(sql.toString());
			while (rs.next()) {
				KawaseBean bean = new KawaseBean();
				bean.setBuy_price(rs.getString("buy_price"));
				bean.setSell_price(rs.getString("sell_price"));
				bean.setDate(rs.getString("stock_date"));
				list.add(bean);
			}
		} catch (AppException e2) {
			e2.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (con != null) {
					DBConnectionMgr.getInstance().freeConnection(con);
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		return list;
	}
	public List getUsaStockInfoList() {

		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		List list = new ArrayList();
		try {
			con = DBConnectionMgr.getInstance().getConnection();

			stmt = con.createStatement();
			StringBuffer sql = new StringBuffer();
			//sql.append(" select stock_price, regist_date from usa_stock order by stock_id desc limit 120");
			sql.append(" select stock_price, regist_date from usa_stock order by stock_id desc ");
			rs = stmt.executeQuery(sql.toString());
			while (rs.next()) {
				KawaseBean bean = new KawaseBean();
				//bean.setBuy_price(rs.getString("stock_price"));
				bean.setSell_price(rs.getString("stock_price"));
				bean.setDate(rs.getString("regist_date"));
				list.add(bean);
			}
		} catch (AppException e2) {
			e2.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (con != null) {
					DBConnectionMgr.getInstance().freeConnection(con);
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		return list;
	}

}