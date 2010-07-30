package common.batch;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import common.constant.Const;
import common.exception.SysException;

import email.bean.EmailBean;
import email.handler.SendMailHandler;

public class MakeEmailContents {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MakeEmailContents makeEmailContents = new MakeEmailContents();
		makeEmailContents.makeRegistMailContents();
		makeEmailContents.makeSearchIdMailContents();
		makeEmailContents.makeSearchPwdMailContents();
		System.out.println("finished");

	}
	
	private void makeRegistMailContents(){
		SendMailHandler backSendMailHandler = new SendMailHandler();
		Properties prop = new Properties();
		try {
			EmailBean emailBean = backSendMailHandler.getEmailInfo("1");
			prop.setProperty("subject", emailBean.getSubject());
			prop.setProperty("contents", emailBean.getContents());
			FileOutputStream fos;

			fos = new FileOutputStream("./xml/"+Const.REGIST_MAIL_FILENAME);
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			prop.storeToXML(bos, "comment", "UTF-8");

		} catch (SysException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}
	private void makeSearchIdMailContents(){
		SendMailHandler backSendMailHandler = new SendMailHandler();
		Properties prop = new Properties();
		try {
			EmailBean emailBean = backSendMailHandler.getEmailInfo("2");
			prop.setProperty("subject", emailBean.getSubject());
			prop.setProperty("contents", emailBean.getContents());
			FileOutputStream fos;

			fos = new FileOutputStream("./xml/"+Const.FIND_ID_MAIL_FILENAME);
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			prop.storeToXML(bos, "comment", "UTF-8");

		} catch (SysException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}	
	private void makeSearchPwdMailContents(){
		SendMailHandler backSendMailHandler = new SendMailHandler();
		Properties prop = new Properties();
		try {
			EmailBean emailBean = backSendMailHandler.getEmailInfo("3");
			prop.setProperty("subject", emailBean.getSubject());
			prop.setProperty("contents", emailBean.getContents());
			FileOutputStream fos;

			fos = new FileOutputStream("./xml/"+Const.FIND_IDPWD_MAIL_FILENAME);
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			prop.storeToXML(bos, "comment", "UTF-8");

		} catch (SysException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}		

}
