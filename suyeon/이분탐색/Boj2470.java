package suyeon.이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//이분탐색 두 용액 골드5..
public class Boj2470 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] result = new int[2];

        int start = 0;
        int end = n - 1;
        int min = Integer.MAX_VALUE;

        Arrays.sort(arr);

        while(start < end){
            int sum = arr[start] + arr[end];

            if(min > Math.abs(sum)){
                min = Math.abs(sum);

                result[0] = arr[start];
                result[1] = arr[end];

                if(sum == 0) break;
            }

            if(sum < 0) start++;
            else end--;
        }
        System.out.println(result[0] + " " + result[1]);
    }
}
