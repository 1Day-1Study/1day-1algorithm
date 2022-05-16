package 백준문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Boj10799 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //괄호를 담기위한 스택
        Stack<Character> stack = new Stack<>();
        char[] pipe = br.readLine().toCharArray();

        int cnt = 0;
        for (int i = 0; i < pipe.length; i++) {

            // 여는 괄호일 경우,
            if (pipe[i] == '(') {
                stack.push('(');
            }

            // 닫는 괄호일 경우,
            else {
                stack.pop();

                // '()' 레이저일 경우,
                if (pipe[i - 1] == '(') {
                    cnt += stack.size();
                }

                // 레이저가 아니면 단순 1 추가
                else {
                    cnt++;
                }

            }
        }

        System.out.println(cnt);
    }
}
