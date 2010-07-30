package common.exception;

import common.logger.KankokujinLogger;
/**
 * アプリケーションException
 */
public class SysException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2908950040513558781L;
	private String messageId = "";
	private String message = "";
	
	public SysException(String message){
		this.message = message;
	}
	public String getMessage() {
		return message;
	}
	public String getMessageId() {
		return messageId;
	}
	
	public SysException(String message, Exception e){
		//e.printStackTrace();
		
		
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
		//this.message = message;
		this.message = message + sb.toString();
		//KankokujinLogger.getInstance().error(sb.toString());
	}
}
