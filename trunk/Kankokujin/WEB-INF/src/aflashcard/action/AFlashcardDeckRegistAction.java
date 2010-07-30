package aflashcard.action;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



import aflashcard.bean.Question;
import aflashcard.handle.AFlashcardDBHandler;
import aflashcard.handle.AFlashcardUtil;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import common.bean.MemberBean;
import common.constant.Const;
import common.database.DBConnectionMgr;
import common.exception.AppException;
import common.exception.KankokujinException;
import common.logger.KankokujinLogger;
import common.util.Util;

public class AFlashcardDeckRegistAction extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String TEMP = "temp";
	public final static String FILTER_KEYWORD_txt = ".txt";
	public final static String FILTER_KEYWORD_csv = ".csv";
	public final static String FILTER_KEYWORD_zip = ".zip";
	public final static String FILTER_KEYWORD_xls = ".xls";
	
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Connection con = null;
		String actionName = "list";
		AFlashcardDBHandler commonHandler = AFlashcardDBHandler.getInstance();
		
		HttpSession session = request.getSession();
		
		String saveFolder = Const.UPLOAD_FOLDER_PATH;
		int maxSize = 10 * 1024 * 1024;
		MultipartRequest multi = new MultipartRequest(request, saveFolder, maxSize, "UTF-8", new DefaultFileRenamePolicy());
		
		String title = multi.getParameter("title");
		String userId = multi.getParameter("user_id");
		String userName = multi.getParameter("user_name");
		String registerUserId = "";
		String password = multi.getParameter("pass_word");
		String categoryCode = multi.getParameter("categoryCode");
		String filename = multi.getFilesystemName("file_name");
		
		if (Util.isLogin(request, "M_memberInfo")) {
			MemberBean memberBean = (MemberBean) session.getAttribute("M_memberInfo");
			userName = memberBean.getName();
			password = "";
			registerUserId = memberBean.getUserid();
		//loginしない場合
		} else {
			registerUserId = "guest";
		}
		
		File file = new File(saveFolder, filename);
		List<File> importFileList = new ArrayList<File>();
		List<File> upzipFileList = null;
		if (file.getName().toLowerCase().endsWith("zip")) {
			upzipFileList = AFlashcardUtil.unZip(file.getAbsolutePath(), saveFolder + TEMP);
			
			for (File unzipFile: upzipFileList) {
				if (unzipFile.isFile()) {
					if (unzipFile.getName().toLowerCase().endsWith(FILTER_KEYWORD_txt) || 
							unzipFile.getName().toLowerCase().endsWith(FILTER_KEYWORD_csv)) {
						importFileList.add(unzipFile);
					}
				}
			}
		} else {
			importFileList.add(file);
		}
		
		try {
			 con = DBConnectionMgr.getInstance().getConnection();
			 int size = importFileList.size();
			 int index = 1;
			 for (File importFile : importFileList) {
				 List<Question>	questionList = AFlashcardUtil.fileToMemorizeInfoList(importFile.getAbsolutePath(), true);
				 AFlashcardUtil.resourcesProcess(questionList, importFile);
				 String newTitle = "";
				 if (size > 1) {
					 newTitle = title + index;
					 index++;
				 } else {
					 newTitle = title;
				 }
					 
				 int insertCnt = commonHandler.insertQuestions(con, newTitle, userId, userName, registerUserId, password, questionList, categoryCode);
			 }
		} catch (AppException e) {
			e.printStackTrace();
			throw new KankokujinException("QuestionsRegistAction", e);

		} finally {
			file.delete();
			if (upzipFileList != null) {
				for (File unzipFile: upzipFileList) {
					unzipFile.delete();
				}
			}
			KankokujinLogger.getInstance().debug("QuestionsRegistAction.end");
		}
		actionName = (String)session.getAttribute("action");
		response.sendRedirect(actionName);

	}
}
