package leetcode.math.collection.medium;

public class S0002Input {
	public static ListNode getListNode(String input){
		int len = input.length();
		ListNode[] nodes = new ListNode[len];
		for (int i = 0; i < nodes.length; i++) {
			int v = Integer.parseInt(input.charAt(i) + "");
			nodes[i] = new ListNode(v);
		}
		for (int i = 0; i < nodes.length - 1; i++) {
			nodes[i].next = nodes[i + 1];
		}
		return nodes[0];
	}
}
