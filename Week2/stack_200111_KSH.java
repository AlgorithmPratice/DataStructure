public class stack_200111_KSH {
	static final int MAX=100;
	static int top;
	static int stack[] = new int [MAX];
	static void Init() {
		top=0;
	}
	static boolean IsEmpty() {
		return (top==0);
	}
	static boolean IsFull() {
		return (top==MAX);
	}
	static boolean push(int value) {
		if(IsFull()) {
			return false;
		}
		stack[top]=value;
		top++;
		return true;
	}
	static Integer peek() {
		if(top==0)return null;
		int value = new Integer(stack[top-1]);
		return value;
	}
	static Integer pop() {
		if(top==0) return null;
		top--;
		int value = new Integer(stack[top]);
		return value;
	}
}
