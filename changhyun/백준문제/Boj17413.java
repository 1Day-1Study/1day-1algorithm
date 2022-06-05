package 백준문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Boj17413 {

    static Stack<Character> stack = new Stack<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String S = br.readLine();

        // < > 태그 안인지 확인하는 변수
        boolean isInTage = false;

        for (int i = 0; i < S.length(); i++) {

            // 여는 태그가 오면
            if (S.charAt(i) == '<') {

                //태그 시작
                isInTage = true;

                //이전 값들을 모두 스택에서 꺼내기(거꾸로 출력)
                reversePrint();

                sb.append("<");
            }

            //닫는 태그가 오면
            else if (S.charAt(i) == '>') {
                isInTage = false;
                sb.append(">");
            }

            // 태그가 아닌 문자나 공백이 오면
            else {

                // 태그 안이면
                if (isInTage) {
                    sb.append(S.charAt(i));
                }

                // 태그 밖이라면
                else {

                    // 공백이라면 이전 값들을 모두 스택에서 꺼내기(거꾸로 출력)
                    if (S.charAt(i) == ' ') {
                        reversePrint();
                        sb.append(" ");
                    }

                    // 공백이 아닌 문자면 그냥 스택에 넣어주기
                    else {
                        stack.push(S.charAt(i));
                    }
                }
            }
        }

        // 스택에 저장되있던 값들을 출력
        reversePrint();

        System.out.println(sb.toString());

    }

    static void reversePrint() {
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
    }
}
