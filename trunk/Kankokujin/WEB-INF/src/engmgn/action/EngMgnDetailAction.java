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

public class EngMgnDetailAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		KankokujinLogger.getInstance().debug("EngMgnDetailAction start");	
		EngMgnBean bean = new EngMgnBean();
		EngMgnDetailHandler mg = new EngMgnDetailHandler();
		
		try{
			String eng_id = request.getParameter("eng_id");
			
			KankokujinLogger.getInstance().debug("DetailAction eng_id="+eng_id);
					
			bean = mg.getEngineer(eng_id);	
			request.setAttribute("bean", bean);
		
		} catch (AppException e) {
			throw new KankokujinException("EngMgnDetailAction", e);
		} catch (Exception e) {
			throw new KankokujinException("EngMgnDetailAction", e);
		} finally {
			KankokujinLogger.getInstance().debug("EngMgnDetailAction.end");
		}
		this.getServletContext().getRequestDispatcher(
		"/jsp/engmgn/engmgnDetail.jsp").forward(request, response);

    }
}
