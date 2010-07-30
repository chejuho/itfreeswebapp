package inform.action;

import inform.bean.InformBean;
import inform.handler.InformRegistHandler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import common.constant.Const;
import common.exception.AppException;
import common.exception.KankokujinException;
import common.logger.KankokujinLogger;
import common.util.Util;

public class InformRegistAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		boolean result = false;
		try {
			KankokujinLogger.getInstance().debug("InformRegistAction.start");

			InformRegistHandler informRegistHandler = new InformRegistHandler();
			
			InformBean informBean = new InformBean();
			setInformBean(informBean, request);
			result = informRegistHandler.insertInformBean(informBean);

		} catch (AppException e) {
			throw new KankokujinException("InformRegistAction", e);
		} catch (Exception e) {
			throw new KankokujinException("InformRegistAction", e);
		} finally {
			KankokujinLogger.getInstance().debug("InformRegistAction.end");
		}
		if (result) {
			this.getServletContext().getRequestDispatcher("/InformList")
			.forward(request, response);

		} else {
			this.getServletContext().getRequestDispatcher(
			"/InformRegistOpen").forward(request, response);
		}

	}

	private InformBean setInformBean(InformBean bean, HttpServletRequest request)
	throws ServletException, IOException {
		KankokujinLogger.getInstance().debug(
		"InformRegistAction.setInformBean.start");
		String saveFolder = Const.UPLOAD_FOLDER_PATH;
		int maxSize = 10 * 1024 * 1024;

		MultipartRequest multi = new MultipartRequest(request, saveFolder,
				maxSize, "UTF-8", new DefaultFileRenamePolicy());

		bean.setUser_id(Util.changeNullStr(multi.getParameter("user_id")));
		bean.setTitle(Util.changeNullStr(multi.getParameter("title")));
		bean.setDetail_info(Util.changeNullStr(multi.getParameter("detail_info")));
		

		return bean;
	}
}