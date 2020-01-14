package datastructure;

public class Queue_200114_KSH {
	static final int MAX_N=100;
	static int front;
	static int rear;
	static int queue[] = new int[MAX_N];
	
	static boolean isEmpty() {
		return (front==rear);
	}
	static boolean isFull() {
		if((rear+1)%MAX_N==front) return true;
		else return false;
	}
	static Integer peek() {
		if(isEmpty()) return null;
		Integer value = new Integer(queue[front]);
		return value;
	}
	static boolean enqueue(int value) {
		if(isFull()) return false;
		queue[rear]=value;
		rear++;
		if(rear==MAX_N) rear=0;
		return true;
	}
	static Integer dequeue() {
		if(isEmpty()) return null;
		Integer value = new Integer(queue[front]);
		front++;
		if(front==MAX_N) front=0;
		return value;
	}
}
