package dataStructure.run;


import dataStructure.stack.impl.Stack;

public class StackRunner {

	public static void main(String[] args) throws Exception {
		Stack<Integer> st = new Stack<Integer>(6);
//		System.out.println(st.peek());
//		st.push(1);
//		System.out.println(st.peek());
//		st.push(2);
//		System.out.println(st.peek());
//		st.push(3);
//		System.out.println(st.peek());
//		System.out.println(st.peek());
		
//		st.push(1);
//		System.out.println(st.pop());
//		st.push(2);
//		System.out.println(st.empty());
//		System.out.println(st.pop());
//		System.out.println(st.peek());
//		System.out.println(st.empty());
		
		st.push(1);
		st.push(2);
		st.push(3);
		st.push(4);
		st.push(5);
		st.push(6);
		
		while(!st.empty()) {
			System.out.println(st.pop());
		}
		
	}

}
