package my.other;

/**
 * 运行时间测试，单位毫秒
 * @author zhaohuiyang
 *
 */
public class RuntimeTest {
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		long sum = 1;
		for (int i = 1; i <= 20; i++) {
			sum = sum * i;
		}
		System.out.println(sum);
		long end = System.currentTimeMillis();
		System.out.println(end-start);
	}
}
