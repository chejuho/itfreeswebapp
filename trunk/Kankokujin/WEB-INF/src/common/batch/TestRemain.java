package common.batch;

import java.math.BigDecimal;
import java.math.BigInteger;

public class TestRemain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		int count = 10;
		BigInteger countBigInteger = new BigInteger(String.valueOf(count));
		BigInteger divideBigInteger = new BigInteger("3");		
		BigInteger divedieBigDecimal = countBigInteger.remainder(divideBigInteger);
		System.out.println(divedieBigDecimal.bitCount());
	}

}
