package categoryNew.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.bean.MemberBean;
import common.category.BookMark;
import common.category.Category;
import common.category.CategoryUtil;
import common.exception.SysException;
import common.util.EnDecoding;
import common.util.Util;

public class CategoryManagerAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String FORWARDURL = "/jsp/bookmark/categoryManager.jsp";
	private static final String REDIRECT_URL = "/CategoryManager";
	private static final String TO_INIT = "0";
	private static final String TO_RE_INIT = "1";
	private static final String TO_INSERT_CATEGORY = "2";
	private static final String TO_UPDATE_CATEGORY = "3";
	private static final String TO_INSERT_BOOK = "4";
	private static final String TO_UPDATE_BOOK = "5";	
	
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		if (!Util.isLogin(request)) {
			session.setAttribute("action", "CategoryManager");
			request.setAttribute("Message", "WAR0004");
			this.getServletContext().getRequestDispatcher("/MemberLoginOpen").forward(request, response);	
		}
		MemberBean memberBean = (MemberBean) session.getAttribute("memberInfo");
		
		String userid = memberBean.getUserid();
		
		String action = request.getParameter("action");
		String clickedbtn = request.getParameter("clickedbtn");
		String forwardSign = null; 
		
		//insertCateOpen
		if ("insertCateOpen".equals(action)) {
			forwardSign = TO_INSERT_CATEGORY;	
		//insertCate
		} else if ("insertCate".equals(action)) {
			insertCategory(request, session, userid);
			forwardSign = TO_INIT;
		//deleteCate
		} else if ("deleteCate".equals(action)) {
			deleteCategory(request, session, userid);
			forwardSign = TO_INIT;			
		//updateCateOpen	
		} else if ("updateCateOpen".equals(action)) {
			updateCategoryOpen(request, session, userid);
			forwardSign = TO_UPDATE_CATEGORY;	
		//updateCateOpen			
		} else if ("updateCate".equals(action)) {
			updateCategory(request, session, userid);
			forwardSign = TO_INIT;		
		//insertBookOpen			
		} else if ("insertBookOpen".equals(action)) {
			forwardSign = TO_INSERT_BOOK;	
		//insertBook			
		} else if ("insertBook".equals(action)) {
			insertBookMark(request, session, userid);
			forwardSign = TO_INIT;	
		//deleteBook	
		} else if ("deleteBook".equals(action)) {
			deleteBookMark(request, session);
			forwardSign = TO_INIT;	
		//updateBookOpen			
		} else if ("updateBookOpen".equals(action)) {
			updateBookMarkOpen(request, session);
			forwardSign = TO_UPDATE_BOOK;
		//updateBook			
		} else if ("updateBook".equals(action)) {
			updateBookMark(request, session);
			forwardSign = TO_INIT;	
		} else {
			init(request, session, userid);
			forwardSign = TO_INIT;
		}
		
		request.setAttribute("forwardSign", forwardSign);
		request.setAttribute("clickedbtn", clickedbtn);
		this.getServletContext().getRequestDispatcher(FORWARDURL).forward(request, response);
		
	}

	private void init(HttpServletRequest request, HttpSession session, String userid) {
		try {
			Category treeMenu = CategoryUtil.createTreeCategory(userid);
			session.setAttribute("treeMenu", treeMenu);
			session.setAttribute("code", "0000");
		} catch (SysException e) {
			e.printStackTrace();
		}
		
	}

	private void updateBookMarkOpen(HttpServletRequest request, HttpSession session) {
		String code = (String) session.getAttribute("code");
		BookMark bookMark = null;
		try {
			bookMark = CategoryUtil.getBookMarkInfo(code);
			request.setAttribute("bookMark", bookMark);
		} catch (SysException e) {
			e.printStackTrace();
		}
	}

	private void updateCategoryOpen(HttpServletRequest request, HttpSession session, String userid) {
		String code = (String) session.getAttribute("code");
		String name = null;
		try {
			name = CategoryUtil.getCategoryName(userid, code);
			request.setAttribute("updateCode", code);
			request.setAttribute("updateCodeName", name);
		} catch (SysException e) {
			e.printStackTrace();
		}
	}

	private void updateBookMark(HttpServletRequest request, HttpSession session) {
		String id = (String) session.getAttribute("code");
		String title = EnDecoding.decoding((String) request.getParameter("uptitle"));
		String url = (String) request.getParameter("upurl");
		String detail = EnDecoding.decoding((String) request.getParameter("updetail"));
		try {
			CategoryUtil.updateBookMark(id, title, url, detail);
			Category category = (Category) session.getAttribute("treeMenu");
			CategoryUtil.updateBookMarkToObject(category, id, title, url, detail);
		} catch (SysException e) {
			e.printStackTrace();
		}
		
	}

	private void deleteBookMark(HttpServletRequest request, HttpSession session) {
		String code = (String) session.getAttribute("code");
		try {
			CategoryUtil.removeBookMark(code);
			Category category = (Category) session.getAttribute("treeMenu");
			CategoryUtil.removeBookMarkToObject(category, code);
		} catch (SysException e) {
			e.printStackTrace();
		}
	}

	private void insertBookMark(HttpServletRequest request, HttpSession session, String userid) {
		String oyacode = (String) session.getAttribute("code");
		String title = EnDecoding.decoding((String) request.getParameter("title"));
		String url = (String) request.getParameter("url");
		String detail = EnDecoding.decoding((String) request.getParameter("detail"));
		try {
			String id = CategoryUtil.insertBookMark(userid, oyacode, title, url, detail);
			Category category = (Category) session.getAttribute("treeMenu");
			CategoryUtil.insertBookMarkToObject(category, oyacode, id, title, url, detail);
		} catch (SysException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @param request
	 * @param session
	 */
	private void updateCategory(HttpServletRequest request, HttpSession session, String userid) {
		String name = EnDecoding.decoding((String) request.getParameter("updateCodename"));
		String code = (String) request.getParameter("updateCode");
		try {
			CategoryUtil.updateCategory(userid, code, name);
			Category category = (Category) session.getAttribute("treeMenu");
			CategoryUtil.updateCategoryToObject(category, code, name);
		} catch (SysException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @param request
	 * @param session
	 */
	private void deleteCategory(HttpServletRequest request, HttpSession session, String userid) {
		String code = (String) session.getAttribute("code");
		try {
			CategoryUtil.removeCategory(userid, code);
			Category category = (Category) session.getAttribute("treeMenu");
			CategoryUtil.removeCategoryToObject(category, code);
		} catch (SysException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @param request
	 * @param session
	 */
	private void insertCategory(HttpServletRequest request, HttpSession session, String userid) {
		String catename = EnDecoding.decoding((String) request.getParameter("catename"));
		String oyacode = (String) session.getAttribute("code");
		if (oyacode == null) {
			oyacode = "0000";
		}
		try {
			String newcode = CategoryUtil.insertCategory(userid, oyacode, catename);
			Category category = (Category) session.getAttribute("treeMenu");
			CategoryUtil.insertCategoryToObject(category, oyacode, newcode, catename, true);
		} catch (SysException e) {
			e.printStackTrace();
		}
	}
}
