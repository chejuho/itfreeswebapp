package common.batch.PerfomanceTest;

public class TestCase1 extends PerformanceTest{

	public static void main(String[] args) {
		
		System.out.println("start");
		int threadCount = 100;		
		for (int i = 0; i < threadCount ; i++) {	
			TestCase1 test1 = new TestCase1();
			test1.start();	
		}
	}

	public TestCase1() {
		runTestSet();
	}
	@Override
	protected void runTestSet() {
		
		testList.add("FAQ");
		
	}

}
