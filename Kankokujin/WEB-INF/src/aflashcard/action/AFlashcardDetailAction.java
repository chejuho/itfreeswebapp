package aflashcard.action;

import java.io.IOException;
import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import aflashcard.bean.Question;
import aflashcard.handle.AFlashcardDBHandler;
import aflashcard.handle.AFlashcardUtil;


import common.bean.PageBean;
import common.database.DBConnectionMgr;
import common.exception.AppException;
import common.exception.KankokujinException;
import common.logger.KankokujinLogger;
import common.page.PageUtil;
import common.util.EnDecoding;
import common.util.Util;

public class AFlashcardDetailAction extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private final static String MOBILE_PAGE = "/jsp/aflashcard/aflashcardDetail_m.jsp";
	private final static String PC_PAGE = "/jsp/aflashcard/aflashcardDetail.jsp";
	private final static String PAGE_BEAN_NAME = "QuestionPageBean";

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		KankokujinLogger.getInstance().debug(this.getClass().getName() + ".start");
		Connection con = null;
		boolean mobileSign = false;
		Map<String, String> groupInfo = null;
		List<Question> questions = null;
		HttpSession session = request.getSession();
		session.setAttribute("action", "MemorizerDetail");

		mobileSign = AFlashcardUtil.getMobileSign(request);
		String groupId = request.getParameter("id");
		String fromPage = request.getParameter("fromPage");
		String categoryCode = request.getParameter("categoryCode");
		
		//String userId = AFlashcardUtil.getUserId(request);
		String userId = request.getParameter("userId");
		//AFlashcardUtil.setLocaleInfo(request, userId);
		
		String search_range = request.getParameter("search_range");
		String search = EnDecoding.decoding(Util.changeNullStr(request.getParameter("search")));
		
		AFlashcardDBHandler commonHandler = AFlashcardDBHandler.getInstance();
		
		PageBean pageBean = PageUtil.getInstance().pagingProcess(request, "10", PAGE_BEAN_NAME);
		try {
			con = DBConnectionMgr.getInstance().getConnection();
			groupInfo= commonHandler.getGroupInfo(con, groupId, userId);
			questions = commonHandler.getMemorizerList(con, groupId, pageBean);
		} catch (AppException e) {
			throw new KankokujinException(e.getMessage(), e);
		} catch (Exception e) {
			throw new KankokujinException("SYE0023", e);
		} finally {
			if (con != null) {
				DBConnectionMgr.getInstance().freeConnection(con);
			}
			KankokujinLogger.getInstance().debug("MemorizerListAction.end");
		}
		//param保存
		Map<String, String> params = new HashMap<String, String>();
		params.put("id", groupId);
		AFlashcardUtil.nowPageUrlSave(session, "detail", params);
		
		String errorMsg = (String) session.getAttribute("Msg");
		session.removeAttribute("Msg");
		if (errorMsg != null) {
			request.setAttribute("Msg", errorMsg);
		}
		request.setAttribute("userId", userId);
		request.setAttribute("groupId", groupId);
		request.setAttribute("groupInfo", groupInfo);
		request.setAttribute("fromPage", fromPage);
		request.setAttribute("memorizerQuestionList", questions);
		request.setAttribute("PageBeanName", PAGE_BEAN_NAME);
		session.setAttribute(PAGE_BEAN_NAME, pageBean);
		request.setAttribute("search", search);
		request.setAttribute("search_range", search_range);
		request.setAttribute("categoryCode", categoryCode);
		
		if (mobileSign) {
			this.getServletContext().getRequestDispatcher(MOBILE_PAGE).forward(request, response);
		} else {
			this.getServletContext().getRequestDispatcher(PC_PAGE).forward(request, response);
		}
	}
}
