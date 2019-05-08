package my.recursion;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 输出多个元素的全排列，可以含相同元素
 * @author zhaohuiyang
 *
 */
public class Permutation3 {

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

	public static void printPermutation(int n, int[] arr, int[] p, int cur) {
		if (cur == n) {
			for (int i = 0; i < n; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
			return;
		}

		for (int i = 0; i < n; i++) {
			if (i == 0 || (i > 0 && p[i] != p[i - 1])) {
				int c1 = 0, c2 = 0;
				for (int j = 0; j < cur; j++)
					if (arr[j] == p[i])
						c1++;
				for (int j = 0; j < n; j++)
					if (p[i] == p[j])
						c2++;
				if (c1 < c2) {
					arr[cur] = p[i];
					printPermutation(n, arr, p, cur + 1);
				}
			}
		}
	}
}
