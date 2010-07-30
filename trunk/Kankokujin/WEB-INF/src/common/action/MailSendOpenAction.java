package common.action;

import java.io.IOException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.logger.KankokujinLogger;
import common.util.EnDecoding;

public class MailSendOpenAction extends HttpServlet {
	
	private final static String USERBEAN = "memberInfo";
	/**
	 * MenuAction���J��
	 * 
	 * @param request,response
	 * @return StoreBean�AStoreSortBean�APageBean�AStoreBeanList�̏��𑗂�
	 */
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		
		KankokujinLogger.getInstance().debug("MailSendOpenAction.start");
		
		Map map = new HashMap();
		String id = (String) request.getParameter("id");
		String username = new String(((String) request.getParameter("username")).getBytes("ISO-8859-1"), "UTF-8");
		//String username = (String) request.getParameter("username");
		String sort = (String) request.getParameter("sort");

		map.put("to_userName", username);
		map.put("to_id", id);
		map.put("sort", sort);
		 
		/** ���ʂ�Request�ɃZ�b�g */
		request.setAttribute("map", map);
		
		/** �����ʃy�[�W����@*/
		String url = "/jsp/email/sendEmailFromWeb.jsp";
		this.getServletContext().getRequestDispatcher(url).forward(request, response);

	}

	
	
	

}