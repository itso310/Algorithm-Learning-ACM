/**
 * 加密解密问题
 * 对明文进行字母唯一映射和重新排列，得到密文。
 * 注意：此代码未通过oj系统，本代码针对所有字母向后平移若干位提供了解决方案
 */

package poj.string.collection.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class P2159 {
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
			boolean f2 = compareFreq(first, second);
			if(f2) {
				System.out.println("YES");
			}
			else {
				System.out.println("NO");
			}
		}
	}
	
	
	private static boolean compareFreq(String s1, String s2) {
		boolean f = true;
		Map<String, Integer> map1 = count(s1);
		Map<String, Integer> map2 = count(s2);
		int size1 = map1.keySet().size();
		int size2 = map2.keySet().size();
		if(size1 != size2) {
			f = false;
			return f;
		}
		Integer[] arr1 = new Integer[map1.size()];
		Integer[] arr2 = new Integer[map2.size()];
		map1.values().toArray(arr1);
		Arrays.sort(arr1);
		map2.values().toArray(arr2);
		Arrays.sort(arr2);
		
		for (int i = 0; i < arr2.length; i++) {
			if(arr1[i] != arr2[i]) {
				f = false;
			}
//			System.out.println(arr1[i] + " " + arr2[i]);
		}
		
		return f;
	}
	
	
	private static boolean compareLen(String s1, String s2) {
		return s1.length() == s2.length();
	}
	
	
	private static Map<String, Integer> count(String s) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (int i=0; i<s.length(); i++) {
			String c = s.charAt(i) + "";
			if(map.containsKey(c)) {
				map.put(c, map.get(c)+1);
			}
			else {
				map.put(c, 1);
			}
		}
		return map;
	}
}
