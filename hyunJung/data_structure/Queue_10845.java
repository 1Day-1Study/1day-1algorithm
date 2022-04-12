package dataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Node {
	private int val = 0; 
	private Node next = null;
	
	public Node(int val) {
		this.val = val;
	}
	public void setVal(int val) {
		this.val = val;
	}
	public void setNext(Node next) {
		this.next = next;
	}
	public int getVal() {
		return this.val;
	}
	public Node getNext() {
		return this.next;
	}
}

class Queue {
	private Node head = null;
	
	public Queue() {
		this.head = null;
	}
	//Queue methods
	public void add(int val) {
		if(this.head == null) {
			this.head = new Node(val); // first node ---> reset head   
		} else {
			Node node = new Node(val); // new node 
			Node FirstNode = this.head; 
			while(this.head.getNext()!=null) {
				this.head = this.head.getNext();
			}
			this.head.setNext(node); // set last node 
			this.head = FirstNode;
		}
	}
	public int pop() {
		if(this.head == null ) {
			return -1;
		} else {
			int first = this.head.getVal();
			this.head = this.head.getNext(); // set next val in head
			return first;
		}
	}
	public int size() {
		int cnt = 0;
		if(this.head == null) {
			return cnt;
		} else {
			Node firstNode = this.head;
			while(this.head.getNext() != null) {
				this.head = this.head.getNext();
				cnt++;
			}
			this.head = firstNode;
			return cnt+1;
		}
	}
	public int empty() {
		if(this.head == null) return 1;
		return 0;
	}
	public int front() {
		if(this.head != null) {
			return this.head.getVal();
		} else {
			return -1;
		}
	}
	public int back(int lastN) {
		if(empty() == 1) {
			return -1;
		}else {
			return lastN;
		}
	}
	
}
public class Queue_10845 {

	public static void main(String[] args) throws IOException {
		//call object 
		Queue qu = new Queue();
		//io
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int lastN = 0;
		
		while(N-- > 0) {
			String[] cmd = br.readLine().split(" ");
			
			switch(cmd[0]) {
				case "push":
					qu.add(Integer.parseInt(cmd[1]));
					lastN = Integer.parseInt(cmd[1]);
					break;
				case "pop":
					System.out.println(qu.pop());
					break;
				case "size":
					System.out.println(qu.size());
					break;
				case "empty":
					System.out.println(qu.empty());
					break;
				case "front":
					System.out.println(qu.front());
					break;
				case "back":
					System.out.println("last num? "+lastN);
					System.out.println(qu.back(lastN));
					break;
					
			}
			
		}
	}
}
