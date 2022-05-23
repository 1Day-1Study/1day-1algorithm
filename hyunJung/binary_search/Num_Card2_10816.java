import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Num_Card2_10816 {
	static int N, M;
	static int[] numbers;
	
	public static void main(String[] args) throws IOException{
		input();
	}
	
	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		numbers = new int[N];
		
		st = new StringTokenizer(br.readLine(), " ");
	
		for(int i=0; i<N; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(numbers);
		
		M = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine(), " ");
		
		for(int i=0; i<M; i++) {
			int num = Integer.parseInt(st.nextToken());
			// 이분탐색으로 보내서 결과값 받아오기...
			sb.append(upper_bound(num) - lower_bound(num)).append(' ');
		}
		br.close();
		System.out.println(sb);
	}
	
	// 하한선 찾기
	static int lower_bound(int target) {
		int left = 0;
		int right = numbers.length;
		
		while(left < right) {
			int mid = (left + right) / 2;
			
			if(target <= numbers[mid]) {
				right = mid;
			}else {
				left = mid + 1;
			}
		}
		
		return left;
	}
	// 상한선 찾기 
	static int upper_bound(int target) {
		int left = 0;
		int right = numbers.length;
		
		while(left < right) {
			int mid = (left + right) / 2;
			if(target < numbers[mid]) {
				right = mid;
			}else {
				left = mid + 1;
			}
		}
		return left;
	}
	
}
