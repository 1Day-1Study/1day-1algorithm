package suyeon.투포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj2559_2 {

    static int n, k; //전체 날짜 수 n, 합을 구할 연속 날짜의 수 k
    static int[] temperatures; //각 날짜별 온도
    static int maxSum; //출력할 전체 합

    static void  cal(){
        //최소 k개의 합
        int temp = 0;
        for (int i = 0; i < k; i++) {
            temp += temperatures[i];
        }

        maxSum = temp;

        int point1 = 0; //합에서 마이너스할 숫자의 위치
        int point2 = k; //합에서 플러스할 숫자의 위치

        while(point2 <= n-1){
          temp -= temperatures[point1++];
          temp += temperatures[point2++];

          maxSum = Math.max(maxSum, temp);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)
        );
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        temperatures = new int[n];
        for (int i = 0; i < n; i++)
            temperatures[i] = Integer.parseInt(st.nextToken());

        cal();
        System.out.println(maxSum);
    }
}
