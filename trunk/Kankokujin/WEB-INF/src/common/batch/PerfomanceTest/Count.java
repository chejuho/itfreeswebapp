package common.batch.PerfomanceTest;
 
public class Count {
	
	private volatile int i = 0;
	
	public synchronized int countUp() {
		i = i + 1;
		return i;
		
	}
	
	public int getCount() {
		return i;
	}

}
