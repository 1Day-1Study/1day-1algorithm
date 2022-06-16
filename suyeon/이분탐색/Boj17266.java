package suyeon.이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//어두운 굴다리
public class Boj17266 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));

        StringTokenizer st = null;
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        st = new StringTokenizer((br.readLine()));

        int[] lamp = new int[m];

        for (int i = 0; i < m; i++) {
            lamp[i] = Integer.parseInt(st.nextToken());
        }
        binary_search(lamp, n);
    }

    private static void binary_search(int[] lamp, int n){
        int left = 0;
        int right = n;
        int mid = 0;

        while(left < right){
            mid = (left + right) / 2;

            //모든 가로등 빛이 굴다리를 덮는 경우,
            if(isPossible(lamp, mid, n)) {
                right = mid;
            //아닌경우 늘려주기 (줄일 수는 없다. 그럼 못지나가니까)
            }else{
                left = mid + 1;
            }
        }
        System.out.println(left);
    }

    private static boolean isPossible(int[] lamp, int height, int n){
        //가로등이 비추는 마지막 지점, 0부터 빠짐없이 비춰주어야한다.
        int start = 0;
        for (int i = 0; i < lamp.length; i++) {
            //가로등을 놓는 지점에서 비출 수 있는 높이(height)를 배면, 가로등이 비추는 최소범위(값)을 구할 수 있다.
            int left = lamp[i] - height;
            int right = lamp[i] + height;

            if(start < left) return false;
            else start = right;
        }
        //마지막 가로등이 비출 수 있는 마지막 지점이 굴다리의 마지막 지점보다 작으면 다 비추지 못하는 것이므로 false
        if(n - start > 0) return false;

        return true;
    }

}
