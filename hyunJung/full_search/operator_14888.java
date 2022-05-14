import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class operator_14888 {

	static int N;
	static int Max = Integer.MAX_VALUE;
	static int Min = Integer.MAX_VALUE;
	static int[] numbers;
	static int[] operator = new int[4];
	
	public static void main(String[] args) throws IOException {
		input();
	}
	
	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		// N
		N = Integer.parseInt(st.nextToken());
		numbers = new int[N];
		//numbers
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0 ; st.hasMoreElements(); i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}
		// operator
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; st.hasMoreElements(); i++) {
			operator[i] = Integer.parseInt(st.nextToken());
		}
		
		dfs(numbers[0], 1);
		
		System.out.println(Max);
		System.out.println(Min);
	}
	
	static void dfs(int num, int idx) {
		if(idx == N) {
			Max = Math.max(Max, num);
			Min = Math.min(Min, num);
			return;
		}
		
		for(int i = 0; i < 4; i++) {
			if(operator[i]>0) {
				operator[i]--;
				
				switch (i) {
				case 0:
					dfs(num + numbers[idx], idx + 1);
					break;
				case 1:
					dfs(num - numbers[idx], idx + 1);
					break;
				case 2:
					dfs(num * numbers[idx], idx + 1);
					break;
				case 3:
					dfs(num / numbers[idx], idx + 1);
					break;

				default:
					break;
				}
				
				operator[i]++;
			}
		}
		
	}
}
