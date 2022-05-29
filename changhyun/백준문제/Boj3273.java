package 백준문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj3273 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n, x;
    static int cnt = 0;
    static int[] a;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        a = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(a);

        x = Integer.parseInt(br.readLine());

        int left = 0;
        int right = n - 1;

        while (left < right) {

            int sum = a[left] + a[right];

            if (sum == x) {
                cnt++;
                left++;
            } else if (sum < x) {
                left++;
            } else {
                right--;
            }
        }

        System.out.println(cnt);


    }
}
