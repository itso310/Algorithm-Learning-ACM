package poj.recursive.easy;

import java.util.Scanner;

public class PermutationPrint {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		printPermutation(n, arr, 0);
		sc.close();
	}
	
	
	public static void printPermutation(int n, int[] arr, int cur ) {
		if(cur == n) {
			for (int i = 0; i < arr.length; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
			return;
		}
		
		
		for (int j = 1; j <= n; j++) {
			boolean f = true;
			for (int i = 0; i < cur; i++) {
				if(arr[i] == j) {
					f = false;
					break;
				}
			}
			if(f) {
				arr[cur] = j;
				printPermutation(n, arr, cur+1);
			}
		}
	}
}
