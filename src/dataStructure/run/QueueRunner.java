package dataStructure.run;

import dataStructure.queue.impl.Queue;

public class QueueRunner {

	public static void main(String[] args) throws Exception {
		Queue<Integer> q = new Queue<Integer>(6);
		
		q.offer(1);
		q.offer(2);
		q.offer(3);
		q.offer(4);
		q.offer(5);
		q.offer(6);
		
		while(!q.isEmpty()) {
			System.out.println(q.poll());
		}
	}

}
