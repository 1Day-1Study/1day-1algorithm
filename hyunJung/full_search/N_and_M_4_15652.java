import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N_and_M_4_15652 {

	static int N, M;
	static int[] selected;

	static StringBuilder answer = new StringBuilder();

	static int cnt = 0;

	public static void main(String[] args) throws IOException {

		// N, M, selected[] 초기화
		input();

		// 재귀호출
		selectNumber(1, 0);
		System.out.println("- - - - - - - - - - - - - -");
		System.out.println(answer);

	}

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		// M개의 배열 생성 -> 숫자 바구니
		selected = new int[M];
	}

	static void selectNumber(int K, int depth) {
		System.out.println("selectNumber 호출 ---> "+K+", "+depth);

		if(depth == M) { // M개 선택 완료
			for(int val : selected) {
				answer.append(val).append(' ');
			}
			answer.append("\n");
			System.out.println(cnt++ +" 회차 선택완료 ---> \n"+answer);
			return;
		}

		for(int i = K; i <= N; i++) {
			selected[depth] = i;
			selectNumber(i, depth+1);
		}
	}

}
