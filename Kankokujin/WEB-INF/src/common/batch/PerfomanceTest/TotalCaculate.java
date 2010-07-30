package common.batch.PerfomanceTest;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

import common.logger.PerformanceLogger;

public class TotalCaculate {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		List result = fileToString("C:\\log\\performanceLog.csv");
	
		int nomalNum = getNomalNum(result);
		System.out.println("nomalNum="+nomalNum);
		int errorNum = getErrorNum(result);
		System.out.println("errorNum="+errorNum);
		//PerformanceLogger.getInstance().debug("���퍇�v"+","+nomalNum);
		//PerformanceLogger.getInstance().debug("�G���[���v"+","+errorNum);

	}
	
	private static int getNomalNum(List result) {
		
		int i = 0;
		
		for (Iterator it = result.iterator(); it.hasNext();) {
			
			String line = (String) it.next();
			String lastStr = "";
			StringTokenizer st = new StringTokenizer(line, ",");
			while (st.hasMoreTokens()) {
				
				lastStr = (String) st.nextToken();
			}
			if ("����".equals(lastStr)) i++;
		}
		
		return i;
	}
	
	private static int getErrorNum(List result) {
		
		int i = 0;
		
		for (Iterator it = result.iterator(); it.hasNext();) {
			
			String line = (String) it.next();
			String lastStr = "";
			StringTokenizer st = new StringTokenizer(line, ",");
			while (st.hasMoreTokens()) {
				
				lastStr = (String) st.nextToken();
			}
			if ("�`�F�b�N�G���[".equals(lastStr)) i++;
		}
		
		return i;
	}

	public static List fileToString(String filename) {
		List list = new ArrayList();
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(filename));
			for (String line = br.readLine(); line != null; line = br.readLine()) {
				list.add(line);
				list.add("\n");
				
			}
		} catch (FileNotFoundException e) {
			// TODO �����������ꂽ catch �u���b�N
			e.printStackTrace();
		} catch (IOException e) {
			// TODO �����������ꂽ catch �u���b�N
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				// TODO �����������ꂽ catch �u���b�N
				e.printStackTrace();
			}
		}

		return list;
	}

}
