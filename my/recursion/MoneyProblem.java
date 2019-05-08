package my.recursion;

import java.util.Arrays;
import java.util.Scanner;

public class MoneyProblem {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int lost = sc.nextInt();
		int n = sc.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}
		sc.close();
		boolean[] b = new boolean[n];
		int k = 0;
		int cursum = 0;
		Arrays.sort(a);
		f(lost, a, b, cursum, k);
	}

	private static void f(int lost, int[] a, boolean[] b, int cursum, int k) {
		if (cursum > lost) {
			return;
		}

		if (cursum == lost) {
			
			for (int i = 0; i < b.length; i++) {
				if(b[i] == false) {
					System.out.print(a[i] + " ");
				}
			}
			System.out.println();
			return;
		}

		if (k >= a.length || cursum > lost) {
			return;
		}
		
		//对每个k位置的元素都有两种情况，选或不选，分别尝试
		//不选
		b[k] = false;
		f(lost, a, b, cursum, k + 1);
		
		//选
		b[k] = true;
		cursum = cursum + a[k];
		f(lost, a, b, cursum, k + 1);
		b[k] = false;
	}
}
