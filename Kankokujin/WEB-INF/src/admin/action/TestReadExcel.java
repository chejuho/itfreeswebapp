package admin.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.batch.insertdata.InsertStoreInfo;
import common.constant.Const;
import common.exception.KankokujinException;
import common.exception.SysException;

public class TestReadExcel extends HttpServlet {
	/**
	 * InteroretListを開く
	 * 
	 * @param request
	 *            response
	 * @return BuySellBean、BuySellSortBean、PageBean、BuySellBeanListの情報を送る
	 */
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		InsertStoreInfo insertStoreInfo = new InsertStoreInfo();
		try {
			insertStoreInfo.exec();
		} catch (SysException e) {
			throw new KankokujinException(e.getMessage(), e);
		} catch (Exception e) {
			throw new KankokujinException("SYE0016", e);
		}
		this.getServletContext().getRequestDispatcher("http://www.yahoo.co.jp").forward(request, response);

	}

}