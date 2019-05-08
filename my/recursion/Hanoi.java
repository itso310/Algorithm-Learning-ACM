package my.recursion;

public class Hanoi {

	static int i;
	
	public static void main(String[] args) {
		f(4, 'A', 'B', 'C');
	}
	
	public static void move(int n, char start, char end) {
		System.out.println("第"+ ++i +"步:将"+n +"号盘子从" + start + "->" + end);
	}
	
	
	/**
	 * 汉诺塔函数
	 * @param n 盘子数量
	 * @param start 盘子所在位置，源位置
	 * @param mid 空的位置
	 * @param end 目标位置
	 */
	public static void f(int n, char start, char mid, char end) {
		if(n==1) {
			move(n, start, end);
			return;
		}
		
		f(n-1, start, end, mid);
		//n指第n个盘子，因为经过上面的步骤，将n-1个盘子从start位置移动到了mid位置，只剩一个编号为n的盘子
		move(n, start, end); 
		//将剩余的n-1个盘子移动到目标位置，只不过这n-1个盘子的位置发生了变化，在mid位置
		f(n-1, mid, start, end);
	}
}
