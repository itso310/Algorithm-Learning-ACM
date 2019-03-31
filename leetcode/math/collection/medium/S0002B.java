package leetcode.math.collection.medium;

import java.util.ArrayList;
import java.util.List;

public class S0002B {

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		
		List<Integer> list1 = new ArrayList<Integer>();
		List<Integer> list2 = new ArrayList<Integer>();
		
		list1.add(l1.val);
		while (l1.next != null) {
			l1 = l1.next;
			list1.add(l1.val);
		} 
		list2.add(l2.val);
		while (l2.next != null) {
			l2 = l2.next;
			list2.add(l2.val);
		} 
		int len1 = list1.size();
		int len2 = list2.size();
		List<Integer> list3 = null;
		if(len1 < len2){
			list3 = list1;
			list1 = list2;
			list2 = list3;
		}
		
		len1 = list1.size();
		len2 = list2.size();


		int flag = 0;
		for (int i = 0; i < len2; i++) {
			int tmp = list1.get(i) + list2.get(i);
			if(flag == 1){
				tmp = tmp + 1;
			}
			
			String s = String.valueOf(tmp);
			if(tmp > 9){
				list1.set(i, Integer.parseInt(s.substring(s.length()-1)));
				flag = 1;
			} else {
				list1.set(i, tmp);
				flag = 0;
			}
		}
		
		for (int i = len2; i < len1; i++) {
			if(flag == 1){
				int tmp = list1.get(i) + 1;
				String s = String.valueOf(tmp);
				if(tmp > 9){
					list1.set(i, Integer.parseInt(s.substring(s.length()-1)));
					flag = 1;
				} else {
					list1.set(i, tmp);
					flag = 0;
				}
			}
		}
		
		if(flag == 1){
			list1.add(1) ;
		}
		ListNode[] nodes = new ListNode[list1.size()];
		nodes[nodes.length-1] = new ListNode(list1.get(nodes.length-1));
		
		for (int i = nodes.length-2; i >=0; i--) {
			nodes[i] = new ListNode(list1.get(i));
			nodes[i].next = nodes[i + 1];
		}
		return nodes[0];
	}
	
	
	public static void main(String[] args) {
		S0002B sol = new S0002B();
		
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
