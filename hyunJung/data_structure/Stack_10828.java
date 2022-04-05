import java.util.Scanner;

public class Stack_10828 {
	
	static int[] stack_num; // variable for save input values
	static int size = 0; // for the number of variables
	
	public static void main(String[] args) throws Exception {
		System.out.println("start...");
		
		Scanner input = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int N = input.nextInt();
		
		stack_num = new int[N];
		
		for(int i=0; i<N; i++) {
			String comm = input.next();
			
			switch(comm) {
				case "push" :
					push(input.nextInt());
					break;
				case "pop" :
					sb.append(pop()).append("\n");
					break;
				case "size" :
					sb.append(size()).append("\n");
					break;
				case "empty" :
					sb.append(empty()).append("\n");
					break;
				case "top" :
					sb.append(top()).append("\n");
					break;
			}
		}
		
		System.out.println("---------------- result ");
		System.out.println(sb);
		
		input.close();
	}
	
	public static void push(int element) {
		stack_num[size] = element;
		size++; 
	}
	
	public static int pop() {
		if(size == 0) { // no data in Stack
			return -1;
		} else { // take the last item in stack
			int last_item = stack_num[size-1]; // index starts from 0
			stack_num[size-1] = 0; // reset the last location
			size--;
			return last_item;
		}
	}
	
	public static int size() {
		return size;
	}
	
	public static int empty() {
		if(size == 0) { // stack is empty
			return 1;
		} else {
			return 0;
		}
	}
	
	public static int top() {
		if(size == 0) {
			return -1;
		}else {
			return stack_num[size-1];
		}
	}
}
