package my.recursion;


/**
 * 3个A，2个B有多少种排列
 * 固定第一位为A，有f(m-1,n)种
 * 固定第一位为B，有f(m,n-1)种
 * @author zhaohuiyang
 * @unit   xcu
 */
public class Permutation4 {

	public static void main(String[] args) {
		int m = 3;
		int n = 2;
		int k = f(m, n);
		System.out.println(k);
	}

	
	private static int f(int m, int n) {
		if(m == 0 || n==0) return 1;
		return f(m-1,n) + f(m,n-1);
	}
}
