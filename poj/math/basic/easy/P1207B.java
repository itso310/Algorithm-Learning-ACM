package poj.math.basic.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;
/**
 * 结果正确，oj未通过
 * @author zhaohuiyang
 *
 */
public class P1207B {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(sc.hasNextLine()) {
			String line = sc.nextLine();
			String[] arr = line.split(" ");
			int start = Integer.parseInt(arr[0]);
			int end = Integer.parseInt(arr[1]);
			deal(start, end);
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
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = min; i <= max; i++) {
			int count = 1;
			int n = i;
			while(n != 1) {
				if(!map.containsKey(n)) {
					stack.push(n);
					count++;
					n = basic(n);
				}
				else {
					int j = map.get(n);
					while (!stack.isEmpty()) {
						int key = stack.pop();
						count = ++j;
						map.put(key, count);
					}
					break;
				}
			}
			stack.clear();
			map.put(i, count);
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
