package suyeon.자료구조1;

import java.io.*;
import java.util.Stack;
//백준 9012 괄호
public class Boj9012 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        //입력 받을 테스트 케이스의 수
        int testCaseCount = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCaseCount; i++) {
            sb.append(solution(br.readLine())).append("\n");
        }
        System.out.println(sb);
    }

    static String solution(String inputPS){

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < inputPS.length(); i++) {

            //입력받은 문자열을 char 형으로 쪼개준다.
            char pv = inputPS.charAt(i);

            //여는 괄호 ( 를 스택에 담는다.
            if(pv == '(') stack.push(pv);
            //닫는 괄호 ) 를 담으려고 했으나 비어있으면 NO
            else if(stack.empty()) return "NO";
            else stack.pop();

        }

        if(stack.empty()) return "YES";
        else return "NO";

     }

}
