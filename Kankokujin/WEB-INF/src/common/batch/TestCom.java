package common.batch;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;


public class TestCom {

	public static void main(String[] args) {

		TestCom testSession = new TestCom();
		int count = 10000;
		boolean isContinue = true;
		while (isContinue) {
		//for (int i = 0; i < count ; i++) {			
			testSession.readUTL();
			try {
				Thread.sleep(1800000);//30•ª
			} catch (InterruptedException e) {
				// TODO Ž©“®¶¬‚³‚ê‚½ catch ƒuƒƒbƒN
				e.printStackTrace();
			}
		}
		
	}

	public void readUTL() {
		URL u;
		InputStream is = null;
		DataInputStream dis;
		String s;

		try {
			String urlStr = "http://192.168.1.10/Kankokujin/TestCom";
			//String urlStr = "http://localhost/Kankokujin/TestCom";
			u = new URL(urlStr);
			is = u.openStream();
			dis = new DataInputStream(new BufferedInputStream(is));
			try {
				byte buffer[] = new byte[1024];
				int i;
				while ((i = is.read(buffer)) != -1) {
					
					System.out.write(buffer, 0, i);					

				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {

			}

		} catch (MalformedURLException mue) {

			System.out.println("Ouch - a MalformedURLException happened.");
			mue.printStackTrace();
			//System.exit(1);

		} catch (IOException ioe) {

			System.out.println("Oops- an IOException happened.");
			ioe.printStackTrace();
			//System.exit(1);

		} finally {
			try {
				is.close();
			} catch (IOException ioe) {

			}

		} // end of 'finally' clause

	}

}
