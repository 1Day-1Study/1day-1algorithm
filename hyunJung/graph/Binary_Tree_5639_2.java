import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Binary_Tree_5639_2 {
	
	static int[] b_tree = new int[10001];
	
	static void postOrder(int n, int end) {
		if(n > end) return;
		
		int mid = n + 1;
		
		while(mid <= end && b_tree[mid] < b_tree[n]) {
			mid ++;
		}
		
		postOrder(n + 1, mid - 1); 
		postOrder(mid, end);
		
		System.out.println(b_tree[n]);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int idx = 0;
		
		String node;
		
		while(true) {
			node = br.readLine();
			
			if(node == null || node.equals("")) break;
			
			b_tree[idx++] = Integer.parseInt(node);
		}
		
		postOrder(0, idx - 1);
	}
}
