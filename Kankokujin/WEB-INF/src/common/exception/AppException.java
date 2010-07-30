package common.exception;

import common.logger.KankokujinLogger;
/**
 * アプリケーションException
 */
public class AppException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2908950040513558781L;
	private String messageId = "";
	private String message = "";
	
	public AppException(String message){
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public String getMessageId() {
		return messageId;
	}
	
	public AppException(String message, Exception e){
		e.printStackTrace();
		this.message = message;
		
		StackTraceElement[] stack = e.getStackTrace();
		int length = stack.length;
		StringBuffer sb = new StringBuffer();
		for (int i= 0 ; i < length ; i ++) {
			sb.append(stack[i].getClassName());
			sb.append(".");
			sb.append(stack[i].getMethodName());
			sb.append(".java ");			
			sb.append(e.getLocalizedMessage());
			sb.append("\r\n");
		}
		KankokujinLogger.getInstance().error(sb.toString());
	}

}
