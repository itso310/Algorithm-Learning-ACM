package leetcode.math.collection.medium;

import java.util.ArrayList;
import java.util.List;

import my.utils.CollectionOutput;

public class S0002A {

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		
		List<String> list1 = new ArrayList<String>();
		List<String> list2 = new ArrayList<String>();
		list1.add(l1.val + "");
		while (l1.next != null) {
			l1 = l1.next;
			list1.add(l1.val + "");
		} 
		list2.add(l2.val + "");
		while (l2.next != null) {
			l2 = l2.next;
			list2.add(l2.val + "");
		} 

		int[] arr1 = new int[list1.size()];
		int[] arr2 = new int[list2.size()];
		for (int i = 0; i < arr1.length; i++) {
			arr1[i] = Integer.parseInt(list1.get(i));
		}
		for (int i = 0; i < arr2.length; i++) {
			arr2[i] = Integer.parseInt(list2.get(i));
		}
		int len1 = arr1.length;
		int len2 = arr2.length;
		int max = Math.max(len1, len2);
		int[] arr3 = new int[max+1];
		if(len1 >= len2){
			for (int i = 0; i < len1; i++) {
				arr3[i] = arr1[i];
			}
		}else{
			for (int i = 0; i < len2; i++) {
				arr3[i] = arr2[i];
			}
		}

		int flag = 0;
		if(len1 >= len2){
			for (int i = 0; i < len2; i++) {
				int tmp = 0;
				if(flag == 0){
					tmp = arr3[i] + arr2[i];
				}else{
					tmp = arr3[i] + arr2[i] + 1;
				}
				
				String s = String.valueOf(tmp);
				if(tmp > 9){
					arr3[i] = Integer.parseInt(s.substring(s.length()-1));
					flag = 1;
				} else {
					flag = 0;
					arr3[i] = tmp;
				}
			}
			
			for (int i = len2; i < arr3.length; i++) {
				if(flag == 1){
					int tmp = arr3[i] + 1;
					String s = String.valueOf(tmp);
					if(tmp > 9){
						arr3[i] = Integer.parseInt(s.substring(s.length()-1));
						flag = 1;
					} else {
						arr3[i] = tmp;
						flag = 0;
					}
				}
			}
//			CollectionOutput.arrToString(arr3);
		}else{
			for (int i = 0; i < len1; i++) {
				int tmp = 0;
				if(flag == 0){
					tmp = arr3[i] + arr1[i];
				}else{
					tmp = arr3[i] + arr1[i] + 1;
				}
				
				String s = String.valueOf(tmp);
				if(tmp > 9){
					arr3[i] = Integer.parseInt(s.substring(s.length()-1));
					flag = 1;
				} else {
					arr3[i] = tmp;
					flag = 0;
				}
			}
			for (int i = len1; i < arr3.length; i++) {
				if(flag == 1){
					int tmp = arr3[i] + 1;
					String s = String.valueOf(tmp);
					if(tmp > 9){
						arr3[i] = Integer.parseInt(s.substring(s.length()-1));
						flag = 1;
					} else {
						arr3[i] = tmp;
					}
				}
			}
		}
		
		int len = arr3.length;
		if(arr3[arr3.length-1] == 0){
			len = len -1 ;
		}
//		System.out.println(len);
//		CollectionOutput.arrToString(arr3);
		ListNode[] nodes = new ListNode[len];
		for (int i = 0; i < nodes.length; i++) {
			nodes[i] = new ListNode(arr3[i]);
		}
		for (int i = 0; i < nodes.length - 1; i++) {
			nodes[i].next = nodes[i + 1];
		}
		return nodes[0];
	}
	
	
	public static void main(String[] args) {
		S0002A sol = new S0002A();
		
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
