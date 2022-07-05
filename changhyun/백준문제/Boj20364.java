package 백준문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj20364 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static boolean[] binaryTree;
    static int N, Q;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        binaryTree = new boolean[N + 1];

        for (int i = 0; i < Q; i++) {
            int land = Integer.parseInt(br.readLine());
            int current = land;
            int occupiedLand = 0;

            while (current != 1) {
                if (binaryTree[current]) {
                    occupiedLand = current;
                }
                current /= 2;
            }

            if (occupiedLand == 0) {
                binaryTree[land] = true;
            }


            sb.append(occupiedLand).append("\n");
        }

        System.out.println(sb.toString());
    }
}
