package admin.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.batch.SendEmail;

public class SendEmailAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		SendEmail sendEmail = new SendEmail();
		PrintWriter out = response.getWriter();
		
			
			out.println("<html>");
/*			try {
			out.println("sendEmail.sendmail1()=" + sendEmail.sendmail1());
			} catch (Exception e) {
				StackTraceElement[] stack = e.getStackTrace();
				int length = stack.length;
				StringBuffer sb = new StringBuffer();
				for (int i= 0 ; i < length ; i ++) {
					sb.append(stack[i].getClassName());
					sb.append(".");
					sb.append(stack[i].getMethodName());
					sb.append(".java ");
					sb.append("(" +stack[i].getLineNumber()+")");
					sb.append(e.getLocalizedMessage());
					
					sb.append("<br>");
				}
				out.println(e.getMessage()+","+sb.toString());
			}
			out.println("<br>");*/
			try {
			out.println("sendEmail.sendmail2()=" + sendEmail.sendmail2());
			} catch (Exception e) {
				StackTraceElement[] stack = e.getStackTrace();
				int length = stack.length;
				StringBuffer sb = new StringBuffer();
				for (int i= 0 ; i < length ; i ++) {
					sb.append(stack[i].getClassName());
					sb.append(".");
					sb.append(stack[i].getMethodName());
					sb.append(".java ");
					sb.append("(" +stack[i].getLineNumber()+")");
					sb.append(e.getLocalizedMessage());
					
					sb.append("<br>");
				}
				out.println(e.getMessage()+","+sb.toString());
			}
			out.println("<br>");
			try {
			out.println("sendEmail.sendmail3()=" + sendEmail.sendmail3());
			} catch (Exception e) {
				StackTraceElement[] stack = e.getStackTrace();
				int length = stack.length;
				StringBuffer sb = new StringBuffer();
				for (int i= 0 ; i < length ; i ++) {
					sb.append(stack[i].getClassName());
					sb.append(".");
					sb.append(stack[i].getMethodName());
					sb.append(".java ");
					sb.append("(" +stack[i].getLineNumber()+")");
					sb.append(e.getLocalizedMessage());
					
					sb.append("<br>");
				}
				out.println(e.getMessage());
			}
			out.println("<br>");
			try {
			out.println("sendEmail.sendmail4()=" + sendEmail.sendmail4());
			} catch (Exception e) {
				StackTraceElement[] stack = e.getStackTrace();
				int length = stack.length;
				StringBuffer sb = new StringBuffer();
				for (int i= 0 ; i < length ; i ++) {
					sb.append(stack[i].getClassName());
					sb.append(".");
					sb.append(stack[i].getMethodName());
					sb.append(".java ");
					sb.append("(" +stack[i].getLineNumber()+")");
					sb.append(e.getLocalizedMessage());
					
					sb.append("<br>");
				}
				out.println(e.getMessage());
			}	
			out.println("<br>");
			try {
			out.println("sendEmail.sendmail5()=" + sendEmail.sendmail5());
			} catch (Exception e) {
				StackTraceElement[] stack = e.getStackTrace();
				int length = stack.length;
				StringBuffer sb = new StringBuffer();
				for (int i= 0 ; i < length ; i ++) {
					sb.append(stack[i].getClassName());
					sb.append(".");
					sb.append(stack[i].getMethodName());
					sb.append(".java ");
					sb.append("(" +stack[i].getLineNumber()+")");
					sb.append(e.getLocalizedMessage());
					
					sb.append("<br>");
				}
				out.println(e.getMessage());
			}			
			out.println("</html>");


	}

}