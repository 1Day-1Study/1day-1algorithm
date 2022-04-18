package suyeon.자료구조1연습;

import java.io.*;
import java.util.Stack;

//백준 단어뒤집기2
public class Boj17413 {

    static Stack<Character> stack = new Stack<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        System.out.println(reverse(input));
    }
    static StringBuilder reverse(String s) {
        char[] chars = (s+ "\n").toCharArray();
        boolean tag = false;

        for (char c : chars) {
            //태그 시작
            if (c == '<') tag = true;
            //태그내부, 공백, 문장 끝
            if (tag || c == ' ' || c == '\n') {
                while (!stack.isEmpty()) sb.append(stack.pop());
                if (c != '\n') sb.append(c);
                System.out.println(sb);
            } else {
                stack.push(c);
            }
            //태그 종료
            if (c == '>') tag = false;
        }
        return sb;
    }
}