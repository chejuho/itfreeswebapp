package board;

import java.sql.*;

import common.database.DBConnectionMgr;
import common.exception.AppException;

public class ConnectionBean {
	Connection con = null;

	public ConnectionBean() {
		try {
			//Class.forName("org.gjt.mm.mysql.Driver");
			//String url = "jdbc:mysql://itfrees.com:3306/www";
			con = 
			DBConnectionMgr.getInstance().getConnection();
			System.out.println("getConnection ok");
		} catch (AppException e) {
			// TODO é©ìÆê∂ê¨Ç≥ÇÍÇΩ catch ÉuÉçÉbÉN
			e.printStackTrace();
		}
	}

	public Connection getConnection() {
		return con;
	}
}