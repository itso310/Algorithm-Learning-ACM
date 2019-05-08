/**
 * 保留小数
 */
package my.math;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class PrecisionTest {
	static double d = 3.2467;
	public static void main(String[] args) {
		test1();
		test2();
		test3();
		test4();
	}
	
	
	/**
	 * 转换最方便
	 */
	private static void test1() {
		DecimalFormat df = new DecimalFormat(".00");  
		String str = df.format(d); 
		System.out.println(str);
	}
	
	
	/**
	 * 打印最方便
	 */
	private static void test2() {
		System.out.println(String.format("%.2f", d));
	}
	
	
	public static void test3() {
		BigDecimal bg = new BigDecimal(String.valueOf(d));
		double f1 = bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		System.out.println(f1);
	}
	
	
	/**
	 * 取整
	 * 向下取整：f1,f2的方法结果相同
	 * 向上取整：f3
	 */
	public static void test4() {
		int f1 = (int)d;
		System.out.println(f1);
		int f2 = (int)Math.floor(d);
		System.out.println(f2);
		int f3 = (int)Math.ceil(d);
		System.out.println(f3);
	}
}
