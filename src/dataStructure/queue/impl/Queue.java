package dataStructure.queue.impl;

public class Queue<E> {

//	offer, pull, pick, isEmpty
	
	private int p;
	private int idx;
	private int size;
	private Object[] data;
	
	public Queue(int size) {
		this.size = size;
		data = new Object[size];
	}
	
	public boolean offer(E input) {
		if(idx != size) {
			data[idx++] = input;
			return true;
		}
		else return false;
	}
	
	public Object poll() {
		if(p == idx) {
			return null;
		}
		size--;
		return data[p++];
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
}
