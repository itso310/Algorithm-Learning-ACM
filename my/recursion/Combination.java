package my.recursion;
/**
 * 从n个球中取m个有多少种组合
 * @author zhaohuiyang
 * @unit   xcu
 */
public class Combination {

	public static void main(String[] args) {
		int n = 4;
		int m = 2;
		int k = f(n, m);
		System.out.println(k);
	}
	
	
	public static int f(int n, int m){
		if(n < m) return 0;
		if(n == m) return 1;
		if(m == 0) return 1;
		return f(n-1,m-1) + f(n-1,m);
	}

}
