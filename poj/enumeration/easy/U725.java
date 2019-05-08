package poj.enumeration.easy;

import java.util.Scanner;

public class U725 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean first = true;
		int n = 0;
		while((n = sc.nextInt())!=0) {
			if(!first) System.out.println();
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
			first = false;
		}
		
		sc.close();
	}
	
	
	public static boolean deal(String s) {
		if(s.contains("0") && s.contains("1") && s.contains("2") && s.contains("3") && s.contains("4") && s.contains("5") && s.contains("6") && s.contains("7") && s.contains("8") && s.contains("9")) {
			return true;
		}
		return false;
	}
}
