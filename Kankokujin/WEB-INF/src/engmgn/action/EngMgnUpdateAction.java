package engmgn.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import common.constant.Const;
import common.exception.AppException;
import common.exception.KankokujinException;
import common.logger.KankokujinLogger;
import common.util.Util;

import engmgn.bean.EngMgnBean;
import engmgn.handler.EngMgnDetailHandler;
import engmgn.handler.EngMgnUpdateHandler;

public class EngMgnUpdateAction extends HttpServlet {
	/**
	 * InteroretListを開く
	 * 
	 * @param request
	 *            response
	 * @return EngMgnBean、InterpretSortBean、PageBean、EngMgnBeanListの情報を送る
	 */
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		KankokujinLogger.getInstance().debug("EngMgnUpdateAction.start");
		EngMgnBean bean = new EngMgnBean();
		boolean result;
		try {
			
			EngMgnUpdateHandler handler = new EngMgnUpdateHandler();
			bean = setEngMgnBean(request);
			
			result = handler.updateEngMgnBean(bean);
		} catch (AppException e) {
			throw new KankokujinException(e.getMessage(), e);
		} catch (Exception e) {
			throw new KankokujinException(
					"EngMgnUpdateAction.service.Exception", e);
		} finally {
			KankokujinLogger.getInstance().debug("EngMgnUpdateAction.end");
		}
		if (result) {
			try {
				EngMgnDetailHandler handler = new EngMgnDetailHandler();
				bean = handler.getEngineer(bean.getEng_id());
			} catch (AppException e) {
				throw new KankokujinException(e.getMessage(), e);
			} catch (Exception e) {
				throw new KankokujinException(
						"InterpretUpdateAction.service.Exception", e);
			} finally {
				KankokujinLogger.getInstance().debug(
						"InterpretUpdateAction.end");
			}
			request.setAttribute("bean", bean);
			request.setAttribute("Message", "Success to update interpret info");
			this.getServletContext().getRequestDispatcher(
					"/jsp/engmgn/engmgnDetail.jsp").forward(request,
					response);
		} else {
			this.getServletContext().getRequestDispatcher(
			"/EngMgnList").forward(request, response);
		}
	}
	
	private EngMgnBean setEngMgnBean(HttpServletRequest request) throws ServletException, IOException {
		KankokujinLogger.getInstance().debug("EngMgnRegistAction.setEngMgnBean.start");
		String saveFolder = Const.DOWNLOAD_FOLDER_PATH;
		int maxSize = 10 * 1024 * 1024;

		MultipartRequest multi = new MultipartRequest(request, saveFolder,
				maxSize, "UTF-8", new DefaultFileRenamePolicy()); 		
		EngMgnBean bean = new EngMgnBean();
		
		bean.setEng_id(multi.getParameter("eng_id"));
		bean.setEng_initial(Util.changeNullStr(multi.getParameter("initial")));
		bean.setEng_name1(Util.changeNullStr(multi.getParameter("name1")));
		bean.setEng_name2(Util.changeNullStr(multi.getParameter("name2")));
		bean.setEng_sex(Util.changeNullInt(multi.getParameter("sex")));
		bean.setEng_age(Util.changeNullInt(multi.getParameter("age")));
		bean.setEng_career(Util.changeNullInt(multi.getParameter("career")));
		bean.setViewflg(Util.changeNullInt(multi.getParameter("viewflg")));

		// nation
		bean.setEng_nation(Util.changeNullStr(multi.getParameter("nation")));
		bean.setEng_nation_etc(Util.changeNullStr(multi.getParameter("nation_etc")));

		// type
		bean.setEng_type((Util.changeNullInt(multi.getParameter("type"))));

		// os
		StringBuffer sbos = new StringBuffer();
		String[] os = multi.getParameterValues("os");
		for (int i = 0; i < os.length; i++) {
			sbos.append(os[i]);
		}		
		bean.setEng_os(Util.changeNullStr(sbos.toString()));		
		bean.setEng_os_etc(Util.changeNullStr(multi.getParameter("os_etc")));
		
		// db
		StringBuffer sbdb = new StringBuffer();
		String[] db = multi.getParameterValues("db");
		for (int i = 0; i < db.length; i++) {
			sbdb.append(db[i]);
		}
		bean.setEng_db(sbdb.toString());
		bean.setEng_db_etc(Util.changeNullStr(multi.getParameter("db_etc")));

		// language
		StringBuffer sblang = new StringBuffer();
		String[] language = multi.getParameterValues("language");
		for (int i = 0; i < language.length; i++) {
			sblang.append(language[i]);
		}
		bean.setEng_language(sblang.toString());
		bean.setEng_language_etc(Util.changeNullStr(multi.getParameter("language_etc")));

		// process
		StringBuffer sbprocess = new StringBuffer();
		String[] process = multi.getParameterValues("process");
		for (int i = 0; i < process.length; i++) {
			sbprocess.append(process[i]);
			System.out.println(sbprocess.charAt(i));
		}
		bean.setEng_process(sbprocess.toString());

		// possibledate
		String now = multi.getParameter("now");
		if (Util.isEmpty(now)) {
			String possibledate = multi.getParameter("year")
					+ multi.getParameter("month");
			bean.setEng_possibledate(possibledate);

		} else {
			bean.setEng_possibledate(now);
		}

		bean.setEng_japanese(Util.changeNullInt(multi.getParameter("jap")));

		bean.setEng_skilllicense(Util.changeNullStr(multi.getParameter("skilllicense")));
		bean.setEng_japlicense(Util.changeNullStr(multi.getParameter("japlicense")));
		bean.setEng_ment(Util.changeNullStr(multi.getParameter("ment")));
		bean.setEng_salary(Util.changeNullInt(multi.getParameter("salary")));
		

		bean.setEng_state(Util.changeNullStr(multi.getParameter("state")));

		/*// filename処理
		System.out.println("form=" + form);
		EngForm engform = (EngForm) form;
		FormFile file = engform.getFile();
		System.out.println("file=" + file);
		String fileName = file.getFileName();
		System.out.println("fileName=" + fileName);
		 出力先ディレクトリの確定 
		String storeDir = "C:\\temp\\";

		long size = file.getFileSize();
		InputStream is = file.getInputStream();

		if (size > 0) {
			String outputPath = storeDir + "/" + fileName;

			OutputStream bos = new FileOutputStream(outputPath);
			int bytesRead = 0;
			byte[] buffer = new byte[8192];
			while ((bytesRead = is.read(buffer, 0, 8192)) != -1) {
				bos.write(buffer, 0, bytesRead);
			}
			bos.close();
		}*/
		bean.setEng_filename(multi.getFilesystemName("file"));
		// filename処理終わり
		return bean;
	}	
}