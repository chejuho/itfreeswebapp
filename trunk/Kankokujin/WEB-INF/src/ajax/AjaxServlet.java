package ajax;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.category.Category;
//import common.category.CategoryBean;
import common.category.BookMark;
import common.category.CategoryUtil;
import common.exception.SysException;

public class AjaxServlet extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7535279358784313246L;

	public void doGet(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		
		response.setHeader("Cache-Control", "no-cache");
		PrintWriter out = new PrintWriter(new OutputStreamWriter(response.getOutputStream(), "UTF-8"), true);
		String sign = request.getParameter("param");
		Category treeMenu = null;
		System.out.println("sign="+sign);
		
		HttpSession session = request.getSession();
		
		if (sign.equals("init")) {
			
			try {
				treeMenu = CategoryUtil.createTreeCategory("sallamang");
			} catch (SysException e) {
				e.printStackTrace();
			}
			session.setAttribute("treeMenu", treeMenu);
		//	String tag =CategoryUtil.makeHtml(treeMenu, "0000");
			//String tag = treeMenu.makeHtml();
		//	System.out.println(tag);
		//	out.println(tag);
		}
		if (sign.equals("select")) {
			String code = request.getParameter("code");
			treeMenu = (Category) session.getAttribute("treeMenu");
	//		treeMenu.clickMenu(code);
	//		String tag = treeMenu.makeHtml();
			CategoryUtil.onclickCategory(treeMenu, code);
		//	String tag =CategoryUtil.makeHtml(treeMenu, code);
//			System.out.println(tag);
		//	out.println(tag);
			session.setAttribute("code", code);
		}
		if (sign.equals("addGroup")) {
			String codename = request.getParameter("codename");
			String rootCode = (String) session.getAttribute("code");
			treeMenu = (Category) session.getAttribute("treeMenu");
			//treeMenu.clickMenu(code);
	//		String tag = treeMenu.makeHtml();
//			System.out.println(tag);
//			out.println(tag);
			//session.setAttribute("code", code);
		}
		if (sign.equals("addItem")) {
			String code = request.getParameter("code");
			treeMenu = (Category) session.getAttribute("treeMenu");
//			treeMenu.clickMenu(code);
//			String tag = treeMenu.makeHtml();
//			System.out.println(tag);
//			out.println(tag);
			session.setAttribute("code", code);
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
