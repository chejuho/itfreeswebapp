package common.batch;

public class TestHeapSize {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Runtime rt = Runtime.getRuntime();
		long totalmemory = rt.totalMemory();
		long freememory = rt.freeMemory();
		long heapsize = rt.totalMemory()-rt.freeMemory();
		System.out.println("total=" + totalmemory + ",free=" + freememory+ ",heap=" + heapsize);



	}

}
