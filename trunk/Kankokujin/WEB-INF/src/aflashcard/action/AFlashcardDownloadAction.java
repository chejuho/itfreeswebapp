package aflashcard.action;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aflashcard.bean.Question;
import aflashcard.handle.AFlashcardDBHandler;
import aflashcard.handle.AFlashcardUtil;


import common.database.DBConnectionMgr;
import common.exception.AppException;
import common.exception.KankokujinException;
import common.logger.KankokujinLogger;

public class AFlashcardDownloadAction extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static final String SEPARATE = "|";

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		Connection con = null;
		// ファイル読み込み用バッファ
		// クライアント側の文字エンコーディングのままのファイル名
		String groupId = request.getParameter("id");
		String userId = request.getParameter("userId");
		Map<String, String> groupInfo = null;
		AFlashcardDBHandler commonHandler = AFlashcardDBHandler.getInstance();
		List<Question> questions = null;
		try {
			con = DBConnectionMgr.getInstance().getConnection();
			groupInfo = commonHandler.getGroupInfo(con, groupId, userId);
			questions = commonHandler.getMemorizerListAll(con, groupId);
		} catch (AppException e) {
			throw new KankokujinException(e.getMessage(), e);
		} catch (Exception e) {
			throw new KankokujinException("SYE0023", e);
		} finally {
			if (con != null) {
				DBConnectionMgr.getInstance().freeConnection(con);
			}
			KankokujinLogger.getInstance().debug("MemorizerListAction.end");
		}

		// 拡張子からcontentTypeを獲得
		String contentType = "application/octet-stream;charset=UTF-8";

		

		// ファイル内容の出力
		ServletOutputStream out = response.getOutputStream();
		String homePath = getServletContext().getRealPath("");
		System.out.println(homePath);
		File downLoadTempFile = AFlashcardUtil.questionListToFile(groupInfo.get("group_name"), questions, homePath);
		
		String ext = "";
		
		if (downLoadTempFile.getAbsolutePath().endsWith(".zip")) {
			ext = ".zip";
		} else {
			ext = ".txt";
		}
		
		// contentTypeを出力
		response.setContentType(contentType);
		// ファイル名の送信(attachment部分をinlineに変更すればインライン表示)
		response.setHeader("Content-disposition", "attachment; filename=\""
				+ new String(groupInfo.get("group_name").getBytes("UTF-8"),
						"ISO-8859-1") + ext + "\"");
		byte[] docfile = loadFile(downLoadTempFile.getPath());

		response.setContentLength(docfile.length) ;
		out.write(docfile);
		out.flush();
		out.close();
		downLoadTempFile.delete();
		//		for (Question question : questions) {
//			String write = "";
//			write = question.getQuestion() + SEPARATE + question.getAnswer();
//			out.write(write.getBytes("UTF-8"));
//			out.write("\r\n".getBytes("UTF-8"));
//		}
		
	}

	/**
	 * Reads the file and returns its content as a byte array
	 * 
	 * @param FileName
	 * @return file as byte array
	 * @throws IOException
	 */
	public static byte[] loadFile(String fileName) throws IOException {
		byte[] byteArray = null;
		BufferedInputStream fileInBuf = null;
		ByteArrayOutputStream baos = null;
		try {

			if (fileName == null) {
				return new byte[0];
			}

			FileInputStream fileIn = new FileInputStream(fileName);
			fileInBuf = new BufferedInputStream(fileIn);

			//fis = new FileInputStream(FileName);

			final int BUF_SIZE = 4096;
			byte buf[] = new byte[BUF_SIZE];
			int length = 0;
			baos = new ByteArrayOutputStream();

			while ((length = fileInBuf.read(buf)) > 0) {
				baos.write(buf, 0, length);

			}
			byteArray = baos.toByteArray();

		} catch (IOException e) {
			throw e;
		} finally {
			if (fileInBuf != null) {
				fileInBuf.close();
			}
			if (baos != null) {
				baos.close();
			}
		}
		return byteArray;
	}
}