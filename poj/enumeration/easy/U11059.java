package poj.enumeration.easy;

import java.util.Scanner;

/**
 * 最大子序列乘积
 * 仔细阅读题目中关于输入与输出格式的描述，例如空行、空格、值等
 * 注意：1. 连续子序列，不能改变数的顺序
 * 2. 最大乘积变量的初始化为0，因为题目中要求乘积为负时输出0
 * 3. 可能序列的乘积p初始化为1
 * 
 * @author zhaohuiyang
 *
 */
public class U11059 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int caseId = 1;
		while(sc.hasNextInt()) {
			int num = sc.nextInt();
			int[] arr = new int[num];
			for (int i = 0; i < num; i++) {
				arr[i] = sc.nextInt();
			}
			
			long maxProduct = 0;
			for (int i = 0; i < arr.length; i++) {
				long p = 1;
				for (int j = i; j < arr.length; j++) {
					p = p * arr[j];
					if(p > maxProduct) {
						maxProduct = p;
					}
				}
			}
			
			System.out.println("Case #" + caseId +": The maximum product is " + maxProduct + ".");
			caseId ++;
			System.out.println();
		}
		
		sc.close();
	}
}
