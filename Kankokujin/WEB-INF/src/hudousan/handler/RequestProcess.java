package hudousan.handler;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public abstract class RequestProcess {

	
	/**
	 * 
	 * @param context 
	 * @param request
	 * @return
	 */
	public abstract String execute(
			ServletContext context,
			HttpServletRequest request, 
			HttpServletResponse response);
	
}
