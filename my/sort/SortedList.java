package my.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Collections.sort(list),按list所存放对象的comparable方法进行比较排序
 * Integer内置的有comparable方法，所以不需要额外定义，自定义对象User需要实现Comparable接口的comparable方法
 * Collections.sort(list,comparator),自定义比较类实现Comparator接口的compareTo方法，或内部类实现compareTo方法
 * Collection.stream().sorted
 * 各种sort方法均调用被排序对象的compare方法或compareTo方法
 * @author zhaohuiyang
 *
 */
public class SortedList {
	public static void main(String[] args) {
//		1.简单list排序升序
		List<Integer> list = new ArrayList<Integer>();
		list.add(new Integer(5));
		list.add(new Integer(13));
		list.add(new Integer(4));
		list.add(new Integer(9));
		Collections.sort(list);
		System.out.println("example 1:" + list.toString());
		
//		2.复杂list排序升序-排序对象实现Comparable接口
		List<User> list2 = new ArrayList<User>();
		list2.add(new User("张三", 5));
		list2.add(new User("李四", 30));
		list2.add(new User("王五", 19));
		list2.add(new User("陈十七", 17)); 
		Collections.sort(list2); // 按年龄排序
		System.out.println("example 2:" + list2.toString());
		
//		3.复杂list排序降序--实现Comparator接口的类
		Collections.sort(list2, new UserComparator()); // 按年龄排序
		System.out.println("example 3:" + list2.toString());
		
		
//		4.复杂list排序降序--实现Comparator接口的匿名内部类
		Collections.sort(list2, new Comparator<User>() {
			@Override
			public int compare(User o1, User o2) {
				// TODO Auto-generated method stub
				return o2.getAge() - o1.getAge();
			}
		}); // 按年龄排序
		System.out.println("example 4:" + list2.toString());
		
		
//		5.复杂list排序升序--stream().sorted()
        List<User> slist = list2.stream().sorted().collect(Collectors.toList());
        System.out.println("example 5:" + slist);
//        slist.forEach(e -> System.out.println("Name: "+e.getName()+", Age:"+e.getAge()));
		
//		6.复杂list排序降序--stream().sorted()
        slist = list2.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        System.out.println("example 6:" + slist);
        
//		7.复杂list排序升序--stream().sorted()
        slist = list2.stream().sorted(Comparator.comparing(User::getName)).collect(Collectors.toList());
        System.out.println("example 7:" + slist);
		
	}
}


class User implements Comparable<User> {
	private String name; // 姓名
	private int age; // 年龄
	
	
	public User(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}

	
	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + "]";
	}

	@Override
	public int compareTo(User user) {
		// TODO Auto-generated method stub
		return this.age - user.age;
	}
}


class UserComparator implements Comparator<User>{

	@Override
	public int compare(User o1, User o2) {
		// TODO Auto-generated method stub
		return o2.getAge() - o1.getAge();
	}
	
}

