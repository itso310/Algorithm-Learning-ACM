package poj.math.basic.easy;

import java.util.Scanner;

public class P1207 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextLine()) {
			String line = sc.nextLine();
			String[] arr = line.split(" ");
			int start = Integer.parseInt(arr[0]);
			int end = Integer.parseInt(arr[1]);
//			long startTime = System.currentTimeMillis();
			deal(start, end);
//			long endTime = System.currentTimeMillis();
//			System.out.println(endTime-startTime);
		}
		sc.close();
	}
	
	
	private static void deal(int start, int end) {
		int min = start;
		int max = end;
		if(start>end) {
			min = end;
			max = start;
		}
		
		int maxCycle = 1;
		for (int i = min; i <= max; i++) {
			int count = 1;
			int n = i;
			while(n != 1) {
				n = basic(n);
				count++;
			}
			if(count>maxCycle) {
				maxCycle = count;
			}
		}
		System.out.println(start + " " + end + " " + maxCycle);
	}
	
	private static int basic(int n) {
		if(n == 1) {
			return 1;
		}
		else {
			if(n%2 == 0) {
				return n/2;
			}
			else {
				return n*3+1;
			}
		}
	}
}
