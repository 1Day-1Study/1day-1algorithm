package suyeon.투포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

//백준 - 수열
public class Boj2559 {
    public static int N, K, max;
    public static int [] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(br.readLine());//온도를 측정한 전체 날짜 개수
        K = Integer.parseInt(br.readLine());//연속적인 날짜의 수

        arr = new int[N]; //온도를 담을 배열

        max = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        cal();

    }
    static void cal(){
        //가장 큰 수열(온도) 의 합 구하기
        int sum = 0;
        int start = 1;
        int end = K;

        for (int i = 0; i < K; i++) {
            sum += arr[i]; //0번째부터 K개씩 온도 구간을 더하기
        }

        max = Math.max(max, sum);

        while(end + 1 <= N){
            sum = sum - arr[start ++ ] + arr[++end];
            max = Math.max(max, sum);
        }

        System.out.println(max);
    }
}
