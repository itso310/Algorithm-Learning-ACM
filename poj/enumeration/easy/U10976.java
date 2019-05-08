package poj.enumeration.easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class U10976 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(sc.hasNextInt()) {
			int k = sc.nextInt();
			int count = 0;
			List<String> list = new ArrayList<String>();
			for (int y = k+1; y <= 2*k; y++) {
				if(y*k % (y-k) == 0) {
					int x = y*k/(y-k);
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
