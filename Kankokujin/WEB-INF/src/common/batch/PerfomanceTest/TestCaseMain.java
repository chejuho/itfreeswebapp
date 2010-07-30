package common.batch.PerfomanceTest;

public class TestCaseMain extends PerformanceTest{

	public static void main(String[] args) {
		
		System.out.println("start");
		int threadCount = 100;		
		for (int i = 0; i < threadCount ; i++) {	
			TestCaseMain main = new TestCaseMain();
			main.start();	
		}
	}

	public TestCaseMain() {
		runTestSet();
	}
	@Override
	protected void runTestSet() {
		
		testList.add("main");
		
	}

}
