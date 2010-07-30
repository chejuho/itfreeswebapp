/*
 * Created on 2006. 7. 5.
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package stock;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import bean.StockBean;

/**
 * @author Administrator
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class TestStock {

	public static void main(String[] args) {
		
//		AnalizeStock test = new AnalizeStock();
//		Map map = test.getStockList(3, 0);
//		Set set = map.keySet();
//		Iterator it = set.iterator();
//		while (it.hasNext()) {
//			String code= (String)it.next();
//			List list = (List)map.get(code);
//			Iterator itList = list.iterator();
//			while (itList.hasNext()) {
//				StockBean bean = (StockBean)itList.next();
//				System.out.println(code + "=" + bean.getEndPrice());
//				//System.out.println(bean.getEndPrice());
//			}
//			
//		}
		
		AnalizeStock test = new AnalizeStock();
		int size = 10;
		for (int i = 0; i< size; i++) {
			Map map1 = test.getUsefulStockMapNew(1, i+1, 2, 4, "10000", "10000000");
			Map map2 = test.getUsefulStockMapNew(1, i, 1, 4, "10000", "10000000");
			//Map map = test.getUsefulStockMapNew(1, 0, 1, 4, "10000", "1000000");
			
			Set set = map1.keySet();
			Iterator it = set.iterator();
			while (it.hasNext()) {
				String code= (String)it.next();
				List list = (List)map1.get(code);
				//System.out.println(code);
				Iterator itList = list.iterator();
				while (itList.hasNext()) {
					StockBean bean = (StockBean)itList.next();
					///System.out.println(test.insertStockBean(bean));
					//System.out.println(code + "=" + bean.getEndPrice() + ", stockdate=" + bean.getStockDate());
					//System.out.println(bean.getEndPrice());
				}
				
			}
			
			Set set2 = map2.keySet();
			Iterator it2 = set2.iterator();
			while (it2.hasNext()) {
				String code= (String)it2.next();
				List list = (List)map2.get(code);
				//System.out.println(code);
				Iterator itList = list.iterator();
				while (itList.hasNext()) {
					StockBean bean = (StockBean)itList.next();
					///System.out.println(test.insertStockBean(bean));
					//System.out.println(code + "=" + bean.getEndPrice() + ", stockdate=" + bean.getStockDate());
					//System.out.println(bean.getEndPrice());
				}
				
			}
			test.getPercent(map1, map2);
		}

	}
	

}
