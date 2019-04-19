/**
 * 计算两个整数的和
 */
package poj.math.basic.easy;

import java.util.Scanner;

public class P1000 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		sc.close();
		boolean fa = isValid(a);
		boolean fb = isValid(b);
		if(fa && fb) {
			int sum = add(a, b);
			System.out.println(sum);
		}
	}

	
	/**
	 * 判断输入的整数是否在规定的范围内
	 * @param a 要相加的整数
	 * @return 是否是有效数字
	 */
	private static boolean isValid(int a) {
		if(a>=0 && a<=10)
			return true;
		return false;
	}

	
	/**
	 * 求两个整数的和
	 * @param a 整数参数a
	 * @param b 整数参数b
	 * @return 两个参数的和
	 */
	private static int add(int a, int b) {
		int sum = a + b;
		return sum;
	}
}
