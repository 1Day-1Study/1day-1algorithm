package suyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;
//백준 1406 에디터
public class Boj1406 {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Stack<String> leftStack = new Stack();
        Stack<String> rightStack = new Stack();

        //입력 받을 테스트 케이스의 수
        int testCaseCount = Integer.parseInt(br.readLine());
        //입력 받을 테스트 케이스
        String testCaseStr = br.readLine();

        //명령어가 수행되기 전에 커서는 문장의 맨 오른쪽 끝에 위치
        for (int i = 0; i < testCaseStr.length(); i++) {
            //leftStack.push(testCaseStr.charAt(i));
            leftStack.push(testCaseStr.substring(i, i+1));
        }
        for (int i = 0; i < testCaseCount; i++){
            //String command = br.readLine();
            StringTokenizer strToken= new StringTokenizer(br.readLine());
            String command = strToken.nextToken();

            if(command.equals("L")){
                if(!leftStack.empty())
                    rightStack.push(leftStack.pop());

            }else if(command.equals("D")){
                if(!rightStack.empty())
                    leftStack.push(rightStack.pop());

            }else if(command.equals("B")){
                if(!leftStack.empty())
                    leftStack.pop();

            }else if(command.equals("P")){
                //char addChar = command.charAt(2);
                String addChar = strToken.nextToken();
                leftStack.push(addChar);
            }
        }

        while(!leftStack.isEmpty()) rightStack.push(leftStack.pop());

        while(!rightStack.isEmpty()) System.out.println(rightStack.pop());//sb.append(rightStack.pop());

    }
}
