package poj.enumeration.easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class U10976A {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(sc.hasNextInt()) {
			int k = sc.nextInt();
			int count = 0;
			List<String> list = new ArrayList<String>();
			for (int y = k+1; y <= 2*k; y++) {
				int x = y*k/(y-k);
				double x1 = 1.0*y*k/(y-k);
				if(Math.abs(x1-x) < 10e-6) {
					count++;
					list.add("1/"+k +" = 1/" + x + " + " + "1/"+y);
				}
			}
			System.out.println(count);
			for (String s : list) {
				System.out.println(s);
			}
		}
		
		sc.close();
	}
}
