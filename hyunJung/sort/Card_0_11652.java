import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Card_0_11652 {
	
	static int N;
	static long numbers[];
	
	public static void main(String[] args) throws IOException {
		input();
		System.out.println(cnt());
	}
	
	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		numbers = new long[N];
		
		for(int i = 0; i < N; i++) {
			numbers[i] = Long.parseLong(br.readLine());
			System.out.println(Arrays.toString(numbers));
		}
		br.close();
	}

	static long cnt() {
		Arrays.sort(numbers); // 오름차순 정렬
		
		long mode = numbers[0];
		int now = 1, often = 1;
		
		for(int i=1; i<N; i++) {
			if(numbers[i] == numbers[i-1]) {
				now++;
			}else {
				now = 1;
			}
			
			if(now > often) {
				often = now;
				mode = numbers[i];
			}
		}
		
		return mode;
	}
}
