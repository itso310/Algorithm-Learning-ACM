package my.recursion;

/**
 * 求数组中各元素的和
 * @author zhaohuiyang
 *
 */
public class SumArray {

	public static void main(String[] args) {
		int[] arr = new int[] {1,3,5,7};
		int r = f(arr, 0);
		System.out.println(r);
	}
	
	public static int f(int[] a, int pos) {
		
		if(pos>a.length-1) return 0;
		int r = a[pos] + f(a, pos+1);
		return r;
	}
}
