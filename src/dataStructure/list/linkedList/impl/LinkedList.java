package dataStructure.list.linkedList.impl;

public class LinkedList {
	
	private Node head;
	private Node tail;
	private int size;
	
	public Node getHead() {
		return head;
	}

	public void setHead(Node head) {
		this.head = head;
	}

	public Node getTail() {
		return tail;
	}

	public void setTail(Node tail) {
		this.tail = tail;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	class Node {
	
		private Object data;
		private Node next;
		
		public Node(Object input) {
			this.data = input;
			this.next = null;
		}
		
		public String toString() {
			return String.valueOf(this.data);
		}
	}

	public void addFirst(Object input) {
		Node newNode = new Node(input);
		newNode.next = head;
		head = newNode;
		
		if(head.next == null) {
			tail = head;
		}
		
		size++;
	}


	public void addLast(Object input) {
		Node newNode = new Node(input);
		
		//내 코드 
//		if(tail != null) {
//			tail.next = newNode;
//		}
//		tail = newNode;
//		if(head == null) {
//			head = newNode;
//		}
//		size++;
		
		//생활코딩 코드 
		if(size == 0) {
			addFirst(newNode);
		} else {
			tail.next = newNode;
			tail = newNode;
			size++;
		}
	}
	
	Node node(int idx) {
		Node x = head;
	
		for(int i = 0; i < idx; i++) {
			x = x.next;
		}
		
		return x;
	}
	
	public void add(int idx, Object input) {
		
		if(idx == 0) {
			addFirst(input);
		} else {
			Node newNode = new Node(input);
			Node prvNode = node(idx-1);
			Node nxtNode = prvNode.next;
			
			newNode.next = nxtNode;
			prvNode.next = newNode;
			if(newNode.next == null) {
				tail = newNode;
			}
			size++;
		}
	}
	
	public Object removeFirst() {
		if(size == 0) return null;
		
		Node removedNode = head;
		Object returnData = removedNode.data;
		head = head.next;
		removedNode = null;
		size--;
		
		return returnData;
	}
	
	public Object remove(int idx) {
		if(idx == 0) {
			return removeFirst();
		} else {
			Node rmvNode = node(idx);
			Node prvNode = node(idx -1);
			prvNode.next = rmvNode.next;
			Object rmvData = rmvNode.data;
			if(rmvNode == tail) {
				tail = prvNode;
			}
			rmvNode = null;
			
			size--;
			return rmvData;
		}
	}
	
	public Object removeLast() {
		return remove(size - 1);
	}
	
	public int size() {
		return this.size;
	}
	
	public Object get(int idx) {
		return this.node(idx).data;
	}
	
	public int indexOf(Object input) {
		
		Node n = head;
		int result = -1;
		int idx = 0;
		while(n.next != null) {
			
			if(input.equals(n.data)) {
				result = idx; 
			}
			n = n.next;
			idx++;
		}
		
		return result;
	}
	
	public String toString() {
		if(head == null) {
			return "[]";
		}
		
		String result = "[";
		Node n = this.head;
		
		while(n.next != null) {
			result += n.data + ", ";
			n = n.next;
		}
		
		result += n.data;
		
		return result + "]";
	}
	
	public ListIterator listIterator() {
		return new ListIterator();
	}
	
	public class ListIterator {
	
		private Node next;
		private Node lastReturned; 
		private int nextIndex;
		
		public ListIterator() {
			next = head;
		}
		
		public Object next() {
			lastReturned = next;
			next = next.next;
			nextIndex++;
			return lastReturned.data; 
		}
		
		public boolean hasNext() {
			return nextIndex < size();
		}
		
		public void add(Object input) {
			Node newNode = new Node(input);
			if(next != head) {
				lastReturned.next = newNode;
			} else {
				head = newNode;
			}
			newNode.next = next;
			lastReturned = newNode;
			
			size++;
			nextIndex++;
		}
		
		public void remove() throws Exception {
			if(lastReturned == null) {
				throw new Exception("No selected Node");
			} else {
				LinkedList.this.remove(nextIndex -1);
				nextIndex--;
				
//				if(head == lastReturned) {
//					head = next;
//					lastReturned = null;
//				} else {
//					Node prevNode = node(nextIndex-2);
//					prevNode.next = next;
//					lastReturned = prevNode;
//				}
//				
//				size--;
//				nextIndex--;
			}
		}
	}

}
