/**
 * 给定一个32位有符号整数，将其逆序输出。
 * 假设处理环境仅能存储32位有符号整数，当逆序后的整数溢出时返回0。
 */
package leetcode.string.basic.easy;

public class S0007 {

	public int reverse(int x) {
		if(x == 0){
			return x;
		}
		String s = x + "";
		if(s.charAt(s.length()-1) == '0'){
			s = s.substring(0, s.length()-1);
		}
		String symbol = "";
		if(x<0){
			symbol = "-";
			s = s.substring(1,s.length());
		}else{
			symbol = "+";
		}
        String s2 = "";
        for (int i = s.length()-1; i >=0; i--) {
			s2 = s2 + s.charAt(i);
		}
        long result = Long.parseLong(symbol + s2);
        if(result > Integer.MAX_VALUE || result<Integer.MIN_VALUE){
        	return 0;
        }
        return (int)result;
    }
	
	
	public static void main(String[] args) {
		S0007 sol = new S0007();
		int x = -123;
		int result = sol.reverse(x);
		System.out.println(result);
	}
}
