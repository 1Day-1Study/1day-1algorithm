package suyeon.투포인터;


import java.io.*;
import java.util.StringTokenizer;
//2559 수열
public class Boj2559 {
        static int n, k;				// 전체 날짜 수 n, 합을 구할 연속 날짜 수 k
        static int[] temperatures;		// 각 날짜 별 온도
        static int maxSum;				// 출력

        static void solution() {
            // 최초 k 개 합
            int temp = 0;
            for (int i = 0; i < k; i++)
                temp += temperatures[i];

            maxSum = temp;

            int ptr1 = 0;			// 합에서 뺄 위치
            int ptr2 = k;			// 합에서 더할 위치

            while (ptr2 <= n - 1) {
                temp -= temperatures[ptr1++];
                temp += temperatures[ptr2++];
                maxSum = Math.max(maxSum, temp);
            }
        }

        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(System.in)
            );
            StringTokenizer st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            temperatures = new int[n];
            for (int i = 0; i < n; i++)
                temperatures[i] = Integer.parseInt(st.nextToken());

            solution();
            System.out.println(maxSum);
        }
    }

