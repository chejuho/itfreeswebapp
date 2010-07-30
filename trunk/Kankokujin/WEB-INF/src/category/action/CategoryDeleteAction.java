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

public class CategoryDeleteAction extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		// 権限チェック
		if (Util.hasPrivilege(request)) {
			String cate_code = request.getParameter("cate_code");
			HttpSession session = request.getSession();
			String code = (String) session.getAttribute("code");

			CategoryHandler category = new CategoryHandler();

			boolean result = category.categoryDelete(cate_code, code);

			String user_id = "";
			user_id = request.getParameter("user_id");

			if (result) {
				Map map = category.getCategoryMap(code);
				String list = category.changCateListToTag(cate_code, map, 0,
						"", "", user_id);
				request.setAttribute("CategoryList", list);
				this.getServletContext().getRequestDispatcher("/CategoryList")
						.forward(request, response);

			} else {
				request.setAttribute("cate_code", cate_code);
				this.getServletContext().getRequestDispatcher(
						"/CategoryUpdateDeleteOpen").forward(request, response);
				// return mapping.findForward("CategoryDelete");
			}
		} else {			
			this.getServletContext().getRequestDispatcher(
					"/").forward(request, response);
		}
	}
}