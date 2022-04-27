package suyeon.수학1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//소수구하기
public class Boj1929 {

    static boolean[] prime; //소수 판별, false :  소수, true : 소수가 아닌 정수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine()," ");

        int M = Integer.parseInt(token.nextToken());
        int N = Integer.parseInt(token.nextToken());

        prime = new boolean[N + 1];
        getPrime();

        StringBuilder sb = new StringBuilder();

        for (int i = M; i <= N; i++) {
            if(!prime[i]) sb.append(i).append("\n");
        }
        System.out.println(sb);
    }
    public static void getPrime(){
        //0과 1은 제외한다.
        prime[0] = true;
        prime[1] = true;

        for (int i = 2; i <= Math.sqrt(prime.length); i++) {
            //소수가 아니라면 지나간다.
            if(prime[i]) continue;
            //작은 정수의 배수부터 확인한다.
            for (int j = i * i; j < prime.length ; j += i) {
                prime[j] = true;
            }
        }
    }
}
