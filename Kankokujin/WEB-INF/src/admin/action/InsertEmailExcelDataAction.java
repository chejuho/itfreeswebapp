package admin.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.batch.insertdata.InsertEmail;
import common.constant.Const;
import common.exception.KankokujinException;
import common.exception.SysException;

public class InsertEmailExcelDataAction extends HttpServlet {
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
		InsertEmail insertEmail = new InsertEmail();
		try {
			insertEmail.exec();
		} catch (SysException e) {
			throw new KankokujinException(e.getMessage(), e);
		} catch (Exception e) {
			throw new KankokujinException("SYE0016", e);
		}
		this.getServletContext().getRequestDispatcher(
				Const.INDEX_PATH).forward(request, response);

	}

}