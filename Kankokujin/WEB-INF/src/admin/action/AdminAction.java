package admin.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.constant.Const;

public class AdminAction extends HttpServlet {
	/**
	 * InteroretList���J��
	 * 
	 * @param request
	 *            response
	 * @return BuySellBean�ABuySellSortBean�APageBean�ABuySellBeanList�̏��𑗂�
	 */
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		this.getServletContext().getRequestDispatcher(
				Const.ADMIN_INDEX_PATH).forward(request, response);

	}

}