/**
 * Scanner输入总结
 * 1. 一般用nextLine或next
 * 2. nextLine适用于每行作为一个基本输入单位的情况，next以空白符分隔为一个个基本输入单位
 * 3. 输入结束的控制两种方法：（1）第一行给出输入的个数；（2）最后一行通过特殊字符控制结束
 * 4. 不管是nextLine还是next，接收的类型都是String，如果要作为数值处理，使用类型转换函数即可
 * 5. 如果要使用nextInt等包含类型的方法，一般用于已知输入个数的情形，因为结束符通常是特殊字符而不是数字
 * 6. 如果分隔符不是空白符，可以使用useDelimiter设置
 */
package my.io;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ScannerTest {
	public static void main(String[] args) {
//		test1();
//		test2();
//		test3();
//		test4();
//		test5();
		test6();
	}
	
	
	/**
	 * 第一行给出输入的总行数
	 */
	private static void test1() {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		String[] lines = new String[n];
		for (int i = 0; i < lines.length; i++) {
			String line = sc.nextLine();
			lines[i] = line;
		}
		sc.close();
		print(lines);
	}
	
	
	/**
	 * 以特定字符串作为输入结束的标志
	 */
	private static void test2() {
		Scanner sc = new Scanner(System.in);
		List<String> list = new ArrayList<String>();
		while(sc.hasNextLine()) {
			String line = sc.nextLine();
			if(line.equals("end")) {
				sc.close();
				break;
			}
			list.add(line);
		}
		print(list.toArray());
	}
	
	
	/**
	 * next--默认以空白字符作为分隔符,一个或多个空格，回车换行都可以
	 * 主要适用于一行有多个输入的情况
	 */
	private static void test3() {
		Scanner sc = new Scanner(System.in);
		List<String> list = new ArrayList<String>();
		while(sc.hasNext()) {
			String line = sc.next();
			if(line.equals("end")) {
				sc.close();
				break;
			}
			list.add(line);
		}
		print(list.toArray());
	}
	
	
	/**
	 * next--默认以空白字符作为分隔符,一个或多个空格，回车换行都可以
	 * 根据要求，进行相应的类型转换，int double等
	 */
	private static void test4() {
		Scanner sc = new Scanner(System.in);
		List<Integer> list = new ArrayList<Integer>();
		while(sc.hasNext()) {
			String line = sc.next();
			if(line.equals("end")) {
				sc.close();
				break;
			}
			list.add(Integer.parseInt(line));
		}
		print(list.toArray());
	}
	
	
	/**
	 * next--默认以空白字符作为分隔符,一个或多个空格，回车换行都可以
	 */
	private static void test5() {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		int[] lines = new int[n];
		for (int i = 0; i < lines.length; i++) {
			int line = sc.nextInt();
			lines[i] = line;
		}
		sc.close();
		print(lines);
	}
	
	
	/**
	 * 指定分隔符为fish
	 */
	private static void test6() {
		String input = "1 fish 2 fish red fish blue fish";
	     Scanner s = new Scanner(input).useDelimiter("\\s*fish\\s*");
	     System.out.println(s.nextInt());
	     System.out.println(s.nextInt());
	     System.out.println(s.next());
	     System.out.println(s.next());
	     s.close();
	}
	
	
	/**
	 * 输入处理模块，以打印输出为例
	 * @param arr 接收所有的输入
	 */
	private static void print(Object[] arr) {
		for (Object s : arr) {
			System.out.println(s);
		}
	}
	
	/**
	 * 输入处理模块，以打印输出为例
	 * @param arr 接收所有的输入，输入是基本类型
	 */
	private static void print(int[] arr) {
		for (int s : arr) {
			System.out.println(s);
		}
	}
	
}
