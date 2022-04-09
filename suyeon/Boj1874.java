package suyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class Boj1874 {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        //입력 받을 테스트 케이스의 수
        int testCaseCount = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCaseCount; i++) {
            sb.append(solution(Integer.parseInt(br.readLine()))).append("\n");
            System.out.println(solution(Integer.parseInt(br.readLine())));
        }
        //System.out.println(sb);
    }

    static String solution(int num){

        Stack<Integer> stack = new Stack<>();
        ArrayList result = new ArrayList();

        int start = 1; //수열에 0은 쓰지 않으므로
        int numArr[] = new int[num + 1];

        for (int i = 1; i <= num; i++) {
            numArr[i] = num;
        }

        Arrays.sort(numArr);

        for (int i = 0; i < numArr.length; i++) {
            stack.push(i);
            result.add("+");

            while(!stack.empty() && stack.peek()==numArr[start]){
                stack.pop();
                result.add("-");
                start++;
            }
        }
        if(stack.empty()){
            for (int i = 0; i < result.size(); i++) {
                result.toString();
            }
        }else return "NO";

        return null;
    }


}
