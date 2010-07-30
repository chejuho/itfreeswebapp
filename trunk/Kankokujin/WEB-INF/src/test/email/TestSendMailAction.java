package test.email;

import interpret.bean.InterpretBean;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import member.handler.MemberLoginHandler;

import common.bean.MemberBean;
import common.database.DBConnectionMgr;
import common.exception.AppException;
import common.exception.SysException;
import common.logger.KankokujinLogger;
import common.util.Util;

public class TestSendMailAction {

	public static void main(String[] args) {
		TestSendMailAction test = new TestSendMailAction();
		test.execute();
		
		
		//String fromId = "jeong";
		//String toId = "aa";
		//String charset = "euc-kr";
		//String charset = "UTF-8";
		
		
		String fromId = "aaa111";
		String toId = "bbb111";		
		String title = "タイトル";
		String contents = "コンテンツ";
		//String charset = "iso-2022-jp";
		//String charset = "SHIFT-JIS";
		String charset = "EUC-JP";
		try {
		MemberLoginHandler member = new MemberLoginHandler();
		MemberBean toBean = member.getMemberInfo(toId);
		test.sendmail(fromId, toId, toBean.getName(), toBean.getName(), charset);
		System.out.println("success");

		} catch (SysException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}

	public void execute() {

	}

	public boolean sendmail(String fromId, String toId, String title,
			String contents, String charset) {
		MemberLoginHandler member = new MemberLoginHandler();

		try {

			MemberBean toBean = member.getMemberInfo(toId);
			MemberBean frombean = member.getMemberInfo(fromId);

			Properties props = new Properties();
			props.put("mail.smtp.host", "smtp.mail.itfrees.com");

			Session s = Session.getInstance(props, null);
			MimeMessage message = new MimeMessage(s);
			InternetAddress from = new InternetAddress(frombean.getEmail1()+"@"+frombean.getEmail2(),
					frombean.getName());

			from.setPersonal(frombean.getName(), charset);

			message.setFrom(from);

			InternetAddress to = new InternetAddress(toBean.getEmail1()+"@"+toBean.getEmail2(),
					toBean.getName());
			to.setPersonal(toBean.getName(), charset);
			message.addRecipient(Message.RecipientType.TO, to);

			message.setSubject(title, charset);

			message.setContent(contents, "text/plain;charset=" + charset);

			Transport.send(message);

		} catch (SysException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		return true;
	}

	public InterpretBean getInterpretBean(int id) throws AppException {
		KankokujinLogger.getInstance().debug(
				"HouseSellDetailHandler.getInterpretBean.start");

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		InterpretBean bean = new InterpretBean();
		try {

			con = DBConnectionMgr.getInstance().getConnection();

			String strSql = "select * from interpret_info where id = ?";

			pstmt = con.prepareStatement(strSql);

			pstmt.setInt(1, id);
			KankokujinLogger.getInstance().debug(
					"getInterpretBean sql=" + strSql);
			rs = pstmt.executeQuery();
			if (rs.next()) {

				bean.setId(Util.changeNullStr(rs.getString("id")));

				bean.setIntroduction(rs.getString("introduction"));

			}
		} catch (SQLException e) {
			throw new AppException("SQLException", e);

		} catch (Exception e) {
			throw new AppException("Exception", e);
		} finally {
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException e) {
					throw new AppException("SQLException", e);
				}
			if (con != null) {
				DBConnectionMgr.getInstance().freeConnection(con);
			}
		}
		return bean;
	}
}
