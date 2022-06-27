import java.util.NoSuchElementException;
import java.util.LinkedList;
import java.util.Iterator;
import java.util.Stack;

class Queue<T> { // 객체 생성 시, 데이터 타입 명시하기
	class Node<T> { // 같은 타입으로 데이터를 받는 노드 생성 
		private T data;
		private Node<T> next; // 다음 노드
		
		public Node(T data) { // 생성자에서 생성 할 노드의 데이터 타입을 받음
			this.data = data;
		}
	}
	
	// 큐는 FIFO 앞과 뒤의 주소를 알고 있어야함
	private Node<T> first;
	private Node<T> last;
	
	// 메소드 구현 : add, remove, peek, isEmpty
	public void add(T item) {
				// 추가 할 T 타입의 아이템을 받아옴
		// Node 생성
		Node<T> t = new Node<T>(item);
		
		if(last != null) {
			last.next = t; // 마지막 노드가 있는 경우, 마지막 노드에 새로 생성한 노드를 붙임 
		}
		last = t; // t가 마지막 노드가 됨 
		
		if(first == null) { // 큐가 비어져 있다면, 처음값 = 마지막값
			first = last; 
		}
	}
	
	public T remove() {
		if(first == null) { // 큐가 비어져있음 
			throw new NoSuchElementException();
		}
		
		// 맨 앞 데이터를 지워주기 전에, 다음 데이터를 첫번째로 바꾸기 위해 데이터 백업 
		T data = first.data;
		first = first.next;
		
		if(first == null) {
			last = null;
		}
		return data;
	}
	
	public T peek() {
		if(first == null) {
			throw new NoSuchElementException();
		}
		
		return first.data;
	}
	
	public boolean isEmpty() {
		return first == null;
	}
}

class Graph { // graph 클래스 생
	class Node { // 노드 객체를 위한 클래스 생성
		int data; // int로 테스트
		LinkedList<Node> adjacent; // 인첩한 노드, linked list로 표현
		boolean marked; // 방문표시
		
		Node (int data) {
			// 노드 생성자를 통해 데이터 저장, false 초기화, linked list 생성 - 다음 노드 받을 준비 
			this.data = data;
			this.marked = false;
			adjacent = new LinkedList<Node>();
		}
	}
	
	// 그래프 생성 - 노드들을 저장 할 배열 생성
	Node[] nodes;
	Graph(int size) { // 간단한 구현을 위해 노드 사이즈 고정 
		nodes = new Node[size];
		for(int i=0; i<size; i++) {
			nodes[i] = new Node(i);
		}
	}
	// 두 노드의 관계를 찾아가는 함수
	void addEdge(int i1, int i2) {
		Node n1 = nodes[i1];
		Node n2 = nodes[i2];
		
		// 인접한 노드 저장 
		if(!n1.adjacent.contains(n2)) {
			n1.adjacent.add(n2);
		}
		if(!n2.adjacent.contains(n1)) {
			n2.adjacent.add(n1);
		}
	}
	// dfs 호출, 그냥 호출하면 0번째 불러옴 
	void dfs() {
		dfs(0);
	}
	void dfs(int index) {
		Node root = nodes[index]; // root node가 해당 인덱스의 노드가 됨
		Queue<Node> queue = new Queue<Node>();
		queue.add(root); // add = enqueue
		root.marked = true;
		// 큐가 비어질 때까지 반복작업 
		while(!queue.isEmpty()) {
			Node r = queue.remove(); // remove = dequeue
			// 큐에서 꺼낸 자식노드들을 큐에 추가 - 인접한 큐 찾기
			for(Node n : r.adjacent) {
				if(n.marked == false) { // 추가된 적 없는 경우만 큐에 추가
					n.marked = true; // 방문표시 
					queue.add(n);
				}
			}
			visit(r); // 출력 
		}
	}
	// 재귀호출을 이용한 dfs : 링크드 리스트가 노드의 주소를 가지고 있어서 노드를 받는 형태
	void dfsR(Node r) {
		if(r == null) return;
		r.marked = true;
		visit(r); // 출력 
		
		// 호출이 되지 않은 자식들을 호출 
		for(Node n : r.adjacent) {
			if(n.marked == false) {
				dfsR(n);
			}
		}
	}
	void dfsR(int index) { // 다양한 인덱스의 노드를 호출 
		Node r = nodes[index];
		dfsR(r);
	}
	void dfsR() {
		dfsR(0);
	}
	
	void visit(Node n) {
		System.out.print(n.data+" ");
	}
}
/*
 * 	  0
 *   /
 *  1 -- 3     7
 *  |  / | \  /
 *  | /  |  5
 *  2 -- 4    \
 *  			6 - 8
 * 
 *  - - - - - - - - result
 *  dfs(0)
 *  0 1 3 5 7 6 8 4 2
 *  bfs(0)
 *  0 1 2 3 4 5 6 7 8
 *  dfsr(0)
 *  0 1 2 4 3 5 6 8 7
 *  - - - 
 *  dfs(3)
 *  3 5 7 6 8 4 2 1 0
 *  bfs(3)
 *  3 1 2 4 5 0 6 7 8
 *  dfsR(3)
 *  3 1 0 2 4 5 6 8 7
 */
public class Graph_Test {

	public static void main(String[] args) {
		Graph g = new Graph(9); // 9개 노드가 있는 그래프 생성
		// 관계명시
		g.addEdge(0, 1);
		g.addEdge(1, 2);
		g.addEdge(1, 3);
		g.addEdge(2, 4);
		g.addEdge(2, 3);
		g.addEdge(3, 4);
		g.addEdge(3, 5);
		g.addEdge(5, 6);
		g.addEdge(5, 7);
		g.addEdge(6, 8);
		
		// 결과보기
		g.dfs(3); // 이상하게 출력됨...
	}
}
