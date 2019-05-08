package my.recursion;
/**
 * 求两个字符串的最大公共子序列的长度
 * @author zhaohuiyang
 * @unit   xcu
 */
public class SubSeqLen {
	public static void main(String[] args) {
		String s1 = "kasfg";
		String s2 = "dbafkfg";
		int len = f(s1, s2);
		System.out.println(len);
	}

	private static int f(String s1, String s2) {
		if(s1.length() == 0 || s2.length() == 0)
			return 0;
		if(s1.charAt(0) == s2.charAt(0))
			return f(s1.substring(1), s2.substring(1)) + 1;
		else
			return Math.max(f(s1.substring(1), s2), f(s1, s2.substring(1)));
	}
}
