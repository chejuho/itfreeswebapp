package common.batch.PerfomanceTest;

public class TestCase5 extends PerformanceTest{
	
	public static void main(String[] args) {
		
		System.out.println("start");
		int threadCount = 100;		
		for (int i = 0; i < threadCount ; i++) {	
			TestCase5 test5 = new TestCase5();
			test5.start();	
		}
	}

	public TestCase5() {
		runTestSet();
		setCount(100);
	}
	@Override
	protected void runTestSet() {
		
		testList.add("readFindjobSearch");
		
	}

}
