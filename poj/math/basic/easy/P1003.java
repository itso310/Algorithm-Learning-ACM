/**
 * poj 1003题
 * Hangover
 * 卡片悬挂于桌子上而不掉落的条件是：
 * 假设有n张卡片，自上而下排序，则每张卡片悬空的部分分别为第1张1/2，第2张是1/3，依次类推，第n张是1/n+1，
 * 1/2 + 1/3 + ... + 1/n+1 > 输入数字
 */
package poj.math.basic.easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P1003 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		List<Float> inList = new ArrayList<Float>();
		String snum = scan.next();
		while(!snum.equals("0.00")) {
			boolean flag = isValid(snum);
//			System.out.println(flag);
			if(flag) {
				inList.add(Float.parseFloat(snum));
			}
			else {
				System.out.println("This is a no valid num");
			}
			snum = scan.next();
		}
		if(inList.size() > 0) {
			List<Integer> numList = getAllCardsNum(inList);
			for (Integer num : numList) {
				System.out.println(num + " card(s)");
			}
		}
		
	}
	
	
	/**
	 * 校验输入字符串的有效性
	 * 条件1：3个数字，加上小数点，所以长度为4
	 * 条件2：数字范围在0.01和5.20中间
	 * @param s 字符串，card的悬挂长度
	 * @return 输入字符串是否有效
	 */
	private static boolean isValid(String s) {
		if(s.length() == 4) {
			float f = Float.parseFloat(s);
			if(f >= 0.01 && f <= 5.20)
				return true;
		}
		return false;
	}
	
	
	/**
	 * 求所有输入长度对应的卡片数量
	 * @param inList 所有有效的输入数字组成的list
	 * @return 与所有输入对应的卡片数量
	 */
	private static List<Integer> getAllCardsNum(List<Float> inList) {
		List<Integer> outList = new ArrayList<Integer>();
		for (Float f : inList) {
			int num = getOneCardsNum(f);
			outList.add(num);
		}
		return outList;
	}
	
	
	/**
	 * 求一个输入长度对应需要的卡片数量
	 * @param f 卡片的悬挂长度
	 * @return 与输入对应的卡片数量
	 */
	private static int getOneCardsNum(float f) {
		float sum = 0.0f;
		int cardNum = 0;
		while(sum < f) {
			cardNum++;
			sum = sum + 1.0f/(cardNum+1);
		}
		return cardNum;
	}
}
