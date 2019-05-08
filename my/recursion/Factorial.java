package my.recursion;

public class Factorial {
	public static void main(String[] args) {
		int r = f(10);
		System.out.println(r);
	}
	
	public static int f(int n) {
		if(n==0) {
			return 1;
		}
		int r = n*f(n-1);
		return r;
	}
}
