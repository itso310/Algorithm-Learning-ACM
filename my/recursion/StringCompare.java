package my.recursion;

public class StringCompare {

	public static void main(String[] args) {
		String s1 = "abcd";
		String s2 = "abcde";
		boolean r = isSame(s1, s2);
		System.out.println(r);
	}
	
	public static boolean isSame(String s1, String s2) {
		if(s1.length() != s2.length()) return false;
		if(s1.length() ==0 && s2.length()==0) return true;
		if(s1.charAt(0) != s2.charAt(0)) return false;
		return isSame(s1.substring(1), s2.substring(1));
	}
}
