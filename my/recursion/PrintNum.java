package my.recursion;

/**
 * 逆序打印数字0到n
 * @author zhaohuiyang
 *
 */
public class PrintNum {

	public static void main(String[] args) {
		int n = 9;
		f(n);
	}
	
	
	public static void f(int n) {
		System.out.println(n);
		if(n>0) f(n-1);
	}
}
