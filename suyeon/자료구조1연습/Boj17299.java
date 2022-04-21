package suyeon.자료구조1연습;

import java.io.*;
import java.util.Stack;

public class Boj17299 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //입력받기
        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        //숫자 등장한 횟수 구하기
        int[] cntArr = new int[1000001];
        for (int i = 0; i < n; i++) {
            cntArr[arr[i]]++;
        }
        //오큰수 구하기를 응용한 오등큰수 구하기
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            //숫자를 비교하는 대신 횟수를 비교한다
            while (!stack.isEmpty() && cntArr[arr[stack.peek()]]<cntArr[arr[i]]){
                arr[stack.pop()] = arr[i];//값 저장은 숫자 그대로
            }
            //인덱스 스텍에 저장
            stack.push(i);
        }
        //스텍에 남아있을는 수는 오등큰수가 없는 수
        while (!stack.isEmpty()){
            arr[stack.pop()] = -1;
        }
        //결과 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(arr[i] + " ");
        }
        System.out.println(sb);
        bw.flush();
        bw.close();
    }
}