package suyeon;

import java.io.*;
import java.util.Stack;
//백준 - 단어뒤집기
public class Boj9093 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //입력 받을 테스트케이스의 갯수
        int testCaseCount = Integer.parseInt(br.readLine());

        Stack<Character> s = new Stack<>();

        for (int i = 0; i < testCaseCount; i++) {
            //입력받은 문장
            String inputString = br.readLine();
            //입력받은 문장을  char 배열로 변경해준다.
            char[] chars = inputString.toCharArray();

                //공백이전까지 끊어가면서 단어를 넣어주고 꺼내고를 반복한다.
                for (char c : chars) {
                    if(c == ' ' || c == '\n'){
                        while(!s.isEmpty()&&s.size()!=0){
                            bw.write(s.pop());
                        }
                        bw.write(" ");
                    }else{
                        s.push(c);
                    }
                }
            //문장의 마지막 단어 출력
            while (!s.empty()) {
                bw.write(s.pop());
            }
            bw.write("\n");

        }
        bw.flush();
        bw.close();
    }
}
