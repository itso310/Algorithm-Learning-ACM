/**
 * 加密解密问题
 * 对明文进行字母唯一映射和重新排列，得到密文。
 * 注意：字母映射规则不唯一，因此算法反而简单了，只需要进行模糊匹配字母频次即可
 */
package poj.string.collection.medium;

import java.util.Arrays;
import java.util.Scanner;

public class P2159A {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String first = sc.nextLine();
		String second = sc.nextLine();
		sc.close();
		boolean f1 = compareLen(first, second);
		if(!f1) {
			System.out.println("NO");
		}
		else {
			boolean f3 = compareString(first, second);
			if(f3) {
				System.out.println("YES");
			}
			else {
				System.out.println("NO");
			}
		}
	}
	
	
	private static boolean compareString(String s1, String s2) {
		char[] arr1 = s1.toCharArray();
		Arrays.sort(arr1);
		char[] arr2 = s2.toCharArray();
		Arrays.sort(arr2);
		
		boolean f = false;
		for (int i = 1; i < 26; i++) {
			String s3 = "";
			for (int j = 0; j < arr2.length; j++) {
				int na = (int) 'A';
				char c = (char) (na + (arr2[j] + i - na) % 26);
				s3 = s3 + c;
				if (s3.equals(new String(arr1))) {
					f = true;
					break;
				}
			}
		}
		return f;
	}
	
	
	private static boolean compareLen(String s1, String s2) {
		return s1.length() == s2.length();
	}
}
