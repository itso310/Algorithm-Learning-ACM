package my.recursion;

/**
 * 顺序打印数字0到n
 * @author zhaohuiyang
 *
 */
public class PrintNum2 {

	public static void main(String[] args) {
		int n = 9;
		f(n);
	}
	
	
	public static void f(int n) {
		if(n>0) f(n-1);
		System.out.println(n);
	}
}
