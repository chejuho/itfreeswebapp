package common.batch.PerfomanceTest;

public class TestCase3 extends PerformanceTest{
	
	public static void main(String[] args) {
		
		System.out.println("start");
		int threadCount = 300;		
		for (int i = 0; i < threadCount ; i++) {	
			TestCase3 test = new TestCase3();
			test.start();	
		}
	}

	public TestCase3() {
		runTestSet();
	}
	@Override
	protected void runTestSet() {
		testList.add("readStoreSearch");	
	}
}