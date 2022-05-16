package 백준문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Boj1406 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        // 왼쪽 스택, 오른쪽 스택
        Stack<Character> leftStack = new Stack<>();
        Stack<Character> rightStack = new Stack<>();

        String str = br.readLine();

        // 커서는 맨뒤에서 시작하니 왼쪽 스택에 모두 넣어주기
        for (int i = 0; i < str.length(); i++) {
            leftStack.push(str.charAt(i));
        }

        int M = Integer.parseInt(br.readLine());

        for (int i = 0; i < M; i++) {

            st = new StringTokenizer(br.readLine());
            String commandType = st.nextToken();

            if (commandType.equals("P")) {
                char c = st.nextToken().charAt(0);
                leftStack.push(c);
            }

            else if (commandType.equals("L")) {
                if (!leftStack.isEmpty()) {
                    rightStack.push(leftStack.pop());
                }
            }

            else if (commandType.equals("D")) {
                if (!rightStack.isEmpty()) {
                    leftStack.push(rightStack.pop());
                }

            }

            else if (commandType.equals("B")) {
                if (!leftStack.isEmpty()) {
                    leftStack.pop();
                }
            }

        }

        int leftSize = leftStack.size();
        for (int i = 0; i < leftSize; i++) {
            rightStack.push(leftStack.pop());
        }

        int rightSize = rightStack.size();
        for (int i = 0; i < rightSize; i++) {
            sb.append(rightStack.pop());
        }

        System.out.println(sb.toString());

    }
}
