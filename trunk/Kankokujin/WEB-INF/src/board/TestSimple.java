/*
 * Created on 2006. 3. 11.
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package board;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Administrator
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class TestSimple {

	public static void main(String[] args) {
		Date nowDate = new Date();
		SimpleDateFormat simple = new SimpleDateFormat();
		simple.format("yyyyMMdd");
		String strDate = simple.format(nowDate);
		System.out.println(strDate);
	}
}
