package doyoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Guitar_2343 {
	
	static int N, M;
	static int[] lesson;
	static int left, right;

	public static void main(String[] args) throws IOException{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		//ex) {1,2,3,4,5,6,7,8,9}
		//강의 수 N , 블루레이 갯수 M , 각 강의의 길이 배열 lesson 초기화 
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		lesson = new int[N];
		
		st = new StringTokenizer(br.readLine()," ");
		int sum = 0;
		for (int i = 0; i < N; i++) {
			lesson[i] = Integer.parseInt(st.nextToken());
			sum += lesson[i]; 
			left = Math.max(left, lesson[i]); //9
		}
		right = sum;  //45
		
		System.out.println(binSearch(left,right));

	}
	public static long binSearch(long left, long right) {
		while(left <= right) {
			long sum = 0;
			long mid = (left+right)/2;
			int count = 1;  
			for (int i = 0; i < N; i++) {
				sum += lesson[i];
				if(sum > mid) {
					sum = lesson[i];
					count ++;
				}
			}
			//필요한 블루레이 갯수가 M보다 작거나 같으면 
			if(count <= M) {
				right = mid - 1;
			}
			//총 필요한 블루레이 개수가 M보다 크다면 
			else {
				left = mid +1;
			}
		}
		return left;
		
		
		
	}

}
