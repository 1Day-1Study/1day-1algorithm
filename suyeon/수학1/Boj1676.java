package suyeon.수학1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//1676 팩토리얼 0의 개수
public class Boj1676 {
    // 뒷자리가 0이 n개 있다는 의미는 2와 5가 n개씩 짝지어 존재한다는 것
    // 5의 개수에 따라 값이 변화한다고 보고, 5의 n제곱에 따라 카운트를 1씩 증가
    // 반복문을 통해 5로 나누면서 누적해서 더하기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int cnt = 0;
        int input = Integer.parseInt(br.readLine());

        while(input >= 5){
            cnt += input / 5;
            input /= 5;
        }

        System.out.println(cnt);

    }
}
