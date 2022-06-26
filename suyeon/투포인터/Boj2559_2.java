package suyeon.투포인터;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj2559_2 {
        static int n;
        static int k;
        static int[] arr;

        public static void main(String[] args) throws IOException{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            arr = new int[n];

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            System.out.println(slidingWindow());
        }

        public static int slidingWindow() {
            int max = 0;
            int sum = 0;

            for(int i = 0; i < n; i++) {
                sum += arr[i];

                // 최초에 나온 합을 최댓값으로 잡아놓음
                if(i == k - 1) {
                    max = sum;
                }

                // 처음 길이를 벗어났을 때 부터 한칸씩 밀어주면서 최댓값 비교
                if(i >= k) {
                    sum -= arr[i - k];
                    max = Math.max(max, sum);
                }
            }
            return max;
        }
    }