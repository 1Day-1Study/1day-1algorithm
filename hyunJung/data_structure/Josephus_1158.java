package dataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Josephus_1158 {
	
	static Queue<Integer> q = new LinkedList<>();
	static StringBuilder result = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = br.readLine().split(" ");
		
		int N = Integer.parseInt(input[0]);
		int K = Integer.parseInt(input[1]);
		
		q = newQ(N);
		
		/*
		result.append('<');
		
		while(q.size()>0) {
			for(int i=0; i< K-1; i++ ) {
				q.offer(q.poll());
			}
			
			if(q.size() == 1 ) {
				result.append(q.poll());
			} else {
				result.append(q.poll()).append(", ");
			}
		}
		
		result.append('>');
		
		System.out.println(result);
		*/
		System.out.println("- - - - - - - - -");
		
		result = cal(K, q);
		System.out.println("???? "+result);
		
		
	}
	
	// methods
	static Queue<Integer> newQ(int N) {
		for(int i=1; i<=N; i++) {
			q.add(i);
		}
		return q;
	}
	
	static StringBuilder cal(int K, Queue<Integer> q) {
		
		result.append('<');
		
		while(q.size()>0) {
			for(int i=0; i< K-1; i++ ) {
				q.offer(q.poll());
			}
			
			if(q.size() == 1 ) {
				result.append(q.poll());
			} else {
				result.append(q.poll()).append(", ");
			}
		}
		
		result.append('>');
		
		return result;
	}
}
