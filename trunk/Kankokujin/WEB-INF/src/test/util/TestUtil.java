package test.util;

import common.util.Util;

import junit.framework.TestCase;

public class TestUtil extends TestCase {
	public void testChangeArrayToStr01(){
		String[] house_sort={"checked","","checked","","checked","","","",""};
		String actualValue = Util.changeArrayToStr(house_sort);
		String expectedValue = "101010000";
		assertEquals(expectedValue, actualValue) ;
	}
	
	public void testChangeStrToArray01(){
		String[] expectedValue ={"checked","","checked","","checked","","","",""};
		String testStr = "101010000";
		String[] actualValue = Util.changeStrToArray(testStr);
	
		assertEquals(expectedValue[0], actualValue[0]) ;
		assertEquals(expectedValue[1], actualValue[1]) ;
		assertEquals(expectedValue[2], actualValue[2]) ;
		assertEquals(expectedValue[3], actualValue[3]) ;
		assertEquals(expectedValue[4], actualValue[4]) ;
		assertEquals(expectedValue[5], actualValue[5]) ;
		assertEquals(expectedValue[6], actualValue[6]) ;
		assertEquals(expectedValue[7], actualValue[7]) ;
		assertEquals(expectedValue[8], actualValue[8]) ;

	}
}
