package my.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class SortedMap {
	public static void main(String[] args) {
		
//		1.key升序排序--TreeMap默认按key升序排序
		Map<String, String> map = new TreeMap<String, String>();
        map.put("c", "ccccc");
        map.put("a", "aaaaa");
        map.put("b", "bbbbb");
        map.put("d", "ddddd");
        printMap(map);
        
//		2.key降序排序--TreeMap默认按key升序排序      
        Map<String, String> map2 = new TreeMap<String, String>(new MapKeyComparator());
        map2.put("c", "ccccc");
        map2.put("a", "aaaaa");
        map2.put("b", "bbbbb");
        map2.put("d", "ddddd");
        printMap(map2);
        
//		3.Value升序排序--Collections.sort
        Map<String, String> map3 = new HashMap<String, String>();
        map3.put("c", "ccccc");
        map3.put("a", "aaaaa");
        map3.put("b", "bbbbb");
        map3.put("d", "ddddd");
        List<Map.Entry<String, String>> entryList = new ArrayList<Map.Entry<String, String>>(map3.entrySet());
        Collections.sort(entryList, new MapValueComparator());
        for (Entry<String, String> en : entryList) {
        	String key = en.getKey();
        	String value = en.getValue();
        	System.out.println(key + ":" + value);
		}
        
        
//		4.Value降序排序--修改comparator的两个比较对象的顺序      
        Collections.sort(entryList, new MapValueComparator2());
        for (Entry<String, String> en : entryList) {
        	String key = en.getKey();
        	String value = en.getValue();
        	System.out.println(key + ":" + value);
		}
        
//      5.Value降序排序--按数值排序 
        Map<String, Integer> map4 = new HashMap<String, Integer>();
        map4.put("a", 100);
        map4.put("d", 50);
        map4.put("c", 75);
        map4.put("b", 32);
        map4.put("e", 235);
        List<Map.Entry<String, Integer>> entryList3 = new ArrayList<Map.Entry<String, Integer>>(map4.entrySet());
        Collections.sort(entryList3, new MapValueComparator3());
        for (Entry<String, Integer> en : entryList3) {
        	String key = en.getKey();
        	int value = en.getValue();
        	System.out.println(key + ":" + value);
		}
	}
	
	
	private static void printMap(Map<String, String> map) {
		Set<Entry<String, String>> set = map.entrySet();
        Iterator<Entry<String, String>> it = set.iterator();
        while(it.hasNext()) {
        	Entry<String, String> en = it.next();
        	String key = en.getKey();
        	String value = en.getValue();
        	System.out.println(key + ":" + value);
        }
	}
}


class MapKeyComparator implements Comparator<String>{

	@Override
	public int compare(String o1, String o2) {
		// TODO Auto-generated method stub
		return -o1.compareTo(o2);
	}
}


class MapValueComparator implements Comparator<Map.Entry<String, String>>{

	@Override
	public int compare(Map.Entry<String, String> o1, Map.Entry<String, String> o2) {
		// TODO Auto-generated method stub
		return o1.getValue().compareTo(o2.getValue());
	}
}


class MapValueComparator2 implements Comparator<Map.Entry<String, String>>{

	@Override
	public int compare(Map.Entry<String, String> o1, Map.Entry<String, String> o2) {
		// TODO Auto-generated method stub
		return -o1.getValue().compareTo(o2.getValue());
	}
}

class MapValueComparator3 implements Comparator<Map.Entry<String, Integer>>{

	@Override
	public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
		// TODO Auto-generated method stub
		return -o1.getValue().compareTo(o2.getValue());
	}
}
