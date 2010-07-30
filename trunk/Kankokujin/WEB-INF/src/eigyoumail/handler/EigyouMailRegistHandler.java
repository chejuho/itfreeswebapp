package eigyoumail.handler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.StringTokenizer;

import common.database.DBConnectionMgr;
import common.util.EnDecoding;

import eigyoumail.bean.EigyoumailBean;

public class EigyouMailRegistHandler {
	
private DBConnectionMgr pool;
	
	public EigyouMailRegistHandler(){
		try{
			pool = DBConnectionMgr.getInstance();
			
			}catch (Exception e) {
				System.out.println("Connection fail...."+e);				
				}
			}

	private String reContent(String content){
				return br(" ","<br>",content);
	}
	public String br(String first,String brTag,String content){
		StringBuffer bf = new StringBuffer();
		StringTokenizer st = new StringTokenizer(content,"\n");
		int count = st.countTokens();
		bf.append(first);
		int i =1;
			while(st.hasMoreTokens()){
				if(i==count){
					bf.append(st.nextToken());
				}else{
					bf.append(st.nextToken()+brTag);
				}
				i++;
			}
			return bf.toString();
		
	}
		

	public ArrayList getMailList(){
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<EigyoumailBean> list = new ArrayList<EigyoumailBean>();
		String query = "";

		try{			
			query="select * from eigyou_email order by mail_id desc";
					
			con = pool.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);

			while(rs.next()){
				EigyoumailBean bean = new EigyoumailBean();
				bean.setMail_id(rs.getInt("mail_id"));
				bean.setTitle(EnDecoding.decoding(rs.getString("title")));
				bean.setContents(EnDecoding.decoding(rs.getString("contents")));
				bean.setInsert_date(rs.getString("insert_date"));
				bean.setUpdate_date(rs.getString("update_date"));
				bean.setUpdate_by_user_id(EnDecoding.decoding(rs.getString("update_by_user_id")));
				
				list.add(bean);
			}
		}catch(Exception e){
			System.out.println("getMailList failed....:"+e);
			pool.freeConnection(con, stmt, rs);
		}finally{
			pool.freeConnection(con,stmt);
		}
		return list;
	}
	
	
	
	public EigyoumailBean getMail(String mail_id){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		EigyoumailBean bean = null;
		
		try
		{
			String query = "select * from eigyou_email where mail_id=?";
			con = pool.getConnection();
			pstmt = con.prepareStatement(query);
			bean = new EigyoumailBean();

			pstmt.setString(1,mail_id);
			rs = pstmt.executeQuery();

			if (rs.next())
			{
				bean.setMail_id(rs.getInt("mail_id"));
				bean.setTitle(EnDecoding.decoding(rs.getString("title")));
				bean.setUpdate_by_user_id(EnDecoding.decoding(rs.getString("update_by_user_id")));
				bean.setContents(EnDecoding.decoding(reContent(rs.getString("contents"))));
				bean.setInsert_date(rs.getString("insert_date"));
				bean.setUpdate_date(rs.getString("update_date"));
			}
			
		}
		catch (Exception e)
		{
			System.out.println("getMail failed"+e);
		}finally{
			pool.freeConnection(con, pstmt, rs);
		}
		return bean;
	}
	
	
	public boolean insertEigyou_email(EigyoumailBean bean){
		Connection con = null;
		PreparedStatement pstmt = null;
		boolean result = false;
		try
		{
			String query = "insert into eigyou_email(title, contents, update_by_user_id," +
						   " insert_date, update_date)" +
						   " values (?, ?, ?, now(), now())";
			con = pool.getConnection();
			pstmt = con.prepareStatement(query);			
			pstmt.setString(1,bean.getTitle());
			pstmt.setString(2,bean.getContents());
			pstmt.setString(3,bean.getUpdate_by_user_id());
			

			int cnt = pstmt.executeUpdate();
			
			if (cnt == 1)
			{
				result = true;
			}
		}
		catch (Exception e)
		{
			System.out.println("mailInsert failed : "+e);
		}finally{
			pool.freeConnection(con, pstmt);
		}
		return result;
	}
	
	public int getMail_id(){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs= null;
		int mail_id = 0;
		try
		{
			String query = "select max(mail_id)as mail_id from eigyou_email";
			con = pool.getConnection();
			pstmt = con.prepareStatement(query);
			rs = pstmt.executeQuery();
			if(rs.next()) mail_id = rs.getInt("mail_id");
			mail_id++;
		
		}
		catch(Exception e)
			{
			System.out.println("Error"+e);
			}finally{
				pool.freeConnection(con,pstmt,rs);
			}
			return mail_id;
		}
	
	public boolean mailDelete(String mail_id)
	{
	Connection con = null;
	PreparedStatement pstmt = null;
	boolean result= false;
	
	System.out.println("mail_id = "+mail_id);
	
	try
	{ 
		String query = "delete from eigyou_email where mail_id = ?";
		
		con = pool.getConnection();
		pstmt = con.prepareStatement(query);

		pstmt.setString(1, mail_id);

		int cnt = pstmt.executeUpdate();
		if (cnt == 1)	
		{
			result = true;
		}
		System.out.println("mailDelete success");
	}
	catch(Exception e)
		{
		System.out.println("mailDelete failed :" + e);
		}finally{
			pool.freeConnection(con,pstmt);
		}
		
		return result;
	}
	
	public boolean mailUpdate(EigyoumailBean bean)
	{
	Connection con = null;
	PreparedStatement pstmt = null;
	boolean result= false;
	
	try
	{
		String query = "update eigyou_email set title=?, contents=?, update_date=now()" +
				" where mail_id=? and update_by_user_id=?";
		con = pool.getConnection();
		pstmt = con.prepareStatement(query);
		pstmt.setString(1, bean.getTitle());
		pstmt.setString(2, bean.getContents());
		pstmt.setInt(3, bean.getMail_id());
		pstmt.setString(4, bean.getUpdate_by_user_id());

		int cnt = pstmt.executeUpdate();
		if (cnt == 1)
		{
			result = true;
		}
	}
	catch(Exception e)
		{
		System.out.println("mailUpdate fail : " + e);
		}finally{
			pool.freeConnection(con,pstmt);
		}
		System.out.println(result);
		return result;
	}
	
	
}
