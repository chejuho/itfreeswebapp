package categoryNew.action;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.bean.MemberBean;
import common.category.Category;
//import common.category.CategoryBean;
import common.category.BookMark;
import common.category.CategoryUtil;
import common.exception.SysException;
import common.util.EnDecoding;
import common.util.Util;

public class CategoryControlAction extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7535279358784313246L;
	
	
	public void doPost(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		process(request, response);
	}
	public void doGet(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		process(request, response);
	}
	
	
	
	public void process(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		
		response.setHeader("Cache-Control", "no-cache");
		PrintWriter out = new PrintWriter(new OutputStreamWriter(response.getOutputStream(), "UTF-8"), true);
		String sign = request.getParameter("param");
		String tag = null;
		Category treeMenu = null;
		System.out.println("sign="+sign);
		
		HttpSession session = request.getSession();
		
		//MemberBean memberBean = (MemberBean) session.getAttribute("memberInfo");
		
		if (sign.equals("managerInit")) {
			String code = (String) session.getAttribute("code");
			if (Util.isEmpty(code)) {
				code = "0000";
			}
			treeMenu = (Category) session.getAttribute("treeMenu");
			tag =CategoryUtil.makeHtmlForManager(treeMenu, code);
			
		}
		if (sign.equals("init")) {
			String code = (String) session.getAttribute("code");
			if (Util.isEmpty(code)) {
				code = "0000";
			}
			treeMenu = (Category) session.getAttribute("treeMenu");
			tag =CategoryUtil.makeHtmlForBookMark(treeMenu, code);
			
		}
		if (sign.equals("managerSelect")) {
			String code = request.getParameter("code");
			treeMenu = (Category) session.getAttribute("treeMenu");
			CategoryUtil.onclickCategory(treeMenu, code);
			tag =CategoryUtil.makeHtmlForManager(treeMenu, code);
			session.setAttribute("code", code);
		}
		if (sign.equals("select")) {
			String code = request.getParameter("code");
			treeMenu = (Category) session.getAttribute("treeMenu");
			CategoryUtil.onclickCategory(treeMenu, code);
			tag =CategoryUtil.makeHtmlForBookMark(treeMenu, code);
			session.setAttribute("code", code);
		}
		if (sign.equals("addGroup")) {
			String codename = request.getParameter("codename");
			String rootCode = (String) session.getAttribute("code");
			treeMenu = (Category) session.getAttribute("treeMenu");
		}
		if (sign.equals("addItem")) {
			String code = request.getParameter("code");
			treeMenu = (Category) session.getAttribute("treeMenu");
			session.setAttribute("code", code);
		}
		if (sign.equals("updateCateOpen")) {
			MemberBean memberBean = (MemberBean) session.getAttribute("memberInfo");
			String userid = memberBean.getUserid();
			tag =updateCategoryOpen(request, session, userid);
		}
		if (sign.equals("updateBookOpen")) {
			tag =updateBookMarkOpen(request, session);
		}
		
		if (sign.equals("insertCategory")) {
			MemberBean memberBean = (MemberBean) session.getAttribute("memberInfo");
			String oyacode = (String) session.getAttribute("code");
			String userid = memberBean.getUserid();
			insertCategory(request, session, userid);
			treeMenu = (Category) session.getAttribute("treeMenu");
			tag =CategoryUtil.makeHtmlForManager(treeMenu, oyacode);
		}
		
		if (sign.equals("insertBook")) {
			MemberBean memberBean = (MemberBean) session.getAttribute("memberInfo");
			String oyacode = (String) session.getAttribute("code");
			String userid = memberBean.getUserid();
			insertBookMark(request, session, userid);
			treeMenu = (Category) session.getAttribute("treeMenu");
			tag =CategoryUtil.makeHtmlForManager(treeMenu, oyacode);
		}
		
		if (sign.equals("deleteCategory")) {
			MemberBean memberBean = (MemberBean) session.getAttribute("memberInfo");
			//String oyacode = (String) session.getAttribute("code");
			String userid = memberBean.getUserid();
			deleteCategory(request, session, userid);
			treeMenu = (Category) session.getAttribute("treeMenu");
			tag =CategoryUtil.makeHtmlForManager(treeMenu, "0000");
		}
		
		if (sign.equals("deleteBookmark")) {
			deleteBookMark(request, session);
			treeMenu = (Category) session.getAttribute("treeMenu");
			tag =CategoryUtil.makeHtmlForManager(treeMenu, "0000");
		}
		
		if (sign.equals("updateCategory")) {
			MemberBean memberBean = (MemberBean) session.getAttribute("memberInfo");
			String oyacode = (String) session.getAttribute("code");
			String userid = memberBean.getUserid();
			updateCategory(request, session, userid);
			treeMenu = (Category) session.getAttribute("treeMenu");
			tag =CategoryUtil.makeHtmlForManager(treeMenu, oyacode);
		}
		
		if (sign.equals("updateBookmark")) {
			updateBookMark(request, session);
			treeMenu = (Category) session.getAttribute("treeMenu");
			tag =CategoryUtil.makeHtmlForManager(treeMenu, "0000");
		}
		
		System.out.println(tag);
		out.println(tag);

	}
	
	private String insertCategory(HttpServletRequest request, HttpSession session) {
		
		return null;
	}

	private String updateCategoryOpen(HttpServletRequest request, HttpSession session, String userid) {
		StringBuffer sb =  new StringBuffer();
		String code = (String) session.getAttribute("code");
		String name = null;
		try {
			name = CategoryUtil.getCategoryName(userid, code);
			sb.append(code).append("<i>");
			sb.append(name);
		} catch (SysException e) {
			e.printStackTrace();
		}
		
		return sb.toString();
	}
	
	private String updateBookMarkOpen(HttpServletRequest request, HttpSession session) {
		StringBuffer sb =  new StringBuffer();
		String code = (String) session.getAttribute("code");
		BookMark bookMark = null;
		try {
			bookMark = CategoryUtil.getBookMarkInfo(code);
			sb.append(bookMark.getTitle()).append("<i>");
			sb.append(bookMark.getUrl()).append("<i>");
			sb.append(bookMark.getDetail()).append("<i>");
			request.setAttribute("bookMark", bookMark);
		} catch (SysException e) {
			e.printStackTrace();
		}

		return sb.toString();
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
	/**
	 * 
	 * @param request
	 * @param session
	 * @param userid
	 */
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
	
	private Category getCategory() {
		Category root = new Category("ROOT","01");
		//Tree
		Category subRoot1 = new Category("ì˙ñ{åÍ","02");
		Category subRoot2 = new Category("íÜçëåÍ","03");
		Category subRoot3 = new Category("äÿçëåÍ","04");
		
		Category subRoot1_1 = new Category("èâãâ","05");
		BookMark subRoot1_2 = new BookMark("íÜãâ","06");
		BookMark subRoot1_3 = new BookMark("çÇãâ","07");
		
		BookMark subRoot1_1_1 = new BookMark("å`óeéå","08");
		BookMark subRoot1_1_2 = new BookMark("ìÆéå","09");
		BookMark subRoot1_1_3 = new BookMark("ñºéå","10");
		
		subRoot1_1.addBookMark(subRoot1_1_1);
		subRoot1_1.addBookMark(subRoot1_1_2);
		subRoot1_1.addBookMark(subRoot1_1_3);
		
		subRoot1.addCategory(subRoot1_1);
		subRoot1.addBookMark(subRoot1_2);
		subRoot1.addBookMark(subRoot1_3);
		
		root.addCategory(subRoot1);
		root.addCategory(subRoot2);
		root.addCategory(subRoot3);
		root.rootSet();
		
		return root;
		
	}

}
