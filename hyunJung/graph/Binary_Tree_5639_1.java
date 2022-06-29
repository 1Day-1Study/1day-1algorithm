import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * No. 5639
 * 
 * pre-order traverse > post-order traverse 
 * pre : root is the first node to be searched
 * 
 * Binary Search Tree :
 * x < root : left
 * x > root : right
 * 
 * then, post-order
 */

public class Binary_Tree_5639_1 {
	
	static class Node {
		int number; // the size of node
		Node left, right;
		
		Node(int number) {
			this.number = number;
		}
		Node(int number, Node left, Node right) {
			this.number = number;
			this.left = left;
			this.right = right;
		}
		
		// method to restore Tree 
		void restore(int n) {
			if(n < this.number) { // left
				if(this.left == null) this.left = new Node(n);
				else this.left.restore(n);
			}else { // right
				if(this.right == null) this.right = new Node(n);
				else this.right.restore(n);
				
			}
		}
	}

	// method to post-order
	static void postOrder(Node node) {
		if( node == null ) return;
		
		postOrder(node.left);
		postOrder(node.right);
		
		System.out.println(node.number);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Node root = new Node(Integer.parseInt(br.readLine()));
		
		String new_node;
		while(true) {
			new_node = br.readLine();
			
			if(new_node == null || new_node.equals("")) break;
			
			root.restore(Integer.parseInt(new_node));
		}
		
		postOrder(root);
		
	}
}
