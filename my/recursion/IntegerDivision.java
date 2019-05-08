package my.recursion;

public class IntegerDivision {

	public static void main(String[] args) {
		int n = 6;
		int[] a = new int[1000];
		f(n, a, 0);
	}
	
	public static void f(int n, int[] a, int k) {
		if(n <= 0) {
			String s = "";
			for (int j = 0; j < k; j++) {
				s =s + "+" + a[j];
			}
			System.out.println(s.substring(1));
			return;
		}
		
		//后放的数<=前放的数
		for (int i = n; i >= 1; i--) {
			if(k>0 && i > a[k-1]) continue;
			a[k] = i;
			f(n-i, a, k+1);
		}
	}
}
