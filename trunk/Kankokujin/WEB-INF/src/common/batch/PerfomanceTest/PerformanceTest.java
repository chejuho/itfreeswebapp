package common.batch.PerfomanceTest;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

//import common.batch.Count;
import common.logger.PerformanceLogger;

public abstract class PerformanceTest extends Thread {
	
	
	private static Count totalCount =  new Count();
	
	private static Count nomalCount =  new Count();
	
	private static Count errorCount =  new Count();
	
	private int totalCn = 0;
	
	private static String[] EXEXLIST = {"main","readSell","readBuy","readStoreSearch","readGourmetSearch","readRoomSellList1","readRoomSellList2","readHouseSellList","readJobSearch","readFindjobSearch","FAQ"};
	
	protected int testCount = 50;
	
	protected List testList = new ArrayList();

	private boolean randomSign = false;
	
	public void run(){
		if (!getRandomSign()) {
			for (Iterator it = testList.iterator(); it.hasNext();) {
				runPerfomanceMeasure((String) it.next());
			}
		}else {
			runPerfomanceMeasure();
			
		}
		
	
	}
	
	protected abstract void runTestSet();
	protected void sleepExec() {
	}
	protected boolean getRandomSign() {
		return randomSign;
	}
	protected void randomTest() {
		randomSign = true;
	}
	protected void setCount(int ct) {
		testCount = ct;
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
		
//		if ("main".equals(measureName)) url = "http://www.kankokujin.com/NewWrite";
//		if ("readSell".equals(measureName)) url = "http://www.kankokujin.com/BuySellList?re=9&search_cate_code_1=C10001";
//		if ("readBuy".equals(measureName)) url = "http://www.kankokujin.com/BuySellList?re=9&search_cate_code_1=C10002";
//		if ("readStoreSearch".equals(measureName)) url = "http://www.kankokujin.com/StoreSearch?re=9";
//		if ("readGourmetSearch".equals(measureName)) url = "http://www.kankokujin.com/GourmetSearch?re=9";
//		if ("readRoomSellList1".equals(measureName)) url = "http://www.kankokujin.com/RoomSellList?re=9&cate_code_1=C10001";
//		if ("readRoomSellList2".equals(measureName)) url = "http://www.kankokujin.com/RoomSellList?re=9&cate_code_1=C10002";
//		if ("readHouseSellList".equals(measureName)) url = "http://www.kankokujin.com/HouseSellList?re=9";
//		if ("readJobSearch".equals(measureName)) url = "http://www.kankokujin.com/JobSearch?re=9";
//		if ("readFindjobSearch".equals(measureName)) url = "http://www.kankokujin.com/FindjobSearch?re=9";
//		if ("FAQ".equals(measureName)) url = "http://www.kankokujin.com/FAQ";
		
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
		if ("FAQ".equals(measureName)) url = "http://localhost:8080/Kankokujin/FAQ";
		
//		if ("main".equals(measureName)) url = "http://www.itfrees.com/NewWrite";
//		if ("readSell".equals(measureName)) url = "http://www.itfrees.com/BuySellList?re=9&search_cate_code_1=C10001";
//		if ("readBuy".equals(measureName)) url = "http://www.itfrees.com//BuySellList?re=9&search_cate_code_1=C10002";
//		if ("readStoreSearch".equals(measureName)) url = "http://www.itfrees.com/StoreSearch?re=9";
//		if ("readGourmetSearch".equals(measureName)) url = "http://www.itfrees.com/GourmetSearch?re=9";
//		if ("readRoomSellList1".equals(measureName)) url = "http://www.itfrees.com/RoomSellList?re=9&cate_code_1=C10001";
//		if ("readRoomSellList2".equals(measureName)) url = "http://www.itfrees.com/RoomSellList?re=9&cate_code_1=C10002";
//		if ("readHouseSellList".equals(measureName)) url = "http://www.itfrees.com/HouseSellList?re=9";
//		if ("readJobSearch".equals(measureName)) url = "http://www.itfrees.com/JobSearch?re=9";
//		if ("readFindjobSearch".equals(measureName)) url = "http://www.itfrees.com/FindjobSearch?re=9";
//		if ("FAQ".equals(measureName)) url = "http://www.itfrees.com/FAQ";
		
//		
//		
		//int testCount = 50;
		for (int i = 0; i < testCount ; i++) {
			boolean check = false;
			long start = 0, stop = 0, diff = 0;
			//PerformanceLogger.getInstance().debug(","+measureName+","+editFormat(Thread.currentThread().getName())+","+i+",�J�n");
			/*���炩�̃\�[�X�D���Ԃ�v�肽���v���O����*/
			try {
				totalCn = totalCount.countUp();
				start = System.currentTimeMillis();
				check = readUTL(url);
				stop = System.currentTimeMillis();
				sleepExec();
				
			} catch (Exception e) {				
				e.printStackTrace();
			//	KankokujinLogger.getInstance().debug(e.getMessage());
				PerformanceLogger.getInstance().error(","+measureName+","+editFormat(Thread.currentThread().getName())+","+totalCn+",�G���[");
				System.exit(1);
			}
			//PerformanceLogger.getInstance().debug(","+measureName+","+editFormat(Thread.currentThread().getName())+","+i+",�I��");
			diff = stop - start;
			PerformanceLogger.getInstance().debug(","+measureName+","+editFormat(
					Thread.currentThread().getName())+","+totalCn+","+secondEdit(diff)+","+editCheckSign(check));
			//System.out.println(measureName+","+editFormat(Thread.currentThread().getName())+","+totalCn+","+secondEdit(diff)+","+editCheckSign(check));
			//System.out.println(measureName+":"+Thread.currentThread().getName()+"��count"+i+"�̎//s���� : "+diff+"�~���b");
			
		}
		
	}
	
	public void runPerfomanceMeasure() {
		
		//int testCount = 50;
		RandomGenerator rg = new RandomGenerator(testCount);
		for (int i = 0; i < testCount ; i++) {
			boolean check = false;
			int ranNum = rg.getRandom(10);
			String measureName = EXEXLIST[ranNum];
			String url = getURL(ranNum);
			long start = 0, stop = 0, diff = 0;
			//PerformanceLogger.getInstance().debug(","+measureName+","+editFormat(Thread.currentThread().getName())+","+i+",�J�n");
			/*���炩�̃\�[�X�D���Ԃ�v�肽���v���O����*/
			try {
				totalCn = totalCount.countUp();
				start = System.currentTimeMillis();
				check = readUTL(url);
				stop = System.currentTimeMillis();
				sleepExec();
				
			} catch (Exception e) {				
				e.printStackTrace();
			//	KankokujinLogger.getInstance().debug(e.getMessage());
				PerformanceLogger.getInstance().error(","+measureName+","+editFormat(Thread.currentThread().getName())+","+totalCn+",�G���[");
				System.exit(1);
			}
			//PerformanceLogger.getInstance().debug(","+measureName+","+editFormat(Thread.currentThread().getName())+","+i+",�I��");
			diff = stop - start;
			PerformanceLogger.getInstance().debug(","+measureName+","+editFormat(
					Thread.currentThread().getName())+","+totalCn+","+secondEdit(diff)+","+editCheckSign(check));
			//System.out.println(measureName+","+editFormat(Thread.currentThread().getName())+","+totalCn+","+secondEdit(diff)+","+editCheckSign(check));
			//System.out.println(measureName+":"+Thread.currentThread().getName()+"��count"+i+"�̎//s���� : "+diff+"�~���b");
		}
		
	}



	

	public boolean readUTL(String url) throws Exception {
		URL u;
		InputStream is = null;
		DataInputStream dis;
		String s;
		boolean check = false;
		//HttpURLConnection http = null;
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
				
				byte buffer[] = new byte[2048];
				int i;
				while ((i = is.read(buffer)) != -1) {
				//	first = true;
					String html = new String(buffer);
					//System.out.println(html);
					check = errorCheck(html);
					if (check) break;
					//System.out.println("check=" + check);
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
	//			System.out.println("sign:"+first);
			} catch (Exception e) {
				//e.printStackTrace();
				System.out.println("===============================================");
				System.out.println("�����I��");
				System.out.println("===============================================");
				//throw e;
			} finally {
				//if (check) {
				//	return check;
//					System.out.println("check-Error");
//					System.out.println("===============================================");
//					System.out.println("�����I��");
//					System.out.println("===============================================");
//					throw new Exception("check-Error");
					//System.exit(1);
				//}
			}

		} catch (MalformedURLException mue) {

			System.out.println("Ouch - a MalformedURLException happened.");
			//throw mue;
			

		} catch (IOException ioe) {
			System.out.println("IOException");
			System.out.println("===============================================");
			System.out.println("�����I��");
			System.out.println("===============================================");
			//throw ioe;

		} catch (Exception e) {
			System.out.println("Exception");
			System.out.println("===============================================");
			System.out.println("�����I��");
			System.out.println("===============================================");
			//throw e;

		} finally {
			try {
				if (is != null) {
					is.close();
				}
				
			} catch (IOException ioe) {
				throw ioe;
			}

		} // end of 'finally' clause
		return check;

	}
	
	/**
	 * @param k
	 * @return true:�G���[�Afalse:����
	 */
	
	private boolean errorCheck(String k) {
		
		boolean checkSign = false;
		StringTokenizer st = new StringTokenizer(k, "\n");
		
		while (st.hasMoreTokens()) {
			String check = st.nextToken();
			//System.out.println(check);
			if (0 < check.indexOf("<title>KANKOKUJIN.COM</title>")) {
				if (0 > check.indexOf("KANKOKUJIN.COM")) {
					System.out.println(check);
					checkSign = true;
				} else {
					checkSign = false;
				}
				break;
				
				
				
//				if (0 < check.indexOf("KankokujinError")) {
//					System.out.println(check);
//					checkSign = true;
//				} else {
//					checkSign = false;
//				}
//				break;
			}
			//System.out.println(ch);
		}

		
		return checkSign;
	}
	
	private String editFormat(String str) {
		StringBuffer sb = new StringBuffer();
		StringTokenizer st = new StringTokenizer(str, "-");
		sb.append("Thread-");
		
		boolean first = true;
		String num = null;
		while (st.hasMoreTokens()) {
			if(first) {
				st.nextToken();
				first = false;
			} else {
				num = st.nextToken();
			}
		}
		for (int i = num.length(); i < 4; i++) {
			sb.append("0");
			
		}
		sb.append(num);
		return sb.toString();

	}
	

	private String getURL(int i) {
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
		
		if ("main".equals(EXEXLIST[i])) url = "http://www.kankokujin.com/NewWrite";
		if ("readSell".equals(EXEXLIST[i])) url = "http://www.kankokujin.com/BuySellList?re=9&search_cate_code_1=C10001";
		if ("readBuy".equals(EXEXLIST[i])) url = "http://www.kankokujin.com/BuySellList?re=9&search_cate_code_1=C10002";
		if ("readStoreSearch".equals(EXEXLIST[i])) url = "http://www.kankokujin.com/StoreSearch?re=9";
		if ("readGourmetSearch".equals(EXEXLIST[i])) url = "http://www.kankokujin.com/GourmetSearch?re=9";
		if ("readRoomSellList1".equals(EXEXLIST[i])) url = "http://www.kankokujin.com/RoomSellList?re=9&cate_code_1=C10001";
		if ("readRoomSellList2".equals(EXEXLIST[i])) url = "http://www.kankokujin.com/RoomSellList?re=9&cate_code_1=C10002";
		if ("readHouseSellList".equals(EXEXLIST[i])) url = "http://www.kankokujin.com/HouseSellList?re=9";
		if ("readJobSearch".equals(EXEXLIST[i])) url = "http://www.kankokujin.com/JobSearch?re=9";
		if ("readFindjobSearch".equals(EXEXLIST[i])) url = "http://www.kankokujin.com/FindjobSearch?re=9";
		if ("FAQ".equals(EXEXLIST[i])) url = "http://www.kankokujin.com/FAQ";
		return url;
		
		
	}
	
	private String secondEdit(long time) {
		
		//System.out.println(time);
		StringBuffer sb = new StringBuffer();
		String s = String.valueOf(time);
		//int i = 0;
		
		if (s.length() > 3) {
			sb.append(s.substring(0,s.length() - 3));
		} else {
			sb.append("0");
		}
		
		sb.append(".");
		
		if (s.length() >= 3) {
			sb.append(s.substring(s.length() - 3));
		}
		
		if (s.length() == 2) {
			sb.append("0");
			sb.append(s.substring(s.length() - 2));
		}
		if (s.length() == 1) {
			sb.append("00");
			sb.append(s.substring(s.length() - 1));
		}
		
		
		sb.append("�b");
		
		return sb.toString();
		
		
	}
	
	private String editCheckSign(boolean check) {
		if (check) {
			errorCount.countUp();
			return "�`�F�b�N�G���[";
		}
		nomalCount.countUp();
		return "����";
	}

}
