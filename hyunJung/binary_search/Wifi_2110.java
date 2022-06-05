import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Wifi_2100 {
	static int N, C, answer;
	
	static int[] house;
	
	public static void main(String[] args) throws IOException {
		input();
		binarySerarch();
	}
	
	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		house = new int[N];
		for(int i=0; i<N; i++) {
			house[i] = Integer.parseInt(br.readLine());
		}
		br.close();
		Arrays.sort(house);
	}
	static void binarySerarch() {
		int left = 0, right = 1000000000;
		
		while(left<=right) {
			int mid = (left+right)/2;
			
			// 공유기가 필요보다 더 많이 설치됨 -> 설치 줄이기
			if(isPossible(mid) >= C) {
				answer = mid;
				left = mid + 1;
			}else {
				// 공유기가 필요보다 덜 설치됨 -> 설치 늘리기
				answer = mid;
				right = mid - 1;
			}
			
		}
		System.out.println(answer);
		
	}
	static int isPossible(int mid) {
		int cnt = 1;
		int lasthouse = house[0];
		
		for(int i=0; i<N; i++) {
			int currentHouse = house[i];
			
			if(currentHouse - lasthouse > mid) {
				cnt++;
				lasthouse = currentHouse;
			}
		}
		
		return cnt;
	}
}
