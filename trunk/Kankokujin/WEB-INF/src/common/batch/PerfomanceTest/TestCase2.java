package common.batch.PerfomanceTest;

public class TestCase2 extends PerformanceTest{
	
	public static void main(String[] args) {
		
		System.out.println("start");
		int threadCount = 100;		
		for (int i = 0; i < threadCount ; i++) {	
			TestCase2 test2 = new TestCase2();
			test2.start();	
		}
	}

	public TestCase2() {
		runTestSet();
	}
	@Override
	protected void runTestSet() {
		
		testList.add("readFindjobSearch");
		
	}
}
