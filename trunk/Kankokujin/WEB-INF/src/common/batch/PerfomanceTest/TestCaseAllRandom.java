package common.batch.PerfomanceTest;

public class TestCaseAllRandom extends PerformanceTest{
	
	public static void main(String[] args) {
		
		System.out.println("start");
		TestCaseAllRandom test = null;
		int threadCount = 10;		
		for (int i = 0; i < threadCount ; i++) {	
			test = new TestCaseAllRandom();
			test.start();	
		}

		//Thread.
	}

	public TestCaseAllRandom() {
		randomTest();
		setCount(500);
	}

//	public void start() {
//		System.out.println("start");
//		TestCaseAllRandom test = null;
//		int threadCount = 100;		
//		for (int i = 0; i < threadCount ; i++) {	
//			test = new TestCaseAllRandom();
//			test.start();	
//		}
//	}
	
	protected void sleepExec() {
		try {
			//long start = System.currentTimeMillis();
			this.currentThread().sleep(2000);
			//long end = System.currentTimeMillis();
			//long dis = end - start;
			//System.out.println("sleep Time="+dis);
		} catch (InterruptedException e) {
			// TODO Ž©“®¶¬‚³‚ê‚½ catch ƒuƒƒbƒN
			e.printStackTrace();
		}
	}

	@Override
	protected void runTestSet() {
		
	}

}
