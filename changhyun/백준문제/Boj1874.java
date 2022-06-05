package 백준문제;

import java.io.*;
import java.util.Stack;

public class Boj1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Stack<Integer> stack = new Stack<>();

        int n = Integer.parseInt(br.readLine());

        // 다음에 스택에 푸쉬해야 하는 수
        int nextPushNumber = 1;
        for (int i = 0; i < n; i++) {

            int number = Integer.parseInt(br.readLine());

            // 푸쉬해야할 수보다 입력 값이 크거나 같은 경우
            if (number >= nextPushNumber) {

                for (int j = nextPushNumber; j <= number; j++) {
                    stack.push(j);
                    sb.append("+");
                    sb.append("\n");
                }

                nextPushNumber = number + 1;

                stack.pop();
                sb.append("-");
                sb.append("\n");
            }

            // 푸쉬해야할 수보다 작은 경우
            else {
                if (stack.peek().equals(number)) {
                    stack.pop();
                    sb.append("-");
                    sb.append("\n");
                } else {
                    System.out.println("NO");
                    return;
                }

            }

        }

        System.out.println(sb.toString());

    }
}
