package suyeon.이분탐색;

import java.util.Scanner;
//이상한 술집
public class Boj13702 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] arr = new int[N];
        int max = 0;

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
            max = Math.max(max, arr[i]);
        }

        long low = 1, high = max;

        while (low <= high) {
            long mid = (low + high) / 2; //나눌 막걸리 양
            int cnt = 0;

            for(int i = 0; i < N; i++) {
                //막걸리를 중간값으로 나눴을 때, 몇 명까지 나누어줄 수 있는지 계산
                //혹여나 어떤 주전자의 값이 너무 적어서, 나눠지지 않는다면, cnt가 세어지지 않는다!!
                cnt += arr[i] / mid;
            }
            //cnt가 K 이상이면,더 나눌 수 있는 막걸리가 있다! -> low를 늘린다.
            if (cnt >= K) {
                low = mid + 1;
            }
            // 막걸리가 부족하다! -> high를 낮춘다.
            else {
                high = mid - 1;
            }
        }
        //low가 high를 넘어갈 때의 high가 K명이 나눠 마실 수 있는 최대 막걸리 용량
        System.out.println(high);
    }
}