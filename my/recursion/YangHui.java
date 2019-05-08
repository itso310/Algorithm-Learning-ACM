package my.recursion;


/**
 * 杨辉三角，求第m层的第n个元素，m>=0, n>=m>=0
 * @author zhaohuiyang
 * @unit   xcu
 */
public class YangHui {

	public static void main(String[] args) {
		int m = 3;
		int n = 2;
		int k = f(m, n);
		System.out.println(k);
	}
	
	
	public static int f(int m, int n){
		if(n == 0) return 1;
		if(n == m) return 1;
		return f(m-1,n-1) + f(m-1,n);
	}

}
