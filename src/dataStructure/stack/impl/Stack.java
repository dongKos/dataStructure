package dataStructure.stack.impl;

public class Stack<E> {

//	empty, peek, pop, push, search
	
	private int top;
	private int size;
	private Object[] data;
	
	public Stack(int size) {
		top = 0;
		this.size = size;
		data = new Object[size];
	}
	
	public void push(E input) throws Exception {
		if(top < size) {
			data[top++] = input;
		} else {
			throw new Exception("Stack Overflow!");
		}
	}
	
	public Object pop() throws Exception {
		if(top == 0) throw new Exception("Stack Underflow!");
		return data[--top];
	}
	
	public Object peek() {
		if(top == 0) return null;
		return data[top-1];
	}
	
	public boolean empty() {
		return top == 0;
	}
	
	public int search(E input) {
		if(top == 0) return -1;
		
		for(int i = 0; i < data.length; i++) {
			if(data[i].equals(input)) return i+1;
		}
		
		return -1;
		
	}
}
