package common.batch;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import common.logger.KankokujinLogger;

public class TestSession {

	public static void main(String[] args) throws Exception {

		// 500 heap = 185,436,632
		// 450 heap = 119,608,736
		// 481 heap = 117,005,744
		int count = 500;
		TestSession TestSession = new TestSession();
		boolean isContinue = true;
		for (int i = 0; i < count; i++) {
			KankokujinLogger.getInstance().debug("2 count=" + i);
			System.out.println("2 count=" + i);
			try {
				TestSession.readUTL();
			} catch (Exception e) {
				e.printStackTrace();
				isContinue = false;
			}
			if(!isContinue){
				break;
			}
		}

		Runtime rt = Runtime.getRuntime();
		long totalmemory = rt.totalMemory();
		long freememory = rt.freeMemory();
		long heapsize = rt.totalMemory() - rt.freeMemory();
		System.out.println("total=" + totalmemory + ",free=" + freememory
				+ ",heap=" + heapsize);
	}

	public void readUTL() throws Exception {
		URL u;
		InputStream is = null;
		DataInputStream dis;
		String s;

		try {

			// String urlStr =
			// "http://192.168.1.10/Kankokujin/MemberLogin?id='jeong'&pw='jeong'";
			// String urlStr =
			// "http://localhost/Kankokujin/MemberLogin?id='jeong'&pw='jeong'";
			// String urlStr =
			// "http://192.168.1.10/Kankokujin/StoreSearch?cate_code='C10002'&cate_code='C20003'";
			//String urlStr = "http://192.168.11.2/Kankokujin/StoreSearch?cate_code='C10002'&cate_code='C20003'";
			String urlStr = "http://localhost/Kankokujin/StoreSearch";
			u = new URL(urlStr);
			is = u.openStream();
			dis = new DataInputStream(new BufferedInputStream(is));
			byte buffer[] = new byte[1024];
			int i;
			while ((i = is.read(buffer)) != -1) {

				// System.out.write(buffer, 0, i);

			}

		} catch (MalformedURLException mue) {

			// System.out.println("Ouch - a MalformedURLException happened.");
			// mue.printStackTrace();
			// System.exit(1);
			throw mue;

		} catch (IOException ioe) {
			throw ioe;
			// System.out.println("Oops- an IOException happened.");
			// ioe.printStackTrace();
			// System.exit(1);

		} catch (Exception ioe) {
			throw ioe;
			// System.out.println("Oops- an IOException happened.");
			// ioe.printStackTrace();
			// System.exit(1);

		} finally {
			try {
				is.close();
			} catch (IOException ioe) {

			}

		} // end of 'finally' clause

	}

}
