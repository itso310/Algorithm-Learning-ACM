package my.recursion;
/**
 * 求两个字符串的最大公共子序列的长度
 * @author zhaohuiyang
 * @unit   xcu
 */
public class SubSeqLen2 {
	public static void main(String[] args) {
		String s1 = "kasfg";
		String s2 = "dbafkfg";
		String s11 = "", s12="";
		for (int i = 0; i < s1.length(); i++) {
			String c = s1.charAt(i) +"";
			if(s2.indexOf(c) != -1) {
				s11 = s11 + c;
			}
		}
		for (int i = 0; i < s2.length(); i++) {
			String c = s2.charAt(i) +"";
			if(s1.indexOf(c) != -1) {
				s12 = s12 + c;
			}
		}
		System.out.println(s11 + "  " + s12);
		int len = f(s11, s12);
		System.out.println(len);
	}

	private static int f(String s1, String s2) {
		if(s1.length() == 0 || s2.length()==0) {
			return 0;
		}
		if(s1.charAt(0) == s2.charAt(0)) {
			return f(s1.substring(1), s2.substring(1)) + 1;
		}
		
		return Math.max(f(s1, s2.substring(1)), f(s1.substring(1), s2));
	}
}
