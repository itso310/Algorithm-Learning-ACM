/**
 * 两个整数以链表的形式逆序存储并相加求和
 * 给定两个非空的链表，表示两个非负整数。每个整数以逆序的方式存储在多个节点中。每个节点存储一个数字。将两个整数相加并返回一个链表。
 * 假设两个整数的最高位数字都不是0，除了0本身。
 */
package leetcode.math.collection.medium;

public class S0002 {

	
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode dummyHead = new ListNode(0);
		ListNode p=l1,q=l2, curr =dummyHead;
		int jinwei = 0;
		while(p != null || q!=null){
			int x = p != null? p.val:0;
			int y = q != null? q.val:0;
			int sum = x + y + jinwei;
			int yushu = sum%10;
			jinwei = sum/10;
			curr.next = new ListNode(yushu);
			curr = curr.next;
			if(p != null) p = p.next;
			if(q != null) q = q.next;
		}
		if(jinwei >0){
			curr.next = new ListNode(jinwei);
		}
		return dummyHead.next;
	}
	
	
	public static void main(String[] args) {
		S0002 sol = new S0002();
		
//		String s1 = "9342342342342342342342342342342342342342342342342342342342342";
//		String s2 = "999934234234234234234234234234234234234234234234234234234246";
//		String s1 = "9";
//		String s2 = "1999999999";
//		String s1 = "0";
//		String s2 = "73";
		String s1 = "243";
		String s2 = "564";
		
		ListNode node1 = S0002Input.getListNode(s1);
		ListNode node2 = S0002Input.getListNode(s2);
		ListNode result = sol.addTwoNumbers(node1, node2);
		
		while(result != null) {
			System.out.print(result.val + " ");
			result = result.next;
		}
	}
}
