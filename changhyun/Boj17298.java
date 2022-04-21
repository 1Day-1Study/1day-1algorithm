import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Boj17298 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] seq = new int[N];
        Stack<Integer> stack = new Stack<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {

            // 스택이 비어 있으면 그냥 푸쉬
            if (stack.isEmpty()) {
                stack.push(i);
                continue;
            }

            // 현재 값이 스택의 최상위 값보다 작거나 같다면 그냥 푸쉬
            if (seq[i] <= seq[stack.peek()]) {
                stack.push(i);
            }

            // 현재 값이 스택의 최상위 값보다 크다면 (오큰수의 등장)
            else {

                //  스택에 있는 값들 중, 현재 원소 값보다 작은 값들을 모두 현재 원소 값으로 바꿔주기
                while (!stack.isEmpty() && seq[i] > seq[stack.peek()]) {
                    seq[stack.pop()] = seq[i];
                }

                // 그리고 현재 값 푸쉬
                stack.push(i);
            }
        }

        // 스택에 값이 남아있다면 오큰수가 등장하지 않은 것!
        // -> 그러므로 모두 -1로 바꿔준다
        if (!stack.isEmpty()) {
            int size = stack.size();
            for (int i = 0; i < size; i++) {
                seq[stack.pop()] = -1;
            }
        }


        for (int i = 0; i < seq.length; i++) {
            sb.append(seq[i]).append(" ");
        }

        System.out.println(sb.toString());

    }
}
