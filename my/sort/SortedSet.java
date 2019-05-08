package my.sort;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * set的自然排序与set的添加顺序无关，例如依次添加d,a,c,b,其自然排序为abcd，因此逆序后为dcba
 * 前三种方式较好
 * @author zhaohuiyang
 *
 */
public class SortedSet {
	public static void main(String[] args) {
//		1.方式1：内部类
	    Set<String> set = new TreeSet<String>(new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				return o1.compareTo(o2);
			}
	    });
	    set.add("d");
	    set.add("b");
	    set.add("c");
	    set.add("a");
//	    printSet(set);
	    System.out.println(set);
	    
//	    2.方式2：lambda
	    Set<String> set2 = new TreeSet<String>((o1,o2) -> o2.compareTo(o1));
	    set2.addAll(set);
	    System.out.println(set2);
	    
//	    3.方式3:Comparator
	    Set<String> set3 = new TreeSet<String>(Comparator.reverseOrder());
	    set3.addAll(set);
	    System.out.println(set3);
	    
//	    4.方式4:stream().sorted
	    Set<String> set4 = new HashSet<String>();
	    set4.add("d");
	    set4.add("c");
	    set4.add("b");
	    set4.add("a");
	    System.out.println(set4);
	    set4.stream().sorted(Comparator.reverseOrder()).forEach(e -> System.out.print(e + " "));
//	    Set<String> set5 = set4.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toSet());
//	    System.out.println(set5);
	}
	
	public static void printSet(Set set){
		Iterator it = set.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}
}
