package poj.recursive.easy;

import java.util.Scanner;
/**
 * 连连看游戏--整合相同代码，变得简单
 * 通过AC
 * 边缘的连线限制在同一侧
 * @author zhaohuiyang
 *
 */
public class P1101A {
	static int minsteps = 99999;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int boardId = 0;

		String line = "";
		while (!(line = sc.nextLine().trim()).equals("0 0")) {

			boardId++;
			String[] arr = line.split(" ");
			int w = Integer.parseInt(arr[0]);
			int h = Integer.parseInt(arr[1]);
			char[][] cards = new char[h + 2][w + 2];

			for (int i = 0; i < w + 2; i++) {
				cards[0][i] = ' ';
				cards[h + 1][i] = ' ';
			}
			for (int i = 1; i <= h; i++) {
				cards[i] = (" " + sc.nextLine() + " ").toCharArray();
			}
			String line2 = "";
			System.out.println("Board #" + boardId + ":");

			int pairId = 0;
			while (!(line2 = sc.nextLine().trim()).equals("0 0 0 0")) {
				String[] pairArr = line2.split(" ");
				int x1 = Integer.parseInt(pairArr[0]);
				int y1 = Integer.parseInt(pairArr[1]);
				int x2 = Integer.parseInt(pairArr[2]);
				int y2 = Integer.parseInt(pairArr[3]);
				int segNum = 0;
				int orientation = -1;
				boolean[][] mark = new boolean[h + 2][w + 2];
				minsteps = 99999;
				g(cards, mark, x1, y1, x2, y2, segNum, orientation);
				pairId++;
				String sNum = "impossible.";

				if (minsteps != 99999) {
					sNum = minsteps + " segments.";
				}
				System.out.println("Pair " + pairId + ": " + sNum);
			}
			System.out.println();
		}

		sc.close();
	}

	public static void g(char[][] cards, boolean[][] mark, int x1, int y1, int x2, int y2, int steps, int orientation) {

		if (steps > minsteps)
			return;

		if (x1 == x2 && y1 == y2) {
			if (steps < minsteps) {
				minsteps = steps;
			}
			return;
		}

		
		//to数组的每一行代表向一个方向的移动时，xy的取值变化是不变还是+1，-1
		//4行分别代表向下，右，上，左四个方向移动，逆时针
		int[][] to = {{0,1},{1,0},{0,-1},{-1,0}};
		//i={0,1,2,3}这四个值分别代表上述四个方向的移动
		for (int i = 0; i < 4; i++) {
			int new_x1 = x1 + to[i][0];
			int new_y1 = y1 + to[i][1];
			
			if (new_x1 >= 0 && new_x1 < cards[0].length && new_y1 >= 0 && new_y1 < cards.length) {// 判断新的点是不是在棋盘中
				if ((cards[new_y1][new_x1] == ' ' && mark[new_y1][new_x1] == false) || (new_x1 == x2 && new_y1 == y2)) {
					mark[new_y1][new_x1] = true;
					if (i == orientation) {
						g(cards, mark, new_x1, new_y1, x2, y2, steps, i);
					} else {
						g(cards, mark, new_x1, new_y1, x2, y2, steps + 1, i);
					}
					mark[new_y1][new_x1] = false;
				}
			}
		}
	}
}
