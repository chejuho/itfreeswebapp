package interpret.action;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.constant.Const;
import common.exception.KankokujinException;
import common.logger.KankokujinLogger;

public class InterpretDownLoadAction extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		KankokujinLogger.getInstance().debug("InterpretDownLoadAction.START");
		ServletOutputStream out = null;
		try {
			String filename = request.getParameter("filename");
			response.setHeader("Content-disposition", "attachment;filename=\""
					+ filename + "\";");
			out = response.getOutputStream();
			downLoad(filename, out);
		} catch (Exception e) {
			throw new KankokujinException("InterpretDownLoadAction.service.Exception", e);
		} finally {
			if (out != null) {
				out.close();
			}
		}
	}

	public void downLoad(String filename, OutputStream out)
			throws FileNotFoundException, IOException {

		FileInputStream fis = null;
		String file = Const.DOWNLOAD_FOLDER_PATH + filename;
		try {
			fis = new FileInputStream(file);
			byte[] buf = new byte[4 * 1024];

			int bytesRead;

			while ((bytesRead = fis.read(buf)) != -1) {
				out.write(buf, 0, bytesRead);
			}
		} finally {
			if (fis != null){
				fis.close();
			}
			KankokujinLogger.getInstance().debug("DownLoadAction.END");
		}

	}
}