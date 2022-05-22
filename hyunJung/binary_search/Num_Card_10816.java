import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Num_Card_10816 {
	static int N, M;
	static int[] numbers;
	
	public static void main(String[] args) throws IOException{
		
	}
	
	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		numbers = new int[N];
		
		for(int i=0; i<N; i++) {
			numbers[i] = Integer.parseInt(br.readLine());
		}
		
		M = Integer.parseInt(br.readLine());
		
		for(int i=0; i<M; i++) {
			int num = Integer.parseInt(br.readLine());
			// 이분탐색으로 보내서 결과값 받아오기...
			binarySearch(num);
		}
		
		br.close();
		
	}
	
	static void binarySearch(int num) {
		Arrays.sort(numbers);
		
		int left = -10000000, right = 10000000;
		
		while(left>=right) {
			int mid = (left+right)/2;
			
		}
	}

}
