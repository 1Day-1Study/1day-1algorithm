package suyeon.투포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//수 고르기
public class Boj2230 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); //수열의 개수
        int M = Integer.parseInt(st.nextToken()); //만족해야하는 두 수 의 차

        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        br.close();

        Arrays.sort(arr);

        int low=0, high = 0, result = Integer.MAX_VALUE;

        while(high < N) {
            if(arr[high] - arr[low] < M) {
                high++;
                continue;
            }

            if(arr[high] - arr[low] == M){
                result = M;
                break;
            }

            result = Math.min(result, (arr[high] - arr[low]));
            low++;
        }

        System.out.println(result);

    }
}
