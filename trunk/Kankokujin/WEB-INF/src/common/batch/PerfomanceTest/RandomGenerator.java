package common.batch.PerfomanceTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Vector;


public class RandomGenerator {
	
	
	public static void main(String[] args) {
		RandomGenerator r = new RandomGenerator(50);
		
		for (int i = 0; i < 50; i++) {
			
			System.out.println(r.getRandom(10));
		}
		
	}
	
	private Random r;
	private int n = 0;
	private List<Integer> checkList = null;
	
	RandomGenerator(int _n) {
		r = new Random();
		n = _n;
		init();
	}
	
	private void init() {
		checkList = new Vector<Integer>(n); 
		for (int i = 0; i < n; i++) {
			checkList.add(new Integer(i));
		}
		//System.out.println(checkList);
		Collections.shuffle(checkList, r);
		
		//System.out.println(checkList);
	}

	public int getRandom(int i) {
		
		
		int num = (Integer) checkList.get(n - 1).intValue();
		//System.out.println("RANDOM="+ num);
		n--;
		return num % i;

	}

}
