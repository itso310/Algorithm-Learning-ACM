package poj.recursive.easy;

import java.util.Scanner;

/**
 * 当n>m：必定有n-m个盘子永远空着，去掉它们对摆放苹果方法数目不产生影响。即if(n>m) f(m,n) = f(m,m)
 * 当n<=m分两种情况：
 * 有至少一个盘子空着，即相当于f(m,n) = f(m,n-1)
 * 所有盘子都有苹果，相当于可以从每个盘子中拿掉一个苹果，不影响不同放法的数目，即f(m,n) = f(m-n,n).
 * @author zhaohuiyang
 *
 */
public class P1664 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int lines = sc.nextInt();
		for (int i = 0; i < lines; i++) {
			int m = sc.nextInt();
			int n = sc.nextInt();
			int num = f(m, n);
			System.out.println(num);
		}
		sc.close();
	}
	
	public static int f(int m, int n) {
		if(n == 1) return 1;
		if(m == 0) return 1;
		if(n>m) 
			return f(m,m);
		else
			return f(m,n-1) + f(m-n,n);
	}

}
