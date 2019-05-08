package poj.enumeration.easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class U725A {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Integer> list = new ArrayList<Integer>();
		while(sc.hasNextInt()) {
			int n = sc.nextInt();
			if(n == 0) {
				break;
			}
			list.add(n);
		}
		
		int blank = 0;
		for (Integer n : list) {
			if(blank!=0) System.out.println();
			boolean f = true;
			for (int i = 12345; i <= 98765; i++) {
				if(i%n == 0) {
					int j = i/n;
					String sj = "" + j;
					if(j<10000) sj = "0" + j;
					String s = i + sj;
					boolean b = deal(s);
					if(b) {
						System.out.println(i + " / " + sj + " = " + n);
						f = false;
					}
				}
			}
			if(f) {
				System.out.println("There are no solutions for " + n + ".");
			}
			blank++;
		}
		
		sc.close();
	}
	
	
	private static boolean deal(String s) {
		if(s.contains("0") && s.contains("1") && s.contains("2") && s.contains("3") && s.contains("4") && s.contains("5") && s.contains("6") && s.contains("7") && s.contains("8") && s.contains("9")) {
			return true;
		}
		return false;
	}
}
