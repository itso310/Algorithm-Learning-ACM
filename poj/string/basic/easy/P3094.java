/**
 * 字符串处理，然后加权求和
 */
package poj.string.basic.easy;

import java.util.Scanner;

public class P3094 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNextLine()) {
			String line = sc.nextLine();
			if(line.equals("#")) {
				sc.close();
				break;
			}
			else {
				int len = line.length();
				int sum = 0;
				for (int i = 0; i < len; i++) {
					int pos = 0;
					if(line.charAt(i) != ' ') {
						pos = line.charAt(i)-'A' + 1;
					}
					sum = sum + (i+1)*pos;
				}
				System.out.println(sum);
			}
		}
		
	}
}
