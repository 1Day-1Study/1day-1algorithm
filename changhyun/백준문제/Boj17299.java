package 백준문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.StringTokenizer;

public class Boj17299 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        // 빈도 수를 저장하기 위한 Map
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();

        int N = Integer.parseInt(br.readLine());
        int[] numbers = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int number = Integer.parseInt(st.nextToken());
            numbers[i] = number;
            // 해당 키가 있으면 +1
            map.put(number, map.getOrDefault(number, 0) + 1);
        }

        for (int i = 0; i < N; i++) {

            // 스택이 비어있으면 푸쉬 (비교대상 X)
            if (stack.isEmpty()) {
                stack.push(i);
            }

            else {
                // 스택에 있는 값들 중, 현재 원소의 빈도수 보다 작은 값들을 모두 현재 원소 값으로 바꿔주기
                while (!stack.isEmpty() && map.get(numbers[stack.peek()]) < map.get(numbers[i])) {
                    numbers[stack.pop()] = numbers[i];
                }
                stack.push(i);
            }
        }

        // 스택에 값이 남아있다면 오등큰수가 등장하지 않은 것!
        // -> 그러므로 모두 -1로 바꿔준다
        if (!stack.isEmpty()) {
            int size = stack.size();
            for (int i = 0; i < size; i++) {
                numbers[stack.pop()] = -1;
            }
        }

        for (int i = 0; i < numbers.length; i++) {
            sb.append(numbers[i]).append(" ");
        }

        System.out.println(sb.toString());

    }
}
