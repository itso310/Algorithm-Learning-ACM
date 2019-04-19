package poj.math.basic.easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P1207C {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextLine()) {
			String line = sc.nextLine();
			String[] arr = line.split(" ");
			int start = Integer.parseInt(arr[0]);
			int end = Integer.parseInt(arr[1]);
			long startTime = System.currentTimeMillis();
			deal(start, end);
			long endTime = System.currentTimeMillis();
			System.out.println(endTime-startTime);
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
		
		List<Integer> list = new ArrayList<Integer>();
		for (int i = max; i >= min; i--) {
			list.add(i);
		}
		int maxCycle = 1;
		while(list.size()>0) {
			int count = 1;
			int i = list.get(0);
			int n = i;
			list.remove(new Integer(n));
			while(n != 1) {
				n = basic(n);
				count++;
				list.remove(new Integer(n));
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
