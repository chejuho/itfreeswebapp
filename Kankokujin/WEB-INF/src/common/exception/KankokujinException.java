package common.exception;

import javax.servlet.ServletException;

import common.logger.KankokujinLogger;
/**
 * サーブレットException
 */
public class KankokujinException extends ServletException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2908950040513558781L;
	private String messageId = "";
	private String message = "";
	
	public KankokujinException(String message){
		this.message = message;
	}
	public String getMessage() {
		return message;
	}

	public String getMessageId() {
		return messageId;
	}
	
	public KankokujinException(String message, Exception e){
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
			sb.append("\r\n");
		}
		this.message = message + sb.toString();
		KankokujinLogger.getInstance().error(sb.toString());
	}
}
