package suyeon.자료구조1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//백준 9012 괄호
public class Boj9012_v2 {

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
        //괄호의 갯수를 세어서 VPS를 확인하는 방식
        int count = 0;

        for(char c : inputPS.toCharArray()){

            //c에 (가 있으면 +1을 해준다.
            if(c == '(') count++;
            // )의 갯수를 셀 차례인데, 더 이상 셀 )가 없으면 NO를 반환한다.
            else if(count == 0) return "NO";
            else count--;//)가 있으면 -1을 해준다.
        }

        //위 작업이 끝나고 () PSV가 올바르면 count는 0이 되므로 YES를 반환한다.
        if(count == 0) return "YES";
        else return "NO";

     }

}
