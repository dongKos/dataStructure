package dataStructure.run;

import dataStructure.list.linkedList.impl.LinkedList;

public class Main {

	public static void main(String [] args) throws Exception {
		LinkedList list = new LinkedList();
		
		
		list.addLast(10);
		list.addLast(20);
		list.addLast(30);
//		
//		list.add(5, 15);
//		System.out.println(list.toString());
//		System.out.println(list.remove(6));
//		System.out.println(list.removeLast());
//		
//		System.out.println(list.size());
//		System.out.println(list.get(3));
//		
//		
//		System.out.println(list.toString());
//		System.out.println(list.indexOf(1));
		LinkedList.ListIterator i = list.listIterator();
		
		System.out.println(i.next());
		i.remove();
		System.out.println(i.next());
//		i.add(5);
//		i.next();
//		i.add(15);
//		i.next();
//		
		System.out.println(list);
	}
}
