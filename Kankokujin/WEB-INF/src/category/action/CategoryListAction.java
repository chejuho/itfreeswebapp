package category.action;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import category.handler.CategoryHandler;

import common.exception.KankokujinException;
import common.logger.KankokujinLogger;
import common.util.Util;

public class CategoryListAction extends HttpServlet {
	/**
	 * InteroretListを開く
	 * 
	 * @param request
	 *            response
	 * @return InterpretBean、InterpretSortBean、PageBean、InterpretBeanListの情報を送る
	 */
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		try {
			if (Util.hasPrivilege(request)) {
				KankokujinLogger.getInstance()
						.debug("CategoryListAction.start");
				HttpSession session = request.getSession();
				// テスト
				session.setAttribute("code", "2");
				String cate_code = request.getParameter("cate_code");

				String cate_code1 = (String) request.getAttribute("cate_code");

				String code = (String) session.getAttribute("code");
				CategoryHandler category = new CategoryHandler();

				Map map = category.getCategoryMap(code);

				String categorySelect = "";

				String user_id = "";
				user_id = request.getParameter("user_id");

				if (cate_code == null) {

					categorySelect = category.changCateListToTag(null, map, 0,
							"", "", user_id);

				} else {
					categorySelect = category.getAllViewTag(cate_code, map, 0,
							"", "", user_id);
				}

				if (cate_code1 != null) {

					categorySelect = category.getAllViewTag(cate_code1, map, 0,
							"", "", user_id);
				}

				request.setAttribute("CategorySelect", categorySelect);
				request.setAttribute("cate_code", cate_code);
			} else {
				this.getServletContext().getRequestDispatcher("/").forward(
						request, response);
			}
			// } catch (AppException e) {
			// throw new KankokujinException("InterpretListAction", e);
		} catch (Exception e) {
			throw new KankokujinException("CategoryListAction", e);
		} finally {
			KankokujinLogger.getInstance().debug("CategoryListAction.end");
		}
		this.getServletContext().getRequestDispatcher(
				"/jsp/category/categoryList.jsp").forward(request, response);

	}
}