package common.batch.url;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import common.logger.KankokujinLogger;



public class URLReader {

	public URLReader() {
	}

	/**
	 * 
	 * @param url
	 * @return
	 * @throws Exception 
	 */
	public String readHtml(URL url) throws Exception {
		
		String html = null;
		StringBuffer sb = new StringBuffer();
		BufferedReader bs = null;
		try {
			//InputStream in = url.openStream();
			String encoding = getCharSet(url);
			bs = new BufferedReader(new InputStreamReader(url.openStream(), encoding));
			for (String str = null; (str = bs.readLine()) != null;) {
				sb.append(str);
				sb.append("\n");
		     }
		} catch (Exception e) {
			throw e;
		} finally {
			try {
				if (bs != null) {
					bs.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		html = sb.toString();
		
		return html;
	}
	
	
	/**
	 * 
	 * @param url
	 * @return
	 * @throws Exception 
	 */
	public String readHtml(URL url, String encoding) throws Exception {
		String html = null;
		StringBuffer sb = new StringBuffer();
		BufferedReader bs = null;
		try {
			//InputStream in = url.openStream();
			bs = new BufferedReader(new InputStreamReader(url.openStream(), encoding));
			for (String str = null; (str = bs.readLine()) != null;) {
				sb.append(str);
				sb.append("\n");
		     }
		} catch (Exception e) {
			throw e;
		} finally {
			try {
				if (bs != null) {
					bs.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		html = sb.toString();
		Set<String> alinkList = searchALinkList(html);
		Set<String> filterAlinkList = filterAlink(alinkList, url);
		
		for (Iterator<String> it = filterAlinkList.iterator(); it.hasNext();) {
			String link = it.next();
			html = editLink(2, link, url, html);
		}
		//System.out.println(html);
		
		return html;
	}
	
	public String getCharSet(URL url) throws Exception {
		BufferedReader bs = null;
		String charset = null;
		try {
			bs = new BufferedReader(new InputStreamReader(url.openStream()));
			// HTMLソースの表示
		      for (String str = null; (str = bs.readLine()) != null;) {
		    	  charset = getCharSet(str);
		    	  if (charset.length() != 0) {
		    		  break;
		    	  }
		      }
		} catch (Exception e) {
			System.err.println("Exception : " + e);
			throw e;
		} finally {
			try {
				if (bs != null) {
					bs.close();
				}
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return charset; 
	}
	
	
	private String getCharSet(String html) {
		String charset = "";
		String contentMatch = "content=\"text/html;.*?charset=(.+)\"";
		Pattern pattern = Pattern.compile(contentMatch);
		Matcher matcher = pattern.matcher(html);
		
		if (matcher.find()) {
			charset = matcher.group(1);
		}
		return charset; 
	}

	
	public File getURLToFileName(URL url, File dir) {
		
		String domain = url.getAuthority();
		
		StringBuffer fileName = new StringBuffer();
		fileName.append(domain);
		fileName.append(getURLPathName(url));
		
		//String filePath = url.getFile();
		File file = new File(dir, fileName.toString());
		return file;
	}
	
	/**
	 * @param url
	 * @return
	 */
	public String getURLPathName(URL url) {
		
		String path = url.getPath();
		
		StringBuffer pathBuffer = new StringBuffer();
		List<String> list = new ArrayList<String>(); 
		
		StringTokenizer st = new StringTokenizer(path, "/");
		while (st.hasMoreTokens()) {
			String token = st.nextToken();
			list.add(token);
		}
		pathBuffer.append("/");
		int size = list.size();
		for (int i = 0; i < size; i++) {
			String next = list.get(i);
			if (i != size - 1) {
				pathBuffer.append(next);
				pathBuffer.append("/");
			} else {
				if (next.indexOf(".") == -1) {
					pathBuffer.append(next);
					pathBuffer.append("/");
				}
			}
			
		}
		return pathBuffer.toString();
	}
	
	
	/**
	 * @param url
	 * @return
	 */
	public String getURLFileName(URL url) {
		
		StringBuffer resultFileName = new StringBuffer();
		
		String filename = "";
		
		String urlPath = url.getFile();
		
		StringTokenizer st = new StringTokenizer(urlPath, "/");
		
		while (st.hasMoreTokens()) {
			filename = st.nextToken();
		}
		
		//folderの場合
		//http://itpro.nikkeibp.co.jp/article/COLUMN/20090709/333467/ or
		//http://itpro.nikkeibp.co.jp/article/COLUMN/20090709/333467
		if (filename.indexOf(".") == -1 && filename.indexOf("?") == -1) {
			resultFileName.append("index.html");
		//Queryがある場合
		//http://itpro.nikkeibp.co.jp/article/COLUMN/20090709/333467/?ST=android-dev&P=2 or
		//	==> _ST_android_-dev_p_2.html
		//http://itpro.nikkeibp.co.jp/article/COLUMN/20090709/333467/aaa?ST=android-dev&P=2 or
		//	==> aaa_ST_android-dev_P_2.html
		//http://itpro.nikkeibp.co.jp/article/COLUMN/20090709/333467/aaa.php?ST=android-dev&P=2 or
		//	==> aaa_php_ST_android-dev_P_2.html
		} else if (filename.indexOf("?") >= 0) {
			filename = filename.replaceAll("\\.", "_");
			filename = filename.replace("?", "_");
			filename = filename.replaceAll("&", "_");
			filename = filename.replaceAll("=", "_");
			
			resultFileName.append(filename);
			resultFileName.append(".html");
			
		//正常の場合
		//http://itpro.nikkeibp.co.jp/article/COLUMN/20090709/333467/index.html or
		//http://itpro.nikkeibp.co.jp/article/COLUMN/20090709/333467/index.php or index.jsp
		} else if (filename.indexOf(".") >= 0 && filename.indexOf("?") == -1) {
			int index = filename.indexOf(".");
			String ext = filename.substring(index, filename.length());
			
			if (".html".equals(ext) || ".htm".equals(ext)) {
				resultFileName.append(filename);
			} else {
				resultFileName.append(filename);
				resultFileName.append(".html");
			}
		}
		
		return resultFileName.toString();
	}
	
	/**
	 * 
	 * @param path
	 * @return
	 */
	private String getPath(String path) {
		StringBuffer pathBuffer = new StringBuffer();
		List<String> list = new ArrayList<String>(); 
		
		StringTokenizer st = new StringTokenizer(path, "/");
		while (st.hasMoreTokens()) {
			String token = st.nextToken();
			list.add(token);
		}
		pathBuffer.append("/");
		int size = list.size();
		for (int i = 0; i < size; i++) {
			String next = list.get(i);
			if (i != size - 1) {
				pathBuffer.append(next);
				pathBuffer.append("/");
			} else {
				if (next.indexOf(".") == -1) {
					pathBuffer.append(next);
					pathBuffer.append("/");
				}
			}
			
		}
		return pathBuffer.toString();
	}
	
	/**
	 * 
	 * @param htmlText
	 * @return
	 */
	public List<String> searchImageLinkList(String htmlText) {
		
		//String imageLinkMatch = "<img src=\"(.+(gif|jpg|png))\"[^<]";
		String imageLinkMatch = "<img.+?src[^=]*=[^\"\']*[\"\']([^\"\']*)[\"\'][^>]*>";
		List<String> imageLinkList = new ArrayList<String>();
		Pattern pattern = Pattern.compile(imageLinkMatch, Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(htmlText);
		int start = 0;
		while (matcher.find(start)) {
			String match = matcher.group(1).toLowerCase();
			if (match.indexOf("jpg") >= 0 || match.indexOf("gif") >= 0 || match.indexOf("png") >= 0) {
				if (match.indexOf("?") == -1 && match.indexOf("'") == -1) {
					imageLinkList.add(matcher.group(1));
				}
			}
			start = matcher.end();
		}
		return imageLinkList;
		
	}
	
	/**
	 * cssファイル　Link抽出
	 * @param htmlText
	 * @return
	 */
	public List<String> searchCssLinkList(String htmlText) {
		String jsLinkMatch = "HREF=\"(.+(\\.css))\"";
		
		List<String> cssLinkList = new ArrayList<String>();
		Pattern pattern = Pattern.compile(jsLinkMatch, Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(htmlText);
		int start = 0;
		while (matcher.find(start)) {
			String match = matcher.group(1);
			if (match.indexOf("?") == -1 && match.indexOf("'") == -1) {
				cssLinkList.add(match);
			}
			start = matcher.end();
			
		}
		return cssLinkList;
	}
	
	/**
	 * jsファイル　Link抽出
	 * @param htmlText
	 * @return
	 */
	public List<String> searchJsLinkList(String htmlText) {
		String jsLinkMatch = "src=\"(.+(\\.js))\"";
		
		List<String> jsLinkList = new ArrayList<String>();
		Pattern pattern = Pattern.compile(jsLinkMatch, Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(htmlText);
		int start = 0;
		while (matcher.find(start)) {
			String match = matcher.group(1);
			if (match.indexOf("?") == -1 && match.indexOf("'") == -1) {
				jsLinkList.add(match);
			}
			start = matcher.end();
			
		}
		return jsLinkList;
	}
	
	public Set<String> searchALinkList(String htmlText) {
		//String aLinkMatch = "<a href=\"([^\"]+)\">";
		String aLinkMatch = "<a.*?href=\"(.*?)\".*?>";
		Set<String> aLinkList = new HashSet<String>();
		Pattern pattern = Pattern.compile(aLinkMatch, Pattern.DOTALL); 
		Matcher matcher = pattern.matcher(htmlText);
		int start = 0;
		while (matcher.find(start)) {
			//System.out.println(matcher.group(1));
			aLinkList.add(matcher.group(1));
			start = matcher.end();
		}
		return aLinkList;
	}
	
	public Set<String> filterAlink(Set<String> aLinkList, URL nowPageUrl) {
		Set<String> filterList = new HashSet<String>();
		
		for (Iterator<String> it = aLinkList.iterator(); it.hasNext();) {
			String link = it.next();
			if (isDownLoadPage(link, nowPageUrl)) {
				filterList.add(link);
			}
		}
		return filterList;
	}
	/**
	 * 
	 * @param aLink
	 * @return
	 */
	private boolean isDownLoadPage(String aLink, URL nowPageUrl) {
		
		if (isMainPage(aLink, nowPageUrl)) {
			return false;
		}
		
		//例外を対応するので
//		if (aLink.indexOf("?") >= 0) {
//			return false;
//		} else if (isDirectory(aLink)) {
//			return false;
//		}
		
		//内部リンク
		if (aLink.indexOf("http://") == -1 && aLink.indexOf("https://") == -1) {
			if (aLink.equals("/")) {
				return false;
			} else if (aLink.indexOf("#") >= 0) {
				return false;
			} else if (aLink.indexOf("javascript:") >= 0) {
				return false;
			} 
			return true;
		//外部リンク
		} else {
			if (!isEqualDomain(aLink, nowPageUrl)) {
				return false;
			}
			return true;
		}
		
	}
	private boolean isMainPage(String aLink, URL nowPageUrl) {
	
		StringBuffer mainPage = new StringBuffer();
		mainPage.append("http://");
		mainPage.append(nowPageUrl.getAuthority());
		
		if (aLink.equals(mainPage.toString()) || aLink.equals(mainPage.toString() + "/")) {
			return true;
		}
		
		return false;
	}

	/**
	 * 
	 * @param aLink
	 * @param url
	 * @return
	 * @throws MalformedURLException
	 */
	public String getAbsolutePath(String aLink, URL nowPageUrl) {
		String domain = nowPageUrl.getAuthority();
		String fullPath = nowPageUrl.getPath();
		// 外部パース
		if (aLink.indexOf("http://") >= 0) {
				return aLink;
		// 内部パース		
		} else if (aLink.indexOf("http://") == -1) {
			StringBuffer linkUrl = new StringBuffer();
			
			if (aLink.indexOf("//") == 0) {
				linkUrl.append("http:");
				linkUrl.append(aLink);
				return linkUrl.toString();
			}
			linkUrl.append("http://");
			linkUrl.append(domain);
			//現在ページの場合
			if (aLink.indexOf("/") == -1) {
				if (aLink.indexOf("#") == 0) {
					linkUrl.append(fullPath);
					linkUrl.append(aLink);
				} else {
					String path = getPath(nowPageUrl.getPath());
					linkUrl.append(path);
					linkUrl.append(aLink);
				}
			} else if (aLink.indexOf("../") > 0) {
				System.out.println(aLink.indexOf("../"));
			} else if (aLink.indexOf("./") >= 0) {
				List<String> pathList = linkToList(fullPath);
				int index = pathList.size() - 1;
				for (int i = 0; i < index; i++) {
					linkUrl.append("/");
					linkUrl.append(pathList.get(i));
				}
				linkUrl.append(aLink.substring(1, aLink.length()));
			} else {
				linkUrl.append(aLink);
			}
		
			return linkUrl.toString();
		}
		return null;
		}
	
	/**
	 * 
	 * @param linkList link情報
	 * @param pageUrl  プールパス
	 * @param downloadFolder
	 * @throws Exception 
	 */
	public void downLoadResourceFile(List<String> linkList, URL pageUrl, File dir) {
		for (Iterator<String> it = linkList.iterator(); it.hasNext();) {
			String link = (String) it.next();
			
			String url = null;
			File reourceFile = null;
			try {
				url = getAbsolutePath(link, pageUrl);
				//System.out.println(url.getPath());
				byte[] image = readByte(url);
				if (image != null) {
					File resourceDir = getResourceFileDir(dir, pageUrl);
					if (!resourceDir.isDirectory()) {
						resourceDir.mkdirs();
					}
					String filename = getResourceFileName(link);
					reourceFile = new File(resourceDir, filename);
					writeFile(image, reourceFile);
				}
			} catch (Exception e) {
				
				KankokujinLogger.getInstance().debug("リソース取得失敗," + pageUrl.toString() + "\t" + url + "\t" + link);
				e.printStackTrace();
			} 
		}
		
	}
	
	/**
	 * 
	 * @param html
	 * @param linkList
	 * @return
	 */
	public String editResourceLink(String html, List<String> linkList, URL pageUrl, File dir) {
		//String editHtml = html;
		for (Iterator<String> it = linkList.iterator(); it.hasNext();) {
			String link = (String) it.next();
			String filename = getResourceFileName(link);
			Pattern pattern = Pattern.compile(link);
			Matcher matcher = pattern.matcher(html);
			String resourceDir = getResourceFileName(pageUrl.getPath());
			html = matcher.replaceAll(resourceDir + ".files" + "/" + filename);
		}
		return html;
	}
	
	/**
	 * 
	 * @param aLink
	 * @param url
	 * @return
	 */
	public boolean isEqualDomain(String aLink, URL url) {

		String domain = url.getAuthority();
		if (aLink.indexOf("http://") >= 0 || aLink.indexOf("https://") >= 0) {
			if (aLink.indexOf(domain) >= 0) {
				return true;
			}
		} else if (aLink.indexOf("http://") == -1 || aLink.indexOf("https://") == -1) {
			return true;
		}
		return false;

	}
	
	/**
	 * リソースDirを取得
	 * @param dir
	 * @param pageUrl
	 * @return
	 */
	private File getResourceFileDir(File dir, URL pageUrl) {
		
		String filename = getResourceFileName(pageUrl.getPath());
		
		File resourceFileDir = new File(dir.getAbsolutePath() + "/" + filename + ".files");
		
		return resourceFileDir;
	}
	
	/**
	 * 
	 * @param option
	 *  1 : 同じdomain絶対リンク -> 相対リンクに変換
	 *  2 : 同じdomain相対リンク -> 絶対リンク
	 * @return
	 */
	public String editLink(int option, String innerLink, URL url) {
		String editLink = null;
		//違うdomain ->該当なし
		if (!isEqualDomain(innerLink, url)) {
			return innerLink;
		}
		if (option == 1) {
			try {
				editLink = absolutePathToRelativePath(innerLink, url);
			} catch (MalformedURLException e) {
				editLink = "";
			}
		} else if(option == 2) {
			editLink = relativePathToAbsolutePath(innerLink, url);
		}
		return editLink;
	}
	
	public String replaceHtml(String html, String target, String replacement) {
		
		//target = "\"" + target + "\"";
		//System.out.println("target=" + target);
		String newHtml = html;
		if (replacement.length() != 0) {
			target = "\"" + target+ "\"";
			replacement = "\"" + replacement+ "\"";

			while (newHtml.indexOf(target) >= 0) {
				newHtml = newHtml.replace(target, replacement);
			}
		}
		return newHtml;
	}
	
	/**
	 * 
	 * @param innerLink
	 * @param url2
	 * @param html
	 * @return
	 * @throws MalformedURLException 
	 */
	public String editLink(int option, String innerLink, URL url, String html) {
		
		if (option == 0) {
			return html;
		}
		String newLink = editLink(option, innerLink, url);
		return replaceHtml(html, innerLink, newLink);
	}
	
	private String absolutePathToRelativePath(String innerLink, URL url) throws MalformedURLException {
		//System.out.println("innerLink=" + innerLink);
		StringBuffer path = new StringBuffer();
		String upLink = "..";
		String conent = "http://";
		//String urlPath = url.getPath();
		URL link = new URL(innerLink);
		innerLink = getURLPathName(link) + getURLFileName(link);
		String urlPath = url.getFile();
		//絶対パースを相対パースに変更
		if (innerLink.indexOf(conent) >= 0 || innerLink.indexOf("/") == 0) {
			String innerLinkPath = null;
			if (innerLink.indexOf(conent) >= 0) {
				URL innerLinkURL = new URL(innerLink);
				innerLinkPath = innerLinkURL.getPath();
			} else {
				innerLinkPath = innerLink;
			}
			
			List<String> innerLinkList = linkToList(innerLinkPath);
			List<String> urlPathList = linkToList(urlPath);
			
			int genziaLinkcnt = urlPathList.size();
			int equalCnt = 0;
			if (innerLinkList.size() > urlPathList.size()) {
				for (int i = 0; i < urlPathList.size(); i++) {
					if (innerLinkList.get(i).equals(urlPathList.get(i))) {
						++equalCnt;
					} else {
						break;
					}
				}
			} else {
				for (int i = 0; i < innerLinkList.size(); i++) {
					if (innerLinkList.get(i).equals(urlPathList.get(i))) {
						++equalCnt;
					} else {
						break;
					}
				}
			}
			//内部リンクが大きい場合
			int upLinkCnt = genziaLinkcnt - equalCnt - 1;
			
			if (upLinkCnt < 0) {
				
				if (upLinkCnt == -1) {
					path.append(innerLinkList.get(innerLinkList.size() - 1));
				} else {
					path.append(innerLinkList.get(equalCnt - 1));
				}
				
			} else {
				for (int i = 0; i < upLinkCnt; i++) {
					path.append(upLink);
					path.append("/");
				}
				for (int j = equalCnt; j < innerLinkList.size(); j++) {
					path.append(innerLinkList.get(j));
					path.append("/");
				}
				path.deleteCharAt(path.length() - 1);
			}
		} else {
			path.append(innerLink);
		}
		
	
		return path.toString();
	}
	
	private String relativePathToAbsolutePath(String innerLink, URL url) {
		
		StringBuffer path = new StringBuffer();
		String conent = "http://";
		String domain = url.getAuthority();
		String urlPath = url.getPath();
		
		//内部パースだけ対応
		if (innerLink.indexOf(conent) == -1) {
			//index.htmlの場合
			if (innerLink.indexOf("/") == -1) {
				path.append(conent);
				path.append(domain);
				path.append(getPath(urlPath));
				path.append(innerLink);
			
			} else if (innerLink.indexOf("./") == 0) {
				path.append(url.toString());
			//../android01_2.html	
			} else if (innerLink.indexOf("../") >= 0) {
				String nowURLPath = getPath(urlPath);
				List<String> linkList = linkToList(nowURLPath);
				
				int upCnt = 0;
				while (innerLink.indexOf("../") >= 0) {
					upCnt++;
					innerLink = innerLink.replaceFirst("../", "");
				}
				int dirCnt = linkList.size() - upCnt;
				path.append(conent);
				path.append(domain);
				for (int i = 0; i < dirCnt; i++) {
					path.append("/");
					path.append(linkList.get(i));
				}
				path.append("/");
				path.append(innerLink);
			} else {
				if (innerLink.indexOf("/") != 0) {
					path.append(url.toString());
					path.append(innerLink);
				} else {
					path.append(conent);
					path.append(domain);
					path.append(innerLink);
				}
				
				//path.append(innerLink);
			}
		}
		return path.toString();
		
	}
	
	private List<String> linkToList(String path) {
		
		List<String> list = new ArrayList<String>();
		StringTokenizer st = new StringTokenizer(path, "/");
		
		while (st.hasMoreTokens()) {
			list.add(st.nextToken());
		}
		return list;
	}
	
	
	/**
	 * 
	 * @param editHtml
	 * @param alinkList
	 * @param resoureFileDir
	 * @return
	 */
	public String editInnerLink(String html, List<String> alinkList,
			URL url) {
		
		String domain = getDomain(url);
		for (Iterator<String> it = alinkList.iterator(); it.hasNext();) {
			String link = (String) it.next();
			String linkSearch = "href=\"" + link + "\"";
			if (link.indexOf("http://") == -1 && link.indexOf("#") == -1) {
				Pattern pattern = Pattern.compile(linkSearch);
				Matcher matcher = pattern.matcher(html);
				if (matcher.find()) {
					html = matcher.replaceAll("href=\"" + domain + link + "\"");
				}
			}
		}
		return html;
	}
	
	
	private String getResourceFileName(String link) {
		String filename = null;
		StringTokenizer st = new StringTokenizer(link, "/");
		
		while (st.hasMoreTokens()) {
			filename = st.nextToken();
		}

		//System.out.println(filename);
		return filename;
	}
	
	private boolean writeFile(byte[] bytes, File file) throws Exception {
		boolean sign = false;
		BufferedOutputStream fis = null;
	        try {
	            //File file = new File("C:/Winter_clone.jpg");
	            file.createNewFile();
	            fis = new BufferedOutputStream(new FileOutputStream(file));
	            fis.write(bytes);
	        } catch (Exception e) {
	        	throw e;
	        	
	        } finally {
                if (fis != null) {
                    fis.close();
                }
	        }
		return sign;
	}
	private byte[] readByte(String uri) throws Exception {
		byte[] bytes = null;
	    DataInputStream dis = null;
        try {
        	URL url = new URL(uri);
        	URLConnection urlcon = url.openConnection();
			urlcon.setDoInput(true);

			int length = urlcon.getContentLength();

			if (length > 0) {
				dis = new DataInputStream(urlcon.getInputStream());
				bytes = new byte[length];
				for(int i=0;i<length;i++) {
					bytes[i] = dis.readByte();
				}
			}
			
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            try {
                if (dis != null) {
                	dis.close();
                }
            } catch (IOException e) {
            }
        }
        return bytes;

    }

	
	private String getDomain(URL u) {
		StringBuffer domain = new StringBuffer();
		String mark = "http://";
		domain.append(mark);
		domain.append(u.getAuthority());
		
		return domain.toString();	
	}



}
