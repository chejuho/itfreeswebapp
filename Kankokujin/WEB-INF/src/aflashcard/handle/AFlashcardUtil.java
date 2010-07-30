package aflashcard.handle;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;



import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.tools.zip.ZipEntry;
import org.apache.tools.zip.ZipFile;
import org.apache.tools.zip.ZipOutputStream;
import org.mozilla.universalchardet.UniversalDetector;

import aflashcard.bean.Question;

import common.constant.Const;

public class AFlashcardUtil {

	private static final String HEXINDEX = "0123456789abcdef          ABCDEF";
	private static final String FILE_SEPARATOR = System.getProperty("file.separator");
	private static final String FILE_HOME = System.getProperty("user.dir");
	private final static String SEPARATION = "\\|";
	private final static String SEPARATE = "|";
	private final static String COMMA = "\\,";
	private final static String TAB = "\t";

	private final static String SAVE_FOLDER = Const.UPLOAD_FOLDER_PATH + "images";
	private final static String IMAGE_PATH = Const.IMAGE_FOLDER_PATH + "images/";
	public final static int SUCCESS = 0;
	public final static int ERROR_INPUT = 1;
	public final static int ERROR_NAME_DUPLICATION = 2;
	public final static int ERROR_FORMAT = 3;
	public final static int ERROR_FILENAME = 4;
	public final static int ERROR_SYSTEM = 5;
	public final static int ERROR_SRCNOTFOUND = 6;

	private static final int EOF = -1;
	private static final int ZIP_BUFF_SIZE = 1024;

	private AFlashcardUtil() {

	}
	
	public static boolean getMobileSign(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String mobileSign = request.getParameter("m");
		if (mobileSign == null) {
			String sign = (String) session.getAttribute("m");
			if (sign != null && sign.equals("t")) {
				return true;
			} else {
				return false;
			}
		} else {
			session.setAttribute("m", mobileSign);
			
			if (mobileSign.equals("t")) {
				return true;
			} else {
				return false;
			}
			
		}
	}
	
	public static String getUserId(HttpServletRequest request) {
		String localeUserId = request.getParameter("localUserId");
		String userId = request.getParameter("userId");
		String language = null;
		HttpSession session = request.getSession();
		if (localeUserId != null) {
			language = request.getLocale().getLanguage();
			if ("ko".equals(language)) {
				userId = "k_admin";
			} else if ("ja".equals(language)) {
				userId = "j_admin";
			} else if ("en".equals(language)) {
				userId = "e_admin";
			} else if ("zh".equals(language)) {
				userId = "c_admin";
			} else {
				userId = "";
			}
		} else {
			if (userId == null) {
				userId = (String) session.getAttribute("userId");
				if (userId == null) {
					language = request.getLocale().getLanguage();
					
					if ("ko".equals(language)) {
						userId = "k_admin";
					} else if ("ja".equals(language)) {
						userId = "j_admin";
					} else if ("en".equals(language)) {
						userId = "e_admin";
					} else if ("zh".equals(language)) {
						userId = "c_admin";
					} else {
						userId = "";
					}
				}
			}
			if (!"k_admin".equals(userId) && 
					!"j_admin".equals(userId) && 
					!"c_admin".equals(userId) && 
					!"e_admin".equals(userId)) {
				userId = "e_admin";
			} 
		}
		
		return userId;
	}
	
	public static void setLocaleInfo(HttpServletRequest request, String userId) {
		HttpSession session = request.getSession();
		Locale localeInfo = Locale.ENGLISH;
		if ("k_admin".equals(userId)) {
			localeInfo = Locale.KOREAN;
		} else if("j_admin".equals(userId)) {
			localeInfo = Locale.JAPANESE;
		} else if("c_admin".equals(userId)) {
			localeInfo = Locale.CHINESE;
		}
		session.setAttribute("LocaleInfo", localeInfo);
		session.setAttribute("UserLocale", userId);
	}
	
	
	public static List<Question> fileToMemorizeInfoList(String filePath,
			boolean displayOption) throws IOException {

		File dataFile = new File(filePath);
		FileInputStream inputStream = new FileInputStream(dataFile);

		if (dataFile.getName().toLowerCase().endsWith("xls")) {
			return xlsFileStreamToMemorizeInfoList(inputStream);
		} else {
			String encoding = getEncoding(dataFile);
			return getQuestionListFromFile(dataFile, displayOption, encoding);
		}

	}

	public static String getImagePath(String path) {
		String imagePath = "";
		String patternStr = "\\*I(.+)I\\*";
		Pattern pattern = Pattern.compile(patternStr);
		Matcher matcher = pattern.matcher(path);
		if (matcher.find()) {
			imagePath = matcher.group(1);
		}
		return imagePath;
	}

	/**
	 * 
	 * @param list
	 * @param importFile
	 * @param newFilename
	 * @throws Exception
	 */
	public static void resourcesProcess(List<Question> list, File importFile) {

		for (Question bean : list) {

			String questionNewImagePath = imageFileMove(bean.getQuestion(),
					importFile);
			String answerNewImagePath = imageFileMove(bean.getAnswer(),
					importFile);

			if (questionNewImagePath.length() != 0) {
				bean.setQuestion(questionNewImagePath);
			}
			if (answerNewImagePath.length() != 0) {
				bean.setAnswer(answerNewImagePath);
			}

		}
	}

	public static boolean isImage(String str) {
		String imagePath = getImagePath(str);

		if (imagePath.length() == 0) {
			return false;
		} else {
			return true;
		}
	}

	public static File zip(String zipFilename, String[] targetFiles,
			String encoding) throws ZipException, FileNotFoundException, IOException {
		int n = targetFiles.length;
		File[] files = new File[n];
		for (int i = 0; i < n; i++) {
			files[i] = new File(targetFiles[i]);
		}
		return null;//zip(new File(zipFilename), files, encoding, "");
	}
	public static File questionListToFile(String groupName, List<Question> questions, String resourcePath) throws IOException {
		
		FileOutputStream fos = null;
		List<File> resourceFileList = new ArrayList<File>();
		File createFile = new File(resourcePath + FILE_SEPARATOR + String.valueOf(System.currentTimeMillis()));

		try {
			fos = new FileOutputStream(createFile);
			for (Question question : questions) {
				
				String write = "";
				String questionStr = question.getQuestion();
				String answerStr = question.getAnswer();
				//imageファイルの場合
				String qImagePath = getImagePath(questionStr);
				String aImagePath = getImagePath(answerStr);
				if (qImagePath.length() > 0 || aImagePath.length() > 0) {
					String tmpQuestionPath = questionStr;
					String tmpAnswerPath = answerStr;
					if (qImagePath.length() > 0) {
						resourceFileList.add(new File(resourcePath + FILE_SEPARATOR + qImagePath));
						tmpQuestionPath = "*I" + questionStr.replaceAll("\\*Iupload/", "");
					}
					if (aImagePath.length() > 0) {
						resourceFileList.add(new File(resourcePath + FILE_SEPARATOR + aImagePath));
						tmpAnswerPath = "*I" + answerStr.replaceAll("\\*Iupload/", "");
					}
					//resourceFile.add(new File(qImagePath));
					write = tmpQuestionPath + TAB + tmpAnswerPath;
				} else {
					write = questionStr + TAB + answerStr;
				}
				
				fos.write(write.getBytes("UTF-8"));
				fos.write("\r\n".getBytes("UTF-8"));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw e;
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			throw e;
		} catch (IOException e) {
			e.printStackTrace();
			throw e;
		} finally {
			fos.close();
		}
		//imageファイルがある場合
		if (resourceFileList.size() > 0) {
			//System.out.println(FILE_HOME); 
			File zipFile = new File(String.valueOf(System.currentTimeMillis()) + ".zip");
			//resourceFileList.add(createFile);
			//(String[])list.toArray(new String[0]);
			return zip(groupName, zipFile,  createFile, resourceFileList.toArray(new File[0]), "UTF-8", resourcePath);
			
		}
		
		return createFile;
	}
		
	private static File zip(String groupName, File zipFile, File txtFile, File[] targetFiles, String encoding, String resourcePath)
			throws ZipException, FileNotFoundException, IOException {
		ZipOutputStream out = new ZipOutputStream(new FileOutputStream(zipFile));
		out.setEncoding(encoding);
		ZipEntry maintarget = new ZipEntry(groupName + ".txt");
		out.putNextEntry(maintarget);
		byte mainbuf[] = new byte[ZIP_BUFF_SIZE];
		int maincount;
		BufferedInputStream mainin = new BufferedInputStream(new FileInputStream(txtFile));
		while ((maincount = mainin.read(mainbuf, 0, ZIP_BUFF_SIZE)) != EOF) {
			out.write(mainbuf, 0, maincount);
		}
		mainin.close();
		out.closeEntry();
		for (File targetFile : targetFiles) {
			//int deleteLength = targetFile.getPath().length() - targetFile.getName().length();
			//zip(out, targetFile);
			ZipEntry target = new ZipEntry("images" + "/" + targetFile.getName());
			out.putNextEntry(target);
			byte buf[] = new byte[ZIP_BUFF_SIZE];
			int count;
			System.out.println(targetFile.getAbsolutePath());
			BufferedInputStream in = new BufferedInputStream(new FileInputStream(targetFile));
			//BufferedInputStream in = new BufferedInputStream(new FileInputStream(targetFile.getAbsolutePath()));
			while ((count = in.read(buf, 0, ZIP_BUFF_SIZE)) != EOF) {
				out.write(buf, 0, count);
			}
			in.close();
			out.closeEntry();
		}
		out.close();
		return zipFile;
	}


	private static String imageFileMove(String pathInfo, File importFile) {

		boolean isExists = false;
		String imagePath = getImagePath(pathInfo);

		if (imagePath.length() == 0) {
			return "";
		}

		File srcImagePath = new File(importFile.getParent() + FILE_SEPARATOR
				+ imagePath);

		isExists = srcImagePath.exists();

		if (!isExists) {

			File searchFile = getFileSearch(new File(importFile.getParent()),
					srcImagePath.getName());
			if (searchFile != null) {
				srcImagePath = searchFile;
			} else {
				return "";
			}
		}
		File destFile = new File(SAVE_FOLDER, srcImagePath.getName());
		destFile.getParentFile().mkdirs();
		fileMoveProcess(srcImagePath, destFile);

		return "*I" + IMAGE_PATH + destFile.getName() + "I*";
	}

	private static List<Question> xlsFileStreamToMemorizeInfoList(
			InputStream inputStream) throws IOException {

		List<Question> list = new ArrayList<Question>();
		try {
			POIFSFileSystem fs = new POIFSFileSystem(inputStream);
			HSSFWorkbook wb = new HSSFWorkbook(fs);

			HSSFSheet sheet = wb.getSheetAt(0);

			int firstRow = sheet.getFirstRowNum();
			int lastRow = sheet.getLastRowNum();
			// for rows
			for (int rowIdx = firstRow; rowIdx <= lastRow; rowIdx++) {

				HSSFRow row = sheet.getRow(rowIdx + 1);

				if (row == null)
					continue;

				short firstCell = row.getFirstCellNum();

				Question bean = new Question();

				for (short cellIdx = firstCell; cellIdx < 2; cellIdx++) {
					String data = null;

					HSSFCell cell = row.getCell(cellIdx);
					if (cell != null) {
						int type = cell.getCellType();
						switch (type) {
						case HSSFCell.CELL_TYPE_BOOLEAN:
							boolean bdata = cell.getBooleanCellValue();
							data = String.valueOf(bdata);
							break;
						case HSSFCell.CELL_TYPE_NUMERIC:
							double ddata = cell.getNumericCellValue();
							data = String.valueOf(ddata);
							break;
						case HSSFCell.CELL_TYPE_STRING:
							data = cell.getStringCellValue();
							break;
						case HSSFCell.CELL_TYPE_BLANK:
							data = cell.getStringCellValue();
							break;
						case HSSFCell.CELL_TYPE_ERROR:
						case HSSFCell.CELL_TYPE_FORMULA:
						default:
							continue;
						}

						if (cellIdx == 0) {
							bean.setQuestion(data.trim());
						} else if (cellIdx == 1) {
							bean.setAnswer(data.trim());
						}
					}
				}
				list.add(bean);
			}
		} catch (IOException e) {
			throw e;
		} finally {
			if (inputStream != null) {
				inputStream.close();
			}
		}

		return list;
	}

	private static File getFileSearch(File searchDir, String searchName) {

		File[] files = searchDir.listFiles();

		for (File file : files) {
			if (file.isDirectory()) {
				File searchFiles[] = file.listFiles();
				for (File searchFile : searchFiles) {
					if (searchFile.isDirectory()) {
						File search = getFileSearch(searchFile, searchName);
						if (search != null) {
							return search;
						}
					} else {
						if (searchName.equals(searchFile.getName())) {
							return searchFile;
						}
					}

				}

			}
		}

		return null;

	}

	/**
	 * 
	 * @param srcfile
	 * @param destfile
	 * @throws IOException
	 */
	private static void fileMoveProcess(File srcfile, File destfile) {

		FileChannel srcChannel = null;
		FileChannel destChannel = null;
		try {
			srcChannel = new FileInputStream(srcfile).getChannel();
			destChannel = new FileOutputStream(destfile).getChannel();
			srcChannel.transferTo(0, srcChannel.size(), destChannel);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (srcChannel != null) {
					srcChannel.close();
				}
				if (destChannel != null) {
					destChannel.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}

	private static List<Question> getQuestionListFromFile(File file,
			boolean displayOption, String encoding) throws IOException {
		List<Question> lineList = new ArrayList<Question>();
		FileInputStream inputStream = new FileInputStream(file);
		BufferedReader reader = null;
		boolean first = true;
		try {
			byte[] bom = new byte[3];
			inputStream.read(bom, 0, 3);
			String firstStr = byteToHex(bom);
			if (firstStr.equals("EFBBBF")) {
				firstStr = "";
			}
			reader = new BufferedReader(new InputStreamReader(inputStream,
					encoding));
			String line = null;
			while ((line = reader.readLine()) != null) {
				if (first) {
					line = new String(hexToByte(firstStr)) + line;
					first = false;
				}
				Question bean = changeOnlineTOBean(line, displayOption);
				if (bean != null) {
					lineList.add(bean);
				}
			}
		} catch (FileNotFoundException e) {
			throw e;
		} catch (IOException e) {
			throw e;
		} finally {
			try {
				if (reader != null) {
					reader.close();
				}
			} catch (IOException e) {
				throw e;

			}
		}
		return lineList;

	}

	public static void nowPageUrlSave(HttpSession session, String forward,
			Map<String, String> params) {
		session.setAttribute("action", makeUrl(forward, params));
	}

	public static List<File> unZip(String zipfile, String unzipDir)
			throws IOException {

		Enumeration enumer = null;

		List<File> createFileList = new ArrayList<File>();
		ZipFile zf = null;

		try {
			zf = new ZipFile(zipfile, "UTF-8");
			enumer = zf.getEntries();

			while (enumer.hasMoreElements()) {
				ZipEntry target = (ZipEntry) enumer.nextElement();
				createFileList.add(saveEntry(target, unzipDir, zf));

			}
		} catch (FileNotFoundException e) {
			throw e;
		} catch (ZipException e) {
			throw e;
		} catch (IOException e) {
			throw e;
		}

		return createFileList;
	}

	private static File saveEntry(ZipEntry target, String root, ZipFile zf)
			throws ZipException, IOException {

		File file = null;
		FileOutputStream fos = null;
		BufferedOutputStream bos = null;
		try {

			file = new File(root, target.getName());
			if (target.isDirectory()) {
				file.mkdirs();
			} else {
				InputStream is = zf.getInputStream(target);
				BufferedInputStream bis = new BufferedInputStream(is);
				File dir = new File(file.getParent());
				dir.mkdirs();
				fos = new FileOutputStream(file);
				bos = new BufferedOutputStream(fos);

				int c;
				byte buf[] = new byte[1024];
				while ((c = bis.read(buf, 0, 1024)) != -1) {
					bos.write(buf, 0, c);
				}

			}
		} catch (ZipException e) {
			throw e;
		} catch (IOException e) {
			throw e;
		} finally {
			if (bos != null) {
				bos.close();
			}
			if (fos != null) {
				fos.close();
			}
		}
		return file;
	}

	private static String makeUrl(String url, Map<String, String> params) {
		StringBuilder sb = new StringBuilder();
		sb.append(url);
		sb.append("?");
		for (Iterator<Map.Entry<String, String>> it = params.entrySet()
				.iterator(); it.hasNext();) {
			Map.Entry<String, String> entry = it.next();
			sb.append(entry.getKey());
			sb.append("=");
			sb.append(entry.getValue());
			sb.append("&");
		}
		return sb.toString();
	}

	/**
	 * 
	 * @param line
	 * @return
	 */
	private static Question changeOnlineTOBean(String line,
			boolean displayOption) {

		Question bean = null;
		String separete = getSeparate(line);
		int commaSu = getInSeparateSize(line, separete);

		if (commaSu == 1 || commaSu == 2 || commaSu == 3) {
			bean = new Question();
			int i = 3 - commaSu;
			for (String data : line.split(separete)) {
				bean.setValue(i, data, displayOption);
				i++;
			}
		}
		return bean;
	}

	private static String getSeparate(String line) {

		if (line.split(SEPARATION).length > 1) {
			return SEPARATION;
		} else if (line.split(TAB).length > 1) {
			return TAB;
		} else if (line.split(COMMA).length > 1) {
			return COMMA;
		}
		return SEPARATION;
	}

	private static int getInSeparateSize(String line, String separete) {
		int totalSize = line.length();
		int afterRemoveSize = line.replaceAll(separete, "").length();
		return totalSize - afterRemoveSize;
	}

	private static String getEncoding(File file) {
		String encoding = null;
		UniversalDetector detector = new UniversalDetector(null);
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(file);
			int nread;
			byte[] buf = new byte[4096];
			while ((nread = fis.read(buf)) > 0 && !detector.isDone()) {
				detector.handleData(buf, 0, nread);
			}
			// (3)
			detector.dataEnd();
			// (4)
			encoding = detector.getDetectedCharset();
			// Log.d("getEncoding", encoding);
			// (5)
			detector.reset();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fis != null) {
					fis.close();
				}
			} catch (IOException e) {
				e.printStackTrace();

			}
		}
		if (encoding == null) {
			encoding = "UTF-8";
		}

		return encoding;
	}

	private static byte[] hexToByte(String s) {
		int l = s.length() / 2;
		byte data[] = new byte[l];
		int j = 0;

		for (int i = 0; i < l; i++) {
			char c = s.charAt(j++);
			int n, b;

			n = HEXINDEX.indexOf(c);
			b = (n & 0xf) << 4;
			c = s.charAt(j++);
			n = HEXINDEX.indexOf(c);
			b += (n & 0xf);
			data[i] = (byte) b;
		}
		return data;
	}

	private static String byteToHex(byte[] data) {
		StringBuffer buf = new StringBuffer();
		for (int i = 0; i < data.length; i++) {
			buf.append(byteToHex(data[i]).toUpperCase());
		}
		return buf.toString();
	}

	private static String byteToHex(byte data) {
		StringBuffer buf = new StringBuffer();
		buf.append(toHexChar((data >>> 4) & 0x0F));
		buf.append(toHexChar(data & 0x0F));
		return buf.toString();
	}

	private static char toHexChar(int i) {
		if ((i >= 0) && (i <= 9)) {
			return (char) ('0' + i);
		} else {
			return (char) ('a' + (i - 10));
		}
	}

	
}
