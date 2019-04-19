/**
 * Fred 发现这些土地是以半圆的形状被侵蚀的。问输入Fred Mapper家的坐标（X,Y），他家所在的位置什么时候被河水侵蚀。
 * Fred Mapper的家（X,Y）到侵蚀中心（0，0）的距离就是侵蚀半径r
 * 那么Area = 1/2*pi*r*r 就是侵蚀到Fred Mapper家时的侵蚀面积
 * 而侵蚀速度为每年50,那么侵蚀到Fred Mapper家需要 RestYear = Area/50年
 */
package poj.math.basic.easy;

import java.util.Scanner;

public class P1005 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = Integer.parseInt(sc.nextLine());
		for (int i = 0; i < a; i++) {
			String line = sc.nextLine();
			String[] arr = line.split(" ");
			double x = Double.parseDouble(arr[0]);
			double y = Double.parseDouble(arr[1]);
			int z = getYears(x, y);
			System.out.println("Property " + (i+1) + ": This property will begin eroding in year " + z + ".");
		}
		sc.close();
		System.out.println("END OF OUTPUT.");
	}
	
	
	private static int getYears(double x, double y) {
		double r2 = x*x + y*y;
		double zd = Math.PI*r2/2/50;
		int z = (int)Math.ceil(zd);
		return z;
	}
}
