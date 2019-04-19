/**
 * 计算12个月消费的平均数
 */
package poj.math.basic.easy;

import java.text.DecimalFormat;
import java.util.Scanner;

public class P1004 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double[] account = new double[12];
		for (int j = 0; j < account.length; j++) {
			account[j] = sc.nextDouble();
		} 
		sc.close();
		avg(account);
	}

	
	/**
	 * 计算平均数
	 * @param account 存放所有数据的数组
	 */
	private static void avg(double[] account) {
		double sum = 0;
		for (double d : account) {
			sum = sum + d;
		}
		double r = sum/account.length;
		DecimalFormat df = new DecimalFormat(".00");  
		String str = df.format(r); 
		System.out.println("$" + str);
	}
}
