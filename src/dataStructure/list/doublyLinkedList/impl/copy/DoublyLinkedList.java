package dataStructure.list.doublyLinkedList.impl.copy;

public class DoublyLinkedList {
	
	private Node head;
	private Node tail;
	private int size;
	

	class Node {
	
		private Object data;
		private Node next;
		private Node prev;
		
		public Node(Object input) {
			this.data = input;
			this.next = null;
			this.prev = null;
		}
		
		public String toString() {
			return String.valueOf(this.data);
		}
	}

	public void addFirst(Object input) {
		Node newNode = new Node(input);
		newNode.next = head;
		
		if(head != null) {
			head.prev = newNode;
		}
		
		head = newNode;
		if(head.next == null) {
			tail = head;
		}
		
		size++;
	}


	public void addLast(Object input) {
		Node newNode = new Node(input);
		if(size == 0) {
			addFirst(newNode);
		} else {
			tail.next = newNode;
			newNode.prev = tail;
			tail = newNode;
			
			size++;
		}
	}
	
	private Node node(int idx) {
		Node x = null;
		
		if(idx < size / 2) {
			x = head;
			for(int i = 0; i < idx; i++) {
				x = x.next;
			}
			
		} else {
			x = tail;
			for(int i = size-1; i > idx; i--) {
				x = x.prev;
			}
		}
	
		
		return x;
	}
	
	public void add(int idx, Object input) {
		
		if(idx == 0) {
			addFirst(input);
		} else {
			Node newNode = new Node(input);
			Node targetNode = node(idx);
			Node prvNode = targetNode.prev;
			
			prvNode.next = newNode;
			newNode.next = targetNode;
			
			newNode.prev = prvNode;
			if(targetNode != null) {
				targetNode.prev = newNode;
			}
			
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
		if(head != null) {
			head.prev = null;
		}
		size--;
		
		return returnData;
	}
	
	public Object remove(int idx) {
		if(idx == 0) {
			return removeFirst();
		} else {
			//내 코드 
//			Node targetNode = node(idx);
//			Node prvNode = targetNode.prev;
//			
//			
//			Object rmvData = targetNode.data;
//			if(targetNode == tail) {
//				tail = prvNode;
//				prvNode.next = null;
//			} else {
//				Node nxtNode = targetNode.next;
//				nxtNode.prev = prvNode;
//				prvNode.next = nxtNode;
//			}
//			targetNode = null;
//			
//			size--;
//			return rmvData;
			
			//생활코딩 
			Node temp = node(idx-1);
			Node todoDeleted = temp.next;
			temp.next = temp.next.next;
			temp.next.prev = temp;
			Object rtnData = todoDeleted.data;
			if(todoDeleted == tail) {
				tail = temp;
			}
			todoDeleted = null;
			size--;
			return rtnData;
			
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
			nextIndex = 0;
		}
		
		public Object next() {
			lastReturned = next;
			next = next.next;
			nextIndex++;
			return lastReturned.data; 
		}
		
		public Object prev() {
			if(next == null) {
				lastReturned = next = tail;
			} else {
				lastReturned = next = next.prev;
			}
			
			nextIndex--;
			return lastReturned.data;
		}
		
		public boolean hasNext() {
			return nextIndex < size();
		}
		
		public boolean hasPrev() {
			//내코드 
//			if(nextIndex == 0) {
//				return false;
//			}
//			return true;
			//생활코딩 
			return nextIndex > 0;
		}
		
		public void add(Object input) {
			Node newNode = new Node(input);
			
			
			if(lastReturned == null) {
				head = newNode;
				newNode.next = next;
			} else {
				lastReturned.next = newNode;
				newNode.prev = lastReturned;
				if(next != null) {
					newNode.next = next;
					next.prev = newNode;
				} else {
					tail = newNode;
				}
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
				DoublyLinkedList.this.remove(nextIndex -1);
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
