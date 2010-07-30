package common.batch;

import java.util.Collections;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

public class TestSortProp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TestSortProp testSortProp = new TestSortProp();
		Properties prop = new Properties();
		prop.put("3","3");
		prop.put("5","5");
		prop.put("1","1");
		prop.put("9","9");
/*		
		Properties newProp = testSortProp.sortProperty(prop);
		Set set = newProp.keySet();
		Iterator it = set.iterator();
		while (it.hasNext()){
			System.out.println(it.next());;
		}*/
		
		SortedMap sortedMap = new TreeMap();
		sortedMap.put("3","3");
		sortedMap.put("5","5");
		sortedMap.put("1","1");
		sortedMap.put("9","9");
		Set set = sortedMap.keySet();
		Iterator it = set.iterator();
		while (it.hasNext()){
			System.out.println(it.next());;
		}

	}
    private Properties sortProperty(Properties prop){
    	Properties newProp = new Properties();
    	SortedMap sortedMap = Collections.synchronizedSortedMap(new TreeMap(prop));
    	Set set = sortedMap.keySet();
		Iterator it = set.iterator();
		while (it.hasNext()){
			String key = (String)it.next();
			System.out.println("key="+key);;
			newProp.put(key, prop.getProperty(key));
		}
		return newProp;
    }
}
