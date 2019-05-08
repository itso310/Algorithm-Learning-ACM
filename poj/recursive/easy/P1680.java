package poj.recursive.easy;

import java.util.Scanner;

/**
 * 递归模拟，题目含义不太清楚
 * 指定循环次数和行号，输出对应的输出
 * @author zhaohuiyang
 *
 */
public class P1680 {
	static int kRoot = 1000;
	static int P = 1000;
//	static int n = 0;
	static int k = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = Integer.parseInt(sc.nextLine().trim());
		for(int j = 0; j< num; j++) {
			String line = sc.nextLine().trim();
			String[] arr = line.split(" ");
			int n = Integer.parseInt(arr[0]);
			k = Integer.parseInt(arr[1]);
			
			dfs(n, 0, 0, P=kRoot);
		}
		sc.close();
	}
	
	
	private static boolean dfs(int n, int i, int a, int p) {
		if(p != kRoot){
			if(--k == 0){
				System.out.println(String.format("Process ID=%d, A=%d", p, a));
				return true;
			}
		}
		while(i < n){
			if(--k == 0){
				System.out.println(String.format("Loop %d: Process ID=%d", i, p));
				return true;
			}
			a += 7;
			if(dfs(n, ++i, a, ++P)) return true;
		}
		return false;
	}

}
