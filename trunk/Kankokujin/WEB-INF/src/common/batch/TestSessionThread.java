package common.batch;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import common.logger.KankokujinLogger;


public class TestSessionThread extends Thread{

	
	public static void main(String[] args) throws InterruptedException {

		
		int count = 20;
//		
		for (int i = 0; i < count ; i++) {	
		//for (;true;) {	
		//	TestSessionThread testSession = new TestSessionThread();
			TestSessionThread testSession = new TestSessionThread();
			testSession.start();
			testSession.sleep(100);
		}
		//	testSession.start();
			//KankokujinLogger.getInstance().debug("1 count=" + i);
			//System.out.println("1 count=" + i);
//			Runtime rt = Runtime.getRuntime();
//			long totalmemory = rt.totalMemory();
//			long freememory = rt.freeMemory();
//			long heapsize = rt.totalMemory()-rt.freeMemory();
//			System.out.println("total=" + totalmemory + ",free=" + freememory+ ",heap=" + heapsize);
	//	}
//		Runtime rt = Runtime.getRuntime();
//		long totalmemory = rt.totalMemory();
//		long freememory = rt.freeMemory();
//		long heapsize = rt.totalMemory()-rt.freeMemory();
//		System.out.println("total=" + totalmemory + ",free=" + freememory+ ",heap=" + heapsize);
		//System.out.println("�I��");
	}
	
	public void run(){
		
		runPerfomanceMeasure("main");
		runPerfomanceMeasure("readSell");
//		runPerfomanceMeasure("readBuy");
//		runPerfomanceMeasure("readStoreSearch");
//		runPerfomanceMeasure("readGourmetSearch");
//		runPerfomanceMeasure("readRoomSellList1");
//		runPerfomanceMeasure("readRoomSellList2");
//		runPerfomanceMeasure("readHouseSellList");
//		runPerfomanceMeasure("readJobSearch");
//		runPerfomanceMeasure("readFindjobSearch");
		
	}
	
	public void runPerfomanceMeasure(String measureName) {
		
		String url = "";
//		if ("main".equals(measureName)) url = "http://192.168.1.10/Kankokujin/NewWrite";
//		if ("readSell".equals(measureName)) url = "http://192.168.1.10/Kankokujin/BuySellList?re=9&search_cate_code_1=C10001";
//		if ("readBuy".equals(measureName)) url = "http://192.168.1.10/Kankokujin/BuySellList?re=9&search_cate_code_1=C10002";
//		if ("readStoreSearch".equals(measureName)) url = "http://192.168.1.10/Kankokujin/StoreSearch?re=9";
//		if ("readGourmetSearch".equals(measureName)) url = "http://192.168.1.10/Kankokujin/GourmetSearch?re=9";
//		if ("readRoomSellList1".equals(measureName)) url = "http://192.168.1.10/Kankokujin/RoomSellList?re=9&cate_code_1=C10001";
//		if ("readRoomSellList2".equals(measureName)) url = "http://192.168.1.10/Kankokujin/RoomSellList?re=9&cate_code_1=C10002";
//		if ("readHouseSellList".equals(measureName)) url = "http://192.168.1.10/Kankokujin/HouseSellList?re=9";
//		if ("readJobSearch".equals(measureName)) url = "http://192.168.1.10/Kankokujin/JobSearch?re=9";
//		if ("readFindjobSearch".equals(measureName)) url = "http://192.168.1.10/Kankokujin/FindjobSearch?re=9";
		
		if ("main".equals(measureName)) url = "http://localhost:8080/Kankokujin/NewWrite";
		if ("readSell".equals(measureName)) url = "http://localhost:8080/Kankokujin/BuySellList?re=9&search_cate_code_1=C10001";
		if ("readBuy".equals(measureName)) url = "http://localhost:8080/Kankokujin/BuySellList?re=9&search_cate_code_1=C10002";
		if ("readStoreSearch".equals(measureName)) url = "http://localhost:8080/Kankokujin/StoreSearch?re=9";
		if ("readGourmetSearch".equals(measureName)) url = "http://localhost:8080/Kankokujin/GourmetSearch?re=9";
		if ("readRoomSellList1".equals(measureName)) url = "http://localhost:8080/Kankokujin/RoomSellList?re=9&cate_code_1=C10001";
		if ("readRoomSellList2".equals(measureName)) url = "http://localhost:8080/Kankokujin/RoomSellList?re=9&cate_code_1=C10002";
		if ("readHouseSellList".equals(measureName)) url = "http://localhost:8080/Kankokujin/HouseSellList?re=9";
		if ("readJobSearch".equals(measureName)) url = "http://localhost:8080/Kankokujin/JobSearch?re=9";
		if ("readFindjobSearch".equals(measureName)) url = "http://localhost:8080/Kankokujin/FindjobSearch?re=9";
		
		
		int count = 10;
		for (int i = 0; i < count ; i++) {
			long start, stop, diff;
	//		System.out.println("���Ԃ̌v����J�n");
			start = System.currentTimeMillis();
			/*���炩�̃\�[�X�D���Ԃ�v�肽���v���O����*/
			readUTL(url);
			stop = System.currentTimeMillis();
	//		System.out.println("�v���I��");
			diff = stop - start;
		//	KankokujinLogger.getInstance().debug(measureName+":"+Thread.currentThread().getName()+"��count"+i+"�̎//s���� : "+diff+"�~���b");
	//		System.out.println(measureName+":"+Thread.currentThread().getName()+"��count"+i+"�̎//s���� : "+diff+"�~���b");
		
		}
		
	}
	
	
	public void readUTL(String url) {
		URL u;
		InputStream is = null;
		DataInputStream dis;
		String s;
		HttpURLConnection http = null;
		try {

			//String urlStr = "http://192.168.1.10/Kankokujin/MemberLogin?id='jeong'&pw='jeong'";
			//String urlStr = "http://localhost/Kankokujin/MemberLogin?id='jeong'&pw='jeong'";
			//String urlStr = "http://192.168.1.10/Kankokujin/StoreSearch?cate_code='C10002'&cate_code='C20003'";
			//String urlStr = "http://192.168.1.10/Kankokujin/NewWrite";
			u = new URL(url);
			//System.out.println();
			is = u.openStream();
			dis = new DataInputStream(new BufferedInputStream(is));
			try {
				boolean first = true;
				byte buffer[] = new byte[1024];
				int i;
				while ((i = is.read(buffer)) != -1) {
//					if (first) {
//						//System.out.write("result=");
//						System.out.write(buffer, 0, i);
//						System.out.println();
//						first = false;
//					} else {
//						break;
//					}
					//System.out.write(buffer, 0, i);					
				}
			} catch (Exception e) {
				//e.printStackTrace();
				System.out.println("===============================================");
				System.out.println("�����I��");
				System.out.println("===============================================");
			} finally {
				
			}

		} catch (MalformedURLException mue) {

			System.out.println("Ouch - a MalformedURLException happened.");
			mue.printStackTrace();
			System.exit(1);

		} catch (IOException ioe) {
			System.out.println("IOException");
			System.out.println("===============================================");
			System.out.println("�����I��");
			System.out.println("===============================================");
			ioe.printStackTrace();
			System.exit(1);

		}  catch (Exception e) {
			System.out.println("Exception");
			System.out.println("===============================================");
			System.out.println("�����I��");
			System.out.println("===============================================");
			//ioe.printStackTrace();
			System.exit(1);

		} finally {
			try {
				is.close();
			} catch (IOException ioe) {

			}

		} // end of 'finally' clause

	}

}
