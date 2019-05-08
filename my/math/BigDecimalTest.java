package my.math;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class BigDecimalTest {
	public static void main(String[] args) {
//		test1();
//		test2();
//		test3();
//		test4();
		other();
	}
	
	
	/**
	 * 测试构造方法
	 * 整数可以用构造方法BigDecimal(整数)
	 * 浮点数用构造方法BigDecimal(字符串)，如果直接用浮点数结果会有误差
	 */
	private static void test1() {
		BigDecimal a = new BigDecimal(1);
		BigDecimal b = new BigDecimal(5.2);
		BigDecimal c = new BigDecimal("5.2");
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		System.out.println(b.equals(c));
	}
	
	
	/**
	 * 测试算术运算
	 */
	private static void test2() {
		BigDecimal a = new BigDecimal("2.13");
		BigDecimal b = new BigDecimal(5);
		BigDecimal r1 = a.add(b);
		BigDecimal r2 = a.subtract(b);
		BigDecimal r3 = a.multiply(b);
		BigDecimal r4 = a.divide(b);
		System.out.println(r1);
		System.out.println(r2);
		System.out.println(r3);
		System.out.println(r4);
	}
	
	
	/**
	 * 测试除不尽的解决方法
	 * MathContext(int setPrecision) 如果整数部分非0，则setPrecision指的是整数和小数部分的位数；如果整数部分为0，则指的是小数部分的位数
	 * MathContext(int setPrecision, RoundingMode setRoundingMode) RoundingMode是舍入模式
	 */
	private static void test3() {
		BigDecimal a = new BigDecimal(1);
		BigDecimal b = new BigDecimal(6);
//		BigDecimal r1 = a.divide(b); //报错
		BigDecimal r1 = a.divide(b, new MathContext(10));
		System.out.println(r1);
		BigDecimal r2 = a.divide(b, new MathContext(10, RoundingMode.HALF_UP));
		System.out.println(r2);
		BigDecimal r3 = a.divide(b, new MathContext(10, RoundingMode.HALF_DOWN));
		System.out.println(r3);
	}
	
	
	/**
	 * HALF指的是5，带HALF的与5进行比较
	 * HALF_UP：>=5,则上入，否则舍掉,即通常所说的四舍五入
	 * HALF_DOWN：>5,则上入，否则舍掉
	 * HALF_EVEN：取最近的偶数，奇数向上入，偶数不变
	 * UP：只要>0,就向上取整
	 * DOWN：：只要>0,就向下取整
	 */
	private static void test4() {
		BigDecimal r1 = new BigDecimal("2.35", new MathContext(2, RoundingMode.HALF_UP));
		BigDecimal r2 = new BigDecimal("2.35", new MathContext(2, RoundingMode.HALF_DOWN));
		BigDecimal r3 = new BigDecimal("2.35", new MathContext(2, RoundingMode.HALF_EVEN));
		BigDecimal r4 = new BigDecimal("2.25", new MathContext(2, RoundingMode.HALF_EVEN));
		BigDecimal r5 = new BigDecimal("2.34", new MathContext(2, RoundingMode.UP));
		BigDecimal r6 = new BigDecimal("2.34", new MathContext(2, RoundingMode.DOWN));
		System.out.println(r1);
		System.out.println(r2);
		System.out.println(r3);
		System.out.println(r4);
		System.out.println(r5);
		System.out.println(r6);
	}
	
	
	/**
	 * 测试其它常用方法
	 * stripTrailingZeros 移除尾部的0
	 * toPlainString 返回不带指数字段的此 BigDecimal 的字符串表示形式
	 * toString 返回此 BigDecimal 的字符串表示形式，如果需要指数，则使用科学记数法。
	 */
	private static void other() {
		BigDecimal r1 = new BigDecimal("0.0000002300");
		String s1 = r1.stripTrailingZeros().toString();
		System.out.println(s1);
		String s2 = r1.stripTrailingZeros().toPlainString();
		System.out.println(s2);
	}
}



