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

import aflashcard.bean.AFlashcardDeck;
import aflashcard.category.MCategory;
import aflashcard.category.MCategoryUtil;
import aflashcard.handle.AFlashcardDBHandler;
import aflashcard.handle.AFlashcardUtil;


import common.bean.PageBean;
import common.database.DBConnectionMgr;
import common.exception.AppException;
import common.exception.KankokujinException;
import common.exception.SysException;
import common.logger.KankokujinLogger;
import common.page.PageUtil;

public class AFlashcardListAction extends HttpServlet {
	
	private final static String PAGE_BEAN_NAME = "GroupPageBean";
	private final static String MOBILE_PAGE = "/jsp/aflashcard/aflashcardList_m.jsp";
	private final static String PC_PAGE = "/jsp/aflashcard/aflashcardList.jsp";
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void service(
			HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		Connection con = null;
		boolean mobileSign = false;
		HttpSession session = request.getSession();
		
		
		String categoryCode = request.getParameter("categoryCode"); 
		String categoryClick = request.getParameter("categoryClick"); 
		
		List<AFlashcardDeck> groupList = null;
		
		mobileSign = AFlashcardUtil.getMobileSign(request);
		String userId = AFlashcardUtil.getUserId(request);
		AFlashcardUtil.setLocaleInfo(request, userId);
		if (categoryCode == null) {
			categoryCode = "0000";
		}
		
		MCategory treeMenu = treeMenuInit(request, session, userId);
		if ("ok".equals(categoryClick)) {
			MCategoryUtil.onclickCategory(treeMenu, categoryCode);
		}
		List<String> codeList = MCategoryUtil.getEqualLowLevelCategotyCodeList(treeMenu, categoryCode);
		
		AFlashcardDBHandler commonHandler = AFlashcardDBHandler.getInstance();
		PageBean pageBean = PageUtil.getInstance().pagingProcess(request, "10", PAGE_BEAN_NAME);
		try {
			con = DBConnectionMgr.getInstance().getConnection();
			groupList = commonHandler.getMemorizerGroupList(con, pageBean, userId, codeList);
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
		params.put("userId", userId);
		params.put("categoryCode", categoryCode);
		AFlashcardUtil.nowPageUrlSave(session, "list", params);
		
		
		String errorMsg = (String) session.getAttribute("Msg");
		session.removeAttribute("Msg");
		if (errorMsg != null) {
			request.setAttribute("Msg", errorMsg);
		}
		
		session.setAttribute("userId", userId);
		request.setAttribute("PageBeanName", PAGE_BEAN_NAME);
		session.setAttribute(PAGE_BEAN_NAME, pageBean);
		request.setAttribute("memorizerGroupList", groupList);
		session.setAttribute("code", categoryCode);
		request.setAttribute("actionUrl", "list");
		
		MCategoryUtil.setTreeMenu(session, treeMenu, userId);
		
		if (mobileSign) {
			this.getServletContext().getRequestDispatcher(MOBILE_PAGE).forward(request, response);
		} else {
			this.getServletContext().getRequestDispatcher(PC_PAGE).forward(request, response);
		}
		
		
	}

	private MCategory treeMenuInit(HttpServletRequest request, HttpSession session, String userid) {
		MCategory treeMenu = null;
		try { 
			treeMenu = MCategoryUtil.getTreeMenu(session, userid);
			if (treeMenu == null) {
				treeMenu = MCategoryUtil.createTreeCategory(userid);
			} 
		} catch (SysException e) {
			e.printStackTrace();
		}
		return treeMenu;
		
	}
	
	
}
