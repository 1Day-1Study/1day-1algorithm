package 백준문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj2110 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] houses;
    static int N, C;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        houses = new int[N];
        for (int i = 0; i < N; i++) {
            houses[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(houses);

        int low = 1; // 가질 수 있는 최소 거리
        int high = houses[N - 1] - houses[0];
        int mid = 0;

        while (low <= high) {
            mid = (high + low) / 2;

            //설치할 수 있는 수가 설치해야할 수보다 작을 때 -> 공유기 설치 거리를 줄여야 한다!
            if (canInstall(mid) < C) {
                high = mid - 1;
            }

            // 설치할 수 있는 수가 설치해야할 수보다 크거나 같을 때 -> 공유기 설치 거리를 늘려야 한다!
            else {
                low = mid + 1;
            }
        }

        System.out.println(mid);

    }

    static int canInstall(int distance) {

        // 첫 번째 집은 무조건 설치
        int cnt = 1;
        int lastHouse = houses[0];

        for (int i = 1; i < N; i++) {
            int currentHouse = houses[i];

            if (currentHouse - lastHouse >= distance) {
                cnt++;
                lastHouse = currentHouse;
            }
        }
        return cnt;
    }
}
