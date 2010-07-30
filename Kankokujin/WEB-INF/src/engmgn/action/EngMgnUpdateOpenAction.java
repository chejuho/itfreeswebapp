package engmgn.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.exception.AppException;
import common.exception.KankokujinException;
import common.logger.KankokujinLogger;
import engmgn.bean.EngMgnBean;
import engmgn.handler.EngMgnDetailHandler;

public class EngMgnUpdateOpenAction  extends HttpServlet {
	/**
	 * 
	 */

	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			KankokujinLogger.getInstance().debug("EngMgnUpdateOpenAction.start");
			EngMgnDetailHandler handler = new EngMgnDetailHandler();
			
			String eng_id = request.getParameter("eng_id");

			EngMgnBean engMgnBean = handler.getEngineer(eng_id);
			
			request.setAttribute("bean", engMgnBean);
		} catch (AppException e) {
			throw new KankokujinException("EngMgnUpdateOpenAction", e);
		} catch (Exception e) {
			throw new KankokujinException("EngMgnUpdateOpenAction", e);
		} finally {
			KankokujinLogger.getInstance().debug("EngMgnUpdateOpenAction.end");
		}
		this.getServletContext().getRequestDispatcher("/jsp/engmgn/engmgnUpdate.jsp").forward(request, response);
	}

	

}