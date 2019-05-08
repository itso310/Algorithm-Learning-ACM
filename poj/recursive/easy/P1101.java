package poj.recursive.easy;

import java.util.Scanner;
/**
 * 连连看游戏
 * 通过AC
 * 边缘的连线限制在同一侧
 * @author zhaohuiyang
 *
 */
public class P1101 {
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
				int orientation = 0;
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

		// 左
		if (x1 >= 1 && x1 < cards[0].length && y1 >= 0 && y1 < cards.length) {// 判断新的点是不是在棋盘中
			if ((cards[y1][x1 - 1] == ' ' && mark[y1][x1 - 1] == false) || (x1 - 1 == x2 && y1 == y2)) {
				int f = -2;
				mark[y1][x1 - 1] = true;
				if (f == orientation) {
					g(cards, mark, x1 - 1, y1, x2, y2, steps, f);
				} else {
					g(cards, mark, x1 - 1, y1, x2, y2, steps + 1, f);
				}
				mark[y1][x1 - 1] = false;
			}
		}

		// 上
		if (x1 >= 0 && x1 < cards[0].length && y1 >= 1 && y1 < cards.length) {// 判断新的点是不是在棋盘中
			if ((cards[y1 - 1][x1] == ' ' && mark[y1 - 1][x1] == false) || (x1 == x2 && y1 - 1 == y2)) {
				int f = 1;
				mark[y1 - 1][x1] = true;

				if (f == orientation) {
					g(cards, mark, x1, y1 - 1, x2, y2, steps, f);
				} else {
					g(cards, mark, x1, y1 - 1, x2, y2, steps + 1, f);
				}
				mark[y1 - 1][x1] = false;
			}
		}

		// 右
		if (x1 >= 0 && x1 < cards[0].length - 1 && y1 >= 0 && y1 < cards.length) {
			if ((cards[y1][x1 + 1] == ' ' && mark[y1][x1 + 1] == false) || (x1 + 1 == x2 && y1 == y2)) {
				int f = 2;
				mark[y1][x1 + 1] = true;

				if (f == orientation) {
					g(cards, mark, x1 + 1, y1, x2, y2, steps, f);
				} else {
					g(cards, mark, x1 + 1, y1, x2, y2, steps + 1, f);
				}
				mark[y1][x1 + 1] = false;
			}
		}

		// 下
		if (x1 >= 0 && x1 < cards[0].length && y1 >= 0 && y1 < cards.length - 1) {
			if ((cards[y1 + 1][x1] == ' ' && mark[y1 + 1][x1] == false) || (x1 == x2 && y1 + 1 == y2)) {
				int f = -1;
				mark[y1 + 1][x1] = true;

				if (f == orientation) {
					g(cards, mark, x1, y1 + 1, x2, y2, steps, f);
				} else {
					g(cards, mark, x1, y1 + 1, x2, y2, steps + 1, f);
				}
				mark[y1 + 1][x1] = false;
			}
		}
	}
}
