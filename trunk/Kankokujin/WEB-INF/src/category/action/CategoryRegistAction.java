package category.action;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.util.Util;

import category.handler.CategoryHandler;

public class CategoryRegistAction extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		if (Util.hasPrivilege(request)) {
			CategoryHandler category = new CategoryHandler();

			String cate_code = "";

			String fatherCateCode = "";
			// String code = request.getParameter("code");
			HttpSession session = request.getSession();
			String code = (String) session.getAttribute("code");
			Map map = category.getCategoryMap(code);

			if (map.size() == 0) {
				cate_code = "0001";
			} else {

				fatherCateCode = request.getParameter("fatherCateCode");

				if ("null".equals(fatherCateCode)) {
					fatherCateCode = "";
				}

				cate_code = category.categoryMax(fatherCateCode, map);
			}
			String cateName = request.getParameter("cateName");

			boolean result = category.categoryInput(cate_code, cateName, code);

			String user_id = "";
			user_id = request.getParameter("user_id");

			if (result) {
				map = category.getCategoryMap(code);
				String list = category.changCateListToTag(fatherCateCode, map,
						0, "", "", user_id);
				request.setAttribute("cate_code", cate_code);
				request.setAttribute("CategoryList", list);
				this.getServletContext().getRequestDispatcher("/CategoryList")
						.forward(request, response);
				// return mapping.findForward("CategoryList");
			} else {
				this.getServletContext().getRequestDispatcher(
						"/CategoryRegistOpen").forward(request, response);
				// return mapping.findForward("CategoryInput");
			}
		} else {
			this.getServletContext().getRequestDispatcher("/").forward(request,
					response);
		}
	}
}