package my.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * 杨辉三角,打印图形
 * 层数m>=0, 第m层有m+1个元素
 * @author zhaohuiyang
 * @unit   xcu
 */
public class YangHui2 {

	public static void main(String[] args) {
		int m = 4;
//		int n = 2;
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i <= m; i++) {
			for (int j = 0; j < i+1; j++) {
				System.out.print(f(i, j) + " ");
			}
			
			System.out.println();
		}
	}
	
	
	public static int f(int m, int n){
		if(n == 0) return 1;
		if(n == m) return 1;
		return f(m-1,n-1) + f(m-1,n);
	}

}
