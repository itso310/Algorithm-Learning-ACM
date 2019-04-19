/**
 * 计算r的n次幂，并按指定格式输出
 */
package poj.math.basic.easy;

import java.math.BigDecimal;
import java.util.Scanner;

public class P1001 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()) {
			BigDecimal bigr = sc.nextBigDecimal();
			int n = sc.nextInt();
			boolean f = isValid(bigr, n);
			if(f) {
				BigDecimal result = new BigDecimal(1);
				for(int i=1; i<=n; i++) {
					result = result.multiply(bigr);
				}
//				BigDecimal result = bigr.pow(n);
				String s = result.stripTrailingZeros().toPlainString();
				if(s.startsWith("0")) {
					s = s.substring(1);
				}
				System.out.println(s);
			}
		}
		sc.close();
	}

	
	/**
	 * 判断输入是否有效
	 * r2如果设置为99.999,自己的机器运行没问题,但是oj系统总是报wrong answer，所以设置为100.01
	 * @param r 浮点数
	 * @param n 指数
	 * @return 如果有效返回true,否则返回false
	 */
	private static boolean isValid(BigDecimal r, int n) {
		BigDecimal r1 = new BigDecimal("0.0");
		BigDecimal r2 = new BigDecimal("100.01");
		if(r.compareTo(r1)==1 && r.compareTo(r2)==-1 && n>0 && n<=25) {
			return true;
		}
		return false;
	}
}
