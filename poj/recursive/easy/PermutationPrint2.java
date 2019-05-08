package poj.recursive.easy;

import java.util.Arrays;
import java.util.Scanner;

public class PermutationPrint2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		int[] p = new int[n];
		for (int i = 0; i < n; i++) {
			p[i] = sc.nextInt();
		}
		Arrays.sort(p);
		printPermutation(n, arr, p, 0);
		sc.close();
	}
	
	
	public static void printPermutation(int n, int[] arr, int[] p, int cur ) {
//		System.out.println("aa--" + cur);
		if(cur == n) {
			for (int i = 0; i < arr.length; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
			return;
		}
		
		
		for (int i = 0; i < n; i++) {
//			System.out.println("bb**" + p[i]);
			boolean f = true;
			for (int j = 0; j < cur; j++) {
				if (arr[j] == p[i]) {
					int countp = 0;
					int counta = 0;
					for (int k = 0; k < n && p[k] <= p[i]; k++) {
						if (p[k] == p[i])
							countp++;
					}
					for (int k = 0; k < cur; k++) {
						if (arr[k] == arr[j])
							counta++;
					}
					if (counta >= countp) {
						f = false;
						break;
					}
				}
			}
			
			if (f && ((i==0) || (i!=0 && p[i]!=p[i-1]))) {
//				System.out.println("cc##" + p[i]);
				arr[cur] = p[i];
				printPermutation(n, arr, p, cur + 1);
			}
		}
		
	}
}
