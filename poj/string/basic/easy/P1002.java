/**
 * 电话号码处理
 * 将字母和数字表示的电话号码进行形式上的统一，并统计重复的号码次数
 */
package poj.string.basic.easy;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class P1002 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		String[] arr = new String[a]; 
		for (int i = 0; i < a; i++) {
			arr[i] = sc.next();
		}
		sc.close();
//		long start = System.currentTimeMillis();
		deal(arr);
//		long end = System.currentTimeMillis();
//		System.out.println(end-start);
		
	}
	
	
	private static void deal(String[] arr) {
		for (int i = 0; i < arr.length; i++) {
			arr[i] = toUniqueString(arr[i]);
		}
		Map<String, Integer> map = count(arr);
		print(map);
	}
	
	
	private static void print(Map<String, Integer> map) {
		boolean f = true;
		if(map.size()>0) {
			Set<Entry<String, Integer>> set = map.entrySet();
			for (Entry<String, Integer> entry : set) {
				String key = entry.getKey();
				int value = entry.getValue();
				if(value>1) {
					f = false;
					System.out.println(key + " " + value);
				}
			}
		}
		if(f) {
			System.out.println("No duplicates.");
		}
	}
	
	private static String toUniqueString(String s) {
		int len = s.length();
		String newstr = "";
		for(int i=0; i<len; i++) {
			char ch = s.charAt(i);
			switch (ch) {
			case 'A':
			case 'B':
			case 'C':newstr = newstr + "2";break;
			case 'D':
			case 'E':
			case 'F':newstr = newstr + "3";break;
			case 'G':
			case 'H':
			case 'I':newstr = newstr + "4";break;
			case 'J':
			case 'K':
			case 'L':newstr = newstr + "5";break;
			case 'M':
			case 'N':
			case 'O':newstr = newstr + "6";break;
			case 'P':
			case 'R':
			case 'S':newstr = newstr + "7";break;
			case 'T':
			case 'U':
			case 'V':newstr = newstr + "8";break;
			case 'W':
			case 'X':
			case 'Y':newstr = newstr + "9";break;
			case '-':break;
			default:
				newstr = newstr + ch;break;
			}
		}
		newstr = newstr.substring(0,3) + "-" + newstr.substring(3);
		return newstr;
	}

	
	private static Map<String, Integer> count(String[] arr) {
		Map<String, Integer> map = new TreeMap<String, Integer>();
		for (String s : arr) {
			if(map.containsKey(s)) {
				map.put(s, map.get(s)+1);
			}
			else {
				map.put(s, 1);
			}
		}
		return map;
	}
}
