package iboard.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class FileDownloadAction extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		// ファイル読み込み用バッファ
		byte buffer[] = new byte[4096];
		// クライアント側の文字エンコーディングのままのファイル名
		String fileName = request.getParameter("fileName");

		String utf8FileName = new String(fileName.getBytes("ISO-8859-1"), "UTF-8");

		
		// 拡張子からcontentTypeを獲得
		String contentType = "application/octet-stream;charset=UTF-8";
		
		File file = new File(getServletContext().getRealPath(utf8FileName));
		
		String outputFile = new String(file.getName().getBytes("UTF-8"), "ISO-8859-1");
		// contentTypeを出力
		response.setContentType(contentType);
		// ファイル名の送信(attachment部分をinlineに変更すればインライン表示)
		response.setHeader("Content-disposition", "attachment; filename=\"" + outputFile + "\"");
		
		// ファイル内容の出力
		ServletOutputStream out = response.getOutputStream();
		FileInputStream fin = new FileInputStream(file);
		int size;
		while ((size = fin.read(buffer)) != -1) {
			out.write(buffer, 0, size);
		}
		fin.close();
		out.close();
	}

}