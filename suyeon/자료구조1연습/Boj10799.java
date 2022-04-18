package suyeon.자료구조1연습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

//백준 쇠막대기
public class Boj10799 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int count = 0;
        int piece = 0;

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);

            if(c == '(') stack.push(c);
            else {
                stack.pop();
                if (input.charAt(i - 1) == '(') count += stack.size();
                else count++;
            }
        }
        System.out.println(count);
    }

    // () 제일 처음의 레이저 절단 막대의 시작과 끝이 없으므로 조각 0
    // ( ) '( ( (' ( ) 레이저 절단, 3단으로 쌓아 올렸기 때문에 스택에 남아 있는 '(((' 3조각이 생긴다
    // ( ) '( ( ('  ( ) ( ) 또다시 레이저 절단, 스택엔 3조각이 남아 있기에  3조각이 더 생긴다
    // ( ) '( ( (' ( ) ( ) ')' 3층 첫 번째 꼭대기 막대기 끝나는 지점, 1조각이 생긴다
    // ( ) ( (   ( ( ) ( ) ) '( ( )'  다시 1개의 층을 쌓고 레이저로 절단, 3조각이 생긴다
    // ( ) ( (   ( ( ) ( ) ) ( ( ) ')'  3층의 두 번째 꼭대기 막대기 끝나는 지점, 1조각이 생긴다
    // ( ) ( (   ( ( ) ( ) ) ( ( ) ) '( )' 2층의 막대기를 레이저로 절단, 2조각이 생긴다
    // ( ) ( (   ( ( ) ( ) ) ( ( ) ) ( ) ') )' 2층과 1층의 막대기가 끝나는 지점이다. 1조각씩  총 2조각이 생긴다
    // ( ) ( (   ( ( ) ( ) ) ( ( ) ) ( ) ) ) '( ( ) )' 마지막 막대기를 레이저로 잘라 2조각이 더 생긴다.
    // count = 17
}
