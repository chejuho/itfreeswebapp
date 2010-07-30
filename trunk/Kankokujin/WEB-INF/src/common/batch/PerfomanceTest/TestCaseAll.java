package common.batch.PerfomanceTest;

public class TestCaseAll extends PerformanceTest{
	
	public static void main(String[] args) {
		
		System.out.println("start");
		int threadCount = 50;		
		for (int i = 0; i < threadCount ; i++) {	
			TestCaseAll test = new TestCaseAll();
			test.start();	
		}
	}

	public TestCaseAll() {
		runTestSet();
		setCount(30);
	}
	@Override
	protected void runTestSet() {
		
		//testList.add("readStoreSearch");
		testList.add("main");
//		testList.add("readSell");
//		testList.add("readBuy");
//		testList.add("readStoreSearch");
//		testList.add("readGourmetSearch");
//		testList.add("readRoomSellList1");
//		testList.add("readRoomSellList2");
//		testList.add("readHouseSellList");
//		testList.add("readJobSearch");
//		testList.add("readFindjobSearch");
//		testList.add("FAQ");
		
	}
	
	protected void sleepExec() {
		try {
			//long start = System.currentTimeMillis();
			this.currentThread().sleep(1000);
			//long end = System.currentTimeMillis();
			//long dis = end - start;
			//System.out.println("sleep Time="+dis);
		} catch (InterruptedException e) {
			// TODO Ž©“®¶¬‚³‚ê‚½ catch ƒuƒƒbƒN
			e.printStackTrace();
		}
	}

}
