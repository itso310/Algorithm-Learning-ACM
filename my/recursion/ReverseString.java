package my.recursion;
/**
 * 反转串
 * 我们把“cba”称为“abc”的反转串。 
 * 求一个串的反转串的方法很多。下面就是其中的一种方法，代码十分简洁（甚至有些神秘）， 
 * 请聪明的你通过给出的一点点线索补充缺少的代码。 
 * 把填空的答案（仅填空处的答案，不包括题面）存入考生文件下对应题号的“解答.txt”中即可。 
 * @author zhaohuiyang
 * @unit   xcu
 */
public class ReverseString {

	public static void main(String[] args) {
		String s = "abcdefg";
		s = reverseString(s);
		System.out.println(s);
	}
	
	
	public static String reverseString(String x){
		if(x == null || x.length() <= 1)	return x;
		return reverseString(x.substring(1)) + x.charAt(0);
	}

}
