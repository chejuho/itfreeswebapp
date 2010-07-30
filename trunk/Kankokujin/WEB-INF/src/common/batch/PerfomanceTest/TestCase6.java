package common.batch.PerfomanceTest;

public class TestCase6 extends PerformanceTest{
	
	public static void main(String[] args) {
		
		System.out.println("start");
		int threadCount = 50;		
		for (int i = 0; i < threadCount ; i++) {	
			TestCase6 test = new TestCase6();
			test.start();	
		}
	}

	public TestCase6() {
		runTestSet();
		setCount(100);
	}
	@Override
	protected void runTestSet() {
		
		testList.add("readStoreSearch");
		
	}

}
