public class Queue {
	private int front;
	private int rear;
	private int queueSize;
	private char queueArr[];
	
	public Queue(int queueSize) {
		front = -1;
		rear = -1;
		this.queueSize = queueSize;
		queueArr = new char[this.queueSize];
	}
	
	public boolean isEmpty() {
		if(front == rear) {
			front = -1;
			rear = -1;
		}
		
		return (front == rear);
	}
	
	public boolean isFull() {
		return (rear == this.queueSize-1);
	}
	
	public void push(char item) {
		if(isFull()) {
			System.out.println("Queue is full");
		}else {
			queueArr[++rear] = item;
			System.out.println("Inserted Item : " + item);
		}
	}

	public char pop() {
		if(isEmpty()) {
			System.out.println("Deleting fail! Queue is empty");
			return 0;
		} else {
			System.out.println("Deleted Item : " + queueArr[front+1]);
			
			front = (front + 1) % this.queueSize;
			
			return queueArr[front];
		}
	}
	
	public char peek() {
		if(isEmpty()) {
			System.out.println("Peeking fail! Queue is empty!");
			return 0;
		}else {
			System.out.println("Peeked Item : " + queueArr[front+1]);
			return queueArr[front+1];
		}
	}
	
	public void clear() {
		if(isEmpty()) {
			System.out.println("Queue is already empty!");
		}else {
			front = -1;
			rear = -1;
			queueArr = new char[this.queueSize];
			System.out.println("Queue is clear");
		}
	}
	
	public void printQueue() {
		if(isEmpty()) {
			System.out.println("Queue is empty!");
		} else {
			System.out.println("Queue elements : ");
			for(int i = front+1; i <= rear; i++) {
				System.out.println(queueArr[i] + " ");
			}
			System.out.println();
		}
	}
}
