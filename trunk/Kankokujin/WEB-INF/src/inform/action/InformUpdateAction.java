package inform.action;

import inform.bean.InformBean;
import inform.handler.InformUpdateHandler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import common.constant.Const;
import common.exception.AppException;
import common.exception.KankokujinException;
import common.logger.KankokujinLogger;
import common.util.Util;

public class InformUpdateAction extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {

		KankokujinLogger.getInstance().debug("InformUpdateAction.start");
		InformUpdateHandler informUpdateHandler = new InformUpdateHandler();
		InformBean informBean = new InformBean();
		boolean result = false;
		try {

			informBean = setInformBean(informBean, request);
            
			result = informUpdateHandler.updateInformBean(informBean);
			HttpSession session = request.getSession();
			session.setAttribute("id", informBean.getId());
		} catch (AppException e) {
			throw new KankokujinException("InformUpdateAction", e);
		} catch (Exception e) {
			throw new KankokujinException("InformUpdateAction", e);
		} finally {
			KankokujinLogger.getInstance().debug("InformUpdateAction.end");
		}
		if (result) {
			this.getServletContext().getRequestDispatcher("/InformDetail")
			.forward(request, response);
		} else {
			this.getServletContext().getRequestDispatcher("/InformList")
			.forward(request, response);
		}

	}

	private InformBean setInformBean(InformBean bean,
			HttpServletRequest request) throws ServletException, IOException {
		KankokujinLogger.getInstance().debug("InformUpdateAction.setInformBean.start");
		String saveFolder = Const.UPLOAD_FOLDER_PATH;
		int maxSize = 10 * 1024 * 1024;

		MultipartRequest multi = new MultipartRequest(request, saveFolder,
				maxSize, "UTF-8", new DefaultFileRenamePolicy());


		bean.setId(Util.changeNullStr(multi.getParameter("id")));
		bean.setUser_id(Util.changeNullStr(multi.getParameter("user_id")));
		bean.setUser_name(Util.changeNullStr(multi.getParameter("user_name")));
		bean.setTitle(Util.changeNullStr(multi.getParameter("title")));
		bean.setDetail_info(Util.changeNullStr(multi.getParameter("detail_info")));
		
		return bean;
	}
}
