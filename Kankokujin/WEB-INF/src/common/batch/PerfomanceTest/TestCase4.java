package common.batch.PerfomanceTest;

public class TestCase4 extends PerformanceTest{

	public static void main(String[] args) {
		
		System.out.println("start");
		int threadCount = 100;		
		for (int i = 0; i < threadCount ; i++) {	
			TestCase4 test4 = new TestCase4();
			test4.start();	
		}
	}

	public TestCase4() {
		runTestSet();
		setCount(100);
	}
	@Override
	protected void runTestSet() {
		
		testList.add("FAQ");
		
	}

	



}
