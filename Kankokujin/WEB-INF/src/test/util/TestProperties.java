package test.util;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;


public class TestProperties {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		
		Properties prop = new Properties();
		FileInputStream fis;
		TestProperties testProperties = new TestProperties();
		try {
			//fis = new FileInputStream("WEB-INF\\prop\\mail.xml");
			//BufferedInputStream bis = new BufferedInputStream(fis);
			prop.setProperty("title", "タイトル");
			prop.setProperty("contents", testProperties.readFile(""));
			//prop.loadFromXML(bis);
			//System.out.println("title=" + prop.get("title"));
			//System.out.println("contents=" + prop.get("contents"));
			//prop.storeToXML(bos, "comment", "UTF-8");
		//} catch (FileNotFoundException e) {
			// TODO 自動生成された catch ブロック
			//e.printStackTrace();
		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		//Properties prop = new Properties();
//		prop.put("title", "これはタイトルです。");
//		prop.put("contents", "<html><title>タイトル</title><body>ボディ</body></html>");
		FileOutputStream fos;
		try {
			fos = new FileOutputStream("./xml/regist.xml");
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			prop.storeToXML(bos, "comment", "UTF-8");
		} catch (FileNotFoundException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

	}
	public String readFile(String filename) {
		StringBuffer sb = new StringBuffer();
		try {
			FileInputStream fis = new FileInputStream("./xml/regist.txt");
			InputStreamReader ir = new InputStreamReader(fis);
			BufferedReader br = new BufferedReader(ir);

			String str = "";
			String str1 = "";
			
			while ((str = br.readLine()) != null) {//ﾆﾄﾀﾏｼﾓﾀﾇ ｶﾎﾀﾌ ｳ｡ｳｯｶｧｱ錝・ﾇﾑｶﾎｾｿ ｽｺﾆｮｸｵﾀｸｷﾎ ﾀ惕・
				sb.append(str);
			}
			ir.close(); 
			fis.close();//ﾅｬｷﾎﾁ﨧ﾎ ｴﾝｾﾆｼｭ ｸｮｼﾒｽｺｸｦ ﾇﾘｹ・
			System.out.println("result=" + sb.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}

		return sb.toString();
	}
}
