/**
 * 电话号码处理
 * 将字母和数字表示的电话号码进行形式上的统一，并统计重复的号码次数
 * 超时，oj系统未通过
 */
package poj.string.basic.easy;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class P1002A {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		String[] arr = new String[a]; 
		for (int i = 0; i < a; i++) {
			arr[i] = sc.next();
		}
		sc.close();
		long start = System.currentTimeMillis();
		deal(arr);
		long end = System.currentTimeMillis();
		System.out.println(end-start);
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
		s = s.replaceAll("[A|B|C]", "2");
		s = s.replaceAll("[D|E|F]", "3");
		s = s.replaceAll("[G|H|I]", "4");
		s = s.replaceAll("[J|K|L]", "5");
		s = s.replaceAll("[M|N|O]", "6");
		s = s.replaceAll("[P|R|S]", "7");
		s = s.replaceAll("[T|U|V]", "8");
		s = s.replaceAll("[W|X|Y]", "9");
		s = s.replaceAll("-", "");
		s = s.substring(0,3) + "-" + s.substring(3);
		return s;
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
