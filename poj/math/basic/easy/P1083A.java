/**
 * 移动桌子，每一次移动耗时10分钟
 * 占用同一段走廊的不能同时移动
 * 特殊情形：多个对门的两个房间移动桌子可以同时进行
 * 由于每个奇数都和它对面的偶数是等价的，所以可以把所有奇数变成对应的偶数
 */
package poj.math.basic.easy;

import java.util.Scanner;

public class P1083A {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int caseNum = Integer.parseInt(sc.nextLine().trim());
		for (int i = 0; i < caseNum; i++) {
			int groupNum = Integer.parseInt(sc.nextLine().trim());
			int[] countArr = new int[400]; 
			for (int j = 0; j < groupNum; j++) {
				String line = sc.nextLine().trim();
				String[] arr = line.split(" ");
				int start = Integer.parseInt(arr[0]);
				int end = Integer.parseInt(arr[1]);
				if(start > end) {
					int tmp = start;
					start = end;
					end = tmp;
				}
				if(start%2!=0) {
					start++;
				}
				if(end%2!=0) {
					end++;
				}
				for (int k = start; k <= end; k++) {
					countArr[k-1] = countArr[k-1] + 1;
				}
			}
			
			int max = 0;
			for (int j = 0; j < countArr.length; j++) {
				if(countArr[j] > max) {
					max = countArr[j];
				}
			}
			int t = max * 10;;
			System.out.println(t);
		}
		sc.close();
	}
	
}

