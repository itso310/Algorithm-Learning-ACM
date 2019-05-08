package my.recursion;


/**
 * 输出n个元素的全排列，不存在相同元素
 * @author zhaohuiyang
 * @unit   xcu
 */
public class Permutaion {

	public static void main(String[] args) {
		String s = "123";
		char[] arr= s.toCharArray();
//		Arrays.sort(arr);
		f(arr,0);
	}

	private static void f(char[] arr, int k) {
		if(k == arr.length-1){
			for (int i = 0; i < arr.length; i++) {
				System.out.print(arr[i]+" ");
			}
			System.out.println();
		}
		
		for (int i = k; i < arr.length; i++) {
			{char t = arr[k]; arr[k] = arr[i]; arr[i] = t;}
			f(arr, k+1);
			{char t = arr[k]; arr[k] = arr[i]; arr[i] = t;}
		}
	}
}
