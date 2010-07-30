package iboard.action;

import iboard.bean.IBoardBean;
import iboard.handler.IBoardCommonHandler;
import iboard.handler.IBoardUpdateHandler;

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
import common.util.EnDecoding;
import common.util.Util;

public class IBoardUpdateAction extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		boolean result = false;
		IBoardBean bean = requestToIBoardBean(request);
		IBoardUpdateHandler updateHandler = IBoardUpdateHandler.getInstance();
		IBoardCommonHandler commonHandler = IBoardCommonHandler.getInstance();
		String board_id = commonHandler.getFromRequestBoardId(request);
		try {
			result = updateHandler.update(bean);
		} catch (AppException e) {
			e.printStackTrace();
			throw new KankokujinException("IBoardRegistAction", e);
			
		} finally {
			KankokujinLogger.getInstance().debug("IBoardRegistAction.end");
		}
		if (result) {
			response.sendRedirect("IBoardDetail?id=" + bean.getId() + "&noReadSign=ok&board_id=" + board_id);
		} else {
			this.getServletContext().getRequestDispatcher("/jsp/iboard/iboardUpdate.jsp").forward(request, response);
		}

	}
	
	private IBoardBean requestToIBoardBean(HttpServletRequest request) throws IOException {
		
		IBoardBean bean = new IBoardBean();
		//Loginする場合
		//HttpSession session = request.getSession();
		//MemberBean memberBean = (MemberBean) session.getAttribute("memberInfo");
		
		bean.setId(Util.changeNullStr(request.getParameter("id")));
		bean.setTitle(Util.changeNullStr(EnDecoding.decoding(request.getParameter("title"))));
		bean.setContent(Util.changeNullStr(EnDecoding.decoding(request.getParameter("content"))));
		bean.setBoardId(Util.changeNullStr(request.getParameter("board_id")));
		bean.setUser_name(EnDecoding.decoding(request.getParameter("user_name")));
		bean.setPassword(request.getParameter("password"));
		return bean;
		
	}
	
}
