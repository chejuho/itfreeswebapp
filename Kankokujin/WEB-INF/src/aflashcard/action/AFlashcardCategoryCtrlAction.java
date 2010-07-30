package aflashcard.action;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import aflashcard.category.MCategory;
import aflashcard.category.MCategoryUtil;


import common.exception.SysException;
import common.util.Util;

public class AFlashcardCategoryCtrlAction extends HttpServlet{
	
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
		String userId = request.getParameter("userId");
		String forward = request.getParameter("forward");
		String tag = null;
		MCategory treeMenu = null;
		System.out.println("sign="+sign);
		
		HttpSession session = request.getSession();
		
		
		
		//MemberBean memberBean = (MemberBean) session.getAttribute("memberInfo");
		
		if (sign.equals("managerInit")) {
			if (Util.isEmpty(userId)) {
				userId = "k_admin";
			} 
			String code = (String) session.getAttribute("code");
			
			treeMenu = MCategoryUtil.getTreeMenu(session, userId);
			
			if (treeMenu == null) {
				try {
					treeMenu = MCategoryUtil.createTreeCategory(userId);
				} catch (SysException e) {
					e.printStackTrace();
				}
			}
			if (Util.isEmpty(code)) {
				code = "0000";
			} 
			//MCategoryUtil.onclickCategory(treeMenu, code);
			MCategoryUtil.setTreeMenu(session, treeMenu, userId);
			tag =MCategoryUtil.makeHtmlForManager(treeMenu, forward, code, userId);
			
		}
		System.out.println(tag);
		out.println(tag);

	}

	
	
	
	
	
	
	

}
