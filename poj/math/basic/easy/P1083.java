/**
 * 移动桌子，每一次移动耗时10分钟
 * 占用同一段走廊的不能同时移动
 * 特殊情形：多个对门的两个房间移动桌子可以同时进行
 * 把每一对数排序后，如果end端的数字为奇数，转换为偶数
 */
package poj.math.basic.easy;

import java.util.Scanner;

public class P1083 {
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

