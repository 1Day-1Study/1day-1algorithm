import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Mana_Allow_6236 {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] money = new int[N];
		st = new StringTokenizer(br.readLine(), "\n");
		for(int i=0; i<N; i++) {
			money[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(money);
		
	}

}
