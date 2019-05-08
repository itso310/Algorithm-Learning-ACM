package my.recursion;

/**
 * 顺序打印数字begin到end
 * @author zhaohuiyang
 *
 */
public class PrintNum3 {

	public static void main(String[] args) {
		int begin=0, end = 9;
		f(begin, end);
	}
	
	
	public static void f(int begin, int end) {
		System.out.println(begin);
		if(begin<end) f(begin+1, end);
		
	}
}
