package my.utils;

import java.util.Arrays;
import java.util.List;

public class CollectionOutput {
	public static void arrToString(int[] arr){
		List list = Arrays.asList(arr);
		listToString(list);
	}
	
	public static void listToString(List list){
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + ",");
		}
	}
	
}
